/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.server.S23PacketBlockChange;
import x.oc053077e19a;
import x.oc19a24d59db;
import x.ocbf5a535fb8;
import x.occ0b63c0426;

public class ocba842a160c
extends oc053077e19a {
    public final ocbf5a535fb8 \u0190;
    public final oc19a24d59db \u03e7;
    public static int \u021b;

    public ocba842a160c(S23PacketBlockChange s23PacketBlockChange) {
        super(s23PacketBlockChange);
        this.\u0190 = ocbf5a535fb8.\u03e1(s23PacketBlockChange.getBlockPosition());
        this.\u03e7 = new oc19a24d59db(s23PacketBlockChange.getBlockState(), s23PacketBlockChange.getBlockPosition());
    }

    public ocba842a160c(ocbf5a535fb8 ocbf5a535fb82) {
        super(null);
        this.\u0190 = ocbf5a535fb82;
        this.\u03e7 = null;
    }

    public ocba842a160c(S23PacketBlockChange s23PacketBlockChange, byte by) {
        this(s23PacketBlockChange);
    }

    public S23PacketBlockChange z$1m95n1m9pvxum() {
        S23PacketBlockChange s23PacketBlockChange;
        block6: {
            block5: {
                ocba842a160c ocba842a160c2;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    ocba842a160c2 = this;
                    if (n != 0) break block4;
                    if (!(ocba842a160c2.\u046d instanceof S23PacketBlockChange)) break block5;
                    ocba842a160c2 = this;
                }
                s23PacketBlockChange = (S23PacketBlockChange)ocba842a160c2.\u046d;
                break block6;
            }
            s23PacketBlockChange = null;
        }
        return s23PacketBlockChange;
    }
}

