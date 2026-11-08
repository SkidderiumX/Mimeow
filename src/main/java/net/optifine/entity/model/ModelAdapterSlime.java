/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterSlime
extends ModelAdapter {
    public ModelAdapterSlime() {
        super(EntitySlime.class, "slime", 0.25f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelSlime(16);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelSlime)) {
            return null;
        }
        ModelSlime modelSlime = (ModelSlime)modelBase;
        return string.equals("body") ? (ModelRenderer)Reflector.getFieldValue(modelSlime, Reflector.ModelSlime_ModelRenderers, 0) : (string.equals("left_eye") ? (ModelRenderer)Reflector.getFieldValue(modelSlime, Reflector.ModelSlime_ModelRenderers, 1) : (string.equals("right_eye") ? (ModelRenderer)Reflector.getFieldValue(modelSlime, Reflector.ModelSlime_ModelRenderers, 2) : (string.equals("mouth") ? (ModelRenderer)Reflector.getFieldValue(modelSlime, Reflector.ModelSlime_ModelRenderers, 3) : null)));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"body", "left_eye", "right_eye", "mouth"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderSlime renderSlime = new RenderSlime(renderManager, modelBase, f);
        return renderSlime;
    }
}

