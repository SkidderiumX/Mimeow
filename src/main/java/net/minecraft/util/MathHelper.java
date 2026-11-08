/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.Random;
import java.util.UUID;
import net.minecraft.util.Vec3i;
import net.optifine.util.MathUtils;
import x.oc5f6ebca44f;

public class MathHelper {
    public static final float SQRT_2;
    private static final int SIN_BITS = 12;
    private static final int SIN_MASK = 4095;
    private static final int SIN_COUNT = 4096;
    private static final int SIN_COUNT_D4 = 1024;
    public static final float PI;
    public static final float PI2;
    public static final float PId2;
    private static final float radToIndex;
    public static final float deg2Rad;
    private static final float[] SIN_TABLE_FAST;
    public static boolean fastMath;
    private static float[] SIN_TABLE;
    private static final int[] multiplyDeBruijnBitPosition;
    private static final double field_181163_d;
    private static final double[] field_181164_e;
    private static final double[] field_181165_f;

    public static float sin(float f) {
        return fastMath ? SIN_TABLE_FAST[(int)(f * radToIndex) & 0xFFF] : oc5f6ebca44f.\u03c1(f);
    }

    public static float cos(float f) {
        return fastMath ? SIN_TABLE_FAST[(int)(f * radToIndex + 1024.0f) & 0xFFF] : oc5f6ebca44f.\u024a(f);
    }

    public static float sqrt_float(float f) {
        return (float)Math.sqrt(f);
    }

    public static float sqrt_double(double d) {
        return (float)Math.sqrt(d);
    }

    public static int floor_float(float f) {
        int n = (int)f;
        return f < (float)n ? n - 1 : n;
    }

    public static int truncateDoubleToInt(double d) {
        return (int)(d + 1024.0) - 1024;
    }

    public static int floor_double(double d) {
        int n = (int)d;
        return d < (double)n ? n - 1 : n;
    }

    public static long floor_double_long(double d) {
        long l = (long)d;
        return d < (double)l ? l - 1L : l;
    }

    public static int func_154353_e(double d) {
        return (int)(d >= 0.0 ? d : -d + 1.0);
    }

    public static float abs(float f) {
        return f >= 0.0f ? f : -f;
    }

    public static int abs_int(int n) {
        return n >= 0 ? n : -n;
    }

    public static int ceiling_float_int(float f) {
        int n = (int)f;
        return f > (float)n ? n + 1 : n;
    }

    public static int ceiling_double_int(double d) {
        int n = (int)d;
        return d > (double)n ? n + 1 : n;
    }

    public static int clamp_int(int n, int n2, int n3) {
        return n < n2 ? n2 : (n > n3 ? n3 : n);
    }

    public static float clamp_float(float f, float f2, float f3) {
        return f < f2 ? f2 : (f > f3 ? f3 : f);
    }

    public static double clamp_double(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    public static double denormalizeClamp(double d, double d2, double d3) {
        return d3 < 0.0 ? d : (d3 > 1.0 ? d2 : d + (d2 - d) * d3);
    }

    public static double abs_max(double d, double d2) {
        if (d < 0.0) {
            d = -d;
        }
        if (d2 < 0.0) {
            d2 = -d2;
        }
        return d > d2 ? d : d2;
    }

    public static int bucketInt(int n, int n2) {
        return n < 0 ? -((-n - 1) / n2) - 1 : n / n2;
    }

    public static int getRandomIntegerInRange(Random random, int n, int n2) {
        return n >= n2 ? n : random.nextInt(n2 - n + 1) + n;
    }

    public static float randomFloatClamp(Random random, float f, float f2) {
        return f >= f2 ? f : random.nextFloat() * (f2 - f) + f;
    }

    public static double getRandomDoubleInRange(Random random, double d, double d2) {
        return d >= d2 ? d : random.nextDouble() * (d2 - d) + d;
    }

    public static double average(long[] lArray) {
        long l = 0L;
        for (long l2 : lArray) {
            l += l2;
        }
        return (double)l / (double)lArray.length;
    }

    public static boolean epsilonEquals(float f, float f2) {
        return MathHelper.abs(f2 - f) < 1.0E-5f;
    }

    public static int normalizeAngle(int n, int n2) {
        return (n % n2 + n2) % n2;
    }

    public static float wrapAngleTo180_float(float f) {
        if ((f %= 360.0f) >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static double wrapAngleTo180_double(double d) {
        if ((d %= 360.0) >= 180.0) {
            d -= 360.0;
        }
        if (d < -180.0) {
            d += 360.0;
        }
        return d;
    }

    public static int parseIntWithDefault(String string, int n) {
        try {
            return Integer.parseInt(string);
        }
        catch (Throwable throwable) {
            return n;
        }
    }

    public static int parseIntWithDefaultAndMax(String string, int n, int n2) {
        return Math.max(n2, MathHelper.parseIntWithDefault(string, n));
    }

    public static double parseDoubleWithDefault(String string, double d) {
        try {
            return Double.parseDouble(string);
        }
        catch (Throwable throwable) {
            return d;
        }
    }

    public static double parseDoubleWithDefaultAndMax(String string, double d, double d2) {
        return Math.max(d2, MathHelper.parseDoubleWithDefault(string, d));
    }

    public static int roundUpToPowerOfTwo(int n) {
        int n2 = n - 1;
        n2 |= n2 >> 1;
        n2 |= n2 >> 2;
        n2 |= n2 >> 4;
        n2 |= n2 >> 8;
        n2 |= n2 >> 16;
        return n2 + 1;
    }

    private static boolean isPowerOfTwo(int n) {
        return n != 0 && (n & n - 1) == 0;
    }

    private static int calculateLogBaseTwoDeBruijn(int n) {
        n = MathHelper.isPowerOfTwo(n) ? n : MathHelper.roundUpToPowerOfTwo(n);
        return multiplyDeBruijnBitPosition[(int)((long)n * 125613361L >> 27) & 0x1F];
    }

    public static int calculateLogBaseTwo(int n) {
        return MathHelper.calculateLogBaseTwoDeBruijn(n) - (MathHelper.isPowerOfTwo(n) ? 0 : 1);
    }

    public static int roundUp(int n, int n2) {
        int n3;
        if (n2 == 0) {
            return 0;
        }
        if (n == 0) {
            return n2;
        }
        if (n < 0) {
            n2 *= -1;
        }
        return (n3 = n % n2) == 0 ? n : n + n2 - n3;
    }

    public static int func_180183_b(float f, float f2, float f3) {
        return MathHelper.func_180181_b(MathHelper.floor_float(f * 255.0f), MathHelper.floor_float(f2 * 255.0f), MathHelper.floor_float(f3 * 255.0f));
    }

    public static int func_180181_b(int n, int n2, int n3) {
        int n4 = (n << 8) + n2;
        n4 = (n4 << 8) + n3;
        return n4;
    }

    public static int func_180188_d(int n, int n2) {
        int n3 = (n & 0xFF0000) >> 16;
        int n4 = (n2 & 0xFF0000) >> 16;
        int n5 = (n & 0xFF00) >> 8;
        int n6 = (n2 & 0xFF00) >> 8;
        int n7 = (n & 0xFF) >> 0;
        int n8 = (n2 & 0xFF) >> 0;
        int n9 = (int)((float)n3 * (float)n4 / 255.0f);
        int n10 = (int)((float)n5 * (float)n6 / 255.0f);
        int n11 = (int)((float)n7 * (float)n8 / 255.0f);
        return n & 0xFF000000 | n9 << 16 | n10 << 8 | n11;
    }

    public static double func_181162_h(double d) {
        return d - Math.floor(d);
    }

    public static long getPositionRandom(Vec3i vec3i) {
        return MathHelper.getCoordinateRandom(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    public static long getCoordinateRandom(int n, int n2, int n3) {
        long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
        l = l * l * 42317861L + l * 11L;
        return l;
    }

    public static UUID getRandomUuid(Random random) {
        long l = random.nextLong() & 0xFFFFFFFFFFFF0FFFL | 0x4000L;
        long l2 = random.nextLong() & 0x3FFFFFFFFFFFFFFFL | Long.MIN_VALUE;
        return new UUID(l, l2);
    }

    public static double func_181160_c(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }

    public static double atan2(double d, double d2) {
        double d3;
        boolean bl;
        boolean bl2;
        boolean bl3;
        double d4 = d2 * d2 + d * d;
        if (Double.isNaN(d4)) {
            return Double.NaN;
        }
        boolean bl4 = bl3 = d < 0.0;
        if (bl3) {
            d = -d;
        }
        boolean bl5 = bl2 = d2 < 0.0;
        if (bl2) {
            d2 = -d2;
        }
        boolean bl6 = bl = d > d2;
        if (bl) {
            d3 = d2;
            d2 = d;
            d = d3;
        }
        d3 = MathHelper.func_181161_i(d4);
        d2 *= d3;
        double d5 = field_181163_d + (d *= d3);
        int n = (int)Double.doubleToRawLongBits(d5);
        double d6 = field_181164_e[n];
        double d7 = field_181165_f[n];
        double d8 = d5 - field_181163_d;
        double d9 = d * d7 - d2 * d8;
        double d10 = (6.0 + d9 * d9) * d9 * 0.16666666666666666;
        double d11 = d6 + d10;
        if (bl) {
            d11 = 1.5707963267948966 - d11;
        }
        if (bl2) {
            d11 = Math.PI - d11;
        }
        if (bl3) {
            d11 = -d11;
        }
        return d11;
    }

    public static double func_181161_i(double d) {
        double d2 = 0.5 * d;
        long l = Double.doubleToRawLongBits(d);
        l = 6910469410427058090L - (l >> 1);
        d = Double.longBitsToDouble(l);
        d *= 1.5 - d2 * d * d;
        return d;
    }

    public static int hsvToRGB(float f, float f2, float f3) {
        float f4;
        float f5;
        int n = (int)(f * 6.0f) % 6;
        float f6 = f * 6.0f - (float)n;
        float f7 = f3 * (1.0f - f2);
        float f8 = f3 * (1.0f - f6 * f2);
        float f9 = f3 * (1.0f - (1.0f - f6) * f2);
        float f10 = switch (n) {
            case 0 -> {
                f5 = f3;
                f4 = f9;
                yield f7;
            }
            case 1 -> {
                f5 = f8;
                f4 = f3;
                yield f7;
            }
            case 2 -> {
                f5 = f7;
                f4 = f3;
                yield f9;
            }
            case 3 -> {
                f5 = f7;
                f4 = f8;
                yield f3;
            }
            case 4 -> {
                f5 = f9;
                f4 = f7;
                yield f3;
            }
            case 5 -> {
                f5 = f3;
                f4 = f7;
                yield f8;
            }
            default -> throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + f + ", " + f2 + ", " + f3);
        };
        int n2 = MathHelper.clamp_int((int)(f5 * 255.0f), 0, 255);
        int n3 = MathHelper.clamp_int((int)(f4 * 255.0f), 0, 255);
        int n4 = MathHelper.clamp_int((int)(f10 * 255.0f), 0, 255);
        return n2 << 16 | n3 << 8 | n4;
    }

    static {
        int n;
        SQRT_2 = MathHelper.sqrt_float(2.0f);
        PI = MathUtils.roundToFloat(Math.PI);
        PI2 = MathUtils.roundToFloat(Math.PI * 2);
        PId2 = MathUtils.roundToFloat(1.5707963267948966);
        radToIndex = MathUtils.roundToFloat(651.8986469044033);
        deg2Rad = MathUtils.roundToFloat(Math.PI / 180);
        SIN_TABLE_FAST = new float[4096];
        fastMath = false;
        SIN_TABLE = new float[65536];
        for (n = 0; n < 65536; ++n) {
            MathHelper.SIN_TABLE[n] = (float)Math.sin((double)n * Math.PI * 2.0 / 65536.0);
        }
        oc5f6ebca44f.\u0539(SIN_TABLE);
        SIN_TABLE = null;
        for (n = 0; n < SIN_TABLE_FAST.length; ++n) {
            MathHelper.SIN_TABLE_FAST[n] = MathUtils.roundToFloat(Math.sin((double)n * Math.PI * 2.0 / 4096.0));
        }
        multiplyDeBruijnBitPosition = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
        field_181163_d = Double.longBitsToDouble(4805340802404319232L);
        field_181164_e = new double[257];
        field_181165_f = new double[257];
        for (n = 0; n < 257; ++n) {
            double d = (double)n / 256.0;
            double d2 = Math.asin(d);
            MathHelper.field_181165_f[n] = Math.cos(d2);
            MathHelper.field_181164_e[n] = d2;
        }
    }
}

