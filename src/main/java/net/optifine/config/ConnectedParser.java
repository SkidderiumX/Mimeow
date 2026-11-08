/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.src.Config;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.ConnectedProperties;
import net.optifine.config.INameGetter;
import net.optifine.config.MatchBlock;
import net.optifine.config.NbtTagValue;
import net.optifine.config.RangeInt;
import net.optifine.config.RangeListInt;
import net.optifine.config.VillagerProfession;
import net.optifine.config.Weather;
import net.optifine.util.EntityUtils;

public class ConnectedParser {
    private String context = null;
    public static final VillagerProfession[] PROFESSIONS_INVALID = new VillagerProfession[0];
    public static final EnumDyeColor[] DYE_COLORS_INVALID = new EnumDyeColor[0];
    private static final INameGetter<Enum> NAME_GETTER_ENUM = new INameGetter<Enum>(){

        @Override
        public String getName(Enum enum_) {
            return enum_.name();
        }
    };
    private static final INameGetter<EnumDyeColor> NAME_GETTER_DYE_COLOR = new INameGetter<EnumDyeColor>(){

        @Override
        public String getName(EnumDyeColor enumDyeColor) {
            return enumDyeColor.getName();
        }
    };

    public ConnectedParser(String string) {
        this.context = string;
    }

    public String parseName(String string) {
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

    public String parseBasePath(String string) {
        int n = string.lastIndexOf(47);
        return n < 0 ? "" : string.substring(0, n);
    }

    public MatchBlock[] parseMatchBlocks(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<MatchBlock> arrayList = new ArrayList<MatchBlock>();
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            MatchBlock[] matchBlockArray = this.parseMatchBlock(string2);
            if (matchBlockArray == null) continue;
            arrayList.addAll(Arrays.asList(matchBlockArray));
        }
        MatchBlock[] matchBlockArray = arrayList.toArray(new MatchBlock[arrayList.size()]);
        return matchBlockArray;
    }

    public IBlockState parseBlockState(String string, IBlockState iBlockState) {
        MatchBlock[] matchBlockArray = this.parseMatchBlock(string);
        if (matchBlockArray == null) {
            return iBlockState;
        }
        if (matchBlockArray.length != 1) {
            return iBlockState;
        }
        MatchBlock matchBlock = matchBlockArray[0];
        int n = matchBlock.getBlockId();
        Block block = Block.getBlockById(n);
        return block.getDefaultState();
    }

    public MatchBlock[] parseMatchBlock(String string) {
        if (string == null) {
            return null;
        }
        if ((string = string.trim()).length() <= 0) {
            return null;
        }
        String[] stringArray = Config.tokenize(string, ":");
        String string2 = "minecraft";
        int n = 0;
        if (stringArray.length > 1 && this.isFullBlockName(stringArray)) {
            string2 = stringArray[0];
            n = 1;
        } else {
            string2 = "minecraft";
            n = 0;
        }
        String string3 = stringArray[n];
        String[] stringArray2 = Arrays.copyOfRange(stringArray, n + 1, stringArray.length);
        Block[] blockArray = this.parseBlockPart(string2, string3);
        if (blockArray == null) {
            return null;
        }
        MatchBlock[] matchBlockArray = new MatchBlock[blockArray.length];
        for (int i = 0; i < blockArray.length; ++i) {
            MatchBlock matchBlock;
            Block block = blockArray[i];
            int n2 = Block.getIdFromBlock(block);
            int[] nArray = null;
            if (stringArray2.length > 0 && (nArray = this.parseBlockMetadatas(block, stringArray2)) == null) {
                return null;
            }
            matchBlockArray[i] = matchBlock = new MatchBlock(n2, nArray);
        }
        return matchBlockArray;
    }

    public boolean isFullBlockName(String[] stringArray) {
        if (stringArray.length < 2) {
            return false;
        }
        String string = stringArray[1];
        return string.length() < 1 ? false : (this.startsWithDigit(string) ? false : !string.contains("="));
    }

    public boolean startsWithDigit(String string) {
        if (string == null) {
            return false;
        }
        if (string.length() < 1) {
            return false;
        }
        char c = string.charAt(0);
        return Character.isDigit(c);
    }

    public Block[] parseBlockPart(String string, String string2) {
        if (this.startsWithDigit(string2)) {
            int[] nArray = this.parseIntList(string2);
            if (nArray == null) {
                return null;
            }
            Block[] blockArray = new Block[nArray.length];
            for (int i = 0; i < nArray.length; ++i) {
                int n = nArray[i];
                Block block = Block.getBlockById(n);
                if (block == null) {
                    this.warn("Block not found for id: " + n);
                    return null;
                }
                blockArray[i] = block;
            }
            return blockArray;
        }
        String string3 = string + ":" + string2;
        Block block = Block.getBlockFromName(string3);
        if (block == null) {
            this.warn("Block not found for name: " + string3);
            return null;
        }
        Block[] blockArray = new Block[]{block};
        return blockArray;
    }

    public int[] parseBlockMetadatas(Block block, String[] stringArray) {
        Object object;
        if (stringArray.length <= 0) {
            return null;
        }
        String string = stringArray[0];
        if (this.startsWithDigit(string)) {
            int[] nArray = this.parseIntList(string);
            return nArray;
        }
        IBlockState iBlockState = block.getDefaultState();
        Collection<IProperty> collection = iBlockState.getPropertyNames();
        HashMap<IProperty, List<Comparable>> hashMap = new HashMap<IProperty, List<Comparable>>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.length() <= 0) continue;
            String[] stringArray2 = Config.tokenize(string2, "=");
            if (stringArray2.length != 2) {
                this.warn("Invalid block property: " + string2);
                return null;
            }
            object = stringArray2[0];
            String string3 = stringArray2[1];
            IProperty iProperty = ConnectedProperties.getProperty((String)object, collection);
            if (iProperty == null) {
                this.warn("Property not found: " + (String)object + ", block: " + String.valueOf(block));
                return null;
            }
            ArrayList<Comparable> arrayList = (ArrayList<Comparable>)hashMap.get(object);
            if (arrayList == null) {
                arrayList = new ArrayList<Comparable>();
                hashMap.put(iProperty, arrayList);
            }
            String[] stringArray3 = Config.tokenize(string3, ",");
            for (int j = 0; j < stringArray3.length; ++j) {
                String string4 = stringArray3[j];
                Comparable comparable = ConnectedParser.parsePropertyValue(iProperty, string4);
                if (comparable == null) {
                    this.warn("Property value not found: " + string4 + ", property: " + (String)object + ", block: " + String.valueOf(block));
                    return null;
                }
                arrayList.add(comparable);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 16; ++i) {
            int n = i;
            try {
                object = this.getStateFromMeta(block, n);
                if (!this.matchState((IBlockState)object, hashMap)) continue;
                arrayList.add(n);
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
        }
        if (arrayList.size() == 16) {
            return null;
        }
        int[] nArray = new int[arrayList.size()];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = (Integer)arrayList.get(i);
        }
        return nArray;
    }

    private IBlockState getStateFromMeta(Block block, int n) {
        try {
            IBlockState iBlockState = block.getStateFromMeta(n);
            if (block == Blocks.double_plant && n > 7) {
                IBlockState iBlockState2 = block.getStateFromMeta(n & 7);
                iBlockState = iBlockState.withProperty(BlockDoublePlant.VARIANT, iBlockState2.getValue(BlockDoublePlant.VARIANT));
            }
            return iBlockState;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return block.getDefaultState();
        }
    }

    public static Comparable parsePropertyValue(IProperty iProperty, String string) {
        Class clazz = iProperty.getValueClass();
        Comparable comparable = ConnectedParser.parseValue(string, clazz);
        if (comparable == null) {
            Collection collection = iProperty.getAllowedValues();
            comparable = ConnectedParser.getPropertyValue(string, collection);
        }
        return comparable;
    }

    public static Comparable getPropertyValue(String string, Collection collection) {
        for (Object e : collection) {
            Comparable comparable = (Comparable)e;
            if (!ConnectedParser.getValueName(comparable).equals(string)) continue;
            return comparable;
        }
        return null;
    }

    private static Object getValueName(Comparable comparable) {
        IStringSerializable iStringSerializable = null;
        int n = -1723286021;
        block5: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case -1723286021: {
                    if (comparable instanceof IStringSerializable) {
                        n = 215608433;
                        continue block5;
                    }
                    n = 738091609;
                    continue block5;
                }
                case 738091609: {
                    return comparable.toString();
                }
                case 215608433: 
            }
            break;
        }
        iStringSerializable = (IStringSerializable)((Object)comparable);
        return iStringSerializable.getName();
    }

    public static Comparable parseValue(String string, Class<?> clazz) {
        if (clazz == String.class) {
            return string;
        }
        if (clazz == Boolean.class) {
            return Boolean.valueOf(string);
        }
        if (clazz == Float.class) {
            return Float.valueOf(string);
        }
        if (clazz == Double.class) {
            return Double.valueOf(string);
        }
        if (clazz == Integer.class) {
            return Integer.valueOf(string);
        }
        if (clazz == Long.class) {
            return Long.valueOf(string);
        }
        return null;
    }

    public boolean matchState(IBlockState iBlockState, Map<IProperty, List<Comparable>> map) {
        for (IProperty iProperty : map.keySet()) {
            List<Comparable> list = map.get(iProperty);
            Object t = iBlockState.getValue(iProperty);
            if (t == null) {
                return false;
            }
            if (list.contains(t)) continue;
            return false;
        }
        return true;
    }

    public BiomeGenBase[] parseBiomes(String string) {
        if (string == null) {
            return null;
        }
        string = string.trim();
        boolean bl = false;
        if (string.startsWith("!")) {
            bl = true;
            string = string.substring(1);
        }
        String[] stringArray = Config.tokenize(string, " ");
        ArrayList<BiomeGenBase> arrayList = new ArrayList<BiomeGenBase>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            BiomeGenBase biomeGenBase = this.findBiome(string2);
            if (biomeGenBase == null) {
                this.warn("Biome not found: " + string2);
                continue;
            }
            arrayList.add(biomeGenBase);
        }
        if (bl) {
            ArrayList<BiomeGenBase> arrayList2 = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeGenBase.getBiomeGenArray()));
            arrayList2.removeAll(arrayList);
            arrayList = arrayList2;
        }
        BiomeGenBase[] biomeGenBaseArray = arrayList.toArray(new BiomeGenBase[arrayList.size()]);
        return biomeGenBaseArray;
    }

    public BiomeGenBase findBiome(String string) {
        if ((string = string.toLowerCase()).equals("nether")) {
            return BiomeGenBase.hell;
        }
        BiomeGenBase[] biomeGenBaseArray = BiomeGenBase.getBiomeGenArray();
        for (int i = 0; i < biomeGenBaseArray.length; ++i) {
            String string2;
            BiomeGenBase biomeGenBase = biomeGenBaseArray[i];
            if (biomeGenBase == null || !(string2 = biomeGenBase.biomeName.replace(" ", "").toLowerCase()).equals(string)) continue;
            return biomeGenBase;
        }
        return null;
    }

    public int parseInt(String string, int n) {
        if (string == null) {
            return n;
        }
        int n2 = Config.parseInt(string = string.trim(), -1);
        if (n2 < 0) {
            this.warn("Invalid number: " + string);
            return n;
        }
        return n2;
    }

    public int[] parseIntList(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        String[] stringArray = Config.tokenize(string, " ,");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.contains("-")) {
                String[] stringArray2 = Config.tokenize(string2, "-");
                if (stringArray2.length != 2) {
                    this.warn("Invalid interval: " + string2 + ", when parsing: " + string);
                    continue;
                }
                int n = Config.parseInt(stringArray2[0], -1);
                int n2 = Config.parseInt(stringArray2[1], -1);
                if (n >= 0 && n2 >= 0 && n <= n2) {
                    for (int j = n; j <= n2; ++j) {
                        arrayList.add(j);
                    }
                    continue;
                }
                this.warn("Invalid interval: " + string2 + ", when parsing: " + string);
                continue;
            }
            int n = Config.parseInt(string2, -1);
            if (n < 0) {
                this.warn("Invalid number: " + string2 + ", when parsing: " + string);
                continue;
            }
            arrayList.add(n);
        }
        int[] nArray = new int[arrayList.size()];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = (Integer)arrayList.get(i);
        }
        return nArray;
    }

    public boolean[] parseFaces(String string, boolean[] blArray) {
        if (string == null) {
            return blArray;
        }
        EnumSet<EnumFacing> enumSet = EnumSet.allOf(EnumFacing.class);
        String[] stringArray = Config.tokenize(string, " ,");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.equals("sides")) {
                enumSet.add(EnumFacing.NORTH);
                enumSet.add(EnumFacing.SOUTH);
                enumSet.add(EnumFacing.WEST);
                enumSet.add(EnumFacing.EAST);
                continue;
            }
            if (string2.equals("all")) {
                enumSet.addAll(Arrays.asList(EnumFacing.VALUES));
                continue;
            }
            EnumFacing enumFacing = this.parseFace(string2);
            if (enumFacing == null) continue;
            enumSet.add(enumFacing);
        }
        boolean[] blArray2 = new boolean[EnumFacing.VALUES.length];
        for (int i = 0; i < blArray2.length; ++i) {
            blArray2[i] = enumSet.contains(EnumFacing.VALUES[i]);
        }
        return blArray2;
    }

    public EnumFacing parseFace(String string) {
        if (!(string = string.toLowerCase()).equals("bottom") && !string.equals("down")) {
            if (!string.equals("top") && !string.equals("up")) {
                if (string.equals("north")) {
                    return EnumFacing.NORTH;
                }
                if (string.equals("south")) {
                    return EnumFacing.SOUTH;
                }
                if (string.equals("east")) {
                    return EnumFacing.EAST;
                }
                if (string.equals("west")) {
                    return EnumFacing.WEST;
                }
                Config.warn("Unknown face: " + string);
                return null;
            }
            return EnumFacing.UP;
        }
        return EnumFacing.DOWN;
    }

    public void dbg(String string) {
        Config.dbg(this.context + ": " + string);
    }

    public void warn(String string) {
        Config.warn(this.context + ": " + string);
    }

    public RangeListInt parseRangeListInt(String string) {
        if (string == null) {
            return null;
        }
        RangeListInt rangeListInt = new RangeListInt();
        String[] stringArray = Config.tokenize(string, " ,");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            RangeInt rangeInt = this.parseRangeInt(string2);
            if (rangeInt == null) {
                return null;
            }
            rangeListInt.addRange(rangeInt);
        }
        return rangeListInt;
    }

    private RangeInt parseRangeInt(String string) {
        if (string == null) {
            return null;
        }
        if (string.indexOf(45) >= 0) {
            String[] stringArray = Config.tokenize(string, "-");
            if (stringArray.length != 2) {
                this.warn("Invalid range: " + string);
                return null;
            }
            int n = Config.parseInt(stringArray[0], -1);
            int n2 = Config.parseInt(stringArray[1], -1);
            if (n >= 0 && n2 >= 0) {
                return new RangeInt(n, n2);
            }
            this.warn("Invalid range: " + string);
            return null;
        }
        int n = Config.parseInt(string, -1);
        if (n < 0) {
            this.warn("Invalid integer: " + string);
            return null;
        }
        return new RangeInt(n, n);
    }

    public boolean parseBoolean(String string, boolean bl) {
        if (string == null) {
            return bl;
        }
        String string2 = string.toLowerCase().trim();
        if (string2.equals("true")) {
            return true;
        }
        if (string2.equals("false")) {
            return false;
        }
        this.warn("Invalid boolean: " + string);
        return bl;
    }

    public Boolean parseBooleanObject(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.toLowerCase().trim();
        if (string2.equals("true")) {
            return Boolean.TRUE;
        }
        if (string2.equals("false")) {
            return Boolean.FALSE;
        }
        this.warn("Invalid boolean: " + string);
        return null;
    }

    public static int parseColor(String string, int n) {
        if (string == null) {
            return n;
        }
        string = string.trim();
        try {
            int n2 = Integer.parseInt(string, 16) & 0xFFFFFF;
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public static int parseColor4(String string, int n) {
        if (string == null) {
            return n;
        }
        string = string.trim();
        try {
            int n2 = (int)(Long.parseLong(string, 16) & 0xFFFFFFFFFFFFFFFFL);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public EnumWorldBlockLayer parseBlockRenderLayer(String string, EnumWorldBlockLayer enumWorldBlockLayer) {
        if (string == null) {
            return enumWorldBlockLayer;
        }
        string = string.toLowerCase().trim();
        EnumWorldBlockLayer[] enumWorldBlockLayerArray = EnumWorldBlockLayer.values();
        for (int i = 0; i < enumWorldBlockLayerArray.length; ++i) {
            EnumWorldBlockLayer enumWorldBlockLayer2 = enumWorldBlockLayerArray[i];
            if (!string.equals(enumWorldBlockLayer2.name().toLowerCase())) continue;
            return enumWorldBlockLayer2;
        }
        return enumWorldBlockLayer;
    }

    public <T> T parseObject(String string, T[] TArray, INameGetter iNameGetter, String string2) {
        if (string == null) {
            return null;
        }
        String string3 = string.toLowerCase().trim();
        for (int i = 0; i < TArray.length; ++i) {
            T t = TArray[i];
            String string4 = iNameGetter.getName(t);
            if (string4 == null || !string4.toLowerCase().equals(string3)) continue;
            return t;
        }
        this.warn("Invalid " + string2 + ": " + string);
        return null;
    }

    public <T> T[] parseObjects(String string, T[] TArray, INameGetter iNameGetter, String string2, T[] TArray2) {
        if (string == null) {
            return null;
        }
        string = string.toLowerCase().trim();
        String[] stringArray = Config.tokenize(string, " ");
        Object[] objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), stringArray.length);
        for (int i = 0; i < stringArray.length; ++i) {
            String string3 = stringArray[i];
            T t = this.parseObject(string3, TArray, iNameGetter, string2);
            if (t == null) {
                return TArray2;
            }
            objectArray[i] = t;
        }
        return objectArray;
    }

    public Enum parseEnum(String string, Enum[] enumArray, String string2) {
        return this.parseObject(string, enumArray, NAME_GETTER_ENUM, string2);
    }

    public Enum[] parseEnums(String string, Enum[] enumArray, String string2, Enum[] enumArray2) {
        return this.parseObjects(string, enumArray, NAME_GETTER_ENUM, string2, enumArray2);
    }

    public EnumDyeColor[] parseDyeColors(String string, String string2, EnumDyeColor[] enumDyeColorArray) {
        return this.parseObjects(string, EnumDyeColor.values(), NAME_GETTER_DYE_COLOR, string2, enumDyeColorArray);
    }

    public Weather[] parseWeather(String string, String string2, Weather[] weatherArray) {
        return this.parseObjects(string, Weather.values(), NAME_GETTER_ENUM, string2, weatherArray);
    }

    public NbtTagValue parseNbtTagValue(String string, String string2) {
        return string != null && string2 != null ? new NbtTagValue(string, string2) : null;
    }

    public VillagerProfession[] parseProfessions(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<VillagerProfession> arrayList = new ArrayList<VillagerProfession>();
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            VillagerProfession villagerProfession = this.parseProfession(string2);
            if (villagerProfession == null) {
                this.warn("Invalid profession: " + string2);
                return PROFESSIONS_INVALID;
            }
            arrayList.add(villagerProfession);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        VillagerProfession[] villagerProfessionArray = arrayList.toArray(new VillagerProfession[arrayList.size()]);
        return villagerProfessionArray;
    }

    private VillagerProfession parseProfession(String string) {
        int n;
        String[] stringArray = Config.tokenize(string = string.toLowerCase(), ":");
        if (stringArray.length > 2) {
            return null;
        }
        String string2 = stringArray[0];
        String string3 = null;
        if (stringArray.length > 1) {
            string3 = stringArray[1];
        }
        if ((n = ConnectedParser.parseProfessionId(string2)) < 0) {
            return null;
        }
        int[] nArray = null;
        if (string3 != null && (nArray = ConnectedParser.parseCareerIds(n, string3)) == null) {
            return null;
        }
        return new VillagerProfession(n, nArray);
    }

    private static int parseProfessionId(String string) {
        int n = 0;
        int n2 = 1250644623;
        block17: while (true) {
            switch (n2) {
                default: {
                    throw null;
                }
                case 1250644623: {
                    n = Config.parseInt(string, -1);
                    if (n >= 0) {
                        n2 = -1352073898;
                        continue block17;
                    }
                    n2 = 1700566214;
                    continue block17;
                }
                case 1692369162: {
                    if (string.equals("priest")) {
                        n2 = -1424232391;
                        continue block17;
                    }
                    n2 = -1910549072;
                    continue block17;
                }
                case -1800750430: {
                    return 5;
                }
                case 954363098: {
                    return 1;
                }
                case 222556029: {
                    return 3;
                }
                case -2019239682: {
                    return 4;
                }
                case -1910549072: {
                    if (string.equals("blacksmith")) {
                        n2 = 222556029;
                        continue block17;
                    }
                    n2 = -1099139447;
                    continue block17;
                }
                case 363307146: {
                    return -1;
                }
                case -1352073898: {
                    return n;
                }
                case -628136458: {
                    return 0;
                }
                case -539730170: {
                    if (string.equals("nitwit")) {
                        n2 = -1800750430;
                        continue block17;
                    }
                    n2 = 363307146;
                    continue block17;
                }
                case -1099139447: {
                    if (string.equals("butcher")) {
                        n2 = -2019239682;
                        continue block17;
                    }
                    n2 = -539730170;
                    continue block17;
                }
                case -1901084999: {
                    if (string.equals("librarian")) {
                        n2 = 954363098;
                        continue block17;
                    }
                    n2 = 1692369162;
                    continue block17;
                }
                case 1700566214: {
                    if (string.equals("farmer")) {
                        n2 = -628136458;
                        continue block17;
                    }
                    n2 = -1901084999;
                    continue block17;
                }
                case -1424232391: 
            }
            break;
        }
        return 2;
    }

    private static int[] parseCareerIds(int n, String string) {
        int n2;
        Object object;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        String[] stringArray = Config.tokenize(string, ",");
        for (int i = 0; i < stringArray.length; ++i) {
            object = stringArray[i];
            n2 = ConnectedParser.parseCareerId(n, (String)object);
            if (n2 < 0) {
                return null;
            }
            hashSet.add(n2);
        }
        Integer[] integerArray = hashSet.toArray(new Integer[hashSet.size()]);
        object = new int[integerArray.length];
        for (n2 = 0; n2 < ((Object)object).length; ++n2) {
            object[n2] = integerArray[n2];
        }
        return object;
    }

    private static int parseCareerId(int n, String string) {
        int n2 = Config.parseInt(string, -1);
        if (n2 >= 0) {
            return n2;
        }
        if (n == 0) {
            if (string.equals("farmer")) {
                return 1;
            }
            if (string.equals("fisherman")) {
                return 2;
            }
            if (string.equals("shepherd")) {
                return 3;
            }
            if (string.equals("fletcher")) {
                return 4;
            }
        }
        if (n == 1) {
            if (string.equals("librarian")) {
                return 1;
            }
            if (string.equals("cartographer")) {
                return 2;
            }
        }
        if (n == 2 && string.equals("cleric")) {
            return 1;
        }
        if (n == 3) {
            if (string.equals("armor")) {
                return 1;
            }
            if (string.equals("weapon")) {
                return 2;
            }
            if (string.equals("tool")) {
                return 3;
            }
        }
        if (n == 4) {
            if (string.equals("butcher")) {
                return 1;
            }
            if (string.equals("leather")) {
                return 2;
            }
        }
        return n == 5 && string.equals("nitwit") ? 1 : -1;
    }

    public int[] parseItems(String string) {
        Object object;
        string = string.trim();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            object = stringArray[i];
            ResourceLocation resourceLocation = new ResourceLocation((String)object);
            Item item = Item.itemRegistry.getObject(resourceLocation);
            if (item == null) {
                this.warn("Item not found: " + (String)object);
                continue;
            }
            int n = Item.getIdFromItem(item);
            if (n < 0) {
                this.warn("Item has no ID: " + String.valueOf(item) + ", name: " + (String)object);
                continue;
            }
            treeSet.add(new Integer(n));
        }
        Integer[] integerArray = treeSet.toArray(new Integer[treeSet.size()]);
        object = Config.toPrimitive(integerArray);
        return object;
    }

    public int[] parseEntities(String string) {
        Object object;
        string = string.trim();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            object = stringArray[i];
            int n = EntityUtils.getEntityIdByName((String)object);
            if (n < 0) {
                this.warn("Entity not found: " + (String)object);
                continue;
            }
            treeSet.add(new Integer(n));
        }
        Integer[] integerArray = treeSet.toArray(new Integer[treeSet.size()]);
        object = Config.toPrimitive(integerArray);
        return object;
    }
}

