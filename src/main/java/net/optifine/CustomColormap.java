/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.BlockPosM;
import net.optifine.CustomColors;
import net.optifine.config.ConnectedParser;
import net.optifine.config.MatchBlock;
import net.optifine.config.Matches;
import net.optifine.util.TextureUtils;

public class CustomColormap
implements CustomColors.IColorizer {
    public String name = null;
    public String basePath = null;
    private int format = -1;
    private MatchBlock[] matchBlocks = null;
    private String source = null;
    private int color = -1;
    private int yVariance = 0;
    private int yOffset = 0;
    private int width = 0;
    private int height = 0;
    private int[] colors = null;
    private float[][] colorsRgb = null;
    private static final int FORMAT_UNKNOWN = -1;
    private static final int FORMAT_VANILLA = 0;
    private static final int FORMAT_GRID = 1;
    private static final int FORMAT_FIXED = 2;
    public static final String FORMAT_VANILLA_STRING = "vanilla";
    public static final String FORMAT_GRID_STRING = "grid";
    public static final String FORMAT_FIXED_STRING = "fixed";
    public static final String[] FORMAT_STRINGS = new String[]{"vanilla", "grid", "fixed"};
    public static final String KEY_FORMAT = "format";
    public static final String KEY_BLOCKS = "blocks";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_COLOR = "color";
    public static final String KEY_Y_VARIANCE = "yVariance";
    public static final String KEY_Y_OFFSET = "yOffset";

    public CustomColormap(Properties properties, String string, int n, int n2, String string2) {
        ConnectedParser connectedParser = new ConnectedParser("Colormap");
        this.name = connectedParser.parseName(string);
        this.basePath = connectedParser.parseBasePath(string);
        this.format = this.parseFormat(properties.getProperty(KEY_FORMAT, string2));
        this.matchBlocks = connectedParser.parseMatchBlocks(properties.getProperty(KEY_BLOCKS));
        this.source = CustomColormap.parseTexture(properties.getProperty(KEY_SOURCE), string, this.basePath);
        this.color = ConnectedParser.parseColor(properties.getProperty(KEY_COLOR), -1);
        this.yVariance = connectedParser.parseInt(properties.getProperty(KEY_Y_VARIANCE), 0);
        this.yOffset = connectedParser.parseInt(properties.getProperty(KEY_Y_OFFSET), 0);
        this.width = n;
        this.height = n2;
    }

    private int parseFormat(String string) {
        if (string == null) {
            return 0;
        }
        if ((string = string.trim()).equals(FORMAT_VANILLA_STRING)) {
            return 0;
        }
        if (string.equals(FORMAT_GRID_STRING)) {
            return 1;
        }
        if (string.equals(FORMAT_FIXED_STRING)) {
            return 2;
        }
        CustomColormap.warn("Unknown format: " + string);
        return -1;
    }

    public boolean isValid(String string) {
        if (this.format != 0 && this.format != 1) {
            if (this.format != 2) {
                return false;
            }
            if (this.color < 0) {
                this.color = 0xFFFFFF;
            }
        } else {
            if (this.source == null) {
                CustomColormap.warn("Source not defined: " + string);
                return false;
            }
            this.readColors();
            if (this.colors == null) {
                return false;
            }
            if (this.color < 0) {
                if (this.format == 0) {
                    this.color = this.getColor(127, 127);
                }
                if (this.format == 1) {
                    this.color = this.getColorGrid(BiomeGenBase.plains, new BlockPos(0, 64, 0));
                }
            }
        }
        return true;
    }

    public boolean isValidMatchBlocks(String string) {
        if (this.matchBlocks == null) {
            this.matchBlocks = this.detectMatchBlocks();
            if (this.matchBlocks == null) {
                CustomColormap.warn("Match blocks not defined: " + string);
                return false;
            }
        }
        return true;
    }

    private MatchBlock[] detectMatchBlocks() {
        Object object;
        int n;
        Block block = Block.getBlockFromName(this.name);
        if (block != null) {
            return new MatchBlock[]{new MatchBlock(Block.getIdFromBlock(block))};
        }
        Pattern pattern = Pattern.compile("^block([0-9]+).*$");
        Matcher matcher = pattern.matcher(this.name);
        if (matcher.matches() && (n = Config.parseInt((String)(object = matcher.group(1)), -1)) >= 0) {
            return new MatchBlock[]{new MatchBlock(n)};
        }
        object = new ConnectedParser("Colormap");
        MatchBlock[] matchBlockArray = ((ConnectedParser)object).parseMatchBlock(this.name);
        return matchBlockArray != null ? matchBlockArray : null;
    }

    private void readColors() {
        try {
            boolean bl;
            this.colors = null;
            if (this.source == null) {
                return;
            }
            String string = this.source + ".png";
            ResourceLocation resourceLocation = new ResourceLocation(string);
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return;
            }
            BufferedImage bufferedImage = TextureUtil.readBufferedImage(inputStream2);
            if (bufferedImage == null) {
                return;
            }
            int n = bufferedImage.getWidth();
            int n2 = bufferedImage.getHeight();
            boolean bl2 = this.width < 0 || this.width == n;
            boolean bl3 = bl = this.height < 0 || this.height == n2;
            if (!bl2 || !bl) {
                CustomColormap.dbg("Non-standard palette size: " + n + "x" + n2 + ", should be: " + this.width + "x" + this.height + ", path: " + string);
            }
            this.width = n;
            this.height = n2;
            if (this.width <= 0 || this.height <= 0) {
                CustomColormap.warn("Invalid palette size: " + n + "x" + n2 + ", path: " + string);
                return;
            }
            this.colors = new int[n * n2];
            bufferedImage.getRGB(0, 0, n, n2, this.colors, 0, n);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private static void dbg(String string) {
        Config.dbg("CustomColors: " + string);
    }

    private static void warn(String string) {
        Config.warn("CustomColors: " + string);
    }

    private static String parseTexture(String string, String string2, String string3) {
        int n;
        if (string != null) {
            String string4;
            if ((string = string.trim()).endsWith(string4 = ".png")) {
                string = string.substring(0, string.length() - string4.length());
            }
            string = CustomColormap.fixTextureName(string, string3);
            return string;
        }
        String string5 = string2;
        int n2 = string2.lastIndexOf(47);
        if (n2 >= 0) {
            string5 = string2.substring(n2 + 1);
        }
        if ((n = string5.lastIndexOf(46)) >= 0) {
            string5 = string5.substring(0, n);
        }
        string5 = CustomColormap.fixTextureName(string5, string3);
        return string5;
    }

    private static String fixTextureName(String object, String string) {
        String string2;
        if (!(((String)(object = TextureUtils.fixResourcePath((String)object, string))).startsWith(string) || ((String)object).startsWith("textures/") || ((String)object).startsWith("mcpatcher/"))) {
            object = string + "/" + (String)object;
        }
        if (((String)object).endsWith(".png")) {
            object = ((String)object).substring(0, ((String)object).length() - 4);
        }
        if (((String)object).startsWith(string2 = "textures/blocks/")) {
            object = ((String)object).substring(string2.length());
        }
        if (((String)object).startsWith("/")) {
            object = ((String)object).substring(1);
        }
        return object;
    }

    public boolean matchesBlock(BlockStateBase blockStateBase) {
        return Matches.block(blockStateBase, this.matchBlocks);
    }

    public int getColorRandom() {
        if (this.format == 2) {
            return this.color;
        }
        int n = CustomColors.random.nextInt(this.colors.length);
        return this.colors[n];
    }

    public int getColor(int n) {
        n = Config.limit(n, 0, this.colors.length - 1);
        return this.colors[n] & 0xFFFFFF;
    }

    public int getColor(int n, int n2) {
        n = Config.limit(n, 0, this.width - 1);
        n2 = Config.limit(n2, 0, this.height - 1);
        return this.colors[n2 * this.width + n] & 0xFFFFFF;
    }

    public float[][] getColorsRgb() {
        if (this.colorsRgb == null) {
            this.colorsRgb = CustomColormap.toRgb(this.colors);
        }
        return this.colorsRgb;
    }

    @Override
    public int getColor(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        return this.getColor(iBlockAccess, blockPos);
    }

    public int getColor(IBlockAccess iBlockAccess, BlockPos blockPos) {
        BiomeGenBase biomeGenBase = CustomColors.getColorBiome(iBlockAccess, blockPos);
        return this.getColor(biomeGenBase, blockPos);
    }

    @Override
    public boolean isColorConstant() {
        return this.format == 2;
    }

    public int getColor(BiomeGenBase biomeGenBase, BlockPos blockPos) {
        return this.format == 0 ? this.getColorVanilla(biomeGenBase, blockPos) : (this.format == 1 ? this.getColorGrid(biomeGenBase, blockPos) : this.color);
    }

    public int getColorSmooth(IBlockAccess iBlockAccess, double d, double d2, double d3, int n) {
        int n2;
        int n3;
        int n4;
        if (this.format == 2) {
            return this.color;
        }
        int n5 = MathHelper.floor_double(d);
        int n6 = MathHelper.floor_double(d2);
        int n7 = MathHelper.floor_double(d3);
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        BlockPosM blockPosM = new BlockPosM(0, 0, 0);
        for (n4 = n5 - n; n4 <= n5 + n; ++n4) {
            for (n3 = n7 - n; n3 <= n7 + n; ++n3) {
                blockPosM.setXyz(n4, n6, n3);
                n2 = this.getColor(iBlockAccess, (BlockPos)blockPosM);
                n8 += n2 >> 16 & 0xFF;
                n9 += n2 >> 8 & 0xFF;
                n10 += n2 & 0xFF;
                ++n11;
            }
        }
        n4 = n8 / n11;
        n3 = n9 / n11;
        n2 = n10 / n11;
        return n4 << 16 | n3 << 8 | n2;
    }

    private int getColorVanilla(BiomeGenBase biomeGenBase, BlockPos blockPos) {
        double d = MathHelper.clamp_float(biomeGenBase.getFloatTemperature(blockPos), 0.0f, 1.0f);
        double d2 = MathHelper.clamp_float(biomeGenBase.getFloatRainfall(), 0.0f, 1.0f);
        int n = (int)((1.0 - d) * (double)(this.width - 1));
        int n2 = (int)((1.0 - (d2 *= d)) * (double)(this.height - 1));
        return this.getColor(n, n2);
    }

    private int getColorGrid(BiomeGenBase biomeGenBase, BlockPos blockPos) {
        int n = biomeGenBase.biomeID;
        int n2 = blockPos.getY() - this.yOffset;
        if (this.yVariance > 0) {
            int n3 = blockPos.getX() << 16 + blockPos.getZ();
            int n4 = Config.intHash(n3);
            int n5 = this.yVariance * 2 + 1;
            int n6 = (n4 & 0xFF) % n5 - this.yVariance;
            n2 += n6;
        }
        return this.getColor(n, n2);
    }

    public int getLength() {
        return this.format == 2 ? 1 : this.colors.length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    private static float[][] toRgb(int[] nArray) {
        float[][] fArray = new float[nArray.length][3];
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            float f = (float)(n >> 16 & 0xFF) / 255.0f;
            float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(n & 0xFF) / 255.0f;
            float[] fArray2 = fArray[i];
            fArray2[0] = f;
            fArray2[1] = f2;
            fArray2[2] = f3;
        }
        return fArray;
    }

    public void addMatchBlock(MatchBlock matchBlock) {
        if (this.matchBlocks == null) {
            this.matchBlocks = new MatchBlock[0];
        }
        this.matchBlocks = (MatchBlock[])Config.addObjectToArray(this.matchBlocks, matchBlock);
    }

    public void addMatchBlock(int n, int n2) {
        MatchBlock matchBlock = this.getMatchBlock(n);
        if (matchBlock != null) {
            if (n2 >= 0) {
                matchBlock.addMetadata(n2);
            }
        } else {
            this.addMatchBlock(new MatchBlock(n, n2));
        }
    }

    private MatchBlock getMatchBlock(int n) {
        if (this.matchBlocks == null) {
            return null;
        }
        for (int i = 0; i < this.matchBlocks.length; ++i) {
            MatchBlock matchBlock = this.matchBlocks[i];
            if (matchBlock.getBlockId() != n) continue;
            return matchBlock;
        }
        return null;
    }

    public int[] getMatchBlockIds() {
        Object object;
        if (this.matchBlocks == null) {
            return null;
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < this.matchBlocks.length; ++i) {
            object = this.matchBlocks[i];
            if (((MatchBlock)object).getBlockId() < 0) continue;
            hashSet.add(((MatchBlock)object).getBlockId());
        }
        Integer[] integerArray = hashSet.toArray(new Integer[hashSet.size()]);
        object = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; ++i) {
            object[i] = integerArray[i];
        }
        return object;
    }

    public String toString() {
        return this.basePath + "/" + this.name + ", blocks: " + Config.arrayToString(this.matchBlocks) + ", source: " + this.source;
    }
}

