/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBClearBufferObject {
    protected ARBClearBufferObject() {
        throw new UnsupportedOperationException();
    }

    public static void nglClearBufferData(int n, int n2, int n3, int n4, long l) {
        GL43C.nglClearBufferData(n, n2, n3, n4, l);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ByteBuffer byteBuffer) {
        GL43C.glClearBufferData(n, n2, n3, n4, byteBuffer);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ShortBuffer shortBuffer) {
        GL43C.glClearBufferData(n, n2, n3, n4, shortBuffer);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable IntBuffer intBuffer) {
        GL43C.glClearBufferData(n, n2, n3, n4, intBuffer);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable FloatBuffer floatBuffer) {
        GL43C.glClearBufferData(n, n2, n3, n4, floatBuffer);
    }

    public static void nglClearBufferSubData(int n, int n2, long l, long l2, int n3, int n4, long l3) {
        GL43C.nglClearBufferSubData(n, n2, l, l2, n3, n4, l3);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ByteBuffer byteBuffer) {
        GL43C.glClearBufferSubData(n, n2, l, l2, n3, n4, byteBuffer);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ShortBuffer shortBuffer) {
        GL43C.glClearBufferSubData(n, n2, l, l2, n3, n4, shortBuffer);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable IntBuffer intBuffer) {
        GL43C.glClearBufferSubData(n, n2, l, l2, n3, n4, intBuffer);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable FloatBuffer floatBuffer) {
        GL43C.glClearBufferSubData(n, n2, l, l2, n3, n4, floatBuffer);
    }

    public static native void nglClearNamedBufferDataEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ByteBuffer byteBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n, n2, n3, n4, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ShortBuffer shortBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n, n2, n3, n4, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable IntBuffer intBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n, n2, n3, n4, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable FloatBuffer floatBuffer) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(n, n2, n3, n4, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static native void nglClearNamedBufferSubDataEXT(int var0, int var1, long var2, long var4, int var6, int var7, long var8);

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ByteBuffer byteBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n, n2, l, l2, n3, n4, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable ShortBuffer shortBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n, n2, l, l2, n3, n4, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable IntBuffer intBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n, n2, l, l2, n3, n4, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") @Nullable FloatBuffer floatBuffer) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(n, n2, l, l2, n3, n4, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") short @Nullable [] sArray) {
        GL43C.glClearBufferData(n, n2, n3, n4, sArray);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") int @Nullable [] nArray) {
        GL43C.glClearBufferData(n, n2, n3, n4, nArray);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") float @Nullable [] fArray) {
        GL43C.glClearBufferData(n, n2, n3, n4, fArray);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") short @Nullable [] sArray) {
        GL43C.glClearBufferSubData(n, n2, l, l2, n3, n4, sArray);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") int @Nullable [] nArray) {
        GL43C.glClearBufferSubData(n, n2, l, l2, n3, n4, nArray);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") float @Nullable [] fArray) {
        GL43C.glClearBufferSubData(n, n2, l, l2, n3, n4, fArray);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") short @Nullable [] sArray) {
        long l = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.callPV(n, n2, n3, n4, sArray, l);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") int @Nullable [] nArray) {
        long l = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.callPV(n, n2, n3, n4, nArray, l);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") float @Nullable [] fArray) {
        long l = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.callPV(n, n2, n3, n4, fArray, l);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") short @Nullable [] sArray) {
        long l3 = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n, n2, l, l2, n3, n4, sArray, l3);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") int @Nullable [] nArray) {
        long l3 = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n, n2, l, l2, n3, n4, nArray, l3);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") float @Nullable [] fArray) {
        long l3 = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPPPV(n, n2, l, l2, n3, n4, fArray, l3);
    }

    static {
        GL.initialize();
    }
}

