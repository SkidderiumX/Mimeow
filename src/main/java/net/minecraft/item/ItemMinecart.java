/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMinecart
extends Item {
    private static final IBehaviorDispenseItem dispenserMinecartBehavior = new BehaviorDefaultDispenseItem(){
        private final BehaviorDefaultDispenseItem behaviourDefaultDispenseItem = new BehaviorDefaultDispenseItem();

        @Override
        public ItemStack dispenseStack(IBlockSource iBlockSource, ItemStack itemStack) {
            Object object;
            double d;
            BlockRailBase.EnumRailDirection enumRailDirection;
            EnumFacing enumFacing = BlockDispenser.getFacing(iBlockSource.getBlockMetadata());
            World world2 = iBlockSource.getWorld();
            double d2 = iBlockSource.getX() + (double)enumFacing.getFrontOffsetX() * 1.125;
            double d3 = Math.floor(iBlockSource.getY()) + (double)enumFacing.getFrontOffsetY();
            double d4 = iBlockSource.getZ() + (double)enumFacing.getFrontOffsetZ() * 1.125;
            BlockPos blockPos = iBlockSource.getBlockPos().offset(enumFacing);
            IBlockState iBlockState = world2.getBlockState(blockPos);
            BlockRailBase.EnumRailDirection enumRailDirection2 = enumRailDirection = iBlockState.getBlock() instanceof BlockRailBase ? iBlockState.getValue(((BlockRailBase)iBlockState.getBlock()).getShapeProperty()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
            if (BlockRailBase.isRailBlock(iBlockState)) {
                d = enumRailDirection.isAscending() ? 0.6 : 0.1;
            } else {
                if (iBlockState.getBlock().getMaterial() != Material.air || !BlockRailBase.isRailBlock(world2.getBlockState(blockPos.down()))) {
                    return this.behaviourDefaultDispenseItem.dispense(iBlockSource, itemStack);
                }
                object = world2.getBlockState(blockPos.down());
                BlockRailBase.EnumRailDirection enumRailDirection3 = object.getBlock() instanceof BlockRailBase ? object.getValue(((BlockRailBase)object.getBlock()).getShapeProperty()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
                d = enumFacing != EnumFacing.DOWN && enumRailDirection3.isAscending() ? -0.4 : -0.9;
            }
            object = EntityMinecart.getMinecart(world2, d2, d3 + d, d4, ((ItemMinecart)itemStack.getItem()).minecartType);
            if (itemStack.hasDisplayName()) {
                ((EntityMinecart)object).setCustomNameTag(itemStack.getDisplayName());
            }
            world2.spawnEntityInWorld((Entity)object);
            itemStack.splitStack(1);
            return itemStack;
        }

        @Override
        protected void playDispenseSound(IBlockSource iBlockSource) {
            iBlockSource.getWorld().playAuxSFX(1000, iBlockSource.getBlockPos(), 0);
        }
    };
    private final EntityMinecart.EnumMinecartType minecartType;

    public ItemMinecart(EntityMinecart.EnumMinecartType enumMinecartType) {
        this.maxStackSize = 1;
        this.minecartType = enumMinecartType;
        this.setCreativeTab(CreativeTabs.tabTransport);
        BlockDispenser.dispenseBehaviorRegistry.putObject(this, dispenserMinecartBehavior);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (BlockRailBase.isRailBlock(iBlockState)) {
            if (!world2.isRemote) {
                BlockRailBase.EnumRailDirection enumRailDirection = iBlockState.getBlock() instanceof BlockRailBase ? iBlockState.getValue(((BlockRailBase)iBlockState.getBlock()).getShapeProperty()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
                double d = 0.0;
                if (enumRailDirection.isAscending()) {
                    d = 0.5;
                }
                EntityMinecart entityMinecart = EntityMinecart.getMinecart(world2, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.0625 + d, (double)blockPos.getZ() + 0.5, this.minecartType);
                if (itemStack.hasDisplayName()) {
                    entityMinecart.setCustomNameTag(itemStack.getDisplayName());
                }
                world2.spawnEntityInWorld(entityMinecart);
            }
            --itemStack.stackSize;
            return true;
        }
        return false;
    }
}

