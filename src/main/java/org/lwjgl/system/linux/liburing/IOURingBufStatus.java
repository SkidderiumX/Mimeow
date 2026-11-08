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

@NativeType(value="struct io_uring_buf_status")
public class IOURingBufStatus
extends Struct<IOURingBufStatus>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BUF_GROUP;
    public static final int HEAD;
    public static final int RESV;

    protected IOURingBufStatus(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingBufStatus create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingBufStatus(l, byteBuffer);
    }

    public IOURingBufStatus(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingBufStatus.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int buf_group() {
        return IOURingBufStatus.nbuf_group(this.address());
    }

    @NativeType(value="__u32")
    public int head() {
        return IOURingBufStatus.nhead(this.address());
    }

    public IOURingBufStatus buf_group(@NativeType(value="__u32") int n) {
        IOURingBufStatus.nbuf_group(this.address(), n);
        return this;
    }

    public IOURingBufStatus head(@NativeType(value="__u32") int n) {
        IOURingBufStatus.nhead(this.address(), n);
        return this;
    }

    public IOURingBufStatus set(int n, int n2) {
        this.buf_group(n);
        this.head(n2);
        return this;
    }

    public IOURingBufStatus set(IOURingBufStatus iOURingBufStatus) {
        MemoryUtil.memCopy(iOURingBufStatus.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingBufStatus malloc() {
        return new IOURingBufStatus(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingBufStatus calloc() {
        return new IOURingBufStatus(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingBufStatus create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingBufStatus(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingBufStatus create(long l) {
        return new IOURingBufStatus(l, null);
    }

    public static @Nullable IOURingBufStatus createSafe(long l) {
        return l == 0L ? null : new IOURingBufStatus(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingBufStatus.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingBufStatus.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingBufStatus malloc(MemoryStack memoryStack) {
        return new IOURingBufStatus(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingBufStatus calloc(MemoryStack memoryStack) {
        return new IOURingBufStatus(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nbuf_group(long l) {
        return MemoryUtil.memGetInt(l + (long)BUF_GROUP);
    }

    public static int nhead(long l) {
        return MemoryUtil.memGetInt(l + (long)HEAD);
    }

    public static IntBuffer nresv(long l) {
        return MemoryUtil.memIntBuffer(l + (long)RESV, 8);
    }

    public static int nresv(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)RESV + Checks.check(n, 8) * 4L);
    }

    public static void nbuf_group(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BUF_GROUP, n);
    }

    public static void nhead(long l, int n) {
        MemoryUtil.memPutInt(l + (long)HEAD, n);
    }

    public static void nresv(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 8);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)RESV, intBuffer.remaining() * 4);
    }

    public static void nresv(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)RESV + Checks.check(n, 8) * 4L, n2);
    }

    static {
        Struct.Layout layout = IOURingBufStatus.__struct(IOURingBufStatus.__member(4), IOURingBufStatus.__member(4), IOURingBufStatus.__array(4, 8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BUF_GROUP = layout.offsetof(0);
        HEAD = layout.offsetof(1);
        RESV = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<IOURingBufStatus, Buffer>
    implements NativeResource {
        private static final IOURingBufStatus ELEMENT_FACTORY = IOURingBufStatus.create(-1L);

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
        protected IOURingBufStatus getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int buf_group() {
            return IOURingBufStatus.nbuf_group(this.address());
        }

        @NativeType(value="__u32")
        public int head() {
            return IOURingBufStatus.nhead(this.address());
        }

        public Buffer buf_group(@NativeType(value="__u32") int n) {
            IOURingBufStatus.nbuf_group(this.address(), n);
            return this;
        }

        public Buffer head(@NativeType(value="__u32") int n) {
            IOURingBufStatus.nhead(this.address(), n);
            return this;
        }
    }
}

