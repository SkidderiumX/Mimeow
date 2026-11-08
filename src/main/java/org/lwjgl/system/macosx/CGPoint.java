/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class CGPoint
extends Struct<CGPoint>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    protected CGPoint(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected CGPoint create(long l, @Nullable ByteBuffer byteBuffer) {
        return new CGPoint(l, byteBuffer);
    }

    public CGPoint(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), CGPoint.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="CGFloat")
    public double x() {
        return CGPoint.nx(this.address());
    }

    @NativeType(value="CGFloat")
    public double y() {
        return CGPoint.ny(this.address());
    }

    public CGPoint x(@NativeType(value="CGFloat") double d) {
        CGPoint.nx(this.address(), d);
        return this;
    }

    public CGPoint y(@NativeType(value="CGFloat") double d) {
        CGPoint.ny(this.address(), d);
        return this;
    }

    public CGPoint set(double d, double d2) {
        this.x(d);
        this.y(d2);
        return this;
    }

    public CGPoint set(CGPoint cGPoint) {
        MemoryUtil.memCopy(cGPoint.address(), this.address(), SIZEOF);
        return this;
    }

    public static CGPoint malloc() {
        return new CGPoint(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CGPoint calloc() {
        return new CGPoint(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CGPoint create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new CGPoint(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static CGPoint create(long l) {
        return new CGPoint(l, null);
    }

    public static @Nullable CGPoint createSafe(long l) {
        return l == 0L ? null : new CGPoint(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(CGPoint.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = CGPoint.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static CGPoint mallocStack() {
        return CGPoint.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGPoint callocStack() {
        return CGPoint.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGPoint mallocStack(MemoryStack memoryStack) {
        return CGPoint.malloc(memoryStack);
    }

    @Deprecated
    public static CGPoint callocStack(MemoryStack memoryStack) {
        return CGPoint.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return CGPoint.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return CGPoint.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return CGPoint.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return CGPoint.calloc(n, memoryStack);
    }

    public static CGPoint malloc(MemoryStack memoryStack) {
        return new CGPoint(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CGPoint calloc(MemoryStack memoryStack) {
        return new CGPoint(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static double nx(long l) {
        return MemoryUtil.memGetDouble(l + (long)X);
    }

    public static double ny(long l) {
        return MemoryUtil.memGetDouble(l + (long)Y);
    }

    public static void nx(long l, double d) {
        MemoryUtil.memPutDouble(l + (long)X, d);
    }

    public static void ny(long l, double d) {
        MemoryUtil.memPutDouble(l + (long)Y, d);
    }

    static {
        Struct.Layout layout = CGPoint.__struct(CGPoint.__member(8), CGPoint.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<CGPoint, Buffer>
    implements NativeResource {
        private static final CGPoint ELEMENT_FACTORY = CGPoint.create(-1L);

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
        protected CGPoint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="CGFloat")
        public double x() {
            return CGPoint.nx(this.address());
        }

        @NativeType(value="CGFloat")
        public double y() {
            return CGPoint.ny(this.address());
        }

        public Buffer x(@NativeType(value="CGFloat") double d) {
            CGPoint.nx(this.address(), d);
            return this;
        }

        public Buffer y(@NativeType(value="CGFloat") double d) {
            CGPoint.ny(this.address(), d);
            return this;
        }
    }
}

