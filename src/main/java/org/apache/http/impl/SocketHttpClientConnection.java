/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import org.apache.http.HttpInetConnection;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.AbstractHttpClientConnection;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
@NotThreadSafe
public class SocketHttpClientConnection
extends AbstractHttpClientConnection
implements HttpInetConnection {
    private volatile boolean open;
    private volatile Socket socket = null;

    protected void assertNotOpen() {
        Asserts.check(!this.open, "Connection is already open");
    }

    protected void assertOpen() {
        Asserts.check(this.open, "Connection is not open");
    }

    protected SessionInputBuffer createSessionInputBuffer(Socket socket, int n, HttpParams httpParams) throws IOException {
        return new SocketInputBuffer(socket, n, httpParams);
    }

    protected SessionOutputBuffer createSessionOutputBuffer(Socket socket, int n, HttpParams httpParams) throws IOException {
        return new SocketOutputBuffer(socket, n, httpParams);
    }

    protected void bind(Socket socket, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        Args.notNull(httpParams, "HTTP parameters");
        this.socket = socket;
        int n = httpParams.getIntParameter("http.socket.buffer-size", -1);
        this.init(this.createSessionInputBuffer(socket, n, httpParams), this.createSessionOutputBuffer(socket, n, httpParams), httpParams);
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }

    protected Socket getSocket() {
        return this.socket;
    }

    public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        }
        return null;
    }

    public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        }
        return -1;
    }

    public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        }
        return -1;
    }

    public void setSocketTimeout(int n) {
        this.assertOpen();
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(n);
            }
            catch (SocketException socketException) {
                // empty catch block
            }
        }
    }

    public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            }
            catch (SocketException socketException) {
                return -1;
            }
        }
        return -1;
    }

    public void shutdown() throws IOException {
        this.open = false;
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        if (!this.open) {
            return;
        }
        this.open = false;
        Socket socket = this.socket;
        try {
            this.doFlush();
            try {
                try {
                    socket.shutdownOutput();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                try {
                    socket.shutdownInput();
                }
                catch (IOException iOException) {
                }
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
        }
        finally {
            socket.close();
        }
    }

    private static void formatAddress(StringBuilder stringBuilder, SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
            stringBuilder.append(inetSocketAddress.getAddress() != null ? inetSocketAddress.getAddress().getHostAddress() : inetSocketAddress.getAddress()).append(':').append(inetSocketAddress.getPort());
        } else {
            stringBuilder.append(socketAddress);
        }
    }

    public String toString() {
        if (this.socket != null) {
            StringBuilder stringBuilder = new StringBuilder();
            SocketAddress socketAddress = this.socket.getRemoteSocketAddress();
            SocketAddress socketAddress2 = this.socket.getLocalSocketAddress();
            if (socketAddress != null && socketAddress2 != null) {
                SocketHttpClientConnection.formatAddress(stringBuilder, socketAddress2);
                stringBuilder.append("<->");
                SocketHttpClientConnection.formatAddress(stringBuilder, socketAddress);
            }
            return stringBuilder.toString();
        }
        return super.toString();
    }
}

