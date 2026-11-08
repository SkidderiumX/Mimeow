/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import x.oc4e1b577a95;
import x.oc8c060e26d1;
import x.occc57954425;
import x.oce4a7521312;
import x.ocee33618a8d;

public class RenderEntityItem
extends Render<EntityItem> {
    private final RenderItem itemRenderer;
    private Random field_177079_e = new Random();
    private static final Random itemPhysics$random = new Random();
    private static long itemPhysics$lastNano = System.nanoTime();
    private static double itemPhysics$rotation;

    public RenderEntityItem(RenderManager renderManager, RenderItem renderItem) {
        super(renderManager);
        this.itemRenderer = renderItem;
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }

    private int func_177077_a(EntityItem entityItem, double d, double d2, double d3, float f, IBakedModel iBakedModel) {
        float f2;
        ItemStack itemStack = entityItem.getEntityItem();
        Item item = itemStack.getItem();
        if (item == null) {
            return 0;
        }
        boolean bl = iBakedModel.isGui3d();
        int n = this.func_177078_a(itemStack);
        float f3 = 0.25f;
        boolean bl2 = oc4e1b577a95.\u0514();
        float f4 = bl2 ? 0.0f : MathHelper.sin(((float)entityItem.getAge() + f) / 10.0f + entityItem.hoverStart) * 0.1f + 0.1f;
        float f5 = iBakedModel.getItemCameraTransforms().getTransform((ItemCameraTransforms.TransformType)ItemCameraTransforms.TransformType.GROUND).scale.y;
        GlStateManager.translate((float)d, (float)d2 + f4 + 0.25f * f5, (float)d3);
        if (!bl2 && (bl || this.renderManager.options != null)) {
            f2 = (((float)entityItem.getAge() + f) / 20.0f + entityItem.hoverStart) * 57.295776f;
            GlStateManager.rotate(f2, 0.0f, 1.0f, 0.0f);
        }
        if (!bl) {
            f2 = -0.0f * (float)(n - 1) * 0.5f;
            float f6 = -0.0f * (float)(n - 1) * 0.5f;
            float f7 = -0.046875f * (float)(n - 1) * 0.5f;
            GlStateManager.translate(f2, f6, f7);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        return n;
    }

    private int func_177078_a(ItemStack itemStack) {
        if (oc4e1b577a95.\u00f2()) {
            return 1;
        }
        int n = 1;
        if (itemStack.stackSize > 48) {
            n = 5;
        } else if (itemStack.stackSize > 32) {
            n = 4;
        } else if (itemStack.stackSize > 16) {
            n = 3;
        } else if (itemStack.stackSize > 1) {
            n = 2;
        }
        return n;
    }

    @Override
    public void doRender(EntityItem entityItem, double d, double d2, double d3, float f, float f2) {
        if (occc57954425.z(entityItem)) {
            return;
        }
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("doRender", true);
        this.mimeow$itemPhysics$doRender(entityItem, d, d2, d3, f, f2, ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            ItemStack itemStack = entityItem.getEntityItem();
            this.field_177079_e.setSeed(187L);
            boolean bl = false;
            if (this.bindEntityTexture(entityItem)) {
                this.renderManager.renderEngine.getTexture(this.getEntityTexture(entityItem)).setBlurMipmap(false, false);
                bl = true;
            }
            GlStateManager.enableRescaleNormal();
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.pushMatrix();
            IBakedModel iBakedModel = this.itemRenderer.getItemModelMesher().getItemModel(itemStack);
            int n = this.func_177077_a(entityItem, d, d2, d3, f2, iBakedModel);
            for (int i = 0; i < n; ++i) {
                float f3;
                float f4;
                float f5;
                if (iBakedModel.isGui3d()) {
                    GlStateManager.pushMatrix();
                    if (i > 0) {
                        f5 = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                        f4 = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                        f3 = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                        GlStateManager.translate(f5, f4, f3);
                    }
                    GlStateManager.scale(0.5f, 0.5f, 0.5f);
                    iBakedModel.getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GROUND);
                    this.itemRenderer.renderItem(itemStack, iBakedModel);
                    GlStateManager.popMatrix();
                    continue;
                }
                GlStateManager.pushMatrix();
                iBakedModel.getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GROUND);
                this.itemRenderer.renderItem(itemStack, iBakedModel);
                GlStateManager.popMatrix();
                f5 = iBakedModel.getItemCameraTransforms().ground.scale.x;
                f4 = iBakedModel.getItemCameraTransforms().ground.scale.y;
                f3 = iBakedModel.getItemCameraTransforms().ground.scale.z;
                GlStateManager.translate(0.0f * f5, 0.0f * f4, 0.046875f * f3);
            }
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
            this.bindEntityTexture(entityItem);
            if (bl) {
                this.renderManager.renderEngine.getTexture(this.getEntityTexture(entityItem)).restoreLastBlurMipmap();
            }
            super.doRender(entityItem, d, d2, d3, f, f2);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityItem entityItem) {
        return TextureMap.locationBlocksTexture;
    }

    private void mimeow$itemPhysics$doRender(EntityItem entityItem, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        if (oc8c060e26d1.\u04bd != null) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
            Minecraft minecraft = Minecraft.getMinecraft();
            RenderEntityItem renderEntityItem = this;
            double d4 = oc8c060e26d1.\u04bd.\u0450.\u04c1();
            itemPhysics$rotation = (double)(System.nanoTime() - itemPhysics$lastNano) / 2500000.0 * d4;
            if (!minecraft.isGamePaused()) {
                itemPhysics$lastNano = System.nanoTime();
            } else {
                itemPhysics$rotation = 0.0;
            }
            ItemStack itemStack = entityItem.getEntityItem();
            if (itemStack != null && itemStack.getItem() != null) {
                int n = Item.getIdFromItem(itemStack.getItem()) + itemStack.getMetadata();
                itemPhysics$random.setSeed(n);
                this.bindTexture(TextureMap.locationBlocksTexture);
                this.getRenderManager().renderEngine.getTexture(TextureMap.locationBlocksTexture).setBlurMipmap(false, false);
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(516, 0.1f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.pushMatrix();
                IBakedModel iBakedModel = minecraft.getRenderItem().getItemModelMesher().getItemModel(itemStack);
                boolean bl = iBakedModel.isGui3d();
                int n2 = RenderEntityItem.itemPhysics$getModelCount(itemStack);
                GlStateManager.translate((float)d, (float)d2, (float)d3);
                if (bl) {
                    GlStateManager.scale(0.5f, 0.5f, 0.5f);
                }
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(entityItem.rotationYaw, 0.0f, 0.0f, 1.0f);
                if (bl) {
                    GlStateManager.translate(0.0, 0.0, -0.08);
                } else {
                    GlStateManager.translate(0.0, 0.0, -0.04);
                }
                if (!entityItem.onGround) {
                    double d5 = itemPhysics$rotation * 2.0;
                    entityItem.rotationPitch += (float)d5;
                } else if (!bl) {
                    entityItem.rotationPitch = 0.0f;
                }
                if (bl || minecraft.getRenderManager().options != null) {
                    GlStateManager.rotate(entityItem.rotationPitch, 1.0f, 0.0f, 0.0f);
                }
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                for (int i = 0; i < n2; ++i) {
                    GlStateManager.pushMatrix();
                    if (!bl) {
                        iBakedModel = oce4a7521312.\u0203(iBakedModel, ItemCameraTransforms.TransformType.GROUND);
                        minecraft.getRenderItem().renderItem(itemStack, iBakedModel);
                        GlStateManager.popMatrix();
                        GlStateManager.translate(0.0f, 0.0f, 0.05375f);
                        continue;
                    }
                    if (i > 0) {
                        float f3 = (itemPhysics$random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                        float f4 = (itemPhysics$random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                        float f5 = (itemPhysics$random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                        GlStateManager.translate(renderEntityItem.getRenderManager().options != null && renderEntityItem.getRenderManager().options.fancyGraphics ? f3 : 0.0f, renderEntityItem.getRenderManager().options != null && renderEntityItem.getRenderManager().options.fancyGraphics ? f4 : 0.0f, f5);
                    }
                    iBakedModel = oce4a7521312.\u0203(iBakedModel, ItemCameraTransforms.TransformType.GROUND);
                    minecraft.getRenderItem().renderItem(itemStack, iBakedModel);
                    GlStateManager.popMatrix();
                }
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
                renderEntityItem.bindTexture(TextureMap.locationBlocksTexture);
                renderEntityItem.getRenderManager().renderEngine.getTexture(TextureMap.locationBlocksTexture).restoreLastBlurMipmap();
            }
        }
    }

    private static int itemPhysics$getModelCount(ItemStack itemStack) {
        return itemStack.stackSize > 48 ? 5 : (itemStack.stackSize > 32 ? 4 : (itemStack.stackSize > 16 ? 3 : (itemStack.stackSize > 1 ? 2 : 1)));
    }
}

