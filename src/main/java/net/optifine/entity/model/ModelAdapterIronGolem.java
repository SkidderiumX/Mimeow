/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityIronGolem;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;

public class ModelAdapterIronGolem
extends ModelAdapter {
    public ModelAdapterIronGolem() {
        super(EntityIronGolem.class, "iron_golem", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelIronGolem();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelIronGolem)) {
            return null;
        }
        ModelIronGolem modelIronGolem = (ModelIronGolem)modelBase;
        return string.equals("head") ? modelIronGolem.ironGolemHead : (string.equals("body") ? modelIronGolem.ironGolemBody : (string.equals("left_arm") ? modelIronGolem.ironGolemLeftArm : (string.equals("right_arm") ? modelIronGolem.ironGolemRightArm : (string.equals("left_leg") ? modelIronGolem.ironGolemLeftLeg : (string.equals("right_leg") ? modelIronGolem.ironGolemRightLeg : null)))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "body", "right_arm", "left_arm", "left_leg", "right_leg"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderIronGolem renderIronGolem = new RenderIronGolem(renderManager);
        renderIronGolem.mainModel = modelBase;
        renderIronGolem.shadowSize = f;
        return renderIronGolem;
    }
}

