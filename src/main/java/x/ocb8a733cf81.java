/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc54714bd439;

public class ocb8a733cf81 {
    private final String \u0446;
    private final long \u0287;
    private final long \u03ec;
    public static boolean \u03c9;

    public ocb8a733cf81(String string, long l) {
        this.\u0446 = string;
        this.\u0287 = l;
        this.\u03ec = System.currentTimeMillis();
    }

    public String \u0156() {
        return this.\u0446;
    }

    public boolean \u03c6() {
        int n;
        block8: {
            block7: {
                ocb8a733cf81 ocb8a733cf812;
                int n2;
                block6: {
                    n2 = oc54714bd439.\u0563;
                    ocb8a733cf812 = this;
                    if (n2 != 0) break block6;
                    if (ocb8a733cf812.\u0287 < 0L) break block7;
                    ocb8a733cf812 = this;
                }
                long l = ocb8a733cf812.\u0287 - (System.currentTimeMillis() - this.\u03ec);
                n = l == 0L ? 0 : (l < 0L ? -1 : 1);
                if (n2 != 0) break block8;
                if (n >= 0) break block7;
                n = 1;
                break block8;
            }
            n = 0;
        }
        return n != 0;
    }
}

