/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oce79181588d;

public class oc29fb8ce47a {
    private static final Minecraft \u00b5 = Minecraft.getMinecraft();
    private final float \u0441;
    private final float \u015e;
    private final float \u03a7;
    private final float s;
    private final boolean \u0257;
    private final float \u00c8;
    private final float \u0147;
    public static boolean \u0439;

    public oc29fb8ce47a(float f, float f2, float f3, float f4, boolean bl, float f5) {
        this(f, f2, f3, f4, bl, f5, f5);
    }

    public oc29fb8ce47a(float f, float f2, float f3, float f4, boolean bl, float f5, float f6) {
        this.\u0441 = f;
        this.\u015e = f2;
        this.\u03a7 = f3;
        this.s = f4;
        this.\u0257 = bl;
        this.\u00c8 = f5;
        this.\u0147 = f6;
    }

    public float \u010a() {
        return this.\u0441;
    }

    public float \u057e() {
        return this.\u015e;
    }

    public float \u0124() {
        return this.\u03a7;
    }

    public float \u03a0() {
        return this.s;
    }

    public boolean \u01ee() {
        return this.\u0257;
    }

    public float \u029b() {
        return Math.max(this.\u00c8, this.\u0147);
    }

    public float \u01d3() {
        return this.\u00c8;
    }

    public float \u040b() {
        return this.\u0147;
    }

    public MovingObjectPosition \u0277() {
        Vec3 vec3 = oc29fb8ce47a.\u00b5.thePlayer.getPositionEyes(1.0f);
        Vec3 vec32 = oc7ab2161b9f.\u04b5(this.\u0441, this.\u015e);
        Vec3 vec33 = vec3.addVector(vec32.xCoord * 4.5, vec32.yCoord * 4.5, vec32.zCoord * 4.5);
        int n = oce79181588d.\u022d;
        MovingObjectPosition movingObjectPosition = oc29fb8ce47a.\u00b5.thePlayer.worldObj.rayTraceBlocks(vec3, vec33, false, false, true);
        if (false) {
            oce79181588d.\u022d = ++n;
        }
        return movingObjectPosition;
    }

    public MovingObjectPosition \u011b() {
        MovingObjectPosition movingObjectPosition;
        block11: {
            Vec3 vec3 = oc29fb8ce47a.\u00b5.thePlayer.getPositionEyes(1.0f);
            int n = oce79181588d.\u022d;
            Vec3 vec32 = oc7ab2161b9f.\u04b5(this.\u0441, this.\u015e);
            Vec3 vec33 = vec3.addVector(vec32.xCoord * 4.5, vec32.yCoord * 4.5, vec32.zCoord * 4.5);
            MovingObjectPosition movingObjectPosition2 = oc29fb8ce47a.\u00b5.thePlayer.worldObj.rayTraceBlocks(vec3, vec33, false, false, true);
            double d = movingObjectPosition2 == null ? Double.MAX_VALUE : vec3.distanceTo(movingObjectPosition2.hitVec);
            double d2 = d;
            MovingObjectPosition movingObjectPosition3 = null;
            double d3 = Double.MAX_VALUE;
            List<Entity> list = oc29fb8ce47a.\u00b5.thePlayer.worldObj.getEntitiesInAABBexcluding(oc29fb8ce47a.\u00b5.thePlayer, oc29fb8ce47a.\u00b5.thePlayer.getEntityBoundingBox().addCoord(vec32.xCoord * 4.5, vec32.yCoord * 4.5, vec32.zCoord * 4.5).expand(1.0, 1.0, 1.0), oc29fb8ce47a::q3kcvvc8opzw1j);
            for (Entity entity : list) {
                block14: {
                    double d4;
                    block13: {
                        MovingObjectPosition movingObjectPosition4;
                        block12: {
                            float f = entity.getCollisionBorderSize();
                            AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().expand(f, f, f);
                            movingObjectPosition = axisAlignedBB.calculateIntercept(vec3, vec33);
                            if (n != 0) break block11;
                            movingObjectPosition4 = movingObjectPosition;
                            if (movingObjectPosition4 != null) break block12;
                            if (n == 0) continue;
                            boolean bl = !false;
                            oc69da1aa7f5.\u04ac = bl;
                        }
                        d4 = vec3.distanceTo(movingObjectPosition4.hitVec);
                        if (n != 0) break block13;
                        if (!(d4 < d3)) break block14;
                        movingObjectPosition3 = new MovingObjectPosition(entity, movingObjectPosition4.hitVec);
                    }
                    d3 = d4;
                }
                if (n == 0) continue;
            }
            movingObjectPosition = d3 < d2 ? movingObjectPosition3 : movingObjectPosition2;
        }
        return movingObjectPosition;
    }

    private static boolean q3kcvvc8opzw1j(Entity entity) {
        return entity.canBeCollidedWith();
    }
}

