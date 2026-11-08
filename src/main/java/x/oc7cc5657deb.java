/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc84f20a0bc5;

public class oc7cc5657deb {
    private boolean W;

    oc7cc5657deb() {
    }

    boolean \u041a() {
        block4: {
            oc7cc5657deb oc7cc5657deb2;
            block5: {
                int n = oc84f20a0bc5.\u0117;
                oc7cc5657deb2 = this;
                if (n != 0) break block4;
                if (!oc7cc5657deb2.W) break block5;
                return false;
            }
            oc7cc5657deb2 = this;
        }
        oc7cc5657deb2.W = true;
        return true;
    }

    boolean F(boolean bl) {
        boolean bl2;
        block6: {
            block8: {
                block7: {
                    int n = oc84f20a0bc5.\u0117;
                    bl2 = bl;
                    if (n != 0) break block6;
                    if (bl2) break block7;
                    bl2 = this.W;
                    if (n != 0) break block6;
                    if (!bl2) break block8;
                }
                bl2 = true;
                break block6;
            }
            bl2 = false;
        }
        boolean bl3 = bl2;
        this.W = false;
        return bl3;
    }

    boolean \u0422() {
        return this.W;
    }

    void \u0213() {
        this.W = false;
    }
}

