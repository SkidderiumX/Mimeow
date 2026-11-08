/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.util;

public class EnumUtils {
    public static <T extends Enum<T>> T findEnumInsensitiveCase(Class<T> clazz, String string) {
        for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
            if (enum_.name().compareToIgnoreCase(string) != 0) continue;
            return (T)enum_;
        }
        throw new IllegalArgumentException("No enum constant " + clazz.getCanonicalName() + "." + string);
    }
}

