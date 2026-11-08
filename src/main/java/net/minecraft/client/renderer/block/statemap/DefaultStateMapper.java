/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public class DefaultStateMapper
extends StateMapperBase {
    @Override
    protected ModelResourceLocation getModelResourceLocation(IBlockState iBlockState) {
        return new ModelResourceLocation((ResourceLocation)Block.blockRegistry.getNameForObject(iBlockState.getBlock()), this.getPropertyString(iBlockState.getProperties()));
    }
}

