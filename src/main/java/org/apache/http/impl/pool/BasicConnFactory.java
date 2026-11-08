/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.DefaultBHttpClientConnectionFactory;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.ConnFactory;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class BasicConnFactory
implements ConnFactory<HttpHost, HttpClientConnection> {
    private final SocketFactory plainfactory;
    private final SSLSocketFactory sslfactory;
    private final int connectTimeout;
    private final SocketConfig sconfig;
    private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;

    @Deprecated
    public BasicConnFactory(SSLSocketFactory sSLSocketFactory, HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = httpParams.getIntParameter("http.connection.timeout", 0);
        this.sconfig = HttpParamConfig.getSocketConfig(httpParams);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(httpParams));
    }

    @Deprecated
    public BasicConnFactory(HttpParams httpParams) {
        this(null, httpParams);
    }

    public BasicConnFactory(SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, int n, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this.plainfactory = socketFactory;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = n;
        this.sconfig = socketConfig != null ? socketConfig : SocketConfig.DEFAULT;
        this.connFactory = new DefaultBHttpClientConnectionFactory(connectionConfig != null ? connectionConfig : ConnectionConfig.DEFAULT);
    }

    public BasicConnFactory(int n, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, n, socketConfig, connectionConfig);
    }

    public BasicConnFactory(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, 0, socketConfig, connectionConfig);
    }

    public BasicConnFactory() {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }

    @Deprecated
    protected HttpClientConnection create(Socket socket, HttpParams httpParams) throws IOException {
        int n = httpParams.getIntParameter("http.socket.buffer-size", 8192);
        DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(n);
        defaultBHttpClientConnection.bind(socket);
        return defaultBHttpClientConnection;
    }

    @Override
    public HttpClientConnection create(HttpHost httpHost) throws IOException {
        String string = httpHost.getSchemeName();
        Socket socket = null;
        if ("http".equalsIgnoreCase(string)) {
            Socket socket2 = socket = this.plainfactory != null ? this.plainfactory.createSocket() : new Socket();
        }
        if ("https".equalsIgnoreCase(string)) {
            socket = (this.sslfactory != null ? this.sslfactory : SSLSocketFactory.getDefault()).createSocket();
        }
        if (socket == null) {
            throw new IOException(string + " scheme is not supported");
        }
        String string2 = httpHost.getHostName();
        int n = httpHost.getPort();
        if (n == -1) {
            if (httpHost.getSchemeName().equalsIgnoreCase("http")) {
                n = 80;
            } else if (httpHost.getSchemeName().equalsIgnoreCase("https")) {
                n = 443;
            }
        }
        socket.setSoTimeout(this.sconfig.getSoTimeout());
        socket.connect(new InetSocketAddress(string2, n), this.connectTimeout);
        socket.setTcpNoDelay(this.sconfig.isTcpNoDelay());
        int n2 = this.sconfig.getSoLinger();
        if (n2 >= 0) {
            socket.setSoLinger(n2 > 0, n2);
        }
        socket.setKeepAlive(this.sconfig.isSoKeepAlive());
        return this.connFactory.createConnection(socket);
    }
}

