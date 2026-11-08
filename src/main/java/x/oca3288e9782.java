/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.Vec3;
import x.oc497d0cdf29;
import x.ocb112cc87f6;
import x.ocd5cc9ffddf;

public class oca3288e9782 {
    public static boolean \u00d6;

    private oca3288e9782() {
    }

    private static double \u01ae(double d) {
        return (float)d;
    }

    private static double \u04e5(double d, double d2) {
        double d3;
        block4: {
            block5: {
                boolean bl = ocd5cc9ffddf.\u0406;
                d3 = d;
                if (bl) break block4;
                if (!(d3 < d2)) break block5;
                d3 = d;
                break block4;
            }
            d3 = d2;
        }
        return d3;
    }

    private static double \u00c4(double d, double d2) {
        double d3;
        block4: {
            block5: {
                boolean bl = ocd5cc9ffddf.\u0406;
                d3 = d;
                if (bl) break block4;
                if (!(d3 > d2)) break block5;
                d3 = d;
                break block4;
            }
            d3 = d2;
        }
        return d3;
    }

    private static double \u015e(double d, double d2) {
        double d3;
        block6: {
            double d4;
            block4: {
                block5: {
                    boolean bl = ocd5cc9ffddf.\u0406;
                    d4 = d2;
                    if (bl) break block4;
                    if (!Double.isNaN(d4)) break block5;
                    d3 = d;
                    break block6;
                }
                d4 = d;
            }
            d3 = oca3288e9782.\u04e5(d4, d2);
        }
        return d3;
    }

    private static double \u0411(double d, double d2) {
        double d3;
        block6: {
            double d4;
            block4: {
                block5: {
                    boolean bl = ocd5cc9ffddf.\u0406;
                    d4 = d2;
                    if (bl) break block4;
                    if (!Double.isNaN(d4)) break block5;
                    d3 = d;
                    break block6;
                }
                d4 = d;
            }
            d3 = oca3288e9782.\u00c4(d4, d2);
        }
        return d3;
    }

    public static Vec3 \u04ab(double[] dArray, Vec3 vec3, Vec3 vec32) {
        Vec3 vec33;
        block13: {
            boolean bl;
            block15: {
                block14: {
                    boolean bl2;
                    block12: {
                        block11: {
                            float f;
                            float f2;
                            float f3;
                            block10: {
                                double d = ocb112cc87f6.\u03a4(0x909AB3DF ^ 0x90895B57);
                                bl2 = ocd5cc9ffddf.\u0406;
                                double d2 = ocb112cc87f6.\u03a4(0x909AB3C7 ^ 0x90895B57);
                                double d3 = oca3288e9782.\u01ae((dArray[0] - vec3.xCoord) * (d / vec32.xCoord));
                                double d4 = oca3288e9782.\u01ae((dArray[0x90895B54 ^ 0x90895B57] - vec3.xCoord) * (d / vec32.xCoord));
                                double d5 = oca3288e9782.\u01ae(oca3288e9782.\u04e5(oca3288e9782.\u00c4(d3, 0.0), oca3288e9782.\u00c4(d4, 0.0)));
                                double d6 = oca3288e9782.\u01ae(oca3288e9782.\u00c4(oca3288e9782.\u04e5(d3, d2), oca3288e9782.\u04e5(d4, d2)));
                                double d7 = oca3288e9782.\u01ae((dArray[1] - vec3.yCoord) * (d / vec32.yCoord));
                                double d8 = oca3288e9782.\u01ae((dArray[0x90895B53 ^ 0x90895B57] - vec3.yCoord) * (d / vec32.yCoord));
                                double d9 = oca3288e9782.\u01ae(oca3288e9782.\u04e5(oca3288e9782.\u00c4(d7, d5), oca3288e9782.\u00c4(d8, d5)));
                                double d10 = oca3288e9782.\u01ae(oca3288e9782.\u00c4(oca3288e9782.\u04e5(d7, d6), oca3288e9782.\u04e5(d8, d6)));
                                double d11 = oca3288e9782.\u01ae((dArray[0x90895B55 ^ 0x90895B57] - vec3.zCoord) * (d / vec32.zCoord));
                                double d12 = oca3288e9782.\u01ae((dArray[0x90895B52 ^ 0x90895B57] - vec3.zCoord) * (d / vec32.zCoord));
                                f3 = (float)oca3288e9782.\u015e(oca3288e9782.\u0411(d9, d12), oca3288e9782.\u0411(d9, d11));
                                float f4 = (float)oca3288e9782.\u0411(oca3288e9782.\u015e(d10, d12), oca3288e9782.\u015e(d10, d11));
                                f2 = f4;
                                f = f3;
                                if (bl2) break block10;
                                if (f2 <= f) break block11;
                                f2 = ocb112cc87f6.\u0193(0x909AB3CF ^ 0x90895B57);
                                f = f3;
                            }
                            if (f2 < f) break block11;
                            vec33 = new Vec3(vec3.xCoord + vec32.xCoord * (double)f3, vec3.yCoord + vec32.yCoord * (double)f3, vec3.zCoord + vec32.zCoord * (double)f3);
                            break block12;
                        }
                        vec33 = null;
                    }
                    if (!false) break block13;
                    if (!bl2) break block14;
                    bl = false;
                    break block15;
                }
                bl = true;
            }
            ocd5cc9ffddf.\u0406 = bl;
        }
        return vec33;
    }

    public static Vec3 \u04f0(float f, float f2) {
        float f3 = (float)((double)f * ocb112cc87f6.\u03a4(0xDC230A72 ^ 0xDC37FD22) / ocb112cc87f6.\u03a4(0xDC230A7A ^ 0xDC37FD22) + ocb112cc87f6.\u03a4(0xDC230A72 ^ 0xDC37FD22));
        float f4 = (float)((double)f2 * ocb112cc87f6.\u03a4(0xDC230A72 ^ 0xDC37FD22) / ocb112cc87f6.\u03a4(0xDC230A7A ^ 0xDC37FD22));
        float f5 = oc497d0cdf29.\u0518(f3);
        float f6 = oc497d0cdf29.\u01ca(f3);
        float f7 = oc497d0cdf29.\u0518(f4);
        float f8 = oc497d0cdf29.\u01ca(f4);
        float f9 = Float.intBitsToFloat(Float.floatToRawIntBits(f7) ^ ocb112cc87f6.\u0288(0xDC230A42 ^ 0xDC37FD22));
        return new Vec3(f6 * f9, f8, f9 * f5);
    }

    public static double \u015c(Vec3 vec3, Vec3 vec32) {
        double d = vec3.xCoord - vec32.xCoord;
        double d2 = vec3.yCoord - vec32.yCoord;
        double d3 = vec3.zCoord - vec32.zCoord;
        return d3 * d3 + (d * d + d2 * d2);
    }

    public static int R(int n) {
        int n2;
        block2: {
            int n3;
            block3: {
                n3 = -n;
                boolean bl = ocd5cc9ffddf.\u0406;
                n2 = n3;
                if (bl) break block2;
                if (n2 >= 0) break block3;
                n2 = n;
                break block2;
            }
            n2 = n3;
        }
        return n2;
    }

    public static long \u02a7(int n, int n2) {
        int n3;
        block6: {
            int n4;
            block4: {
                block5: {
                    boolean bl = ocd5cc9ffddf.\u0406;
                    n4 = n2;
                    if (bl) break block4;
                    if (n4 >= n) break block5;
                    n3 = n - n2;
                    break block6;
                }
                n4 = n2;
            }
            n3 = n4 - n;
        }
        return Integer.toUnsignedLong(n3);
    }
}

