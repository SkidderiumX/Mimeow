/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemLead
extends Item {
    public ItemLead() {
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        Block block = world2.getBlockState(blockPos).getBlock();
        if (block instanceof BlockFence) {
            if (world2.isRemote) {
                return true;
            }
            ItemLead.attachToFence(entityPlayer, world2, blockPos);
            return true;
        }
        return false;
    }

    public static boolean attachToFence(EntityPlayer entityPlayer, World world2, BlockPos blockPos) {
        EntityLeashKnot entityLeashKnot = EntityLeashKnot.getKnotForPosition(world2, blockPos);
        boolean bl = false;
        double d = 7.0;
        int n = blockPos.getX();
        int n2 = blockPos.getY();
        int n3 = blockPos.getZ();
        for (EntityLiving entityLiving : world2.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB((double)n - d, (double)n2 - d, (double)n3 - d, (double)n + d, (double)n2 + d, (double)n3 + d))) {
            if (!entityLiving.getLeashed() || entityLiving.getLeashedToEntity() != entityPlayer) continue;
            if (entityLeashKnot == null) {
                entityLeashKnot = EntityLeashKnot.createKnot(world2, blockPos);
            }
            entityLiving.setLeashedToEntity(entityLeashKnot, true);
            bl = true;
        }
        return bl;
    }
}

