/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterSilverfish
extends ModelAdapter {
    public ModelAdapterSilverfish() {
        super(EntitySilverfish.class, "silverfish", 0.3f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelSilverfish();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelSilverfish)) {
            return null;
        }
        ModelSilverfish modelSilverfish = (ModelSilverfish)modelBase;
        String string2 = "body";
        if (string.startsWith(string2)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelSilverfish, Reflector.ModelSilverfish_bodyParts);
            if (modelRendererArray == null) {
                return null;
            }
            String string3 = string.substring(string2.length());
            int n = Config.parseInt(string3, -1);
            return --n >= 0 && n < modelRendererArray.length ? modelRendererArray[n] : null;
        }
        String string4 = "wing";
        if (string.startsWith(string4)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelSilverfish, Reflector.ModelSilverfish_wingParts);
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
        return new String[]{"body1", "body2", "body3", "body4", "body5", "body6", "body7", "wing1", "wing2", "wing3"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderSilverfish renderSilverfish = new RenderSilverfish(renderManager);
        renderSilverfish.mainModel = modelBase;
        renderSilverfish.shadowSize = f;
        return renderSilverfish;
    }
}

