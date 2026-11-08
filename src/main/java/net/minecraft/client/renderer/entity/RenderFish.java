/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import x.oc4e1b577a95;
import x.occ34ee36d65;

public class RenderFish
extends Render<EntityFishHook> {
    private static final ResourceLocation FISH_PARTICLES = new ResourceLocation("textures/particle/particles.png");

    public RenderFish(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityFishHook entityFishHook, double d, double d2, double d3, float f, float f2) {
        if (oc4e1b577a95.\u040d() && entityFishHook.ticksExisted < 2) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)d, (float)d2, (float)d3);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        this.bindEntityTexture(entityFishHook);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        boolean bl = true;
        int n = 2;
        float f3 = 0.0625f;
        float f4 = 0.125f;
        float f5 = 0.125f;
        float f6 = 0.1875f;
        float f7 = 1.0f;
        float f8 = 0.5f;
        float f9 = 0.5f;
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        worldRenderer.pos(-0.5, -0.5, 0.0).tex(0.0625, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(0.5, -0.5, 0.0).tex(0.125, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(0.5, 0.5, 0.0).tex(0.125, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(-0.5, 0.5, 0.0).tex(0.0625, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
        tessellator.draw();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        if (entityFishHook.angler != null) {
            float f10 = entityFishHook.angler.getSwingProgress(f2);
            float f11 = MathHelper.sin(MathHelper.sqrt_float(f10) * (float)Math.PI);
            Vec3 vec3 = new Vec3(-0.36, 0.03, 0.35);
            vec3 = vec3.rotatePitch(-(entityFishHook.angler.prevRotationPitch + (entityFishHook.angler.rotationPitch - entityFishHook.angler.prevRotationPitch) * f2) * (float)Math.PI / 180.0f);
            vec3 = vec3.rotateYaw(-(entityFishHook.angler.prevRotationYaw + (entityFishHook.angler.rotationYaw - entityFishHook.angler.prevRotationYaw) * f2) * (float)Math.PI / 180.0f);
            vec3 = vec3.rotateYaw(f11 * 0.5f);
            vec3 = vec3.rotatePitch(-f11 * 0.7f);
            double d4 = entityFishHook.angler.prevPosX + (entityFishHook.angler.posX - entityFishHook.angler.prevPosX) * (double)f2 + vec3.xCoord;
            double d5 = entityFishHook.angler.prevPosY + (entityFishHook.angler.posY - entityFishHook.angler.prevPosY) * (double)f2 + vec3.yCoord;
            double d6 = entityFishHook.angler.prevPosZ + (entityFishHook.angler.posZ - entityFishHook.angler.prevPosZ) * (double)f2 + vec3.zCoord;
            double d7 = entityFishHook.angler.getEyeHeight();
            if (this.renderManager.options != null && this.renderManager.options.thirdPersonView > 0 || entityFishHook.angler != Minecraft.getMinecraft().thePlayer) {
                float f12 = (entityFishHook.angler.prevRenderYawOffset + (entityFishHook.angler.renderYawOffset - entityFishHook.angler.prevRenderYawOffset) * f2) * (float)Math.PI / 180.0f;
                double d8 = MathHelper.sin(f12);
                double d9 = MathHelper.cos(f12);
                double d10 = 0.35;
                double d11 = 0.8;
                d4 = entityFishHook.angler.prevPosX + (entityFishHook.angler.posX - entityFishHook.angler.prevPosX) * (double)f2 - d9 * 0.35 - d8 * 0.8;
                d5 = entityFishHook.angler.prevPosY + d7 + (entityFishHook.angler.posY - entityFishHook.angler.prevPosY) * (double)f2 - 0.45;
                d6 = entityFishHook.angler.prevPosZ + (entityFishHook.angler.posZ - entityFishHook.angler.prevPosZ) * (double)f2 - d8 * 0.35 + d9 * 0.8;
                d7 = occ34ee36d65.\u042e(entityFishHook.angler) ? -0.1875 : 0.0;
            }
            double d12 = entityFishHook.prevPosX + (entityFishHook.posX - entityFishHook.prevPosX) * (double)f2;
            double d13 = entityFishHook.prevPosY + (entityFishHook.posY - entityFishHook.prevPosY) * (double)f2 + 0.25;
            double d14 = entityFishHook.prevPosZ + (entityFishHook.posZ - entityFishHook.prevPosZ) * (double)f2;
            double d15 = (float)(d4 - d12);
            double d16 = (double)((float)(d5 - d13)) + d7;
            double d17 = (float)(d6 - d14);
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
            int n2 = 16;
            for (int i = 0; i <= 16; ++i) {
                float f13 = (float)i / 16.0f;
                worldRenderer.pos(d + d15 * (double)f13, d2 + d16 * (double)(f13 * f13 + f13) * 0.5 + 0.25, d3 + d17 * (double)f13).color(0, 0, 0, 255).endVertex();
            }
            tessellator.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            super.doRender(entityFishHook, d, d2, d3, f, f2);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFishHook entityFishHook) {
        return FISH_PARTICLES;
    }
}

