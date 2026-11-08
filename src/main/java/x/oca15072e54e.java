/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc110d7f376c;
import x.oc668fce0dbf;
import x.oc66fa4f2195;
import x.oc84f20a0bc5;
import x.ocea775c9d5c;
import x.ocf923d5a814;

public class oca15072e54e {
    private oc668fce0dbf \u0205;

    private oca15072e54e() {
    }

    @oc66fa4f2195
    public void \u03ae(ocf923d5a814 ocf923d5a8142) {
        block15: {
            boolean bl;
            block18: {
                oc668fce0dbf oc668fce0dbf2;
                int n;
                block17: {
                    oc668fce0dbf oc668fce0dbf3;
                    block16: {
                        block14: {
                            n = oc84f20a0bc5.\u0117;
                            oc668fce0dbf3 = this.\u0205;
                            if (n != 0) break block14;
                            if (oc668fce0dbf3 == null) break block15;
                            oc668fce0dbf2 = oc668fce0dbf3;
                            if (n != 0) break block16;
                            oc668fce0dbf2.\u04e3(ocf923d5a8142);
                        }
                        if (ocf923d5a8142.\u04b0 != oc110d7f376c.END) break block15;
                        oc668fce0dbf2 = oc668fce0dbf3;
                        if (n != 0) break block17;
                    }
                    if (oc668fce0dbf2.z$3rzb3dil7uydr()) break block15;
                    oc668fce0dbf2 = oc668fce0dbf3;
                }
                bl = oc668fce0dbf2.\u01ea();
                if (n != 0) break block18;
                if (!bl) break block15;
                ocea775c9d5c.\u0173.unregister(this);
                bl = false;
            }
            oc668fce0dbf.\u0562 = bl;
        }
    }
}

