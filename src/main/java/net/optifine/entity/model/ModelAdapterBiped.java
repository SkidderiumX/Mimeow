/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.optifine.entity.model.ModelAdapter;

public abstract class ModelAdapterBiped
extends ModelAdapter {
    public ModelAdapterBiped(Class clazz, String string, float f) {
        super(clazz, string, f);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelBiped)) {
            return null;
        }
        ModelBiped modelBiped = (ModelBiped)modelBase;
        return string.equals("head") ? modelBiped.bipedHead : (string.equals("headwear") ? modelBiped.bipedHeadwear : (string.equals("body") ? modelBiped.bipedBody : (string.equals("left_arm") ? modelBiped.bipedLeftArm : (string.equals("right_arm") ? modelBiped.bipedRightArm : (string.equals("left_leg") ? modelBiped.bipedLeftLeg : (string.equals("right_leg") ? modelBiped.bipedRightLeg : null))))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "headwear", "body", "left_arm", "right_arm", "left_leg", "right_leg"};
    }
}

