/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;

public class occc82079da8 {
    public static boolean \u025f;

    private occc82079da8() {
    }

    public static Field \u00d0(Class<?> clazz, String ... stringArray) {
        for (Class<?> clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            for (String string : stringArray) {
                try {
                    Field field = clazz2.getDeclaredField(string);
                    field.setAccessible(true);
                    return field;
                }
                catch (NoSuchFieldException noSuchFieldException) {
                }
            }
        }
        throw new IllegalStateException("Missing field in " + clazz.getName());
    }
}

