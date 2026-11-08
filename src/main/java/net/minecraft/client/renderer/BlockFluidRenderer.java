/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.optifine.CustomColors;
import net.optifine.render.RenderEnv;
import net.optifine.shaders.SVertexBuilder;

public class BlockFluidRenderer {
    private TextureAtlasSprite[] atlasSpritesLava = new TextureAtlasSprite[2];
    private TextureAtlasSprite[] atlasSpritesWater = new TextureAtlasSprite[2];

    public BlockFluidRenderer() {
        this.initAtlasSprites();
    }

    protected void initAtlasSprites() {
        TextureMap textureMap = Minecraft.getMinecraft().getTextureMapBlocks();
        this.atlasSpritesLava[0] = textureMap.getAtlasSprite("minecraft:blocks/lava_still");
        this.atlasSpritesLava[1] = textureMap.getAtlasSprite("minecraft:blocks/lava_flow");
        this.atlasSpritesWater[0] = textureMap.getAtlasSprite("minecraft:blocks/water_still");
        this.atlasSpritesWater[1] = textureMap.getAtlasSprite("minecraft:blocks/water_flow");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean renderFluid(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, WorldRenderer worldRenderer) {
        boolean bl;
        try {
            if (Config.isShaders()) {
                SVertexBuilder.pushEntity(iBlockState, blockPos, iBlockAccess, worldRenderer);
            }
            BlockLiquid blockLiquid = (BlockLiquid)iBlockState.getBlock();
            blockLiquid.setBlockBoundsBasedOnState(iBlockAccess, blockPos);
            TextureAtlasSprite[] textureAtlasSpriteArray = blockLiquid.getMaterial() == Material.lava ? this.atlasSpritesLava : this.atlasSpritesWater;
            RenderEnv renderEnv = worldRenderer.getRenderEnv(iBlockState, blockPos);
            int n = CustomColors.getFluidColor(iBlockAccess, iBlockState, blockPos, renderEnv);
            float f = (float)(n >> 16 & 0xFF) / 255.0f;
            float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(n & 0xFF) / 255.0f;
            boolean bl2 = blockLiquid.shouldSideBeRendered(iBlockAccess, blockPos.up(), EnumFacing.UP);
            boolean bl3 = blockLiquid.shouldSideBeRendered(iBlockAccess, blockPos.down(), EnumFacing.DOWN);
            boolean[] blArray = renderEnv.getBorderFlags();
            blArray[0] = blockLiquid.shouldSideBeRendered(iBlockAccess, blockPos.north(), EnumFacing.NORTH);
            blArray[1] = blockLiquid.shouldSideBeRendered(iBlockAccess, blockPos.south(), EnumFacing.SOUTH);
            blArray[2] = blockLiquid.shouldSideBeRendered(iBlockAccess, blockPos.west(), EnumFacing.WEST);
            blArray[3] = blockLiquid.shouldSideBeRendered(iBlockAccess, blockPos.east(), EnumFacing.EAST);
            if (bl2 || bl3 || blArray[0] || blArray[1] || blArray[2] || blArray[3]) {
                int n2;
                float f4;
                float f5;
                float f6;
                float f7;
                float f8;
                int n3 = 0;
                float f9 = 0.5f;
                float f10 = 1.0f;
                float f11 = 0.8f;
                float f12 = 0.6f;
                Material material = blockLiquid.getMaterial();
                float f13 = this.getFluidHeight(iBlockAccess, blockPos, material);
                float f14 = this.getFluidHeight(iBlockAccess, blockPos.south(), material);
                float f15 = this.getFluidHeight(iBlockAccess, blockPos.east().south(), material);
                float f16 = this.getFluidHeight(iBlockAccess, blockPos.east(), material);
                double d = blockPos.getX();
                double d2 = blockPos.getY();
                double d3 = blockPos.getZ();
                float f17 = 0.001f;
                if (bl2) {
                    float f18;
                    float f19;
                    float f20;
                    float f21;
                    float f22;
                    n3 = 1;
                    TextureAtlasSprite textureAtlasSprite = textureAtlasSpriteArray[0];
                    f8 = (float)BlockLiquid.getFlowDirection(iBlockAccess, blockPos, material);
                    if (f8 > -999.0f) {
                        textureAtlasSprite = textureAtlasSpriteArray[1];
                    }
                    worldRenderer.setSprite(textureAtlasSprite);
                    f13 -= f17;
                    f14 -= f17;
                    f15 -= f17;
                    f16 -= f17;
                    if (f8 < -999.0f) {
                        f7 = textureAtlasSprite.getInterpolatedU(0.0);
                        f22 = textureAtlasSprite.getInterpolatedV(0.0);
                        f6 = f7;
                        f5 = textureAtlasSprite.getInterpolatedV(16.0);
                        f21 = textureAtlasSprite.getInterpolatedU(16.0);
                        f20 = f5;
                        f19 = f21;
                        f18 = f22;
                    } else {
                        float f23 = MathHelper.sin(f8) * 0.25f;
                        float f24 = MathHelper.cos(f8) * 0.25f;
                        float f25 = 8.0f;
                        f7 = textureAtlasSprite.getInterpolatedU(8.0f + (-f24 - f23) * 16.0f);
                        f22 = textureAtlasSprite.getInterpolatedV(8.0f + (-f24 + f23) * 16.0f);
                        f6 = textureAtlasSprite.getInterpolatedU(8.0f + (-f24 + f23) * 16.0f);
                        f5 = textureAtlasSprite.getInterpolatedV(8.0f + (f24 + f23) * 16.0f);
                        f21 = textureAtlasSprite.getInterpolatedU(8.0f + (f24 + f23) * 16.0f);
                        f20 = textureAtlasSprite.getInterpolatedV(8.0f + (f24 - f23) * 16.0f);
                        f19 = textureAtlasSprite.getInterpolatedU(8.0f + (f24 - f23) * 16.0f);
                        f18 = textureAtlasSprite.getInterpolatedV(8.0f + (-f24 - f23) * 16.0f);
                    }
                    int n4 = blockLiquid.getMixedBrightnessForBlock(iBlockAccess, blockPos);
                    int n5 = n4 >> 16 & 0xFFFF;
                    int n6 = n4 & 0xFFFF;
                    float f26 = f10 * f;
                    float f27 = f10 * f2;
                    f4 = f10 * f3;
                    worldRenderer.pos(d + 0.0, d2 + (double)f13, d3 + 0.0).color(f26, f27, f4, 1.0f).tex(f7, f22).lightmap(n5, n6).endVertex();
                    worldRenderer.pos(d + 0.0, d2 + (double)f14, d3 + 1.0).color(f26, f27, f4, 1.0f).tex(f6, f5).lightmap(n5, n6).endVertex();
                    worldRenderer.pos(d + 1.0, d2 + (double)f15, d3 + 1.0).color(f26, f27, f4, 1.0f).tex(f21, f20).lightmap(n5, n6).endVertex();
                    worldRenderer.pos(d + 1.0, d2 + (double)f16, d3 + 0.0).color(f26, f27, f4, 1.0f).tex(f19, f18).lightmap(n5, n6).endVertex();
                    if (blockLiquid.shouldRenderSides(iBlockAccess, blockPos.up())) {
                        worldRenderer.pos(d + 0.0, d2 + (double)f13, d3 + 0.0).color(f26, f27, f4, 1.0f).tex(f7, f22).lightmap(n5, n6).endVertex();
                        worldRenderer.pos(d + 1.0, d2 + (double)f16, d3 + 0.0).color(f26, f27, f4, 1.0f).tex(f19, f18).lightmap(n5, n6).endVertex();
                        worldRenderer.pos(d + 1.0, d2 + (double)f15, d3 + 1.0).color(f26, f27, f4, 1.0f).tex(f21, f20).lightmap(n5, n6).endVertex();
                        worldRenderer.pos(d + 0.0, d2 + (double)f14, d3 + 1.0).color(f26, f27, f4, 1.0f).tex(f6, f5).lightmap(n5, n6).endVertex();
                    }
                }
                if (bl3) {
                    worldRenderer.setSprite(textureAtlasSpriteArray[0]);
                    float f28 = textureAtlasSpriteArray[0].getMinU();
                    f8 = textureAtlasSpriteArray[0].getMaxU();
                    f7 = textureAtlasSpriteArray[0].getMinV();
                    f6 = textureAtlasSpriteArray[0].getMaxV();
                    int n7 = blockLiquid.getMixedBrightnessForBlock(iBlockAccess, blockPos.down());
                    int n8 = n7 >> 16 & 0xFFFF;
                    int n9 = n7 & 0xFFFF;
                    f5 = FaceBakery.getFaceBrightness(EnumFacing.DOWN);
                    worldRenderer.pos(d, d2, d3 + 1.0).color(f * f5, f2 * f5, f3 * f5, 1.0f).tex(f28, f6).lightmap(n8, n9).endVertex();
                    worldRenderer.pos(d, d2, d3).color(f * f5, f2 * f5, f3 * f5, 1.0f).tex(f28, f7).lightmap(n8, n9).endVertex();
                    worldRenderer.pos(d + 1.0, d2, d3).color(f * f5, f2 * f5, f3 * f5, 1.0f).tex(f8, f7).lightmap(n8, n9).endVertex();
                    worldRenderer.pos(d + 1.0, d2, d3 + 1.0).color(f * f5, f2 * f5, f3 * f5, 1.0f).tex(f8, f6).lightmap(n8, n9).endVertex();
                    n3 = 1;
                }
                for (n2 = 0; n2 < 4; ++n2) {
                    double d4;
                    double d5;
                    double d6;
                    double d7;
                    float f29;
                    float f30;
                    int n10 = 0;
                    int n11 = 0;
                    if (n2 == 0) {
                        --n11;
                    }
                    if (n2 == 1) {
                        ++n11;
                    }
                    if (n2 == 2) {
                        --n10;
                    }
                    if (n2 == 3) {
                        ++n10;
                    }
                    BlockPos blockPos2 = blockPos.add(n10, 0, n11);
                    TextureAtlasSprite textureAtlasSprite = textureAtlasSpriteArray[1];
                    worldRenderer.setSprite(textureAtlasSprite);
                    if (!blArray[n2]) continue;
                    if (n2 == 0) {
                        f30 = f13;
                        f29 = f16;
                        d7 = d;
                        d6 = d + 1.0;
                        d5 = d3 + (double)f17;
                        d4 = d3 + (double)f17;
                    } else if (n2 == 1) {
                        f30 = f15;
                        f29 = f14;
                        d7 = d + 1.0;
                        d6 = d;
                        d5 = d3 + 1.0 - (double)f17;
                        d4 = d3 + 1.0 - (double)f17;
                    } else if (n2 == 2) {
                        f30 = f14;
                        f29 = f13;
                        d7 = d + (double)f17;
                        d6 = d + (double)f17;
                        d5 = d3 + 1.0;
                        d4 = d3;
                    } else {
                        f30 = f16;
                        f29 = f15;
                        d7 = d + 1.0 - (double)f17;
                        d6 = d + 1.0 - (double)f17;
                        d5 = d3;
                        d4 = d3 + 1.0;
                    }
                    n3 = 1;
                    f4 = textureAtlasSprite.getInterpolatedU(0.0);
                    float f31 = textureAtlasSprite.getInterpolatedU(8.0);
                    float f32 = textureAtlasSprite.getInterpolatedV((1.0f - f30) * 16.0f * 0.5f);
                    float f33 = textureAtlasSprite.getInterpolatedV((1.0f - f29) * 16.0f * 0.5f);
                    float f34 = textureAtlasSprite.getInterpolatedV(8.0);
                    int n12 = blockLiquid.getMixedBrightnessForBlock(iBlockAccess, blockPos2);
                    int n13 = n12 >> 16 & 0xFFFF;
                    int n14 = n12 & 0xFFFF;
                    float f35 = n2 < 2 ? FaceBakery.getFaceBrightness(EnumFacing.NORTH) : FaceBakery.getFaceBrightness(EnumFacing.WEST);
                    float f36 = f10 * f35 * f;
                    float f37 = f10 * f35 * f2;
                    float f38 = f10 * f35 * f3;
                    worldRenderer.pos(d7, d2 + (double)f30, d5).color(f36, f37, f38, 1.0f).tex(f4, f32).lightmap(n13, n14).endVertex();
                    worldRenderer.pos(d6, d2 + (double)f29, d4).color(f36, f37, f38, 1.0f).tex(f31, f33).lightmap(n13, n14).endVertex();
                    worldRenderer.pos(d6, d2 + 0.0, d4).color(f36, f37, f38, 1.0f).tex(f31, f34).lightmap(n13, n14).endVertex();
                    worldRenderer.pos(d7, d2 + 0.0, d5).color(f36, f37, f38, 1.0f).tex(f4, f34).lightmap(n13, n14).endVertex();
                    worldRenderer.pos(d7, d2 + 0.0, d5).color(f36, f37, f38, 1.0f).tex(f4, f34).lightmap(n13, n14).endVertex();
                    worldRenderer.pos(d6, d2 + 0.0, d4).color(f36, f37, f38, 1.0f).tex(f31, f34).lightmap(n13, n14).endVertex();
                    worldRenderer.pos(d6, d2 + (double)f29, d4).color(f36, f37, f38, 1.0f).tex(f31, f33).lightmap(n13, n14).endVertex();
                    worldRenderer.pos(d7, d2 + (double)f30, d5).color(f36, f37, f38, 1.0f).tex(f4, f32).lightmap(n13, n14).endVertex();
                }
                worldRenderer.setSprite(null);
                int n15 = n2 = n3;
                return n15 != 0;
            }
            bl = false;
        }
        finally {
            if (Config.isShaders()) {
                SVertexBuilder.popEntity(worldRenderer);
            }
        }
        return bl;
    }

    private float getFluidHeight(IBlockAccess iBlockAccess, BlockPos blockPos, Material material) {
        int n = 0;
        float f = 0.0f;
        for (int i = 0; i < 4; ++i) {
            BlockPos blockPos2 = blockPos.add(-(i & 1), 0, -(i >> 1 & 1));
            if (iBlockAccess.getBlockState(blockPos2.up()).getBlock().getMaterial() == material) {
                return 1.0f;
            }
            IBlockState iBlockState = iBlockAccess.getBlockState(blockPos2);
            Material material2 = iBlockState.getBlock().getMaterial();
            if (material2 != material) {
                if (material2.isSolid()) continue;
                f += 1.0f;
                ++n;
                continue;
            }
            int n2 = iBlockState.getValue(BlockLiquid.LEVEL);
            if (n2 >= 8 || n2 == 0) {
                f += BlockLiquid.getLiquidHeightPercent(n2) * 10.0f;
                n += 10;
            }
            f += BlockLiquid.getLiquidHeightPercent(n2);
            ++n;
        }
        return 1.0f - f / (float)n;
    }
}

