/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.renderer.GlStateManager;
import x.oc06b9308b3c;
import x.oc1dbdddc1e9;
import x.oc33f9a73cbd;
import x.ocb579fc6994;
import x.oce634a371c2;
import x.ocf30607050c;

public class oc1aae86a55a
implements oc1dbdddc1e9 {
    private static final oc33f9a73cbd \u0240 = new ocf30607050c();
    private final oc33f9a73cbd \u048f;

    public oc1aae86a55a() {
        this(\u0240);
    }

    public oc1aae86a55a(oc33f9a73cbd oc33f9a73cbd2) {
        this.\u048f = Objects.requireNonNull(oc33f9a73cbd2);
    }

    @Override
    public void z$219pbvor6g5ok(oc06b9308b3c oc06b9308b3c2, int[] nArray, float[] fArray, float[] fArray2, float f, List<ocb579fc6994> list, float[] fArray3) {
        this.\u048f.z$2s7347vx00vmh(nArray);
        for (ocb579fc6994 ocb579fc69942 : list) {
            this.\u0214(0x65AA9AF5 ^ 0x65AA9AF3, ocb579fc69942.\u0389, oc06b9308b3c2, 1.0f, false);
            if (ocb579fc69942.\u0145.isEmpty()) continue;
            this.\u0214(0x65AA9AF6 ^ 0x65AA9AF3, ocb579fc69942.\u0145, oc06b9308b3c2, 1.0f, true);
        }
    }

    @Override
    public void z$3iv8gkrmvrc59(oc06b9308b3c oc06b9308b3c2, int[] nArray, float[] fArray, float[] fArray2, float f, float f2, List<ocb579fc6994> list) {
        this.\u048f.z$2s7347vx00vmh(nArray);
        float f3 = f == 0.0f ? 1.0f : (f2 * 0.5f + f * 0.5f) / f;
        for (ocb579fc6994 ocb579fc69942 : list) {
            this.\u0214(0x4FDB7BBD ^ 0x4FDB7BB8, ocb579fc69942.\u0145, oc06b9308b3c2, f3, true);
        }
    }

    private void \u0214(int n, List<float[]> list, oc06b9308b3c oc06b9308b3c2, float f, boolean bl) {
        if (!list.isEmpty()) {
            if (this.\u048f == \u0240 && oce634a371c2.\u03cb()) {
                GlStateManager.disableTexture2D();
                GlStateManager.disableAlpha();
                oce634a371c2.V(n, list, oc06b9308b3c2, f, bl);
            } else {
                List<float[]> list2 = bl ? oc1aae86a55a.\u0264(n, list, f) : list;
                ArrayList<float[]> arrayList = new ArrayList<float[]>();
                for (float[] fArray : list2) {
                    float f2 = bl ? fArray[0xC5712F6D ^ 0xC5712F69] : 1.0f;
                    float[] fArray2 = oc1aae86a55a.\u017d(oc06b9308b3c2, fArray[0], fArray[1]);
                    float[] fArray3 = new float[0xC5712F6F ^ 0xC5712F69];
                    fArray3[0] = fArray[0];
                    fArray3[1] = fArray[1];
                    fArray3[0xC5712F6B ^ 0xC5712F69] = fArray2[0];
                    fArray3[0xC5712F6A ^ 0xC5712F69] = fArray2[1];
                    fArray3[0xC5712F6D ^ 0xC5712F69] = fArray2[0xC5712F6B ^ 0xC5712F69];
                    fArray3[0xC5712F6C ^ 0xC5712F69] = fArray2[0xC5712F6A ^ 0xC5712F69] * f2;
                    arrayList.add(fArray3);
                }
                this.\u048f.z$1chj8mtkruq7y(bl ? 0xC5712F6D ^ 0xC5712F69 : n, arrayList);
            }
        }
    }

    public static List<float[]> \u0264(int n, List<float[]> list, float f) {
        float[] fArray;
        ArrayList<float[]> arrayList = new ArrayList<float[]>();
        if (f > 1.0f) {
            float[] fArray2 = new float[0xBE8AC69D ^ 0xBE8AC699];
            fArray2[0] = 0.0f;
            fArray2[1] = 0.5f / f;
            fArray2[0xBE8AC69B ^ 0xBE8AC699] = 1.0f - 0.5f / f;
            fArray = fArray2;
            fArray2[0xBE8AC69A ^ 0xBE8AC699] = 1.0f;
        } else {
            float[] fArray3 = new float[0xBE8AC69A ^ 0xBE8AC699];
            fArray3[0] = 0.0f;
            fArray3[1] = 0.5f;
            fArray = fArray3;
            fArray3[0xBE8AC69B ^ 0xBE8AC699] = 1.0f;
        }
        float[] fArray4 = fArray;
        for (int i = 0xBE8AC69B ^ 0xBE8AC699; i < list.size(); ++i) {
            float[] fArray5;
            float[] fArray6 = list.get(i - 1);
            float[] fArray7 = list.get(i);
            if (n == (0xBE8AC69F ^ 0xBE8AC699)) {
                fArray5 = list.get(0);
            } else {
                if (n != (0xBE8AC69C ^ 0xBE8AC699)) {
                    throw new IllegalArgumentException("Unsupported canvas fringe primitive");
                }
                fArray5 = list.get(i - (0xBE8AC69B ^ 0xBE8AC699));
                if ((i & 1) != 0) {
                    float[] fArray8 = fArray5;
                    fArray5 = fArray6;
                    fArray6 = fArray8;
                }
            }
            float f2 = Math.min(fArray5[0xBE8AC69B ^ 0xBE8AC699], Math.min(fArray6[0xBE8AC69B ^ 0xBE8AC699], fArray7[0xBE8AC69B ^ 0xBE8AC699]));
            float f3 = Math.max(fArray5[0xBE8AC69B ^ 0xBE8AC699], Math.max(fArray6[0xBE8AC69B ^ 0xBE8AC699], fArray7[0xBE8AC69B ^ 0xBE8AC699]));
            if (f2 == f3) {
                oc1aae86a55a.\u0285(arrayList, fArray5, fArray6, fArray7, f, 0);
                continue;
            }
            for (int j = 1; j < fArray4.length; ++j) {
                float[][] fArrayArray = new float[0xBE8AC69A ^ 0xBE8AC699][];
                fArrayArray[0] = fArray5;
                fArrayArray[1] = fArray6;
                fArrayArray[0xBE8AC69B ^ 0xBE8AC699] = fArray7;
                List<float[]> list2 = oc1aae86a55a.\u0512(Arrays.asList(fArrayArray), fArray4[j - 1], true);
                list2 = oc1aae86a55a.\u0512(list2, fArray4[j], false);
                for (int k = 0xBE8AC69B ^ 0xBE8AC699; k < list2.size(); ++k) {
                    oc1aae86a55a.\u0285(arrayList, list2.get(0), list2.get(k - 1), list2.get(k), f, 0);
                }
            }
        }
        return arrayList;
    }

    private static List<float[]> \u0512(List<float[]> list, float f, boolean bl) {
        ArrayList<float[]> arrayList = new ArrayList<float[]>();
        if (list.isEmpty()) {
            return arrayList;
        }
        float[] fArray = list.get(list.size() - 1);
        boolean bl2 = bl ? fArray[0xF4DABDB ^ 0xF4DABD9] >= f : fArray[0xF4DABDB ^ 0xF4DABD9] <= f;
        for (float[] fArray2 : list) {
            boolean bl3;
            boolean bl4 = bl ? fArray2[0xF4DABDB ^ 0xF4DABD9] >= f : (bl3 = fArray2[0xF4DABDB ^ 0xF4DABD9] <= f);
            if (bl2 != bl3) {
                float f2 = (f - fArray[0xF4DABDB ^ 0xF4DABD9]) / (fArray2[0xF4DABDB ^ 0xF4DABD9] - fArray[0xF4DABDB ^ 0xF4DABD9]);
                float[] fArray3 = oc1aae86a55a.\u01fe(fArray, fArray2, f2);
                fArray3[0xF4DABDB ^ 0xF4DABD9] = f;
                arrayList.add(fArray3);
            }
            if (bl3) {
                arrayList.add(fArray2);
            }
            fArray = fArray2;
            bl2 = bl3;
        }
        return arrayList;
    }

    private static float[] \u01fe(float[] fArray, float[] fArray2, float f) {
        float[] fArray3 = new float[0x46FABF83 ^ 0x46FABF87];
        for (int i = 0; i < (0x46FABF83 ^ 0x46FABF87); ++i) {
            fArray3[i] = fArray[i] + (fArray2[i] - fArray[i]) * f;
        }
        return fArray3;
    }

    public static float \u0143(float f, float f2, float f3) {
        return Math.min(1.0f, Math.max(0.0f, (1.0f - Math.abs(f * 2.0f - 1.0f)) * f3)) * Math.min(1.0f, f2);
    }

    private static void \u0285(List<float[]> list, float[] fArray, float[] fArray2, float[] fArray3, float f, int n) {
        float f2 = (fArray2[0] - fArray[0]) * (fArray3[1] - fArray[1]) - (fArray2[1] - fArray[1]) * (fArray3[0] - fArray[0]);
        if (f2 != 0.0f) {
            float f3 = oc1aae86a55a.\u0143(fArray[0x241C99A8 ^ 0x241C99AA], fArray[0x241C99A9 ^ 0x241C99AA], f);
            float f4 = oc1aae86a55a.\u0143(fArray2[0x241C99A8 ^ 0x241C99AA], fArray2[0x241C99A9 ^ 0x241C99AA], f);
            float f5 = oc1aae86a55a.\u0143(fArray3[0x241C99A8 ^ 0x241C99AA], fArray3[0x241C99A9 ^ 0x241C99AA], f);
            float[] fArray4 = oc1aae86a55a.\u01fe(fArray, fArray2, 0.5f);
            float[] fArray5 = oc1aae86a55a.\u01fe(fArray3, fArray, 0.5f);
            float[] fArray6 = oc1aae86a55a.\u01fe(fArray3, fArray2, 0.5f);
            float f6 = Math.max(Math.abs(oc1aae86a55a.\u0143(fArray4[0x241C99A8 ^ 0x241C99AA], fArray4[0x241C99A9 ^ 0x241C99AA], f) - (f3 + f4) * 0.5f), Math.max(Math.abs(oc1aae86a55a.\u0143(fArray5[0x241C99A8 ^ 0x241C99AA], fArray5[0x241C99A9 ^ 0x241C99AA], f) - (f5 + f3) * 0.5f), Math.abs(oc1aae86a55a.\u0143(fArray6[0x241C99A8 ^ 0x241C99AA], fArray6[0x241C99A9 ^ 0x241C99AA], f) - (f5 + f4) * 0.5f)));
            if (f6 > 9.765625E-4f && n < (0x241C99AC ^ 0x241C99AA)) {
                oc1aae86a55a.\u0285(list, fArray, fArray4, fArray5, f, n + 1);
                oc1aae86a55a.\u0285(list, fArray4, fArray2, fArray6, f, n + 1);
                oc1aae86a55a.\u0285(list, fArray5, fArray6, fArray3, f, n + 1);
                oc1aae86a55a.\u0285(list, fArray4, fArray6, fArray5, f, n + 1);
            } else {
                float[] fArray7 = new float[0x241C99AF ^ 0x241C99AA];
                fArray7[0] = fArray[0];
                fArray7[1] = fArray[1];
                fArray7[0x241C99A8 ^ 0x241C99AA] = fArray[0x241C99A8 ^ 0x241C99AA];
                fArray7[0x241C99A9 ^ 0x241C99AA] = fArray[0x241C99A9 ^ 0x241C99AA];
                fArray7[0x241C99AE ^ 0x241C99AA] = f3;
                list.add(fArray7);
                float[] fArray8 = new float[0x241C99AF ^ 0x241C99AA];
                fArray8[0] = fArray2[0];
                fArray8[1] = fArray2[1];
                fArray8[0x241C99A8 ^ 0x241C99AA] = fArray2[0x241C99A8 ^ 0x241C99AA];
                fArray8[0x241C99A9 ^ 0x241C99AA] = fArray2[0x241C99A9 ^ 0x241C99AA];
                fArray8[0x241C99AE ^ 0x241C99AA] = f4;
                list.add(fArray8);
                float[] fArray9 = new float[0x241C99AF ^ 0x241C99AA];
                fArray9[0] = fArray3[0];
                fArray9[1] = fArray3[1];
                fArray9[0x241C99A8 ^ 0x241C99AA] = fArray3[0x241C99A8 ^ 0x241C99AA];
                fArray9[0x241C99A9 ^ 0x241C99AA] = fArray3[0x241C99A9 ^ 0x241C99AA];
                fArray9[0x241C99AE ^ 0x241C99AA] = f5;
                list.add(fArray9);
            }
        }
    }

    public static float[] \u017d(oc06b9308b3c oc06b9308b3c2, float f, float f2) {
        float[] fArray = oc06b9308b3c2.\u013f;
        float f3 = fArray[0] * fArray[0x14F2ABDF ^ 0x14F2ABDC] - fArray[1] * fArray[0x14F2ABDE ^ 0x14F2ABDC];
        float f4 = 0.0f;
        if (f3 != 0.0f && oc06b9308b3c2.\u04b2 != 0.0f) {
            float f5 = ((f - fArray[0x14F2ABD8 ^ 0x14F2ABDC]) * fArray[0x14F2ABDF ^ 0x14F2ABDC] - (f2 - fArray[0x14F2ABD9 ^ 0x14F2ABDC]) * fArray[0x14F2ABDE ^ 0x14F2ABDC]) / f3;
            float f6 = ((f2 - fArray[0x14F2ABD9 ^ 0x14F2ABDC]) * fArray[0] - (f - fArray[0x14F2ABD8 ^ 0x14F2ABDC]) * fArray[1]) / f3;
            float f7 = Math.abs(f5) - oc06b9308b3c2.\u026a[0] + oc06b9308b3c2.\u02a9;
            float f8 = Math.abs(f6) - oc06b9308b3c2.\u026a[1] + oc06b9308b3c2.\u02a9;
            float f9 = Math.min(Math.max(f7, f8), 0.0f) + (float)StrictMath.sqrt(Math.max(f7, 0.0f) * Math.max(f7, 0.0f) + Math.max(f8, 0.0f) * Math.max(f8, 0.0f)) - oc06b9308b3c2.\u02a9;
            f4 = Math.max(0.0f, Math.min(1.0f, (f9 + oc06b9308b3c2.\u04b2 * 0.5f) / oc06b9308b3c2.\u04b2));
        }
        float[] fArray2 = new float[0x14F2ABD8 ^ 0x14F2ABDC];
        for (int i = 0; i < (0x14F2ABD8 ^ 0x14F2ABDC); ++i) {
            fArray2[i] = oc06b9308b3c2.\u0180[i] + (oc06b9308b3c2.\u02af[i] - oc06b9308b3c2.\u0180[i]) * f4;
        }
        return fArray2;
    }
}

