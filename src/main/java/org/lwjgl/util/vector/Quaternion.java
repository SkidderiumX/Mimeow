/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.vector;

import java.nio.FloatBuffer;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.ReadableVector4f;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector4f;

public class Quaternion
extends Vector
implements ReadableVector4f {
    private static final long serialVersionUID = 1L;
    public float x;
    public float y;
    public float z;
    public float w;

    public Quaternion() {
        this.setIdentity();
    }

    public Quaternion(ReadableVector4f readableVector4f) {
        this.set(readableVector4f);
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        this.set(f, f2, f3, f4);
    }

    public void set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public void set(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public void set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public Quaternion set(ReadableVector4f readableVector4f) {
        this.x = readableVector4f.getX();
        this.y = readableVector4f.getY();
        this.z = readableVector4f.getZ();
        this.w = readableVector4f.getW();
        return this;
    }

    public Quaternion setIdentity() {
        return Quaternion.setIdentity(this);
    }

    public static Quaternion setIdentity(Quaternion quaternion) {
        quaternion.x = 0.0f;
        quaternion.y = 0.0f;
        quaternion.z = 0.0f;
        quaternion.w = 1.0f;
        return quaternion;
    }

    @Override
    public float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }

    public static Quaternion normalise(Quaternion quaternion, Quaternion quaternion2) {
        float f = 1.0f / quaternion.length();
        if (quaternion2 == null) {
            quaternion2 = new Quaternion();
        }
        quaternion2.set(quaternion.x * f, quaternion.y * f, quaternion.z * f, quaternion.w * f);
        return quaternion2;
    }

    public Quaternion normalise(Quaternion quaternion) {
        return Quaternion.normalise(this, quaternion);
    }

    public static float dot(Quaternion quaternion, Quaternion quaternion2) {
        return quaternion.x * quaternion2.x + quaternion.y * quaternion2.y + quaternion.z * quaternion2.z + quaternion.w * quaternion2.w;
    }

    public Quaternion negate(Quaternion quaternion) {
        return Quaternion.negate(this, quaternion);
    }

    public static Quaternion negate(Quaternion quaternion, Quaternion quaternion2) {
        if (quaternion2 == null) {
            quaternion2 = new Quaternion();
        }
        quaternion2.x = -quaternion.x;
        quaternion2.y = -quaternion.y;
        quaternion2.z = -quaternion.z;
        quaternion2.w = quaternion.w;
        return quaternion2;
    }

    @Override
    public Vector negate() {
        return Quaternion.negate(this, this);
    }

    @Override
    public Vector load(FloatBuffer floatBuffer) {
        this.x = floatBuffer.get();
        this.y = floatBuffer.get();
        this.z = floatBuffer.get();
        this.w = floatBuffer.get();
        return this;
    }

    @Override
    public Vector scale(float f) {
        return Quaternion.scale(f, this, this);
    }

    public static Quaternion scale(float f, Quaternion quaternion, Quaternion quaternion2) {
        if (quaternion2 == null) {
            quaternion2 = new Quaternion();
        }
        quaternion2.x = quaternion.x * f;
        quaternion2.y = quaternion.y * f;
        quaternion2.z = quaternion.z * f;
        quaternion2.w = quaternion.w * f;
        return quaternion2;
    }

    @Override
    public Vector store(FloatBuffer floatBuffer) {
        floatBuffer.put(this.x);
        floatBuffer.put(this.y);
        floatBuffer.put(this.z);
        floatBuffer.put(this.w);
        return this;
    }

    @Override
    public final float getX() {
        return this.x;
    }

    @Override
    public final float getY() {
        return this.y;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final void setY(float f) {
        this.y = f;
    }

    public void setZ(float f) {
        this.z = f;
    }

    @Override
    public float getZ() {
        return this.z;
    }

    public void setW(float f) {
        this.w = f;
    }

    @Override
    public float getW() {
        return this.w;
    }

    public String toString() {
        return "Quaternion: " + this.x + " " + this.y + " " + this.z + " " + this.w;
    }

    public static Quaternion mul(Quaternion quaternion, Quaternion quaternion2, Quaternion quaternion3) {
        if (quaternion3 == null) {
            quaternion3 = new Quaternion();
        }
        quaternion3.set(quaternion.x * quaternion2.w + quaternion.w * quaternion2.x + quaternion.y * quaternion2.z - quaternion.z * quaternion2.y, quaternion.y * quaternion2.w + quaternion.w * quaternion2.y + quaternion.z * quaternion2.x - quaternion.x * quaternion2.z, quaternion.z * quaternion2.w + quaternion.w * quaternion2.z + quaternion.x * quaternion2.y - quaternion.y * quaternion2.x, quaternion.w * quaternion2.w - quaternion.x * quaternion2.x - quaternion.y * quaternion2.y - quaternion.z * quaternion2.z);
        return quaternion3;
    }

    public static Quaternion mulInverse(Quaternion quaternion, Quaternion quaternion2, Quaternion quaternion3) {
        float f = quaternion2.lengthSquared();
        float f2 = f = (double)f == 0.0 ? f : 1.0f / f;
        if (quaternion3 == null) {
            quaternion3 = new Quaternion();
        }
        quaternion3.set((quaternion.x * quaternion2.w - quaternion.w * quaternion2.x - quaternion.y * quaternion2.z + quaternion.z * quaternion2.y) * f, (quaternion.y * quaternion2.w - quaternion.w * quaternion2.y - quaternion.z * quaternion2.x + quaternion.x * quaternion2.z) * f, (quaternion.z * quaternion2.w - quaternion.w * quaternion2.z - quaternion.x * quaternion2.y + quaternion.y * quaternion2.x) * f, (quaternion.w * quaternion2.w + quaternion.x * quaternion2.x + quaternion.y * quaternion2.y + quaternion.z * quaternion2.z) * f);
        return quaternion3;
    }

    public final void setFromAxisAngle(Vector4f vector4f) {
        this.x = vector4f.x;
        this.y = vector4f.y;
        this.z = vector4f.z;
        float f = (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        float f2 = (float)(Math.sin(0.5 * (double)vector4f.w) / (double)f);
        this.x *= f2;
        this.y *= f2;
        this.z *= f2;
        this.w = (float)Math.cos(0.5 * (double)vector4f.w);
    }

    public final Quaternion setFromMatrix(Matrix4f matrix4f) {
        return Quaternion.setFromMatrix(matrix4f, this);
    }

    public static Quaternion setFromMatrix(Matrix4f matrix4f, Quaternion quaternion) {
        return quaternion.setFromMat(matrix4f.m00, matrix4f.m01, matrix4f.m02, matrix4f.m10, matrix4f.m11, matrix4f.m12, matrix4f.m20, matrix4f.m21, matrix4f.m22);
    }

    public final Quaternion setFromMatrix(Matrix3f matrix3f) {
        return Quaternion.setFromMatrix(matrix3f, this);
    }

    public static Quaternion setFromMatrix(Matrix3f matrix3f, Quaternion quaternion) {
        return quaternion.setFromMat(matrix3f.m00, matrix3f.m01, matrix3f.m02, matrix3f.m10, matrix3f.m11, matrix3f.m12, matrix3f.m20, matrix3f.m21, matrix3f.m22);
    }

    private Quaternion setFromMat(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f + f5 + f9;
        if ((double)f10 >= 0.0) {
            float f11 = (float)Math.sqrt((double)f10 + 1.0);
            this.w = f11 * 0.5f;
            f11 = 0.5f / f11;
            this.x = (f8 - f6) * f11;
            this.y = (f3 - f7) * f11;
            this.z = (f4 - f2) * f11;
        } else {
            float f12 = Math.max(Math.max(f, f5), f9);
            if (f12 == f) {
                float f13 = (float)Math.sqrt((double)(f - (f5 + f9)) + 1.0);
                this.x = f13 * 0.5f;
                f13 = 0.5f / f13;
                this.y = (f2 + f4) * f13;
                this.z = (f7 + f3) * f13;
                this.w = (f8 - f6) * f13;
            } else if (f12 == f5) {
                float f14 = (float)Math.sqrt((double)(f5 - (f9 + f)) + 1.0);
                this.y = f14 * 0.5f;
                f14 = 0.5f / f14;
                this.z = (f6 + f8) * f14;
                this.x = (f2 + f4) * f14;
                this.w = (f3 - f7) * f14;
            } else {
                float f15 = (float)Math.sqrt((double)(f9 - (f + f5)) + 1.0);
                this.z = f15 * 0.5f;
                f15 = 0.5f / f15;
                this.x = (f7 + f3) * f15;
                this.y = (f6 + f8) * f15;
                this.w = (f4 - f2) * f15;
            }
        }
        return this;
    }
}

