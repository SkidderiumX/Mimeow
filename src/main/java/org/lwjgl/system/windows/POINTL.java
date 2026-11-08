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

public class POINTL
extends Struct<POINTL>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    protected POINTL(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected POINTL create(long l, @Nullable ByteBuffer byteBuffer) {
        return new POINTL(l, byteBuffer);
    }

    public POINTL(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), POINTL.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int x() {
        return POINTL.nx(this.address());
    }

    @NativeType(value="LONG")
    public int y() {
        return POINTL.ny(this.address());
    }

    public POINTL x(@NativeType(value="LONG") int n) {
        POINTL.nx(this.address(), n);
        return this;
    }

    public POINTL y(@NativeType(value="LONG") int n) {
        POINTL.ny(this.address(), n);
        return this;
    }

    public POINTL set(int n, int n2) {
        this.x(n);
        this.y(n2);
        return this;
    }

    public POINTL set(POINTL pOINTL) {
        MemoryUtil.memCopy(pOINTL.address(), this.address(), SIZEOF);
        return this;
    }

    public static POINTL malloc() {
        return new POINTL(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static POINTL calloc() {
        return new POINTL(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static POINTL create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new POINTL(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static POINTL create(long l) {
        return new POINTL(l, null);
    }

    public static @Nullable POINTL createSafe(long l) {
        return l == 0L ? null : new POINTL(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(POINTL.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = POINTL.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static POINTL mallocStack() {
        return POINTL.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINTL callocStack() {
        return POINTL.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINTL mallocStack(MemoryStack memoryStack) {
        return POINTL.malloc(memoryStack);
    }

    @Deprecated
    public static POINTL callocStack(MemoryStack memoryStack) {
        return POINTL.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return POINTL.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return POINTL.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return POINTL.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return POINTL.calloc(n, memoryStack);
    }

    public static POINTL malloc(MemoryStack memoryStack) {
        return new POINTL(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static POINTL calloc(MemoryStack memoryStack) {
        return new POINTL(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
        Struct.Layout layout = POINTL.__struct(POINTL.__member(4), POINTL.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<POINTL, Buffer>
    implements NativeResource {
        private static final POINTL ELEMENT_FACTORY = POINTL.create(-1L);

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
        protected POINTL getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int x() {
            return POINTL.nx(this.address());
        }

        @NativeType(value="LONG")
        public int y() {
            return POINTL.ny(this.address());
        }

        public Buffer x(@NativeType(value="LONG") int n) {
            POINTL.nx(this.address(), n);
            return this;
        }

        public Buffer y(@NativeType(value="LONG") int n) {
            POINTL.ny(this.address(), n);
            return this;
        }
    }
}

