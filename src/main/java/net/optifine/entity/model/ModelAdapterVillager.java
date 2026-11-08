/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;

public class ModelAdapterVillager
extends ModelAdapter {
    public ModelAdapterVillager() {
        super(EntityVillager.class, "villager", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelVillager(0.0f);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelVillager)) {
            return null;
        }
        ModelVillager modelVillager = (ModelVillager)modelBase;
        return string.equals("head") ? modelVillager.villagerHead : (string.equals("body") ? modelVillager.villagerBody : (string.equals("arms") ? modelVillager.villagerArms : (string.equals("left_leg") ? modelVillager.leftVillagerLeg : (string.equals("right_leg") ? modelVillager.rightVillagerLeg : (string.equals("nose") ? modelVillager.villagerNose : null)))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "body", "arms", "right_leg", "left_leg", "nose"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderVillager renderVillager = new RenderVillager(renderManager);
        renderVillager.mainModel = modelBase;
        renderVillager.shadowSize = f;
        return renderVillager;
    }
}

