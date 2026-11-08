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
public class NVGLUFramebufferBGFX
extends Struct<NVGLUFramebufferBGFX> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CTX;
    public static final int HANDLE;
    public static final int IMAGE;
    public static final int VIEWID;

    protected NVGLUFramebufferBGFX(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NVGLUFramebufferBGFX create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NVGLUFramebufferBGFX(l, byteBuffer);
    }

    public NVGLUFramebufferBGFX(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NVGLUFramebufferBGFX.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcontext *")
    public long ctx() {
        return NVGLUFramebufferBGFX.nctx(this.address());
    }

    @NativeType(value="bgfx_frame_buffer_handle_t")
    public short handle() {
        return NVGLUFramebufferBGFX.nhandle(this.address());
    }

    public int image() {
        return NVGLUFramebufferBGFX.nimage(this.address());
    }

    @NativeType(value="bgfx_view_id_t")
    public short viewId() {
        return NVGLUFramebufferBGFX.nviewId(this.address());
    }

    public static NVGLUFramebufferBGFX create(long l) {
        return new NVGLUFramebufferBGFX(l, null);
    }

    public static @Nullable NVGLUFramebufferBGFX createSafe(long l) {
        return l == 0L ? null : new NVGLUFramebufferBGFX(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static long nctx(long l) {
        return MemoryUtil.memGetAddress(l + (long)CTX);
    }

    public static short nhandle(long l) {
        return MemoryUtil.memGetShort(l + (long)HANDLE);
    }

    public static int nimage(long l) {
        return MemoryUtil.memGetInt(l + (long)IMAGE);
    }

    public static short nviewId(long l) {
        return MemoryUtil.memGetShort(l + (long)VIEWID);
    }

    static {
        Struct.Layout layout = NVGLUFramebufferBGFX.__struct(NVGLUFramebufferBGFX.__member(POINTER_SIZE), NVGLUFramebufferBGFX.__member(2), NVGLUFramebufferBGFX.__member(4), NVGLUFramebufferBGFX.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CTX = layout.offsetof(0);
        HANDLE = layout.offsetof(1);
        IMAGE = layout.offsetof(2);
        VIEWID = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NVGLUFramebufferBGFX, Buffer> {
        private static final NVGLUFramebufferBGFX ELEMENT_FACTORY = NVGLUFramebufferBGFX.create(-1L);

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
        protected NVGLUFramebufferBGFX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcontext *")
        public long ctx() {
            return NVGLUFramebufferBGFX.nctx(this.address());
        }

        @NativeType(value="bgfx_frame_buffer_handle_t")
        public short handle() {
            return NVGLUFramebufferBGFX.nhandle(this.address());
        }

        public int image() {
            return NVGLUFramebufferBGFX.nimage(this.address());
        }

        @NativeType(value="bgfx_view_id_t")
        public short viewId() {
            return NVGLUFramebufferBGFX.nviewId(this.address());
        }
    }
}

