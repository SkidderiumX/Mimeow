/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBanner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityBannerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityBanner;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterBanner
extends ModelAdapter {
    public ModelAdapterBanner() {
        super(TileEntityBanner.class, "banner", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelBanner();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelBanner)) {
            return null;
        }
        ModelBanner modelBanner = (ModelBanner)modelBase;
        return string.equals("slate") ? modelBanner.bannerSlate : (string.equals("stand") ? modelBanner.bannerStand : (string.equals("top") ? modelBanner.bannerTop : null));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"slate", "stand", "top"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        TileEntityRendererDispatcher tileEntityRendererDispatcher = TileEntityRendererDispatcher.instance;
        TileEntityBannerRenderer tileEntityBannerRenderer = tileEntityRendererDispatcher.getSpecialRendererByClass(TileEntityBanner.class);
        if (!(tileEntityBannerRenderer instanceof TileEntityBannerRenderer)) {
            return null;
        }
        if (tileEntityBannerRenderer.getEntityClass() == null) {
            tileEntityBannerRenderer = new TileEntityBannerRenderer();
            tileEntityBannerRenderer.setRendererDispatcher(tileEntityRendererDispatcher);
        }
        if (!Reflector.TileEntityBannerRenderer_bannerModel.exists()) {
            Config.warn("Field not found: TileEntityBannerRenderer.bannerModel");
            return null;
        }
        Reflector.setFieldValue(tileEntityBannerRenderer, Reflector.TileEntityBannerRenderer_bannerModel, modelBase);
        return tileEntityBannerRenderer;
    }
}

