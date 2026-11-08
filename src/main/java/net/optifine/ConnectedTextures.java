/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.BetterGrass;
import net.optifine.BlockDir;
import net.optifine.ConnectedProperties;
import net.optifine.ConnectedTexturesCompact;
import net.optifine.config.Matches;
import net.optifine.model.BlockModelUtils;
import net.optifine.model.ListQuadsOverlay;
import net.optifine.reflect.Reflector;
import net.optifine.render.RenderEnv;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.ResUtils;
import net.optifine.util.TileEntityUtils;

public class ConnectedTextures {
    private static Map[] spriteQuadMaps = null;
    private static Map[] spriteQuadFullMaps = null;
    private static Map[][] spriteQuadCompactMaps = null;
    private static ConnectedProperties[][] blockProperties = null;
    private static ConnectedProperties[][] tileProperties = null;
    private static boolean multipass = false;
    protected static final int UNKNOWN = -1;
    protected static final int Y_NEG_DOWN = 0;
    protected static final int Y_POS_UP = 1;
    protected static final int Z_NEG_NORTH = 2;
    protected static final int Z_POS_SOUTH = 3;
    protected static final int X_NEG_WEST = 4;
    protected static final int X_POS_EAST = 5;
    private static final int Y_AXIS = 0;
    private static final int Z_AXIS = 1;
    private static final int X_AXIS = 2;
    public static final IBlockState AIR_DEFAULT_STATE = Blocks.air.getDefaultState();
    private static TextureAtlasSprite emptySprite = null;
    private static final BlockDir[] SIDES_Y_NEG_DOWN = new BlockDir[]{BlockDir.WEST, BlockDir.EAST, BlockDir.NORTH, BlockDir.SOUTH};
    private static final BlockDir[] SIDES_Y_POS_UP = new BlockDir[]{BlockDir.WEST, BlockDir.EAST, BlockDir.SOUTH, BlockDir.NORTH};
    private static final BlockDir[] SIDES_Z_NEG_NORTH = new BlockDir[]{BlockDir.EAST, BlockDir.WEST, BlockDir.DOWN, BlockDir.UP};
    private static final BlockDir[] SIDES_Z_POS_SOUTH = new BlockDir[]{BlockDir.WEST, BlockDir.EAST, BlockDir.DOWN, BlockDir.UP};
    private static final BlockDir[] SIDES_X_NEG_WEST = new BlockDir[]{BlockDir.NORTH, BlockDir.SOUTH, BlockDir.DOWN, BlockDir.UP};
    private static final BlockDir[] SIDES_X_POS_EAST = new BlockDir[]{BlockDir.SOUTH, BlockDir.NORTH, BlockDir.DOWN, BlockDir.UP};
    private static final BlockDir[] SIDES_Z_NEG_NORTH_Z_AXIS = new BlockDir[]{BlockDir.WEST, BlockDir.EAST, BlockDir.UP, BlockDir.DOWN};
    private static final BlockDir[] SIDES_X_POS_EAST_X_AXIS = new BlockDir[]{BlockDir.NORTH, BlockDir.SOUTH, BlockDir.UP, BlockDir.DOWN};
    private static final BlockDir[] EDGES_Y_NEG_DOWN = new BlockDir[]{BlockDir.NORTH_EAST, BlockDir.NORTH_WEST, BlockDir.SOUTH_EAST, BlockDir.SOUTH_WEST};
    private static final BlockDir[] EDGES_Y_POS_UP = new BlockDir[]{BlockDir.SOUTH_EAST, BlockDir.SOUTH_WEST, BlockDir.NORTH_EAST, BlockDir.NORTH_WEST};
    private static final BlockDir[] EDGES_Z_NEG_NORTH = new BlockDir[]{BlockDir.DOWN_WEST, BlockDir.DOWN_EAST, BlockDir.UP_WEST, BlockDir.UP_EAST};
    private static final BlockDir[] EDGES_Z_POS_SOUTH = new BlockDir[]{BlockDir.DOWN_EAST, BlockDir.DOWN_WEST, BlockDir.UP_EAST, BlockDir.UP_WEST};
    private static final BlockDir[] EDGES_X_NEG_WEST = new BlockDir[]{BlockDir.DOWN_SOUTH, BlockDir.DOWN_NORTH, BlockDir.UP_SOUTH, BlockDir.UP_NORTH};
    private static final BlockDir[] EDGES_X_POS_EAST = new BlockDir[]{BlockDir.DOWN_NORTH, BlockDir.DOWN_SOUTH, BlockDir.UP_NORTH, BlockDir.UP_SOUTH};
    private static final BlockDir[] EDGES_Z_NEG_NORTH_Z_AXIS = new BlockDir[]{BlockDir.UP_EAST, BlockDir.UP_WEST, BlockDir.DOWN_EAST, BlockDir.DOWN_WEST};
    private static final BlockDir[] EDGES_X_POS_EAST_X_AXIS = new BlockDir[]{BlockDir.UP_SOUTH, BlockDir.UP_NORTH, BlockDir.DOWN_SOUTH, BlockDir.DOWN_NORTH};
    public static final TextureAtlasSprite SPRITE_DEFAULT = new TextureAtlasSprite("<default>");

    public static BakedQuad[] getConnectedTexture(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, BakedQuad bakedQuad, RenderEnv renderEnv) {
        TextureAtlasSprite textureAtlasSprite = bakedQuad.getSprite();
        if (textureAtlasSprite == null) {
            return renderEnv.getArrayQuadsCtm(bakedQuad);
        }
        Block block = iBlockState.getBlock();
        if (ConnectedTextures.skipConnectedTexture(iBlockAccess, iBlockState, blockPos, bakedQuad, renderEnv)) {
            bakedQuad = ConnectedTextures.getQuad(emptySprite, bakedQuad);
            return renderEnv.getArrayQuadsCtm(bakedQuad);
        }
        EnumFacing enumFacing = bakedQuad.getFace();
        BakedQuad[] bakedQuadArray = ConnectedTextures.getConnectedTextureMultiPass(iBlockAccess, iBlockState, blockPos, enumFacing, bakedQuad, renderEnv);
        return bakedQuadArray;
    }

    private static boolean skipConnectedTexture(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, BakedQuad bakedQuad, RenderEnv renderEnv) {
        Object object;
        Block block = iBlockState.getBlock();
        if (block instanceof BlockPane && ((TextureAtlasSprite)(object = bakedQuad.getSprite())).getIconName().startsWith("minecraft:blocks/glass_pane_top")) {
            IBlockState iBlockState2 = iBlockAccess.getBlockState(blockPos.offset(bakedQuad.getFace()));
            return iBlockState2 == iBlockState;
        }
        if (block instanceof BlockPane) {
            object = bakedQuad.getFace();
            if (object != EnumFacing.UP && object != EnumFacing.DOWN) {
                return false;
            }
            if (!bakedQuad.isFaceQuad()) {
                return false;
            }
            BlockPos blockPos2 = blockPos.offset(bakedQuad.getFace());
            IBlockState iBlockState3 = iBlockAccess.getBlockState(blockPos2);
            if (iBlockState3.getBlock() != block) {
                return false;
            }
            if (block == Blocks.stained_glass_pane && iBlockState3.getValue(BlockStainedGlassPane.COLOR) != iBlockState.getValue(BlockStainedGlassPane.COLOR)) {
                return false;
            }
            iBlockState3 = iBlockState3.getBlock().getActualState(iBlockState3, iBlockAccess, blockPos2);
            double d = bakedQuad.getMidX();
            if (d < 0.4) {
                if (iBlockState3.getValue(BlockPane.WEST).booleanValue()) {
                    return true;
                }
            } else if (d > 0.6) {
                if (iBlockState3.getValue(BlockPane.EAST).booleanValue()) {
                    return true;
                }
            } else {
                double d2 = bakedQuad.getMidZ();
                if (d2 < 0.4) {
                    if (iBlockState3.getValue(BlockPane.NORTH).booleanValue()) {
                        return true;
                    }
                } else {
                    if (d2 <= 0.6) {
                        return true;
                    }
                    if (iBlockState3.getValue(BlockPane.SOUTH).booleanValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected static BakedQuad[] getQuads(TextureAtlasSprite textureAtlasSprite, BakedQuad bakedQuad, RenderEnv renderEnv) {
        if (textureAtlasSprite == null) {
            return null;
        }
        if (textureAtlasSprite == SPRITE_DEFAULT) {
            return renderEnv.getArrayQuadsCtm(bakedQuad);
        }
        BakedQuad bakedQuad2 = ConnectedTextures.getQuad(textureAtlasSprite, bakedQuad);
        BakedQuad[] bakedQuadArray = renderEnv.getArrayQuadsCtm(bakedQuad2);
        return bakedQuadArray;
    }

    private static synchronized BakedQuad getQuad(TextureAtlasSprite textureAtlasSprite, BakedQuad bakedQuad) {
        if (spriteQuadMaps == null) {
            return bakedQuad;
        }
        int n = textureAtlasSprite.getIndexInMap();
        if (n >= 0 && n < spriteQuadMaps.length) {
            BakedQuad bakedQuad2;
            IdentityHashMap<BakedQuad, BakedQuad> identityHashMap = spriteQuadMaps[n];
            if (identityHashMap == null) {
                ConnectedTextures.spriteQuadMaps[n] = identityHashMap = new IdentityHashMap<BakedQuad, BakedQuad>(1);
            }
            if ((bakedQuad2 = (BakedQuad)identityHashMap.get(bakedQuad)) == null) {
                bakedQuad2 = ConnectedTextures.makeSpriteQuad(bakedQuad, textureAtlasSprite);
                identityHashMap.put(bakedQuad, bakedQuad2);
            }
            return bakedQuad2;
        }
        return bakedQuad;
    }

    private static synchronized BakedQuad getQuadFull(TextureAtlasSprite textureAtlasSprite, BakedQuad bakedQuad, int n) {
        if (spriteQuadFullMaps == null) {
            return null;
        }
        if (textureAtlasSprite == null) {
            return null;
        }
        int n2 = textureAtlasSprite.getIndexInMap();
        if (n2 >= 0 && n2 < spriteQuadFullMaps.length) {
            EnumFacing enumFacing;
            BakedQuad bakedQuad2;
            EnumMap<EnumFacing, BakedQuad> enumMap = spriteQuadFullMaps[n2];
            if (enumMap == null) {
                ConnectedTextures.spriteQuadFullMaps[n2] = enumMap = new EnumMap<EnumFacing, BakedQuad>(EnumFacing.class);
            }
            if ((bakedQuad2 = (BakedQuad)enumMap.get(enumFacing = bakedQuad.getFace())) == null) {
                bakedQuad2 = BlockModelUtils.makeBakedQuad(enumFacing, textureAtlasSprite, n);
                enumMap.put(enumFacing, bakedQuad2);
            }
            return bakedQuad2;
        }
        return null;
    }

    private static BakedQuad makeSpriteQuad(BakedQuad bakedQuad, TextureAtlasSprite textureAtlasSprite) {
        int[] nArray = (int[])bakedQuad.getVertexData().clone();
        TextureAtlasSprite textureAtlasSprite2 = bakedQuad.getSprite();
        for (int i = 0; i < 4; ++i) {
            ConnectedTextures.fixVertex(nArray, i, textureAtlasSprite2, textureAtlasSprite);
        }
        BakedQuad bakedQuad2 = new BakedQuad(nArray, bakedQuad.getTintIndex(), bakedQuad.getFace(), textureAtlasSprite);
        return bakedQuad2;
    }

    private static void fixVertex(int[] nArray, int n, TextureAtlasSprite textureAtlasSprite, TextureAtlasSprite textureAtlasSprite2) {
        int n2 = nArray.length / 4;
        int n3 = n2 * n;
        float f = Float.intBitsToFloat(nArray[n3 + 4]);
        float f2 = Float.intBitsToFloat(nArray[n3 + 4 + 1]);
        double d = textureAtlasSprite.getSpriteU16(f);
        double d2 = textureAtlasSprite.getSpriteV16(f2);
        nArray[n3 + 4] = Float.floatToRawIntBits(textureAtlasSprite2.getInterpolatedU(d));
        nArray[n3 + 4 + 1] = Float.floatToRawIntBits(textureAtlasSprite2.getInterpolatedV(d2));
    }

    private static BakedQuad[] getConnectedTextureMultiPass(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, BakedQuad bakedQuad, RenderEnv renderEnv) {
        int n;
        BakedQuad[] bakedQuadArray = ConnectedTextures.getConnectedTextureSingle(iBlockAccess, iBlockState, blockPos, enumFacing, bakedQuad, true, 0, renderEnv);
        if (!multipass) {
            return bakedQuadArray;
        }
        if (bakedQuadArray.length == 1 && bakedQuadArray[0] == bakedQuad) {
            return bakedQuadArray;
        }
        List<BakedQuad> list = renderEnv.getListQuadsCtmMultipass(bakedQuadArray);
        for (n = 0; n < list.size(); ++n) {
            BakedQuad[] bakedQuadArray2;
            BakedQuad bakedQuad2;
            BakedQuad bakedQuad3 = bakedQuad2 = list.get(n);
            for (int i = 0; i < 3 && (bakedQuadArray2 = ConnectedTextures.getConnectedTextureSingle(iBlockAccess, iBlockState, blockPos, enumFacing, bakedQuad3, false, i + 1, renderEnv)).length == 1 && bakedQuadArray2[0] != bakedQuad3; ++i) {
                bakedQuad3 = bakedQuadArray2[0];
            }
            list.set(n, bakedQuad3);
        }
        for (n = 0; n < bakedQuadArray.length; ++n) {
            bakedQuadArray[n] = list.get(n);
        }
        return bakedQuadArray;
    }

    public static BakedQuad[] getConnectedTextureSingle(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, BakedQuad bakedQuad, boolean bl, int n, RenderEnv renderEnv) {
        BakedQuad[] bakedQuadArray;
        ConnectedProperties connectedProperties;
        int n2;
        int n3;
        ConnectedProperties[] connectedPropertiesArray;
        int n4;
        Block block = iBlockState.getBlock();
        if (!(iBlockState instanceof BlockStateBase)) {
            return renderEnv.getArrayQuadsCtm(bakedQuad);
        }
        BlockStateBase blockStateBase = (BlockStateBase)iBlockState;
        TextureAtlasSprite textureAtlasSprite = bakedQuad.getSprite();
        if (tileProperties != null && (n4 = textureAtlasSprite.getIndexInMap()) >= 0 && n4 < tileProperties.length && (connectedPropertiesArray = tileProperties[n4]) != null) {
            n3 = ConnectedTextures.getSide(enumFacing);
            for (n2 = 0; n2 < connectedPropertiesArray.length; ++n2) {
                connectedProperties = connectedPropertiesArray[n2];
                if (connectedProperties == null || !connectedProperties.matchesBlockId(blockStateBase.getBlockId()) || (bakedQuadArray = ConnectedTextures.getConnectedTexture(connectedProperties, iBlockAccess, blockStateBase, blockPos, n3, bakedQuad, n, renderEnv)) == null) continue;
                return bakedQuadArray;
            }
        }
        if (blockProperties != null && bl && (n4 = renderEnv.getBlockId()) >= 0 && n4 < blockProperties.length && (connectedPropertiesArray = blockProperties[n4]) != null) {
            n3 = ConnectedTextures.getSide(enumFacing);
            for (n2 = 0; n2 < connectedPropertiesArray.length; ++n2) {
                connectedProperties = connectedPropertiesArray[n2];
                if (connectedProperties == null || !connectedProperties.matchesIcon(textureAtlasSprite) || (bakedQuadArray = ConnectedTextures.getConnectedTexture(connectedProperties, iBlockAccess, blockStateBase, blockPos, n3, bakedQuad, n, renderEnv)) == null) continue;
                return bakedQuadArray;
            }
        }
        return renderEnv.getArrayQuadsCtm(bakedQuad);
    }

    public static int getSide(EnumFacing enumFacing) {
        if (enumFacing == null) {
            return -1;
        }
        switch (enumFacing) {
            case DOWN: {
                return 0;
            }
            case UP: {
                return 1;
            }
            case EAST: {
                return 5;
            }
            case WEST: {
                return 4;
            }
            case NORTH: {
                return 2;
            }
            case SOUTH: {
                return 3;
            }
        }
        return -1;
    }

    private static EnumFacing getFacing(int n) {
        switch (n) {
            case 0: {
                return EnumFacing.DOWN;
            }
            case 1: {
                return EnumFacing.UP;
            }
            case 2: {
                return EnumFacing.NORTH;
            }
            case 3: {
                return EnumFacing.SOUTH;
            }
            case 4: {
                return EnumFacing.WEST;
            }
            case 5: {
                return EnumFacing.EAST;
            }
        }
        return EnumFacing.UP;
    }

    private static BakedQuad[] getConnectedTexture(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, BlockStateBase blockStateBase, BlockPos blockPos, int n, BakedQuad bakedQuad, int n2, RenderEnv renderEnv) {
        Object object;
        int n3;
        int n4;
        int n5 = 0;
        int n6 = n4 = blockStateBase.getMetadata();
        Block block = blockStateBase.getBlock();
        if (block instanceof BlockRotatedPillar) {
            n5 = ConnectedTextures.getWoodAxis(n, n4);
            if (connectedProperties.getMetadataMax() <= 3) {
                n6 = n4 & 3;
            }
        }
        if (block instanceof BlockQuartz) {
            n5 = ConnectedTextures.getQuartzAxis(n, n4);
            if (connectedProperties.getMetadataMax() <= 2 && n6 > 2) {
                n6 = 2;
            }
        }
        if (!connectedProperties.matchesBlock(blockStateBase.getBlockId(), n6)) {
            return null;
        }
        if (n >= 0 && connectedProperties.faces != 63) {
            n3 = n;
            if (n5 != 0) {
                n3 = ConnectedTextures.fixSideByAxis(n, n5);
            }
            if ((1 << n3 & connectedProperties.faces) == 0) {
                return null;
            }
        }
        n3 = blockPos.getY();
        if (connectedProperties.heights != null && !connectedProperties.heights.isInRange(n3)) {
            return null;
        }
        if (connectedProperties.biomes != null && !connectedProperties.matchesBiome((BiomeGenBase)(object = iBlockAccess.getBiomeGenForCoords(blockPos)))) {
            return null;
        }
        if (connectedProperties.nbtName != null && !connectedProperties.nbtName.matchesValue((String)(object = TileEntityUtils.getTileEntityName(iBlockAccess, blockPos)))) {
            return null;
        }
        object = bakedQuad.getSprite();
        switch (connectedProperties.method) {
            case 1: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureCtm(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, (TextureAtlasSprite)object, n4, renderEnv), bakedQuad, renderEnv);
            }
            case 2: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureHorizontal(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, (TextureAtlasSprite)object, n4), bakedQuad, renderEnv);
            }
            case 3: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureTop(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, (TextureAtlasSprite)object, n4), bakedQuad, renderEnv);
            }
            case 4: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureRandom(connectedProperties, iBlockAccess, blockStateBase, blockPos, n), bakedQuad, renderEnv);
            }
            case 5: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureRepeat(connectedProperties, blockPos, n), bakedQuad, renderEnv);
            }
            case 6: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureVertical(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, (TextureAtlasSprite)object, n4), bakedQuad, renderEnv);
            }
            case 7: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureFixed(connectedProperties), bakedQuad, renderEnv);
            }
            case 8: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureHorizontalVertical(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, (TextureAtlasSprite)object, n4), bakedQuad, renderEnv);
            }
            case 9: {
                return ConnectedTextures.getQuads(ConnectedTextures.getConnectedTextureVerticalHorizontal(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, (TextureAtlasSprite)object, n4), bakedQuad, renderEnv);
            }
            case 10: {
                if (n2 == 0) {
                    return ConnectedTextures.getConnectedTextureCtmCompact(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, bakedQuad, n4, renderEnv);
                }
            }
            default: {
                return null;
            }
            case 11: {
                return ConnectedTextures.getConnectedTextureOverlay(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, bakedQuad, n4, renderEnv);
            }
            case 12: {
                return ConnectedTextures.getConnectedTextureOverlayFixed(connectedProperties, bakedQuad, renderEnv);
            }
            case 13: {
                return ConnectedTextures.getConnectedTextureOverlayRandom(connectedProperties, iBlockAccess, blockStateBase, blockPos, n, bakedQuad, renderEnv);
            }
            case 14: {
                return ConnectedTextures.getConnectedTextureOverlayRepeat(connectedProperties, blockPos, n, bakedQuad, renderEnv);
            }
            case 15: 
        }
        return ConnectedTextures.getConnectedTextureOverlayCtm(connectedProperties, iBlockAccess, blockStateBase, blockPos, n5, n, bakedQuad, n4, renderEnv);
    }

    private static int fixSideByAxis(int n, int n2) {
        switch (n2) {
            case 0: {
                return n;
            }
            case 1: {
                switch (n) {
                    case 0: {
                        return 2;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 1;
                    }
                    case 3: {
                        return 0;
                    }
                }
                return n;
            }
            case 2: {
                switch (n) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 5;
                    }
                    default: {
                        return n;
                    }
                    case 4: {
                        return 1;
                    }
                    case 5: 
                }
                return 0;
            }
        }
        return n;
    }

    private static int getWoodAxis(int n, int n2) {
        int n3 = (n2 & 0xC) >> 2;
        switch (n3) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
        }
        return 0;
    }

    private static int getQuartzAxis(int n, int n2) {
        switch (n2) {
            case 3: {
                return 2;
            }
            case 4: {
                return 1;
            }
        }
        return 0;
    }

    private static TextureAtlasSprite getConnectedTextureRandom(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, BlockStateBase blockStateBase, BlockPos blockPos, int n) {
        int n2;
        if (connectedProperties.tileIcons.length == 1) {
            return connectedProperties.tileIcons[0];
        }
        int n3 = n / connectedProperties.symmetry * connectedProperties.symmetry;
        if (connectedProperties.linked) {
            BlockPos blockPos2 = blockPos.down();
            IBlockState iBlockState = iBlockAccess.getBlockState(blockPos2);
            while (iBlockState.getBlock() == blockStateBase.getBlock()) {
                blockPos = blockPos2;
                if ((blockPos2 = blockPos2.down()).getY() < 0) break;
                iBlockState = iBlockAccess.getBlockState(blockPos2);
            }
        }
        int n4 = Config.getRandom(blockPos, n3) & Integer.MAX_VALUE;
        for (n2 = 0; n2 < connectedProperties.randomLoops; ++n2) {
            n4 = Config.intHash(n4);
        }
        n2 = 0;
        if (connectedProperties.weights == null) {
            n2 = n4 % connectedProperties.tileIcons.length;
        } else {
            int n5 = n4 % connectedProperties.sumAllWeights;
            int[] nArray = connectedProperties.sumWeights;
            for (int i = 0; i < nArray.length; ++i) {
                if (n5 >= nArray[i]) continue;
                n2 = i;
                break;
            }
        }
        return connectedProperties.tileIcons[n2];
    }

    private static TextureAtlasSprite getConnectedTextureFixed(ConnectedProperties connectedProperties) {
        return connectedProperties.tileIcons[0];
    }

    private static TextureAtlasSprite getConnectedTextureRepeat(ConnectedProperties connectedProperties, BlockPos blockPos, int n) {
        if (connectedProperties.tileIcons.length == 1) {
            return connectedProperties.tileIcons[0];
        }
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = 0;
        int n6 = 0;
        switch (n) {
            case 0: {
                n5 = n2;
                n6 = -n4 - 1;
                break;
            }
            case 1: {
                n5 = n2;
                n6 = n4;
                break;
            }
            case 2: {
                n5 = -n2 - 1;
                n6 = -n3;
                break;
            }
            case 3: {
                n5 = n2;
                n6 = -n3;
                break;
            }
            case 4: {
                n5 = n4;
                n6 = -n3;
                break;
            }
            case 5: {
                n5 = -n4 - 1;
                n6 = -n3;
            }
        }
        n6 %= connectedProperties.height;
        if ((n5 %= connectedProperties.width) < 0) {
            n5 += connectedProperties.width;
        }
        if (n6 < 0) {
            n6 += connectedProperties.height;
        }
        int n7 = n6 * connectedProperties.width + n5;
        return connectedProperties.tileIcons[n7];
    }

    private static TextureAtlasSprite getConnectedTextureCtm(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3, RenderEnv renderEnv) {
        int n4 = ConnectedTextures.getConnectedTextureCtmIndex(connectedProperties, iBlockAccess, iBlockState, blockPos, n, n2, textureAtlasSprite, n3, renderEnv);
        return connectedProperties.tileIcons[n4];
    }

    private static synchronized BakedQuad[] getConnectedTextureCtmCompact(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, BakedQuad bakedQuad, int n3, RenderEnv renderEnv) {
        TextureAtlasSprite textureAtlasSprite = bakedQuad.getSprite();
        int n4 = ConnectedTextures.getConnectedTextureCtmIndex(connectedProperties, iBlockAccess, iBlockState, blockPos, n, n2, textureAtlasSprite, n3, renderEnv);
        return ConnectedTexturesCompact.getConnectedTextureCtmCompact(n4, connectedProperties, n2, bakedQuad, renderEnv);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BakedQuad[] getConnectedTextureOverlay(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, BakedQuad bakedQuad, int n3, RenderEnv renderEnv) {
        Object var13_18;
        if (!bakedQuad.isFullQuad()) {
            return null;
        }
        TextureAtlasSprite textureAtlasSprite = bakedQuad.getSprite();
        BlockDir[] blockDirArray = ConnectedTextures.getSideDirections(n2, n);
        boolean[] blArray = renderEnv.getBorderFlags();
        for (int i = 0; i < 4; ++i) {
            blArray[i] = ConnectedTextures.isNeighbourOverlay(connectedProperties, iBlockAccess, iBlockState, blockDirArray[i].offset(blockPos), n2, textureAtlasSprite, n3);
        }
        ListQuadsOverlay listQuadsOverlay = renderEnv.getListQuadsOverlay(connectedProperties.layer);
        try {
            if (!(blArray[0] && blArray[1] && blArray[2] && blArray[3])) {
                if (blArray[0] && blArray[1] && blArray[2]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[5], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    Object var13_14 = null;
                    BakedQuad[] bakedQuadArray = var13_14;
                    return bakedQuadArray;
                }
                if (blArray[0] && blArray[2] && blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[6], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    Object var13_15 = null;
                    BakedQuad[] bakedQuadArray = var13_15;
                    return bakedQuadArray;
                }
                if (blArray[1] && blArray[2] && blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[12], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    Object var13_16 = null;
                    BakedQuad[] bakedQuadArray = var13_16;
                    return bakedQuadArray;
                }
                if (blArray[0] && blArray[1] && blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[13], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    Object var13_17 = null;
                    BakedQuad[] bakedQuadArray = var13_17;
                    return bakedQuadArray;
                }
                BlockDir[] blockDirArray2 = ConnectedTextures.getEdgeDirections(n2, n);
                boolean[] blArray2 = renderEnv.getBorderFlags2();
                for (int i = 0; i < 4; ++i) {
                    blArray2[i] = ConnectedTextures.isNeighbourOverlay(connectedProperties, iBlockAccess, iBlockState, blockDirArray2[i].offset(blockPos), n2, textureAtlasSprite, n3);
                }
                if (blArray[1] && blArray[2]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[3], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    if (blArray2[3]) {
                        listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[16], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    }
                    Object var16_26 = null;
                    BakedQuad[] bakedQuadArray = var16_26;
                    return bakedQuadArray;
                }
                if (blArray[0] && blArray[2]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[4], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    if (blArray2[2]) {
                        listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[14], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    }
                    Object var16_27 = null;
                    BakedQuad[] bakedQuadArray = var16_27;
                    return bakedQuadArray;
                }
                if (blArray[1] && blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[10], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    if (blArray2[1]) {
                        listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[2], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    }
                    Object var16_28 = null;
                    BakedQuad[] bakedQuadArray = var16_28;
                    return bakedQuadArray;
                }
                if (blArray[0] && blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[11], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    if (blArray2[0]) {
                        listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[0], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                    }
                    Object var16_29 = null;
                    BakedQuad[] bakedQuadArray = var16_29;
                    return bakedQuadArray;
                }
                boolean[] blArray3 = renderEnv.getBorderFlags3();
                for (int i = 0; i < 4; ++i) {
                    blArray3[i] = ConnectedTextures.isNeighbourMatching(connectedProperties, iBlockAccess, iBlockState, blockDirArray[i].offset(blockPos), n2, textureAtlasSprite, n3);
                }
                if (blArray[0]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[9], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                if (blArray[1]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[7], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                if (blArray[2]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[1], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                if (blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[15], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                if (blArray2[0] && (blArray3[1] || blArray3[2]) && !blArray[1] && !blArray[2]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[0], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                if (blArray2[1] && (blArray3[0] || blArray3[2]) && !blArray[0] && !blArray[2]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[2], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                if (blArray2[2] && (blArray3[1] || blArray3[3]) && !blArray[1] && !blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[14], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                if (blArray2[3] && (blArray3[0] || blArray3[3]) && !blArray[0] && !blArray[3]) {
                    listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[16], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
                }
                Object var17_36 = null;
                BakedQuad[] bakedQuadArray = var17_36;
                return bakedQuadArray;
            }
            listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(connectedProperties.tileIcons[8], bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
            var13_18 = null;
        }
        finally {
            if (listQuadsOverlay.size() > 0) {
                renderEnv.setOverlaysRendered(true);
            }
        }
        return var13_18;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BakedQuad[] getConnectedTextureOverlayFixed(ConnectedProperties connectedProperties, BakedQuad bakedQuad, RenderEnv renderEnv) {
        Object var4_5;
        if (!bakedQuad.isFullQuad()) {
            return null;
        }
        ListQuadsOverlay listQuadsOverlay = renderEnv.getListQuadsOverlay(connectedProperties.layer);
        try {
            TextureAtlasSprite textureAtlasSprite = ConnectedTextures.getConnectedTextureFixed(connectedProperties);
            if (textureAtlasSprite != null) {
                listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(textureAtlasSprite, bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
            }
            var4_5 = null;
        }
        finally {
            if (listQuadsOverlay.size() > 0) {
                renderEnv.setOverlaysRendered(true);
            }
        }
        return var4_5;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BakedQuad[] getConnectedTextureOverlayRandom(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, BlockStateBase blockStateBase, BlockPos blockPos, int n, BakedQuad bakedQuad, RenderEnv renderEnv) {
        Object var8_9;
        if (!bakedQuad.isFullQuad()) {
            return null;
        }
        ListQuadsOverlay listQuadsOverlay = renderEnv.getListQuadsOverlay(connectedProperties.layer);
        try {
            TextureAtlasSprite textureAtlasSprite = ConnectedTextures.getConnectedTextureRandom(connectedProperties, iBlockAccess, blockStateBase, blockPos, n);
            if (textureAtlasSprite != null) {
                listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(textureAtlasSprite, bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
            }
            var8_9 = null;
        }
        finally {
            if (listQuadsOverlay.size() > 0) {
                renderEnv.setOverlaysRendered(true);
            }
        }
        return var8_9;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BakedQuad[] getConnectedTextureOverlayRepeat(ConnectedProperties connectedProperties, BlockPos blockPos, int n, BakedQuad bakedQuad, RenderEnv renderEnv) {
        Object var6_7;
        if (!bakedQuad.isFullQuad()) {
            return null;
        }
        ListQuadsOverlay listQuadsOverlay = renderEnv.getListQuadsOverlay(connectedProperties.layer);
        try {
            TextureAtlasSprite textureAtlasSprite = ConnectedTextures.getConnectedTextureRepeat(connectedProperties, blockPos, n);
            if (textureAtlasSprite != null) {
                listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(textureAtlasSprite, bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
            }
            var6_7 = null;
        }
        finally {
            if (listQuadsOverlay.size() > 0) {
                renderEnv.setOverlaysRendered(true);
            }
        }
        return var6_7;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BakedQuad[] getConnectedTextureOverlayCtm(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, BakedQuad bakedQuad, int n3, RenderEnv renderEnv) {
        Object var10_11;
        if (!bakedQuad.isFullQuad()) {
            return null;
        }
        ListQuadsOverlay listQuadsOverlay = renderEnv.getListQuadsOverlay(connectedProperties.layer);
        try {
            TextureAtlasSprite textureAtlasSprite = ConnectedTextures.getConnectedTextureCtm(connectedProperties, iBlockAccess, iBlockState, blockPos, n, n2, bakedQuad.getSprite(), n3, renderEnv);
            if (textureAtlasSprite != null) {
                listQuadsOverlay.addQuad(ConnectedTextures.getQuadFull(textureAtlasSprite, bakedQuad, connectedProperties.tintIndex), connectedProperties.tintBlockState);
            }
            var10_11 = null;
        }
        finally {
            if (listQuadsOverlay.size() > 0) {
                renderEnv.setOverlaysRendered(true);
            }
        }
        return var10_11;
    }

    private static BlockDir[] getSideDirections(int n, int n2) {
        switch (n) {
            case 0: {
                return SIDES_Y_NEG_DOWN;
            }
            case 1: {
                return SIDES_Y_POS_UP;
            }
            case 2: {
                if (n2 == 1) {
                    return SIDES_Z_NEG_NORTH_Z_AXIS;
                }
                return SIDES_Z_NEG_NORTH;
            }
            case 3: {
                return SIDES_Z_POS_SOUTH;
            }
            case 4: {
                return SIDES_X_NEG_WEST;
            }
            case 5: {
                if (n2 == 2) {
                    return SIDES_X_POS_EAST_X_AXIS;
                }
                return SIDES_X_POS_EAST;
            }
        }
        throw new IllegalArgumentException("Unknown side: " + n);
    }

    private static BlockDir[] getEdgeDirections(int n, int n2) {
        switch (n) {
            case 0: {
                return EDGES_Y_NEG_DOWN;
            }
            case 1: {
                return EDGES_Y_POS_UP;
            }
            case 2: {
                if (n2 == 1) {
                    return EDGES_Z_NEG_NORTH_Z_AXIS;
                }
                return EDGES_Z_NEG_NORTH;
            }
            case 3: {
                return EDGES_Z_POS_SOUTH;
            }
            case 4: {
                return EDGES_X_NEG_WEST;
            }
            case 5: {
                if (n2 == 2) {
                    return EDGES_X_POS_EAST_X_AXIS;
                }
                return EDGES_X_POS_EAST;
            }
        }
        throw new IllegalArgumentException("Unknown side: " + n);
    }

    protected static Map[][] getSpriteQuadCompactMaps() {
        return spriteQuadCompactMaps;
    }

    private static int getConnectedTextureCtmIndex(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3, RenderEnv renderEnv) {
        boolean[] blArray = renderEnv.getBorderFlags();
        switch (n2) {
            case 0: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos2 = blockPos.down();
                blArray[0] = blArray[0] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.west(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.east(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.north(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.south(), n2, textureAtlasSprite, n3);
                break;
            }
            case 1: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos2 = blockPos.up();
                blArray[0] = blArray[0] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.west(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.east(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.south(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.north(), n2, textureAtlasSprite, n3);
                break;
            }
            case 2: {
                BlockPos blockPos2;
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                if (connectedProperties.innerSeams) {
                    blockPos2 = blockPos.north();
                    blArray[0] = blArray[0] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.east(), n2, textureAtlasSprite, n3);
                    blArray[1] = blArray[1] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.west(), n2, textureAtlasSprite, n3);
                    blArray[2] = blArray[2] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.down(), n2, textureAtlasSprite, n3);
                    boolean bl = blArray[3] = blArray[3] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.up(), n2, textureAtlasSprite, n3);
                }
                if (n != 1) break;
                ConnectedTextures.switchValues(0, 1, blArray);
                ConnectedTextures.switchValues(2, 3, blArray);
                break;
            }
            case 3: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos2 = blockPos.south();
                blArray[0] = blArray[0] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.west(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.east(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.down(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.up(), n2, textureAtlasSprite, n3);
                break;
            }
            case 4: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos2 = blockPos.west();
                blArray[0] = blArray[0] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.north(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.south(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.down(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.up(), n2, textureAtlasSprite, n3);
                break;
            }
            case 5: {
                BlockPos blockPos2;
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                if (connectedProperties.innerSeams) {
                    blockPos2 = blockPos.east();
                    blArray[0] = blArray[0] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.south(), n2, textureAtlasSprite, n3);
                    blArray[1] = blArray[1] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.north(), n2, textureAtlasSprite, n3);
                    blArray[2] = blArray[2] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.down(), n2, textureAtlasSprite, n3);
                    boolean bl = blArray[3] = blArray[3] && !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos2.up(), n2, textureAtlasSprite, n3);
                }
                if (n != 2) break;
                ConnectedTextures.switchValues(0, 1, blArray);
                ConnectedTextures.switchValues(2, 3, blArray);
            }
        }
        int n4 = 0;
        if (blArray[0] & !blArray[1] & !blArray[2] & !blArray[3]) {
            n4 = 3;
        } else if (!blArray[0] & blArray[1] & !blArray[2] & !blArray[3]) {
            n4 = 1;
        } else if (!blArray[0] & !blArray[1] & blArray[2] & !blArray[3]) {
            n4 = 12;
        } else if (!blArray[0] & !blArray[1] & !blArray[2] & blArray[3]) {
            n4 = 36;
        } else if (blArray[0] & blArray[1] & !blArray[2] & !blArray[3]) {
            n4 = 2;
        } else if (!blArray[0] & !blArray[1] & blArray[2] & blArray[3]) {
            n4 = 24;
        } else if (blArray[0] & !blArray[1] & blArray[2] & !blArray[3]) {
            n4 = 15;
        } else if (blArray[0] & !blArray[1] & !blArray[2] & blArray[3]) {
            n4 = 39;
        } else if (!blArray[0] & blArray[1] & blArray[2] & !blArray[3]) {
            n4 = 13;
        } else if (!blArray[0] & blArray[1] & !blArray[2] & blArray[3]) {
            n4 = 37;
        } else if (!blArray[0] & blArray[1] & blArray[2] & blArray[3]) {
            n4 = 25;
        } else if (blArray[0] & !blArray[1] & blArray[2] & blArray[3]) {
            n4 = 27;
        } else if (blArray[0] & blArray[1] & !blArray[2] & blArray[3]) {
            n4 = 38;
        } else if (blArray[0] & blArray[1] & blArray[2] & !blArray[3]) {
            n4 = 14;
        } else if (blArray[0] & blArray[1] & blArray[2] & blArray[3]) {
            n4 = 26;
        }
        if (n4 == 0) {
            return n4;
        }
        if (!Config.isConnectedTexturesFancy()) {
            return n4;
        }
        switch (n2) {
            case 0: {
                blArray[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().north(), n2, textureAtlasSprite, n3);
                blArray[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().north(), n2, textureAtlasSprite, n3);
                blArray[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().south(), n2, textureAtlasSprite, n3);
                boolean bl = blArray[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().south(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos3 = blockPos.down();
                blArray[0] = blArray[0] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos3.east().north(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos3.west().north(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos3.east().south(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos3.west().south(), n2, textureAtlasSprite, n3);
                break;
            }
            case 1: {
                blArray[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().south(), n2, textureAtlasSprite, n3);
                blArray[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().south(), n2, textureAtlasSprite, n3);
                blArray[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().north(), n2, textureAtlasSprite, n3);
                boolean bl = blArray[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().north(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos4 = blockPos.up();
                blArray[0] = blArray[0] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos4.east().south(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos4.west().south(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos4.east().north(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos4.west().north(), n2, textureAtlasSprite, n3);
                break;
            }
            case 2: {
                blArray[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().down(), n2, textureAtlasSprite, n3);
                blArray[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().down(), n2, textureAtlasSprite, n3);
                blArray[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().up(), n2, textureAtlasSprite, n3);
                boolean bl = blArray[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().up(), n2, textureAtlasSprite, n3);
                if (connectedProperties.innerSeams) {
                    BlockPos blockPos5 = blockPos.north();
                    blArray[0] = blArray[0] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos5.west().down(), n2, textureAtlasSprite, n3);
                    blArray[1] = blArray[1] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos5.east().down(), n2, textureAtlasSprite, n3);
                    blArray[2] = blArray[2] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos5.west().up(), n2, textureAtlasSprite, n3);
                    boolean bl2 = blArray[3] = blArray[3] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos5.east().up(), n2, textureAtlasSprite, n3);
                }
                if (n != 1) break;
                ConnectedTextures.switchValues(0, 3, blArray);
                ConnectedTextures.switchValues(1, 2, blArray);
                break;
            }
            case 3: {
                blArray[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().down(), n2, textureAtlasSprite, n3);
                blArray[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().down(), n2, textureAtlasSprite, n3);
                blArray[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east().up(), n2, textureAtlasSprite, n3);
                boolean bl = blArray[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west().up(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos6 = blockPos.south();
                blArray[0] = blArray[0] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos6.east().down(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos6.west().down(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos6.east().up(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos6.west().up(), n2, textureAtlasSprite, n3);
                break;
            }
            case 4: {
                blArray[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down().south(), n2, textureAtlasSprite, n3);
                blArray[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down().north(), n2, textureAtlasSprite, n3);
                blArray[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up().south(), n2, textureAtlasSprite, n3);
                boolean bl = blArray[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up().north(), n2, textureAtlasSprite, n3);
                if (!connectedProperties.innerSeams) break;
                BlockPos blockPos7 = blockPos.west();
                blArray[0] = blArray[0] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos7.down().south(), n2, textureAtlasSprite, n3);
                blArray[1] = blArray[1] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos7.down().north(), n2, textureAtlasSprite, n3);
                blArray[2] = blArray[2] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos7.up().south(), n2, textureAtlasSprite, n3);
                blArray[3] = blArray[3] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos7.up().north(), n2, textureAtlasSprite, n3);
                break;
            }
            case 5: {
                blArray[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down().north(), n2, textureAtlasSprite, n3);
                blArray[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down().south(), n2, textureAtlasSprite, n3);
                blArray[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up().north(), n2, textureAtlasSprite, n3);
                boolean bl = blArray[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up().south(), n2, textureAtlasSprite, n3);
                if (connectedProperties.innerSeams) {
                    BlockPos blockPos8 = blockPos.east();
                    blArray[0] = blArray[0] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos8.down().north(), n2, textureAtlasSprite, n3);
                    blArray[1] = blArray[1] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos8.down().south(), n2, textureAtlasSprite, n3);
                    blArray[2] = blArray[2] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos8.up().north(), n2, textureAtlasSprite, n3);
                    boolean bl3 = blArray[3] = blArray[3] || ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos8.up().south(), n2, textureAtlasSprite, n3);
                }
                if (n != 2) break;
                ConnectedTextures.switchValues(0, 3, blArray);
                ConnectedTextures.switchValues(1, 2, blArray);
            }
        }
        if (n4 == 13 && blArray[0]) {
            n4 = 4;
        } else if (n4 == 15 && blArray[1]) {
            n4 = 5;
        } else if (n4 == 37 && blArray[2]) {
            n4 = 16;
        } else if (n4 == 39 && blArray[3]) {
            n4 = 17;
        } else if (n4 == 14 && blArray[0] && blArray[1]) {
            n4 = 7;
        } else if (n4 == 25 && blArray[0] && blArray[2]) {
            n4 = 6;
        } else if (n4 == 27 && blArray[3] && blArray[1]) {
            n4 = 19;
        } else if (n4 == 38 && blArray[3] && blArray[2]) {
            n4 = 18;
        } else if (n4 == 14 && !blArray[0] && blArray[1]) {
            n4 = 31;
        } else if (n4 == 25 && blArray[0] && !blArray[2]) {
            n4 = 30;
        } else if (n4 == 27 && !blArray[3] && blArray[1]) {
            n4 = 41;
        } else if (n4 == 38 && blArray[3] && !blArray[2]) {
            n4 = 40;
        } else if (n4 == 14 && blArray[0] && !blArray[1]) {
            n4 = 29;
        } else if (n4 == 25 && !blArray[0] && blArray[2]) {
            n4 = 28;
        } else if (n4 == 27 && blArray[3] && !blArray[1]) {
            n4 = 43;
        } else if (n4 == 38 && !blArray[3] && blArray[2]) {
            n4 = 42;
        } else if (n4 == 26 && blArray[0] && blArray[1] && blArray[2] && blArray[3]) {
            n4 = 46;
        } else if (n4 == 26 && !blArray[0] && blArray[1] && blArray[2] && blArray[3]) {
            n4 = 9;
        } else if (n4 == 26 && blArray[0] && !blArray[1] && blArray[2] && blArray[3]) {
            n4 = 21;
        } else if (n4 == 26 && blArray[0] && blArray[1] && !blArray[2] && blArray[3]) {
            n4 = 8;
        } else if (n4 == 26 && blArray[0] && blArray[1] && blArray[2] && !blArray[3]) {
            n4 = 20;
        } else if (n4 == 26 && blArray[0] && blArray[1] && !blArray[2] && !blArray[3]) {
            n4 = 11;
        } else if (n4 == 26 && !blArray[0] && !blArray[1] && blArray[2] && blArray[3]) {
            n4 = 22;
        } else if (n4 == 26 && !blArray[0] && blArray[1] && !blArray[2] && blArray[3]) {
            n4 = 23;
        } else if (n4 == 26 && blArray[0] && !blArray[1] && blArray[2] && !blArray[3]) {
            n4 = 10;
        } else if (n4 == 26 && blArray[0] && !blArray[1] && !blArray[2] && blArray[3]) {
            n4 = 34;
        } else if (n4 == 26 && !blArray[0] && blArray[1] && blArray[2] && !blArray[3]) {
            n4 = 35;
        } else if (n4 == 26 && blArray[0] && !blArray[1] && !blArray[2] && !blArray[3]) {
            n4 = 32;
        } else if (n4 == 26 && !blArray[0] && blArray[1] && !blArray[2] && !blArray[3]) {
            n4 = 33;
        } else if (n4 == 26 && !blArray[0] && !blArray[1] && blArray[2] && !blArray[3]) {
            n4 = 44;
        } else if (n4 == 26 && !blArray[0] && !blArray[1] && !blArray[2] && blArray[3]) {
            n4 = 45;
        }
        return n4;
    }

    private static void switchValues(int n, int n2, boolean[] blArray) {
        boolean bl = blArray[n];
        blArray[n] = blArray[n2];
        blArray[n2] = bl;
    }

    private static boolean isNeighbourOverlay(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, TextureAtlasSprite textureAtlasSprite, int n2) {
        Object object;
        IBlockState iBlockState2 = iBlockAccess.getBlockState(blockPos);
        if (!ConnectedTextures.isFullCubeModel(iBlockState2)) {
            return false;
        }
        if (connectedProperties.connectBlocks != null && !Matches.block(((BlockStateBase)(object = (BlockStateBase)iBlockState2)).getBlockId(), ((BlockStateBase)object).getMetadata(), connectedProperties.connectBlocks)) {
            return false;
        }
        if (connectedProperties.connectTileIcons != null && !Config.isSameOne(object = ConnectedTextures.getNeighbourIcon(iBlockAccess, iBlockState, blockPos, iBlockState2, n), connectedProperties.connectTileIcons)) {
            return false;
        }
        object = iBlockAccess.getBlockState(blockPos.offset(ConnectedTextures.getFacing(n)));
        return object.getBlock().isOpaqueCube() ? false : (n == 1 && object.getBlock() == Blocks.snow_layer ? false : !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos, iBlockState2, n, textureAtlasSprite, n2));
    }

    private static boolean isFullCubeModel(IBlockState iBlockState) {
        if (iBlockState.getBlock().isFullCube()) {
            return true;
        }
        Block block = iBlockState.getBlock();
        return block instanceof BlockGlass ? true : block instanceof BlockStainedGlass;
    }

    private static boolean isNeighbourMatching(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, TextureAtlasSprite textureAtlasSprite, int n2) {
        Object object;
        IBlockState iBlockState2 = iBlockAccess.getBlockState(blockPos);
        if (iBlockState2 == AIR_DEFAULT_STATE) {
            return false;
        }
        if (connectedProperties.matchBlocks != null && iBlockState2 instanceof BlockStateBase && !connectedProperties.matchesBlock(((BlockStateBase)(object = (BlockStateBase)iBlockState2)).getBlockId(), ((BlockStateBase)object).getMetadata())) {
            return false;
        }
        if (connectedProperties.matchTileIcons != null && (object = ConnectedTextures.getNeighbourIcon(iBlockAccess, iBlockState, blockPos, iBlockState2, n)) != textureAtlasSprite) {
            return false;
        }
        object = iBlockAccess.getBlockState(blockPos.offset(ConnectedTextures.getFacing(n)));
        return object.getBlock().isOpaqueCube() ? false : n != 1 || object.getBlock() != Blocks.snow_layer;
    }

    private static boolean isNeighbour(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, TextureAtlasSprite textureAtlasSprite, int n2) {
        IBlockState iBlockState2 = iBlockAccess.getBlockState(blockPos);
        return ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos, iBlockState2, n, textureAtlasSprite, n2);
    }

    private static boolean isNeighbour(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, IBlockState iBlockState2, int n, TextureAtlasSprite textureAtlasSprite, int n2) {
        if (iBlockState == iBlockState2) {
            return true;
        }
        if (connectedProperties.connect == 2) {
            if (iBlockState2 == null) {
                return false;
            }
            if (iBlockState2 == AIR_DEFAULT_STATE) {
                return false;
            }
            TextureAtlasSprite textureAtlasSprite2 = ConnectedTextures.getNeighbourIcon(iBlockAccess, iBlockState, blockPos, iBlockState2, n);
            return textureAtlasSprite2 == textureAtlasSprite;
        }
        if (connectedProperties.connect == 3) {
            return iBlockState2 == null ? false : (iBlockState2 == AIR_DEFAULT_STATE ? false : iBlockState2.getBlock().getMaterial() == iBlockState.getBlock().getMaterial());
        }
        if (!(iBlockState2 instanceof BlockStateBase)) {
            return false;
        }
        BlockStateBase blockStateBase = (BlockStateBase)iBlockState2;
        Block block = blockStateBase.getBlock();
        int n3 = blockStateBase.getMetadata();
        return block == iBlockState.getBlock() && n3 == n2;
    }

    private static TextureAtlasSprite getNeighbourIcon(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, IBlockState iBlockState2, int n) {
        EnumFacing enumFacing;
        List list;
        iBlockState2 = iBlockState2.getBlock().getActualState(iBlockState2, iBlockAccess, blockPos);
        IBakedModel iBakedModel = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(iBlockState2);
        if (iBakedModel == null) {
            return null;
        }
        if (Reflector.CompatBlock_getExtendedState.exists()) {
            iBlockState2 = (IBlockState)Reflector.call(iBlockState2.getBlock(), Reflector.CompatBlock_getExtendedState, iBlockState2, iBlockAccess, blockPos);
        }
        if ((list = iBakedModel.getFaceQuads(enumFacing = ConnectedTextures.getFacing(n))) == null) {
            return null;
        }
        if (Config.isBetterGrass()) {
            list = BetterGrass.getFaceQuads(iBlockAccess, iBlockState2, blockPos, enumFacing, list);
        }
        if (list.size() > 0) {
            BakedQuad bakedQuad = list.get(0);
            return bakedQuad.getSprite();
        }
        List<BakedQuad> list2 = iBakedModel.getGeneralQuads();
        if (list2 == null) {
            return null;
        }
        for (int i = 0; i < list2.size(); ++i) {
            BakedQuad bakedQuad = list2.get(i);
            if (bakedQuad.getFace() != enumFacing) continue;
            return bakedQuad.getSprite();
        }
        return null;
    }

    private static TextureAtlasSprite getConnectedTextureHorizontal(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3) {
        boolean bl = false;
        boolean bl2 = false;
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 1: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 2: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 3: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 4: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 5: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 1: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 2: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 3: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 4: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                        break;
                    }
                    case 5: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                    }
                }
                break;
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                        break block0;
                    }
                    case 1: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                        break block0;
                    }
                    case 2: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                        break block0;
                    }
                    case 3: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                        break block0;
                    }
                    case 4: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                        break block0;
                    }
                    case 5: {
                        bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                        bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                    }
                }
            }
        }
        int n4 = 3;
        n4 = bl ? (bl2 ? 1 : 2) : (bl2 ? 0 : 3);
        return connectedProperties.tileIcons[n4];
    }

    private static TextureAtlasSprite getConnectedTextureVertical(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3) {
        boolean bl = false;
        boolean bl2 = false;
        switch (n) {
            case 0: {
                if (n2 == 1) {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                    break;
                }
                if (n2 == 0) {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                    break;
                }
                bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                break;
            }
            case 1: {
                if (n2 == 3) {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                    break;
                }
                if (n2 == 2) {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                    break;
                }
                bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.north(), n2, textureAtlasSprite, n3);
                break;
            }
            case 2: {
                if (n2 == 5) {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                    break;
                }
                if (n2 == 4) {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.down(), n2, textureAtlasSprite, n3);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                    break;
                }
                bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.west(), n2, textureAtlasSprite, n3);
                bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
            }
        }
        int n4 = 3;
        n4 = bl ? (bl2 ? 1 : 2) : (bl2 ? 0 : 3);
        return connectedProperties.tileIcons[n4];
    }

    private static TextureAtlasSprite getConnectedTextureHorizontalVertical(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3) {
        TextureAtlasSprite[] textureAtlasSpriteArray = connectedProperties.tileIcons;
        TextureAtlasSprite textureAtlasSprite2 = ConnectedTextures.getConnectedTextureHorizontal(connectedProperties, iBlockAccess, iBlockState, blockPos, n, n2, textureAtlasSprite, n3);
        if (textureAtlasSprite2 != null && textureAtlasSprite2 != textureAtlasSprite && textureAtlasSprite2 != textureAtlasSpriteArray[3]) {
            return textureAtlasSprite2;
        }
        TextureAtlasSprite textureAtlasSprite3 = ConnectedTextures.getConnectedTextureVertical(connectedProperties, iBlockAccess, iBlockState, blockPos, n, n2, textureAtlasSprite, n3);
        return textureAtlasSprite3 == textureAtlasSpriteArray[0] ? textureAtlasSpriteArray[4] : (textureAtlasSprite3 == textureAtlasSpriteArray[1] ? textureAtlasSpriteArray[5] : (textureAtlasSprite3 == textureAtlasSpriteArray[2] ? textureAtlasSpriteArray[6] : textureAtlasSprite3));
    }

    private static TextureAtlasSprite getConnectedTextureVerticalHorizontal(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3) {
        TextureAtlasSprite[] textureAtlasSpriteArray = connectedProperties.tileIcons;
        TextureAtlasSprite textureAtlasSprite2 = ConnectedTextures.getConnectedTextureVertical(connectedProperties, iBlockAccess, iBlockState, blockPos, n, n2, textureAtlasSprite, n3);
        if (textureAtlasSprite2 != null && textureAtlasSprite2 != textureAtlasSprite && textureAtlasSprite2 != textureAtlasSpriteArray[3]) {
            return textureAtlasSprite2;
        }
        TextureAtlasSprite textureAtlasSprite3 = ConnectedTextures.getConnectedTextureHorizontal(connectedProperties, iBlockAccess, iBlockState, blockPos, n, n2, textureAtlasSprite, n3);
        return textureAtlasSprite3 == textureAtlasSpriteArray[0] ? textureAtlasSpriteArray[4] : (textureAtlasSprite3 == textureAtlasSpriteArray[1] ? textureAtlasSpriteArray[5] : (textureAtlasSprite3 == textureAtlasSpriteArray[2] ? textureAtlasSpriteArray[6] : textureAtlasSprite3));
    }

    private static TextureAtlasSprite getConnectedTextureTop(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, int n, int n2, TextureAtlasSprite textureAtlasSprite, int n3) {
        boolean bl = false;
        switch (n) {
            case 0: {
                if (n2 == 1 || n2 == 0) {
                    return null;
                }
                bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.up(), n2, textureAtlasSprite, n3);
                break;
            }
            case 1: {
                if (n2 == 3 || n2 == 2) {
                    return null;
                }
                bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.south(), n2, textureAtlasSprite, n3);
                break;
            }
            case 2: {
                if (n2 == 5 || n2 == 4) {
                    return null;
                }
                bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, iBlockState, blockPos.east(), n2, textureAtlasSprite, n3);
            }
        }
        if (bl) {
            return connectedProperties.tileIcons[0];
        }
        return null;
    }

    public static void updateIcons(TextureMap textureMap) {
        blockProperties = null;
        tileProperties = null;
        spriteQuadMaps = null;
        spriteQuadCompactMaps = null;
        if (Config.isConnectedTextures()) {
            IResourcePack[] iResourcePackArray = Config.getResourcePacks();
            for (int i = iResourcePackArray.length - 1; i >= 0; --i) {
                IResourcePack iResourcePack = iResourcePackArray[i];
                ConnectedTextures.updateIcons(textureMap, iResourcePack);
            }
            ConnectedTextures.updateIcons(textureMap, Config.getDefaultResourcePack());
            ResourceLocation resourceLocation = new ResourceLocation("mcpatcher/ctm/default/empty");
            emptySprite = textureMap.registerSprite(resourceLocation);
            spriteQuadMaps = new Map[textureMap.getCountRegisteredSprites() + 1];
            spriteQuadFullMaps = new Map[textureMap.getCountRegisteredSprites() + 1];
            spriteQuadCompactMaps = new Map[textureMap.getCountRegisteredSprites() + 1][];
            if (blockProperties.length <= 0) {
                blockProperties = null;
            }
            if (tileProperties.length <= 0) {
                tileProperties = null;
            }
        }
    }

    private static void updateIconEmpty(TextureMap textureMap) {
    }

    public static void updateIcons(TextureMap textureMap, IResourcePack iResourcePack) {
        String[] stringArray = ResUtils.collectFiles(iResourcePack, "mcpatcher/ctm/", ".properties", ConnectedTextures.getDefaultCtmPaths());
        Arrays.sort(stringArray);
        List list = ConnectedTextures.makePropertyList(tileProperties);
        List list2 = ConnectedTextures.makePropertyList(blockProperties);
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            Config.dbg("ConnectedTextures: " + string);
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string);
                InputStream inputStream2 = iResourcePack.getInputStream(resourceLocation);
                if (inputStream2 == null) {
                    Config.warn("ConnectedTextures file not found: " + string);
                    continue;
                }
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                ConnectedProperties connectedProperties = new ConnectedProperties(propertiesOrdered, string);
                if (!connectedProperties.isValid(string)) continue;
                connectedProperties.updateIcons(textureMap);
                ConnectedTextures.addToTileList(connectedProperties, list);
                ConnectedTextures.addToBlockList(connectedProperties, list2);
                continue;
            }
            catch (FileNotFoundException fileNotFoundException) {
                Config.warn("ConnectedTextures file not found: " + string);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        blockProperties = ConnectedTextures.propertyListToArray(list2);
        tileProperties = ConnectedTextures.propertyListToArray(list);
        multipass = ConnectedTextures.detectMultipass();
        Config.dbg("Multipass connected textures: " + multipass);
    }

    private static List makePropertyList(ConnectedProperties[][] connectedPropertiesArray) {
        ArrayList<ArrayList<ConnectedProperties>> arrayList = new ArrayList<ArrayList<ConnectedProperties>>();
        if (connectedPropertiesArray != null) {
            for (int i = 0; i < connectedPropertiesArray.length; ++i) {
                ConnectedProperties[] connectedPropertiesArray2 = connectedPropertiesArray[i];
                ArrayList<ConnectedProperties> arrayList2 = null;
                if (connectedPropertiesArray2 != null) {
                    arrayList2 = new ArrayList<ConnectedProperties>(Arrays.asList(connectedPropertiesArray2));
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private static boolean detectMultipass() {
        Object object;
        int n;
        ArrayList<ConnectedProperties> arrayList = new ArrayList<ConnectedProperties>();
        for (n = 0; n < tileProperties.length; ++n) {
            object = tileProperties[n];
            if (object == null) continue;
            arrayList.addAll(Arrays.asList(object));
        }
        for (n = 0; n < blockProperties.length; ++n) {
            object = blockProperties[n];
            if (object == null) continue;
            arrayList.addAll(Arrays.asList(object));
        }
        ConnectedProperties[] connectedPropertiesArray = arrayList.toArray(new ConnectedProperties[arrayList.size()]);
        object = new HashSet();
        HashSet<TextureAtlasSprite> hashSet = new HashSet<TextureAtlasSprite>();
        for (int i = 0; i < connectedPropertiesArray.length; ++i) {
            ConnectedProperties connectedProperties = connectedPropertiesArray[i];
            if (connectedProperties.matchTileIcons != null) {
                object.addAll(Arrays.asList(connectedProperties.matchTileIcons));
            }
            if (connectedProperties.tileIcons == null) continue;
            hashSet.addAll(Arrays.asList(connectedProperties.tileIcons));
        }
        object.retainAll(hashSet);
        return !object.isEmpty();
    }

    private static ConnectedProperties[][] propertyListToArray(List list) {
        ConnectedProperties[][] connectedPropertiesArray = new ConnectedProperties[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            List list2 = (List)list.get(i);
            if (list2 == null) continue;
            ConnectedProperties[] connectedPropertiesArray2 = list2.toArray(new ConnectedProperties[list2.size()]);
            connectedPropertiesArray[i] = connectedPropertiesArray2;
        }
        return connectedPropertiesArray;
    }

    private static void addToTileList(ConnectedProperties connectedProperties, List list) {
        if (connectedProperties.matchTileIcons != null) {
            for (int i = 0; i < connectedProperties.matchTileIcons.length; ++i) {
                TextureAtlasSprite textureAtlasSprite = connectedProperties.matchTileIcons[i];
                if (!(textureAtlasSprite instanceof TextureAtlasSprite)) {
                    Config.warn("TextureAtlasSprite is not TextureAtlasSprite: " + String.valueOf(textureAtlasSprite) + ", name: " + textureAtlasSprite.getIconName());
                    continue;
                }
                int n = textureAtlasSprite.getIndexInMap();
                if (n < 0) {
                    Config.warn("Invalid tile ID: " + n + ", icon: " + textureAtlasSprite.getIconName());
                    continue;
                }
                ConnectedTextures.addToList(connectedProperties, list, n);
            }
        }
    }

    private static void addToBlockList(ConnectedProperties connectedProperties, List list) {
        if (connectedProperties.matchBlocks != null) {
            for (int i = 0; i < connectedProperties.matchBlocks.length; ++i) {
                int n = connectedProperties.matchBlocks[i].getBlockId();
                if (n < 0) {
                    Config.warn("Invalid block ID: " + n);
                    continue;
                }
                ConnectedTextures.addToList(connectedProperties, list, n);
            }
        }
    }

    private static void addToList(ConnectedProperties connectedProperties, List list, int n) {
        while (n >= list.size()) {
            list.add(null);
        }
        ArrayList<ConnectedProperties> arrayList = (ArrayList<ConnectedProperties>)list.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList<ConnectedProperties>();
            list.set(n, arrayList);
        }
        arrayList.add(connectedProperties);
    }

    private static String[] getDefaultCtmPaths() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        String string = "mcpatcher/ctm/default/";
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/glass.png"))) {
            arrayList.add((CallSite)((Object)(string + "glass.properties")));
            arrayList.add((CallSite)((Object)(string + "glasspane.properties")));
        }
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/bookshelf.png"))) {
            arrayList.add((CallSite)((Object)(string + "bookshelf.properties")));
        }
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/sandstone_normal.png"))) {
            arrayList.add((CallSite)((Object)(string + "sandstone.properties")));
        }
        String[] stringArray = new String[]{"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black"};
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (!Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/glass_" + string2 + ".png"))) continue;
            arrayList.add((CallSite)((Object)(string + i + "_glass_" + string2 + "/glass_" + string2 + ".properties")));
            arrayList.add((CallSite)((Object)(string + i + "_glass_" + string2 + "/glass_pane_" + string2 + ".properties")));
        }
        String[] stringArray2 = arrayList.toArray(new String[arrayList.size()]);
        return stringArray2;
    }
}

