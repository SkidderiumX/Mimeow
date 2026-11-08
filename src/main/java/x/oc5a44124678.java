/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C03PacketPlayer;
import x.ocb5eb238adf;
import x.ocbf5a535fb8;
import x.occ0b63c0426;

public class oc5a44124678
extends ocb5eb238adf {
    public final boolean \u0289;
    public final ocbf5a535fb8 \u038e;
    public final float s;
    public final float \u00ee;
    public static int \u0187;

    public oc5a44124678(C03PacketPlayer c03PacketPlayer) {
        super(c03PacketPlayer);
        this.\u0289 = c03PacketPlayer.isMoving();
        this.\u038e = this.\u0289 ? new ocbf5a535fb8(c03PacketPlayer.getPositionX(), c03PacketPlayer.getPositionY(), c03PacketPlayer.getPositionZ()) : null;
        this.s = c03PacketPlayer.getYaw();
        this.\u00ee = c03PacketPlayer.getPitch();
    }

    public oc5a44124678(boolean bl) {
        this(new C03PacketPlayer(bl));
    }

    public oc5a44124678(ocbf5a535fb8 ocbf5a535fb82, boolean bl) {
        this(ocbf5a535fb82 == null ? new C03PacketPlayer(bl) : new C03PacketPlayer.C04PacketPlayerPosition(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0, bl));
    }

    public oc5a44124678(float f, float f2, boolean bl) {
        this(new C03PacketPlayer.C05PacketPlayerLook(f, f2, bl));
    }

    public oc5a44124678(ocbf5a535fb8 ocbf5a535fb82, float f, float f2, boolean bl) {
        this(new C03PacketPlayer.C06PacketPlayerPosLook(ocbf5a535fb82 == null ? 0.0 : ocbf5a535fb82.\u03ba, ocbf5a535fb82 == null ? 0.0 : ocbf5a535fb82.\u0418, ocbf5a535fb82 == null ? 0.0 : ocbf5a535fb82.\u03e0, f, f2, bl));
    }

    public C03PacketPlayer z$3uoime2rixgf9() {
        C03PacketPlayer c03PacketPlayer;
        block6: {
            block5: {
                oc5a44124678 oc5a441246782;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5a441246782 = this;
                    if (n != 0) break block4;
                    if (!(oc5a441246782.\u03e3 instanceof C03PacketPlayer)) break block5;
                    oc5a441246782 = this;
                }
                c03PacketPlayer = (C03PacketPlayer)oc5a441246782.\u03e3;
                break block6;
            }
            c03PacketPlayer = null;
        }
        return c03PacketPlayer;
    }
}

