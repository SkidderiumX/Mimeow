/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C09PacketHeldItemChange;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oc6ebd99bf0a
extends ocb5eb238adf {
    public int \u01ac;
    public static int D;

    public oc6ebd99bf0a(int n) {
        this(new C09PacketHeldItemChange(n));
    }

    public oc6ebd99bf0a(C09PacketHeldItemChange c09PacketHeldItemChange, boolean bl) {
        this(c09PacketHeldItemChange);
    }

    public oc6ebd99bf0a(C09PacketHeldItemChange c09PacketHeldItemChange) {
        super(c09PacketHeldItemChange);
        this.\u01ac = c09PacketHeldItemChange == null ? 0 : c09PacketHeldItemChange.getSlotId();
    }

    public C09PacketHeldItemChange z$3uoime2rixgf9() {
        C09PacketHeldItemChange c09PacketHeldItemChange;
        block6: {
            block5: {
                oc6ebd99bf0a oc6ebd99bf0a2;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc6ebd99bf0a2 = this;
                    if (n != 0) break block4;
                    if (!(oc6ebd99bf0a2.\u03e3 instanceof C09PacketHeldItemChange)) break block5;
                    oc6ebd99bf0a2 = this;
                }
                c09PacketHeldItemChange = (C09PacketHeldItemChange)oc6ebd99bf0a2.\u03e3;
                break block6;
            }
            c09PacketHeldItemChange = null;
        }
        return c09PacketHeldItemChange;
    }
}

