/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_restriction")
public class IOURingRestriction
extends Struct<IOURingRestriction>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OPCODE;
    public static final int REGISTER_OP;
    public static final int SQE_OP;
    public static final int SQE_FLAGS;
    public static final int RESV;
    public static final int RESV2;

    protected IOURingRestriction(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingRestriction create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingRestriction(l, byteBuffer);
    }

    public IOURingRestriction(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRestriction.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u16")
    public short opcode() {
        return IOURingRestriction.nopcode(this.address());
    }

    @NativeType(value="__u8")
    public byte register_op() {
        return IOURingRestriction.nregister_op(this.address());
    }

    @NativeType(value="__u8")
    public byte sqe_op() {
        return IOURingRestriction.nsqe_op(this.address());
    }

    @NativeType(value="__u8")
    public byte sqe_flags() {
        return IOURingRestriction.nsqe_flags(this.address());
    }

    public IOURingRestriction opcode(@NativeType(value="__u16") short s) {
        IOURingRestriction.nopcode(this.address(), s);
        return this;
    }

    public IOURingRestriction register_op(@NativeType(value="__u8") byte by) {
        IOURingRestriction.nregister_op(this.address(), by);
        return this;
    }

    public IOURingRestriction sqe_op(@NativeType(value="__u8") byte by) {
        IOURingRestriction.nsqe_op(this.address(), by);
        return this;
    }

    public IOURingRestriction sqe_flags(@NativeType(value="__u8") byte by) {
        IOURingRestriction.nsqe_flags(this.address(), by);
        return this;
    }

    public IOURingRestriction set(IOURingRestriction iOURingRestriction) {
        MemoryUtil.memCopy(iOURingRestriction.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRestriction malloc() {
        return new IOURingRestriction(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRestriction calloc() {
        return new IOURingRestriction(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRestriction create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRestriction(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRestriction create(long l) {
        return new IOURingRestriction(l, null);
    }

    public static @Nullable IOURingRestriction createSafe(long l) {
        return l == 0L ? null : new IOURingRestriction(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRestriction.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingRestriction.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingRestriction malloc(MemoryStack memoryStack) {
        return new IOURingRestriction(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRestriction calloc(MemoryStack memoryStack) {
        return new IOURingRestriction(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static short nopcode(long l) {
        return MemoryUtil.memGetShort(l + (long)OPCODE);
    }

    public static byte nregister_op(long l) {
        return MemoryUtil.memGetByte(l + (long)REGISTER_OP);
    }

    public static byte nsqe_op(long l) {
        return MemoryUtil.memGetByte(l + (long)SQE_OP);
    }

    public static byte nsqe_flags(long l) {
        return MemoryUtil.memGetByte(l + (long)SQE_FLAGS);
    }

    public static byte nresv(long l) {
        return MemoryUtil.memGetByte(l + (long)RESV);
    }

    public static IntBuffer nresv2(long l) {
        return MemoryUtil.memIntBuffer(l + (long)RESV2, 3);
    }

    public static int nresv2(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)RESV2 + Checks.check(n, 3) * 4L);
    }

    public static void nopcode(long l, short s) {
        MemoryUtil.memPutShort(l + (long)OPCODE, s);
    }

    public static void nregister_op(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)REGISTER_OP, by);
    }

    public static void nsqe_op(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)SQE_OP, by);
    }

    public static void nsqe_flags(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)SQE_FLAGS, by);
    }

    public static void nresv(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)RESV, by);
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

    static {
        Struct.Layout layout = IOURingRestriction.__struct(IOURingRestriction.__member(2), IOURingRestriction.__union(IOURingRestriction.__member(1), IOURingRestriction.__member(1), IOURingRestriction.__member(1)), IOURingRestriction.__member(1), IOURingRestriction.__array(4, 3));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OPCODE = layout.offsetof(0);
        REGISTER_OP = layout.offsetof(2);
        SQE_OP = layout.offsetof(3);
        SQE_FLAGS = layout.offsetof(4);
        RESV = layout.offsetof(5);
        RESV2 = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<IOURingRestriction, Buffer>
    implements NativeResource {
        private static final IOURingRestriction ELEMENT_FACTORY = IOURingRestriction.create(-1L);

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
        protected IOURingRestriction getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u16")
        public short opcode() {
            return IOURingRestriction.nopcode(this.address());
        }

        @NativeType(value="__u8")
        public byte register_op() {
            return IOURingRestriction.nregister_op(this.address());
        }

        @NativeType(value="__u8")
        public byte sqe_op() {
            return IOURingRestriction.nsqe_op(this.address());
        }

        @NativeType(value="__u8")
        public byte sqe_flags() {
            return IOURingRestriction.nsqe_flags(this.address());
        }

        public Buffer opcode(@NativeType(value="__u16") short s) {
            IOURingRestriction.nopcode(this.address(), s);
            return this;
        }

        public Buffer register_op(@NativeType(value="__u8") byte by) {
            IOURingRestriction.nregister_op(this.address(), by);
            return this;
        }

        public Buffer sqe_op(@NativeType(value="__u8") byte by) {
            IOURingRestriction.nsqe_op(this.address(), by);
            return this;
        }

        public Buffer sqe_flags(@NativeType(value="__u8") byte by) {
            IOURingRestriction.nsqe_flags(this.address(), by);
            return this;
        }
    }
}

