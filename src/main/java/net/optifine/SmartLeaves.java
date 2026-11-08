/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.src.Config;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.optifine.model.ModelUtils;

public class SmartLeaves {
    private static IBakedModel modelLeavesCullAcacia = null;
    private static IBakedModel modelLeavesCullBirch = null;
    private static IBakedModel modelLeavesCullDarkOak = null;
    private static IBakedModel modelLeavesCullJungle = null;
    private static IBakedModel modelLeavesCullOak = null;
    private static IBakedModel modelLeavesCullSpruce = null;
    private static List generalQuadsCullAcacia = null;
    private static List generalQuadsCullBirch = null;
    private static List generalQuadsCullDarkOak = null;
    private static List generalQuadsCullJungle = null;
    private static List generalQuadsCullOak = null;
    private static List generalQuadsCullSpruce = null;
    private static IBakedModel modelLeavesDoubleAcacia = null;
    private static IBakedModel modelLeavesDoubleBirch = null;
    private static IBakedModel modelLeavesDoubleDarkOak = null;
    private static IBakedModel modelLeavesDoubleJungle = null;
    private static IBakedModel modelLeavesDoubleOak = null;
    private static IBakedModel modelLeavesDoubleSpruce = null;

    public static IBakedModel getLeavesModel(IBakedModel iBakedModel, IBlockState iBlockState) {
        if (!Config.isTreesSmart()) {
            return iBakedModel;
        }
        List<BakedQuad> list = iBakedModel.getGeneralQuads();
        return list == generalQuadsCullAcacia ? modelLeavesDoubleAcacia : (list == generalQuadsCullBirch ? modelLeavesDoubleBirch : (list == generalQuadsCullDarkOak ? modelLeavesDoubleDarkOak : (list == generalQuadsCullJungle ? modelLeavesDoubleJungle : (list == generalQuadsCullOak ? modelLeavesDoubleOak : (list == generalQuadsCullSpruce ? modelLeavesDoubleSpruce : iBakedModel)))));
    }

    public static boolean isSameLeaves(IBlockState iBlockState, IBlockState iBlockState2) {
        Block block;
        if (iBlockState == iBlockState2) {
            return true;
        }
        Block block2 = iBlockState.getBlock();
        return block2 != (block = iBlockState2.getBlock()) ? false : (block2 instanceof BlockOldLeaf ? iBlockState.getValue(BlockOldLeaf.VARIANT).equals(iBlockState2.getValue(BlockOldLeaf.VARIANT)) : (block2 instanceof BlockNewLeaf ? iBlockState.getValue(BlockNewLeaf.VARIANT).equals(iBlockState2.getValue(BlockNewLeaf.VARIANT)) : false));
    }

    public static void updateLeavesModels() {
        ArrayList arrayList = new ArrayList();
        modelLeavesCullAcacia = SmartLeaves.getModelCull("acacia", arrayList);
        modelLeavesCullBirch = SmartLeaves.getModelCull("birch", arrayList);
        modelLeavesCullDarkOak = SmartLeaves.getModelCull("dark_oak", arrayList);
        modelLeavesCullJungle = SmartLeaves.getModelCull("jungle", arrayList);
        modelLeavesCullOak = SmartLeaves.getModelCull("oak", arrayList);
        modelLeavesCullSpruce = SmartLeaves.getModelCull("spruce", arrayList);
        generalQuadsCullAcacia = SmartLeaves.getGeneralQuadsSafe(modelLeavesCullAcacia);
        generalQuadsCullBirch = SmartLeaves.getGeneralQuadsSafe(modelLeavesCullBirch);
        generalQuadsCullDarkOak = SmartLeaves.getGeneralQuadsSafe(modelLeavesCullDarkOak);
        generalQuadsCullJungle = SmartLeaves.getGeneralQuadsSafe(modelLeavesCullJungle);
        generalQuadsCullOak = SmartLeaves.getGeneralQuadsSafe(modelLeavesCullOak);
        generalQuadsCullSpruce = SmartLeaves.getGeneralQuadsSafe(modelLeavesCullSpruce);
        modelLeavesDoubleAcacia = SmartLeaves.getModelDoubleFace(modelLeavesCullAcacia);
        modelLeavesDoubleBirch = SmartLeaves.getModelDoubleFace(modelLeavesCullBirch);
        modelLeavesDoubleDarkOak = SmartLeaves.getModelDoubleFace(modelLeavesCullDarkOak);
        modelLeavesDoubleJungle = SmartLeaves.getModelDoubleFace(modelLeavesCullJungle);
        modelLeavesDoubleOak = SmartLeaves.getModelDoubleFace(modelLeavesCullOak);
        modelLeavesDoubleSpruce = SmartLeaves.getModelDoubleFace(modelLeavesCullSpruce);
        if (arrayList.size() > 0) {
            Config.dbg("Enable face culling: " + Config.arrayToString(arrayList.toArray()));
        }
    }

    private static List getGeneralQuadsSafe(IBakedModel iBakedModel) {
        return iBakedModel == null ? null : iBakedModel.getGeneralQuads();
    }

    static IBakedModel getModelCull(String string, List list) {
        ModelManager modelManager = Config.getModelManager();
        if (modelManager == null) {
            return null;
        }
        ResourceLocation resourceLocation = new ResourceLocation("blockstates/" + string + "_leaves.json");
        if (Config.getDefiningResourcePack(resourceLocation) != Config.getDefaultResourcePack()) {
            return null;
        }
        ResourceLocation resourceLocation2 = new ResourceLocation("models/block/" + string + "_leaves.json");
        if (Config.getDefiningResourcePack(resourceLocation2) != Config.getDefaultResourcePack()) {
            return null;
        }
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(string + "_leaves", "normal");
        IBakedModel iBakedModel = modelManager.getModel(modelResourceLocation);
        if (iBakedModel != null && iBakedModel != modelManager.getMissingModel()) {
            List<BakedQuad> list2 = iBakedModel.getGeneralQuads();
            if (list2.size() == 0) {
                return iBakedModel;
            }
            if (list2.size() != 6) {
                return null;
            }
            for (BakedQuad bakedQuad : list2) {
                BakedQuad bakedQuad2 = bakedQuad;
                List<BakedQuad> list3 = iBakedModel.getFaceQuads(bakedQuad2.getFace());
                if (list3.size() > 0) {
                    return null;
                }
                list3.add(bakedQuad2);
            }
            list2.clear();
            list.add(string + "_leaves");
            return iBakedModel;
        }
        return null;
    }

    private static IBakedModel getModelDoubleFace(IBakedModel iBakedModel) {
        List[] listArray;
        if (iBakedModel == null) {
            return null;
        }
        if (iBakedModel.getGeneralQuads().size() > 0) {
            Config.warn("SmartLeaves: Model is not cube, general quads: " + iBakedModel.getGeneralQuads().size() + ", model: " + String.valueOf(iBakedModel));
            return iBakedModel;
        }
        EnumFacing[] enumFacingArray = EnumFacing.VALUES;
        for (int i = 0; i < enumFacingArray.length; ++i) {
            listArray = enumFacingArray[i];
            List<BakedQuad> list = iBakedModel.getFaceQuads((EnumFacing)listArray);
            if (list.size() == 1) continue;
            Config.warn("SmartLeaves: Model is not cube, side: " + String.valueOf(listArray) + ", quads: " + list.size() + ", model: " + String.valueOf(iBakedModel));
            return iBakedModel;
        }
        IBakedModel iBakedModel2 = ModelUtils.duplicateModel(iBakedModel);
        listArray = new List[enumFacingArray.length];
        for (int i = 0; i < enumFacingArray.length; ++i) {
            EnumFacing enumFacing = enumFacingArray[i];
            List<BakedQuad> list = iBakedModel2.getFaceQuads(enumFacing);
            BakedQuad bakedQuad = list.get(0);
            BakedQuad bakedQuad2 = new BakedQuad((int[])bakedQuad.getVertexData().clone(), bakedQuad.getTintIndex(), bakedQuad.getFace(), bakedQuad.getSprite());
            int[] nArray = bakedQuad2.getVertexData();
            int[] nArray2 = (int[])nArray.clone();
            int n = nArray.length / 4;
            System.arraycopy(nArray, 0 * n, nArray2, 3 * n, n);
            System.arraycopy(nArray, 1 * n, nArray2, 2 * n, n);
            System.arraycopy(nArray, 2 * n, nArray2, 1 * n, n);
            System.arraycopy(nArray, 3 * n, nArray2, 0 * n, n);
            System.arraycopy(nArray2, 0, nArray, 0, nArray2.length);
            list.add(bakedQuad2);
        }
        return iBakedModel2;
    }
}

