/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.scheme.LayeredSchemeSocketFactory;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactoryAdaptor;

@Deprecated
public class LayeredSocketFactoryAdaptor
extends SocketFactoryAdaptor
implements LayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory layeredSchemeSocketFactory) {
        super(layeredSchemeSocketFactory);
        this.factory = layeredSchemeSocketFactory;
    }

    public Socket createSocket(Socket socket, String string, int n, boolean bl) throws IOException, UnknownHostException {
        return this.factory.createLayeredSocket(socket, string, n, bl);
    }
}

