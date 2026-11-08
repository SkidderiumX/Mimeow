/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.execchain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.execchain.ConnectionHolder;
import org.apache.http.impl.execchain.RequestEntityExecHandler;
import org.apache.http.impl.execchain.ResponseProxyHandler;

@NotThreadSafe
public class Proxies {
    Proxies() {
    }

    static void enhanceEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        HttpEntity httpEntity = httpEntityEnclosingRequest.getEntity();
        if (httpEntity != null && !httpEntity.isRepeatable() && !Proxies.isEnhanced(httpEntity)) {
            HttpEntity httpEntity2 = (HttpEntity)Proxy.newProxyInstance(HttpEntity.class.getClassLoader(), new Class[]{HttpEntity.class}, (InvocationHandler)new RequestEntityExecHandler(httpEntity));
            httpEntityEnclosingRequest.setEntity(httpEntity2);
        }
    }

    static boolean isEnhanced(HttpEntity httpEntity) {
        if (httpEntity != null && Proxy.isProxyClass(httpEntity.getClass())) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(httpEntity);
            return invocationHandler instanceof RequestEntityExecHandler;
        }
        return false;
    }

    static boolean isRepeatable(HttpRequest httpRequest) {
        HttpEntity httpEntity;
        if (httpRequest instanceof HttpEntityEnclosingRequest && (httpEntity = ((HttpEntityEnclosingRequest)httpRequest).getEntity()) != null) {
            RequestEntityExecHandler requestEntityExecHandler;
            if (Proxies.isEnhanced(httpEntity) && !(requestEntityExecHandler = (RequestEntityExecHandler)Proxy.getInvocationHandler(httpEntity)).isConsumed()) {
                return true;
            }
            return httpEntity.isRepeatable();
        }
        return true;
    }

    public static CloseableHttpResponse enhanceResponse(HttpResponse httpResponse, ConnectionHolder connectionHolder) {
        return (CloseableHttpResponse)Proxy.newProxyInstance(ResponseProxyHandler.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, (InvocationHandler)new ResponseProxyHandler(httpResponse, connectionHolder));
    }
}

