/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.ConnectedTextures;
import net.optifine.config.ConnectedParser;
import net.optifine.config.MatchBlock;
import net.optifine.config.Matches;
import net.optifine.config.NbtTagValue;
import net.optifine.config.RangeInt;
import net.optifine.config.RangeListInt;
import net.optifine.util.MathUtils;
import net.optifine.util.TextureUtils;

public class ConnectedProperties {
    public String name = null;
    public String basePath = null;
    public MatchBlock[] matchBlocks = null;
    public int[] metadatas = null;
    public String[] matchTiles = null;
    public int method = 0;
    public String[] tiles = null;
    public int connect = 0;
    public int faces = 63;
    public BiomeGenBase[] biomes = null;
    public RangeListInt heights = null;
    public int renderPass = 0;
    public boolean innerSeams = false;
    public int[] ctmTileIndexes = null;
    public int width = 0;
    public int height = 0;
    public int[] weights = null;
    public int randomLoops = 0;
    public int symmetry = 1;
    public boolean linked = false;
    public NbtTagValue nbtName = null;
    public int[] sumWeights = null;
    public int sumAllWeights = 1;
    public TextureAtlasSprite[] matchTileIcons = null;
    public TextureAtlasSprite[] tileIcons = null;
    public MatchBlock[] connectBlocks = null;
    public String[] connectTiles = null;
    public TextureAtlasSprite[] connectTileIcons = null;
    public int tintIndex = -1;
    public IBlockState tintBlockState = Blocks.air.getDefaultState();
    public EnumWorldBlockLayer layer = null;
    public static final int METHOD_NONE = 0;
    public static final int METHOD_CTM = 1;
    public static final int METHOD_HORIZONTAL = 2;
    public static final int METHOD_TOP = 3;
    public static final int METHOD_RANDOM = 4;
    public static final int METHOD_REPEAT = 5;
    public static final int METHOD_VERTICAL = 6;
    public static final int METHOD_FIXED = 7;
    public static final int METHOD_HORIZONTAL_VERTICAL = 8;
    public static final int METHOD_VERTICAL_HORIZONTAL = 9;
    public static final int METHOD_CTM_COMPACT = 10;
    public static final int METHOD_OVERLAY = 11;
    public static final int METHOD_OVERLAY_FIXED = 12;
    public static final int METHOD_OVERLAY_RANDOM = 13;
    public static final int METHOD_OVERLAY_REPEAT = 14;
    public static final int METHOD_OVERLAY_CTM = 15;
    public static final int CONNECT_NONE = 0;
    public static final int CONNECT_BLOCK = 1;
    public static final int CONNECT_TILE = 2;
    public static final int CONNECT_MATERIAL = 3;
    public static final int CONNECT_UNKNOWN = 128;
    public static final int FACE_BOTTOM = 1;
    public static final int FACE_TOP = 2;
    public static final int FACE_NORTH = 4;
    public static final int FACE_SOUTH = 8;
    public static final int FACE_WEST = 16;
    public static final int FACE_EAST = 32;
    public static final int FACE_SIDES = 60;
    public static final int FACE_ALL = 63;
    public static final int FACE_UNKNOWN = 128;
    public static final int SYMMETRY_NONE = 1;
    public static final int SYMMETRY_OPPOSITE = 2;
    public static final int SYMMETRY_ALL = 6;
    public static final int SYMMETRY_UNKNOWN = 128;
    public static final String TILE_SKIP_PNG = "<skip>.png";
    public static final String TILE_DEFAULT_PNG = "<default>.png";

    public ConnectedProperties(Properties properties, String string) {
        ConnectedParser connectedParser = new ConnectedParser("ConnectedTextures");
        this.name = connectedParser.parseName(string);
        this.basePath = connectedParser.parseBasePath(string);
        this.matchBlocks = connectedParser.parseMatchBlocks(properties.getProperty("matchBlocks"));
        this.metadatas = connectedParser.parseIntList(properties.getProperty("metadata"));
        this.matchTiles = this.parseMatchTiles(properties.getProperty("matchTiles"));
        this.method = ConnectedProperties.parseMethod(properties.getProperty("method"));
        this.tiles = this.parseTileNames(properties.getProperty("tiles"));
        this.connect = ConnectedProperties.parseConnect(properties.getProperty("connect"));
        this.faces = ConnectedProperties.parseFaces(properties.getProperty("faces"));
        this.biomes = connectedParser.parseBiomes(properties.getProperty("biomes"));
        this.heights = connectedParser.parseRangeListInt(properties.getProperty("heights"));
        if (this.heights == null) {
            int n = connectedParser.parseInt(properties.getProperty("minHeight"), -1);
            int n2 = connectedParser.parseInt(properties.getProperty("maxHeight"), 1024);
            if (n != -1 || n2 != 1024) {
                this.heights = new RangeListInt(new RangeInt(n, n2));
            }
        }
        this.renderPass = connectedParser.parseInt(properties.getProperty("renderPass"), -1);
        this.innerSeams = connectedParser.parseBoolean(properties.getProperty("innerSeams"), false);
        this.ctmTileIndexes = this.parseCtmTileIndexes(properties);
        this.width = connectedParser.parseInt(properties.getProperty("width"), -1);
        this.height = connectedParser.parseInt(properties.getProperty("height"), -1);
        this.weights = connectedParser.parseIntList(properties.getProperty("weights"));
        this.randomLoops = connectedParser.parseInt(properties.getProperty("randomLoops"), 0);
        this.symmetry = ConnectedProperties.parseSymmetry(properties.getProperty("symmetry"));
        this.linked = connectedParser.parseBoolean(properties.getProperty("linked"), false);
        this.nbtName = connectedParser.parseNbtTagValue("name", properties.getProperty("name"));
        this.connectBlocks = connectedParser.parseMatchBlocks(properties.getProperty("connectBlocks"));
        this.connectTiles = this.parseMatchTiles(properties.getProperty("connectTiles"));
        this.tintIndex = connectedParser.parseInt(properties.getProperty("tintIndex"), -1);
        this.tintBlockState = connectedParser.parseBlockState(properties.getProperty("tintBlock"), Blocks.air.getDefaultState());
        this.layer = connectedParser.parseBlockRenderLayer(properties.getProperty("layer"), EnumWorldBlockLayer.CUTOUT_MIPPED);
    }

    private int[] parseCtmTileIndexes(Properties properties) {
        if (this.tiles == null) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (Object object : properties.keySet()) {
            String string;
            String string2;
            if (!(object instanceof String) || !(string2 = (String)object).startsWith(string = "ctm.")) continue;
            String string3 = string2.substring(string.length());
            String string4 = properties.getProperty(string2);
            if (string4 == null) continue;
            string4 = string4.trim();
            int n = Config.parseInt(string3, -1);
            if (n >= 0 && n <= 46) {
                int n2 = Config.parseInt(string4, -1);
                if (n2 >= 0 && n2 < this.tiles.length) {
                    hashMap.put(n, n2);
                    continue;
                }
                Config.warn("Invalid CTM tile index: " + string4);
                continue;
            }
            Config.warn("Invalid CTM index: " + string3);
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        Object object = new int[47];
        for (int i = 0; i < ((Object)object).length; ++i) {
            object[i] = -1;
            if (!hashMap.containsKey(i)) continue;
            object[i] = (Integer)hashMap.get(i);
        }
        return object;
    }

    private String[] parseMatchTiles(String string) {
        if (string == null) {
            return null;
        }
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.endsWith(".png")) {
                string2 = string2.substring(0, string2.length() - 4);
            }
            stringArray[i] = string2 = TextureUtils.fixResourcePath(string2, this.basePath);
        }
        return stringArray;
    }

    private static String parseName(String string) {
        int n;
        String string2 = string;
        int n2 = string.lastIndexOf(47);
        if (n2 >= 0) {
            string2 = string.substring(n2 + 1);
        }
        if ((n = string2.lastIndexOf(46)) >= 0) {
            string2 = string2.substring(0, n);
        }
        return string2;
    }

    private static String parseBasePath(String string) {
        int n = string.lastIndexOf(47);
        return n < 0 ? "" : string.substring(0, n);
    }

    private String[] parseTileNames(String string) {
        Object object;
        if (string == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = Config.tokenize(string, " ,");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.contains("-") && ((String[])(object = Config.tokenize(string2, "-"))).length == 2) {
                int n = Config.parseInt(object[0], -1);
                int n2 = Config.parseInt(object[1], -1);
                if (n >= 0 && n2 >= 0) {
                    if (n > n2) {
                        Config.warn("Invalid interval: " + string2 + ", when parsing: " + string);
                        continue;
                    }
                    for (int j = n; j <= n2; ++j) {
                        arrayList.add(String.valueOf(j));
                    }
                    continue;
                }
            }
            arrayList.add(string2);
        }
        String[] stringArray2 = arrayList.toArray(new String[arrayList.size()]);
        for (int i = 0; i < stringArray2.length; ++i) {
            object = stringArray2[i];
            if (!(((String)(object = TextureUtils.fixResourcePath((String)object, this.basePath))).startsWith(this.basePath) || ((String)object).startsWith("textures/") || ((String)object).startsWith("mcpatcher/"))) {
                object = this.basePath + "/" + (String)object;
            }
            if (((String)object).endsWith(".png")) {
                object = ((String)object).substring(0, ((String)object).length() - 4);
            }
            if (((String)object).startsWith("/")) {
                object = ((String)object).substring(1);
            }
            stringArray2[i] = object;
        }
        return stringArray2;
    }

    private static int parseSymmetry(String string) {
        if (string == null) {
            return 1;
        }
        if ((string = string.trim()).equals("opposite")) {
            return 2;
        }
        if (string.equals("all")) {
            return 6;
        }
        Config.warn("Unknown symmetry: " + string);
        return 1;
    }

    private static int parseFaces(String string) {
        if (string == null) {
            return 63;
        }
        String[] stringArray = Config.tokenize(string, " ,");
        int n = 0;
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            int n2 = ConnectedProperties.parseFace(string2);
            n |= n2;
        }
        return n;
    }

    private static int parseFace(String string) {
        if (!(string = string.toLowerCase()).equals("bottom") && !string.equals("down")) {
            if (!string.equals("top") && !string.equals("up")) {
                if (string.equals("north")) {
                    return 4;
                }
                if (string.equals("south")) {
                    return 8;
                }
                if (string.equals("east")) {
                    return 32;
                }
                if (string.equals("west")) {
                    return 16;
                }
                if (string.equals("sides")) {
                    return 60;
                }
                if (string.equals("all")) {
                    return 63;
                }
                Config.warn("Unknown face: " + string);
                return 128;
            }
            return 2;
        }
        return 1;
    }

    private static int parseConnect(String string) {
        if (string == null) {
            return 0;
        }
        if ((string = string.trim()).equals("block")) {
            return 1;
        }
        if (string.equals("tile")) {
            return 2;
        }
        if (string.equals("material")) {
            return 3;
        }
        Config.warn("Unknown connect: " + string);
        return 128;
    }

    public static IProperty getProperty(String string, Collection collection) {
        for (Object e : collection) {
            IProperty iProperty = (IProperty)e;
            if (!string.equals(iProperty.getName())) continue;
            return iProperty;
        }
        return null;
    }

    private static int parseMethod(String string) {
        if (string == null) {
            return 1;
        }
        if (!(string = string.trim()).equals("ctm") && !string.equals("glass")) {
            if (string.equals("ctm_compact")) {
                return 10;
            }
            if (!string.equals("horizontal") && !string.equals("bookshelf")) {
                if (string.equals("vertical")) {
                    return 6;
                }
                if (string.equals("top")) {
                    return 3;
                }
                if (string.equals("random")) {
                    return 4;
                }
                if (string.equals("repeat")) {
                    return 5;
                }
                if (string.equals("fixed")) {
                    return 7;
                }
                if (!string.equals("horizontal+vertical") && !string.equals("h+v")) {
                    if (!string.equals("vertical+horizontal") && !string.equals("v+h")) {
                        if (string.equals("overlay")) {
                            return 11;
                        }
                        if (string.equals("overlay_fixed")) {
                            return 12;
                        }
                        if (string.equals("overlay_random")) {
                            return 13;
                        }
                        if (string.equals("overlay_repeat")) {
                            return 14;
                        }
                        if (string.equals("overlay_ctm")) {
                            return 15;
                        }
                        Config.warn("Unknown method: " + string);
                        return 0;
                    }
                    return 9;
                }
                return 8;
            }
            return 2;
        }
        return 1;
    }

    public boolean isValid(String string) {
        if (this.name != null && this.name.length() > 0) {
            if (this.basePath == null) {
                Config.warn("No base path found: " + string);
                return false;
            }
            if (this.matchBlocks == null) {
                this.matchBlocks = this.detectMatchBlocks();
            }
            if (this.matchTiles == null && this.matchBlocks == null) {
                this.matchTiles = this.detectMatchTiles();
            }
            if (this.matchBlocks == null && this.matchTiles == null) {
                Config.warn("No matchBlocks or matchTiles specified: " + string);
                return false;
            }
            if (this.method == 0) {
                Config.warn("No method: " + string);
                return false;
            }
            if (this.tiles != null && this.tiles.length > 0) {
                if (this.connect == 0) {
                    this.connect = this.detectConnect();
                }
                if (this.connect == 128) {
                    Config.warn("Invalid connect in: " + string);
                    return false;
                }
                if (this.renderPass > 0) {
                    Config.warn("Render pass not supported: " + this.renderPass);
                    return false;
                }
                if ((this.faces & 0x80) != 0) {
                    Config.warn("Invalid faces in: " + string);
                    return false;
                }
                if ((this.symmetry & 0x80) != 0) {
                    Config.warn("Invalid symmetry in: " + string);
                    return false;
                }
                switch (this.method) {
                    case 1: {
                        return this.isValidCtm(string);
                    }
                    case 2: {
                        return this.isValidHorizontal(string);
                    }
                    case 3: {
                        return this.isValidTop(string);
                    }
                    case 4: {
                        return this.isValidRandom(string);
                    }
                    case 5: {
                        return this.isValidRepeat(string);
                    }
                    case 6: {
                        return this.isValidVertical(string);
                    }
                    case 7: {
                        return this.isValidFixed(string);
                    }
                    case 8: {
                        return this.isValidHorizontalVertical(string);
                    }
                    case 9: {
                        return this.isValidVerticalHorizontal(string);
                    }
                    case 10: {
                        return this.isValidCtmCompact(string);
                    }
                    case 11: {
                        return this.isValidOverlay(string);
                    }
                    case 12: {
                        return this.isValidOverlayFixed(string);
                    }
                    case 13: {
                        return this.isValidOverlayRandom(string);
                    }
                    case 14: {
                        return this.isValidOverlayRepeat(string);
                    }
                    case 15: {
                        return this.isValidOverlayCtm(string);
                    }
                }
                Config.warn("Unknown method: " + string);
                return false;
            }
            Config.warn("No tiles specified: " + string);
            return false;
        }
        Config.warn("No name found: " + string);
        return false;
    }

    private int detectConnect() {
        return this.matchBlocks != null ? 1 : (this.matchTiles != null ? 2 : 128);
    }

    private MatchBlock[] detectMatchBlocks() {
        int[] nArray = this.detectMatchBlockIds();
        if (nArray == null) {
            return null;
        }
        MatchBlock[] matchBlockArray = new MatchBlock[nArray.length];
        for (int i = 0; i < matchBlockArray.length; ++i) {
            matchBlockArray[i] = new MatchBlock(nArray[i]);
        }
        return matchBlockArray;
    }

    private int[] detectMatchBlockIds() {
        int[] nArray;
        int n;
        char c;
        int n2;
        if (!this.name.startsWith("block")) {
            return null;
        }
        for (n2 = n = "block".length(); n2 < this.name.length() && (c = this.name.charAt(n2)) >= '0' && c <= '9'; ++n2) {
        }
        if (n2 == n) {
            return null;
        }
        String string = this.name.substring(n, n2);
        int n3 = Config.parseInt(string, -1);
        if (n3 < 0) {
            nArray = null;
        } else {
            int[] nArray2 = new int[1];
            nArray = nArray2;
            nArray2[0] = n3;
        }
        return nArray;
    }

    private String[] detectMatchTiles() {
        String[] stringArray;
        TextureAtlasSprite textureAtlasSprite = ConnectedProperties.getIcon(this.name);
        if (textureAtlasSprite == null) {
            stringArray = null;
        } else {
            String[] stringArray2 = new String[1];
            stringArray = stringArray2;
            stringArray2[0] = this.name;
        }
        return stringArray;
    }

    private static TextureAtlasSprite getIcon(String string) {
        TextureMap textureMap = Minecraft.getMinecraft().getTextureMapBlocks();
        TextureAtlasSprite textureAtlasSprite = textureMap.getSpriteSafe(string);
        if (textureAtlasSprite != null) {
            return textureAtlasSprite;
        }
        textureAtlasSprite = textureMap.getSpriteSafe("blocks/" + string);
        return textureAtlasSprite;
    }

    private boolean isValidCtm(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-11 16-27 32-43 48-58");
        }
        if (this.tiles.length < 47) {
            Config.warn("Invalid tiles, must be at least 47: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidCtmCompact(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-4");
        }
        if (this.tiles.length < 5) {
            Config.warn("Invalid tiles, must be at least 5: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidOverlay(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-16");
        }
        if (this.tiles.length < 17) {
            Config.warn("Invalid tiles, must be at least 17: " + string);
            return false;
        }
        if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
            return true;
        }
        Config.warn("Invalid overlay layer: " + String.valueOf((Object)this.layer));
        return false;
    }

    private boolean isValidOverlayFixed(String string) {
        if (!this.isValidFixed(string)) {
            return false;
        }
        if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
            return true;
        }
        Config.warn("Invalid overlay layer: " + String.valueOf((Object)this.layer));
        return false;
    }

    private boolean isValidOverlayRandom(String string) {
        if (!this.isValidRandom(string)) {
            return false;
        }
        if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
            return true;
        }
        Config.warn("Invalid overlay layer: " + String.valueOf((Object)this.layer));
        return false;
    }

    private boolean isValidOverlayRepeat(String string) {
        if (!this.isValidRepeat(string)) {
            return false;
        }
        if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
            return true;
        }
        Config.warn("Invalid overlay layer: " + String.valueOf((Object)this.layer));
        return false;
    }

    private boolean isValidOverlayCtm(String string) {
        if (!this.isValidCtm(string)) {
            return false;
        }
        if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
            return true;
        }
        Config.warn("Invalid overlay layer: " + String.valueOf((Object)this.layer));
        return false;
    }

    private boolean isValidHorizontal(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("12-15");
        }
        if (this.tiles.length != 4) {
            Config.warn("Invalid tiles, must be exactly 4: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidVertical(String string) {
        if (this.tiles == null) {
            Config.warn("No tiles defined for vertical: " + string);
            return false;
        }
        if (this.tiles.length != 4) {
            Config.warn("Invalid tiles, must be exactly 4: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidHorizontalVertical(String string) {
        if (this.tiles == null) {
            Config.warn("No tiles defined for horizontal+vertical: " + string);
            return false;
        }
        if (this.tiles.length != 7) {
            Config.warn("Invalid tiles, must be exactly 7: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidVerticalHorizontal(String string) {
        if (this.tiles == null) {
            Config.warn("No tiles defined for vertical+horizontal: " + string);
            return false;
        }
        if (this.tiles.length != 7) {
            Config.warn("Invalid tiles, must be exactly 7: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidRandom(String string) {
        if (this.tiles != null && this.tiles.length > 0) {
            if (this.weights != null) {
                int n;
                int[] nArray;
                if (this.weights.length > this.tiles.length) {
                    Config.warn("More weights defined than tiles, trimming weights: " + string);
                    nArray = new int[this.tiles.length];
                    System.arraycopy(this.weights, 0, nArray, 0, nArray.length);
                    this.weights = nArray;
                }
                if (this.weights.length < this.tiles.length) {
                    Config.warn("Less weights defined than tiles, expanding weights: " + string);
                    nArray = new int[this.tiles.length];
                    System.arraycopy(this.weights, 0, nArray, 0, this.weights.length);
                    n = MathUtils.getAverage(this.weights);
                    for (int i = this.weights.length; i < nArray.length; ++i) {
                        nArray[i] = n;
                    }
                    this.weights = nArray;
                }
                this.sumWeights = new int[this.weights.length];
                int n2 = 0;
                for (n = 0; n < this.weights.length; ++n) {
                    this.sumWeights[n] = n2 += this.weights[n];
                }
                this.sumAllWeights = n2;
                if (this.sumAllWeights <= 0) {
                    Config.warn("Invalid sum of all weights: " + n2);
                    this.sumAllWeights = 1;
                }
            }
            if (this.randomLoops >= 0 && this.randomLoops <= 9) {
                return true;
            }
            Config.warn("Invalid randomLoops: " + this.randomLoops);
            return false;
        }
        Config.warn("Tiles not defined: " + string);
        return false;
    }

    private boolean isValidRepeat(String string) {
        if (this.tiles == null) {
            Config.warn("Tiles not defined: " + string);
            return false;
        }
        if (this.width <= 0) {
            Config.warn("Invalid width: " + string);
            return false;
        }
        if (this.height <= 0) {
            Config.warn("Invalid height: " + string);
            return false;
        }
        if (this.tiles.length != this.width * this.height) {
            Config.warn("Number of tiles does not equal width x height: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidFixed(String string) {
        if (this.tiles == null) {
            Config.warn("Tiles not defined: " + string);
            return false;
        }
        if (this.tiles.length != 1) {
            Config.warn("Number of tiles should be 1 for method: fixed.");
            return false;
        }
        return true;
    }

    private boolean isValidTop(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("66");
        }
        if (this.tiles.length != 1) {
            Config.warn("Invalid tiles, must be exactly 1: " + string);
            return false;
        }
        return true;
    }

    public void updateIcons(TextureMap textureMap) {
        if (this.matchTiles != null) {
            this.matchTileIcons = ConnectedProperties.registerIcons(this.matchTiles, textureMap, false, false);
        }
        if (this.connectTiles != null) {
            this.connectTileIcons = ConnectedProperties.registerIcons(this.connectTiles, textureMap, false, false);
        }
        if (this.tiles != null) {
            this.tileIcons = ConnectedProperties.registerIcons(this.tiles, textureMap, true, !ConnectedProperties.isMethodOverlay(this.method));
        }
    }

    private static boolean isMethodOverlay(int n) {
        switch (n) {
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return true;
            }
        }
        return false;
    }

    private static TextureAtlasSprite[] registerIcons(String[] stringArray, TextureMap textureMap, boolean bl, boolean bl2) {
        if (stringArray == null) {
            return null;
        }
        ArrayList<TextureAtlasSprite> arrayList = new ArrayList<TextureAtlasSprite>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            ResourceLocation resourceLocation = new ResourceLocation(string);
            String string2 = resourceLocation.getResourceDomain();
            Object object = resourceLocation.getResourcePath();
            if (!((String)object).contains("/")) {
                object = "textures/blocks/" + (String)object;
            }
            String string3 = (String)object + ".png";
            if (bl && string3.endsWith(TILE_SKIP_PNG)) {
                arrayList.add(null);
                continue;
            }
            if (bl2 && string3.endsWith(TILE_DEFAULT_PNG)) {
                arrayList.add(ConnectedTextures.SPRITE_DEFAULT);
                continue;
            }
            ResourceLocation resourceLocation2 = new ResourceLocation(string2, string3);
            boolean bl3 = Config.hasResource(resourceLocation2);
            if (!bl3) {
                Config.warn("File not found: " + string3);
            }
            String string4 = "textures/";
            Object object2 = object;
            if (((String)object).startsWith(string4)) {
                object2 = ((String)object).substring(string4.length());
            }
            ResourceLocation resourceLocation3 = new ResourceLocation(string2, (String)object2);
            TextureAtlasSprite textureAtlasSprite = textureMap.registerSprite(resourceLocation3);
            arrayList.add(textureAtlasSprite);
        }
        TextureAtlasSprite[] textureAtlasSpriteArray = arrayList.toArray(new TextureAtlasSprite[arrayList.size()]);
        return textureAtlasSpriteArray;
    }

    public boolean matchesBlockId(int n) {
        return Matches.blockId(n, this.matchBlocks);
    }

    public boolean matchesBlock(int n, int n2) {
        return !Matches.block(n, n2, this.matchBlocks) ? false : Matches.metadata(n2, this.metadatas);
    }

    public boolean matchesIcon(TextureAtlasSprite textureAtlasSprite) {
        return Matches.sprite(textureAtlasSprite, this.matchTileIcons);
    }

    public String toString() {
        return "CTM name: " + this.name + ", basePath: " + this.basePath + ", matchBlocks: " + Config.arrayToString(this.matchBlocks) + ", matchTiles: " + Config.arrayToString(this.matchTiles);
    }

    public boolean matchesBiome(BiomeGenBase biomeGenBase) {
        return Matches.biome(biomeGenBase, this.biomes);
    }

    public int getMetadataMax() {
        int n = -1;
        n = this.getMax(this.metadatas, n);
        if (this.matchBlocks != null) {
            for (int i = 0; i < this.matchBlocks.length; ++i) {
                MatchBlock matchBlock = this.matchBlocks[i];
                n = this.getMax(matchBlock.getMetadatas(), n);
            }
        }
        return n;
    }

    private int getMax(int[] nArray, int n) {
        if (nArray == null) {
            return n;
        }
        for (int i = 0; i < nArray.length; ++i) {
            int n2 = nArray[i];
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }
}

