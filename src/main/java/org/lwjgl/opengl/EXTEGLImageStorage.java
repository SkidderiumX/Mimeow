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

public class EXTEGLImageStorage {
    protected EXTEGLImageStorage() {
        throw new UnsupportedOperationException();
    }

    public static native void nglEGLImageTargetTexStorageEXT(int var0, long var1, long var3);

    public static void glEGLImageTargetTexStorageEXT(@NativeType(value="GLenum") int n, @NativeType(value="GLeglImageOES") long l, @NativeType(value="int const *") @Nullable IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNTSafe(intBuffer);
        }
        EXTEGLImageStorage.nglEGLImageTargetTexStorageEXT(n, l, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static native void nglEGLImageTargetTextureStorageEXT(int var0, long var1, long var3);

    public static void glEGLImageTargetTextureStorageEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLeglImageOES") long l, @NativeType(value="int const *") @Nullable IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkNTSafe(intBuffer);
        }
        EXTEGLImageStorage.nglEGLImageTargetTextureStorageEXT(n, l, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glEGLImageTargetTexStorageEXT(@NativeType(value="GLenum") int n, @NativeType(value="GLeglImageOES") long l, @NativeType(value="int const *") int @Nullable [] nArray) {
        long l2 = GL.getICD().glEGLImageTargetTexStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
            Checks.checkNTSafe(nArray);
        }
        JNI.callPPV(n, l, nArray, l2);
    }

    public static void glEGLImageTargetTextureStorageEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLeglImageOES") long l, @NativeType(value="int const *") int @Nullable [] nArray) {
        long l2 = GL.getICD().glEGLImageTargetTextureStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
            Checks.checkNTSafe(nArray);
        }
        JNI.callPPV(n, l, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

