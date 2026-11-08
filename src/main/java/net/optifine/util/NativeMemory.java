/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.lang.reflect.Method;
import net.optifine.util.LongSupplier;

public class NativeMemory {
    private static LongSupplier bufferAllocatedSupplier = NativeMemory.makeLongSupplier(new String[][]{{"sun.misc.SharedSecrets", "getJavaNioAccess", "getDirectBufferPool", "getMemoryUsed"}, {"jdk.internal.misc.SharedSecrets", "getJavaNioAccess", "getDirectBufferPool", "getMemoryUsed"}});
    private static LongSupplier bufferMaximumSupplier = NativeMemory.makeLongSupplier(new String[][]{{"sun.misc.VM", "maxDirectMemory"}, {"jdk.internal.misc.VM", "maxDirectMemory"}});

    public static long getBufferAllocated() {
        return bufferAllocatedSupplier == null ? -1L : bufferAllocatedSupplier.getAsLong();
    }

    public static long getBufferMaximum() {
        return bufferMaximumSupplier == null ? Runtime.getRuntime().maxMemory() : bufferMaximumSupplier.getAsLong();
    }

    private static LongSupplier makeLongSupplier(String[][] stringArray) {
        for (int i = 0; i < stringArray.length; ++i) {
            String[] stringArray2 = stringArray[i];
            try {
                LongSupplier longSupplier = NativeMemory.makeLongSupplier(stringArray2);
                if (longSupplier == null) continue;
                return longSupplier;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return null;
    }

    private static LongSupplier makeLongSupplier(String[] stringArray) throws Exception {
        String string;
        if (stringArray.length < 2) {
            return null;
        }
        Class<?> clazz = Class.forName(stringArray[0]);
        Method method = clazz.getMethod(stringArray[1], new Class[0]);
        method.setAccessible(true);
        Object object = null;
        for (int i = 2; i < stringArray.length; ++i) {
            string = stringArray[i];
            object = method.invoke(object, new Object[0]);
            method = object.getClass().getMethod(string, new Class[0]);
            method.setAccessible(true);
        }
        final Method method2 = method;
        string = object;
        LongSupplier longSupplier = new LongSupplier(){
            private boolean disabled = false;

            @Override
            public long getAsLong() {
                if (this.disabled) {
                    return -1L;
                }
                try {
                    return (Long)method2.invoke(string, new Object[0]);
                }
                catch (Throwable throwable) {
                    this.disabled = true;
                    return -1L;
                }
            }
        };
        return longSupplier;
    }
}

