/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomColors;

public class RenderXPOrb
extends Render<EntityXPOrb> {
    private static final ResourceLocation experienceOrbTextures = new ResourceLocation("textures/entity/experience_orb.png");

    public RenderXPOrb(RenderManager renderManager) {
        super(renderManager);
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }

    @Override
    public void doRender(EntityXPOrb entityXPOrb, double d, double d2, double d3, float f, float f2) {
        int n;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)d, (float)d2, (float)d3);
        this.bindEntityTexture(entityXPOrb);
        int n2 = entityXPOrb.getTextureByXP();
        float f3 = (float)(n2 % 4 * 16 + 0) / 64.0f;
        float f4 = (float)(n2 % 4 * 16 + 16) / 64.0f;
        float f5 = (float)(n2 / 4 * 16 + 0) / 64.0f;
        float f6 = (float)(n2 / 4 * 16 + 16) / 64.0f;
        float f7 = 1.0f;
        float f8 = 0.5f;
        float f9 = 0.25f;
        int n3 = entityXPOrb.getBrightnessForRender(f2);
        int n4 = n3 % 65536;
        int n5 = n3 / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)n4 / 1.0f, (float)n5 / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        float f10 = 255.0f;
        float f11 = ((float)entityXPOrb.xpColor + f2) / 2.0f;
        if (Config.isCustomColors()) {
            f11 = CustomColors.getXpOrbTimer(f11);
        }
        n5 = (int)((MathHelper.sin(f11 + 0.0f) + 1.0f) * 0.5f * 255.0f);
        int n6 = 255;
        int n7 = (int)((MathHelper.sin(f11 + 4.1887903f) + 1.0f) * 0.1f * 255.0f);
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        float f12 = 0.3f;
        GlStateManager.scale(0.3f, 0.3f, 0.3f);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
        int n8 = n5;
        int n9 = 255;
        int n10 = n7;
        if (Config.isCustomColors() && (n = CustomColors.getXpOrbColor(f11)) >= 0) {
            n8 = n >> 16 & 0xFF;
            n9 = n >> 8 & 0xFF;
            n10 = n >> 0 & 0xFF;
        }
        worldRenderer.pos(0.0f - f8, 0.0f - f9, 0.0).tex(f3, f6).color(n8, n9, n10, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(f7 - f8, 0.0f - f9, 0.0).tex(f4, f6).color(n8, n9, n10, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(f7 - f8, 1.0f - f9, 0.0).tex(f4, f5).color(n8, n9, n10, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(0.0f - f8, 1.0f - f9, 0.0).tex(f3, f5).color(n8, n9, n10, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entityXPOrb, d, d2, d3, f, f2);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityXPOrb entityXPOrb) {
        return experienceOrbTextures;
    }
}

