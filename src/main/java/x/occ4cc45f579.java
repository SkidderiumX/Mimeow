/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerCapabilities;
import x.oc47731c13e2;
import x.oc6031c5c531;
import x.oc7ab2161b9f;
import x.ocdacba68ccd;

public class occ4cc45f579
extends oc6031c5c531 {
    private boolean \u014a;
    public static int \u03c4;

    public occ4cc45f579(ocdacba68ccd ocdacba68ccd2) {
        super("Vanilla", ocdacba68ccd2);
    }

    @Override
    public boolean z$sdj84ne38bfn() {
        return true;
    }

    @Override
    public void z$30uo8shdqe5to() {
        block9: {
            block10: {
                occ4cc45f579 occ4cc45f5792;
                int n;
                block8: {
                    n = oc47731c13e2.\u016f;
                    occ4cc45f5792 = this;
                    if (n != 0) break block8;
                    if (occ4cc45f5792.\u0465 == null) break block9;
                    occ4cc45f5792 = this;
                }
                if (n != 0) break block10;
                if (occ4cc45f5792.\u0465.thePlayer == null) break block9;
                occ4cc45f5792 = this;
            }
            occ4cc45f5792.\u014a = this.\u0465.thePlayer.capabilities.isFlying;
        }
    }

    @Override
    public void z$16gekk6u5hb3u() {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        this.\u0465.thePlayer.motionY = 0.0;
        this.\u0465.thePlayer.capabilities.setFlySpeed((float)((double)0.05f * this.\u0212.\u0421()));
        this.\u0465.thePlayer.capabilities.isFlying = true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$1q0da71f8mrae() {
        boolean bl;
        block19: {
            block18: {
                occ4cc45f579 occ4cc45f5792;
                int n;
                block17: {
                    Minecraft minecraft;
                    block15: {
                        block16: {
                            occ4cc45f579 occ4cc45f5793;
                            block14: {
                                n = oc47731c13e2.\u016f;
                                occ4cc45f5793 = this;
                                if (n != 0) break block14;
                                if (occ4cc45f5793.\u0465 == null) return;
                                occ4cc45f5793 = this;
                            }
                            minecraft = occ4cc45f5793.\u0465;
                            if (n != 0) break block15;
                            if (minecraft.thePlayer != null) break block16;
                            return;
                        }
                        minecraft = this.\u0465;
                    }
                    PlayerCapabilities playerCapabilities = minecraft.thePlayer.capabilities;
                    occ4cc45f5792 = this;
                    if (n != 0) break block17;
                    if (!occ4cc45f5792.\u0465.thePlayer.capabilities.allowFlying) break block18;
                    occ4cc45f5792 = this;
                }
                bl = occ4cc45f5792.\u014a;
                if (n != 0) break block19;
                if (!bl) break block18;
                bl = true;
                break block19;
            }
            bl = false;
        }
        playerCapabilities.isFlying = bl;
        this.\u0465.thePlayer.capabilities.setFlySpeed(0.05f);
        this.\u014a = false;
    }
}

