/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterEnderCrystal
extends ModelAdapter {
    public ModelAdapterEnderCrystal() {
        this("end_crystal");
    }

    protected ModelAdapterEnderCrystal(String string) {
        super(EntityEnderCrystal.class, string, 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelEnderCrystal(0.0f, true);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelEnderCrystal)) {
            return null;
        }
        ModelEnderCrystal modelEnderCrystal = (ModelEnderCrystal)modelBase;
        return string.equals("cube") ? (ModelRenderer)Reflector.getFieldValue(modelEnderCrystal, Reflector.ModelEnderCrystal_ModelRenderers, 0) : (string.equals("glass") ? (ModelRenderer)Reflector.getFieldValue(modelEnderCrystal, Reflector.ModelEnderCrystal_ModelRenderers, 1) : (string.equals("base") ? (ModelRenderer)Reflector.getFieldValue(modelEnderCrystal, Reflector.ModelEnderCrystal_ModelRenderers, 2) : null));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"cube", "glass", "base"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        Render render2 = renderManager.getEntityRenderMap().get(EntityEnderCrystal.class);
        if (!(render2 instanceof RenderEnderCrystal)) {
            Config.warn("Not an instance of RenderEnderCrystal: " + String.valueOf(render2));
            return null;
        }
        RenderEnderCrystal renderEnderCrystal = (RenderEnderCrystal)render2;
        if (!Reflector.RenderEnderCrystal_modelEnderCrystal.exists()) {
            Config.warn("Field not found: RenderEnderCrystal.modelEnderCrystal");
            return null;
        }
        Reflector.setFieldValue(renderEnderCrystal, Reflector.RenderEnderCrystal_modelEnderCrystal, modelBase);
        renderEnderCrystal.shadowSize = f;
        return renderEnderCrystal;
    }
}

