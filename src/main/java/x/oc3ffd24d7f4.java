/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.entity.EntityPlayerSP;
import x.K;
import x.oc25aa89b91f;
import x.oc7ab2161b9f;
import x.ocbb69a39dee;
import x.occ2f8dff8d8;

public class oc3ffd24d7f4
extends ocbb69a39dee {
    private final occ2f8dff8d8 \u0524 = new occ2f8dff8d8("Only forward", false);
    private final occ2f8dff8d8 \u021a;
    public static int \u0377;

    public oc3ffd24d7f4(K k) {
        super("Legit", k);
        this.\u04f4(this.\u0524);
        this.\u021a = new occ2f8dff8d8("Only strafe", false);
        this.\u04f4(this.\u021a);
    }

    @Override
    public void z$3p2wgqhd145z0() {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    boolean bl2 = this.A.\u0440("Legit");
                    this.\u0524.\u0209(bl2, this.A);
                    this.\u021a.\u0209(bl2, this.A);
                    boolean bl3 = ocbb69a39dee.\u0410;
                    if (!false) break block4;
                    if (!bl3) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            ocbb69a39dee.\u0410 = bl;
        }
    }

    @Override
    public void z$232m1q68rrkqe(oc25aa89b91f oc25aa89b91f2) {
        oc3ffd24d7f4 oc3ffd24d7f42;
        block31: {
            block32: {
                block25: {
                    int n;
                    block30: {
                        boolean bl;
                        block28: {
                            block29: {
                                EntityPlayerSP entityPlayerSP;
                                block27: {
                                    oc3ffd24d7f4 oc3ffd24d7f43;
                                    block26: {
                                        double d;
                                        block24: {
                                            bl = ocbb69a39dee.\u0410;
                                            double d2 = oc7ab2161b9f.\u0159() - 0.0;
                                            d = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                                            if (bl) break block24;
                                            if (d == false) break block25;
                                            oc3ffd24d7f43 = this;
                                            if (bl) break block26;
                                            d = (double)oc3ffd24d7f43.\u0151.thePlayer.onGround;
                                        }
                                        if (d == false) break block25;
                                        oc3ffd24d7f43 = this;
                                    }
                                    entityPlayerSP = oc3ffd24d7f43.\u0151.thePlayer;
                                    if (bl) break block27;
                                    if (entityPlayerSP.capabilities.isFlying) break block25;
                                    entityPlayerSP = this.\u0151.thePlayer;
                                }
                                n = entityPlayerSP.hurtTime;
                                if (bl) break block28;
                                if (n != this.\u0151.thePlayer.maxHurtTime) break block29;
                                n = this.\u0151.thePlayer.maxHurtTime;
                                if (bl) break block28;
                                if (n > 0) break block25;
                            }
                            n = oc7ab2161b9f.\u0183() ? 1 : 0;
                        }
                        if (bl) break block30;
                        if (n != 0) break block25;
                        oc3ffd24d7f42 = this;
                        if (bl) break block31;
                        n = oc3ffd24d7f42.\u045d() ? 1 : 0;
                    }
                    if (n != 0) break block32;
                }
                return;
            }
            oc3ffd24d7f42 = this;
        }
        oc3ffd24d7f42.\u0151.thePlayer.jump();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean \u045d() {
        boolean bl = ocbb69a39dee.\u0410;
        int n = 0xDFDA490B ^ 0x28C60C14;
        block13: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case 1628695229: {
                    int n2 = this.\u021a.\u01ed();
                    if (!bl) {
                        if (n2 != 0) {
                            n = 0x6363198B ^ 0x28C60C14;
                            if (!bl) continue block13;
                        }
                        n2 = 0x278F39D9 ^ 0x28C60C14;
                    }
                    n = n2;
                    if (!bl) continue block13;
                }
                case -378274978: {
                    return false;
                }
                case -149142241: {
                    int n3 = this.\u0524.\u01ed();
                    if (!bl) {
                        if (n3 != 0) {
                            n = 0xBED42C5E ^ 0x28C60C14;
                            if (!bl) continue block13;
                        }
                        n3 = 0x49D5E6A9 ^ 0x28C60C14;
                    }
                    n = n3;
                    if (!bl) continue block13;
                }
                case 1293890264: {
                    return false;
                }
                case -1777196982: {
                    int n4 = oc7ab2161b9f.\u0576(this.\u0151.gameSettings.keyBindForward);
                    if (!bl) {
                        if (n4 == 0) {
                            n = 0x65D93ECC ^ 0x28C60C14;
                            if (!bl) continue block13;
                        }
                        n4 = 0x49D5E6A9 ^ 0x28C60C14;
                    }
                    n = n4;
                    if (!bl) continue block13;
                }
                case 256456141: {
                    return true;
                }
                case 1269110175: 
            }
            float f = this.\u0151.thePlayer.moveStrafing - 0.0f;
            float f2 = f == 0.0f ? 0 : (f > 0.0f ? 1 : -1);
            if (!bl) {
                if (f2 != false) {
                    n = 0x278F39D9 ^ 0x28C60C14;
                    if (!bl) continue;
                }
                f2 = 0xC1B5F74A ^ 0x28C60C14;
            }
            n = (int)f2;
        }
    }
}

