/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import x.L;
import x.O;
import x.oc116f3f7aec;
import x.oc222bbf49ca;
import x.oc3004491957;
import x.oc35e4c54bd4;
import x.oc45558f4986;
import x.oc62a465bc97;
import x.oc64a59b1eaa;
import x.oc6f44315029;
import x.oc98904eb9e7;
import x.ocac488f5520;
import x.ocd9db3ede42;
import x.oce4a4c32971;
import x.oce9437cfbe3;
import x.oce9581ba640;
import x.ocf9f6726f63;

public class oc449e61fefc {
    private final ocf9f6726f63 \u0467;
    private final oc6f44315029 \u021a;
    private final oc45558f4986 \u017b;

    public oc449e61fefc(ocf9f6726f63 ocf9f6726f632, oc6f44315029 oc6f443150292, oc45558f4986 oc45558f49862) {
        this.\u0467 = Objects.requireNonNull(ocf9f6726f632);
        this.\u021a = Objects.requireNonNull(oc6f443150292);
        this.\u017b = Objects.requireNonNull(oc45558f49862);
    }

    private static float \u0470(int n) {
        return L.\u026d(n);
    }

    private static double \u02e1(int n) {
        return L.\u0239(n);
    }

    private static int \u04cd(float f) {
        int n = (int)(f * 255.0f);
        return 0xD15D060C ^ 0x2E5D060C | (n & (0x2E5D06F3 ^ 0x2E5D060C)) << (0x2E5D061C ^ 0x2E5D060C) | (n & (0x2E5D06F3 ^ 0x2E5D060C)) << (0x2E5D0604 ^ 0x2E5D060C) | n & (0x2E5D06F3 ^ 0x2E5D060C);
    }

    private static int \u0429(float[] fArray) {
        return (int)(fArray[0x8BEECF8D ^ 0x8BEECF8E] * 255.0f) << (0x8BEECF96 ^ 0x8BEECF8E) | ((int)(fArray[0] * 255.0f) & (0x8BEECF71 ^ 0x8BEECF8E)) << (0x8BEECF9E ^ 0x8BEECF8E) | ((int)(fArray[1] * 255.0f) & (0x8BEECF71 ^ 0x8BEECF8E)) << (0x8BEECF86 ^ 0x8BEECF8E) | (int)(fArray[0x8BEECF8C ^ 0x8BEECF8E] * 255.0f) & (0x8BEECF71 ^ 0x8BEECF8E);
    }

    private static ocd9db3ede42 \u0462(ocd9db3ede42 ocd9db3ede422, float f) {
        return new ocd9db3ede42(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423, f);
    }

    public void \u0117(ocac488f5520 ocac488f55202, String string, ocd9db3ede42 ocd9db3ede422, int n, int n2) {
        this.\u0467.\u0397(ocac488f55202, string, ocd9db3ede422, 0, 0, oc449e61fefc.\u0470(n2), oc449e61fefc.\u04cd(oc449e61fefc.\u0470(n)));
    }

    private static void \u011d(ocac488f5520 ocac488f55202, float[] fArray) {
        ocac488f55202.\u0104(fArray[0], fArray[1], fArray[0x54552142 ^ 0x54552140], fArray[0x54552143 ^ 0x54552140]);
    }

    private static void \u0506(ocac488f5520 ocac488f55202, ocd9db3ede42 ocd9db3ede422, int n, int n2, int n3) {
        float f = oc449e61fefc.\u0470(n);
        ocac488f55202.\u0104(f, f, f, 1.0f).\u0297(oc449e61fefc.\u0470(n2)).\u048f(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423, ocd9db3ede422.\u0462, oc449e61fefc.\u0470(n3));
    }

    public static float[] \u0469(float[] fArray, float[] fArray2, float f) {
        float f2 = f < 0.0f ? 0.0f : oc62a465bc97.\u0517(oc449e61fefc.\u0470(0x4B036B47 ^ 0x4B283AD3), f);
        float f3 = oc449e61fefc.\u0470(0x4B036B47 ^ 0x4B283AD3) - f2;
        float[] fArray3 = new float[0x4B283AD7 ^ 0x4B283AD3];
        for (int i = 0; i < (0x4B283AD7 ^ 0x4B283AD3); ++i) {
            fArray3[i] = f3 * fArray[i] + f2 * fArray2[i];
        }
        return fArray3;
    }

    private static void \u0119(ocac488f5520 ocac488f55202, float f, float f2, float f3) {
        float[] fArray = new float[0x2A064DA8 ^ 0x2A064DAB];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x2A064DA9 ^ 0x2A064DAB] = f3;
        ocac488f55202.B("circle", fArray);
    }

    private static void \u03f7(ocac488f5520 ocac488f55202, ocd9db3ede42 ocd9db3ede422, boolean bl, float f, int n, int n2, int n3) {
        float f2 = bl ? oc449e61fefc.\u0470(n) : f;
        float f3 = bl ? oc449e61fefc.\u0470(n2) : f;
        float f4 = (float)((double)ocd9db3ede422.\u0462 * oc449e61fefc.\u02e1(n3));
        float f5 = ocd9db3ede422.\u00c8 + f4;
        float f6 = ocd9db3ede422.\u0151 + f4;
        float f7 = ocd9db3ede422.\u0462 + ocd9db3ede422.\u00c8 - f4;
        float f8 = ocd9db3ede422.\u0151 + ocd9db3ede422.\u0462 - f4;
        ocac488f55202.\u0104(f2, f3, f3, 1.0f).\u0138(f5, f6, f7, f8).\u0138(f7, f6, f5, f8);
    }

    private String \u0411(String string, int n, float f, float ... fArray) {
        double[] dArray = new double[fArray.length];
        for (int i = 0; i < dArray.length; ++i) {
            dArray[i] = f != 0.0f ? f * fArray[i] : fArray[i];
        }
        return this.\u017b.z$21aeoq2vy2osy(string == null ? L.\u00f2(n) : string, dArray);
    }

    private void \u0208(String string, float f, float f2) {
        this.\u021a.\u0537(string, oc3004491957.\u0182(f), oc3004491957.\u0182(f2));
    }

    public static boolean \u01fd(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oc64a59b1eaa oc64a59b1eaa2, ocd9db3ede42 ocd9db3ede422, boolean bl, float[] fArray, double d) {
        oc64a59b1eaa2.\u00d6(bl, d);
        float f = oc64a59b1eaa2.\u03b9();
        float f2 = oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede422) ? 0xD0C49C8B ^ 0xD0D090D3 : 0xD0C49C87 ^ 0xD0D090D3);
        float[] fArray2 = new float[0xD0D090D7 ^ 0xD0D090D3];
        fArray2[0] = f2;
        fArray2[1] = f2;
        fArray2[0xD0D090D1 ^ 0xD0D090D3] = f2;
        fArray2[0xD0D090D0 ^ 0xD0D090D3] = 1.0f;
        float[] fArray3 = oc449e61fefc.\u0469(fArray2, fArray, f);
        oc449e61fefc.\u011d(ocac488f55202, fArray3);
        ocac488f55202.\u0217(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423, ocd9db3ede422.\u0462, oc449e61fefc.\u0470(0xD0C49C8F ^ 0xD0D090D3));
        if (oc35e4c54bd42.f(ocd9db3ede422)) {
            bl = !bl;
        }
        ocd9db3ede42 ocd9db3ede423 = ocd9db3ede422.\u0427(oc449e61fefc.\u0470(0xD0C49CB3 ^ 0xD0D090D3));
        float f3 = oc449e61fefc.\u0470(0xD0C49CB7 ^ 0xD0D090D3);
        float f4 = oc3004491957.\u0182(ocd9db3ede423.\u0462);
        float f5 = f4 * oc449e61fefc.\u0470(0xD0C49CBB ^ 0xD0D090D3);
        float f6 = oc62a465bc97.\u0479(f5 + ocd9db3ede423.\u00c8, ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423 - f5, f);
        float f7 = f5 + ocd9db3ede423.\u0151;
        ocac488f55202.\u0104(f3, f3, f3, 1.0f);
        oc449e61fefc.\u0119(ocac488f55202, f6, f7, f4);
        return bl;
    }

    public boolean \u03f0(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, oc64a59b1eaa oc64a59b1eaa2, boolean bl, float[] fArray, double d) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc449e61fefc.\u0470(0x124BE206 ^ 0x125FEE6A));
        this.\u0117(ocac488f55202, string, ocd9db3ede422, 0x124BE21A ^ 0x125FEE6A, 0x124BE21E ^ 0x125FEE6A);
        return oc449e61fefc.\u01fd(oc35e4c54bd42, ocac488f55202, oc64a59b1eaa2, new ocd9db3ede42(ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423 + oc449e61fefc.\u0470(0x124BE212 ^ 0x125FEE6A), ocd9db3ede422.\u0151, oc449e61fefc.\u0470(0x124BE216 ^ 0x125FEE6A), ocd9db3ede422.\u0462), bl, fArray, d);
    }

    public void \u02ac(ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc449e61fefc.\u0470(0x2B0BC65D ^ 0x2B1FCADD));
        this.\u0117(ocac488f55202, string, new ocd9db3ede42(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151 + oc449e61fefc.\u0470(0x2B0BC659 ^ 0x2B1FCADD), ocd9db3ede422.\u0423, ocd9db3ede422.\u0462), 0x2B0BC655 ^ 0x2B1FCADD, 0x2B0BC651 ^ 0x2B1FCADD);
    }

    public boolean \u00e8(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, boolean bl) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc449e61fefc.\u0470(0x32278168 ^ 0x32338DE8));
        this.\u0117(ocac488f55202, string, new ocd9db3ede42(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151 + oc449e61fefc.\u0470(0x3227816C ^ 0x32338DE8), ocd9db3ede422.\u0423 - 12.0f, ocd9db3ede422.\u0462), 0x32278160 ^ 0x32338DE8, 0x32278164 ^ 0x32338DE8);
        float f = oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede422) ? 0x32278198 ^ 0x32338DE8 : 0x32278160 ^ 0x32338DE8);
        float f2 = ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423 - 6.0f;
        float f3 = ocd9db3ede422.\u0151 + ocd9db3ede422.\u0462 * 0.5f + oc449e61fefc.\u0470(0x3227816C ^ 0x32338DE8);
        ocac488f55202.\u0104(f, f, f, 1.0f).\u0297(1.0f);
        if (bl) {
            ocac488f55202.\u0138(f2 - 3.0f, f3 - 1.5f, f2, f3 + 1.5f).\u0138(f2, f3 + 1.5f, f2 + 3.0f, f3 - 1.5f);
        } else {
            ocac488f55202.\u0138(f2 - 1.5f, f3 - 3.0f, f2 + 1.5f, f3).\u0138(f2 + 1.5f, f3, f2 - 1.5f, f3 + 3.0f);
        }
        return oc35e4c54bd42.f(ocd9db3ede422) ? !bl : bl;
    }

    public float \u04c7(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, String string2, Object object, oc222bbf49ca oc222bbf49ca2, float f, float f2, float f3, float f4, float f5, float[] fArray, double d) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc449e61fefc.\u0470(0x3228E93C ^ 0x323CE5AC));
        this.\u0117(ocac488f55202, string, ocd9db3ede422, 0x3228E938 ^ 0x323CE5AC, 0x3228E934 ^ 0x323CE5AC);
        double d2 = (double)ocd9db3ede422.\u0423 * oc449e61fefc.\u02e1(0x3228E90C ^ 0x323CE5AC);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u00c8 + d2), ocd9db3ede422.\u0151 + oc449e61fefc.\u0470(0x3228E930 ^ 0x323CE5AC) + oc449e61fefc.\u0470(0x3228E904 ^ 0x323CE5AC), (float)(d2 + oc449e61fefc.\u02e1(0x3228E91C ^ 0x323CE5AC)), 4.0f);
        float f6 = oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede422) ? 0x3228E910 ^ 0x323CE5AC : 0x3228E914 ^ 0x323CE5AC);
        float f7 = oc449e61fefc.\u0470(0x3228E96C ^ 0x323CE5AC);
        ocac488f55202.\u0104(f6, f6, f6, 1.0f).\u0217(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, ocd9db3ede423.\u0462, f7);
        float f8 = f2 > f ? oc62a465bc97.\u0496(0.0f, oc449e61fefc.\u0470(0x3228E968 ^ 0x323CE5AC), (f5 - f) / (f2 - f)) : 0.0f;
        float f9 = (float)((double)((float)(d - oc222bbf49ca2.\u0438)) / oc449e61fefc.\u02e1(0x3228E964 ^ 0x323CE5AC));
        oc222bbf49ca2.\u00cf = oc98904eb9e7.\u03e9(oc222bbf49ca2.\u00cf, f8, f9);
        oc222bbf49ca2.\u0438 = d;
        float f10 = oc62a465bc97.\u0479(ocd9db3ede423.\u00c8, ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423, oc222bbf49ca2.\u00cf);
        oc449e61fefc.\u011d(ocac488f55202, fArray);
        ocac488f55202.\u0217(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, f10 - ocd9db3ede423.\u00c8, 4.0f, f7);
        oc449e61fefc.\u0119(ocac488f55202, f10, f7 + ocd9db3ede423.\u0151, oc449e61fefc.\u0470(0x3228E97C ^ 0x323CE5AC));
        f5 = oc222bbf49ca2.\u01f6(oc35e4c54bd42, object, ocd9db3ede423, ocd9db3ede422, f5, f, f2, f3, f4);
        if (oc222bbf49ca2.\u0567 || oc35e4c54bd42.\u0518(ocd9db3ede422) && !oc35e4c54bd42.\u01db) {
            this.\u0208(oc35e4c54bd42.\u0469(object) ? oc35e4c54bd42.\u02c0.toString() : this.\u0411(string2, 0x3228EBFF ^ 0x323CE5AC, f4, f5), f10, ocd9db3ede423.\u0151);
        }
        return f5;
    }

    public void \u0479(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, String string2, String string3, Object object, int n, Consumer<String> consumer, double d) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(28.0f);
        this.\u0117(ocac488f55202, string, oc449e61fefc.\u0462(ocd9db3ede422, 20.0f), 0xB947F084 ^ 0xB953FDCC, 0xB947F080 ^ 0xB953FDCC);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42(ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423 * 0.5f, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423 * 0.5f, 20.0f);
        oc449e61fefc.\u0506(ocac488f55202, ocd9db3ede423, 0xB947F090 ^ 0xB953FDCC, 0xB947F0AC ^ 0xB953FDCC, 0xB947F0A8 ^ 0xB953FDCC);
        this.\u0467.\u0397(ocac488f55202, string2, ocd9db3ede423, 1, 0, oc449e61fefc.\u0470(0xB947F080 ^ 0xB953FDCC), oc449e61fefc.\u04cd(oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede423) ? 0xB947F0B4 ^ 0xB953FDCC : 0xB947F084 ^ 0xB953FDCC)));
        if (oc35e4c54bd42.f(ocd9db3ede423)) {
            oc35e4c54bd42.\u0183(string, object, (stringBuilder, n2) -> {
                if (stringBuilder.length() + Character.charCount(n2) <= n && n2 >= (0x6ABBC5FC ^ 0x6ABBC5DC) && n2 != (0x6ABBC5A3 ^ 0x6ABBC5DC)) {
                    stringBuilder.appendCodePoint(n2);
                }
            }, consumer, d);
            oc35e4c54bd42.\u02c0.append(string3);
        }
    }

    public float[] \u054d(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, String string2, String string3, Object object, Object object2, oce9437cfbe3 oce9437cfbe32, float f, float f2, float f3, float f4, float f5, float f6, float[] fArray, double d) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc449e61fefc.\u0470(0x7B6AC3B1 ^ 0x7B7ECF59));
        this.\u0117(ocac488f55202, string, ocd9db3ede422, 0x7B6AC3B5 ^ 0x7B7ECF59, 0x7B6AC3A9 ^ 0x7B7ECF59);
        double d2 = (double)ocd9db3ede422.\u0423 * oc449e61fefc.\u02e1(0x7B6AC3A1 ^ 0x7B7ECF59);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u00c8 + d2), ocd9db3ede422.\u0151 + oc449e61fefc.\u0470(0x7B6AC3AD ^ 0x7B7ECF59) + oc449e61fefc.\u0470(0x7B6AC259 ^ 0x7B7ECF59), (float)(d2 + oc449e61fefc.\u02e1(0x7B6AC251 ^ 0x7B7ECF59)), 4.0f);
        float f7 = oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede422) ? 0x7B6AC24D ^ 0x7B7ECF59 : 0x7B6AC249 ^ 0x7B7ECF59);
        float f8 = oc449e61fefc.\u0470(0x7B6AC241 ^ 0x7B7ECF59);
        ocac488f55202.\u0104(f7, f7, f7, 1.0f).\u0217(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, 4.0f, f8);
        float f9 = (float)((double)((float)(d - oce9437cfbe32.\u045f)) / oc449e61fefc.\u02e1(0x7B6AC279 ^ 0x7B7ECF59));
        float f10 = f2 - f;
        oce9437cfbe32.\u018a.\u00cf = oc98904eb9e7.\u03e9(oce9437cfbe32.\u018a.\u00cf, oc62a465bc97.\u0496(0.0f, oc449e61fefc.\u0470(0x7B6AC245 ^ 0x7B7ECF59), (f5 - f) / f10), f9);
        oce9437cfbe32.\u047b.\u00cf = oc98904eb9e7.\u03e9(oce9437cfbe32.\u047b.\u00cf, oc62a465bc97.\u0496(0.0f, oc449e61fefc.\u0470(0x7B6AC245 ^ 0x7B7ECF59), (f6 - f) / f10), f9);
        oce9437cfbe32.\u045f = d;
        float f11 = oc62a465bc97.\u0479(ocd9db3ede423.\u00c8, ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423, oce9437cfbe32.\u018a.\u00cf);
        float f12 = oc62a465bc97.\u0479(ocd9db3ede423.\u00c8, ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423, oce9437cfbe32.\u047b.\u00cf);
        oc449e61fefc.\u011d(ocac488f55202, fArray);
        ocac488f55202.\u0217(f11, ocd9db3ede423.\u0151, f12 - f11, 4.0f, f8);
        oc449e61fefc.\u0119(ocac488f55202, f11, f8 + ocd9db3ede423.\u0151, oc449e61fefc.\u0470(0x7B6AC271 ^ 0x7B7ECF59));
        oc449e61fefc.\u0119(ocac488f55202, f12, f8 + ocd9db3ede423.\u0151, oc449e61fefc.\u0470(0x7B6AC271 ^ 0x7B7ECF59));
        ocd9db3ede42[] ocd9db3ede42Array = oc449e61fefc.\u00f9(ocd9db3ede423, ocd9db3ede422, f11, f12);
        f5 = oce9437cfbe32.\u018a.\u01f6(oc35e4c54bd42, object, ocd9db3ede423, ocd9db3ede42Array[0], f5, f, f2, f3, f4);
        if (oce9437cfbe32.\u018a.\u0567) {
            if (f5 > f6) {
                f6 = f5;
            }
            this.\u0208(oc35e4c54bd42.\u0469(object) ? oc35e4c54bd42.\u02c0.toString() : this.\u0411(string2, 0x7B6AC10A ^ 0x7B7ECF59, f4, f5), f11, ocd9db3ede423.\u0151);
        } else {
            f6 = oce9437cfbe32.\u047b.\u01f6(oc35e4c54bd42, object2, ocd9db3ede423, ocd9db3ede42Array[1], f6, f, f2, f3, f4);
            if (oce9437cfbe32.\u047b.\u0567) {
                if (f5 > f6) {
                    f5 = f6;
                }
                this.\u0208(oc35e4c54bd42.\u0469(object2) ? oc35e4c54bd42.\u02c0.toString() : this.\u0411(string2, 0x7B6AC10A ^ 0x7B7ECF59, f4, f6), f12, ocd9db3ede423.\u0151);
            } else if (oc35e4c54bd42.\u0518(ocd9db3ede422) && (!oc35e4c54bd42.\u01db || oce9437cfbe32.\u018a.\u0567 || oce9437cfbe32.\u047b.\u0567)) {
                float f13 = ocd9db3ede42Array[0].\u00c8 + ocd9db3ede42Array[0].\u0423 + ocd9db3ede42Array[1].\u00c8;
                float[] fArray2 = new float[0x7B7ECF5B ^ 0x7B7ECF59];
                fArray2[0] = f5;
                fArray2[1] = f6;
                this.\u021a.\u0537(this.\u0411(string3, 0x7B6AC175 ^ 0x7B7ECF59, f4, fArray2), oc3004491957.\u043e((double)f13 * oc449e61fefc.\u02e1(0x7B6AC3A1 ^ 0x7B7ECF59)), oc3004491957.\u0182(ocd9db3ede423.\u0151));
            }
        }
        float[] fArray3 = new float[0x7B7ECF5B ^ 0x7B7ECF59];
        fArray3[0] = f5;
        fArray3[1] = f6;
        return fArray3;
    }

    public static ocd9db3ede42[] \u00f9(ocd9db3ede42 ocd9db3ede422, ocd9db3ede42 ocd9db3ede423, float f, float f2) {
        float f3 = oc3004491957.\u043e((double)(f + f2) * oc449e61fefc.\u02e1(0xCA394D9D ^ 0xCA2D4165));
        float f4 = f3 - ocd9db3ede422.\u00c8;
        float f5 = oc449e61fefc.\u0470(0xCA394C55 ^ 0xCA2D4165);
        ocd9db3ede42[] ocd9db3ede42Array = new ocd9db3ede42[0xCA2D4167 ^ 0xCA2D4165];
        ocd9db3ede42Array[0] = new ocd9db3ede42(oc449e61fefc.\u0470(0xCA394C49 ^ 0xCA2D4165) + ocd9db3ede422.\u00c8, ocd9db3ede423.\u0151, f4 + f5, ocd9db3ede423.\u0462);
        ocd9db3ede42Array[1] = new ocd9db3ede42(f3, ocd9db3ede423.\u0151, ocd9db3ede422.\u0423 - f4 + f5, ocd9db3ede423.\u0462);
        return ocd9db3ede42Array;
    }

    public int \u012a(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, oce9581ba640 oce9581ba6402, List<String> list, int[] nArray, int n, float[] fArray, double d) {
        int n2 = list.size();
        float f = oce9581ba6402.\u0119 ? (float)Integer.toUnsignedLong(n2 * (0x631705D ^ 0x6317041)) : oc449e61fefc.\u0470(0x6257D79 ^ 0x6317041);
        float f2 = (float)((double)((float)(d - oce9581ba6402.\u017b)) / oc449e61fefc.\u02e1(0x6257D01 ^ 0x6317041));
        oce9581ba6402.\u014a = oc98904eb9e7.\u03e9(oce9581ba6402.\u014a, f, f2);
        oce9581ba6402.\u017b = d;
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oce9581ba6402.\u014a);
        this.\u0117(ocac488f55202, string, oc449e61fefc.\u0462(ocd9db3ede422, 20.0f), 0x6257D09 ^ 0x6317041, 0x6257D0D ^ 0x6317041);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u0423 * oc449e61fefc.\u02e1(0x6257D11 ^ 0x6317041) + (double)ocd9db3ede422.\u00c8), ocd9db3ede422.\u0151, ocd9db3ede422.\u0423 * oc449e61fefc.\u0470(0x6257D19 ^ 0x6317041), ocd9db3ede422.\u0462);
        oc449e61fefc.\u0506(ocac488f55202, ocd9db3ede423, 0x6257D1D ^ 0x6317041, 0x6257D21 ^ 0x6317041, 0x6257D25 ^ 0x6317041);
        float f3 = oc449e61fefc.\u0470(0x6257D1D ^ 0x6317041);
        if (oce9581ba6402.\u0119) {
            if (n2 == 0) {
                return 0;
            }
            float f4 = ocd9db3ede423.\u0462 / (float)Integer.toUnsignedLong(n2);
            boolean bl = false;
            for (int i = 0; i < n2; ++i) {
                float[] fArray2;
                ocd9db3ede42 ocd9db3ede424 = new ocd9db3ede42(ocd9db3ede423.\u00c8, (float)i * f4 + ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, f4);
                boolean bl2 = oc35e4c54bd42.\u0518(ocd9db3ede424);
                int n3 = (n ^ 1) & (0x63170BE ^ 0x6317041);
                if (i == nArray[0]) {
                    fArray2 = fArray;
                } else {
                    int n4 = bl2 ? (((i == 0 ? 1 : 0) | n3) != 0 ? 0x6257D39 ^ 0x6317041 : 0x6257DC1 ^ 0x6317041) : (((i != 0 ? 1 : 0) | n3) != 0 ? 0x6257D09 ^ 0x6317041 : 0x6257D3D ^ 0x6317041);
                    float f5 = oc449e61fefc.\u0470(n4);
                    float[] fArray3 = new float[0x6317045 ^ 0x6317041];
                    fArray3[0] = f5;
                    fArray3[1] = f5;
                    fArray3[0x6317043 ^ 0x6317041] = f5;
                    fArray3[0x6317042 ^ 0x6317041] = 1.0f;
                    fArray2 = fArray3;
                }
                this.\u0467.\u0397(ocac488f55202, list.get(i), ocd9db3ede424, 1, 0, oc449e61fefc.\u0470(0x6257D0D ^ 0x6317041), oc449e61fefc.\u0429(fArray2));
                if (!bl && oc35e4c54bd42.f(ocd9db3ede424)) {
                    nArray[0] = i;
                    oce9581ba6402.\u0119 = false;
                    bl = true;
                }
                if (i == 0) continue;
                ocac488f55202.\u0104(f3, f3, f3, oc449e61fefc.\u0470(0x6257D19 ^ 0x6317041)).\u0138(ocd9db3ede423.\u00c8, ocd9db3ede424.\u0151, ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423, ocd9db3ede424.\u0151);
            }
            return bl ? 1 : 0;
        }
        boolean bl = oc35e4c54bd42.\u0518(ocd9db3ede423);
        if (((n ^ 1 | (n2 < (0x6317047 ^ 0x6317041) ? 1 : 0)) & (0x63170BE ^ 0x6317041)) == 0 && nArray[0] != 0) {
            ocd9db3ede42 ocd9db3ede425 = new ocd9db3ede42(ocd9db3ede423.\u0423 - ocd9db3ede423.\u0462 + ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0462, ocd9db3ede423.\u0462);
            boolean bl3 = oc35e4c54bd42.\u0518(ocd9db3ede425);
            oc449e61fefc.\u03f7(ocac488f55202, ocd9db3ede425, bl3, f3, 0x6257D29 ^ 0x6317041, 0x6257D2D ^ 0x6317041, 0x6257D31 ^ 0x6317041);
            if (oc35e4c54bd42.f(ocd9db3ede425)) {
                nArray[0] = 0;
            }
            boolean bl4 = bl = bl && !bl3;
        }
        int n5 = n != 0 && nArray[0] == 0 ? (bl ? 0x6257DC1 ^ 0x6317041 : 0x6257D3D ^ 0x6317041) : (bl ? 0x6257D39 ^ 0x6317041 : 0x6257D09 ^ 0x6317041);
        this.\u0467.\u0397(ocac488f55202, list.get(nArray[0]), ocd9db3ede423, 1, 0, oc449e61fefc.\u0470(0x6257D0D ^ 0x6317041), oc449e61fefc.\u04cd(oc449e61fefc.\u0470(n5)));
        if (oc35e4c54bd42.f(ocd9db3ede423)) {
            oce9581ba6402.\u0119 = true;
        }
        return 0;
    }

    public boolean \u0517(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, oce9581ba640 oce9581ba6402, List<String> list, Predicate<String> predicate, Consumer<String> consumer, float[] fArray, double d) {
        float f = oc449e61fefc.\u0470(0xD141DE17 ^ 0xD155D32F);
        float f2 = f * (float)(oce9581ba6402.\u0119 ? list.size() + 1 : 1);
        float f3 = (float)((d - oce9581ba6402.\u017b) / oc449e61fefc.\u02e1(0xD141DE6F ^ 0xD155D32F));
        oce9581ba6402.\u014a = oc98904eb9e7.\u03e9(oce9581ba6402.\u014a, f2, f3);
        oce9581ba6402.\u017b = d;
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oce9581ba6402.\u014a);
        this.\u0117(ocac488f55202, string, oc449e61fefc.\u0462(ocd9db3ede422, 20.0f), 0xD141DE67 ^ 0xD155D32F, 0xD141DE63 ^ 0xD155D32F);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u0423 * oc449e61fefc.\u02e1(0xD141DE7F ^ 0xD155D32F) + (double)ocd9db3ede422.\u00c8), ocd9db3ede422.\u0151, ocd9db3ede422.\u0423 * oc449e61fefc.\u0470(0xD141DE77 ^ 0xD155D32F), Math.max(f, ocd9db3ede422.\u0462));
        ocd9db3ede42 ocd9db3ede424 = oc449e61fefc.\u0462(ocd9db3ede423, f);
        oc449e61fefc.\u0506(ocac488f55202, ocd9db3ede423, 0xD141DE73 ^ 0xD155D32F, 0xD141DE4F ^ 0xD155D32F, 0xD141DE4B ^ 0xD155D32F);
        int n = 0;
        Object object = "None";
        for (String string2 : list) {
            if (!predicate.test(string2)) continue;
            object = string2.replace((char)(0xD155D370 ^ 0xD155D32F), (char)(0xD155D30F ^ 0xD155D32F));
            ++n;
        }
        if (n > 1) {
            object = n + " selected";
        }
        this.\u0467.\u0397(ocac488f55202, (String)object, new ocd9db3ede42(ocd9db3ede424.\u00c8, ocd9db3ede424.\u0151, ocd9db3ede424.\u0423 - 16.0f, ocd9db3ede424.\u0462), 1, 0, oc449e61fefc.\u0470(0xD141DE63 ^ 0xD155D32F), oc449e61fefc.\u04cd(oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede424) ? 0xD141DE57 ^ 0xD155D32F : 0xD141DE67 ^ 0xD155D32F)));
        float f4 = ocd9db3ede424.\u00c8 + ocd9db3ede424.\u0423 - 9.0f;
        float f5 = ocd9db3ede424.\u0151 + f * 0.5f;
        float f6 = oc449e61fefc.\u0470(0xD141DE73 ^ 0xD155D32F);
        ocac488f55202.\u0104(f6, f6, f6, 1.0f).\u0297(1.0f);
        if (oce9581ba6402.\u0119) {
            ocac488f55202.\u0138(f4 - 3.0f, f5 - 1.5f, f4, f5 + 1.5f).\u0138(f4, f5 + 1.5f, f4 + 3.0f, f5 - 1.5f);
        } else {
            ocac488f55202.\u0138(f4 - 1.5f, f5 - 3.0f, f4 + 1.5f, f5).\u0138(f4 + 1.5f, f5, f4 - 1.5f, f5 + 3.0f);
        }
        if (oc35e4c54bd42.f(ocd9db3ede424)) {
            oce9581ba6402.\u0119 = !oce9581ba6402.\u0119;
            return false;
        }
        if (!oce9581ba6402.\u0119) {
            return false;
        }
        boolean bl = false;
        for (int i = 0; i < list.size(); ++i) {
            float[] fArray2;
            ocd9db3ede42 ocd9db3ede425 = new ocd9db3ede42(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151 + f * (float)(i + 1), ocd9db3ede423.\u0423, f);
            if (ocd9db3ede425.\u0151 + ocd9db3ede425.\u0462 > ocd9db3ede423.\u0151 + ocd9db3ede423.\u0462) break;
            String string3 = list.get(i);
            float f7 = oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede425) ? 0xD141DE57 ^ 0xD155D32F : 0xD141DE67 ^ 0xD155D32F);
            if (predicate.test(string3)) {
                fArray2 = fArray;
            } else {
                float[] fArray3 = new float[0xD155D32B ^ 0xD155D32F];
                fArray3[0] = f7;
                fArray3[1] = f7;
                fArray3[0xD155D32D ^ 0xD155D32F] = f7;
                fArray2 = fArray3;
                fArray3[0xD155D32C ^ 0xD155D32F] = 1.0f;
            }
            float[] fArray4 = fArray2;
            this.\u0467.\u0397(ocac488f55202, string3.replace((char)(0xD155D370 ^ 0xD155D32F), (char)(0xD155D30F ^ 0xD155D32F)), new ocd9db3ede42(ocd9db3ede425.\u00c8, ocd9db3ede425.\u0151, ocd9db3ede425.\u0423 - 16.0f, ocd9db3ede425.\u0462), 1, 0, oc449e61fefc.\u0470(0xD141DE63 ^ 0xD155D32F), oc449e61fefc.\u0429(fArray4));
            if (predicate.test(string3)) {
                oc449e61fefc.\u011d(ocac488f55202, fArray);
                oc449e61fefc.\u0119(ocac488f55202, ocd9db3ede425.\u00c8 + ocd9db3ede425.\u0423 - 9.0f, ocd9db3ede425.\u0151 + ocd9db3ede425.\u0462 * 0.5f, 3.0f);
            }
            ocac488f55202.\u0104(f6, f6, f6, oc449e61fefc.\u0470(0xD141DE77 ^ 0xD155D32F)).\u0138(ocd9db3ede425.\u00c8, ocd9db3ede425.\u0151, ocd9db3ede425.\u00c8 + ocd9db3ede425.\u0423, ocd9db3ede425.\u0151);
            if (!oc35e4c54bd42.f(ocd9db3ede425)) continue;
            consumer.accept(string3);
            bl = true;
        }
        return bl;
    }

    public void \u047b(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, String string2, List<String> list, Consumer<Integer> consumer, double d) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc449e61fefc.\u0470(0xDD940621 ^ 0xDD800B19));
        this.\u0117(ocac488f55202, string, oc449e61fefc.\u0462(ocd9db3ede422, 20.0f), 0xDD940651 ^ 0xDD800B19, 0xDD940655 ^ 0xDD800B19);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u0423 * oc449e61fefc.\u02e1(0xDD940649 ^ 0xDD800B19) + (double)ocd9db3ede422.\u00c8), ocd9db3ede422.\u0151, ocd9db3ede422.\u0423 * oc449e61fefc.\u0470(0xDD940641 ^ 0xDD800B19), ocd9db3ede422.\u0462);
        oc449e61fefc.\u0506(ocac488f55202, ocd9db3ede423, 0xDD940645 ^ 0xDD800B19, 0xDD940679 ^ 0xDD800B19, 0xDD94067D ^ 0xDD800B19);
        this.\u0467.\u0397(ocac488f55202, string2, ocd9db3ede423, 1, 0, oc449e61fefc.\u0470(0xDD940655 ^ 0xDD800B19), oc449e61fefc.\u04cd(oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede423) ? 0xDD940661 ^ 0xDD800B19 : 0xDD940651 ^ 0xDD800B19)));
        if (oc35e4c54bd42.f(ocd9db3ede423)) {
            oc35e4c54bd42.\u0471(string, list, consumer, d);
        }
    }

    public boolean \u03c5(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string, float[] fArray, Consumer<float[]> consumer, double d) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc449e61fefc.\u0470(0xFE0E36A6 ^ 0xFE1A3B2E));
        this.\u0117(ocac488f55202, string, oc449e61fefc.\u0462(ocd9db3ede422, 20.0f), 0xFE0E36A2 ^ 0xFE1A3B2E, 0xFE0E36BE ^ 0xFE1A3B2E);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42(ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423 + oc449e61fefc.\u0470(0xFE0E36BA ^ 0xFE1A3B2E), ocd9db3ede422.\u0151, oc449e61fefc.\u0470(0xFE0E36B6 ^ 0xFE1A3B2E), 20.0f);
        float f = ocd9db3ede423.\u0462 * 0.5f;
        ocac488f55202.\u0104(fArray[0], fArray[1], fArray[0xFE1A3B2C ^ 0xFE1A3B2E], 1.0f).\u0217(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, ocd9db3ede423.\u0462, f);
        ocac488f55202.\u0104(0.33f, 0.33f, 0.33f, 1.0f).\u0297(1.0f).\u048f(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, ocd9db3ede423.\u0462, f);
        ocd9db3ede42 ocd9db3ede424 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u0423 * oc449e61fefc.\u02e1(0xFE0E3686 ^ 0xFE1A3B2E) + (double)ocd9db3ede422.\u00c8), ocd9db3ede422.\u0151, ocd9db3ede422.\u0423 * oc449e61fefc.\u0470(0xFE0E369E ^ 0xFE1A3B2E), ocd9db3ede422.\u0462);
        boolean bl = oc35e4c54bd42.f(ocd9db3ede424);
        if (bl) {
            oc35e4c54bd42.\u026c(string, fArray, consumer, d);
        }
        return bl;
    }

    public boolean \u02b0(oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, String string2, String string3, oc116f3f7aec oc116f3f7aec2, int n2, O o, List<String> list, double d) {
        long l = o.z$2x3ntqt526oi6();
        long l2 = l + 1L;
        float f = ocf9f6726f63.\u057b(l2);
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(ocf9f6726f63.\u057b(l2 * (0xDD9A3AF8C1B652E6L ^ 0xDD9A3AF8C1B652FAL)));
        this.\u0117(ocac488f55202, string2, oc449e61fefc.\u0462(ocd9db3ede422, 20.0f), 0xBA8E8C32 ^ 0xBA9A818A, 0xBA8E8C36 ^ 0xBA9A818A);
        ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u0423 * oc449e61fefc.\u02e1(0xBA8E8C4A ^ 0xBA9A818A) + (double)ocd9db3ede422.\u00c8), ocd9db3ede422.\u0151, ocd9db3ede422.\u0423 * oc449e61fefc.\u0470(0xBA8E8C42 ^ 0xBA9A818A), ocd9db3ede422.\u0462);
        oc449e61fefc.\u0506(ocac488f55202, ocd9db3ede423, 0xBA8E8C46 ^ 0xBA9A818A, 0xBA8E8C5A ^ 0xBA9A818A, 0xBA8E8C5E ^ 0xBA9A818A);
        float f2 = ocd9db3ede423.\u0462 / f;
        float f3 = oc449e61fefc.\u0470(0xBA8E8C46 ^ 0xBA9A818A);
        long l3 = 0x2265C5073E49AD05L ^ 0xDD9A3AF8C1B652FAL;
        boolean bl = false;
        long l4 = 0L;
        while (Long.compareUnsigned(l4, l) < 0) {
            ocd9db3ede42 ocd9db3ede424;
            ocd9db3ede42 ocd9db3ede425 = new ocd9db3ede42(ocd9db3ede423.\u00c8, ocf9f6726f63.\u057b(l4) * f2 + ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, f2);
            String string4 = o.z$35m04xqyo0snr(l4);
            byte[] byArray = string4.getBytes(StandardCharsets.UTF_8);
            String string5 = new String(byArray, 0, Math.min(byArray.length, 0xBA9A819E ^ 0xBA9A818A), StandardCharsets.UTF_8);
            this.\u0467.\u0397(ocac488f55202, string5, ocd9db3ede425, 1, 0, oc449e61fefc.\u0470(0xBA8E8C36 ^ 0xBA9A818A), oc449e61fefc.\u04cd(oc449e61fefc.\u0470(0xBA8E8C32 ^ 0xBA9A818A)));
            if (n2 == 1) {
                ocd9db3ede424 = new ocd9db3ede42(ocd9db3ede425.\u00c8, ocd9db3ede425.\u0151, ocd9db3ede425.\u0462, ocd9db3ede425.\u0462).\u0427(oc449e61fefc.\u0470(0xBA8E8C52 ^ 0xBA9A818A));
                float[] fArray2 = o.z$1vqgh10n4y8c4(l4);
                ocac488f55202.\u0104(fArray2[0], fArray2[1], fArray2[0xBA9A8188 ^ 0xBA9A818A], 1.0f).\u0217(ocd9db3ede424.\u00c8, ocd9db3ede424.\u0151, ocd9db3ede424.\u0423, ocd9db3ede424.\u0462, oc449e61fefc.\u0470(0xBA8E8C56 ^ 0xBA9A818A));
                if (oc35e4c54bd42.f(ocd9db3ede424)) {
                    long l5 = l4;
                    oc35e4c54bd42.\u026c(string4, fArray2, fArray -> o.z$3khx2gyg54sew(l5, (float[])fArray), d);
                    bl = true;
                }
            }
            ocd9db3ede424 = new ocd9db3ede42(ocd9db3ede425.\u0423 - ocd9db3ede425.\u0462 + ocd9db3ede425.\u00c8, ocd9db3ede425.\u0151, ocd9db3ede425.\u0462, ocd9db3ede425.\u0462);
            oc449e61fefc.\u03f7(ocac488f55202, ocd9db3ede424, oc35e4c54bd42.\u0518(ocd9db3ede424), f3, 0xBA8E8C6A ^ 0xBA9A818A, 0xBA8E8C6E ^ 0xBA9A818A, 0xBA8E8C62 ^ 0xBA9A818A);
            if (oc35e4c54bd42.f(ocd9db3ede424)) {
                l3 = l4;
            }
            ocac488f55202.\u0104(f3, f3, f3, oc449e61fefc.\u0470(0xBA8E8C42 ^ 0xBA9A818A)).\u0138(ocd9db3ede425.\u00c8, ocd9db3ede425.\u0151 + ocd9db3ede425.\u0462, ocd9db3ede425.\u00c8 + ocd9db3ede425.\u0423, ocd9db3ede425.\u0151 + ocd9db3ede425.\u0462);
            ++l4;
        }
        if (l3 != (0x2265C5073E49AD05L ^ 0xDD9A3AF8C1B652FAL)) {
            o.z$2pwvkhw6ga4vj(l3);
            bl = true;
        }
        ocd9db3ede42 ocd9db3ede426 = new ocd9db3ede42(ocd9db3ede423.\u00c8, ocf9f6726f63.\u057b(l) * f2 + ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, f2);
        this.\u0467.\u0397(ocac488f55202, L.\u00f2(0xBA8E8FCC ^ 0xBA9A818A), ocd9db3ede426, 1, 0, oc449e61fefc.\u0470(0xBA8E8C36 ^ 0xBA9A818A), oc449e61fefc.\u04cd(oc449e61fefc.\u0470(oc35e4c54bd42.\u0518(ocd9db3ede426) ? 0xBA8E8C7E ^ 0xBA9A818A : 0xBA8E8C7A ^ 0xBA9A818A)));
        if (oc35e4c54bd42.f(ocd9db3ede426)) {
            if (list != null) {
                oc35e4c54bd42.\u0471(string3, list, n -> {
                    if (n != null) {
                        float[] fArray = new float[0xCB02E4F5 ^ 0xCB02E4F6];
                        fArray[0] = oc449e61fefc.\u0470(0xCB16E90E ^ 0xCB02E4F6);
                        fArray[1] = 0.0f;
                        fArray[0xCB02E4F4 ^ 0xCB02E4F6] = 0.0f;
                        o.z$2k037up90b496((int)n, (String)list.get((int)n), fArray);
                    }
                }, d);
            } else {
                oc35e4c54bd42.\u0183(string3, o, oc116f3f7aec2, string -> {
                    if (string != null) {
                        float[] fArray = new float[0xCCCA936C ^ 0xCCCA936F];
                        fArray[0] = oc449e61fefc.\u0470(0xCCDE9E93 ^ 0xCCCA936F);
                        fArray[1] = 0.0f;
                        fArray[0xCCCA936D ^ 0xCCCA936F] = 0.0f;
                        o.z$3d5hxar1iu0yg((String)string, fArray);
                    }
                }, d);
            }
            bl = true;
        }
        return bl;
    }
}

