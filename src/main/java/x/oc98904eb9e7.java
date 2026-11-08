/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.charset.StandardCharsets;
import x.L;
import x.oc222bbf49ca;
import x.oc35e4c54bd4;
import x.oc42b715e79d;
import x.oc449e61fefc;
import x.oc62a465bc97;
import x.ocd9db3ede42;

public class oc98904eb9e7 {
    private static float \u0132(int n) {
        return L.\u026d(n);
    }

    private static double \u0442(int n) {
        return L.\u0239(n);
    }

    public static ocd9db3ede42 \u03aa(ocd9db3ede42 ocd9db3ede422) {
        return new ocd9db3ede42(oc42b715e79d.\u01f1(ocd9db3ede422.\u00c8), oc42b715e79d.\u01f1(ocd9db3ede422.\u0151), oc42b715e79d.\u01f1(ocd9db3ede422.\u0423), oc42b715e79d.\u01f1(ocd9db3ede422.\u0462));
    }

    public static boolean \u0203(ocd9db3ede42 ocd9db3ede422, ocd9db3ede42 ocd9db3ede423) {
        return !(ocd9db3ede422.\u00c8 > ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423 || ocd9db3ede423.\u00c8 > ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423 || ocd9db3ede422.\u0151 > ocd9db3ede423.\u0151 + ocd9db3ede423.\u0462 || ocd9db3ede423.\u0151 > ocd9db3ede422.\u0151 + ocd9db3ede422.\u0462);
    }

    public static float[] \u029d(oc35e4c54bd4 oc35e4c54bd42, Object object, Object object2, oc222bbf49ca oc222bbf49ca2, oc222bbf49ca oc222bbf49ca3, ocd9db3ede42 ocd9db3ede422, float f, float f2, float f3, float f4, float f5, float f6, double d) {
        float f7 = f4 - f3;
        float f8 = (float)((double)((float)(d - oc222bbf49ca2.\u0438)) / oc98904eb9e7.\u0442(0xB5972801 ^ 0xB5832521));
        oc222bbf49ca2.\u00cf = oc98904eb9e7.\u03e9(oc222bbf49ca2.\u00cf, oc62a465bc97.\u0496(0.0f, oc98904eb9e7.\u0132(0xB597283D ^ 0xB5832521), (f - f3) / f7), f8);
        oc222bbf49ca3.\u00cf = oc98904eb9e7.\u03e9(oc222bbf49ca3.\u00cf, oc62a465bc97.\u0496(0.0f, oc98904eb9e7.\u0132(0xB597283D ^ 0xB5832521), (f2 - f3) / f7), f8);
        oc222bbf49ca2.\u0438 = oc222bbf49ca3.\u0438 = d;
        float f9 = oc62a465bc97.\u0479(ocd9db3ede422.\u00c8, ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423, oc222bbf49ca2.\u00cf);
        float f10 = oc62a465bc97.\u0479(ocd9db3ede422.\u00c8, ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423, oc222bbf49ca3.\u00cf);
        ocd9db3ede42[] ocd9db3ede42Array = oc449e61fefc.\u00f9(ocd9db3ede422, ocd9db3ede422, f9, f10);
        float f11 = oc222bbf49ca2.\u01f6(oc35e4c54bd42, object, ocd9db3ede422, ocd9db3ede42Array[0], f, f3, f4, f5, f6);
        float f12 = f2;
        if (oc222bbf49ca2.\u0567) {
            if (f11 > f2) {
                f12 = f11;
            }
        } else {
            f12 = oc222bbf49ca3.\u01f6(oc35e4c54bd42, object2, ocd9db3ede422, ocd9db3ede42Array[1], f2, f3, f4, f5, f6);
            if (f11 > f12) {
                f11 = f12;
            }
        }
        float[] fArray = new float[0xB5832523 ^ 0xB5832521];
        fArray[0] = f11;
        fArray[1] = f12;
        return fArray;
    }

    public static float \u03e9(float f, float f2, float f3) {
        return oc62a465bc97.\u0479(f, f2, oc62a465bc97.\u0517(oc98904eb9e7.\u0132(0xD753B279 ^ 0xD7405AA9), f3));
    }

    public static float \u0253(String string) {
        byte[] byArray = oc98904eb9e7.\u0547(string);
        int n = 0;
        int n2 = 1;
        int n3 = 0;
        if (byArray.length > 0 && byArray[0] == (0x38EE6547 ^ 0x38EE656A)) {
            n = 1;
            n2 = -1;
        }
        while (n < byArray.length && (byArray[n] & (0x38EE6595 ^ 0x38EE656A)) - (0x38EE655A ^ 0x38EE656A) < (0x38EE6560 ^ 0x38EE656A) && (byArray[n] & (0x38EE6595 ^ 0x38EE656A)) >= (0x38EE655A ^ 0x38EE656A)) {
            n3 = n3 * (0x38EE6560 ^ 0x38EE656A) + (byArray[n] & (0x38EE6595 ^ 0x38EE656A)) - (0x38EE655A ^ 0x38EE656A);
            ++n;
        }
        if (n < byArray.length && (byArray[n] & (0x38EE6595 ^ 0x38EE656A) | 0x38EE6568 ^ 0x38EE656A) == (0x38EE6544 ^ 0x38EE656A)) {
            float f = 0.0f;
            float f2 = oc98904eb9e7.\u0132(0x38FA69B2 ^ 0x38EE656A);
            ++n;
            while (n < byArray.length && (byArray[n] & (0x38EE6595 ^ 0x38EE656A)) - (0x38EE655A ^ 0x38EE656A) < (0x38EE6560 ^ 0x38EE656A) && (byArray[n] & (0x38EE6595 ^ 0x38EE656A)) >= (0x38EE655A ^ 0x38EE656A)) {
                f += (float)((byArray[n] & (0x38EE6595 ^ 0x38EE656A)) - (0x38EE655A ^ 0x38EE656A)) * f2;
                f2 = (float)((double)f2 * oc98904eb9e7.\u0442(0x38FA698A ^ 0x38EE656A));
                ++n;
            }
            return ((float)n3 + f) * (float)n2;
        }
        return n3 * n2;
    }

    public static void \u01a3(StringBuilder stringBuilder, int n) {
        int n2 = n & (0xACAD767C ^ 0xACAD7683);
        if (stringBuilder.length() != (0xACAD76E7 ^ 0xACAD7683) && (n2 >= (0xACAD76B3 ^ 0xACAD7683) && n2 <= (0xACAD76BA ^ 0xACAD7683) || n2 == (0xACAD76AE ^ 0xACAD7683) || n2 == (0xACAD76AD ^ 0xACAD7683) || n2 == (0xACAD76AF ^ 0xACAD7683))) {
            stringBuilder.append((char)n2);
        }
    }

    public static void \u01d3(StringBuilder stringBuilder, int n) {
        if (stringBuilder.length() <= (0x527D955B ^ 0x527D9538) && oc62a465bc97.\u041f(n)) {
            stringBuilder.append((char)(n & (0x527D95C7 ^ 0x527D9538)));
        }
    }

    public static void \u045d(StringBuilder stringBuilder, int n) {
        if (stringBuilder.length() + Character.charCount(n) <= (0x4B8A3DF6 ^ 0x4B8A3DD6) && n >= (0x4B8A3DF6 ^ 0x4B8A3DD6) && n != (0x4B8A3DA9 ^ 0x4B8A3DD6) && n != (0x4B8A3DF9 ^ 0x4B8A3DD6) && n != (0x4B8A3D8A ^ 0x4B8A3DD6)) {
            stringBuilder.appendCodePoint(n);
        }
    }

    public static void \u014d(StringBuilder stringBuilder, int n) {
        if (stringBuilder.length() <= (0xC925D98F ^ 0xC925D98A)) {
            int n2 = n & (0xC925D975 ^ 0xC925D98A);
            if ((n2 - (0xC925D9CB ^ 0xC925D98A) & (0xC925D975 ^ 0xC925D98A)) <= (0xC925D98F ^ 0xC925D98A)) {
                n2 |= 0xC925D9AA ^ 0xC925D98A;
            } else if ((n2 - (0xC925D9EB ^ 0xC925D98A) & (0xC925D975 ^ 0xC925D98A)) >= (0xC925D98C ^ 0xC925D98A) && (n2 - (0xC925D9BA ^ 0xC925D98A) & (0xC925D975 ^ 0xC925D98A)) >= (0xC925D980 ^ 0xC925D98A)) {
                return;
            }
            stringBuilder.append((char)n2);
        }
    }

    private static byte[] \u0547(String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }

    private static String \u0410(String string, int n) {
        byte[] byArray = oc98904eb9e7.\u0547(string);
        return new String(byArray, 0, Math.min(n, byArray.length), StandardCharsets.UTF_8);
    }

    public static boolean \u017c(byte[] byArray, byte[] byArray2) {
        if (byArray2.length == 0) {
            return true;
        }
        for (int i = 0; i <= byArray.length - byArray2.length; ++i) {
            int n = 0;
            while (oc98904eb9e7.\u0264(byArray[i + n] & (0x74686581 ^ 0x7468657E)) == oc98904eb9e7.\u0264(byArray2[n] & (0x74686581 ^ 0x7468657E))) {
                if (++n != byArray2.length) continue;
                return true;
            }
        }
        return false;
    }

    private static int \u0264(int n) {
        return (n - (0x7410D48A ^ 0x7410D4CB) & (0x7410D434 ^ 0x7410D4CB)) < (0x7410D4D1 ^ 0x7410D4CB) ? n | 0x7410D4EB ^ 0x7410D4CB : n;
    }

    public static float[] \u04f7(float[] fArray, boolean bl, boolean bl2) {
        float f;
        float f2 = fArray[0];
        float f3 = fArray[1];
        float f4 = f = fArray[0x8E3D9185 ^ 0x8E3D9187];
        float f5 = f;
        if (!Float.isNaN(f3)) {
            f4 = oc62a465bc97.\u057f(f, f3);
            f5 = oc62a465bc97.\u0517(f, f3);
        }
        if (!Float.isNaN(f2)) {
            f4 = oc62a465bc97.\u057f(f4, f2);
            f5 = oc62a465bc97.\u0517(f5, f2);
        }
        float f6 = oc98904eb9e7.\u0132(bl2 ? 0x8E299F5B ^ 0x8E3D9187 : 0x8E299FE7 ^ 0x8E3D9187);
        float f7 = oc98904eb9e7.\u0132(bl2 ? 0x8E299F33 ^ 0x8E3D9187 : 0x8E299FE3 ^ 0x8E3D9187);
        float f8 = oc98904eb9e7.\u0132(bl2 ? 0x8E299E87 ^ 0x8E3D9187 : 0x8E299FEB ^ 0x8E3D9187);
        float f9 = f4 + f5;
        float f10 = f6 * f9;
        float f11 = 0.0f;
        float f12 = 0.0f;
        if (f4 != f5) {
            float f13;
            float f14 = f4 - f5;
            float f15 = f13 = f6 < f10 ? f7 - f4 - f5 : f9;
            f11 = f4 == f2 ? (f3 - f) / f14 + (f3 < f ? f8 : 0.0f) : (f4 == f3 ? (f - f2) / f14 + oc98904eb9e7.\u0132(bl2 ? 0x8E299F33 ^ 0x8E3D9187 : 0x8E299FE3 ^ 0x8E3D9187) : (f4 == f ? (f2 - f3) / f14 + oc98904eb9e7.\u0132(bl2 ? 0x8E299F4B ^ 0x8E3D9187 : 0x8E299FEF ^ 0x8E3D9187) : f10));
            f12 = f14 / f13;
            f11 /= f8;
        }
        float[] fArray2 = new float[0x8E3D9184 ^ 0x8E3D9187];
        fArray2[0] = f11;
        fArray2[1] = f12;
        fArray2[0x8E3D9185 ^ 0x8E3D9187] = f10;
        return fArray2;
    }

    private static float \u01e7(float f) {
        return f < 0.0f ? 0.0f : oc62a465bc97.\u0517(oc98904eb9e7.\u0132(0x92D7E038 ^ 0x92FCB1A0), f);
    }

    private static float \u0447(float f) {
        float f2 = oc98904eb9e7.\u0132(0xA9B4FFD ^ 0xAB01E65);
        if (f < 0.0f) {
            f += f2;
        }
        if (f2 < f) {
            f += oc98904eb9e7.\u0132(0xA9B4FC1 ^ 0xAB01E65);
        }
        return f;
    }

    private static float \u04c4(float f, float f2, float f3) {
        if (oc98904eb9e7.\u0132(0x808E1D5 ^ 0x823B07D) > f) {
            return (f2 - f3) * f * oc98904eb9e7.\u0132(0x808E1CD ^ 0x823B07D) + f3;
        }
        if (oc98904eb9e7.\u0132(0x808E1E1 ^ 0x823B07D) > f) {
            return f2;
        }
        return oc98904eb9e7.\u0132(0x808E1D1 ^ 0x823B07D) > f ? (oc98904eb9e7.\u0132(0x808E1D1 ^ 0x823B07D) - f) * (f2 - f3) * oc98904eb9e7.\u0132(0x808E1CD ^ 0x823B07D) + f3 : f3;
    }

    public static float[] \u04c3(float f, float f2, float f3, int n) {
        if ((f = oc42b715e79d.\u012a(f, oc98904eb9e7.\u0132(0x58C77947 ^ 0x58EC28DF))) < 0.0f) {
            f += oc98904eb9e7.\u0132(0x58C77947 ^ 0x58EC28DF);
        }
        f2 = oc98904eb9e7.\u01e7(f2);
        f3 = oc98904eb9e7.\u01e7(f3);
        float f4 = oc98904eb9e7.\u0132(0x58C77943 ^ 0x58EC28DF) >= f3 ? (f2 + oc98904eb9e7.\u0132(0x58C77947 ^ 0x58EC28DF)) * f3 : f2 + f3 - f3 * f2;
        float f5 = f3 + f3 - f4;
        float[] fArray = new float[0x58EC28DB ^ 0x58EC28DF];
        fArray[0] = oc98904eb9e7.\u01e7(oc98904eb9e7.\u04c4(oc98904eb9e7.\u0447(oc98904eb9e7.\u0132(0x58C7797F ^ 0x58EC28DF) + f), f4, f5));
        fArray[1] = oc98904eb9e7.\u01e7(oc98904eb9e7.\u04c4(oc98904eb9e7.\u0447(f), f4, f5));
        fArray[0x58EC28DD ^ 0x58EC28DF] = oc98904eb9e7.\u01e7(oc98904eb9e7.\u04c4(oc98904eb9e7.\u0447(f + oc98904eb9e7.\u0132(0x58C7796B ^ 0x58EC28DF)), f4, f5));
        fArray[0x58EC28DC ^ 0x58EC28DF] = (float)(n & (0x58EC2820 ^ 0x58EC28DF)) / oc98904eb9e7.\u0132(0x58C77967 ^ 0x58EC28DF);
        return fArray;
    }

    public static float \u00ba(float f) {
        int n = Float.floatToRawIntBits(f);
        int n2 = n >>> (0xC1E58DAC ^ 0xC1E58DBB) & (0xC1E58D44 ^ 0xC1E58DBB);
        if (n2 >= (0xC1E58D2D ^ 0xC1E58DBB)) {
            return f;
        }
        if (n2 >= (0xC1E58DC4 ^ 0xC1E58DBB)) {
            int n3 = -1 << ((0xC1E58DAD ^ 0xC1E58DBB) - n2 & (0xC1E58DA4 ^ 0xC1E58DBB));
            int n4 = ~n3;
            return (n & n4) == 0 ? f : Float.intBitsToFloat(n + (-(n >>> (0xC1E58DA4 ^ 0xC1E58DBB)) & n4) & n3);
        }
        if (n >= 0) {
            return 0.0f;
        }
        return f == 0.0f ? f : oc98904eb9e7.\u0132(0xC1CE4B0F ^ 0xC1E58DBB);
    }
}

