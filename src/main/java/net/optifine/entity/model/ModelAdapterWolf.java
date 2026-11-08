/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityWolf;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterWolf
extends ModelAdapter {
    public ModelAdapterWolf() {
        super(EntityWolf.class, "wolf", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelWolf();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelWolf)) {
            return null;
        }
        ModelWolf modelWolf = (ModelWolf)modelBase;
        return string.equals("head") ? modelWolf.wolfHeadMain : (string.equals("body") ? modelWolf.wolfBody : (string.equals("leg1") ? modelWolf.wolfLeg1 : (string.equals("leg2") ? modelWolf.wolfLeg2 : (string.equals("leg3") ? modelWolf.wolfLeg3 : (string.equals("leg4") ? modelWolf.wolfLeg4 : (string.equals("tail") ? (ModelRenderer)Reflector.getFieldValue(modelWolf, Reflector.ModelWolf_tail) : (string.equals("mane") ? (ModelRenderer)Reflector.getFieldValue(modelWolf, Reflector.ModelWolf_mane) : null)))))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "body", "leg1", "leg2", "leg3", "leg4", "tail", "mane"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderWolf renderWolf = new RenderWolf(renderManager, modelBase, f);
        return renderWolf;
    }
}

