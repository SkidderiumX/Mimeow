/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;

public class LayerBipedArmor
extends LayerArmorBase<ModelBiped> {
    public LayerBipedArmor(RendererLivingEntity<?> rendererLivingEntity) {
        super(rendererLivingEntity);
    }

    @Override
    protected void initArmor() {
        this.modelLeggings = new ModelBiped(0.5f);
        this.modelArmor = new ModelBiped(1.0f);
    }

    @Override
    protected void setModelPartVisible(ModelBiped modelBiped, int n) {
        this.setModelVisible(modelBiped);
        switch (n) {
            case 1: {
                modelBiped.bipedRightLeg.showModel = true;
                modelBiped.bipedLeftLeg.showModel = true;
                break;
            }
            case 2: {
                modelBiped.bipedBody.showModel = true;
                modelBiped.bipedRightLeg.showModel = true;
                modelBiped.bipedLeftLeg.showModel = true;
                break;
            }
            case 3: {
                modelBiped.bipedBody.showModel = true;
                modelBiped.bipedRightArm.showModel = true;
                modelBiped.bipedLeftArm.showModel = true;
                break;
            }
            case 4: {
                modelBiped.bipedHead.showModel = true;
                modelBiped.bipedHeadwear.showModel = true;
            }
        }
    }

    protected void setModelVisible(ModelBiped modelBiped) {
        modelBiped.setInvisible(false);
    }
}

