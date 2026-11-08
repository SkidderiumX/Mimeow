/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;
import org.lwjgl.util.vector.Matrix;
import org.lwjgl.util.vector.Vector3f;

public class Matrix3f
extends Matrix
implements Serializable {
    private static final long serialVersionUID = 1L;
    public float m00;
    public float m01;
    public float m02;
    public float m10;
    public float m11;
    public float m12;
    public float m20;
    public float m21;
    public float m22;

    public Matrix3f() {
        this.setIdentity();
    }

    public Matrix3f load(Matrix3f matrix3f) {
        return Matrix3f.load(matrix3f, this);
    }

    public static Matrix3f load(Matrix3f matrix3f, Matrix3f matrix3f2) {
        if (matrix3f2 == null) {
            matrix3f2 = new Matrix3f();
        }
        matrix3f2.m00 = matrix3f.m00;
        matrix3f2.m10 = matrix3f.m10;
        matrix3f2.m20 = matrix3f.m20;
        matrix3f2.m01 = matrix3f.m01;
        matrix3f2.m11 = matrix3f.m11;
        matrix3f2.m21 = matrix3f.m21;
        matrix3f2.m02 = matrix3f.m02;
        matrix3f2.m12 = matrix3f.m12;
        matrix3f2.m22 = matrix3f.m22;
        return matrix3f2;
    }

    @Override
    public Matrix load(FloatBuffer floatBuffer) {
        this.m00 = floatBuffer.get();
        this.m01 = floatBuffer.get();
        this.m02 = floatBuffer.get();
        this.m10 = floatBuffer.get();
        this.m11 = floatBuffer.get();
        this.m12 = floatBuffer.get();
        this.m20 = floatBuffer.get();
        this.m21 = floatBuffer.get();
        this.m22 = floatBuffer.get();
        return this;
    }

    @Override
    public Matrix loadTranspose(FloatBuffer floatBuffer) {
        this.m00 = floatBuffer.get();
        this.m10 = floatBuffer.get();
        this.m20 = floatBuffer.get();
        this.m01 = floatBuffer.get();
        this.m11 = floatBuffer.get();
        this.m21 = floatBuffer.get();
        this.m02 = floatBuffer.get();
        this.m12 = floatBuffer.get();
        this.m22 = floatBuffer.get();
        return this;
    }

    @Override
    public Matrix store(FloatBuffer floatBuffer) {
        floatBuffer.put(this.m00);
        floatBuffer.put(this.m01);
        floatBuffer.put(this.m02);
        floatBuffer.put(this.m10);
        floatBuffer.put(this.m11);
        floatBuffer.put(this.m12);
        floatBuffer.put(this.m20);
        floatBuffer.put(this.m21);
        floatBuffer.put(this.m22);
        return this;
    }

    @Override
    public Matrix storeTranspose(FloatBuffer floatBuffer) {
        floatBuffer.put(this.m00);
        floatBuffer.put(this.m10);
        floatBuffer.put(this.m20);
        floatBuffer.put(this.m01);
        floatBuffer.put(this.m11);
        floatBuffer.put(this.m21);
        floatBuffer.put(this.m02);
        floatBuffer.put(this.m12);
        floatBuffer.put(this.m22);
        return this;
    }

    public static Matrix3f add(Matrix3f matrix3f, Matrix3f matrix3f2, Matrix3f matrix3f3) {
        if (matrix3f3 == null) {
            matrix3f3 = new Matrix3f();
        }
        matrix3f3.m00 = matrix3f.m00 + matrix3f2.m00;
        matrix3f3.m01 = matrix3f.m01 + matrix3f2.m01;
        matrix3f3.m02 = matrix3f.m02 + matrix3f2.m02;
        matrix3f3.m10 = matrix3f.m10 + matrix3f2.m10;
        matrix3f3.m11 = matrix3f.m11 + matrix3f2.m11;
        matrix3f3.m12 = matrix3f.m12 + matrix3f2.m12;
        matrix3f3.m20 = matrix3f.m20 + matrix3f2.m20;
        matrix3f3.m21 = matrix3f.m21 + matrix3f2.m21;
        matrix3f3.m22 = matrix3f.m22 + matrix3f2.m22;
        return matrix3f3;
    }

    public static Matrix3f sub(Matrix3f matrix3f, Matrix3f matrix3f2, Matrix3f matrix3f3) {
        if (matrix3f3 == null) {
            matrix3f3 = new Matrix3f();
        }
        matrix3f3.m00 = matrix3f.m00 - matrix3f2.m00;
        matrix3f3.m01 = matrix3f.m01 - matrix3f2.m01;
        matrix3f3.m02 = matrix3f.m02 - matrix3f2.m02;
        matrix3f3.m10 = matrix3f.m10 - matrix3f2.m10;
        matrix3f3.m11 = matrix3f.m11 - matrix3f2.m11;
        matrix3f3.m12 = matrix3f.m12 - matrix3f2.m12;
        matrix3f3.m20 = matrix3f.m20 - matrix3f2.m20;
        matrix3f3.m21 = matrix3f.m21 - matrix3f2.m21;
        matrix3f3.m22 = matrix3f.m22 - matrix3f2.m22;
        return matrix3f3;
    }

    public static Matrix3f mul(Matrix3f matrix3f, Matrix3f matrix3f2, Matrix3f matrix3f3) {
        if (matrix3f3 == null) {
            matrix3f3 = new Matrix3f();
        }
        float f = matrix3f.m00 * matrix3f2.m00 + matrix3f.m10 * matrix3f2.m01 + matrix3f.m20 * matrix3f2.m02;
        float f2 = matrix3f.m01 * matrix3f2.m00 + matrix3f.m11 * matrix3f2.m01 + matrix3f.m21 * matrix3f2.m02;
        float f3 = matrix3f.m02 * matrix3f2.m00 + matrix3f.m12 * matrix3f2.m01 + matrix3f.m22 * matrix3f2.m02;
        float f4 = matrix3f.m00 * matrix3f2.m10 + matrix3f.m10 * matrix3f2.m11 + matrix3f.m20 * matrix3f2.m12;
        float f5 = matrix3f.m01 * matrix3f2.m10 + matrix3f.m11 * matrix3f2.m11 + matrix3f.m21 * matrix3f2.m12;
        float f6 = matrix3f.m02 * matrix3f2.m10 + matrix3f.m12 * matrix3f2.m11 + matrix3f.m22 * matrix3f2.m12;
        float f7 = matrix3f.m00 * matrix3f2.m20 + matrix3f.m10 * matrix3f2.m21 + matrix3f.m20 * matrix3f2.m22;
        float f8 = matrix3f.m01 * matrix3f2.m20 + matrix3f.m11 * matrix3f2.m21 + matrix3f.m21 * matrix3f2.m22;
        float f9 = matrix3f.m02 * matrix3f2.m20 + matrix3f.m12 * matrix3f2.m21 + matrix3f.m22 * matrix3f2.m22;
        matrix3f3.m00 = f;
        matrix3f3.m01 = f2;
        matrix3f3.m02 = f3;
        matrix3f3.m10 = f4;
        matrix3f3.m11 = f5;
        matrix3f3.m12 = f6;
        matrix3f3.m20 = f7;
        matrix3f3.m21 = f8;
        matrix3f3.m22 = f9;
        return matrix3f3;
    }

    public static Vector3f transform(Matrix3f matrix3f, Vector3f vector3f, Vector3f vector3f2) {
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        float f = matrix3f.m00 * vector3f.x + matrix3f.m10 * vector3f.y + matrix3f.m20 * vector3f.z;
        float f2 = matrix3f.m01 * vector3f.x + matrix3f.m11 * vector3f.y + matrix3f.m21 * vector3f.z;
        float f3 = matrix3f.m02 * vector3f.x + matrix3f.m12 * vector3f.y + matrix3f.m22 * vector3f.z;
        vector3f2.x = f;
        vector3f2.y = f2;
        vector3f2.z = f3;
        return vector3f2;
    }

    @Override
    public Matrix transpose() {
        return Matrix3f.transpose(this, this);
    }

    public Matrix3f transpose(Matrix3f matrix3f) {
        return Matrix3f.transpose(this, matrix3f);
    }

    public static Matrix3f transpose(Matrix3f matrix3f, Matrix3f matrix3f2) {
        if (matrix3f2 == null) {
            matrix3f2 = new Matrix3f();
        }
        float f = matrix3f.m00;
        float f2 = matrix3f.m10;
        float f3 = matrix3f.m20;
        float f4 = matrix3f.m01;
        float f5 = matrix3f.m11;
        float f6 = matrix3f.m21;
        float f7 = matrix3f.m02;
        float f8 = matrix3f.m12;
        float f9 = matrix3f.m22;
        matrix3f2.m00 = f;
        matrix3f2.m01 = f2;
        matrix3f2.m02 = f3;
        matrix3f2.m10 = f4;
        matrix3f2.m11 = f5;
        matrix3f2.m12 = f6;
        matrix3f2.m20 = f7;
        matrix3f2.m21 = f8;
        matrix3f2.m22 = f9;
        return matrix3f2;
    }

    @Override
    public float determinant() {
        float f = this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) + this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) + this.m02 * (this.m10 * this.m21 - this.m11 * this.m20);
        return f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.m00).append(' ').append(this.m10).append(' ').append(this.m20).append(' ').append('\n');
        stringBuilder.append(this.m01).append(' ').append(this.m11).append(' ').append(this.m21).append(' ').append('\n');
        stringBuilder.append(this.m02).append(' ').append(this.m12).append(' ').append(this.m22).append(' ').append('\n');
        return stringBuilder.toString();
    }

    @Override
    public Matrix invert() {
        return Matrix3f.invert(this, this);
    }

    public static Matrix3f invert(Matrix3f matrix3f, Matrix3f matrix3f2) {
        float f = matrix3f.determinant();
        if (f != 0.0f) {
            if (matrix3f2 == null) {
                matrix3f2 = new Matrix3f();
            }
            float f2 = 1.0f / f;
            float f3 = matrix3f.m11 * matrix3f.m22 - matrix3f.m12 * matrix3f.m21;
            float f4 = -matrix3f.m10 * matrix3f.m22 + matrix3f.m12 * matrix3f.m20;
            float f5 = matrix3f.m10 * matrix3f.m21 - matrix3f.m11 * matrix3f.m20;
            float f6 = -matrix3f.m01 * matrix3f.m22 + matrix3f.m02 * matrix3f.m21;
            float f7 = matrix3f.m00 * matrix3f.m22 - matrix3f.m02 * matrix3f.m20;
            float f8 = -matrix3f.m00 * matrix3f.m21 + matrix3f.m01 * matrix3f.m20;
            float f9 = matrix3f.m01 * matrix3f.m12 - matrix3f.m02 * matrix3f.m11;
            float f10 = -matrix3f.m00 * matrix3f.m12 + matrix3f.m02 * matrix3f.m10;
            float f11 = matrix3f.m00 * matrix3f.m11 - matrix3f.m01 * matrix3f.m10;
            matrix3f2.m00 = f3 * f2;
            matrix3f2.m11 = f7 * f2;
            matrix3f2.m22 = f11 * f2;
            matrix3f2.m01 = f6 * f2;
            matrix3f2.m10 = f4 * f2;
            matrix3f2.m20 = f5 * f2;
            matrix3f2.m02 = f9 * f2;
            matrix3f2.m12 = f10 * f2;
            matrix3f2.m21 = f8 * f2;
            return matrix3f2;
        }
        return null;
    }

    @Override
    public Matrix negate() {
        return this.negate(this);
    }

    public Matrix3f negate(Matrix3f matrix3f) {
        return Matrix3f.negate(this, matrix3f);
    }

    public static Matrix3f negate(Matrix3f matrix3f, Matrix3f matrix3f2) {
        if (matrix3f2 == null) {
            matrix3f2 = new Matrix3f();
        }
        matrix3f2.m00 = -matrix3f.m00;
        matrix3f2.m01 = -matrix3f.m02;
        matrix3f2.m02 = -matrix3f.m01;
        matrix3f2.m10 = -matrix3f.m10;
        matrix3f2.m11 = -matrix3f.m12;
        matrix3f2.m12 = -matrix3f.m11;
        matrix3f2.m20 = -matrix3f.m20;
        matrix3f2.m21 = -matrix3f.m22;
        matrix3f2.m22 = -matrix3f.m21;
        return matrix3f2;
    }

    @Override
    public Matrix setIdentity() {
        return Matrix3f.setIdentity(this);
    }

    public static Matrix3f setIdentity(Matrix3f matrix3f) {
        matrix3f.m00 = 1.0f;
        matrix3f.m01 = 0.0f;
        matrix3f.m02 = 0.0f;
        matrix3f.m10 = 0.0f;
        matrix3f.m11 = 1.0f;
        matrix3f.m12 = 0.0f;
        matrix3f.m20 = 0.0f;
        matrix3f.m21 = 0.0f;
        matrix3f.m22 = 1.0f;
        return matrix3f;
    }

    @Override
    public Matrix setZero() {
        return Matrix3f.setZero(this);
    }

    public static Matrix3f setZero(Matrix3f matrix3f) {
        matrix3f.m00 = 0.0f;
        matrix3f.m01 = 0.0f;
        matrix3f.m02 = 0.0f;
        matrix3f.m10 = 0.0f;
        matrix3f.m11 = 0.0f;
        matrix3f.m12 = 0.0f;
        matrix3f.m20 = 0.0f;
        matrix3f.m21 = 0.0f;
        matrix3f.m22 = 0.0f;
        return matrix3f;
    }
}

