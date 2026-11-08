/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.util;

import java.util.Locale;

public class EnglishEnums {
    private EnglishEnums() {
    }

    public static <T extends Enum<T>> T valueOf(Class<T> clazz, String string) {
        return EnglishEnums.valueOf(clazz, string, null);
    }

    public static <T extends Enum<T>> T valueOf(Class<T> clazz, String string, T t) {
        return string == null ? t : Enum.valueOf(clazz, string.toUpperCase(Locale.ENGLISH));
    }
}

