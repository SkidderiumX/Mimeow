/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc3004491957 {
    private oc3004491957() {
    }

    public static float \u0112(float f, float f2) {
        int n = Float.floatToRawIntBits(f) & (0x736F707D ^ 0xC908F82);
        int n2 = Float.floatToRawIntBits(f2) & (0x736F707D ^ 0xC908F82);
        if (n == (0x73108F82 ^ 0xC908F82) || n2 == (0x73108F82 ^ 0xC908F82)) {
            return Float.POSITIVE_INFINITY;
        }
        if (n <= (0x73108F82 ^ 0xC908F82) && n2 <= (0x73108F82 ^ 0xC908F82)) {
            double d = f;
            double d2 = f2;
            return (float)Math.sqrt(d * d + d2 * d2);
        }
        return Float.NaN;
    }

    public static int \u0182(float f) {
        return !Float.isNaN(f) && !(f >= 2.14748365E9f) && !(f < -2.14748365E9f) ? (int)f : 0xEF5C22D3 ^ 0x6F5C22D3;
    }

    public static int \u043e(double d) {
        return !Double.isNaN(d) && !(d >= 2.147483648E9) && !(d < -2.147483648E9) ? (int)d : 0xAB064DD ^ 0x8AB064DD;
    }

    public static long \u0462(float f) {
        return !Float.isNaN(f) && !((double)f >= 9.223372036854776E18) && !((double)f < -9.223372036854776E18) ? (long)f : 0x2D0C6EC934ACEC27L ^ 0xAD0C6EC934ACEC27L;
    }

    public static long \u03d5(double d) {
        return !Double.isNaN(d) && !(d >= 9.223372036854776E18) && !(d < -9.223372036854776E18) ? (long)d : 0x9D9C9EC582D84C99L ^ 0x1D9C9EC582D84C99L;
    }

    public static float \u0434(float f) {
        int n = Float.floatToRawIntBits(f);
        int n2 = n >>> (0x767F51A3 ^ 0x767F51B4) & (0x767F514B ^ 0x767F51B4);
        if (n2 >= (0x767F5122 ^ 0x767F51B4)) {
            return f;
        }
        if (n2 >= (0x767F51CB ^ 0x767F51B4)) {
            int n3 = -1 << ((0x767F51A2 ^ 0x767F51B4) - (n >>> (0x767F51A3 ^ 0x767F51B4)) & (0x767F51AB ^ 0x767F51B4));
            int n4 = ~n3;
            return (n & n4) == 0 ? f : Float.intBitsToFloat(n + (n < 0 ? 0 : n4) & n3);
        }
        return Float.intBitsToFloat(n < 0 ? 0xF67F51B4 ^ 0x767F51B4 : (n == 0 ? 0 : 0x49FF51B4 ^ 0x767F51B4));
    }
}

