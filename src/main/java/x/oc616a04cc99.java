/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc3004491957;
import x.ocbfb02edab6;
import x.ocd8ecc8a91a;

public class oc616a04cc99 {
    private oc616a04cc99() {
    }

    private static double \u04a6(int n) {
        return ocd8ecc8a91a.\u042d(n);
    }

    private static double \u0493(int n) {
        return ocd8ecc8a91a.K((0x5772E85F ^ 0x57593C67) + (0x57593C63 ^ 0x57593C67) * n);
    }

    private static double \u03f5(double[] dArray, double[] dArray2, int n, int n2) {
        double d = 0.0;
        for (int i = 0; i <= n; ++i) {
            d += dArray[i] * dArray2[n + n2 - i];
        }
        return d;
    }

    private static double \u0242(double d, int n) {
        return n != 0 ? Double.longBitsToDouble(Double.doubleToRawLongBits(d) ^ ocd8ecc8a91a.\u0147(0x3EB90767 ^ 0x3E92B707)) : d;
    }

    public static int \u012d(double[] dArray, double[] dArray2, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        double d;
        int n7;
        int n8;
        int n9 = ocd8ecc8a91a.K((0x312CD2FC ^ 0x310706D4) + (0x310706D0 ^ 0x310706D4) * n3);
        int n10 = n2 - 1;
        int n11 = Math.max(0, (short)(n - (0x310706D7 ^ 0x310706D4)) / (0x310706CC ^ 0x310706D4));
        int n12 = n - (0x310706CC ^ 0x310706D4) * (n11 + 1);
        double[] dArray3 = new double[0x310706C0 ^ 0x310706D4];
        double[] dArray4 = new double[0x310706C0 ^ 0x310706D4];
        double[] dArray5 = new double[0x310706C0 ^ 0x310706D4];
        int[] nArray = new int[0x310706C0 ^ 0x310706D4];
        double d2 = oc616a04cc99.\u04a6(0x312CB6F4 ^ 0x310706D4);
        double d3 = oc616a04cc99.\u04a6(0x312CB6FC ^ 0x310706D4);
        double d4 = oc616a04cc99.\u04a6(0x312CB6E4 ^ 0x310706D4);
        double d5 = oc616a04cc99.\u04a6(0x312CB684 ^ 0x310706D4);
        double d6 = oc616a04cc99.\u04a6(0x312CB69C ^ 0x310706D4);
        for (n8 = 0; n8 <= n10 + n9; ++n8) {
            n7 = n11 - n10 + n8;
            dArray3[n8] = n7 < 0 ? 0.0 : oc616a04cc99.\u0493(n7);
        }
        for (n8 = 0; n8 <= n9; ++n8) {
            dArray4[n8] = oc616a04cc99.\u03f5(dArray, dArray3, n10, n8);
        }
        n8 = n9;
        n7 = 0;
        int n13 = 0;
        while (true) {
            int n14;
            d = dArray4[n8];
            int n15 = 0;
            for (int i = n8; i > 0; --i) {
                double d7 = oc3004491957.\u043e(d * d2);
                nArray[n15] = oc3004491957.\u043e(d7 * d4 + d);
                d = dArray4[i - 1] + d7;
                ++n15;
            }
            d = ocbfb02edab6.\u025d(d, n12);
            double d8 = ocbfb02edab6.O(d * oc616a04cc99.\u04a6(0x312CB6EC ^ 0x310706D4));
            d = d8 * oc616a04cc99.\u04a6(0x312CB694 ^ 0x310706D4) + d;
            n7 = oc3004491957.\u043e(d);
            d -= (double)n7;
            n13 = 0;
            if (n12 > 0) {
                n14 = nArray[n8 - 1] >> (0x310706CC ^ 0x310706D4) - n12;
                n7 += n14;
                nArray[n8 - 1] = nArray[n8 - 1] - (n14 << (0x310706CC ^ 0x310706D4) - n12);
                n13 = nArray[n8 - 1] >> (0x310706C3 ^ 0x310706D4) - n12;
            } else if (n12 == 0) {
                n13 = nArray[n8 - 1] >> (0x310706C3 ^ 0x310706D4);
            } else if (!(d < d6)) {
                n13 = 0x310706D6 ^ 0x310706D4;
            }
            if (n13 > 0) {
                ++n7;
                n14 = 0;
                for (n6 = 0; n6 < n8; ++n6) {
                    n5 = nArray[n6];
                    if (n14 != 0) {
                        nArray[n6] = (0x31F8F92B ^ 0x310706D4) - n5;
                        continue;
                    }
                    if (n5 == 0) continue;
                    n14 = 1;
                    nArray[n6] = (0x300706D4 ^ 0x310706D4) - n5;
                }
                if (n12 == 1) {
                    nArray[n8 - 1] = nArray[n8 - 1] & (0x3178F92B ^ 0x310706D4);
                } else if (n12 == (0x310706D6 ^ 0x310706D4)) {
                    nArray[n8 - 1] = nArray[n8 - 1] & (0x3138F92B ^ 0x310706D4);
                }
                if (n13 == (0x310706D6 ^ 0x310706D4)) {
                    d = d5 - d;
                    if (n14 != 0) {
                        d -= ocbfb02edab6.\u025d(d5, n12);
                    }
                }
            }
            if (d != 0.0) break;
            n14 = 0;
            for (n6 = n8 - 1; n6 >= n9; --n6) {
                n14 |= nArray[n6];
            }
            if (n14 != 0) break;
            n6 = 1;
            while (nArray[n9 - n6] == 0) {
                ++n6;
            }
            for (n5 = n8 + 1; n5 <= n8 + n6; ++n5) {
                dArray3[n10 + n5] = oc616a04cc99.\u0493(n11 + n5);
                dArray4[n5] = oc616a04cc99.\u03f5(dArray, dArray3, n10, n5);
            }
            n8 += n6;
        }
        if (d == 0.0) {
            --n8;
            n12 -= 24;
            while (nArray[n8] == 0) {
                --n8;
                n12 -= 24;
            }
        } else if (!((d = ocbfb02edab6.\u025d(d, -n12)) < d3)) {
            double d9 = oc3004491957.\u043e(d * d2);
            nArray[n8] = oc3004491957.\u043e(d9 * d4 + d);
            n12 += 24;
            nArray[++n8] = oc3004491957.\u043e(d9);
        } else {
            nArray[n8] = oc3004491957.\u043e(d);
        }
        double d10 = ocbfb02edab6.\u025d(d5, n12);
        for (n4 = n8; n4 >= 0; --n4) {
            dArray4[n4] = d10 * (double)nArray[n4];
            d10 *= d2;
        }
        for (n4 = n8; n4 >= 0; --n4) {
            double d11 = 0.0;
            for (n5 = 0; n5 <= n9 && n5 <= n8 - n4; ++n5) {
                d11 += oc616a04cc99.\u04a6((0x312CD9D4 ^ 0x310706D4) + (0x310706DC ^ 0x310706D4) * n5) * dArray4[n4 + n5];
            }
            dArray5[n8 - n4] = d11;
        }
        if (n3 < (0x310706D7 ^ 0x310706D4)) {
            double d12 = 0.0;
            for (n6 = n8; n6 >= 0; --n6) {
                d12 += dArray5[n6];
            }
            dArray2[0] = oc616a04cc99.\u0242(d12, n13);
            if (n3 == 1 || n3 == (0x310706D6 ^ 0x310706D4)) {
                double d13 = dArray5[0] - d12;
                for (int i = 1; i <= n8; ++i) {
                    d13 += dArray5[i];
                }
                dArray2[1] = oc616a04cc99.\u0242(d13, n13);
            }
        } else if (n3 == (0x310706D7 ^ 0x310706D4)) {
            for (n4 = 0; n4 < (0x310706D6 ^ 0x310706D4); ++n4) {
                for (int i = n8; i > n4; --i) {
                    double d14 = dArray5[i - 1] + dArray5[i];
                    int n16 = i;
                    dArray5[n16] = dArray5[n16] + (dArray5[i - 1] - d14);
                    dArray5[i - 1] = d14;
                }
            }
            double d15 = 0.0;
            for (int i = n8; i >= (0x310706D6 ^ 0x310706D4); --i) {
                d15 += dArray5[i];
            }
            dArray2[0] = oc616a04cc99.\u0242(dArray5[0], n13);
            dArray2[1] = oc616a04cc99.\u0242(dArray5[1], n13);
            dArray2[0x310706D6 ^ 0x310706D4] = oc616a04cc99.\u0242(d15, n13);
        }
        return n7 & (0x310706D3 ^ 0x310706D4);
    }
}

