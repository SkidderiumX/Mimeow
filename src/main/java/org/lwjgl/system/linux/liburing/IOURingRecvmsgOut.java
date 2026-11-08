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

@NativeType(value="struct io_uring_recvmsg_out")
public class IOURingRecvmsgOut
extends Struct<IOURingRecvmsgOut>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAMELEN;
    public static final int CONTROLLEN;
    public static final int PAYLOADLEN;
    public static final int FLAGS;

    protected IOURingRecvmsgOut(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingRecvmsgOut create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingRecvmsgOut(l, byteBuffer);
    }

    public IOURingRecvmsgOut(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRecvmsgOut.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int namelen() {
        return IOURingRecvmsgOut.nnamelen(this.address());
    }

    @NativeType(value="__u32")
    public int controllen() {
        return IOURingRecvmsgOut.ncontrollen(this.address());
    }

    @NativeType(value="__u32")
    public int payloadlen() {
        return IOURingRecvmsgOut.npayloadlen(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingRecvmsgOut.nflags(this.address());
    }

    public IOURingRecvmsgOut namelen(@NativeType(value="__u32") int n) {
        IOURingRecvmsgOut.nnamelen(this.address(), n);
        return this;
    }

    public IOURingRecvmsgOut controllen(@NativeType(value="__u32") int n) {
        IOURingRecvmsgOut.ncontrollen(this.address(), n);
        return this;
    }

    public IOURingRecvmsgOut payloadlen(@NativeType(value="__u32") int n) {
        IOURingRecvmsgOut.npayloadlen(this.address(), n);
        return this;
    }

    public IOURingRecvmsgOut flags(@NativeType(value="__u32") int n) {
        IOURingRecvmsgOut.nflags(this.address(), n);
        return this;
    }

    public IOURingRecvmsgOut set(int n, int n2, int n3, int n4) {
        this.namelen(n);
        this.controllen(n2);
        this.payloadlen(n3);
        this.flags(n4);
        return this;
    }

    public IOURingRecvmsgOut set(IOURingRecvmsgOut iOURingRecvmsgOut) {
        MemoryUtil.memCopy(iOURingRecvmsgOut.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRecvmsgOut malloc() {
        return new IOURingRecvmsgOut(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRecvmsgOut calloc() {
        return new IOURingRecvmsgOut(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRecvmsgOut create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRecvmsgOut(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRecvmsgOut create(long l) {
        return new IOURingRecvmsgOut(l, null);
    }

    public static @Nullable IOURingRecvmsgOut createSafe(long l) {
        return l == 0L ? null : new IOURingRecvmsgOut(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRecvmsgOut.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingRecvmsgOut.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingRecvmsgOut malloc(MemoryStack memoryStack) {
        return new IOURingRecvmsgOut(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRecvmsgOut calloc(MemoryStack memoryStack) {
        return new IOURingRecvmsgOut(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nnamelen(long l) {
        return MemoryUtil.memGetInt(l + (long)NAMELEN);
    }

    public static int ncontrollen(long l) {
        return MemoryUtil.memGetInt(l + (long)CONTROLLEN);
    }

    public static int npayloadlen(long l) {
        return MemoryUtil.memGetInt(l + (long)PAYLOADLEN);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static void nnamelen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)NAMELEN, n);
    }

    public static void ncontrollen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CONTROLLEN, n);
    }

    public static void npayloadlen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)PAYLOADLEN, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    static {
        Struct.Layout layout = IOURingRecvmsgOut.__struct(IOURingRecvmsgOut.__member(4), IOURingRecvmsgOut.__member(4), IOURingRecvmsgOut.__member(4), IOURingRecvmsgOut.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NAMELEN = layout.offsetof(0);
        CONTROLLEN = layout.offsetof(1);
        PAYLOADLEN = layout.offsetof(2);
        FLAGS = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingRecvmsgOut, Buffer>
    implements NativeResource {
        private static final IOURingRecvmsgOut ELEMENT_FACTORY = IOURingRecvmsgOut.create(-1L);

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
        protected IOURingRecvmsgOut getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int namelen() {
            return IOURingRecvmsgOut.nnamelen(this.address());
        }

        @NativeType(value="__u32")
        public int controllen() {
            return IOURingRecvmsgOut.ncontrollen(this.address());
        }

        @NativeType(value="__u32")
        public int payloadlen() {
            return IOURingRecvmsgOut.npayloadlen(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingRecvmsgOut.nflags(this.address());
        }

        public Buffer namelen(@NativeType(value="__u32") int n) {
            IOURingRecvmsgOut.nnamelen(this.address(), n);
            return this;
        }

        public Buffer controllen(@NativeType(value="__u32") int n) {
            IOURingRecvmsgOut.ncontrollen(this.address(), n);
            return this;
        }

        public Buffer payloadlen(@NativeType(value="__u32") int n) {
            IOURingRecvmsgOut.npayloadlen(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOURingRecvmsgOut.nflags(this.address(), n);
            return this;
        }
    }
}

