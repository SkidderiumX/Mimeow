/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnchantmentTableRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.reflect.Reflector;

public class ModelAdapterBook
extends ModelAdapter {
    public ModelAdapterBook() {
        super(TileEntityEnchantmentTable.class, "book", 0.0f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelBook();
    }

    @Override
    public ModelRenderer getModelRenderer(ModelBase modelBase, String string) {
        if (!(modelBase instanceof ModelBook)) {
            return null;
        }
        ModelBook modelBook = (ModelBook)modelBase;
        return string.equals("cover_right") ? modelBook.coverRight : (string.equals("cover_left") ? modelBook.coverLeft : (string.equals("pages_right") ? modelBook.pagesRight : (string.equals("pages_left") ? modelBook.pagesLeft : (string.equals("flipping_page_right") ? modelBook.flippingPageRight : (string.equals("flipping_page_left") ? modelBook.flippingPageLeft : (string.equals("book_spine") ? modelBook.bookSpine : null))))));
    }

    @Override
    public String[] getModelRendererNames() {
        return new String[]{"cover_right", "cover_left", "pages_right", "pages_left", "flipping_page_right", "flipping_page_left", "book_spine"};
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        TileEntityRendererDispatcher tileEntityRendererDispatcher = TileEntityRendererDispatcher.instance;
        TileEntityEnchantmentTableRenderer tileEntityEnchantmentTableRenderer = tileEntityRendererDispatcher.getSpecialRendererByClass(TileEntityEnchantmentTable.class);
        if (!(tileEntityEnchantmentTableRenderer instanceof TileEntityEnchantmentTableRenderer)) {
            return null;
        }
        if (tileEntityEnchantmentTableRenderer.getEntityClass() == null) {
            tileEntityEnchantmentTableRenderer = new TileEntityEnchantmentTableRenderer();
            tileEntityEnchantmentTableRenderer.setRendererDispatcher(tileEntityRendererDispatcher);
        }
        if (!Reflector.TileEntityEnchantmentTableRenderer_modelBook.exists()) {
            Config.warn("Field not found: TileEntityEnchantmentTableRenderer.modelBook");
            return null;
        }
        Reflector.setFieldValue(tileEntityEnchantmentTableRenderer, Reflector.TileEntityEnchantmentTableRenderer_modelBook, modelBase);
        return tileEntityEnchantmentTableRenderer;
    }
}

