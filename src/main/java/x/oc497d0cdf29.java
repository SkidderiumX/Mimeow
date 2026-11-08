/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.Vec3;
import x.I;
import x.oc01be0c7606;
import x.oc30e402796f;
import x.oc69da1aa7f5;
import x.oca6eae151db;
import x.ocaa841bf6d1;

public class oc497d0cdf29 {
    public static boolean \u03c0;

    private oc497d0cdf29() {
    }

    public static float \u01ca(float f) {
        return ocaa841bf6d1.\u026d(f);
    }

    public static float \u0518(float f) {
        return ocaa841bf6d1.\u018c(f);
    }

    public static double \u0585(double d, double d2) {
        return oc01be0c7606.\u03f5(d, d2);
    }

    public static float \u0127(float f, float f2) {
        return oc01be0c7606.\u04ad(f, f2);
    }

    public static float \u0226(float f, float f2) {
        return oc01be0c7606.\u04ad(f, f2);
    }

    public static double \u053a(double d, double d2) {
        return oc01be0c7606.\u01d8(d, d2);
    }

    public static float \u0416(float f) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f) & (0xC6434EB0 ^ 0xB9BCB14F));
    }

    public static float \u0175(float f, float f2) {
        float f3;
        block4: {
            block5: {
                boolean bl = oca6eae151db.\u0237;
                f3 = f;
                if (bl) break block4;
                if (!(f3 < f2)) break block5;
                f3 = f;
                break block4;
            }
            f3 = f2;
        }
        return f3;
    }

    public static float \u04b0(float f, float f2) {
        float f3;
        block4: {
            block5: {
                boolean bl = oca6eae151db.\u0237;
                f3 = f;
                if (bl) break block4;
                if (!(f3 > f2)) break block5;
                f3 = f;
                break block4;
            }
            f3 = f2;
        }
        return f3;
    }

    public static double \u0187(double d, double d2) {
        double d3;
        block4: {
            block5: {
                boolean bl = oca6eae151db.\u0237;
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

    public static double \u01a0(double d, double d2) {
        double d3;
        block4: {
            block5: {
                boolean bl = oca6eae151db.\u0237;
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

    public static float \u053c(float f, float f2, float f3) {
        float f4;
        block6: {
            float f5;
            block4: {
                block5: {
                    boolean bl = oca6eae151db.\u0237;
                    f5 = f3;
                    if (bl) break block4;
                    if (!(f5 < f)) break block5;
                    f4 = f;
                    break block6;
                }
                f5 = f2;
            }
            f4 = oc497d0cdf29.\u0175(f5, f3);
        }
        return f4;
    }

    public static double \u0268(double d, double d2, double d3) {
        double d4;
        block6: {
            double d5;
            block4: {
                block5: {
                    boolean bl = oca6eae151db.\u0237;
                    d5 = d3;
                    if (bl) break block4;
                    if (!(d5 < d)) break block5;
                    d4 = d;
                    break block6;
                }
                d5 = d2;
            }
            d4 = oc497d0cdf29.\u0187(d5, d3);
        }
        return d4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static float \u0538(float f) {
        float f2;
        block10: {
            float f3;
            block9: {
                float f4;
                block7: {
                    boolean bl;
                    block8: {
                        f3 = I.\u0464(f, 360.0f);
                        bl = oca6eae151db.\u0237;
                        f2 = f3;
                        f4 = 180.0f;
                        if (bl) break block7;
                        if (!(f2 >= f4)) break block8;
                        f3 += -360.0f;
                        if (!bl) break block9;
                    }
                    f2 = f3;
                    if (bl) break block10;
                    f4 = -180.0f;
                }
                if (f2 < f4) {
                    f3 += 360.0f;
                }
            }
            f2 = f3;
        }
        return f2;
    }

    public static float[] \u0282(Vec3 vec3, Vec3 vec32) {
        float[] fArray;
        block4: {
            boolean bl;
            block6: {
                block5: {
                    double d = vec32.xCoord - vec3.xCoord;
                    double d2 = vec32.yCoord - vec3.yCoord;
                    boolean bl2 = oca6eae151db.\u0237;
                    double d3 = vec32.zCoord - vec3.zCoord;
                    double d4 = Math.sqrt(d * d + d3 * d3);
                    float f = (float)(oc497d0cdf29.\u0585(d3, d) * 180.0 / Math.PI + -90.0);
                    float f2 = (float)(oc497d0cdf29.\u0585(d2, d4) * -180.0 / Math.PI);
                    float[] fArray2 = new float[0x56FC12BE ^ 0x56FC12BC];
                    fArray2[0] = f;
                    fArray = fArray2;
                    fArray2[1] = f2;
                    if (!bl2) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return fArray;
    }

    public static Vec3 \u01f6(Vec3 vec3, Vec3 vec32, double d) {
        return new Vec3(d * (vec32.xCoord - vec3.xCoord) + vec3.xCoord, d * (vec32.yCoord - vec3.yCoord) + vec3.yCoord, (vec32.zCoord - vec3.zCoord) * d + vec3.zCoord);
    }

    public static double \u017b(Vec3 vec3, Vec3 vec32) {
        double d = vec3.xCoord - vec32.xCoord;
        double d2 = vec3.yCoord - vec32.yCoord;
        double d3 = vec3.zCoord - vec32.zCoord;
        return Math.sqrt(d3 * d3 + (d * d + d2 * d2));
    }

    public static double[] \u03a1(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        block4: {
            block5: {
                f8 = f2 * 0.98f;
                boolean bl = oca6eae151db.\u0237;
                f7 = f3 * 0.98f;
                f6 = f7 * f7 + f8 * f8;
                f5 = 1.0E-4f;
                if (bl) break block4;
                if (!(f5 > f6)) break block5;
                double[] dArray = new double[0xCECE469D ^ 0xCECE469F];
                dArray[0] = 0.0;
                dArray[1] = 0.0;
                return dArray;
            }
            f5 = f4 * Float.intBitsToFloat(0xF1B1B962 ^ 0xCECE469F);
        }
        float f9 = f5;
        float f10 = oc497d0cdf29.\u04b0(1.0f, (float)Math.sqrt(f6));
        float f11 = (float)((double)f * Math.PI / 180.0);
        float f12 = oc497d0cdf29.\u01ca(f11);
        float f13 = oc497d0cdf29.\u0518(f11);
        double[] dArray = new double[0xCECE469D ^ 0xCECE469F];
        dArray[0] = (f7 *= (f9 /= f10)) * f13 - (f8 *= f9) * f12;
        dArray[1] = f8 * f13 + f7 * f12;
        return dArray;
    }

    public static float \u018a(float f, float f2) {
        return oc30e402796f.\u04e3(f, f2);
    }

    public static int T(int n, long l) {
        int n2 = n + (int)l;
        n2 ^= n2 >>> (0x853D4D7F ^ 0x853D4D6F);
        n2 *= 0x8160D254 ^ 0x853D4D6F;
        n2 ^= n2 >>> (0x853D4D7F ^ 0x853D4D6F);
        return (n2 *= 0x8160D254 ^ 0x853D4D6F) ^ n2 >>> (0x853D4D7F ^ 0x853D4D6F);
    }
}

