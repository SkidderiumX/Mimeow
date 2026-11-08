/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;

public class ModelAdapterSpider
extends ModelAdapter {
    public ModelAdapterSpider() {
        super(EntitySpider.class, "spider", 1.0f);
    }

    protected ModelAdapterSpider(Class clazz, String string, float f) {
        super(clazz, string, f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelSpider();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelSpider)) {
            return null;
        }
        ModelSpider modelSpider = (ModelSpider)modelBase;
        return string.equals("head") ? modelSpider.spiderHead : (string.equals("neck") ? modelSpider.spiderNeck : (string.equals("body") ? modelSpider.spiderBody : (string.equals("leg1") ? modelSpider.spiderLeg1 : (string.equals("leg2") ? modelSpider.spiderLeg2 : (string.equals("leg3") ? modelSpider.spiderLeg3 : (string.equals("leg4") ? modelSpider.spiderLeg4 : (string.equals("leg5") ? modelSpider.spiderLeg5 : (string.equals("leg6") ? modelSpider.spiderLeg6 : (string.equals("leg7") ? modelSpider.spiderLeg7 : (string.equals("leg8") ? modelSpider.spiderLeg8 : null))))))))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head", "neck", "body", "leg1", "leg2", "leg3", "leg4", "leg5", "leg6", "leg7", "leg8"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderSpider renderSpider = new RenderSpider(renderManager);
        renderSpider.mainModel = modelBase;
        renderSpider.shadowSize = f;
        return renderSpider;
    }
}

