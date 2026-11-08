/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import x.L;
import x.oc0e43a7e4c4;
import x.oc2f988f0583;
import x.oc3004491957;
import x.oc32b50dcd85;
import x.oc62a465bc97;
import x.ocd1cb14b5c3;
import x.ocfad8dd9638;
import x.ocfb6751b034;

public class oc173282b3d7 {
    private static float \u03b3(int n) {
        return L.\u026d(n);
    }

    private static float F(float f) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f) ^ L.\u0497(0x6C043F68 ^ 0x6C2F73B8));
    }

    private static List<List<float[]>> \u01cd(List<ocd1cb14b5c3> list, float f) {
        ArrayList<List<float[]>> arrayList = new ArrayList<List<float[]>>();
        ArrayList<float[]> arrayList2 = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (ocd1cb14b5c3 ocd1cb14b5c32 : list) {
            if (ocd1cb14b5c32.\u021e == 1) {
                arrayList2 = new ArrayList<float[]>();
                arrayList.add(arrayList2);
                f2 = ocd1cb14b5c32.\u04c1;
                f3 = ocd1cb14b5c32.\u0122;
                float[] fArray = new float[0xC52DD2F0 ^ 0xC52DD2F2];
                fArray[0] = f2;
                fArray[1] = f3;
                arrayList2.add(fArray);
                continue;
            }
            if (ocd1cb14b5c32.\u021e == (0xC52DD2F0 ^ 0xC52DD2F2)) {
                f2 = ocd1cb14b5c32.\u04c1;
                f3 = ocd1cb14b5c32.\u0122;
                float[] fArray = new float[0xC52DD2F0 ^ 0xC52DD2F2];
                fArray[0] = f2;
                fArray[1] = f3;
                arrayList2.add(fArray);
                continue;
            }
            if (ocd1cb14b5c32.\u021e == (0xC52DD2F1 ^ 0xC52DD2F2)) {
                oc2f988f0583.\u0228(arrayList2, f2, f3, ocd1cb14b5c32.\u025c, ocd1cb14b5c32.\u0518, ocd1cb14b5c32.\u04c1, ocd1cb14b5c32.\u0122, f, 0);
                f2 = ocd1cb14b5c32.\u04c1;
                f3 = ocd1cb14b5c32.\u0122;
                continue;
            }
            if (ocd1cb14b5c32.\u021e != (0xC52DD2F6 ^ 0xC52DD2F2)) continue;
            oc2f988f0583.G(arrayList2, f2, f3, ocd1cb14b5c32.\u025c, ocd1cb14b5c32.\u0518, ocd1cb14b5c32.\u0131, ocd1cb14b5c32.\u044c, ocd1cb14b5c32.\u04c1, ocd1cb14b5c32.\u0122, f, 0);
            f2 = ocd1cb14b5c32.\u04c1;
            f3 = ocd1cb14b5c32.\u0122;
        }
        return arrayList;
    }

    private static void \u0154(float[] fArray, int n, ocfad8dd9638 ocfad8dd96382, float f, float f2, float f3, float f4) {
        if (f2 != f4 && !(f2 > ocfad8dd96382.\u03d9) && !(f4 < ocfad8dd96382.\u00f6)) {
            if (f2 < ocfad8dd96382.\u00f6) {
                f += (f3 - f) * (ocfad8dd96382.\u00f6 - f2) / (f4 - f2);
                f2 = ocfad8dd96382.\u00f6;
            }
            if (f4 > ocfad8dd96382.\u03d9) {
                f3 += (f3 - f) * (ocfad8dd96382.\u03d9 - f4) / (f4 - f2);
                f4 = ocfad8dd96382.\u03d9;
            }
            float f5 = n;
            float f6 = n + 1;
            float f7 = (f4 - f2) * ocfad8dd96382.\u048d;
            if (f <= f5 && f3 <= f5) {
                int n2 = n;
                fArray[n2] = fArray[n2] + f7;
            } else if (!(f >= f6) || !(f3 >= f6)) {
                float f8 = (f3 - f5 + (f - f5)) * oc173282b3d7.\u03b3(0xA00B27F4 ^ 0xA0206B18) + oc173282b3d7.\u03b3(0xA00B27F8 ^ 0xA0206B18);
                int n3 = n;
                fArray[n3] = fArray[n3] + f8 * f7;
            }
        }
    }

    private static void \u0481(float[] fArray, float[] fArray2, int n, ocfad8dd9638 ocfad8dd96382, float f, float f2, float f3, float f4) {
        oc173282b3d7.\u0154(fArray2, n, ocfad8dd96382, f, f2, f3, f4);
    }

    private static void \u0110(float[] fArray, float[] fArray2, List<ocfad8dd9638> list, float f, float f2) {
        int n = fArray.length;
        float f3 = oc173282b3d7.\u03b3(0x3DF73C76 ^ 0x3DDC7096);
        float f4 = oc173282b3d7.\u03b3(0x3DF73C7A ^ 0x3DDC7096);
        float f5 = oc173282b3d7.\u03b3(0x3DF73C66 ^ 0x3DDC7096);
        for (ocfad8dd9638 ocfad8dd96382 : list) {
            float f6 = ocfad8dd96382.\u01dd;
            float f7 = ocfad8dd96382.\u01bc;
            if (f7 != 0.0f) {
                float f8;
                float f9;
                float f10;
                float f11 = f7 + f6;
                float f12 = ocfad8dd96382.\u00f6 > f ? (ocfad8dd96382.\u00f6 - f) * f7 + f6 : f6;
                float f13 = f10 = ocfad8dd96382.\u03d9 < f2 ? (ocfad8dd96382.\u03d9 - f) * f7 + f6 : f11;
                if (f12 >= 0.0f && f10 >= 0.0f && f12 < (float)n && f10 < (float)n) {
                    float f14;
                    float f15;
                    float f16;
                    float f17;
                    int n2;
                    float f18 = oc62a465bc97.\u057f(ocfad8dd96382.\u00f6, f);
                    f9 = oc62a465bc97.\u0517(ocfad8dd96382.\u03d9, f2);
                    int n3 = oc3004491957.\u0182(f12);
                    if (n3 == (n2 = oc3004491957.\u0182(f10))) {
                        f8 = ((f10 - (float)n3 + (f12 - (float)n3)) * f4 + f3) * ocfad8dd96382.\u048d;
                        int n4 = n3;
                        fArray[n4] = fArray[n4] + f8 * (f9 - f18);
                        fArray2[n3 + 1] = (f9 - f18) * ocfad8dd96382.\u048d + fArray2[n3 + 1];
                        continue;
                    }
                    f8 = f12;
                    float f19 = f10;
                    float f20 = ocfad8dd96382.\u00f1;
                    float f21 = f6;
                    if (f12 > f10) {
                        f17 = f - f18 + f2;
                        f16 = f - f9 + f2;
                        f9 = f17;
                        f18 = f16;
                        f20 = oc173282b3d7.F(f20);
                        f8 = f10;
                        f19 = f12;
                        f21 = f11;
                        n3 = oc3004491957.\u0182(f10);
                        n2 = oc3004491957.\u0182(f12);
                    }
                    f17 = ((float)(n3 + 1) - f21) * f20 + f;
                    f16 = (f17 - f18) * ocfad8dd96382.\u048d;
                    float f22 = (f8 - (float)n3 + f3) * f4 + f3;
                    int n5 = n3;
                    fArray[n5] = fArray[n5] + f22 * f16;
                    int n6 = n2 - (n3 + 1);
                    if (n6 > 0) {
                        f15 = f20 * ocfad8dd96382.\u048d;
                        f14 = f15 * f5;
                        int n7 = n3 + 1;
                        while (n7 < n2) {
                            int n8 = n7++;
                            fArray[n8] = fArray[n8] + (f14 + f16);
                            f16 += f15;
                        }
                    }
                    f15 = f20 * (float)n6 + f17;
                    f14 = ((f19 - (float)n2) * f4 + f3) * ocfad8dd96382.\u048d;
                    int n9 = n2;
                    fArray[n9] = fArray[n9] + ((f9 - f15) * f14 + f16);
                    fArray2[n2 + 1] = (f9 - f18) * ocfad8dd96382.\u048d + fArray2[n2 + 1];
                    continue;
                }
                for (int i = 0; i < n; ++i) {
                    f9 = i;
                    float f23 = i + 1;
                    float f24 = (f9 - f6) / f7 + f;
                    f8 = (f23 - f6) / f7 + f;
                    if (f6 < f9 && f11 > f23) {
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f6, f, f9, f24);
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f9, f24, f23, f8);
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f23, f8, f11, f2);
                        continue;
                    }
                    if (f11 < f9 && f6 > f23) {
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f6, f, f23, f8);
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f23, f8, f9, f24);
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f9, f24, f11, f2);
                        continue;
                    }
                    if (!(f6 < f9 && f11 > f9 || f11 < f9 && f6 > f9)) {
                        if (!(f6 < f23 && f11 > f23 || f11 < f23 && f6 > f23)) {
                            oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f6, f, f11, f2);
                            continue;
                        }
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f6, f, f23, f8);
                        oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f23, f8, f11, f2);
                        continue;
                    }
                    oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f6, f, f9, f24);
                    oc173282b3d7.\u0154(fArray, i, ocfad8dd96382, f9, f24, f11, f2);
                }
                continue;
            }
            if (!(f6 < (float)n)) continue;
            if (f6 >= 0.0f) {
                int n10 = oc3004491957.\u0182(f6);
                oc173282b3d7.\u0154(fArray, n10, ocfad8dd96382, f6, f, f6, f2);
                oc173282b3d7.\u0481(fArray, fArray2, n10 + 1, ocfad8dd96382, f6, f, f6, f2);
                continue;
            }
            oc173282b3d7.\u0481(fArray, fArray2, 0, ocfad8dd96382, f6, f, f6, f2);
        }
    }

    public static void \u01a4(byte[] byArray, int n, int n2, int n3, int n4, float f, List<ocd1cb14b5c3> list, float f2, float f3, float f4, float f5, int n5, int n6, boolean bl, oc32b50dcd85 oc32b50dcd852) {
        if (!list.isEmpty()) {
            int n7 = 0;
            for (ocd1cb14b5c3 list2 : list) {
                if (list2.\u021e != 1) continue;
                ++n7;
            }
            if (n7 != 0 && oc32b50dcd852.\u02e4(n7 * (0xBE041B08 ^ 0xBE041B0C))) {
                float f6 = f / oc62a465bc97.\u0517(f3, f2);
                f = f6 * f6;
                List<List<float[]>> list2 = oc173282b3d7.\u01cd(list, f);
                int n8 = 0;
                for (List<float[]> list3 : list2) {
                    n8 += list3.size();
                }
                if (oc32b50dcd852.\u02e4(n8 * (0xBE041B04 ^ 0xBE041B0C))) {
                    List<List<float[]>> list4 = oc173282b3d7.\u01cd(list, f);
                    if (bl) {
                        f3 = oc173282b3d7.F(f3);
                    }
                    if (oc32b50dcd852.\u02e4(n8 * (0xBE041B18 ^ 0xBE041B0C) + (0xBE041B18 ^ 0xBE041B0C))) {
                        int n9;
                        float[] fArray;
                        ArrayList arrayList = new ArrayList();
                        for (List<float[]> list5 : list4) {
                            fArray = list5.get(list5.size() - 1);
                            for (Object object : list5) {
                                if (fArray[1] != object[1]) {
                                    n9 = bl ? (fArray[1] > object[1] ? 1 : 0) : (object[1] > fArray[1] ? 1 : 0);
                                    float[] fArray2 = (float[])(n9 != 0 ? fArray : object);
                                    Object object2 = n9 != 0 ? object : fArray;
                                    arrayList.add(new ocfb6751b034(fArray2[0] * f2 + f4, fArray2[1] * f3 + f5, object2[0] * f2 + f4, object2[1] * f3 + f5, n9 != 0 ? 1 : 0));
                                }
                                fArray = object;
                            }
                        }
                        ocfb6751b034[] ocfb6751b034Array = arrayList.toArray(new ocfb6751b034[0]);
                        oc2f988f0583.d(ocfb6751b034Array);
                        if ((n2 < (0xBE041B4D ^ 0xBE041B0C) || oc32b50dcd852.\u02e4(n2 * (0xBE041B04 ^ 0xBE041B0C) + (0xBE041B08 ^ 0xBE041B0C))) && n3 > 0) {
                            Object object;
                            float[] fArray3 = new float[n2];
                            fArray = new float[n2 + 1];
                            ArrayList arrayList2 = new ArrayList();
                            object = new oc0e43a7e4c4(oc32b50dcd852);
                            n9 = 0;
                            float f7 = oc173282b3d7.\u03b3(0xBE2F57EC ^ 0xBE041B0C);
                            int n10 = 0;
                            int n11 = n6;
                            while (n10 < n3) {
                                Object object3;
                                Object object4;
                                float f8 = n11;
                                float f9 = f8 + f7;
                                Arrays.fill(fArray3, 0.0f);
                                Arrays.fill(fArray, 0.0f);
                                Iterator iterator2 = arrayList2.iterator();
                                while (iterator2.hasNext()) {
                                    object4 = (ocfad8dd9638)iterator2.next();
                                    if (!(f8 >= ((ocfad8dd9638)object4).\u03d9)) continue;
                                    iterator2.remove();
                                    object.\u0167();
                                }
                                while (n9 < ocfb6751b034Array.length && f9 >= ocfb6751b034Array[n9].\u04b0) {
                                    object4 = ocfb6751b034Array[n9++];
                                    if (((ocfb6751b034)object4).\u04b0 == ((ocfb6751b034)object4).\u057a || !object.\u0545()) continue;
                                    object3 = new ocfad8dd9638();
                                    ((ocfad8dd9638)object3).\u01bc = (((ocfb6751b034)object4).\u0407 - ((ocfb6751b034)object4).\u0576) / (((ocfb6751b034)object4).\u057a - ((ocfb6751b034)object4).\u04b0);
                                    ((ocfad8dd9638)object3).\u00f1 = ((ocfad8dd9638)object3).\u01bc == 0.0f ? 0.0f : f7 / ((ocfad8dd9638)object3).\u01bc;
                                    ((ocfad8dd9638)object3).\u01dd = ((ocfad8dd9638)object3).\u01bc * (f8 - ((ocfb6751b034)object4).\u04b0) + ((ocfb6751b034)object4).\u0576 - (float)n5;
                                    ((ocfad8dd9638)object3).\u048d = oc173282b3d7.\u03b3(((ocfb6751b034)object4).\u0220 != 0 ? 0xBE2F57E8 ^ 0xBE041B0C : 0xBE2F57E4 ^ 0xBE041B0C);
                                    ((ocfad8dd9638)object3).\u00f6 = ((ocfb6751b034)object4).\u04b0;
                                    ((ocfad8dd9638)object3).\u03d9 = ((ocfb6751b034)object4).\u057a;
                                    if (n10 == 0 && n6 != 0 && f8 > ((ocfad8dd9638)object3).\u03d9) {
                                        ((ocfad8dd9638)object3).\u03d9 = f8;
                                    }
                                    arrayList2.add(0, object3);
                                }
                                oc173282b3d7.\u0110(fArray3, fArray, arrayList2, f8, f9);
                                float f10 = 0.0f;
                                for (int i = 0; i < n2; ++i) {
                                    float f11 = Float.intBitsToFloat(Float.floatToRawIntBits(fArray3[i] + (f10 += fArray[i])) & L.\u0497(0xBE2F560C ^ 0xBE041B0C));
                                    int n12 = oc3004491957.\u0182(f11 * oc173282b3d7.\u03b3(0xBE2F561C ^ 0xBE041B0C) + oc173282b3d7.\u03b3(0xBE2F57FC ^ 0xBE041B0C));
                                    if (n12 >= (0xBE041BF3 ^ 0xBE041B0C)) {
                                        n12 = 0xBE041BF3 ^ 0xBE041B0C;
                                    }
                                    byArray[n + n4 * n10 + i] = (byte)n12;
                                }
                                object3 = arrayList2.iterator();
                                while (object3.hasNext()) {
                                    ocfad8dd9638 ocfad8dd96382 = (ocfad8dd9638)object3.next();
                                    ocfad8dd96382.\u01dd = ocfad8dd96382.\u01bc + ocfad8dd96382.\u01dd;
                                }
                                ++n10;
                                ++n11;
                            }
                        }
                    }
                }
            }
        }
    }

    private oc173282b3d7() {
    }
}

