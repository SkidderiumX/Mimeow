/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.annotation.Immutable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class CloneUtils {
    public static <T> T cloneObject(T t) throws CloneNotSupportedException {
        if (t == null) {
            return null;
        }
        if (t instanceof Cloneable) {
            Method method;
            Class<?> clazz = t.getClass();
            try {
                method = clazz.getMethod("clone", null);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new NoSuchMethodError(noSuchMethodException.getMessage());
            }
            try {
                Object object = method.invoke(t, null);
                return (T)object;
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getCause();
                if (throwable instanceof CloneNotSupportedException) {
                    throw (CloneNotSupportedException)throwable;
                }
                throw new Error("Unexpected exception", throwable);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new IllegalAccessError(illegalAccessException.getMessage());
            }
        }
        throw new CloneNotSupportedException();
    }

    public static Object clone(Object object) throws CloneNotSupportedException {
        return CloneUtils.cloneObject(object);
    }

    private CloneUtils() {
    }
}

