/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTNT
extends Block {
    public static final PropertyBool EXPLODE = PropertyBool.create("explode");

    public BlockTNT() {
        super(Material.tnt);
        this.setDefaultState(this.blockState.getBaseState().withProperty(EXPLODE, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        super.onBlockAdded(world2, blockPos, iBlockState);
        if (world2.isBlockPowered(blockPos)) {
            this.onBlockDestroyedByPlayer(world2, blockPos, iBlockState.withProperty(EXPLODE, true));
            world2.setBlockToAir(blockPos);
        }
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (world2.isBlockPowered(blockPos)) {
            this.onBlockDestroyedByPlayer(world2, blockPos, iBlockState.withProperty(EXPLODE, true));
            world2.setBlockToAir(blockPos);
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World world2, BlockPos blockPos, Explosion explosion) {
        if (!world2.isRemote) {
            EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(world2, (float)blockPos.getX() + 0.5f, blockPos.getY(), (float)blockPos.getZ() + 0.5f, explosion.getExplosivePlacedBy());
            entityTNTPrimed.fuse = world2.rand.nextInt(entityTNTPrimed.fuse / 4) + entityTNTPrimed.fuse / 8;
            world2.spawnEntityInWorld(entityTNTPrimed);
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World world2, BlockPos blockPos, IBlockState iBlockState) {
        this.explode(world2, blockPos, iBlockState, null);
    }

    public void explode(World world2, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase) {
        if (!world2.isRemote && iBlockState.getValue(EXPLODE).booleanValue()) {
            EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(world2, (float)blockPos.getX() + 0.5f, blockPos.getY(), (float)blockPos.getZ() + 0.5f, entityLivingBase);
            world2.spawnEntityInWorld(entityTNTPrimed);
            world2.playSoundAtEntity(entityTNTPrimed, "game.tnt.primed", 1.0f, 1.0f);
        }
    }

    @Override
    public boolean onBlockActivated(World world2, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumFacing enumFacing, float f, float f2, float f3) {
        Item item;
        if (entityPlayer.getCurrentEquippedItem() != null && ((item = entityPlayer.getCurrentEquippedItem().getItem()) == Items.flint_and_steel || item == Items.fire_charge)) {
            this.explode(world2, blockPos, iBlockState.withProperty(EXPLODE, true), entityPlayer);
            world2.setBlockToAir(blockPos);
            if (item == Items.flint_and_steel) {
                entityPlayer.getCurrentEquippedItem().damageItem(1, entityPlayer);
            } else if (!entityPlayer.capabilities.isCreativeMode) {
                --entityPlayer.getCurrentEquippedItem().stackSize;
            }
            return true;
        }
        return super.onBlockActivated(world2, blockPos, iBlockState, entityPlayer, enumFacing, f, f2, f3);
    }

    @Override
    public void onEntityCollidedWithBlock(World world2, BlockPos blockPos, IBlockState iBlockState, Entity entity) {
        EntityArrow entityArrow;
        if (!world2.isRemote && entity instanceof EntityArrow && (entityArrow = (EntityArrow)entity).isBurning()) {
            this.explode(world2, blockPos, world2.getBlockState(blockPos).withProperty(EXPLODE, true), entityArrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityArrow.shootingEntity : null);
            world2.setBlockToAir(blockPos);
        }
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion) {
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(EXPLODE, (n & 1) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(EXPLODE) != false ? 1 : 0;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, EXPLODE);
    }
}

