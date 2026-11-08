/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc84f20a0bc5;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.oce4cea752dd;

public class ocb754f4cbfb
extends oc69da1aa7f5 {
    private oca9cc61aada \u02a7;
    public oca9cc61aada \u03f1;
    private occ2f8dff8d8 \u018e;
    private occ2f8dff8d8 \u02a9;
    private int x;
    public static boolean \u01dd;

    public ocb754f4cbfb() {
        super("FastMine", oce4cea752dd.\u0437);
        this.\u0105("Allows you to mine blocks faster than vanilla.");
        this.\u02a7 = new oca9cc61aada("Break delay", "ms", 250.0, 0.0, 250.0, 50.0);
        this.\u028c(this.\u02a7);
        this.\u03f1 = new oca9cc61aada("Break speed", "x", 1.0, 1.0, 2.0, 0.02);
        this.\u028c(this.\u03f1);
        this.\u018e = new occ2f8dff8d8("Disable in creative", true);
        this.\u028c(this.\u018e);
        this.\u02a9 = new occ2f8dff8d8("Decrease break delay", false);
        this.\u028c(this.\u02a9);
        this.\u026e = true;
    }

    public float \u0579() {
        float f;
        block24: {
            block25: {
                ocb754f4cbfb ocb754f4cbfb2;
                int n;
                block21: {
                    block22: {
                        Minecraft minecraft;
                        block23: {
                            block19: {
                                block20: {
                                    n = oc84f20a0bc5.\u0117;
                                    ocb754f4cbfb2 = this;
                                    if (n != 0) break block19;
                                    if (ocb754f4cbfb2.z$3rzb3dil7uydr()) break block20;
                                    return 1.0f;
                                }
                                ocb754f4cbfb2 = this;
                            }
                            if (n != 0) break block21;
                            if (!ocb754f4cbfb2.\u018e.\u01ed()) break block22;
                            minecraft = oc69da1aa7f5.\u0151;
                            if (n != 0) break block23;
                            if (minecraft.thePlayer == null) break block22;
                            minecraft = oc69da1aa7f5.\u0151;
                        }
                        if (minecraft.thePlayer.capabilities.isCreativeMode) {
                            return 1.0f;
                        }
                    }
                    ocb754f4cbfb2 = this;
                }
                float f2 = (float)ocb754f4cbfb2.\u03f1.\u04c1();
                f = f2;
                if (n != 0) break block24;
                if (!(f > 1.0f)) break block25;
                f = f2;
                break block24;
            }
            f = 1.0f;
        }
        return f;
    }

    public boolean \u016d() {
        boolean bl;
        block11: {
            block9: {
                int n;
                block10: {
                    ocb754f4cbfb ocb754f4cbfb2;
                    block8: {
                        n = oc84f20a0bc5.\u0117;
                        ocb754f4cbfb2 = this;
                        if (n != 0) break block8;
                        if (!ocb754f4cbfb2.z$3rzb3dil7uydr()) break block9;
                        ocb754f4cbfb2 = this;
                    }
                    bl = ocb754f4cbfb2.\u02a9.\u01ed();
                    if (n != 0) break block10;
                    if (!bl) break block9;
                    bl = oc7ab2161b9f.\u00d0();
                }
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public void \u0134(Minecraft minecraft) {
        block15: {
            int n;
            block16: {
                Minecraft minecraft2;
                int n2;
                block13: {
                    block14: {
                        block12: {
                            n2 = oc84f20a0bc5.\u0117;
                            if (!this.\u016d()) break block12;
                            minecraft2 = minecraft;
                            if (n2 != 0) break block13;
                            if (minecraft2.playerController != null) break block14;
                        }
                        return;
                    }
                    minecraft2 = minecraft;
                }
                PlayerControllerMP playerControllerMP = minecraft2.playerController;
                n = playerControllerMP.getBlockHitDelay();
                if (n2 != 0) break block15;
                if (n <= 0) break block16;
                if (n != this.x) break block16;
                playerControllerMP.setBlockHitDelay(n - 1);
            }
            this.x = n;
        }
    }

    public int \u0129() {
        int n;
        block34: {
            int n2;
            block35: {
                int n3;
                int n4;
                block33: {
                    ocb754f4cbfb ocb754f4cbfb2;
                    block30: {
                        block31: {
                            Minecraft minecraft;
                            block32: {
                                boolean bl;
                                block28: {
                                    block29: {
                                        int n5;
                                        block26: {
                                            block27: {
                                                n4 = oc84f20a0bc5.\u0117;
                                                n5 = this.z$3rzb3dil7uydr();
                                                if (n4 != 0) break block26;
                                                if (n5 == 0) break block27;
                                                n5 = oc7ab2161b9f.\u00d0() ? '\u0001' : '\u0000';
                                                if (n4 != 0) break block26;
                                                if (n5 == 0) break block27;
                                                bl = oc69da1aa7f5.\u0151.inGameHasFocus;
                                                if (n4 != 0) break block28;
                                                if (bl) break block29;
                                            }
                                            n5 = -1;
                                        }
                                        return n5;
                                    }
                                    ocb754f4cbfb2 = this;
                                    if (n4 != 0) break block30;
                                    bl = ocb754f4cbfb2.\u018e.\u01ed();
                                }
                                if (!bl) break block31;
                                minecraft = oc69da1aa7f5.\u0151;
                                if (n4 != 0) break block32;
                                if (minecraft.thePlayer == null) break block31;
                                minecraft = oc69da1aa7f5.\u0151;
                            }
                            n3 = minecraft.thePlayer.capabilities.isCreativeMode ? '\u0001' : '\u0000';
                            if (n4 != 0) break block33;
                            if (n3 == 0) break block31;
                            return -1;
                        }
                        ocb754f4cbfb2 = this;
                    }
                    n3 = (int)(ocb754f4cbfb2.\u02a7.\u04c1() / 50.0);
                }
                n2 = n3;
                n = n2;
                if (n4 != 0) break block34;
                if (n < (0xF001C857 ^ 0xF001C852)) break block35;
                return -1;
            }
            n = n2;
        }
        return n;
    }

    @Override
    public String getInfo() {
        Object object;
        block6: {
            double d;
            block4: {
                block5: {
                    int n = oc84f20a0bc5.\u0117;
                    d = this.\u03f1.\u04c1();
                    if (n != 0) break block4;
                    if ((double)((int)d) != this.\u03f1.\u04c1()) break block5;
                    object = "" + (int)this.\u03f1.\u04c1();
                    break block6;
                }
                d = this.\u03f1.\u04c1();
            }
            object = d;
        }
        return String.valueOf(object) + this.\u03f1.\u011c();
    }
}

