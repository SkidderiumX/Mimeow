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
import org.lwjgl.system.linux.liburing.IOURingBuf;

@NativeType(value="struct io_uring_buf_ring")
public class IOURingBufRing
extends Struct<IOURingBufRing>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RESV1;
    public static final int RESV2;
    public static final int RESV3;
    public static final int TAIL;
    public static final int BUFS;

    protected IOURingBufRing(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingBufRing create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingBufRing(l, byteBuffer);
    }

    public IOURingBufRing(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingBufRing.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long resv1() {
        return IOURingBufRing.nresv1(this.address());
    }

    @NativeType(value="__u32")
    public int resv2() {
        return IOURingBufRing.nresv2(this.address());
    }

    @NativeType(value="__u16")
    public short resv3() {
        return IOURingBufRing.nresv3(this.address());
    }

    @NativeType(value="__u16")
    public short tail() {
        return IOURingBufRing.ntail(this.address());
    }

    @NativeType(value="struct io_uring_buf[0]")
    public IOURingBuf.Buffer bufs() {
        return IOURingBufRing.nbufs(this.address());
    }

    @NativeType(value="struct io_uring_buf")
    public IOURingBuf bufs(int n) {
        return IOURingBufRing.nbufs(this.address(), n);
    }

    public IOURingBufRing resv1(@NativeType(value="__u64") long l) {
        IOURingBufRing.nresv1(this.address(), l);
        return this;
    }

    public IOURingBufRing resv2(@NativeType(value="__u32") int n) {
        IOURingBufRing.nresv2(this.address(), n);
        return this;
    }

    public IOURingBufRing resv3(@NativeType(value="__u16") short s) {
        IOURingBufRing.nresv3(this.address(), s);
        return this;
    }

    public IOURingBufRing tail(@NativeType(value="__u16") short s) {
        IOURingBufRing.ntail(this.address(), s);
        return this;
    }

    public IOURingBufRing bufs(@NativeType(value="struct io_uring_buf[0]") IOURingBuf.Buffer buffer) {
        IOURingBufRing.nbufs(this.address(), buffer);
        return this;
    }

    public IOURingBufRing bufs(int n, @NativeType(value="struct io_uring_buf") IOURingBuf iOURingBuf) {
        IOURingBufRing.nbufs(this.address(), n, iOURingBuf);
        return this;
    }

    public IOURingBufRing bufs(Consumer<IOURingBuf.Buffer> consumer) {
        consumer.accept(this.bufs());
        return this;
    }

    public IOURingBufRing bufs(int n, Consumer<IOURingBuf> consumer) {
        consumer.accept(this.bufs(n));
        return this;
    }

    public IOURingBufRing set(IOURingBufRing iOURingBufRing) {
        MemoryUtil.memCopy(iOURingBufRing.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingBufRing malloc() {
        return new IOURingBufRing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingBufRing calloc() {
        return new IOURingBufRing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingBufRing create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingBufRing(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingBufRing create(long l) {
        return new IOURingBufRing(l, null);
    }

    public static @Nullable IOURingBufRing createSafe(long l) {
        return l == 0L ? null : new IOURingBufRing(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingBufRing.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingBufRing.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingBufRing malloc(MemoryStack memoryStack) {
        return new IOURingBufRing(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingBufRing calloc(MemoryStack memoryStack) {
        return new IOURingBufRing(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nresv1(long l) {
        return MemoryUtil.memGetLong(l + (long)RESV1);
    }

    public static int nresv2(long l) {
        return MemoryUtil.memGetInt(l + (long)RESV2);
    }

    public static short nresv3(long l) {
        return MemoryUtil.memGetShort(l + (long)RESV3);
    }

    public static short ntail(long l) {
        return MemoryUtil.memGetShort(l + (long)TAIL);
    }

    public static IOURingBuf.Buffer nbufs(long l) {
        return IOURingBuf.create(l + (long)BUFS, 0);
    }

    public static IOURingBuf nbufs(long l, int n) {
        return IOURingBuf.create(l + (long)BUFS + Checks.check(n, 0) * (long)IOURingBuf.SIZEOF);
    }

    public static void nresv1(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)RESV1, l2);
    }

    public static void nresv2(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RESV2, n);
    }

    public static void nresv3(long l, short s) {
        MemoryUtil.memPutShort(l + (long)RESV3, s);
    }

    public static void ntail(long l, short s) {
        MemoryUtil.memPutShort(l + (long)TAIL, s);
    }

    public static void nbufs(long l, IOURingBuf.Buffer buffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(buffer, 0);
        }
        MemoryUtil.memCopy(buffer.address(), l + (long)BUFS, buffer.remaining() * IOURingBuf.SIZEOF);
    }

    public static void nbufs(long l, int n, IOURingBuf iOURingBuf) {
        MemoryUtil.memCopy(iOURingBuf.address(), l + (long)BUFS + Checks.check(n, 0) * (long)IOURingBuf.SIZEOF, IOURingBuf.SIZEOF);
    }

    static {
        Struct.Layout layout = IOURingBufRing.__struct(IOURingBufRing.__union(IOURingBufRing.__struct(IOURingBufRing.__member(8), IOURingBufRing.__member(4), IOURingBufRing.__member(2), IOURingBufRing.__member(2)), IOURingBufRing.__array(IOURingBuf.SIZEOF, IOURingBuf.ALIGNOF, 0)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        RESV1 = layout.offsetof(2);
        RESV2 = layout.offsetof(3);
        RESV3 = layout.offsetof(4);
        TAIL = layout.offsetof(5);
        BUFS = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<IOURingBufRing, Buffer>
    implements NativeResource {
        private static final IOURingBufRing ELEMENT_FACTORY = IOURingBufRing.create(-1L);

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
        protected IOURingBufRing getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long resv1() {
            return IOURingBufRing.nresv1(this.address());
        }

        @NativeType(value="__u32")
        public int resv2() {
            return IOURingBufRing.nresv2(this.address());
        }

        @NativeType(value="__u16")
        public short resv3() {
            return IOURingBufRing.nresv3(this.address());
        }

        @NativeType(value="__u16")
        public short tail() {
            return IOURingBufRing.ntail(this.address());
        }

        @NativeType(value="struct io_uring_buf[0]")
        public IOURingBuf.Buffer bufs() {
            return IOURingBufRing.nbufs(this.address());
        }

        @NativeType(value="struct io_uring_buf")
        public IOURingBuf bufs(int n) {
            return IOURingBufRing.nbufs(this.address(), n);
        }

        public Buffer resv1(@NativeType(value="__u64") long l) {
            IOURingBufRing.nresv1(this.address(), l);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u32") int n) {
            IOURingBufRing.nresv2(this.address(), n);
            return this;
        }

        public Buffer resv3(@NativeType(value="__u16") short s) {
            IOURingBufRing.nresv3(this.address(), s);
            return this;
        }

        public Buffer tail(@NativeType(value="__u16") short s) {
            IOURingBufRing.ntail(this.address(), s);
            return this;
        }

        public Buffer bufs(@NativeType(value="struct io_uring_buf[0]") IOURingBuf.Buffer buffer) {
            IOURingBufRing.nbufs(this.address(), buffer);
            return this;
        }

        public Buffer bufs(int n, @NativeType(value="struct io_uring_buf") IOURingBuf iOURingBuf) {
            IOURingBufRing.nbufs(this.address(), n, iOURingBuf);
            return this;
        }

        public Buffer bufs(Consumer<IOURingBuf.Buffer> consumer) {
            consumer.accept(this.bufs());
            return this;
        }

        public Buffer bufs(int n, Consumer<IOURingBuf> consumer) {
            consumer.accept(this.bufs(n));
            return this;
        }
    }
}

