/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.player;

import java.util.Map;
import java.util.Set;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.src.Config;
import net.optifine.player.PlayerConfigurations;

public class PlayerItemsLayer
implements LayerRenderer {
    private RenderPlayer renderPlayer = null;

    public PlayerItemsLayer(RenderPlayer renderPlayer) {
        this.renderPlayer = renderPlayer;
    }

    public void doRenderLayer(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.renderEquippedItems(entityLivingBase, f7, f3);
    }

    protected void renderEquippedItems(EntityLivingBase entityLivingBase, float f, float f2) {
        if (Config.isShowCapes() && !entityLivingBase.isInvisible() && entityLivingBase instanceof AbstractClientPlayer) {
            AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)entityLivingBase;
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableRescaleNormal();
            GlStateManager.enableCull();
            ModelPlayer modelPlayer = this.renderPlayer.getMainModel();
            PlayerConfigurations.renderPlayerItems(modelPlayer, abstractClientPlayer, f, f2);
            GlStateManager.disableCull();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    public static void register(Map map) {
        Set set = map.keySet();
        boolean bl = false;
        for (Object k : set) {
            Object v = map.get(k);
            if (!(v instanceof RenderPlayer)) continue;
            RenderPlayer renderPlayer = (RenderPlayer)v;
            renderPlayer.addLayer(new PlayerItemsLayer(renderPlayer));
            bl = true;
        }
        if (!bl) {
            Config.warn("PlayerItemsLayer not registered");
        }
    }
}

