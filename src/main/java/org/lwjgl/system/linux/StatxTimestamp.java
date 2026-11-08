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

@NativeType(value="struct statx_timestamp")
public class StatxTimestamp
extends Struct<StatxTimestamp>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TV_SEC;
    public static final int TV_NSEC;
    public static final int __RESERVED;

    protected StatxTimestamp(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected StatxTimestamp create(long l, @Nullable ByteBuffer byteBuffer) {
        return new StatxTimestamp(l, byteBuffer);
    }

    public StatxTimestamp(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), StatxTimestamp.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__s64")
    public long tv_sec() {
        return StatxTimestamp.ntv_sec(this.address());
    }

    @NativeType(value="__u32")
    public int tv_nsec() {
        return StatxTimestamp.ntv_nsec(this.address());
    }

    public StatxTimestamp tv_sec(@NativeType(value="__s64") long l) {
        StatxTimestamp.ntv_sec(this.address(), l);
        return this;
    }

    public StatxTimestamp tv_nsec(@NativeType(value="__u32") int n) {
        StatxTimestamp.ntv_nsec(this.address(), n);
        return this;
    }

    public StatxTimestamp set(long l, int n) {
        this.tv_sec(l);
        this.tv_nsec(n);
        return this;
    }

    public StatxTimestamp set(StatxTimestamp statxTimestamp) {
        MemoryUtil.memCopy(statxTimestamp.address(), this.address(), SIZEOF);
        return this;
    }

    public static StatxTimestamp malloc() {
        return new StatxTimestamp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static StatxTimestamp calloc() {
        return new StatxTimestamp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static StatxTimestamp create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new StatxTimestamp(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static StatxTimestamp create(long l) {
        return new StatxTimestamp(l, null);
    }

    public static @Nullable StatxTimestamp createSafe(long l) {
        return l == 0L ? null : new StatxTimestamp(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(StatxTimestamp.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = StatxTimestamp.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static StatxTimestamp malloc(MemoryStack memoryStack) {
        return new StatxTimestamp(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static StatxTimestamp calloc(MemoryStack memoryStack) {
        return new StatxTimestamp(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int ntv_nsec(long l) {
        return MemoryUtil.memGetInt(l + (long)TV_NSEC);
    }

    public static int n__reserved(long l) {
        return MemoryUtil.memGetInt(l + (long)__RESERVED);
    }

    public static void ntv_sec(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)TV_SEC, l2);
    }

    public static void ntv_nsec(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TV_NSEC, n);
    }

    public static void n__reserved(long l, int n) {
        MemoryUtil.memPutInt(l + (long)__RESERVED, n);
    }

    static {
        Struct.Layout layout = StatxTimestamp.__struct(StatxTimestamp.__member(8), StatxTimestamp.__member(4), StatxTimestamp.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TV_SEC = layout.offsetof(0);
        TV_NSEC = layout.offsetof(1);
        __RESERVED = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<StatxTimestamp, Buffer>
    implements NativeResource {
        private static final StatxTimestamp ELEMENT_FACTORY = StatxTimestamp.create(-1L);

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
        protected StatxTimestamp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__s64")
        public long tv_sec() {
            return StatxTimestamp.ntv_sec(this.address());
        }

        @NativeType(value="__u32")
        public int tv_nsec() {
            return StatxTimestamp.ntv_nsec(this.address());
        }

        public Buffer tv_sec(@NativeType(value="__s64") long l) {
            StatxTimestamp.ntv_sec(this.address(), l);
            return this;
        }

        public Buffer tv_nsec(@NativeType(value="__u32") int n) {
            StatxTimestamp.ntv_nsec(this.address(), n);
            return this;
        }
    }
}

