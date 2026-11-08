/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.optifine.entity.model.ModelAdapter;

public abstract class ModelAdapterQuadruped
extends ModelAdapter {
    public ModelAdapterQuadruped(Class clazz, String string, float f) {
        super(clazz, string, f);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelQuadruped)) {
            return null;
        }
        ModelQuadruped modelQuadruped = (ModelQuadruped)modelBase;
        return string.equals("head") ? modelQuadruped.head : (string.equals("body") ? modelQuadruped.body : (string.equals("leg1") ? modelQuadruped.leg1 : (string.equals("leg2") ? modelQuadruped.leg2 : (string.equals("leg3") ? modelQuadruped.leg3 : (string.equals("leg4") ? modelQuadruped.leg4 : null)))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "body", "leg1", "leg2", "leg3", "leg4"};
    }
}

