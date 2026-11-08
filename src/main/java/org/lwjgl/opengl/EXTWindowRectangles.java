/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTWindowRectangles {
    public static final int GL_INCLUSIVE_EXT = 36624;
    public static final int GL_EXCLUSIVE_EXT = 36625;
    public static final int GL_WINDOW_RECTANGLE_EXT = 36626;
    public static final int GL_WINDOW_RECTANGLE_MODE_EXT = 36627;
    public static final int GL_MAX_WINDOW_RECTANGLES_EXT = 36628;
    public static final int GL_NUM_WINDOW_RECTANGLES_EXT = 36629;

    protected EXTWindowRectangles() {
        throw new UnsupportedOperationException();
    }

    public static native void nglWindowRectanglesEXT(int var0, int var1, long var2);

    public static void glWindowRectanglesEXT(@NativeType(value="GLenum") int n, @NativeType(value="GLint const *") @Nullable IntBuffer intBuffer) {
        EXTWindowRectangles.nglWindowRectanglesEXT(n, Checks.remainingSafe(intBuffer) >> 2, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glWindowRectanglesEXT(@NativeType(value="GLenum") int n, @NativeType(value="GLint const *") int @Nullable [] nArray) {
        long l = GL.getICD().glWindowRectanglesEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.callPV(n, Checks.lengthSafe(nArray) >> 2, nArray, l);
    }

    static {
        GL.initialize();
    }
}

