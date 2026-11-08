/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc75d51ec7eb;

public class oc30e402796f {
    public static int \u04a6;

    private oc30e402796f() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static float \u04e3(float f, float f2) {
        int n;
        block15: {
            int n2;
            int n3;
            block13: {
                int n4;
                block14: {
                    block12: {
                        n4 = Float.floatToRawIntBits(f) & (0xC15ABE30 ^ 0xBEA541CF);
                        n3 = Float.floatToRawIntBits(f2) & (0xC15ABE30 ^ 0xBEA541CF);
                        n2 = oc75d51ec7eb.\u03e9;
                        n = n4;
                        if (n2 != 0) break block12;
                        if (n == (0xC12541CF ^ 0xBEA541CF)) return Float.POSITIVE_INFINITY;
                        n = n3;
                    }
                    if (n2 != 0) break block13;
                    if (n != (0xC12541CF ^ 0xBEA541CF)) break block14;
                    return Float.POSITIVE_INFINITY;
                }
                n = n4;
            }
            if (n2 != 0) break block15;
            if (n > (0xC12541CF ^ 0xBEA541CF)) return Float.NaN;
            n = n3;
        }
        if (n > (0xC12541CF ^ 0xBEA541CF)) return Float.NaN;
        double d = f;
        double d2 = f2;
        return (float)Math.sqrt(d * d + d2 * d2);
    }

    public static int \u00fd(float f) {
        int n;
        block16: {
            block13: {
                float f2;
                block15: {
                    float f3;
                    block14: {
                        int n2;
                        block12: {
                            n2 = oc75d51ec7eb.\u03e9;
                            f2 = f;
                            if (n2 != 0) break block12;
                            if (Float.isNaN(f2)) break block13;
                            f2 = f;
                        }
                        f3 = 2.14748365E9f;
                        if (n2 != 0) break block14;
                        if (f2 >= f3) break block13;
                        f2 = f;
                        if (n2 != 0) break block15;
                        f3 = -2.14748365E9f;
                    }
                    if (f2 < f3) break block13;
                    f2 = f;
                }
                n = (int)f2;
                break block16;
            }
            n = 0x6451BF55 ^ 0xE451BF55;
        }
        return n;
    }

    public static int \u03d2(double d) {
        int n;
        block16: {
            block13: {
                double d2;
                block15: {
                    int n2;
                    block14: {
                        block12: {
                            n2 = oc75d51ec7eb.\u03e9;
                            d2 = d;
                            if (n2 != 0) break block12;
                            if (Double.isNaN(d2)) break block13;
                            d2 = d;
                        }
                        if (n2 != 0) break block14;
                        if (d2 >= 2.147483648E9) break block13;
                        d2 = d;
                    }
                    if (n2 != 0) break block15;
                    if (d2 < -2.147483648E9) break block13;
                    d2 = d;
                }
                n = (int)d2;
                break block16;
            }
            n = 0x142CA85E ^ 0x942CA85E;
        }
        return n;
    }

    public static long \u03e7(float f) {
        long l;
        block16: {
            block13: {
                float f2;
                block15: {
                    int n;
                    block14: {
                        block12: {
                            n = oc75d51ec7eb.\u03e9;
                            f2 = f;
                            if (n != 0) break block12;
                            if (Float.isNaN(f2)) break block13;
                            f2 = f;
                        }
                        if (n != 0) break block14;
                        if ((double)f2 >= 9.223372036854776E18) break block13;
                        f2 = f;
                    }
                    if (n != 0) break block15;
                    if ((double)f2 < -9.223372036854776E18) break block13;
                    f2 = f;
                }
                l = (long)f2;
                break block16;
            }
            l = 0xA30DD0490DC55D88L ^ 0x230DD0490DC55D88L;
        }
        return l;
    }

    public static long \u056c(double d) {
        long l;
        block16: {
            block13: {
                double d2;
                block15: {
                    double d3;
                    block14: {
                        int n;
                        block12: {
                            n = oc75d51ec7eb.\u03e9;
                            d2 = d;
                            if (n != 0) break block12;
                            if (Double.isNaN(d2)) break block13;
                            d2 = d;
                        }
                        d3 = 9.223372036854776E18;
                        if (n != 0) break block14;
                        if (d2 >= d3) break block13;
                        d2 = d;
                        if (n != 0) break block15;
                        d3 = -9.223372036854776E18;
                    }
                    if (d2 < d3) break block13;
                    d2 = d;
                }
                l = (long)d2;
                break block16;
            }
            l = 0xFC7A6247867DB628L ^ 0x7C7A6247867DB628L;
        }
        return l;
    }

    public static float \u017b(float f) {
        int n;
        block29: {
            block30: {
                int n2;
                block27: {
                    int n3;
                    block28: {
                        block20: {
                            block21: {
                                float f2;
                                block24: {
                                    int n4;
                                    int n5;
                                    int n6;
                                    block25: {
                                        int n7;
                                        block26: {
                                            block22: {
                                                block23: {
                                                    block18: {
                                                        int n8;
                                                        block19: {
                                                            n3 = Float.floatToRawIntBits(f);
                                                            n8 = n3 >>> (0xD88461F6 ^ 0xD88461E1) & (0xD884611E ^ 0xD88461E1);
                                                            n2 = oc75d51ec7eb.\u03e9;
                                                            n = n8;
                                                            if (n2 != 0) break block18;
                                                            if (n < (0xD8846177 ^ 0xD88461E1)) break block19;
                                                            return f;
                                                        }
                                                        n = n8;
                                                    }
                                                    if (n2 != 0) break block20;
                                                    if (n < (0xD884619E ^ 0xD88461E1)) break block21;
                                                    n6 = -1 << ((0xD88461F7 ^ 0xD88461E1) - (n3 >>> (0xD88461F6 ^ 0xD88461E1)) & (0xD88461FE ^ 0xD88461E1));
                                                    n7 = ~n6;
                                                    n5 = n3;
                                                    n4 = n7;
                                                    if (n2 != 0) break block22;
                                                    if ((n5 & n4) != 0) break block23;
                                                    f2 = f;
                                                    break block24;
                                                }
                                                n5 = n3;
                                                n4 = n3;
                                            }
                                            if (n2 != 0) break block25;
                                            if (n4 >= 0) break block26;
                                            n4 = 0;
                                            break block25;
                                        }
                                        n4 = n7;
                                    }
                                    f2 = Float.intBitsToFloat(n5 + n4 & n6);
                                }
                                return f2;
                            }
                            n = n3;
                        }
                        if (n2 != 0) break block27;
                        if (n >= 0) break block28;
                        n = 0x588461E1 ^ 0xD88461E1;
                        break block29;
                    }
                    n = n3;
                }
                if (n2 != 0) break block29;
                if (n != 0) break block30;
                n = 0;
                break block29;
            }
            n = 0xE70461E1 ^ 0xD88461E1;
        }
        return Float.intBitsToFloat(n);
    }
}

