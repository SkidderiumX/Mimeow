/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.proxy;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.lenni0451.commons.httpclient.proxy.ProxyType;
import net.lenni0451.commons.httpclient.proxy.SingleProxyAuthenticator;
import net.lenni0451.commons.httpclient.proxy.SingleProxySelector;

public class ProxyHandler {
    private ProxyType proxyType;
    private SocketAddress address;
    private String username;
    private String password;

    public ProxyHandler() {
    }

    public ProxyHandler(ProxyType proxyType, String string, int n) {
        this(proxyType, string, n, null, null);
    }

    public ProxyHandler(ProxyType proxyType, String string, int n, @Nullable String string2, @Nullable String string3) {
        this(proxyType, new InetSocketAddress(string, n), string2, string3);
    }

    public ProxyHandler(ProxyType proxyType, SocketAddress socketAddress) {
        this(proxyType, socketAddress, null, null);
    }

    public ProxyHandler(ProxyType proxyType, SocketAddress socketAddress, @Nullable String string, @Nullable String string2) {
        this.proxyType = proxyType;
        this.address = socketAddress;
        this.username = string;
        this.password = string2;
    }

    public ProxyHandler setProxy(ProxyType proxyType, String string, int n) {
        return this.setProxy(proxyType, new InetSocketAddress(string, n));
    }

    public ProxyHandler setProxy(ProxyType proxyType, SocketAddress socketAddress) {
        this.proxyType = proxyType;
        this.address = socketAddress;
        return this;
    }

    public ProxyHandler unsetProxy() {
        this.proxyType = null;
        this.address = null;
        return this;
    }

    public boolean isProxySet() {
        return this.proxyType != null && this.address != null;
    }

    @Nullable
    public ProxyType getProxyType() {
        return this.proxyType;
    }

    public ProxyHandler setProxyType(@Nonnull ProxyType proxyType) {
        this.proxyType = proxyType;
        return this;
    }

    @Nullable
    public SocketAddress getAddress() {
        return this.address;
    }

    public ProxyHandler setAddress(@Nonnull SocketAddress socketAddress) {
        this.address = socketAddress;
        return this;
    }

    public boolean isAuthenticationSet() {
        return this.username != null && this.password != null;
    }

    @Nullable
    public String getUsername() {
        return this.username;
    }

    public ProxyHandler setUsername(@Nullable String string) {
        this.username = string;
        return this;
    }

    @Nullable
    public String getPassword() {
        return this.password;
    }

    public ProxyHandler setPassword(@Nullable String string) {
        this.password = string;
        return this;
    }

    public SingleProxySelector getProxySelector() {
        if (!this.isProxySet()) {
            throw new IllegalStateException("Proxy is not set");
        }
        return new SingleProxySelector(this.toJavaProxy(), this.username, this.password);
    }

    public SingleProxyAuthenticator getProxyAuthenticator() {
        if (!this.isProxySet()) {
            throw new IllegalStateException("Proxy is not set");
        }
        if (!this.isAuthenticationSet()) {
            throw new IllegalStateException("Username or password is not set");
        }
        return new SingleProxyAuthenticator(this.username, this.password);
    }

    public Proxy toJavaProxy() {
        switch (this.proxyType) {
            case HTTP: {
                return new Proxy(Proxy.Type.HTTP, this.address);
            }
            case SOCKS4: {
                try {
                    Class<?> clazz = Class.forName("sun.net.SocksProxy");
                    Method method = clazz.getDeclaredMethod("create", SocketAddress.class, Integer.TYPE);
                    return (Proxy)method.invoke(null, this.address, 4);
                }
                catch (Throwable throwable) {
                    throw new UnsupportedOperationException("SOCKS4 proxy type is not supported", throwable);
                }
            }
            case SOCKS5: {
                return new Proxy(Proxy.Type.SOCKS, this.address);
            }
        }
        throw new IllegalStateException("Unknown proxy type: " + this.proxyType.name());
    }
}

