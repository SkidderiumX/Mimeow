/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import com.google.common.collect.Lists;
import java.util.BitSet;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.optifine.SmartAnimations;

public abstract class ChunkRenderContainer {
    private double viewEntityX;
    private double viewEntityY;
    private double viewEntityZ;
    protected List<RenderChunk> renderChunks = Lists.newArrayListWithCapacity(17424);
    protected boolean initialized;
    private BitSet animatedSpritesRendered;
    private final BitSet animatedSpritesCached = new BitSet();

    public void initialize(double d, double d2, double d3) {
        this.initialized = true;
        this.renderChunks.clear();
        this.viewEntityX = d;
        this.viewEntityY = d2;
        this.viewEntityZ = d3;
        if (SmartAnimations.isActive()) {
            if (this.animatedSpritesRendered != null) {
                SmartAnimations.spritesRendered(this.animatedSpritesRendered);
            } else {
                this.animatedSpritesRendered = this.animatedSpritesCached;
            }
            this.animatedSpritesRendered.clear();
        } else if (this.animatedSpritesRendered != null) {
            SmartAnimations.spritesRendered(this.animatedSpritesRendered);
            this.animatedSpritesRendered = null;
        }
    }

    public void preRenderChunk(RenderChunk renderChunk) {
        BlockPos blockPos = renderChunk.getPosition();
        GlStateManager.translate((float)((double)blockPos.getX() - this.viewEntityX), (float)((double)blockPos.getY() - this.viewEntityY), (float)((double)blockPos.getZ() - this.viewEntityZ));
    }

    public void addRenderChunk(RenderChunk renderChunk, EnumWorldBlockLayer enumWorldBlockLayer) {
        BitSet bitSet;
        this.renderChunks.add(renderChunk);
        if (this.animatedSpritesRendered != null && (bitSet = renderChunk.compiledChunk.getAnimatedSprites(enumWorldBlockLayer)) != null) {
            this.animatedSpritesRendered.or(bitSet);
        }
    }

    public abstract void renderChunkLayer(EnumWorldBlockLayer var1);
}

