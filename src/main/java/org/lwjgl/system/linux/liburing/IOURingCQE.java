/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_cqe")
public class IOURingCQE
extends Struct<IOURingCQE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int USER_DATA;
    public static final int RES;
    public static final int FLAGS;
    public static final int BIG_CQE;

    protected IOURingCQE(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingCQE create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingCQE(l, byteBuffer);
    }

    public IOURingCQE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingCQE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long user_data() {
        return IOURingCQE.nuser_data(this.address());
    }

    @NativeType(value="__s32")
    public int res() {
        return IOURingCQE.nres(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingCQE.nflags(this.address());
    }

    @NativeType(value="__u64[0]")
    public LongBuffer big_cqe() {
        return IOURingCQE.nbig_cqe(this.address());
    }

    @NativeType(value="__u64")
    public long big_cqe(int n) {
        return IOURingCQE.nbig_cqe(this.address(), n);
    }

    public IOURingCQE user_data(@NativeType(value="__u64") long l) {
        IOURingCQE.nuser_data(this.address(), l);
        return this;
    }

    public IOURingCQE res(@NativeType(value="__s32") int n) {
        IOURingCQE.nres(this.address(), n);
        return this;
    }

    public IOURingCQE flags(@NativeType(value="__u32") int n) {
        IOURingCQE.nflags(this.address(), n);
        return this;
    }

    public IOURingCQE big_cqe(@NativeType(value="__u64[0]") LongBuffer longBuffer) {
        IOURingCQE.nbig_cqe(this.address(), longBuffer);
        return this;
    }

    public IOURingCQE big_cqe(int n, @NativeType(value="__u64") long l) {
        IOURingCQE.nbig_cqe(this.address(), n, l);
        return this;
    }

    public IOURingCQE set(long l, int n, int n2, LongBuffer longBuffer) {
        this.user_data(l);
        this.res(n);
        this.flags(n2);
        this.big_cqe(longBuffer);
        return this;
    }

    public IOURingCQE set(IOURingCQE iOURingCQE) {
        MemoryUtil.memCopy(iOURingCQE.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingCQE malloc() {
        return new IOURingCQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingCQE calloc() {
        return new IOURingCQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingCQE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingCQE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingCQE create(long l) {
        return new IOURingCQE(l, null);
    }

    public static @Nullable IOURingCQE createSafe(long l) {
        return l == 0L ? null : new IOURingCQE(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingCQE.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingCQE.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingCQE malloc(MemoryStack memoryStack) {
        return new IOURingCQE(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingCQE calloc(MemoryStack memoryStack) {
        return new IOURingCQE(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nuser_data(long l) {
        return MemoryUtil.memGetLong(l + (long)USER_DATA);
    }

    public static int nres(long l) {
        return MemoryUtil.memGetInt(l + (long)RES);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static LongBuffer nbig_cqe(long l) {
        return MemoryUtil.memLongBuffer(l + (long)BIG_CQE, 0);
    }

    public static long nbig_cqe(long l, int n) {
        return MemoryUtil.memGetLong(l + (long)BIG_CQE + Checks.check(n, 0) * 8L);
    }

    public static void nuser_data(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)USER_DATA, l2);
    }

    public static void nres(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RES, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void nbig_cqe(long l, LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(longBuffer, 0);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(longBuffer), l + (long)BIG_CQE, longBuffer.remaining() * 8);
    }

    public static void nbig_cqe(long l, int n, long l2) {
        MemoryUtil.memPutLong(l + (long)BIG_CQE + Checks.check(n, 0) * 8L, l2);
    }

    static {
        Struct.Layout layout = IOURingCQE.__struct(IOURingCQE.__member(8), IOURingCQE.__member(4), IOURingCQE.__member(4), IOURingCQE.__array(8, 0));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        USER_DATA = layout.offsetof(0);
        RES = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        BIG_CQE = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingCQE, Buffer>
    implements NativeResource {
        private static final IOURingCQE ELEMENT_FACTORY = IOURingCQE.create(-1L);

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
        protected IOURingCQE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long user_data() {
            return IOURingCQE.nuser_data(this.address());
        }

        @NativeType(value="__s32")
        public int res() {
            return IOURingCQE.nres(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingCQE.nflags(this.address());
        }

        @NativeType(value="__u64[0]")
        public LongBuffer big_cqe() {
            return IOURingCQE.nbig_cqe(this.address());
        }

        @NativeType(value="__u64")
        public long big_cqe(int n) {
            return IOURingCQE.nbig_cqe(this.address(), n);
        }

        public Buffer user_data(@NativeType(value="__u64") long l) {
            IOURingCQE.nuser_data(this.address(), l);
            return this;
        }

        public Buffer res(@NativeType(value="__s32") int n) {
            IOURingCQE.nres(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOURingCQE.nflags(this.address(), n);
            return this;
        }

        public Buffer big_cqe(@NativeType(value="__u64[0]") LongBuffer longBuffer) {
            IOURingCQE.nbig_cqe(this.address(), longBuffer);
            return this;
        }

        public Buffer big_cqe(int n, @NativeType(value="__u64") long l) {
            IOURingCQE.nbig_cqe(this.address(), n, l);
            return this;
        }
    }
}

