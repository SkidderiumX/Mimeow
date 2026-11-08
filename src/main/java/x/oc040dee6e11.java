/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Arrays;
import x.L;
import x.oc5f397ea265;
import x.oc7f6c6f758e;
import x.ocae3bb6ecc0;
import x.ocdc39746a92;
import x.oce7a77f7e99;

public class oc040dee6e11 {
    public static boolean \u01e1(oce7a77f7e99 oce7a77f7e992) {
        int n;
        int n2;
        int n3;
        oc7f6c6f758e oc7f6c6f758e2 = oce7a77f7e992.\u0151;
        oc5f397ea265 oc5f397ea2652 = oc7f6c6f758e2.\u0137;
        if (oc7f6c6f758e2.\u04dc()) {
            n3 = oc5f397ea2652.\u0431;
            int n4 = oc5f397ea2652.\u021f;
            n2 = oc5f397ea2652.\u0552 - n3;
            n = oc5f397ea2652.\u017c - n4;
            oc7f6c6f758e2.k();
            int n5 = oce7a77f7e992.\u029b[oce7a77f7e992.\u0495];
            if (n5 != 0) {
                oce7a77f7e992.\u0490.z$20w06ler7vqca(n5, n3, n4, n2, n, oc5f397ea2652.\u0289);
            }
        }
        if ((n3 = oce7a77f7e992.\u0495) > (0xE9857FFB ^ 0xE9857FF9)) {
            return false;
        }
        int[] nArray = new int[0xE9857FFB ^ 0xE9857FF9];
        nArray[0] = oce7a77f7e992.\u02a4;
        nArray[1] = oce7a77f7e992.\u01f4;
        int[] nArray2 = nArray;
        n2 = oce7a77f7e992.\u029b[n3 + 1];
        if (n2 != 0) {
            oce7a77f7e992.\u0490.z$3mrpfyp7hdljq(n2, nArray2);
        } else {
            oce7a77f7e992.\u0490.z$3mrpfyp7hdljq(oce7a77f7e992.\u029b[n3], nArray2);
            if (nArray2[0] > nArray2[1]) {
                nArray2[1] = nArray2[1] + nArray2[1];
            } else {
                nArray2[0] = nArray2[0] + nArray2[0];
            }
            if (nArray2[0] >= (0xE98577F8 ^ 0xE9857FF9) || nArray2[1] >= (0xE98577F8 ^ 0xE9857FF9)) {
                nArray2[0] = nArray2[1] = 0xE98577F9 ^ 0xE9857FF9;
            }
            oce7a77f7e992.\u029b[oce7a77f7e992.\u0495 + 1] = n = oce7a77f7e992.\u0490.z$8519guy0xkde(1, nArray2[0], nArray2[1], 0, null);
        }
        ++oce7a77f7e992.\u0495;
        oc040dee6e11.\u047b(oce7a77f7e992.\u0151, nArray2[0], nArray2[1], oce7a77f7e992.\u0563, oce7a77f7e992.\u046b);
        return true;
    }

    public static boolean \u047b(oc7f6c6f758e oc7f6c6f758e2, int n, int n2, int n3, int n4) {
        if (oc7f6c6f758e2 == null) {
            return false;
        }
        oc5f397ea265 oc5f397ea2652 = oc7f6c6f758e2.\u0137;
        if (oc7f6c6f758e2.\u04dc()) {
            if (oc7f6c6f758e2.\u0212 != null) {
                int[] nArray = new int[0x99C2AF4F ^ 0x99C2AF4B];
                nArray[0] = oc5f397ea2652.\u0431;
                nArray[1] = oc5f397ea2652.\u021f;
                nArray[0x99C2AF49 ^ 0x99C2AF4B] = oc5f397ea2652.\u0552;
                nArray[0x99C2AF48 ^ 0x99C2AF4B] = oc5f397ea2652.\u017c;
                oc7f6c6f758e2.\u0212.z$23dsopmgb909x(nArray, oc5f397ea2652.\u0289);
            }
            oc7f6c6f758e2.k();
        }
        if (oc7f6c6f758e2.\u0110 > 0) {
            if (oc7f6c6f758e2.\u04a0 != null) {
                oc7f6c6f758e2.\u04a0.z$1py9acp050vos(oc7f6c6f758e2.\u03ac, oc7f6c6f758e2.\u0481, oc7f6c6f758e2.\u0555, oc7f6c6f758e2.\u0110);
            }
            oc7f6c6f758e2.\u0110 = 0;
        }
        if (oc7f6c6f758e2.\u0151 != null && !oc7f6c6f758e2.\u0151.z$10g7469dopgaa(n, n2)) {
            return false;
        }
        oc5f397ea2652.\u0534 = new ocdc39746a92(n, n2);
        long l = n2 * n;
        oc5f397ea2652.\u0289 = oc7f6c6f758e2.\u0469.z$3fff7eaqdilfk(oc5f397ea2652.\u0289, l);
        if (oc5f397ea2652.\u0289 == null) {
            return false;
        }
        Arrays.fill(oc5f397ea2652.\u0289, 0, (int)l, (byte)0);
        oc5f397ea2652.\u0431 = n;
        oc5f397ea2652.\u021f = n2;
        oc5f397ea2652.\u017c = 0;
        oc5f397ea2652.\u0552 = 0;
        for (ocae3bb6ecc0 ocae3bb6ecc02 : oc7f6c6f758e2.\u04d8) {
            ocae3bb6ecc02.\u0143.clear();
            Arrays.fill(ocae3bb6ecc02.\u0463, -1);
        }
        oc7f6c6f758e2.\u0272 = n;
        oc7f6c6f758e2.\u00cf = n2;
        oc5f397ea2652.\u0241 = n;
        oc7f6c6f758e2.v = L.\u026d(0x99E9E02B ^ 0x99C2AF4B) / (float)n;
        oc7f6c6f758e2.\u0525 = L.\u026d(0x99E9E02F ^ 0x99C2AF4B) / (float)n2;
        Object object = oc5f397ea2652.\u0534.\u0262(0x99C2AF49 ^ 0x99C2AF4B, 0x99C2AF49 ^ 0x99C2AF4B);
        if (object != null) {
            Object object2 = object[0];
            Object object3 = object[1];
            int n5 = n * object3 + object2;
            oc5f397ea2652.\u0289[n5 + n + 1] = -1;
            oc5f397ea2652.\u0289[n5 + n] = -1;
            oc5f397ea2652.\u0289[n5 + 1] = -1;
            oc5f397ea2652.\u0289[n5] = -1;
            oc5f397ea2652.\u0431 = Math.min(oc5f397ea2652.\u0431, (int)object2);
            oc5f397ea2652.\u021f = Math.min(oc5f397ea2652.\u021f, (int)object3);
            oc5f397ea2652.\u0552 = Math.max(oc5f397ea2652.\u0552, (int)(object2 + (0x99C2AF49 ^ 0x99C2AF4B)));
            oc5f397ea2652.\u017c = Math.max(oc5f397ea2652.\u017c, (int)(object3 + (0x99C2AF49 ^ 0x99C2AF4B)));
        }
        return true;
    }

    private oc040dee6e11() {
    }
}

