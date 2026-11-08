/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc3004491957;
import x.ocd8ecc8a91a;

public class oc42b715e79d {
    private oc42b715e79d() {
    }

    private static float \u023d(int n) {
        return ocd8ecc8a91a.\u027e(n);
    }

    private static long \u010b(int n) {
        return (long)n & (0xFFE4EA2EAE108BF2L ^ 0xFFE4EA2E51EF740DL);
    }

    public static float d(float f) {
        int n;
        int n2 = Float.floatToRawIntBits(f);
        if (n2 < (0xF55ECCA5 ^ 0xF5DECCA5)) {
            if (f == 0.0f) {
                return oc42b715e79d.\u023d(0xF5F50851 ^ 0xF5DECCA5) / (f * f);
            }
            if (n2 < 0) {
                return oc42b715e79d.\u0119(f);
            }
            float f2 = f * oc42b715e79d.\u023d(0xF5F50855 ^ 0xF5DECCA5);
            n2 = Float.floatToRawIntBits(f2);
            n = 0xA2133CD ^ 0xF5DECCA5;
        } else {
            if (Integer.compareUnsigned(n2, 0x8AA1335A ^ 0xF5DECCA5) > 0) {
                return f;
            }
            if (n2 == (0xCA5ECCA5 ^ 0xF5DECCA5)) {
                return 0.0f;
            }
            n = 0xA213324 ^ 0xF5DECCA5;
        }
        int n3 = ((n2 += 0xF59437A8 ^ 0xF5DECCA5) >>> (0xF5DECCB2 ^ 0xF5DECCA5)) + n;
        n2 = (n2 & (0xF5A1335A ^ 0xF5DECCA5)) + (0xCAEBC856 ^ 0xF5DECCA5);
        float f3 = Float.intBitsToFloat(n2) + oc42b715e79d.\u023d(0xF5F50851 ^ 0xF5DECCA5);
        float f4 = oc42b715e79d.\u023d(0xF5F5085D ^ 0xF5DECCA5) + f3;
        float f5 = f3 / f4;
        float f6 = f5 * f5;
        float f7 = f6 * f6;
        float f8 = f7 * oc42b715e79d.\u023d(0xF5F509A5 ^ 0xF5DECCA5);
        f8 += oc42b715e79d.\u023d(0xF5F509B5 ^ 0xF5DECCA5);
        float f9 = f7 * oc42b715e79d.\u023d(0xF5F509A1 ^ 0xF5DECCA5);
        f9 += oc42b715e79d.\u023d(0xF5F509B1 ^ 0xF5DECCA5);
        f8 = f6 * f8;
        f9 = f7 * f9;
        float f10 = f9 + f8;
        float f11 = oc42b715e79d.\u023d(0xF5F50985 ^ 0xF5DECCA5) * f3;
        f10 += (f11 *= f3);
        float f12 = n3;
        float f13 = oc42b715e79d.\u023d(0xF5F50981 ^ 0xF5DECCA5) * f12;
        f13 += (f10 *= f5);
        f13 -= f11;
        float f14 = f12 * oc42b715e79d.\u023d(0xF5F5098D ^ 0xF5DECCA5);
        return f14 + (f13 += f3);
    }

    public static float \u0119(float f) {
        int n = Float.floatToRawIntBits(f);
        return Float.intBitsToFloat((n & (0xF3986120 ^ 0x8C679EDF)) > (0xF3E79EDF ^ 0x8C679EDF) ? n | 0x8C279EDF ^ 0x8C679EDF : 0x73A79EDF ^ 0x8C679EDF);
    }

    public static float \u018a(float f) {
        int n = Float.floatToRawIntBits(f);
        if (Integer.compareUnsigned(n - (0xA9F2E5FD ^ 0xD672E5FD), 0x5772E5FD ^ 0xD672E5FD) < 0) {
            if (f == 0.0f || n == (0xA9F2E5FD ^ 0xD672E5FD)) {
                return f;
            }
            if (Integer.compareUnsigned(n, 0xA9F2E5FC ^ 0xD672E5FD) >= 0) {
                return oc42b715e79d.\u0119(f);
            }
            n = Float.floatToRawIntBits(f *= oc42b715e79d.\u023d(0xD65952BD ^ 0xD672E5FD)) + (0x22F2E5FD ^ 0xD672E5FD);
        }
        int n2 = n << (0xD672E5F5 ^ 0xD672E5FD) | 0x5672E5FD ^ 0xD672E5FD;
        if ((n & (0xD6F2E5FD ^ 0xD672E5FD)) != 0) {
            n2 = n << (0xD672E5FA ^ 0xD672E5FD) & (0xA98D1A7D ^ 0xD672E5FD);
        }
        int n3 = (n >>> 1) + (0xC9B2E5FD ^ 0xD672E5FD) & (0xA9F2E5FD ^ 0xD672E5FD);
        long l = (long)ocd8ecc8a91a.\u0575((0xD6593ABD ^ 0xD672E5FD) + (n >>> (0xD672E5ED ^ 0xD672E5FD) & (0xD672E503 ^ 0xD672E5FD))) << (0xD672E5ED ^ 0xD672E5FD);
        long l2 = oc42b715e79d.\u010b(n2) * l >>> (0xD672E5DD ^ 0xD672E5FD);
        long l3 = l2 * l >>> (0xD672E5DD ^ 0xD672E5FD);
        int n4 = (0x1672E5FD ^ 0xD672E5FD) - (int)l3;
        l = oc42b715e79d.\u010b((int)(l * oc42b715e79d.\u010b(n4) >>> (0xD672E5E2 ^ 0xD672E5FD)) & (0x298D1A03 ^ 0xD672E5FD));
        l2 = oc42b715e79d.\u010b((int)(l2 * oc42b715e79d.\u010b(n4) >>> (0xD672E5E2 ^ 0xD672E5FD)) & (0x298D1A03 ^ 0xD672E5FD));
        n4 = (0x1672E5FD ^ 0xD672E5FD) - (int)(l * l2 >>> (0xD672E5DD ^ 0xD672E5FD));
        int n5 = (int)(oc42b715e79d.\u010b(n4) * l2 >>> (0xD672E5DD ^ 0xD672E5FD)) - 1 >>> (0xD672E5FB ^ 0xD672E5FD);
        int n6 = n5 * n5 - (n2 <<= 0xD672E5ED ^ 0xD672E5FD) + n5;
        int n7 = n5 + (n6 >>> (0xD672E5E2 ^ 0xD672E5FD));
        int n8 = n5 + n6;
        float f2 = Float.intBitsToFloat(n3 | n7 & (0xD60D1A02 ^ 0xD672E5FD));
        int n9 = (++n8 == 0 ? 0 : 0xD772E5FD ^ 0xD672E5FD) | (n8 ^ n6) & (0x5672E5FD ^ 0xD672E5FD);
        return f2 + Float.intBitsToFloat(n9);
    }

    public static float \u028f(float f, int n) {
        int n2;
        int n3 = Float.floatToRawIntBits(f);
        int n4 = n3 & (0xD02E7346 ^ 0xAFD18CB9);
        if (n4 >= (0xD0518CB9 ^ 0xAFD18CB9)) {
            return f;
        }
        int n5 = n3 & (0x2FD18CB9 ^ 0xAFD18CB9);
        int n6 = n3 << 1;
        int n7 = n6 >>> (0xAFD18CA1 ^ 0xAFD18CB9);
        if (Integer.compareUnsigned(n6, 0xAED18CB9 ^ 0xAFD18CB9) < 0) {
            n2 = n6 != 0 ? (0xAFD18CA6 ^ 0xAFD18CB9) - Integer.numberOfLeadingZeros(n6) : 0xAFD18C86 ^ 0xAFD18CB9;
            n7 = (n2 ^ (0x502E7359 ^ 0xAFD18CB9)) + (0xAFD18CB0 ^ 0xAFD18CB9);
        }
        if (n >= 0) {
            if (n > (0xAFD18C47 ^ 0xAFD18CB9) - n7) {
                return Float.intBitsToFloat(n5 | ocd8ecc8a91a.K(0xAFFA4419 ^ 0xAFD18CB9));
            }
        } else if (n <= -n7) {
            if (n < (0x502E7350 ^ 0xAFD18CB9) - n7) {
                return Float.intBitsToFloat(n5);
            }
            n2 = Math.min(-n, 1 - (n + n7)) - 1 & (0xAFD18CA6 ^ 0xAFD18CB9);
            int n8 = Integer.numberOfTrailingZeros(n3) == n2 ? 1 : 0;
            int n9 = n3 & (0xAFAE7346 ^ 0xAFD18CB9) | (n7 > 0 ? 0xAF518CB9 ^ 0xAFD18CB9 : 0);
            int n10 = (n9 >>> n2) + 1 >>> 1;
            return Float.intBitsToFloat(n5 | n10 & ~n8 & (0xAFAE7346 ^ 0xAFD18CB9));
        }
        if ((n2 = n + n7) <= 0) {
            return Float.intBitsToFloat(n3 << n | n5);
        }
        if (n7 > 0) {
            return Float.intBitsToFloat(n3 + (n << (0xAFD18CAE ^ 0xAFD18CB9)));
        }
        int n11 = n3 << 1 - n7 & (0xAFAE7346 ^ 0xAFD18CB9);
        return Float.intBitsToFloat(n2 << (0xAFD18CAE ^ 0xAFD18CB9) | n11 | n5);
    }

    public static float \u0212(float f) {
        float f2;
        int n = Float.floatToRawIntBits(f);
        int n2 = n & (0x1E594E69 ^ 0x61A6B196);
        int n3 = n >>> (0x61A6B189 ^ 0x61A6B196);
        if (n2 > (0x1E26B196 ^ 0x61A6B196)) {
            return f;
        }
        if (n2 > (0x23081DD9 ^ 0x61A6B196)) {
            if (n3 == 0 && n2 >= (0x2317C38E ^ 0x61A6B196)) {
                return f * oc42b715e79d.\u023d(0x618D79C6 ^ 0x61A6B196);
            }
            if (n3 != 0 && n2 > (0x23694022 ^ 0x61A6B196)) {
                return 0.0f;
            }
        }
        int n4 = 0;
        float f3 = f;
        float f4 = 0.0f;
        float f5 = f;
        if (n2 > (0x5F17C38E ^ 0x61A6B196)) {
            if (n2 <= (0x5E23A404 ^ 0x61A6B196)) {
                n4 = n3 != 0 ? -1 : 1;
            } else {
                f2 = oc42b715e79d.\u023d(0x618D79CA ^ 0x61A6B196) * f;
                n4 = oc3004491957.\u0182(f2 += oc42b715e79d.\u023d((0x618D51D6 ^ 0x61A6B196) + n3 * (0x61A6B192 ^ 0x61A6B196)));
            }
            f2 = n4;
            f3 = f + oc42b715e79d.\u023d(0x618D79F6 ^ 0x61A6B196) * f2;
            f4 = f2 * oc42b715e79d.\u023d(0x618D79F2 ^ 0x61A6B196);
            f5 = f3 - f4;
        } else if (n2 <= (0x58A6B196 ^ 0x61A6B196)) {
            return f + oc42b715e79d.\u023d(0x618D79C2 ^ 0x61A6B196);
        }
        f2 = f5 * f5;
        float f6 = oc42b715e79d.\u023d(0x618D79FE ^ 0x61A6B196) * f2;
        f6 += oc42b715e79d.\u023d(0x618D79FA ^ 0x61A6B196);
        float f7 = f5 - (f6 *= f2);
        float f8 = f5 * f7;
        f8 /= oc42b715e79d.\u023d(0x618D79E6 ^ 0x61A6B196) - f7;
        f8 -= f4;
        f8 += f3;
        return n4 != 0 ? oc42b715e79d.\u028f(f8, n4) : (f8 += oc42b715e79d.\u023d(0x618D79C2 ^ 0x61A6B196));
    }

    public static float \u01f1(float f) {
        int n = Float.floatToRawIntBits(f);
        int n2 = n >>> (0xD06ACF4A ^ 0xD06ACF5D) & (0xD06ACFA2 ^ 0xD06ACF5D);
        if (n2 >= (0xD06ACFCB ^ 0xD06ACF5D)) {
            return f;
        }
        float f2 = Float.intBitsToFloat(n & ocd8ecc8a91a.K(0xD0410EDD ^ 0xD06ACF5D));
        float f3 = oc42b715e79d.\u023d(0xD0410ECD ^ 0xD06ACF5D) + f2;
        if (n2 <= (0xD06ACF20 ^ 0xD06ACF5D)) {
            return f * 0.0f;
        }
        f3 += oc42b715e79d.\u023d(0xD0410EC9 ^ 0xD06ACF5D);
        if ((f3 -= f2) > oc42b715e79d.\u023d(0xD0410EC5 ^ 0xD06ACF5D)) {
            f2 += f3;
            f2 += oc42b715e79d.\u023d(0xD0410EF9 ^ 0xD06ACF5D);
        } else {
            f2 += f3;
            if (oc42b715e79d.\u023d(0xD0410EC1 ^ 0xD06ACF5D) >= f3) {
                f2 += oc42b715e79d.\u023d(0xD0410EFD ^ 0xD06ACF5D);
            }
        }
        return Float.intBitsToFloat(Float.floatToRawIntBits(f2) ^ (n < 0 ? ocd8ecc8a91a.K(0xD0410EED ^ 0xD06ACF5D) : 0));
    }

    public static float \u0258(float f) {
        int n = Float.floatToRawIntBits(f);
        int n2 = n >>> (0xF5C735C5 ^ 0xF5C735D2) & (0xF5C7352D ^ 0xF5C735D2);
        if (n2 >= (0xF5C73544 ^ 0xF5C735D2)) {
            return f;
        }
        int n3 = n2 >= (0xF5C735AD ^ 0xF5C735D2) ? n2 - (0xF5C735A4 ^ 0xF5C735D2) : 1;
        int n4 = -1 >>> (n3 & (0xF5C735CD ^ 0xF5C735D2));
        return Float.intBitsToFloat(n & ~n4);
    }

    public static float \u012a(float f, float f2) {
        int n = Float.floatToRawIntBits(f);
        int n2 = Float.floatToRawIntBits(f2);
        int n3 = n & (0xF7DA53C3 ^ 0x77DA53C3);
        int n4 = n & (0x825AC3C ^ 0x77DA53C3);
        int n5 = n2 & (0x825AC3C ^ 0x77DA53C3);
        int n6 = n4 >>> (0x77DA53D4 ^ 0x77DA53C3);
        int n7 = n5 >>> (0x77DA53D4 ^ 0x77DA53C3);
        if (n5 != 0 && n5 <= (0x85A53C3 ^ 0x77DA53C3) && n6 != (0x77DA533C ^ 0x77DA53C3)) {
            if (n4 <= n5) {
                return n4 == n5 ? Float.intBitsToFloat(n3) : f;
            }
            if (n6 != 0) {
                n4 = n4 & (0x77A5AC3C ^ 0x77DA53C3) | 0x775A53C3 ^ 0x77DA53C3;
            } else {
                n6 = 1;
                while (n4 < (0x775A53C3 ^ 0x77DA53C3)) {
                    n4 <<= 1;
                    --n6;
                }
            }
            if (n7 != 0) {
                n5 = n5 & (0x77A5AC3C ^ 0x77DA53C3) | 0x775A53C3 ^ 0x77DA53C3;
            } else {
                n7 = 1;
                while (n5 < (0x775A53C3 ^ 0x77DA53C3)) {
                    n5 <<= 1;
                    --n7;
                }
            }
            while (n6 > n7) {
                if (n4 >= n5 && (n4 -= n5) == 0) {
                    return Float.intBitsToFloat(n3);
                }
                n4 <<= 1;
                --n6;
            }
            if (n4 >= n5 && (n4 -= n5) == 0) {
                return Float.intBitsToFloat(n3);
            }
            while (n4 < (0x775A53C3 ^ 0x77DA53C3)) {
                n4 <<= 1;
                --n6;
            }
            n4 = n6 > 0 ? n4 - (0x775A53C3 ^ 0x77DA53C3) | n6 << (0x77DA53D4 ^ 0x77DA53C3) : (n4 >>>= 1 - n6);
            return Float.intBitsToFloat(n4 | n3);
        }
        if (n4 > (0x85A53C3 ^ 0x77DA53C3)) {
            return oc42b715e79d.\u0119(f);
        }
        return n5 > (0x85A53C3 ^ 0x77DA53C3) ? oc42b715e79d.\u0119(f2) : Float.intBitsToFloat(0x881A53C3 ^ 0x77DA53C3);
    }
}

