/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.ssl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLInitializationException;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@ThreadSafe
public class SSLConnectionSocketFactory
implements LayeredConnectionSocketFactory {
    public static final String TLS = "TLS";
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    private final SSLSocketFactory socketfactory;
    private final X509HostnameVerifier hostnameVerifier;
    private final String[] supportedProtocols;
    private final String[] supportedCipherSuites;

    public static SSLConnectionSocketFactory getSocketFactory() throws SSLInitializationException {
        return new SSLConnectionSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    private static String[] split(String string) {
        if (TextUtils.isBlank(string)) {
            return null;
        }
        return string.split(" *, *");
    }

    public static SSLConnectionSocketFactory getSystemSocketFactory() throws SSLInitializationException {
        return new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), SSLConnectionSocketFactory.split(System.getProperty("https.protocols")), SSLConnectionSocketFactory.split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext) {
        this(sSLContext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext, X509HostnameVerifier x509HostnameVerifier) {
        this(Args.notNull(sSLContext, "SSL context").getSocketFactory(), null, null, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext, String[] stringArray, String[] stringArray2, X509HostnameVerifier x509HostnameVerifier) {
        this(Args.notNull(sSLContext, "SSL context").getSocketFactory(), stringArray, stringArray2, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        this(sSLSocketFactory, null, null, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sSLSocketFactory, String[] stringArray, String[] stringArray2, X509HostnameVerifier x509HostnameVerifier) {
        this.socketfactory = Args.notNull(sSLSocketFactory, "SSL socket factory");
        this.supportedProtocols = stringArray;
        this.supportedCipherSuites = stringArray2;
        this.hostnameVerifier = x509HostnameVerifier != null ? x509HostnameVerifier : BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    }

    protected void prepareSocket(SSLSocket sSLSocket) throws IOException {
    }

    public Socket createSocket(HttpContext httpContext) throws IOException {
        return SocketFactory.getDefault().createSocket();
    }

    public Socket connectSocket(int n, Socket socket, HttpHost httpHost, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpContext httpContext) throws IOException {
        Socket socket2;
        Args.notNull(httpHost, "HTTP host");
        Args.notNull(inetSocketAddress, "Remote address");
        Socket socket3 = socket2 = socket != null ? socket : this.createSocket(httpContext);
        if (inetSocketAddress2 != null) {
            socket2.bind(inetSocketAddress2);
        }
        try {
            socket2.connect(inetSocketAddress, n);
        }
        catch (IOException iOException) {
            try {
                socket2.close();
            }
            catch (IOException iOException2) {
                // empty catch block
            }
            throw iOException;
        }
        if (socket2 instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket)socket2;
            sSLSocket.startHandshake();
            this.verifyHostname(sSLSocket, httpHost.getHostName());
            return socket2;
        }
        return this.createLayeredSocket(socket2, httpHost.getHostName(), inetSocketAddress.getPort(), httpContext);
    }

    public Socket createLayeredSocket(Socket socket, String string, int n, HttpContext httpContext) throws IOException {
        SSLSocket sSLSocket = (SSLSocket)this.socketfactory.createSocket(socket, string, n, true);
        if (this.supportedProtocols != null) {
            sSLSocket.setEnabledProtocols(this.supportedProtocols);
        }
        if (this.supportedCipherSuites != null) {
            sSLSocket.setEnabledCipherSuites(this.supportedCipherSuites);
        }
        this.prepareSocket(sSLSocket);
        sSLSocket.startHandshake();
        this.verifyHostname(sSLSocket, string);
        return sSLSocket;
    }

    X509HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    private void verifyHostname(SSLSocket sSLSocket, String string) throws IOException {
        try {
            this.hostnameVerifier.verify(string, sSLSocket);
        }
        catch (IOException iOException) {
            try {
                sSLSocket.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            throw iOException;
        }
    }
}

