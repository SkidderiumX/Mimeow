/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.NSVGImage;
import org.lwjgl.nanovg.NSVGPath;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NanoSVG {
    public static final int NSVG_PAINT_UNDEF = -1;
    public static final int NSVG_PAINT_NONE = 0;
    public static final int NSVG_PAINT_COLOR = 1;
    public static final int NSVG_PAINT_LINEAR_GRADIENT = 2;
    public static final int NSVG_PAINT_RADIAL_GRADIENT = 3;
    public static final int NSVG_SPREAD_PAD = 0;
    public static final int NSVG_SPREAD_REFLECT = 1;
    public static final int NSVG_SPREAD_REPEAT = 2;
    public static final int NSVG_JOIN_MITER = 0;
    public static final int NSVG_JOIN_ROUND = 1;
    public static final int NSVG_JOIN_BEVEL = 2;
    public static final int NSVG_CAP_BUTT = 0;
    public static final int NSVG_CAP_ROUND = 1;
    public static final int NSVG_CAP_SQUARE = 2;
    public static final int NSVG_FILLRULE_NONZERO = 0;
    public static final int NSVG_FILLRULE_EVENODD = 1;
    public static final int NSVG_FLAGS_VISIBLE = 1;

    protected NanoSVG() {
        throw new UnsupportedOperationException();
    }

    public static native long nnsvgParseFromFile(long var0, long var2, float var4);

    @NativeType(value="NSVGimage *")
    public static @Nullable NSVGImage nsvgParseFromFile(@NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, float f) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        long l = NanoSVG.nnsvgParseFromFile(MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), f);
        return NSVGImage.createSafe(l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="NSVGimage *")
    public static @Nullable NSVGImage nsvgParseFromFile(@NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2, float f) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nASCII(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            long l3 = NanoSVG.nnsvgParseFromFile(l, l2, f);
            NSVGImage nSVGImage = NSVGImage.createSafe(l3);
            return nSVGImage;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native long nnsvgParse(long var0, long var2, float var4);

    @NativeType(value="NSVGimage *")
    public static @Nullable NSVGImage nsvgParse(@NativeType(value="char *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, float f) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        long l = NanoSVG.nnsvgParse(MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), f);
        return NSVGImage.createSafe(l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="NSVGimage *")
    public static @Nullable NSVGImage nsvgParse(@NativeType(value="char *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2, float f) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nASCII(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            long l3 = NanoSVG.nnsvgParse(l, l2, f);
            NSVGImage nSVGImage = NSVGImage.createSafe(l3);
            return nSVGImage;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native long nnsvgDuplicatePath(long var0);

    @NativeType(value="NSVGpath *")
    public static @Nullable NSVGPath nsvgDuplicatePath(@NativeType(value="NSVGpath *") NSVGPath nSVGPath) {
        long l = NanoSVG.nnsvgDuplicatePath(nSVGPath.address());
        return NSVGPath.createSafe(l);
    }

    public static native void nnsvgDelete(long var0);

    public static void nsvgDelete(@NativeType(value="NSVGimage *") NSVGImage nSVGImage) {
        NanoSVG.nnsvgDelete(nSVGImage.address());
    }

    @NativeType(value="NSVGrasterizer *")
    public static native long nsvgCreateRasterizer();

    public static native void nnsvgRasterize(long var0, long var2, float var4, float var5, float var6, long var7, int var9, int var10, int var11);

    public static void nsvgRasterize(@NativeType(value="NSVGrasterizer *") long l, @NativeType(value="NSVGimage *") NSVGImage nSVGImage, float f, float f2, float f3, @NativeType(value="unsigned char *") ByteBuffer byteBuffer, int n, int n2, int n3) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check((Buffer)byteBuffer, n2 * n3);
        }
        NanoSVG.nnsvgRasterize(l, nSVGImage.address(), f, f2, f3, MemoryUtil.memAddress(byteBuffer), n, n2, n3);
    }

    public static native void nnsvgDeleteRasterizer(long var0);

    public static void nsvgDeleteRasterizer(@NativeType(value="NSVGrasterizer *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoSVG.nnsvgDeleteRasterizer(l);
    }

    static {
        LibNanoVG.initialize();
    }
}

