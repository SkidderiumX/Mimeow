/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.src.Config;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapterQuadruped;

public class ModelAdapterSheepWool
extends ModelAdapterQuadruped {
    public ModelAdapterSheepWool() {
        super(EntitySheep.class, "sheep_wool", 0.7f);
    }

    @Override
    public ModelBase makeModel() {
        return new ModelSheep1();
    }

    @Override
    public IEntityRenderer makeEntityRender(ModelBase modelBase, float f) {
        LayerSheepWool layerSheepWool;
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        Render render2 = renderManager.getEntityRenderMap().get(EntitySheep.class);
        if (!(render2 instanceof RenderSheep)) {
            Config.warn("Not a RenderSheep: " + String.valueOf(render2));
            return null;
        }
        if (render2.getEntityClass() == null) {
            render2 = new RenderSheep(renderManager, new ModelSheep2(), 0.7f);
        }
        RenderSheep renderSheep = (RenderSheep)render2;
        List list = renderSheep.getLayerRenderers();
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            layerSheepWool = iterator2.next();
            if (!(layerSheepWool instanceof LayerSheepWool)) continue;
            iterator2.remove();
        }
        layerSheepWool = new LayerSheepWool(renderSheep);
        layerSheepWool.sheepModel = (ModelSheep1)modelBase;
        renderSheep.addLayer(layerSheepWool);
        return renderSheep;
    }
}

