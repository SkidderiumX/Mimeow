/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private final Log log = LogFactory.getLog(this.getClass());
    private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;
    private final SchemePortResolver schemePortResolver;
    private final DnsResolver dnsResolver;

    HttpClientConnectionOperator(Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        Args.notNull(lookup, "Socket factory registry");
        this.socketFactoryRegistry = lookup;
        this.schemePortResolver = schemePortResolver != null ? schemePortResolver : DefaultSchemePortResolver.INSTANCE;
        this.dnsResolver = dnsResolver != null ? dnsResolver : SystemDefaultDnsResolver.INSTANCE;
    }

    private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext httpContext) {
        Lookup<ConnectionSocketFactory> lookup = (Lookup<ConnectionSocketFactory>)httpContext.getAttribute(SOCKET_FACTORY_REGISTRY);
        if (lookup == null) {
            lookup = this.socketFactoryRegistry;
        }
        return lookup;
    }

    public void connect(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, InetSocketAddress inetSocketAddress, int n, SocketConfig socketConfig, HttpContext httpContext) throws IOException {
        Lookup<ConnectionSocketFactory> lookup = this.getSocketFactoryRegistry(httpContext);
        ConnectionSocketFactory connectionSocketFactory = lookup.lookup(httpHost.getSchemeName());
        if (connectionSocketFactory == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        }
        InetAddress[] inetAddressArray = this.dnsResolver.resolve(httpHost.getHostName());
        int n2 = this.schemePortResolver.resolve(httpHost);
        for (int i = 0; i < inetAddressArray.length; ++i) {
            InetSocketAddress inetSocketAddress2;
            block10: {
                InetAddress inetAddress = inetAddressArray[i];
                boolean bl = i == inetAddressArray.length - 1;
                Socket socket = connectionSocketFactory.createSocket(httpContext);
                socket.setReuseAddress(socketConfig.isSoReuseAddress());
                managedHttpClientConnection.bind(socket);
                inetSocketAddress2 = new InetSocketAddress(inetAddress, n2);
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Connecting to " + inetSocketAddress2);
                }
                try {
                    socket.setSoTimeout(socketConfig.getSoTimeout());
                    socket = connectionSocketFactory.connectSocket(n, socket, httpHost, inetSocketAddress2, inetSocketAddress, httpContext);
                    socket.setTcpNoDelay(socketConfig.isTcpNoDelay());
                    socket.setKeepAlive(socketConfig.isSoKeepAlive());
                    int n3 = socketConfig.getSoLinger();
                    if (n3 >= 0) {
                        socket.setSoLinger(n3 > 0, n3);
                    }
                    managedHttpClientConnection.bind(socket);
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Connection established " + managedHttpClientConnection);
                    }
                    return;
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    if (bl) {
                        throw new ConnectTimeoutException(socketTimeoutException, httpHost, inetAddressArray);
                    }
                }
                catch (ConnectException connectException) {
                    if (!bl) break block10;
                    String string = connectException.getMessage();
                    if ("Connection timed out".equals(string)) {
                        throw new ConnectTimeoutException(connectException, httpHost, inetAddressArray);
                    }
                    throw new HttpHostConnectException(connectException, httpHost, inetAddressArray);
                }
            }
            if (!this.log.isDebugEnabled()) continue;
            this.log.debug("Connect to " + inetSocketAddress2 + " timed out. " + "Connection will be retried using another IP address");
        }
    }

    public void upgrade(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, HttpContext httpContext) throws IOException {
        HttpClientContext httpClientContext = HttpClientContext.adapt(httpContext);
        Lookup<ConnectionSocketFactory> lookup = this.getSocketFactoryRegistry(httpClientContext);
        ConnectionSocketFactory connectionSocketFactory = lookup.lookup(httpHost.getSchemeName());
        if (connectionSocketFactory == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        }
        if (!(connectionSocketFactory instanceof LayeredConnectionSocketFactory)) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol does not support connection upgrade");
        }
        LayeredConnectionSocketFactory layeredConnectionSocketFactory = (LayeredConnectionSocketFactory)connectionSocketFactory;
        Socket socket = managedHttpClientConnection.getSocket();
        int n = this.schemePortResolver.resolve(httpHost);
        socket = layeredConnectionSocketFactory.createLayeredSocket(socket, httpHost.getHostName(), n, httpContext);
        managedHttpClientConnection.bind(socket);
    }
}

