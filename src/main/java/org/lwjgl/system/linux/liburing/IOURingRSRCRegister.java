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

@NativeType(value="struct io_uring_rsrc_register")
public class IOURingRSRCRegister
extends Struct<IOURingRSRCRegister>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NR;
    public static final int FLAGS;
    public static final int RESV2;
    public static final int DATA;
    public static final int TAGS;

    protected IOURingRSRCRegister(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingRSRCRegister create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingRSRCRegister(l, byteBuffer);
    }

    public IOURingRSRCRegister(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRSRCRegister.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int nr() {
        return IOURingRSRCRegister.nnr(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingRSRCRegister.nflags(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCRegister.ndata(this.address());
    }

    @NativeType(value="__u64")
    public long tags() {
        return IOURingRSRCRegister.ntags(this.address());
    }

    public IOURingRSRCRegister nr(@NativeType(value="__u32") int n) {
        IOURingRSRCRegister.nnr(this.address(), n);
        return this;
    }

    public IOURingRSRCRegister flags(@NativeType(value="__u32") int n) {
        IOURingRSRCRegister.nflags(this.address(), n);
        return this;
    }

    public IOURingRSRCRegister data(@NativeType(value="__u64") long l) {
        IOURingRSRCRegister.ndata(this.address(), l);
        return this;
    }

    public IOURingRSRCRegister tags(@NativeType(value="__u64") long l) {
        IOURingRSRCRegister.ntags(this.address(), l);
        return this;
    }

    public IOURingRSRCRegister set(int n, int n2, long l, long l2) {
        this.nr(n);
        this.flags(n2);
        this.data(l);
        this.tags(l2);
        return this;
    }

    public IOURingRSRCRegister set(IOURingRSRCRegister iOURingRSRCRegister) {
        MemoryUtil.memCopy(iOURingRSRCRegister.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCRegister malloc() {
        return new IOURingRSRCRegister(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRSRCRegister calloc() {
        return new IOURingRSRCRegister(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRSRCRegister create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRSRCRegister(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRSRCRegister create(long l) {
        return new IOURingRSRCRegister(l, null);
    }

    public static @Nullable IOURingRSRCRegister createSafe(long l) {
        return l == 0L ? null : new IOURingRSRCRegister(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRSRCRegister.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingRSRCRegister.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingRSRCRegister malloc(MemoryStack memoryStack) {
        return new IOURingRSRCRegister(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRSRCRegister calloc(MemoryStack memoryStack) {
        return new IOURingRSRCRegister(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nnr(long l) {
        return MemoryUtil.memGetInt(l + (long)NR);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static long nresv2(long l) {
        return MemoryUtil.memGetLong(l + (long)RESV2);
    }

    public static long ndata(long l) {
        return MemoryUtil.memGetLong(l + (long)DATA);
    }

    public static long ntags(long l) {
        return MemoryUtil.memGetLong(l + (long)TAGS);
    }

    public static void nnr(long l, int n) {
        MemoryUtil.memPutInt(l + (long)NR, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void nresv2(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)RESV2, l2);
    }

    public static void ndata(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)DATA, l2);
    }

    public static void ntags(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)TAGS, l2);
    }

    static {
        Struct.Layout layout = IOURingRSRCRegister.__struct(IOURingRSRCRegister.__member(4), IOURingRSRCRegister.__member(4), IOURingRSRCRegister.__member(8), IOURingRSRCRegister.__member(8), IOURingRSRCRegister.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NR = layout.offsetof(0);
        FLAGS = layout.offsetof(1);
        RESV2 = layout.offsetof(2);
        DATA = layout.offsetof(3);
        TAGS = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCRegister, Buffer>
    implements NativeResource {
        private static final IOURingRSRCRegister ELEMENT_FACTORY = IOURingRSRCRegister.create(-1L);

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
        protected IOURingRSRCRegister getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int nr() {
            return IOURingRSRCRegister.nnr(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingRSRCRegister.nflags(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCRegister.ndata(this.address());
        }

        @NativeType(value="__u64")
        public long tags() {
            return IOURingRSRCRegister.ntags(this.address());
        }

        public Buffer nr(@NativeType(value="__u32") int n) {
            IOURingRSRCRegister.nnr(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOURingRSRCRegister.nflags(this.address(), n);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long l) {
            IOURingRSRCRegister.ndata(this.address(), l);
            return this;
        }

        public Buffer tags(@NativeType(value="__u64") long l) {
            IOURingRSRCRegister.ntags(this.address(), l);
            return this;
        }
    }
}

