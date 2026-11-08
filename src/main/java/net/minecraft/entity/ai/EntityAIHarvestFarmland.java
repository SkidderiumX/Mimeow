/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityAIHarvestFarmland
extends EntityAIMoveToBlock {
    private final EntityVillager theVillager;
    private boolean hasFarmItem;
    private boolean field_179503_e;
    private int field_179501_f;

    public EntityAIHarvestFarmland(EntityVillager entityVillager, double d) {
        super(entityVillager, d, 16);
        this.theVillager = entityVillager;
    }

    @Override
    public boolean shouldExecute() {
        if (this.runDelay <= 0) {
            if (!this.theVillager.worldObj.getGameRules().getBoolean("mobGriefing")) {
                return false;
            }
            this.field_179501_f = -1;
            this.hasFarmItem = this.theVillager.isFarmItemInInventory();
            this.field_179503_e = this.theVillager.func_175557_cr();
        }
        return super.shouldExecute();
    }

    @Override
    public boolean continueExecuting() {
        return this.field_179501_f >= 0 && super.continueExecuting();
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }

    @Override
    public void updateTask() {
        super.updateTask();
        this.theVillager.getLookHelper().setLookPosition((double)this.destinationBlock.getX() + 0.5, this.destinationBlock.getY() + 1, (double)this.destinationBlock.getZ() + 0.5, 10.0f, this.theVillager.getVerticalFaceSpeed());
        if (this.getIsAboveDestination()) {
            World world2 = this.theVillager.worldObj;
            BlockPos blockPos = this.destinationBlock.up();
            IBlockState iBlockState = world2.getBlockState(blockPos);
            Block block = iBlockState.getBlock();
            if (this.field_179501_f == 0 && block instanceof BlockCrops && iBlockState.getValue(BlockCrops.AGE) == 7) {
                world2.destroyBlock(blockPos, true);
            } else if (this.field_179501_f == 1 && block == Blocks.air) {
                InventoryBasic inventoryBasic = this.theVillager.getVillagerInventory();
                for (int i = 0; i < inventoryBasic.getSizeInventory(); ++i) {
                    ItemStack itemStack = inventoryBasic.getStackInSlot(i);
                    boolean bl = false;
                    if (itemStack != null) {
                        if (itemStack.getItem() == Items.wheat_seeds) {
                            world2.setBlockState(blockPos, Blocks.wheat.getDefaultState(), 3);
                            bl = true;
                        } else if (itemStack.getItem() == Items.potato) {
                            world2.setBlockState(blockPos, Blocks.potatoes.getDefaultState(), 3);
                            bl = true;
                        } else if (itemStack.getItem() == Items.carrot) {
                            world2.setBlockState(blockPos, Blocks.carrots.getDefaultState(), 3);
                            bl = true;
                        }
                    }
                    if (!bl) continue;
                    --itemStack.stackSize;
                    if (itemStack.stackSize > 0) break;
                    inventoryBasic.setInventorySlotContents(i, null);
                    break;
                }
            }
            this.field_179501_f = -1;
            this.runDelay = 10;
        }
    }

    @Override
    protected boolean shouldMoveTo(World world2, BlockPos blockPos) {
        Block block = world2.getBlockState(blockPos).getBlock();
        if (block == Blocks.farmland) {
            IBlockState iBlockState = world2.getBlockState(blockPos = blockPos.up());
            block = iBlockState.getBlock();
            if (block instanceof BlockCrops && iBlockState.getValue(BlockCrops.AGE) == 7 && this.field_179503_e && (this.field_179501_f == 0 || this.field_179501_f < 0)) {
                this.field_179501_f = 0;
                return true;
            }
            if (block == Blocks.air && this.hasFarmItem && (this.field_179501_f == 1 || this.field_179501_f < 0)) {
                this.field_179501_f = 1;
                return true;
            }
        }
        return false;
    }
}

