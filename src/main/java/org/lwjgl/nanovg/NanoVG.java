/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NVGGlyphPosition;
import org.lwjgl.nanovg.NVGPaint;
import org.lwjgl.nanovg.NVGTextRow;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NanoVG {
    public static final float NVG_PI = (float)Math.PI;
    public static final int NVG_CCW = 1;
    public static final int NVG_CW = 2;
    public static final int NVG_SOLID = 1;
    public static final int NVG_HOLE = 2;
    public static final int NVG_BUTT = 0;
    public static final int NVG_ROUND = 1;
    public static final int NVG_SQUARE = 2;
    public static final int NVG_BEVEL = 3;
    public static final int NVG_MITER = 4;
    public static final int NVG_ALIGN_LEFT = 1;
    public static final int NVG_ALIGN_CENTER = 2;
    public static final int NVG_ALIGN_RIGHT = 4;
    public static final int NVG_ALIGN_TOP = 8;
    public static final int NVG_ALIGN_MIDDLE = 16;
    public static final int NVG_ALIGN_BOTTOM = 32;
    public static final int NVG_ALIGN_BASELINE = 64;
    public static final int NVG_ZERO = 1;
    public static final int NVG_ONE = 2;
    public static final int NVG_SRC_COLOR = 4;
    public static final int NVG_ONE_MINUS_SRC_COLOR = 8;
    public static final int NVG_DST_COLOR = 16;
    public static final int NVG_ONE_MINUS_DST_COLOR = 32;
    public static final int NVG_SRC_ALPHA = 64;
    public static final int NVG_ONE_MINUS_SRC_ALPHA = 128;
    public static final int NVG_DST_ALPHA = 256;
    public static final int NVG_ONE_MINUS_DST_ALPHA = 512;
    public static final int NVG_SRC_ALPHA_SATURATE = 1024;
    public static final int NVG_SOURCE_OVER = 0;
    public static final int NVG_SOURCE_IN = 1;
    public static final int NVG_SOURCE_OUT = 2;
    public static final int NVG_ATOP = 3;
    public static final int NVG_DESTINATION_OVER = 4;
    public static final int NVG_DESTINATION_IN = 5;
    public static final int NVG_DESTINATION_OUT = 6;
    public static final int NVG_DESTINATION_ATOP = 7;
    public static final int NVG_LIGHTER = 8;
    public static final int NVG_COPY = 9;
    public static final int NVG_XOR = 10;
    public static final int NVG_IMAGE_GENERATE_MIPMAPS = 1;
    public static final int NVG_IMAGE_REPEATX = 2;
    public static final int NVG_IMAGE_REPEATY = 4;
    public static final int NVG_IMAGE_FLIPY = 8;
    public static final int NVG_IMAGE_PREMULTIPLIED = 16;
    public static final int NVG_IMAGE_NEAREST = 32;
    static final long nvgCreateInternal;
    static final long nvgInternalParams;
    static final long nvgDeleteInternal;

    protected NanoVG() {
        throw new UnsupportedOperationException();
    }

    public static native void nnvgBeginFrame(long var0, float var2, float var3, float var4);

    public static void nvgBeginFrame(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgBeginFrame(l, f, f2, f3);
    }

    public static native void nnvgCancelFrame(long var0);

    public static void nvgCancelFrame(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgCancelFrame(l);
    }

    public static native void nnvgEndFrame(long var0);

    public static void nvgEndFrame(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgEndFrame(l);
    }

    public static native void nnvgGlobalCompositeOperation(long var0, int var2);

    public static void nvgGlobalCompositeOperation(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgGlobalCompositeOperation(l, n);
    }

    public static native void nnvgGlobalCompositeBlendFunc(long var0, int var2, int var3);

    public static void nvgGlobalCompositeBlendFunc(@NativeType(value="NVGcontext *") long l, int n, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgGlobalCompositeBlendFunc(l, n, n2);
    }

    public static native void nnvgGlobalCompositeBlendFuncSeparate(long var0, int var2, int var3, int var4, int var5);

    public static void nvgGlobalCompositeBlendFuncSeparate(@NativeType(value="NVGcontext *") long l, int n, int n2, int n3, int n4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgGlobalCompositeBlendFuncSeparate(l, n, n2, n3, n4);
    }

    public static native void nnvgRGB(byte var0, byte var1, byte var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGB(@NativeType(value="unsigned char") byte by, @NativeType(value="unsigned char") byte by2, @NativeType(value="unsigned char") byte by3, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        NanoVG.nnvgRGB(by, by2, by3, nVGColor.address());
        return nVGColor;
    }

    public static native void nnvgRGBf(float var0, float var1, float var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGBf(float f, float f2, float f3, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        NanoVG.nnvgRGBf(f, f2, f3, nVGColor.address());
        return nVGColor;
    }

    public static native void nnvgRGBA(byte var0, byte var1, byte var2, byte var3, long var4);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGBA(@NativeType(value="unsigned char") byte by, @NativeType(value="unsigned char") byte by2, @NativeType(value="unsigned char") byte by3, @NativeType(value="unsigned char") byte by4, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        NanoVG.nnvgRGBA(by, by2, by3, by4, nVGColor.address());
        return nVGColor;
    }

    public static native void nnvgRGBAf(float var0, float var1, float var2, float var3, long var4);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGBAf(float f, float f2, float f3, float f4, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        NanoVG.nnvgRGBAf(f, f2, f3, f4, nVGColor.address());
        return nVGColor;
    }

    public static native void nnvgLerpRGBA(long var0, long var2, float var4, long var5);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgLerpRGBA(@NativeType(value="NVGcolor") NVGColor nVGColor, @NativeType(value="NVGcolor") NVGColor nVGColor2, float f, @NativeType(value="NVGcolor") NVGColor nVGColor3) {
        NanoVG.nnvgLerpRGBA(nVGColor.address(), nVGColor2.address(), f, nVGColor3.address());
        return nVGColor3;
    }

    public static native void nnvgTransRGBA(long var0, byte var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgTransRGBA(@NativeType(value="NVGcolor") NVGColor nVGColor, @NativeType(value="unsigned char") byte by, @NativeType(value="NVGcolor") NVGColor nVGColor2) {
        NanoVG.nnvgTransRGBA(nVGColor.address(), by, nVGColor2.address());
        return nVGColor2;
    }

    public static native void nnvgTransRGBAf(long var0, float var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgTransRGBAf(@NativeType(value="NVGcolor") NVGColor nVGColor, float f, @NativeType(value="NVGcolor") NVGColor nVGColor2) {
        NanoVG.nnvgTransRGBAf(nVGColor.address(), f, nVGColor2.address());
        return nVGColor2;
    }

    public static native void nnvgHSL(float var0, float var1, float var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgHSL(float f, float f2, float f3, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        NanoVG.nnvgHSL(f, f2, f3, nVGColor.address());
        return nVGColor;
    }

    public static native void nnvgHSLA(float var0, float var1, float var2, byte var3, long var4);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgHSLA(float f, float f2, float f3, @NativeType(value="unsigned char") byte by, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        NanoVG.nnvgHSLA(f, f2, f3, by, nVGColor.address());
        return nVGColor;
    }

    public static native void nnvgSave(long var0);

    public static void nvgSave(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgSave(l);
    }

    public static native void nnvgRestore(long var0);

    public static void nvgRestore(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgRestore(l);
    }

    public static native void nnvgReset(long var0);

    public static void nvgReset(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgReset(l);
    }

    public static native void nnvgShapeAntiAlias(long var0, int var2);

    public static void nvgShapeAntiAlias(@NativeType(value="NVGcontext *") long l, @NativeType(value="int") boolean bl) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgShapeAntiAlias(l, bl ? 1 : 0);
    }

    public static native void nnvgStrokeColor(long var0, long var2);

    public static void nvgStrokeColor(@NativeType(value="NVGcontext *") long l, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgStrokeColor(l, nVGColor.address());
    }

    public static native void nnvgStrokePaint(long var0, long var2);

    public static void nvgStrokePaint(@NativeType(value="NVGcontext *") long l, @NativeType(value="NVGpaint") NVGPaint nVGPaint) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgStrokePaint(l, nVGPaint.address());
    }

    public static native void nnvgFillColor(long var0, long var2);

    public static void nvgFillColor(@NativeType(value="NVGcontext *") long l, @NativeType(value="NVGcolor") NVGColor nVGColor) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgFillColor(l, nVGColor.address());
    }

    public static native void nnvgFillPaint(long var0, long var2);

    public static void nvgFillPaint(@NativeType(value="NVGcontext *") long l, @NativeType(value="NVGpaint") NVGPaint nVGPaint) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgFillPaint(l, nVGPaint.address());
    }

    public static native void nnvgMiterLimit(long var0, float var2);

    public static void nvgMiterLimit(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgMiterLimit(l, f);
    }

    public static native void nnvgStrokeWidth(long var0, float var2);

    public static void nvgStrokeWidth(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgStrokeWidth(l, f);
    }

    public static native void nnvgLineCap(long var0, int var2);

    public static void nvgLineCap(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgLineCap(l, n);
    }

    public static native void nnvgLineJoin(long var0, int var2);

    public static void nvgLineJoin(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgLineJoin(l, n);
    }

    public static native void nnvgGlobalAlpha(long var0, float var2);

    public static void nvgGlobalAlpha(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgGlobalAlpha(l, f);
    }

    public static native void nnvgResetTransform(long var0);

    public static void nvgResetTransform(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgResetTransform(l);
    }

    public static native void nnvgTransform(long var0, float var2, float var3, float var4, float var5, float var6, float var7);

    public static void nvgTransform(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5, float f6) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgTransform(l, f, f2, f3, f4, f5, f6);
    }

    public static native void nnvgTranslate(long var0, float var2, float var3);

    public static void nvgTranslate(@NativeType(value="NVGcontext *") long l, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgTranslate(l, f, f2);
    }

    public static native void nnvgRotate(long var0, float var2);

    public static void nvgRotate(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgRotate(l, f);
    }

    public static native void nnvgSkewX(long var0, float var2);

    public static void nvgSkewX(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgSkewX(l, f);
    }

    public static native void nnvgSkewY(long var0, float var2);

    public static void nvgSkewY(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgSkewY(l, f);
    }

    public static native void nnvgScale(long var0, float var2, float var3);

    public static void nvgScale(@NativeType(value="NVGcontext *") long l, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgScale(l, f, f2);
    }

    public static native void nnvgCurrentTransform(long var0, long var2);

    public static void nvgCurrentTransform(@NativeType(value="NVGcontext *") long l, @NativeType(value="float *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check((Buffer)floatBuffer, 6);
        }
        NanoVG.nnvgCurrentTransform(l, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nnvgTransformIdentity(long var0);

    public static void nvgTransformIdentity(@NativeType(value="float *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NanoVG.nnvgTransformIdentity(MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nnvgTransformTranslate(long var0, float var2, float var3);

    public static void nvgTransformTranslate(@NativeType(value="float *") FloatBuffer floatBuffer, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NanoVG.nnvgTransformTranslate(MemoryUtil.memAddress(floatBuffer), f, f2);
    }

    public static native void nnvgTransformScale(long var0, float var2, float var3);

    public static void nvgTransformScale(@NativeType(value="float *") FloatBuffer floatBuffer, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NanoVG.nnvgTransformScale(MemoryUtil.memAddress(floatBuffer), f, f2);
    }

    public static native void nnvgTransformRotate(long var0, float var2);

    public static void nvgTransformRotate(@NativeType(value="float *") FloatBuffer floatBuffer, float f) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NanoVG.nnvgTransformRotate(MemoryUtil.memAddress(floatBuffer), f);
    }

    public static native void nnvgTransformSkewX(long var0, float var2);

    public static void nvgTransformSkewX(@NativeType(value="float *") FloatBuffer floatBuffer, float f) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NanoVG.nnvgTransformSkewX(MemoryUtil.memAddress(floatBuffer), f);
    }

    public static native void nnvgTransformSkewY(long var0, float var2);

    public static void nvgTransformSkewY(@NativeType(value="float *") FloatBuffer floatBuffer, float f) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NanoVG.nnvgTransformSkewY(MemoryUtil.memAddress(floatBuffer), f);
    }

    public static native void nnvgTransformMultiply(long var0, long var2);

    public static void nvgTransformMultiply(@NativeType(value="float *") FloatBuffer floatBuffer, @NativeType(value="float const *") FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
            Checks.check((Buffer)floatBuffer2, 6);
        }
        NanoVG.nnvgTransformMultiply(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2));
    }

    public static native void nnvgTransformPremultiply(long var0, long var2);

    public static void nvgTransformPremultiply(@NativeType(value="float *") FloatBuffer floatBuffer, @NativeType(value="float const *") FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
            Checks.check((Buffer)floatBuffer2, 6);
        }
        NanoVG.nnvgTransformPremultiply(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2));
    }

    public static native int nnvgTransformInverse(long var0, long var2);

    @NativeType(value="int")
    public static boolean nvgTransformInverse(@NativeType(value="float *") FloatBuffer floatBuffer, @NativeType(value="float const *") FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
            Checks.check((Buffer)floatBuffer2, 6);
        }
        return NanoVG.nnvgTransformInverse(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2)) != 0;
    }

    public static native void nnvgTransformPoint(long var0, long var2, long var4, float var6, float var7);

    public static void nvgTransformPoint(@NativeType(value="float *") FloatBuffer floatBuffer, @NativeType(value="float *") FloatBuffer floatBuffer2, @NativeType(value="float const *") FloatBuffer floatBuffer3, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
            Checks.check((Buffer)floatBuffer2, 1);
            Checks.check((Buffer)floatBuffer3, 6);
        }
        NanoVG.nnvgTransformPoint(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2), MemoryUtil.memAddress(floatBuffer3), f, f2);
    }

    public static native float nvgDegToRad(float var0);

    public static native float nvgRadToDeg(float var0);

    public static native int nnvgCreateImage(long var0, long var2, int var4);

    public static int nvgCreateImage(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
        }
        return NanoVG.nnvgCreateImage(l, MemoryUtil.memAddress(byteBuffer), n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgCreateImage(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n3 = NanoVG.nnvgCreateImage(l, l2, n);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int nnvgCreateImageMem(long var0, int var2, long var3, int var5);

    public static int nvgCreateImageMem(@NativeType(value="NVGcontext *") long l, int n, @NativeType(value="unsigned char *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return NanoVG.nnvgCreateImageMem(l, n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static native int nnvgCreateImageRGBA(long var0, int var2, int var3, int var4, long var5);

    public static int nvgCreateImageRGBA(@NativeType(value="NVGcontext *") long l, int n, int n2, int n3, @NativeType(value="unsigned char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check((Buffer)byteBuffer, n * n2 * 4);
        }
        return NanoVG.nnvgCreateImageRGBA(l, n, n2, n3, MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nnvgUpdateImage(long var0, int var2, long var3);

    public static void nvgUpdateImage(@NativeType(value="NVGcontext *") long l, int n, @NativeType(value="unsigned char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgUpdateImage(l, n, MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nnvgImageSize(long var0, int var2, long var3, long var5);

    public static void nvgImageSize(@NativeType(value="NVGcontext *") long l, int n, @NativeType(value="int *") IntBuffer intBuffer, @NativeType(value="int *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        NanoVG.nnvgImageSize(l, n, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2));
    }

    public static native void nnvgDeleteImage(long var0, int var2);

    public static void nvgDeleteImage(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgDeleteImage(l, n);
    }

    public static native void nnvgLinearGradient(long var0, float var2, float var3, float var4, float var5, long var6, long var8, long var10);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgLinearGradient(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, @NativeType(value="NVGcolor") NVGColor nVGColor, @NativeType(value="NVGcolor") NVGColor nVGColor2, @NativeType(value="NVGpaint") NVGPaint nVGPaint) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgLinearGradient(l, f, f2, f3, f4, nVGColor.address(), nVGColor2.address(), nVGPaint.address());
        return nVGPaint;
    }

    public static native void nnvgBoxGradient(long var0, float var2, float var3, float var4, float var5, float var6, float var7, long var8, long var10, long var12);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgBoxGradient(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5, float f6, @NativeType(value="NVGcolor") NVGColor nVGColor, @NativeType(value="NVGcolor") NVGColor nVGColor2, @NativeType(value="NVGpaint") NVGPaint nVGPaint) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgBoxGradient(l, f, f2, f3, f4, f5, f6, nVGColor.address(), nVGColor2.address(), nVGPaint.address());
        return nVGPaint;
    }

    public static native void nnvgRadialGradient(long var0, float var2, float var3, float var4, float var5, long var6, long var8, long var10);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgRadialGradient(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, @NativeType(value="NVGcolor") NVGColor nVGColor, @NativeType(value="NVGcolor") NVGColor nVGColor2, @NativeType(value="NVGpaint") NVGPaint nVGPaint) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgRadialGradient(l, f, f2, f3, f4, nVGColor.address(), nVGColor2.address(), nVGPaint.address());
        return nVGPaint;
    }

    public static native void nnvgImagePattern(long var0, float var2, float var3, float var4, float var5, float var6, int var7, float var8, long var9);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgImagePattern(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5, int n, float f6, @NativeType(value="NVGpaint") NVGPaint nVGPaint) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgImagePattern(l, f, f2, f3, f4, f5, n, f6, nVGPaint.address());
        return nVGPaint;
    }

    public static native void nnvgScissor(long var0, float var2, float var3, float var4, float var5);

    public static void nvgScissor(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgScissor(l, f, f2, f3, f4);
    }

    public static native void nnvgIntersectScissor(long var0, float var2, float var3, float var4, float var5);

    public static void nvgIntersectScissor(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgIntersectScissor(l, f, f2, f3, f4);
    }

    public static native void nnvgResetScissor(long var0);

    public static void nvgResetScissor(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgResetScissor(l);
    }

    public static native void nnvgBeginPath(long var0);

    public static void nvgBeginPath(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgBeginPath(l);
    }

    public static native void nnvgMoveTo(long var0, float var2, float var3);

    public static void nvgMoveTo(@NativeType(value="NVGcontext *") long l, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgMoveTo(l, f, f2);
    }

    public static native void nnvgLineTo(long var0, float var2, float var3);

    public static void nvgLineTo(@NativeType(value="NVGcontext *") long l, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgLineTo(l, f, f2);
    }

    public static native void nnvgBezierTo(long var0, float var2, float var3, float var4, float var5, float var6, float var7);

    public static void nvgBezierTo(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5, float f6) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgBezierTo(l, f, f2, f3, f4, f5, f6);
    }

    public static native void nnvgQuadTo(long var0, float var2, float var3, float var4, float var5);

    public static void nvgQuadTo(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgQuadTo(l, f, f2, f3, f4);
    }

    public static native void nnvgArcTo(long var0, float var2, float var3, float var4, float var5, float var6);

    public static void nvgArcTo(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgArcTo(l, f, f2, f3, f4, f5);
    }

    public static native void nnvgClosePath(long var0);

    public static void nvgClosePath(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgClosePath(l);
    }

    public static native void nnvgPathWinding(long var0, int var2);

    public static void nvgPathWinding(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgPathWinding(l, n);
    }

    public static native void nnvgArc(long var0, float var2, float var3, float var4, float var5, float var6, int var7);

    public static void nvgArc(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgArc(l, f, f2, f3, f4, f5, n);
    }

    public static native void nnvgRect(long var0, float var2, float var3, float var4, float var5);

    public static void nvgRect(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgRect(l, f, f2, f3, f4);
    }

    public static native void nnvgRoundedRect(long var0, float var2, float var3, float var4, float var5, float var6);

    public static void nvgRoundedRect(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgRoundedRect(l, f, f2, f3, f4, f5);
    }

    public static native void nnvgRoundedRectVarying(long var0, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9);

    public static void nvgRoundedRectVarying(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgRoundedRectVarying(l, f, f2, f3, f4, f5, f6, f7, f8);
    }

    public static native void nnvgEllipse(long var0, float var2, float var3, float var4, float var5);

    public static void nvgEllipse(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, float f4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgEllipse(l, f, f2, f3, f4);
    }

    public static native void nnvgCircle(long var0, float var2, float var3, float var4);

    public static void nvgCircle(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgCircle(l, f, f2, f3);
    }

    public static native void nnvgFill(long var0);

    public static void nvgFill(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgFill(l);
    }

    public static native void nnvgStroke(long var0);

    public static void nvgStroke(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgStroke(l);
    }

    public static native int nnvgCreateFont(long var0, long var2, long var4);

    public static int nvgCreateFont(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        return NanoVG.nnvgCreateFont(l, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgCreateFont(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            memoryStack.nASCII(charSequence2, true);
            long l3 = memoryStack.getPointerAddress();
            int n2 = NanoVG.nnvgCreateFont(l, l2, l3);
            return n2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nnvgCreateFontAtIndex(long var0, long var2, long var4, int var6);

    public static int nvgCreateFontAtIndex(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        return NanoVG.nnvgCreateFontAtIndex(l, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgCreateFontAtIndex(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            memoryStack.nASCII(charSequence2, true);
            long l3 = memoryStack.getPointerAddress();
            int n3 = NanoVG.nnvgCreateFontAtIndex(l, l2, l3, n);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int nnvgCreateFontMem(long var0, long var2, long var4, int var6, int var7);

    public static int nvgCreateFontMem(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="unsigned char *") ByteBuffer byteBuffer2, @NativeType(value="int") boolean bl) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
        }
        return NanoVG.nnvgCreateFontMem(l, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), byteBuffer2.remaining(), bl ? 1 : 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgCreateFontMem(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="unsigned char *") ByteBuffer byteBuffer, @NativeType(value="int") boolean bl) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n2 = NanoVG.nnvgCreateFontMem(l, l2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), bl ? 1 : 0);
            return n2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nnvgCreateFontMemAtIndex(long var0, long var2, long var4, int var6, int var7, int var8);

    public static int nvgCreateFontMemAtIndex(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="unsigned char *") ByteBuffer byteBuffer2, @NativeType(value="int") boolean bl, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
        }
        return NanoVG.nnvgCreateFontMemAtIndex(l, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), byteBuffer2.remaining(), bl ? 1 : 0, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgCreateFontMemAtIndex(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="unsigned char *") ByteBuffer byteBuffer, @NativeType(value="int") boolean bl, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n3 = NanoVG.nnvgCreateFontMemAtIndex(l, l2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), bl ? 1 : 0, n);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int nnvgFindFont(long var0, long var2);

    public static int nvgFindFont(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
        }
        return NanoVG.nnvgFindFont(l, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgFindFont(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n2 = NanoVG.nnvgFindFont(l, l2);
            return n2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nnvgAddFallbackFontId(long var0, int var2, int var3);

    public static int nvgAddFallbackFontId(@NativeType(value="NVGcontext *") long l, int n, int n2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return NanoVG.nnvgAddFallbackFontId(l, n, n2);
    }

    public static native int nnvgAddFallbackFont(long var0, long var2, long var4);

    public static int nvgAddFallbackFont(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        return NanoVG.nnvgAddFallbackFont(l, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgAddFallbackFont(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            memoryStack.nASCII(charSequence2, true);
            long l3 = memoryStack.getPointerAddress();
            int n2 = NanoVG.nnvgAddFallbackFont(l, l2, l3);
            return n2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nnvgResetFallbackFontsId(long var0, int var2);

    public static void nvgResetFallbackFontsId(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgResetFallbackFontsId(l, n);
    }

    public static native void nnvgResetFallbackFonts(long var0, long var2);

    public static void nvgResetFallbackFonts(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
        }
        NanoVG.nnvgResetFallbackFonts(l, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void nvgResetFallbackFonts(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            NanoVG.nnvgResetFallbackFonts(l, l2);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nnvgFontSize(long var0, float var2);

    public static void nvgFontSize(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgFontSize(l, f);
    }

    public static native void nnvgFontBlur(long var0, float var2);

    public static void nvgFontBlur(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgFontBlur(l, f);
    }

    public static native void nnvgTextLetterSpacing(long var0, float var2);

    public static void nvgTextLetterSpacing(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgTextLetterSpacing(l, f);
    }

    public static native void nnvgTextLineHeight(long var0, float var2);

    public static void nvgTextLineHeight(@NativeType(value="NVGcontext *") long l, float f) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgTextLineHeight(l, f);
    }

    public static native void nnvgTextAlign(long var0, int var2);

    public static void nvgTextAlign(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgTextAlign(l, n);
    }

    public static native void nnvgFontFaceId(long var0, int var2);

    public static void nvgFontFaceId(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgFontFaceId(l, n);
    }

    public static native void nnvgFontFace(long var0, long var2);

    public static void nvgFontFace(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
        }
        NanoVG.nnvgFontFace(l, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void nvgFontFace(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            NanoVG.nnvgFontFace(l, l2);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native float nnvgText(long var0, float var2, float var3, long var4, long var6);

    public static float nvgText(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return NanoVG.nnvgText(l, f, f2, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static float nvgText(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            float f3 = NanoVG.nnvgText(l, f, f2, l2, l2 + (long)n2);
            return f3;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nnvgTextBox(long var0, float var2, float var3, float var4, long var5, long var7);

    public static void nvgTextBox(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVG.nnvgTextBox(l, f, f2, f3, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void nvgTextBox(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, @NativeType(value="char const *") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            NanoVG.nnvgTextBox(l, f, f2, f3, l2, l2 + (long)n2);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native float nnvgTextBounds(long var0, float var2, float var3, long var4, long var6, long var8);

    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe((Buffer)floatBuffer, 4);
        }
        return NanoVG.nnvgTextBounds(l, f, f2, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining(), MemoryUtil.memAddressSafe(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe((Buffer)floatBuffer, 4);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            float f3 = NanoVG.nnvgTextBounds(l, f, f2, l2, l2 + (long)n2, MemoryUtil.memAddressSafe(floatBuffer));
            return f3;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nnvgTextBoxBounds(long var0, float var2, float var3, float var4, long var5, long var7, long var9);

    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe((Buffer)floatBuffer, 4);
        }
        NanoVG.nnvgTextBoxBounds(l, f, f2, f3, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining(), MemoryUtil.memAddressSafe(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe((Buffer)floatBuffer, 4);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            NanoVG.nnvgTextBoxBounds(l, f, f2, f3, l2, l2 + (long)n2, MemoryUtil.memAddressSafe(floatBuffer));
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nnvgTextGlyphPositions(long var0, float var2, float var3, long var4, long var6, long var8, int var10);

    public static int nvgTextGlyphPositions(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="NVGglyphPosition *") NVGGlyphPosition.Buffer buffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return NanoVG.nnvgTextGlyphPositions(l, f, f2, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining(), buffer.address(), buffer.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgTextGlyphPositions(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="NVGglyphPosition *") NVGGlyphPosition.Buffer buffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            int n3 = NanoVG.nnvgTextGlyphPositions(l, f, f2, l2, l2 + (long)n2, buffer.address(), buffer.remaining());
            return n3;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nnvgTextMetrics(long var0, long var2, long var4, long var6);

    public static void nvgTextMetrics(@NativeType(value="NVGcontext *") long l, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer2, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer3) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe((Buffer)floatBuffer, 1);
            Checks.checkSafe((Buffer)floatBuffer2, 1);
            Checks.checkSafe((Buffer)floatBuffer3, 1);
        }
        NanoVG.nnvgTextMetrics(l, MemoryUtil.memAddressSafe(floatBuffer), MemoryUtil.memAddressSafe(floatBuffer2), MemoryUtil.memAddressSafe(floatBuffer3));
    }

    public static native int nnvgTextBreakLines(long var0, long var2, long var4, float var6, long var7, int var9);

    public static int nvgTextBreakLines(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer, float f, @NativeType(value="NVGtextRow *") NVGTextRow.Buffer buffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return NanoVG.nnvgTextBreakLines(l, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining(), f, buffer.address(), buffer.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int nvgTextBreakLines(@NativeType(value="NVGcontext *") long l, @NativeType(value="char const *") CharSequence charSequence, float f, @NativeType(value="NVGtextRow *") NVGTextRow.Buffer buffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            int n3 = NanoVG.nnvgTextBreakLines(l, l2, l2 + (long)n2, f, buffer.address(), buffer.remaining());
            return n3;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    @NativeType(value="void *")
    private static native long nvgCreateInternal();

    @NativeType(value="void *")
    private static native long nvgInternalParams();

    @NativeType(value="void *")
    private static native long nvgDeleteInternal();

    public static native void nnvgCurrentTransform(long var0, float[] var2);

    public static void nvgCurrentTransform(@NativeType(value="NVGcontext *") long l, @NativeType(value="float *") float[] fArray) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check(fArray, 6);
        }
        NanoVG.nnvgCurrentTransform(l, fArray);
    }

    public static native void nnvgTransformIdentity(float[] var0);

    public static void nvgTransformIdentity(@NativeType(value="float *") float[] fArray) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
        }
        NanoVG.nnvgTransformIdentity(fArray);
    }

    public static native void nnvgTransformTranslate(float[] var0, float var1, float var2);

    public static void nvgTransformTranslate(@NativeType(value="float *") float[] fArray, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
        }
        NanoVG.nnvgTransformTranslate(fArray, f, f2);
    }

    public static native void nnvgTransformScale(float[] var0, float var1, float var2);

    public static void nvgTransformScale(@NativeType(value="float *") float[] fArray, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
        }
        NanoVG.nnvgTransformScale(fArray, f, f2);
    }

    public static native void nnvgTransformRotate(float[] var0, float var1);

    public static void nvgTransformRotate(@NativeType(value="float *") float[] fArray, float f) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
        }
        NanoVG.nnvgTransformRotate(fArray, f);
    }

    public static native void nnvgTransformSkewX(float[] var0, float var1);

    public static void nvgTransformSkewX(@NativeType(value="float *") float[] fArray, float f) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
        }
        NanoVG.nnvgTransformSkewX(fArray, f);
    }

    public static native void nnvgTransformSkewY(float[] var0, float var1);

    public static void nvgTransformSkewY(@NativeType(value="float *") float[] fArray, float f) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
        }
        NanoVG.nnvgTransformSkewY(fArray, f);
    }

    public static native void nnvgTransformMultiply(float[] var0, float[] var1);

    public static void nvgTransformMultiply(@NativeType(value="float *") float[] fArray, @NativeType(value="float const *") float[] fArray2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
            Checks.check(fArray2, 6);
        }
        NanoVG.nnvgTransformMultiply(fArray, fArray2);
    }

    public static native void nnvgTransformPremultiply(float[] var0, float[] var1);

    public static void nvgTransformPremultiply(@NativeType(value="float *") float[] fArray, @NativeType(value="float const *") float[] fArray2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
            Checks.check(fArray2, 6);
        }
        NanoVG.nnvgTransformPremultiply(fArray, fArray2);
    }

    public static native int nnvgTransformInverse(float[] var0, float[] var1);

    @NativeType(value="int")
    public static boolean nvgTransformInverse(@NativeType(value="float *") float[] fArray, @NativeType(value="float const *") float[] fArray2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 6);
            Checks.check(fArray2, 6);
        }
        return NanoVG.nnvgTransformInverse(fArray, fArray2) != 0;
    }

    public static native void nnvgTransformPoint(float[] var0, float[] var1, float[] var2, float var3, float var4);

    public static void nvgTransformPoint(@NativeType(value="float *") float[] fArray, @NativeType(value="float *") float[] fArray2, @NativeType(value="float const *") float[] fArray3, float f, float f2) {
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
            Checks.check(fArray2, 1);
            Checks.check(fArray3, 6);
        }
        NanoVG.nnvgTransformPoint(fArray, fArray2, fArray3, f, f2);
    }

    public static native void nnvgImageSize(long var0, int var2, int[] var3, int[] var4);

    public static void nvgImageSize(@NativeType(value="NVGcontext *") long l, int n, @NativeType(value="int *") int[] nArray, @NativeType(value="int *") int[] nArray2) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        NanoVG.nnvgImageSize(l, n, nArray, nArray2);
    }

    public static native float nnvgTextBounds(long var0, float var2, float var3, long var4, long var6, float[] var8);

    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="float *") float @Nullable [] fArray) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(fArray, 4);
        }
        return NanoVG.nnvgTextBounds(l, f, f2, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining(), fArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="float *") float @Nullable [] fArray) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(fArray, 4);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            float f3 = NanoVG.nnvgTextBounds(l, f, f2, l2, l2 + (long)n2, fArray);
            return f3;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nnvgTextBoxBounds(long var0, float var2, float var3, float var4, long var5, long var7, float[] var9);

    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="float *") float @Nullable [] fArray) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(fArray, 4);
        }
        NanoVG.nnvgTextBoxBounds(l, f, f2, f3, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer) + (long)byteBuffer.remaining(), fArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long l, float f, float f2, float f3, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="float *") float @Nullable [] fArray) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(fArray, 4);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            NanoVG.nnvgTextBoxBounds(l, f, f2, f3, l2, l2 + (long)n2, fArray);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nnvgTextMetrics(long var0, float[] var2, float[] var3, float[] var4);

    public static void nvgTextMetrics(@NativeType(value="NVGcontext *") long l, @NativeType(value="float *") float @Nullable [] fArray, @NativeType(value="float *") float @Nullable [] fArray2, @NativeType(value="float *") float @Nullable [] fArray3) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(fArray, 1);
            Checks.checkSafe(fArray2, 1);
            Checks.checkSafe(fArray3, 1);
        }
        NanoVG.nnvgTextMetrics(l, fArray, fArray2, fArray3);
    }

    static {
        LibNanoVG.initialize();
        nvgCreateInternal = NanoVG.nvgCreateInternal();
        nvgInternalParams = NanoVG.nvgInternalParams();
        nvgDeleteInternal = NanoVG.nvgDeleteInternal();
    }
}

