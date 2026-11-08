/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGLUframebuffer")
public class NVGLUFramebuffer
extends Struct<NVGLUFramebuffer> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int FBO;
    public static final int RBO;
    public static final int TEXTURE;
    public static final int IMAGE;

    protected NVGLUFramebuffer(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NVGLUFramebuffer create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NVGLUFramebuffer(l, byteBuffer);
    }

    public NVGLUFramebuffer(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NVGLUFramebuffer.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="GLuint")
    public int fbo() {
        return NVGLUFramebuffer.nfbo(this.address());
    }

    @NativeType(value="GLuint")
    public int rbo() {
        return NVGLUFramebuffer.nrbo(this.address());
    }

    @NativeType(value="GLuint")
    public int texture() {
        return NVGLUFramebuffer.ntexture(this.address());
    }

    public int image() {
        return NVGLUFramebuffer.nimage(this.address());
    }

    public static NVGLUFramebuffer create(long l) {
        return new NVGLUFramebuffer(l, null);
    }

    public static @Nullable NVGLUFramebuffer createSafe(long l) {
        return l == 0L ? null : new NVGLUFramebuffer(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static int nfbo(long l) {
        return MemoryUtil.memGetInt(l + (long)FBO);
    }

    public static int nrbo(long l) {
        return MemoryUtil.memGetInt(l + (long)RBO);
    }

    public static int ntexture(long l) {
        return MemoryUtil.memGetInt(l + (long)TEXTURE);
    }

    public static int nimage(long l) {
        return MemoryUtil.memGetInt(l + (long)IMAGE);
    }

    static {
        Struct.Layout layout = NVGLUFramebuffer.__struct(NVGLUFramebuffer.__member(4), NVGLUFramebuffer.__member(4), NVGLUFramebuffer.__member(4), NVGLUFramebuffer.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        FBO = layout.offsetof(0);
        RBO = layout.offsetof(1);
        TEXTURE = layout.offsetof(2);
        IMAGE = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NVGLUFramebuffer, Buffer> {
        private static final NVGLUFramebuffer ELEMENT_FACTORY = NVGLUFramebuffer.create(-1L);

        public Buffer(ByteBuffer byteBuffer) {
            super(byteBuffer, byteBuffer.remaining() / SIZEOF);
        }

        public Buffer(long l, int n) {
            super(l, null, -1, 0, n, n);
        }

        Buffer(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
            super(l, byteBuffer, n, n2, n3, n4);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer create(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
            return new Buffer(l, byteBuffer, n, n2, n3, n4);
        }

        @Override
        protected NVGLUFramebuffer getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="GLuint")
        public int fbo() {
            return NVGLUFramebuffer.nfbo(this.address());
        }

        @NativeType(value="GLuint")
        public int rbo() {
            return NVGLUFramebuffer.nrbo(this.address());
        }

        @NativeType(value="GLuint")
        public int texture() {
            return NVGLUFramebuffer.ntexture(this.address());
        }

        public int image() {
            return NVGLUFramebuffer.nimage(this.address());
        }
    }
}

