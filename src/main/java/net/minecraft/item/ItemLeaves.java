/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeaves
extends ItemBlock {
    private final BlockLeaves leaves;

    public ItemLeaves(BlockLeaves blockLeaves) {
        super(blockLeaves);
        this.leaves = blockLeaves;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int n) {
        return n | 4;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return this.leaves.getRenderColor(this.leaves.getStateFromMeta(itemStack.getMetadata()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + this.leaves.getWoodType(itemStack.getMetadata()).getUnlocalizedName();
    }
}

