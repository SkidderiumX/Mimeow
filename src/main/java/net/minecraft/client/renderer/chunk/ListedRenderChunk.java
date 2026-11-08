/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class ListedRenderChunk
extends RenderChunk {
    private final int baseDisplayList = GLAllocation.generateDisplayLists(EnumWorldBlockLayer.values().length);

    public ListedRenderChunk(World world2, RenderGlobal renderGlobal, BlockPos blockPos, int n) {
        super(world2, renderGlobal, blockPos, n);
    }

    public int getDisplayList(EnumWorldBlockLayer enumWorldBlockLayer, CompiledChunk compiledChunk) {
        return !compiledChunk.isLayerEmpty(enumWorldBlockLayer) ? this.baseDisplayList + enumWorldBlockLayer.ordinal() : -1;
    }

    @Override
    public void deleteGlResources() {
        super.deleteGlResources();
        GLAllocation.deleteDisplayLists(this.baseDisplayList, EnumWorldBlockLayer.values().length);
    }
}

