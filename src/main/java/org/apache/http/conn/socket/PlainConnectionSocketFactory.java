/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;

@Immutable
public class PlainConnectionSocketFactory
implements ConnectionSocketFactory {
    public static final PlainConnectionSocketFactory INSTANCE = new PlainConnectionSocketFactory();

    public static PlainConnectionSocketFactory getSocketFactory() {
        return INSTANCE;
    }

    public Socket createSocket(HttpContext httpContext) throws IOException {
        return new Socket();
    }

    public Socket connectSocket(int n, Socket socket, HttpHost httpHost, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpContext httpContext) throws IOException {
        Socket socket2;
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
        return socket2;
    }
}

