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

@NativeType(value="struct io_uring_clock_register")
public class IOURingClockRegister
extends Struct<IOURingClockRegister>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CLOCKID;
    public static final int __RESV;

    protected IOURingClockRegister(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingClockRegister create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingClockRegister(l, byteBuffer);
    }

    public IOURingClockRegister(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingClockRegister.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int clockid() {
        return IOURingClockRegister.nclockid(this.address());
    }

    public IOURingClockRegister clockid(@NativeType(value="__u32") int n) {
        IOURingClockRegister.nclockid(this.address(), n);
        return this;
    }

    public IOURingClockRegister set(IOURingClockRegister iOURingClockRegister) {
        MemoryUtil.memCopy(iOURingClockRegister.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingClockRegister malloc() {
        return new IOURingClockRegister(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingClockRegister calloc() {
        return new IOURingClockRegister(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingClockRegister create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingClockRegister(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingClockRegister create(long l) {
        return new IOURingClockRegister(l, null);
    }

    public static @Nullable IOURingClockRegister createSafe(long l) {
        return l == 0L ? null : new IOURingClockRegister(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingClockRegister.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingClockRegister.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingClockRegister malloc(MemoryStack memoryStack) {
        return new IOURingClockRegister(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingClockRegister calloc(MemoryStack memoryStack) {
        return new IOURingClockRegister(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nclockid(long l) {
        return MemoryUtil.memGetInt(l + (long)CLOCKID);
    }

    public static IntBuffer n__resv(long l) {
        return MemoryUtil.memIntBuffer(l + (long)__RESV, 3);
    }

    public static int n__resv(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)__RESV + Checks.check(n, 3) * 4L);
    }

    public static void nclockid(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CLOCKID, n);
    }

    public static void n__resv(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)__RESV, intBuffer.remaining() * 4);
    }

    public static void n__resv(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)__RESV + Checks.check(n, 3) * 4L, n2);
    }

    static {
        Struct.Layout layout = IOURingClockRegister.__struct(IOURingClockRegister.__member(4), IOURingClockRegister.__array(4, 3));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CLOCKID = layout.offsetof(0);
        __RESV = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<IOURingClockRegister, Buffer>
    implements NativeResource {
        private static final IOURingClockRegister ELEMENT_FACTORY = IOURingClockRegister.create(-1L);

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
        protected IOURingClockRegister getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int clockid() {
            return IOURingClockRegister.nclockid(this.address());
        }

        public Buffer clockid(@NativeType(value="__u32") int n) {
            IOURingClockRegister.nclockid(this.address(), n);
            return this;
        }
    }
}

