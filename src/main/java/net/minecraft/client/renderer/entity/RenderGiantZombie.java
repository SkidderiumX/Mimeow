/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

public class RenderGiantZombie
extends RenderLiving<EntityGiantZombie> {
    private static final ResourceLocation zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
    private float scale;

    public RenderGiantZombie(RenderManager renderManager, ModelBase modelBase, float f, float f2) {
        super(renderManager, modelBase, f * f2);
        this.scale = f2;
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this){

            @Override
            protected void initArmor() {
                this.modelLeggings = new ModelZombie(0.5f, true);
                this.modelArmor = new ModelZombie(1.0f, true);
            }
        });
    }

    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }

    @Override
    protected void preRenderCallback(EntityGiantZombie entityGiantZombie, float f) {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGiantZombie entityGiantZombie) {
        return zombieTextures;
    }
}

