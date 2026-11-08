/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemHangingEntity
extends Item {
    private final Class<? extends EntityHanging> hangingEntityClass;

    public ItemHangingEntity(Class<? extends EntityHanging> clazz) {
        this.hangingEntityClass = clazz;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        if (enumFacing == EnumFacing.DOWN) {
            return false;
        }
        if (enumFacing == EnumFacing.UP) {
            return false;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        if (!entityPlayer.canPlayerEdit(blockPos2, enumFacing, itemStack)) {
            return false;
        }
        EntityHanging entityHanging = this.createEntity(world2, blockPos2, enumFacing);
        if (entityHanging != null && entityHanging.onValidSurface()) {
            if (!world2.isRemote) {
                world2.spawnEntityInWorld(entityHanging);
            }
            --itemStack.stackSize;
        }
        return true;
    }

    private EntityHanging createEntity(World world2, BlockPos blockPos, EnumFacing enumFacing) {
        return this.hangingEntityClass == EntityPainting.class ? new EntityPainting(world2, blockPos, enumFacing) : (this.hangingEntityClass == EntityItemFrame.class ? new EntityItemFrame(world2, blockPos, enumFacing) : null);
    }
}

