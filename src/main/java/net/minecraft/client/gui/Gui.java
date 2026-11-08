/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;

public class Gui {
    public static final ResourceLocation optionsBackground = new ResourceLocation("textures/gui/options_background.png");
    public static final ResourceLocation statIcons = new ResourceLocation("textures/gui/container/stats_icons.png");
    public static final ResourceLocation icons = new ResourceLocation("textures/gui/icons.png");
    protected float zLevel;

    protected void drawHorizontalLine(int n, int n2, int n3, int n4) {
        if (n2 < n) {
            int n5 = n;
            n = n2;
            n2 = n5;
        }
        Gui.drawRect(n, n3, n2 + 1, n3 + 1, n4);
    }

    protected void drawVerticalLine(int n, int n2, int n3, int n4) {
        if (n3 < n2) {
            int n5 = n2;
            n2 = n3;
            n3 = n5;
        }
        Gui.drawRect(n, n2 + 1, n + 1, n3, n4);
    }

    public static void drawRect(int n, int n2, int n3, int n4, int n5) {
        int n6;
        if (n < n3) {
            n6 = n;
            n = n3;
            n3 = n6;
        }
        if (n2 < n4) {
            n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(f2, f3, f4, f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION);
        worldRenderer.pos(n, n4, 0.0).endVertex();
        worldRenderer.pos(n3, n4, 0.0).endVertex();
        worldRenderer.pos(n3, n2, 0.0).endVertex();
        worldRenderer.pos(n, n2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    protected void drawGradientRect(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n6 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldRenderer.pos(n3, n2, this.zLevel).color(f2, f3, f4, f).endVertex();
        worldRenderer.pos(n, n2, this.zLevel).color(f2, f3, f4, f).endVertex();
        worldRenderer.pos(n, n4, this.zLevel).color(f6, f7, f8, f5).endVertex();
        worldRenderer.pos(n3, n4, this.zLevel).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public void drawCenteredString(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer.drawStringWithShadow(string, n - fontRenderer.getStringWidth(string) / 2, n2, n3);
    }

    public void drawString(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer.drawStringWithShadow(string, n, n2, n3);
    }

    public void drawTexturedModalRect(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        Gui.drawTexturedQuad(n, n2, n + n5, n2 + n6, this.zLevel, (float)n3 * f, (float)n4 * f2, (float)(n3 + n5) * f, (float)(n4 + n6) * f2);
    }

    public void drawTexturedModalRect(float f, float f2, int n, int n2, int n3, int n4) {
        float f3 = 0.00390625f;
        float f4 = 0.00390625f;
        Gui.drawTexturedQuad(f, f2, f + (float)n3, f2 + (float)n4, this.zLevel, (float)n * f3, (float)n2 * f4, (float)(n + n3) * f3, (float)(n2 + n4) * f4);
    }

    public void drawTexturedModalRect(int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3, int n4) {
        Gui.drawTexturedQuad(n, n2, n + n3, n2 + n4, this.zLevel, textureAtlasSprite.getMinU(), textureAtlasSprite.getMinV(), textureAtlasSprite.getMaxU(), textureAtlasSprite.getMaxV());
    }

    private static void drawTexturedQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        if (OpenGlHelper.isReducedRenderMode()) {
            Gui.drawTexturedQuadImmediate(d, d2, d3, d4, d5, d6, d7, d8, d9);
            return;
        }
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(d, d4, d5).tex(d6, d9).endVertex();
        worldRenderer.pos(d3, d4, d5).tex(d8, d9).endVertex();
        worldRenderer.pos(d3, d2, d5).tex(d8, d7).endVertex();
        worldRenderer.pos(d, d2, d5).tex(d6, d7).endVertex();
        tessellator.draw();
    }

    private static void drawTexturedQuadImmediate(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        GL11.glBegin(7);
        GL11.glTexCoord2d(d6, d9);
        GL11.glVertex3d(d, d4, d5);
        GL11.glTexCoord2d(d8, d9);
        GL11.glVertex3d(d3, d4, d5);
        GL11.glTexCoord2d(d8, d7);
        GL11.glVertex3d(d3, d2, d5);
        GL11.glTexCoord2d(d6, d7);
        GL11.glVertex3d(d, d2, d5);
        oc170ea29aae.\u0177();
    }

    public static void drawModalRectWithCustomSizedTexture(int n, int n2, float f, float f2, int n3, int n4, float f3, float f4) {
        float f5 = 1.0f / f3;
        float f6 = 1.0f / f4;
        Gui.drawTexturedQuad(n, n2, n + n3, n2 + n4, 0.0, f * f5, f2 * f6, (f + (float)n3) * f5, (f2 + (float)n4) * f6);
    }

    public static void drawScaledCustomSizeModalRect(int n, int n2, float f, float f2, int n3, int n4, int n5, int n6, float f3, float f4) {
        float f5 = 1.0f / f3;
        float f6 = 1.0f / f4;
        Gui.drawTexturedQuad(n, n2, n + n5, n2 + n6, 0.0, f * f5, f2 * f6, (f + (float)n3) * f5, (f2 + (float)n4) * f6);
    }
}

