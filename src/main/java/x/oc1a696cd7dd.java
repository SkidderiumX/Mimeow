/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovementInput;
import x.oc75d51ec7eb;
import x.oc865980c948;
import x.oce673b272fb;

public class oc1a696cd7dd {
    private static final double \u028c = 0.08;
    private static final double \u028b = 0.98;
    public static boolean \u0551;

    private oc1a696cd7dd() {
    }

    public static AxisAlignedBB \u0263(EntityLivingBase entityLivingBase, int n) {
        oce673b272fb[] oce673b272fbArray = oc1a696cd7dd.\u04df(entityLivingBase, n);
        return oce673b272fbArray[oce673b272fbArray.length - 1].\u011a();
    }

    public static AxisAlignedBB[] \u021b(EntityLivingBase entityLivingBase, int n) {
        AxisAlignedBB[] axisAlignedBBArray;
        block4: {
            oce673b272fb[] oce673b272fbArray = oc1a696cd7dd.\u04df(entityLivingBase, n);
            AxisAlignedBB[] axisAlignedBBArray2 = new AxisAlignedBB[oce673b272fbArray.length];
            int n2 = oc75d51ec7eb.\u03e9;
            for (int i = 0; i < oce673b272fbArray.length; ++i) {
                axisAlignedBBArray = axisAlignedBBArray2;
                if (n2 == 0) {
                    axisAlignedBBArray[i] = oce673b272fbArray[i].\u011a();
                    if (n2 == 0) continue;
                    break;
                }
                break block4;
            }
            axisAlignedBBArray = axisAlignedBBArray2;
        }
        return axisAlignedBBArray;
    }

    public static oce673b272fb[] \u04df(EntityLivingBase entityLivingBase, int n) {
        return oc1a696cd7dd.\u0298(entityLivingBase, n, 1.0);
    }

    public static oce673b272fb[] \u0298(EntityLivingBase entityLivingBase, int n, double d) {
        oce673b272fb[] oce673b272fbArray;
        block21: {
            EntityPlayerSP entityPlayerSP;
            int n2;
            int n3;
            block18: {
                block19: {
                    oce673b272fb[] oce673b272fbArray2;
                    block20: {
                        EntityLivingBase entityLivingBase2;
                        block16: {
                            block17: {
                                n3 = Math.max(0, n);
                                n2 = oc75d51ec7eb.\u03e9;
                                entityLivingBase2 = entityLivingBase;
                                if (n2 != 0) break block16;
                                if (!(entityLivingBase2 instanceof EntityPlayerSP)) break block17;
                                entityPlayerSP = Minecraft.getMinecraft().thePlayer;
                                if (n2 != 0) break block18;
                                if (entityPlayerSP == entityLivingBase) break block19;
                            }
                            entityLivingBase2 = entityLivingBase;
                        }
                        oce673b272fb oce673b272fb2 = oc1a696cd7dd.\u00fd(entityLivingBase2);
                        oce673b272fb[] oce673b272fbArray3 = new oce673b272fb[n3 + 1];
                        for (int i = 0; i < oce673b272fbArray3.length; ++i) {
                            oce673b272fbArray2 = oce673b272fbArray3;
                            if (n2 == 0) {
                                oce673b272fbArray2[i] = oce673b272fb2;
                                if (n2 == 0) continue;
                                break;
                            }
                            break block20;
                        }
                        oce673b272fbArray2 = oce673b272fbArray3;
                    }
                    return oce673b272fbArray2;
                }
                entityPlayerSP = (EntityPlayerSP)entityLivingBase;
            }
            EntityPlayerSP entityPlayerSP2 = entityPlayerSP;
            MovementInput movementInput = new MovementInput();
            movementInput.moveForward = entityPlayerSP2.movementInput.moveForward * (float)d;
            movementInput.moveStrafe = entityPlayerSP2.movementInput.moveStrafe * (float)d;
            movementInput.jump = entityPlayerSP2.movementInput.jump;
            movementInput.sneak = entityPlayerSP2.movementInput.sneak;
            oc865980c948 oc865980c9482 = oc865980c948.\u02a2(movementInput);
            oc865980c9482.\u03bc = entityPlayerSP2.posX - entityPlayerSP2.prevPosX;
            oc865980c9482.\u0544 = (entityPlayerSP2.posY - entityPlayerSP2.prevPosY - 0.08) * 0.98;
            oc865980c9482.\u03c4 = entityPlayerSP2.posZ - entityPlayerSP2.prevPosZ;
            oce673b272fb[] oce673b272fbArray4 = new oce673b272fb[n3 + 1];
            oce673b272fbArray4[0] = oc1a696cd7dd.p(oc865980c9482);
            for (int i = 0; i < n3; ++i) {
                oc865980c9482.\u01eb();
                oce673b272fbArray = oce673b272fbArray4;
                if (n2 == 0) {
                    oce673b272fbArray[i + 1] = oc1a696cd7dd.p(oc865980c9482);
                    if (n2 == 0) continue;
                    break;
                }
                break block21;
            }
            oce673b272fbArray = oce673b272fbArray4;
        }
        return oce673b272fbArray;
    }

    private static oce673b272fb p(oc865980c948 oc865980c9482) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        double d;
        double d2;
        double d3;
        oce673b272fb oce673b272fb2;
        oce673b272fb oce673b272fb3;
        block3: {
            block2: {
                oce673b272fb oce673b272fb4;
                boolean bl5 = oc865980c9482.\u04b8();
                boolean bl6 = oc865980c9482.\u01e1;
                oce673b272fb3 = oce673b272fb4;
                oce673b272fb2 = oce673b272fb4;
                d3 = oc865980c9482.\u03bc;
                d2 = oc865980c9482.\u0544;
                d = oc865980c9482.\u03c4;
                bl4 = oc865980c9482.\u04d5;
                bl3 = bl6;
                bl2 = bl5;
                if (!bl6 && !bl5) break block2;
                bl = true;
                break block3;
            }
            bl = false;
        }
        oce673b272fb3(d3, d2, d, bl4, bl3, bl2, bl, oc865980c9482.\u03b0(), oc865980c9482.\u00e2(), oc865980c9482.\u0423);
        return oce673b272fb2;
    }

    private static oce673b272fb \u00fd(EntityLivingBase entityLivingBase) {
        return new oce673b272fb(entityLivingBase.motionX, entityLivingBase.motionY, entityLivingBase.motionZ, entityLivingBase.onGround, entityLivingBase.isCollidedHorizontally, entityLivingBase.isCollidedVertically, entityLivingBase.isCollided, entityLivingBase.isInWater(), entityLivingBase.isInLava(), entityLivingBase.getEntityBoundingBox());
    }
}

