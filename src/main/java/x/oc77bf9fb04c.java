/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc3004491957;
import x.oc42b715e79d;
import x.oc616a04cc99;
import x.ocd8ecc8a91a;

public class oc77bf9fb04c {
    private oc77bf9fb04c() {
    }

    private static double \u00fa(int n) {
        return ocd8ecc8a91a.\u042d(n);
    }

    private static float \u03ef(float f, int n) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f) ^ ocd8ecc8a91a.K(n));
    }

    private static float \u03e1(double d, int n, int n2, boolean bl) {
        double d2 = d * d;
        double d3 = d2 * d2;
        double d4 = bl ? Double.longBitsToDouble(Double.doubleToRawLongBits(d) ^ ocd8ecc8a91a.\u0147(n2)) : d;
        double d5 = bl ? d4 * d2 : d2 * d;
        double d6 = d2 * oc77bf9fb04c.\u00fa(n) + oc77bf9fb04c.\u00fa(n + (0xFD314CB7 ^ 0xFD314CA7));
        double d7 = d2 * oc77bf9fb04c.\u00fa(n + (0xFD314CAF ^ 0xFD314CA7)) + oc77bf9fb04c.\u00fa(n + (0xFD314CBF ^ 0xFD314CA7));
        double d8 = d3 * d5 * d6;
        double d9 = d5 * d7;
        d9 = bl ? d9 - d : d9 + d;
        return (float)(d9 + d8);
    }

    private static float \u037a(double d, int n, int n2, boolean bl) {
        double d2 = d * d;
        double d3 = d2 * d2;
        double d4 = oc77bf9fb04c.\u00fa(n) * d2 + oc77bf9fb04c.\u00fa(n + (0x9E2EC5E1 ^ 0x9E2EC5E9));
        double d5 = oc77bf9fb04c.\u00fa(n + (0x9E2EC5F9 ^ 0x9E2EC5E9)) * d2 + oc77bf9fb04c.\u00fa(n + (0x9E2EC5F1 ^ 0x9E2EC5E9));
        double d6 = d2 * d3;
        double d7 = d3 * oc77bf9fb04c.\u00fa(n + (0x9E2EC5C9 ^ 0x9E2EC5E9)) + d5;
        double d8 = d6 * d4;
        float f = (float)(d8 + d7);
        return bl ? oc77bf9fb04c.\u03ef(f, n2) : f;
    }

    public static int \u040a(float f, double[] dArray) {
        int n = Float.floatToRawIntBits(f);
        int n2 = n & (0x3CA2AA81 ^ 0x435D557E);
        if (n2 <= (0xE945AA4 ^ 0x435D557E)) {
            double d;
            double d2 = f;
            double d3 = oc77bf9fb04c.\u00fa(0x4376E3BE ^ 0x435D557E) * d2;
            d3 += oc77bf9fb04c.\u00fa(0x4376E3B6 ^ 0x435D557E);
            int n3 = oc3004491957.\u043e(d3 += oc77bf9fb04c.\u00fa(0x4376E3AE ^ 0x435D557E));
            double d4 = oc77bf9fb04c.\u00fa(0x4376E3A6 ^ 0x435D557E) * d3 + d2;
            dArray[0] = d = oc77bf9fb04c.\u00fa(0x4376E39E ^ 0x435D557E) * d3 + d4;
            if (oc77bf9fb04c.\u00fa(0x4376E396 ^ 0x435D557E) > d) {
                d3 += oc77bf9fb04c.\u00fa(0x4376E27E ^ 0x435D557E);
                --n3;
            } else {
                if (!(d > oc77bf9fb04c.\u00fa(0x4376E38E ^ 0x435D557E))) {
                    return n3;
                }
                d3 += oc77bf9fb04c.\u00fa(0x4376E386 ^ 0x435D557E);
                ++n3;
            }
            double d5 = oc77bf9fb04c.\u00fa(0x4376E3A6 ^ 0x435D557E) * d3;
            dArray[0] = (d3 *= oc77bf9fb04c.\u00fa(0x4376E39E ^ 0x435D557E)) + (d2 += d5);
            return n3;
        }
        if (n2 > (0x3C22AA81 ^ 0x435D557E)) {
            dArray[0] = oc42b715e79d.\u0119(f);
            return 0;
        }
        int n4 = (n2 >>> (0x435D5569 ^ 0x435D557E)) - (0x435D55E8 ^ 0x435D557E);
        int n5 = n2 - (n4 << (0x435D5569 ^ 0x435D557E));
        double[] dArray2 = new double[1];
        int n6 = oc616a04cc99.\u012d(new double[]{Float.intBitsToFloat(n5)}, dArray2, n4, 1, 0);
        if (n < 0) {
            dArray[0] = Double.longBitsToDouble(Double.doubleToRawLongBits(dArray2[0]) ^ ocd8ecc8a91a.\u0147(0x4376E3CE ^ 0x435D557E));
            n6 = -n6;
        } else {
            dArray[0] = dArray2[0];
        }
        return n6;
    }

    public static float \u0145(float f) {
        int n = Float.floatToRawIntBits(f);
        int n2 = n & (0x9797EA5 ^ 0x7686815A);
        boolean bl = n < 0;
        double d = f;
        if (n2 <= (0x49CF8E80 ^ 0x7686815A)) {
            return n2 < (0x4F06815A ^ 0x7686815A) ? f : oc77bf9fb04c.\u03e1(d, 0x76AD3EEA ^ 0x7686815A, 0x76AD3EFA ^ 0x7686815A, false);
        }
        if (n2 < (0x36FDD288 ^ 0x7686815A)) {
            if (n2 >= (0x36904ABE ^ 0x7686815A)) {
                return oc77bf9fb04c.\u03e1(d += oc77bf9fb04c.\u00fa(bl ? 0x76AD3EAA ^ 0x7686815A : 0x76AD3EA2 ^ 0x7686815A), 0x76AD3EEA ^ 0x7686815A, 0x76AD3EFA ^ 0x7686815A, true);
            }
            return oc77bf9fb04c.\u037a(d += oc77bf9fb04c.\u00fa(bl ? 0x76AD415A ^ 0x7686815A : 0x76AD4152 ^ 0x7686815A), 0x76AD3E3A ^ 0x7686815A, 0x76AD3ECA ^ 0x7686815A, bl);
        }
        if (n2 < (0x3664B08C ^ 0x7686815A)) {
            if (n2 >= (0x36296CBA ^ 0x7686815A)) {
                return oc77bf9fb04c.\u03e1(d += oc77bf9fb04c.\u00fa(bl ? 0x76AD3E8A ^ 0x7686815A : 0x76AD3E82 ^ 0x7686815A), 0x76AD3EEA ^ 0x7686815A, 0x76AD3EFA ^ 0x7686815A, false);
            }
            return oc77bf9fb04c.\u037a(d += oc77bf9fb04c.\u00fa(bl ? 0x76AD3EBA ^ 0x7686815A : 0x76AD3EB2 ^ 0x7686815A), 0x76AD3E3A ^ 0x7686815A, 0x76AD3ECA ^ 0x7686815A, !bl);
        }
        if (n2 > (0x9F97EA5 ^ 0x7686815A)) {
            return oc42b715e79d.\u0119(f);
        }
        double[] dArray = new double[1];
        int n3 = oc77bf9fb04c.\u040a(f, dArray) & (0x76868159 ^ 0x7686815A);
        d = dArray[0];
        if (n3 == 0) {
            return oc77bf9fb04c.\u03e1(d, 0x76AD3EEA ^ 0x7686815A, 0x76AD3EFA ^ 0x7686815A, false);
        }
        if (n3 == 1) {
            return oc77bf9fb04c.\u037a(d, 0x76AD3E3A ^ 0x7686815A, 0x76AD3ECA ^ 0x7686815A, false);
        }
        return n3 == (0x76868158 ^ 0x7686815A) ? oc77bf9fb04c.\u03e1(d, 0x76AD3EEA ^ 0x7686815A, 0x76AD3EFA ^ 0x7686815A, true) : oc77bf9fb04c.\u037a(d, 0x76AD3E3A ^ 0x7686815A, 0x76AD3ECA ^ 0x7686815A, true);
    }

    public static float \u04ed(float f) {
        int n = Float.floatToRawIntBits(f);
        int n2 = n & (0xD037124F ^ 0xAFC8EDB0);
        boolean bl = n < 0;
        double d = f;
        if (n2 <= (0x9081E26A ^ 0xAFC8EDB0)) {
            return n2 < (0x9648EDB0 ^ 0xAFC8EDB0) ? ocd8ecc8a91a.\u027e(0xAFE326F4 ^ 0xAFC8EDB0) : oc77bf9fb04c.\u037a(d, 0xAFE32770 ^ 0xAFC8EDB0, 0xAFE32740 ^ 0xAFC8EDB0, false);
        }
        if (n2 < (0xEFB3BE62 ^ 0xAFC8EDB0)) {
            if (n2 > (0xEFDE2653 ^ 0xAFC8EDB0)) {
                return oc77bf9fb04c.\u037a(d += oc77bf9fb04c.\u00fa(bl ? 0xAFE32680 ^ 0xAFC8EDB0 : 0xAFE32688 ^ 0xAFC8EDB0), 0xAFE32770 ^ 0xAFC8EDB0, 0xAFE32740 ^ 0xAFC8EDB0, true);
            }
            d = bl ? d + oc77bf9fb04c.\u00fa(0xAFE32698 ^ 0xAFC8EDB0) : oc77bf9fb04c.\u00fa(0xAFE32698 ^ 0xAFC8EDB0) - d;
            return oc77bf9fb04c.\u03e1(d, 0xAFE32710 ^ 0xAFC8EDB0, 0xAFE326B0 ^ 0xAFC8EDB0, false);
        }
        if (n2 < (0xEF2ADC66 ^ 0xAFC8EDB0)) {
            if (n2 > (0xEF67006F ^ 0xAFC8EDB0)) {
                return oc77bf9fb04c.\u037a(d += oc77bf9fb04c.\u00fa(bl ? 0xAFE326A8 ^ 0xAFC8EDB0 : 0xAFE32690 ^ 0xAFC8EDB0), 0xAFE32770 ^ 0xAFC8EDB0, 0xAFE32740 ^ 0xAFC8EDB0, false);
            }
            d = bl ? oc77bf9fb04c.\u00fa(0xAFE326A0 ^ 0xAFC8EDB0) - d : d + oc77bf9fb04c.\u00fa(0xAFE326A0 ^ 0xAFC8EDB0);
            return oc77bf9fb04c.\u03e1(d, 0xAFE32710 ^ 0xAFC8EDB0, 0xAFE326B0 ^ 0xAFC8EDB0, false);
        }
        if (n2 > (0xD0B7124F ^ 0xAFC8EDB0)) {
            return oc42b715e79d.\u0119(f);
        }
        double[] dArray = new double[1];
        int n3 = oc77bf9fb04c.\u040a(f, dArray) & (0xAFC8EDB3 ^ 0xAFC8EDB0);
        d = dArray[0];
        if (n3 == 0) {
            return oc77bf9fb04c.\u037a(d, 0xAFE32770 ^ 0xAFC8EDB0, 0xAFE32740 ^ 0xAFC8EDB0, false);
        }
        if (n3 == 1) {
            return oc77bf9fb04c.\u03e1(d, 0xAFE32710 ^ 0xAFC8EDB0, 0xAFE326B0 ^ 0xAFC8EDB0, true);
        }
        return n3 == (0xAFC8EDB2 ^ 0xAFC8EDB0) ? oc77bf9fb04c.\u037a(d, 0xAFE32770 ^ 0xAFC8EDB0, 0xAFE32740 ^ 0xAFC8EDB0, true) : oc77bf9fb04c.\u03e1(d, 0xAFE32710 ^ 0xAFC8EDB0, 0xAFE326B0 ^ 0xAFC8EDB0, false);
    }
}

