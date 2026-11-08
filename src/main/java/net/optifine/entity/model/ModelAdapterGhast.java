/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelGhast;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterGhast
extends ModelAdapter {
    public ModelAdapterGhast() {
        super(EntityGhast.class, "ghast", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelGhast();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelGhast)) {
            return null;
        }
        ModelGhast modelGhast = (ModelGhast)modelBase;
        if (string.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(modelGhast, Reflector.ModelGhast_body);
        }
        String string2 = "tentacle";
        if (string.startsWith(string2)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelGhast, Reflector.ModelGhast_tentacles);
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
        return new String[]{"body", "tentacle1", "tentacle2", "tentacle3", "tentacle4", "tentacle5", "tentacle6", "tentacle7", "tentacle8", "tentacle9"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderGhast renderGhast = new RenderGhast(renderManager);
        renderGhast.mainModel = modelBase;
        renderGhast.shadowSize = f;
        return renderGhast;
    }
}

