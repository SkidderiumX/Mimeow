/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Timer;
import x.oc30e402796f;
import x.oc5d43ea95a2;
import x.oc6111f05032;
import x.oc75d51ec7eb;
import x.oca6eae151db;
import x.ocbd3640d420;

public class oca59cf41fac {
    private final ocbd3640d420 \u0434 = ocbd3640d420.L;
    private int \u0466;
    private boolean \u03ee;
    private boolean \u0587;
    private boolean \u0523;
    private double \u01a3;
    public static boolean \u03bf;

    public void \u03e5(oc6111f05032 oc6111f050322, float f, boolean bl, boolean bl2) {
        boolean bl3;
        block61: {
            block57: {
                MovingObjectPosition movingObjectPosition;
                block60: {
                    EntityPlayerSP entityPlayerSP;
                    MovingObjectPosition movingObjectPosition2;
                    int n;
                    block59: {
                        oc6111f05032 oc6111f050323;
                        block58: {
                            int n2;
                            block56: {
                                oc6111f05032 oc6111f050324;
                                int n3;
                                block45: {
                                    block46: {
                                        int n4;
                                        block55: {
                                            block50: {
                                                int n5;
                                                block53: {
                                                    block54: {
                                                        block51: {
                                                            block52: {
                                                                block49: {
                                                                    oca59cf41fac oca59cf41fac2;
                                                                    block47: {
                                                                        block48: {
                                                                            n3 = 0;
                                                                            n = oc75d51ec7eb.\u03e9;
                                                                            oc6111f050324 = oc6111f050322;
                                                                            if (n != 0) break block45;
                                                                            if (!oc6111f050324.\u044f()) break block46;
                                                                            oca59cf41fac2 = this;
                                                                            if (n != 0) break block47;
                                                                            if (oca59cf41fac2.\u0466 != 0) break block48;
                                                                            this.\u0466 = 0x6E815282 ^ 0x6E815288;
                                                                            this.\u03ee = oca6eae151db.\u0151.\u03ec(f);
                                                                        }
                                                                        --this.\u0466;
                                                                        oca59cf41fac2 = this;
                                                                    }
                                                                    n5 = oca59cf41fac2.\u03ee;
                                                                    if (n != 0) break block49;
                                                                    if (n5 == 0) break block50;
                                                                    n5 = bl;
                                                                }
                                                                if (n != 0) break block51;
                                                                if (n5 == 0) break block52;
                                                                n5 = oc5d43ea95a2.\u042b(oc6111f050322);
                                                                if (n != 0) break block51;
                                                                if (n5 == 0) break block50;
                                                            }
                                                            n5 = bl2;
                                                        }
                                                        if (n != 0) break block53;
                                                        if (n5 == 0) break block54;
                                                        n5 = this.\u0434.\u015a(oc6111f050322.\u016d()) ? 1 : 0;
                                                        if (n != 0) break block53;
                                                        if (n5 == 0) break block50;
                                                    }
                                                    n4 = oc6111f050322.\u016d().ticksExisted;
                                                    if (n != 0) break block55;
                                                    n5 = n4 - oc6111f050322.\u016d().getLastAttackerTime();
                                                }
                                                if (n5 >= (0x6E815283 ^ 0x6E815288)) break block50;
                                                n4 = 1;
                                                break block55;
                                            }
                                            n4 = 0;
                                        }
                                        n3 = n4;
                                    }
                                    oc6111f050324 = oc6111f050322;
                                }
                                movingObjectPosition2 = oc6111f050324.\u0128().objectMouseOver;
                                oca59cf41fac oca59cf41fac3 = this;
                                n2 = n3;
                                if (n != 0) break block56;
                                if (n2 == 0) break block57;
                                oc6111f050323 = oc6111f050322;
                                if (n != 0) break block58;
                                n2 = oc6111f050323.\u016d().onGround;
                            }
                            if (n2 != 0) break block57;
                            oc6111f050323 = oc6111f050322;
                        }
                        entityPlayerSP = oc6111f050323.\u016d();
                        if (n != 0) break block59;
                        if (entityPlayerSP.motionY >= 0.0) break block57;
                        entityPlayerSP = oc6111f050322.\u016d();
                    }
                    if (entityPlayerSP.hurtTime == (0x6E815282 ^ 0x6E815288)) break block57;
                    movingObjectPosition = movingObjectPosition2;
                    if (n != 0) break block60;
                    if (movingObjectPosition == null) break block57;
                    movingObjectPosition = movingObjectPosition2;
                }
                if (movingObjectPosition.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY) break block57;
                bl3 = true;
                break block61;
            }
            bl3 = false;
        }
        oca59cf41fac3.\u0587 = bl3;
    }

    public void \u0507(Minecraft minecraft, double d, float f, float f2) {
        block10: {
            oca59cf41fac oca59cf41fac2;
            block11: {
                block12: {
                    int n;
                    block8: {
                        block9: {
                            Timer timer = minecraft.getTimer();
                            n = oc75d51ec7eb.\u03e9;
                            oca59cf41fac2 = this;
                            if (n != 0) break block8;
                            if (!oca59cf41fac2.\u0587) break block9;
                            timer.timerSpeed = f;
                            this.\u0523 = true;
                            this.\u01a3 = oca59cf41fac.\u00cd(this.\u01a3, f, d, f2);
                            if (n == 0) break block10;
                        }
                        oca59cf41fac2 = this;
                    }
                    if (n != 0) break block11;
                    if (!(oca59cf41fac2.\u01a3 > 1.0)) break block12;
                    int n2 = oc30e402796f.\u03d2(this.\u01a3);
                    timer.elapsedPartialTicks += (float)n2;
                    this.\u01a3 -= (double)n2;
                }
                oca59cf41fac2 = this;
            }
            oca59cf41fac2.\u0538(minecraft);
        }
    }

    public static double \u00cd(double d, float f, double d2, float f2) {
        double d3;
        block4: {
            double d4;
            block5: {
                d4 = (double)(1.0f - f) * (d2 * 20.0) + d;
                int n = oc75d51ec7eb.\u03e9;
                d3 = d4;
                if (n != 0) break block4;
                if (!(d3 > (double)f2)) break block5;
                d3 = f2;
                break block4;
            }
            d3 = d4;
        }
        return d3;
    }

    public void \u0538(Minecraft minecraft) {
        block4: {
            oca59cf41fac oca59cf41fac2;
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                oca59cf41fac2 = this;
                if (n != 0) break block4;
                if (!oca59cf41fac2.\u0523) break block5;
                minecraft.getTimer().timerSpeed = 1.0f;
            }
            oca59cf41fac2 = this;
        }
        oca59cf41fac2.\u0523 = false;
    }

    public void \u049b(Minecraft minecraft) {
        this.\u0538(minecraft);
        this.\u0466 = 0;
        this.\u0587 = false;
        this.\u03ee = false;
        this.\u01a3 = 0.0;
    }
}

