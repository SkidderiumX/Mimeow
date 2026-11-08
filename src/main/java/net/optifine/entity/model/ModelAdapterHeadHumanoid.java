/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntitySkull;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterHeadHumanoid
extends ModelAdapter {
    public ModelAdapterHeadHumanoid() {
        super(TileEntitySkull.class, "head_humanoid", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelHumanoidHead();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelHumanoidHead)) {
            return null;
        }
        ModelHumanoidHead modelHumanoidHead = (ModelHumanoidHead)modelBase;
        return string.equals("head") ? modelHumanoidHead.skeletonHead : (string.equals("head2") ? (!Reflector.ModelHumanoidHead_head.exists() ? null : (ModelRenderer)Reflector.getFieldValue(modelHumanoidHead, Reflector.ModelHumanoidHead_head)) : null);
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"head"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        TileEntityRendererDispatcher tileEntityRendererDispatcher = TileEntityRendererDispatcher.instance;
        TileEntitySkullRenderer tileEntitySkullRenderer = tileEntityRendererDispatcher.getSpecialRendererByClass(TileEntitySkull.class);
        if (!(tileEntitySkullRenderer instanceof TileEntitySkullRenderer)) {
            return null;
        }
        if (tileEntitySkullRenderer.getEntityClass() == null) {
            tileEntitySkullRenderer = new TileEntitySkullRenderer();
            ((TileEntitySpecialRenderer)tileEntitySkullRenderer).setRendererDispatcher(tileEntityRendererDispatcher);
        }
        if (!Reflector.TileEntitySkullRenderer_humanoidHead.exists()) {
            Config.warn("Field not found: TileEntitySkullRenderer.humanoidHead");
            return null;
        }
        Reflector.setFieldValue(tileEntitySkullRenderer, Reflector.TileEntitySkullRenderer_humanoidHead, modelBase);
        return tileEntitySkullRenderer;
    }
}

