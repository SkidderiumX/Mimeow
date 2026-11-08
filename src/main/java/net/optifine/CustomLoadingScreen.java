/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.Properties;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomLoadingScreens;

public class CustomLoadingScreen {
    private ResourceLocation locationTexture;
    private int scaleMode = 0;
    private int scale = 2;
    private boolean center;
    private static final int SCALE_DEFAULT = 2;
    private static final int SCALE_MODE_FIXED = 0;
    private static final int SCALE_MODE_FULL = 1;
    private static final int SCALE_MODE_STRETCH = 2;

    public CustomLoadingScreen(ResourceLocation resourceLocation, int n, int n2, boolean bl) {
        this.locationTexture = resourceLocation;
        this.scaleMode = n;
        this.scale = n2;
        this.center = bl;
    }

    public static CustomLoadingScreen parseScreen(String string, int n, Properties properties) {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        int n2 = CustomLoadingScreen.parseScaleMode(CustomLoadingScreen.getProperty("scaleMode", n, properties));
        int n3 = n2 == 0 ? 2 : 1;
        int n4 = CustomLoadingScreen.parseScale(CustomLoadingScreen.getProperty("scale", n, properties), n3);
        boolean bl = Config.parseBoolean(CustomLoadingScreen.getProperty("center", n, properties), false);
        CustomLoadingScreen customLoadingScreen = new CustomLoadingScreen(resourceLocation, n2, n4, bl);
        return customLoadingScreen;
    }

    private static String getProperty(String string, int n, Properties properties) {
        if (properties == null) {
            return null;
        }
        String string2 = properties.getProperty("dim" + n + "." + string);
        if (string2 != null) {
            return string2;
        }
        string2 = properties.getProperty(string);
        return string2;
    }

    private static int parseScaleMode(String string) {
        if (string == null) {
            return 0;
        }
        if ((string = string.toLowerCase().trim()).equals("fixed")) {
            return 0;
        }
        if (string.equals("full")) {
            return 1;
        }
        if (string.equals("stretch")) {
            return 2;
        }
        CustomLoadingScreens.warn("Invalid scale mode: " + string);
        return 0;
    }

    private static int parseScale(String string, int n) {
        if (string == null) {
            return n;
        }
        int n2 = Config.parseInt(string = string.trim(), -1);
        if (n2 < 1) {
            CustomLoadingScreens.warn("Invalid scale: " + string);
            return n;
        }
        return n2;
    }

    public void drawBackground(int n, int n2) {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        Config.getTextureManager().bindTexture(this.locationTexture);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        double d = 16 * this.scale;
        double d2 = (double)n / d;
        double d3 = (double)n2 / d;
        double d4 = 0.0;
        double d5 = 0.0;
        if (this.center) {
            d4 = (d - (double)n) / (d * 2.0);
            d5 = (d - (double)n2) / (d * 2.0);
        }
        switch (this.scaleMode) {
            case 1: {
                d = Math.max(n, n2);
                d2 = (double)(this.scale * n) / d;
                d3 = (double)(this.scale * n2) / d;
                if (!this.center) break;
                d4 = (double)this.scale * (d - (double)n) / (d * 2.0);
                d5 = (double)this.scale * (d - (double)n2) / (d * 2.0);
                break;
            }
            case 2: {
                d2 = this.scale;
                d3 = this.scale;
                d4 = 0.0;
                d5 = 0.0;
            }
        }
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldRenderer.pos(0.0, n2, 0.0).tex(d4, d5 + d3).color(255, 255, 255, 255).endVertex();
        worldRenderer.pos(n, n2, 0.0).tex(d4 + d2, d5 + d3).color(255, 255, 255, 255).endVertex();
        worldRenderer.pos(n, 0.0, 0.0).tex(d4 + d2, d5).color(255, 255, 255, 255).endVertex();
        worldRenderer.pos(0.0, 0.0, 0.0).tex(d4, d5).color(255, 255, 255, 255).endVertex();
        tessellator.draw();
    }
}

