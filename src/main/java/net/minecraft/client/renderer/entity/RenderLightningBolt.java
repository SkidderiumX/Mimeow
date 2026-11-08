/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.ResourceLocation;

public class RenderLightningBolt
extends Render<EntityLightningBolt> {
    public RenderLightningBolt(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityLightningBolt entityLightningBolt, double d, double d2, double d3, float f, float f2) {
        int n;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 1);
        double[] dArray = new double[8];
        double[] dArray2 = new double[8];
        double d4 = 0.0;
        double d5 = 0.0;
        Random random = new Random(entityLightningBolt.boltVertex);
        for (n = 7; n >= 0; --n) {
            dArray[n] = d4;
            dArray2[n] = d5;
            d4 += (double)(random.nextInt(11) - 5);
            d5 += (double)(random.nextInt(11) - 5);
        }
        for (n = 0; n < 4; ++n) {
            Random random2 = new Random(entityLightningBolt.boltVertex);
            for (int i = 0; i < 3; ++i) {
                int n2 = 7;
                int n3 = 0;
                if (i > 0) {
                    n2 = 7 - i;
                }
                if (i > 0) {
                    n3 = n2 - 2;
                }
                double d6 = dArray[n2] - d4;
                double d7 = dArray2[n2] - d5;
                for (int j = n2; j >= n3; --j) {
                    double d8 = d6;
                    double d9 = d7;
                    if (i == 0) {
                        d6 += (double)(random2.nextInt(11) - 5);
                        d7 += (double)(random2.nextInt(11) - 5);
                    } else {
                        d6 += (double)(random2.nextInt(31) - 15);
                        d7 += (double)(random2.nextInt(31) - 15);
                    }
                    worldRenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    float f3 = 0.5f;
                    float f4 = 0.45f;
                    float f5 = 0.45f;
                    float f6 = 0.5f;
                    double d10 = 0.1 + (double)n * 0.2;
                    if (i == 0) {
                        d10 *= (double)j * 0.1 + 1.0;
                    }
                    double d11 = 0.1 + (double)n * 0.2;
                    if (i == 0) {
                        d11 *= (double)(j - 1) * 0.1 + 1.0;
                    }
                    for (int k = 0; k < 5; ++k) {
                        double d12 = d + 0.5 - d10;
                        double d13 = d3 + 0.5 - d10;
                        if (k == 1 || k == 2) {
                            d12 += d10 * 2.0;
                        }
                        if (k == 2 || k == 3) {
                            d13 += d10 * 2.0;
                        }
                        double d14 = d + 0.5 - d11;
                        double d15 = d3 + 0.5 - d11;
                        if (k == 1 || k == 2) {
                            d14 += d11 * 2.0;
                        }
                        if (k == 2 || k == 3) {
                            d15 += d11 * 2.0;
                        }
                        worldRenderer.pos(d14 + d6, d2 + (double)(j * 16), d15 + d7).color(0.45f, 0.45f, 0.5f, 0.3f).endVertex();
                        worldRenderer.pos(d12 + d8, d2 + (double)((j + 1) * 16), d13 + d9).color(0.45f, 0.45f, 0.5f, 0.3f).endVertex();
                    }
                    tessellator.draw();
                }
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLightningBolt entityLightningBolt) {
        return null;
    }
}

