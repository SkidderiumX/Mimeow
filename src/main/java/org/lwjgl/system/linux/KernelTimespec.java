/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct __kernel_timespec")
public class KernelTimespec
extends Struct<KernelTimespec>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TV_SEC;
    public static final int TV_NSEC;

    protected KernelTimespec(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected KernelTimespec create(long l, @Nullable ByteBuffer byteBuffer) {
        return new KernelTimespec(l, byteBuffer);
    }

    public KernelTimespec(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), KernelTimespec.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int64_t")
    public long tv_sec() {
        return KernelTimespec.ntv_sec(this.address());
    }

    @NativeType(value="long long")
    public long tv_nsec() {
        return KernelTimespec.ntv_nsec(this.address());
    }

    public KernelTimespec tv_sec(@NativeType(value="int64_t") long l) {
        KernelTimespec.ntv_sec(this.address(), l);
        return this;
    }

    public KernelTimespec tv_nsec(@NativeType(value="long long") long l) {
        KernelTimespec.ntv_nsec(this.address(), l);
        return this;
    }

    public KernelTimespec set(long l, long l2) {
        this.tv_sec(l);
        this.tv_nsec(l2);
        return this;
    }

    public KernelTimespec set(KernelTimespec kernelTimespec) {
        MemoryUtil.memCopy(kernelTimespec.address(), this.address(), SIZEOF);
        return this;
    }

    public static KernelTimespec malloc() {
        return new KernelTimespec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static KernelTimespec calloc() {
        return new KernelTimespec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static KernelTimespec create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new KernelTimespec(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static KernelTimespec create(long l) {
        return new KernelTimespec(l, null);
    }

    public static @Nullable KernelTimespec createSafe(long l) {
        return l == 0L ? null : new KernelTimespec(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(KernelTimespec.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = KernelTimespec.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static KernelTimespec malloc(MemoryStack memoryStack) {
        return new KernelTimespec(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static KernelTimespec calloc(MemoryStack memoryStack) {
        return new KernelTimespec(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long ntv_sec(long l) {
        return MemoryUtil.memGetLong(l + (long)TV_SEC);
    }

    public static long ntv_nsec(long l) {
        return MemoryUtil.memGetLong(l + (long)TV_NSEC);
    }

    public static void ntv_sec(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)TV_SEC, l2);
    }

    public static void ntv_nsec(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)TV_NSEC, l2);
    }

    static {
        Struct.Layout layout = KernelTimespec.__struct(KernelTimespec.__member(8), KernelTimespec.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TV_SEC = layout.offsetof(0);
        TV_NSEC = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<KernelTimespec, Buffer>
    implements NativeResource {
        private static final KernelTimespec ELEMENT_FACTORY = KernelTimespec.create(-1L);

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
        protected KernelTimespec getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int64_t")
        public long tv_sec() {
            return KernelTimespec.ntv_sec(this.address());
        }

        @NativeType(value="long long")
        public long tv_nsec() {
            return KernelTimespec.ntv_nsec(this.address());
        }

        public Buffer tv_sec(@NativeType(value="int64_t") long l) {
            KernelTimespec.ntv_sec(this.address(), l);
            return this;
        }

        public Buffer tv_nsec(@NativeType(value="long long") long l) {
            KernelTimespec.ntv_nsec(this.address(), l);
            return this;
        }
    }
}

