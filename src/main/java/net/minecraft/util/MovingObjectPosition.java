/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;

public class MovingObjectPosition {
    private BlockPos blockPos;
    public MovingObjectType typeOfHit;
    public EnumFacing sideHit;
    public Vec3 hitVec;
    public Entity entityHit;

    public MovingObjectPosition(Vec3 vec3, EnumFacing enumFacing, BlockPos blockPos) {
        this(MovingObjectType.BLOCK, vec3, enumFacing, blockPos);
    }

    public MovingObjectPosition(Vec3 vec3, EnumFacing enumFacing) {
        this(MovingObjectType.BLOCK, vec3, enumFacing, BlockPos.ORIGIN);
    }

    public MovingObjectPosition(Entity entity) {
        this(entity, new Vec3(entity.posX, entity.posY, entity.posZ));
    }

    public MovingObjectPosition(MovingObjectType movingObjectType, Vec3 vec3, EnumFacing enumFacing, BlockPos blockPos) {
        this.typeOfHit = movingObjectType;
        this.blockPos = blockPos;
        this.sideHit = enumFacing;
        this.hitVec = new Vec3(vec3.xCoord, vec3.yCoord, vec3.zCoord);
    }

    public MovingObjectPosition(Entity entity, Vec3 vec3) {
        this.typeOfHit = MovingObjectType.ENTITY;
        this.entityHit = entity;
        this.hitVec = vec3;
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public String toString() {
        return "HitResult{type=" + String.valueOf((Object)this.typeOfHit) + ", blockpos=" + String.valueOf(this.blockPos) + ", f=" + String.valueOf(this.sideHit) + ", pos=" + String.valueOf(this.hitVec) + ", entity=" + String.valueOf(this.entityHit) + "}";
    }

    public static enum MovingObjectType {
        MISS,
        BLOCK,
        ENTITY;

    }
}

