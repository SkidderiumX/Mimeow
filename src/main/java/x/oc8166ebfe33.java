/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.Vec3;
import x.oc497d0cdf29;
import x.oc69da1aa7f5;
import x.ocdab58ca6e4;

public class oc8166ebfe33 {
    public static boolean \u0503;

    private oc8166ebfe33() {
    }

    private static double z(double d) {
        return (float)d;
    }

    private static double \u0574(double d, double d2) {
        double d3;
        block4: {
            block5: {
                boolean bl = ocdab58ca6e4.\u02e3;
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

    private static double \u0448(double d, double d2) {
        double d3;
        block4: {
            block5: {
                boolean bl = ocdab58ca6e4.\u02e3;
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

    private static double I(double d, double d2) {
        double d3;
        block6: {
            double d4;
            block4: {
                block5: {
                    boolean bl = ocdab58ca6e4.\u02e3;
                    d4 = d2;
                    if (bl) break block4;
                    if (!Double.isNaN(d4)) break block5;
                    d3 = d;
                    break block6;
                }
                d4 = d;
            }
            d3 = oc8166ebfe33.\u0574(d4, d2);
        }
        return d3;
    }

    private static double \u00ce(double d, double d2) {
        double d3;
        block6: {
            double d4;
            block4: {
                block5: {
                    boolean bl = ocdab58ca6e4.\u02e3;
                    d4 = d2;
                    if (bl) break block4;
                    if (!Double.isNaN(d4)) break block5;
                    d3 = d;
                    break block6;
                }
                d4 = d;
            }
            d3 = oc8166ebfe33.\u0448(d4, d2);
        }
        return d3;
    }

    public static boolean \u0453(double[] dArray, Vec3 vec3, Vec3 vec32) {
        double[] dArray2 = new double[0xB1BC6405 ^ 0xB1BC6406];
        dArray2[0] = vec3.xCoord;
        dArray2[1] = vec3.yCoord;
        dArray2[0xB1BC6404 ^ 0xB1BC6406] = vec3.zCoord;
        double[] dArray3 = new double[0xB1BC6405 ^ 0xB1BC6406];
        dArray3[0] = vec32.xCoord;
        dArray3[1] = vec32.yCoord;
        dArray3[0xB1BC6404 ^ 0xB1BC6406] = vec32.zCoord;
        return oc8166ebfe33.\u018d(dArray, dArray2, dArray3);
    }

    public static boolean \u018d(double[] dArray, double[] dArray2, double[] dArray3) {
        float f;
        block13: {
            boolean bl;
            block15: {
                block14: {
                    boolean bl2;
                    block12: {
                        block11: {
                            float f2;
                            block10: {
                                double d = oc8166ebfe33.z((dArray[0] - dArray2[0]) * (1.0 / dArray3[0]));
                                double d2 = oc8166ebfe33.z((dArray[0x321E2680 ^ 0x321E2683] - dArray2[0]) * (1.0 / dArray3[0]));
                                double d3 = oc8166ebfe33.z(oc8166ebfe33.\u0574(oc8166ebfe33.\u0448(d, 0.0), oc8166ebfe33.\u0448(d2, 0.0)));
                                double d4 = oc8166ebfe33.z(oc8166ebfe33.\u0448(oc8166ebfe33.\u0574(d, Double.POSITIVE_INFINITY), oc8166ebfe33.\u0574(d2, Double.POSITIVE_INFINITY)));
                                double d5 = oc8166ebfe33.z((dArray[1] - dArray2[1]) * (1.0 / dArray3[1]));
                                double d6 = oc8166ebfe33.z((dArray[0x321E2687 ^ 0x321E2683] - dArray2[1]) * (1.0 / dArray3[1]));
                                double d7 = oc8166ebfe33.z(oc8166ebfe33.\u0574(oc8166ebfe33.\u0448(d5, d3), oc8166ebfe33.\u0448(d6, d3)));
                                double d8 = oc8166ebfe33.z(oc8166ebfe33.\u0448(oc8166ebfe33.\u0574(d5, d4), oc8166ebfe33.\u0574(d6, d4)));
                                double d9 = oc8166ebfe33.z((dArray[0x321E2681 ^ 0x321E2683] - dArray2[0x321E2681 ^ 0x321E2683]) * (1.0 / dArray3[0x321E2681 ^ 0x321E2683]));
                                double d10 = oc8166ebfe33.z((dArray[0x321E2686 ^ 0x321E2683] - dArray2[0x321E2681 ^ 0x321E2683]) * (1.0 / dArray3[0x321E2681 ^ 0x321E2683]));
                                bl2 = ocdab58ca6e4.\u02e3;
                                float f3 = (float)oc8166ebfe33.I(oc8166ebfe33.\u00ce(d7, d10), oc8166ebfe33.\u00ce(d7, d9));
                                float f4 = (float)oc8166ebfe33.\u00ce(oc8166ebfe33.I(d8, d10), oc8166ebfe33.I(d8, d9));
                                f2 = f3;
                                if (bl2) break block10;
                                if (!(f2 < f4)) break block11;
                                f2 = f3;
                            }
                            float f5 = f2 - 1.0f;
                            f = f5 == 0.0f ? 0 : (f5 < 0.0f ? -1 : 1);
                            if (bl2) break block12;
                            if (f > 0) break block11;
                            f = 1.0f;
                            break block12;
                        }
                        f = 0.0f;
                    }
                    if (!bl2) break block13;
                    if (!false) break block14;
                    bl = false;
                    break block15;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return (boolean)f;
    }

    public static Vec3 \u0254(double[] dArray, Vec3 vec3) {
        return new Vec3(oc497d0cdf29.\u0268(dArray[0], dArray[0xDA189ECB ^ 0xDA189EC8], vec3.xCoord), oc497d0cdf29.\u0268(dArray[1], dArray[0xDA189ECC ^ 0xDA189EC8], vec3.yCoord), oc497d0cdf29.\u0268(dArray[0xDA189ECA ^ 0xDA189EC8], dArray[0xDA189ECD ^ 0xDA189EC8], vec3.zCoord));
    }

    public static Vec3 \u0401(float f, float f2, float f3, float f4) {
        double[] dArray = oc497d0cdf29.\u03a1(f, f2, f3, f4);
        return new Vec3(dArray[0], 0.0, dArray[1]);
    }

    public static Vec3 Q(Vec3 vec3, double d) {
        return new Vec3(vec3.xCoord * d, vec3.yCoord * d, vec3.zCoord * d);
    }
}

