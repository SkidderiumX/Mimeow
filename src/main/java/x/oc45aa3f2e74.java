/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class oc45aa3f2e74 {
    private static final ResourceLocation \u010b = new ResourceLocation("miau", "images/cat_presence.png");
    private static final int \u0149 = 1;
    public static int \u03f1;

    private oc45aa3f2e74() {
    }

    public static int \u041e(int n) {
        return n + 1;
    }

    public static void \u03f8(float f, float f2, int n, int n2) {
        GlStateManager.disableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(0xCDE2D075 ^ 0xCDE2D377, 0xCDE2D074 ^ 0xCDE2D377, 1, 0);
        float f3 = (float)(n2 >>> (0xCDE2D36F ^ 0xCDE2D377) & (0xCDE2D388 ^ 0xCDE2D377)) / 255.0f;
        float f4 = (float)(n2 >> (0xCDE2D367 ^ 0xCDE2D377) & (0xCDE2D388 ^ 0xCDE2D377)) / 255.0f;
        float f5 = (float)(n2 >> (0xCDE2D37F ^ 0xCDE2D377) & (0xCDE2D388 ^ 0xCDE2D377)) / 255.0f;
        float f6 = (float)(n2 & (0xCDE2D388 ^ 0xCDE2D377)) / 255.0f;
        GlStateManager.color(f4, f5, f6, f3);
        Minecraft.getMinecraft().getTextureManager().bindTexture(\u010b);
        Gui.drawModalRectWithCustomSizedTexture((int)f, (int)f2, 0.0f, 0.0f, n, n, n, n);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
}

