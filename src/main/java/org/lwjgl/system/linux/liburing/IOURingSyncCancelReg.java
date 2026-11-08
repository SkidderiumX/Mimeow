/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
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
import org.lwjgl.system.linux.KernelTimespec;

@NativeType(value="struct io_uring_sync_cancel_reg")
public class IOURingSyncCancelReg
extends Struct<IOURingSyncCancelReg>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ADDR;
    public static final int FD;
    public static final int FLAGS;
    public static final int TIMEOUT;
    public static final int OPCODE;
    public static final int PAD;
    public static final int PAD2;

    protected IOURingSyncCancelReg(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingSyncCancelReg create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingSyncCancelReg(l, byteBuffer);
    }

    public IOURingSyncCancelReg(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingSyncCancelReg.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long addr() {
        return IOURingSyncCancelReg.naddr(this.address());
    }

    @NativeType(value="__s32")
    public int fd() {
        return IOURingSyncCancelReg.nfd(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingSyncCancelReg.nflags(this.address());
    }

    @NativeType(value="struct __kernel_timespec")
    public KernelTimespec timeout() {
        return IOURingSyncCancelReg.ntimeout(this.address());
    }

    @NativeType(value="__u8")
    public byte opcode() {
        return IOURingSyncCancelReg.nopcode(this.address());
    }

    public IOURingSyncCancelReg addr(@NativeType(value="__u64") long l) {
        IOURingSyncCancelReg.naddr(this.address(), l);
        return this;
    }

    public IOURingSyncCancelReg fd(@NativeType(value="__s32") int n) {
        IOURingSyncCancelReg.nfd(this.address(), n);
        return this;
    }

    public IOURingSyncCancelReg flags(@NativeType(value="__u32") int n) {
        IOURingSyncCancelReg.nflags(this.address(), n);
        return this;
    }

    public IOURingSyncCancelReg timeout(@NativeType(value="struct __kernel_timespec") KernelTimespec kernelTimespec) {
        IOURingSyncCancelReg.ntimeout(this.address(), kernelTimespec);
        return this;
    }

    public IOURingSyncCancelReg timeout(Consumer<KernelTimespec> consumer) {
        consumer.accept(this.timeout());
        return this;
    }

    public IOURingSyncCancelReg opcode(@NativeType(value="__u8") byte by) {
        IOURingSyncCancelReg.nopcode(this.address(), by);
        return this;
    }

    public IOURingSyncCancelReg set(long l, int n, int n2, KernelTimespec kernelTimespec, byte by) {
        this.addr(l);
        this.fd(n);
        this.flags(n2);
        this.timeout(kernelTimespec);
        this.opcode(by);
        return this;
    }

    public IOURingSyncCancelReg set(IOURingSyncCancelReg iOURingSyncCancelReg) {
        MemoryUtil.memCopy(iOURingSyncCancelReg.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSyncCancelReg malloc() {
        return new IOURingSyncCancelReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingSyncCancelReg calloc() {
        return new IOURingSyncCancelReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingSyncCancelReg create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingSyncCancelReg(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingSyncCancelReg create(long l) {
        return new IOURingSyncCancelReg(l, null);
    }

    public static @Nullable IOURingSyncCancelReg createSafe(long l) {
        return l == 0L ? null : new IOURingSyncCancelReg(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingSyncCancelReg.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingSyncCancelReg.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingSyncCancelReg malloc(MemoryStack memoryStack) {
        return new IOURingSyncCancelReg(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingSyncCancelReg calloc(MemoryStack memoryStack) {
        return new IOURingSyncCancelReg(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long naddr(long l) {
        return MemoryUtil.memGetLong(l + (long)ADDR);
    }

    public static int nfd(long l) {
        return MemoryUtil.memGetInt(l + (long)FD);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static KernelTimespec ntimeout(long l) {
        return KernelTimespec.create(l + (long)TIMEOUT);
    }

    public static byte nopcode(long l) {
        return MemoryUtil.memGetByte(l + (long)OPCODE);
    }

    public static ByteBuffer npad(long l) {
        return MemoryUtil.memByteBuffer(l + (long)PAD, 7);
    }

    public static byte npad(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)PAD + Checks.check(n, 7) * 1L);
    }

    public static LongBuffer npad2(long l) {
        return MemoryUtil.memLongBuffer(l + (long)PAD2, 3);
    }

    public static long npad2(long l, int n) {
        return MemoryUtil.memGetLong(l + (long)PAD2 + Checks.check(n, 3) * 8L);
    }

    public static void naddr(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)ADDR, l2);
    }

    public static void nfd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FD, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void ntimeout(long l, KernelTimespec kernelTimespec) {
        MemoryUtil.memCopy(kernelTimespec.address(), l + (long)TIMEOUT, KernelTimespec.SIZEOF);
    }

    public static void nopcode(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)OPCODE, by);
    }

    public static void npad(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 7);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)PAD, byteBuffer.remaining() * 1);
    }

    public static void npad(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)PAD + Checks.check(n, 7) * 1L, by);
    }

    public static void npad2(long l, LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(longBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(longBuffer), l + (long)PAD2, longBuffer.remaining() * 8);
    }

    public static void npad2(long l, int n, long l2) {
        MemoryUtil.memPutLong(l + (long)PAD2 + Checks.check(n, 3) * 8L, l2);
    }

    static {
        Struct.Layout layout = IOURingSyncCancelReg.__struct(IOURingSyncCancelReg.__member(8), IOURingSyncCancelReg.__member(4), IOURingSyncCancelReg.__member(4), IOURingSyncCancelReg.__member(KernelTimespec.SIZEOF, KernelTimespec.ALIGNOF), IOURingSyncCancelReg.__member(1), IOURingSyncCancelReg.__array(1, 7), IOURingSyncCancelReg.__array(8, 3));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ADDR = layout.offsetof(0);
        FD = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        TIMEOUT = layout.offsetof(3);
        OPCODE = layout.offsetof(4);
        PAD = layout.offsetof(5);
        PAD2 = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<IOURingSyncCancelReg, Buffer>
    implements NativeResource {
        private static final IOURingSyncCancelReg ELEMENT_FACTORY = IOURingSyncCancelReg.create(-1L);

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
        protected IOURingSyncCancelReg getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long addr() {
            return IOURingSyncCancelReg.naddr(this.address());
        }

        @NativeType(value="__s32")
        public int fd() {
            return IOURingSyncCancelReg.nfd(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingSyncCancelReg.nflags(this.address());
        }

        @NativeType(value="struct __kernel_timespec")
        public KernelTimespec timeout() {
            return IOURingSyncCancelReg.ntimeout(this.address());
        }

        @NativeType(value="__u8")
        public byte opcode() {
            return IOURingSyncCancelReg.nopcode(this.address());
        }

        public Buffer addr(@NativeType(value="__u64") long l) {
            IOURingSyncCancelReg.naddr(this.address(), l);
            return this;
        }

        public Buffer fd(@NativeType(value="__s32") int n) {
            IOURingSyncCancelReg.nfd(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOURingSyncCancelReg.nflags(this.address(), n);
            return this;
        }

        public Buffer timeout(@NativeType(value="struct __kernel_timespec") KernelTimespec kernelTimespec) {
            IOURingSyncCancelReg.ntimeout(this.address(), kernelTimespec);
            return this;
        }

        public Buffer timeout(Consumer<KernelTimespec> consumer) {
            consumer.accept(this.timeout());
            return this;
        }

        public Buffer opcode(@NativeType(value="__u8") byte by) {
            IOURingSyncCancelReg.nopcode(this.address(), by);
            return this;
        }
    }
}

