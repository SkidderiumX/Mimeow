/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
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
import org.lwjgl.system.linux.liburing.IOCQRingOffsets;
import org.lwjgl.system.linux.liburing.IOSQRingOffsets;

@NativeType(value="struct io_uring_params")
public class IOURingParams
extends Struct<IOURingParams>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SQ_ENTRIES;
    public static final int CQ_ENTRIES;
    public static final int FLAGS;
    public static final int SQ_THREAD_CPU;
    public static final int SQ_THREAD_IDLE;
    public static final int FEATURES;
    public static final int WQ_FD;
    public static final int RESV;
    public static final int SQ_OFF;
    public static final int CQ_OFF;

    protected IOURingParams(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingParams create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingParams(l, byteBuffer);
    }

    public IOURingParams(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingParams.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int sq_entries() {
        return IOURingParams.nsq_entries(this.address());
    }

    @NativeType(value="__u32")
    public int cq_entries() {
        return IOURingParams.ncq_entries(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingParams.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int sq_thread_cpu() {
        return IOURingParams.nsq_thread_cpu(this.address());
    }

    @NativeType(value="__u32")
    public int sq_thread_idle() {
        return IOURingParams.nsq_thread_idle(this.address());
    }

    @NativeType(value="__u32")
    public int features() {
        return IOURingParams.nfeatures(this.address());
    }

    @NativeType(value="__u32")
    public int wq_fd() {
        return IOURingParams.nwq_fd(this.address());
    }

    @NativeType(value="struct io_sqring_offsets")
    public IOSQRingOffsets sq_off() {
        return IOURingParams.nsq_off(this.address());
    }

    @NativeType(value="struct io_cqring_offsets")
    public IOCQRingOffsets cq_off() {
        return IOURingParams.ncq_off(this.address());
    }

    public IOURingParams sq_entries(@NativeType(value="__u32") int n) {
        IOURingParams.nsq_entries(this.address(), n);
        return this;
    }

    public IOURingParams cq_entries(@NativeType(value="__u32") int n) {
        IOURingParams.ncq_entries(this.address(), n);
        return this;
    }

    public IOURingParams flags(@NativeType(value="__u32") int n) {
        IOURingParams.nflags(this.address(), n);
        return this;
    }

    public IOURingParams sq_thread_cpu(@NativeType(value="__u32") int n) {
        IOURingParams.nsq_thread_cpu(this.address(), n);
        return this;
    }

    public IOURingParams sq_thread_idle(@NativeType(value="__u32") int n) {
        IOURingParams.nsq_thread_idle(this.address(), n);
        return this;
    }

    public IOURingParams features(@NativeType(value="__u32") int n) {
        IOURingParams.nfeatures(this.address(), n);
        return this;
    }

    public IOURingParams wq_fd(@NativeType(value="__u32") int n) {
        IOURingParams.nwq_fd(this.address(), n);
        return this;
    }

    public IOURingParams sq_off(@NativeType(value="struct io_sqring_offsets") IOSQRingOffsets iOSQRingOffsets) {
        IOURingParams.nsq_off(this.address(), iOSQRingOffsets);
        return this;
    }

    public IOURingParams sq_off(Consumer<IOSQRingOffsets> consumer) {
        consumer.accept(this.sq_off());
        return this;
    }

    public IOURingParams cq_off(@NativeType(value="struct io_cqring_offsets") IOCQRingOffsets iOCQRingOffsets) {
        IOURingParams.ncq_off(this.address(), iOCQRingOffsets);
        return this;
    }

    public IOURingParams cq_off(Consumer<IOCQRingOffsets> consumer) {
        consumer.accept(this.cq_off());
        return this;
    }

    public IOURingParams set(int n, int n2, int n3, int n4, int n5, int n6, int n7, IOSQRingOffsets iOSQRingOffsets, IOCQRingOffsets iOCQRingOffsets) {
        this.sq_entries(n);
        this.cq_entries(n2);
        this.flags(n3);
        this.sq_thread_cpu(n4);
        this.sq_thread_idle(n5);
        this.features(n6);
        this.wq_fd(n7);
        this.sq_off(iOSQRingOffsets);
        this.cq_off(iOCQRingOffsets);
        return this;
    }

    public IOURingParams set(IOURingParams iOURingParams) {
        MemoryUtil.memCopy(iOURingParams.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingParams malloc() {
        return new IOURingParams(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingParams calloc() {
        return new IOURingParams(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingParams create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingParams(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingParams create(long l) {
        return new IOURingParams(l, null);
    }

    public static @Nullable IOURingParams createSafe(long l) {
        return l == 0L ? null : new IOURingParams(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingParams.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingParams.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingParams malloc(MemoryStack memoryStack) {
        return new IOURingParams(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingParams calloc(MemoryStack memoryStack) {
        return new IOURingParams(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nsq_entries(long l) {
        return MemoryUtil.memGetInt(l + (long)SQ_ENTRIES);
    }

    public static int ncq_entries(long l) {
        return MemoryUtil.memGetInt(l + (long)CQ_ENTRIES);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static int nsq_thread_cpu(long l) {
        return MemoryUtil.memGetInt(l + (long)SQ_THREAD_CPU);
    }

    public static int nsq_thread_idle(long l) {
        return MemoryUtil.memGetInt(l + (long)SQ_THREAD_IDLE);
    }

    public static int nfeatures(long l) {
        return MemoryUtil.memGetInt(l + (long)FEATURES);
    }

    public static int nwq_fd(long l) {
        return MemoryUtil.memGetInt(l + (long)WQ_FD);
    }

    public static IntBuffer nresv(long l) {
        return MemoryUtil.memIntBuffer(l + (long)RESV, 3);
    }

    public static int nresv(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)RESV + Checks.check(n, 3) * 4L);
    }

    public static IOSQRingOffsets nsq_off(long l) {
        return IOSQRingOffsets.create(l + (long)SQ_OFF);
    }

    public static IOCQRingOffsets ncq_off(long l) {
        return IOCQRingOffsets.create(l + (long)CQ_OFF);
    }

    public static void nsq_entries(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SQ_ENTRIES, n);
    }

    public static void ncq_entries(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CQ_ENTRIES, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void nsq_thread_cpu(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SQ_THREAD_CPU, n);
    }

    public static void nsq_thread_idle(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SQ_THREAD_IDLE, n);
    }

    public static void nfeatures(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FEATURES, n);
    }

    public static void nwq_fd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)WQ_FD, n);
    }

    public static void nresv(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)RESV, intBuffer.remaining() * 4);
    }

    public static void nresv(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)RESV + Checks.check(n, 3) * 4L, n2);
    }

    public static void nsq_off(long l, IOSQRingOffsets iOSQRingOffsets) {
        MemoryUtil.memCopy(iOSQRingOffsets.address(), l + (long)SQ_OFF, IOSQRingOffsets.SIZEOF);
    }

    public static void ncq_off(long l, IOCQRingOffsets iOCQRingOffsets) {
        MemoryUtil.memCopy(iOCQRingOffsets.address(), l + (long)CQ_OFF, IOCQRingOffsets.SIZEOF);
    }

    static {
        Struct.Layout layout = IOURingParams.__struct(IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__array(4, 3), IOURingParams.__member(IOSQRingOffsets.SIZEOF, IOSQRingOffsets.ALIGNOF), IOURingParams.__member(IOCQRingOffsets.SIZEOF, IOCQRingOffsets.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SQ_ENTRIES = layout.offsetof(0);
        CQ_ENTRIES = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        SQ_THREAD_CPU = layout.offsetof(3);
        SQ_THREAD_IDLE = layout.offsetof(4);
        FEATURES = layout.offsetof(5);
        WQ_FD = layout.offsetof(6);
        RESV = layout.offsetof(7);
        SQ_OFF = layout.offsetof(8);
        CQ_OFF = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<IOURingParams, Buffer>
    implements NativeResource {
        private static final IOURingParams ELEMENT_FACTORY = IOURingParams.create(-1L);

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
        protected IOURingParams getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int sq_entries() {
            return IOURingParams.nsq_entries(this.address());
        }

        @NativeType(value="__u32")
        public int cq_entries() {
            return IOURingParams.ncq_entries(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingParams.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int sq_thread_cpu() {
            return IOURingParams.nsq_thread_cpu(this.address());
        }

        @NativeType(value="__u32")
        public int sq_thread_idle() {
            return IOURingParams.nsq_thread_idle(this.address());
        }

        @NativeType(value="__u32")
        public int features() {
            return IOURingParams.nfeatures(this.address());
        }

        @NativeType(value="__u32")
        public int wq_fd() {
            return IOURingParams.nwq_fd(this.address());
        }

        @NativeType(value="struct io_sqring_offsets")
        public IOSQRingOffsets sq_off() {
            return IOURingParams.nsq_off(this.address());
        }

        @NativeType(value="struct io_cqring_offsets")
        public IOCQRingOffsets cq_off() {
            return IOURingParams.ncq_off(this.address());
        }

        public Buffer sq_entries(@NativeType(value="__u32") int n) {
            IOURingParams.nsq_entries(this.address(), n);
            return this;
        }

        public Buffer cq_entries(@NativeType(value="__u32") int n) {
            IOURingParams.ncq_entries(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOURingParams.nflags(this.address(), n);
            return this;
        }

        public Buffer sq_thread_cpu(@NativeType(value="__u32") int n) {
            IOURingParams.nsq_thread_cpu(this.address(), n);
            return this;
        }

        public Buffer sq_thread_idle(@NativeType(value="__u32") int n) {
            IOURingParams.nsq_thread_idle(this.address(), n);
            return this;
        }

        public Buffer features(@NativeType(value="__u32") int n) {
            IOURingParams.nfeatures(this.address(), n);
            return this;
        }

        public Buffer wq_fd(@NativeType(value="__u32") int n) {
            IOURingParams.nwq_fd(this.address(), n);
            return this;
        }

        public Buffer sq_off(@NativeType(value="struct io_sqring_offsets") IOSQRingOffsets iOSQRingOffsets) {
            IOURingParams.nsq_off(this.address(), iOSQRingOffsets);
            return this;
        }

        public Buffer sq_off(Consumer<IOSQRingOffsets> consumer) {
            consumer.accept(this.sq_off());
            return this;
        }

        public Buffer cq_off(@NativeType(value="struct io_cqring_offsets") IOCQRingOffsets iOCQRingOffsets) {
            IOURingParams.ncq_off(this.address(), iOCQRingOffsets);
            return this;
        }

        public Buffer cq_off(Consumer<IOCQRingOffsets> consumer) {
            consumer.accept(this.cq_off());
            return this;
        }
    }
}

