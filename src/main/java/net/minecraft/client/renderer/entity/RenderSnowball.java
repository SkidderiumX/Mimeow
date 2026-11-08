/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import x.oc4e1b577a95;

public class RenderSnowball<T extends Entity>
extends Render<T> {
    protected final Item field_177084_a;
    private final RenderItem field_177083_e;

    public RenderSnowball(RenderManager renderManager, Item item, RenderItem renderItem) {
        super(renderManager);
        this.field_177084_a = item;
        this.field_177083_e = renderItem;
    }

    @Override
    public void doRender(T t, double d, double d2, double d3, float f, float f2) {
        if (oc4e1b577a95.\u040d() && ((Entity)t).ticksExisted < 2) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)d, (float)d2, (float)d3);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        this.bindTexture(TextureMap.locationBlocksTexture);
        this.field_177083_e.renderItem(this.func_177082_d(t), ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(t, d, d2, d3, f, f2);
    }

    public ItemStack func_177082_d(T t) {
        return new ItemStack(this.field_177084_a, 1, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return TextureMap.locationBlocksTexture;
    }
}

