/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.liburing.IOURingCQ;
import org.lwjgl.system.linux.liburing.IOURingSQ;

@NativeType(value="struct io_uring")
public class IOURing
extends Struct<IOURing>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SQ;
    public static final int CQ;
    public static final int FLAGS;
    public static final int RING_FD;
    public static final int FEATURES;
    public static final int ENTER_RING_FD;
    public static final int INT_FLAGS;
    public static final int PAD;
    public static final int PAD2;

    protected IOURing(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURing create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURing(l, byteBuffer);
    }

    public IOURing(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURing.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="struct io_uring_sq")
    public IOURingSQ sq() {
        return IOURing.nsq(this.address());
    }

    @NativeType(value="struct io_uring_cq")
    public IOURingCQ cq() {
        return IOURing.ncq(this.address());
    }

    @NativeType(value="unsigned int")
    public int flags() {
        return IOURing.nflags(this.address());
    }

    public int ring_fd() {
        return IOURing.nring_fd(this.address());
    }

    @NativeType(value="unsigned int")
    public int features() {
        return IOURing.nfeatures(this.address());
    }

    public int enter_ring_fd() {
        return IOURing.nenter_ring_fd(this.address());
    }

    @NativeType(value="__u8")
    public byte int_flags() {
        return IOURing.nint_flags(this.address());
    }

    public IOURing sq(@NativeType(value="struct io_uring_sq") IOURingSQ iOURingSQ) {
        IOURing.nsq(this.address(), iOURingSQ);
        return this;
    }

    public IOURing sq(Consumer<IOURingSQ> consumer) {
        consumer.accept(this.sq());
        return this;
    }

    public IOURing cq(@NativeType(value="struct io_uring_cq") IOURingCQ iOURingCQ) {
        IOURing.ncq(this.address(), iOURingCQ);
        return this;
    }

    public IOURing cq(Consumer<IOURingCQ> consumer) {
        consumer.accept(this.cq());
        return this;
    }

    public IOURing flags(@NativeType(value="unsigned int") int n) {
        IOURing.nflags(this.address(), n);
        return this;
    }

    public IOURing ring_fd(int n) {
        IOURing.nring_fd(this.address(), n);
        return this;
    }

    public IOURing features(@NativeType(value="unsigned int") int n) {
        IOURing.nfeatures(this.address(), n);
        return this;
    }

    public IOURing enter_ring_fd(int n) {
        IOURing.nenter_ring_fd(this.address(), n);
        return this;
    }

    public IOURing int_flags(@NativeType(value="__u8") byte by) {
        IOURing.nint_flags(this.address(), by);
        return this;
    }

    public IOURing set(IOURingSQ iOURingSQ, IOURingCQ iOURingCQ, int n, int n2, int n3, int n4, byte by) {
        this.sq(iOURingSQ);
        this.cq(iOURingCQ);
        this.flags(n);
        this.ring_fd(n2);
        this.features(n3);
        this.enter_ring_fd(n4);
        this.int_flags(by);
        return this;
    }

    public IOURing set(IOURing iOURing) {
        MemoryUtil.memCopy(iOURing.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURing malloc() {
        return new IOURing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURing calloc() {
        return new IOURing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURing create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURing(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURing create(long l) {
        return new IOURing(l, null);
    }

    public static @Nullable IOURing createSafe(long l) {
        return l == 0L ? null : new IOURing(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURing.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURing.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURing malloc(MemoryStack memoryStack) {
        return new IOURing(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURing calloc(MemoryStack memoryStack) {
        return new IOURing(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static IOURingSQ nsq(long l) {
        return IOURingSQ.create(l + (long)SQ);
    }

    public static IOURingCQ ncq(long l) {
        return IOURingCQ.create(l + (long)CQ);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static int nring_fd(long l) {
        return MemoryUtil.memGetInt(l + (long)RING_FD);
    }

    public static int nfeatures(long l) {
        return MemoryUtil.memGetInt(l + (long)FEATURES);
    }

    public static int nenter_ring_fd(long l) {
        return MemoryUtil.memGetInt(l + (long)ENTER_RING_FD);
    }

    public static byte nint_flags(long l) {
        return MemoryUtil.memGetByte(l + (long)INT_FLAGS);
    }

    public static ByteBuffer npad(long l) {
        return MemoryUtil.memByteBuffer(l + (long)PAD, 3);
    }

    public static byte npad(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)PAD + Checks.check(n, 3) * 1L);
    }

    public static int npad2(long l) {
        return MemoryUtil.memGetInt(l + (long)PAD2);
    }

    public static void nsq(long l, IOURingSQ iOURingSQ) {
        MemoryUtil.memCopy(iOURingSQ.address(), l + (long)SQ, IOURingSQ.SIZEOF);
    }

    public static void ncq(long l, IOURingCQ iOURingCQ) {
        MemoryUtil.memCopy(iOURingCQ.address(), l + (long)CQ, IOURingCQ.SIZEOF);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void nring_fd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RING_FD, n);
    }

    public static void nfeatures(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FEATURES, n);
    }

    public static void nenter_ring_fd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)ENTER_RING_FD, n);
    }

    public static void nint_flags(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)INT_FLAGS, by);
    }

    public static void npad(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)PAD, byteBuffer.remaining() * 1);
    }

    public static void npad(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)PAD + Checks.check(n, 3) * 1L, by);
    }

    public static void npad2(long l, int n) {
        MemoryUtil.memPutInt(l + (long)PAD2, n);
    }

    public static void validate(long l) {
        IOURingSQ.validate(l + (long)SQ);
        IOURingCQ.validate(l + (long)CQ);
    }

    static {
        Struct.Layout layout = IOURing.__struct(IOURing.__member(IOURingSQ.SIZEOF, IOURingSQ.ALIGNOF), IOURing.__member(IOURingCQ.SIZEOF, IOURingCQ.ALIGNOF), IOURing.__member(4), IOURing.__member(4), IOURing.__member(4), IOURing.__member(4), IOURing.__member(1), IOURing.__array(1, 3), IOURing.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SQ = layout.offsetof(0);
        CQ = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        RING_FD = layout.offsetof(3);
        FEATURES = layout.offsetof(4);
        ENTER_RING_FD = layout.offsetof(5);
        INT_FLAGS = layout.offsetof(6);
        PAD = layout.offsetof(7);
        PAD2 = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOURing, Buffer>
    implements NativeResource {
        private static final IOURing ELEMENT_FACTORY = IOURing.create(-1L);

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
        protected IOURing getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="struct io_uring_sq")
        public IOURingSQ sq() {
            return IOURing.nsq(this.address());
        }

        @NativeType(value="struct io_uring_cq")
        public IOURingCQ cq() {
            return IOURing.ncq(this.address());
        }

        @NativeType(value="unsigned int")
        public int flags() {
            return IOURing.nflags(this.address());
        }

        public int ring_fd() {
            return IOURing.nring_fd(this.address());
        }

        @NativeType(value="unsigned int")
        public int features() {
            return IOURing.nfeatures(this.address());
        }

        public int enter_ring_fd() {
            return IOURing.nenter_ring_fd(this.address());
        }

        @NativeType(value="__u8")
        public byte int_flags() {
            return IOURing.nint_flags(this.address());
        }

        public Buffer sq(@NativeType(value="struct io_uring_sq") IOURingSQ iOURingSQ) {
            IOURing.nsq(this.address(), iOURingSQ);
            return this;
        }

        public Buffer sq(Consumer<IOURingSQ> consumer) {
            consumer.accept(this.sq());
            return this;
        }

        public Buffer cq(@NativeType(value="struct io_uring_cq") IOURingCQ iOURingCQ) {
            IOURing.ncq(this.address(), iOURingCQ);
            return this;
        }

        public Buffer cq(Consumer<IOURingCQ> consumer) {
            consumer.accept(this.cq());
            return this;
        }

        public Buffer flags(@NativeType(value="unsigned int") int n) {
            IOURing.nflags(this.address(), n);
            return this;
        }

        public Buffer ring_fd(int n) {
            IOURing.nring_fd(this.address(), n);
            return this;
        }

        public Buffer features(@NativeType(value="unsigned int") int n) {
            IOURing.nfeatures(this.address(), n);
            return this;
        }

        public Buffer enter_ring_fd(int n) {
            IOURing.nenter_ring_fd(this.address(), n);
            return this;
        }

        public Buffer int_flags(@NativeType(value="__u8") byte by) {
            IOURing.nint_flags(this.address(), by);
            return this;
        }
    }
}

