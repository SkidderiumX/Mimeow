/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Rotations;
import net.minecraft.world.World;

public class ItemArmorStand
extends Item {
    public ItemArmorStand() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        double d;
        double d2;
        BlockPos blockPos2;
        if (enumFacing == EnumFacing.DOWN) {
            return false;
        }
        boolean bl = world2.getBlockState(blockPos).getBlock().isReplaceable(world2, blockPos);
        BlockPos blockPos3 = blockPos2 = bl ? blockPos : blockPos.offset(enumFacing);
        if (!entityPlayer.canPlayerEdit(blockPos2, enumFacing, itemStack)) {
            return false;
        }
        BlockPos blockPos4 = blockPos2.up();
        boolean bl2 = !world2.isAirBlock(blockPos2) && !world2.getBlockState(blockPos2).getBlock().isReplaceable(world2, blockPos2);
        if (bl2 |= !world2.isAirBlock(blockPos4) && !world2.getBlockState(blockPos4).getBlock().isReplaceable(world2, blockPos4)) {
            return false;
        }
        double d3 = blockPos2.getX();
        List<Entity> list = world2.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB.fromBounds(d3, d2 = (double)blockPos2.getY(), d = (double)blockPos2.getZ(), d3 + 1.0, d2 + 2.0, d + 1.0));
        if (list.size() > 0) {
            return false;
        }
        if (!world2.isRemote) {
            world2.setBlockToAir(blockPos2);
            world2.setBlockToAir(blockPos4);
            EntityArmorStand entityArmorStand = new EntityArmorStand(world2, d3 + 0.5, d2, d + 0.5);
            float f4 = (float)MathHelper.floor_float((MathHelper.wrapAngleTo180_float(entityPlayer.rotationYaw - 180.0f) + 22.5f) / 45.0f) * 45.0f;
            entityArmorStand.setLocationAndAngles(d3 + 0.5, d2, d + 0.5, f4, 0.0f);
            this.applyRandomRotations(entityArmorStand, world2.rand);
            NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
            if (nBTTagCompound != null && nBTTagCompound.hasKey("EntityTag", 10)) {
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                entityArmorStand.writeToNBTOptional(nBTTagCompound2);
                nBTTagCompound2.merge(nBTTagCompound.getCompoundTag("EntityTag"));
                entityArmorStand.readFromNBT(nBTTagCompound2);
            }
            world2.spawnEntityInWorld(entityArmorStand);
        }
        --itemStack.stackSize;
        return true;
    }

    private void applyRandomRotations(EntityArmorStand entityArmorStand, Random random) {
        Rotations rotations = entityArmorStand.getHeadRotation();
        float f = random.nextFloat() * 5.0f;
        float f2 = random.nextFloat() * 20.0f - 10.0f;
        Rotations rotations2 = new Rotations(rotations.getX() + f, rotations.getY() + f2, rotations.getZ());
        entityArmorStand.setHeadRotation(rotations2);
        rotations = entityArmorStand.getBodyRotation();
        f = random.nextFloat() * 10.0f - 5.0f;
        rotations2 = new Rotations(rotations.getX(), rotations.getY() + f, rotations.getZ());
        entityArmorStand.setBodyRotation(rotations2);
    }
}

