/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import x.oc1b46ea259e;
import x.oc595c51c58f;
import x.oc992493b0d3;
import x.ocbd4917c4b1;

public class W {
    private static final Logger \u01f1 = LogManager.getLogger(W.class);
    private static final Map<String, oc595c51c58f> \u03e9 = new HashMap<String, oc595c51c58f>();
    private static final Set<String> \u0535 = new HashSet<String>();
    public static int \u0157;

    public static void s(float f, float f2, float f3, float f4, float f5, Color color) {
        W.\u0213(f, f2, f3, f4, f5, false, color);
    }

    public static void \u0526(float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        W.\u0292(f, f2, f3, f4, f5, color, color, color2, color2);
    }

    public static void \u027e(float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        W.\u0292(f, f2, f3, f4, f5, color2, color, color2, color);
    }

    public static void \u0428(float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        Color color3 = ocbd4917c4b1.\u0421(color, color2, 0.5f);
        W.\u0292(f, f2, f3, f4, f5, color3, color, color2, color3);
    }

    public static void \u0189(float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        Color color3 = ocbd4917c4b1.\u0421(color2, color, 0.5f);
        W.\u0292(f, f2, f3, f4, f5, color, color3, color3, color2);
    }

    public static void \u02e0(float f, float f2, float f3, float f4, float f5, int n) {
        W.\u0413(f, f2, f3, f4, f5, false, n);
    }

    public static void \u0413(float f, float f2, float f3, float f4, float f5, boolean bl, int n) {
        boolean bl2;
        int[] nArray;
        String string;
        oc595c51c58f oc595c51c58f2;
        oc595c51c58f oc595c51c58f3;
        block8: {
            block9: {
                boolean bl3;
                block6: {
                    block7: {
                        bl3 = oc1b46ea259e.\u01e7;
                        oc595c51c58f3 = W.\u01a9("roundedRect");
                        if (bl3) break block6;
                        if (oc595c51c58f3 != null) break block7;
                        ocbd4917c4b1.\u0109(f, f2, f + f3, f2 + f4, n);
                        return;
                    }
                    ocbd4917c4b1.\u0502();
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(0xDBC586EA ^ 0xDBC585E8, 0xDBC586EB ^ 0xDBC585E8);
                    GL11.glBlendFunc(0xDBC586EA ^ 0xDBC585E8, 0xDBC586EB ^ 0xDBC585E8);
                    ocbd4917c4b1.\u0412(0.0f);
                    oc595c51c58f3.\u01f5();
                    W.\u03de(f, f2, f3, f4, f5, oc595c51c58f3);
                }
                oc595c51c58f2 = oc595c51c58f3;
                string = "blur";
                int[] nArray2 = new int[1];
                int[] nArray3 = nArray2;
                nArray = nArray2;
                int n2 = 0;
                bl2 = bl;
                if (bl3) break block8;
                if (!bl2) break block9;
                bl2 = true;
                break block8;
            }
            bl2 = false;
        }
        nArray3[n2] = bl2 ? 1 : 0;
        oc595c51c58f2.\u048f(string, nArray);
        float[] fArray = new float[0xDBC585EC ^ 0xDBC585E8];
        fArray[0] = W.\u053a(n);
        fArray[1] = W.\u0439(n);
        fArray[0xDBC585EA ^ 0xDBC585E8] = W.\u0553(n);
        fArray[0xDBC585EB ^ 0xDBC585E8] = W.\u00e9(n);
        oc595c51c58f3.\u03c8("color", fArray);
        oc595c51c58f.\u0562(f - 1.0f, f2 - 1.0f, f3 + 2.0f, f4 + 2.0f);
        oc595c51c58f3.\u0287();
        GlStateManager.disableBlend();
    }

    public static void \u0292(float f, float f2, float f3, float f4, float f5, Color color, Color color2, Color color3, Color color4) {
        block4: {
            oc595c51c58f oc595c51c58f2;
            block5: {
                boolean bl = oc1b46ea259e.\u01e7;
                oc595c51c58f2 = W.\u01a9("roundedRectGradient");
                if (bl) break block4;
                if (oc595c51c58f2 != null) break block5;
                Color[] colorArray = new Color[0x1F40C44D ^ 0x1F40C449];
                colorArray[0] = color;
                colorArray[1] = color2;
                colorArray[0x1F40C44B ^ 0x1F40C449] = color3;
                colorArray[0x1F40C44A ^ 0x1F40C449] = color4;
                ocbd4917c4b1.\u0109(f, f2, f + f3, f2 + f4, W.\u0416(colorArray));
                return;
            }
            ocbd4917c4b1.\u0412(0.0f);
            ocbd4917c4b1.\u0502();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(0x1F40C74B ^ 0x1F40C449, 0x1F40C74A ^ 0x1F40C449);
            oc595c51c58f2.\u01f5();
            W.\u03de(f, f2, f3, f4, f5, oc595c51c58f2);
            float[] fArray = new float[0x1F40C44D ^ 0x1F40C449];
            fArray[0] = (float)color2.getRed() / 255.0f;
            fArray[1] = (float)color2.getGreen() / 255.0f;
            fArray[0x1F40C44B ^ 0x1F40C449] = (float)color2.getBlue() / 255.0f;
            fArray[0x1F40C44A ^ 0x1F40C449] = (float)color2.getAlpha() / 255.0f;
            oc595c51c58f2.\u03c8("color1", fArray);
            float[] fArray2 = new float[0x1F40C44D ^ 0x1F40C449];
            fArray2[0] = (float)color.getRed() / 255.0f;
            fArray2[1] = (float)color.getGreen() / 255.0f;
            fArray2[0x1F40C44B ^ 0x1F40C449] = (float)color.getBlue() / 255.0f;
            fArray2[0x1F40C44A ^ 0x1F40C449] = (float)color.getAlpha() / 255.0f;
            oc595c51c58f2.\u03c8("color2", fArray2);
            float[] fArray3 = new float[0x1F40C44D ^ 0x1F40C449];
            fArray3[0] = (float)color4.getRed() / 255.0f;
            fArray3[1] = (float)color4.getGreen() / 255.0f;
            fArray3[0x1F40C44B ^ 0x1F40C449] = (float)color4.getBlue() / 255.0f;
            fArray3[0x1F40C44A ^ 0x1F40C449] = (float)color4.getAlpha() / 255.0f;
            oc595c51c58f2.\u03c8("color3", fArray3);
            float[] fArray4 = new float[0x1F40C44D ^ 0x1F40C449];
            fArray4[0] = (float)color3.getRed() / 255.0f;
            fArray4[1] = (float)color3.getGreen() / 255.0f;
            fArray4[0x1F40C44B ^ 0x1F40C449] = (float)color3.getBlue() / 255.0f;
            fArray4[0x1F40C44A ^ 0x1F40C449] = (float)color3.getAlpha() / 255.0f;
            oc595c51c58f2.\u03c8("color4", fArray4);
            oc595c51c58f.\u0562(f - 1.0f, f2 - 1.0f, f3 + 2.0f, f4 + 2.0f);
            oc595c51c58f2.\u0287();
            GlStateManager.disableBlend();
        }
    }

    public static void P(float f, float f2, float f3, float f4, float f5, int n, int n2, int n3, int n4) {
        block4: {
            oc595c51c58f oc595c51c58f2;
            block5: {
                boolean bl = oc1b46ea259e.\u01e7;
                oc595c51c58f2 = W.\u01a9("roundedRectGradient");
                if (bl) break block4;
                if (oc595c51c58f2 != null) break block5;
                int[] nArray = new int[0x1954478A ^ 0x1954478E];
                nArray[0] = n;
                nArray[1] = n2;
                nArray[0x1954478C ^ 0x1954478E] = n3;
                nArray[0x1954478D ^ 0x1954478E] = n4;
                ocbd4917c4b1.\u0109(f, f2, f + f3, f2 + f4, W.\u0119(nArray));
                return;
            }
            ocbd4917c4b1.\u0412(0.0f);
            ocbd4917c4b1.\u0502();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(0x1954448C ^ 0x1954478E, 0x1954448D ^ 0x1954478E);
            oc595c51c58f2.\u01f5();
            W.\u03de(f, f2, f3, f4, f5, oc595c51c58f2);
            float[] fArray = new float[0x1954478A ^ 0x1954478E];
            fArray[0] = W.\u053a(n2);
            fArray[1] = W.\u0439(n2);
            fArray[0x1954478C ^ 0x1954478E] = W.\u0553(n2);
            fArray[0x1954478D ^ 0x1954478E] = W.\u00e9(n2);
            oc595c51c58f2.\u03c8("color1", fArray);
            float[] fArray2 = new float[0x1954478A ^ 0x1954478E];
            fArray2[0] = W.\u053a(n);
            fArray2[1] = W.\u0439(n);
            fArray2[0x1954478C ^ 0x1954478E] = W.\u0553(n);
            fArray2[0x1954478D ^ 0x1954478E] = W.\u00e9(n);
            oc595c51c58f2.\u03c8("color2", fArray2);
            float[] fArray3 = new float[0x1954478A ^ 0x1954478E];
            fArray3[0] = W.\u053a(n4);
            fArray3[1] = W.\u0439(n4);
            fArray3[0x1954478C ^ 0x1954478E] = W.\u0553(n4);
            fArray3[0x1954478D ^ 0x1954478E] = W.\u00e9(n4);
            oc595c51c58f2.\u03c8("color3", fArray3);
            float[] fArray4 = new float[0x1954478A ^ 0x1954478E];
            fArray4[0] = W.\u053a(n3);
            fArray4[1] = W.\u0439(n3);
            fArray4[0x1954478C ^ 0x1954478E] = W.\u0553(n3);
            fArray4[0x1954478D ^ 0x1954478E] = W.\u00e9(n3);
            oc595c51c58f2.\u03c8("color4", fArray4);
            oc595c51c58f.\u0562(f - 1.0f, f2 - 1.0f, f3 + 2.0f, f4 + 2.0f);
            oc595c51c58f2.\u0287();
            GlStateManager.disableBlend();
        }
    }

    public static void \u0213(float f, float f2, float f3, float f4, float f5, boolean bl, Color color) {
        boolean bl2;
        int[] nArray;
        String string;
        oc595c51c58f oc595c51c58f2;
        oc595c51c58f oc595c51c58f3;
        block8: {
            block9: {
                boolean bl3;
                block6: {
                    block7: {
                        bl3 = oc1b46ea259e.\u01e7;
                        oc595c51c58f3 = W.\u01a9("roundedRect");
                        if (bl3) break block6;
                        if (oc595c51c58f3 != null) break block7;
                        ocbd4917c4b1.\u0109(f, f2, f + f3, f2 + f4, color.getRGB());
                        return;
                    }
                    ocbd4917c4b1.\u0502();
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(0xD0BC2834 ^ 0xD0BC2B36, 0xD0BC2835 ^ 0xD0BC2B36);
                    GL11.glBlendFunc(0xD0BC2834 ^ 0xD0BC2B36, 0xD0BC2835 ^ 0xD0BC2B36);
                    ocbd4917c4b1.\u0412(0.0f);
                    oc595c51c58f3.\u01f5();
                    W.\u03de(f, f2, f3, f4, f5, oc595c51c58f3);
                }
                oc595c51c58f2 = oc595c51c58f3;
                string = "blur";
                int[] nArray2 = new int[1];
                int[] nArray3 = nArray2;
                nArray = nArray2;
                int n = 0;
                bl2 = bl;
                if (bl3) break block8;
                if (!bl2) break block9;
                bl2 = true;
                break block8;
            }
            bl2 = false;
        }
        nArray3[n] = bl2 ? 1 : 0;
        oc595c51c58f2.\u048f(string, nArray);
        float[] fArray = new float[0xD0BC2B32 ^ 0xD0BC2B36];
        fArray[0] = (float)color.getRed() / 255.0f;
        fArray[1] = (float)color.getGreen() / 255.0f;
        fArray[0xD0BC2B34 ^ 0xD0BC2B36] = (float)color.getBlue() / 255.0f;
        fArray[0xD0BC2B35 ^ 0xD0BC2B36] = (float)color.getAlpha() / 255.0f;
        oc595c51c58f3.\u03c8("color", fArray);
        oc595c51c58f.\u0562(f - 1.0f, f2 - 1.0f, f3 + 2.0f, f4 + 2.0f);
        oc595c51c58f3.\u0287();
        GlStateManager.disableBlend();
    }

    public static void \u03ff(float f, float f2, float f3, float f4, float f5, float f6, Color color, Color color2) {
        block8: {
            boolean bl;
            block10: {
                block9: {
                    oc595c51c58f oc595c51c58f2;
                    boolean bl2;
                    block6: {
                        block7: {
                            bl2 = oc1b46ea259e.\u01e7;
                            oc595c51c58f2 = W.\u01a9("roundRectOutline");
                            if (bl2) break block6;
                            if (oc595c51c58f2 != null) break block7;
                            float f7 = Math.max(1.0f, f6);
                            ocbd4917c4b1.\u0109(f - f7, f2 - f7, f + f3 + f7, f2 + f4 + f7, color2.getRGB());
                            ocbd4917c4b1.\u0109(f, f2, f + f3, f2 + f4, color.getRGB());
                            return;
                        }
                        ocbd4917c4b1.\u0502();
                        GlStateManager.enableBlend();
                        GlStateManager.blendFunc(0xE43E1755 ^ 0xE43E1457, 0xE43E1754 ^ 0xE43E1457);
                        GL11.glBlendFunc(0xE43E1755 ^ 0xE43E1457, 0xE43E1754 ^ 0xE43E1457);
                        ocbd4917c4b1.\u0412(0.0f);
                        oc595c51c58f2.\u01f5();
                    }
                    ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
                    W.\u03de(f, f2, f3, f4, f5, oc595c51c58f2);
                    oc595c51c58f2.\u03c8("outlineThickness", f6 * (float)scaledResolution.getScaleFactor());
                    float[] fArray = new float[0xE43E1453 ^ 0xE43E1457];
                    fArray[0] = (float)color.getRed() / 255.0f;
                    fArray[1] = (float)color.getGreen() / 255.0f;
                    fArray[0xE43E1455 ^ 0xE43E1457] = (float)color.getBlue() / 255.0f;
                    fArray[0xE43E1454 ^ 0xE43E1457] = (float)color.getAlpha() / 255.0f;
                    oc595c51c58f2.\u03c8("color", fArray);
                    float[] fArray2 = new float[0xE43E1453 ^ 0xE43E1457];
                    fArray2[0] = (float)color2.getRed() / 255.0f;
                    fArray2[1] = (float)color2.getGreen() / 255.0f;
                    fArray2[0xE43E1455 ^ 0xE43E1457] = (float)color2.getBlue() / 255.0f;
                    fArray2[0xE43E1454 ^ 0xE43E1457] = (float)color2.getAlpha() / 255.0f;
                    oc595c51c58f2.\u03c8("outlineColor", fArray2);
                    oc595c51c58f.\u0562(f - (2.0f + f6), f2 - (2.0f + f6), f3 + (4.0f + f6 * 2.0f), f4 + (4.0f + f6 * 2.0f));
                    oc595c51c58f2.\u0287();
                    GlStateManager.disableBlend();
                    if (!false) break block8;
                    if (!bl2) break block9;
                    bl = false;
                    break block10;
                }
                bl = true;
            }
            oc1b46ea259e.\u01e7 = bl;
        }
    }

    public static void \u0521(float f, float f2, float f3, float f4, float f5, float f6) {
        block4: {
            oc595c51c58f oc595c51c58f2;
            block5: {
                boolean bl = oc1b46ea259e.\u01e7;
                oc595c51c58f2 = W.\u01a9("roundRectTexture");
                if (bl) break block4;
                if (oc595c51c58f2 != null) break block5;
                GlStateManager.enableBlend();
                GlStateManager.color(1.0f, 1.0f, 1.0f, f6);
                oc595c51c58f.\u0562(f, f2, f3, f4);
                ocbd4917c4b1.\u0502();
                GlStateManager.disableBlend();
                return;
            }
            ocbd4917c4b1.\u0502();
            ocbd4917c4b1.\u0412(0.0f);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(0xB5BD32D9 ^ 0xB5BD31DB, 0xB5BD32D8 ^ 0xB5BD31DB);
            oc595c51c58f2.\u01f5();
            oc595c51c58f2.\u048f("textureIn", 0);
            W.\u03de(f, f2, f3, f4, f5, oc595c51c58f2);
            oc595c51c58f2.\u03c8("alpha", f6);
            oc595c51c58f.\u0562(f - 1.0f, f2 - 1.0f, f3 + 2.0f, f4 + 2.0f);
            oc595c51c58f2.\u0287();
            GlStateManager.disableBlend();
        }
    }

    private static void \u03de(float f, float f2, float f3, float f4, float f5, oc595c51c58f oc595c51c58f2) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        float[] fArray = new float[0x87810CE3 ^ 0x87810CE1];
        fArray[0] = f * (float)scaledResolution.getScaleFactor();
        fArray[1] = (float)Minecraft.getMinecraft().displayHeight - f4 * (float)scaledResolution.getScaleFactor() - f2 * (float)scaledResolution.getScaleFactor();
        oc595c51c58f2.\u03c8("location", fArray);
        float[] fArray2 = new float[0x87810CE3 ^ 0x87810CE1];
        fArray2[0] = f3 * (float)scaledResolution.getScaleFactor();
        fArray2[1] = f4 * (float)scaledResolution.getScaleFactor();
        oc595c51c58f2.\u03c8("rectSize", fArray2);
        oc595c51c58f2.\u03c8("radius", f5 * (float)scaledResolution.getScaleFactor());
    }

    public static void b(float f, float f2, float f3, float f4, float f5, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        float f6;
        float[] fArray;
        String string;
        oc595c51c58f oc595c51c58f2;
        block16: {
            block17: {
                oc595c51c58f oc595c51c58f3;
                boolean bl5;
                block14: {
                    block15: {
                        bl5 = oc1b46ea259e.\u01e7;
                        oc595c51c58f3 = W.\u01a9("roundedRectRise");
                        if (bl5) break block14;
                        if (oc595c51c58f3 != null) break block15;
                        ocbd4917c4b1.\u0109(f, f2, f + f3, f2 + f4, n);
                        return;
                    }
                    GL11.glPushMatrix();
                    GlStateManager.pushAttrib();
                }
                int n2 = oc595c51c58f3.\u018c;
                GL20.glUseProgram(n2);
                float[] fArray2 = new float[0x4CB254C3 ^ 0x4CB254C1];
                fArray2[0] = f3;
                fArray2[1] = f4;
                oc595c51c58f3.\u03c8("u_size", fArray2);
                oc595c51c58f2 = oc595c51c58f3;
                string = "u_radius";
                float[] fArray3 = new float[1];
                float[] fArray4 = fArray3;
                fArray = fArray3;
                int n3 = 0;
                f6 = f5;
                if (bl5) break block16;
                fArray4[n3] = f6;
                oc595c51c58f2.\u03c8(string, fArray);
                float[] fArray5 = new float[0x4CB254C5 ^ 0x4CB254C1];
                fArray5[0] = W.\u053a(n);
                fArray5[1] = W.\u0439(n);
                fArray5[0x4CB254C3 ^ 0x4CB254C1] = W.\u0553(n);
                fArray5[0x4CB254C2 ^ 0x4CB254C1] = W.\u00e9(n);
                oc595c51c58f3.\u03c8("u_color", fArray5);
                oc595c51c58f2 = oc595c51c58f3;
                string = "u_edges";
                float[] fArray6 = new float[0x4CB254C5 ^ 0x4CB254C1];
                fArray4 = fArray6;
                fArray = fArray6;
                n3 = 0;
                if (!bl) break block17;
                f6 = 1.0f;
                break block16;
            }
            f6 = 0.0f;
        }
        fArray4[n3] = f6;
        float[] fArray7 = fArray;
        float[] fArray8 = fArray;
        int n4 = 1;
        float f7 = bl2 ? 1.0f : 0.0f;
        fArray7[n4] = f7;
        float[] fArray9 = fArray8;
        float[] fArray10 = fArray8;
        int n5 = 0x4CB254C3 ^ 0x4CB254C1;
        float f8 = bl3 ? 1.0f : 0.0f;
        fArray9[n5] = f8;
        float[] fArray11 = fArray10;
        float[] fArray12 = fArray10;
        int n6 = 0x4CB254C2 ^ 0x4CB254C1;
        float f9 = bl4 ? 1.0f : 0.0f;
        fArray11[n6] = f9;
        oc595c51c58f2.\u03c8(string, fArray12);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(0x4CB257C3 ^ 0x4CB254C1, 0x4CB257C2 ^ 0x4CB254C1);
        oc595c51c58f.\u0562(f, f2, f3, f4);
        GlStateManager.disableBlend();
        GL20.glUseProgram(0);
        GlStateManager.popAttrib();
        GL11.glPopMatrix();
    }

    public static void \u0137(double d, double d2, double d3, double d4, double d5, int n) {
        W.b((float)d, (float)d2, (float)d3, (float)d4, (float)d5, n, true, true, true, true);
    }

    private static float \u053a(int n) {
        return (float)(n >> (0x37F6CF2F ^ 0x37F6CF3F) & (0x37F6CFC0 ^ 0x37F6CF3F)) / 255.0f;
    }

    private static float \u0439(int n) {
        return (float)(n >> (0xBC4997BC ^ 0xBC4997B4) & (0xBC49974B ^ 0xBC4997B4)) / 255.0f;
    }

    private static float \u0553(int n) {
        return (float)(n & (0x8B73827F ^ 0x8B738280)) / 255.0f;
    }

    private static float \u00e9(int n) {
        return (float)(n >> (0xF313C631 ^ 0xF313C629) & (0xF313C6D6 ^ 0xF313C629)) / 255.0f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static synchronized oc595c51c58f \u01a9(String string) {
        Object object;
        oc595c51c58f oc595c51c58f2;
        block12: {
            oc595c51c58f oc595c51c58f3;
            block11: {
                boolean bl = oc1b46ea259e.\u01e7;
                if (!oc992493b0d3.\u02a2()) {
                    return null;
                }
                oc595c51c58f3 = oc595c51c58f2 = \u03e9.get(string);
                if (bl) return oc595c51c58f3;
                if (oc595c51c58f3 != null) break block11;
                object = \u0535;
                if (bl) return oc595c51c58f2;
                if (!object.contains(string)) break block12;
            }
            oc595c51c58f3 = oc595c51c58f2;
            return oc595c51c58f3;
        }
        try {
            oc595c51c58f2 = new oc595c51c58f(string);
            object = \u03e9.put(string, oc595c51c58f2);
            return oc595c51c58f2;
        }
        catch (LinkageError | RuntimeException throwable) {
            \u0535.add(string);
            Object[] objectArray = new Object[0x89B63054 ^ 0x89B63056];
            objectArray[0] = string;
            objectArray[1] = throwable;
            \u01f1.warn("Shader {} is unavailable", objectArray);
            return null;
        }
    }

    private static int \u0416(Color ... colorArray) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        block2: {
            n5 = 0;
            boolean bl = oc1b46ea259e.\u01e7;
            n4 = 0;
            n3 = 0;
            n2 = 0;
            for (Color color : colorArray) {
                n5 += color.getRed();
                n = n4 + color.getGreen();
                if (!bl) {
                    n4 = n;
                    n3 += color.getBlue();
                    n2 += color.getAlpha();
                    if (!bl) continue;
                }
                break block2;
            }
            n = colorArray.length;
        }
        int n6 = n;
        return new Color(n5 / n6, n4 / n6, n3 / n6, n2 / n6).getRGB();
    }

    private static int \u0119(int ... nArray) {
        Color[] colorArray;
        block4: {
            Color[] colorArray2 = new Color[nArray.length];
            boolean bl = oc1b46ea259e.\u01e7;
            for (int i = 0; i < nArray.length; ++i) {
                colorArray = colorArray2;
                if (!bl) {
                    colorArray[i] = new Color(nArray[i], true);
                    if (!bl) continue;
                    break;
                }
                break block4;
            }
            colorArray = colorArray2;
        }
        return W.\u0416(colorArray);
    }
}

