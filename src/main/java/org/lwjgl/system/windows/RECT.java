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

public class RECT
extends Struct<RECT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LEFT;
    public static final int TOP;
    public static final int RIGHT;
    public static final int BOTTOM;

    protected RECT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected RECT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new RECT(l, byteBuffer);
    }

    public RECT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), RECT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int left() {
        return RECT.nleft(this.address());
    }

    @NativeType(value="LONG")
    public int top() {
        return RECT.ntop(this.address());
    }

    @NativeType(value="LONG")
    public int right() {
        return RECT.nright(this.address());
    }

    @NativeType(value="LONG")
    public int bottom() {
        return RECT.nbottom(this.address());
    }

    public RECT left(@NativeType(value="LONG") int n) {
        RECT.nleft(this.address(), n);
        return this;
    }

    public RECT top(@NativeType(value="LONG") int n) {
        RECT.ntop(this.address(), n);
        return this;
    }

    public RECT right(@NativeType(value="LONG") int n) {
        RECT.nright(this.address(), n);
        return this;
    }

    public RECT bottom(@NativeType(value="LONG") int n) {
        RECT.nbottom(this.address(), n);
        return this;
    }

    public RECT set(int n, int n2, int n3, int n4) {
        this.left(n);
        this.top(n2);
        this.right(n3);
        this.bottom(n4);
        return this;
    }

    public RECT set(RECT rECT) {
        MemoryUtil.memCopy(rECT.address(), this.address(), SIZEOF);
        return this;
    }

    public static RECT malloc() {
        return new RECT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static RECT calloc() {
        return new RECT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static RECT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new RECT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static RECT create(long l) {
        return new RECT(l, null);
    }

    public static @Nullable RECT createSafe(long l) {
        return l == 0L ? null : new RECT(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(RECT.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = RECT.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static RECT mallocStack() {
        return RECT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static RECT callocStack() {
        return RECT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static RECT mallocStack(MemoryStack memoryStack) {
        return RECT.malloc(memoryStack);
    }

    @Deprecated
    public static RECT callocStack(MemoryStack memoryStack) {
        return RECT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return RECT.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return RECT.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return RECT.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return RECT.calloc(n, memoryStack);
    }

    public static RECT malloc(MemoryStack memoryStack) {
        return new RECT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static RECT calloc(MemoryStack memoryStack) {
        return new RECT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nleft(long l) {
        return MemoryUtil.memGetInt(l + (long)LEFT);
    }

    public static int ntop(long l) {
        return MemoryUtil.memGetInt(l + (long)TOP);
    }

    public static int nright(long l) {
        return MemoryUtil.memGetInt(l + (long)RIGHT);
    }

    public static int nbottom(long l) {
        return MemoryUtil.memGetInt(l + (long)BOTTOM);
    }

    public static void nleft(long l, int n) {
        MemoryUtil.memPutInt(l + (long)LEFT, n);
    }

    public static void ntop(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TOP, n);
    }

    public static void nright(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RIGHT, n);
    }

    public static void nbottom(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BOTTOM, n);
    }

    static {
        Struct.Layout layout = RECT.__struct(RECT.__member(4), RECT.__member(4), RECT.__member(4), RECT.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        LEFT = layout.offsetof(0);
        TOP = layout.offsetof(1);
        RIGHT = layout.offsetof(2);
        BOTTOM = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<RECT, Buffer>
    implements NativeResource {
        private static final RECT ELEMENT_FACTORY = RECT.create(-1L);

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
        protected RECT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int left() {
            return RECT.nleft(this.address());
        }

        @NativeType(value="LONG")
        public int top() {
            return RECT.ntop(this.address());
        }

        @NativeType(value="LONG")
        public int right() {
            return RECT.nright(this.address());
        }

        @NativeType(value="LONG")
        public int bottom() {
            return RECT.nbottom(this.address());
        }

        public Buffer left(@NativeType(value="LONG") int n) {
            RECT.nleft(this.address(), n);
            return this;
        }

        public Buffer top(@NativeType(value="LONG") int n) {
            RECT.ntop(this.address(), n);
            return this;
        }

        public Buffer right(@NativeType(value="LONG") int n) {
            RECT.nright(this.address(), n);
            return this;
        }

        public Buffer bottom(@NativeType(value="LONG") int n) {
            RECT.nbottom(this.address(), n);
            return this;
        }
    }
}

