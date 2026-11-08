/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.nio.IntBuffer;
import net.minecraft.client.renderer.ChunkRenderContainer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.chunk.ListedRenderChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.src.Config;
import net.minecraft.util.EnumWorldBlockLayer;
import x.oc170ea29aae;

public class RenderList
extends ChunkRenderContainer {
    private double viewEntityX;
    private double viewEntityY;
    private double viewEntityZ;
    IntBuffer bufferLists = GLAllocation.createDirectIntBuffer(16);

    @Override
    public void renderChunkLayer(EnumWorldBlockLayer enumWorldBlockLayer) {
        if (this.initialized) {
            if (!Config.isRenderRegions()) {
                for (RenderChunk renderChunk : this.renderChunks) {
                    ListedRenderChunk listedRenderChunk = (ListedRenderChunk)renderChunk;
                    GlStateManager.pushMatrix();
                    this.preRenderChunk(renderChunk);
                    oc170ea29aae.\u0146(listedRenderChunk.getDisplayList(enumWorldBlockLayer, listedRenderChunk.getCompiledChunk()));
                    GlStateManager.popMatrix();
                }
            } else {
                int n = Integer.MIN_VALUE;
                int n2 = Integer.MIN_VALUE;
                for (RenderChunk renderChunk : this.renderChunks) {
                    ListedRenderChunk listedRenderChunk = (ListedRenderChunk)renderChunk;
                    if (n != renderChunk.regionX || n2 != renderChunk.regionZ) {
                        if (this.bufferLists.position() > 0) {
                            this.drawRegion(n, n2, this.bufferLists);
                        }
                        n = renderChunk.regionX;
                        n2 = renderChunk.regionZ;
                    }
                    if (this.bufferLists.position() >= this.bufferLists.capacity()) {
                        IntBuffer intBuffer = GLAllocation.createDirectIntBuffer(this.bufferLists.capacity() * 2);
                        this.bufferLists.flip();
                        intBuffer.put(this.bufferLists);
                        this.bufferLists = intBuffer;
                    }
                    this.bufferLists.put(listedRenderChunk.getDisplayList(enumWorldBlockLayer, listedRenderChunk.getCompiledChunk()));
                }
                if (this.bufferLists.position() > 0) {
                    this.drawRegion(n, n2, this.bufferLists);
                }
            }
            if (Config.isMultiTexture()) {
                GlStateManager.bindCurrentTexture();
            }
            GlStateManager.resetColor();
            this.renderChunks.clear();
        }
    }

    @Override
    public void initialize(double d, double d2, double d3) {
        this.viewEntityX = d;
        this.viewEntityY = d2;
        this.viewEntityZ = d3;
        super.initialize(d, d2, d3);
    }

    private void drawRegion(int n, int n2, IntBuffer intBuffer) {
        GlStateManager.pushMatrix();
        this.preRenderRegion(n, 0, n2);
        intBuffer.flip();
        GlStateManager.callLists(intBuffer);
        intBuffer.clear();
        GlStateManager.popMatrix();
    }

    public void preRenderRegion(int n, int n2, int n3) {
        GlStateManager.translate((float)((double)n - this.viewEntityX), (float)((double)n2 - this.viewEntityY), (float)((double)n3 - this.viewEntityZ));
    }
}

