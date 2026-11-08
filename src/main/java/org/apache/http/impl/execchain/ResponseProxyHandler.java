/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.execchain;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.execchain.ConnectionHolder;
import org.apache.http.impl.execchain.ResponseEntityWrapper;

@NotThreadSafe
public class ResponseProxyHandler
implements InvocationHandler {
    private static final Method CLOSE_METHOD;
    private final HttpResponse original;
    private final ConnectionHolder connHolder;

    ResponseProxyHandler(HttpResponse httpResponse, ConnectionHolder connectionHolder) {
        this.original = httpResponse;
        this.connHolder = connectionHolder;
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity != null && httpEntity.isStreaming() && connectionHolder != null) {
            this.original.setEntity(new ResponseEntityWrapper(httpEntity, connectionHolder));
        }
    }

    public void close() throws IOException {
        if (this.connHolder != null) {
            this.connHolder.abortConnection();
        }
    }

    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        if (method.equals(CLOSE_METHOD)) {
            this.close();
            return null;
        }
        try {
            return method.invoke(this.original, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable != null) {
                throw throwable;
            }
            throw invocationTargetException;
        }
    }

    static {
        try {
            CLOSE_METHOD = Closeable.class.getMethod("close", new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new Error(noSuchMethodException);
        }
    }
}

