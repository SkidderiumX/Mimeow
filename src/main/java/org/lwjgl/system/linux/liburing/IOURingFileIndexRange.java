/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_file_index_range")
public class IOURingFileIndexRange
extends Struct<IOURingFileIndexRange>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OFF;
    public static final int LEN;
    public static final int RESV;

    protected IOURingFileIndexRange(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingFileIndexRange create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingFileIndexRange(l, byteBuffer);
    }

    public IOURingFileIndexRange(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingFileIndexRange.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int off() {
        return IOURingFileIndexRange.noff(this.address());
    }

    @NativeType(value="__u32")
    public int len() {
        return IOURingFileIndexRange.nlen(this.address());
    }

    public IOURingFileIndexRange off(@NativeType(value="__u32") int n) {
        IOURingFileIndexRange.noff(this.address(), n);
        return this;
    }

    public IOURingFileIndexRange len(@NativeType(value="__u32") int n) {
        IOURingFileIndexRange.nlen(this.address(), n);
        return this;
    }

    public IOURingFileIndexRange set(int n, int n2) {
        this.off(n);
        this.len(n2);
        return this;
    }

    public IOURingFileIndexRange set(IOURingFileIndexRange iOURingFileIndexRange) {
        MemoryUtil.memCopy(iOURingFileIndexRange.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingFileIndexRange malloc() {
        return new IOURingFileIndexRange(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingFileIndexRange calloc() {
        return new IOURingFileIndexRange(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingFileIndexRange create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingFileIndexRange(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingFileIndexRange create(long l) {
        return new IOURingFileIndexRange(l, null);
    }

    public static @Nullable IOURingFileIndexRange createSafe(long l) {
        return l == 0L ? null : new IOURingFileIndexRange(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingFileIndexRange.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingFileIndexRange.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingFileIndexRange malloc(MemoryStack memoryStack) {
        return new IOURingFileIndexRange(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingFileIndexRange calloc(MemoryStack memoryStack) {
        return new IOURingFileIndexRange(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int noff(long l) {
        return MemoryUtil.memGetInt(l + (long)OFF);
    }

    public static int nlen(long l) {
        return MemoryUtil.memGetInt(l + (long)LEN);
    }

    public static long nresv(long l) {
        return MemoryUtil.memGetLong(l + (long)RESV);
    }

    public static void noff(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OFF, n);
    }

    public static void nlen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)LEN, n);
    }

    public static void nresv(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)RESV, l2);
    }

    static {
        Struct.Layout layout = IOURingFileIndexRange.__struct(IOURingFileIndexRange.__member(4), IOURingFileIndexRange.__member(4), IOURingFileIndexRange.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OFF = layout.offsetof(0);
        LEN = layout.offsetof(1);
        RESV = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<IOURingFileIndexRange, Buffer>
    implements NativeResource {
        private static final IOURingFileIndexRange ELEMENT_FACTORY = IOURingFileIndexRange.create(-1L);

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
        protected IOURingFileIndexRange getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int off() {
            return IOURingFileIndexRange.noff(this.address());
        }

        @NativeType(value="__u32")
        public int len() {
            return IOURingFileIndexRange.nlen(this.address());
        }

        public Buffer off(@NativeType(value="__u32") int n) {
            IOURingFileIndexRange.noff(this.address(), n);
            return this;
        }

        public Buffer len(@NativeType(value="__u32") int n) {
            IOURingFileIndexRange.nlen(this.address(), n);
            return this;
        }
    }
}

