/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockMycelium;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.optifine.model.BlockModelUtils;
import net.optifine.util.PropertiesOrdered;

public class BetterGrass {
    private static boolean betterGrass = true;
    private static boolean betterMycelium = true;
    private static boolean betterPodzol = true;
    private static boolean betterGrassSnow = true;
    private static boolean betterMyceliumSnow = true;
    private static boolean betterPodzolSnow = true;
    private static boolean grassMultilayer = false;
    private static TextureAtlasSprite spriteGrass = null;
    private static TextureAtlasSprite spriteGrassSide = null;
    private static TextureAtlasSprite spriteMycelium = null;
    private static TextureAtlasSprite spritePodzol = null;
    private static TextureAtlasSprite spriteSnow = null;
    private static boolean spritesLoaded = false;
    private static IBakedModel modelCubeGrass = null;
    private static IBakedModel modelCubeMycelium = null;
    private static IBakedModel modelCubePodzol = null;
    private static IBakedModel modelCubeSnow = null;
    private static boolean modelsLoaded = false;
    private static final String TEXTURE_GRASS_DEFAULT = "blocks/grass_top";
    private static final String TEXTURE_GRASS_SIDE_DEFAULT = "blocks/grass_side";
    private static final String TEXTURE_MYCELIUM_DEFAULT = "blocks/mycelium_top";
    private static final String TEXTURE_PODZOL_DEFAULT = "blocks/dirt_podzol_top";
    private static final String TEXTURE_SNOW_DEFAULT = "blocks/snow";

    public static void updateIcons(TextureMap textureMap) {
        spritesLoaded = false;
        modelsLoaded = false;
        BetterGrass.loadProperties(textureMap);
    }

    public static void update() {
        if (spritesLoaded) {
            modelCubeGrass = BlockModelUtils.makeModelCube(spriteGrass, 0);
            if (grassMultilayer) {
                IBakedModel iBakedModel = BlockModelUtils.makeModelCube(spriteGrassSide, -1);
                modelCubeGrass = BlockModelUtils.joinModelsCube(iBakedModel, modelCubeGrass);
            }
            modelCubeMycelium = BlockModelUtils.makeModelCube(spriteMycelium, -1);
            modelCubePodzol = BlockModelUtils.makeModelCube(spritePodzol, 0);
            modelCubeSnow = BlockModelUtils.makeModelCube(spriteSnow, -1);
            modelsLoaded = true;
        }
    }

    private static void loadProperties(TextureMap textureMap) {
        betterGrass = true;
        betterMycelium = true;
        betterPodzol = true;
        betterGrassSnow = true;
        betterMyceliumSnow = true;
        betterPodzolSnow = true;
        spriteGrass = textureMap.registerSprite(new ResourceLocation(TEXTURE_GRASS_DEFAULT));
        spriteGrassSide = textureMap.registerSprite(new ResourceLocation(TEXTURE_GRASS_SIDE_DEFAULT));
        spriteMycelium = textureMap.registerSprite(new ResourceLocation(TEXTURE_MYCELIUM_DEFAULT));
        spritePodzol = textureMap.registerSprite(new ResourceLocation(TEXTURE_PODZOL_DEFAULT));
        spriteSnow = textureMap.registerSprite(new ResourceLocation(TEXTURE_SNOW_DEFAULT));
        spritesLoaded = true;
        String string = "optifine/bettergrass.properties";
        try {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            if (!Config.hasResource(resourceLocation)) {
                return;
            }
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return;
            }
            boolean bl = Config.isFromDefaultResourcePack(resourceLocation);
            if (bl) {
                Config.dbg("BetterGrass: Parsing default configuration " + string);
            } else {
                Config.dbg("BetterGrass: Parsing configuration " + string);
            }
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
            betterGrass = BetterGrass.getBoolean(propertiesOrdered, "grass", true);
            betterMycelium = BetterGrass.getBoolean(propertiesOrdered, "mycelium", true);
            betterPodzol = BetterGrass.getBoolean(propertiesOrdered, "podzol", true);
            betterGrassSnow = BetterGrass.getBoolean(propertiesOrdered, "grass.snow", true);
            betterMyceliumSnow = BetterGrass.getBoolean(propertiesOrdered, "mycelium.snow", true);
            betterPodzolSnow = BetterGrass.getBoolean(propertiesOrdered, "podzol.snow", true);
            grassMultilayer = BetterGrass.getBoolean(propertiesOrdered, "grass.multilayer", false);
            spriteGrass = BetterGrass.registerSprite(propertiesOrdered, "texture.grass", TEXTURE_GRASS_DEFAULT, textureMap);
            spriteGrassSide = BetterGrass.registerSprite(propertiesOrdered, "texture.grass_side", TEXTURE_GRASS_SIDE_DEFAULT, textureMap);
            spriteMycelium = BetterGrass.registerSprite(propertiesOrdered, "texture.mycelium", TEXTURE_MYCELIUM_DEFAULT, textureMap);
            spritePodzol = BetterGrass.registerSprite(propertiesOrdered, "texture.podzol", TEXTURE_PODZOL_DEFAULT, textureMap);
            spriteSnow = BetterGrass.registerSprite(propertiesOrdered, "texture.snow", TEXTURE_SNOW_DEFAULT, textureMap);
        }
        catch (IOException iOException) {
            Config.warn("Error reading: " + string + ", " + iOException.getClass().getName() + ": " + iOException.getMessage());
        }
    }

    private static TextureAtlasSprite registerSprite(Properties properties, String string, String string2, TextureMap textureMap) {
        ResourceLocation resourceLocation;
        String string3 = properties.getProperty(string);
        if (string3 == null) {
            string3 = string2;
        }
        if (!Config.hasResource(resourceLocation = new ResourceLocation("textures/" + string3 + ".png"))) {
            Config.warn("BetterGrass texture not found: " + String.valueOf(resourceLocation));
            string3 = string2;
        }
        ResourceLocation resourceLocation2 = new ResourceLocation(string3);
        TextureAtlasSprite textureAtlasSprite = textureMap.registerSprite(resourceLocation2);
        return textureAtlasSprite;
    }

    public static List getFaceQuads(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, List list) {
        if (enumFacing != EnumFacing.UP && enumFacing != EnumFacing.DOWN) {
            if (!modelsLoaded) {
                return list;
            }
            Block block = iBlockState.getBlock();
            return block instanceof BlockMycelium ? BetterGrass.getFaceQuadsMycelium(iBlockAccess, iBlockState, blockPos, enumFacing, list) : (block instanceof BlockDirt ? BetterGrass.getFaceQuadsDirt(iBlockAccess, iBlockState, blockPos, enumFacing, list) : (block instanceof BlockGrass ? BetterGrass.getFaceQuadsGrass(iBlockAccess, iBlockState, blockPos, enumFacing, list) : list));
        }
        return list;
    }

    private static List getFaceQuadsMycelium(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, List list) {
        boolean bl;
        Block block = iBlockAccess.getBlockState(blockPos.up()).getBlock();
        boolean bl2 = bl = block == Blocks.snow || block == Blocks.snow_layer;
        if (Config.isBetterGrassFancy()) {
            if (bl) {
                if (betterMyceliumSnow && BetterGrass.getBlockAt(blockPos, enumFacing, iBlockAccess) == Blocks.snow_layer) {
                    return modelCubeSnow.getFaceQuads(enumFacing);
                }
            } else if (betterMycelium && BetterGrass.getBlockAt(blockPos.down(), enumFacing, iBlockAccess) == Blocks.mycelium) {
                return modelCubeMycelium.getFaceQuads(enumFacing);
            }
        } else if (bl) {
            if (betterMyceliumSnow) {
                return modelCubeSnow.getFaceQuads(enumFacing);
            }
        } else if (betterMycelium) {
            return modelCubeMycelium.getFaceQuads(enumFacing);
        }
        return list;
    }

    private static List getFaceQuadsDirt(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, List list) {
        boolean bl;
        Block block = BetterGrass.getBlockAt(blockPos, EnumFacing.UP, iBlockAccess);
        if (iBlockState.getValue(BlockDirt.VARIANT) != BlockDirt.DirtType.PODZOL) {
            return list;
        }
        boolean bl2 = bl = block == Blocks.snow || block == Blocks.snow_layer;
        if (Config.isBetterGrassFancy()) {
            BlockPos blockPos2;
            IBlockState iBlockState2;
            if (bl) {
                if (betterPodzolSnow && BetterGrass.getBlockAt(blockPos, enumFacing, iBlockAccess) == Blocks.snow_layer) {
                    return modelCubeSnow.getFaceQuads(enumFacing);
                }
            } else if (betterPodzol && (iBlockState2 = iBlockAccess.getBlockState(blockPos2 = blockPos.down().offset(enumFacing))).getBlock() == Blocks.dirt && iBlockState2.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.PODZOL) {
                return modelCubePodzol.getFaceQuads(enumFacing);
            }
        } else if (bl) {
            if (betterPodzolSnow) {
                return modelCubeSnow.getFaceQuads(enumFacing);
            }
        } else if (betterPodzol) {
            return modelCubePodzol.getFaceQuads(enumFacing);
        }
        return list;
    }

    private static List getFaceQuadsGrass(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, EnumFacing enumFacing, List list) {
        boolean bl;
        Block block = iBlockAccess.getBlockState(blockPos.up()).getBlock();
        boolean bl2 = bl = block == Blocks.snow || block == Blocks.snow_layer;
        if (Config.isBetterGrassFancy()) {
            if (bl) {
                if (betterGrassSnow && BetterGrass.getBlockAt(blockPos, enumFacing, iBlockAccess) == Blocks.snow_layer) {
                    return modelCubeSnow.getFaceQuads(enumFacing);
                }
            } else if (betterGrass && BetterGrass.getBlockAt(blockPos.down(), enumFacing, iBlockAccess) == Blocks.grass) {
                return modelCubeGrass.getFaceQuads(enumFacing);
            }
        } else if (bl) {
            if (betterGrassSnow) {
                return modelCubeSnow.getFaceQuads(enumFacing);
            }
        } else if (betterGrass) {
            return modelCubeGrass.getFaceQuads(enumFacing);
        }
        return list;
    }

    private static Block getBlockAt(BlockPos blockPos, EnumFacing enumFacing, IBlockAccess iBlockAccess) {
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        Block block = iBlockAccess.getBlockState(blockPos2).getBlock();
        return block;
    }

    private static boolean getBoolean(Properties properties, String string, boolean bl) {
        String string2 = properties.getProperty(string);
        return string2 == null ? bl : Boolean.parseBoolean(string2);
    }
}

