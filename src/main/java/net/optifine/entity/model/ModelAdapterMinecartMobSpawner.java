/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecartMobSpawner;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapterMinecart;
import net.optifine.reflect.Reflector;

public class ModelAdapterMinecartMobSpawner
extends ModelAdapterMinecart {
    public ModelAdapterMinecartMobSpawner() {
        super(EntityMinecartMobSpawner.class, "spawner_minecart", 0.5f);
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderMinecartMobSpawner renderMinecartMobSpawner = new RenderMinecartMobSpawner(renderManager);
        if (!Reflector.RenderMinecart_modelMinecart.exists()) {
            Config.warn("Field not found: RenderMinecart.modelMinecart");
            return null;
        }
        Reflector.setFieldValue(renderMinecartMobSpawner, Reflector.RenderMinecart_modelMinecart, modelBase);
        renderMinecartMobSpawner.shadowSize = f;
        return renderMinecartMobSpawner;
    }
}

