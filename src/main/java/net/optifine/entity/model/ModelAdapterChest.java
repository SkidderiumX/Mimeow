/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityChest;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterChest
extends ModelAdapter {
    public ModelAdapterChest() {
        super(TileEntityChest.class, "chest", 0.0f);
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
        TileEntityChestRenderer tileEntityChestRenderer = tileEntityRendererDispatcher.getSpecialRendererByClass(TileEntityChest.class);
        if (!(tileEntityChestRenderer instanceof TileEntityChestRenderer)) {
            return null;
        }
        if (tileEntityChestRenderer.getEntityClass() == null) {
            tileEntityChestRenderer = new TileEntityChestRenderer();
            tileEntityChestRenderer.setRendererDispatcher(tileEntityRendererDispatcher);
        }
        if (!Reflector.TileEntityChestRenderer_simpleChest.exists()) {
            Config.warn("Field not found: TileEntityChestRenderer.simpleChest");
            return null;
        }
        Reflector.setFieldValue(tileEntityChestRenderer, Reflector.TileEntityChestRenderer_simpleChest, modelBase);
        return tileEntityChestRenderer;
    }
}

