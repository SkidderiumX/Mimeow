/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import org.apache.http.conn.scheme.SchemeSocketFactoryAdaptor;
import org.apache.http.params.HttpParams;

@Deprecated
public class SchemeLayeredSocketFactoryAdaptor
extends SchemeSocketFactoryAdaptor
implements SchemeLayeredSocketFactory {
    private final LayeredSocketFactory factory;

    SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory layeredSocketFactory) {
        super(layeredSocketFactory);
        this.factory = layeredSocketFactory;
    }

    public Socket createLayeredSocket(Socket socket, String string, int n, HttpParams httpParams) throws IOException, UnknownHostException {
        return this.factory.createSocket(socket, string, n, true);
    }
}

