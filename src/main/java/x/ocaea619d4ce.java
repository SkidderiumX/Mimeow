/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc75d51ec7eb;
import x.oca40eaa9ef8;

public class ocaea619d4ce {
    public static final long \u0431 = 50000000L;
    private static final long \u03b8 = 1000000000L;
    private static final int \u0395 = 60;
    private oca40eaa9ef8 \u01ad = oca40eaa9ef8.\u04cc;
    private long \u017b;
    private long \u00d5;
    private long \u043b;
    private long p;
    private int \u00c8;
    private int \u017d;
    private double \u03ae;
    private float \u03c3;
    public static boolean \u019b;

    public void Z(long l, int n, int n2, int n3, float f) {
        this.\u043d(l, n, n2, n3, f, 1.0f);
    }

    public void \u043d(long l, int n, int n2, int n3, float f, float f2) {
        this.\u017b = l;
        this.\u00d5 = l + (long)Math.max(0, n) * (0x7C88067CF2FB8E78L ^ 0x7C88067CF0017EF8L);
        this.\u043b = this.\u00d5 + (long)Math.max(1, n2) * (0x7C88067CF2FB8E78L ^ 0x7C88067CF0017EF8L);
        this.p = 0L;
        this.\u00c8 = Math.max(1, Math.min(0x9C2EF61B ^ 0x9C2EF611, n3));
        this.\u017d = 0;
        this.\u03ae = Math.max(0.0, Math.min(1.0, (double)f));
        this.\u03c3 = Math.max(0.0f, f2);
        ocaea619d4ce ocaea619d4ce2 = this;
        oca40eaa9ef8 oca40eaa9ef82 = n > 0 ? oca40eaa9ef8.\u0498 : oca40eaa9ef8.\u0421;
        ocaea619d4ce2.\u01ad = oca40eaa9ef82;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean \u047b(long l) {
        long l2;
        block18: {
            ocaea619d4ce ocaea619d4ce2;
            long l3;
            int n;
            block16: {
                block17: {
                    oca40eaa9ef8 oca40eaa9ef82;
                    block15: {
                        n = oc75d51ec7eb.\u03e9;
                        oca40eaa9ef82 = this.\u01ad;
                        if (n != 0) break block15;
                        if (oca40eaa9ef82 == oca40eaa9ef8.\u04cc) return false;
                        oca40eaa9ef82 = this.\u01ad;
                    }
                    if (oca40eaa9ef82 == oca40eaa9ef8.\u0127) {
                        return false;
                    }
                    l3 = l;
                    ocaea619d4ce2 = this;
                    if (n != 0) break block16;
                    if (l3 < ocaea619d4ce2.\u043b) break block17;
                    this.\u0564(l);
                    return true;
                }
                l3 = l;
                ocaea619d4ce2 = this;
            }
            long l4 = l3 - ocaea619d4ce2.\u00d5;
            l2 = l4 == 0L ? 0 : (l4 < 0L ? -1 : 1);
            if (n != 0) return (boolean)l2;
            if (l2 < 0) break block18;
            this.\u01ad = oca40eaa9ef8.\u0421;
        }
        l2 = 0;
        return (boolean)l2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void \u0564(long l) {
        block10: {
            ocaea619d4ce ocaea619d4ce2;
            oca40eaa9ef8 oca40eaa9ef82;
            block9: {
                int n = oc75d51ec7eb.\u03e9;
                oca40eaa9ef82 = this.\u01ad;
                if (n != 0) break block9;
                if (oca40eaa9ef82 == oca40eaa9ef8.\u04cc) return;
                ocaea619d4ce2 = this;
                if (n != 0) break block10;
                oca40eaa9ef82 = ocaea619d4ce2.\u01ad;
            }
            if (oca40eaa9ef82 == oca40eaa9ef8.\u0127) {
                return;
            }
            this.\u01ad = oca40eaa9ef8.\u0127;
            ocaea619d4ce2 = this;
        }
        ocaea619d4ce2.p = l + (0xAFE98F8C70FB36B0L ^ 0xAFE98F8C4B61FCB0L);
    }

    public float \u0581(long l) {
        oca40eaa9ef8 oca40eaa9ef82;
        block7: {
            block8: {
                int n = oc75d51ec7eb.\u03e9;
                oca40eaa9ef82 = this.\u01ad;
                if (n != 0) break block7;
                if (oca40eaa9ef82 != oca40eaa9ef8.\u0421) break block8;
                return 0.0f;
            }
            oca40eaa9ef82 = this.\u01ad;
        }
        if (oca40eaa9ef82 != oca40eaa9ef8.\u0498) {
            return 1.0f;
        }
        double d = (double)Math.max(0L, l - this.\u017b) / (double)Math.max(1L, this.\u00d5 - this.\u017b);
        return (float)Math.max(0.1, 1.0 - d * 0.9);
    }

    public long \u026b(long l) {
        long l2 = this.\u01ad == oca40eaa9ef8.\u0421 ? Math.max(0L, this.\u043b - l) : 0L;
        return l2;
    }

    public int \u045f(long l, int n) {
        if (this.\u01ad != oca40eaa9ef8.\u0127) {
            return 0;
        }
        int n2 = Math.max(0, this.\u0212(l) - this.\u017d - n);
        return Math.min(n2, Math.min(this.\u00c8, Math.max(0, (0xF98E82C6 ^ 0xF98E82CC) - n)));
    }

    public void \u0265() {
        block5: {
            ocaea619d4ce ocaea619d4ce2;
            block4: {
                int n = oc75d51ec7eb.\u03e9;
                ocaea619d4ce2 = this;
                if (n != 0) break block4;
                if (ocaea619d4ce2.\u01ad == oca40eaa9ef8.\u04cc) break block5;
                ocaea619d4ce2 = this;
            }
            ++ocaea619d4ce2.\u017d;
        }
    }

    public boolean \u0455(long l) {
        int n;
        block12: {
            block11: {
                block13: {
                    ocaea619d4ce ocaea619d4ce2;
                    int n2;
                    block10: {
                        n2 = oc75d51ec7eb.\u03e9;
                        ocaea619d4ce2 = this;
                        if (n2 != 0) break block10;
                        if (ocaea619d4ce2.\u01ad != oca40eaa9ef8.\u0127) break block11;
                        ocaea619d4ce2 = this;
                    }
                    n = ocaea619d4ce2.\u017d;
                    if (n2 != 0) break block12;
                    if (n >= this.\u0212(l)) break block13;
                    long l2 = l - this.p;
                    n = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                    if (n2 != 0) break block12;
                    if (n < 0) break block11;
                }
                n = 1;
                break block12;
            }
            n = 0;
        }
        return n != 0;
    }

    public float \u0132(long l) {
        double d = this.\u0160(l);
        return (float)(d - Math.floor(d));
    }

    public oca40eaa9ef8 \u015d() {
        return this.\u01ad;
    }

    public boolean \u0217() {
        boolean bl = this.\u01ad != oca40eaa9ef8.\u04cc;
        return bl;
    }

    public void \u02b0() {
        this.\u01ad = oca40eaa9ef8.\u04cc;
        this.\u017b = 0L;
        this.\u00d5 = 0L;
        this.\u043b = 0L;
        this.p = 0L;
        this.\u017d = 0;
        this.\u03ae = 0.0;
    }

    private int \u0212(long l) {
        return (int)Math.min(60.0, Math.floor(this.\u0160(l)));
    }

    private double \u0160(long l) {
        return this.\u03ae + (double)Math.max(0L, l - this.\u017b) * (double)this.\u03c3 / 5.0E7;
    }
}

