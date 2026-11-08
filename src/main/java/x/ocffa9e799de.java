/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import x.oc75d51ec7eb;
import x.ocda171fe5d8;

public class ocffa9e799de
implements ocda171fe5d8 {
    public static int \u03a8;

    private ocffa9e799de() {
    }

    public static Vec3 \u047e(Entity entity) {
        float f = entity.getCollisionBorderSize();
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().expand(f, f, f);
        Vec3 vec3 = ocda171fe5d8.\u01d4.thePlayer.getPositionEyes(1.0f);
        if (axisAlignedBB.isVecInside(vec3)) {
            return vec3;
        }
        return new Vec3(MathHelper.clamp_double(vec3.xCoord, axisAlignedBB.minX + 0.03, axisAlignedBB.maxX - 0.03), MathHelper.clamp_double(vec3.yCoord, axisAlignedBB.minY + 0.03, axisAlignedBB.maxY - 0.03), MathHelper.clamp_double(vec3.zCoord, axisAlignedBB.minZ + 0.03, axisAlignedBB.maxZ - 0.03));
    }

    public static Vec3 \u028a(Entity entity) {
        int n;
        Vec3 vec3;
        block14: {
            Vec3 vec32;
            block13: {
                vec3 = ocda171fe5d8.\u01d4.thePlayer.getPositionEyes(1.0f);
                Vec3 vec33 = ocffa9e799de.\u047e(entity);
                n = oc75d51ec7eb.\u03e9;
                vec32 = vec3;
                if (n != 0) break block13;
                if (!ocffa9e799de.\u01ca(vec32, vec33)) break block14;
                vec32 = vec33;
            }
            return vec32;
        }
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        double[] dArray = new double[0xB2E314C8 ^ 0xB2E314CC];
        dArray[0] = 0.9;
        dArray[1] = 0.65;
        dArray[0xB2E314CE ^ 0xB2E314CC] = 0.4;
        dArray[0xB2E314CF ^ 0xB2E314CC] = 0.15;
        for (double d : dArray) {
            double[] dArray2 = new double[0xB2E314CF ^ 0xB2E314CC];
            dArray2[0] = 0.5;
            dArray2[1] = 0.1;
            double[] dArray3 = dArray2;
            double[] dArray4 = dArray2;
            int n2 = 0xB2E314CE ^ 0xB2E314CC;
            double d2 = 0.9;
            block9: while (true) {
                double[] dArray5;
                dArray3[n2] = d2;
                double[] dArray6 = dArray5 = dArray4;
                block10: while (true) {
                    int n3 = dArray6.length;
                    for (int i = 0; i < n3; ++i) {
                        double d3 = dArray5[i];
                        double[] dArray7 = new double[0xB2E314CF ^ 0xB2E314CC];
                        dArray7[0] = 0.5;
                        dArray3 = dArray7;
                        dArray4 = dArray7;
                        n2 = 1;
                        d2 = 0.1;
                        if (n != 0) continue block9;
                        dArray3[n2] = d2;
                        dArray4[0xB2E314CE ^ 0xB2E314CC] = 0.9;
                        double[] dArray8 = dArray4;
                        int n4 = dArray8.length;
                        int n5 = 0;
                        while (n5 < n4) {
                            block15: {
                                block16: {
                                    dArray6 = dArray8;
                                    if (n != 0) continue block10;
                                    double d4 = dArray6[n5];
                                    Vec3 vec34 = new Vec3(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d3, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d4);
                                    if (n != 0) break block15;
                                    if (!ocffa9e799de.\u01ca(vec3, vec34)) break block16;
                                    return vec34;
                                }
                                ++n5;
                            }
                            if (n == 0) continue;
                        }
                        if (n == 0) continue;
                    }
                    break;
                }
                break;
            }
            if (n == 0) continue;
        }
        return null;
    }

    public static float[] \u00d0(Entity entity, Vec3 vec3) {
        Vec3 vec32;
        block10: {
            Vec3 vec33;
            block11: {
                Vec3 vec34;
                int n;
                Vec3 vec35;
                block8: {
                    block9: {
                        vec35 = ocda171fe5d8.\u01d4.thePlayer.getPositionEyes(1.0f);
                        n = oc75d51ec7eb.\u03e9;
                        vec34 = vec3;
                        if (n != 0) break block8;
                        if (vec34 != null) break block9;
                        vec34 = ocffa9e799de.\u047e(entity);
                        break block8;
                    }
                    vec34 = vec3;
                }
                vec33 = vec34;
                vec32 = vec35;
                if (n != 0) break block10;
                if (!(vec32.squareDistanceTo(vec33) < 1.0E-8)) break block11;
                float[] fArray = new float[0x6DA6BAEC ^ 0x6DA6BAEE];
                fArray[0] = ocda171fe5d8.\u01d4.thePlayer.rotationYaw;
                fArray[1] = ocda171fe5d8.\u01d4.thePlayer.rotationPitch;
                return fArray;
            }
            vec32 = vec33;
        }
        return oc75d51ec7eb.\u046c(vec32);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static MovingObjectPosition \u01db(Entity entity, float f, float f2, double d) {
        MovingObjectPosition movingObjectPosition;
        AxisAlignedBB axisAlignedBB;
        Vec3 vec3;
        Vec3 vec32;
        block20: {
            AxisAlignedBB axisAlignedBB2;
            block21: {
                Minecraft minecraft;
                int n;
                block18: {
                    block19: {
                        int n2;
                        block17: {
                            Entity entity2;
                            block16: {
                                n = oc75d51ec7eb.\u03e9;
                                entity2 = entity;
                                if (n != 0) break block16;
                                if (entity2 == null) return null;
                                entity2 = entity;
                            }
                            n2 = entity2.canBeCollidedWith();
                            if (n != 0) break block17;
                            if (n2 == 0) return null;
                            double d2 = d - 0.0;
                            n2 = d2 == 0.0 ? 0 : (d2 < 0.0 ? -1 : 1);
                        }
                        if (n2 <= 0) return null;
                        minecraft = ocda171fe5d8.\u01d4;
                        if (n != 0) break block18;
                        if (minecraft.thePlayer != null) break block19;
                        return null;
                    }
                    minecraft = ocda171fe5d8.\u01d4;
                }
                vec32 = minecraft.thePlayer.getPositionEyes(1.0f);
                Vec3 vec33 = oc75d51ec7eb.\u010f(f2, f);
                vec3 = vec32.addVector(vec33.xCoord * d, vec33.yCoord * d, vec33.zCoord * d);
                float f3 = entity.getCollisionBorderSize();
                axisAlignedBB2 = entity.getEntityBoundingBox().expand(f3, f3, f3);
                axisAlignedBB = axisAlignedBB2;
                if (n != 0) break block20;
                if (!axisAlignedBB.isVecInside(vec32)) break block21;
                movingObjectPosition = new MovingObjectPosition(entity, vec32);
                return movingObjectPosition;
            }
            axisAlignedBB = axisAlignedBB2;
        }
        movingObjectPosition = axisAlignedBB.calculateIntercept(vec32, vec3);
        return movingObjectPosition;
    }

    public static boolean \u0433(Entity entity, double d) {
        float[] fArray = ocffa9e799de.\u00d0(entity, null);
        boolean bl = ocffa9e799de.\u01db(entity, fArray[0], fArray[1], d) != null;
        return bl;
    }

    public static boolean \u01ca(Vec3 vec3, Vec3 vec32) {
        boolean bl = ocda171fe5d8.\u01d4.theWorld.rayTraceBlocks(vec3, vec32, false, true, false) == null;
        return bl;
    }
}

