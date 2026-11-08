/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.proxy;

import java.net.Proxy;

public enum ProxyType {
    HTTP,
    SOCKS4,
    SOCKS5;


    public static ProxyType from(Proxy.Type type) {
        switch (type) {
            case HTTP: {
                return HTTP;
            }
            case SOCKS: {
                return SOCKS5;
            }
        }
        throw new IllegalArgumentException("Unknown proxy type: " + type.name());
    }
}

