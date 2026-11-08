/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderMagmaCube;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterMagmaCube
extends ModelAdapter {
    public ModelAdapterMagmaCube() {
        super(EntityMagmaCube.class, "magma_cube", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelMagmaCube();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelMagmaCube)) {
            return null;
        }
        ModelMagmaCube modelMagmaCube = (ModelMagmaCube)modelBase;
        if (string.equals("core")) {
            return (ModelRenderer)Reflector.getFieldValue(modelMagmaCube, Reflector.ModelMagmaCube_core);
        }
        String string2 = "segment";
        if (string.startsWith(string2)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelMagmaCube, Reflector.ModelMagmaCube_segments);
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
        return new String[]{"core", "segment1", "segment2", "segment3", "segment4", "segment5", "segment6", "segment7", "segment8"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderMagmaCube renderMagmaCube = new RenderMagmaCube(renderManager);
        renderMagmaCube.mainModel = modelBase;
        renderMagmaCube.shadowSize = f;
        return renderMagmaCube;
    }
}

