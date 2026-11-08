/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.ocbb1bc27172;

public class oc5a0c1fbe1c {
    public static final oc5a0c1fbe1c \u012c = new oc5a0c1fbe1c("", "", 0L);
    private final String \u037c;
    private final String \u00ca;
    private final long \u03a7;
    public static int \u03e4;

    public oc5a0c1fbe1c(String string, String string2, long l) {
        this.\u037c = string == null ? "" : string;
        this.\u00ca = string2 == null ? "" : string2;
        this.\u03a7 = Math.max(0L, l);
    }

    public String \u020b() {
        return this.\u037c;
    }

    public String \u054f() {
        return this.\u00ca;
    }

    public long \u021b() {
        return this.\u03a7;
    }

    public boolean \u0163() {
        boolean bl;
        block2: {
            block3: {
                int n = ocbb1bc27172.\u050d;
                bl = this.\u037c.isEmpty();
                if (n != 0) break block2;
                if (bl) break block3;
                bl = true;
                break block2;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u04a0() {
        boolean bl;
        block2: {
            block3: {
                int n = ocbb1bc27172.\u050d;
                bl = this.\u00ca.isEmpty();
                if (n != 0) break block2;
                if (bl) break block3;
                bl = true;
                break block2;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0207(long l) {
        int n;
        block12: {
            block11: {
                block13: {
                    oc5a0c1fbe1c oc5a0c1fbe1c2;
                    int n2;
                    block10: {
                        n2 = ocbb1bc27172.\u050d;
                        oc5a0c1fbe1c2 = this;
                        if (n2 != 0) break block10;
                        if (!oc5a0c1fbe1c2.\u04a0()) break block11;
                        oc5a0c1fbe1c2 = this;
                    }
                    n = oc5a0c1fbe1c2.\u0163();
                    if (n2 != 0) break block12;
                    if (n == 0) break block13;
                    long l2 = this.\u03a7 - (l + (0x2C640F53C02F1D46L ^ 0x2C640F53C02FF726L));
                    n = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                    if (n2 != 0) break block12;
                    if (n > 0) break block11;
                }
                n = 1;
                break block12;
            }
            n = 0;
        }
        return n != 0;
    }
}

