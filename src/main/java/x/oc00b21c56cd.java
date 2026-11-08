/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import x.oc69da1aa7f5;
import x.oc84f20a0bc5;
import x.oce4cea752dd;

public class oc00b21c56cd
extends oc69da1aa7f5 {
    private float \u029d = 0.0f;
    private float \u0538 = 0.0f;
    public static int \u0436;

    public oc00b21c56cd() {
        super("NoRotate", oce4cea752dd.\u0437);
        this.\u0105("Keeps server corrections from changing your view.");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void \u012c() {
        Minecraft minecraft;
        block10: {
            int n = oc84f20a0bc5.\u0117;
            if (!this.z$3rzb3dil7uydr()) {
                return;
            }
            minecraft = oc69da1aa7f5.\u0151;
            if (n != 0) break block10;
            if (minecraft.thePlayer == null) return;
            minecraft = oc69da1aa7f5.\u0151;
        }
        if (minecraft.thePlayer.rotationPitch == 0.0f) {
            return;
        }
        this.\u029d = oc69da1aa7f5.\u0151.thePlayer.rotationPitch % 360.0f;
        this.\u0538 = oc69da1aa7f5.\u0151.thePlayer.rotationYaw % 360.0f;
    }

    public void \u03bf(Packet<?> packet) {
        block13: {
            block14: {
                int n;
                block12: {
                    boolean bl;
                    block10: {
                        block11: {
                            n = oc84f20a0bc5.\u0117;
                            bl = this.z$3rzb3dil7uydr();
                            if (n != 0) break block10;
                            if (bl) break block11;
                            return;
                        }
                        bl = packet instanceof S08PacketPlayerPosLook;
                    }
                    if (bl && oc69da1aa7f5.\u0151.thePlayer != null) break block12;
                    return;
                }
                S08PacketPlayerPosLook s08PacketPlayerPosLook = (S08PacketPlayerPosLook)packet;
                if (n != 0) break block13;
                if (s08PacketPlayerPosLook.getPitch() != 0.0f) break block14;
                return;
            }
            oc69da1aa7f5.\u0151.thePlayer.prevRotationYaw = this.\u0538;
            oc69da1aa7f5.\u0151.thePlayer.prevRotationPitch = this.\u029d;
            oc69da1aa7f5.\u0151.thePlayer.rotationPitch = this.\u029d;
            oc69da1aa7f5.\u0151.thePlayer.rotationYaw = this.\u0538;
        }
    }
}

