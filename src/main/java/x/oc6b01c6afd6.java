/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import x.oc110d7f376c;
import x.oc1378bc114d;
import x.oc1b46ea259e;
import x.oc287435e33a;
import x.oc2cf3d80e17;
import x.oc3ebac73392;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc9cd81f0bf1;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.oce6044968f8;
import x.ocf923d5a814;

public class oc6b01c6afd6
extends oc69da1aa7f5 {
    private static final ResourceLocation \u0526 = new ResourceLocation("textures/gui/container/inventory.png");
    private final occ2f8dff8d8 \u00ce = new occ2f8dff8d8("Potion Lower case", false);
    private final occ2f8dff8d8 \u04ad = new occ2f8dff8d8("Potion Icons", true);
    private final occ2f8dff8d8 \u0534 = new occ2f8dff8d8("Potion Levels", true);
    private final occ2f8dff8d8 \u0271 = new occ2f8dff8d8("Potion Durations", true);
    private final occ2f8dff8d8 \u0390 = new occ2f8dff8d8("Potion Hide long effects", true);
    private double \u01b8 = 1.0;
    private double \u04e3 = 1.0;
    private boolean \u0376;
    private float \u02e2;
    private float \u00f6;
    public static int \u0474;

    public oc6b01c6afd6() {
        super("PotionHUD", oce4cea752dd.\u014e);
        this.\u0105("Displays active potion effects and durations.");
        this.\u028c(this.\u00ce);
        this.\u028c(this.\u04ad);
        this.\u028c(this.\u0534);
        this.\u028c(this.\u0271);
        this.\u028c(this.\u0390);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u00f5(ocf923d5a814 ocf923d5a8142) {
        block14: {
            Minecraft minecraft;
            block13: {
                boolean bl;
                block12: {
                    boolean bl2;
                    block11: {
                        bl = oce6044968f8.\u0452;
                        if (ocf923d5a8142.\u04b0 != oc110d7f376c.END) return;
                        bl2 = oc7ab2161b9f.\u00d0();
                        if (bl) break block11;
                        if (!bl2) return;
                        minecraft = oc69da1aa7f5.\u0151;
                        if (bl) break block12;
                        bl2 = minecraft.gameSettings.showDebugInfo;
                    }
                    if (bl2) return;
                    minecraft = oc69da1aa7f5.\u0151;
                }
                if (bl) break block13;
                if (minecraft.currentScreen == null) break block14;
                minecraft = oc69da1aa7f5.\u0151;
            }
            if (!(minecraft.currentScreen instanceof GuiChat)) return;
        }
        this.\u012e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void \u012e() {
        block83: {
            int n;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            ArrayList<oc287435e33a> arrayList;
            float f6;
            boolean bl;
            block82: {
                float f7;
                float f8;
                float f9;
                oc1378bc114d oc1378bc114d2;
                block81: {
                    block72: {
                        block80: {
                            oc6b01c6afd6 oc6b01c6afd62;
                            float f10;
                            ScaledResolution scaledResolution;
                            block79: {
                                int n2;
                                float f11;
                                float f12;
                                float f13;
                                float f14;
                                block78: {
                                    block77: {
                                        block76: {
                                            int n3;
                                            block74: {
                                                block75: {
                                                    int n4;
                                                    block73: {
                                                        block71: {
                                                            oc1378bc114d oc1378bc114d3;
                                                            block68: {
                                                                bl = oce6044968f8.\u0452;
                                                                if (!oc7ab2161b9f.\u00d0()) {
                                                                    return;
                                                                }
                                                                scaledResolution = new ScaledResolution(oc69da1aa7f5.\u0151);
                                                                f6 = oce6044968f8.\u01bc() / 0.9f;
                                                                oc1378bc114d2 = oc3ebac73392.\u022f("ProductSans-Bold", 0.8f * f6);
                                                                oc1378bc114d3 = oc3ebac73392.\u022f("ProductSans", 0.9f * f6);
                                                                arrayList = new ArrayList<oc287435e33a>();
                                                                Iterator<PotionEffect> iterator2 = oc69da1aa7f5.\u0151.thePlayer.getActivePotionEffects().iterator();
                                                                block39: while (true) {
                                                                    Iterator<PotionEffect> iterator3 = iterator2;
                                                                    while (iterator3.hasNext()) {
                                                                        Potion potion;
                                                                        PotionEffect potionEffect;
                                                                        block70: {
                                                                            int n5;
                                                                            block69: {
                                                                                iterator3 = iterator2;
                                                                                if (bl) continue;
                                                                                potionEffect = iterator3.next();
                                                                                if (bl) break block68;
                                                                                potion = oc6b01c6afd6.\u03c0(potionEffect);
                                                                                if (potion == null) continue block39;
                                                                                n5 = this.\u0390.\u01ed();
                                                                                if (bl) break block69;
                                                                                if (n5 == 0) break block70;
                                                                                n5 = potionEffect.getDuration();
                                                                            }
                                                                            if (n5 > (0x98B783DD ^ 0x98B7DE1D)) continue block39;
                                                                        }
                                                                        Object object = I18n.format(potion.getName(), new Object[0]);
                                                                        occ2f8dff8d8 occ2f8dff8d82 = this.\u00ce;
                                                                        if (!bl) {
                                                                            if (occ2f8dff8d82.\u01ed()) {
                                                                                object = ((String)object).toLowerCase(Locale.ROOT);
                                                                            }
                                                                            occ2f8dff8d82 = this.\u0534;
                                                                        }
                                                                        if (!bl) {
                                                                            if (occ2f8dff8d82.\u01ed()) {
                                                                                object = (String)object + " " + oc6b01c6afd6.\u021f(potionEffect.getAmplifier() + 1);
                                                                            }
                                                                            occ2f8dff8d82 = this.\u0271;
                                                                        }
                                                                        String string = occ2f8dff8d82.\u01ed() ? " " + Potion.getDurationString(potionEffect) : "";
                                                                        arrayList.add(oc6b01c6afd6.\u01c9(potion, (String)object, string, oc1378bc114d2, oc1378bc114d3));
                                                                        if (bl) break block39;
                                                                        continue block39;
                                                                    }
                                                                    break;
                                                                }
                                                                arrayList.sort(Comparator.comparingDouble(oc287435e33a2 -> oc287435e33a2.\u0499).reversed().thenComparing(oc287435e33a2 -> oc287435e33a2.\u04e3));
                                                            }
                                                            int n6 = oc69da1aa7f5.\u0151.currentScreen instanceof GuiChat;
                                                            boolean bl2 = arrayList.isEmpty();
                                                            if (!bl) {
                                                                if (bl2) {
                                                                    this.\u0376 = false;
                                                                    if (n6 == 0) {
                                                                        return;
                                                                    }
                                                                    arrayList.add(oc6b01c6afd6.\u01c9(Potion.moveSpeed, this.\u03a5(Potion.moveSpeed, 0x98B7DE1F ^ 0x98B7DE1D), this.\u0271.\u01ed() ? " 1:30" : "", oc1378bc114d2, oc1378bc114d3));
                                                                    arrayList.add(oc6b01c6afd6.\u01c9(Potion.regeneration, this.\u03a5(Potion.regeneration, 1), this.\u0271.\u01ed() ? " 0:45" : "", oc1378bc114d2, oc1378bc114d3));
                                                                    arrayList.sort(Comparator.comparingDouble(oc287435e33a2 -> oc287435e33a2.\u0499).reversed().thenComparing(oc287435e33a2 -> oc287435e33a2.\u04e3));
                                                                }
                                                                bl2 = this.\u04ad.\u01ed();
                                                            }
                                                            f5 = bl2 ? 19.0f * f6 : 0.0f;
                                                            f4 = this.\u04ad.\u01ed() ? 3.7f * f6 : 0.0f;
                                                            float f16 = oc1378bc114d2.z$1tqmx4tpnr6lq();
                                                            f16 = f4;
                                                            if (!bl) {
                                                                float f16 = f15 + f16;
                                                                f16 = this.\u04ad.\u01ed() ? 13.0f * f6 : 0.0f;
                                                            }
                                                            f9 = Math.max(f15, f16);
                                                            f3 = (float)oc1378bc114d3.z$3hte9fh87zo6x() + 5.0f * f6;
                                                            f14 = (float)arrayList.stream().mapToDouble(oc287435e33a2 -> oc287435e33a2.\u0571).max().orElse(0.0) + f5;
                                                            f13 = (float)(arrayList.size() - 1) * f3 + f9;
                                                            f10 = 5.0f * f6;
                                                            f12 = Math.max(0.0f, (float)scaledResolution.getScaledWidth() - f10);
                                                            f11 = scaledResolution.getScaledHeight();
                                                            f2 = (float)(this.\u01b8 * (double)scaledResolution.getScaledWidth()) - f10;
                                                            f8 = (float)(this.\u04e3 * (double)scaledResolution.getScaledHeight());
                                                            f2 = oc6b01c6afd6.\u0586(f2, f14, f12);
                                                            f8 = oc6b01c6afd6.\u0586(f8, f13, f11);
                                                            n4 = n6;
                                                            if (bl) break block71;
                                                            if (n4 == 0) break block72;
                                                            n4 = Mouse.isCreated();
                                                        }
                                                        if (bl) break block73;
                                                        if (n4 == 0) break block72;
                                                        n4 = Mouse.getX() * scaledResolution.getScaledWidth();
                                                    }
                                                    f7 = (float)n4 / (float)oc69da1aa7f5.\u0151.displayWidth;
                                                    f = (float)scaledResolution.getScaledHeight() - (float)(Mouse.getY() * scaledResolution.getScaledHeight()) / (float)oc69da1aa7f5.\u0151.displayHeight - 1.0f;
                                                    n3 = 0;
                                                    if (bl) break block74;
                                                    if (Mouse.isButtonDown(n3)) break block75;
                                                    this.\u0376 = false;
                                                    if (!bl) break block76;
                                                }
                                                oc6b01c6afd62 = this;
                                                if (bl) break block77;
                                                n3 = oc6b01c6afd62.\u0376 ? 1 : 0;
                                            }
                                            if (n3 != 0) break block76;
                                            float f17 = f7 - (f2 - f14);
                                            n2 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
                                            if (bl) break block78;
                                            if (n2 < 0) break block76;
                                            n2 = f7 == f2 ? 0 : (f7 < f2 ? -1 : 1);
                                            if (bl) break block78;
                                            if (n2 > 0) break block76;
                                            float f18 = f - (f8 - f13);
                                            n2 = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
                                            if (bl) break block78;
                                            if (n2 < 0) break block76;
                                            n2 = f == f8 ? 0 : (f < f8 ? -1 : 1);
                                            if (bl) break block78;
                                            if (n2 <= 0) {
                                                this.\u0376 = true;
                                                this.\u02e2 = f7 - f2;
                                                this.\u00f6 = f - f8;
                                            }
                                        }
                                        oc6b01c6afd62 = this;
                                    }
                                    if (bl) break block79;
                                    n2 = oc6b01c6afd62.\u0376;
                                }
                                if (n2 == 0) break block80;
                                f2 = oc6b01c6afd6.\u0586(f7 - this.\u02e2, f14, f12);
                                f8 = oc6b01c6afd6.\u0586(f - this.\u00f6, f13, f11);
                                oc6b01c6afd62 = this;
                            }
                            oc6b01c6afd62.\u011f((f2 + f10) / (float)scaledResolution.getScaledWidth(), f8 / (float)scaledResolution.getScaledHeight());
                            oc2cf3d80e17.\u04eb();
                        }
                        if (!bl) break block81;
                    }
                    this.\u0376 = false;
                }
                f7 = f2;
                f = f8 - f9 + f4;
                oc9cd81f0bf1 oc9cd81f0bf12 = oce6044968f8.\u03a6();
                if (!bl) {
                    if (oc9cd81f0bf12.\u0462()) {
                        oc1b46ea259e.\u0406(() -> oc6b01c6afd6.\u00f0(arrayList, oc1378bc114d2, f7, f, f3, oc9cd81f0bf12.\u022f()), oc9cd81f0bf12.\u03fe(), oc9cd81f0bf12.\u00e3());
                    }
                    oc6b01c6afd6.\u00f0(arrayList, oc1378bc114d2, f7, f, f3, 0x677B12D1 ^ 0x98B7DE1D);
                }
                int n7 = this.\u04ad.\u01ed();
                if (bl) break block82;
                if (n7 == 0) break block83;
                n7 = n = 0;
            }
            while (n < arrayList.size()) {
                oc287435e33a oc287435e33a3 = (oc287435e33a)arrayList.get(n);
                if (!bl) {
                    if (oc287435e33a3.\u04ed.hasStatusIcon()) {
                        this.\u024c(oc287435e33a3.\u04ed, f2 - oc287435e33a3.\u0571 - f5 + 4.0f * f6, f - (float)n * f3 - f4, 13.0f * f6);
                    }
                    ++n;
                }
                if (!bl) continue;
            }
        }
    }

    private static float \u0586(float f, float f2, float f3) {
        return Math.max(Math.min(f2, f3), Math.min(f3, f));
    }

    private String \u03a5(Potion potion, int n) {
        occ2f8dff8d8 occ2f8dff8d82;
        String string;
        block4: {
            block5: {
                string = I18n.format(potion.getName(), new Object[0]);
                boolean bl = oce6044968f8.\u0452;
                occ2f8dff8d82 = this.\u00ce;
                if (bl) break block4;
                if (!occ2f8dff8d82.\u01ed()) break block5;
                string = string.toLowerCase(Locale.ROOT);
            }
            occ2f8dff8d82 = this.\u0534;
        }
        Object object = occ2f8dff8d82.\u01ed() ? string + " " + oc6b01c6afd6.\u021f(n) : string;
        return object;
    }

    private static oc287435e33a \u01c9(Potion potion, String string, String string2, oc1378bc114d oc1378bc114d2, oc1378bc114d oc1378bc114d3) {
        float f = oc1378bc114d2.z$toz8pt08w0nc(string);
        return new oc287435e33a(potion, string, string2, f + (float)oc1378bc114d3.z$toz8pt08w0nc(string2), f + (float)oc1378bc114d2.z$toz8pt08w0nc(string2));
    }

    private static void \u00f0(List<oc287435e33a> list, oc1378bc114d oc1378bc114d2, float f, float f2, float f3, int n) {
        boolean bl = oce6044968f8.\u0452;
        for (int i = 0; i < list.size(); ++i) {
            oc287435e33a oc287435e33a2 = list.get(i);
            float f4 = f - oc287435e33a2.\u0571;
            float f5 = f2 - (float)i * f3;
            oc1378bc114d2.z$ao2ykh4tuw6w(oc287435e33a2.\u04e3, f4, f5, n, false);
            oc1378bc114d2.z$ao2ykh4tuw6w(oc287435e33a2.\u03b6, f4 + (float)oc1378bc114d2.z$toz8pt08w0nc(oc287435e33a2.\u04e3), f5, n, false);
            if (!bl) continue;
        }
    }

    static String \u021f(int n) {
        int n2;
        boolean bl;
        block7: {
            block8: {
                bl = oce6044968f8.\u0452;
                n2 = n;
                if (bl) break block7;
                if (n2 > 0) break block8;
                return String.valueOf(n);
            }
            n2 = 0xA20024EA ^ 0xA20024E3;
        }
        int[] nArray = new int[n2];
        nArray[0] = 0xA2002487 ^ 0xA20024E3;
        nArray[1] = 0xA20024B9 ^ 0xA20024E3;
        nArray[0xA20024E1 ^ 0xA20024E3] = 0xA20024D1 ^ 0xA20024E3;
        nArray[0xA20024E0 ^ 0xA20024E3] = 0xA20024CB ^ 0xA20024E3;
        nArray[0xA20024E7 ^ 0xA20024E3] = 0xA20024E9 ^ 0xA20024E3;
        nArray[0xA20024E6 ^ 0xA20024E3] = 0xA20024EA ^ 0xA20024E3;
        nArray[0xA20024E5 ^ 0xA20024E3] = 0xA20024E6 ^ 0xA20024E3;
        nArray[0xA20024E4 ^ 0xA20024E3] = 0xA20024E7 ^ 0xA20024E3;
        nArray[0xA20024EB ^ 0xA20024E3] = 1;
        int[] nArray2 = nArray;
        String[] stringArray = new String[0xA20024EA ^ 0xA20024E3];
        stringArray[0] = "C";
        stringArray[1] = "XC";
        stringArray[0xA20024E1 ^ 0xA20024E3] = "L";
        stringArray[0xA20024E0 ^ 0xA20024E3] = "XL";
        stringArray[0xA20024E7 ^ 0xA20024E3] = "X";
        stringArray[0xA20024E6 ^ 0xA20024E3] = "IX";
        stringArray[0xA20024E5 ^ 0xA20024E3] = "V";
        stringArray[0xA20024E4 ^ 0xA20024E3] = "IV";
        stringArray[0xA20024EB ^ 0xA20024E3] = "I";
        String[] stringArray2 = stringArray;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = Math.min(0xA200241C ^ 0xA20024E3, n);
        int n4 = 0;
        while (n4 < nArray2.length) {
            block9: {
                while (n3 >= nArray2[n4]) {
                    stringBuilder.append(stringArray2[n4]);
                    if (!bl) {
                        n3 -= nArray2[n4];
                        if (!bl) continue;
                    }
                    break block9;
                }
                ++n4;
            }
            if (!bl) continue;
        }
        return stringBuilder.toString();
    }

    private static Potion \u03c0(PotionEffect potionEffect) {
        Potion potion;
        block6: {
            block5: {
                int n;
                int n2;
                block4: {
                    n2 = potionEffect.getPotionID();
                    boolean bl = oce6044968f8.\u0452;
                    n = n2;
                    if (bl) break block4;
                    if (n < 0) break block5;
                    n = n2;
                }
                if (n >= Potion.potionTypes.length) break block5;
                potion = Potion.potionTypes[n2];
                break block6;
            }
            potion = null;
        }
        return potion;
    }

    public double \u01ac() {
        return this.\u01b8;
    }

    public double \u0525() {
        return this.\u04e3;
    }

    public void \u011f(double d, double d2) {
        double d3;
        block7: {
            block8: {
                boolean bl = oce6044968f8.\u0452;
                d3 = d;
                if (bl) break block7;
                if (!Double.isFinite(d3)) break block8;
                this.\u01b8 = Math.max(0.0, Math.min(1.0, d));
            }
            d3 = d2;
        }
        if (Double.isFinite(d3)) {
            this.\u04e3 = Math.max(0.0, Math.min(1.0, d2));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u024c(Potion potion, float f, float f2, float f3) {
        block27: {
            block26: {
                boolean bl;
                block25: {
                    int n;
                    block20: {
                        int n2;
                        boolean bl2;
                        int n3;
                        block19: {
                            int n4 = potion.getStatusIconIndex();
                            boolean bl3 = GL11.glIsEnabled(0xC0B9B788 ^ 0xC0B9BB99);
                            bl = oce6044968f8.\u0452;
                            n3 = GL11.glIsEnabled(0xC0B9B0E8 ^ 0xC0B9BB99);
                            bl2 = GL11.glGetBoolean(0xC0B9B0EB ^ 0xC0B9BB99);
                            GlStateManager.pushMatrix();
                            try {
                                GlStateManager.translate(f, f2, 0.0f);
                                float f4 = f3 / 18.0f;
                                GlStateManager.scale(f4, f4, 1.0f);
                                OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
                                GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
                                GL11.glDisable(0xC0B9B678 ^ 0xC0B9BB99);
                                GlStateManager.disableTexture2D();
                                n2 = OpenGlHelper.defaultTexUnit;
                                if (bl) break block19;
                                OpenGlHelper.setActiveTexture(n2);
                                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
                                GL11.glEnable(0xC0B9B678 ^ 0xC0B9BB99);
                                GlStateManager.enableTexture2D();
                                GlStateManager.disableAlpha();
                                GlStateManager.enableAlpha();
                                GlStateManager.disableBlend();
                                GlStateManager.enableBlend();
                                GlStateManager.tryBlendFuncSeparate(0xC0B9B89B ^ 0xC0B9BB99, 0xC0B9B89A ^ 0xC0B9BB99, 1, 0);
                                GlStateManager.alphaFunc(0xC0B9B99D ^ 0xC0B9BB99, 0.0f);
                                GlStateManager.disableLighting();
                                GlStateManager.disableDepth();
                                GlStateManager.depthMask(false);
                                GlStateManager.resetColor();
                                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                                GL11.glTexEnvi(0xC0B99899 ^ 0xC0B9BB99, 0xC0B99999 ^ 0xC0B9BB99, 0xC0B99A99 ^ 0xC0B9BB99);
                                if (bl3) {
                                    GL11.glDisable(0xC0B9B788 ^ 0xC0B9BB99);
                                }
                                GL11.glBindTexture(0xC0B9B678 ^ 0xC0B9BB99, 0);
                                n = 0;
                                if (bl) break block20;
                                GlStateManager.bindTexture(n);
                                oc69da1aa7f5.\u0151.getTextureManager().bindTexture(\u0526);
                                Gui.drawScaledCustomSizeModalRect(0, 0, n4 % (0xC0B9BB91 ^ 0xC0B9BB99) * (0xC0B9BB8B ^ 0xC0B9BB99), (0xC0B9BB5F ^ 0xC0B9BB99) + n4 / (0xC0B9BB91 ^ 0xC0B9BB99) * (0xC0B9BB8A ^ 0xC0B9BB99), 0xC0B9BB8B ^ 0xC0B9BB99, 0xC0B9BB8B ^ 0xC0B9BB99, 0xC0B9BB8B ^ 0xC0B9BB99, 0xC0B9BB8B ^ 0xC0B9BB99, 256.0f, 256.0f);
                            }
                            catch (Throwable throwable) {
                                block24: {
                                    block23: {
                                        block22: {
                                            block21: {
                                                if (bl) break block21;
                                                if (bl3) {
                                                    GL11.glEnable(0xC0B9B788 ^ 0xC0B9BB99);
                                                }
                                                GlStateManager.depthMask(bl2);
                                                if (bl) break block22;
                                            }
                                            if (n3 == 0) break block23;
                                            GlStateManager.enableDepth();
                                        }
                                        if (!bl) break block24;
                                    }
                                    GlStateManager.disableDepth();
                                }
                                GlStateManager.disableBlend();
                                GlStateManager.alphaFunc(0xC0B9B99D ^ 0xC0B9BB99, 0.1f);
                                GlStateManager.enableAlpha();
                                OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
                                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
                                GL11.glEnable(0xC0B9B678 ^ 0xC0B9BB99);
                                GlStateManager.enableTexture2D();
                                GlStateManager.resetColor();
                                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                                GlStateManager.popMatrix();
                                throw throwable;
                            }
                            n2 = bl3 ? 1 : 0;
                        }
                        if (n2 != 0) {
                            GL11.glEnable(0xC0B9B788 ^ 0xC0B9BB99);
                        }
                        GlStateManager.depthMask(bl2);
                        if (bl) break block25;
                        n = n3;
                    }
                    if (n == 0) break block26;
                    GlStateManager.enableDepth();
                }
                if (!bl) break block27;
            }
            GlStateManager.disableDepth();
        }
        GlStateManager.disableBlend();
        GlStateManager.alphaFunc(0xC0B9B99D ^ 0xC0B9BB99, 0.1f);
        GlStateManager.enableAlpha();
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GL11.glEnable(0xC0B9B678 ^ 0xC0B9BB99);
        GlStateManager.enableTexture2D();
        GlStateManager.resetColor();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }
}

