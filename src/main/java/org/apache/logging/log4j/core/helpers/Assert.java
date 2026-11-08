/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

public class Assert {
    private Assert() {
    }

    public static <T> T isNotNull(T t, String string) {
        if (t == null) {
            throw new NullPointerException(string + " is null");
        }
        return t;
    }
}

