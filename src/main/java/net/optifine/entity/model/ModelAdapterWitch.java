/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.EntityWitch;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterWitch
extends ModelAdapter {
    public ModelAdapterWitch() {
        super(EntityWitch.class, "witch", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelWitch(0.0f);
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelWitch)) {
            return null;
        }
        ModelWitch modelWitch = (ModelWitch)modelBase;
        return string.equals("mole") ? (ModelRenderer)Reflector.getFieldValue(modelWitch, Reflector.ModelWitch_mole) : (string.equals("hat") ? (ModelRenderer)Reflector.getFieldValue(modelWitch, Reflector.ModelWitch_hat) : (string.equals("head") ? modelWitch.villagerHead : (string.equals("body") ? modelWitch.villagerBody : (string.equals("arms") ? modelWitch.villagerArms : (string.equals("left_leg") ? modelWitch.leftVillagerLeg : (string.equals("right_leg") ? modelWitch.rightVillagerLeg : (string.equals("nose") ? modelWitch.villagerNose : null)))))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"mole", "head", "body", "arms", "right_leg", "left_leg", "nose"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderWitch renderWitch = new RenderWitch(renderManager);
        renderWitch.mainModel = modelBase;
        renderWitch.shadowSize = f;
        return renderWitch;
    }
}

