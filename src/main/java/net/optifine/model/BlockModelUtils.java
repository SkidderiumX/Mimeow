/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.model;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.client.renderer.block.model.BlockPartFace;
import net.minecraft.client.renderer.block.model.BlockPartRotation;
import net.minecraft.client.renderer.block.model.BreakingFour;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.ModelRotation;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.src.Config;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.optifine.model.ModelUtils;
import org.lwjgl.util.vector.Vector3f;

public class BlockModelUtils {
    private static final float VERTEX_COORD_ACCURACY = 1.0E-6f;

    public static IBakedModel makeModelCube(String string, int n) {
        TextureAtlasSprite textureAtlasSprite = Config.getMinecraft().getTextureMapBlocks().getAtlasSprite(string);
        return BlockModelUtils.makeModelCube(textureAtlasSprite, n);
    }

    public static IBakedModel makeModelCube(TextureAtlasSprite textureAtlasSprite, int n) {
        ArrayList<BakedQuad> arrayList = new ArrayList<BakedQuad>();
        EnumFacing[] enumFacingArray = EnumFacing.VALUES;
        ArrayList<List<BakedQuad>> arrayList2 = new ArrayList<List<BakedQuad>>();
        for (int i = 0; i < enumFacingArray.length; ++i) {
            EnumFacing enumFacing = enumFacingArray[i];
            ArrayList<BakedQuad> arrayList3 = new ArrayList<BakedQuad>();
            arrayList3.add(BlockModelUtils.makeBakedQuad(enumFacing, textureAtlasSprite, n));
            arrayList2.add(arrayList3);
        }
        SimpleBakedModel simpleBakedModel = new SimpleBakedModel(arrayList, arrayList2, true, true, textureAtlasSprite, ItemCameraTransforms.DEFAULT);
        return simpleBakedModel;
    }

    public static IBakedModel joinModelsCube(IBakedModel iBakedModel, IBakedModel iBakedModel2) {
        Object object;
        int n;
        ArrayList<BakedQuad> arrayList = new ArrayList<BakedQuad>();
        arrayList.addAll(iBakedModel.getGeneralQuads());
        arrayList.addAll(iBakedModel2.getGeneralQuads());
        EnumFacing[] enumFacingArray = EnumFacing.VALUES;
        ArrayList<List<BakedQuad>> arrayList2 = new ArrayList<List<BakedQuad>>();
        for (n = 0; n < enumFacingArray.length; ++n) {
            EnumFacing enumFacing = enumFacingArray[n];
            object = new ArrayList<BakedQuad>();
            object.addAll(iBakedModel.getFaceQuads(enumFacing));
            object.addAll(iBakedModel2.getFaceQuads(enumFacing));
            arrayList2.add((List<BakedQuad>)object);
        }
        n = iBakedModel.isAmbientOcclusion() ? 1 : 0;
        boolean bl = iBakedModel.isBuiltInRenderer();
        object = iBakedModel.getParticleTexture();
        ItemCameraTransforms itemCameraTransforms = iBakedModel.getItemCameraTransforms();
        SimpleBakedModel simpleBakedModel = new SimpleBakedModel(arrayList, arrayList2, n != 0, bl, (TextureAtlasSprite)object, itemCameraTransforms);
        return simpleBakedModel;
    }

    public static BakedQuad makeBakedQuad(EnumFacing enumFacing, TextureAtlasSprite textureAtlasSprite, int n) {
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 0.0f);
        Vector3f vector3f2 = new Vector3f(16.0f, 16.0f, 16.0f);
        BlockFaceUV blockFaceUV = new BlockFaceUV(new float[]{0.0f, 0.0f, 16.0f, 16.0f}, 0);
        BlockPartFace blockPartFace = new BlockPartFace(enumFacing, n, "#" + enumFacing.getName(), blockFaceUV);
        ModelRotation modelRotation = ModelRotation.X0_Y0;
        BlockPartRotation blockPartRotation = null;
        boolean bl = false;
        boolean bl2 = true;
        FaceBakery faceBakery = new FaceBakery();
        BakedQuad bakedQuad = faceBakery.makeBakedQuad(vector3f, vector3f2, blockPartFace, textureAtlasSprite, enumFacing, modelRotation, blockPartRotation, bl, bl2);
        return bakedQuad;
    }

    public static IBakedModel makeModel(String string, String string2, String string3) {
        TextureMap textureMap = Config.getMinecraft().getTextureMapBlocks();
        TextureAtlasSprite textureAtlasSprite = textureMap.getSpriteSafe(string2);
        TextureAtlasSprite textureAtlasSprite2 = textureMap.getSpriteSafe(string3);
        return BlockModelUtils.makeModel(string, textureAtlasSprite, textureAtlasSprite2);
    }

    public static IBakedModel makeModel(String string, TextureAtlasSprite textureAtlasSprite, TextureAtlasSprite textureAtlasSprite2) {
        if (textureAtlasSprite != null && textureAtlasSprite2 != null) {
            ModelManager modelManager = Config.getModelManager();
            if (modelManager == null) {
                return null;
            }
            ModelResourceLocation modelResourceLocation = new ModelResourceLocation(string, "normal");
            IBakedModel iBakedModel = modelManager.getModel(modelResourceLocation);
            if (iBakedModel != null && iBakedModel != modelManager.getMissingModel()) {
                IBakedModel iBakedModel2 = ModelUtils.duplicateModel(iBakedModel);
                EnumFacing[] enumFacingArray = EnumFacing.VALUES;
                for (int i = 0; i < enumFacingArray.length; ++i) {
                    EnumFacing enumFacing = enumFacingArray[i];
                    List<BakedQuad> list = iBakedModel2.getFaceQuads(enumFacing);
                    BlockModelUtils.replaceTexture(list, textureAtlasSprite, textureAtlasSprite2);
                }
                List<BakedQuad> list = iBakedModel2.getGeneralQuads();
                BlockModelUtils.replaceTexture(list, textureAtlasSprite, textureAtlasSprite2);
                return iBakedModel2;
            }
            return null;
        }
        return null;
    }

    private static void replaceTexture(List<BakedQuad> list, TextureAtlasSprite textureAtlasSprite, TextureAtlasSprite textureAtlasSprite2) {
        ArrayList<BakedQuad> arrayList = new ArrayList<BakedQuad>();
        for (BakedQuad bakedQuad : list) {
            if (bakedQuad.getSprite() == textureAtlasSprite) {
                bakedQuad = new BreakingFour(bakedQuad, textureAtlasSprite2);
            }
            arrayList.add(bakedQuad);
        }
        list.clear();
        list.addAll(arrayList);
    }

    public static void snapVertexPosition(Vector3f vector3f) {
        vector3f.setX(BlockModelUtils.snapVertexCoord(vector3f.getX()));
        vector3f.setY(BlockModelUtils.snapVertexCoord(vector3f.getY()));
        vector3f.setZ(BlockModelUtils.snapVertexCoord(vector3f.getZ()));
    }

    private static float snapVertexCoord(float f) {
        return f > -1.0E-6f && f < 1.0E-6f ? 0.0f : (f > 0.999999f && f < 1.000001f ? 1.0f : f);
    }

    public static AxisAlignedBB getOffsetBoundingBox(AxisAlignedBB axisAlignedBB, Block.EnumOffsetType enumOffsetType, BlockPos blockPos) {
        int n = blockPos.getX();
        int n2 = blockPos.getZ();
        long l = (long)(n * 3129871) ^ (long)n2 * 116129781L;
        l = l * l * 42317861L + l * 11L;
        double d = ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.5;
        double d2 = ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.5;
        double d3 = 0.0;
        if (enumOffsetType == Block.EnumOffsetType.XYZ) {
            d3 = ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 1.0) * 0.2;
        }
        return axisAlignedBB.offset(d, d3, d2);
    }
}

