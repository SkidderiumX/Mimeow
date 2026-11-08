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
import org.lwjgl.system.linux.liburing.IOURingProbeOp;

@NativeType(value="struct io_uring_probe")
public class IOURingProbe
extends Struct<IOURingProbe>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LAST_OP;
    public static final int OPS_LEN;
    public static final int RESV;
    public static final int RESV2;
    public static final int OPS;

    protected IOURingProbe(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingProbe create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingProbe(l, byteBuffer);
    }

    public IOURingProbe(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingProbe.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte last_op() {
        return IOURingProbe.nlast_op(this.address());
    }

    @NativeType(value="__u8")
    public byte ops_len() {
        return IOURingProbe.nops_len(this.address());
    }

    @NativeType(value="struct io_uring_probe_op[0]")
    public IOURingProbeOp.Buffer ops() {
        return IOURingProbe.nops(this.address());
    }

    @NativeType(value="struct io_uring_probe_op")
    public IOURingProbeOp ops(int n) {
        return IOURingProbe.nops(this.address(), n);
    }

    public IOURingProbe last_op(@NativeType(value="__u8") byte by) {
        IOURingProbe.nlast_op(this.address(), by);
        return this;
    }

    public IOURingProbe ops_len(@NativeType(value="__u8") byte by) {
        IOURingProbe.nops_len(this.address(), by);
        return this;
    }

    public IOURingProbe ops(@NativeType(value="struct io_uring_probe_op[0]") IOURingProbeOp.Buffer buffer) {
        IOURingProbe.nops(this.address(), buffer);
        return this;
    }

    public IOURingProbe ops(int n, @NativeType(value="struct io_uring_probe_op") IOURingProbeOp iOURingProbeOp) {
        IOURingProbe.nops(this.address(), n, iOURingProbeOp);
        return this;
    }

    public IOURingProbe ops(Consumer<IOURingProbeOp.Buffer> consumer) {
        consumer.accept(this.ops());
        return this;
    }

    public IOURingProbe ops(int n, Consumer<IOURingProbeOp> consumer) {
        consumer.accept(this.ops(n));
        return this;
    }

    public IOURingProbe set(byte by, byte by2, IOURingProbeOp.Buffer buffer) {
        this.last_op(by);
        this.ops_len(by2);
        this.ops(buffer);
        return this;
    }

    public IOURingProbe set(IOURingProbe iOURingProbe) {
        MemoryUtil.memCopy(iOURingProbe.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingProbe malloc() {
        return new IOURingProbe(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingProbe calloc() {
        return new IOURingProbe(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingProbe create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingProbe(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingProbe create(long l) {
        return new IOURingProbe(l, null);
    }

    public static @Nullable IOURingProbe createSafe(long l) {
        return l == 0L ? null : new IOURingProbe(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingProbe.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingProbe.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingProbe malloc(MemoryStack memoryStack) {
        return new IOURingProbe(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingProbe calloc(MemoryStack memoryStack) {
        return new IOURingProbe(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static byte nlast_op(long l) {
        return MemoryUtil.memGetByte(l + (long)LAST_OP);
    }

    public static byte nops_len(long l) {
        return MemoryUtil.memGetByte(l + (long)OPS_LEN);
    }

    public static short nresv(long l) {
        return MemoryUtil.memGetShort(l + (long)RESV);
    }

    public static IntBuffer nresv2(long l) {
        return MemoryUtil.memIntBuffer(l + (long)RESV2, 3);
    }

    public static int nresv2(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)RESV2 + Checks.check(n, 3) * 4L);
    }

    public static IOURingProbeOp.Buffer nops(long l) {
        return IOURingProbeOp.create(l + (long)OPS, 0);
    }

    public static IOURingProbeOp nops(long l, int n) {
        return IOURingProbeOp.create(l + (long)OPS + Checks.check(n, 0) * (long)IOURingProbeOp.SIZEOF);
    }

    public static void nlast_op(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)LAST_OP, by);
    }

    public static void nops_len(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)OPS_LEN, by);
    }

    public static void nresv(long l, short s) {
        MemoryUtil.memPutShort(l + (long)RESV, s);
    }

    public static void nresv2(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)RESV2, intBuffer.remaining() * 4);
    }

    public static void nresv2(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)RESV2 + Checks.check(n, 3) * 4L, n2);
    }

    public static void nops(long l, IOURingProbeOp.Buffer buffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(buffer, 0);
        }
        MemoryUtil.memCopy(buffer.address(), l + (long)OPS, buffer.remaining() * IOURingProbeOp.SIZEOF);
    }

    public static void nops(long l, int n, IOURingProbeOp iOURingProbeOp) {
        MemoryUtil.memCopy(iOURingProbeOp.address(), l + (long)OPS + Checks.check(n, 0) * (long)IOURingProbeOp.SIZEOF, IOURingProbeOp.SIZEOF);
    }

    static {
        Struct.Layout layout = IOURingProbe.__struct(IOURingProbe.__member(1), IOURingProbe.__member(1), IOURingProbe.__member(2), IOURingProbe.__array(4, 3), IOURingProbe.__array(IOURingProbeOp.SIZEOF, IOURingProbeOp.ALIGNOF, 0));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        LAST_OP = layout.offsetof(0);
        OPS_LEN = layout.offsetof(1);
        RESV = layout.offsetof(2);
        RESV2 = layout.offsetof(3);
        OPS = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingProbe, Buffer>
    implements NativeResource {
        private static final IOURingProbe ELEMENT_FACTORY = IOURingProbe.create(-1L);

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
        protected IOURingProbe getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte last_op() {
            return IOURingProbe.nlast_op(this.address());
        }

        @NativeType(value="__u8")
        public byte ops_len() {
            return IOURingProbe.nops_len(this.address());
        }

        @NativeType(value="struct io_uring_probe_op[0]")
        public IOURingProbeOp.Buffer ops() {
            return IOURingProbe.nops(this.address());
        }

        @NativeType(value="struct io_uring_probe_op")
        public IOURingProbeOp ops(int n) {
            return IOURingProbe.nops(this.address(), n);
        }

        public Buffer last_op(@NativeType(value="__u8") byte by) {
            IOURingProbe.nlast_op(this.address(), by);
            return this;
        }

        public Buffer ops_len(@NativeType(value="__u8") byte by) {
            IOURingProbe.nops_len(this.address(), by);
            return this;
        }

        public Buffer ops(@NativeType(value="struct io_uring_probe_op[0]") IOURingProbeOp.Buffer buffer) {
            IOURingProbe.nops(this.address(), buffer);
            return this;
        }

        public Buffer ops(int n, @NativeType(value="struct io_uring_probe_op") IOURingProbeOp iOURingProbeOp) {
            IOURingProbe.nops(this.address(), n, iOURingProbeOp);
            return this;
        }

        public Buffer ops(Consumer<IOURingProbeOp.Buffer> consumer) {
            consumer.accept(this.ops());
            return this;
        }

        public Buffer ops(int n, Consumer<IOURingProbeOp> consumer) {
            consumer.accept(this.ops(n));
            return this;
        }
    }
}

