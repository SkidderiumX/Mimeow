/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import x.oc75d51ec7eb;

public class oc169f211a70 {
    public static int \u02aa;

    private oc169f211a70() {
    }

    public static Vec3 \u03ad(Entity entity, Entity entity2) {
        Vec3 vec3 = entity.getPositionEyes(1.0f);
        AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox();
        Vec3 vec32 = new Vec3((axisAlignedBB.minX + axisAlignedBB.maxX) * 0.5, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * 0.55, (axisAlignedBB.minZ + axisAlignedBB.maxZ) * 0.5);
        double d = MathHelper.clamp_double(vec3.distanceTo(vec32) / 1.5, 1.0, 6.0);
        Vec3 vec33 = oc169f211a70.\u0370(entity2);
        return vec32.addVector(vec33.xCoord * d, vec33.yCoord * d + 0.02 * d * d, vec33.zCoord * d);
    }

    public static boolean \u0423(Entity entity, Entity entity2, double d) {
        double d2;
        block2: {
            block3: {
                Vec3 vec3 = oc169f211a70.\u0370(entity2).subtract(oc169f211a70.\u0370(entity));
                AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox().offset(vec3.xCoord * 1.5, vec3.yCoord * 1.5, vec3.zCoord * 1.5);
                Vec3 vec32 = entity.getPositionEyes(1.0f);
                int n = oc75d51ec7eb.\u03e9;
                Vec3 vec33 = new Vec3(MathHelper.clamp_double(vec32.xCoord, axisAlignedBB.minX, axisAlignedBB.maxX), MathHelper.clamp_double(vec32.yCoord, axisAlignedBB.minY, axisAlignedBB.maxY), MathHelper.clamp_double(vec32.zCoord, axisAlignedBB.minZ, axisAlignedBB.maxZ));
                double d3 = vec32.squareDistanceTo(vec33) - d * d;
                d2 = d3 == 0.0 ? 0 : (d3 < 0.0 ? -1 : 1);
                if (n != 0) break block2;
                if (d2 > 0) break block3;
                d2 = 1.0;
                break block2;
            }
            d2 = 0.0;
        }
        return (boolean)d2;
    }

    private static Vec3 \u0370(Entity entity) {
        double d;
        double d2;
        double d3;
        block3: {
            double d4;
            block2: {
                d3 = entity.posX - entity.prevPosX;
                int n = oc75d51ec7eb.\u03e9;
                d2 = entity.posY - entity.prevPosY;
                d = entity.posZ - entity.prevPosZ;
                d4 = d3;
                if (n != 0) break block2;
                if (!(d4 * d3 + d2 * d2 + d * d > 1.0)) break block3;
                d3 = entity.motionX;
                d2 = entity.motionY;
                d4 = entity.motionZ;
            }
            d = d4;
        }
        return new Vec3(MathHelper.clamp_double(d3, -0.8, 0.8), MathHelper.clamp_double(d2, -0.5, 0.5), MathHelper.clamp_double(d, -0.8, 0.8));
    }
}

