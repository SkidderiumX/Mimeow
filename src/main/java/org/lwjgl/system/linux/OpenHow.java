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

@NativeType(value="struct open_how")
public class OpenHow
extends Struct<OpenHow>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int FLAGS;
    public static final int MODE;
    public static final int RESOLVE;

    protected OpenHow(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected OpenHow create(long l, @Nullable ByteBuffer byteBuffer) {
        return new OpenHow(l, byteBuffer);
    }

    public OpenHow(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), OpenHow.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long flags() {
        return OpenHow.nflags(this.address());
    }

    @NativeType(value="__u64")
    public long mode() {
        return OpenHow.nmode(this.address());
    }

    @NativeType(value="__u64")
    public long resolve() {
        return OpenHow.nresolve(this.address());
    }

    public OpenHow flags(@NativeType(value="__u64") long l) {
        OpenHow.nflags(this.address(), l);
        return this;
    }

    public OpenHow mode(@NativeType(value="__u64") long l) {
        OpenHow.nmode(this.address(), l);
        return this;
    }

    public OpenHow resolve(@NativeType(value="__u64") long l) {
        OpenHow.nresolve(this.address(), l);
        return this;
    }

    public OpenHow set(long l, long l2, long l3) {
        this.flags(l);
        this.mode(l2);
        this.resolve(l3);
        return this;
    }

    public OpenHow set(OpenHow openHow) {
        MemoryUtil.memCopy(openHow.address(), this.address(), SIZEOF);
        return this;
    }

    public static OpenHow malloc() {
        return new OpenHow(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static OpenHow calloc() {
        return new OpenHow(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static OpenHow create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new OpenHow(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static OpenHow create(long l) {
        return new OpenHow(l, null);
    }

    public static @Nullable OpenHow createSafe(long l) {
        return l == 0L ? null : new OpenHow(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(OpenHow.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = OpenHow.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static OpenHow malloc(MemoryStack memoryStack) {
        return new OpenHow(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static OpenHow calloc(MemoryStack memoryStack) {
        return new OpenHow(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nflags(long l) {
        return MemoryUtil.memGetLong(l + (long)FLAGS);
    }

    public static long nmode(long l) {
        return MemoryUtil.memGetLong(l + (long)MODE);
    }

    public static long nresolve(long l) {
        return MemoryUtil.memGetLong(l + (long)RESOLVE);
    }

    public static void nflags(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)FLAGS, l2);
    }

    public static void nmode(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)MODE, l2);
    }

    public static void nresolve(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)RESOLVE, l2);
    }

    static {
        Struct.Layout layout = OpenHow.__struct(OpenHow.__member(8), OpenHow.__member(8), OpenHow.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        FLAGS = layout.offsetof(0);
        MODE = layout.offsetof(1);
        RESOLVE = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<OpenHow, Buffer>
    implements NativeResource {
        private static final OpenHow ELEMENT_FACTORY = OpenHow.create(-1L);

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
        protected OpenHow getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long flags() {
            return OpenHow.nflags(this.address());
        }

        @NativeType(value="__u64")
        public long mode() {
            return OpenHow.nmode(this.address());
        }

        @NativeType(value="__u64")
        public long resolve() {
            return OpenHow.nresolve(this.address());
        }

        public Buffer flags(@NativeType(value="__u64") long l) {
            OpenHow.nflags(this.address(), l);
            return this;
        }

        public Buffer mode(@NativeType(value="__u64") long l) {
            OpenHow.nmode(this.address(), l);
            return this;
        }

        public Buffer resolve(@NativeType(value="__u64") long l) {
            OpenHow.nresolve(this.address(), l);
            return this;
        }
    }
}

