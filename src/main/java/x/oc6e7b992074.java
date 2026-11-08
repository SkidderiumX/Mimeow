/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import x.oc66fa4f2195;
import x.oc68d6b191af;
import x.oc8ce2882092;

public class oc6e7b992074 {
    private final Method Y;
    private final MethodHandle \u01a5;
    private final Class<?> \u0568;
    private final oc8ce2882092 \u00f6;
    private final boolean \u047b;
    private final long \u04e4;

    private oc6e7b992074(Object object, Method method, Class<?> clazz, oc66fa4f2195 oc66fa4f21952, long l) throws IllegalAccessException {
        this.Y = method;
        this.\u01a5 = MethodHandles.lookup().unreflect(method).bindTo(object).asType(MethodType.methodType(Void.TYPE, oc68d6b191af.class));
        this.\u0568 = clazz;
        this.\u00f6 = oc66fa4f21952.priority();
        this.\u047b = oc66fa4f21952.receiveCanceled();
        this.\u04e4 = l;
    }
}

