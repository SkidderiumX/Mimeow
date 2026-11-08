/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelSprite {
    private ModelRenderer modelRenderer = null;
    private int textureOffsetX = 0;
    private int textureOffsetY = 0;
    private float posX = 0.0f;
    private float posY = 0.0f;
    private float posZ = 0.0f;
    private int sizeX = 0;
    private int sizeY = 0;
    private int sizeZ = 0;
    private float sizeAdd = 0.0f;
    private float minU = 0.0f;
    private float minV = 0.0f;
    private float maxU = 0.0f;
    private float maxV = 0.0f;

    public ModelSprite(ModelRenderer modelRenderer, int n, int n2, float f, float f2, float f3, int n3, int n4, int n5, float f4) {
        this.modelRenderer = modelRenderer;
        this.textureOffsetX = n;
        this.textureOffsetY = n2;
        this.posX = f;
        this.posY = f2;
        this.posZ = f3;
        this.sizeX = n3;
        this.sizeY = n4;
        this.sizeZ = n5;
        this.sizeAdd = f4;
        this.minU = (float)n / modelRenderer.textureWidth;
        this.minV = (float)n2 / modelRenderer.textureHeight;
        this.maxU = (float)(n + n3) / modelRenderer.textureWidth;
        this.maxV = (float)(n2 + n4) / modelRenderer.textureHeight;
    }

    public void render(Tessellator tessellator, float f) {
        GlStateManager.translate(this.posX * f, this.posY * f, this.posZ * f);
        float f2 = this.minU;
        float f3 = this.maxU;
        float f4 = this.minV;
        float f5 = this.maxV;
        if (this.modelRenderer.mirror) {
            f2 = this.maxU;
            f3 = this.minU;
        }
        if (this.modelRenderer.mirrorV) {
            f4 = this.maxV;
            f5 = this.minV;
        }
        ModelSprite.renderItemIn2D(tessellator, f2, f4, f3, f5, this.sizeX, this.sizeY, f * (float)this.sizeZ, this.modelRenderer.textureWidth, this.modelRenderer.textureHeight);
        GlStateManager.translate(-this.posX * f, -this.posY * f, -this.posZ * f);
    }

    public static void renderItemIn2D(Tessellator tessellator, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, float f7) {
        float f8;
        float f9;
        float f10;
        int n3;
        if (f5 < 6.25E-4f) {
            f5 = 6.25E-4f;
        }
        float f11 = f3 - f;
        float f12 = f4 - f2;
        double d = MathHelper.abs(f11) * (f6 / 16.0f);
        double d2 = MathHelper.abs(f12) * (f7 / 16.0f);
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(0.0, d2, 0.0).tex(f, f4).endVertex();
        worldRenderer.pos(d, d2, 0.0).tex(f3, f4).endVertex();
        worldRenderer.pos(d, 0.0, 0.0).tex(f3, f2).endVertex();
        worldRenderer.pos(0.0, 0.0, 0.0).tex(f, f2).endVertex();
        tessellator.draw();
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(0.0, 0.0, f5).tex(f, f2).endVertex();
        worldRenderer.pos(d, 0.0, f5).tex(f3, f2).endVertex();
        worldRenderer.pos(d, d2, f5).tex(f3, f4).endVertex();
        worldRenderer.pos(0.0, d2, f5).tex(f, f4).endVertex();
        tessellator.draw();
        float f13 = 0.5f * f11 / (float)n;
        float f14 = 0.5f * f12 / (float)n2;
        GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (n3 = 0; n3 < n; ++n3) {
            f10 = (float)n3 / (float)n;
            f9 = f + f11 * f10 + f13;
            worldRenderer.pos((double)f10 * d, d2, f5).tex(f9, f4).endVertex();
            worldRenderer.pos((double)f10 * d, d2, 0.0).tex(f9, f4).endVertex();
            worldRenderer.pos((double)f10 * d, 0.0, 0.0).tex(f9, f2).endVertex();
            worldRenderer.pos((double)f10 * d, 0.0, f5).tex(f9, f2).endVertex();
        }
        tessellator.draw();
        GL11.glNormal3f(1.0f, 0.0f, 0.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (n3 = 0; n3 < n; ++n3) {
            f10 = (float)n3 / (float)n;
            f9 = f + f11 * f10 + f13;
            f8 = f10 + 1.0f / (float)n;
            worldRenderer.pos((double)f8 * d, 0.0, f5).tex(f9, f2).endVertex();
            worldRenderer.pos((double)f8 * d, 0.0, 0.0).tex(f9, f2).endVertex();
            worldRenderer.pos((double)f8 * d, d2, 0.0).tex(f9, f4).endVertex();
            worldRenderer.pos((double)f8 * d, d2, f5).tex(f9, f4).endVertex();
        }
        tessellator.draw();
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (n3 = 0; n3 < n2; ++n3) {
            f10 = (float)n3 / (float)n2;
            f9 = f2 + f12 * f10 + f14;
            f8 = f10 + 1.0f / (float)n2;
            worldRenderer.pos(0.0, (double)f8 * d2, f5).tex(f, f9).endVertex();
            worldRenderer.pos(d, (double)f8 * d2, f5).tex(f3, f9).endVertex();
            worldRenderer.pos(d, (double)f8 * d2, 0.0).tex(f3, f9).endVertex();
            worldRenderer.pos(0.0, (double)f8 * d2, 0.0).tex(f, f9).endVertex();
        }
        tessellator.draw();
        GL11.glNormal3f(0.0f, -1.0f, 0.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (n3 = 0; n3 < n2; ++n3) {
            f10 = (float)n3 / (float)n2;
            f9 = f2 + f12 * f10 + f14;
            worldRenderer.pos(d, (double)f10 * d2, f5).tex(f3, f9).endVertex();
            worldRenderer.pos(0.0, (double)f10 * d2, f5).tex(f, f9).endVertex();
            worldRenderer.pos(0.0, (double)f10 * d2, 0.0).tex(f, f9).endVertex();
            worldRenderer.pos(d, (double)f10 * d2, 0.0).tex(f3, f9).endVertex();
        }
        tessellator.draw();
    }
}

