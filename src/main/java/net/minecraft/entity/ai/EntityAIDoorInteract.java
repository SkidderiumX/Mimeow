/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.BlockPos;

public abstract class EntityAIDoorInteract
extends EntityAIBase {
    protected EntityLiving theEntity;
    protected BlockPos doorPosition = BlockPos.ORIGIN;
    protected BlockDoor doorBlock;
    boolean hasStoppedDoorInteraction;
    float entityPositionX;
    float entityPositionZ;

    public EntityAIDoorInteract(EntityLiving entityLiving) {
        this.theEntity = entityLiving;
        if (!(entityLiving.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");
        }
    }

    @Override
    public boolean shouldExecute() {
        if (!this.theEntity.isCollidedHorizontally) {
            return false;
        }
        PathNavigateGround pathNavigateGround = (PathNavigateGround)this.theEntity.getNavigator();
        PathEntity pathEntity = pathNavigateGround.getPath();
        if (pathEntity != null && !pathEntity.isFinished() && pathNavigateGround.getEnterDoors()) {
            for (int i = 0; i < Math.min(pathEntity.getCurrentPathIndex() + 2, pathEntity.getCurrentPathLength()); ++i) {
                PathPoint pathPoint = pathEntity.getPathPointFromIndex(i);
                this.doorPosition = new BlockPos(pathPoint.xCoord, pathPoint.yCoord + 1, pathPoint.zCoord);
                if (!(this.theEntity.getDistanceSq(this.doorPosition.getX(), this.theEntity.posY, this.doorPosition.getZ()) <= 2.25)) continue;
                this.doorBlock = this.getBlockDoor(this.doorPosition);
                if (this.doorBlock == null) continue;
                return true;
            }
            this.doorPosition = new BlockPos(this.theEntity).up();
            this.doorBlock = this.getBlockDoor(this.doorPosition);
            return this.doorBlock != null;
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        return !this.hasStoppedDoorInteraction;
    }

    @Override
    public void startExecuting() {
        this.hasStoppedDoorInteraction = false;
        this.entityPositionX = (float)((double)((float)this.doorPosition.getX() + 0.5f) - this.theEntity.posX);
        this.entityPositionZ = (float)((double)((float)this.doorPosition.getZ() + 0.5f) - this.theEntity.posZ);
    }

    @Override
    public void updateTask() {
        float f;
        float f2 = (float)((double)((float)this.doorPosition.getX() + 0.5f) - this.theEntity.posX);
        float f3 = this.entityPositionX * f2 + this.entityPositionZ * (f = (float)((double)((float)this.doorPosition.getZ() + 0.5f) - this.theEntity.posZ));
        if (f3 < 0.0f) {
            this.hasStoppedDoorInteraction = true;
        }
    }

    private BlockDoor getBlockDoor(BlockPos blockPos) {
        Block block = this.theEntity.worldObj.getBlockState(blockPos).getBlock();
        return block instanceof BlockDoor && block.getMaterial() == Material.wood ? (BlockDoor)block : null;
    }
}

