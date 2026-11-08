/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class POINT
extends Struct<POINT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    protected POINT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected POINT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new POINT(l, byteBuffer);
    }

    public POINT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), POINT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int x() {
        return POINT.nx(this.address());
    }

    @NativeType(value="LONG")
    public int y() {
        return POINT.ny(this.address());
    }

    public POINT x(@NativeType(value="LONG") int n) {
        POINT.nx(this.address(), n);
        return this;
    }

    public POINT y(@NativeType(value="LONG") int n) {
        POINT.ny(this.address(), n);
        return this;
    }

    public POINT set(int n, int n2) {
        this.x(n);
        this.y(n2);
        return this;
    }

    public POINT set(POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), this.address(), SIZEOF);
        return this;
    }

    public static POINT malloc() {
        return new POINT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static POINT calloc() {
        return new POINT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static POINT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new POINT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static POINT create(long l) {
        return new POINT(l, null);
    }

    public static @Nullable POINT createSafe(long l) {
        return l == 0L ? null : new POINT(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(POINT.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = POINT.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static POINT mallocStack() {
        return POINT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINT callocStack() {
        return POINT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINT mallocStack(MemoryStack memoryStack) {
        return POINT.malloc(memoryStack);
    }

    @Deprecated
    public static POINT callocStack(MemoryStack memoryStack) {
        return POINT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return POINT.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return POINT.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return POINT.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return POINT.calloc(n, memoryStack);
    }

    public static POINT malloc(MemoryStack memoryStack) {
        return new POINT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static POINT calloc(MemoryStack memoryStack) {
        return new POINT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nx(long l) {
        return MemoryUtil.memGetInt(l + (long)X);
    }

    public static int ny(long l) {
        return MemoryUtil.memGetInt(l + (long)Y);
    }

    public static void nx(long l, int n) {
        MemoryUtil.memPutInt(l + (long)X, n);
    }

    public static void ny(long l, int n) {
        MemoryUtil.memPutInt(l + (long)Y, n);
    }

    static {
        Struct.Layout layout = POINT.__struct(POINT.__member(4), POINT.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<POINT, Buffer>
    implements NativeResource {
        private static final POINT ELEMENT_FACTORY = POINT.create(-1L);

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
        protected POINT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int x() {
            return POINT.nx(this.address());
        }

        @NativeType(value="LONG")
        public int y() {
            return POINT.ny(this.address());
        }

        public Buffer x(@NativeType(value="LONG") int n) {
            POINT.nx(this.address(), n);
            return this;
        }

        public Buffer y(@NativeType(value="LONG") int n) {
            POINT.ny(this.address(), n);
            return this;
        }
    }
}

