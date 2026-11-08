/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemMonsterPlacer
extends Item {
    public ItemMonsterPlacer() {
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        Object object = StatCollector.translateToLocal(this.getUnlocalizedName() + ".name").trim();
        String string = EntityList.getStringFromID(itemStack.getMetadata());
        if (string != null) {
            object = (String)object + " " + StatCollector.translateToLocal("entity." + string + ".name");
        }
        return object;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        EntityList.EntityEggInfo entityEggInfo = EntityList.entityEggs.get(itemStack.getMetadata());
        return entityEggInfo != null ? (n == 0 ? entityEggInfo.primaryColor : entityEggInfo.secondaryColor) : 0xFFFFFF;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        Entity entity;
        TileEntity tileEntity;
        if (world2.isRemote) {
            return true;
        }
        if (!entityPlayer.canPlayerEdit(blockPos.offset(enumFacing), enumFacing, itemStack)) {
            return false;
        }
        IBlockState iBlockState = world2.getBlockState(blockPos);
        if (iBlockState.getBlock() == Blocks.mob_spawner && (tileEntity = world2.getTileEntity(blockPos)) instanceof TileEntityMobSpawner) {
            MobSpawnerBaseLogic mobSpawnerBaseLogic = ((TileEntityMobSpawner)tileEntity).getSpawnerBaseLogic();
            mobSpawnerBaseLogic.setEntityName(EntityList.getStringFromID(itemStack.getMetadata()));
            tileEntity.markDirty();
            world2.markBlockForUpdate(blockPos);
            if (!entityPlayer.capabilities.isCreativeMode) {
                --itemStack.stackSize;
            }
            return true;
        }
        blockPos = blockPos.offset(enumFacing);
        double d = 0.0;
        if (enumFacing == EnumFacing.UP && iBlockState instanceof BlockFence) {
            d = 0.5;
        }
        if ((entity = ItemMonsterPlacer.spawnCreature(world2, itemStack.getMetadata(), (double)blockPos.getX() + 0.5, (double)blockPos.getY() + d, (double)blockPos.getZ() + 0.5)) != null) {
            if (entity instanceof EntityLivingBase && itemStack.hasDisplayName()) {
                entity.setCustomNameTag(itemStack.getDisplayName());
            }
            if (!entityPlayer.capabilities.isCreativeMode) {
                --itemStack.stackSize;
            }
        }
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        if (world2.isRemote) {
            return itemStack;
        }
        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world2, entityPlayer, true);
        if (movingObjectPosition == null) {
            return itemStack;
        }
        if (movingObjectPosition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            Entity entity;
            BlockPos blockPos = movingObjectPosition.getBlockPos();
            if (!world2.isBlockModifiable(entityPlayer, blockPos)) {
                return itemStack;
            }
            if (!entityPlayer.canPlayerEdit(blockPos, movingObjectPosition.sideHit, itemStack)) {
                return itemStack;
            }
            if (world2.getBlockState(blockPos).getBlock() instanceof BlockLiquid && (entity = ItemMonsterPlacer.spawnCreature(world2, itemStack.getMetadata(), (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5)) != null) {
                if (entity instanceof EntityLivingBase && itemStack.hasDisplayName()) {
                    ((EntityLiving)entity).setCustomNameTag(itemStack.getDisplayName());
                }
                if (!entityPlayer.capabilities.isCreativeMode) {
                    --itemStack.stackSize;
                }
                entityPlayer.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
            }
        }
        return itemStack;
    }

    public static Entity spawnCreature(World world2, int n, double d, double d2, double d3) {
        if (!EntityList.entityEggs.containsKey(n)) {
            return null;
        }
        Entity entity = null;
        for (int i = 0; i < 1; ++i) {
            entity = EntityList.createEntityByID(n, world2);
            if (!(entity instanceof EntityLivingBase)) continue;
            EntityLiving entityLiving = (EntityLiving)entity;
            entity.setLocationAndAngles(d, d2, d3, MathHelper.wrapAngleTo180_float(world2.rand.nextFloat() * 360.0f), 0.0f);
            entityLiving.rotationYawHead = entityLiving.rotationYaw;
            entityLiving.renderYawOffset = entityLiving.rotationYaw;
            entityLiving.onInitialSpawn(world2.getDifficultyForLocation(new BlockPos(entityLiving)), null);
            world2.spawnEntityInWorld(entity);
            entityLiving.playLivingSound();
        }
        return entity;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (EntityList.EntityEggInfo entityEggInfo : EntityList.entityEggs.values()) {
            list.add(new ItemStack(item, 1, entityEggInfo.spawnedID));
        }
    }
}

