/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.render;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.VboRenderList;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.src.Config;
import net.minecraft.util.EnumWorldBlockLayer;
import net.optifine.render.VboRange;
import net.optifine.util.LinkedList;

public class VboRegion {
    private EnumWorldBlockLayer layer = null;
    private int glBufferId = OpenGlHelper.glGenBuffers();
    private int capacity = 4096;
    private int positionTop = 0;
    private int sizeUsed;
    private LinkedList<VboRange> rangeList = new LinkedList();
    private VboRange compactRangeLast = null;
    private IntBuffer bufferIndexVertex = Config.createDirectIntBuffer(this.capacity);
    private IntBuffer bufferCountVertex = Config.createDirectIntBuffer(this.capacity);
    private int drawMode = 7;
    private final int vertexBytes = DefaultVertexFormats.BLOCK.getNextOffset();

    public VboRegion(EnumWorldBlockLayer enumWorldBlockLayer) {
        this.layer = enumWorldBlockLayer;
        this.bindBuffer();
        long l = this.toBytes(this.capacity);
        OpenGlHelper.glBufferData(OpenGlHelper.GL_ARRAY_BUFFER, l, OpenGlHelper.GL_STATIC_DRAW);
        this.unbindBuffer();
    }

    public void bufferData(ByteBuffer byteBuffer, VboRange vboRange) {
        int n = vboRange.getPosition();
        int n2 = vboRange.getSize();
        int n3 = this.toVertex(byteBuffer.limit());
        if (n3 <= 0) {
            if (n >= 0) {
                vboRange.setPosition(-1);
                vboRange.setSize(0);
                this.rangeList.remove(vboRange.getNode());
                this.sizeUsed -= n2;
            }
        } else {
            if (n3 > n2) {
                vboRange.setPosition(this.positionTop);
                vboRange.setSize(n3);
                this.positionTop += n3;
                if (n >= 0) {
                    this.rangeList.remove(vboRange.getNode());
                }
                this.rangeList.addLast(vboRange.getNode());
            }
            vboRange.setSize(n3);
            this.sizeUsed += n3 - n2;
            this.checkVboSize(vboRange.getPositionNext());
            long l = this.toBytes(vboRange.getPosition());
            this.bindBuffer();
            OpenGlHelper.glBufferSubData(OpenGlHelper.GL_ARRAY_BUFFER, l, byteBuffer);
            this.unbindBuffer();
            if (this.positionTop > this.sizeUsed * 11 / 10) {
                this.compactRanges(1);
            }
        }
    }

    private void compactRanges(int n) {
        if (!this.rangeList.isEmpty()) {
            VboRange vboRange = this.compactRangeLast;
            if (vboRange == null || !this.rangeList.contains(vboRange.getNode())) {
                vboRange = this.rangeList.getFirst().getItem();
            }
            int n2 = vboRange.getPosition();
            VboRange vboRange2 = vboRange.getPrev();
            n2 = vboRange2 == null ? 0 : vboRange2.getPositionNext();
            for (int i = 0; vboRange != null && i < n; ++i) {
                if (vboRange.getPosition() == n2) {
                    n2 += vboRange.getSize();
                    vboRange = vboRange.getNext();
                    continue;
                }
                int n3 = vboRange.getPosition() - n2;
                if (vboRange.getSize() <= n3) {
                    this.copyVboData(vboRange.getPosition(), n2, vboRange.getSize());
                    vboRange.setPosition(n2);
                    n2 += vboRange.getSize();
                    vboRange = vboRange.getNext();
                    continue;
                }
                this.checkVboSize(this.positionTop + vboRange.getSize());
                this.copyVboData(vboRange.getPosition(), this.positionTop, vboRange.getSize());
                vboRange.setPosition(this.positionTop);
                this.positionTop += vboRange.getSize();
                VboRange vboRange3 = vboRange.getNext();
                this.rangeList.remove(vboRange.getNode());
                this.rangeList.addLast(vboRange.getNode());
                vboRange = vboRange3;
            }
            if (vboRange == null) {
                this.positionTop = this.rangeList.getLast().getItem().getPositionNext();
            }
            this.compactRangeLast = vboRange;
        }
    }

    private void checkRanges() {
        int n = 0;
        int n2 = 0;
        for (VboRange vboRange = this.rangeList.getFirst().getItem(); vboRange != null; vboRange = vboRange.getNext()) {
            ++n;
            n2 += vboRange.getSize();
            if (vboRange.getPosition() < 0 || vboRange.getSize() <= 0 || vboRange.getPositionNext() > this.positionTop) {
                throw new RuntimeException("Invalid range: " + String.valueOf(vboRange));
            }
            VboRange vboRange2 = vboRange.getPrev();
            if (vboRange2 != null && vboRange.getPosition() < vboRange2.getPositionNext()) {
                throw new RuntimeException("Invalid range: " + String.valueOf(vboRange));
            }
            VboRange vboRange3 = vboRange.getNext();
            if (vboRange3 == null || vboRange.getPositionNext() <= vboRange3.getPosition()) continue;
            throw new RuntimeException("Invalid range: " + String.valueOf(vboRange));
        }
        if (n != this.rangeList.getSize()) {
            throw new RuntimeException("Invalid count: " + n + " <> " + this.rangeList.getSize());
        }
        if (n2 != this.sizeUsed) {
            throw new RuntimeException("Invalid size: " + n2 + " <> " + this.sizeUsed);
        }
    }

    private void checkVboSize(int n) {
        if (this.capacity < n) {
            this.expandVbo(n);
        }
    }

    private void copyVboData(int n, int n2, int n3) {
        long l = this.toBytes(n);
        long l2 = this.toBytes(n2);
        long l3 = this.toBytes(n3);
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_READ_BUFFER, this.glBufferId);
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_WRITE_BUFFER, this.glBufferId);
        OpenGlHelper.glCopyBufferSubData(OpenGlHelper.GL_COPY_READ_BUFFER, OpenGlHelper.GL_COPY_WRITE_BUFFER, l, l2, l3);
        Config.checkGlError("Copy VBO range");
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_READ_BUFFER, 0);
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_WRITE_BUFFER, 0);
    }

    private void expandVbo(int n) {
        int n2 = this.capacity * 6 / 4;
        while (n2 < n) {
            n2 = n2 * 6 / 4;
        }
        long l = this.toBytes(this.capacity);
        long l2 = this.toBytes(n2);
        int n3 = OpenGlHelper.glGenBuffers();
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, n3);
        OpenGlHelper.glBufferData(OpenGlHelper.GL_ARRAY_BUFFER, l2, OpenGlHelper.GL_STATIC_DRAW);
        Config.checkGlError("Expand VBO");
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_READ_BUFFER, this.glBufferId);
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_WRITE_BUFFER, n3);
        OpenGlHelper.glCopyBufferSubData(OpenGlHelper.GL_COPY_READ_BUFFER, OpenGlHelper.GL_COPY_WRITE_BUFFER, 0L, 0L, l);
        Config.checkGlError("Copy VBO: " + l2);
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_READ_BUFFER, 0);
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_COPY_WRITE_BUFFER, 0);
        OpenGlHelper.glDeleteBuffers(this.glBufferId);
        this.bufferIndexVertex = Config.createDirectIntBuffer(n2);
        this.bufferCountVertex = Config.createDirectIntBuffer(n2);
        this.glBufferId = n3;
        this.capacity = n2;
    }

    public void bindBuffer() {
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, this.glBufferId);
    }

    public void drawArrays(int n, VboRange vboRange) {
        if (this.drawMode != n) {
            if (this.bufferIndexVertex.position() > 0) {
                throw new IllegalArgumentException("Mixed region draw modes: " + this.drawMode + " != " + n);
            }
            this.drawMode = n;
        }
        this.bufferIndexVertex.put(vboRange.getPosition());
        this.bufferCountVertex.put(vboRange.getSize());
    }

    public void finishDraw(VboRenderList vboRenderList) {
        this.bindBuffer();
        vboRenderList.setupArrayPointers();
        this.bufferIndexVertex.flip();
        this.bufferCountVertex.flip();
        GlStateManager.glMultiDrawArrays(this.drawMode, this.bufferIndexVertex, this.bufferCountVertex);
        this.bufferIndexVertex.limit(this.bufferIndexVertex.capacity());
        this.bufferCountVertex.limit(this.bufferCountVertex.capacity());
        if (this.positionTop > this.sizeUsed * 11 / 10) {
            this.compactRanges(1);
        }
    }

    public void unbindBuffer() {
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
    }

    public void deleteGlBuffers() {
        if (this.glBufferId >= 0) {
            OpenGlHelper.glDeleteBuffers(this.glBufferId);
            this.glBufferId = -1;
        }
    }

    private long toBytes(int n) {
        return (long)n * (long)this.vertexBytes;
    }

    private int toVertex(long l) {
        return (int)(l / (long)this.vertexBytes);
    }

    public int getPositionTop() {
        return this.positionTop;
    }
}

