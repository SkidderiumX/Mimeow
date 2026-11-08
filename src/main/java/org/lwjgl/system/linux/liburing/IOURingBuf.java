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

@NativeType(value="struct io_uring_buf")
public class IOURingBuf
extends Struct<IOURingBuf>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ADDR;
    public static final int LEN;
    public static final int BID;
    public static final int RESV;

    protected IOURingBuf(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingBuf create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingBuf(l, byteBuffer);
    }

    public IOURingBuf(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingBuf.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long addr() {
        return IOURingBuf.naddr(this.address());
    }

    @NativeType(value="__u32")
    public int len() {
        return IOURingBuf.nlen(this.address());
    }

    @NativeType(value="__u16")
    public short bid() {
        return IOURingBuf.nbid(this.address());
    }

    public IOURingBuf addr(@NativeType(value="__u64") long l) {
        IOURingBuf.naddr(this.address(), l);
        return this;
    }

    public IOURingBuf len(@NativeType(value="__u32") int n) {
        IOURingBuf.nlen(this.address(), n);
        return this;
    }

    public IOURingBuf bid(@NativeType(value="__u16") short s) {
        IOURingBuf.nbid(this.address(), s);
        return this;
    }

    public IOURingBuf set(long l, int n, short s) {
        this.addr(l);
        this.len(n);
        this.bid(s);
        return this;
    }

    public IOURingBuf set(IOURingBuf iOURingBuf) {
        MemoryUtil.memCopy(iOURingBuf.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingBuf malloc() {
        return new IOURingBuf(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingBuf calloc() {
        return new IOURingBuf(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingBuf create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingBuf(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingBuf create(long l) {
        return new IOURingBuf(l, null);
    }

    public static @Nullable IOURingBuf createSafe(long l) {
        return l == 0L ? null : new IOURingBuf(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingBuf.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingBuf.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingBuf malloc(MemoryStack memoryStack) {
        return new IOURingBuf(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingBuf calloc(MemoryStack memoryStack) {
        return new IOURingBuf(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nlen(long l) {
        return MemoryUtil.memGetInt(l + (long)LEN);
    }

    public static short nbid(long l) {
        return MemoryUtil.memGetShort(l + (long)BID);
    }

    public static short nresv(long l) {
        return MemoryUtil.memGetShort(l + (long)RESV);
    }

    public static void naddr(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)ADDR, l2);
    }

    public static void nlen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)LEN, n);
    }

    public static void nbid(long l, short s) {
        MemoryUtil.memPutShort(l + (long)BID, s);
    }

    public static void nresv(long l, short s) {
        MemoryUtil.memPutShort(l + (long)RESV, s);
    }

    static {
        Struct.Layout layout = IOURingBuf.__struct(IOURingBuf.__member(8), IOURingBuf.__member(4), IOURingBuf.__member(2), IOURingBuf.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ADDR = layout.offsetof(0);
        LEN = layout.offsetof(1);
        BID = layout.offsetof(2);
        RESV = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingBuf, Buffer>
    implements NativeResource {
        private static final IOURingBuf ELEMENT_FACTORY = IOURingBuf.create(-1L);

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
        protected IOURingBuf getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long addr() {
            return IOURingBuf.naddr(this.address());
        }

        @NativeType(value="__u32")
        public int len() {
            return IOURingBuf.nlen(this.address());
        }

        @NativeType(value="__u16")
        public short bid() {
            return IOURingBuf.nbid(this.address());
        }

        public Buffer addr(@NativeType(value="__u64") long l) {
            IOURingBuf.naddr(this.address(), l);
            return this;
        }

        public Buffer len(@NativeType(value="__u32") int n) {
            IOURingBuf.nlen(this.address(), n);
            return this;
        }

        public Buffer bid(@NativeType(value="__u16") short s) {
            IOURingBuf.nbid(this.address(), s);
            return this;
        }
    }
}

