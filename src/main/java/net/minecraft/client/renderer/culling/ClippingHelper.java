/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.culling;

public class ClippingHelper {
    public float[][] frustum = new float[6][4];
    public float[] projectionMatrix = new float[16];
    public float[] modelviewMatrix = new float[16];
    public float[] clippingMatrix = new float[16];
    public boolean disabled = false;

    private float dot(float[] fArray, float f, float f2, float f3) {
        return fArray[0] * f + fArray[1] * f2 + fArray[2] * f3 + fArray[3];
    }

    public boolean isBoxInFrustum(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.disabled) {
            return true;
        }
        float f = (float)d;
        float f2 = (float)d2;
        float f3 = (float)d3;
        float f4 = (float)d4;
        float f5 = (float)d5;
        float f6 = (float)d6;
        for (int i = 0; i < 6; ++i) {
            float[] fArray = this.frustum[i];
            float f7 = fArray[0];
            float f8 = fArray[1];
            float f9 = fArray[2];
            float f10 = f7 * (f7 < 0.0f ? f : f4) + f8 * (f8 < 0.0f ? f2 : f5);
            float f11 = f9 < 0.0f ? f3 : f6;
            if (!(f10 + f9 * f11 + fArray[3] <= 0.0f)) continue;
            return false;
        }
        return true;
    }

    public boolean isBoxInFrustumFully(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.disabled) {
            return true;
        }
        float f = (float)d;
        float f2 = (float)d2;
        float f3 = (float)d3;
        float f4 = (float)d4;
        float f5 = (float)d5;
        float f6 = (float)d6;
        for (int i = 0; i < 6; ++i) {
            float f7;
            float f8;
            float f9;
            float[] fArray = this.frustum[i];
            float f10 = fArray[0];
            float f11 = fArray[1];
            float f12 = fArray[2];
            float f13 = i < 4 ? (f10 < 0.0f ? f4 : f) : (f9 = f10 < 0.0f ? f : f4);
            float f14 = i < 4 ? (f11 < 0.0f ? f5 : f2) : (f8 = f11 < 0.0f ? f2 : f5);
            float f15 = i < 4 ? (f12 < 0.0f ? f6 : f3) : (f7 = f12 < 0.0f ? f3 : f6);
            if (!(f10 * f9 + f11 * f8 + f12 * f7 + fArray[3] <= 0.0f)) continue;
            return false;
        }
        return true;
    }
}

