/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.Config;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.shaders.Shaders;
import org.lwjgl.opengl.GL11;
import x.oc45aa3f2e74;

public abstract class Render<T extends Entity>
implements IEntityRenderer {
    private static final ResourceLocation shadowTextures = new ResourceLocation("textures/misc/shadow.png");
    protected final RenderManager renderManager;
    public float shadowSize;
    protected float shadowOpaque = 1.0f;
    private Class entityClass = null;
    private ResourceLocation locationTextureCustom = null;

    protected Render(RenderManager renderManager) {
        this.renderManager = renderManager;
    }

    public boolean shouldRender(T t, ICamera iCamera, double d, double d2, double d3) {
        AxisAlignedBB axisAlignedBB = ((Entity)t).getEntityBoundingBox();
        if (axisAlignedBB.hasNaN() || axisAlignedBB.getAverageEdgeLength() == 0.0) {
            axisAlignedBB = new AxisAlignedBB(((Entity)t).posX - 2.0, ((Entity)t).posY - 2.0, ((Entity)t).posZ - 2.0, ((Entity)t).posX + 2.0, ((Entity)t).posY + 2.0, ((Entity)t).posZ + 2.0);
        }
        return ((Entity)t).isInRangeToRender3d(d, d2, d3) && (((Entity)t).ignoreFrustumCheck || iCamera.isBoundingBoxInFrustum(axisAlignedBB));
    }

    public void doRender(T t, double d, double d2, double d3, float f, float f2) {
        this.renderName(t, d, d2, d3);
    }

    protected void renderName(T t, double d, double d2, double d3) {
        if (this.canRenderName(t)) {
            this.renderLivingLabel(t, ((Entity)t).getDisplayName().getFormattedText(), d, d2, d3, 64);
        }
    }

    protected boolean canRenderName(T t) {
        return ((Entity)t).getAlwaysRenderNameTagForRender() && ((Entity)t).hasCustomName();
    }

    protected void renderOffsetLivingLabel(T t, double d, double d2, double d3, String string, float f, double d4) {
        this.renderLivingLabel(t, string, d, d2, d3, 64);
    }

    protected abstract ResourceLocation getEntityTexture(T var1);

    protected boolean bindEntityTexture(T t) {
        ResourceLocation resourceLocation = this.getEntityTexture(t);
        if (this.locationTextureCustom != null) {
            resourceLocation = this.locationTextureCustom;
        }
        if (resourceLocation == null) {
            return false;
        }
        this.bindTexture(resourceLocation);
        return true;
    }

    public void bindTexture(ResourceLocation resourceLocation) {
        this.renderManager.renderEngine.bindTexture(resourceLocation);
    }

    private void renderEntityOnFire(Entity entity, double d, double d2, double d3, float f) {
        GlStateManager.disableLighting();
        TextureMap textureMap = Minecraft.getMinecraft().getTextureMapBlocks();
        TextureAtlasSprite textureAtlasSprite = textureMap.getAtlasSprite("minecraft:blocks/fire_layer_0");
        TextureAtlasSprite textureAtlasSprite2 = textureMap.getAtlasSprite("minecraft:blocks/fire_layer_1");
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)d, (float)d2, (float)d3);
        float f2 = entity.width * 1.4f;
        GlStateManager.scale(f2, f2, f2);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        float f3 = 0.5f;
        float f4 = 0.0f;
        float f5 = entity.height / f2;
        float f6 = (float)(entity.posY - entity.getEntityBoundingBox().minY);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.0f, -0.3f + (float)((int)f5) * 0.02f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        float f7 = 0.0f;
        int n = 0;
        boolean bl = Config.isMultiTexture();
        if (bl) {
            worldRenderer.setBlockLayer(EnumWorldBlockLayer.SOLID);
        }
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        while (f5 > 0.0f) {
            TextureAtlasSprite textureAtlasSprite3 = n % 2 == 0 ? textureAtlasSprite : textureAtlasSprite2;
            worldRenderer.setSprite(textureAtlasSprite3);
            this.bindTexture(TextureMap.locationBlocksTexture);
            float f8 = textureAtlasSprite3.getMinU();
            float f9 = textureAtlasSprite3.getMinV();
            float f10 = textureAtlasSprite3.getMaxU();
            float f11 = textureAtlasSprite3.getMaxV();
            if (n / 2 % 2 == 0) {
                float f12 = f10;
                f10 = f8;
                f8 = f12;
            }
            worldRenderer.pos(f3 - f4, 0.0f - f6, f7).tex(f10, f11).endVertex();
            worldRenderer.pos(-f3 - f4, 0.0f - f6, f7).tex(f8, f11).endVertex();
            worldRenderer.pos(-f3 - f4, 1.4f - f6, f7).tex(f8, f9).endVertex();
            worldRenderer.pos(f3 - f4, 1.4f - f6, f7).tex(f10, f9).endVertex();
            f5 -= 0.45f;
            f6 -= 0.45f;
            f3 *= 0.9f;
            f7 += 0.03f;
            ++n;
        }
        tessellator.draw();
        if (bl) {
            worldRenderer.setBlockLayer(null);
            GlStateManager.bindCurrentTexture();
        }
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }

    private void renderShadow(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (!Config.isShaders() || !Shaders.shouldSkipDefaultShadow) {
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            this.renderManager.renderEngine.bindTexture(shadowTextures);
            World world2 = this.getWorldFromRenderManager();
            GlStateManager.depthMask(false);
            float f3 = this.shadowSize;
            if (entity instanceof EntityLiving) {
                EntityLiving entityLiving = (EntityLiving)entity;
                f3 *= entityLiving.getRenderSizeModifier();
                if (entityLiving.isChild()) {
                    f3 *= 0.5f;
                }
            }
            double d4 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2;
            double d5 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2;
            double d6 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2;
            int n = MathHelper.floor_double(d4 - (double)f3);
            int n2 = MathHelper.floor_double(d4 + (double)f3);
            int n3 = MathHelper.floor_double(d5 - (double)f3);
            int n4 = MathHelper.floor_double(d5);
            int n5 = MathHelper.floor_double(d6 - (double)f3);
            int n6 = MathHelper.floor_double(d6 + (double)f3);
            double d7 = d - d4;
            double d8 = d2 - d5;
            double d9 = d3 - d6;
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            for (BlockPos blockPos : BlockPos.getAllInBoxMutable(new BlockPos(n, n3, n5), new BlockPos(n2, n4, n6))) {
                Block block = world2.getBlockState(blockPos.down()).getBlock();
                if (block.getRenderType() == -1 || world2.getLightFromNeighbors(blockPos) <= 3) continue;
                this.renderShadowBlock(block, d, d2, d3, blockPos, f, f3, d7, d8, d9);
            }
            tessellator.draw();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
        }
    }

    private World getWorldFromRenderManager() {
        return this.renderManager.worldObj;
    }

    private void renderShadowBlock(Block block, double d, double d2, double d3, BlockPos blockPos, float f, float f2, double d4, double d5, double d6) {
        if (block.isFullCube()) {
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            double d7 = ((double)f - (d2 - ((double)blockPos.getY() + d5)) / 2.0) * 0.5 * (double)this.getWorldFromRenderManager().getLightBrightness(blockPos);
            if (d7 >= 0.0) {
                if (d7 > 1.0) {
                    d7 = 1.0;
                }
                double d8 = (double)blockPos.getX() + block.getBlockBoundsMinX() + d4;
                double d9 = (double)blockPos.getX() + block.getBlockBoundsMaxX() + d4;
                double d10 = (double)blockPos.getY() + block.getBlockBoundsMinY() + d5 + 0.015625;
                double d11 = (double)blockPos.getZ() + block.getBlockBoundsMinZ() + d6;
                double d12 = (double)blockPos.getZ() + block.getBlockBoundsMaxZ() + d6;
                float f3 = (float)((d - d8) / 2.0 / (double)f2 + 0.5);
                float f4 = (float)((d - d9) / 2.0 / (double)f2 + 0.5);
                float f5 = (float)((d3 - d11) / 2.0 / (double)f2 + 0.5);
                float f6 = (float)((d3 - d12) / 2.0 / (double)f2 + 0.5);
                worldRenderer.pos(d8, d10, d11).tex(f3, f5).color(1.0f, 1.0f, 1.0f, (float)d7).endVertex();
                worldRenderer.pos(d8, d10, d12).tex(f3, f6).color(1.0f, 1.0f, 1.0f, (float)d7).endVertex();
                worldRenderer.pos(d9, d10, d12).tex(f4, f6).color(1.0f, 1.0f, 1.0f, (float)d7).endVertex();
                worldRenderer.pos(d9, d10, d11).tex(f4, f5).color(1.0f, 1.0f, 1.0f, (float)d7).endVertex();
            }
        }
    }

    public static void renderOffsetAABB(AxisAlignedBB axisAlignedBB, double d, double d2, double d3) {
        GlStateManager.disableTexture2D();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        worldRenderer.setTranslation(d, d2, d3);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_NORMAL);
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        tessellator.draw();
        worldRenderer.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.enableTexture2D();
    }

    public void doRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (this.renderManager.options != null) {
            double d4;
            float f3;
            if (!OpenGlHelper.isReducedRenderMode() && this.renderManager.options.entityShadows && this.shadowSize > 0.0f && !entity.isInvisible() && this.renderManager.isRenderShadow() && (f3 = (float)((1.0 - (d4 = this.renderManager.getDistanceToCamera(entity.posX, entity.posY, entity.posZ)) / 256.0) * (double)this.shadowOpaque)) > 0.0f) {
                this.renderShadow(entity, d, d2, d3, f3, f2);
            }
            if (!(!entity.canRenderOnFire() || entity instanceof EntityPlayer && ((EntityPlayer)entity).isSpectator())) {
                this.renderEntityOnFire(entity, d, d2, d3, f2);
            }
        }
    }

    public FontRenderer getFontRendererFromRenderManager() {
        return this.renderManager.getFontRenderer();
    }

    protected void renderLivingLabel(T t, String string, double d, double d2, double d3, int n) {
        this.renderLivingLabel(t, string, d, d2, d3, n, false);
    }

    protected void renderLivingLabel(T t, String string, double d, double d2, double d3, int n, boolean bl) {
        double d4 = ((Entity)t).getDistanceSqToEntity(this.renderManager.livingPlayer);
        if (d4 <= (double)(n * n)) {
            FontRenderer fontRenderer = this.getFontRendererFromRenderManager();
            float f = 1.6f;
            float f2 = 0.016666668f * f;
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)d + 0.0f, (float)d2 + ((Entity)t).height + 0.5f, (float)d3);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
            GlStateManager.scale(-f2, -f2, f2);
            GlStateManager.disableLighting();
            GlStateManager.depthMask(false);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            int n2 = 0;
            if (string.equals("deadmau5")) {
                n2 = -10;
            }
            int n3 = bl ? oc45aa3f2e74.\u041e(8) : 0;
            int n4 = fontRenderer.getStringWidth(string);
            int n5 = n4 + n3;
            int n6 = n5 / 2;
            int n7 = -n6 + n3;
            GlStateManager.disableTexture2D();
            worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
            worldRenderer.pos(-n6 - 1, -1 + n2, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            worldRenderer.pos(-n6 - 1, 8 + n2, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            worldRenderer.pos(n6 + 1, 8 + n2, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            worldRenderer.pos(n6 + 1, -1 + n2, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
            if (bl) {
                oc45aa3f2e74.\u03f8(-n6, n2, 8, 0x20FFFFFF);
            }
            fontRenderer.drawString(string, n7, n2, 0x20FFFFFF);
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            if (bl) {
                oc45aa3f2e74.\u03f8(-n6, n2, 8, -1);
            }
            fontRenderer.drawString(string, n7, n2, -1);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
    }

    public RenderManager getRenderManager() {
        return this.renderManager;
    }

    public boolean isMultipass() {
        return false;
    }

    public void renderMultipass(T t, double d, double d2, double d3, float f, float f2) {
    }

    @Override
    public Class getEntityClass() {
        return this.entityClass;
    }

    @Override
    public void setEntityClass(Class clazz) {
        this.entityClass = clazz;
    }

    @Override
    public ResourceLocation getLocationTextureCustom() {
        return this.locationTextureCustom;
    }

    @Override
    public void setLocationTextureCustom(ResourceLocation resourceLocation) {
        this.locationTextureCustom = resourceLocation;
    }

    public static void setModelBipedMain(RenderBiped renderBiped, ModelBiped modelBiped) {
        renderBiped.modelBipedMain = modelBiped;
    }
}

