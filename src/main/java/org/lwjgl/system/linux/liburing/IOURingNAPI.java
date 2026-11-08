/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_napi")
public class IOURingNAPI
extends Struct<IOURingNAPI>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BUSY_POLL_TO;
    public static final int PREFER_BUSY_POLL;
    public static final int PAD;
    public static final int RESV;

    protected IOURingNAPI(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingNAPI create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingNAPI(l, byteBuffer);
    }

    public IOURingNAPI(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingNAPI.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int busy_poll_to() {
        return IOURingNAPI.nbusy_poll_to(this.address());
    }

    @NativeType(value="__u8")
    public byte prefer_busy_poll() {
        return IOURingNAPI.nprefer_busy_poll(this.address());
    }

    public IOURingNAPI busy_poll_to(@NativeType(value="__u32") int n) {
        IOURingNAPI.nbusy_poll_to(this.address(), n);
        return this;
    }

    public IOURingNAPI prefer_busy_poll(@NativeType(value="__u8") byte by) {
        IOURingNAPI.nprefer_busy_poll(this.address(), by);
        return this;
    }

    public IOURingNAPI set(int n, byte by) {
        this.busy_poll_to(n);
        this.prefer_busy_poll(by);
        return this;
    }

    public IOURingNAPI set(IOURingNAPI iOURingNAPI) {
        MemoryUtil.memCopy(iOURingNAPI.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingNAPI malloc() {
        return new IOURingNAPI(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingNAPI calloc() {
        return new IOURingNAPI(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingNAPI create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingNAPI(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingNAPI create(long l) {
        return new IOURingNAPI(l, null);
    }

    public static @Nullable IOURingNAPI createSafe(long l) {
        return l == 0L ? null : new IOURingNAPI(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingNAPI.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingNAPI.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingNAPI malloc(MemoryStack memoryStack) {
        return new IOURingNAPI(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingNAPI calloc(MemoryStack memoryStack) {
        return new IOURingNAPI(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nbusy_poll_to(long l) {
        return MemoryUtil.memGetInt(l + (long)BUSY_POLL_TO);
    }

    public static byte nprefer_busy_poll(long l) {
        return MemoryUtil.memGetByte(l + (long)PREFER_BUSY_POLL);
    }

    public static ByteBuffer npad(long l) {
        return MemoryUtil.memByteBuffer(l + (long)PAD, 3);
    }

    public static byte npad(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)PAD + Checks.check(n, 3) * 1L);
    }

    public static long nresv(long l) {
        return MemoryUtil.memGetLong(l + (long)RESV);
    }

    public static void nbusy_poll_to(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BUSY_POLL_TO, n);
    }

    public static void nprefer_busy_poll(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)PREFER_BUSY_POLL, by);
    }

    public static void npad(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)PAD, byteBuffer.remaining() * 1);
    }

    public static void npad(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)PAD + Checks.check(n, 3) * 1L, by);
    }

    public static void nresv(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)RESV, l2);
    }

    static {
        Struct.Layout layout = IOURingNAPI.__struct(IOURingNAPI.__member(4), IOURingNAPI.__member(1), IOURingNAPI.__array(1, 3), IOURingNAPI.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BUSY_POLL_TO = layout.offsetof(0);
        PREFER_BUSY_POLL = layout.offsetof(1);
        PAD = layout.offsetof(2);
        RESV = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingNAPI, Buffer>
    implements NativeResource {
        private static final IOURingNAPI ELEMENT_FACTORY = IOURingNAPI.create(-1L);

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
        protected IOURingNAPI getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int busy_poll_to() {
            return IOURingNAPI.nbusy_poll_to(this.address());
        }

        @NativeType(value="__u8")
        public byte prefer_busy_poll() {
            return IOURingNAPI.nprefer_busy_poll(this.address());
        }

        public Buffer busy_poll_to(@NativeType(value="__u32") int n) {
            IOURingNAPI.nbusy_poll_to(this.address(), n);
            return this;
        }

        public Buffer prefer_busy_poll(@NativeType(value="__u8") byte by) {
            IOURingNAPI.nprefer_busy_poll(this.address(), by);
            return this;
        }
    }
}

