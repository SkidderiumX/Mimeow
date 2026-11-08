/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct iovec")
public class IOVec
extends Struct<IOVec>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int IOV_BASE;
    public static final int IOV_LEN;

    protected IOVec(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOVec create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOVec(l, byteBuffer);
    }

    public IOVec(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOVec.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public @Nullable ByteBuffer iov_base() {
        return IOVec.niov_base(this.address());
    }

    @NativeType(value="size_t")
    public long iov_len() {
        return IOVec.niov_len(this.address());
    }

    public IOVec iov_base(@NativeType(value="void *") @Nullable ByteBuffer byteBuffer) {
        IOVec.niov_base(this.address(), byteBuffer);
        return this;
    }

    public IOVec iov_len(@NativeType(value="size_t") long l) {
        IOVec.niov_len(this.address(), l);
        return this;
    }

    public IOVec set(@Nullable ByteBuffer byteBuffer, long l) {
        this.iov_base(byteBuffer);
        this.iov_len(l);
        return this;
    }

    public IOVec set(IOVec iOVec) {
        MemoryUtil.memCopy(iOVec.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOVec malloc() {
        return new IOVec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOVec calloc() {
        return new IOVec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOVec create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOVec(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOVec create(long l) {
        return new IOVec(l, null);
    }

    public static @Nullable IOVec createSafe(long l) {
        return l == 0L ? null : new IOVec(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOVec.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOVec.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOVec malloc(MemoryStack memoryStack) {
        return new IOVec(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOVec calloc(MemoryStack memoryStack) {
        return new IOVec(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static @Nullable ByteBuffer niov_base(long l) {
        return MemoryUtil.memByteBufferSafe(MemoryUtil.memGetAddress(l + (long)IOV_BASE), (int)IOVec.niov_len(l));
    }

    public static long niov_len(long l) {
        return MemoryUtil.memGetAddress(l + (long)IOV_LEN);
    }

    public static void niov_base(long l, @Nullable ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)IOV_BASE, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void niov_len(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)IOV_LEN, l2);
    }

    static {
        Struct.Layout layout = IOVec.__struct(IOVec.__member(POINTER_SIZE), IOVec.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        IOV_BASE = layout.offsetof(0);
        IOV_LEN = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<IOVec, Buffer>
    implements NativeResource {
        private static final IOVec ELEMENT_FACTORY = IOVec.create(-1L);

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
        protected IOVec getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public @Nullable ByteBuffer iov_base() {
            return IOVec.niov_base(this.address());
        }

        @NativeType(value="size_t")
        public long iov_len() {
            return IOVec.niov_len(this.address());
        }

        public Buffer iov_base(@NativeType(value="void *") @Nullable ByteBuffer byteBuffer) {
            IOVec.niov_base(this.address(), byteBuffer);
            return this;
        }

        public Buffer iov_len(@NativeType(value="size_t") long l) {
            IOVec.niov_len(this.address(), l);
            return this;
        }
    }
}

