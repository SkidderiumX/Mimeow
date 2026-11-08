/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.system.NativeType;

public class ARBGetProgramBinary {
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
    public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
    public static final int GL_PROGRAM_BINARY_FORMATS = 34815;

    protected ARBGetProgramBinary() {
        throw new UnsupportedOperationException();
    }

    public static void nglGetProgramBinary(int n, int n2, long l, long l2, long l3) {
        GL41C.nglGetProgramBinary(n, n2, l, l2, l3);
    }

    public static void glGetProgramBinary(@NativeType(value="GLuint") int n, @NativeType(value="GLsizei *") @Nullable IntBuffer intBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL41C.glGetProgramBinary(n, intBuffer, intBuffer2, byteBuffer);
    }

    public static void nglProgramBinary(int n, int n2, long l, int n3) {
        GL41C.nglProgramBinary(n, n2, l, n3);
    }

    public static void glProgramBinary(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL41C.glProgramBinary(n, n2, byteBuffer);
    }

    public static void glProgramParameteri(@NativeType(value="GLuint") int n, @NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3) {
        GL41C.glProgramParameteri(n, n2, n3);
    }

    public static void glGetProgramBinary(@NativeType(value="GLuint") int n, @NativeType(value="GLsizei *") int @Nullable [] nArray, @NativeType(value="GLenum *") int[] nArray2, @NativeType(value="void *") ByteBuffer byteBuffer) {
        GL41C.glGetProgramBinary(n, nArray, nArray2, byteBuffer);
    }

    static {
        GL.initialize();
    }
}

