/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import net.minecraft.util.MathHelper;
import net.optifine.util.MathUtils;

public class MathUtilsTest {
    public static void main(String[] stringArray) throws Exception {
        OPER[] oPERArray = OPER.values();
        for (int i = 0; i < oPERArray.length; ++i) {
            OPER oPER = oPERArray[i];
            MathUtilsTest.dbg("******** " + String.valueOf((Object)oPER) + " ***********");
            MathUtilsTest.test(oPER, false);
        }
    }

    private static void test(OPER oPER, boolean bl) {
        double d;
        double d2;
        MathHelper.fastMath = bl;
        switch (oPER) {
            case SIN: 
            case COS: {
                d2 = -MathHelper.PI;
                d = MathHelper.PI;
                break;
            }
            case ASIN: 
            case ACOS: {
                d2 = -1.0;
                d = 1.0;
                break;
            }
            default: {
                return;
            }
        }
        int n = 10;
        for (int i = 0; i <= n; ++i) {
            float f;
            float f2;
            double d3 = d2 + (double)i * (d - d2) / (double)n;
            switch (oPER) {
                case SIN: {
                    f2 = (float)Math.sin(d3);
                    f = MathHelper.sin((float)d3);
                    break;
                }
                case COS: {
                    f2 = (float)Math.cos(d3);
                    f = MathHelper.cos((float)d3);
                    break;
                }
                case ASIN: {
                    f2 = (float)Math.asin(d3);
                    f = MathUtils.asin((float)d3);
                    break;
                }
                case ACOS: {
                    f2 = (float)Math.acos(d3);
                    f = MathUtils.acos((float)d3);
                    break;
                }
                default: {
                    return;
                }
            }
            MathUtilsTest.dbg(String.format("%.2f, Math: %f, Helper: %f, diff: %f", d3, Float.valueOf(f2), Float.valueOf(f), Float.valueOf(Math.abs(f2 - f))));
        }
    }

    public static void dbg(String string) {
        System.out.println(string);
    }

    private static enum OPER {
        SIN,
        COS,
        ASIN,
        ACOS;

    }
}

