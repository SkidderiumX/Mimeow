/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterMinecart
extends ModelAdapter {
    public ModelAdapterMinecart() {
        super(EntityMinecart.class, "minecart", 0.5f);
    }

    protected ModelAdapterMinecart(Class clazz, String string, float f) {
        super(clazz, string, f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelMinecart();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelMinecart)) {
            return null;
        }
        ModelMinecart modelMinecart = (ModelMinecart)modelBase;
        return string.equals("bottom") ? modelMinecart.sideModels[0] : (string.equals("back") ? modelMinecart.sideModels[1] : (string.equals("front") ? modelMinecart.sideModels[2] : (string.equals("right") ? modelMinecart.sideModels[3] : (string.equals("left") ? modelMinecart.sideModels[4] : (string.equals("dirt") ? modelMinecart.sideModels[5] : null)))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"bottom", "back", "front", "right", "left", "dirt"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderMinecart renderMinecart = new RenderMinecart(renderManager);
        if (!Reflector.RenderMinecart_modelMinecart.exists()) {
            Config.warn("Field not found: RenderMinecart.modelMinecart");
            return null;
        }
        Reflector.setFieldValue(renderMinecart, Reflector.RenderMinecart_modelMinecart, modelBase);
        renderMinecart.shadowSize = f;
        return renderMinecart;
    }
}

