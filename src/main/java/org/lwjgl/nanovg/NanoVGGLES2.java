/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.NVGLUFramebuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NanoVGGLES2 {
    public static final int NVG_ANTIALIAS = 1;
    public static final int NVG_STENCIL_STROKES = 2;
    public static final int NVG_DEBUG = 4;
    public static final int NVG_IMAGE_NODELETE = 65536;

    protected NanoVGGLES2() {
        throw new UnsupportedOperationException();
    }

    public static native int nnvglCreateImageFromHandle(long var0, int var2, int var3, int var4, int var5);

    public static int nvglCreateImageFromHandle(@NativeType(value="NVGcontext *") long l, @NativeType(value="GLuint") int n, int n2, int n3, int n4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return NanoVGGLES2.nnvglCreateImageFromHandle(l, n, n2, n3, n4);
    }

    public static native int nnvglImageHandle(long var0, int var2);

    @NativeType(value="GLuint")
    public static int nvglImageHandle(@NativeType(value="NVGcontext *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return NanoVGGLES2.nnvglImageHandle(l, n);
    }

    public static native long nnvgCreate(int var0);

    @NativeType(value="NVGcontext *")
    public static long nvgCreate(int n) {
        return NanoVGGLES2.nnvgCreate(n);
    }

    public static native void nnvgDelete(long var0);

    public static void nvgDelete(@NativeType(value="NVGcontext *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVGGLES2.nnvgDelete(l);
    }

    public static native long nnvgluCreateFramebuffer(long var0, int var2, int var3, int var4);

    @NativeType(value="NVGLUframebuffer *")
    public static @Nullable NVGLUFramebuffer nvgluCreateFramebuffer(@NativeType(value="NVGcontext *") long l, int n, int n2, int n3) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        long l2 = NanoVGGLES2.nnvgluCreateFramebuffer(l, n, n2, n3);
        return NVGLUFramebuffer.createSafe(l2);
    }

    public static native void nnvgluBindFramebuffer(long var0, long var2);

    public static void nvgluBindFramebuffer(@NativeType(value="NVGcontext *") long l, @NativeType(value="NVGLUframebuffer *") @Nullable NVGLUFramebuffer nVGLUFramebuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVGGLES2.nnvgluBindFramebuffer(l, MemoryUtil.memAddressSafe(nVGLUFramebuffer));
    }

    public static native void nnvgluDeleteFramebuffer(long var0, long var2);

    public static void nvgluDeleteFramebuffer(@NativeType(value="NVGcontext *") long l, @NativeType(value="NVGLUframebuffer *") NVGLUFramebuffer nVGLUFramebuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        NanoVGGLES2.nnvgluDeleteFramebuffer(l, nVGLUFramebuffer.address());
    }

    static {
        LibNanoVG.initialize();
    }
}

