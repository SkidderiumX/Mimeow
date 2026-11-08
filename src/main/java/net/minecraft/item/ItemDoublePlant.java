/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.base.Function;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerGrass;

public class ItemDoublePlant
extends ItemMultiTexture {
    public ItemDoublePlant(Block block, Block block2, Function<ItemStack, String> function) {
        super(block, block2, function);
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        BlockDoublePlant.EnumPlantType enumPlantType = BlockDoublePlant.EnumPlantType.byMetadata(itemStack.getMetadata());
        return enumPlantType != BlockDoublePlant.EnumPlantType.GRASS && enumPlantType != BlockDoublePlant.EnumPlantType.FERN ? super.getColorFromItemStack(itemStack, n) : ColorizerGrass.getGrassColor(0.5, 1.0);
    }
}

