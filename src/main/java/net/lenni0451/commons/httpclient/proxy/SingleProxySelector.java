/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.proxy;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.net.Authenticator;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import net.lenni0451.commons.httpclient.proxy.SingleProxyAuthenticator;

public class SingleProxySelector
extends ProxySelector {
    private static final MethodHandle GET_AUTHENTICATOR;
    private final Proxy proxy;
    private final String username;
    private final String password;
    private final ProxySelector defaultProxySelector;
    private final Authenticator defaultAuthenticator;

    public SingleProxySelector(Proxy proxy, String string, String string2) {
        this.proxy = proxy;
        this.username = string;
        this.password = string2;
        this.defaultProxySelector = ProxySelector.getDefault();
        this.defaultAuthenticator = GET_AUTHENTICATOR.invokeExact();
    }

    public SingleProxySelector set(boolean bl) {
        if (bl) {
            ProxySelector.setDefault(this);
        }
        if (this.username != null && this.password != null) {
            Authenticator.setDefault(new SingleProxyAuthenticator(this.username, this.password));
        }
        return this;
    }

    public SingleProxySelector reset(boolean bl) {
        if (bl) {
            ProxySelector.setDefault(this.defaultProxySelector);
        }
        if (this.username != null && this.password != null) {
            Authenticator.setDefault(this.defaultAuthenticator);
        }
        return this;
    }

    @Override
    public List<Proxy> select(URI uRI) {
        return Collections.singletonList(this.proxy);
    }

    @Override
    public void connectFailed(URI uRI, SocketAddress socketAddress, IOException iOException) {
    }

    static {
        MethodHandle methodHandle;
        try {
            methodHandle = MethodHandles.lookup().findStatic(Authenticator.class, "getDefault", MethodType.methodType(Authenticator.class));
        }
        catch (Throwable throwable) {
            try {
                Field field = Authenticator.class.getDeclaredField("theAuthenticator");
                field.setAccessible(true);
                methodHandle = MethodHandles.lookup().unreflectGetter(field);
            }
            catch (Throwable throwable2) {
                methodHandle = MethodHandles.constant(Authenticator.class, null);
            }
        }
        GET_AUTHENTICATOR = methodHandle;
    }
}

