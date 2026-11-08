/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.src.Config;

public class VertexBufferUploader
extends WorldVertexBufferUploader {
    private VertexBuffer vertexBuffer = null;

    @Override
    public void draw(WorldRenderer worldRenderer) {
        if (this.vertexBuffer == null || worldRenderer == null) {
            if (worldRenderer != null) {
                worldRenderer.reset();
            }
            return;
        }
        if (worldRenderer.getDrawMode() == 7 && Config.isQuadsToTriangles()) {
            worldRenderer.quadsToTriangles();
            this.vertexBuffer.setDrawMode(worldRenderer.getDrawMode());
        }
        this.vertexBuffer.bufferData(worldRenderer.getByteBuffer());
        worldRenderer.reset();
    }

    public void setVertexBuffer(VertexBuffer vertexBuffer) {
        this.vertexBuffer = vertexBuffer;
    }
}

