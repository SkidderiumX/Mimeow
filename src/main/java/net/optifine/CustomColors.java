/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockStem;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.BlockPosM;
import net.optifine.CustomColorFader;
import net.optifine.CustomColormap;
import net.optifine.LightMap;
import net.optifine.LightMapPack;
import net.optifine.config.ConnectedParser;
import net.optifine.config.MatchBlock;
import net.optifine.reflect.Reflector;
import net.optifine.render.RenderEnv;
import net.optifine.util.EntityUtils;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.ResUtils;
import net.optifine.util.StrUtils;
import net.optifine.util.TextureUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class CustomColors {
    private static String paletteFormatDefault = "vanilla";
    private static CustomColormap waterColors = null;
    private static CustomColormap foliagePineColors = null;
    private static CustomColormap foliageBirchColors = null;
    private static CustomColormap swampFoliageColors = null;
    private static CustomColormap swampGrassColors = null;
    private static CustomColormap[] colorsBlockColormaps = null;
    private static CustomColormap[][] blockColormaps = null;
    private static CustomColormap skyColors = null;
    private static CustomColorFader skyColorFader = new CustomColorFader();
    private static CustomColormap fogColors = null;
    private static CustomColorFader fogColorFader = new CustomColorFader();
    private static CustomColormap underwaterColors = null;
    private static CustomColorFader underwaterColorFader = new CustomColorFader();
    private static CustomColormap underlavaColors = null;
    private static CustomColorFader underlavaColorFader = new CustomColorFader();
    private static LightMapPack[] lightMapPacks = null;
    private static int lightmapMinDimensionId = 0;
    private static CustomColormap redstoneColors = null;
    private static CustomColormap xpOrbColors = null;
    private static int xpOrbTime = -1;
    private static CustomColormap durabilityColors = null;
    private static CustomColormap stemColors = null;
    private static CustomColormap stemMelonColors = null;
    private static CustomColormap stemPumpkinColors = null;
    private static CustomColormap myceliumParticleColors = null;
    private static boolean useDefaultGrassFoliageColors = true;
    private static int particleWaterColor = -1;
    private static int particlePortalColor = -1;
    private static int lilyPadColor = -1;
    private static int expBarTextColor = -1;
    private static int bossTextColor = -1;
    private static int signTextColor = -1;
    private static Vec3 fogColorNether = null;
    private static Vec3 fogColorEnd = null;
    private static Vec3 skyColorEnd = null;
    private static int[] spawnEggPrimaryColors = null;
    private static int[] spawnEggSecondaryColors = null;
    private static float[][] wolfCollarColors = null;
    private static float[][] sheepColors = null;
    private static int[] textColors = null;
    private static int[] mapColorsOriginal = null;
    private static int[] potionColors = null;
    private static final IBlockState BLOCK_STATE_DIRT = Blocks.dirt.getDefaultState();
    private static final IBlockState BLOCK_STATE_WATER = Blocks.water.getDefaultState();
    public static Random random = new Random();
    private static final IColorizer COLORIZER_GRASS = new IColorizer(){

        @Override
        public int getColor(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
            BiomeGenBase biomeGenBase = CustomColors.getColorBiome(iBlockAccess, blockPos);
            return swampGrassColors != null && biomeGenBase == BiomeGenBase.swampland ? swampGrassColors.getColor(biomeGenBase, blockPos) : biomeGenBase.getGrassColorAtPos(blockPos);
        }

        @Override
        public boolean isColorConstant() {
            return false;
        }
    };
    private static final IColorizer COLORIZER_FOLIAGE = new IColorizer(){

        @Override
        public int getColor(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
            BiomeGenBase biomeGenBase = CustomColors.getColorBiome(iBlockAccess, blockPos);
            return swampFoliageColors != null && biomeGenBase == BiomeGenBase.swampland ? swampFoliageColors.getColor(biomeGenBase, blockPos) : biomeGenBase.getFoliageColorAtPos(blockPos);
        }

        @Override
        public boolean isColorConstant() {
            return false;
        }
    };
    private static final IColorizer COLORIZER_FOLIAGE_PINE = new IColorizer(){

        @Override
        public int getColor(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
            return foliagePineColors != null ? foliagePineColors.getColor(iBlockAccess, blockPos) : ColorizerFoliage.getFoliageColorPine();
        }

        @Override
        public boolean isColorConstant() {
            return foliagePineColors == null;
        }
    };
    private static final IColorizer COLORIZER_FOLIAGE_BIRCH = new IColorizer(){

        @Override
        public int getColor(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
            return foliageBirchColors != null ? foliageBirchColors.getColor(iBlockAccess, blockPos) : ColorizerFoliage.getFoliageColorBirch();
        }

        @Override
        public boolean isColorConstant() {
            return foliageBirchColors == null;
        }
    };
    private static final IColorizer COLORIZER_WATER = new IColorizer(){

        @Override
        public int getColor(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
            BiomeGenBase biomeGenBase = CustomColors.getColorBiome(iBlockAccess, blockPos);
            return waterColors != null ? waterColors.getColor(biomeGenBase, blockPos) : (Reflector.CompatBiome_getWaterColorMultiplier.exists() ? Reflector.callInt(biomeGenBase, Reflector.CompatBiome_getWaterColorMultiplier, new Object[0]) : biomeGenBase.waterColorMultiplier);
        }

        @Override
        public boolean isColorConstant() {
            return false;
        }
    };

    public static void update() {
        paletteFormatDefault = "vanilla";
        waterColors = null;
        foliageBirchColors = null;
        foliagePineColors = null;
        swampGrassColors = null;
        swampFoliageColors = null;
        skyColors = null;
        fogColors = null;
        underwaterColors = null;
        underlavaColors = null;
        redstoneColors = null;
        xpOrbColors = null;
        xpOrbTime = -1;
        durabilityColors = null;
        stemColors = null;
        myceliumParticleColors = null;
        lightMapPacks = null;
        particleWaterColor = -1;
        particlePortalColor = -1;
        lilyPadColor = -1;
        expBarTextColor = -1;
        bossTextColor = -1;
        signTextColor = -1;
        fogColorNether = null;
        fogColorEnd = null;
        skyColorEnd = null;
        colorsBlockColormaps = null;
        blockColormaps = null;
        useDefaultGrassFoliageColors = true;
        spawnEggPrimaryColors = null;
        spawnEggSecondaryColors = null;
        wolfCollarColors = null;
        sheepColors = null;
        textColors = null;
        CustomColors.setMapColors(mapColorsOriginal);
        potionColors = null;
        paletteFormatDefault = CustomColors.getValidProperty("mcpatcher/color.properties", "palette.format", CustomColormap.FORMAT_STRINGS, "vanilla");
        String string = "mcpatcher/colormap/";
        String[] stringArray = new String[]{"water.png", "watercolorX.png"};
        waterColors = CustomColors.getCustomColors(string, stringArray, 256, 256);
        CustomColors.updateUseDefaultGrassFoliageColors();
        if (Config.isCustomColors()) {
            String[] stringArray2 = new String[]{"pine.png", "pinecolor.png"};
            foliagePineColors = CustomColors.getCustomColors(string, stringArray2, 256, 256);
            String[] stringArray3 = new String[]{"birch.png", "birchcolor.png"};
            foliageBirchColors = CustomColors.getCustomColors(string, stringArray3, 256, 256);
            String[] stringArray4 = new String[]{"swampgrass.png", "swampgrasscolor.png"};
            swampGrassColors = CustomColors.getCustomColors(string, stringArray4, 256, 256);
            String[] stringArray5 = new String[]{"swampfoliage.png", "swampfoliagecolor.png"};
            swampFoliageColors = CustomColors.getCustomColors(string, stringArray5, 256, 256);
            String[] stringArray6 = new String[]{"sky0.png", "skycolor0.png"};
            skyColors = CustomColors.getCustomColors(string, stringArray6, 256, 256);
            String[] stringArray7 = new String[]{"fog0.png", "fogcolor0.png"};
            fogColors = CustomColors.getCustomColors(string, stringArray7, 256, 256);
            String[] stringArray8 = new String[]{"underwater.png", "underwatercolor.png"};
            underwaterColors = CustomColors.getCustomColors(string, stringArray8, 256, 256);
            String[] stringArray9 = new String[]{"underlava.png", "underlavacolor.png"};
            underlavaColors = CustomColors.getCustomColors(string, stringArray9, 256, 256);
            String[] stringArray10 = new String[]{"redstone.png", "redstonecolor.png"};
            redstoneColors = CustomColors.getCustomColors(string, stringArray10, 16, 1);
            xpOrbColors = CustomColors.getCustomColors(string + "xporb.png", -1, -1);
            durabilityColors = CustomColors.getCustomColors(string + "durability.png", -1, -1);
            String[] stringArray11 = new String[]{"stem.png", "stemcolor.png"};
            stemColors = CustomColors.getCustomColors(string, stringArray11, 8, 1);
            stemPumpkinColors = CustomColors.getCustomColors(string + "pumpkinstem.png", 8, 1);
            stemMelonColors = CustomColors.getCustomColors(string + "melonstem.png", 8, 1);
            String[] stringArray12 = new String[]{"myceliumparticle.png", "myceliumparticlecolor.png"};
            myceliumParticleColors = CustomColors.getCustomColors(string, stringArray12, -1, -1);
            Pair<LightMapPack[], Integer> pair = CustomColors.parseLightMapPacks();
            lightMapPacks = pair.getLeft();
            lightmapMinDimensionId = pair.getRight();
            CustomColors.readColorProperties("mcpatcher/color.properties");
            blockColormaps = CustomColors.readBlockColormaps(new String[]{string + "custom/", string + "blocks/"}, colorsBlockColormaps, 256, 256);
            CustomColors.updateUseDefaultGrassFoliageColors();
        }
    }

    private static String getValidProperty(String string, String string2, String[] stringArray, String string3) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return string3;
            }
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
            String string4 = propertiesOrdered.getProperty(string2);
            if (string4 == null) {
                return string3;
            }
            List<String> list = Arrays.asList(stringArray);
            if (!list.contains(string4)) {
                CustomColors.warn("Invalid value: " + string2 + "=" + string4);
                CustomColors.warn("Expected values: " + Config.arrayToString(stringArray));
                return string3;
            }
            CustomColors.dbg(string2 + "=" + string4);
            return string4;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return string3;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return string3;
        }
    }

    private static Pair<LightMapPack[], Integer> parseLightMapPacks() {
        Object object;
        Object object2;
        int n;
        Integer[] integerArray;
        String string = "mcpatcher/lightmap/world";
        String string2 = ".png";
        String[] stringArray = ResUtils.collectFiles(string, string2);
        HashMap<Integer, Integer[]> hashMap = new HashMap<Integer, Integer[]>();
        for (int i = 0; i < stringArray.length; ++i) {
            integerArray = stringArray[i];
            String string3 = StrUtils.removePrefixSuffix((String)integerArray, string, string2);
            n = Config.parseInt(string3, Integer.MIN_VALUE);
            if (n == Integer.MIN_VALUE) {
                CustomColors.warn("Invalid dimension ID: " + string3 + ", path: " + (String)integerArray);
                continue;
            }
            hashMap.put(n, integerArray);
        }
        Set set = hashMap.keySet();
        integerArray = set.toArray(new Integer[set.size()]);
        Arrays.sort((Object[])integerArray);
        if (integerArray.length <= 0) {
            return new ImmutablePair<Object, Integer>(null, 0);
        }
        int n2 = integerArray[0];
        n = integerArray[integerArray.length - 1];
        int n3 = n - n2 + 1;
        CustomColormap[] customColormapArray = new CustomColormap[n3];
        for (int i = 0; i < integerArray.length; ++i) {
            Integer n4 = integerArray[i];
            object2 = (String)hashMap.get(n4);
            object = CustomColors.getCustomColors((String)object2, -1, -1);
            if (object == null) continue;
            if (((CustomColormap)object).getWidth() < 16) {
                CustomColors.warn("Invalid lightmap width: " + ((CustomColormap)object).getWidth() + ", path: " + (String)object2);
                continue;
            }
            int n5 = n4 - n2;
            customColormapArray[n5] = object;
        }
        LightMapPack[] lightMapPackArray = new LightMapPack[customColormapArray.length];
        for (int i = 0; i < customColormapArray.length; ++i) {
            LightMapPack lightMapPack;
            object2 = customColormapArray[i];
            if (object2 == null) continue;
            object = ((CustomColormap)object2).name;
            String string4 = ((CustomColormap)object2).basePath;
            CustomColormap customColormap = CustomColors.getCustomColors(string4 + "/" + (String)object + "_rain.png", -1, -1);
            CustomColormap customColormap2 = CustomColors.getCustomColors(string4 + "/" + (String)object + "_thunder.png", -1, -1);
            LightMap lightMap = new LightMap((CustomColormap)object2);
            LightMap lightMap2 = customColormap != null ? new LightMap(customColormap) : null;
            LightMap lightMap3 = customColormap2 != null ? new LightMap(customColormap2) : null;
            lightMapPackArray[i] = lightMapPack = new LightMapPack(lightMap, lightMap2, lightMap3);
        }
        return new ImmutablePair<LightMapPack[], Integer>(lightMapPackArray, n2);
    }

    private static int getTextureHeight(String string, int n) {
        try {
            InputStream inputStream2 = Config.getResourceStream(new ResourceLocation(string));
            if (inputStream2 == null) {
                return n;
            }
            BufferedImage bufferedImage = ImageIO.read(inputStream2);
            inputStream2.close();
            return bufferedImage == null ? n : bufferedImage.getHeight();
        }
        catch (IOException iOException) {
            return n;
        }
    }

    private static void readColorProperties(String string) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return;
            }
            CustomColors.dbg("Loading " + string);
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
            particleWaterColor = CustomColors.readColor((Properties)propertiesOrdered, new String[]{"particle.water", "drop.water"});
            particlePortalColor = CustomColors.readColor((Properties)propertiesOrdered, "particle.portal");
            lilyPadColor = CustomColors.readColor((Properties)propertiesOrdered, "lilypad");
            expBarTextColor = CustomColors.readColor((Properties)propertiesOrdered, "text.xpbar");
            bossTextColor = CustomColors.readColor((Properties)propertiesOrdered, "text.boss");
            signTextColor = CustomColors.readColor((Properties)propertiesOrdered, "text.sign");
            fogColorNether = CustomColors.readColorVec3(propertiesOrdered, "fog.nether");
            fogColorEnd = CustomColors.readColorVec3(propertiesOrdered, "fog.end");
            skyColorEnd = CustomColors.readColorVec3(propertiesOrdered, "sky.end");
            colorsBlockColormaps = CustomColors.readCustomColormaps(propertiesOrdered, string);
            spawnEggPrimaryColors = CustomColors.readSpawnEggColors(propertiesOrdered, string, "egg.shell.", "Spawn egg shell");
            spawnEggSecondaryColors = CustomColors.readSpawnEggColors(propertiesOrdered, string, "egg.spots.", "Spawn egg spot");
            wolfCollarColors = CustomColors.readDyeColors(propertiesOrdered, string, "collar.", "Wolf collar");
            sheepColors = CustomColors.readDyeColors(propertiesOrdered, string, "sheep.", "Sheep");
            textColors = CustomColors.readTextColors(propertiesOrdered, string, "text.code.", "Text");
            int[] nArray = CustomColors.readMapColors(propertiesOrdered, string, "map.", "Map");
            if (nArray != null) {
                if (mapColorsOriginal == null) {
                    mapColorsOriginal = CustomColors.getMapColors();
                }
                CustomColors.setMapColors(nArray);
            }
            potionColors = CustomColors.readPotionColors(propertiesOrdered, string, "potion.", "Potion");
            xpOrbTime = Config.parseInt(propertiesOrdered.getProperty("xporb.time"), -1);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private static CustomColormap[] readCustomColormaps(Properties properties, String string) {
        String string2;
        String string3;
        ArrayList<CustomColormap> arrayList = new ArrayList<CustomColormap>();
        String string4 = "palette.block.";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (Object object : properties.keySet()) {
            string3 = (String)object;
            string2 = properties.getProperty(string3);
            if (!string3.startsWith(string4)) continue;
            hashMap.put(string3, string2);
        }
        String[] stringArray = hashMap.keySet().toArray(new String[hashMap.size()]);
        for (int i = 0; i < stringArray.length; ++i) {
            string3 = stringArray[i];
            string2 = properties.getProperty(string3);
            CustomColors.dbg("Block palette: " + string3 + " = " + string2);
            String string5 = string3.substring(string4.length());
            String string6 = TextureUtils.getBasePath(string);
            string5 = TextureUtils.fixResourcePath(string5, string6);
            CustomColormap customColormap = CustomColors.getCustomColors(string5, 256, 256);
            if (customColormap == null) {
                CustomColors.warn("Colormap not found: " + string5);
                continue;
            }
            ConnectedParser connectedParser = new ConnectedParser("CustomColors");
            MatchBlock[] matchBlockArray = connectedParser.parseMatchBlocks(string2);
            if (matchBlockArray != null && matchBlockArray.length > 0) {
                for (int j = 0; j < matchBlockArray.length; ++j) {
                    MatchBlock matchBlock = matchBlockArray[j];
                    customColormap.addMatchBlock(matchBlock);
                }
                arrayList.add(customColormap);
                continue;
            }
            CustomColors.warn("Invalid match blocks: " + string2);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        CustomColormap[] customColormapArray = arrayList.toArray(new CustomColormap[arrayList.size()]);
        return customColormapArray;
    }

    private static CustomColormap[][] readBlockColormaps(String[] stringArray, CustomColormap[] customColormapArray, int n, int n2) {
        Object object;
        int n3;
        String[] stringArray2 = ResUtils.collectFiles(stringArray, new String[]{".properties"});
        Arrays.sort(stringArray2);
        ArrayList arrayList = new ArrayList();
        for (n3 = 0; n3 < stringArray2.length; ++n3) {
            object = stringArray2[n3];
            CustomColors.dbg("Block colormap: " + (String)object);
            try {
                ResourceLocation resourceLocation = new ResourceLocation("minecraft", (String)object);
                InputStream inputStream2 = Config.getResourceStream(resourceLocation);
                if (inputStream2 == null) {
                    CustomColors.warn("File not found: " + (String)object);
                    continue;
                }
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                CustomColormap customColormap = new CustomColormap(propertiesOrdered, (String)object, n, n2, paletteFormatDefault);
                if (!customColormap.isValid((String)object) || !customColormap.isValidMatchBlocks((String)object)) continue;
                CustomColors.addToBlockList(customColormap, arrayList);
                continue;
            }
            catch (FileNotFoundException fileNotFoundException) {
                CustomColors.warn("File not found: " + (String)object);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (customColormapArray != null) {
            for (n3 = 0; n3 < customColormapArray.length; ++n3) {
                object = customColormapArray[n3];
                CustomColors.addToBlockList((CustomColormap)object, arrayList);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        CustomColormap[][] customColormapArray2 = CustomColors.blockListToArray(arrayList);
        return customColormapArray2;
    }

    private static void addToBlockList(CustomColormap customColormap, List list) {
        int[] nArray = customColormap.getMatchBlockIds();
        if (nArray != null && nArray.length > 0) {
            for (int i = 0; i < nArray.length; ++i) {
                int n = nArray[i];
                if (n < 0) {
                    CustomColors.warn("Invalid block ID: " + n);
                    continue;
                }
                CustomColors.addToList(customColormap, list, n);
            }
        } else {
            CustomColors.warn("No match blocks: " + Config.arrayToString(nArray));
        }
    }

    private static void addToList(CustomColormap customColormap, List list, int n) {
        while (n >= list.size()) {
            list.add(null);
        }
        ArrayList<CustomColormap> arrayList = (ArrayList<CustomColormap>)list.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList<CustomColormap>();
            arrayList.set(n, (CustomColormap)((Object)arrayList));
        }
        arrayList.add(customColormap);
    }

    private static CustomColormap[][] blockListToArray(List list) {
        CustomColormap[][] customColormapArray = new CustomColormap[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            List list2 = (List)list.get(i);
            if (list2 == null) continue;
            CustomColormap[] customColormapArray2 = list2.toArray(new CustomColormap[list2.size()]);
            customColormapArray[i] = customColormapArray2;
        }
        return customColormapArray;
    }

    private static int readColor(Properties properties, String[] stringArray) {
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            int n = CustomColors.readColor(properties, string);
            if (n < 0) continue;
            return n;
        }
        return -1;
    }

    private static int readColor(Properties properties, String string) {
        String string2 = properties.getProperty(string);
        if (string2 == null) {
            return -1;
        }
        int n = CustomColors.parseColor(string2 = string2.trim());
        if (n < 0) {
            CustomColors.warn("Invalid color: " + string + " = " + string2);
            return n;
        }
        CustomColors.dbg(string + " = " + string2);
        return n;
    }

    private static int parseColor(String string) {
        if (string == null) {
            return -1;
        }
        string = string.trim();
        try {
            int n = Integer.parseInt(string, 16) & 0xFFFFFF;
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    private static Vec3 readColorVec3(Properties properties, String string) {
        int n = CustomColors.readColor(properties, string);
        if (n < 0) {
            return null;
        }
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        return new Vec3(f, f2, f3);
    }

    private static CustomColormap getCustomColors(String string, String[] stringArray, int n, int n2) {
        for (int i = 0; i < stringArray.length; ++i) {
            Object object = stringArray[i];
            CustomColormap customColormap = CustomColors.getCustomColors((String)(object = string + (String)object), n, n2);
            if (customColormap == null) continue;
            return customColormap;
        }
        return null;
    }

    public static CustomColormap getCustomColors(String string, int n, int n2) {
        try {
            Object object;
            ResourceLocation resourceLocation = new ResourceLocation(string);
            if (!Config.hasResource(resourceLocation)) {
                return null;
            }
            CustomColors.dbg("Colormap " + string);
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            String string2 = StrUtils.replaceSuffix(string, ".png", ".properties");
            ResourceLocation resourceLocation2 = new ResourceLocation(string2);
            if (Config.hasResource(resourceLocation2)) {
                object = Config.getResourceStream(resourceLocation2);
                propertiesOrdered.load((InputStream)object);
                ((InputStream)object).close();
                CustomColors.dbg("Colormap properties: " + string2);
            } else {
                ((Properties)propertiesOrdered).put("format", paletteFormatDefault);
                ((Properties)propertiesOrdered).put("source", string);
                string2 = string;
            }
            object = new CustomColormap(propertiesOrdered, string2, n, n2, paletteFormatDefault);
            return !((CustomColormap)object).isValid(string2) ? null : object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void updateUseDefaultGrassFoliageColors() {
        useDefaultGrassFoliageColors = foliageBirchColors == null && foliagePineColors == null && swampGrassColors == null && swampFoliageColors == null && Config.isSwampColors() && Config.isSmoothBiomes();
    }

    public static int getColorMultiplier(BakedQuad bakedQuad, IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, RenderEnv renderEnv) {
        IColorizer iColorizer;
        Block block = iBlockState.getBlock();
        IBlockState iBlockState2 = renderEnv.getBlockState();
        if (blockColormaps != null) {
            CustomColormap customColormap;
            if (!bakedQuad.hasTintIndex()) {
                if (block == Blocks.grass) {
                    iBlockState2 = BLOCK_STATE_DIRT;
                }
                if (block == Blocks.redstone_wire) {
                    return -1;
                }
            }
            if (block == Blocks.double_plant && renderEnv.getMetadata() >= 8) {
                blockPos = blockPos.down();
                iBlockState2 = iBlockAccess.getBlockState(blockPos);
            }
            if ((customColormap = CustomColors.getBlockColormap(iBlockState2)) != null) {
                if (Config.isSmoothBiomes() && !customColormap.isColorConstant()) {
                    return CustomColors.getSmoothColorMultiplier(iBlockState, iBlockAccess, blockPos, customColormap, renderEnv.getColorizerBlockPosM());
                }
                return customColormap.getColor(iBlockAccess, blockPos);
            }
        }
        if (!bakedQuad.hasTintIndex()) {
            return -1;
        }
        if (block == Blocks.waterlily) {
            return CustomColors.getLilypadColorMultiplier(iBlockAccess, blockPos);
        }
        if (block == Blocks.redstone_wire) {
            return CustomColors.getRedstoneColor(renderEnv.getBlockState());
        }
        if (block instanceof BlockStem) {
            return CustomColors.getStemColorMultiplier(block, iBlockAccess, blockPos, renderEnv);
        }
        if (useDefaultGrassFoliageColors) {
            return -1;
        }
        int n = renderEnv.getMetadata();
        if (block != Blocks.grass && block != Blocks.tallgrass && block != Blocks.double_plant) {
            if (block == Blocks.double_plant) {
                iColorizer = COLORIZER_GRASS;
                if (n >= 8) {
                    blockPos = blockPos.down();
                }
            } else if (block == Blocks.leaves) {
                switch (n & 3) {
                    case 0: {
                        iColorizer = COLORIZER_FOLIAGE;
                        break;
                    }
                    case 1: {
                        iColorizer = COLORIZER_FOLIAGE_PINE;
                        break;
                    }
                    case 2: {
                        iColorizer = COLORIZER_FOLIAGE_BIRCH;
                        break;
                    }
                    default: {
                        iColorizer = COLORIZER_FOLIAGE;
                        break;
                    }
                }
            } else if (block == Blocks.leaves2) {
                iColorizer = COLORIZER_FOLIAGE;
            } else {
                if (block != Blocks.vine) {
                    return -1;
                }
                iColorizer = COLORIZER_FOLIAGE;
            }
        } else {
            iColorizer = COLORIZER_GRASS;
        }
        return Config.isSmoothBiomes() && !iColorizer.isColorConstant() ? CustomColors.getSmoothColorMultiplier(iBlockState, iBlockAccess, blockPos, iColorizer, renderEnv.getColorizerBlockPosM()) : iColorizer.getColor(iBlockState2, iBlockAccess, blockPos);
    }

    protected static BiomeGenBase getColorBiome(IBlockAccess iBlockAccess, BlockPos blockPos) {
        BiomeGenBase biomeGenBase = iBlockAccess.getBiomeGenForCoords(blockPos);
        if (biomeGenBase == BiomeGenBase.swampland && !Config.isSwampColors()) {
            biomeGenBase = BiomeGenBase.plains;
        }
        return biomeGenBase;
    }

    private static CustomColormap getBlockColormap(IBlockState iBlockState) {
        if (blockColormaps == null) {
            return null;
        }
        if (!(iBlockState instanceof BlockStateBase)) {
            return null;
        }
        BlockStateBase blockStateBase = (BlockStateBase)iBlockState;
        int n = blockStateBase.getBlockId();
        if (n >= 0 && n < blockColormaps.length) {
            CustomColormap[] customColormapArray = blockColormaps[n];
            if (customColormapArray == null) {
                return null;
            }
            for (int i = 0; i < customColormapArray.length; ++i) {
                CustomColormap customColormap = customColormapArray[i];
                if (!customColormap.matchesBlock(blockStateBase)) continue;
                return customColormap;
            }
            return null;
        }
        return null;
    }

    private static int getSmoothColorMultiplier(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, IColorizer iColorizer, BlockPosM blockPosM) {
        int n;
        int n2;
        int n3;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = blockPos.getX();
        int n8 = blockPos.getY();
        int n9 = blockPos.getZ();
        BlockPosM blockPosM2 = blockPosM;
        for (n3 = n7 - 1; n3 <= n7 + 1; ++n3) {
            for (n2 = n9 - 1; n2 <= n9 + 1; ++n2) {
                blockPosM2.setXyz(n3, n8, n2);
                n = iColorizer.getColor(iBlockState, iBlockAccess, blockPosM2);
                n4 += n >> 16 & 0xFF;
                n5 += n >> 8 & 0xFF;
                n6 += n & 0xFF;
            }
        }
        n3 = n4 / 9;
        n2 = n5 / 9;
        n = n6 / 9;
        return n3 << 16 | n2 << 8 | n;
    }

    public static int getFluidColor(IBlockAccess iBlockAccess, IBlockState iBlockState, BlockPos blockPos, RenderEnv renderEnv) {
        Block block = iBlockState.getBlock();
        IColorizer iColorizer = CustomColors.getBlockColormap(iBlockState);
        if (iColorizer == null && iBlockState.getBlock().getMaterial() == Material.water) {
            iColorizer = COLORIZER_WATER;
        }
        return iColorizer == null ? block.colorMultiplier(iBlockAccess, blockPos, 0) : (Config.isSmoothBiomes() && !iColorizer.isColorConstant() ? CustomColors.getSmoothColorMultiplier(iBlockState, iBlockAccess, blockPos, iColorizer, renderEnv.getColorizerBlockPosM()) : iColorizer.getColor(iBlockState, iBlockAccess, blockPos));
    }

    public static void updatePortalFX(EntityFX entityFX) {
        if (particlePortalColor >= 0) {
            int n = particlePortalColor;
            int n2 = n >> 16 & 0xFF;
            int n3 = n >> 8 & 0xFF;
            int n4 = n & 0xFF;
            float f = (float)n2 / 255.0f;
            float f2 = (float)n3 / 255.0f;
            float f3 = (float)n4 / 255.0f;
            entityFX.setRBGColorF(f, f2, f3);
        }
    }

    public static void updateMyceliumFX(EntityFX entityFX) {
        if (myceliumParticleColors != null) {
            int n = myceliumParticleColors.getColorRandom();
            int n2 = n >> 16 & 0xFF;
            int n3 = n >> 8 & 0xFF;
            int n4 = n & 0xFF;
            float f = (float)n2 / 255.0f;
            float f2 = (float)n3 / 255.0f;
            float f3 = (float)n4 / 255.0f;
            entityFX.setRBGColorF(f, f2, f3);
        }
    }

    private static int getRedstoneColor(IBlockState iBlockState) {
        if (redstoneColors == null) {
            return -1;
        }
        int n = CustomColors.getRedstoneLevel(iBlockState, 15);
        int n2 = redstoneColors.getColor(n);
        return n2;
    }

    public static void updateReddustFX(EntityFX entityFX, IBlockAccess iBlockAccess, double d, double d2, double d3) {
        if (redstoneColors != null) {
            IBlockState iBlockState = iBlockAccess.getBlockState(new BlockPos(d, d2, d3));
            int n = CustomColors.getRedstoneLevel(iBlockState, 15);
            int n2 = redstoneColors.getColor(n);
            int n3 = n2 >> 16 & 0xFF;
            int n4 = n2 >> 8 & 0xFF;
            int n5 = n2 & 0xFF;
            float f = (float)n3 / 255.0f;
            float f2 = (float)n4 / 255.0f;
            float f3 = (float)n5 / 255.0f;
            entityFX.setRBGColorF(f, f2, f3);
        }
    }

    private static int getRedstoneLevel(IBlockState iBlockState, int n) {
        Block block = iBlockState.getBlock();
        if (!(block instanceof BlockRedstoneWire)) {
            return n;
        }
        Integer n2 = iBlockState.getValue(BlockRedstoneWire.POWER);
        if (!(n2 instanceof Integer)) {
            return n;
        }
        Integer n3 = n2;
        return n3;
    }

    public static float getXpOrbTimer(float f) {
        if (xpOrbTime <= 0) {
            return f;
        }
        float f2 = 628.0f / (float)xpOrbTime;
        return f * f2;
    }

    public static int getXpOrbColor(float f) {
        if (xpOrbColors == null) {
            return -1;
        }
        int n = (int)Math.round((double)((MathHelper.sin(f) + 1.0f) * (float)(xpOrbColors.getLength() - 1)) / 2.0);
        int n2 = xpOrbColors.getColor(n);
        return n2;
    }

    public static int getDurabilityColor(int n) {
        if (durabilityColors == null) {
            return -1;
        }
        int n2 = n * durabilityColors.getLength() / 255;
        int n3 = durabilityColors.getColor(n2);
        return n3;
    }

    public static void updateWaterFX(EntityFX entityFX, IBlockAccess iBlockAccess, double d, double d2, double d3, RenderEnv renderEnv) {
        if (waterColors != null || blockColormaps != null || particleWaterColor >= 0) {
            BlockPos blockPos = new BlockPos(d, d2, d3);
            renderEnv.reset(BLOCK_STATE_WATER, blockPos);
            int n = CustomColors.getFluidColor(iBlockAccess, BLOCK_STATE_WATER, blockPos, renderEnv);
            int n2 = n >> 16 & 0xFF;
            int n3 = n >> 8 & 0xFF;
            int n4 = n & 0xFF;
            float f = (float)n2 / 255.0f;
            float f2 = (float)n3 / 255.0f;
            float f3 = (float)n4 / 255.0f;
            if (particleWaterColor >= 0) {
                int n5 = particleWaterColor >> 16 & 0xFF;
                int n6 = particleWaterColor >> 8 & 0xFF;
                int n7 = particleWaterColor & 0xFF;
                f *= (float)n5 / 255.0f;
                f2 *= (float)n6 / 255.0f;
                f3 *= (float)n7 / 255.0f;
            }
            entityFX.setRBGColorF(f, f2, f3);
        }
    }

    private static int getLilypadColorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return lilyPadColor < 0 ? Blocks.waterlily.colorMultiplier(iBlockAccess, blockPos) : lilyPadColor;
    }

    private static Vec3 getFogColorNether(Vec3 vec3) {
        return fogColorNether == null ? vec3 : fogColorNether;
    }

    private static Vec3 getFogColorEnd(Vec3 vec3) {
        return fogColorEnd == null ? vec3 : fogColorEnd;
    }

    private static Vec3 getSkyColorEnd(Vec3 vec3) {
        return skyColorEnd == null ? vec3 : skyColorEnd;
    }

    public static Vec3 getSkyColor(Vec3 vec3, IBlockAccess iBlockAccess, double d, double d2, double d3) {
        if (skyColors == null) {
            return vec3;
        }
        int n = skyColors.getColorSmooth(iBlockAccess, d, d2, d3, 3);
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        float f4 = (float)vec3.xCoord / 0.5f;
        float f5 = (float)vec3.yCoord / 0.66275f;
        float f6 = (float)vec3.zCoord;
        Vec3 vec32 = skyColorFader.getColor(f *= f4, f2 *= f5, f3 *= f6);
        return vec32;
    }

    private static Vec3 getFogColor(Vec3 vec3, IBlockAccess iBlockAccess, double d, double d2, double d3) {
        if (fogColors == null) {
            return vec3;
        }
        int n = fogColors.getColorSmooth(iBlockAccess, d, d2, d3, 3);
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        float f4 = (float)vec3.xCoord / 0.753f;
        float f5 = (float)vec3.yCoord / 0.8471f;
        float f6 = (float)vec3.zCoord;
        Vec3 vec32 = fogColorFader.getColor(f *= f4, f2 *= f5, f3 *= f6);
        return vec32;
    }

    public static Vec3 getUnderwaterColor(IBlockAccess iBlockAccess, double d, double d2, double d3) {
        return CustomColors.getUnderFluidColor(iBlockAccess, d, d2, d3, underwaterColors, underwaterColorFader);
    }

    public static Vec3 getUnderlavaColor(IBlockAccess iBlockAccess, double d, double d2, double d3) {
        return CustomColors.getUnderFluidColor(iBlockAccess, d, d2, d3, underlavaColors, underlavaColorFader);
    }

    public static Vec3 getUnderFluidColor(IBlockAccess iBlockAccess, double d, double d2, double d3, CustomColormap customColormap, CustomColorFader customColorFader) {
        if (customColormap == null) {
            return null;
        }
        int n = customColormap.getColorSmooth(iBlockAccess, d, d2, d3, 3);
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        Vec3 vec3 = customColorFader.getColor(f, f2, f3);
        return vec3;
    }

    private static int getStemColorMultiplier(Block block, IBlockAccess iBlockAccess, BlockPos blockPos, RenderEnv renderEnv) {
        CustomColormap customColormap = stemColors;
        if (block == Blocks.pumpkin_stem && stemPumpkinColors != null) {
            customColormap = stemPumpkinColors;
        }
        if (block == Blocks.melon_stem && stemMelonColors != null) {
            customColormap = stemMelonColors;
        }
        if (customColormap == null) {
            return -1;
        }
        int n = renderEnv.getMetadata();
        return customColormap.getColor(n);
    }

    public static boolean updateLightmap(World world2, float f, int[] nArray, boolean bl, float f2) {
        if (world2 == null) {
            return false;
        }
        if (lightMapPacks == null) {
            return false;
        }
        int n = world2.provider.getDimensionId();
        int n2 = n - lightmapMinDimensionId;
        if (n2 >= 0 && n2 < lightMapPacks.length) {
            LightMapPack lightMapPack = lightMapPacks[n2];
            return lightMapPack == null ? false : lightMapPack.updateLightmap(world2, f, nArray, bl, f2);
        }
        return false;
    }

    public static Vec3 getWorldFogColor(Vec3 vec3, World world2, Entity entity, float f) {
        int n = world2.provider.getDimensionId();
        switch (n) {
            case -1: {
                vec3 = CustomColors.getFogColorNether(vec3);
                break;
            }
            case 0: {
                Minecraft minecraft = Minecraft.getMinecraft();
                vec3 = CustomColors.getFogColor(vec3, minecraft.theWorld, entity.posX, entity.posY + 1.0, entity.posZ);
                break;
            }
            case 1: {
                vec3 = CustomColors.getFogColorEnd(vec3);
            }
        }
        return vec3;
    }

    public static Vec3 getWorldSkyColor(Vec3 vec3, World world2, Entity entity, float f) {
        int n = world2.provider.getDimensionId();
        switch (n) {
            case 0: {
                Minecraft minecraft = Minecraft.getMinecraft();
                vec3 = CustomColors.getSkyColor(vec3, minecraft.theWorld, entity.posX, entity.posY + 1.0, entity.posZ);
                break;
            }
            case 1: {
                vec3 = CustomColors.getSkyColorEnd(vec3);
            }
        }
        return vec3;
    }

    private static int[] readSpawnEggColors(Properties properties, String string, String string2, String string3) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Set<Object> set = properties.keySet();
        int n = 0;
        for (Object object : set) {
            String string4 = (String)object;
            String string5 = properties.getProperty(string4);
            if (!string4.startsWith(string2)) continue;
            String string6 = StrUtils.removePrefix(string4, string2);
            int n2 = EntityUtils.getEntityIdByName(string6);
            if (n2 < 0) {
                CustomColors.warn("Invalid spawn egg name: " + string4);
                continue;
            }
            int n3 = CustomColors.parseColor(string5);
            if (n3 < 0) {
                CustomColors.warn("Invalid spawn egg color: " + string4 + " = " + string5);
                continue;
            }
            while (arrayList.size() <= n2) {
                arrayList.add(-1);
            }
            arrayList.set(n2, n3);
            ++n;
        }
        if (n <= 0) {
            return null;
        }
        CustomColors.dbg(string3 + " colors: " + n);
        Object object = new int[arrayList.size()];
        for (int i = 0; i < ((Object)object).length; ++i) {
            object[i] = (Integer)arrayList.get(i);
        }
        return object;
    }

    private static int getSpawnEggColor(ItemMonsterPlacer itemMonsterPlacer, ItemStack itemStack, int n, int n2) {
        int[] nArray;
        int n3 = itemStack.getMetadata();
        int[] nArray2 = nArray = n == 0 ? spawnEggPrimaryColors : spawnEggSecondaryColors;
        if (nArray == null) {
            return n2;
        }
        if (n3 >= 0 && n3 < nArray.length) {
            int n4 = nArray[n3];
            return n4 < 0 ? n2 : n4;
        }
        return n2;
    }

    public static int getColorFromItemStack(ItemStack itemStack, int n, int n2) {
        if (itemStack == null) {
            return n2;
        }
        Item item = itemStack.getItem();
        return item == null ? n2 : (item instanceof ItemMonsterPlacer ? CustomColors.getSpawnEggColor((ItemMonsterPlacer)item, itemStack, n, n2) : n2);
    }

    private static float[][] readDyeColors(Properties properties, String string, String string2, String string3) {
        EnumDyeColor[] enumDyeColorArray = EnumDyeColor.values();
        HashMap<String, EnumDyeColor> hashMap = new HashMap<String, EnumDyeColor>();
        for (int i = 0; i < enumDyeColorArray.length; ++i) {
            EnumDyeColor enumDyeColor = enumDyeColorArray[i];
            hashMap.put(enumDyeColor.getName(), enumDyeColor);
        }
        float[][] fArrayArray = new float[enumDyeColorArray.length][];
        int n = 0;
        for (Object object : properties.keySet()) {
            String string4 = (String)object;
            String string5 = properties.getProperty(string4);
            if (!string4.startsWith(string2)) continue;
            String string6 = StrUtils.removePrefix(string4, string2);
            if (string6.equals("lightBlue")) {
                string6 = "light_blue";
            }
            EnumDyeColor enumDyeColor = (EnumDyeColor)hashMap.get(string6);
            int n2 = CustomColors.parseColor(string5);
            if (enumDyeColor != null && n2 >= 0) {
                float[] fArray = new float[]{(float)(n2 >> 16 & 0xFF) / 255.0f, (float)(n2 >> 8 & 0xFF) / 255.0f, (float)(n2 & 0xFF) / 255.0f};
                fArrayArray[enumDyeColor.ordinal()] = fArray;
                ++n;
                continue;
            }
            CustomColors.warn("Invalid color: " + string4 + " = " + string5);
        }
        if (n <= 0) {
            return null;
        }
        CustomColors.dbg(string3 + " colors: " + n);
        return fArrayArray;
    }

    private static float[] getDyeColors(EnumDyeColor enumDyeColor, float[][] fArray, float[] fArray2) {
        if (fArray == null) {
            return fArray2;
        }
        if (enumDyeColor == null) {
            return fArray2;
        }
        float[] fArray3 = fArray[enumDyeColor.ordinal()];
        return fArray3 == null ? fArray2 : fArray3;
    }

    public static float[] getWolfCollarColors(EnumDyeColor enumDyeColor, float[] fArray) {
        return CustomColors.getDyeColors(enumDyeColor, wolfCollarColors, fArray);
    }

    public static float[] getSheepColors(EnumDyeColor enumDyeColor, float[] fArray) {
        return CustomColors.getDyeColors(enumDyeColor, sheepColors, fArray);
    }

    private static int[] readTextColors(Properties properties, String string, String string2, String string3) {
        int[] nArray = new int[32];
        Arrays.fill(nArray, -1);
        int n = 0;
        for (Object object : properties.keySet()) {
            String string4 = (String)object;
            String string5 = properties.getProperty(string4);
            if (!string4.startsWith(string2)) continue;
            String string6 = StrUtils.removePrefix(string4, string2);
            int n2 = Config.parseInt(string6, -1);
            int n3 = CustomColors.parseColor(string5);
            if (n2 >= 0 && n2 < nArray.length && n3 >= 0) {
                nArray[n2] = n3;
                ++n;
                continue;
            }
            CustomColors.warn("Invalid color: " + string4 + " = " + string5);
        }
        if (n <= 0) {
            return null;
        }
        CustomColors.dbg(string3 + " colors: " + n);
        return nArray;
    }

    public static int getTextColor(int n, int n2) {
        if (textColors == null) {
            return n2;
        }
        if (n >= 0 && n < textColors.length) {
            int n3 = textColors[n];
            return n3 < 0 ? n2 : n3;
        }
        return n2;
    }

    private static int[] readMapColors(Properties properties, String string, String string2, String string3) {
        int[] nArray = new int[MapColor.mapColorArray.length];
        Arrays.fill(nArray, -1);
        int n = 0;
        for (Object object : properties.keySet()) {
            String string4 = (String)object;
            String string5 = properties.getProperty(string4);
            if (!string4.startsWith(string2)) continue;
            String string6 = StrUtils.removePrefix(string4, string2);
            int n2 = CustomColors.getMapColorIndex(string6);
            int n3 = CustomColors.parseColor(string5);
            if (n2 >= 0 && n2 < nArray.length && n3 >= 0) {
                nArray[n2] = n3;
                ++n;
                continue;
            }
            CustomColors.warn("Invalid color: " + string4 + " = " + string5);
        }
        if (n <= 0) {
            return null;
        }
        CustomColors.dbg(string3 + " colors: " + n);
        return nArray;
    }

    private static int[] readPotionColors(Properties properties, String string, String string2, String string3) {
        int[] nArray = new int[Potion.potionTypes.length];
        Arrays.fill(nArray, -1);
        int n = 0;
        for (Object object : properties.keySet()) {
            String string4 = (String)object;
            String string5 = properties.getProperty(string4);
            if (!string4.startsWith(string2)) continue;
            int n2 = CustomColors.getPotionId(string4);
            int n3 = CustomColors.parseColor(string5);
            if (n2 >= 0 && n2 < nArray.length && n3 >= 0) {
                nArray[n2] = n3;
                ++n;
                continue;
            }
            CustomColors.warn("Invalid color: " + string4 + " = " + string5);
        }
        if (n <= 0) {
            return null;
        }
        CustomColors.dbg(string3 + " colors: " + n);
        return nArray;
    }

    private static int getPotionId(String string) {
        if (string.equals("potion.water")) {
            return 0;
        }
        Potion[] potionArray = Potion.potionTypes;
        for (int i = 0; i < potionArray.length; ++i) {
            Potion potion = potionArray[i];
            if (potion == null || !potion.getName().equals(string)) continue;
            return potion.getId();
        }
        return -1;
    }

    public static int getPotionColor(int n, int n2) {
        if (potionColors == null) {
            return n2;
        }
        if (n >= 0 && n < potionColors.length) {
            int n3 = potionColors[n];
            return n3 < 0 ? n2 : n3;
        }
        return n2;
    }

    private static int getMapColorIndex(String string) {
        return string == null ? -1 : (string.equals("air") ? MapColor.airColor.colorIndex : (string.equals("grass") ? MapColor.grassColor.colorIndex : (string.equals("sand") ? MapColor.sandColor.colorIndex : (string.equals("cloth") ? MapColor.clothColor.colorIndex : (string.equals("tnt") ? MapColor.tntColor.colorIndex : (string.equals("ice") ? MapColor.iceColor.colorIndex : (string.equals("iron") ? MapColor.ironColor.colorIndex : (string.equals("foliage") ? MapColor.foliageColor.colorIndex : (string.equals("clay") ? MapColor.clayColor.colorIndex : (string.equals("dirt") ? MapColor.dirtColor.colorIndex : (string.equals("stone") ? MapColor.stoneColor.colorIndex : (string.equals("water") ? MapColor.waterColor.colorIndex : (string.equals("wood") ? MapColor.woodColor.colorIndex : (string.equals("quartz") ? MapColor.quartzColor.colorIndex : (string.equals("gold") ? MapColor.goldColor.colorIndex : (string.equals("diamond") ? MapColor.diamondColor.colorIndex : (string.equals("lapis") ? MapColor.lapisColor.colorIndex : (string.equals("emerald") ? MapColor.emeraldColor.colorIndex : (string.equals("podzol") ? MapColor.obsidianColor.colorIndex : (string.equals("netherrack") ? MapColor.netherrackColor.colorIndex : (!string.equals("snow") && !string.equals("white") ? (!string.equals("adobe") && !string.equals("orange") ? (string.equals("magenta") ? MapColor.magentaColor.colorIndex : (!string.equals("light_blue") && !string.equals("lightBlue") ? (string.equals("yellow") ? MapColor.yellowColor.colorIndex : (string.equals("lime") ? MapColor.limeColor.colorIndex : (string.equals("pink") ? MapColor.pinkColor.colorIndex : (string.equals("gray") ? MapColor.grayColor.colorIndex : (string.equals("silver") ? MapColor.silverColor.colorIndex : (string.equals("cyan") ? MapColor.cyanColor.colorIndex : (string.equals("purple") ? MapColor.purpleColor.colorIndex : (string.equals("blue") ? MapColor.blueColor.colorIndex : (string.equals("brown") ? MapColor.brownColor.colorIndex : (string.equals("green") ? MapColor.greenColor.colorIndex : (string.equals("red") ? MapColor.redColor.colorIndex : (string.equals("black") ? MapColor.blackColor.colorIndex : -1)))))))))))) : MapColor.lightBlueColor.colorIndex)) : MapColor.adobeColor.colorIndex) : MapColor.snowColor.colorIndex)))))))))))))))))))));
    }

    private static int[] getMapColors() {
        MapColor[] mapColorArray = MapColor.mapColorArray;
        int[] nArray = new int[mapColorArray.length];
        Arrays.fill(nArray, -1);
        for (int i = 0; i < mapColorArray.length && i < nArray.length; ++i) {
            MapColor mapColor = mapColorArray[i];
            if (mapColor == null) continue;
            nArray[i] = mapColor.colorValue;
        }
        return nArray;
    }

    private static void setMapColors(int[] nArray) {
        if (nArray != null) {
            MapColor[] mapColorArray = MapColor.mapColorArray;
            boolean bl = false;
            for (int i = 0; i < mapColorArray.length && i < nArray.length; ++i) {
                int n;
                MapColor mapColor = mapColorArray[i];
                if (mapColor == null || (n = nArray[i]) < 0 || mapColor.colorValue == n) continue;
                mapColor.colorValue = n;
                bl = true;
            }
            if (bl) {
                Minecraft.getMinecraft().getTextureManager().reloadBannerTextures();
            }
        }
    }

    private static void dbg(String string) {
        Config.dbg("CustomColors: " + string);
    }

    private static void warn(String string) {
        Config.warn("CustomColors: " + string);
    }

    public static int getExpBarTextColor(int n) {
        return expBarTextColor < 0 ? n : expBarTextColor;
    }

    public static int getBossTextColor(int n) {
        return bossTextColor < 0 ? n : bossTextColor;
    }

    public static int getSignTextColor(int n) {
        return signTextColor < 0 ? n : signTextColor;
    }

    public static interface IColorizer {
        public int getColor(IBlockState var1, IBlockAccess var2, BlockPos var3);

        public boolean isColorConstant();
    }
}

