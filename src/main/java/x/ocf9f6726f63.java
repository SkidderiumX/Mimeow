/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import x.L;
import x.oc11d1e4dfb9;
import x.oc16a684bb41;
import x.oc3004491957;
import x.oc33beffb935;
import x.oc35e4c54bd4;
import x.oc62a465bc97;
import x.oc6f44315029;
import x.oc77bf9fb04c;
import x.ocac488f5520;
import x.ocd1e9706904;
import x.ocd942ca907b;
import x.ocd9db3ede42;

public class ocf9f6726f63 {
    private final ocd942ca907b \u046d;
    private final boolean \u0251;
    private final Map<Integer, Float> \u02a6 = new HashMap<Integer, Float>();

    public ocf9f6726f63(ocd942ca907b ocd942ca907b2) {
        this(ocd942ca907b2, false);
    }

    public ocf9f6726f63(ocd942ca907b ocd942ca907b2, boolean bl) {
        this.\u046d = Objects.requireNonNull(ocd942ca907b2);
        this.\u0251 = bl;
    }

    private static float \u0247(int n) {
        return L.\u026d(n);
    }

    private static double \u03a3(int n) {
        return L.\u0239(n);
    }

    private static int \u03ef(float f, float f2, float f3, float f4) {
        return (int)(f4 * 255.0f) << (0xF1BC2CC ^ 0xF1BC2D4) | ((int)(f * 255.0f) & (0xF1BC22B ^ 0xF1BC2D4)) << (0xF1BC2C4 ^ 0xF1BC2D4) | ((int)(f2 * 255.0f) & (0xF1BC22B ^ 0xF1BC2D4)) << (0xF1BC2DC ^ 0xF1BC2D4) | (int)(f3 * 255.0f) & (0xF1BC22B ^ 0xF1BC2D4);
    }

    private static int \u0251(float f) {
        return ocf9f6726f63.\u03ef(f, f, f, 1.0f);
    }

    public static float[] \u00aa(ocd9db3ede42 ocd9db3ede422, int n) {
        float f = ocd9db3ede422.\u00c8;
        if (n == (0xE0C99E82 ^ 0xE0C99E80)) {
            f += ocd9db3ede422.\u0423;
        } else if (n != 0) {
            f = (float)((double)ocd9db3ede422.\u0423 * ocf9f6726f63.\u03a3(0xE0DD96B8 ^ 0xE0C99E80) + (double)f);
        }
        float f2 = ocd9db3ede422.\u0151 + ocf9f6726f63.\u0247(0xE0DD96C0 ^ 0xE0C99E80);
        f2 = (float)((double)ocd9db3ede422.\u0462 * ocf9f6726f63.\u03a3(0xE0DD96B8 ^ 0xE0C99E80) + (double)f2);
        float[] fArray = new float[0xE0C99E82 ^ 0xE0C99E80];
        fArray[0] = f;
        fArray[1] = f2;
        return fArray;
    }

    public float \u0397(ocac488f5520 ocac488f55202, String string, ocd9db3ede42 ocd9db3ede422, int n, int n2, float f, int n3) {
        float[] fArray = ocf9f6726f63.\u00aa(ocd9db3ede422, n);
        float f2 = this.\u046d.z$326dlq9qjcdoc(string, n2, f);
        float f3 = fArray[0];
        if (n == (0xB2E52097 ^ 0xB2E52095)) {
            f3 -= f2;
        } else if (n != 0) {
            f3 -= f2 * (float)ocf9f6726f63.\u03a3(0xB2F128AD ^ 0xB2E52095);
        }
        if (this.\u0251) {
            return ocac488f55202.\u03ad(string, fArray[0], fArray[1], n3, f, (n == 0 ? 1 : (n == (0xB2E52097 ^ 0xB2E52095) ? 0xB2E52091 ^ 0xB2E52095 : 0xB2E52097 ^ 0xB2E52095)) | 0xB2E52085 ^ 0xB2E52095, n2);
        }
        ocac488f55202.\u051b(string, f3, fArray[1] - f * 0.5f, n3, false, f);
        return f3 + f2;
    }

    public float \u0552(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oc11d1e4dfb9 oc11d1e4dfb92, boolean bl, String string, ocd9db3ede42 ocd9db3ede422, float f, int n, int n2) {
        boolean bl2;
        if (!bl) {
            return this.\u0397(ocac488f55202, string, ocd9db3ede422, 0, 0, f, n);
        }
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0462, ocd9db3ede422.\u0462);
        float f2 = ocf9f6726f63.\u0247(0x6F23FB8D ^ 0x6F37F1AD);
        float f3 = ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423 + f2;
        float f4 = this.\u046d.z$326dlq9qjcdoc(string, 0, f);
        ocd9db3ede42 ocd9db3ede424 = new ocd9db3ede42(f3, ocd9db3ede422.\u0151, f4, ocd9db3ede422.\u0462);
        ocd9db3ede42 ocd9db3ede425 = new ocd9db3ede42(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede423.\u0423 + ocd9db3ede424.\u0423 + f2, ocd9db3ede422.\u0462);
        if (oc35e4c54bd42.f(ocd9db3ede425)) {
            oc11d1e4dfb92.\u0545 = !oc11d1e4dfb92.\u0545;
        }
        this.\u0397(ocac488f55202, string, ocd9db3ede424, 0, 0, f, (bl2 = oc35e4c54bd42.\u0518(ocd9db3ede425)) ? n2 : n);
        float f5 = ocf9f6726f63.\u0247(bl2 ? 0x6F23FB85 ^ 0x6F37F1AD : 0x6F23FB89 ^ 0x6F37F1AD);
        ocac488f55202.\u0104(f5, f5, f5, 1.0f).\u0217(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, ocd9db3ede423.\u0462, ocf9f6726f63.\u0247(0x6F23FB81 ^ 0x6F37F1AD));
        ocd9db3ede42 ocd9db3ede426 = ocd9db3ede423.\u0427(ocf9f6726f63.\u0247(0x6F23FB9D ^ 0x6F37F1AD));
        float f6 = ocf9f6726f63.\u0247(bl2 ? 0x6F23FB95 ^ 0x6F37F1AD : 0x6F23FB99 ^ 0x6F37F1AD);
        float f7 = ocf9f6726f63.\u0247(0x6F23FB91 ^ 0x6F37F1AD);
        ocac488f55202.\u0104(f6, f6, f6, 1.0f).\u0297(ocf9f6726f63.\u0247(0x6F23FBED ^ 0x6F37F1AD)).\u0138(ocd9db3ede426.\u00c8, ocd9db3ede426.\u0462 * f7 + ocd9db3ede426.\u0151, ocd9db3ede426.\u00c8 + ocd9db3ede426.\u0423, ocd9db3ede426.\u0462 * f7 + ocd9db3ede426.\u0151);
        if (!oc11d1e4dfb92.\u0545) {
            float f8 = f7 * ocd9db3ede426.\u0423 + ocd9db3ede426.\u00c8;
            ocac488f55202.\u0138(f8, ocd9db3ede426.\u0151, f8, ocd9db3ede426.\u0151 + ocd9db3ede426.\u0462);
        }
        return ocd9db3ede425.\u00c8 + ocd9db3ede425.\u0423;
    }

    public void \u029e(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oc33beffb935 oc33beffb9352, ocd9db3ede42 ocd9db3ede422, float[] fArray, boolean bl) {
        float[] fArray2;
        Object object;
        float f;
        String string;
        float f2 = ocf9f6726f63.\u0247(0xACCAE0B1 ^ 0xACDEEAF5);
        boolean bl2 = oc35e4c54bd42.\u00fa == 1 && oc35e4c54bd42.\u0580 == oc33beffb9352.\u0520;
        String string2 = string = bl2 ? L.\u00f2(0xACCAE043 ^ 0xACDEEAF5) : ocd1e9706904.\u04ef(oc33beffb9352.\u03e1);
        if (bl2) {
            f = oc3004491957.\u0434(this.\u046d.z$326dlq9qjcdoc(string, 1, f2));
        } else {
            object = this.\u02a6.get(oc33beffb9352.\u03e1);
            float f3 = f = object == null ? 0.0f : ((Float)object).floatValue();
            if (f == 0.0f) {
                f = oc3004491957.\u0434(this.\u046d.z$326dlq9qjcdoc(string, 1, f2));
                this.\u02a6.put(oc33beffb9352.\u03e1, Float.valueOf(f));
            }
        }
        object = new ocd9db3ede42(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, f + f2, ocd9db3ede422.\u0462);
        float f4 = ocf9f6726f63.\u0247(0xACCAE0B9 ^ 0xACDEEAF5);
        if (oc33beffb9352.\u03e1 != 0) {
            fArray2 = fArray;
        } else {
            float[] fArray3 = new float[0xACDEEAF1 ^ 0xACDEEAF5];
            fArray3[0] = f4;
            fArray3[1] = f4;
            fArray3[0xACDEEAF7 ^ 0xACDEEAF5] = f4;
            fArray2 = fArray3;
            fArray3[0xACDEEAF6 ^ 0xACDEEAF5] = 1.0f;
        }
        float[] fArray4 = fArray2;
        ocac488f55202.\u0104(fArray4[0], fArray4[1], fArray4[0xACDEEAF7 ^ 0xACDEEAF5], fArray4[0xACDEEAF6 ^ 0xACDEEAF5] * ocf9f6726f63.\u0247(0xACCAE0BD ^ 0xACDEEAF5)).\u0217(((ocd9db3ede42)object).\u00c8, ((ocd9db3ede42)object).\u0151, ((ocd9db3ede42)object).\u0423, ((ocd9db3ede42)object).\u0462, ocf9f6726f63.\u0247(0xACCAE0A5 ^ 0xACDEEAF5));
        int n2 = oc35e4c54bd42.\u0518((ocd9db3ede42)object) ? ocf9f6726f63.\u0251(ocf9f6726f63.\u0247(0xACCAE0A1 ^ 0xACDEEAF5)) : ocf9f6726f63.\u03ef(fArray4[0], fArray4[1], fArray4[0xACDEEAF7 ^ 0xACDEEAF5], fArray4[0xACDEEAF6 ^ 0xACDEEAF5]);
        this.\u0397(ocac488f55202, string, (ocd9db3ede42)object, 1, 1, f2, n2);
        if (oc35e4c54bd42.f((ocd9db3ede42)object)) {
            oc35e4c54bd42.\u04f7(oc33beffb9352.\u0520, n -> {
                oc33beffb9352.\u03e1 = n;
                oc33beffb9352.\u00e5.accept(n);
            });
        }
        if (oc33beffb9352.\u03e1 == 0) {
            if (bl) {
                oc33beffb9352.\u0442 = false;
            }
        } else if (bl) {
            String string3 = L.\u00f2(0xACCAE030 ^ 0xACDEEAF5);
            float f5 = oc3004491957.\u0434(this.\u046d.z$326dlq9qjcdoc(string3, 1, f2));
            ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42(((ocd9db3ede42)object).\u00c8 + ((ocd9db3ede42)object).\u0423 + ocf9f6726f63.\u0247(0xACCAE0A5 ^ 0xACDEEAF5), ((ocd9db3ede42)object).\u0151, f5 + f2, ((ocd9db3ede42)object).\u0462);
            if (oc33beffb9352.\u0442 || oc35e4c54bd42.\u0518(ocd9db3ede422)) {
                float f6 = ocf9f6726f63.\u0247(oc33beffb9352.\u0442 ? 0xACCAE0AD ^ 0xACDEEAF5 : 0xACCAE0B9 ^ 0xACDEEAF5);
                ocac488f55202.\u0104(f6, f6, f6, ocf9f6726f63.\u0247(0xACCAE0BD ^ 0xACDEEAF5)).\u0217(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, ocd9db3ede423.\u0462, ocf9f6726f63.\u0247(0xACCAE0A5 ^ 0xACDEEAF5));
                this.\u0397(ocac488f55202, string3, ocd9db3ede423, 1, 1, f2, ocf9f6726f63.\u0251(ocf9f6726f63.\u0247(oc35e4c54bd42.\u0518(ocd9db3ede423) ? 0xACCAE0AD ^ 0xACDEEAF5 : 0xACCAE0B9 ^ 0xACDEEAF5)));
                if (oc35e4c54bd42.f(ocd9db3ede423)) {
                    oc33beffb9352.\u0442 = !oc33beffb9352.\u0442;
                }
            }
        }
    }

    public static oc16a684bb41 \u01f6(ocd9db3ede42 ocd9db3ede422, float[] fArray, int n, float f, float f2) {
        float f3 = ocd9db3ede422.\u0423 / ocf9f6726f63.\u0247(0xE5577A45 ^ 0xE5437275);
        float f4 = ocd9db3ede422.\u0462 / ocf9f6726f63.\u0247(0xE5577A45 ^ 0xE5437275);
        return new oc16a684bb41(ocd9db3ede422.\u00c8 - fArray[n * (0xE5437277 ^ 0xE5437275)] * f3, ocd9db3ede422.\u0151 - fArray[n * (0xE5437277 ^ 0xE5437275) + 1] * f4, f3 * f, f4 * f2);
    }

    public static float \u0252(float f, double d) {
        float f2 = (float)((double)f * d);
        float f3 = ocf9f6726f63.\u0247(0x274B038D ^ 0x275F0BD5);
        return f3 + oc77bf9fb04c.\u0145(f2) * f3;
    }

    public void l(ocac488f5520 ocac488f55202, ocd9db3ede42 ocd9db3ede422, float[] fArray, float f, float f2, double d) {
        ocac488f55202.\u0104(fArray[0], fArray[1], fArray[0xC4156EB ^ 0xC4156E9], fArray[0xC4156EA ^ 0xC4156E9] * ocf9f6726f63.\u0252(f, d)).\u0297(f2).\u0138(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151 + ocd9db3ede422.\u0462);
    }

    public void \u024f(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, ocd9db3ede42 ocd9db3ede422, int n, float f, double d) {
        float f2 = this.\u0397(ocac488f55202, oc35e4c54bd42.\u02c0.toString(), ocd9db3ede422, n, 0, f, -1) + ocf9f6726f63.\u0247(n == 1 ? 0x83E8064A ^ 0x83FC085E : 0x83E8067E ^ 0x83FC085E);
        float f3 = ocf9f6726f63.\u0247(n == 1 ? 0x83E80646 ^ 0x83FC085E : 0x83E8067A ^ 0x83FC085E);
        float[] fArray = new float[0x83FC085A ^ 0x83FC085E];
        fArray[0] = f3;
        fArray[1] = f3;
        fArray[0x83FC085C ^ 0x83FC085E] = f3;
        fArray[0x83FC085D ^ 0x83FC085E] = 1.0f;
        this.l(ocac488f55202, new ocd9db3ede42(f2, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423, ocd9db3ede422.\u0462), fArray, ocf9f6726f63.\u0247(n == 1 ? 0x83E80642 ^ 0x83FC085E : 0x83E80676 ^ 0x83FC085E), 1.0f, d);
    }

    public void \u018c(ocac488f5520 ocac488f55202, oc6f44315029 oc6f443150292, float f) {
        if (!oc6f443150292.\u026c) {
            oc6f443150292.\u03d6 = 0.0f;
        } else {
            float f2;
            oc6f443150292.\u03d6 = (float)((double)oc6f443150292.\u03d6 + (double)f / ocf9f6726f63.\u03a3(0x4BE9A0A2 ^ 0x4BFDA9D2));
            ocac488f55202.\u0566().\u03e8(oc6f443150292.\u0226, oc6f443150292.\u0199, 0.0f);
            if (oc6f443150292.\u03d6 > ocf9f6726f63.\u0247(0x4BE9A102 ^ 0x4BFDA9D2)) {
                oc6f443150292.\u03d6 = 1.0f;
            } else {
                f2 = oc62a465bc97.\u0181(oc6f443150292.\u03d6);
                ocac488f55202.\u0176(f2).\u042e(f2, f2, 1.0f);
            }
            f2 = ocf9f6726f63.\u0247(0x4BE9A092 ^ 0x4BFDA9D2);
            float f3 = this.\u046d.z$326dlq9qjcdoc(oc6f443150292.\u0143, 0, f2);
            ocd9db3ede42 ocd9db3ede422 = new ocd9db3ede42((float)((double)f3 * ocf9f6726f63.\u03a3(0x4BE9A0AA ^ 0x4BFDA9D2) + ocf9f6726f63.\u03a3(0x4BE9A052 ^ 0x4BFDA9D2)), ocf9f6726f63.\u0247(0x4BE9A05E ^ 0x4BFDA9D2), f3 + ocf9f6726f63.\u0247(0x4BE9A05A ^ 0x4BFDA9D2), 20.0f);
            float f4 = ocf9f6726f63.\u0247(0x4BE9A042 ^ 0x4BFDA9D2);
            ocac488f55202.\u0104(f4, f4, f4, 1.0f).\u0217(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423, ocd9db3ede422.\u0462, ocf9f6726f63.\u0247(0x4BE9A0E6 ^ 0x4BFDA9D2));
            this.\u0397(ocac488f55202, oc6f443150292.\u0143, ocd9db3ede422, 1, 0, f2, ocf9f6726f63.\u0251(ocf9f6726f63.\u0247(0x4BE9A0E2 ^ 0x4BFDA9D2)));
            ocac488f55202.\u0408();
            oc6f443150292.\u026c = false;
        }
    }

    public static float \u057b(long l) {
        if (l >= 0L) {
            return l;
        }
        long l2 = l >>> 1 | l & 1L;
        float f = l2;
        return f + f;
    }

    public static float \u0102(float f) {
        long l = oc3004491957.\u0462(f);
        long l2 = oc3004491957.\u0462(f - ocf9f6726f63.\u0247(0x4662A674 ^ 0x4676AC68));
        long l3 = l >> (0x4676AC57 ^ 0x4676AC68);
        return ocf9f6726f63.\u057b(l | l2 & l3);
    }
}

