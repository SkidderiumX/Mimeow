/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.function.BooleanSupplier;
import java.util.function.LongSupplier;
import x.oc75d51ec7eb;

public class occ2b330902d {
    private long \u0117;
    private long \u02a3;
    private boolean \u0511;
    public static int \u01b1;

    public occ2b330902d(long l) {
        this.\u0117 = l;
    }

    public occ2b330902d() {
        this.\u0117 = System.currentTimeMillis();
    }

    public void \u04a9() {
        this.\u029b();
        this.\u0511 = false;
    }

    public boolean \u0547() {
        return this.\u03eb(() -> {
            long l;
            block2: {
                block3: {
                    int n = oc75d51ec7eb.\u03e9;
                    long l2 = System.currentTimeMillis() - (this.\u02a3 + this.\u0117);
                    l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                    if (n != 0) break block2;
                    if (l < 0) break block3;
                    l = 1;
                    break block2;
                }
                l = 0;
            }
            return (boolean)l;
        });
    }

    public void \u03b2(long l) {
        this.\u0117 = l;
    }

    public boolean \u049e() {
        return this.\u00e0(this.\u02a3 + this.\u0117, System::currentTimeMillis);
    }

    public boolean \u04cd(long l) {
        return this.\u00e0(this.\u02a3, () -> System.currentTimeMillis() - l);
    }

    public boolean \u0418(long l) {
        return this.\u00e0(this.\u0117, () -> System.currentTimeMillis() - l);
    }

    public boolean \u024d(long l) {
        return this.\u00e0(this.\u02a3, () -> Math.max(0L, System.currentTimeMillis() - l));
    }

    public void \u029b() {
        this.\u02a3 = System.currentTimeMillis();
    }

    public long \u0551() {
        return Math.max(0L, System.currentTimeMillis() - this.\u02a3);
    }

    public boolean \u0278(long l) {
        long l2;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                long l3 = this.\u0551() - this.\u0117 - l;
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

    public boolean \u0293(long l, boolean bl) {
        long l2;
        block8: {
            block9: {
                boolean bl2;
                block10: {
                    block11: {
                        int n = oc75d51ec7eb.\u03e9;
                        long l3 = this.\u0551() - l;
                        l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                        if (n != 0) break block8;
                        if (l2 < 0) break block9;
                        bl2 = bl;
                        if (n != 0) break block10;
                        if (!bl2) break block11;
                        this.\u029b();
                    }
                    bl2 = true;
                }
                return bl2;
            }
            l2 = 0;
        }
        return (boolean)l2;
    }

    private boolean \u03eb(BooleanSupplier booleanSupplier) {
        boolean bl;
        block8: {
            block9: {
                int n = oc75d51ec7eb.\u03e9;
                bl = booleanSupplier.getAsBoolean();
                if (n != 0) break block8;
                if (!bl) break block9;
                bl = this.\u0511;
                if (n != 0) break block8;
                if (bl) break block9;
                this.\u0511 = true;
                return true;
            }
            bl = false;
        }
        return bl;
    }

    private boolean \u00e0(long l, LongSupplier longSupplier) {
        long l2;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                long l3 = longSupplier.getAsLong() - l;
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
}

