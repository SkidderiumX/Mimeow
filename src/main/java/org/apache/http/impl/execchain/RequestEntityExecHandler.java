/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.execchain;

import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class RequestEntityExecHandler
implements InvocationHandler {
    private static final Method WRITE_TO_METHOD;
    private final HttpEntity original;
    private boolean consumed = false;

    RequestEntityExecHandler(HttpEntity httpEntity) {
        this.original = httpEntity;
    }

    public HttpEntity getOriginal() {
        return this.original;
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        try {
            if (method.equals(WRITE_TO_METHOD)) {
                this.consumed = true;
            }
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
            WRITE_TO_METHOD = HttpEntity.class.getMethod("writeTo", OutputStream.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new Error(noSuchMethodException);
        }
    }
}

