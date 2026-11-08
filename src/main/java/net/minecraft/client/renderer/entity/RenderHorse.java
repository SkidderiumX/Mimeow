/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.ResourceLocation;

public class RenderHorse
extends RenderLiving<EntityHorse> {
    private static final Map<String, ResourceLocation> field_110852_a = Maps.newHashMap();
    private static final ResourceLocation whiteHorseTextures = new ResourceLocation("textures/entity/horse/horse_white.png");
    private static final ResourceLocation muleTextures = new ResourceLocation("textures/entity/horse/mule.png");
    private static final ResourceLocation donkeyTextures = new ResourceLocation("textures/entity/horse/donkey.png");
    private static final ResourceLocation zombieHorseTextures = new ResourceLocation("textures/entity/horse/horse_zombie.png");
    private static final ResourceLocation skeletonHorseTextures = new ResourceLocation("textures/entity/horse/horse_skeleton.png");

    public RenderHorse(RenderManager renderManager, ModelHorse modelHorse, float f) {
        super(renderManager, modelHorse, f);
    }

    @Override
    protected void preRenderCallback(EntityHorse entityHorse, float f) {
        float f2 = 1.0f;
        int n = entityHorse.getHorseType();
        if (n == 1) {
            f2 *= 0.87f;
        } else if (n == 2) {
            f2 *= 0.92f;
        }
        GlStateManager.scale(f2, f2, f2);
        super.preRenderCallback(entityHorse, f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHorse entityHorse) {
        if (!entityHorse.func_110239_cn()) {
            switch (entityHorse.getHorseType()) {
                default: {
                    return whiteHorseTextures;
                }
                case 1: {
                    return donkeyTextures;
                }
                case 2: {
                    return muleTextures;
                }
                case 3: {
                    return zombieHorseTextures;
                }
                case 4: 
            }
            return skeletonHorseTextures;
        }
        return this.func_110848_b(entityHorse);
    }

    private ResourceLocation func_110848_b(EntityHorse entityHorse) {
        String string = entityHorse.getHorseTexture();
        if (!entityHorse.func_175507_cI()) {
            return null;
        }
        ResourceLocation resourceLocation = field_110852_a.get(string);
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string);
            Minecraft.getMinecraft().getTextureManager().loadTexture(resourceLocation, new LayeredTexture(entityHorse.getVariantTexturePaths()));
            field_110852_a.put(string, resourceLocation);
        }
        return resourceLocation;
    }
}

