/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.player;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.optifine.player.PlayerItemModel;

public class PlayerItemRenderer {
    private int attachTo = 0;
    private ModelRenderer modelRenderer = null;

    public PlayerItemRenderer(int n, ModelRenderer modelRenderer) {
        this.attachTo = n;
        this.modelRenderer = modelRenderer;
    }

    public ModelRenderer getModelRenderer() {
        return this.modelRenderer;
    }

    public void render(ModelBiped modelBiped, float f) {
        ModelRenderer modelRenderer = PlayerItemModel.getAttachModel(modelBiped, this.attachTo);
        if (modelRenderer != null) {
            modelRenderer.postRender(f);
        }
        this.modelRenderer.render(f);
    }
}

