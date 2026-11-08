/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityAIOcelotSit
extends EntityAIMoveToBlock {
    private final EntityOcelot ocelot;

    public EntityAIOcelotSit(EntityOcelot entityOcelot, double d) {
        super(entityOcelot, d, 8);
        this.ocelot = entityOcelot;
    }

    @Override
    public boolean shouldExecute() {
        return this.ocelot.isTamed() && !this.ocelot.isSitting() && super.shouldExecute();
    }

    @Override
    public boolean continueExecuting() {
        return super.continueExecuting();
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        this.ocelot.getAISit().setSitting(false);
    }

    @Override
    public void resetTask() {
        super.resetTask();
        this.ocelot.setSitting(false);
    }

    @Override
    public void updateTask() {
        super.updateTask();
        this.ocelot.getAISit().setSitting(false);
        if (!this.getIsAboveDestination()) {
            this.ocelot.setSitting(false);
        } else if (!this.ocelot.isSitting()) {
            this.ocelot.setSitting(true);
        }
    }

    @Override
    protected boolean shouldMoveTo(World world2, BlockPos blockPos) {
        if (!world2.isAirBlock(blockPos.up())) {
            return false;
        }
        IBlockState iBlockState = world2.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        if (block == Blocks.chest) {
            TileEntity tileEntity = world2.getTileEntity(blockPos);
            if (tileEntity instanceof TileEntityChest && ((TileEntityChest)tileEntity).numPlayersUsing < 1) {
                return true;
            }
        } else {
            if (block == Blocks.lit_furnace) {
                return true;
            }
            if (block == Blocks.bed && iBlockState.getValue(BlockBed.PART) != BlockBed.EnumPartType.HEAD) {
                return true;
            }
        }
        return false;
    }
}

