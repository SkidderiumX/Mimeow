/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.entity.monster.EntitySnowman;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;

public class ModelAdapterSnowman
extends ModelAdapter {
    public ModelAdapterSnowman() {
        super(EntitySnowman.class, "snow_golem", 0.5f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelSnowMan();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelSnowMan)) {
            return null;
        }
        ModelSnowMan modelSnowMan = (ModelSnowMan)modelBase;
        return string.equals("body") ? modelSnowMan.body : (string.equals("body_bottom") ? modelSnowMan.bottomBody : (string.equals("head") ? modelSnowMan.head : (string.equals("left_hand") ? modelSnowMan.leftHand : (string.equals("right_hand") ? modelSnowMan.rightHand : null))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"body", "body_bottom", "head", "right_hand", "left_hand"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderSnowMan renderSnowMan = new RenderSnowMan(renderManager);
        renderSnowMan.mainModel = modelBase;
        renderSnowMan.shadowSize = f;
        return renderSnowMan;
    }
}

