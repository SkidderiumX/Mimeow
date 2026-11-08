/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelLeashKnot;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderLeashKnot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterLeadKnot
extends ModelAdapter {
    public ModelAdapterLeadKnot() {
        super(EntityLeashKnot.class, "lead_knot", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelLeashKnot();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelLeashKnot)) {
            return null;
        }
        ModelLeashKnot modelLeashKnot = (ModelLeashKnot)modelBase;
        return string.equals("knot") ? modelLeashKnot.field_110723_a : null;
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"knot"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderLeashKnot renderLeashKnot = new RenderLeashKnot(renderManager);
        if (!Reflector.RenderLeashKnot_leashKnotModel.exists()) {
            Config.warn("Field not found: RenderLeashKnot.leashKnotModel");
            return null;
        }
        Reflector.setFieldValue(renderLeashKnot, Reflector.RenderLeashKnot_leashKnotModel, modelBase);
        renderLeashKnot.shadowSize = f;
        return renderLeashKnot;
    }
}

