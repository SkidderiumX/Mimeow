/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class Vec3 {
    public double x;
    public double y;
    public double z;

    public Vec3(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public Vec3(net.minecraft.util.Vec3 vec3) {
        this.x = vec3.xCoord;
        this.y = vec3.yCoord;
        this.z = vec3.zCoord;
    }

    public Vec3(BlockPos blockPos) {
        this.x = blockPos.getX();
        this.y = blockPos.getY();
        this.z = blockPos.getZ();
    }

    public boolean equals(Vec3 vec3) {
        if (this == vec3) {
            return true;
        }
        return this.x == vec3.x && this.y == vec3.y && this.z == vec3.z;
    }

    public Vec3 offset(Vec3 vec3) {
        return new Vec3(this.x + vec3.x, this.y + vec3.y, this.z + vec3.z);
    }

    public Vec3 offset(double d, double d2, double d3) {
        return new Vec3(this.x + d, this.y + d2, this.z + d3);
    }

    public Vec3 ceil() {
        return new Vec3(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }

    public Vec3 floor() {
        return new Vec3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }

    public Vec3 inverse() {
        return new Vec3(-this.x, -this.y, -this.z);
    }

    public Vec3 translate(Vec3 vec3) {
        return this.offset(vec3.x, vec3.y, vec3.z);
    }

    public Vec3 translate(double d, double d2, double d3) {
        return this.offset(d, d2, d3);
    }

    public static Vec3 convert(BlockPos blockPos) {
        if (blockPos == null) {
            return null;
        }
        return new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    public double distanceTo(Vec3 vec3) {
        double d = this.x - vec3.x;
        double d2 = this.y - vec3.y;
        double d3 = this.z - vec3.z;
        return MathHelper.sqrt_double(d * d + d2 * d2 + d3 * d3);
    }

    public double distanceToSq(Vec3 vec3) {
        double d = this.x - vec3.x;
        double d2 = this.y - vec3.y;
        double d3 = this.z - vec3.z;
        return d * d + d2 * d2 + d3 * d3;
    }

    public static BlockPos getBlockPos(Vec3 vec3) {
        return new BlockPos(vec3.x, vec3.y, vec3.z);
    }

    public static net.minecraft.util.Vec3 getVec3(Vec3 vec3) {
        return new net.minecraft.util.Vec3(vec3.x, vec3.y, vec3.z);
    }

    public String toString() {
        double d = this.z;
        double d2 = this.y;
        double d3 = this.x;
        return "Vec3(" + d3 + "," + d2 + "," + d + ")";
    }
}

