/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnderChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterEnderChest
extends ModelAdapter {
    public ModelAdapterEnderChest() {
        super(TileEntityEnderChest.class, "ender_chest", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelChest();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelChest)) {
            return null;
        }
        ModelChest modelChest = (ModelChest)modelBase;
        return string.equals("lid") ? modelChest.chestLid : (string.equals("base") ? modelChest.chestBelow : (string.equals("knob") ? modelChest.chestKnob : null));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"lid", "base", "knob"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        TileEntityRendererDispatcher tileEntityRendererDispatcher = TileEntityRendererDispatcher.instance;
        TileEntityEnderChestRenderer tileEntityEnderChestRenderer = tileEntityRendererDispatcher.getSpecialRendererByClass(TileEntityEnderChest.class);
        if (!(tileEntityEnderChestRenderer instanceof TileEntityEnderChestRenderer)) {
            return null;
        }
        if (tileEntityEnderChestRenderer.getEntityClass() == null) {
            tileEntityEnderChestRenderer = new TileEntityEnderChestRenderer();
            tileEntityEnderChestRenderer.setRendererDispatcher(tileEntityRendererDispatcher);
        }
        if (!Reflector.TileEntityEnderChestRenderer_modelChest.exists()) {
            Config.warn("Field not found: TileEntityEnderChestRenderer.modelChest");
            return null;
        }
        Reflector.setFieldValue(tileEntityEnderChestRenderer, Reflector.TileEntityEnderChestRenderer_modelChest, modelBase);
        return tileEntityEnderChestRenderer;
    }
}

