/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockPart;
import net.minecraft.client.renderer.block.model.BlockPartFace;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.ModelRotation;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.src.Config;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.optifine.config.IParserInt;
import net.optifine.config.NbtTagValue;
import net.optifine.config.ParserEnchantmentId;
import net.optifine.config.RangeInt;
import net.optifine.config.RangeListInt;
import net.optifine.reflect.Reflector;
import net.optifine.render.Blender;
import net.optifine.util.StrUtils;
import net.optifine.util.TextureUtils;
import org.lwjgl.opengl.GL11;

public class CustomItemProperties {
    public String name = null;
    public String basePath = null;
    public int type = 1;
    public int[] items = null;
    public String texture = null;
    public Map<String, String> mapTextures = null;
    public String model = null;
    public Map<String, String> mapModels = null;
    public RangeListInt damage = null;
    public boolean damagePercent = false;
    public int damageMask = 0;
    public RangeListInt stackSize = null;
    public RangeListInt enchantmentIds = null;
    public RangeListInt enchantmentLevels = null;
    public NbtTagValue[] nbtTagValues = null;
    public int hand = 0;
    public int blend = 1;
    public float speed = 0.0f;
    public float rotation = 0.0f;
    public int layer = 0;
    public float duration = 1.0f;
    public int weight = 0;
    public ResourceLocation textureLocation = null;
    public Map mapTextureLocations = null;
    public TextureAtlasSprite sprite = null;
    public Map mapSprites = null;
    public IBakedModel bakedModelTexture = null;
    public Map<String, IBakedModel> mapBakedModelsTexture = null;
    public IBakedModel bakedModelFull = null;
    public Map<String, IBakedModel> mapBakedModelsFull = null;
    private int textureWidth = 0;
    private int textureHeight = 0;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_ENCHANTMENT = 2;
    public static final int TYPE_ARMOR = 3;
    public static final int HAND_ANY = 0;
    public static final int HAND_MAIN = 1;
    public static final int HAND_OFF = 2;
    public static final String INVENTORY = "inventory";

    public CustomItemProperties(Properties properties, String string) {
        this.name = CustomItemProperties.parseName(string);
        this.basePath = CustomItemProperties.parseBasePath(string);
        this.type = this.parseType(properties.getProperty("type"));
        this.items = this.parseItems(properties.getProperty("items"), properties.getProperty("matchItems"));
        this.mapModels = CustomItemProperties.parseModels(properties, this.basePath);
        this.model = CustomItemProperties.parseModel(properties.getProperty("model"), string, this.basePath, this.type, this.mapModels);
        this.mapTextures = CustomItemProperties.parseTextures(properties, this.basePath);
        boolean bl = this.mapModels == null && this.model == null;
        this.texture = CustomItemProperties.parseTexture(properties.getProperty("texture"), properties.getProperty("tile"), properties.getProperty("source"), string, this.basePath, this.type, this.mapTextures, bl);
        String string2 = properties.getProperty("damage");
        if (string2 != null) {
            this.damagePercent = string2.contains("%");
            string2 = string2.replace("%", "");
            this.damage = this.parseRangeListInt(string2);
            this.damageMask = this.parseInt(properties.getProperty("damageMask"), 0);
        }
        this.stackSize = this.parseRangeListInt(properties.getProperty("stackSize"));
        this.enchantmentIds = this.parseRangeListInt(properties.getProperty("enchantmentIDs"), new ParserEnchantmentId());
        this.enchantmentLevels = this.parseRangeListInt(properties.getProperty("enchantmentLevels"));
        this.nbtTagValues = this.parseNbtTagValues(properties);
        this.hand = this.parseHand(properties.getProperty("hand"));
        this.blend = Blender.parseBlend(properties.getProperty("blend"));
        this.speed = this.parseFloat(properties.getProperty("speed"), 0.0f);
        this.rotation = this.parseFloat(properties.getProperty("rotation"), 0.0f);
        this.layer = this.parseInt(properties.getProperty("layer"), 0);
        this.weight = this.parseInt(properties.getProperty("weight"), 0);
        this.duration = this.parseFloat(properties.getProperty("duration"), 1.0f);
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

    private int parseType(String string) {
        if (string == null) {
            return 1;
        }
        if (string.equals("item")) {
            return 1;
        }
        if (string.equals("enchantment")) {
            return 2;
        }
        if (string.equals("armor")) {
            return 3;
        }
        Config.warn("Unknown method: " + string);
        return 0;
    }

    private int[] parseItems(String string, String string2) {
        int n;
        Object object;
        if (string == null) {
            string = string2;
        }
        if (string == null) {
            return null;
        }
        string = string.trim();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            int n2;
            String[] stringArray2;
            object = stringArray[i];
            n = Config.parseInt((String)object, -1);
            if (n >= 0) {
                treeSet.add(new Integer(n));
                continue;
            }
            if (((String)object).contains("-") && (stringArray2 = Config.tokenize((String)object, "-")).length == 2) {
                n2 = Config.parseInt(stringArray2[0], -1);
                int n3 = Config.parseInt(stringArray2[1], -1);
                if (n2 >= 0 && n3 >= 0) {
                    int n4 = Math.min(n2, n3);
                    int n5 = Math.max(n2, n3);
                    for (int j = n4; j <= n5; ++j) {
                        treeSet.add(new Integer(j));
                    }
                    continue;
                }
            }
            if ((stringArray2 = Item.getByNameOrId((String)object)) == null) {
                Config.warn("Item not found: " + (String)object);
                continue;
            }
            n2 = Item.getIdFromItem((Item)stringArray2);
            if (n2 <= 0) {
                Config.warn("Item not found: " + (String)object);
                continue;
            }
            treeSet.add(new Integer(n2));
        }
        Integer[] integerArray = treeSet.toArray(new Integer[treeSet.size()]);
        object = new int[integerArray.length];
        for (n = 0; n < ((Object)object).length; ++n) {
            object[n] = integerArray[n];
        }
        return object;
    }

    private static String parseTexture(String string, String string2, String string3, String string4, String string5, int n, Map<String, String> map, boolean bl) {
        int n2;
        String string6;
        if (string == null) {
            string = string2;
        }
        if (string == null) {
            string = string3;
        }
        if (string != null) {
            String string7 = ".png";
            if (string.endsWith(string7)) {
                string = string.substring(0, string.length() - string7.length());
            }
            string = CustomItemProperties.fixTextureName(string, string5);
            return string;
        }
        if (n == 3) {
            return null;
        }
        if (map != null && (string6 = map.get("texture.bow_standby")) != null) {
            return string6;
        }
        if (!bl) {
            return null;
        }
        string6 = string4;
        int n3 = string4.lastIndexOf(47);
        if (n3 >= 0) {
            string6 = string4.substring(n3 + 1);
        }
        if ((n2 = string6.lastIndexOf(46)) >= 0) {
            string6 = string6.substring(0, n2);
        }
        string6 = CustomItemProperties.fixTextureName(string6, string5);
        return string6;
    }

    private static Map parseTextures(Properties properties, String string) {
        String string2 = "texture.";
        Map map = CustomItemProperties.getMatchingProperties(properties, string2);
        if (map.size() <= 0) {
            return null;
        }
        Set set = map.keySet();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        for (Object k : set) {
            String string3 = (String)k;
            String string4 = (String)map.get(string3);
            string4 = CustomItemProperties.fixTextureName(string4, string);
            linkedHashMap.put(string3, string4);
        }
        return linkedHashMap;
    }

    private static String fixTextureName(String object, String string) {
        if (!(((String)(object = TextureUtils.fixResourcePath((String)object, string))).startsWith(string) || ((String)object).startsWith("textures/") || ((String)object).startsWith("mcpatcher/"))) {
            object = string + "/" + (String)object;
        }
        if (((String)object).endsWith(".png")) {
            object = ((String)object).substring(0, ((String)object).length() - 4);
        }
        if (((String)object).startsWith("/")) {
            object = ((String)object).substring(1);
        }
        return object;
    }

    private static String parseModel(String string, String string2, String string3, int n, Map<String, String> map) {
        String string4;
        if (string != null) {
            String string5 = ".json";
            if (string.endsWith(string5)) {
                string = string.substring(0, string.length() - string5.length());
            }
            string = CustomItemProperties.fixModelName(string, string3);
            return string;
        }
        if (n == 3) {
            return null;
        }
        if (map != null && (string4 = map.get("model.bow_standby")) != null) {
            return string4;
        }
        return string;
    }

    private static Map parseModels(Properties properties, String string) {
        String string2 = "model.";
        Map map = CustomItemProperties.getMatchingProperties(properties, string2);
        if (map.size() <= 0) {
            return null;
        }
        Set set = map.keySet();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        for (Object k : set) {
            String string3 = (String)k;
            String string4 = (String)map.get(string3);
            string4 = CustomItemProperties.fixModelName(string4, string);
            linkedHashMap.put(string3, string4);
        }
        return linkedHashMap;
    }

    private static String fixModelName(String object, String string) {
        String string2;
        boolean bl;
        boolean bl2 = bl = ((String)(object = TextureUtils.fixResourcePath((String)object, string))).startsWith("block/") || ((String)object).startsWith("item/");
        if (!(((String)object).startsWith(string) || bl || ((String)object).startsWith("mcpatcher/"))) {
            object = string + "/" + (String)object;
        }
        if (((String)object).endsWith(string2 = ".json")) {
            object = ((String)object).substring(0, ((String)object).length() - string2.length());
        }
        if (((String)object).startsWith("/")) {
            object = ((String)object).substring(1);
        }
        return object;
    }

    private int parseInt(String string, int n) {
        if (string == null) {
            return n;
        }
        int n2 = Config.parseInt(string = string.trim(), Integer.MIN_VALUE);
        if (n2 == Integer.MIN_VALUE) {
            Config.warn("Invalid integer: " + string);
            return n;
        }
        return n2;
    }

    private float parseFloat(String string, float f) {
        if (string == null) {
            return f;
        }
        float f2 = Config.parseFloat(string = string.trim(), Float.MIN_VALUE);
        if (f2 == Float.MIN_VALUE) {
            Config.warn("Invalid float: " + string);
            return f;
        }
        return f2;
    }

    private RangeListInt parseRangeListInt(String string) {
        return this.parseRangeListInt(string, null);
    }

    private RangeListInt parseRangeListInt(String string, IParserInt iParserInt) {
        if (string == null) {
            return null;
        }
        String[] stringArray = Config.tokenize(string, " ");
        RangeListInt rangeListInt = new RangeListInt();
        for (int i = 0; i < stringArray.length; ++i) {
            int n;
            String string2 = stringArray[i];
            if (iParserInt != null && (n = iParserInt.parse(string2, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
                rangeListInt.addRange(new RangeInt(n, n));
                continue;
            }
            RangeInt rangeInt = this.parseRangeInt(string2);
            if (rangeInt == null) {
                Config.warn("Invalid range list: " + string);
                return null;
            }
            rangeListInt.addRange(rangeInt);
        }
        return rangeListInt;
    }

    private RangeInt parseRangeInt(String string) {
        int n;
        if (string == null) {
            return null;
        }
        int n2 = (string = string.trim()).length() - string.replace("-", "").length();
        if (n2 > 1) {
            Config.warn("Invalid range: " + string);
            return null;
        }
        String[] stringArray = Config.tokenize(string, "- ");
        int[] nArray = new int[stringArray.length];
        for (n = 0; n < stringArray.length; ++n) {
            String string2 = stringArray[n];
            int n3 = Config.parseInt(string2, -1);
            if (n3 < 0) {
                Config.warn("Invalid range: " + string);
                return null;
            }
            nArray[n] = n3;
        }
        if (nArray.length == 1) {
            n = nArray[0];
            if (string.startsWith("-")) {
                return new RangeInt(0, n);
            }
            if (string.endsWith("-")) {
                return new RangeInt(n, 65535);
            }
            return new RangeInt(n, n);
        }
        if (nArray.length == 2) {
            n = Math.min(nArray[0], nArray[1]);
            int n4 = Math.max(nArray[0], nArray[1]);
            return new RangeInt(n, n4);
        }
        Config.warn("Invalid range: " + string);
        return null;
    }

    private NbtTagValue[] parseNbtTagValues(Properties properties) {
        String string = "nbt.";
        Map map = CustomItemProperties.getMatchingProperties(properties, string);
        if (map.size() <= 0) {
            return null;
        }
        ArrayList<NbtTagValue> arrayList = new ArrayList<NbtTagValue>();
        for (Object k : map.keySet()) {
            String string2 = (String)k;
            String string3 = (String)map.get(string2);
            String string4 = string2.substring(string.length());
            NbtTagValue nbtTagValue = new NbtTagValue(string4, string3);
            arrayList.add(nbtTagValue);
        }
        NbtTagValue[] nbtTagValueArray = arrayList.toArray(new NbtTagValue[arrayList.size()]);
        return nbtTagValueArray;
    }

    private static Map getMatchingProperties(Properties properties, String string) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        for (Object object : properties.keySet()) {
            String string2 = (String)object;
            String string3 = properties.getProperty(string2);
            if (!string2.startsWith(string)) continue;
            linkedHashMap.put(string2, string3);
        }
        return linkedHashMap;
    }

    private int parseHand(String string) {
        if (string == null) {
            return 0;
        }
        if ((string = string.toLowerCase()).equals("any")) {
            return 0;
        }
        if (string.equals("main")) {
            return 1;
        }
        if (string.equals("off")) {
            return 2;
        }
        Config.warn("Invalid hand: " + string);
        return 0;
    }

    public boolean isValid(String string) {
        if (this.name != null && this.name.length() > 0) {
            if (this.basePath == null) {
                Config.warn("No base path found: " + string);
                return false;
            }
            if (this.type == 0) {
                Config.warn("No type defined: " + string);
                return false;
            }
            if (this.type == 1 || this.type == 3) {
                if (this.items == null) {
                    this.items = this.detectItems();
                }
                if (this.items == null) {
                    Config.warn("No items defined: " + string);
                    return false;
                }
            }
            if (this.texture == null && this.mapTextures == null && this.model == null && this.mapModels == null) {
                Config.warn("No texture or model specified: " + string);
                return false;
            }
            if (this.type == 2 && this.enchantmentIds == null) {
                Config.warn("No enchantmentIDs specified: " + string);
                return false;
            }
            return true;
        }
        Config.warn("No name found: " + string);
        return false;
    }

    private int[] detectItems() {
        int[] nArray;
        Item item = Item.getByNameOrId(this.name);
        if (item == null) {
            return null;
        }
        int n = Item.getIdFromItem(item);
        if (n <= 0) {
            nArray = null;
        } else {
            int[] nArray2 = new int[1];
            nArray = nArray2;
            nArray2[0] = n;
        }
        return nArray;
    }

    public void updateIcons(TextureMap textureMap) {
        if (this.texture != null) {
            this.textureLocation = this.getTextureLocation(this.texture);
            if (this.type == 1) {
                ResourceLocation resourceLocation = this.getSpriteLocation(this.textureLocation);
                this.sprite = textureMap.registerSprite(resourceLocation);
            }
        }
        if (this.mapTextures != null) {
            this.mapTextureLocations = new HashMap();
            this.mapSprites = new HashMap();
            for (String string : this.mapTextures.keySet()) {
                String string2 = this.mapTextures.get(string);
                ResourceLocation resourceLocation = this.getTextureLocation(string2);
                this.mapTextureLocations.put(string, resourceLocation);
                if (this.type != 1) continue;
                ResourceLocation resourceLocation2 = this.getSpriteLocation(resourceLocation);
                TextureAtlasSprite textureAtlasSprite = textureMap.registerSprite(resourceLocation2);
                this.mapSprites.put(string, textureAtlasSprite);
            }
        }
    }

    private ResourceLocation getTextureLocation(String string) {
        String string2;
        ResourceLocation resourceLocation;
        boolean bl;
        if (string == null) {
            return null;
        }
        ResourceLocation resourceLocation2 = new ResourceLocation(string);
        String string3 = resourceLocation2.getResourceDomain();
        Object object = resourceLocation2.getResourcePath();
        if (!((String)object).contains("/")) {
            object = "textures/items/" + (String)object;
        }
        if (!(bl = Config.hasResource(resourceLocation = new ResourceLocation(string3, string2 = (String)object + ".png")))) {
            Config.warn("File not found: " + string2);
        }
        return resourceLocation;
    }

    private ResourceLocation getSpriteLocation(ResourceLocation resourceLocation) {
        String string = resourceLocation.getResourcePath();
        string = StrUtils.removePrefix(string, "textures/");
        string = StrUtils.removeSuffix(string, ".png");
        ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), string);
        return resourceLocation2;
    }

    public void updateModelTexture(TextureMap textureMap, ItemModelGenerator itemModelGenerator) {
        if (this.texture != null || this.mapTextures != null) {
            String[] stringArray = this.getModelTextures();
            boolean bl = this.isUseTint();
            this.bakedModelTexture = CustomItemProperties.makeBakedModel(textureMap, itemModelGenerator, stringArray, bl);
            if (this.type == 1 && this.mapTextures != null) {
                for (String string : this.mapTextures.keySet()) {
                    String string2 = this.mapTextures.get(string);
                    String string3 = StrUtils.removePrefix(string, "texture.");
                    if (!string3.startsWith("bow") && !string3.startsWith("fishing_rod") && !string3.startsWith("shield")) continue;
                    String[] stringArray2 = new String[]{string2};
                    IBakedModel iBakedModel = CustomItemProperties.makeBakedModel(textureMap, itemModelGenerator, stringArray2, bl);
                    if (this.mapBakedModelsTexture == null) {
                        this.mapBakedModelsTexture = new HashMap<String, IBakedModel>();
                    }
                    this.mapBakedModelsTexture.put(string3, iBakedModel);
                }
            }
        }
    }

    private boolean isUseTint() {
        return true;
    }

    private static IBakedModel makeBakedModel(TextureMap textureMap, ItemModelGenerator itemModelGenerator, String[] stringArray, boolean bl) {
        Object object;
        String[] stringArray2 = new String[stringArray.length];
        for (int i = 0; i < stringArray2.length; ++i) {
            object = stringArray[i];
            stringArray2[i] = StrUtils.removePrefix((String)object, "textures/");
        }
        ModelBlock modelBlock = CustomItemProperties.makeModelBlock(stringArray2);
        object = itemModelGenerator.makeItemModel(textureMap, modelBlock);
        IBakedModel iBakedModel = CustomItemProperties.bakeModel(textureMap, (ModelBlock)object, bl);
        return iBakedModel;
    }

    private String[] getModelTextures() {
        if (this.type == 1 && this.items.length == 1) {
            ItemArmor itemArmor;
            Item item = Item.getItemById(this.items[0]);
            if (item == Items.potionitem && this.damage != null && this.damage.getCountRanges() > 0) {
                RangeInt rangeInt = this.damage.getRange(0);
                int n = rangeInt.getMin();
                boolean bl = (n & 0x4000) != 0;
                String string = this.getMapTexture(this.mapTextures, "texture.potion_overlay", "items/potion_overlay");
                String string2 = null;
                string2 = bl ? this.getMapTexture(this.mapTextures, "texture.potion_bottle_splash", "items/potion_bottle_splash") : this.getMapTexture(this.mapTextures, "texture.potion_bottle_drinkable", "items/potion_bottle_drinkable");
                return new String[]{string, string2};
            }
            if (item instanceof ItemArmor && (itemArmor = (ItemArmor)item).getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER) {
                String string = "leather";
                String string3 = "helmet";
                if (itemArmor.armorType == 0) {
                    string3 = "helmet";
                }
                if (itemArmor.armorType == 1) {
                    string3 = "chestplate";
                }
                if (itemArmor.armorType == 2) {
                    string3 = "leggings";
                }
                if (itemArmor.armorType == 3) {
                    string3 = "boots";
                }
                String string4 = string + "_" + string3;
                String string5 = this.getMapTexture(this.mapTextures, "texture." + string4, "items/" + string4);
                String string6 = this.getMapTexture(this.mapTextures, "texture." + string4 + "_overlay", "items/" + string4 + "_overlay");
                return new String[]{string5, string6};
            }
        }
        return new String[]{this.texture};
    }

    private String getMapTexture(Map<String, String> map, String string, String string2) {
        if (map == null) {
            return string2;
        }
        String string3 = map.get(string);
        return string3 == null ? string2 : string3;
    }

    private static ModelBlock makeModelBlock(String[] stringArray) {
        Object object;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"parent\": \"builtin/generated\",\"textures\": {");
        for (int i = 0; i < stringArray.length; ++i) {
            object = stringArray[i];
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"layer" + i + "\": \"" + (String)object + "\"");
        }
        stringBuffer.append("}}");
        String string = stringBuffer.toString();
        object = ModelBlock.deserialize(string);
        return object;
    }

    private static IBakedModel bakeModel(TextureMap textureMap, ModelBlock modelBlock, boolean bl) {
        ModelRotation modelRotation = ModelRotation.X0_Y0;
        boolean bl2 = false;
        String string = modelBlock.resolveTextureName("particle");
        TextureAtlasSprite textureAtlasSprite = textureMap.getAtlasSprite(new ResourceLocation(string).toString());
        SimpleBakedModel.Builder builder = new SimpleBakedModel.Builder(modelBlock).setTexture(textureAtlasSprite);
        for (BlockPart blockPart : modelBlock.getElements()) {
            for (EnumFacing enumFacing : blockPart.mapFaces.keySet()) {
                BlockPartFace blockPartFace = blockPart.mapFaces.get(enumFacing);
                if (!bl) {
                    blockPartFace = new BlockPartFace(blockPartFace.cullFace, -1, blockPartFace.texture, blockPartFace.blockFaceUV);
                }
                String string2 = modelBlock.resolveTextureName(blockPartFace.texture);
                TextureAtlasSprite textureAtlasSprite2 = textureMap.getAtlasSprite(new ResourceLocation(string2).toString());
                BakedQuad bakedQuad = CustomItemProperties.makeBakedQuad(blockPart, blockPartFace, textureAtlasSprite2, enumFacing, modelRotation, bl2);
                if (blockPartFace.cullFace == null) {
                    builder.addGeneralQuad(bakedQuad);
                    continue;
                }
                builder.addFaceQuad(modelRotation.rotateFace(blockPartFace.cullFace), bakedQuad);
            }
        }
        return builder.makeBakedModel();
    }

    private static BakedQuad makeBakedQuad(BlockPart blockPart, BlockPartFace blockPartFace, TextureAtlasSprite textureAtlasSprite, EnumFacing enumFacing, ModelRotation modelRotation, boolean bl) {
        FaceBakery faceBakery = new FaceBakery();
        return faceBakery.makeBakedQuad(blockPart.positionFrom, blockPart.positionTo, blockPartFace, textureAtlasSprite, enumFacing, modelRotation, blockPart.partRotation, bl, blockPart.shade);
    }

    public String toString() {
        return this.basePath + "/" + this.name + ", type: " + this.type + ", items: [" + Config.arrayToString(this.items) + "], textture: " + this.texture;
    }

    public float getTextureWidth(TextureManager textureManager) {
        if (this.textureWidth <= 0) {
            if (this.textureLocation != null) {
                ITextureObject iTextureObject = textureManager.getTexture(this.textureLocation);
                int n = iTextureObject.getGlTextureId();
                int n2 = GlStateManager.getBoundTexture();
                GlStateManager.bindTexture(n);
                this.textureWidth = GL11.glGetTexLevelParameteri(3553, 0, 4096);
                GlStateManager.bindTexture(n2);
            }
            if (this.textureWidth <= 0) {
                this.textureWidth = 16;
            }
        }
        return this.textureWidth;
    }

    public float getTextureHeight(TextureManager textureManager) {
        if (this.textureHeight <= 0) {
            if (this.textureLocation != null) {
                ITextureObject iTextureObject = textureManager.getTexture(this.textureLocation);
                int n = iTextureObject.getGlTextureId();
                int n2 = GlStateManager.getBoundTexture();
                GlStateManager.bindTexture(n);
                this.textureHeight = GL11.glGetTexLevelParameteri(3553, 0, 4097);
                GlStateManager.bindTexture(n2);
            }
            if (this.textureHeight <= 0) {
                this.textureHeight = 16;
            }
        }
        return this.textureHeight;
    }

    public IBakedModel getBakedModel(ResourceLocation resourceLocation, boolean bl) {
        String string;
        IBakedModel iBakedModel;
        Map<String, IBakedModel> map;
        IBakedModel iBakedModel2;
        if (bl) {
            iBakedModel2 = this.bakedModelFull;
            map = this.mapBakedModelsFull;
        } else {
            iBakedModel2 = this.bakedModelTexture;
            map = this.mapBakedModelsTexture;
        }
        if (resourceLocation != null && map != null && (iBakedModel = map.get(string = resourceLocation.getResourcePath())) != null) {
            return iBakedModel;
        }
        return iBakedModel2;
    }

    public void loadModels(ModelBakery modelBakery) {
        if (this.model != null) {
            CustomItemProperties.loadItemModel(modelBakery, this.model);
        }
        if (this.type == 1 && this.mapModels != null) {
            for (String string : this.mapModels.keySet()) {
                String string2 = this.mapModels.get(string);
                String string3 = StrUtils.removePrefix(string, "model.");
                if (!string3.startsWith("bow") && !string3.startsWith("fishing_rod") && !string3.startsWith("shield")) continue;
                CustomItemProperties.loadItemModel(modelBakery, string2);
            }
        }
    }

    public void updateModelsFull() {
        ModelManager modelManager = Config.getModelManager();
        IBakedModel iBakedModel = modelManager.getMissingModel();
        if (this.model != null) {
            ResourceLocation resourceLocation = CustomItemProperties.getModelLocation(this.model);
            ModelResourceLocation object = new ModelResourceLocation(resourceLocation, INVENTORY);
            this.bakedModelFull = modelManager.getModel(object);
            if (this.bakedModelFull == iBakedModel) {
                Config.warn("Custom Items: Model not found " + object.getResourcePath());
                this.bakedModelFull = null;
            }
        }
        if (this.type == 1 && this.mapModels != null) {
            for (String string : this.mapModels.keySet()) {
                String string2 = this.mapModels.get(string);
                String string3 = StrUtils.removePrefix(string, "model.");
                if (!string3.startsWith("bow") && !string3.startsWith("fishing_rod") && !string3.startsWith("shield")) continue;
                ResourceLocation resourceLocation = CustomItemProperties.getModelLocation(string2);
                ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, INVENTORY);
                IBakedModel iBakedModel2 = modelManager.getModel(modelResourceLocation);
                if (iBakedModel2 == iBakedModel) {
                    Config.warn("Custom Items: Model not found " + modelResourceLocation.getResourcePath());
                    continue;
                }
                if (this.mapBakedModelsFull == null) {
                    this.mapBakedModelsFull = new HashMap<String, IBakedModel>();
                }
                this.mapBakedModelsFull.put(string3, iBakedModel2);
            }
        }
    }

    private static void loadItemModel(ModelBakery modelBakery, String string) {
        ResourceLocation resourceLocation = CustomItemProperties.getModelLocation(string);
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, INVENTORY);
        if (Reflector.ModelLoader.exists()) {
            try {
                Object object = Reflector.ModelLoader_VanillaLoader_INSTANCE.getValue();
                CustomItemProperties.checkNull(object, "vanillaLoader is null");
                Object object2 = Reflector.call(object, Reflector.ModelLoader_VanillaLoader_loadModel, modelResourceLocation);
                CustomItemProperties.checkNull(object2, "iModel is null");
                Map map = (Map)Reflector.getFieldValue(modelBakery, Reflector.ModelLoader_stateModels);
                CustomItemProperties.checkNull(map, "stateModels is null");
                map.put(modelResourceLocation, object2);
                Set set = (Set)Reflector.getFieldValue(modelBakery, Reflector.ModelLoader_textures);
                CustomItemProperties.checkNull(set, "registryTextures is null");
                Collection collection = (Collection)Reflector.call(object2, Reflector.IModel_getTextures, new Object[0]);
                CustomItemProperties.checkNull(collection, "modelTextures is null");
                set.addAll(collection);
            }
            catch (Exception exception) {
                Config.warn("Error registering model with ModelLoader: " + String.valueOf(modelResourceLocation) + ", " + exception.getClass().getName() + ": " + exception.getMessage());
            }
        } else {
            modelBakery.loadItemModel(resourceLocation.toString(), modelResourceLocation, resourceLocation);
        }
    }

    private static void checkNull(Object object, String string) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException(string);
        }
    }

    private static ResourceLocation getModelLocation(String string) {
        return Reflector.ModelLoader.exists() && !string.startsWith("mcpatcher/") && !string.startsWith("optifine/") ? new ResourceLocation("models/" + string) : new ResourceLocation(string);
    }
}

