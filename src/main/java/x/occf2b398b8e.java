/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import x.ocb5eb238adf;
import x.ocbf5a535fb8;
import x.occ0b63c0426;
import x.occ2ace216f9;

public class occf2b398b8e
extends ocb5eb238adf {
    public final int \u0189;
    public final ocbf5a535fb8 \u0240;
    public final occ2ace216f9 \u050a;
    public static boolean \u050f;

    public occf2b398b8e(occ2ace216f9 occ2ace216f92, ocbf5a535fb8 ocbf5a535fb82, int n, ocbf5a535fb8 ocbf5a535fb83) {
        this(new C08PacketPlayerBlockPlacement(ocbf5a535fb82 == null ? BlockPos.ORIGIN : ocbf5a535fb8.\u020e(ocbf5a535fb82), n, occ2ace216f92 == null ? null : occ2ace216f92.W(), ocbf5a535fb83 == null ? 0.0f : (float)ocbf5a535fb83.\u03ba, ocbf5a535fb83 == null ? 0.0f : (float)ocbf5a535fb83.\u0418, ocbf5a535fb83 == null ? 0.0f : (float)ocbf5a535fb83.\u03e0));
    }

    public occf2b398b8e(C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement) {
        super(c08PacketPlayerBlockPlacement);
        this.\u0189 = c08PacketPlayerBlockPlacement.getPlacedBlockDirection();
        this.\u0240 = ocbf5a535fb8.\u03e1(c08PacketPlayerBlockPlacement.getPosition());
        this.\u050a = occ2ace216f9.\u0256(c08PacketPlayerBlockPlacement.getStack());
    }

    public ocbf5a535fb8 \u0565() {
        occf2b398b8e occf2b398b8e2;
        block4: {
            block5: {
                int n = occ0b63c0426.\u039f;
                occf2b398b8e2 = this;
                if (n != 0) break block4;
                if (occf2b398b8e2.\u03e3 instanceof C08PacketPlayerBlockPlacement) break block5;
                return null;
            }
            occf2b398b8e2 = this;
        }
        C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement = (C08PacketPlayerBlockPlacement)occf2b398b8e2.\u03e3;
        return new ocbf5a535fb8(c08PacketPlayerBlockPlacement.getPlacedBlockOffsetX(), c08PacketPlayerBlockPlacement.getPlacedBlockOffsetY(), c08PacketPlayerBlockPlacement.getPlacedBlockOffsetZ());
    }

    public C08PacketPlayerBlockPlacement z$3uoime2rixgf9() {
        C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement;
        block6: {
            block5: {
                occf2b398b8e occf2b398b8e2;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    occf2b398b8e2 = this;
                    if (n != 0) break block4;
                    if (!(occf2b398b8e2.\u03e3 instanceof C08PacketPlayerBlockPlacement)) break block5;
                    occf2b398b8e2 = this;
                }
                c08PacketPlayerBlockPlacement = (C08PacketPlayerBlockPlacement)occf2b398b8e2.\u03e3;
                break block6;
            }
            c08PacketPlayerBlockPlacement = null;
        }
        return c08PacketPlayerBlockPlacement;
    }
}

