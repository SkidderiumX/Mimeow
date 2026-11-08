/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.L;
import x.ocfb6751b034;

public class oc2f988f0583 {
    private static float \u00dd(int n) {
        return L.\u026d(n);
    }

    public static void \u0228(List<float[]> list, float f, float f2, float f3, float f4, float f5, float f6, float f7, int n) {
        if (n <= (0xD560E3E6 ^ 0xD560E3F6)) {
            float f8 = oc2f988f0583.\u00dd(0xD54BB886 ^ 0xD560E3F6);
            float f9 = oc2f988f0583.\u00dd(0xD54BB876 ^ 0xD560E3F6);
            float f10 = oc2f988f0583.\u00dd(0xD54BB866 ^ 0xD560E3F6);
            ++n;
            do {
                float f11;
                float f12;
                float f13;
                float f14;
                float f15;
                if (!((f15 = (f14 = (f6 + f2) * f9 - (f13 = (f4 + f4 + f2 + f6) * f8)) * f14 + (f12 = (f5 + f) * f9 - (f11 = (f3 + f3 + f + f5) * f8)) * f12) > f7)) {
                    float[] fArray = new float[0xD560E3F4 ^ 0xD560E3F6];
                    fArray[0] = f5;
                    fArray[1] = f6;
                    list.add(fArray);
                    return;
                }
                float f16 = (f + f3) * f9;
                float f17 = (f4 + f2) * f9;
                oc2f988f0583.\u0228(list, f, f2, f16, f17, f11, f13, f7, n);
                f3 = (f3 + f5) * f10;
                f4 = (f4 + f6) * f10;
                f = f11;
                f2 = f13;
            } while (++n != (0xD560E3E4 ^ 0xD560E3F6));
        }
    }

    public static void G(List<float[]> list, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n) {
        if (n <= (0xD81CBA9C ^ 0xD81CBA8C)) {
            int n2;
            float f10 = oc2f988f0583.\u00dd(0xD837E12C ^ 0xD81CBA8C);
            float f11 = oc2f988f0583.\u00dd(0xD837E13C ^ 0xD81CBA8C);
            int n3 = n >= (0xD81CBA9E ^ 0xD81CBA8C) ? n : 0xD81CBA9D ^ 0xD81CBA8C;
            ++n;
            do {
                double d;
                float f12 = f7 - f;
                float f13 = f8 - f2;
                float f14 = (float)StrictMath.sqrt(f12 * f12 + f13 * f13);
                f12 = f7 - f5;
                f13 = f8 - f6;
                double d2 = StrictMath.sqrt(f12 * f12 + f13 * f13);
                float f15 = f3 - f;
                float f16 = f4 - f2;
                float f17 = f5 - f3;
                float f18 = f6 - f4;
                double d3 = StrictMath.sqrt(f15 * f15 + f16 * f16);
                float f19 = (float)(d3 + (d = StrictMath.sqrt(f17 * f17 + f18 * f18)) + d2);
                if (!(f19 * f19 - f14 * f14 > f9)) {
                    float[] fArray = new float[0xD81CBA8E ^ 0xD81CBA8C];
                    fArray[0] = f7;
                    fArray[1] = f8;
                    list.add(fArray);
                    return;
                }
                float f20 = (f + f3) * f11;
                float f21 = (f7 + f5) * f11;
                float f22 = (f2 + f4) * f11;
                float f23 = (f8 + f6) * f11;
                float f24 = (f3 + f5) * f10;
                float f25 = (f4 + f6) * f10;
                float f26 = (f24 + f20) * f11;
                float f27 = (f24 + f21) * f11;
                float f28 = (f25 + f22) * f11;
                float f29 = (f25 + f23) * f11;
                float f30 = (f27 + f26) * f10;
                float f31 = (f29 + f28) * f10;
                oc2f988f0583.G(list, f, f2, f20, f22, f26, f28, f30, f31, f9, n);
                f = f30;
                f2 = f31;
                f3 = f27;
                f4 = f29;
                f5 = f21;
                f6 = f23;
            } while ((n2 = n++) - n3 + 1 != 1);
        }
    }

    private static void \u03ba(ocfb6751b034[] ocfb6751b034Array, int n, int n2) {
        ocfb6751b034 ocfb6751b0342 = ocfb6751b034Array[n];
        ocfb6751b034Array[n] = ocfb6751b034Array[n2];
        ocfb6751b034Array[n2] = ocfb6751b0342;
    }

    public static void \u0512(ocfb6751b034[] ocfb6751b034Array, int n, int n2) {
        block0: while (n2 > (0x87BC3B50 ^ 0x87BC3B5C)) {
            int n3;
            float f;
            int n4 = n2 >>> 1;
            float f2 = ocfb6751b034Array[n].\u04b0;
            float f3 = ocfb6751b034Array[n + n4].\u04b0;
            if (!(f2 < f3) == f3 < (f = ocfb6751b034Array[n + n2 - 1].\u04b0)) {
                n3 = !(f2 < f) != f3 < f ? 0 : n2 - 1;
                oc2f988f0583.\u03ba(ocfb6751b034Array, n + n3, n + n4);
            }
            oc2f988f0583.\u03ba(ocfb6751b034Array, n, n + n4);
            n3 = 1;
            int n5 = n2 - 1;
            while (true) {
                float f4 = ocfb6751b034Array[n].\u04b0;
                while (f4 > ocfb6751b034Array[n + n3].\u04b0) {
                    ++n3;
                }
                while (ocfb6751b034Array[n + n5].\u04b0 > f4) {
                    --n5;
                }
                if (n3 >= n5) {
                    if (n2 - n3 <= n5) {
                        oc2f988f0583.\u0512(ocfb6751b034Array, n + n3, n2 - n3);
                        n2 = n5;
                        continue block0;
                    }
                    oc2f988f0583.\u0512(ocfb6751b034Array, n, n5);
                    n += n3;
                    n2 -= n3;
                    continue block0;
                }
                oc2f988f0583.\u03ba(ocfb6751b034Array, n + n3, n + n5);
                ++n3;
                --n5;
            }
        }
    }

    public static void d(ocfb6751b034[] ocfb6751b034Array) {
        oc2f988f0583.\u0512(ocfb6751b034Array, 0, ocfb6751b034Array.length);
        for (int i = 1; i < ocfb6751b034Array.length; ++i) {
            int n;
            ocfb6751b034 ocfb6751b0342 = ocfb6751b034Array[i];
            for (n = i; n > 0 && ocfb6751b034Array[n - 1].\u04b0 > ocfb6751b0342.\u04b0; --n) {
                ocfb6751b034Array[n] = ocfb6751b034Array[n - 1];
            }
            if (n == i) continue;
            ocfb6751b034Array[n] = ocfb6751b0342;
        }
    }

    private oc2f988f0583() {
    }
}

