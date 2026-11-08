/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.OutputStreamManager;

public abstract class AbstractSocketManager
extends OutputStreamManager {
    protected final InetAddress address;
    protected final String host;
    protected final int port;

    public AbstractSocketManager(String string, OutputStream outputStream2, InetAddress inetAddress, String string2, int n, Layout<? extends Serializable> layout) {
        super(outputStream2, string, layout);
        this.address = inetAddress;
        this.host = string2;
        this.port = n;
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>(super.getContentFormat());
        hashMap.put("port", Integer.toString(this.port));
        hashMap.put("address", this.address.getHostAddress());
        return hashMap;
    }
}

