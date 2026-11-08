/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.tileentity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBanner;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.LayeredColorMaskTexture;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class TileEntityBannerRenderer
extends TileEntitySpecialRenderer<TileEntityBanner> {
    private static final Map<String, TimedBannerTexture> DESIGNS = Maps.newHashMap();
    private static final ResourceLocation BANNERTEXTURES = new ResourceLocation("textures/entity/banner_base.png");
    private ModelBanner bannerModel = new ModelBanner();

    @Override
    public void renderTileEntityAt(TileEntityBanner tileEntityBanner, double d, double d2, double d3, float f, int n) {
        boolean bl = tileEntityBanner.getWorld() != null;
        boolean bl2 = !bl || tileEntityBanner.getBlockType() == Blocks.standing_banner;
        int n2 = bl ? tileEntityBanner.getBlockMetadata() : 0;
        long l = bl ? tileEntityBanner.getWorld().getTotalWorldTime() : 0L;
        GlStateManager.pushMatrix();
        float f2 = 0.6666667f;
        if (bl2) {
            GlStateManager.translate((float)d + 0.5f, (float)d2 + 0.75f * f2, (float)d3 + 0.5f);
            var16_12 = (float)(n2 * 360) / 16.0f;
            GlStateManager.rotate(-var16_12, 0.0f, 1.0f, 0.0f);
            this.bannerModel.bannerStand.showModel = true;
        } else {
            var16_12 = 0.0f;
            if (n2 == 2) {
                var16_12 = 180.0f;
            }
            if (n2 == 4) {
                var16_12 = 90.0f;
            }
            if (n2 == 5) {
                var16_12 = -90.0f;
            }
            GlStateManager.translate((float)d + 0.5f, (float)d2 - 0.25f * f2, (float)d3 + 0.5f);
            GlStateManager.rotate(-var16_12, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.bannerModel.bannerStand.showModel = false;
        }
        BlockPos blockPos = tileEntityBanner.getPos();
        float f3 = (float)(blockPos.getX() * 7 + blockPos.getY() * 9 + blockPos.getZ() * 13) + (float)l + f;
        this.bannerModel.bannerSlate.rotateAngleX = (-0.0125f + 0.01f * MathHelper.cos(f3 * (float)Math.PI * 0.02f)) * (float)Math.PI;
        GlStateManager.enableRescaleNormal();
        ResourceLocation resourceLocation = this.func_178463_a(tileEntityBanner);
        if (resourceLocation != null) {
            this.bindTexture(resourceLocation);
            GlStateManager.pushMatrix();
            GlStateManager.scale(f2, -f2, -f2);
            this.bannerModel.renderBanner();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }

    private ResourceLocation func_178463_a(TileEntityBanner tileEntityBanner) {
        String string = tileEntityBanner.getPatternResourceLocation();
        if (string.isEmpty()) {
            return null;
        }
        TimedBannerTexture timedBannerTexture = DESIGNS.get(string);
        if (timedBannerTexture == null) {
            Object object;
            if (DESIGNS.size() >= 256) {
                long l = System.currentTimeMillis();
                object = DESIGNS.keySet().iterator();
                while (object.hasNext()) {
                    String string2 = (String)object.next();
                    TimedBannerTexture object2 = DESIGNS.get(string2);
                    if (l - object2.systemTime <= 60000L) continue;
                    Minecraft.getMinecraft().getTextureManager().deleteTexture(object2.bannerTexture);
                    object.remove();
                }
                if (DESIGNS.size() >= 256) {
                    return null;
                }
            }
            List<TileEntityBanner.EnumBannerPattern> list = tileEntityBanner.getPatternList();
            List<EnumDyeColor> list2 = tileEntityBanner.getColorList();
            object = Lists.newArrayList();
            for (TileEntityBanner.EnumBannerPattern enumBannerPattern : list) {
                object.add("textures/entity/banner/" + enumBannerPattern.getPatternName() + ".png");
            }
            timedBannerTexture = new TimedBannerTexture();
            timedBannerTexture.bannerTexture = new ResourceLocation(string);
            Minecraft.getMinecraft().getTextureManager().loadTexture(timedBannerTexture.bannerTexture, new LayeredColorMaskTexture(BANNERTEXTURES, (List<String>)object, list2));
            DESIGNS.put(string, timedBannerTexture);
        }
        timedBannerTexture.systemTime = System.currentTimeMillis();
        return timedBannerTexture.bannerTexture;
    }

    public static class TimedBannerTexture {
        public long systemTime;
        public ResourceLocation bannerTexture;

        private TimedBannerTexture() {
        }
    }
}

