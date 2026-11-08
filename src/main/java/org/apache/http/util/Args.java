/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.util;

import java.util.Collection;
import org.apache.http.util.TextUtils;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Args {
    public static void check(boolean bl, String string) {
        if (!bl) {
            throw new IllegalArgumentException(string);
        }
    }

    public static void check(boolean bl, String string, Object ... objectArray) {
        if (!bl) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }

    public static <T> T notNull(T t, String string) {
        if (t == null) {
            throw new IllegalArgumentException(string + " may not be null");
        }
        return t;
    }

    public static <T extends CharSequence> T notEmpty(T t, String string) {
        if (t == null) {
            throw new IllegalArgumentException(string + " may not be null");
        }
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(string + " may not be empty");
        }
        return t;
    }

    public static <T extends CharSequence> T notBlank(T t, String string) {
        if (t == null) {
            throw new IllegalArgumentException(string + " may not be null");
        }
        if (TextUtils.isBlank(t)) {
            throw new IllegalArgumentException(string + " may not be blank");
        }
        return t;
    }

    public static <E, T extends Collection<E>> T notEmpty(T t, String string) {
        if (t == null) {
            throw new IllegalArgumentException(string + " may not be null");
        }
        if (t.isEmpty()) {
            throw new IllegalArgumentException(string + " may not be empty");
        }
        return t;
    }

    public static int positive(int n, String string) {
        if (n <= 0) {
            throw new IllegalArgumentException(string + " may not be negative or zero");
        }
        return n;
    }

    public static long positive(long l, String string) {
        if (l <= 0L) {
            throw new IllegalArgumentException(string + " may not be negative or zero");
        }
        return l;
    }

    public static int notNegative(int n, String string) {
        if (n < 0) {
            throw new IllegalArgumentException(string + " may not be negative");
        }
        return n;
    }

    public static long notNegative(long l, String string) {
        if (l < 0L) {
            throw new IllegalArgumentException(string + " may not be negative");
        }
        return l;
    }
}

