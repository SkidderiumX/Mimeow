/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import x.oc70db705765;
import x.oc75d51ec7eb;
import x.ocda171fe5d8;

public class ocb15e077143
implements ocda171fe5d8 {
    private static final float[] \u00eb;
    private static final float[] \u0118;
    public static boolean \u0505;

    private ocb15e077143() {
    }

    public static boolean \u024e() {
        boolean bl;
        block8: {
            block10: {
                block9: {
                    int n = oc75d51ec7eb.\u03e9;
                    bl = ocda171fe5d8.\u01d4.gameSettings.keyBindForward.isKeyDown();
                    if (n != 0) break block8;
                    if (bl != ocda171fe5d8.\u01d4.gameSettings.keyBindBack.isKeyDown()) break block9;
                    bl = ocda171fe5d8.\u01d4.gameSettings.keyBindLeft.isKeyDown();
                    if (n != 0) break block8;
                    if (bl == ocda171fe5d8.\u01d4.gameSettings.keyBindRight.isKeyDown()) break block10;
                }
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static void \u0576(oc70db705765 oc70db7057652, float f) {
        int n;
        int n2;
        int n3;
        block14: {
            block15: {
                int n4;
                block12: {
                    block13: {
                        int n5;
                        int n6;
                        block10: {
                            block11: {
                                block8: {
                                    block9: {
                                        n4 = oc75d51ec7eb.\u03e9;
                                        n6 = ocda171fe5d8.\u01d4.gameSettings.keyBindForward.isKeyDown();
                                        if (n4 != 0) break block8;
                                        if (n6 == 0) break block9;
                                        n6 = 1;
                                        break block8;
                                    }
                                    n6 = 0;
                                }
                                n5 = ocda171fe5d8.\u01d4.gameSettings.keyBindBack.isKeyDown();
                                if (n4 != 0) break block10;
                                if (n5 == 0) break block11;
                                n5 = 1;
                                break block10;
                            }
                            n5 = 0;
                        }
                        n3 = n6 - n5;
                        n2 = ocda171fe5d8.\u01d4.gameSettings.keyBindLeft.isKeyDown();
                        if (n4 != 0) break block12;
                        if (n2 == 0) break block13;
                        n2 = 1;
                        break block12;
                    }
                    n2 = 0;
                }
                n = ocda171fe5d8.\u01d4.gameSettings.keyBindRight.isKeyDown();
                if (n4 != 0) break block14;
                if (n == 0) break block15;
                n = 1;
                break block14;
            }
            n = 0;
        }
        int n7 = n2 - n;
        float f2 = ocb15e077143.\u04f4(ocda171fe5d8.\u01d4.thePlayer.rotationYaw, n3, n7);
        float f3 = MathHelper.wrapAngleTo180_float(f2 - f + 22.5f);
        int n8 = (int)(f3 + 180.0f) / (0xF6294318 ^ 0xF6294335) % (0xF629433D ^ 0xF6294335);
        oc70db7057652.\u010f(\u00eb[n8]);
        oc70db7057652.\u0524(\u0118[n8]);
    }

    public static float \u04f4(float f, float f2, float f3) {
        float f4;
        block12: {
            block13: {
                float f5;
                block16: {
                    float f6;
                    block14: {
                        block15: {
                            int n;
                            block10: {
                                block11: {
                                    n = oc75d51ec7eb.\u03e9;
                                    f4 = f2;
                                    if (n != 0) break block10;
                                    if (!(f4 < 0.0f)) break block11;
                                    f += 180.0f;
                                }
                                f4 = f3;
                            }
                            if (n != 0) break block12;
                            if (f4 == 0.0f) break block13;
                            f6 = f2;
                            if (n != 0) break block14;
                            if (f6 != 0.0f) break block15;
                            f5 = 1.0f;
                            break block16;
                        }
                        f6 = 0.5f;
                    }
                    f5 = f6 * Math.signum(f2);
                }
                float f7 = f5;
                f += -90.0f * f7 * Math.signum(f3);
            }
            f4 = MathHelper.wrapAngleTo180_float(f);
        }
        return f4;
    }

    public static int \u0458() {
        int n;
        block9: {
            Minecraft minecraft;
            int n2;
            int n3;
            block7: {
                block8: {
                    n3 = 0;
                    n2 = oc75d51ec7eb.\u03e9;
                    minecraft = ocda171fe5d8.\u01d4;
                    if (n2 != 0) break block7;
                    if (!minecraft.gameSettings.keyBindForward.isKeyDown()) break block8;
                    ++n3;
                }
                minecraft = ocda171fe5d8.\u01d4;
            }
            n = minecraft.gameSettings.keyBindBack.isKeyDown();
            if (n2 != 0) break block9;
            if (n != 0) {
                // empty if block
            }
            n = --n3;
        }
        return n;
    }

    public static int \u019a() {
        int n;
        block9: {
            GameSettings gameSettings;
            int n2;
            int n3;
            block7: {
                block8: {
                    n3 = 0;
                    n2 = oc75d51ec7eb.\u03e9;
                    gameSettings = ocda171fe5d8.\u01d4.gameSettings;
                    if (n2 != 0) break block7;
                    if (!gameSettings.keyBindLeft.isKeyDown()) break block8;
                    ++n3;
                }
                gameSettings = ocda171fe5d8.\u01d4.gameSettings;
            }
            n = gameSettings.keyBindRight.isKeyDown();
            if (n2 != 0) break block9;
            if (n != 0) {
                // empty if block
            }
            n = --n3;
        }
        return n;
    }

    public static float \u0470() {
        float f = ocda171fe5d8.\u01d4.thePlayer.worldObj.getBlockState((BlockPos)new BlockPos((int)MathHelper.floor_double((double)ocda171fe5d8.\u01d4.thePlayer.posX), (int)(MathHelper.floor_double((double)ocda171fe5d8.\u01d4.thePlayer.getEntityBoundingBox().minY) - 1), (int)MathHelper.floor_double((double)ocda171fe5d8.\u01d4.thePlayer.posZ))).getBlock().slipperiness * 0.91f;
        return ocda171fe5d8.\u01d4.thePlayer.getAIMoveSpeed() * (0.16277136f / (f * f * f));
    }

    public static double[] \u00f3() {
        float f;
        float f2;
        float f3;
        float f4;
        block8: {
            block9: {
                int n;
                block6: {
                    block7: {
                        f4 = (float)ocb15e077143.\u019a() * 0.98f;
                        f3 = (float)ocb15e077143.\u0458() * 0.98f;
                        f2 = f4 * f4 + f3 * f3;
                        n = oc75d51ec7eb.\u03e9;
                        f = f2;
                        if (n != 0) break block6;
                        if (!(f < 1.0E-4f)) break block7;
                        double[] dArray = new double[0xED5E16E4 ^ 0xED5E16E6];
                        dArray[0] = 0.0;
                        dArray[1] = 0.0;
                        return dArray;
                    }
                    f = f2 = MathHelper.sqrt_float(f2);
                }
                if (n != 0) break block8;
                if (!(f < 1.0f)) break block9;
                f2 = 1.0f;
            }
            f2 = ocb15e077143.\u0470() / f2;
            f = MathHelper.sin(ocda171fe5d8.\u01d4.thePlayer.rotationYaw * (float)Math.PI / 180.0f);
        }
        float f5 = f;
        float f6 = MathHelper.cos(ocda171fe5d8.\u01d4.thePlayer.rotationYaw * (float)Math.PI / 180.0f);
        double[] dArray = new double[0xED5E16E4 ^ 0xED5E16E6];
        dArray[0] = (f4 *= f2) * f6 - (f3 *= f2) * f5;
        dArray[1] = f3 * f6 + f4 * f5;
        return dArray;
    }

    public static boolean \u045b(AxisAlignedBB axisAlignedBB, double d) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.contract(d, 0.0, d);
        AxisAlignedBB axisAlignedBB3 = new AxisAlignedBB(axisAlignedBB2.minX, axisAlignedBB2.minY - 0.1, axisAlignedBB2.minZ, axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.maxZ);
        return ocda171fe5d8.\u01d4.theWorld.checkBlockCollision(axisAlignedBB3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int \u0519(EntityLivingBase entityLivingBase) {
        int n;
        int n2 = 0x21D14DB ^ 0x21D14D7;
        double d = entityLivingBase.posY;
        double d2 = entityLivingBase.posY - entityLivingBase.prevPosY;
        int n3 = oc75d51ec7eb.\u03e9;
        for (int i = 0; i < (0x21D14DB ^ 0x21D14D7); ++i) {
            double d3 = (d2 - 0.08) * 0.98;
            double d4 = d;
            if (n3 == 0) {
                d = d4 + d3;
                n = ocb15e077143.\u045b(entityLivingBase.getEntityBoundingBox().offset(0.0, d - entityLivingBase.posY, 0.0), 0.0) ? 1 : 0;
                if (n3 != 0) return n;
                if (n != 0) {
                    n2 = i;
                    if (n3 == 0) break;
                }
                d4 = d3;
            }
            d2 = d4;
            if (n3 == 0) continue;
        }
        n = n2;
        return n;
    }

    static {
        float[] fArray = new float[0x82EAC739 ^ 0x82EAC731];
        fArray[0] = -1.0f;
        fArray[1] = -1.0f;
        fArray[0x82EAC733 ^ 0x82EAC731] = 0.0f;
        fArray[0x82EAC732 ^ 0x82EAC731] = 1.0f;
        fArray[0x82EAC735 ^ 0x82EAC731] = 1.0f;
        fArray[0x82EAC734 ^ 0x82EAC731] = 1.0f;
        fArray[0x82EAC737 ^ 0x82EAC731] = 0.0f;
        fArray[0x82EAC736 ^ 0x82EAC731] = -1.0f;
        \u00eb = fArray;
        float[] fArray2 = new float[0x82EAC739 ^ 0x82EAC731];
        fArray2[0] = 0.0f;
        fArray2[1] = 1.0f;
        fArray2[0x82EAC733 ^ 0x82EAC731] = 1.0f;
        fArray2[0x82EAC732 ^ 0x82EAC731] = 1.0f;
        fArray2[0x82EAC735 ^ 0x82EAC731] = 0.0f;
        fArray2[0x82EAC734 ^ 0x82EAC731] = -1.0f;
        fArray2[0x82EAC737 ^ 0x82EAC731] = -1.0f;
        fArray2[0x82EAC736 ^ 0x82EAC731] = -1.0f;
        \u0118 = fArray2;
    }
}

