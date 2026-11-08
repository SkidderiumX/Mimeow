/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

@NotThreadSafe
public class CloseableHttpResponseProxy
implements InvocationHandler {
    private final HttpResponse original;

    CloseableHttpResponseProxy(HttpResponse httpResponse) {
        this.original = httpResponse;
    }

    public void close() throws IOException {
        HttpEntity httpEntity = this.original.getEntity();
        EntityUtils.consume(httpEntity);
    }

    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        String string = method.getName();
        if (string.equals("close")) {
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

    public static CloseableHttpResponse newProxy(HttpResponse httpResponse) {
        return (CloseableHttpResponse)Proxy.newProxyInstance(CloseableHttpResponseProxy.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, (InvocationHandler)new CloseableHttpResponseProxy(httpResponse));
    }
}

