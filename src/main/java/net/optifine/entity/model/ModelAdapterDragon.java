/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.EntityDragon;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterDragon
extends ModelAdapter {
    public ModelAdapterDragon() {
        super(EntityDragon.class, "dragon", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelDragon(0.0f);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelDragon)) {
            return null;
        }
        ModelDragon modelDragon = (ModelDragon)modelBase;
        return string.equals("head") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 0) : (string.equals("spine") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 1) : (string.equals("jaw") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 2) : (string.equals("body") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 3) : (string.equals("rear_leg") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 4) : (string.equals("front_leg") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 5) : (string.equals("rear_leg_tip") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 6) : (string.equals("front_leg_tip") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 7) : (string.equals("rear_foot") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 8) : (string.equals("front_foot") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 9) : (string.equals("wing") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 10) : (string.equals("wing_tip") ? (ModelRenderer)Reflector.getFieldValue(modelDragon, Reflector.ModelDragon_ModelRenderers, 11) : null)))))))))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "spine", "jaw", "body", "rear_leg", "front_leg", "rear_leg_tip", "front_leg_tip", "rear_foot", "front_foot", "wing", "wing_tip"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderDragon renderDragon = new RenderDragon(renderManager);
        renderDragon.mainModel = modelBase;
        renderDragon.shadowSize = f;
        return renderDragon;
    }
}

