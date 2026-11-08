/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntitySign;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterSign
extends ModelAdapter {
    public ModelAdapterSign() {
        super(TileEntitySign.class, "sign", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelSign();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelSign)) {
            return null;
        }
        ModelSign modelSign = (ModelSign)modelBase;
        return string.equals("board") ? modelSign.signBoard : (string.equals("stick") ? modelSign.signStick : null);
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"board", "stick"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        TileEntityRendererDispatcher tileEntityRendererDispatcher = TileEntityRendererDispatcher.instance;
        TileEntitySignRenderer tileEntitySignRenderer = tileEntityRendererDispatcher.getSpecialRendererByClass(TileEntitySign.class);
        if (!(tileEntitySignRenderer instanceof TileEntitySignRenderer)) {
            return null;
        }
        if (tileEntitySignRenderer.getEntityClass() == null) {
            tileEntitySignRenderer = new TileEntitySignRenderer();
            tileEntitySignRenderer.setRendererDispatcher(tileEntityRendererDispatcher);
        }
        if (!Reflector.TileEntitySignRenderer_model.exists()) {
            Config.warn("Field not found: TileEntitySignRenderer.model");
            return null;
        }
        Reflector.setFieldValue(tileEntitySignRenderer, Reflector.TileEntitySignRenderer_model, modelBase);
        return tileEntitySignRenderer;
    }
}

