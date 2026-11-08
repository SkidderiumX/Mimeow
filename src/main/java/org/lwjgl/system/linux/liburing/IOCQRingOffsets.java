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

@NativeType(value="struct io_cqring_offsets")
public class IOCQRingOffsets
extends Struct<IOCQRingOffsets>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HEAD;
    public static final int TAIL;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int OVERFLOW;
    public static final int CQES;
    public static final int FLAGS;
    public static final int RESV1;
    public static final int USER_ADDR;

    protected IOCQRingOffsets(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOCQRingOffsets create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOCQRingOffsets(l, byteBuffer);
    }

    public IOCQRingOffsets(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOCQRingOffsets.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int head() {
        return IOCQRingOffsets.nhead(this.address());
    }

    @NativeType(value="__u32")
    public int tail() {
        return IOCQRingOffsets.ntail(this.address());
    }

    @NativeType(value="__u32")
    public int ring_mask() {
        return IOCQRingOffsets.nring_mask(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOCQRingOffsets.nring_entries(this.address());
    }

    @NativeType(value="__u32")
    public int overflow() {
        return IOCQRingOffsets.noverflow(this.address());
    }

    @NativeType(value="__u32")
    public int cqes() {
        return IOCQRingOffsets.ncqes(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOCQRingOffsets.nflags(this.address());
    }

    @NativeType(value="__u64")
    public long user_addr() {
        return IOCQRingOffsets.nuser_addr(this.address());
    }

    public IOCQRingOffsets head(@NativeType(value="__u32") int n) {
        IOCQRingOffsets.nhead(this.address(), n);
        return this;
    }

    public IOCQRingOffsets tail(@NativeType(value="__u32") int n) {
        IOCQRingOffsets.ntail(this.address(), n);
        return this;
    }

    public IOCQRingOffsets ring_mask(@NativeType(value="__u32") int n) {
        IOCQRingOffsets.nring_mask(this.address(), n);
        return this;
    }

    public IOCQRingOffsets ring_entries(@NativeType(value="__u32") int n) {
        IOCQRingOffsets.nring_entries(this.address(), n);
        return this;
    }

    public IOCQRingOffsets overflow(@NativeType(value="__u32") int n) {
        IOCQRingOffsets.noverflow(this.address(), n);
        return this;
    }

    public IOCQRingOffsets cqes(@NativeType(value="__u32") int n) {
        IOCQRingOffsets.ncqes(this.address(), n);
        return this;
    }

    public IOCQRingOffsets flags(@NativeType(value="__u32") int n) {
        IOCQRingOffsets.nflags(this.address(), n);
        return this;
    }

    public IOCQRingOffsets user_addr(@NativeType(value="__u64") long l) {
        IOCQRingOffsets.nuser_addr(this.address(), l);
        return this;
    }

    public IOCQRingOffsets set(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l) {
        this.head(n);
        this.tail(n2);
        this.ring_mask(n3);
        this.ring_entries(n4);
        this.overflow(n5);
        this.cqes(n6);
        this.flags(n7);
        this.user_addr(l);
        return this;
    }

    public IOCQRingOffsets set(IOCQRingOffsets iOCQRingOffsets) {
        MemoryUtil.memCopy(iOCQRingOffsets.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOCQRingOffsets malloc() {
        return new IOCQRingOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOCQRingOffsets calloc() {
        return new IOCQRingOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOCQRingOffsets create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOCQRingOffsets(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOCQRingOffsets create(long l) {
        return new IOCQRingOffsets(l, null);
    }

    public static @Nullable IOCQRingOffsets createSafe(long l) {
        return l == 0L ? null : new IOCQRingOffsets(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOCQRingOffsets.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOCQRingOffsets.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOCQRingOffsets malloc(MemoryStack memoryStack) {
        return new IOCQRingOffsets(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOCQRingOffsets calloc(MemoryStack memoryStack) {
        return new IOCQRingOffsets(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nhead(long l) {
        return MemoryUtil.memGetInt(l + (long)HEAD);
    }

    public static int ntail(long l) {
        return MemoryUtil.memGetInt(l + (long)TAIL);
    }

    public static int nring_mask(long l) {
        return MemoryUtil.memGetInt(l + (long)RING_MASK);
    }

    public static int nring_entries(long l) {
        return MemoryUtil.memGetInt(l + (long)RING_ENTRIES);
    }

    public static int noverflow(long l) {
        return MemoryUtil.memGetInt(l + (long)OVERFLOW);
    }

    public static int ncqes(long l) {
        return MemoryUtil.memGetInt(l + (long)CQES);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static int nresv1(long l) {
        return MemoryUtil.memGetInt(l + (long)RESV1);
    }

    public static long nuser_addr(long l) {
        return MemoryUtil.memGetLong(l + (long)USER_ADDR);
    }

    public static void nhead(long l, int n) {
        MemoryUtil.memPutInt(l + (long)HEAD, n);
    }

    public static void ntail(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TAIL, n);
    }

    public static void nring_mask(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RING_MASK, n);
    }

    public static void nring_entries(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RING_ENTRIES, n);
    }

    public static void noverflow(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OVERFLOW, n);
    }

    public static void ncqes(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CQES, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void nresv1(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RESV1, n);
    }

    public static void nuser_addr(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)USER_ADDR, l2);
    }

    static {
        Struct.Layout layout = IOCQRingOffsets.__struct(IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        HEAD = layout.offsetof(0);
        TAIL = layout.offsetof(1);
        RING_MASK = layout.offsetof(2);
        RING_ENTRIES = layout.offsetof(3);
        OVERFLOW = layout.offsetof(4);
        CQES = layout.offsetof(5);
        FLAGS = layout.offsetof(6);
        RESV1 = layout.offsetof(7);
        USER_ADDR = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOCQRingOffsets, Buffer>
    implements NativeResource {
        private static final IOCQRingOffsets ELEMENT_FACTORY = IOCQRingOffsets.create(-1L);

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
        protected IOCQRingOffsets getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int head() {
            return IOCQRingOffsets.nhead(this.address());
        }

        @NativeType(value="__u32")
        public int tail() {
            return IOCQRingOffsets.ntail(this.address());
        }

        @NativeType(value="__u32")
        public int ring_mask() {
            return IOCQRingOffsets.nring_mask(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOCQRingOffsets.nring_entries(this.address());
        }

        @NativeType(value="__u32")
        public int overflow() {
            return IOCQRingOffsets.noverflow(this.address());
        }

        @NativeType(value="__u32")
        public int cqes() {
            return IOCQRingOffsets.ncqes(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOCQRingOffsets.nflags(this.address());
        }

        @NativeType(value="__u64")
        public long user_addr() {
            return IOCQRingOffsets.nuser_addr(this.address());
        }

        public Buffer head(@NativeType(value="__u32") int n) {
            IOCQRingOffsets.nhead(this.address(), n);
            return this;
        }

        public Buffer tail(@NativeType(value="__u32") int n) {
            IOCQRingOffsets.ntail(this.address(), n);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="__u32") int n) {
            IOCQRingOffsets.nring_mask(this.address(), n);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int n) {
            IOCQRingOffsets.nring_entries(this.address(), n);
            return this;
        }

        public Buffer overflow(@NativeType(value="__u32") int n) {
            IOCQRingOffsets.noverflow(this.address(), n);
            return this;
        }

        public Buffer cqes(@NativeType(value="__u32") int n) {
            IOCQRingOffsets.ncqes(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOCQRingOffsets.nflags(this.address(), n);
            return this;
        }

        public Buffer user_addr(@NativeType(value="__u64") long l) {
            IOCQRingOffsets.nuser_addr(this.address(), l);
            return this;
        }
    }
}

