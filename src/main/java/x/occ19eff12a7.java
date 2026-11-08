/*
 * Decompiled with CFR 0.152.
 */
package x;

import javax.net.ssl.SSLContext;

public class occ19eff12a7 {
    private static final SSLContext \u0426;
    public static boolean \u0582;

    public static SSLContext \u03ce() {
        return \u0426;
    }

    static {
        try {
            \u0426 = SSLContext.getDefault();
        }
        catch (Exception exception) {
            throw new RuntimeException("Failed to initialize SSLContext", exception);
        }
    }
}

