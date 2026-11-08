/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.NSVGPaint;
import org.lwjgl.nanovg.NSVGPath;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGshape")
public class NSVGShape
extends Struct<NSVGShape> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ID;
    public static final int FILL;
    public static final int STROKE;
    public static final int OPACITY;
    public static final int STROKEWIDTH;
    public static final int STROKEDASHOFFSET;
    public static final int STROKEDASHARRAY;
    public static final int STROKEDASHCOUNT;
    public static final int STROKELINEJOIN;
    public static final int STROKELINECAP;
    public static final int MITERLIMIT;
    public static final int FILLRULE;
    public static final int FLAGS;
    public static final int BOUNDS;
    public static final int FILLGRADIENT;
    public static final int STROKEGRADIENT;
    public static final int XFORM;
    public static final int PATHS;
    public static final int NEXT;

    protected NSVGShape(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NSVGShape create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NSVGShape(l, byteBuffer);
    }

    public NSVGShape(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NSVGShape.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char[64]")
    public ByteBuffer id() {
        return NSVGShape.nid(this.address());
    }

    @NativeType(value="char[64]")
    public String idString() {
        return NSVGShape.nidString(this.address());
    }

    @NativeType(value="NSVGpaint")
    public NSVGPaint fill() {
        return NSVGShape.nfill(this.address());
    }

    @NativeType(value="NSVGpaint")
    public NSVGPaint stroke() {
        return NSVGShape.nstroke(this.address());
    }

    public float opacity() {
        return NSVGShape.nopacity(this.address());
    }

    public float strokeWidth() {
        return NSVGShape.nstrokeWidth(this.address());
    }

    public float strokeDashOffset() {
        return NSVGShape.nstrokeDashOffset(this.address());
    }

    @NativeType(value="float[8]")
    public FloatBuffer strokeDashArray() {
        return NSVGShape.nstrokeDashArray(this.address());
    }

    public float strokeDashArray(int n) {
        return NSVGShape.nstrokeDashArray(this.address(), n);
    }

    @NativeType(value="char")
    public byte strokeDashCount() {
        return NSVGShape.nstrokeDashCount(this.address());
    }

    @NativeType(value="char")
    public byte strokeLineJoin() {
        return NSVGShape.nstrokeLineJoin(this.address());
    }

    @NativeType(value="char")
    public byte strokeLineCap() {
        return NSVGShape.nstrokeLineCap(this.address());
    }

    public float miterLimit() {
        return NSVGShape.nmiterLimit(this.address());
    }

    @NativeType(value="char")
    public byte fillRule() {
        return NSVGShape.nfillRule(this.address());
    }

    @NativeType(value="unsigned char")
    public byte flags() {
        return NSVGShape.nflags(this.address());
    }

    @NativeType(value="float[4]")
    public FloatBuffer bounds() {
        return NSVGShape.nbounds(this.address());
    }

    public float bounds(int n) {
        return NSVGShape.nbounds(this.address(), n);
    }

    @NativeType(value="char[64]")
    public ByteBuffer fillGradient() {
        return NSVGShape.nfillGradient(this.address());
    }

    @NativeType(value="char[64]")
    public String fillGradientString() {
        return NSVGShape.nfillGradientString(this.address());
    }

    @NativeType(value="char[64]")
    public ByteBuffer strokeGradient() {
        return NSVGShape.nstrokeGradient(this.address());
    }

    @NativeType(value="char[64]")
    public String strokeGradientString() {
        return NSVGShape.nstrokeGradientString(this.address());
    }

    @NativeType(value="float[6]")
    public FloatBuffer xform() {
        return NSVGShape.nxform(this.address());
    }

    public float xform(int n) {
        return NSVGShape.nxform(this.address(), n);
    }

    @NativeType(value="NSVGpath *")
    public NSVGPath paths() {
        return NSVGShape.npaths(this.address());
    }

    @NativeType(value="NSVGshape *")
    public NSVGShape next() {
        return NSVGShape.nnext(this.address());
    }

    public static NSVGShape create(long l) {
        return new NSVGShape(l, null);
    }

    public static @Nullable NSVGShape createSafe(long l) {
        return l == 0L ? null : new NSVGShape(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static ByteBuffer nid(long l) {
        return MemoryUtil.memByteBuffer(l + (long)ID, 64);
    }

    public static String nidString(long l) {
        return MemoryUtil.memASCII(l + (long)ID);
    }

    public static NSVGPaint nfill(long l) {
        return NSVGPaint.create(l + (long)FILL);
    }

    public static NSVGPaint nstroke(long l) {
        return NSVGPaint.create(l + (long)STROKE);
    }

    public static float nopacity(long l) {
        return MemoryUtil.memGetFloat(l + (long)OPACITY);
    }

    public static float nstrokeWidth(long l) {
        return MemoryUtil.memGetFloat(l + (long)STROKEWIDTH);
    }

    public static float nstrokeDashOffset(long l) {
        return MemoryUtil.memGetFloat(l + (long)STROKEDASHOFFSET);
    }

    public static FloatBuffer nstrokeDashArray(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)STROKEDASHARRAY, 8);
    }

    public static float nstrokeDashArray(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)STROKEDASHARRAY + Checks.check(n, 8) * 4L);
    }

    public static byte nstrokeDashCount(long l) {
        return MemoryUtil.memGetByte(l + (long)STROKEDASHCOUNT);
    }

    public static byte nstrokeLineJoin(long l) {
        return MemoryUtil.memGetByte(l + (long)STROKELINEJOIN);
    }

    public static byte nstrokeLineCap(long l) {
        return MemoryUtil.memGetByte(l + (long)STROKELINECAP);
    }

    public static float nmiterLimit(long l) {
        return MemoryUtil.memGetFloat(l + (long)MITERLIMIT);
    }

    public static byte nfillRule(long l) {
        return MemoryUtil.memGetByte(l + (long)FILLRULE);
    }

    public static byte nflags(long l) {
        return MemoryUtil.memGetByte(l + (long)FLAGS);
    }

    public static FloatBuffer nbounds(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)BOUNDS, 4);
    }

    public static float nbounds(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)BOUNDS + Checks.check(n, 4) * 4L);
    }

    public static ByteBuffer nfillGradient(long l) {
        return MemoryUtil.memByteBuffer(l + (long)FILLGRADIENT, 64);
    }

    public static String nfillGradientString(long l) {
        return MemoryUtil.memASCII(l + (long)FILLGRADIENT);
    }

    public static ByteBuffer nstrokeGradient(long l) {
        return MemoryUtil.memByteBuffer(l + (long)STROKEGRADIENT, 64);
    }

    public static String nstrokeGradientString(long l) {
        return MemoryUtil.memASCII(l + (long)STROKEGRADIENT);
    }

    public static FloatBuffer nxform(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)XFORM, 6);
    }

    public static float nxform(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)XFORM + Checks.check(n, 6) * 4L);
    }

    public static NSVGPath npaths(long l) {
        return NSVGPath.create(MemoryUtil.memGetAddress(l + (long)PATHS));
    }

    public static NSVGShape nnext(long l) {
        return NSVGShape.create(MemoryUtil.memGetAddress(l + (long)NEXT));
    }

    static {
        Struct.Layout layout = NSVGShape.__struct(NSVGShape.__array(1, 64), NSVGShape.__member(NSVGPaint.SIZEOF, NSVGPaint.ALIGNOF), NSVGShape.__member(NSVGPaint.SIZEOF, NSVGPaint.ALIGNOF), NSVGShape.__member(4), NSVGShape.__member(4), NSVGShape.__member(4), NSVGShape.__array(4, 8), NSVGShape.__member(1), NSVGShape.__member(1), NSVGShape.__member(1), NSVGShape.__member(4), NSVGShape.__member(1), NSVGShape.__member(1), NSVGShape.__array(4, 4), NSVGShape.__array(1, 64), NSVGShape.__array(1, 64), NSVGShape.__array(4, 6), NSVGShape.__member(POINTER_SIZE), NSVGShape.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ID = layout.offsetof(0);
        FILL = layout.offsetof(1);
        STROKE = layout.offsetof(2);
        OPACITY = layout.offsetof(3);
        STROKEWIDTH = layout.offsetof(4);
        STROKEDASHOFFSET = layout.offsetof(5);
        STROKEDASHARRAY = layout.offsetof(6);
        STROKEDASHCOUNT = layout.offsetof(7);
        STROKELINEJOIN = layout.offsetof(8);
        STROKELINECAP = layout.offsetof(9);
        MITERLIMIT = layout.offsetof(10);
        FILLRULE = layout.offsetof(11);
        FLAGS = layout.offsetof(12);
        BOUNDS = layout.offsetof(13);
        FILLGRADIENT = layout.offsetof(14);
        STROKEGRADIENT = layout.offsetof(15);
        XFORM = layout.offsetof(16);
        PATHS = layout.offsetof(17);
        NEXT = layout.offsetof(18);
    }

    public static class Buffer
    extends StructBuffer<NSVGShape, Buffer> {
        private static final NSVGShape ELEMENT_FACTORY = NSVGShape.create(-1L);

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
        protected NSVGShape getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char[64]")
        public ByteBuffer id() {
            return NSVGShape.nid(this.address());
        }

        @NativeType(value="char[64]")
        public String idString() {
            return NSVGShape.nidString(this.address());
        }

        @NativeType(value="NSVGpaint")
        public NSVGPaint fill() {
            return NSVGShape.nfill(this.address());
        }

        @NativeType(value="NSVGpaint")
        public NSVGPaint stroke() {
            return NSVGShape.nstroke(this.address());
        }

        public float opacity() {
            return NSVGShape.nopacity(this.address());
        }

        public float strokeWidth() {
            return NSVGShape.nstrokeWidth(this.address());
        }

        public float strokeDashOffset() {
            return NSVGShape.nstrokeDashOffset(this.address());
        }

        @NativeType(value="float[8]")
        public FloatBuffer strokeDashArray() {
            return NSVGShape.nstrokeDashArray(this.address());
        }

        public float strokeDashArray(int n) {
            return NSVGShape.nstrokeDashArray(this.address(), n);
        }

        @NativeType(value="char")
        public byte strokeDashCount() {
            return NSVGShape.nstrokeDashCount(this.address());
        }

        @NativeType(value="char")
        public byte strokeLineJoin() {
            return NSVGShape.nstrokeLineJoin(this.address());
        }

        @NativeType(value="char")
        public byte strokeLineCap() {
            return NSVGShape.nstrokeLineCap(this.address());
        }

        public float miterLimit() {
            return NSVGShape.nmiterLimit(this.address());
        }

        @NativeType(value="char")
        public byte fillRule() {
            return NSVGShape.nfillRule(this.address());
        }

        @NativeType(value="unsigned char")
        public byte flags() {
            return NSVGShape.nflags(this.address());
        }

        @NativeType(value="float[4]")
        public FloatBuffer bounds() {
            return NSVGShape.nbounds(this.address());
        }

        public float bounds(int n) {
            return NSVGShape.nbounds(this.address(), n);
        }

        @NativeType(value="char[64]")
        public ByteBuffer fillGradient() {
            return NSVGShape.nfillGradient(this.address());
        }

        @NativeType(value="char[64]")
        public String fillGradientString() {
            return NSVGShape.nfillGradientString(this.address());
        }

        @NativeType(value="char[64]")
        public ByteBuffer strokeGradient() {
            return NSVGShape.nstrokeGradient(this.address());
        }

        @NativeType(value="char[64]")
        public String strokeGradientString() {
            return NSVGShape.nstrokeGradientString(this.address());
        }

        @NativeType(value="float[6]")
        public FloatBuffer xform() {
            return NSVGShape.nxform(this.address());
        }

        public float xform(int n) {
            return NSVGShape.nxform(this.address(), n);
        }

        @NativeType(value="NSVGpath *")
        public NSVGPath paths() {
            return NSVGShape.npaths(this.address());
        }

        @NativeType(value="NSVGshape *")
        public NSVGShape next() {
            return NSVGShape.nnext(this.address());
        }
    }
}

