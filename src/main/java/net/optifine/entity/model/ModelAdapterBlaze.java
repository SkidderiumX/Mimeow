/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterBlaze
extends ModelAdapter {
    public ModelAdapterBlaze() {
        super(EntityBlaze.class, "blaze", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelBlaze();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelBlaze)) {
            return null;
        }
        ModelBlaze modelBlaze = (ModelBlaze)modelBase;
        if (string.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(modelBlaze, Reflector.ModelBlaze_blazeHead);
        }
        String string2 = "stick";
        if (string.startsWith(string2)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelBlaze, Reflector.ModelBlaze_blazeSticks);
            if (modelRendererArray == null) {
                return null;
            }
            String string3 = string.substring(string2.length());
            int n = Config.parseInt(string3, -1);
            return --n >= 0 && n < modelRendererArray.length ? modelRendererArray[n] : null;
        }
        return null;
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "stick1", "stick2", "stick3", "stick4", "stick5", "stick6", "stick7", "stick8", "stick9", "stick10", "stick11", "stick12"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderBlaze renderBlaze = new RenderBlaze(renderManager);
        renderBlaze.mainModel = modelBase;
        renderBlaze.shadowSize = f;
        return renderBlaze;
    }
}

