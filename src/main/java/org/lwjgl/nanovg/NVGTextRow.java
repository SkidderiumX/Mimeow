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

@NativeType(value="struct NVGtextRow")
public class NVGTextRow
extends Struct<NVGTextRow>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int START;
    public static final int END;
    public static final int NEXT;
    public static final int WIDTH;
    public static final int MINX;
    public static final int MAXX;

    protected NVGTextRow(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NVGTextRow create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NVGTextRow(l, byteBuffer);
    }

    public NVGTextRow(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NVGTextRow.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public long start() {
        return NVGTextRow.nstart(this.address());
    }

    @NativeType(value="char *")
    public long end() {
        return NVGTextRow.nend(this.address());
    }

    @NativeType(value="char *")
    public long next() {
        return NVGTextRow.nnext(this.address());
    }

    public float width() {
        return NVGTextRow.nwidth(this.address());
    }

    public float minx() {
        return NVGTextRow.nminx(this.address());
    }

    public float maxx() {
        return NVGTextRow.nmaxx(this.address());
    }

    public static NVGTextRow malloc() {
        return new NVGTextRow(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGTextRow calloc() {
        return new NVGTextRow(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGTextRow create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGTextRow(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static NVGTextRow create(long l) {
        return new NVGTextRow(l, null);
    }

    public static @Nullable NVGTextRow createSafe(long l) {
        return l == 0L ? null : new NVGTextRow(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGTextRow.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = NVGTextRow.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static NVGTextRow mallocStack() {
        return NVGTextRow.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGTextRow callocStack() {
        return NVGTextRow.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGTextRow mallocStack(MemoryStack memoryStack) {
        return NVGTextRow.malloc(memoryStack);
    }

    @Deprecated
    public static NVGTextRow callocStack(MemoryStack memoryStack) {
        return NVGTextRow.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return NVGTextRow.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return NVGTextRow.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return NVGTextRow.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return NVGTextRow.calloc(n, memoryStack);
    }

    public static NVGTextRow malloc(MemoryStack memoryStack) {
        return new NVGTextRow(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGTextRow calloc(MemoryStack memoryStack) {
        return new NVGTextRow(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nstart(long l) {
        return MemoryUtil.memGetAddress(l + (long)START);
    }

    public static long nend(long l) {
        return MemoryUtil.memGetAddress(l + (long)END);
    }

    public static long nnext(long l) {
        return MemoryUtil.memGetAddress(l + (long)NEXT);
    }

    public static float nwidth(long l) {
        return MemoryUtil.memGetFloat(l + (long)WIDTH);
    }

    public static float nminx(long l) {
        return MemoryUtil.memGetFloat(l + (long)MINX);
    }

    public static float nmaxx(long l) {
        return MemoryUtil.memGetFloat(l + (long)MAXX);
    }

    static {
        Struct.Layout layout = NVGTextRow.__struct(NVGTextRow.__member(POINTER_SIZE), NVGTextRow.__member(POINTER_SIZE), NVGTextRow.__member(POINTER_SIZE), NVGTextRow.__member(4), NVGTextRow.__member(4), NVGTextRow.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        START = layout.offsetof(0);
        END = layout.offsetof(1);
        NEXT = layout.offsetof(2);
        WIDTH = layout.offsetof(3);
        MINX = layout.offsetof(4);
        MAXX = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<NVGTextRow, Buffer>
    implements NativeResource {
        private static final NVGTextRow ELEMENT_FACTORY = NVGTextRow.create(-1L);

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
        protected NVGTextRow getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public long start() {
            return NVGTextRow.nstart(this.address());
        }

        @NativeType(value="char *")
        public long end() {
            return NVGTextRow.nend(this.address());
        }

        @NativeType(value="char *")
        public long next() {
            return NVGTextRow.nnext(this.address());
        }

        public float width() {
            return NVGTextRow.nwidth(this.address());
        }

        public float minx() {
            return NVGTextRow.nminx(this.address());
        }

        public float maxx() {
            return NVGTextRow.nmaxx(this.address());
        }
    }
}

