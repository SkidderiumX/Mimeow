/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec4b;
import net.minecraft.world.storage.MapData;

public class MapItemRenderer {
    private static final ResourceLocation mapIcons = new ResourceLocation("textures/map/map_icons.png");
    private final TextureManager textureManager;
    private final Map<String, Instance> loadedMaps = Maps.newHashMap();

    public MapItemRenderer(TextureManager textureManager) {
        this.textureManager = textureManager;
    }

    public void updateMapTexture(MapData mapData) {
        this.getMapRendererInstance(mapData).updateMapTexture();
    }

    public void renderMap(MapData mapData, boolean bl) {
        this.getMapRendererInstance(mapData).render(bl);
    }

    private Instance getMapRendererInstance(MapData mapData) {
        Instance instance = this.loadedMaps.get(mapData.mapName);
        if (instance == null) {
            instance = new Instance(mapData);
            this.loadedMaps.put(mapData.mapName, instance);
        }
        return instance;
    }

    public void clearLoadedMaps() {
        for (Instance instance : this.loadedMaps.values()) {
            this.textureManager.deleteTexture(instance.location);
        }
        this.loadedMaps.clear();
    }

    public class Instance {
        private final MapData mapData;
        private final DynamicTexture mapTexture;
        private final ResourceLocation location;
        private final int[] mapTextureData;

        private Instance(MapData mapData) {
            this.mapData = mapData;
            this.mapTexture = new DynamicTexture(128, 128);
            this.mapTextureData = this.mapTexture.getTextureData();
            this.location = MapItemRenderer.this.textureManager.getDynamicTextureLocation("map/" + mapData.mapName, this.mapTexture);
            for (int i = 0; i < this.mapTextureData.length; ++i) {
                this.mapTextureData[i] = 0;
            }
        }

        private void updateMapTexture() {
            for (int i = 0; i < 16384; ++i) {
                int n = this.mapData.colors[i] & 0xFF;
                this.mapTextureData[i] = n / 4 == 0 ? (i + i / 128 & 1) * 8 + 16 << 24 : MapColor.mapColorArray[n / 4].getMapColor(n & 3);
            }
            this.mapTexture.updateDynamicTexture();
        }

        private void render(boolean bl) {
            int n = 0;
            int n2 = 0;
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            float f = 0.0f;
            MapItemRenderer.this.textureManager.bindTexture(this.location);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(1, 771, 0, 1);
            GlStateManager.disableAlpha();
            worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
            worldRenderer.pos((float)(n + 0) + f, (float)(n2 + 128) - f, -0.01f).tex(0.0, 1.0).endVertex();
            worldRenderer.pos((float)(n + 128) - f, (float)(n2 + 128) - f, -0.01f).tex(1.0, 1.0).endVertex();
            worldRenderer.pos((float)(n + 128) - f, (float)(n2 + 0) + f, -0.01f).tex(1.0, 0.0).endVertex();
            worldRenderer.pos((float)(n + 0) + f, (float)(n2 + 0) + f, -0.01f).tex(0.0, 0.0).endVertex();
            tessellator.draw();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            MapItemRenderer.this.textureManager.bindTexture(mapIcons);
            int n3 = 0;
            for (Vec4b vec4b : this.mapData.mapDecorations.values()) {
                if (bl && vec4b.func_176110_a() != 1) continue;
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)n + (float)vec4b.func_176112_b() / 2.0f + 64.0f, (float)n2 + (float)vec4b.func_176113_c() / 2.0f + 64.0f, -0.02f);
                GlStateManager.rotate((float)(vec4b.func_176111_d() * 360) / 16.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.scale(4.0f, 4.0f, 3.0f);
                GlStateManager.translate(-0.125f, 0.125f, 0.0f);
                byte by = vec4b.func_176110_a();
                float f2 = (float)(by % 4 + 0) / 4.0f;
                float f3 = (float)(by / 4 + 0) / 4.0f;
                float f4 = (float)(by % 4 + 1) / 4.0f;
                float f5 = (float)(by / 4 + 1) / 4.0f;
                worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
                float f6 = -0.001f;
                worldRenderer.pos(-1.0, 1.0, (float)n3 * -0.001f).tex(f2, f3).endVertex();
                worldRenderer.pos(1.0, 1.0, (float)n3 * -0.001f).tex(f4, f3).endVertex();
                worldRenderer.pos(1.0, -1.0, (float)n3 * -0.001f).tex(f4, f5).endVertex();
                worldRenderer.pos(-1.0, -1.0, (float)n3 * -0.001f).tex(f2, f5).endVertex();
                tessellator.draw();
                GlStateManager.popMatrix();
                ++n3;
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, -0.04f);
            GlStateManager.scale(1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
    }
}

