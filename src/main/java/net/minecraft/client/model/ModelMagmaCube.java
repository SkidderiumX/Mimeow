/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;

public class ModelMagmaCube
extends ModelBase {
    ModelRenderer[] segments = new ModelRenderer[8];
    ModelRenderer core;

    public ModelMagmaCube() {
        for (int i = 0; i < this.segments.length; ++i) {
            int n = 0;
            int n2 = i;
            if (i == 2) {
                n = 24;
                n2 = 10;
            } else if (i == 3) {
                n = 24;
                n2 = 19;
            }
            this.segments[i] = new ModelRenderer(this, n, n2);
            this.segments[i].addBox(-4.0f, 16 + i, -4.0f, 8, 1, 8);
        }
        this.core = new ModelRenderer(this, 0, 16);
        this.core.addBox(-2.0f, 18.0f, -2.0f, 4, 4, 4);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        EntityMagmaCube entityMagmaCube = (EntityMagmaCube)entityLivingBase;
        float f4 = entityMagmaCube.prevSquishFactor + (entityMagmaCube.squishFactor - entityMagmaCube.prevSquishFactor) * f3;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        for (int i = 0; i < this.segments.length; ++i) {
            this.segments[i].rotationPointY = (float)(-(4 - i)) * f4 * 1.7f;
        }
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.core.render(f6);
        for (int i = 0; i < this.segments.length; ++i) {
            this.segments[i].render(f6);
        }
    }
}

