/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.L;
import x.oc173282b3d7;
import x.oc25e9d31d7d;
import x.oc3004491957;
import x.oc42b715e79d;
import x.oc5f397ea265;
import x.oc68aa547e4e;
import x.oc98904eb9e7;
import x.ocae3bb6ecc0;
import x.ocd1cb14b5c3;
import x.ocd63c3dcb1b;
import x.ocd78ebee979;
import x.ocdaf6bff4db;
import x.oceb7ed9a2d8;
import x.ocf13aa48070;

public class oca0f68927a8
implements ocd78ebee979 {
    private final oc5f397ea265 \u010c;
    private final ocae3bb6ecc0 \u0146;
    private final oc25e9d31d7d \u016a;

    public oca0f68927a8(oc5f397ea265 oc5f397ea2652, ocae3bb6ecc0 ocae3bb6ecc02) {
        this(oc5f397ea2652, ocae3bb6ecc02, null);
    }

    public oca0f68927a8(oc5f397ea265 oc5f397ea2652, ocae3bb6ecc0 ocae3bb6ecc02, oc25e9d31d7d oc25e9d31d7d2) {
        this.\u010c = oc5f397ea2652;
        this.\u0146 = ocae3bb6ecc02;
        this.\u016a = oc25e9d31d7d2;
    }

    private static float \u027b(int n) {
        return L.\u026d(n);
    }

    @Override
    public int z$3lozifh06bic(int n, int n2) {
        return this.\u016a == null ? ocdaf6bff4db.\u04a3(this.\u0146.\u0214, n, n2) : this.\u016a.z$hqqzkx9lgbnj(n, n2);
    }

    @Override
    public float z$1dwkeyeylat9c() {
        return this.\u0146.\u03f0;
    }

    @Override
    public float z$2besc61ybi4tc() {
        return this.\u0146.\u0521;
    }

    @Override
    public float z$v8k2n88ulsas() {
        return this.\u0146.\u01be;
    }

    @Override
    public int z$3reop5w4manwh() {
        return this.\u016a == null ? ocdaf6bff4db.\u0244(this.\u0146.\u0214.\u02b7, this.\u0146.\u0214.\u0109 + (0xA318E120 ^ 0xA318E132)) : this.\u016a.z$2droptwdkxnj3();
    }

    @Override
    public ocf13aa48070 z$ru87w5pic870(int n, int n2, short s, int n3) {
        short s2 = (short)n2;
        if (s2 < (0x5AA2573E ^ 0x5AA2573C)) {
            return null;
        }
        short s3 = (short)Math.min(s, 0x5AA25728 ^ 0x5AA2573C);
        (this.\u016a == null ? this.\u0146.\u0214.\u0508 : this.\u016a.z$c0rlehjoef0y()).\u0416 = 0;
        int n4 = ocd63c3dcb1b.\u011f(n);
        int n5 = this.\u0146.\u0463[n4];
        oc68aa547e4e oc68aa547e4e2 = null;
        while (n5 != -1) {
            oc68aa547e4e oc68aa547e4e3 = this.\u0146.\u0143.get(n5);
            if (oc68aa547e4e3.\u01d6 == n && oc68aa547e4e3.\u03c0 == s2 && oc68aa547e4e3.b == s3) {
                oc68aa547e4e2 = oc68aa547e4e3;
                break;
            }
            n5 = oc68aa547e4e3.\u03b6;
        }
        if (oc68aa547e4e2 == null || n3 != 1 && (oc68aa547e4e2.\u0511.\u03ef < 0 || oc68aa547e4e2.\u0511.\u0130 < 0)) {
            int n6;
            Object object;
            int n7;
            int n8;
            int n9;
            int n10;
            float f = (float)s2 / oca0f68927a8.\u027b(0x5A8919FC ^ 0x5AA2573C);
            ocae3bb6ecc0 ocae3bb6ecc02 = this.\u0146;
            int n11 = n10 = this.\u016a == null ? ocdaf6bff4db.\u0546(this.\u0146.\u0214, n) : this.\u016a.z$9uuod3iw435o(n);
            if (n10 == 0) {
                for (ocae3bb6ecc0 ocae3bb6ecc03 : this.\u0146.\u039d) {
                    n9 = ocdaf6bff4db.\u0546(ocae3bb6ecc03.\u0214, n);
                    if (n9 == 0) continue;
                    ocae3bb6ecc02 = ocae3bb6ecc03;
                    n10 = n9;
                    break;
                }
            }
            oceb7ed9a2d8 oceb7ed9a2d82 = ocae3bb6ecc02.\u0214;
            float f2 = f / (float)(this.\u016a == null ? ocdaf6bff4db.\u0244(oceb7ed9a2d82.\u02b7, oceb7ed9a2d82.\u0109 + (0x5AA2572E ^ 0x5AA2573C)) : this.\u016a.z$2droptwdkxnj3());
            n9 = s3 + (0x5AA2573E ^ 0x5AA2573C);
            if (this.\u016a == null) {
                int n12 = ocdaf6bff4db.\u0244(oceb7ed9a2d82.\u02b7, oceb7ed9a2d82.\u01dd + (0x5AA2571E ^ 0x5AA2573C));
                n8 = oceb7ed9a2d82.\u0164 + (n10 < n12 ? n10 : n12 - 1) * (0x5AA25738 ^ 0x5AA2573C);
                n7 = ocdaf6bff4db.\u0244(oceb7ed9a2d82.\u02b7, n8);
            } else {
                n7 = this.\u016a.z$2pfocnh38gpk7(n10);
            }
            int[] nArray = this.\u016a == null ? ocdaf6bff4db.\u00fb(oceb7ed9a2d82, n10) : this.\u016a.z$3lnt5igups949(n10);
            n8 = 0;
            int n13 = 0;
            int n14 = 0;
            int n15 = 0;
            if (nArray != null) {
                n8 = oc3004491957.\u0182(oc98904eb9e7.\u00ba((float)nArray[0] * f2 + 0.0f));
                n13 = oc3004491957.\u0182(oc98904eb9e7.\u00ba((float)(-nArray[0x5AA2573F ^ 0x5AA2573C]) * f2 + 0.0f));
                n14 = oc3004491957.\u0182(oc3004491957.\u0434((float)nArray[0x5AA2573E ^ 0x5AA2573C] * f2 + 0.0f));
                n15 = oc3004491957.\u0182(oc3004491957.\u0434((float)(-nArray[1]) * f2 + 0.0f));
            }
            int n16 = n14 - n8;
            int n17 = n15 - n13;
            int n18 = n16 + n9 * (0x5AA2573E ^ 0x5AA2573C);
            int n19 = n17 + n9 * (0x5AA2573E ^ 0x5AA2573C);
            Object object2 = -1;
            Object object3 = -1;
            if (n3 == (0x5AA2573E ^ 0x5AA2573C)) {
                object = this.\u010c.\u0534.\u0262(n18, n19);
                if (object == null) {
                    if (this.\u010c.\u02a4 == null) {
                        return null;
                    }
                    this.\u010c.\u02a4.run();
                    object = this.\u010c.\u0534.\u0262(n18, n19);
                    if (object == null) {
                        return null;
                    }
                }
                object2 = object[0];
                object3 = object[1];
            }
            if (oc68aa547e4e2 == null) {
                oc68aa547e4e2 = new oc68aa547e4e();
                oc68aa547e4e2.\u01d6 = n;
                oc68aa547e4e2.\u03c0 = s2;
                oc68aa547e4e2.b = s3;
                oc68aa547e4e2.\u03b6 = this.\u0146.\u0463[n4];
                this.\u0146.\u0463[n4] = this.\u0146.\u0143.size();
                this.\u0146.\u0143.add(oc68aa547e4e2);
            }
            object = oc68aa547e4e2.\u0511;
            ((ocf13aa48070)object).\u04cc = n10;
            ((ocf13aa48070)object).\u03ef = (short)object2;
            ((ocf13aa48070)object).\u0130 = (short)object3;
            ((ocf13aa48070)object).\u038e = (short)(object2 + n18);
            ((ocf13aa48070)object).\u0230 = (short)(object3 + n19);
            ((ocf13aa48070)object).\u02e0 = (short)oc3004491957.\u0182((float)((short)n7) * f2 * oca0f68927a8.\u027b(0x5A8919FC ^ 0x5AA2573C));
            ((ocf13aa48070)object).z = (short)(n8 - n9);
            ((ocf13aa48070)object).\u00dc = (short)(n13 - n9);
            if (n3 == 1) {
                return object;
            }
            int n20 = ((short)object3 + n9) * this.\u010c.\u0241 + (short)object2 + n9;
            if (this.\u016a == null) {
                oca0f68927a8.\u0506(oceb7ed9a2d82, this.\u010c.\u0289, n20, n16, n17, this.\u010c.\u0241, f2, f2, 0.0f, 0.0f, n10);
            } else if (n16 != 0 && n17 != 0) {
                oc173282b3d7.\u01a4(this.\u010c.\u0289, n20, n16, n17, this.\u010c.\u0241, oca0f68927a8.\u027b(0x5A891A14 ^ 0x5AA2573C), this.\u016a.z$3k6ox4binq6s8(n10), f2, f2, 0.0f, 0.0f, n8, n13, true, this.\u016a.z$c0rlehjoef0y());
            }
            int n21 = ((ocf13aa48070)object).\u0130 * this.\u010c.\u0241 + ((ocf13aa48070)object).\u03ef;
            for (n6 = 0; n6 < n19; ++n6) {
                this.\u010c.\u0289[n21 + this.\u010c.\u0241 * n6] = 0;
                this.\u010c.\u0289[n21 + this.\u010c.\u0241 * n6 + n18 - 1] = 0;
            }
            for (n6 = 0; n6 < n18; ++n6) {
                this.\u010c.\u0289[n21 + n6] = 0;
                this.\u010c.\u0289[n21 + (n19 - 1) * this.\u010c.\u0241 + n6] = 0;
            }
            if (s > 0) {
                (this.\u016a == null ? this.\u0146.\u0214.\u0508 : this.\u016a.z$c0rlehjoef0y()).\u0416 = 0;
                float f3 = (float)s3 * oca0f68927a8.\u027b(0x5A8919F8 ^ 0x5AA2573C) + oca0f68927a8.\u027b(0x5A8919F4 ^ 0x5AA2573C);
                float f4 = oc42b715e79d.\u0212(oca0f68927a8.\u027b(0x5A8919F0 ^ 0x5AA2573C) / f3);
                int n22 = oc3004491957.\u0182((oca0f68927a8.\u027b(0x5A8919F4 ^ 0x5AA2573C) - f4) * oca0f68927a8.\u027b(0x5A8919EC ^ 0x5AA2573C));
                ocd63c3dcb1b.\u00e1(this.\u010c.\u0289, n21, n18, n19, this.\u010c.\u0241, n22);
            }
            this.\u010c.\u0431 = Math.min(this.\u010c.\u0431, ((ocf13aa48070)object).\u03ef);
            this.\u010c.\u021f = Math.min(this.\u010c.\u021f, ((ocf13aa48070)object).\u0130);
            this.\u010c.\u0552 = Math.max(this.\u010c.\u0552, ((ocf13aa48070)object).\u038e);
            this.\u010c.\u017c = Math.max(this.\u010c.\u017c, ((ocf13aa48070)object).\u0230);
            return object;
        }
        return oc68aa547e4e2.\u0511;
    }

    public static void \u0506(oceb7ed9a2d8 oceb7ed9a2d82, byte[] byArray, int n, int n2, int n3, int n4, float f, float f2, float f3, float f4, int n5) {
        List<ocd1cb14b5c3> list = ocdaf6bff4db.\u0194(oceb7ed9a2d82, n5);
        int[] nArray = ocdaf6bff4db.\u00fb(oceb7ed9a2d82, n5);
        int n6 = 0;
        int n7 = 0;
        if (nArray != null) {
            n6 = oc3004491957.\u0182(oc98904eb9e7.\u00ba((float)nArray[0] * f + f3));
            n7 = oc3004491957.\u0182(oc98904eb9e7.\u00ba((float)(-nArray[0x46476744 ^ 0x46476747]) * f2 + f4));
        }
        if (n2 != 0 && n3 != 0) {
            oc173282b3d7.\u01a4(byArray, n, n2, n3, n4, oca0f68927a8.\u027b(0x466C2A6F ^ 0x46476747), list, f, f2, f3, f4, n6, n7, true, oceb7ed9a2d82.\u0508);
        }
    }
}

