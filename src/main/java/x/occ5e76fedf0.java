/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc3004491957;
import x.oc6e8a040e02;
import x.oca2204e5924;
import x.occd6cefb795;

public class occ5e76fedf0 {
    public static occd6cefb795 \u00c7(occd6cefb795 occd6cefb7952, int n) {
        occd6cefb7952.\u02e0(0);
        int n2 = occd6cefb7952.\u00f3(0xFE4FDC75 ^ 0xFE4FDC77);
        int n3 = occd6cefb7952.\u00fa();
        occd6cefb7952.\u0576(n * n3);
        int n4 = occd6cefb7952.\u00f3(n3);
        int n5 = occd6cefb7952.\u00f3(n3);
        int n6 = (0xFE4FDC75 ^ 0xFE4FDC77) + (n2 + 1) * n3 + n4;
        return occd6cefb7952.\u0511(n6, n5 - n4);
    }

    public static int \u016d(occd6cefb795 occd6cefb7952) {
        int n = occd6cefb7952.\u00fa();
        if (n >= (0xA900FBE1 ^ 0xA900FBC1) && n <= (0xA900FB37 ^ 0xA900FBC1)) {
            return n - (0xA900FB4A ^ 0xA900FBC1);
        }
        if (n >= (0xA900FB36 ^ 0xA900FBC1) && n <= (0xA900FB3B ^ 0xA900FBC1)) {
            return (n - (0xA900FB36 ^ 0xA900FBC1)) * (0xA900FAC1 ^ 0xA900FBC1) + occd6cefb7952.\u00fa() + (0xA900FBAD ^ 0xA900FBC1);
        }
        if (n >= (0xA900FB3A ^ 0xA900FBC1) && n <= (0xA900FB3F ^ 0xA900FBC1)) {
            return -(n - (0xA900FB3A ^ 0xA900FBC1)) * (0xA900FAC1 ^ 0xA900FBC1) - occd6cefb7952.\u00fa() - (0xA900FBAD ^ 0xA900FBC1);
        }
        if (n == (0xA900FBDD ^ 0xA900FBC1)) {
            return occd6cefb7952.\u00f3(0xA900FBC3 ^ 0xA900FBC1);
        }
        return n == (0xA900FBDC ^ 0xA900FBC1) ? occd6cefb7952.\u00f3(0xA900FBC5 ^ 0xA900FBC1) : 0;
    }

    public static void \u04a9(occd6cefb795 occd6cefb7952, int n, int n2, int[] nArray) {
        occd6cefb7952.\u02e0(0);
        while (occd6cefb7952.\u0241 < occd6cefb7952.\u00c8) {
            int n3;
            int n4 = occd6cefb7952.\u0241;
            while (occd6cefb7952.\u0241 < occd6cefb7952.\u00c8 && (occd6cefb7952.\u0161[occd6cefb7952.\u010b + occd6cefb7952.\u0241] & (0xE74E7997 ^ 0xE74E7968)) >= (0xE74E7974 ^ 0xE74E7968)) {
                if ((occd6cefb7952.\u0161[occd6cefb7952.\u010b + occd6cefb7952.\u0241] & (0xE74E7997 ^ 0xE74E7968)) == (0xE74E7976 ^ 0xE74E7968)) {
                    occd6cefb7952.\u0576(1);
                    while (occd6cefb7952.\u0241 < occd6cefb7952.\u00c8 && ((n3 = occd6cefb7952.\u00fa()) & (0xE74E7967 ^ 0xE74E7968)) != (0xE74E7967 ^ 0xE74E7968) && n3 >>> (0xE74E796C ^ 0xE74E7968) != (0xE74E7967 ^ 0xE74E7968)) {
                    }
                    continue;
                }
                occ5e76fedf0.\u016d(occd6cefb7952);
            }
            n3 = occd6cefb7952.\u0241;
            int n5 = occd6cefb7952.\u00fa();
            if (n5 == (0xE74E7964 ^ 0xE74E7968)) {
                n5 = occd6cefb7952.\u00fa() | 0xE74E7868 ^ 0xE74E7968;
            }
            if (n5 != n) continue;
            occd6cefb795 occd6cefb7953 = occd6cefb7952.\u0511(n4, n3 - n4);
            if (occd6cefb7953.\u0241 < occd6cefb7953.\u00c8) {
                int n6 = 0;
                do {
                    nArray[n6++] = occ5e76fedf0.\u016d(occd6cefb7953);
                } while (Integer.toUnsignedLong(n6) < Integer.toUnsignedLong(n2) && occd6cefb7953.\u0241 < occd6cefb7953.\u00c8);
            }
            return;
        }
    }

    public static occd6cefb795 \u0143(occd6cefb795 occd6cefb7952) {
        int n = occd6cefb7952.\u0241;
        int n2 = occd6cefb7952.\u00f3(0x39548E47 ^ 0x39548E45);
        if (n2 != 0) {
            int n3 = occd6cefb7952.\u00fa();
            occd6cefb7952.\u0576(n3 * n2);
            occd6cefb7952.\u0576(occd6cefb7952.\u00f3(n3) - 1);
        }
        return occd6cefb7952.\u0511(n, occd6cefb7952.\u0241 - n);
    }

    public static occd6cefb795 \u014a(occd6cefb795 occd6cefb7952, occd6cefb795 occd6cefb7953) {
        int[] nArray = new int[0xE0D599C2 ^ 0xE0D599C0];
        int[] nArray2 = new int[1];
        occ5e76fedf0.\u04a9(occd6cefb7953, 0xE0D599D2 ^ 0xE0D599C0, 0xE0D599C2 ^ 0xE0D599C0, nArray);
        if (nArray[0] != 0 && nArray[1] != 0) {
            occd6cefb795 occd6cefb7954 = occd6cefb7952.\u0511(nArray[1], nArray[0]);
            occ5e76fedf0.\u04a9(occd6cefb7954, 0xE0D599D3 ^ 0xE0D599C0, 1, nArray2);
            if (nArray2[0] == 0) {
                return new occd6cefb795(new byte[0]);
            }
            occd6cefb7952.\u02e0(nArray[1] + nArray2[0]);
            return occ5e76fedf0.\u0143(occd6cefb7952);
        }
        return new occd6cefb795(new byte[0]);
    }

    private static occd6cefb795 \u01e8(occd6cefb795 occd6cefb7952, int n) {
        occd6cefb7952 = occd6cefb7952.\u00df();
        occd6cefb7952.\u02e0(0);
        int n2 = occd6cefb7952.\u00f3(0x467BEBC9 ^ 0x467BEBCB);
        int n3 = n2 >= (0x467B6FA7 ^ 0x467BEBCB) ? 0x467B6BCB ^ 0x467BEBCB : (n2 >= (0x467BEF13 ^ 0x467BEBCB) ? 0x467BEFA0 ^ 0x467BEBCB : 0x467BEBA0 ^ 0x467BEBCB);
        int n4 = n + n3;
        return Integer.compareUnsigned(n4, n2) >= 0 ? new occd6cefb795(new byte[0]) : occ5e76fedf0.\u00c7(occd6cefb7952, n4);
    }

    private static occd6cefb795 \u0120(oca2204e5924 oca2204e59242, int n) {
        occd6cefb795 occd6cefb7952 = oca2204e59242.\u03b5.\u00df();
        occd6cefb7952.\u02e0(0);
        int n2 = occd6cefb7952.\u00fa();
        int n3 = -1;
        if (n2 == 0) {
            occd6cefb7952.\u0576(n);
            n3 = occd6cefb7952.\u00fa();
        } else if (n2 == (0x3B15642A ^ 0x3B156429)) {
            int n4 = occd6cefb7952.\u00f3(0x3B15642B ^ 0x3B156429);
            int n5 = occd6cefb7952.\u00f3(0x3B15642B ^ 0x3B156429);
            for (int i = 0; i < n4; ++i) {
                int n6 = occd6cefb7952.\u00fa();
                int n7 = occd6cefb7952.\u00f3(0x3B15642B ^ 0x3B156429);
                if (n >= n5 && n < n7) {
                    n3 = n6;
                    break;
                }
                n5 = n7;
            }
        }
        occd6cefb795 occd6cefb7953 = occ5e76fedf0.\u00c7(oca2204e59242.\u0225.\u00df(), n3);
        return occ5e76fedf0.\u014a(oca2204e59242.\u01e0.\u00df(), occd6cefb7953);
    }

    private static int \u0477(float f) {
        return oc3004491957.\u0182(f);
    }

    private static float \u00da(float f) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f) ^ (0x1F29AEDB ^ 0x9F29AEDB));
    }

    public static void \u03c7(oc6e8a040e02 oc6e8a040e022) {
        if (oc6e8a040e022.\u0373 != oc6e8a040e022.\u0543 || oc6e8a040e022.\u016e != oc6e8a040e022.\u00e8) {
            oc6e8a040e022.\u0220(0xCDE73FA0 ^ 0xCDE73FA2, occ5e76fedf0.\u0477(oc6e8a040e022.\u0373), occ5e76fedf0.\u0477(oc6e8a040e022.\u016e), 0, 0, 0, 0);
        }
    }

    public static void \u03fe(oc6e8a040e02 oc6e8a040e022, float f, float f2) {
        occ5e76fedf0.\u03c7(oc6e8a040e022);
        oc6e8a040e022.\u0373 = oc6e8a040e022.\u0543 += f;
        oc6e8a040e022.\u016e = oc6e8a040e022.\u00e8 += f2;
        oc6e8a040e022.\u0220(1, occ5e76fedf0.\u0477(oc6e8a040e022.\u0543), occ5e76fedf0.\u0477(oc6e8a040e022.\u00e8), 0, 0, 0, 0);
    }

    public static void \u00d5(oc6e8a040e02 oc6e8a040e022, float f, float f2) {
        oc6e8a040e022.\u0543 += f;
        oc6e8a040e022.\u00e8 += f2;
        oc6e8a040e022.\u0220(0xA5B527B1 ^ 0xA5B527B3, occ5e76fedf0.\u0477(oc6e8a040e022.\u0543), occ5e76fedf0.\u0477(oc6e8a040e022.\u00e8), 0, 0, 0, 0);
    }

    public static void \u0454(oc6e8a040e02 oc6e8a040e022, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f + oc6e8a040e022.\u0543;
        float f8 = f2 + oc6e8a040e022.\u00e8;
        float f9 = f3 + f7;
        float f10 = f4 + f8;
        oc6e8a040e022.\u0543 = f5 + f9;
        oc6e8a040e022.\u00e8 = f6 + f10;
        oc6e8a040e022.\u0220(0x85E63DEF ^ 0x85E63DEB, occ5e76fedf0.\u0477(oc6e8a040e022.\u0543), occ5e76fedf0.\u0477(oc6e8a040e022.\u00e8), occ5e76fedf0.\u0477(f7), occ5e76fedf0.\u0477(f8), occ5e76fedf0.\u0477(f9), occ5e76fedf0.\u0477(f10));
    }

    public static boolean \u0386(oca2204e5924 oca2204e59242, int n, oc6e8a040e02 oc6e8a040e022) {
        boolean bl = true;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        boolean bl2 = false;
        float[] fArray = new float[0xB123E98A ^ 0xB123E9BA];
        occd6cefb795[] occd6cefb795Array = new occd6cefb795[0xB123E9B0 ^ 0xB123E9BA];
        occd6cefb795 occd6cefb7952 = oca2204e59242.\u00f6.\u00df();
        occd6cefb795 occd6cefb7953 = occ5e76fedf0.\u00c7(oca2204e59242.\u02e1.\u00df(), n);
        while (occd6cefb7953.\u0241 < occd6cefb7953.\u00c8) {
            int n5 = occd6cefb7953.\u00fa();
            boolean bl3 = true;
            switch (n5) {
                case 1: 
                case 3: 
                case 18: 
                case 23: {
                    n2 += n4 / (0xB123E9B8 ^ 0xB123E9BA);
                    break;
                }
                default: {
                    float f;
                    if (n5 != (0xB123E945 ^ 0xB123E9BA) && n5 != (0xB123E9A6 ^ 0xB123E9BA) && n5 < (0xB123E99A ^ 0xB123E9BA)) {
                        return false;
                    }
                    if (n5 == (0xB123E945 ^ 0xB123E9BA)) {
                        f = (float)occd6cefb7953.\u00f3(0xB123E9BE ^ 0xB123E9BA) * 1.5258789E-5f;
                    } else {
                        occd6cefb7953.\u0576(-1);
                        f = (short)occ5e76fedf0.\u016d(occd6cefb7953);
                    }
                    if (n4 >= (0xB123E98A ^ 0xB123E9BA)) {
                        return false;
                    }
                    fArray[n4++] = f;
                    bl3 = false;
                    break;
                }
                case 4: {
                    if (n4 < 1) {
                        return false;
                    }
                    occ5e76fedf0.\u03fe(oc6e8a040e022, 0.0f, fArray[n4 - 1]);
                    bl = false;
                    break;
                }
                case 5: {
                    int n6;
                    if (n4 < (0xB123E9B8 ^ 0xB123E9BA)) {
                        return false;
                    }
                    while (n6 + 1 < n4) {
                        occ5e76fedf0.\u00d5(oc6e8a040e022, fArray[n6], fArray[n6 + 1]);
                        n6 += 2;
                    }
                    break;
                }
                case 6: 
                case 7: {
                    int n7;
                    int n6;
                    if (n4 < 1) {
                        return false;
                    }
                    int n8 = n7 = n5 == (0xB123E9BC ^ 0xB123E9BA) ? 1 : 0;
                    for (n6 = 0; n6 < n4; ++n6) {
                        occ5e76fedf0.\u00d5(oc6e8a040e022, n7 != 0 ? fArray[n6] : 0.0f, n7 != 0 ? 0.0f : fArray[n6]);
                        n7 = n7 == 0 ? 1 : 0;
                    }
                    break;
                }
                case 8: {
                    int n6;
                    if (n4 < (0xB123E9BC ^ 0xB123E9BA)) {
                        return false;
                    }
                    while (n6 + (0xB123E9BF ^ 0xB123E9BA) < n4) {
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[n6], fArray[n6 + 1], fArray[n6 + (0xB123E9B8 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9B9 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9BE ^ 0xB123E9BA)], fArray[n6 + (0xB123E9BF ^ 0xB123E9BA)]);
                        n6 += 6;
                    }
                    break;
                }
                case 10: 
                case 29: {
                    if (n5 == (0xB123E9B0 ^ 0xB123E9BA) && !bl2) {
                        if (oca2204e59242.\u03b5.\u00c8 != 0) {
                            occd6cefb7952 = occ5e76fedf0.\u0120(oca2204e59242, n);
                        }
                        bl2 = true;
                    }
                    if (n4 < 1 || n3 >= (0xB123E9B0 ^ 0xB123E9BA)) {
                        return false;
                    }
                    int n7 = occ5e76fedf0.\u0477(fArray[--n4]);
                    occd6cefb795Array[n3] = occd6cefb7953;
                    occd6cefb7953 = occ5e76fedf0.\u01e8(n5 == (0xB123E9B0 ^ 0xB123E9BA) ? occd6cefb7952 : oca2204e59242.\u0182, n7);
                    if (occd6cefb7953.\u00c8 == 0) {
                        return false;
                    }
                    ++n3;
                    occd6cefb7953.\u0241 = 0;
                    bl3 = false;
                    break;
                }
                case 11: {
                    if (n3 <= 0) {
                        return false;
                    }
                    occd6cefb7953 = occd6cefb795Array[--n3];
                    bl3 = false;
                    break;
                }
                case 12: {
                    float f;
                    int n9 = occd6cefb7953.\u00fa();
                    if (n9 == (0xB123E998 ^ 0xB123E9BA)) {
                        if (n4 < (0xB123E9BD ^ 0xB123E9BA)) {
                            return false;
                        }
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0], 0.0f, fArray[1], fArray[0xB123E9B8 ^ 0xB123E9BA], fArray[0xB123E9B9 ^ 0xB123E9BA], 0.0f);
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0xB123E9BE ^ 0xB123E9BA], 0.0f, fArray[0xB123E9BF ^ 0xB123E9BA], occ5e76fedf0.\u00da(fArray[0xB123E9B8 ^ 0xB123E9BA]), fArray[0xB123E9BC ^ 0xB123E9BA], 0.0f);
                        break;
                    }
                    if (n9 == (0xB123E999 ^ 0xB123E9BA)) {
                        if (n4 < (0xB123E9B7 ^ 0xB123E9BA)) {
                            return false;
                        }
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0], fArray[1], fArray[0xB123E9B8 ^ 0xB123E9BA], fArray[0xB123E9B9 ^ 0xB123E9BA], fArray[0xB123E9BE ^ 0xB123E9BA], fArray[0xB123E9BF ^ 0xB123E9BA]);
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0xB123E9BC ^ 0xB123E9BA], fArray[0xB123E9BD ^ 0xB123E9BA], fArray[0xB123E9B2 ^ 0xB123E9BA], fArray[0xB123E9B3 ^ 0xB123E9BA], fArray[0xB123E9B0 ^ 0xB123E9BA], fArray[0xB123E9B1 ^ 0xB123E9BA]);
                        break;
                    }
                    if (n9 == (0xB123E99E ^ 0xB123E9BA)) {
                        if (n4 < (0xB123E9B3 ^ 0xB123E9BA)) {
                            return false;
                        }
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0], fArray[1], fArray[0xB123E9B8 ^ 0xB123E9BA], fArray[0xB123E9B9 ^ 0xB123E9BA], fArray[0xB123E9BE ^ 0xB123E9BA], 0.0f);
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0xB123E9BF ^ 0xB123E9BA], 0.0f, fArray[0xB123E9BC ^ 0xB123E9BA], fArray[0xB123E9BD ^ 0xB123E9BA], fArray[0xB123E9B2 ^ 0xB123E9BA], occ5e76fedf0.\u00da(fArray[1] + fArray[0xB123E9B9 ^ 0xB123E9BA] + fArray[0xB123E9BD ^ 0xB123E9BA]));
                        break;
                    }
                    if (n9 != (0xB123E99F ^ 0xB123E9BA)) {
                        return false;
                    }
                    if (n4 < (0xB123E9B1 ^ 0xB123E9BA)) {
                        return false;
                    }
                    float f2 = fArray[0] + fArray[0xB123E9B8 ^ 0xB123E9BA] + fArray[0xB123E9BE ^ 0xB123E9BA] + fArray[0xB123E9BC ^ 0xB123E9BA] + fArray[0xB123E9B2 ^ 0xB123E9BA];
                    float f3 = fArray[1] + fArray[0xB123E9B9 ^ 0xB123E9BA] + fArray[0xB123E9BF ^ 0xB123E9BA] + fArray[0xB123E9BD ^ 0xB123E9BA] + fArray[0xB123E9B3 ^ 0xB123E9BA];
                    float f4 = Float.intBitsToFloat(Float.floatToRawIntBits(f2) & (0xCEDC1645 ^ 0xB123E9BA));
                    float f5 = f4 > (f = Float.intBitsToFloat(Float.floatToRawIntBits(f3) & (0xCEDC1645 ^ 0xB123E9BA))) ? fArray[0xB123E9B0 ^ 0xB123E9BA] : occ5e76fedf0.\u00da(f2);
                    float f6 = f4 > f ? occ5e76fedf0.\u00da(f3) : fArray[0xB123E9B0 ^ 0xB123E9BA];
                    occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0], fArray[1], fArray[0xB123E9B8 ^ 0xB123E9BA], fArray[0xB123E9B9 ^ 0xB123E9BA], fArray[0xB123E9BE ^ 0xB123E9BA], fArray[0xB123E9BF ^ 0xB123E9BA]);
                    occ5e76fedf0.\u0454(oc6e8a040e022, fArray[0xB123E9BC ^ 0xB123E9BA], fArray[0xB123E9BD ^ 0xB123E9BA], fArray[0xB123E9B2 ^ 0xB123E9BA], fArray[0xB123E9B3 ^ 0xB123E9BA], f5, f6);
                    break;
                }
                case 14: {
                    occ5e76fedf0.\u03c7(oc6e8a040e022);
                    return true;
                }
                case 19: 
                case 20: {
                    if (bl) {
                        n2 += n4 / (0xB123E9B8 ^ 0xB123E9BA);
                    }
                    bl = false;
                    occd6cefb7953.\u0576((n2 + (0xB123E9BD ^ 0xB123E9BA)) / (0xB123E9B2 ^ 0xB123E9BA));
                    break;
                }
                case 21: {
                    if (n4 < (0xB123E9B8 ^ 0xB123E9BA)) {
                        return false;
                    }
                    occ5e76fedf0.\u03fe(oc6e8a040e022, fArray[n4 - (0xB123E9B8 ^ 0xB123E9BA)], fArray[n4 - 1]);
                    bl = false;
                    break;
                }
                case 22: {
                    if (n4 < 1) {
                        return false;
                    }
                    occ5e76fedf0.\u03fe(oc6e8a040e022, fArray[n4 - 1], 0.0f);
                    bl = false;
                    break;
                }
                case 24: {
                    int n6;
                    if (n4 < (0xB123E9B2 ^ 0xB123E9BA)) {
                        return false;
                    }
                    while (n6 + (0xB123E9BF ^ 0xB123E9BA) < n4 - (0xB123E9B8 ^ 0xB123E9BA)) {
                        occ5e76fedf0.\u0454(oc6e8a040e022, fArray[n6], fArray[n6 + 1], fArray[n6 + (0xB123E9B8 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9B9 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9BE ^ 0xB123E9BA)], fArray[n6 + (0xB123E9BF ^ 0xB123E9BA)]);
                        n6 += 6;
                    }
                    if (n6 + 1 >= n4) {
                        return false;
                    }
                    occ5e76fedf0.\u00d5(oc6e8a040e022, fArray[n6], fArray[n6 + 1]);
                    break;
                }
                case 25: {
                    int n6;
                    if (n4 < (0xB123E9B2 ^ 0xB123E9BA)) {
                        return false;
                    }
                    while (n6 + 1 < n4 - (0xB123E9BC ^ 0xB123E9BA)) {
                        occ5e76fedf0.\u00d5(oc6e8a040e022, fArray[n6], fArray[n6 + 1]);
                        n6 += 2;
                    }
                    if (n6 + (0xB123E9BF ^ 0xB123E9BA) >= n4) {
                        return false;
                    }
                    occ5e76fedf0.\u0454(oc6e8a040e022, fArray[n6], fArray[n6 + 1], fArray[n6 + (0xB123E9B8 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9B9 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9BE ^ 0xB123E9BA)], fArray[n6 + (0xB123E9BF ^ 0xB123E9BA)]);
                    break;
                }
                case 26: 
                case 27: {
                    int n6;
                    if (n4 < (0xB123E9BE ^ 0xB123E9BA)) {
                        return false;
                    }
                    float f2 = 0.0f;
                    if ((n4 & 1) != 0) {
                        f2 = fArray[n6++];
                    }
                    while (n6 + (0xB123E9B9 ^ 0xB123E9BA) < n4) {
                        if (n5 == (0xB123E9A1 ^ 0xB123E9BA)) {
                            occ5e76fedf0.\u0454(oc6e8a040e022, fArray[n6], f2, fArray[n6 + 1], fArray[n6 + (0xB123E9B8 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9B9 ^ 0xB123E9BA)], 0.0f);
                        } else {
                            occ5e76fedf0.\u0454(oc6e8a040e022, f2, fArray[n6], fArray[n6 + 1], fArray[n6 + (0xB123E9B8 ^ 0xB123E9BA)], 0.0f, fArray[n6 + (0xB123E9B9 ^ 0xB123E9BA)]);
                        }
                        f2 = 0.0f;
                        n6 += 4;
                    }
                    break;
                }
                case 30: 
                case 31: {
                    boolean bl4;
                    int n6;
                    if (n4 < (0xB123E9BE ^ 0xB123E9BA)) {
                        return false;
                    }
                    boolean bl5 = bl4 = n5 == (0xB123E9A5 ^ 0xB123E9BA);
                    while (n6 + (0xB123E9B9 ^ 0xB123E9BA) < n4) {
                        if (bl4) {
                            occ5e76fedf0.\u0454(oc6e8a040e022, fArray[n6], 0.0f, fArray[n6 + 1], fArray[n6 + (0xB123E9B8 ^ 0xB123E9BA)], n4 - n6 == (0xB123E9BF ^ 0xB123E9BA) ? fArray[n6 + (0xB123E9BE ^ 0xB123E9BA)] : 0.0f, fArray[n6 + (0xB123E9B9 ^ 0xB123E9BA)]);
                        } else {
                            occ5e76fedf0.\u0454(oc6e8a040e022, 0.0f, fArray[n6], fArray[n6 + 1], fArray[n6 + (0xB123E9B8 ^ 0xB123E9BA)], fArray[n6 + (0xB123E9B9 ^ 0xB123E9BA)], n4 - n6 == (0xB123E9BF ^ 0xB123E9BA) ? fArray[n6 + (0xB123E9BE ^ 0xB123E9BA)] : 0.0f);
                        }
                        bl4 = !bl4;
                        n6 += 4;
                    }
                    break block0;
                }
            }
            if (!bl3) continue;
            n4 = 0;
        }
        return false;
    }

    private occ5e76fedf0() {
    }
}

