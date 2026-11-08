/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oca05c637d94
extends ocb5eb238adf {
    public int \u0264;
    public short \u00fb;
    public static boolean \u00ba;

    public oca05c637d94(int n, short s) {
        this(new C0FPacketConfirmTransaction(n, s, true));
    }

    public oca05c637d94(C0FPacketConfirmTransaction c0FPacketConfirmTransaction) {
        super(c0FPacketConfirmTransaction);
        this.\u0264 = c0FPacketConfirmTransaction == null ? 0 : c0FPacketConfirmTransaction.getWindowId();
        this.\u00fb = c0FPacketConfirmTransaction == null ? (short)0 : c0FPacketConfirmTransaction.getUid();
    }

    public C0FPacketConfirmTransaction z$3uoime2rixgf9() {
        C0FPacketConfirmTransaction c0FPacketConfirmTransaction;
        block6: {
            block5: {
                oca05c637d94 oca05c637d942;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oca05c637d942 = this;
                    if (n != 0) break block4;
                    if (!(oca05c637d942.\u03e3 instanceof C0FPacketConfirmTransaction)) break block5;
                    oca05c637d942 = this;
                }
                c0FPacketConfirmTransaction = (C0FPacketConfirmTransaction)oca05c637d942.\u03e3;
                break block6;
            }
            c0FPacketConfirmTransaction = null;
        }
        return c0FPacketConfirmTransaction;
    }
}

