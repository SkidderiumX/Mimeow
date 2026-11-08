/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVVertexArrayRange {
    protected WGLNVVertexArrayRange() {
        throw new UnsupportedOperationException();
    }

    public static long nwglAllocateMemoryNV(int n, float f, float f2, float f3) {
        long l = GL.getCapabilitiesWGL().wglAllocateMemoryNV;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.callP(n, f, f2, f3, l);
    }

    @NativeType(value="void *")
    public static @Nullable ByteBuffer wglAllocateMemoryNV(@NativeType(value="GLsizei") int n, @NativeType(value="GLfloat") float f, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3) {
        long l = WGLNVVertexArrayRange.nwglAllocateMemoryNV(n, f, f2, f3);
        return MemoryUtil.memByteBufferSafe(l, n);
    }

    public static void nwglFreeMemoryNV(long l) {
        long l2 = GL.getCapabilitiesWGL().wglFreeMemoryNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(l, l2);
    }

    public static void wglFreeMemoryNV(@NativeType(value="void *") ByteBuffer byteBuffer) {
        WGLNVVertexArrayRange.nwglFreeMemoryNV(MemoryUtil.memAddress(byteBuffer));
    }
}

