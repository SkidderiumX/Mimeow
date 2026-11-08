/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;
import org.lwjgl.util.vector.Matrix;
import org.lwjgl.util.vector.Vector2f;

public class Matrix2f
extends Matrix
implements Serializable {
    private static final long serialVersionUID = 1L;
    public float m00;
    public float m01;
    public float m10;
    public float m11;

    public Matrix2f() {
        this.setIdentity();
    }

    public Matrix2f(Matrix2f matrix2f) {
        this.load(matrix2f);
    }

    public Matrix2f load(Matrix2f matrix2f) {
        return Matrix2f.load(matrix2f, this);
    }

    public static Matrix2f load(Matrix2f matrix2f, Matrix2f matrix2f2) {
        if (matrix2f2 == null) {
            matrix2f2 = new Matrix2f();
        }
        matrix2f2.m00 = matrix2f.m00;
        matrix2f2.m01 = matrix2f.m01;
        matrix2f2.m10 = matrix2f.m10;
        matrix2f2.m11 = matrix2f.m11;
        return matrix2f2;
    }

    @Override
    public Matrix load(FloatBuffer floatBuffer) {
        this.m00 = floatBuffer.get();
        this.m01 = floatBuffer.get();
        this.m10 = floatBuffer.get();
        this.m11 = floatBuffer.get();
        return this;
    }

    @Override
    public Matrix loadTranspose(FloatBuffer floatBuffer) {
        this.m00 = floatBuffer.get();
        this.m10 = floatBuffer.get();
        this.m01 = floatBuffer.get();
        this.m11 = floatBuffer.get();
        return this;
    }

    @Override
    public Matrix store(FloatBuffer floatBuffer) {
        floatBuffer.put(this.m00);
        floatBuffer.put(this.m01);
        floatBuffer.put(this.m10);
        floatBuffer.put(this.m11);
        return this;
    }

    @Override
    public Matrix storeTranspose(FloatBuffer floatBuffer) {
        floatBuffer.put(this.m00);
        floatBuffer.put(this.m10);
        floatBuffer.put(this.m01);
        floatBuffer.put(this.m11);
        return this;
    }

    public static Matrix2f add(Matrix2f matrix2f, Matrix2f matrix2f2, Matrix2f matrix2f3) {
        if (matrix2f3 == null) {
            matrix2f3 = new Matrix2f();
        }
        matrix2f3.m00 = matrix2f.m00 + matrix2f2.m00;
        matrix2f3.m01 = matrix2f.m01 + matrix2f2.m01;
        matrix2f3.m10 = matrix2f.m10 + matrix2f2.m10;
        matrix2f3.m11 = matrix2f.m11 + matrix2f2.m11;
        return matrix2f3;
    }

    public static Matrix2f sub(Matrix2f matrix2f, Matrix2f matrix2f2, Matrix2f matrix2f3) {
        if (matrix2f3 == null) {
            matrix2f3 = new Matrix2f();
        }
        matrix2f3.m00 = matrix2f.m00 - matrix2f2.m00;
        matrix2f3.m01 = matrix2f.m01 - matrix2f2.m01;
        matrix2f3.m10 = matrix2f.m10 - matrix2f2.m10;
        matrix2f3.m11 = matrix2f.m11 - matrix2f2.m11;
        return matrix2f3;
    }

    public static Matrix2f mul(Matrix2f matrix2f, Matrix2f matrix2f2, Matrix2f matrix2f3) {
        if (matrix2f3 == null) {
            matrix2f3 = new Matrix2f();
        }
        float f = matrix2f.m00 * matrix2f2.m00 + matrix2f.m10 * matrix2f2.m01;
        float f2 = matrix2f.m01 * matrix2f2.m00 + matrix2f.m11 * matrix2f2.m01;
        float f3 = matrix2f.m00 * matrix2f2.m10 + matrix2f.m10 * matrix2f2.m11;
        float f4 = matrix2f.m01 * matrix2f2.m10 + matrix2f.m11 * matrix2f2.m11;
        matrix2f3.m00 = f;
        matrix2f3.m01 = f2;
        matrix2f3.m10 = f3;
        matrix2f3.m11 = f4;
        return matrix2f3;
    }

    public static Vector2f transform(Matrix2f matrix2f, Vector2f vector2f, Vector2f vector2f2) {
        if (vector2f2 == null) {
            vector2f2 = new Vector2f();
        }
        float f = matrix2f.m00 * vector2f.x + matrix2f.m10 * vector2f.y;
        float f2 = matrix2f.m01 * vector2f.x + matrix2f.m11 * vector2f.y;
        vector2f2.x = f;
        vector2f2.y = f2;
        return vector2f2;
    }

    @Override
    public Matrix transpose() {
        return this.transpose(this);
    }

    public Matrix2f transpose(Matrix2f matrix2f) {
        return Matrix2f.transpose(this, matrix2f);
    }

    public static Matrix2f transpose(Matrix2f matrix2f, Matrix2f matrix2f2) {
        if (matrix2f2 == null) {
            matrix2f2 = new Matrix2f();
        }
        float f = matrix2f.m10;
        float f2 = matrix2f.m01;
        matrix2f2.m01 = f;
        matrix2f2.m10 = f2;
        return matrix2f2;
    }

    @Override
    public Matrix invert() {
        return Matrix2f.invert(this, this);
    }

    public static Matrix2f invert(Matrix2f matrix2f, Matrix2f matrix2f2) {
        float f = matrix2f.determinant();
        if (f != 0.0f) {
            if (matrix2f2 == null) {
                matrix2f2 = new Matrix2f();
            }
            float f2 = 1.0f / f;
            float f3 = matrix2f.m11 * f2;
            float f4 = -matrix2f.m01 * f2;
            float f5 = matrix2f.m00 * f2;
            float f6 = -matrix2f.m10 * f2;
            matrix2f2.m00 = f3;
            matrix2f2.m01 = f4;
            matrix2f2.m10 = f6;
            matrix2f2.m11 = f5;
            return matrix2f2;
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.m00).append(' ').append(this.m10).append(' ').append('\n');
        stringBuilder.append(this.m01).append(' ').append(this.m11).append(' ').append('\n');
        return stringBuilder.toString();
    }

    @Override
    public Matrix negate() {
        return this.negate(this);
    }

    public Matrix2f negate(Matrix2f matrix2f) {
        return Matrix2f.negate(this, matrix2f);
    }

    public static Matrix2f negate(Matrix2f matrix2f, Matrix2f matrix2f2) {
        if (matrix2f2 == null) {
            matrix2f2 = new Matrix2f();
        }
        matrix2f2.m00 = -matrix2f.m00;
        matrix2f2.m01 = -matrix2f.m01;
        matrix2f2.m10 = -matrix2f.m10;
        matrix2f2.m11 = -matrix2f.m11;
        return matrix2f2;
    }

    @Override
    public Matrix setIdentity() {
        return Matrix2f.setIdentity(this);
    }

    public static Matrix2f setIdentity(Matrix2f matrix2f) {
        matrix2f.m00 = 1.0f;
        matrix2f.m01 = 0.0f;
        matrix2f.m10 = 0.0f;
        matrix2f.m11 = 1.0f;
        return matrix2f;
    }

    @Override
    public Matrix setZero() {
        return Matrix2f.setZero(this);
    }

    public static Matrix2f setZero(Matrix2f matrix2f) {
        matrix2f.m00 = 0.0f;
        matrix2f.m01 = 0.0f;
        matrix2f.m10 = 0.0f;
        matrix2f.m11 = 0.0f;
        return matrix2f;
    }

    @Override
    public float determinant() {
        return this.m00 * this.m11 - this.m01 * this.m10;
    }
}

