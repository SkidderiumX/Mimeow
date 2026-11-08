/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import x.oc69da1aa7f5;

public class oc8e5a0b9bfa {
    public static boolean \u0104;

    private oc8e5a0b9bfa() {
    }

    public static Field \u020a(Class<?> clazz, String ... stringArray) {
        for (String string : stringArray) {
            for (Class<?> clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
                try {
                    Field field = clazz2.getDeclaredField(string);
                    field.setAccessible(true);
                    return field;
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    continue;
                }
            }
        }
        throw new IllegalArgumentException("Unable to find field on " + clazz.getName());
    }

    public static <T, E> T \u050a(Class<? super E> clazz, E e, String ... stringArray) {
        try {
            return (T)oc8e5a0b9bfa.\u020a(clazz, stringArray).get(e);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
    }

    public static <T, E> void \u0279(Class<? super E> clazz, E e, T t, String ... stringArray) {
        block6: {
            boolean bl;
            block8: {
                block7: {
                    boolean bl2 = false;
                    try {
                        oc8e5a0b9bfa.\u020a(clazz, stringArray).set(e, t);
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        throw new IllegalStateException(illegalAccessException);
                    }
                    if (!bl2) break block6;
                    if (!false) break block7;
                    bl = false;
                    break block8;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }
}

