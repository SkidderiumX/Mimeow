/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oce6044968f8;

public class oc8ef88da691 {
    public static final long \u054c = 250L;
    private boolean \u0569;
    private long p;
    private long \u0573 = 0x95799198BCD95B84L ^ 0x95799198BCD95B7EL;
    public static int \u050a;

    public oc8ef88da691(boolean bl, long l) {
        this.\u0390(bl, l);
    }

    public void \u025e(boolean bl, long l) {
        oc8ef88da691 oc8ef88da6912;
        block6: {
            block7: {
                boolean bl2 = oce6044968f8.\u0452;
                oc8ef88da6912 = this;
                if (bl2) break block6;
                if (oc8ef88da6912.\u0569 != bl) break block7;
                return;
            }
            oc8ef88da6912 = this;
        }
        double d = oc8ef88da6912.\u02a1(l);
        this.\u0569 = bl;
        double d2 = bl ? 1.0 - Math.sqrt(1.0 - d) : 1.0 - Math.sqrt(d);
        double d3 = d2;
        this.p = l - Math.round(oc8ef88da691.\u029a(d3) * (double)this.\u0573);
    }

    public void \u0526(long l, long l2) {
        long l3;
        long l4;
        block4: {
            block5: {
                l4 = Math.max(1L, l);
                boolean bl = oce6044968f8.\u0452;
                l3 = this.\u0573;
                if (bl) break block4;
                if (l3 != l4) break block5;
                return;
            }
            l3 = l2 - this.p;
        }
        double d = oc8ef88da691.\u029a((double)l3 / (double)this.\u0573);
        this.\u0573 = l4;
        this.p = l2 - Math.round(d * (double)l4);
    }

    public void \u0390(boolean bl, long l) {
        this.\u0569 = bl;
        this.p = l - this.\u0573;
    }

    public double \u02a1(long l) {
        double d = oc8ef88da691.\u029a((double)(l - this.p) / (double)this.\u0573);
        double d2 = 1.0 - (d - 1.0) * (d - 1.0);
        double d3 = this.\u0569 ? d2 : 1.0 - d2;
        return oc8ef88da691.\u029a(d3);
    }

    public boolean \u0144(long l) {
        int n;
        block8: {
            block7: {
                boolean bl;
                block6: {
                    bl = oce6044968f8.\u0452;
                    n = this.\u0569;
                    if (bl) break block6;
                    if (n != 0) break block7;
                    long l2 = l - this.p - this.\u0573;
                    n = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                }
                if (bl) break block8;
                if (n < 0) break block7;
                n = 1;
                break block8;
            }
            n = 0;
        }
        return n != 0;
    }

    private static double \u029a(double d) {
        return Math.max(0.0, Math.min(1.0, d));
    }
}

