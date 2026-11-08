/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelGuardian;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderGuardian;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterGuardian
extends ModelAdapter {
    public ModelAdapterGuardian() {
        super(EntityGuardian.class, "guardian", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelGuardian();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelGuardian)) {
            return null;
        }
        ModelGuardian modelGuardian = (ModelGuardian)modelBase;
        if (string.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(modelGuardian, Reflector.ModelGuardian_body);
        }
        if (string.equals("eye")) {
            return (ModelRenderer)Reflector.getFieldValue(modelGuardian, Reflector.ModelGuardian_eye);
        }
        String string2 = "spine";
        if (string.startsWith(string2)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelGuardian, Reflector.ModelGuardian_spines);
            if (modelRendererArray == null) {
                return null;
            }
            String string3 = string.substring(string2.length());
            int n = Config.parseInt(string3, -1);
            return --n >= 0 && n < modelRendererArray.length ? modelRendererArray[n] : null;
        }
        String string4 = "tail";
        if (string.startsWith(string4)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelGuardian, Reflector.ModelGuardian_tail);
            if (modelRendererArray == null) {
                return null;
            }
            String string5 = string.substring(string4.length());
            int n = Config.parseInt(string5, -1);
            return --n >= 0 && n < modelRendererArray.length ? modelRendererArray[n] : null;
        }
        return null;
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"body", "eye", "spine1", "spine2", "spine3", "spine4", "spine5", "spine6", "spine7", "spine8", "spine9", "spine10", "spine11", "spine12", "tail1", "tail2", "tail3"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderGuardian renderGuardian = new RenderGuardian(renderManager);
        renderGuardian.mainModel = modelBase;
        renderGuardian.shadowSize = f;
        return renderGuardian;
    }
}

