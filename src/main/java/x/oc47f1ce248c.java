/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.AxisAlignedBB;
import x.oc47731c13e2;
import x.oc58525a3389;
import x.oc6031c5c531;
import x.oc7ab2161b9f;
import x.occ2f8dff8d8;
import x.ocdacba68ccd;

public class oc47f1ce248c
extends oc6031c5c531 {
    private static final AxisAlignedBB \u044b = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    public final occ2f8dff8d8 \u0460 = new occ2f8dff8d8("Keep-Y", false);
    private boolean \u01f1;
    private int \u00ea;
    public static int \u0125;

    public oc47f1ce248c(ocdacba68ccd ocdacba68ccd2) {
        super("Walk", ocdacba68ccd2);
    }

    @Override
    public void z$3g18l332rzhcd(boolean bl) {
        this.\u0460.\u0209(bl, this.\u0212);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$30uo8shdqe5to() {
        block9: {
            oc47f1ce248c oc47f1ce248c2;
            block10: {
                int n;
                block8: {
                    n = oc47731c13e2.\u016f;
                    oc47f1ce248c2 = this;
                    if (n != 0) break block8;
                    if (oc47f1ce248c2.\u0465 == null) return;
                    oc47f1ce248c2 = this;
                }
                if (n != 0) break block9;
                if (oc47f1ce248c2.\u0465.thePlayer != null) break block10;
                return;
            }
            this.\u01f1 = this.\u0465.thePlayer.capabilities.isFlying;
            oc47f1ce248c2 = this;
        }
        oc47f1ce248c2.\u00ea = this.\u0465.thePlayer.getPosition().getY();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$1ofn7mpfow52n(oc58525a3389 oc58525a33892) {
        double d;
        double d2;
        block30: {
            oc47f1ce248c oc47f1ce248c2;
            block28: {
                block29: {
                    int n;
                    int n2;
                    block26: {
                        block27: {
                            oc47f1ce248c oc47f1ce248c3;
                            block24: {
                                block25: {
                                    block23: {
                                        block22: {
                                            n2 = oc47731c13e2.\u016f;
                                            oc47f1ce248c3 = this;
                                            if (n2 != 0) break block22;
                                            if (oc47f1ce248c3.\u0465 == null) return;
                                            oc47f1ce248c3 = this;
                                        }
                                        if (n2 != 0) break block23;
                                        if (oc47f1ce248c3.\u0465.thePlayer == null) return;
                                        oc47f1ce248c3 = this;
                                    }
                                    if (n2 != 0) break block24;
                                    if (oc47f1ce248c3.\u0465.gameSettings != null) break block25;
                                    return;
                                }
                                oc47f1ce248c3 = this;
                            }
                            n = oc7ab2161b9f.\u0576(oc47f1ce248c3.\u0465.gameSettings.keyBindSneak);
                            if (n2 != 0) break block26;
                            if (n == 0) break block27;
                            this.\u00ea = this.\u0465.thePlayer.getPosition().getY();
                            return;
                        }
                        n = oc58525a33892.\u0463.getY();
                    }
                    d2 = n;
                    oc47f1ce248c2 = this;
                    if (n2 != 0) break block28;
                    if (!oc47f1ce248c2.\u0460.\u01ed()) break block29;
                    d = this.\u00ea;
                    break block30;
                }
                oc47f1ce248c2 = this;
            }
            d = oc47f1ce248c2.\u0465.thePlayer.posY;
        }
        if (!(d2 < d)) return;
        oc58525a33892.\u0173 = \u044b.offset(oc58525a33892.\u0463.getX(), oc58525a33892.\u0463.getY(), oc58525a33892.\u0463.getZ());
        return;
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
                oc47f1ce248c oc47f1ce248c2;
                int n;
                block17: {
                    oc47f1ce248c oc47f1ce248c3;
                    block15: {
                        block16: {
                            block14: {
                                n = oc47731c13e2.\u016f;
                                oc47f1ce248c3 = this;
                                if (n != 0) break block14;
                                if (oc47f1ce248c3.\u0465 == null) return;
                                oc47f1ce248c3 = this;
                            }
                            if (n != 0) break block15;
                            if (oc47f1ce248c3.\u0465.thePlayer != null) break block16;
                            return;
                        }
                        oc47f1ce248c3 = this;
                    }
                    PlayerCapabilities playerCapabilities = oc47f1ce248c3.\u0465.thePlayer.capabilities;
                    oc47f1ce248c2 = this;
                    if (n != 0) break block17;
                    if (!oc47f1ce248c2.\u0465.thePlayer.capabilities.allowFlying) break block18;
                    oc47f1ce248c2 = this;
                }
                bl = oc47f1ce248c2.\u01f1;
                if (n != 0) break block19;
                if (!bl) break block18;
                bl = true;
                break block19;
            }
            bl = false;
        }
        playerCapabilities.isFlying = bl;
        this.\u01f1 = false;
    }
}

