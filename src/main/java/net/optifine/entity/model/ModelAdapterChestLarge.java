/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityChest;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterChestLarge
extends ModelAdapter {
    public ModelAdapterChestLarge() {
        super(TileEntityChest.class, "chest_large", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelLargeChest();
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
        if (!Reflector.TileEntityChestRenderer_largeChest.exists()) {
            Config.warn("Field not found: TileEntityChestRenderer.largeChest");
            return null;
        }
        Reflector.setFieldValue(tileEntityChestRenderer, Reflector.TileEntityChestRenderer_largeChest, modelBase);
        return tileEntityChestRenderer;
    }
}

