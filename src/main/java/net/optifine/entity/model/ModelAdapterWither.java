/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWither;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterWither
extends ModelAdapter {
    public ModelAdapterWither() {
        super(EntityWither.class, "wither", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelWither(0.0f);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelWither)) {
            return null;
        }
        ModelWither modelWither = (ModelWither)modelBase;
        String string2 = "body";
        if (string.startsWith(string2)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelWither, Reflector.ModelWither_bodyParts);
            if (modelRendererArray == null) {
                return null;
            }
            String string3 = string.substring(string2.length());
            int n = Config.parseInt(string3, -1);
            return --n >= 0 && n < modelRendererArray.length ? modelRendererArray[n] : null;
        }
        String string4 = "head";
        if (string.startsWith(string4)) {
            ModelRenderer[] modelRendererArray = (ModelRenderer[])Reflector.getFieldValue(modelWither, Reflector.ModelWither_heads);
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
        return new String[]{"body1", "body2", "body3", "head1", "head2", "head3"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderWither renderWither = new RenderWither(renderManager);
        renderWither.mainModel = modelBase;
        renderWither.shadowSize = f;
        return renderWither;
    }
}

