/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.model;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.src.Config;
import net.minecraft.util.EnumFacing;

public class ModelUtils {
    public static void dbgModel(IBakedModel iBakedModel) {
        if (iBakedModel != null) {
            Config.dbg("Model: " + String.valueOf(iBakedModel) + ", ao: " + iBakedModel.isAmbientOcclusion() + ", gui3d: " + iBakedModel.isGui3d() + ", builtIn: " + iBakedModel.isBuiltInRenderer() + ", particle: " + String.valueOf(iBakedModel.getParticleTexture()));
            EnumFacing[] enumFacingArray = EnumFacing.VALUES;
            for (int i = 0; i < enumFacingArray.length; ++i) {
                EnumFacing enumFacing = enumFacingArray[i];
                List<BakedQuad> list = iBakedModel.getFaceQuads(enumFacing);
                ModelUtils.dbgQuads(enumFacing.getName(), list, "  ");
            }
            List<BakedQuad> list = iBakedModel.getGeneralQuads();
            ModelUtils.dbgQuads("General", list, "  ");
        }
    }

    private static void dbgQuads(String string, List list, String string2) {
        for (Object e : list) {
            BakedQuad bakedQuad = (BakedQuad)e;
            ModelUtils.dbgQuad(string, bakedQuad, string2);
        }
    }

    public static void dbgQuad(String string, BakedQuad bakedQuad, String string2) {
        Config.dbg(string2 + "Quad: " + bakedQuad.getClass().getName() + ", type: " + string + ", face: " + String.valueOf(bakedQuad.getFace()) + ", tint: " + bakedQuad.getTintIndex() + ", sprite: " + String.valueOf(bakedQuad.getSprite()));
        ModelUtils.dbgVertexData(bakedQuad.getVertexData(), "  " + string2);
    }

    public static void dbgVertexData(int[] nArray, String string) {
        int n = nArray.length / 4;
        Config.dbg(string + "Length: " + nArray.length + ", step: " + n);
        for (int i = 0; i < 4; ++i) {
            int n2 = i * n;
            float f = Float.intBitsToFloat(nArray[n2 + 0]);
            float f2 = Float.intBitsToFloat(nArray[n2 + 1]);
            float f3 = Float.intBitsToFloat(nArray[n2 + 2]);
            int n3 = nArray[n2 + 3];
            float f4 = Float.intBitsToFloat(nArray[n2 + 4]);
            float f5 = Float.intBitsToFloat(nArray[n2 + 5]);
            Config.dbg(string + i + " xyz: " + f + "," + f2 + "," + f3 + " col: " + n3 + " u,v: " + f4 + "," + f5);
        }
    }

    public static IBakedModel duplicateModel(IBakedModel iBakedModel) {
        List list = ModelUtils.duplicateQuadList(iBakedModel.getGeneralQuads());
        EnumFacing[] enumFacingArray = EnumFacing.VALUES;
        ArrayList<List<BakedQuad>> arrayList = new ArrayList<List<BakedQuad>>();
        for (int i = 0; i < enumFacingArray.length; ++i) {
            EnumFacing enumFacing = enumFacingArray[i];
            List<BakedQuad> list2 = iBakedModel.getFaceQuads(enumFacing);
            List list3 = ModelUtils.duplicateQuadList(list2);
            arrayList.add(list3);
        }
        SimpleBakedModel simpleBakedModel = new SimpleBakedModel(list, arrayList, iBakedModel.isAmbientOcclusion(), iBakedModel.isGui3d(), iBakedModel.getParticleTexture(), iBakedModel.getItemCameraTransforms());
        return simpleBakedModel;
    }

    public static List duplicateQuadList(List list) {
        ArrayList<BakedQuad> arrayList = new ArrayList<BakedQuad>();
        for (Object e : list) {
            BakedQuad bakedQuad = (BakedQuad)e;
            BakedQuad bakedQuad2 = ModelUtils.duplicateQuad(bakedQuad);
            arrayList.add(bakedQuad2);
        }
        return arrayList;
    }

    public static BakedQuad duplicateQuad(BakedQuad bakedQuad) {
        BakedQuad bakedQuad2 = new BakedQuad((int[])bakedQuad.getVertexData().clone(), bakedQuad.getTintIndex(), bakedQuad.getFace(), bakedQuad.getSprite());
        return bakedQuad2;
    }
}

