/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGpath")
public class NSVGPath
extends Struct<NSVGPath> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int PTS;
    public static final int NPTS;
    public static final int CLOSED;
    public static final int BOUNDS;
    public static final int NEXT;

    protected NSVGPath(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NSVGPath create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NSVGPath(l, byteBuffer);
    }

    public NSVGPath(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NSVGPath.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float *")
    public FloatBuffer pts() {
        return NSVGPath.npts(this.address());
    }

    public int npts() {
        return NSVGPath.nnpts(this.address());
    }

    @NativeType(value="char")
    public byte closed() {
        return NSVGPath.nclosed(this.address());
    }

    @NativeType(value="float[4]")
    public FloatBuffer bounds() {
        return NSVGPath.nbounds(this.address());
    }

    public float bounds(int n) {
        return NSVGPath.nbounds(this.address(), n);
    }

    @NativeType(value="NSVGpath *")
    public NSVGPath next() {
        return NSVGPath.nnext(this.address());
    }

    public static NSVGPath create(long l) {
        return new NSVGPath(l, null);
    }

    public static @Nullable NSVGPath createSafe(long l) {
        return l == 0L ? null : new NSVGPath(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static FloatBuffer npts(long l) {
        return MemoryUtil.memFloatBuffer(MemoryUtil.memGetAddress(l + (long)PTS), NSVGPath.nnpts(l) << 1);
    }

    public static int nnpts(long l) {
        return MemoryUtil.memGetInt(l + (long)NPTS);
    }

    public static byte nclosed(long l) {
        return MemoryUtil.memGetByte(l + (long)CLOSED);
    }

    public static FloatBuffer nbounds(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)BOUNDS, 4);
    }

    public static float nbounds(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)BOUNDS + Checks.check(n, 4) * 4L);
    }

    public static NSVGPath nnext(long l) {
        return NSVGPath.create(MemoryUtil.memGetAddress(l + (long)NEXT));
    }

    static {
        Struct.Layout layout = NSVGPath.__struct(NSVGPath.__member(POINTER_SIZE), NSVGPath.__member(4), NSVGPath.__member(1), NSVGPath.__array(4, 4), NSVGPath.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        PTS = layout.offsetof(0);
        NPTS = layout.offsetof(1);
        CLOSED = layout.offsetof(2);
        BOUNDS = layout.offsetof(3);
        NEXT = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<NSVGPath, Buffer> {
        private static final NSVGPath ELEMENT_FACTORY = NSVGPath.create(-1L);

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
        protected NSVGPath getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float *")
        public FloatBuffer pts() {
            return NSVGPath.npts(this.address());
        }

        public int npts() {
            return NSVGPath.nnpts(this.address());
        }

        @NativeType(value="char")
        public byte closed() {
            return NSVGPath.nclosed(this.address());
        }

        @NativeType(value="float[4]")
        public FloatBuffer bounds() {
            return NSVGPath.nbounds(this.address());
        }

        public float bounds(int n) {
            return NSVGPath.nbounds(this.address(), n);
        }

        @NativeType(value="NSVGpath *")
        public NSVGPath next() {
            return NSVGPath.nnext(this.address());
        }
    }
}

