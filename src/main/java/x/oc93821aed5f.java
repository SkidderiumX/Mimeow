/*
 * Decompiled with CFR 0.152.
 */
package x;

public abstract class oc93821aed5f {
    private volatile boolean r = false;
    public static int \u053f;

    protected abstract boolean z$3j6encvc02s81();

    public final boolean \u0259() {
        boolean bl;
        block6: {
            block8: {
                block7: {
                    int n = \u053f;
                    bl = this.r;
                    if (n != 0) break block6;
                    if (bl) break block7;
                    bl = this.z$3j6encvc02s81();
                    if (n != 0) break block6;
                    if (!bl) break block8;
                }
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public final void \u00e5() {
        this.r = true;
    }
}

