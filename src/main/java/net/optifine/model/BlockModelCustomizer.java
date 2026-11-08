/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.model;

import com.google.common.collect.ImmutableList;
import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.optifine.BetterGrass;
import net.optifine.ConnectedTextures;
import net.optifine.NaturalTextures;
import net.optifine.SmartLeaves;
import net.optifine.render.RenderEnv;

public class BlockModelCustomizer {
    private static final List<BakedQuad> NO_QUADS = ImmutableList.of();

    public static IBakedModel getRenderModel(IBakedModel iBakedModel, IBlockState iBlockState, RenderEnv renderEnv) {
        if (renderEnv.isSmartLeaves()) {
            iBakedModel = SmartLeaves.getLeavesModel(iBakedModel, iBlockState);
        }
        return iBakedModel;
    }

    public static List<BakedQuad> getRenderQuads(List<BakedQuad> list, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, EnumWorldBlockLayer enumWorldBlockLayer, long l, RenderEnv renderEnv) {
        if (enumFacing != null) {
            if (renderEnv.isSmartLeaves() && SmartLeaves.isSameLeaves(iBlockAccess.getBlockState(blockPos.offset(enumFacing)), iBlockState)) {
                return NO_QUADS;
            }
            if (!renderEnv.isBreakingAnimation(list) && Config.isBetterGrass()) {
                list = BetterGrass.getFaceQuads(iBlockAccess, iBlockState, blockPos, enumFacing, list);
            }
        }
        List<BakedQuad> list2 = renderEnv.getListQuadsCustomizer();
        list2.clear();
        for (int i = 0; i < list.size(); ++i) {
            BakedQuad bakedQuad = list.get(i);
            BakedQuad[] bakedQuadArray = BlockModelCustomizer.getRenderQuads(bakedQuad, iBlockAccess, iBlockState, blockPos, enumFacing, l, renderEnv);
            if (i == 0 && list.size() == 1 && bakedQuadArray.length == 1 && bakedQuadArray[0] == bakedQuad && bakedQuad.getQuadEmissive() == null) {
                return list;
            }
            for (int j = 0; j < bakedQuadArray.length; ++j) {
                BakedQuad bakedQuad2 = bakedQuadArray[j];
                list2.add(bakedQuad2);
                if (bakedQuad2.getQuadEmissive() == null) continue;
                renderEnv.getListQuadsOverlay(BlockModelCustomizer.getEmissiveLayer(enumWorldBlockLayer)).addQuad(bakedQuad2.getQuadEmissive(), iBlockState);
                renderEnv.setOverlaysRendered(true);
            }
        }
        return list2;
    }

    private static EnumWorldBlockLayer getEmissiveLayer(EnumWorldBlockLayer enumWorldBlockLayer) {
        return enumWorldBlockLayer != null && enumWorldBlockLayer != EnumWorldBlockLayer.SOLID ? enumWorldBlockLayer : EnumWorldBlockLayer.CUTOUT_MIPPED;
    }

    private static BakedQuad[] getRenderQuads(BakedQuad bakedQuad, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, long l, RenderEnv renderEnv) {
        BakedQuad[] bakedQuadArray;
        if (renderEnv.isBreakingAnimation(bakedQuad)) {
            return renderEnv.getArrayQuadsCtm(bakedQuad);
        }
        BakedQuad bakedQuad2 = bakedQuad;
        if (Config.isConnectedTextures() && ((bakedQuadArray = ConnectedTextures.getConnectedTexture(iBlockAccess, iBlockState, blockPos, bakedQuad, renderEnv)).length != 1 || bakedQuadArray[0] != bakedQuad)) {
            return bakedQuadArray;
        }
        if (Config.isNaturalTextures() && (bakedQuad = NaturalTextures.getNaturalTexture(blockPos, bakedQuad)) != bakedQuad2) {
            return renderEnv.getArrayQuadsCtm(bakedQuad);
        }
        return renderEnv.getArrayQuadsCtm(bakedQuad);
    }
}

