/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.internal;

public class Objects {
    private Objects() {
        throw new UnsupportedOperationException();
    }

    public static void ensureNotNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }
}

