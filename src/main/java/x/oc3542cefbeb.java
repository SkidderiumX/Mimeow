/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;

public enum oc3542cefbeb {
    \u00d5(null, null),
    \u0443(new Color(0xCC670F6A ^ 0xCC670F95, 0xCC670F5D ^ 0xCC670F95, 0xCC670F5D ^ 0xCC670F95), new Color(0xCC670F66 ^ 0xCC670F95, 0xCC670FAF ^ 0xCC670F95, 0xCC670FFF ^ 0xCC670F95)),
    \u019f(new Color(0xCC670FF6 ^ 0xCC670F95, 0xCC670F6C ^ 0xCC670F95, 0xCC670F6A ^ 0xCC670F95), new Color(0xCC670F6A ^ 0xCC670F95, 0xCC670FFD ^ 0xCC670F95, 0xCC670F59 ^ 0xCC670F95)),
    \u01a2(new Color(0xCC670F72 ^ 0xCC670F95, 0xCC670FB2 ^ 0xCC670F95, 0xCC670F8D ^ 0xCC670F95), new Color(0xCC670F60 ^ 0xCC670F95, 0xCC670F38 ^ 0xCC670F95, 0xCC670FA4 ^ 0xCC670F95)),
    \u03bd(new Color(0xCC670F42 ^ 0xCC670F95, 0xCC670F33 ^ 0xCC670F95, 0xCC670F72 ^ 0xCC670F95), new Color(0xCC670F46 ^ 0xCC670F95, 0xCC670FCF ^ 0xCC670F95, 0xCC670F7D ^ 0xCC670F95)),
    \u023d(new Color(0xCC670F6A ^ 0xCC670F95, 0xCC670F42 ^ 0xCC670F95, 0), new Color(0xCC670F65 ^ 0xCC670F95, 0xCC670F0A ^ 0xCC670F95, 0)),
    \u01f6(new Color(0xCC670F65 ^ 0xCC670F95, 0xCC670F65 ^ 0xCC670F95, 0xCC670F65 ^ 0xCC670F95), new Color(0xCC670FFB ^ 0xCC670F95, 0xCC670FFB ^ 0xCC670F95, 0xCC670FFB ^ 0xCC670F95)),
    \u047c(new Color(0xCC670FE8 ^ 0xCC670F95, 0xCC670F59 ^ 0xCC670F95, 0xCC670F64 ^ 0xCC670F95), new Color(0xCC670F8B ^ 0xCC670F95, 0xCC670FD2 ^ 0xCC670F95, 0xCC670F3F ^ 0xCC670F95)),
    \u0252(new Color(0xCC670F35 ^ 0xCC670F95, 0xCC670F73 ^ 0xCC670F95, 0xCC670F74 ^ 0xCC670F95), new Color(0xCC670F9A ^ 0xCC670F95, 0xCC670F2B ^ 0xCC670F95, 0xCC670F49 ^ 0xCC670F95)),
    \u0187(new Color(0xCC670F84 ^ 0xCC670F95, 0xCC670F55 ^ 0xCC670F95, 0xCC670FB8 ^ 0xCC670F95), new Color(0xCC670F5C ^ 0xCC670F95, 0xCC670F7F ^ 0xCC670F95, 0xCC670F53 ^ 0xCC670F95));
    private static final oc3542cefbeb[] $VALUES_REF;
    static {
        $VALUES_REF = oc3542cefbeb.\u01cd();
    }










    private final Color \u01de;
    private final Color \u03e9;
    public static Color[] \u0197;
    public static Color[] \u039d;
    public static String[] \u048e;
    public static boolean \u04d5;



    private oc3542cefbeb(Color color, Color color2) {
        this.\u01de = color;
        this.\u03e9 = color2;
    }

    public static int \u053e(int n, double d) {
        int n2;
        block10: {
            block11: {
                int n3;
                block8: {
                    block9: {
                        n3 = oc75d51ec7eb.\u03e9;
                        n2 = n;
                        if (n3 != 0) break block8;
                        if (n2 <= 0) break block9;
                        return oc3542cefbeb.\u0242(oc3542cefbeb.values()[n].\u01de, oc3542cefbeb.values()[n].\u03e9, (Math.sin((double)System.currentTimeMillis() / 1.0E8 * 0.5 * 400000.0 + d * 0.5) + 1.0) * 0.5).getRGB();
                    }
                    n2 = n;
                }
                if (n3 != 0) break block10;
                if (n2 != 0) break block11;
                return oc3542cefbeb.\u03e1(0xC021F105A19F1C31L ^ 0xC021F105A19F1C33L, (long)d);
            }
            n2 = -1;
        }
        return n2;
    }

    public static int \u03e1(long l, long l2) {
        double d = 0.5 * (double)l2;
        long l3 = System.currentTimeMillis() + (long)d;
        float f = (float)(l3 % ((0x839535381E8DA7EDL ^ 0x839535381E8D9D75L) / l)) / (15000.0f / (float)l);
        return Color.getHSBColor(f, 1.0f, 1.0f).getRGB();
    }

    public static int \u0189(Color color, Color color2, double d) {
        return oc3542cefbeb.\u0242(color, color2, (Math.sin((double)System.currentTimeMillis() / 1.0E8 * 0.5 * 400000.0 + d * (double)0.55f) + 1.0) * 0.5).getRGB();
    }

    public static Color \u0242(Color color, Color color2, double d) {
        double d2 = 1.0 - d;
        return new Color((int)((double)color.getRed() * d + (double)color2.getRed() * d2), (int)((double)color.getGreen() * d + (double)color2.getGreen() * d2), (int)((double)color.getBlue() * d + (double)color2.getBlue() * d2));
    }

    public static int[] \u01be(int n) {
        int n2;
        block20: {
            block19: {
                block23: {
                    Color color;
                    Color color2;
                    Color color3;
                    block22: {
                        int n3;
                        oc3542cefbeb[] oc3542cefbebArray;
                        int n4;
                        oc3542cefbeb[] oc3542cefbebArray2;
                        block21: {
                            oc3542cefbebArray2 = oc3542cefbeb.values();
                            n4 = oc75d51ec7eb.\u03e9;
                            if (oc3542cefbebArray2 == null) break block19;
                            n2 = n;
                            if (n4 != 0) break block20;
                            if (n2 < 0) break block19;
                            n2 = n;
                            if (n4 != 0) break block20;
                            if (n2 >= oc3542cefbebArray2.length) break block19;
                            oc3542cefbebArray = oc3542cefbebArray2;
                            n3 = n;
                            if (n4 != 0) break block21;
                            if (oc3542cefbebArray[n3] == null) break block19;
                            oc3542cefbebArray = oc3542cefbebArray2;
                            n3 = n;
                        }
                        color3 = oc3542cefbebArray[n3].\u01de;
                        color2 = oc3542cefbebArray2[n].\u03e9;
                        color = color3;
                        if (n4 != 0) break block22;
                        if (color == null) break block23;
                        color = color2;
                    }
                    if (color != null) {
                        int[] nArray = new int[0xCBB28733 ^ 0xCBB28731];
                        nArray[0] = color3.getRGB();
                        nArray[1] = color2.getRGB();
                        return nArray;
                    }
                }
                int[] nArray = new int[0xCBB28733 ^ 0xCBB28731];
                nArray[0] = oc7ab2161b9f.\u01be(0xEB0D72499F2025FDL ^ 0xEB0D72499F2025FFL, 0L);
                nArray[1] = oc7ab2161b9f.\u01be(0xEB0D72499F2025FDL ^ 0xEB0D72499F2025FFL, 0L);
                return nArray;
            }
            n2 = 0xCBB28733 ^ 0xCBB28731;
        }
        int[] nArray = new int[n2];
        nArray[0] = 0;
        nArray[1] = 0;
        return nArray;
    }

    private static /* synthetic */ oc3542cefbeb[] \u01cd() {
        oc3542cefbeb[] oc3542cefbebArray = new oc3542cefbeb[0xA7F7EB1F ^ 0xA7F7EB15];
        oc3542cefbebArray[0] = \u00d5;
        oc3542cefbebArray[1] = \u0443;
        oc3542cefbebArray[0xA7F7EB17 ^ 0xA7F7EB15] = \u019f;
        oc3542cefbebArray[0xA7F7EB16 ^ 0xA7F7EB15] = \u01a2;
        oc3542cefbebArray[0xA7F7EB11 ^ 0xA7F7EB15] = \u03bd;
        oc3542cefbebArray[0xA7F7EB10 ^ 0xA7F7EB15] = \u023d;
        oc3542cefbebArray[0xA7F7EB13 ^ 0xA7F7EB15] = \u01f6;
        oc3542cefbebArray[0xA7F7EB12 ^ 0xA7F7EB15] = \u047c;
        oc3542cefbebArray[0xA7F7EB1D ^ 0xA7F7EB15] = \u0252;
        oc3542cefbebArray[0xA7F7EB1C ^ 0xA7F7EB15] = \u0187;
        return oc3542cefbebArray;
    }

    static {
        Color[] colorArray = new Color[0xCC670F97 ^ 0xCC670F95];
        colorArray[0] = new Color(0xCC670FCA ^ 0xCC670F95, 0xCC670F7E ^ 0xCC670F95, 0xCC670F6A ^ 0xCC670F95);
        colorArray[1] = new Color(0xCC670FD1 ^ 0xCC670F95, 0xCC670FF3 ^ 0xCC670F95, 0xCC670F6F ^ 0xCC670F95);
        \u0197 = colorArray;
        Color[] colorArray2 = new Color[0xCC670F97 ^ 0xCC670F95];
        colorArray2[0] = new Color(0xCC670F60 ^ 0xCC670F95, 0xCC670FB4 ^ 0xCC670F95, 0xCC670FB4 ^ 0xCC670F95);
        colorArray2[1] = new Color(0xCC670F70 ^ 0xCC670F95, 0xCC670F80 ^ 0xCC670F95, 0xCC670FF7 ^ 0xCC670F95);
        \u039d = colorArray2;
        String[] stringArray = new String[0xCC670F9F ^ 0xCC670F95];
        stringArray[0] = "Rainbow";
        stringArray[1] = "Cherry";
        stringArray[0xCC670F97 ^ 0xCC670F95] = "Cotton candy";
        stringArray[0xCC670F96 ^ 0xCC670F95] = "Flare";
        stringArray[0xCC670F91 ^ 0xCC670F95] = "Flower";
        stringArray[0xCC670F90 ^ 0xCC670F95] = "Gold";
        stringArray[0xCC670F93 ^ 0xCC670F95] = "Grayscale";
        stringArray[0xCC670F92 ^ 0xCC670F95] = "Royal";
        stringArray[0xCC670F9D ^ 0xCC670F95] = "Sky";
        stringArray[0xCC670F9C ^ 0xCC670F95] = "Vine";
        \u048e = stringArray;
    }
}

