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

@NativeType(value="struct io_sqring_offsets")
public class IOSQRingOffsets
extends Struct<IOSQRingOffsets>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HEAD;
    public static final int TAIL;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int FLAGS;
    public static final int DROPPED;
    public static final int ARRAY;
    public static final int RESV1;
    public static final int USER_ADDR;

    protected IOSQRingOffsets(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOSQRingOffsets create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOSQRingOffsets(l, byteBuffer);
    }

    public IOSQRingOffsets(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOSQRingOffsets.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int head() {
        return IOSQRingOffsets.nhead(this.address());
    }

    @NativeType(value="__u32")
    public int tail() {
        return IOSQRingOffsets.ntail(this.address());
    }

    @NativeType(value="__u32")
    public int ring_mask() {
        return IOSQRingOffsets.nring_mask(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOSQRingOffsets.nring_entries(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOSQRingOffsets.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int dropped() {
        return IOSQRingOffsets.ndropped(this.address());
    }

    @NativeType(value="__u32")
    public int array() {
        return IOSQRingOffsets.narray(this.address());
    }

    @NativeType(value="__u64")
    public long user_addr() {
        return IOSQRingOffsets.nuser_addr(this.address());
    }

    public IOSQRingOffsets head(@NativeType(value="__u32") int n) {
        IOSQRingOffsets.nhead(this.address(), n);
        return this;
    }

    public IOSQRingOffsets tail(@NativeType(value="__u32") int n) {
        IOSQRingOffsets.ntail(this.address(), n);
        return this;
    }

    public IOSQRingOffsets ring_mask(@NativeType(value="__u32") int n) {
        IOSQRingOffsets.nring_mask(this.address(), n);
        return this;
    }

    public IOSQRingOffsets ring_entries(@NativeType(value="__u32") int n) {
        IOSQRingOffsets.nring_entries(this.address(), n);
        return this;
    }

    public IOSQRingOffsets flags(@NativeType(value="__u32") int n) {
        IOSQRingOffsets.nflags(this.address(), n);
        return this;
    }

    public IOSQRingOffsets dropped(@NativeType(value="__u32") int n) {
        IOSQRingOffsets.ndropped(this.address(), n);
        return this;
    }

    public IOSQRingOffsets array(@NativeType(value="__u32") int n) {
        IOSQRingOffsets.narray(this.address(), n);
        return this;
    }

    public IOSQRingOffsets user_addr(@NativeType(value="__u64") long l) {
        IOSQRingOffsets.nuser_addr(this.address(), l);
        return this;
    }

    public IOSQRingOffsets set(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l) {
        this.head(n);
        this.tail(n2);
        this.ring_mask(n3);
        this.ring_entries(n4);
        this.flags(n5);
        this.dropped(n6);
        this.array(n7);
        this.user_addr(l);
        return this;
    }

    public IOSQRingOffsets set(IOSQRingOffsets iOSQRingOffsets) {
        MemoryUtil.memCopy(iOSQRingOffsets.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOSQRingOffsets malloc() {
        return new IOSQRingOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOSQRingOffsets calloc() {
        return new IOSQRingOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOSQRingOffsets create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOSQRingOffsets(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOSQRingOffsets create(long l) {
        return new IOSQRingOffsets(l, null);
    }

    public static @Nullable IOSQRingOffsets createSafe(long l) {
        return l == 0L ? null : new IOSQRingOffsets(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOSQRingOffsets.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOSQRingOffsets.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOSQRingOffsets malloc(MemoryStack memoryStack) {
        return new IOSQRingOffsets(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOSQRingOffsets calloc(MemoryStack memoryStack) {
        return new IOSQRingOffsets(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static int ndropped(long l) {
        return MemoryUtil.memGetInt(l + (long)DROPPED);
    }

    public static int narray(long l) {
        return MemoryUtil.memGetInt(l + (long)ARRAY);
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

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void ndropped(long l, int n) {
        MemoryUtil.memPutInt(l + (long)DROPPED, n);
    }

    public static void narray(long l, int n) {
        MemoryUtil.memPutInt(l + (long)ARRAY, n);
    }

    public static void nresv1(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RESV1, n);
    }

    public static void nuser_addr(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)USER_ADDR, l2);
    }

    static {
        Struct.Layout layout = IOSQRingOffsets.__struct(IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        HEAD = layout.offsetof(0);
        TAIL = layout.offsetof(1);
        RING_MASK = layout.offsetof(2);
        RING_ENTRIES = layout.offsetof(3);
        FLAGS = layout.offsetof(4);
        DROPPED = layout.offsetof(5);
        ARRAY = layout.offsetof(6);
        RESV1 = layout.offsetof(7);
        USER_ADDR = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOSQRingOffsets, Buffer>
    implements NativeResource {
        private static final IOSQRingOffsets ELEMENT_FACTORY = IOSQRingOffsets.create(-1L);

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
        protected IOSQRingOffsets getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int head() {
            return IOSQRingOffsets.nhead(this.address());
        }

        @NativeType(value="__u32")
        public int tail() {
            return IOSQRingOffsets.ntail(this.address());
        }

        @NativeType(value="__u32")
        public int ring_mask() {
            return IOSQRingOffsets.nring_mask(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOSQRingOffsets.nring_entries(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOSQRingOffsets.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int dropped() {
            return IOSQRingOffsets.ndropped(this.address());
        }

        @NativeType(value="__u32")
        public int array() {
            return IOSQRingOffsets.narray(this.address());
        }

        @NativeType(value="__u64")
        public long user_addr() {
            return IOSQRingOffsets.nuser_addr(this.address());
        }

        public Buffer head(@NativeType(value="__u32") int n) {
            IOSQRingOffsets.nhead(this.address(), n);
            return this;
        }

        public Buffer tail(@NativeType(value="__u32") int n) {
            IOSQRingOffsets.ntail(this.address(), n);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="__u32") int n) {
            IOSQRingOffsets.nring_mask(this.address(), n);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int n) {
            IOSQRingOffsets.nring_entries(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOSQRingOffsets.nflags(this.address(), n);
            return this;
        }

        public Buffer dropped(@NativeType(value="__u32") int n) {
            IOSQRingOffsets.ndropped(this.address(), n);
            return this;
        }

        public Buffer array(@NativeType(value="__u32") int n) {
            IOSQRingOffsets.narray(this.address(), n);
            return this;
        }

        public Buffer user_addr(@NativeType(value="__u64") long l) {
            IOSQRingOffsets.nuser_addr(this.address(), l);
            return this;
        }
    }
}

