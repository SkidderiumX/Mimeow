/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import x.ocb5eb238adf;
import x.occ0b63c0426;
import x.occ2ace216f9;

public class X
extends ocb5eb238adf {
    public int \u0161;
    public occ2ace216f9 \u054c;
    public static boolean \u00f5;

    public X(int n, occ2ace216f9 occ2ace216f92) {
        this(new C10PacketCreativeInventoryAction(n, occ2ace216f92 == null ? null : occ2ace216f92.W()));
    }

    public X(C10PacketCreativeInventoryAction c10PacketCreativeInventoryAction) {
        super(c10PacketCreativeInventoryAction);
        this.\u0161 = c10PacketCreativeInventoryAction == null ? 0 : c10PacketCreativeInventoryAction.getSlotId();
        this.\u054c = c10PacketCreativeInventoryAction == null ? null : occ2ace216f9.\u0256(c10PacketCreativeInventoryAction.getStack());
    }

    public C10PacketCreativeInventoryAction z$3uoime2rixgf9() {
        C10PacketCreativeInventoryAction c10PacketCreativeInventoryAction;
        block6: {
            block5: {
                X x;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    x = this;
                    if (n != 0) break block4;
                    if (!(x.\u03e3 instanceof C10PacketCreativeInventoryAction)) break block5;
                    x = this;
                }
                c10PacketCreativeInventoryAction = (C10PacketCreativeInventoryAction)x.\u03e3;
                break block6;
            }
            c10PacketCreativeInventoryAction = null;
        }
        return c10PacketCreativeInventoryAction;
    }
}

