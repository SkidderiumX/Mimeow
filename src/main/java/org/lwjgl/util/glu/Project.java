/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Util;

public class Project
extends Util {
    private static final float[] IDENTITY_MATRIX = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final FloatBuffer matrix = BufferUtils.createFloatBuffer(16);
    private static final FloatBuffer finalMatrix = BufferUtils.createFloatBuffer(16);
    private static final FloatBuffer tempMatrix = BufferUtils.createFloatBuffer(16);
    private static final float[] in = new float[4];
    private static final float[] out = new float[4];
    private static final float[] forward = new float[3];
    private static final float[] side = new float[3];
    private static final float[] up = new float[3];

    private static void __gluMakeIdentityf(FloatBuffer floatBuffer) {
        int n = floatBuffer.position();
        floatBuffer.put(IDENTITY_MATRIX);
        floatBuffer.position(n);
    }

    private static void __gluMultMatrixVecf(FloatBuffer floatBuffer, float[] fArray, float[] fArray2) {
        for (int i = 0; i < 4; ++i) {
            fArray2[i] = fArray[0] * floatBuffer.get(floatBuffer.position() + 0 + i) + fArray[1] * floatBuffer.get(floatBuffer.position() + 4 + i) + fArray[2] * floatBuffer.get(floatBuffer.position() + 8 + i) + fArray[3] * floatBuffer.get(floatBuffer.position() + 12 + i);
        }
    }

    private static boolean __gluInvertMatrixf(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int n;
        FloatBuffer floatBuffer3 = tempMatrix;
        for (n = 0; n < 16; ++n) {
            floatBuffer3.put(n, floatBuffer.get(n + floatBuffer.position()));
        }
        Project.__gluMakeIdentityf(floatBuffer2);
        for (n = 0; n < 4; ++n) {
            float f;
            int n2;
            int n3;
            int n4 = n;
            for (n3 = n + 1; n3 < 4; ++n3) {
                if (!(Math.abs(floatBuffer3.get(n3 * 4 + n)) > Math.abs(floatBuffer3.get(n * 4 + n)))) continue;
                n4 = n3;
            }
            if (n4 != n) {
                for (n2 = 0; n2 < 4; ++n2) {
                    f = floatBuffer3.get(n * 4 + n2);
                    floatBuffer3.put(n * 4 + n2, floatBuffer3.get(n4 * 4 + n2));
                    floatBuffer3.put(n4 * 4 + n2, f);
                    f = floatBuffer2.get(n * 4 + n2);
                    floatBuffer2.put(n * 4 + n2, floatBuffer2.get(n4 * 4 + n2));
                    floatBuffer2.put(n4 * 4 + n2, f);
                }
            }
            if (floatBuffer3.get(n * 4 + n) == 0.0f) {
                return false;
            }
            f = floatBuffer3.get(n * 4 + n);
            for (n2 = 0; n2 < 4; ++n2) {
                floatBuffer3.put(n * 4 + n2, floatBuffer3.get(n * 4 + n2) / f);
                floatBuffer2.put(n * 4 + n2, floatBuffer2.get(n * 4 + n2) / f);
            }
            for (n3 = 0; n3 < 4; ++n3) {
                if (n3 == n) continue;
                f = floatBuffer3.get(n3 * 4 + n);
                for (n2 = 0; n2 < 4; ++n2) {
                    floatBuffer3.put(n3 * 4 + n2, floatBuffer3.get(n3 * 4 + n2) - floatBuffer3.get(n * 4 + n2) * f);
                    floatBuffer2.put(n3 * 4 + n2, floatBuffer2.get(n3 * 4 + n2) - floatBuffer2.get(n * 4 + n2) * f);
                }
            }
        }
        return true;
    }

    private static void __gluMultMatricesf(FloatBuffer floatBuffer, FloatBuffer floatBuffer2, FloatBuffer floatBuffer3) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                floatBuffer3.put(floatBuffer3.position() + i * 4 + j, floatBuffer.get(floatBuffer.position() + i * 4 + 0) * floatBuffer2.get(floatBuffer2.position() + 0 + j) + floatBuffer.get(floatBuffer.position() + i * 4 + 1) * floatBuffer2.get(floatBuffer2.position() + 4 + j) + floatBuffer.get(floatBuffer.position() + i * 4 + 2) * floatBuffer2.get(floatBuffer2.position() + 8 + j) + floatBuffer.get(floatBuffer.position() + i * 4 + 3) * floatBuffer2.get(floatBuffer2.position() + 12 + j));
            }
        }
    }

    public static void gluPerspective(float f, float f2, float f3, float f4) {
        float f5 = f / 2.0f * (float)Math.PI / 180.0f;
        float f6 = f4 - f3;
        float f7 = (float)Math.sin(f5);
        if (f6 == 0.0f || f7 == 0.0f || f2 == 0.0f) {
            return;
        }
        float f8 = (float)Math.cos(f5) / f7;
        Project.__gluMakeIdentityf(matrix);
        matrix.put(0, f8 / f2);
        matrix.put(5, f8);
        matrix.put(10, -(f4 + f3) / f6);
        matrix.put(11, -1.0f);
        matrix.put(14, -2.0f * f3 * f4 / f6);
        matrix.put(15, 0.0f);
        GL11.glMultMatrixf(matrix);
    }

    public static void gluLookAt(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float[] fArray = forward;
        float[] fArray2 = side;
        float[] fArray3 = up;
        fArray[0] = f4 - f;
        fArray[1] = f5 - f2;
        fArray[2] = f6 - f3;
        fArray3[0] = f7;
        fArray3[1] = f8;
        fArray3[2] = f9;
        Project.normalize(fArray);
        Project.cross(fArray, fArray3, fArray2);
        Project.normalize(fArray2);
        Project.cross(fArray2, fArray, fArray3);
        Project.__gluMakeIdentityf(matrix);
        matrix.put(0, fArray2[0]);
        matrix.put(4, fArray2[1]);
        matrix.put(8, fArray2[2]);
        matrix.put(1, fArray3[0]);
        matrix.put(5, fArray3[1]);
        matrix.put(9, fArray3[2]);
        matrix.put(2, -fArray[0]);
        matrix.put(6, -fArray[1]);
        matrix.put(10, -fArray[2]);
        GL11.glMultMatrixf(matrix);
        GL11.glTranslatef(-f, -f2, -f3);
    }

    public static boolean gluProject(float f, float f2, float f3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, IntBuffer intBuffer, FloatBuffer floatBuffer3) {
        float[] fArray = in;
        float[] fArray2 = out;
        fArray[0] = f;
        fArray[1] = f2;
        fArray[2] = f3;
        fArray[3] = 1.0f;
        Project.__gluMultMatrixVecf(floatBuffer, fArray, fArray2);
        Project.__gluMultMatrixVecf(floatBuffer2, fArray2, fArray);
        if ((double)fArray[3] == 0.0) {
            return false;
        }
        fArray[3] = 1.0f / fArray[3] * 0.5f;
        fArray[0] = fArray[0] * fArray[3] + 0.5f;
        fArray[1] = fArray[1] * fArray[3] + 0.5f;
        fArray[2] = fArray[2] * fArray[3] + 0.5f;
        floatBuffer3.put(0, fArray[0] * (float)intBuffer.get(intBuffer.position() + 2) + (float)intBuffer.get(intBuffer.position() + 0));
        floatBuffer3.put(1, fArray[1] * (float)intBuffer.get(intBuffer.position() + 3) + (float)intBuffer.get(intBuffer.position() + 1));
        floatBuffer3.put(2, fArray[2]);
        return true;
    }

    public static boolean gluUnProject(float f, float f2, float f3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, IntBuffer intBuffer, FloatBuffer floatBuffer3) {
        float[] fArray = in;
        float[] fArray2 = out;
        Project.__gluMultMatricesf(floatBuffer, floatBuffer2, finalMatrix);
        if (!Project.__gluInvertMatrixf(finalMatrix, finalMatrix)) {
            return false;
        }
        fArray[0] = f;
        fArray[1] = f2;
        fArray[2] = f3;
        fArray[3] = 1.0f;
        fArray[0] = (fArray[0] - (float)intBuffer.get(intBuffer.position() + 0)) / (float)intBuffer.get(intBuffer.position() + 2);
        fArray[1] = (fArray[1] - (float)intBuffer.get(intBuffer.position() + 1)) / (float)intBuffer.get(intBuffer.position() + 3);
        fArray[0] = fArray[0] * 2.0f - 1.0f;
        fArray[1] = fArray[1] * 2.0f - 1.0f;
        fArray[2] = fArray[2] * 2.0f - 1.0f;
        Project.__gluMultMatrixVecf(finalMatrix, fArray, fArray2);
        if ((double)fArray2[3] == 0.0) {
            return false;
        }
        fArray2[3] = 1.0f / fArray2[3];
        floatBuffer3.put(floatBuffer3.position() + 0, fArray2[0] * fArray2[3]);
        floatBuffer3.put(floatBuffer3.position() + 1, fArray2[1] * fArray2[3]);
        floatBuffer3.put(floatBuffer3.position() + 2, fArray2[2] * fArray2[3]);
        return true;
    }

    public static void gluPickMatrix(float f, float f2, float f3, float f4, IntBuffer intBuffer) {
        if (f3 <= 0.0f || f4 <= 0.0f) {
            return;
        }
        GL11.glTranslatef(((float)intBuffer.get(intBuffer.position() + 2) - 2.0f * (f - (float)intBuffer.get(intBuffer.position() + 0))) / f3, ((float)intBuffer.get(intBuffer.position() + 3) - 2.0f * (f2 - (float)intBuffer.get(intBuffer.position() + 1))) / f4, 0.0f);
        GL11.glScalef((float)intBuffer.get(intBuffer.position() + 2) / f3, (float)intBuffer.get(intBuffer.position() + 3) / f4, 1.0f);
    }
}

