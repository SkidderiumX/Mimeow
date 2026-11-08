/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnection;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.impl.conn.CPoolEntry;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.protocol.HttpContext;

@NotThreadSafe
public class CPoolProxy
implements InvocationHandler {
    private static final Method CLOSE_METHOD;
    private static final Method SHUTDOWN_METHOD;
    private static final Method IS_OPEN_METHOD;
    private static final Method IS_STALE_METHOD;
    private volatile CPoolEntry poolEntry;

    CPoolProxy(CPoolEntry cPoolEntry) {
        this.poolEntry = cPoolEntry;
    }

    CPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    CPoolEntry detach() {
        CPoolEntry cPoolEntry = this.poolEntry;
        this.poolEntry = null;
        return cPoolEntry;
    }

    HttpClientConnection getConnection() {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry == null) {
            return null;
        }
        return (HttpClientConnection)cPoolEntry.getConnection();
    }

    public void close() throws IOException {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            cPoolEntry.closeConnection();
        }
    }

    public void shutdown() throws IOException {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            cPoolEntry.shutdownConnection();
        }
    }

    public boolean isOpen() {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            return !cPoolEntry.isClosed();
        }
        return false;
    }

    public boolean isStale() {
        HttpClientConnection httpClientConnection = this.getConnection();
        if (httpClientConnection != null) {
            return httpClientConnection.isStale();
        }
        return true;
    }

    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        if (method.equals(CLOSE_METHOD)) {
            this.close();
            return null;
        }
        if (method.equals(SHUTDOWN_METHOD)) {
            this.shutdown();
            return null;
        }
        if (method.equals(IS_OPEN_METHOD)) {
            return this.isOpen();
        }
        if (method.equals(IS_STALE_METHOD)) {
            return this.isStale();
        }
        HttpClientConnection httpClientConnection = this.getConnection();
        if (httpClientConnection == null) {
            throw new ConnectionShutdownException();
        }
        try {
            return method.invoke(httpClientConnection, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable != null) {
                throw throwable;
            }
            throw invocationTargetException;
        }
    }

    public static HttpClientConnection newProxy(CPoolEntry cPoolEntry) {
        return (HttpClientConnection)Proxy.newProxyInstance(CPoolProxy.class.getClassLoader(), new Class[]{ManagedHttpClientConnection.class, HttpContext.class}, (InvocationHandler)new CPoolProxy(cPoolEntry));
    }

    private static CPoolProxy getHandler(HttpClientConnection httpClientConnection) {
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(httpClientConnection);
        if (!CPoolProxy.class.isInstance(invocationHandler)) {
            throw new IllegalStateException("Unexpected proxy handler class: " + invocationHandler);
        }
        return (CPoolProxy)CPoolProxy.class.cast(invocationHandler);
    }

    public static CPoolEntry getPoolEntry(HttpClientConnection httpClientConnection) {
        CPoolEntry cPoolEntry = CPoolProxy.getHandler(httpClientConnection).getPoolEntry();
        if (cPoolEntry == null) {
            throw new ConnectionShutdownException();
        }
        return cPoolEntry;
    }

    public static CPoolEntry detach(HttpClientConnection httpClientConnection) {
        return CPoolProxy.getHandler(httpClientConnection).detach();
    }

    static {
        try {
            CLOSE_METHOD = HttpConnection.class.getMethod("close", new Class[0]);
            SHUTDOWN_METHOD = HttpConnection.class.getMethod("shutdown", new Class[0]);
            IS_OPEN_METHOD = HttpConnection.class.getMethod("isOpen", new Class[0]);
            IS_STALE_METHOD = HttpConnection.class.getMethod("isStale", new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new Error(noSuchMethodException);
        }
    }
}

