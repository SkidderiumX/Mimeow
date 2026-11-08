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

@NativeType(value="struct io_uring_probe_op")
public class IOURingProbeOp
extends Struct<IOURingProbeOp>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OP;
    public static final int RESV;
    public static final int FLAGS;
    public static final int RESV2;

    protected IOURingProbeOp(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingProbeOp create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingProbeOp(l, byteBuffer);
    }

    public IOURingProbeOp(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingProbeOp.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte op() {
        return IOURingProbeOp.nop(this.address());
    }

    @NativeType(value="__u16")
    public short flags() {
        return IOURingProbeOp.nflags(this.address());
    }

    public IOURingProbeOp op(@NativeType(value="__u8") byte by) {
        IOURingProbeOp.nop(this.address(), by);
        return this;
    }

    public IOURingProbeOp flags(@NativeType(value="__u16") short s) {
        IOURingProbeOp.nflags(this.address(), s);
        return this;
    }

    public IOURingProbeOp set(byte by, short s) {
        this.op(by);
        this.flags(s);
        return this;
    }

    public IOURingProbeOp set(IOURingProbeOp iOURingProbeOp) {
        MemoryUtil.memCopy(iOURingProbeOp.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingProbeOp malloc() {
        return new IOURingProbeOp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingProbeOp calloc() {
        return new IOURingProbeOp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingProbeOp create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingProbeOp(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingProbeOp create(long l) {
        return new IOURingProbeOp(l, null);
    }

    public static @Nullable IOURingProbeOp createSafe(long l) {
        return l == 0L ? null : new IOURingProbeOp(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingProbeOp.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingProbeOp.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingProbeOp malloc(MemoryStack memoryStack) {
        return new IOURingProbeOp(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingProbeOp calloc(MemoryStack memoryStack) {
        return new IOURingProbeOp(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static byte nop(long l) {
        return MemoryUtil.memGetByte(l + (long)OP);
    }

    public static byte nresv(long l) {
        return MemoryUtil.memGetByte(l + (long)RESV);
    }

    public static short nflags(long l) {
        return MemoryUtil.memGetShort(l + (long)FLAGS);
    }

    public static int nresv2(long l) {
        return MemoryUtil.memGetInt(l + (long)RESV2);
    }

    public static void nop(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)OP, by);
    }

    public static void nresv(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)RESV, by);
    }

    public static void nflags(long l, short s) {
        MemoryUtil.memPutShort(l + (long)FLAGS, s);
    }

    public static void nresv2(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RESV2, n);
    }

    static {
        Struct.Layout layout = IOURingProbeOp.__struct(IOURingProbeOp.__member(1), IOURingProbeOp.__member(1), IOURingProbeOp.__member(2), IOURingProbeOp.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OP = layout.offsetof(0);
        RESV = layout.offsetof(1);
        FLAGS = layout.offsetof(2);
        RESV2 = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingProbeOp, Buffer>
    implements NativeResource {
        private static final IOURingProbeOp ELEMENT_FACTORY = IOURingProbeOp.create(-1L);

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
        protected IOURingProbeOp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte op() {
            return IOURingProbeOp.nop(this.address());
        }

        @NativeType(value="__u16")
        public short flags() {
            return IOURingProbeOp.nflags(this.address());
        }

        public Buffer op(@NativeType(value="__u8") byte by) {
            IOURingProbeOp.nop(this.address(), by);
            return this;
        }

        public Buffer flags(@NativeType(value="__u16") short s) {
            IOURingProbeOp.nflags(this.address(), s);
            return this;
        }
    }
}

