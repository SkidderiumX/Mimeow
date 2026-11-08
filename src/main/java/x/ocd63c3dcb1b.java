/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import x.L;
import x.oc2d39c317eb;
import x.oc3004491957;
import x.oc4b4b5da6c6;
import x.oc53b6121dc1;
import x.oc56e3ec4ee3;
import x.oc62a465bc97;
import x.oc66ab65400a;
import x.oc98904eb9e7;
import x.occ1875d4f2d;
import x.ocd78ebee979;
import x.ocf13aa48070;

public class ocd63c3dcb1b {
    private static float \u051a(int n) {
        return L.\u026d(n);
    }

    private static int \u0129(int n) {
        return L.\u0497(n & (0x840FB4CA ^ 0x7BF04B36)) >>> (n & (0x7BF04B35 ^ 0x7BF04B36)) * (0x7BF04B3E ^ 0x7BF04B36) & (0x7BF04BC9 ^ 0x7BF04B36);
    }

    public static oc53b6121dc1 \u00fb(ocd78ebee979 ocd78ebee9792, ocf13aa48070 ocf13aa480702, int n, float f, float f2, oc66ab65400a oc66ab65400a2, boolean bl, float f3, float f4) {
        float f5;
        if (n != -1) {
            int n2 = ocd78ebee9792.z$3lozifh06bic(n, ocf13aa480702.\u04cc);
            f5 = oc3004491957.\u0182((float)n2 * f + f2 + ocd63c3dcb1b.\u051a(0x997302E2 ^ 0x99584C36));
            oc66ab65400a2.\u0129 += f5;
        }
        float f6 = (short)(ocf13aa480702.z + 1);
        f5 = (short)(ocf13aa480702.\u00dc + 1);
        float f7 = ocf13aa480702.\u0130 + 1;
        float f8 = ocf13aa480702.\u0230 - 1;
        float f9 = ocf13aa480702.\u03ef + 1;
        float f10 = ocf13aa480702.\u038e - 1;
        oc53b6121dc1 oc53b6121dc12 = new oc53b6121dc1();
        oc53b6121dc12.\u0516 = oc98904eb9e7.\u00ba(f6 + oc66ab65400a2.\u0129);
        oc53b6121dc12.\u01fe = oc98904eb9e7.\u00ba(bl ? oc66ab65400a2.\u024b + f5 : oc66ab65400a2.\u024b - f5);
        oc53b6121dc12.\u03dc = oc53b6121dc12.\u0516 + f10 - f9;
        oc53b6121dc12.\u04fd = bl ? oc53b6121dc12.\u01fe + f8 - f7 : oc53b6121dc12.\u01fe - f8 + f7;
        oc53b6121dc12.\u0570 = f9 * f3;
        oc53b6121dc12.\u0182 = f7 * f4;
        oc53b6121dc12.\u0156 = f10 * f3;
        oc53b6121dc12.\u03d1 = f8 * f4;
        float f11 = oc3004491957.\u0182((float)ocf13aa480702.\u02e0 / ocd63c3dcb1b.\u051a(0x997302EE ^ 0x99584C36) + ocd63c3dcb1b.\u051a(0x997302E2 ^ 0x99584C36));
        oc66ab65400a2.\u0129 += f11;
        return oc53b6121dc12;
    }

    private static float \u0146(ocd78ebee979 ocd78ebee9792, boolean bl, int n, float f, int n2, int n3, int n4, int n5, boolean bl2) {
        float f2;
        boolean bl3 = false;
        if ((n & (0xD77C338A ^ 0xD77C3382)) != 0) {
            f2 = ocd78ebee9792.z$1dwkeyeylat9c();
            bl3 = !bl;
        } else if ((n & (0xD77C3392 ^ 0xD77C3382)) != 0) {
            f2 = (ocd78ebee9792.z$1dwkeyeylat9c() + ocd78ebee9792.z$2besc61ybi4tc()) * ocd63c3dcb1b.\u051a(bl ? n3 : n5);
        } else {
            if ((n & (0xD77C33E2 ^ 0xD77C3382)) != (0xD77C33A2 ^ 0xD77C3382)) {
                return 0.0f;
            }
            f2 = ocd78ebee9792.z$2besc61ybi4tc();
            bl3 = !bl;
        }
        return (bl2 ? f * f2 : f2 * f) / ocd63c3dcb1b.\u051a(bl3 ? n4 : n2);
    }

    public static float \u0253(ocd78ebee979 ocd78ebee9792, float f, float f2, byte[] byArray, int n, float f3, float f4, float f5, int n2, boolean bl, float f6, float f7, float[] fArray) {
        int n3 = oc3004491957.\u0182(f3 * ocd63c3dcb1b.\u051a(0x3F166C34 ^ 0x3F3D2284));
        float f8 = (short)n3;
        float f9 = f;
        float f10 = f;
        float f11 = f2 += ocd63c3dcb1b.\u0146(ocd78ebee9792, bl, n2, f8, 0x3F166C34 ^ 0x3F3D2284, 0x3F166C30 ^ 0x3F3D2284, 0x3F166C3C ^ 0x3F3D2284, 0x3F166C38 ^ 0x3F3D2284, false);
        float f12 = f2;
        float f13 = f8 / ocd63c3dcb1b.\u051a(0x3F166C34 ^ 0x3F3D2284) / (float)ocd78ebee9792.z$3reop5w4manwh();
        oc66ab65400a oc66ab65400a2 = new oc66ab65400a(f, f2);
        occ1875d4f2d occ1875d4f2d2 = new occ1875d4f2d();
        int n4 = -1;
        for (int i = 0; i < n; ++i) {
            if (!occ1875d4f2d2.\u0507(byArray[i])) continue;
            ocf13aa48070 ocf13aa480702 = ocd78ebee9792.z$ru87w5pic870(occ1875d4f2d2.\u047f, n3, (short)oc3004491957.\u0182(f4), 1);
            if (ocf13aa480702 == null) {
                n4 = -1;
                continue;
            }
            oc53b6121dc1 oc53b6121dc12 = ocd63c3dcb1b.\u00fb(ocd78ebee9792, ocf13aa480702, n4, f13, f5, oc66ab65400a2, bl, f6, f7);
            float f14 = bl ? oc53b6121dc12.\u01fe : oc53b6121dc12.\u04fd;
            float f15 = bl ? oc53b6121dc12.\u04fd : oc53b6121dc12.\u01fe;
            f11 = oc62a465bc97.\u0517(f14, f11);
            f12 = f15 > f12 ? f15 : f12;
            f9 = oc62a465bc97.\u0517(oc53b6121dc12.\u0516, f9);
            f10 = oc62a465bc97.\u057f(oc53b6121dc12.\u03dc, f10);
            n4 = ocf13aa480702.\u04cc;
        }
        float f16 = oc66ab65400a2.\u0129 - f;
        if ((n2 & 1) == 0) {
            if ((n2 & (0x3F3D2280 ^ 0x3F3D2284)) != 0) {
                f9 -= f16;
                f10 -= f16;
            } else if ((n2 & (0x3F3D2286 ^ 0x3F3D2284)) != 0) {
                float f17 = ocd63c3dcb1b.\u051a(0x3F166C38 ^ 0x3F3D2284) * f16;
                f9 += f17;
                f10 += f17;
            }
        }
        if (fArray != null) {
            fArray[0] = f9;
            fArray[1] = f11;
            fArray[0x3F3D2286 ^ 0x3F3D2284] = f10;
            fArray[0x3F3D2287 ^ 0x3F3D2284] = f12;
        }
        return f16;
    }

    public static float[] \u0525(ocd78ebee979 ocd78ebee9792, float f, float f2, int n, boolean bl) {
        float f3 = (short)oc3004491957.\u0182(f2 * ocd63c3dcb1b.\u051a(0x954E038A ^ 0x95654CBE));
        f += ocd63c3dcb1b.\u0146(ocd78ebee9792, bl, n, f3, 0x954E038A ^ 0x95654CBE, 0x954E0386 ^ 0x95654CBE, 0x954E0382 ^ 0x95654CBE, 0x954E03FE ^ 0x95654CBE, false);
        if (bl) {
            float[] fArray = new float[0x95654CBC ^ 0x95654CBE];
            fArray[0] = f -= ocd78ebee9792.z$1dwkeyeylat9c() * f3 / ocd63c3dcb1b.\u051a(0x954E038A ^ 0x95654CBE);
            fArray[1] = f3 * ocd78ebee9792.z$v8k2n88ulsas() / ocd63c3dcb1b.\u051a(0x954E038A ^ 0x95654CBE) + f;
            return fArray;
        }
        f = ocd78ebee9792.z$2besc61ybi4tc() * f3 / ocd63c3dcb1b.\u051a(0x954E038A ^ 0x95654CBE) + f;
        float[] fArray = new float[0x95654CBC ^ 0x95654CBE];
        fArray[0] = f - f3 * ocd78ebee9792.z$v8k2n88ulsas() / ocd63c3dcb1b.\u051a(0x954E038A ^ 0x95654CBE);
        fArray[1] = f;
        return fArray;
    }

    public static int \u011f(int n) {
        int n2 = ~(n << (0x9353FB2E ^ 0x9353FB21)) + n;
        n2 ^= n2 >>> (0x9353FB2B ^ 0x9353FB21);
        n2 *= 0x9353FB28 ^ 0x9353FB21;
        n2 ^= n2 >>> (0x9353FB27 ^ 0x9353FB21);
        n2 = ~(n2 << (0x9353FB2A ^ 0x9353FB21)) + n2;
        n2 ^= n2 >>> (0x9353FB31 ^ 0x9353FB21);
        return n2 & (0x9353FBDE ^ 0x9353FB21);
    }

    private static int I(byte[] byArray, int n, int n2, int n3) {
        int n4 = ((byArray[n] & (0x65D959CA ^ 0x65D95935)) << (0x65D95932 ^ 0x65D95935)) - n2;
        byArray[n] = (byte)((n2 += n3 * n4 >> (0x65D95925 ^ 0x65D95935)) >>> (0x65D95932 ^ 0x65D95935));
        return n2;
    }

    public static void \u00e1(byte[] byArray, int n, int n2, int n3, int n4, int n5) {
        for (int i = 0; i < (0x1C3CFE5D ^ 0x1C3CFE5F); ++i) {
            int n6;
            int n7;
            int n8;
            int n9;
            for (n9 = 0; n9 < n2; ++n9) {
                n8 = n + n9;
                n7 = 0;
                for (n6 = 1; n6 < n3; ++n6) {
                    n7 = ocd63c3dcb1b.I(byArray, n8 + n6 * n4, n7, n5);
                }
                byArray[n8 + (n3 - 1) * n4] = 0;
                n7 = 0;
                for (n6 = n3 - (0x1C3CFE5D ^ 0x1C3CFE5F); n6 >= 0; --n6) {
                    n7 = ocd63c3dcb1b.I(byArray, n8 + n6 * n4, n7, n5);
                }
                byArray[n8] = 0;
            }
            for (n9 = 0; n9 < n3; ++n9) {
                n8 = n + n9 * n4;
                n7 = 0;
                for (n6 = 1; n6 < n2; ++n6) {
                    n7 = ocd63c3dcb1b.I(byArray, n8 + n6, n7, n5);
                }
                byArray[n8 + n2 - 1] = 0;
                n7 = 0;
                for (n6 = n2 - (0x1C3CFE5D ^ 0x1C3CFE5F); n6 >= 0; --n6) {
                    n7 = ocd63c3dcb1b.I(byArray, n8 + n6, n7, n5);
                }
                byArray[n8] = 0;
            }
        }
    }

    public static float \u0538(float[] fArray, float f, float f2, float f3, float f4) {
        float f5 = (float)StrictMath.sqrt(fArray[0] * fArray[0] + fArray[0xFEEDEEF ^ 0xFEEDEED] * fArray[0xFEEDEEF ^ 0xFEEDEED]);
        float f6 = (float)StrictMath.sqrt(fArray[1] * fArray[1] + fArray[0xFEEDEEE ^ 0xFEEDEED] * fArray[0xFEEDEEE ^ 0xFEEDEED]);
        float f7 = f6 + f5;
        f7 = f7 * f / f2 + f;
        float f8 = oc3004491957.\u0182(f7);
        return oc62a465bc97.\u0517(f8 * f2, f3) * f4;
    }

    public static float \u04c3(ocd78ebee979 ocd78ebee9792, int n, float f, float f2, byte[] byArray, int n2, float f3, float f4, float f5, int n3, boolean bl, float f6, float f7, float[] fArray, float f8, float[] fArray2) {
        if (n == -1) {
            return 0.0f;
        }
        float f9 = ocd63c3dcb1b.\u0538(fArray, ocd63c3dcb1b.\u051a(0xE9A949CB ^ 0xE9821EDB), ocd63c3dcb1b.\u051a(0xE9A949CF ^ 0xE9821EDB), ocd63c3dcb1b.\u051a(0xE9A949C3 ^ 0xE9821EDB), f8);
        float f10 = ocd63c3dcb1b.\u051a(0xE9A949C7 ^ 0xE9821EDB) / f9;
        float f11 = f2 * f9;
        float f12 = ocd63c3dcb1b.\u0253(ocd78ebee9792, f * f9, f11, byArray, n2, f3 * f9, f4 * f9, f5 * f9, n3, bl, f6, f7, fArray2);
        if (fArray2 != null) {
            float[] fArray3 = ocd63c3dcb1b.\u0525(ocd78ebee9792, f11, f3 * f9, n3, bl);
            fArray2[1] = fArray3[0];
            fArray2[0xE9821ED8 ^ 0xE9821EDB] = fArray3[1];
            for (int i = 0; i < (0xE9821EDF ^ 0xE9821EDB); ++i) {
                fArray2[i] = f10 * fArray2[i];
            }
        }
        return f10 * f12;
    }

    public static float[][] \u0452(oc53b6121dc1 oc53b6121dc12, float f, float[] fArray) {
        float f2;
        float f3 = oc53b6121dc12.\u01fe;
        float f4 = oc53b6121dc12.\u04fd;
        float f5 = oc53b6121dc12.\u0182;
        float f6 = oc53b6121dc12.\u03d1;
        float f7 = fArray[0x2E14F723 ^ 0x2E14F720] * fArray[0] - fArray[1] * fArray[0x2E14F722 ^ 0x2E14F720];
        if (0.0f > f7) {
            f2 = f3;
            f3 = f4;
            f4 = f2;
            f2 = f5;
            f5 = f6;
            f6 = f2;
        }
        f2 = oc53b6121dc12.\u0516 * f;
        float f8 = oc53b6121dc12.\u03dc * f;
        float[] fArray2 = ocd63c3dcb1b.\u0578(fArray, f2, f3 *= f);
        float[] fArray3 = ocd63c3dcb1b.\u0578(fArray, f8, f3);
        float[] fArray4 = ocd63c3dcb1b.\u0578(fArray, f8, f4 *= f);
        float[] fArray5 = ocd63c3dcb1b.\u0578(fArray, f2, f4);
        float[][] fArrayArray = new float[0x2E14F726 ^ 0x2E14F720][];
        float[] fArray6 = new float[0x2E14F724 ^ 0x2E14F720];
        fArray6[0] = fArray2[0];
        fArray6[1] = fArray2[1];
        fArray6[0x2E14F722 ^ 0x2E14F720] = oc53b6121dc12.\u0570;
        fArray6[0x2E14F723 ^ 0x2E14F720] = f5;
        fArrayArray[0] = fArray6;
        float[] fArray7 = new float[0x2E14F724 ^ 0x2E14F720];
        fArray7[0] = fArray4[0];
        fArray7[1] = fArray4[1];
        fArray7[0x2E14F722 ^ 0x2E14F720] = oc53b6121dc12.\u0156;
        fArray7[0x2E14F723 ^ 0x2E14F720] = f6;
        fArrayArray[1] = fArray7;
        float[] fArray8 = new float[0x2E14F724 ^ 0x2E14F720];
        fArray8[0] = fArray3[0];
        fArray8[1] = fArray3[1];
        fArray8[0x2E14F722 ^ 0x2E14F720] = oc53b6121dc12.\u0156;
        fArray8[0x2E14F723 ^ 0x2E14F720] = f5;
        fArrayArray[0x2E14F722 ^ 0x2E14F720] = fArray8;
        float[] fArray9 = new float[0x2E14F724 ^ 0x2E14F720];
        fArray9[0] = fArray2[0];
        fArray9[1] = fArray2[1];
        fArray9[0x2E14F722 ^ 0x2E14F720] = oc53b6121dc12.\u0570;
        fArray9[0x2E14F723 ^ 0x2E14F720] = f5;
        fArrayArray[0x2E14F723 ^ 0x2E14F720] = fArray9;
        float[] fArray10 = new float[0x2E14F724 ^ 0x2E14F720];
        fArray10[0] = fArray5[0];
        fArray10[1] = fArray5[1];
        fArray10[0x2E14F722 ^ 0x2E14F720] = oc53b6121dc12.\u0570;
        fArray10[0x2E14F723 ^ 0x2E14F720] = f6;
        fArrayArray[0x2E14F724 ^ 0x2E14F720] = fArray10;
        float[] fArray11 = new float[0x2E14F724 ^ 0x2E14F720];
        fArray11[0] = fArray4[0];
        fArray11[1] = fArray4[1];
        fArray11[0x2E14F722 ^ 0x2E14F720] = oc53b6121dc12.\u0156;
        fArray11[0x2E14F723 ^ 0x2E14F720] = f6;
        fArrayArray[0x2E14F725 ^ 0x2E14F720] = fArray11;
        return fArrayArray;
    }

    private static float[] \u0578(float[] fArray, float f, float f2) {
        float[] fArray2 = new float[0xD0DE56D5 ^ 0xD0DE56D7];
        fArray2[0] = f * fArray[0] + f2 * fArray[0xD0DE56D5 ^ 0xD0DE56D7] + fArray[0xD0DE56D3 ^ 0xD0DE56D7];
        fArray2[1] = f * fArray[1] + f2 * fArray[0xD0DE56D4 ^ 0xD0DE56D7] + fArray[0xD0DE56D2 ^ 0xD0DE56D7];
        return fArray2;
    }

    public static float \u02e3(oc56e3ec4ee3 oc56e3ec4ee32, float f, float f2, float[] fArray, oc4b4b5da6c6 oc4b4b5da6c62, oc2d39c317eb oc2d39c317eb2) {
        int n = oc56e3ec4ee32.\u0539.length;
        int n2 = (n >= (0x3216FAA3 ^ 0x3216FAA0) ? n : 0x3216FAA2 ^ 0x3216FAA0) * (0x3216FAA6 ^ 0x3216FAA0);
        if (!oc4b4b5da6c62.z$1hzotucotrctd(n2 + (0x3216FA5F ^ 0x3216FAA0) & (0x4DE905A0 ^ 0x3216FAA0))) {
            return f;
        }
        ArrayList<float[]> arrayList = new ArrayList<float[]>();
        oc53b6121dc1 oc53b6121dc12 = new oc53b6121dc1();
        int[] nArray = ocd63c3dcb1b.\u01aa(oc56e3ec4ee32);
        float[] fArray2 = new float[0x3216FAA2 ^ 0x3216FAA0];
        fArray2[0] = oc56e3ec4ee32.\u01aa.\u0129;
        fArray2[1] = oc56e3ec4ee32.\u01aa.\u024b;
        float[] fArray3 = fArray2;
        float f3 = ocd63c3dcb1b.\u051a(0x323DAC34 ^ 0x3216FAA0) / f2;
        while (oc56e3ec4ee32.\u04a2(oc53b6121dc12)) {
            if (oc56e3ec4ee32.\u0110 == -1) {
                if (!arrayList.isEmpty()) {
                    oc4b4b5da6c62.z$2yoi8bjxqdeix(arrayList);
                    ++oc2d39c317eb2.\u00c4;
                    oc2d39c317eb2.\u0110 += arrayList.size() / (0x3216FAA3 ^ 0x3216FAA0);
                }
                if (!oc4b4b5da6c62.z$2m538xvys2mci()) {
                    arrayList.clear();
                    break;
                }
                ocd63c3dcb1b.\u03d9(oc56e3ec4ee32, nArray, fArray3);
                oc56e3ec4ee32.\u04a2(oc53b6121dc12);
                arrayList.clear();
                if (oc56e3ec4ee32.\u0110 == -1) break;
            }
            nArray = ocd63c3dcb1b.\u01aa(oc56e3ec4ee32);
            float[] fArray4 = new float[0x3216FAA2 ^ 0x3216FAA0];
            fArray4[0] = oc56e3ec4ee32.\u01aa.\u0129;
            fArray4[1] = oc56e3ec4ee32.\u01aa.\u024b;
            fArray3 = fArray4;
            if (arrayList.size() + (0x3216FAA6 ^ 0x3216FAA0) > n2) continue;
            Collections.addAll(arrayList, ocd63c3dcb1b.\u0452(oc53b6121dc12, f3, fArray));
        }
        oc4b4b5da6c62.z$281dh0fsip3jd();
        oc4b4b5da6c62.z$2yoi8bjxqdeix(arrayList);
        ++oc2d39c317eb2.\u00c4;
        oc2d39c317eb2.\u0110 += arrayList.size() / (0x3216FAA3 ^ 0x3216FAA0);
        return oc56e3ec4ee32.\u01aa.\u0129 / f2;
    }

    private static int[] \u01aa(oc56e3ec4ee3 oc56e3ec4ee32) {
        int[] nArray = new int[0xD5E03A8B ^ 0xD5E03A8C];
        nArray[0] = oc56e3ec4ee32.\u0582;
        nArray[1] = oc56e3ec4ee32.W;
        nArray[0xD5E03A8E ^ 0xD5E03A8C] = oc56e3ec4ee32.\u0110;
        nArray[0xD5E03A8F ^ 0xD5E03A8C] = oc56e3ec4ee32.\u043b.\u054d;
        nArray[0xD5E03A88 ^ 0xD5E03A8C] = oc56e3ec4ee32.\u043b.\u047f;
        nArray[0xD5E03A89 ^ 0xD5E03A8C] = Float.floatToRawIntBits(oc56e3ec4ee32.\u0250);
        nArray[0xD5E03A8A ^ 0xD5E03A8C] = Float.floatToRawIntBits(oc56e3ec4ee32.\u04f8);
        return nArray;
    }

    private static void \u03d9(oc56e3ec4ee3 oc56e3ec4ee32, int[] nArray, float[] fArray) {
        oc56e3ec4ee32.\u0582 = nArray[0];
        oc56e3ec4ee32.W = nArray[1];
        oc56e3ec4ee32.\u0110 = nArray[0x2605CA59 ^ 0x2605CA5B];
        oc56e3ec4ee32.\u043b.\u054d = nArray[0x2605CA58 ^ 0x2605CA5B];
        oc56e3ec4ee32.\u043b.\u047f = nArray[0x2605CA5F ^ 0x2605CA5B];
        oc56e3ec4ee32.\u0250 = Float.intBitsToFloat(nArray[0x2605CA5E ^ 0x2605CA5B]);
        oc56e3ec4ee32.\u04f8 = Float.intBitsToFloat(nArray[0x2605CA5D ^ 0x2605CA5B]);
        oc56e3ec4ee32.\u01aa.\u0129 = fArray[0];
        oc56e3ec4ee32.\u01aa.\u024b = fArray[1];
    }
}

