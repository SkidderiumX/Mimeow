/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.passive.EntityOcelot;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterOcelot
extends ModelAdapter {
    private static Map<String, Integer> mapPartFields = null;

    public ModelAdapterOcelot() {
        super(EntityOcelot.class, "ocelot", 0.4f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelOcelot();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelOcelot)) {
            return null;
        }
        ModelOcelot modelOcelot = (ModelOcelot)modelBase;
        Map<String, Integer> map = ModelAdapterOcelot.getMapPartFields();
        if (map.containsKey(string)) {
            int n = map.get(string);
            return (ModelRenderer)Reflector.getFieldValue(modelOcelot, Reflector.ModelOcelot_ModelRenderers, n);
        }
        return null;
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"back_left_leg", "back_right_leg", "front_left_leg", "front_right_leg", "tail", "tail2", "head", "body"};
    }

    private static Map<String, Integer> getMapPartFields() {
        if (mapPartFields != null) {
            return mapPartFields;
        }
        mapPartFields = new HashMap<String, Integer>();
        mapPartFields.put("back_left_leg", 0);
        mapPartFields.put("back_right_leg", 1);
        mapPartFields.put("front_left_leg", 2);
        mapPartFields.put("front_right_leg", 3);
        mapPartFields.put("tail", 4);
        mapPartFields.put("tail2", 5);
        mapPartFields.put("head", 6);
        mapPartFields.put("body", 7);
        return mapPartFields;
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderOcelot renderOcelot = new RenderOcelot(renderManager, modelBase, f);
        return renderOcelot;
    }
}

