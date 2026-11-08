/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderMite;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderEndermite;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterEndermite
extends ModelAdapter {
    public ModelAdapterEndermite() {
        super(EntityEndermite.class, "endermite", 0.3f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelEnderMite();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelEnderMite)) {
            return null;
        }
        ModelEnderMite modelEnderMite = (ModelEnderMite)modelBase;
        String string2 = "body";
        if (string.startsWith(string2)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelEnderMite, Reflector.ModelEnderMite_bodyParts);
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
        return new String[]{"body1", "body2", "body3", "body4"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderEndermite renderEndermite = new RenderEndermite(renderManager);
        renderEndermite.mainModel = modelBase;
        renderEndermite.shadowSize = f;
        return renderEndermite;
    }
}

