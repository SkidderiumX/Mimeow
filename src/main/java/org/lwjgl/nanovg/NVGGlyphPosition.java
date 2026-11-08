/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGglyphPosition")
public class NVGGlyphPosition
extends Struct<NVGGlyphPosition>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int STR;
    public static final int X;
    public static final int MINX;
    public static final int MAXX;

    protected NVGGlyphPosition(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NVGGlyphPosition create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NVGGlyphPosition(l, byteBuffer);
    }

    public NVGGlyphPosition(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NVGGlyphPosition.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public long str() {
        return NVGGlyphPosition.nstr(this.address());
    }

    public float x() {
        return NVGGlyphPosition.nx(this.address());
    }

    public float minx() {
        return NVGGlyphPosition.nminx(this.address());
    }

    public float maxx() {
        return NVGGlyphPosition.nmaxx(this.address());
    }

    public static NVGGlyphPosition malloc() {
        return new NVGGlyphPosition(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGGlyphPosition calloc() {
        return new NVGGlyphPosition(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGGlyphPosition create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGGlyphPosition(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static NVGGlyphPosition create(long l) {
        return new NVGGlyphPosition(l, null);
    }

    public static @Nullable NVGGlyphPosition createSafe(long l) {
        return l == 0L ? null : new NVGGlyphPosition(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGGlyphPosition.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = NVGGlyphPosition.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static NVGGlyphPosition mallocStack() {
        return NVGGlyphPosition.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGGlyphPosition callocStack() {
        return NVGGlyphPosition.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGGlyphPosition mallocStack(MemoryStack memoryStack) {
        return NVGGlyphPosition.malloc(memoryStack);
    }

    @Deprecated
    public static NVGGlyphPosition callocStack(MemoryStack memoryStack) {
        return NVGGlyphPosition.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return NVGGlyphPosition.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return NVGGlyphPosition.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return NVGGlyphPosition.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return NVGGlyphPosition.calloc(n, memoryStack);
    }

    public static NVGGlyphPosition malloc(MemoryStack memoryStack) {
        return new NVGGlyphPosition(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGGlyphPosition calloc(MemoryStack memoryStack) {
        return new NVGGlyphPosition(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nstr(long l) {
        return MemoryUtil.memGetAddress(l + (long)STR);
    }

    public static float nx(long l) {
        return MemoryUtil.memGetFloat(l + (long)X);
    }

    public static float nminx(long l) {
        return MemoryUtil.memGetFloat(l + (long)MINX);
    }

    public static float nmaxx(long l) {
        return MemoryUtil.memGetFloat(l + (long)MAXX);
    }

    static {
        Struct.Layout layout = NVGGlyphPosition.__struct(NVGGlyphPosition.__member(POINTER_SIZE), NVGGlyphPosition.__member(4), NVGGlyphPosition.__member(4), NVGGlyphPosition.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        STR = layout.offsetof(0);
        X = layout.offsetof(1);
        MINX = layout.offsetof(2);
        MAXX = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NVGGlyphPosition, Buffer>
    implements NativeResource {
        private static final NVGGlyphPosition ELEMENT_FACTORY = NVGGlyphPosition.create(-1L);

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
        protected NVGGlyphPosition getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public long str() {
            return NVGGlyphPosition.nstr(this.address());
        }

        public float x() {
            return NVGGlyphPosition.nx(this.address());
        }

        public float minx() {
            return NVGGlyphPosition.nminx(this.address());
        }

        public float maxx() {
            return NVGGlyphPosition.nmaxx(this.address());
        }
    }
}

