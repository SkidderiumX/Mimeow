/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class EntityAIMoveToBlock
extends EntityAIBase {
    private final EntityCreature theEntity;
    private final double movementSpeed;
    protected int runDelay;
    private int timeoutCounter;
    private int field_179490_f;
    protected BlockPos destinationBlock = BlockPos.ORIGIN;
    private boolean isAboveDestination;
    private int searchLength;

    public EntityAIMoveToBlock(EntityCreature entityCreature, double d, int n) {
        this.theEntity = entityCreature;
        this.movementSpeed = d;
        this.searchLength = n;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        if (this.runDelay > 0) {
            --this.runDelay;
            return false;
        }
        this.runDelay = 200 + this.theEntity.getRNG().nextInt(200);
        return this.searchForDestination();
    }

    @Override
    public boolean continueExecuting() {
        return this.timeoutCounter >= -this.field_179490_f && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.theEntity.worldObj, this.destinationBlock);
    }

    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().tryMoveToXYZ((double)this.destinationBlock.getX() + 0.5, this.destinationBlock.getY() + 1, (double)this.destinationBlock.getZ() + 0.5, this.movementSpeed);
        this.timeoutCounter = 0;
        this.field_179490_f = this.theEntity.getRNG().nextInt(this.theEntity.getRNG().nextInt(1200) + 1200) + 1200;
    }

    @Override
    public void resetTask() {
    }

    @Override
    public void updateTask() {
        if (this.theEntity.getDistanceSqToCenter(this.destinationBlock.up()) > 1.0) {
            this.isAboveDestination = false;
            ++this.timeoutCounter;
            if (this.timeoutCounter % 40 == 0) {
                this.theEntity.getNavigator().tryMoveToXYZ((double)this.destinationBlock.getX() + 0.5, this.destinationBlock.getY() + 1, (double)this.destinationBlock.getZ() + 0.5, this.movementSpeed);
            }
        } else {
            this.isAboveDestination = true;
            --this.timeoutCounter;
        }
    }

    protected boolean getIsAboveDestination() {
        return this.isAboveDestination;
    }

    private boolean searchForDestination() {
        int n = this.searchLength;
        boolean bl = true;
        BlockPos blockPos = new BlockPos(this.theEntity);
        int n2 = 0;
        while (n2 <= 1) {
            for (int i = 0; i < n; ++i) {
                int n3 = 0;
                while (n3 <= i) {
                    int n4;
                    int n5 = n4 = n3 < i && n3 > -i ? i : 0;
                    while (n4 <= i) {
                        BlockPos blockPos2 = blockPos.add(n3, n2 - 1, n4);
                        if (this.theEntity.isWithinHomeDistanceFromPosition(blockPos2) && this.shouldMoveTo(this.theEntity.worldObj, blockPos2)) {
                            this.destinationBlock = blockPos2;
                            return true;
                        }
                        n4 = n4 > 0 ? -n4 : 1 - n4;
                    }
                    n3 = n3 > 0 ? -n3 : 1 - n3;
                }
            }
            n2 = n2 > 0 ? -n2 : 1 - n2;
        }
        return false;
    }

    protected abstract boolean shouldMoveTo(World var1, BlockPos var2);
}

