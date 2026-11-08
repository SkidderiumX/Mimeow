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

@NativeType(value="struct io_uring_getevents_arg")
public class IOURingGeteventsArg
extends Struct<IOURingGeteventsArg>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SIGMASK;
    public static final int SIGMASK_SZ;
    public static final int MIN_WAIT_USEC;
    public static final int TS;

    protected IOURingGeteventsArg(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingGeteventsArg create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingGeteventsArg(l, byteBuffer);
    }

    public IOURingGeteventsArg(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingGeteventsArg.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long sigmask() {
        return IOURingGeteventsArg.nsigmask(this.address());
    }

    @NativeType(value="__u32")
    public int sigmask_sz() {
        return IOURingGeteventsArg.nsigmask_sz(this.address());
    }

    @NativeType(value="__u32")
    public int min_wait_usec() {
        return IOURingGeteventsArg.nmin_wait_usec(this.address());
    }

    @NativeType(value="__u64")
    public long ts() {
        return IOURingGeteventsArg.nts(this.address());
    }

    public IOURingGeteventsArg sigmask(@NativeType(value="__u64") long l) {
        IOURingGeteventsArg.nsigmask(this.address(), l);
        return this;
    }

    public IOURingGeteventsArg sigmask_sz(@NativeType(value="__u32") int n) {
        IOURingGeteventsArg.nsigmask_sz(this.address(), n);
        return this;
    }

    public IOURingGeteventsArg min_wait_usec(@NativeType(value="__u32") int n) {
        IOURingGeteventsArg.nmin_wait_usec(this.address(), n);
        return this;
    }

    public IOURingGeteventsArg ts(@NativeType(value="__u64") long l) {
        IOURingGeteventsArg.nts(this.address(), l);
        return this;
    }

    public IOURingGeteventsArg set(long l, int n, int n2, long l2) {
        this.sigmask(l);
        this.sigmask_sz(n);
        this.min_wait_usec(n2);
        this.ts(l2);
        return this;
    }

    public IOURingGeteventsArg set(IOURingGeteventsArg iOURingGeteventsArg) {
        MemoryUtil.memCopy(iOURingGeteventsArg.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingGeteventsArg malloc() {
        return new IOURingGeteventsArg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingGeteventsArg calloc() {
        return new IOURingGeteventsArg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingGeteventsArg create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingGeteventsArg(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingGeteventsArg create(long l) {
        return new IOURingGeteventsArg(l, null);
    }

    public static @Nullable IOURingGeteventsArg createSafe(long l) {
        return l == 0L ? null : new IOURingGeteventsArg(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingGeteventsArg.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingGeteventsArg.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingGeteventsArg malloc(MemoryStack memoryStack) {
        return new IOURingGeteventsArg(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingGeteventsArg calloc(MemoryStack memoryStack) {
        return new IOURingGeteventsArg(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nsigmask(long l) {
        return MemoryUtil.memGetLong(l + (long)SIGMASK);
    }

    public static int nsigmask_sz(long l) {
        return MemoryUtil.memGetInt(l + (long)SIGMASK_SZ);
    }

    public static int nmin_wait_usec(long l) {
        return MemoryUtil.memGetInt(l + (long)MIN_WAIT_USEC);
    }

    public static long nts(long l) {
        return MemoryUtil.memGetLong(l + (long)TS);
    }

    public static void nsigmask(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)SIGMASK, l2);
    }

    public static void nsigmask_sz(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SIGMASK_SZ, n);
    }

    public static void nmin_wait_usec(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MIN_WAIT_USEC, n);
    }

    public static void nts(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)TS, l2);
    }

    static {
        Struct.Layout layout = IOURingGeteventsArg.__struct(IOURingGeteventsArg.__member(8), IOURingGeteventsArg.__member(4), IOURingGeteventsArg.__member(4), IOURingGeteventsArg.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SIGMASK = layout.offsetof(0);
        SIGMASK_SZ = layout.offsetof(1);
        MIN_WAIT_USEC = layout.offsetof(2);
        TS = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingGeteventsArg, Buffer>
    implements NativeResource {
        private static final IOURingGeteventsArg ELEMENT_FACTORY = IOURingGeteventsArg.create(-1L);

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
        protected IOURingGeteventsArg getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long sigmask() {
            return IOURingGeteventsArg.nsigmask(this.address());
        }

        @NativeType(value="__u32")
        public int sigmask_sz() {
            return IOURingGeteventsArg.nsigmask_sz(this.address());
        }

        @NativeType(value="__u32")
        public int min_wait_usec() {
            return IOURingGeteventsArg.nmin_wait_usec(this.address());
        }

        @NativeType(value="__u64")
        public long ts() {
            return IOURingGeteventsArg.nts(this.address());
        }

        public Buffer sigmask(@NativeType(value="__u64") long l) {
            IOURingGeteventsArg.nsigmask(this.address(), l);
            return this;
        }

        public Buffer sigmask_sz(@NativeType(value="__u32") int n) {
            IOURingGeteventsArg.nsigmask_sz(this.address(), n);
            return this;
        }

        public Buffer min_wait_usec(@NativeType(value="__u32") int n) {
            IOURingGeteventsArg.nmin_wait_usec(this.address(), n);
            return this;
        }

        public Buffer ts(@NativeType(value="__u64") long l) {
            IOURingGeteventsArg.nts(this.address(), l);
            return this;
        }
    }
}

