/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemFishingRod
extends Item {
    public ItemFishingRod() {
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        if (entityPlayer.fishEntity != null) {
            int n = entityPlayer.fishEntity.handleHookRetraction();
            itemStack.damageItem(n, entityPlayer);
            entityPlayer.swingItem();
        } else {
            world2.playSoundAtEntity(entityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world2.isRemote) {
                world2.spawnEntityInWorld(new EntityFishHook(world2, entityPlayer));
            }
            entityPlayer.swingItem();
            entityPlayer.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        }
        return itemStack;
    }

    @Override
    public boolean isItemTool(ItemStack itemStack) {
        return super.isItemTool(itemStack);
    }

    @Override
    public int getItemEnchantability() {
        return 1;
    }
}

