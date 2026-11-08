/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelArmorStand;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapterBiped;

public class ModelAdapterArmorStand
extends ModelAdapterBiped {
    public ModelAdapterArmorStand() {
        super(EntityArmorStand.class, "armor_stand", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelArmorStand();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelArmorStand)) {
            return null;
        }
        ModelArmorStand modelArmorStand = (ModelArmorStand)modelBase;
        return string.equals("right") ? modelArmorStand.standRightSide : (string.equals("left") ? modelArmorStand.standLeftSide : (string.equals("waist") ? modelArmorStand.standWaist : (string.equals("base") ? modelArmorStand.standBase : super.getModelRenderer(modelArmorStand, string))));
    }

    @Override
    public String[] getModelRendererNames() {
        Object[] objectArray = super.getModelRendererNames();
        objectArray = (String[])Config.addObjectsToArray(objectArray, new String[]{"right", "left", "waist", "base"});
        return objectArray;
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        ArmorStandRenderer armorStandRenderer = new ArmorStandRenderer(renderManager);
        armorStandRenderer.mainModel = modelBase;
        armorStandRenderer.shadowSize = f;
        return armorStandRenderer;
    }
}

