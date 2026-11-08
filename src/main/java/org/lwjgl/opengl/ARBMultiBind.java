/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.system.NativeType;

public class ARBMultiBind {
    protected ARBMultiBind() {
        throw new UnsupportedOperationException();
    }

    public static void nglBindBuffersBase(int n, int n2, int n3, long l) {
        GL44C.nglBindBuffersBase(n, n2, n3, l);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n, @NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") @Nullable IntBuffer intBuffer) {
        GL44C.glBindBuffersBase(n, n2, intBuffer);
    }

    public static void nglBindBuffersRange(int n, int n2, int n3, long l, long l2, long l3) {
        GL44C.nglBindBuffersRange(n, n2, n3, l, l2, l3);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n, @NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") @Nullable IntBuffer intBuffer, @NativeType(value="GLintptr const *") @Nullable PointerBuffer pointerBuffer, @NativeType(value="GLsizeiptr const *") @Nullable PointerBuffer pointerBuffer2) {
        GL44C.glBindBuffersRange(n, n2, intBuffer, pointerBuffer, pointerBuffer2);
    }

    public static void nglBindTextures(int n, int n2, long l) {
        GL44C.nglBindTextures(n, n2, l);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") @Nullable IntBuffer intBuffer) {
        GL44C.glBindTextures(n, intBuffer);
    }

    public static void nglBindSamplers(int n, int n2, long l) {
        GL44C.nglBindSamplers(n, n2, l);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") @Nullable IntBuffer intBuffer) {
        GL44C.glBindSamplers(n, intBuffer);
    }

    public static void nglBindImageTextures(int n, int n2, long l) {
        GL44C.nglBindImageTextures(n, n2, l);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") @Nullable IntBuffer intBuffer) {
        GL44C.glBindImageTextures(n, intBuffer);
    }

    public static void nglBindVertexBuffers(int n, int n2, long l, long l2, long l3) {
        GL44C.nglBindVertexBuffers(n, n2, l, l2, l3);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") @Nullable IntBuffer intBuffer, @NativeType(value="GLintptr const *") @Nullable PointerBuffer pointerBuffer, @NativeType(value="GLsizei const *") @Nullable IntBuffer intBuffer2) {
        GL44C.glBindVertexBuffers(n, intBuffer, pointerBuffer, intBuffer2);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n, @NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int @Nullable [] nArray) {
        GL44C.glBindBuffersBase(n, n2, nArray);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n, @NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int @Nullable [] nArray, @NativeType(value="GLintptr const *") @Nullable PointerBuffer pointerBuffer, @NativeType(value="GLsizeiptr const *") @Nullable PointerBuffer pointerBuffer2) {
        GL44C.glBindBuffersRange(n, n2, nArray, pointerBuffer, pointerBuffer2);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") int @Nullable [] nArray) {
        GL44C.glBindTextures(n, nArray);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") int @Nullable [] nArray) {
        GL44C.glBindSamplers(n, nArray);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") int @Nullable [] nArray) {
        GL44C.glBindImageTextures(n, nArray);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n, @NativeType(value="GLuint const *") int @Nullable [] nArray, @NativeType(value="GLintptr const *") @Nullable PointerBuffer pointerBuffer, @NativeType(value="GLsizei const *") int @Nullable [] nArray2) {
        GL44C.glBindVertexBuffers(n, nArray, pointerBuffer, nArray2);
    }

    static {
        GL.initialize();
    }
}

