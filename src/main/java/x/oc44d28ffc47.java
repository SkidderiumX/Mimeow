/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.player.PlayerCapabilities;
import x.oc47731c13e2;
import x.oc6031c5c531;
import x.oc7ab2161b9f;
import x.ocdacba68ccd;

public class oc44d28ffc47
extends oc6031c5c531 {
    private boolean \u028b;
    public static boolean \u0268;

    public oc44d28ffc47(ocdacba68ccd ocdacba68ccd2) {
        super("Fast", ocdacba68ccd2);
    }

    @Override
    public boolean z$sdj84ne38bfn() {
        return true;
    }

    @Override
    public void z$30uo8shdqe5to() {
        block9: {
            block10: {
                oc44d28ffc47 oc44d28ffc472;
                int n;
                block8: {
                    n = oc47731c13e2.\u016f;
                    oc44d28ffc472 = this;
                    if (n != 0) break block8;
                    if (oc44d28ffc472.\u0465 == null) break block9;
                    oc44d28ffc472 = this;
                }
                if (n != 0) break block10;
                if (oc44d28ffc472.\u0465.thePlayer == null) break block9;
                oc44d28ffc472 = this;
            }
            oc44d28ffc472.\u028b = this.\u0465.thePlayer.capabilities.isFlying;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$16gekk6u5hb3u() {
        block18: {
            block14: {
                oc44d28ffc47 oc44d28ffc472;
                block15: {
                    int n;
                    block19: {
                        oc44d28ffc47 oc44d28ffc473;
                        block20: {
                            boolean bl;
                            block16: {
                                block17: {
                                    n = oc47731c13e2.\u016f;
                                    if (!oc7ab2161b9f.\u00d0()) {
                                        return;
                                    }
                                    this.\u0465.thePlayer.onGround = true;
                                    oc44d28ffc472 = this;
                                    if (n != 0) break block14;
                                    if (oc44d28ffc472.\u0465.currentScreen != null) break block15;
                                    bl = oc7ab2161b9f.\u0183();
                                    if (n != 0) break block16;
                                    if (!bl) break block17;
                                    this.\u0465.thePlayer.motionY = 0.3 * this.\u0212.\u0428();
                                    if (n == 0) break block18;
                                }
                                oc44d28ffc473 = this;
                                if (n != 0) break block19;
                                bl = oc7ab2161b9f.\u0576(oc44d28ffc473.\u0465.gameSettings.keyBindSneak);
                            }
                            if (!bl) break block20;
                            this.\u0465.thePlayer.motionY = -0.3 * this.\u0212.\u0428();
                            if (n == 0) break block18;
                        }
                        oc44d28ffc473 = this;
                    }
                    oc44d28ffc473.\u0465.thePlayer.motionY = 0.0;
                    if (n == 0) break block18;
                }
                oc44d28ffc472 = this;
            }
            oc44d28ffc472.\u0465.thePlayer.motionY = 0.0;
        }
        this.\u0465.thePlayer.capabilities.setFlySpeed(0.2f);
        this.\u0465.thePlayer.capabilities.isFlying = true;
        this.\u03d7(0.85 * this.\u0212.\u0421());
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
                oc44d28ffc47 oc44d28ffc472;
                int n;
                block17: {
                    oc44d28ffc47 oc44d28ffc473;
                    block15: {
                        block16: {
                            block14: {
                                n = oc47731c13e2.\u016f;
                                oc44d28ffc473 = this;
                                if (n != 0) break block14;
                                if (oc44d28ffc473.\u0465 == null) return;
                                oc44d28ffc473 = this;
                            }
                            if (n != 0) break block15;
                            if (oc44d28ffc473.\u0465.thePlayer != null) break block16;
                            return;
                        }
                        oc44d28ffc473 = this;
                    }
                    PlayerCapabilities playerCapabilities = oc44d28ffc473.\u0465.thePlayer.capabilities;
                    oc44d28ffc472 = this;
                    if (n != 0) break block17;
                    if (!oc44d28ffc472.\u0465.thePlayer.capabilities.allowFlying) break block18;
                    oc44d28ffc472 = this;
                }
                bl = oc44d28ffc472.\u028b;
                if (n != 0) break block19;
                if (!bl) break block18;
                bl = true;
                break block19;
            }
            bl = false;
        }
        playerCapabilities.isFlying = bl;
        this.\u0465.thePlayer.capabilities.setFlySpeed(0.05f);
        this.\u028b = false;
    }
}

