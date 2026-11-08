/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import net.minecraft.util.MathHelper;

public class MathUtils {
    public static final float PI = (float)Math.PI;
    public static final float PI2 = (float)Math.PI * 2;
    public static final float PId2 = 1.5707964f;
    private static final float[] ASIN_TABLE;

    public static float asin(float f) {
        return ASIN_TABLE[(int)((double)(f + 1.0f) * 32767.5) & 0xFFFF];
    }

    public static float acos(float f) {
        return 1.5707964f - ASIN_TABLE[(int)((double)(f + 1.0f) * 32767.5) & 0xFFFF];
    }

    public static int getAverage(int[] nArray) {
        if (nArray.length <= 0) {
            return 0;
        }
        int n = MathUtils.getSum(nArray);
        int n2 = n / nArray.length;
        return n2;
    }

    public static int getSum(int[] nArray) {
        if (nArray.length <= 0) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < nArray.length; ++i) {
            int n2 = nArray[i];
            n += n2;
        }
        return n;
    }

    public static int roundDownToPowerOfTwo(int n) {
        int n2 = MathHelper.roundUpToPowerOfTwo(n);
        return n == n2 ? n2 : n2 / 2;
    }

    public static boolean equalsDelta(float f, float f2, float f3) {
        return Math.abs(f - f2) <= f3;
    }

    public static float toDeg(float f) {
        return f * 180.0f / MathHelper.PI;
    }

    public static float toRad(float f) {
        return f / 180.0f * MathHelper.PI;
    }

    public static float roundToFloat(double d) {
        return (float)((double)Math.round(d * 1.0E8) / 1.0E8);
    }

    static {
        int n;
        ASIN_TABLE = new float[65536];
        for (n = 0; n < 65536; ++n) {
            MathUtils.ASIN_TABLE[n] = (float)Math.asin((double)n / 32767.5 - 1.0);
        }
        for (n = -1; n < 2; ++n) {
            MathUtils.ASIN_TABLE[(int)(((double)n + 1.0) * 32767.5) & 0xFFFF] = (float)Math.asin(n);
        }
    }
}

