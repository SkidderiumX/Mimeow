/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;

public class ModelAdapterChicken
extends ModelAdapter {
    public ModelAdapterChicken() {
        super(EntityChicken.class, "chicken", 0.3f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelChicken();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelChicken)) {
            return null;
        }
        ModelChicken modelChicken = (ModelChicken)modelBase;
        return string.equals("head") ? modelChicken.head : (string.equals("body") ? modelChicken.body : (string.equals("right_leg") ? modelChicken.rightLeg : (string.equals("left_leg") ? modelChicken.leftLeg : (string.equals("right_wing") ? modelChicken.rightWing : (string.equals("left_wing") ? modelChicken.leftWing : (string.equals("bill") ? modelChicken.bill : (string.equals("chin") ? modelChicken.chin : null)))))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "body", "right_leg", "left_leg", "right_wing", "left_wing", "bill", "chin"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderChicken renderChicken = new RenderChicken(renderManager, modelBase, f);
        return renderChicken;
    }
}

