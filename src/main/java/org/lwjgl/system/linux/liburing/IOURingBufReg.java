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

@NativeType(value="struct io_uring_buf_reg")
public class IOURingBufReg
extends Struct<IOURingBufReg>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RING_ADDR;
    public static final int RING_ENTRIES;
    public static final int BGID;
    public static final int FLAGS;
    public static final int RESV;

    protected IOURingBufReg(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingBufReg create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingBufReg(l, byteBuffer);
    }

    public IOURingBufReg(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingBufReg.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long ring_addr() {
        return IOURingBufReg.nring_addr(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOURingBufReg.nring_entries(this.address());
    }

    @NativeType(value="__u16")
    public short bgid() {
        return IOURingBufReg.nbgid(this.address());
    }

    @NativeType(value="__u16")
    public short flags() {
        return IOURingBufReg.nflags(this.address());
    }

    public IOURingBufReg ring_addr(@NativeType(value="__u64") long l) {
        IOURingBufReg.nring_addr(this.address(), l);
        return this;
    }

    public IOURingBufReg ring_entries(@NativeType(value="__u32") int n) {
        IOURingBufReg.nring_entries(this.address(), n);
        return this;
    }

    public IOURingBufReg bgid(@NativeType(value="__u16") short s) {
        IOURingBufReg.nbgid(this.address(), s);
        return this;
    }

    public IOURingBufReg flags(@NativeType(value="__u16") short s) {
        IOURingBufReg.nflags(this.address(), s);
        return this;
    }

    public IOURingBufReg set(long l, int n, short s, short s2) {
        this.ring_addr(l);
        this.ring_entries(n);
        this.bgid(s);
        this.flags(s2);
        return this;
    }

    public IOURingBufReg set(IOURingBufReg iOURingBufReg) {
        MemoryUtil.memCopy(iOURingBufReg.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingBufReg malloc() {
        return new IOURingBufReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingBufReg calloc() {
        return new IOURingBufReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingBufReg create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingBufReg(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingBufReg create(long l) {
        return new IOURingBufReg(l, null);
    }

    public static @Nullable IOURingBufReg createSafe(long l) {
        return l == 0L ? null : new IOURingBufReg(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingBufReg.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingBufReg.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingBufReg malloc(MemoryStack memoryStack) {
        return new IOURingBufReg(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingBufReg calloc(MemoryStack memoryStack) {
        return new IOURingBufReg(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nring_addr(long l) {
        return MemoryUtil.memGetLong(l + (long)RING_ADDR);
    }

    public static int nring_entries(long l) {
        return MemoryUtil.memGetInt(l + (long)RING_ENTRIES);
    }

    public static short nbgid(long l) {
        return MemoryUtil.memGetShort(l + (long)BGID);
    }

    public static short nflags(long l) {
        return MemoryUtil.memGetShort(l + (long)FLAGS);
    }

    public static LongBuffer nresv(long l) {
        return MemoryUtil.memLongBuffer(l + (long)RESV, 3);
    }

    public static long nresv(long l, int n) {
        return MemoryUtil.memGetLong(l + (long)RESV + Checks.check(n, 3) * 8L);
    }

    public static void nring_addr(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)RING_ADDR, l2);
    }

    public static void nring_entries(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RING_ENTRIES, n);
    }

    public static void nbgid(long l, short s) {
        MemoryUtil.memPutShort(l + (long)BGID, s);
    }

    public static void nflags(long l, short s) {
        MemoryUtil.memPutShort(l + (long)FLAGS, s);
    }

    public static void nresv(long l, LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(longBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(longBuffer), l + (long)RESV, longBuffer.remaining() * 8);
    }

    public static void nresv(long l, int n, long l2) {
        MemoryUtil.memPutLong(l + (long)RESV + Checks.check(n, 3) * 8L, l2);
    }

    static {
        Struct.Layout layout = IOURingBufReg.__struct(IOURingBufReg.__member(8), IOURingBufReg.__member(4), IOURingBufReg.__member(2), IOURingBufReg.__member(2), IOURingBufReg.__array(8, 3));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        RING_ADDR = layout.offsetof(0);
        RING_ENTRIES = layout.offsetof(1);
        BGID = layout.offsetof(2);
        FLAGS = layout.offsetof(3);
        RESV = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingBufReg, Buffer>
    implements NativeResource {
        private static final IOURingBufReg ELEMENT_FACTORY = IOURingBufReg.create(-1L);

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
        protected IOURingBufReg getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long ring_addr() {
            return IOURingBufReg.nring_addr(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOURingBufReg.nring_entries(this.address());
        }

        @NativeType(value="__u16")
        public short bgid() {
            return IOURingBufReg.nbgid(this.address());
        }

        @NativeType(value="__u16")
        public short flags() {
            return IOURingBufReg.nflags(this.address());
        }

        public Buffer ring_addr(@NativeType(value="__u64") long l) {
            IOURingBufReg.nring_addr(this.address(), l);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int n) {
            IOURingBufReg.nring_entries(this.address(), n);
            return this;
        }

        public Buffer bgid(@NativeType(value="__u16") short s) {
            IOURingBufReg.nbgid(this.address(), s);
            return this;
        }

        public Buffer flags(@NativeType(value="__u16") short s) {
            IOURingBufReg.nflags(this.address(), s);
            return this;
        }
    }
}

