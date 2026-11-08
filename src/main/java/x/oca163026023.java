/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import x.oc2e6d7f97ce;
import x.oc3e527bc66f;
import x.oc75d51ec7eb;
import x.oc94a86ee062;

public class oca163026023 {
    private static final int \u01e0 = 600;
    private static final int \u0131 = 25;
    private static final double \u02a9 = (double)0.3f;
    private static final double \u0370 = 1.0;
    private static final double \u045a = 1.0E-7;
    private static final double \u01c4 = 0.014;
    private static final double \u0199 = (double)-0.4f;
    private static final double \u03f2 = 0.001;
    private static final float \u04ee = 0.95f;
    private static final float \u054a = 0.8f;
    public static int \u054e;

    public static MovingObjectPosition \u0409(EntityPlayer entityPlayer, float f, double d) {
        MovingObjectPosition movingObjectPosition;
        block34: {
            MovingObjectPosition movingObjectPosition2;
            block28: {
                Vec3 vec3;
                double d2;
                int n;
                World world2;
                Vec3 vec32;
                Vec3 vec33;
                block27: {
                    MovingObjectPosition movingObjectPosition3;
                    block25: {
                        block26: {
                            vec33 = entityPlayer.getPositionEyes(f);
                            Vec3 vec34 = oc75d51ec7eb.\u010f(entityPlayer.rotationPitch, entityPlayer.rotationYaw);
                            vec32 = vec33.addVector(vec34.xCoord * d, vec34.yCoord * d, vec34.zCoord * d);
                            world2 = entityPlayer.worldObj;
                            movingObjectPosition2 = oca163026023.\u053b(world2, vec33, vec32, true);
                            n = oc75d51ec7eb.\u03e9;
                            double d3 = movingObjectPosition2 == null ? d * d : vec33.squareDistanceTo(movingObjectPosition2.hitVec);
                            d2 = d3;
                            movingObjectPosition3 = movingObjectPosition2;
                            if (n != 0) break block25;
                            if (movingObjectPosition3 != null) break block26;
                            vec3 = vec32;
                            break block27;
                        }
                        movingObjectPosition3 = movingObjectPosition2;
                    }
                    vec3 = movingObjectPosition3.hitVec;
                }
                Vec3 vec35 = vec3;
                AxisAlignedBB axisAlignedBB = new AxisAlignedBB(vec33.xCoord, vec33.yCoord, vec33.zCoord, vec33.xCoord, vec33.yCoord, vec33.zCoord).addCoord(vec35.xCoord - vec33.xCoord, vec35.yCoord - vec33.yCoord, vec35.zCoord - vec33.zCoord).expand(1.0, 1.0, 1.0);
                for (Entity entity : world2.getEntitiesWithinAABBExcludingEntity(entityPlayer, axisAlignedBB)) {
                    block33: {
                        Entity entity2;
                        block30: {
                            block31: {
                                block29: {
                                    if (n != 0) break block28;
                                    entity2 = entity;
                                    if (n != 0) break block29;
                                    if (!entity2.canBeCollidedWith()) continue;
                                    entity2 = entity;
                                }
                                if (n != 0) break block30;
                                if (!entity2.isDead) break block31;
                                if (n == 0) continue;
                            }
                            entity2 = entity;
                        }
                        AxisAlignedBB axisAlignedBB2 = entity2.getEntityBoundingBox().expand(0.3f, 0.3f, 0.3f);
                        MovingObjectPosition movingObjectPosition4 = axisAlignedBB2.calculateIntercept(vec33, vec35);
                        if (axisAlignedBB2.isVecInside(vec33)) {
                            movingObjectPosition4 = new MovingObjectPosition(entity, vec33);
                        }
                        if (movingObjectPosition4 != null) {
                            double d4;
                            block32: {
                                double d5 = vec33.squareDistanceTo(movingObjectPosition4.hitVec);
                                d4 = d5;
                                if (n != 0) break block32;
                                if (!(d4 + 1.0E-7 < d2)) break block33;
                                d4 = d5;
                            }
                            d2 = d4;
                            movingObjectPosition2 = new MovingObjectPosition(entity, movingObjectPosition4.hitVec);
                        }
                    }
                    if (n == 0) continue;
                }
                movingObjectPosition = movingObjectPosition2;
                if (n != 0) break block34;
                if (movingObjectPosition != null) break block28;
                movingObjectPosition = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, vec32, null, new BlockPos(vec32));
                break block34;
            }
            movingObjectPosition = movingObjectPosition2;
        }
        return movingObjectPosition;
    }

    public static oc94a86ee062 \u03a9(EntityLargeFireball entityLargeFireball) {
        return oca163026023.\u0278(entityLargeFireball, 0x70E7A046 ^ 0x70E7A21E);
    }

    public static oc94a86ee062 \u0278(EntityLargeFireball entityLargeFireball, int n) {
        World world2;
        EntityLargeFireball entityLargeFireball2;
        int n2;
        block47: {
            block48: {
                n2 = oc75d51ec7eb.\u03e9;
                entityLargeFireball2 = entityLargeFireball;
                if (n2 != 0) break block47;
                if (entityLargeFireball2 != null) break block48;
                throw new IllegalArgumentException("fireball cannot be null");
            }
            entityLargeFireball2 = entityLargeFireball;
        }
        if ((world2 = entityLargeFireball2.worldObj) == null) {
            Vec3 vec3 = new Vec3(entityLargeFireball.posX, entityLargeFireball.posY, entityLargeFireball.posZ);
            return new oc94a86ee062(oc3e527bc66f.\u01e1, null, null, null, vec3, 0);
        }
        double d = entityLargeFireball.posX;
        double d2 = entityLargeFireball.posY;
        double d3 = entityLargeFireball.posZ;
        double d4 = entityLargeFireball.motionX;
        double d5 = entityLargeFireball.motionY;
        double d6 = entityLargeFireball.motionZ;
        double d7 = oca163026023.\u00cb(entityLargeFireball.accelerationX);
        double d8 = oca163026023.\u00cb(entityLargeFireball.accelerationY);
        double d9 = oca163026023.\u00cb(entityLargeFireball.accelerationZ);
        float f = entityLargeFireball.width;
        float f2 = entityLargeFireball.height;
        EntityLivingBase entityLivingBase = entityLargeFireball.shootingEntity;
        int n3 = Math.max(0, entityLargeFireball.ticksExisted);
        int n4 = 0;
        Vec3 vec3 = new Vec3(d, d2, d3);
        int n5 = 0;
        while (n5 < Math.max(1, n)) {
            float f3;
            MovingObjectPosition movingObjectPosition;
            MovingObjectPosition movingObjectPosition2;
            Vec3 vec32;
            oc2e6d7f97ce oc2e6d7f97ce2;
            block61: {
                block53: {
                    Vec3 vec33;
                    AxisAlignedBB axisAlignedBB;
                    block62: {
                        Vec3 vec34;
                        block52: {
                            MovingObjectPosition movingObjectPosition3;
                            block51: {
                                block50: {
                                    block49: {
                                        n4 = n5 + 1;
                                        ++n3;
                                        oc2e6d7f97ce2 = oca163026023.F(world2, d, d2, d3, f, f2, entityLargeFireball);
                                        if (n2 != 0) break block49;
                                        if (!entityLargeFireball.isPushedByWater()) break block50;
                                        d4 += oc2e6d7f97ce2.o.xCoord * 0.014;
                                        d5 += oc2e6d7f97ce2.o.yCoord * 0.014;
                                    }
                                    d6 += oc2e6d7f97ce2.o.zCoord * 0.014;
                                }
                                vec32 = new Vec3(d, d2, d3);
                                vec34 = new Vec3(d + d4, d2 + d5, d3 + d6);
                                axisAlignedBB = oca163026023.\u02b3(d, d2, d3, d4, d5, d6, f, f2);
                                movingObjectPosition2 = oca163026023.\u053b(world2, vec32, vec34, false);
                                movingObjectPosition3 = movingObjectPosition2;
                                if (n2 != 0) break block51;
                                if (movingObjectPosition3 == null) break block52;
                                movingObjectPosition3 = movingObjectPosition2;
                            }
                            vec33 = movingObjectPosition3.hitVec;
                            break block62;
                        }
                        vec33 = vec34;
                    }
                    Vec3 vec35 = vec33;
                    double d10 = movingObjectPosition2 != null ? vec32.squareDistanceTo(movingObjectPosition2.hitVec) : Double.MAX_VALUE;
                    double d11 = d10;
                    MovingObjectPosition movingObjectPosition4 = null;
                    AxisAlignedBB axisAlignedBB2 = axisAlignedBB.expand(1.0, 1.0, 1.0);
                    List<Entity> list = world2.getEntitiesWithinAABBExcludingEntity(entityLargeFireball, axisAlignedBB2);
                    for (Entity entity : list) {
                        block60: {
                            double d12;
                            MovingObjectPosition movingObjectPosition5;
                            block59: {
                                Entity entity2;
                                block57: {
                                    block58: {
                                        block55: {
                                            block56: {
                                                block54: {
                                                    if (n2 != 0) break block53;
                                                    entity2 = entity;
                                                    if (n2 != 0) break block54;
                                                    if (entity2.isDead) continue;
                                                    entity2 = entity;
                                                }
                                                if (n2 != 0) break block55;
                                                if (entity2.canBeCollidedWith()) break block56;
                                                if (n2 == 0) continue;
                                            }
                                            entity2 = entity;
                                        }
                                        if (n2 != 0) break block57;
                                        if (!entity2.isEntityEqual(entityLivingBase)) break block58;
                                        if (n3 >= (0xD87F495A ^ 0xD87F4943)) break block58;
                                        if (n2 == 0) continue;
                                    }
                                    entity2 = entity;
                                }
                                AxisAlignedBB axisAlignedBB3 = entity2.getEntityBoundingBox().expand(0.3f, 0.3f, 0.3f);
                                movingObjectPosition5 = axisAlignedBB3.calculateIntercept(vec32, vec35);
                                if (movingObjectPosition5 == null && n2 == 0) continue;
                                double d13 = vec32.squareDistanceTo(movingObjectPosition5.hitVec);
                                d12 = d13;
                                if (n2 != 0) break block59;
                                if (!(d12 + 1.0E-7 < d11)) break block60;
                                d12 = d13;
                            }
                            d11 = d12;
                            movingObjectPosition4 = new MovingObjectPosition(entity, movingObjectPosition5.hitVec);
                        }
                        if (n2 == 0) continue;
                    }
                    movingObjectPosition = movingObjectPosition4;
                    if (n2 != 0) break block61;
                    if (movingObjectPosition == null) break block53;
                    return new oc94a86ee062(oc3e527bc66f.\u0474, movingObjectPosition4, movingObjectPosition4.hitVec, vec32, vec32, n4);
                }
                movingObjectPosition = movingObjectPosition2;
            }
            if (movingObjectPosition != null) {
                return new oc94a86ee062(oc3e527bc66f.\u04de, movingObjectPosition2, movingObjectPosition2.hitVec, vec32, vec32, n4);
            }
            vec3 = new Vec3(d += d4, d2 += d5, d3 += d6);
            d4 += d7;
            d5 += d8;
            d6 += d9;
            float f4 = f3 = oc2e6d7f97ce2.\u04df ? 0.8f : 0.95f;
            if (n2 == 0) {
                d4 *= (double)f3;
                d5 *= (double)f3;
                d6 *= (double)f3;
                if (d2 < -64.0 && n2 == 0) break;
                ++n5;
            }
            if (n2 == 0) continue;
        }
        return new oc94a86ee062(oc3e527bc66f.\u01e1, null, null, vec3, vec3, n4);
    }

    private static AxisAlignedBB \u0141(double d, double d2, double d3, float f, float f2) {
        double d4 = (double)f * 0.5;
        return new AxisAlignedBB(d - d4, d2, d3 - d4, d + d4, d2 + (double)f2, d3 + d4);
    }

    private static AxisAlignedBB \u02b3(double d, double d2, double d3, double d4, double d5, double d6, float f, float f2) {
        return oca163026023.\u0141(d, d2, d3, f, f2).addCoord(d4, d5, d6);
    }

    private static MovingObjectPosition \u053b(World world2, Vec3 vec3, Vec3 vec32, boolean bl) {
        Vec3 vec33 = vec32.subtract(vec3);
        int n = Math.max(1, (int)Math.ceil(vec33.lengthVector() / 64.0));
        Vec3 vec34 = vec3;
        int n2 = oc75d51ec7eb.\u03e9;
        int n3 = 1;
        while (n3 <= n) {
            block5: {
                Vec3 vec35;
                block6: {
                    double d = (double)n3 / (double)n;
                    vec35 = vec3.addVector(vec33.xCoord * d, vec33.yCoord * d, vec33.zCoord * d);
                    MovingObjectPosition movingObjectPosition = world2.rayTraceBlocks(vec34, vec35, false, bl, false);
                    if (n2 != 0) break block5;
                    if (movingObjectPosition == null) break block6;
                    return movingObjectPosition;
                }
                vec34 = vec35;
                ++n3;
            }
            if (n2 == 0) continue;
        }
        return null;
    }

    private static oc2e6d7f97ce F(World world2, double d, double d2, double d3, float f, float f2, Entity entity) {
        Vec3 vec3;
        int n;
        block21: {
            Vec3 vec32;
            block26: {
                int n2;
                int n3;
                int n4;
                int n5;
                int n6;
                int n7;
                int n8;
                block19: {
                    block20: {
                        AxisAlignedBB axisAlignedBB = oca163026023.\u0141(d, d2, d3, f, f2).expand(0.0, -0.4f, 0.0).contract(0.001, 0.001, 0.001);
                        n8 = MathHelper.floor_double(axisAlignedBB.minX);
                        n7 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
                        n6 = oc75d51ec7eb.\u03e9;
                        n5 = MathHelper.floor_double(axisAlignedBB.minY);
                        n4 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
                        int n9 = MathHelper.floor_double(axisAlignedBB.minZ);
                        n3 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0);
                        n2 = world2.isAreaLoaded(new BlockPos(n8, n5, n9), new BlockPos(n7, n4, n3), true);
                        if (n6 != 0) break block19;
                        if (n2 != 0) break block20;
                        return new oc2e6d7f97ce(false, new Vec3(0.0, 0.0, 0.0));
                    }
                    n2 = 0;
                }
                n = n2;
                vec3 = new Vec3(0.0, 0.0, 0.0);
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                int n10 = n8;
                while (n10 < n7) {
                    block22: {
                        if (n6 != 0) break block21;
                        int n11 = n5;
                        while (n11 < n4) {
                            block23: {
                                if (n6 != 0) break block22;
                                for (int i = n9; i < n3; ++i) {
                                    int n12;
                                    IBlockState iBlockState;
                                    block24: {
                                        block25: {
                                            if (n6 != 0) break block23;
                                            mutableBlockPos.set(n10, n11, i);
                                            iBlockState = world2.getBlockState(mutableBlockPos);
                                            if (iBlockState.getBlock().getMaterial() != Material.water && n6 == 0) continue;
                                            double d4 = (float)(n11 + 1) - BlockLiquid.getLiquidHeightPercent(iBlockState.getValue(BlockLiquid.LEVEL));
                                            n12 = n4;
                                            if (n6 != 0) break block24;
                                            if (!((double)n12 < d4)) break block25;
                                            if (n6 == 0) continue;
                                        }
                                        n12 = 1;
                                    }
                                    n = n12;
                                    vec3 = iBlockState.getBlock().modifyAcceleration(world2, mutableBlockPos, entity, vec3);
                                    if (n6 == 0) continue;
                                }
                                ++n11;
                            }
                            if (n6 == 0) continue;
                        }
                        ++n10;
                    }
                    if (n6 == 0) continue;
                }
                vec32 = vec3;
                if (n6 != 0) break block26;
                if (!(vec32.lengthVector() > 0.0)) break block21;
                vec32 = vec3.normalize();
            }
            vec3 = vec32;
        }
        return new oc2e6d7f97ce(n != 0, vec3);
    }

    private static double \u00cb(double d) {
        double d2;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                d2 = d;
                if (n != 0) break block4;
                if (!Double.isFinite(d2)) break block5;
                d2 = d;
                break block4;
            }
            d2 = 0.0;
        }
        return d2;
    }
}

