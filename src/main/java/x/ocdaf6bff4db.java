/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x.L;
import x.oc3004491957;
import x.oc6e8a040e02;
import x.occ5e76fedf0;
import x.ocd1cb14b5c3;
import x.oceb7ed9a2d8;

public class ocdaf6bff4db {
    public static int \u0244(byte[] byArray, int n) {
        return (byArray[n] & (0xE0D3963 ^ 0xE0D399C)) << (0xE0D3994 ^ 0xE0D399C) | byArray[n + 1] & (0xE0D3963 ^ 0xE0D399C);
    }

    public static int \u0534(byte[] byArray, int n) {
        return (short)ocdaf6bff4db.\u0244(byArray, n);
    }

    public static int \u0425(byte[] byArray, int n) {
        return (byArray[n] & (0x2D25C507 ^ 0x2D25C5F8)) << (0x2D25C5E0 ^ 0x2D25C5F8) | (byArray[n + 1] & (0x2D25C507 ^ 0x2D25C5F8)) << (0x2D25C5E8 ^ 0x2D25C5F8) | (byArray[n + (0x2D25C5FA ^ 0x2D25C5F8)] & (0x2D25C507 ^ 0x2D25C5F8)) << (0x2D25C5F0 ^ 0x2D25C5F8) | byArray[n + (0x2D25C5FB ^ 0x2D25C5F8)] & (0x2D25C507 ^ 0x2D25C5F8);
    }

    public static int \u03fc(oceb7ed9a2d8 oceb7ed9a2d82, int n) {
        if (n < oceb7ed9a2d82.\u056d && oceb7ed9a2d82.\u027c <= 1) {
            int n2 = oceb7ed9a2d82.\u027c == 0 ? ocdaf6bff4db.\u0244(oceb7ed9a2d82.\u02b7, oceb7ed9a2d82.\u00f0 + n * (0xF3205074 ^ 0xF3205076)) * (0xF3205074 ^ 0xF3205076) : ocdaf6bff4db.\u0425(oceb7ed9a2d82.\u02b7, oceb7ed9a2d82.\u00f0 + n * (0xF3205072 ^ 0xF3205076));
            int n3 = oceb7ed9a2d82.\u027c == 0 ? ocdaf6bff4db.\u0244(oceb7ed9a2d82.\u02b7, oceb7ed9a2d82.\u00f0 + n * (0xF3205074 ^ 0xF3205076) + (0xF3205074 ^ 0xF3205076)) * (0xF3205074 ^ 0xF3205076) : ocdaf6bff4db.\u0425(oceb7ed9a2d82.\u02b7, oceb7ed9a2d82.\u00f0 + n * (0xF3205072 ^ 0xF3205076) + (0xF3205072 ^ 0xF3205076));
            return n2 == n3 ? -1 : oceb7ed9a2d82.\u03fe + n2;
        }
        return -1;
    }

    public static int \u0546(oceb7ed9a2d8 oceb7ed9a2d82, int n) {
        byte[] byArray = oceb7ed9a2d82.\u02b7;
        int n2 = oceb7ed9a2d82.\u0429;
        int n3 = ocdaf6bff4db.\u0244(byArray, n2);
        if (n3 == 0) {
            return n >= ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799DC ^ 0x28E799DE)) - (0x28E799D8 ^ 0x28E799DE) ? 0 : byArray[n2 + (0x28E799D8 ^ 0x28E799DE) + n] & (0x28E79921 ^ 0x28E799DE);
        }
        if (n3 == (0x28E799D8 ^ 0x28E799DE)) {
            int n4 = ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799D8 ^ 0x28E799DE));
            int n5 = ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799D6 ^ 0x28E799DE));
            return Integer.compareUnsigned(n, n4) >= 0 && Integer.compareUnsigned(n, n4 + n5) < 0 ? ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799D4 ^ 0x28E799DE) + (n - n4) * (0x28E799DC ^ 0x28E799DE)) : 0;
        }
        if (n3 == (0x28E799DA ^ 0x28E799DE)) {
            int n6;
            if (n > (0x28E76621 ^ 0x28E799DE)) {
                return 0;
            }
            int n7 = ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799D8 ^ 0x28E799DE)) >>> 1;
            int n8 = ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799D6 ^ 0x28E799DE)) >>> 1;
            int n9 = ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799D4 ^ 0x28E799DE));
            int n10 = ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799D2 ^ 0x28E799DE)) >>> 1;
            int n11 = n6 = n2 + (0x28E799D0 ^ 0x28E799DE);
            if (n >= ocdaf6bff4db.\u0244(byArray, n6 + n10 * (0x28E799DC ^ 0x28E799DE))) {
                n11 = n6 + n10 * (0x28E799DC ^ 0x28E799DE);
            }
            n11 -= 2;
            while (n9 != 0) {
                if (n > ocdaf6bff4db.\u0244(byArray, n11 + (n8 >>>= 1) * (0x28E799DC ^ 0x28E799DE))) {
                    n11 += n8 * (0x28E799DC ^ 0x28E799DE);
                }
                --n9;
            }
            int n12 = (n11 += 2) - n6 >>> 1 & (0x28E76621 ^ 0x28E799DE);
            int n13 = ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799CE ^ 0x28E799DE) + n7 * (0x28E799DC ^ 0x28E799DE) + n12 * (0x28E799DC ^ 0x28E799DE));
            if (n < n13) {
                return 0;
            }
            int n14 = n2 + (0x28E799CE ^ 0x28E799DE) + n7 * (0x28E799D8 ^ 0x28E799DE) + n12 * (0x28E799DC ^ 0x28E799DE);
            int n15 = ocdaf6bff4db.\u0244(byArray, n14);
            return n15 == 0 ? n + ocdaf6bff4db.\u0244(byArray, n2 + (0x28E799CE ^ 0x28E799DE) + n7 * (0x28E799DA ^ 0x28E799DE) + n12 * (0x28E799DC ^ 0x28E799DE)) & (0x28E76621 ^ 0x28E799DE) : ocdaf6bff4db.\u0244(byArray, n14 + n15 + (n - n13) * (0x28E799DC ^ 0x28E799DE));
        }
        if (n3 == (0x28E799D2 ^ 0x28E799DE) || n3 == (0x28E799D3 ^ 0x28E799DE)) {
            int n16 = 0;
            int n17 = ocdaf6bff4db.\u0425(byArray, n2 + (0x28E799D2 ^ 0x28E799DE));
            while (n16 < n17) {
                int n18 = n16 + (n17 - n16 >>> 1);
                int n19 = n2 + (0x28E799CE ^ 0x28E799DE) + n18 * (0x28E799D2 ^ 0x28E799DE);
                int n20 = ocdaf6bff4db.\u0425(byArray, n19);
                int n21 = ocdaf6bff4db.\u0425(byArray, n19 + (0x28E799DA ^ 0x28E799DE));
                if (Integer.compareUnsigned(n, n20) < 0) {
                    n17 = n18;
                    continue;
                }
                if (Integer.compareUnsigned(n, n21) <= 0) {
                    return ocdaf6bff4db.\u0425(byArray, n19 + (0x28E799D6 ^ 0x28E799DE)) + (n3 == (0x28E799D2 ^ 0x28E799DE) ? n - n20 : 0);
                }
                n16 = n18 + 1;
            }
        }
        return 0;
    }

    public static int W(byte[] byArray, int n, int n2) {
        int n3 = ocdaf6bff4db.\u0244(byArray, n);
        int n4 = 0;
        int n5 = ocdaf6bff4db.\u0244(byArray, n + (0xCFBA7CB3 ^ 0xCFBA7CB1)) - 1;
        while (n4 <= n5) {
            int n6;
            int n7 = n4 + n5 >> 1;
            if (n3 == 1) {
                n6 = ocdaf6bff4db.\u0244(byArray, n + (0xCFBA7CB5 ^ 0xCFBA7CB1) + n7 * (0xCFBA7CB3 ^ 0xCFBA7CB1));
                if (n2 < n6) {
                    n5 = n7 - 1;
                    continue;
                }
                if (Integer.compareUnsigned(n2, n6) <= 0) {
                    return n7;
                }
                n4 = n7 + 1;
                continue;
            }
            if (n3 != (0xCFBA7CB3 ^ 0xCFBA7CB1)) break;
            n6 = n + (0xCFBA7CB5 ^ 0xCFBA7CB1) + n7 * (0xCFBA7CB7 ^ 0xCFBA7CB1);
            int n8 = ocdaf6bff4db.\u0244(byArray, n6);
            int n9 = ocdaf6bff4db.\u0244(byArray, n6 + (0xCFBA7CB3 ^ 0xCFBA7CB1));
            if (n2 < n8) {
                n5 = n7 - 1;
                continue;
            }
            if (Integer.compareUnsigned(n2, n9) <= 0) {
                return n2 - n8 + ocdaf6bff4db.\u0244(byArray, n6 + (0xCFBA7CB5 ^ 0xCFBA7CB1));
            }
            n4 = n7 + 1;
        }
        return -1;
    }

    public static int \u0536(byte[] byArray, int n, int n2) {
        int n3 = ocdaf6bff4db.\u0244(byArray, n);
        if (n3 == 1) {
            int n4 = ocdaf6bff4db.\u0244(byArray, n + (0x2DF95A0E ^ 0x2DF95A0C));
            int n5 = ocdaf6bff4db.\u0244(byArray, n + (0x2DF95A08 ^ 0x2DF95A0C));
            return n2 >= n4 && Integer.compareUnsigned(n2, n4 + n5) < 0 ? ocdaf6bff4db.\u0244(byArray, n + (0x2DF95A0A ^ 0x2DF95A0C) + (n2 - n4) * (0x2DF95A0E ^ 0x2DF95A0C)) : -1;
        }
        if (n3 == (0x2DF95A0E ^ 0x2DF95A0C)) {
            int n6 = 0;
            int n7 = ocdaf6bff4db.\u0244(byArray, n + (0x2DF95A0E ^ 0x2DF95A0C)) - 1;
            while (n6 <= n7) {
                int n8 = n6 + n7 >> 1;
                int n9 = n + (0x2DF95A08 ^ 0x2DF95A0C) + n8 * (0x2DF95A0A ^ 0x2DF95A0C);
                if (n2 < ocdaf6bff4db.\u0244(byArray, n9)) {
                    n7 = n8 - 1;
                    continue;
                }
                if (Integer.compareUnsigned(n2, ocdaf6bff4db.\u0244(byArray, n9 + (0x2DF95A0E ^ 0x2DF95A0C))) <= 0) {
                    return ocdaf6bff4db.\u0244(byArray, n9 + (0x2DF95A08 ^ 0x2DF95A0C));
                }
                n6 = n8 + 1;
            }
        }
        return -1;
    }

    public static int \u04a3(oceb7ed9a2d8 oceb7ed9a2d82, int n, int n2) {
        byte[] byArray = oceb7ed9a2d82.\u02b7;
        if (oceb7ed9a2d82.\u0514 == 0) {
            if (oceb7ed9a2d82.\u0531 == 0) {
                return 0;
            }
            int n3 = oceb7ed9a2d82.\u0531;
            if ((byArray[n3 + (0xE5F8BC36 ^ 0xE5F8BC34)] | byArray[n3 + (0xE5F8BC37 ^ 0xE5F8BC34)]) != 0 && ocdaf6bff4db.\u0244(byArray, n3 + (0xE5F8BC3C ^ 0xE5F8BC34)) == 1) {
                int n4 = n << (0xE5F8BC24 ^ 0xE5F8BC34) | n2;
                int n5 = 0;
                int n6 = ocdaf6bff4db.\u0244(byArray, n3 + (0xE5F8BC3E ^ 0xE5F8BC34)) - 1;
                while (n5 <= n6) {
                    int n7 = n5 + n6 >> 1;
                    int n8 = n3 + (0xE5F8BC26 ^ 0xE5F8BC34) + n7 * (0xE5F8BC32 ^ 0xE5F8BC34);
                    int n9 = ocdaf6bff4db.\u0425(byArray, n8);
                    if (Integer.compareUnsigned(n4, n9) < 0) {
                        n6 = n7 - 1;
                        continue;
                    }
                    if (Integer.compareUnsigned(n4, n9) <= 0) {
                        return ocdaf6bff4db.\u0534(byArray, n8 + (0xE5F8BC30 ^ 0xE5F8BC34));
                    }
                    n5 = n7 + 1;
                }
                return 0;
            }
            return 0;
        }
        int n10 = oceb7ed9a2d82.\u0514;
        if (ocdaf6bff4db.\u0244(byArray, n10) == 1 && (byArray[n10 + (0xE5F8BC36 ^ 0xE5F8BC34)] | byArray[n10 + (0xE5F8BC37 ^ 0xE5F8BC34)]) == 0) {
            int n11 = n10 + ocdaf6bff4db.\u0244(byArray, n10 + (0xE5F8BC3C ^ 0xE5F8BC34));
            int n12 = ocdaf6bff4db.\u0244(byArray, n11);
            for (int i = 0; i < n12; ++i) {
                int n13 = n11 + ocdaf6bff4db.\u0244(byArray, n11 + (0xE5F8BC36 ^ 0xE5F8BC34) + i * (0xE5F8BC36 ^ 0xE5F8BC34));
                if (ocdaf6bff4db.\u0244(byArray, n13) != (0xE5F8BC36 ^ 0xE5F8BC34)) continue;
                int n14 = ocdaf6bff4db.\u0244(byArray, n13 + (0xE5F8BC30 ^ 0xE5F8BC34));
                for (int j = 0; j < n14; ++j) {
                    int n15;
                    int n16;
                    int n17;
                    int n18;
                    int n19 = n13 + ocdaf6bff4db.\u0244(byArray, n13 + (0xE5F8BC32 ^ 0xE5F8BC34) + j * (0xE5F8BC36 ^ 0xE5F8BC34));
                    int n20 = ocdaf6bff4db.\u0244(byArray, n19);
                    int n21 = ocdaf6bff4db.W(byArray, n19 + ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC36 ^ 0xE5F8BC34)), n);
                    if (n21 == -1) continue;
                    if (n20 == 1) {
                        if (ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC30 ^ 0xE5F8BC34)) != (0xE5F8BC30 ^ 0xE5F8BC34) || (byArray[n19 + (0xE5F8BC32 ^ 0xE5F8BC34)] | byArray[n19 + (0xE5F8BC33 ^ 0xE5F8BC34)]) != 0) {
                            return 0;
                        }
                        n18 = n19 + ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC3E ^ 0xE5F8BC34) + n21 * (0xE5F8BC36 ^ 0xE5F8BC34));
                        n17 = 0;
                        n16 = ocdaf6bff4db.\u0244(byArray, n18) - 1;
                        while (n17 <= n16) {
                            n15 = n17 + n16 >> 1;
                            int n22 = n18 + (0xE5F8BC36 ^ 0xE5F8BC34) + n15 * (0xE5F8BC30 ^ 0xE5F8BC34);
                            if (n2 < ocdaf6bff4db.\u0244(byArray, n22)) {
                                n16 = n15 - 1;
                                continue;
                            }
                            if (Integer.compareUnsigned(n2, ocdaf6bff4db.\u0244(byArray, n22)) <= 0) {
                                return ocdaf6bff4db.\u0534(byArray, n22 + (0xE5F8BC36 ^ 0xE5F8BC34));
                            }
                            n17 = n15 + 1;
                        }
                        continue;
                    }
                    if (n20 != (0xE5F8BC36 ^ 0xE5F8BC34)) continue;
                    n18 = ocdaf6bff4db.\u0536(byArray, n19 + ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC3C ^ 0xE5F8BC34)), n);
                    n17 = ocdaf6bff4db.\u0536(byArray, n19 + ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC3E ^ 0xE5F8BC34)), n2);
                    if (ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC30 ^ 0xE5F8BC34)) != (0xE5F8BC30 ^ 0xE5F8BC34) || (byArray[n19 + (0xE5F8BC32 ^ 0xE5F8BC34)] | byArray[n19 + (0xE5F8BC33 ^ 0xE5F8BC34)]) != 0) {
                        return 0;
                    }
                    n16 = ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC38 ^ 0xE5F8BC34));
                    n15 = ocdaf6bff4db.\u0244(byArray, n19 + (0xE5F8BC3A ^ 0xE5F8BC34));
                    if (n18 < 0 || Integer.compareUnsigned(n18, n16) >= 0 || n17 < 0 || Integer.compareUnsigned(n17, n15) >= 0) continue;
                    return ocdaf6bff4db.\u0534(byArray, n19 + (0xE5F8BC24 ^ 0xE5F8BC34) + n18 * n15 * (0xE5F8BC36 ^ 0xE5F8BC34) + n17 * (0xE5F8BC36 ^ 0xE5F8BC34));
                }
            }
            return 0;
        }
        return 0;
    }

    public static int[] \u00fb(oceb7ed9a2d8 oceb7ed9a2d82, int n) {
        int[] nArray;
        if (oceb7ed9a2d82.\u00aa != null) {
            int[] nArray2;
            oc6e8a040e02 oc6e8a040e022 = new oc6e8a040e02(true);
            boolean bl = occ5e76fedf0.\u0386(oceb7ed9a2d82.\u00aa, n, oc6e8a040e022);
            if (bl) {
                int[] nArray3 = new int[0xE3EC3480 ^ 0xE3EC3484];
                nArray3[0] = oc6e8a040e022.\u0533;
                nArray3[1] = oc6e8a040e022.k;
                nArray3[0xE3EC3486 ^ 0xE3EC3484] = oc6e8a040e022.\u01ce;
                nArray2 = nArray3;
                nArray3[0xE3EC3487 ^ 0xE3EC3484] = oc6e8a040e022.\u0389;
            } else {
                nArray2 = new int[0xE3EC3480 ^ 0xE3EC3484];
            }
            return nArray2;
        }
        int n2 = ocdaf6bff4db.\u03fc(oceb7ed9a2d82, n);
        if (n2 < 0) {
            nArray = null;
        } else {
            int[] nArray4 = new int[0xE3EC3480 ^ 0xE3EC3484];
            nArray4[0] = ocdaf6bff4db.\u0534(oceb7ed9a2d82.\u02b7, n2 + (0xE3EC3486 ^ 0xE3EC3484));
            nArray4[1] = ocdaf6bff4db.\u0534(oceb7ed9a2d82.\u02b7, n2 + (0xE3EC3480 ^ 0xE3EC3484));
            nArray4[0xE3EC3486 ^ 0xE3EC3484] = ocdaf6bff4db.\u0534(oceb7ed9a2d82.\u02b7, n2 + (0xE3EC3482 ^ 0xE3EC3484));
            nArray = nArray4;
            nArray4[0xE3EC3487 ^ 0xE3EC3484] = ocdaf6bff4db.\u0534(oceb7ed9a2d82.\u02b7, n2 + (0xE3EC348C ^ 0xE3EC3484));
        }
        return nArray;
    }

    private static void \u01e2(List<ocd1cb14b5c3> list, int n, int n2, int n3, int n4, int n5) {
        list.add(new ocd1cb14b5c3(n, n2, n3, n4, n5, 0, 0));
    }

    private static void \u0209(List<ocd1cb14b5c3> list, boolean bl, boolean bl2, int n, int n2, int n3, int n4, int n5, int n6) {
        if (bl2) {
            if (bl) {
                ocdaf6bff4db.\u01e2(list, 0xFCBD7A9 ^ 0xFCBD7AA, n5 + n3 >> 1, n6 + n4 >> 1, n5, n6);
            }
            ocdaf6bff4db.\u01e2(list, 0xFCBD7A9 ^ 0xFCBD7AA, n, n2, n3, n4);
        } else if (bl) {
            ocdaf6bff4db.\u01e2(list, 0xFCBD7A9 ^ 0xFCBD7AA, n, n2, n5, n6);
        } else {
            ocdaf6bff4db.\u01e2(list, 0xFCBD7A8 ^ 0xFCBD7AA, n, n2, 0, 0);
        }
    }

    private static short \u01cf(float f, boolean bl) {
        int n = oc3004491957.\u0182(f);
        return (short)(bl ? (n > (0xDFEF5822 ^ 0xDFEF27DD) ? 0xDFEF5822 ^ 0xDFEF27DD : (n < (0x2010A7DD ^ 0xDFEF27DD) ? 0x2010A7DD ^ 0xDFEF27DD : n)) : n);
    }

    public static List<ocd1cb14b5c3> \u0194(oceb7ed9a2d8 oceb7ed9a2d82, int n) {
        int n2;
        if (oceb7ed9a2d82.\u00aa != null) {
            oc6e8a040e02 oc6e8a040e022 = new oc6e8a040e02(true);
            if (occ5e76fedf0.\u0386(oceb7ed9a2d82.\u00aa, n, oc6e8a040e022) && oceb7ed9a2d82.\u0508.\u02e4(oc6e8a040e022.\u010f * (0x527069AD ^ 0x527069A3) + (0x527069AC ^ 0x527069A3) & (0xAD8F9653 ^ 0x527069A3))) {
                oc6e8a040e02 oc6e8a040e023 = new oc6e8a040e02(false);
                return occ5e76fedf0.\u0386(oceb7ed9a2d82.\u00aa, n, oc6e8a040e023) ? oc6e8a040e023.\u027c : Collections.emptyList();
            }
            return Collections.emptyList();
        }
        int n3 = ocdaf6bff4db.\u03fc(oceb7ed9a2d82, n);
        if (n3 < 0) {
            return Collections.emptyList();
        }
        byte[] byArray = oceb7ed9a2d82.\u02b7;
        int n4 = ocdaf6bff4db.\u0534(byArray, n3);
        ArrayList<ocd1cb14b5c3> arrayList = new ArrayList<ocd1cb14b5c3>();
        if (n4 > 0) {
            int n5;
            int n6;
            int n7;
            int n8 = n3 + (0x527069A9 ^ 0x527069A3);
            int n9 = ocdaf6bff4db.\u0244(byArray, n8 + n4 * (0x527069A1 ^ 0x527069A3) - (0x527069A1 ^ 0x527069A3));
            int n10 = n9 + 1;
            if (!oceb7ed9a2d82.\u0508.\u02e4((n9 + (0x527069A1 ^ 0x527069A3) * n4) * (0x527069AD ^ 0x527069A3) + (0x527069BE ^ 0x527069A3) & (0x2D8F9653 ^ 0x527069A3))) {
                return arrayList;
            }
            int n11 = n3 + (0x527069AF ^ 0x527069A3) + n4 * (0x527069A1 ^ 0x527069A3) + ocdaf6bff4db.\u0244(byArray, n3 + (0x527069A9 ^ 0x527069A3) + n4 * (0x527069A1 ^ 0x527069A3));
            int[] nArray = new int[n10];
            int[] nArray2 = new int[n10];
            int[] nArray3 = new int[n10];
            int n12 = 0;
            int n13 = 0;
            for (n7 = 0; n7 < n10; ++n7) {
                if (n13 == 0) {
                    if (((n12 = byArray[n11++] & (0x5270695C ^ 0x527069A3)) & (0x527069AB ^ 0x527069A3)) != 0) {
                        n13 = byArray[n11++] & (0x5270695C ^ 0x527069A3);
                    }
                } else {
                    --n13;
                }
                nArray[n7] = n12;
            }
            n7 = 0;
            for (n6 = 0; n6 < n10; ++n6) {
                n12 = nArray[n6];
                if ((n12 & (0x527069A1 ^ 0x527069A3)) != 0) {
                    n5 = byArray[n11++] & (0x5270695C ^ 0x527069A3);
                    n7 += (n12 & (0x527069B3 ^ 0x527069A3)) != 0 ? n5 : -n5;
                } else if ((n12 & (0x527069B3 ^ 0x527069A3)) == 0) {
                    n7 += ocdaf6bff4db.\u0534(byArray, n11);
                    n11 += 2;
                }
                nArray2[n6] = (short)n7;
            }
            n7 = 0;
            for (n6 = 0; n6 < n10; ++n6) {
                n12 = nArray[n6];
                if ((n12 & (0x527069A7 ^ 0x527069A3)) != 0) {
                    n5 = byArray[n11++] & (0x5270695C ^ 0x527069A3);
                    n7 += (n12 & (0x52706983 ^ 0x527069A3)) != 0 ? n5 : -n5;
                } else if ((n12 & (0x52706983 ^ 0x527069A3)) == 0) {
                    n7 += ocdaf6bff4db.\u0534(byArray, n11);
                    n11 += 2;
                }
                nArray3[n6] = (short)n7;
            }
            n6 = 0;
            n5 = 0;
            int n14 = 0;
            int n15 = 0;
            int n16 = 0;
            int n17 = 0;
            int n18 = 0;
            int n19 = 0;
            boolean bl = false;
            boolean bl2 = false;
            for (int i = 0; i < n10; ++i) {
                int n20 = nArray2[i];
                int n21 = nArray3[i];
                if (n6 == i) {
                    if (i != 0) {
                        ocdaf6bff4db.\u0209(arrayList, bl, bl2, n14, n15, n18, n19, n16, n17);
                    }
                    boolean bl3 = bl2 = (nArray[i] & 1) == 0;
                    if (bl2) {
                        n18 = n20;
                        n19 = n21;
                        if ((nArray[i + 1] & 1) == 0) {
                            n14 = n20 + nArray2[i + 1] >> 1;
                            n15 = n21 + nArray3[i + 1] >> 1;
                        } else {
                            n14 = nArray2[i + 1];
                            n15 = nArray3[i + 1];
                            ++i;
                        }
                    } else {
                        n14 = n20;
                        n15 = n21;
                    }
                    ocdaf6bff4db.\u01e2(arrayList, 1, n14, n15, 0, 0);
                    bl = false;
                    n6 = 1 + ocdaf6bff4db.\u0244(byArray, n8 + n5++ * (0x527069A1 ^ 0x527069A3));
                    continue;
                }
                if ((nArray[i] & 1) == 0) {
                    if (bl) {
                        ocdaf6bff4db.\u01e2(arrayList, 0x527069A0 ^ 0x527069A3, n16 + n20 >> 1, n17 + n21 >> 1, n16, n17);
                    }
                    n16 = n20;
                    n17 = n21;
                    bl = true;
                    continue;
                }
                ocdaf6bff4db.\u01e2(arrayList, bl ? 0x527069A0 ^ 0x527069A3 : 0x527069A1 ^ 0x527069A3, n20, n21, bl ? n16 : 0, bl ? n17 : 0);
                bl = false;
            }
            ocdaf6bff4db.\u0209(arrayList, bl, bl2, n14, n15, n18, n19, n16, n17);
            return arrayList;
        }
        if (n4 == 0) {
            return arrayList;
        }
        int n22 = n3 + (0x527069A9 ^ 0x527069A3);
        float f = L.\u026d(0x525B25E7 ^ 0x527069A3);
        float f2 = L.\u026d(0x525B25E3 ^ 0x527069A3);
        do {
            n2 = ocdaf6bff4db.\u0244(byArray, n22);
            int n23 = ocdaf6bff4db.\u0244(byArray, n22 + (0x527069A1 ^ 0x527069A3));
            n22 += 4;
            float f3 = f;
            float f4 = 0.0f;
            float f5 = f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            if ((n2 & (0x527069A1 ^ 0x527069A3)) != 0) {
                if ((n2 & 1) != 0) {
                    f7 = ocdaf6bff4db.\u0534(byArray, n22);
                    f8 = ocdaf6bff4db.\u0534(byArray, n22 + (0x527069A1 ^ 0x527069A3));
                    n22 += 4;
                } else {
                    f7 = byArray[n22];
                    f8 = byArray[n22 + 1];
                    n22 += 2;
                }
            }
            if ((n2 & (0x527069AB ^ 0x527069A3)) != 0) {
                f3 = f5 = (float)ocdaf6bff4db.\u0534(byArray, n22) * f2;
                n22 += 2;
            } else if ((n2 & (0x527069E3 ^ 0x527069A3)) != 0) {
                f3 = (float)ocdaf6bff4db.\u0534(byArray, n22) * f2;
                f5 = (float)ocdaf6bff4db.\u0534(byArray, n22 + (0x527069A1 ^ 0x527069A3)) * f2;
                n22 += 4;
            } else if ((n2 & (0x52706923 ^ 0x527069A3)) != 0) {
                f3 = (float)ocdaf6bff4db.\u0534(byArray, n22) * f2;
                f6 = (float)ocdaf6bff4db.\u0534(byArray, n22 + (0x527069A1 ^ 0x527069A3)) * f2;
                f4 = (float)ocdaf6bff4db.\u0534(byArray, n22 + (0x527069A7 ^ 0x527069A3)) * f2;
                f5 = (float)ocdaf6bff4db.\u0534(byArray, n22 + (0x527069A5 ^ 0x527069A3)) * f2;
                n22 += 8;
            }
            List<ocd1cb14b5c3> list = ocdaf6bff4db.\u0194(oceb7ed9a2d82, n23);
            if (list.isEmpty()) continue;
            float f9 = (float)StrictMath.sqrt(f3 * f3 + f6 * f6);
            float f10 = (float)StrictMath.sqrt(f4 * f4 + f5 * f5);
            int n24 = list.size();
            int n25 = n24 >= (0x527069AA ^ 0x527069A3) ? n24 - (n24 % (0x527069AB ^ 0x527069A3) != 0 ? n24 % (0x527069AB ^ 0x527069A3) : 0x527069AB ^ 0x527069A3) : 0;
            for (int i = 0; i < n24; ++i) {
                ocd1cb14b5c3 ocd1cb14b5c32 = list.get(i);
                boolean bl = i >= n25 || i % (0x527069AB ^ 0x527069A3) >= 1 && i % (0x527069AB ^ 0x527069A3) <= (0x527069A0 ^ 0x527069A3);
                boolean bl4 = bl && (i >= n25 || i % (0x527069AB ^ 0x527069A3) != (0x527069A1 ^ 0x527069A3));
                float f11 = ocd1cb14b5c32.\u04c1;
                float f12 = ocd1cb14b5c32.\u0122;
                float f13 = ocd1cb14b5c32.\u025c;
                float f14 = ocd1cb14b5c32.\u0518;
                ocd1cb14b5c32.\u04c1 = ocdaf6bff4db.\u01cf(f9 * (f4 * f12 + f3 * f11 + f7), bl);
                ocd1cb14b5c32.\u0122 = ocdaf6bff4db.\u01cf(f10 * (f6 * f11 + f5 * f12 + f8), bl);
                ocd1cb14b5c32.\u025c = ocdaf6bff4db.\u01cf(f9 * (f4 * f14 + f3 * f13 + f7), bl4);
                ocd1cb14b5c32.\u0518 = ocdaf6bff4db.\u01cf(f10 * (f6 * f13 + f5 * f14 + f8), bl);
            }
            if (!oceb7ed9a2d82.\u0508.\u02e4((arrayList.size() + n24) * (0x527069AD ^ 0x527069A3))) {
                return Collections.emptyList();
            }
            arrayList.addAll(list);
        } while ((n2 & (0x52706983 ^ 0x527069A3)) != 0);
        return arrayList;
    }

    private ocdaf6bff4db() {
    }
}

