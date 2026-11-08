/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterBoat
extends ModelAdapter {
    public ModelAdapterBoat() {
        super(EntityBoat.class, "boat", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelBoat();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelBoat)) {
            return null;
        }
        ModelBoat modelBoat = (ModelBoat)modelBase;
        return string.equals("bottom") ? modelBoat.boatSides[0] : (string.equals("back") ? modelBoat.boatSides[1] : (string.equals("front") ? modelBoat.boatSides[2] : (string.equals("right") ? modelBoat.boatSides[3] : (string.equals("left") ? modelBoat.boatSides[4] : null))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"bottom", "back", "front", "right", "left"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderBoat renderBoat = new RenderBoat(renderManager);
        if (!Reflector.RenderBoat_modelBoat.exists()) {
            Config.warn("Field not found: RenderBoat.modelBoat");
            return null;
        }
        Reflector.setFieldValue(renderBoat, Reflector.RenderBoat_modelBoat, modelBase);
        renderBoat.shadowSize = f;
        return renderBoat;
    }
}

