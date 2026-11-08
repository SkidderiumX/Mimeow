/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import org.lwjgl.opengl.GL11;
import x.oc3c923cb5dd;
import x.oc718fd4d503;
import x.oc743046ab41;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.ocbb9d40af7e;
import x.ocee33618a8d;

public class ItemRenderer
implements oc3c923cb5dd,
ocbb9d40af7e {
    private static final ResourceLocation RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
    private static final ResourceLocation RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
    private final Minecraft mc;
    private ItemStack itemToRender;
    private float equippedProgress;
    private float prevEquippedProgress;
    private final RenderManager renderManager;
    private final RenderItem itemRenderer;
    private int equippedItemSlot = -1;
    private ItemStack originalItemToRender;
    public boolean cancelUpdate = false;
    public boolean cancelReset = false;
    private boolean renderItemInUse;

    public ItemRenderer(Minecraft minecraft) {
        this.mc = minecraft;
        this.renderManager = minecraft.getRenderManager();
        this.itemRenderer = minecraft.getRenderItem();
    }

    public void renderItem(EntityLivingBase entityLivingBase, ItemStack itemStack, ItemCameraTransforms.TransformType transformType) {
        if (itemStack != null) {
            Item item = itemStack.getItem();
            Block block = Block.getBlockFromItem(item);
            GlStateManager.pushMatrix();
            if (this.itemRenderer.shouldRenderItemIn3D(itemStack)) {
                GlStateManager.scale(2.0f, 2.0f, 2.0f);
                if (this.isBlockTranslucent(block)) {
                    GlStateManager.depthMask(false);
                }
            }
            this.itemRenderer.renderItemModelForEntity(itemStack, entityLivingBase, transformType);
            if (this.isBlockTranslucent(block)) {
                GlStateManager.depthMask(true);
            }
            GlStateManager.popMatrix();
        }
    }

    private boolean isBlockTranslucent(Block block) {
        return block != null && block.getBlockLayer() == EnumWorldBlockLayer.TRANSLUCENT;
    }

    private void rotateArroundXAndY(float f, float f2) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(f2, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }

    private void setLightMapFromPlayer(AbstractClientPlayer abstractClientPlayer) {
        int n = this.mc.theWorld.getCombinedLight(new BlockPos(abstractClientPlayer.posX, abstractClientPlayer.posY + (double)abstractClientPlayer.getEyeHeight(), abstractClientPlayer.posZ), 0);
        float f = n & 0xFFFF;
        float f2 = n >> 16;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, f, f2);
    }

    private void rotateWithPlayerRotations(EntityPlayerSP entityPlayerSP, float f) {
        float f2 = entityPlayerSP.prevRenderArmPitch + (entityPlayerSP.renderArmPitch - entityPlayerSP.prevRenderArmPitch) * f;
        float f3 = entityPlayerSP.prevRenderArmYaw + (entityPlayerSP.renderArmYaw - entityPlayerSP.prevRenderArmYaw) * f;
        GlStateManager.rotate((entityPlayerSP.rotationPitch - f2) * 0.1f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate((entityPlayerSP.rotationYaw - f3) * 0.1f, 0.0f, 1.0f, 0.0f);
    }

    private float getMapAngleFromPitch(float f) {
        float f2 = 1.0f - f / 45.0f + 0.1f;
        f2 = MathHelper.clamp_float(f2, 0.0f, 1.0f);
        f2 = -MathHelper.cos(f2 * (float)Math.PI) * 0.5f + 0.5f;
        return f2;
    }

    private void renderRightArm(RenderPlayer renderPlayer) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(54.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(64.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(-62.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(0.25f, -0.85f, 0.75f);
        renderPlayer.renderRightArm(this.mc.thePlayer);
        GlStateManager.popMatrix();
    }

    private void renderLeftArm(RenderPlayer renderPlayer) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(92.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(41.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(-0.3f, -1.1f, 0.45f);
        renderPlayer.renderLeftArm(this.mc.thePlayer);
        GlStateManager.popMatrix();
    }

    private void renderPlayerArms(AbstractClientPlayer abstractClientPlayer) {
        this.mc.getTextureManager().bindTexture(abstractClientPlayer.getLocationSkin());
        Render render2 = this.renderManager.getEntityRenderObject(this.mc.thePlayer);
        RenderPlayer renderPlayer = (RenderPlayer)render2;
        if (!abstractClientPlayer.isInvisible()) {
            GlStateManager.disableCull();
            this.renderRightArm(renderPlayer);
            this.renderLeftArm(renderPlayer);
            GlStateManager.enableCull();
        }
    }

    private void renderItemMap(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        float f4 = -0.4f * MathHelper.sin(MathHelper.sqrt_float(f3) * (float)Math.PI);
        float f5 = 0.2f * MathHelper.sin(MathHelper.sqrt_float(f3) * (float)Math.PI * 2.0f);
        float f6 = -0.2f * MathHelper.sin(f3 * (float)Math.PI);
        GlStateManager.translate(f4, f5, f6);
        float f7 = this.getMapAngleFromPitch(f);
        GlStateManager.translate(0.0f, 0.04f, -0.72f);
        GlStateManager.translate(0.0f, f2 * -1.2f, 0.0f);
        GlStateManager.translate(0.0f, f7 * -0.5f, 0.0f);
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(f7 * -85.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(0.0f, 1.0f, 0.0f, 0.0f);
        this.renderPlayerArms(abstractClientPlayer);
        float f8 = MathHelper.sin(f3 * f3 * (float)Math.PI);
        float f9 = MathHelper.sin(MathHelper.sqrt_float(f3) * (float)Math.PI);
        GlStateManager.rotate(f8 * -20.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(f9 * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(f9 * -80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(0.38f, 0.38f, 0.38f);
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(0.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(-1.0f, -1.0f, 0.0f);
        GlStateManager.scale(0.015625f, 0.015625f, 0.015625f);
        this.mc.getTextureManager().bindTexture(RES_MAP_BACKGROUND);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(-7.0, 135.0, 0.0).tex(0.0, 1.0).endVertex();
        worldRenderer.pos(135.0, 135.0, 0.0).tex(1.0, 1.0).endVertex();
        worldRenderer.pos(135.0, -7.0, 0.0).tex(1.0, 0.0).endVertex();
        worldRenderer.pos(-7.0, -7.0, 0.0).tex(0.0, 0.0).endVertex();
        tessellator.draw();
        MapData mapData = Items.filled_map.getMapData(this.itemToRender, this.mc.theWorld);
        if (mapData != null) {
            this.mc.entityRenderer.getMapItemRenderer().renderMap(mapData, false);
        }
    }

    private void renderPlayerArm(AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        float f3 = -0.3f * MathHelper.sin(MathHelper.sqrt_float(f2) * (float)Math.PI);
        float f4 = 0.4f * MathHelper.sin(MathHelper.sqrt_float(f2) * (float)Math.PI * 2.0f);
        float f5 = -0.4f * MathHelper.sin(f2 * (float)Math.PI);
        GlStateManager.translate(f3, f4, f5);
        GlStateManager.translate(0.64000005f, -0.6f, -0.71999997f);
        GlStateManager.translate(0.0f, f * -0.6f, 0.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        float f6 = MathHelper.sin(f2 * f2 * (float)Math.PI);
        float f7 = MathHelper.sin(MathHelper.sqrt_float(f2) * (float)Math.PI);
        GlStateManager.rotate(f7 * 70.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(f6 * -20.0f, 0.0f, 0.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(abstractClientPlayer.getLocationSkin());
        GlStateManager.translate(-1.0f, 3.6f, 3.5f);
        GlStateManager.rotate(120.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(200.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        GlStateManager.translate(5.6f, 0.0f, 0.0f);
        Render render2 = this.renderManager.getEntityRenderObject(this.mc.thePlayer);
        GlStateManager.disableCull();
        RenderPlayer renderPlayer = (RenderPlayer)render2;
        renderPlayer.renderRightArm(this.mc.thePlayer);
        GlStateManager.enableCull();
    }

    private void doItemUsedTransformations(float f) {
        float f2 = -0.4f * MathHelper.sin(MathHelper.sqrt_float(f) * (float)Math.PI);
        float f3 = 0.2f * MathHelper.sin(MathHelper.sqrt_float(f) * (float)Math.PI * 2.0f);
        float f4 = -0.2f * MathHelper.sin(f * (float)Math.PI);
        GlStateManager.translate(f2, f3, f4);
    }

    private void performDrinking(AbstractClientPlayer abstractClientPlayer, float f) {
        float f2 = (float)abstractClientPlayer.getItemInUseCount() - f + 1.0f;
        float f3 = f2 / (float)this.itemToRender.getMaxItemUseDuration();
        float f4 = MathHelper.abs(MathHelper.cos(f2 / 4.0f * (float)Math.PI) * 0.1f);
        if (f3 >= 0.8f) {
            f4 = 0.0f;
        }
        GlStateManager.translate(0.0f, f4, 0.0f);
        float f5 = 1.0f - (float)Math.pow(f3, 27.0);
        GlStateManager.translate(f5 * 0.6f, f5 * -0.5f, f5 * 0.0f);
        GlStateManager.rotate(f5 * 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(f5 * 10.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(f5 * 30.0f, 0.0f, 0.0f, 1.0f);
    }

    private void transformFirstPersonItem(float f, float f2) {
        GlStateManager.translate(0.56f, -0.52f, -0.71999997f);
        GlStateManager.translate(0.0f, f * -0.6f, 0.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        float f3 = MathHelper.sin(f2 * f2 * (float)Math.PI);
        float f4 = MathHelper.sin(MathHelper.sqrt_float(f2) * (float)Math.PI);
        GlStateManager.rotate(f3 * -20.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(f4 * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(f4 * -80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(0.4f, 0.4f, 0.4f);
    }

    private void doBowTransformations(float f, AbstractClientPlayer abstractClientPlayer) {
        GlStateManager.rotate(-18.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(-12.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-8.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(-0.9f, 0.2f, 0.0f);
        float f2 = (float)this.itemToRender.getMaxItemUseDuration() - ((float)abstractClientPlayer.getItemInUseCount() - f + 1.0f);
        float f3 = f2 / 20.0f;
        f3 = (f3 * f3 + f3 * 2.0f) / 3.0f;
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f3 > 0.1f) {
            float f4 = MathHelper.sin((f2 - 0.1f) * 1.3f);
            float f5 = f3 - 0.1f;
            float f6 = f4 * f5;
            GlStateManager.translate(f6 * 0.0f, f6 * 0.01f, f6 * 0.0f);
        }
        GlStateManager.translate(f3 * 0.0f, f3 * 0.0f, f3 * 0.1f);
        GlStateManager.scale(1.0f, 1.0f, 1.0f + f3 * 0.2f);
    }

    private void doBlockTransformations() {
        GlStateManager.translate(-0.5f, 0.2f, 0.0f);
        GlStateManager.rotate(30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(60.0f, 0.0f, 1.0f, 0.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void renderItemInFirstPerson(float f) {
        this.mimeow$modifyRenderItemPre(f, new ocee33618a8d("renderItemInFirstPerson", false));
        try {
            float f2 = 1.0f - (this.prevEquippedProgress + (this.equippedProgress - this.prevEquippedProgress) * f);
            EntityPlayerSP entityPlayerSP = this.mc.thePlayer;
            float f3 = entityPlayerSP.getSwingProgress(f);
            float f4 = entityPlayerSP.prevRotationPitch + (entityPlayerSP.rotationPitch - entityPlayerSP.prevRotationPitch) * f;
            float f5 = entityPlayerSP.prevRotationYaw + (entityPlayerSP.rotationYaw - entityPlayerSP.prevRotationYaw) * f;
            this.rotateArroundXAndY(f4, f5);
            this.setLightMapFromPlayer(entityPlayerSP);
            this.rotateWithPlayerRotations(entityPlayerSP, f);
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            if (this.itemToRender != null) {
                if (this.itemToRender.getItem() == Items.filled_map) {
                    this.renderItemMap(entityPlayerSP, f4, f2, f3);
                } else if (this.mimeow$redirect$getItemInUseCountForRender(entityPlayerSP) > 0) {
                    EnumAction enumAction = this.itemToRender.getItemUseAction();
                    switch (enumAction) {
                        case NONE: {
                            float f6 = 0.0f;
                            this.mimeow$redirectTransformFirstPerson(this, f2, f6);
                            break;
                        }
                        case EAT: 
                        case DRINK: {
                            this.performDrinking(entityPlayerSP, f);
                            float f7 = 0.0f;
                            this.mimeow$redirectTransformFirstPerson(this, f2, f7);
                            break;
                        }
                        case BLOCK: {
                            float f8 = 0.0f;
                            this.mimeow$redirectTransformFirstPerson(this, f2, f8);
                            this.mimeow$redirectBlockTransformations(this);
                            break;
                        }
                        case BOW: {
                            float f9 = 0.0f;
                            this.mimeow$redirectTransformFirstPerson(this, f2, f9);
                            this.doBowTransformations(f, entityPlayerSP);
                        }
                    }
                } else {
                    this.doItemUsedTransformations(f3);
                    this.mimeow$redirectTransformFirstPerson(this, f2, f3);
                }
                this.renderItem(entityPlayerSP, this.itemToRender, ItemCameraTransforms.TransformType.FIRST_PERSON);
            } else {
                this.renderPlayerArm(entityPlayerSP, f2, f3);
            }
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
        }
        finally {
            this.mimeow$modifyRenderItemPost(f, new ocee33618a8d("renderItemInFirstPerson", false));
        }
    }

    public void renderOverlays(float f) {
        GlStateManager.disableAlpha();
        if (this.mc.thePlayer.isEntityInsideOpaqueBlock()) {
            IBlockState iBlockState = this.mc.theWorld.getBlockState(new BlockPos(this.mc.thePlayer));
            EntityPlayerSP entityPlayerSP = this.mc.thePlayer;
            for (int i = 0; i < 8; ++i) {
                double d = entityPlayerSP.posX + (double)(((float)((i >> 0) % 2) - 0.5f) * entityPlayerSP.width * 0.8f);
                double d2 = entityPlayerSP.posY + (double)(((float)((i >> 1) % 2) - 0.5f) * 0.1f);
                double d3 = entityPlayerSP.posZ + (double)(((float)((i >> 2) % 2) - 0.5f) * entityPlayerSP.width * 0.8f);
                BlockPos blockPos = new BlockPos(d, d2 + (double)entityPlayerSP.getEyeHeight(), d3);
                IBlockState iBlockState2 = this.mc.theWorld.getBlockState(blockPos);
                if (!iBlockState2.getBlock().isVisuallyOpaque()) continue;
                iBlockState = iBlockState2;
            }
            if (iBlockState.getBlock().getRenderType() != -1) {
                this.renderBlockInHand(f, this.mc.getBlockRendererDispatcher().getBlockModelShapes().getTexture(iBlockState));
            }
        }
        if (!this.mc.thePlayer.isSpectator()) {
            if (this.mc.thePlayer.isInsideOfMaterial(Material.water)) {
                this.renderWaterOverlayTexture(f);
            }
            if (this.mc.thePlayer.isBurning()) {
                this.renderFireInFirstPerson(f);
            }
        }
        GlStateManager.enableAlpha();
    }

    private void renderBlockInHand(float f, TextureAtlasSprite textureAtlasSprite) {
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        float f2 = 0.1f;
        GlStateManager.color(0.1f, 0.1f, 0.1f, 0.5f);
        GlStateManager.pushMatrix();
        float f3 = -1.0f;
        float f4 = 1.0f;
        float f5 = -1.0f;
        float f6 = 1.0f;
        float f7 = -0.5f;
        float f8 = textureAtlasSprite.getMinU();
        float f9 = textureAtlasSprite.getMaxU();
        float f10 = textureAtlasSprite.getMinV();
        float f11 = textureAtlasSprite.getMaxV();
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(-1.0, -1.0, -0.5).tex(f9, f11).endVertex();
        worldRenderer.pos(1.0, -1.0, -0.5).tex(f8, f11).endVertex();
        worldRenderer.pos(1.0, 1.0, -0.5).tex(f8, f10).endVertex();
        worldRenderer.pos(-1.0, 1.0, -0.5).tex(f9, f10).endVertex();
        tessellator.draw();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void renderWaterOverlayTexture(float f) {
        this.mc.getTextureManager().bindTexture(RES_UNDERWATER_OVERLAY);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        float f2 = this.mc.thePlayer.getBrightness(f);
        GlStateManager.color(f2, f2, f2, 0.5f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.pushMatrix();
        float f3 = 4.0f;
        float f4 = -1.0f;
        float f5 = 1.0f;
        float f6 = -1.0f;
        float f7 = 1.0f;
        float f8 = -0.5f;
        float f9 = -this.mc.thePlayer.rotationYaw / 64.0f;
        float f10 = this.mc.thePlayer.rotationPitch / 64.0f;
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(-1.0, -1.0, -0.5).tex(4.0f + f9, 4.0f + f10).endVertex();
        worldRenderer.pos(1.0, -1.0, -0.5).tex(0.0f + f9, 4.0f + f10).endVertex();
        worldRenderer.pos(1.0, 1.0, -0.5).tex(0.0f + f9, 0.0f + f10).endVertex();
        worldRenderer.pos(-1.0, 1.0, -0.5).tex(4.0f + f9, 0.0f + f10).endVertex();
        tessellator.draw();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
    }

    private void renderFireInFirstPerson(float f) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.9f);
        GlStateManager.depthFunc(519);
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        float f2 = 1.0f;
        for (int i = 0; i < 2; ++i) {
            GlStateManager.pushMatrix();
            TextureAtlasSprite textureAtlasSprite = this.mc.getTextureMapBlocks().getAtlasSprite("minecraft:blocks/fire_layer_1");
            this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            float f3 = textureAtlasSprite.getMinU();
            float f4 = textureAtlasSprite.getMaxU();
            float f5 = textureAtlasSprite.getMinV();
            float f6 = textureAtlasSprite.getMaxV();
            float f7 = (0.0f - f2) / 2.0f;
            float f8 = f7 + f2;
            float f9 = 0.0f - f2 / 2.0f;
            float f10 = f9 + f2;
            float f11 = -0.5f;
            GlStateManager.translate((float)(-(i * 2 - 1)) * 0.24f, -0.3f, 0.0f);
            GlStateManager.rotate((float)(i * 2 - 1) * 10.0f, 0.0f, 1.0f, 0.0f);
            worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
            worldRenderer.pos(f7, f9, f11).tex(f4, f6).endVertex();
            worldRenderer.pos(f8, f9, f11).tex(f3, f6).endVertex();
            worldRenderer.pos(f8, f10, f11).tex(f3, f5).endVertex();
            worldRenderer.pos(f7, f10, f11).tex(f4, f5).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(515);
    }

    public void updateEquippedItem() {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("updateEquippedItem", true);
        this.mimeow$onUpdateEquippedItem(ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            this.prevEquippedProgress = this.equippedProgress;
            EntityPlayerSP entityPlayerSP = this.mc.thePlayer;
            ItemStack itemStack = oc718fd4d503.\u014c.\u0435(entityPlayerSP.inventory);
            boolean bl = false;
            if (this.itemToRender != null && itemStack != null) {
                if (!this.itemToRender.getIsItemStackEqual(itemStack)) {
                    bl = true;
                }
            } else {
                bl = this.itemToRender != null || itemStack != null;
            }
            float f = 0.4f;
            float f2 = bl ? 0.0f : 1.0f;
            float f3 = MathHelper.clamp_float(f2 - this.equippedProgress, -f, f);
            this.equippedProgress += f3;
            if (this.equippedProgress < 0.1f) {
                this.itemToRender = itemStack;
                this.equippedItemSlot = entityPlayerSP.inventory.currentItem;
            }
        }
    }

    public void resetEquippedProgress() {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("resetEquippedProgress", true);
        this.mimeow$injectResetEquippedProgress(ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            this.equippedProgress = 0.0f;
        }
    }

    public void resetEquippedProgress2() {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("resetEquippedProgress2", true);
        this.mimeow$injectResetEquippedProgress2(ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            this.equippedProgress = 0.0f;
        }
    }

    private void mimeow$modifyRenderItemPre(float f, ocee33618a8d ocee33618a8d2) {
        this.originalItemToRender = this.itemToRender;
        this.itemToRender = oc7ab2161b9f.\u03de(this.originalItemToRender);
        if (this.itemToRender != null && (this.itemToRender.getItem() == null || this.itemToRender.stackSize <= 0)) {
            this.itemToRender = null;
        }
    }

    private void mimeow$modifyRenderItemPost(float f, ocee33618a8d ocee33618a8d2) {
        this.itemToRender = this.originalItemToRender;
    }

    private int mimeow$redirect$getItemInUseCountForRender(AbstractClientPlayer abstractClientPlayer) {
        int n = abstractClientPlayer.getItemInUseCount();
        return n <= 0 && this.isRenderItemInUse() && this.itemToRender != null ? (this.itemToRender.getItemUseAction() == EnumAction.BLOCK ? 1 : n) : n;
    }

    private void mimeow$redirectTransformFirstPerson(ItemRenderer itemRenderer, float f, float f2) {
        if (!oc743046ab41.\u03b7() || this.itemToRender == null || (Minecraft.getMinecraft().thePlayer.getItemInUseCount() <= 0 || this.itemToRender.getItemUseAction() != EnumAction.BLOCK) && !this.isRenderItemInUse()) {
            this.transformFirstPersonItem(f, f2);
        } else {
            float f3 = Minecraft.getMinecraft().thePlayer.getSwingProgress(Minecraft.getMinecraft().getTimer().renderPartialTicks);
            oc743046ab41.\u0271(f, f3);
        }
    }

    private void mimeow$redirectBlockTransformations(ItemRenderer itemRenderer) {
        if (!oc743046ab41.\u03b7()) {
            this.doBlockTransformations();
        }
    }

    private void mimeow$onUpdateEquippedItem(ocee33618a8d ocee33618a8d2) {
        if (this.cancelUpdate) {
            this.cancelUpdate = false;
            this.equippedProgress = 1.0f;
            this.prevEquippedProgress = 1.0f;
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    public void mimeow$injectResetEquippedProgress(ocee33618a8d ocee33618a8d2) {
        if (this.cancelReset) {
            this.cancelReset = false;
            this.equippedProgress = 1.0f;
            this.prevEquippedProgress = 1.0f;
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    public void mimeow$injectResetEquippedProgress2(ocee33618a8d ocee33618a8d2) {
        if (this.cancelReset) {
            this.cancelReset = false;
            this.equippedProgress = 1.0f;
            this.prevEquippedProgress = 1.0f;
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    @Override
    public void setCancelUpdate(boolean bl) {
        this.cancelUpdate = bl;
    }

    @Override
    public void setCancelReset(boolean bl) {
        this.cancelReset = bl;
    }

    @Override
    public boolean isRenderItemInUse() {
        return this.renderItemInUse || oc9755810e45.\u00ff != null && oc9755810e45.\u00ff.\u044a() && this.itemToRender != null && this.itemToRender.getItemUseAction() == EnumAction.BLOCK;
    }

    @Override
    public void setRenderItemInUse(boolean bl) {
        this.renderItemInUse = bl;
    }

    @Override
    public float getEquippedProgress() {
        return this.equippedProgress;
    }
}

