/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C03PacketPlayer;
import x.oc84f20a0bc5;
import x.oceb39b7deb2;

public class oc791986a759 {
    final double \u0509;
    final double \u017f;
    final double \u0243;
    final float \u0386;
    final float \u0163;
    final boolean \u01e8;
    final boolean \u057c;
    final boolean \u04cd;
    final boolean \u0155;
    final long \u0522;

    oc791986a759(double d, double d2, double d3, float f, float f2, boolean bl, boolean bl2, boolean bl3, boolean bl4, long l) {
        this.\u0509 = d;
        this.\u017f = d2;
        this.\u0243 = d3;
        this.\u0386 = f;
        this.\u0163 = f2;
        this.\u01e8 = bl;
        this.\u057c = bl2;
        this.\u04cd = bl3;
        this.\u0155 = bl4;
        this.\u0522 = l;
    }

    static oc791986a759 \u04b1(oc791986a759 oc791986a7592, C03PacketPlayer c03PacketPlayer, long l) {
        oc791986a759 oc791986a7593;
        boolean bl = c03PacketPlayer.isMoving();
        boolean bl2 = c03PacketPlayer.getRotating();
        oc791986a759 oc791986a7594 = oc791986a7593;
        oc791986a759 oc791986a7595 = oc791986a7593;
        double d = bl ? c03PacketPlayer.getPositionX() : (oc791986a7592 == null ? 0.0 : oc791986a7592.\u0509);
        oc791986a7594(d, bl ? c03PacketPlayer.getPositionY() : (oc791986a7592 == null ? 0.0 : oc791986a7592.\u017f), bl ? c03PacketPlayer.getPositionZ() : (oc791986a7592 == null ? 0.0 : oc791986a7592.\u0243), bl2 ? c03PacketPlayer.getYaw() : (oc791986a7592 == null ? 0.0f : oc791986a7592.\u0386), bl2 ? c03PacketPlayer.getPitch() : (oc791986a7592 == null ? 0.0f : oc791986a7592.\u0163), c03PacketPlayer.isOnGround(), oc791986a7592 != null && oc791986a7592.\u057c, bl || oc791986a7592 != null && oc791986a7592.\u04cd, bl2 || oc791986a7592 != null && oc791986a7592.\u0155, l);
        return oc791986a7595;
    }

    static oc791986a759 \u053b(oc791986a759 oc791986a7592, boolean bl) {
        oc791986a759 oc791986a7593;
        block4: {
            block5: {
                int n = oc84f20a0bc5.\u0117;
                oc791986a7593 = oc791986a7592;
                if (n != 0) break block4;
                if (oc791986a7593 != null) break block5;
                return new oc791986a759(0.0, 0.0, 0.0, 0.0f, 0.0f, false, bl, false, false, 0L);
            }
            oc791986a7593 = new oc791986a759(oc791986a7592.\u0509, oc791986a7592.\u017f, oc791986a7592.\u0243, oc791986a7592.\u0386, oc791986a7592.\u0163, oc791986a7592.\u01e8, bl, oc791986a7592.\u04cd, oc791986a7592.\u0155, oc791986a7592.\u0522);
        }
        return oc791986a7593;
    }

    oceb39b7deb2 \u021a() {
        return new oceb39b7deb2(this.\u0509, this.\u017f, this.\u0243, this.\u057c);
    }
}

