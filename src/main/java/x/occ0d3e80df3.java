/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc110d7f376c;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc84f20a0bc5;
import x.oca5723f2407;
import x.occ2f8dff8d8;
import x.oce4cea752dd;

public class occ0d3e80df3
extends oc69da1aa7f5 {
    public occ2f8dff8d8 \u00c8;
    public occ2f8dff8d8 \u02a4;
    public static int \u0233;

    public occ0d3e80df3() {
        super("DelayRemover", oce4cea752dd.\u0437, 0);
        this.\u0105("Removes attack and optional jump delays.");
        this.\u00c8 = new occ2f8dff8d8("1.7 hitreg", true);
        this.\u028c(this.\u00c8);
        this.\u02a4 = new occ2f8dff8d8("Remove jump ticks", false);
        this.\u028c(this.\u02a4);
        this.\u026e = true;
    }

    public boolean \u0516() {
        boolean bl;
        block8: {
            block7: {
                occ0d3e80df3 occ0d3e80df32;
                int n;
                block6: {
                    n = oc84f20a0bc5.\u0117;
                    occ0d3e80df32 = this;
                    if (n != 0) break block6;
                    if (!occ0d3e80df32.z$3rzb3dil7uydr()) break block7;
                    occ0d3e80df32 = this;
                }
                bl = occ0d3e80df32.\u02a4.\u01ed();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    @oc66fa4f2195
    public void \u03ed(oca5723f2407 oca5723f24072) {
        occ0d3e80df3 occ0d3e80df32;
        block18: {
            boolean bl;
            block16: {
                int n;
                block17: {
                    block14: {
                        block15: {
                            n = oc84f20a0bc5.\u0117;
                            if (oca5723f24072.\u04b0 != oc110d7f376c.END) break block14;
                            bl = oc69da1aa7f5.\u0151.inGameHasFocus;
                            if (n != 0) break block15;
                            if (!bl) break block14;
                            bl = oc7ab2161b9f.\u00d0();
                        }
                        if (n != 0) break block16;
                        if (bl) break block17;
                    }
                    return;
                }
                occ0d3e80df32 = this;
                if (n != 0) break block18;
                bl = occ0d3e80df32.\u00c8.\u01ed();
            }
            if (bl) {
                oc69da1aa7f5.\u0151.setLeftClickCounter(0);
            }
            occ0d3e80df32 = this;
        }
        if (occ0d3e80df32.\u0516()) {
            oc69da1aa7f5.\u0151.thePlayer.setJumpTicks(0);
        }
    }
}

