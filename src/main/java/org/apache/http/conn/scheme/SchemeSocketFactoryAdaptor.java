/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.SchemeSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

@Deprecated
public class SchemeSocketFactoryAdaptor
implements SchemeSocketFactory {
    private final SocketFactory factory;

    SchemeSocketFactoryAdaptor(SocketFactory socketFactory) {
        this.factory = socketFactory;
    }

    public Socket connectSocket(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpParams httpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
        String string = inetSocketAddress.getHostName();
        int n = inetSocketAddress.getPort();
        InetAddress inetAddress = null;
        int n2 = 0;
        if (inetSocketAddress2 != null) {
            inetAddress = inetSocketAddress2.getAddress();
            n2 = inetSocketAddress2.getPort();
        }
        return this.factory.connectSocket(socket, string, n, inetAddress, n2, httpParams);
    }

    public Socket createSocket(HttpParams httpParams) throws IOException {
        return this.factory.createSocket();
    }

    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return this.factory.isSecure(socket);
    }

    public SocketFactory getFactory() {
        return this.factory;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof SchemeSocketFactoryAdaptor) {
            return this.factory.equals(((SchemeSocketFactoryAdaptor)object).factory);
        }
        return this.factory.equals(object);
    }

    public int hashCode() {
        return this.factory.hashCode();
    }
}

