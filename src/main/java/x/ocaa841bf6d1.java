/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.I;
import x.oc01be0c7606;
import x.oc30e402796f;
import x.ocbc6b8beaac;
import x.ocd857d42ebe;

public class ocaa841bf6d1 {
    public static boolean \u00f4;

    private ocaa841bf6d1() {
    }

    private static double \u0134(int n) {
        return ocd857d42ebe.\u049c(n);
    }

    private static float \u0109(float f, int n) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f) ^ ocd857d42ebe.\u0522(n));
    }

    private static float \u02e2(double d, int n, int n2, boolean bl) {
        double d2 = d * d;
        double d3 = d2 * d2;
        double d4 = bl ? Double.longBitsToDouble(Double.doubleToRawLongBits(d) ^ ocd857d42ebe.h(n2)) : d;
        double d5 = d4;
        double d6 = bl ? d5 * d2 : d2 * d;
        double d7 = d6;
        double d8 = d2 * ocaa841bf6d1.\u0134(n) + ocaa841bf6d1.\u0134(n + (0x286B2A68 ^ 0x286B2A78));
        double d9 = d2 * ocaa841bf6d1.\u0134(n + (0x286B2A70 ^ 0x286B2A78)) + ocaa841bf6d1.\u0134(n + (0x286B2A60 ^ 0x286B2A78));
        double d10 = d3 * d7 * d8;
        double d11 = d7 * d9;
        double d12 = bl ? d11 - d : d11 + d;
        d11 = d12;
        return (float)(d11 + d10);
    }

    private static float \u0582(double d, int n, int n2, boolean bl) {
        double d2 = d * d;
        double d3 = d2 * d2;
        double d4 = ocaa841bf6d1.\u0134(n) * d2 + ocaa841bf6d1.\u0134(n + (0x7016943C ^ 0x70169434));
        double d5 = ocaa841bf6d1.\u0134(n + (0x70169424 ^ 0x70169434)) * d2 + ocaa841bf6d1.\u0134(n + (0x7016942C ^ 0x70169434));
        double d6 = d2 * d3;
        double d7 = d3 * ocaa841bf6d1.\u0134(n + (0x70169414 ^ 0x70169434)) + d5;
        double d8 = d6 * d4;
        float f = (float)(d8 + d7);
        float f2 = bl ? ocaa841bf6d1.\u0109(f, n2) : f;
        return f2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int \u049f(float f, double[] dArray) {
        int n;
        double[] dArray2;
        block25: {
            int n2;
            block24: {
                int n3;
                int n4;
                int n5;
                block18: {
                    block19: {
                        int n6;
                        double d;
                        block22: {
                            int n7;
                            double d2;
                            block23: {
                                double d3;
                                block20: {
                                    double d4;
                                    block21: {
                                        n5 = Float.floatToRawIntBits(f);
                                        n4 = n5 & (0x1766EB9B ^ 0x68991464);
                                        n2 = oc01be0c7606.\u017a;
                                        n3 = n4;
                                        if (n2 != 0) break block18;
                                        if (n3 > (0x25501BBE ^ 0x68991464)) break block19;
                                        double d5 = f;
                                        d = ocaa841bf6d1.\u0134(0x68B2A2A4 ^ 0x68991464) * d5;
                                        d += ocaa841bf6d1.\u0134(0x68B2A2AC ^ 0x68991464);
                                        n6 = oc30e402796f.\u03d2(d += ocaa841bf6d1.\u0134(0x68B2A2B4 ^ 0x68991464));
                                        double d6 = ocaa841bf6d1.\u0134(0x68B2A2BC ^ 0x68991464) * d + d5;
                                        dArray[0] = d4 = ocaa841bf6d1.\u0134(0x68B2A284 ^ 0x68991464) * d + d6;
                                        d2 = ocaa841bf6d1.\u0134(0x68B2A28C ^ 0x68991464);
                                        d3 = d4;
                                        if (n2 != 0) break block20;
                                        if (!(d2 > d3)) break block21;
                                        d += ocaa841bf6d1.\u0134(0x68B2A364 ^ 0x68991464);
                                        --n6;
                                        if (n2 == 0) break block22;
                                    }
                                    d2 = d4;
                                    n7 = 0x68B2A294 ^ 0x68991464;
                                    if (n2 != 0) break block23;
                                    d3 = ocaa841bf6d1.\u0134(n7);
                                }
                                if (!(d2 > d3)) {
                                    return n6;
                                }
                                d2 = d;
                                n7 = 0x68B2A29C ^ 0x68991464;
                            }
                            d = d2 + ocaa841bf6d1.\u0134(n7);
                            ++n6;
                        }
                        double d7 = ocaa841bf6d1.\u0134(0x68B2A2BC ^ 0x68991464) * d;
                        dArray[0] = (d *= ocaa841bf6d1.\u0134(0x68B2A284 ^ 0x68991464)) + (d5 += d7);
                        return n6;
                    }
                    n3 = n4;
                }
                if (n2 == 0) {
                    if (n3 > (0x17E6EB9B ^ 0x68991464)) {
                        dArray[0] = I.\u01e4(f);
                        return 0;
                    }
                    n3 = (n4 >>> (0x68991473 ^ 0x68991464)) - (0x689914F2 ^ 0x68991464);
                }
                int n8 = n3;
                int n9 = n4 - (n8 << (0x68991473 ^ 0x68991464));
                dArray2 = new double[1];
                n = ocbc6b8beaac.\u04cc(new double[]{Float.intBitsToFloat(n9)}, dArray2, n8, 1, 0);
                if (n2 != 0) break block24;
                if (n5 >= 0) break block25;
                dArray[0] = Double.longBitsToDouble(Double.doubleToRawLongBits(dArray2[0]) ^ ocd857d42ebe.h(0x68B2A2D4 ^ 0x68991464));
                n = -n;
            }
            if (n2 == 0) return n;
        }
        dArray[0] = dArray2[0];
        return n;
    }

    public static float \u026d(float f) {
        int n;
        double d;
        block70: {
            int n2;
            block71: {
                int n3;
                block68: {
                    block69: {
                        int n4;
                        block66: {
                            block67: {
                                block57: {
                                    int n5;
                                    block58: {
                                        int n6;
                                        int n7;
                                        int n8;
                                        double d2;
                                        block64: {
                                            block65: {
                                                int n9;
                                                double d3;
                                                int n10;
                                                block62: {
                                                    block63: {
                                                        block59: {
                                                            int n11;
                                                            double d4;
                                                            block60: {
                                                                block61: {
                                                                    block50: {
                                                                        block51: {
                                                                            int n12;
                                                                            double d5;
                                                                            block55: {
                                                                                block56: {
                                                                                    block52: {
                                                                                        int n13;
                                                                                        double d6;
                                                                                        block53: {
                                                                                            block54: {
                                                                                                block46: {
                                                                                                    block47: {
                                                                                                        float f2;
                                                                                                        block49: {
                                                                                                            block48: {
                                                                                                                int n14;
                                                                                                                block44: {
                                                                                                                    block45: {
                                                                                                                        int n15 = Float.floatToRawIntBits(f);
                                                                                                                        n5 = n15 & (0x4DCBEC3B ^ 0x323413C4);
                                                                                                                        n3 = oc01be0c7606.\u017a;
                                                                                                                        n14 = n15;
                                                                                                                        if (n3 != 0) break block44;
                                                                                                                        if (n14 >= 0) break block45;
                                                                                                                        n14 = 1;
                                                                                                                        break block44;
                                                                                                                    }
                                                                                                                    n14 = 0;
                                                                                                                }
                                                                                                                n10 = n14;
                                                                                                                d = f;
                                                                                                                n4 = n5;
                                                                                                                if (n3 != 0) break block46;
                                                                                                                if (n4 > (0xD7D1C1E ^ 0x323413C4)) break block47;
                                                                                                                if (n5 >= (0xBB413C4 ^ 0x323413C4)) break block48;
                                                                                                                f2 = f;
                                                                                                                break block49;
                                                                                                            }
                                                                                                            f2 = ocaa841bf6d1.\u02e2(d, 0x321FAC74 ^ 0x323413C4, 0x321FAC64 ^ 0x323413C4, false);
                                                                                                        }
                                                                                                        return f2;
                                                                                                    }
                                                                                                    n4 = n5;
                                                                                                }
                                                                                                if (n3 != 0) break block50;
                                                                                                if (n4 >= (0x724F4016 ^ 0x323413C4)) break block51;
                                                                                                if (n5 < (0x7222D820 ^ 0x323413C4)) break block52;
                                                                                                d6 = d;
                                                                                                n13 = n10;
                                                                                                if (n3 != 0) break block53;
                                                                                                if (n13 == 0) break block54;
                                                                                                n13 = 0x321FAC34 ^ 0x323413C4;
                                                                                                break block53;
                                                                                            }
                                                                                            n13 = 0x321FAC3C ^ 0x323413C4;
                                                                                        }
                                                                                        d = d6 + ocaa841bf6d1.\u0134(n13);
                                                                                        return ocaa841bf6d1.\u02e2(d, 0x321FAC74 ^ 0x323413C4, 0x321FAC64 ^ 0x323413C4, true);
                                                                                    }
                                                                                    d5 = d;
                                                                                    n12 = n10;
                                                                                    if (n3 != 0) break block55;
                                                                                    if (n12 == 0) break block56;
                                                                                    n12 = 0x321FD3C4 ^ 0x323413C4;
                                                                                    break block55;
                                                                                }
                                                                                n12 = 0x321FD3CC ^ 0x323413C4;
                                                                            }
                                                                            d = d5 + ocaa841bf6d1.\u0134(n12);
                                                                            return ocaa841bf6d1.\u0582(d, 0x321FACA4 ^ 0x323413C4, 0x321FAC54 ^ 0x323413C4, n10 != 0);
                                                                        }
                                                                        n4 = n5;
                                                                    }
                                                                    if (n3 != 0) break block57;
                                                                    if (n4 >= (0x72D62212 ^ 0x323413C4)) break block58;
                                                                    if (n5 < (0x729BFE24 ^ 0x323413C4)) break block59;
                                                                    d4 = d;
                                                                    n11 = n10;
                                                                    if (n3 != 0) break block60;
                                                                    if (n11 == 0) break block61;
                                                                    n11 = 0x321FAC14 ^ 0x323413C4;
                                                                    break block60;
                                                                }
                                                                n11 = 0x321FAC1C ^ 0x323413C4;
                                                            }
                                                            d = d4 + ocaa841bf6d1.\u0134(n11);
                                                            return ocaa841bf6d1.\u02e2(d, 0x321FAC74 ^ 0x323413C4, 0x321FAC64 ^ 0x323413C4, false);
                                                        }
                                                        d3 = d;
                                                        n9 = n10;
                                                        if (n3 != 0) break block62;
                                                        if (n9 == 0) break block63;
                                                        n9 = 0x321FAC24 ^ 0x323413C4;
                                                        break block62;
                                                    }
                                                    n9 = 0x321FAC2C ^ 0x323413C4;
                                                }
                                                d = d3 + ocaa841bf6d1.\u0134(n9);
                                                d2 = d;
                                                n8 = 0x321FACA4 ^ 0x323413C4;
                                                n7 = 0x321FAC54 ^ 0x323413C4;
                                                n6 = n10;
                                                if (n3 != 0) break block64;
                                                if (n6 != 0) break block65;
                                                n6 = 1;
                                                break block64;
                                            }
                                            n6 = 0;
                                        }
                                        return ocaa841bf6d1.\u0582(d2, n8, n7, n6 != 0);
                                    }
                                    n4 = n5;
                                }
                                if (n3 != 0) break block66;
                                if (n4 <= (0x4D4BEC3B ^ 0x323413C4)) break block67;
                                return I.\u01e4(f);
                            }
                            n4 = 1;
                        }
                        double[] dArray = new double[n4];
                        n2 = ocaa841bf6d1.\u049f(f, dArray) & (0x323413C7 ^ 0x323413C4);
                        d = dArray[0];
                        n = n2;
                        if (n3 != 0) break block68;
                        if (n != 0) break block69;
                        return ocaa841bf6d1.\u02e2(d, 0x321FAC74 ^ 0x323413C4, 0x321FAC64 ^ 0x323413C4, false);
                    }
                    n = n2;
                }
                if (n3 != 0) break block70;
                if (n != 1) break block71;
                return ocaa841bf6d1.\u0582(d, 0x321FACA4 ^ 0x323413C4, 0x321FAC54 ^ 0x323413C4, false);
            }
            n = n2;
        }
        float f3 = n == (0x323413C6 ^ 0x323413C4) ? ocaa841bf6d1.\u02e2(d, 0x321FAC74 ^ 0x323413C4, 0x321FAC64 ^ 0x323413C4, true) : ocaa841bf6d1.\u0582(d, 0x321FACA4 ^ 0x323413C4, 0x321FAC54 ^ 0x323413C4, true);
        return f3;
    }

    public static float \u018c(float f) {
        int n;
        double d;
        block77: {
            int n2;
            block78: {
                int n3;
                block75: {
                    block76: {
                        int n4;
                        block73: {
                            block74: {
                                block65: {
                                    int n5;
                                    block66: {
                                        double d2;
                                        block80: {
                                            block72: {
                                                int n6;
                                                block71: {
                                                    block67: {
                                                        int n7;
                                                        block68: {
                                                            int n8;
                                                            double d3;
                                                            block69: {
                                                                block70: {
                                                                    block56: {
                                                                        block57: {
                                                                            double d4;
                                                                            block64: {
                                                                                int n9;
                                                                                block62: {
                                                                                    block63: {
                                                                                        block58: {
                                                                                            block59: {
                                                                                                int n10;
                                                                                                double d5;
                                                                                                block60: {
                                                                                                    block61: {
                                                                                                        block52: {
                                                                                                            block53: {
                                                                                                                float f2;
                                                                                                                block79: {
                                                                                                                    block55: {
                                                                                                                        int n11;
                                                                                                                        block54: {
                                                                                                                            int n12;
                                                                                                                            block50: {
                                                                                                                                block51: {
                                                                                                                                    int n13 = Float.floatToRawIntBits(f);
                                                                                                                                    n5 = n13 & (0xBD66DCEA ^ 0xC2992315);
                                                                                                                                    n3 = oc01be0c7606.\u017a;
                                                                                                                                    n12 = n13;
                                                                                                                                    if (n3 != 0) break block50;
                                                                                                                                    if (n12 >= 0) break block51;
                                                                                                                                    n12 = 1;
                                                                                                                                    break block50;
                                                                                                                                }
                                                                                                                                n12 = 0;
                                                                                                                            }
                                                                                                                            n7 = n12;
                                                                                                                            d = f;
                                                                                                                            n4 = n5;
                                                                                                                            if (n3 != 0) break block52;
                                                                                                                            if (n4 > (0xFDD02CCF ^ 0xC2992315)) break block53;
                                                                                                                            n11 = n5;
                                                                                                                            if (n3 != 0) break block54;
                                                                                                                            if (n11 >= (0xFB192315 ^ 0xC2992315)) break block55;
                                                                                                                            n11 = 0xC2B2E851 ^ 0xC2992315;
                                                                                                                        }
                                                                                                                        f2 = ocd857d42ebe.\u0284(n11);
                                                                                                                        break block79;
                                                                                                                    }
                                                                                                                    f2 = ocaa841bf6d1.\u0582(d, 0xC2B2E9D5 ^ 0xC2992315, 0xC2B2E9E5 ^ 0xC2992315, false);
                                                                                                                }
                                                                                                                return f2;
                                                                                                            }
                                                                                                            n4 = n5;
                                                                                                        }
                                                                                                        if (n3 != 0) break block56;
                                                                                                        if (n4 >= (0x82E270C7 ^ 0xC2992315)) break block57;
                                                                                                        n9 = n5;
                                                                                                        if (n3 != 0) break block58;
                                                                                                        if (n9 <= (0x828FE8F6 ^ 0xC2992315)) break block59;
                                                                                                        d5 = d;
                                                                                                        n10 = n7;
                                                                                                        if (n3 != 0) break block60;
                                                                                                        if (n10 == 0) break block61;
                                                                                                        n10 = 0xC2B2E825 ^ 0xC2992315;
                                                                                                        break block60;
                                                                                                    }
                                                                                                    n10 = 0xC2B2E82D ^ 0xC2992315;
                                                                                                }
                                                                                                d = d5 + ocaa841bf6d1.\u0134(n10);
                                                                                                return ocaa841bf6d1.\u0582(d, 0xC2B2E9D5 ^ 0xC2992315, 0xC2B2E9E5 ^ 0xC2992315, true);
                                                                                            }
                                                                                            n9 = n7;
                                                                                        }
                                                                                        if (n3 != 0) break block62;
                                                                                        if (n9 == 0) break block63;
                                                                                        d4 = d + ocaa841bf6d1.\u0134(0xC2B2E83D ^ 0xC2992315);
                                                                                        break block64;
                                                                                    }
                                                                                    n9 = 0xC2B2E83D ^ 0xC2992315;
                                                                                }
                                                                                d4 = ocaa841bf6d1.\u0134(n9) - d;
                                                                            }
                                                                            d = d4;
                                                                            return ocaa841bf6d1.\u02e2(d, 0xC2B2E9B5 ^ 0xC2992315, 0xC2B2E815 ^ 0xC2992315, false);
                                                                        }
                                                                        n4 = n5;
                                                                    }
                                                                    if (n3 != 0) break block65;
                                                                    if (n4 >= (0x827B12C3 ^ 0xC2992315)) break block66;
                                                                    n6 = n5;
                                                                    if (n3 != 0) break block67;
                                                                    if (n6 <= (0x8236CECA ^ 0xC2992315)) break block68;
                                                                    d3 = d;
                                                                    n8 = n7;
                                                                    if (n3 != 0) break block69;
                                                                    if (n8 == 0) break block70;
                                                                    n8 = 0xC2B2E80D ^ 0xC2992315;
                                                                    break block69;
                                                                }
                                                                n8 = 0xC2B2E835 ^ 0xC2992315;
                                                            }
                                                            d = d3 + ocaa841bf6d1.\u0134(n8);
                                                            return ocaa841bf6d1.\u0582(d, 0xC2B2E9D5 ^ 0xC2992315, 0xC2B2E9E5 ^ 0xC2992315, false);
                                                        }
                                                        n6 = n7;
                                                    }
                                                    if (n3 != 0) break block71;
                                                    if (n6 == 0) break block72;
                                                    n6 = 0xC2B2E805 ^ 0xC2992315;
                                                }
                                                d2 = ocaa841bf6d1.\u0134(n6) - d;
                                                break block80;
                                            }
                                            d2 = d + ocaa841bf6d1.\u0134(0xC2B2E805 ^ 0xC2992315);
                                        }
                                        d = d2;
                                        return ocaa841bf6d1.\u02e2(d, 0xC2B2E9B5 ^ 0xC2992315, 0xC2B2E815 ^ 0xC2992315, false);
                                    }
                                    n4 = n5;
                                }
                                if (n3 != 0) break block73;
                                if (n4 <= (0xBDE6DCEA ^ 0xC2992315)) break block74;
                                return I.\u01e4(f);
                            }
                            n4 = 1;
                        }
                        double[] dArray = new double[n4];
                        n2 = ocaa841bf6d1.\u049f(f, dArray) & (0xC2992316 ^ 0xC2992315);
                        d = dArray[0];
                        n = n2;
                        if (n3 != 0) break block75;
                        if (n != 0) break block76;
                        return ocaa841bf6d1.\u0582(d, 0xC2B2E9D5 ^ 0xC2992315, 0xC2B2E9E5 ^ 0xC2992315, false);
                    }
                    n = n2;
                }
                if (n3 != 0) break block77;
                if (n != 1) break block78;
                return ocaa841bf6d1.\u02e2(d, 0xC2B2E9B5 ^ 0xC2992315, 0xC2B2E815 ^ 0xC2992315, true);
            }
            n = n2;
        }
        float f3 = n == (0xC2992317 ^ 0xC2992315) ? ocaa841bf6d1.\u0582(d, 0xC2B2E9D5 ^ 0xC2992315, 0xC2B2E9E5 ^ 0xC2992315, true) : ocaa841bf6d1.\u02e2(d, 0xC2B2E9B5 ^ 0xC2992315, 0xC2B2E815 ^ 0xC2992315, false);
        return f3;
    }
}

