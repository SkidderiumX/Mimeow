/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.server.S27PacketExplosion;
import x.oc47731c13e2;
import x.oc6031c5c531;
import x.ocdacba68ccd;
import x.oce79181588d;

public class oc9fb3e9bae3
extends oc6031c5c531 {
    private boolean \u0151 = false;
    private int \u0556 = 0;
    public static int \u0210;

    public oc9fb3e9bae3(ocdacba68ccd ocdacba68ccd2) {
        super("IntaveFlagFly", ocdacba68ccd2);
    }

    @Override
    public boolean z$3hzq8op22ljmt() {
        return true;
    }

    @Override
    public void z$30uo8shdqe5to() {
        this.\u0151 = false;
        this.\u0556 = 0;
    }

    @Override
    public void z$28gl8df6dqh8o(oce79181588d oce79181588d2) {
        if (oce79181588d2.\u04a0() instanceof S27PacketExplosion) {
            this.\u0151 = true;
            this.\u0556 = 0;
        }
    }

    @Override
    public void z$16gekk6u5hb3u() {
        EntityPlayerSP entityPlayerSP;
        int n;
        block14: {
            oc9fb3e9bae3 oc9fb3e9bae32;
            block12: {
                block13: {
                    n = oc47731c13e2.\u016f;
                    oc9fb3e9bae32 = this;
                    if (n != 0) break block12;
                    if (oc9fb3e9bae32.\u0465 != null) break block13;
                    entityPlayerSP = null;
                    break block14;
                }
                oc9fb3e9bae32 = this;
            }
            entityPlayerSP = oc9fb3e9bae32.\u0465.thePlayer;
        }
        EntityPlayerSP entityPlayerSP2 = entityPlayerSP;
        if (entityPlayerSP2 == null) {
            return;
        }
        if (this.\u0151) {
            block16: {
                block15: {
                    double d = 2.2 + Math.random() * 0.25;
                    double d2 = Math.toRadians(entityPlayerSP2.rotationYaw);
                    entityPlayerSP2.motionX = -Math.sin(d2) * d + (Math.random() - 0.5) * 0.07;
                    entityPlayerSP2.motionZ = Math.cos(d2) * d + (Math.random() - 0.5) * 0.07;
                    EntityPlayerSP entityPlayerSP3 = entityPlayerSP2;
                    if (n != 0) break block15;
                    entityPlayerSP3.motionY = 0.42 + (Math.random() - 0.5) * 0.08;
                    entityPlayerSP2.fallDistance = 0.0f;
                    ++this.\u0556;
                    if (this.\u0556 < this.\u0212.M()) break block16;
                    this.\u0151 = false;
                    entityPlayerSP2.motionX = 0.0;
                    entityPlayerSP3 = entityPlayerSP2;
                }
                entityPlayerSP3.motionZ = 0.0;
            }
            return;
        }
    }

    @Override
    public void z$1q0da71f8mrae() {
        this.\u0151 = false;
        this.\u0556 = 0;
    }
}

