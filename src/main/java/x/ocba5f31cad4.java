/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc75d51ec7eb;

public class ocba5f31cad4 {
    private long \u0414 = 0L;
    public static boolean \u03df;

    public void \u0178() {
        this.\u0414 = System.currentTimeMillis();
    }

    public long \u02ac() {
        return System.currentTimeMillis() - this.\u0414;
    }

    public boolean \u0168(long l) {
        long l2;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                long l3 = this.\u02ac() - l;
                l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                if (n != 0) break block2;
                if (l2 < 0) break block3;
                l2 = 1;
                break block2;
            }
            l2 = 0;
        }
        return (boolean)l2;
    }

    public boolean \u024c(long l, boolean bl) {
        long l2;
        block8: {
            block9: {
                boolean bl2;
                block10: {
                    block11: {
                        int n = oc75d51ec7eb.\u03e9;
                        long l3 = System.currentTimeMillis() - this.\u0414 - l;
                        l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                        if (n != 0) break block8;
                        if (l2 <= 0) break block9;
                        bl2 = bl;
                        if (n != 0) break block10;
                        if (!bl2) break block11;
                        this.\u0178();
                    }
                    bl2 = true;
                }
                return bl2;
            }
            l2 = 0;
        }
        return (boolean)l2;
    }

    public boolean \u03be(double d) {
        return this.\u0168((long)d);
    }

    public long \u0566() {
        return this.\u02ac();
    }

    public void \u0102() {
        this.\u0414 = 0L;
    }

    public void \u0295(long l) {
        this.\u0414 = l;
    }
}

