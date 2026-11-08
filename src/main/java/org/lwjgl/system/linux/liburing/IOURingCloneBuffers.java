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

@NativeType(value="struct io_uring_clone_buffers")
public class IOURingCloneBuffers
extends Struct<IOURingCloneBuffers>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SRC_FD;
    public static final int FLAGS;
    public static final int PAD;

    protected IOURingCloneBuffers(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingCloneBuffers create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingCloneBuffers(l, byteBuffer);
    }

    public IOURingCloneBuffers(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingCloneBuffers.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int src_fd() {
        return IOURingCloneBuffers.nsrc_fd(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingCloneBuffers.nflags(this.address());
    }

    public IOURingCloneBuffers src_fd(@NativeType(value="__u32") int n) {
        IOURingCloneBuffers.nsrc_fd(this.address(), n);
        return this;
    }

    public IOURingCloneBuffers flags(@NativeType(value="__u32") int n) {
        IOURingCloneBuffers.nflags(this.address(), n);
        return this;
    }

    public IOURingCloneBuffers set(int n, int n2) {
        this.src_fd(n);
        this.flags(n2);
        return this;
    }

    public IOURingCloneBuffers set(IOURingCloneBuffers iOURingCloneBuffers) {
        MemoryUtil.memCopy(iOURingCloneBuffers.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingCloneBuffers malloc() {
        return new IOURingCloneBuffers(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingCloneBuffers calloc() {
        return new IOURingCloneBuffers(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingCloneBuffers create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingCloneBuffers(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingCloneBuffers create(long l) {
        return new IOURingCloneBuffers(l, null);
    }

    public static @Nullable IOURingCloneBuffers createSafe(long l) {
        return l == 0L ? null : new IOURingCloneBuffers(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingCloneBuffers.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingCloneBuffers.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingCloneBuffers malloc(MemoryStack memoryStack) {
        return new IOURingCloneBuffers(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingCloneBuffers calloc(MemoryStack memoryStack) {
        return new IOURingCloneBuffers(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nsrc_fd(long l) {
        return MemoryUtil.memGetInt(l + (long)SRC_FD);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static IntBuffer npad(long l) {
        return MemoryUtil.memIntBuffer(l + (long)PAD, 6);
    }

    public static int npad(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)PAD + Checks.check(n, 6) * 4L);
    }

    public static void nsrc_fd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SRC_FD, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void npad(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 6);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)PAD, intBuffer.remaining() * 4);
    }

    public static void npad(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)PAD + Checks.check(n, 6) * 4L, n2);
    }

    static {
        Struct.Layout layout = IOURingCloneBuffers.__struct(IOURingCloneBuffers.__member(4), IOURingCloneBuffers.__member(4), IOURingCloneBuffers.__array(4, 6));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SRC_FD = layout.offsetof(0);
        FLAGS = layout.offsetof(1);
        PAD = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<IOURingCloneBuffers, Buffer>
    implements NativeResource {
        private static final IOURingCloneBuffers ELEMENT_FACTORY = IOURingCloneBuffers.create(-1L);

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
        protected IOURingCloneBuffers getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int src_fd() {
            return IOURingCloneBuffers.nsrc_fd(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingCloneBuffers.nflags(this.address());
        }

        public Buffer src_fd(@NativeType(value="__u32") int n) {
            IOURingCloneBuffers.nsrc_fd(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int n) {
            IOURingCloneBuffers.nflags(this.address(), n);
            return this;
        }
    }
}

