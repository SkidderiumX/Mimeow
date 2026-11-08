/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomItemProperties;
import net.optifine.CustomItemsComparator;
import net.optifine.config.NbtTagValue;
import net.optifine.render.Blender;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.ShadersRender;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.ResUtils;
import net.optifine.util.StrUtils;

public class CustomItems {
    private static CustomItemProperties[][] itemProperties = null;
    private static CustomItemProperties[][] enchantmentProperties = null;
    private static Map mapPotionIds = null;
    private static ItemModelGenerator itemModelGenerator = new ItemModelGenerator();
    private static boolean useGlint = true;
    private static boolean renderOffHand = false;
    public static final int MASK_POTION_SPLASH = 16384;
    public static final int MASK_POTION_NAME = 63;
    public static final int MASK_POTION_EXTENDED = 64;
    public static final String KEY_TEXTURE_OVERLAY = "texture.potion_overlay";
    public static final String KEY_TEXTURE_SPLASH = "texture.potion_bottle_splash";
    public static final String KEY_TEXTURE_DRINKABLE = "texture.potion_bottle_drinkable";
    public static final String DEFAULT_TEXTURE_OVERLAY = "items/potion_overlay";
    public static final String DEFAULT_TEXTURE_SPLASH = "items/potion_bottle_splash";
    public static final String DEFAULT_TEXTURE_DRINKABLE = "items/potion_bottle_drinkable";
    private static final int[][] EMPTY_INT2_ARRAY = new int[0][];
    private static final String TYPE_POTION_NORMAL = "normal";
    private static final String TYPE_POTION_SPLASH = "splash";
    private static final String TYPE_POTION_LINGER = "linger";

    public static void update() {
        itemProperties = null;
        enchantmentProperties = null;
        useGlint = true;
        if (Config.isCustomItems()) {
            CustomItems.readCitProperties("mcpatcher/cit.properties");
            IResourcePack[] iResourcePackArray = Config.getResourcePacks();
            for (int i = iResourcePackArray.length - 1; i >= 0; --i) {
                IResourcePack iResourcePack = iResourcePackArray[i];
                CustomItems.update(iResourcePack);
            }
            CustomItems.update(Config.getDefaultResourcePack());
            if (itemProperties.length <= 0) {
                itemProperties = null;
            }
            if (enchantmentProperties.length <= 0) {
                enchantmentProperties = null;
            }
        }
    }

    private static void readCitProperties(String string) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return;
            }
            Config.dbg("CustomItems: Loading " + string);
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
            useGlint = Config.parseBoolean(propertiesOrdered.getProperty("useGlint"), true);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private static void update(IResourcePack iResourcePack) {
        int n;
        Object object;
        Object[] objectArray;
        Collection<Object> collection;
        Object[] objectArray2 = ResUtils.collectFiles(iResourcePack, "mcpatcher/cit/", ".properties", (String[])null);
        Map map = CustomItems.makeAutoImageProperties(iResourcePack);
        if (map.size() > 0) {
            collection = map.keySet();
            objectArray = collection.toArray(new String[collection.size()]);
            objectArray2 = (String[])Config.addObjectsToArray(objectArray2, objectArray);
        }
        Arrays.sort(objectArray2);
        collection = CustomItems.makePropertyList(itemProperties);
        objectArray = CustomItems.makePropertyList(enchantmentProperties);
        for (int i = 0; i < objectArray2.length; ++i) {
            Object object2 = objectArray2[i];
            Config.dbg("CustomItems: " + (String)object2);
            try {
                object = null;
                if (map.containsKey(object2)) {
                    object = (CustomItemProperties)map.get(object2);
                }
                if (object == null) {
                    ResourceLocation resourceLocation = new ResourceLocation((String)object2);
                    InputStream inputStream2 = iResourcePack.getInputStream(resourceLocation);
                    if (inputStream2 == null) {
                        Config.warn("CustomItems file not found: " + (String)object2);
                        continue;
                    }
                    PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                    propertiesOrdered.load(inputStream2);
                    inputStream2.close();
                    object = new CustomItemProperties(propertiesOrdered, (String)object2);
                }
                if (!object.isValid((String)object2)) continue;
                CustomItems.addToItemList((CustomItemProperties)object, collection);
                CustomItems.addToEnchantmentList((CustomItemProperties)object, (List)objectArray);
                continue;
            }
            catch (FileNotFoundException fileNotFoundException) {
                Config.warn("CustomItems file not found: " + (String)object2);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        itemProperties = CustomItems.propertyListToArray(collection);
        enchantmentProperties = CustomItems.propertyListToArray((List)objectArray);
        Comparator comparator = CustomItems.getPropertiesComparator();
        for (n = 0; n < itemProperties.length; ++n) {
            object = itemProperties[n];
            if (object == null) continue;
            Arrays.sort(object, comparator);
        }
        for (n = 0; n < enchantmentProperties.length; ++n) {
            object = enchantmentProperties[n];
            if (object == null) continue;
            Arrays.sort(object, comparator);
        }
    }

    private static Comparator getPropertiesComparator() {
        Comparator comparator = new Comparator(){

            public int compare(Object object, Object object2) {
                CustomItemProperties customItemProperties = (CustomItemProperties)object;
                CustomItemProperties customItemProperties2 = (CustomItemProperties)object2;
                return customItemProperties.layer != customItemProperties2.layer ? customItemProperties.layer - customItemProperties2.layer : (customItemProperties.weight != customItemProperties2.weight ? customItemProperties2.weight - customItemProperties.weight : (!customItemProperties.basePath.equals(customItemProperties2.basePath) ? customItemProperties.basePath.compareTo(customItemProperties2.basePath) : customItemProperties.name.compareTo(customItemProperties2.name)));
            }
        };
        return comparator;
    }

    public static void updateIcons(TextureMap textureMap) {
        for (CustomItemProperties customItemProperties : CustomItems.getAllProperties()) {
            customItemProperties.updateIcons(textureMap);
        }
    }

    public static void loadModels(ModelBakery modelBakery) {
        for (CustomItemProperties customItemProperties : CustomItems.getAllProperties()) {
            customItemProperties.loadModels(modelBakery);
        }
    }

    public static void updateModels() {
        for (CustomItemProperties customItemProperties : CustomItems.getAllProperties()) {
            if (customItemProperties.type != 1) continue;
            TextureMap textureMap = Minecraft.getMinecraft().getTextureMapBlocks();
            customItemProperties.updateModelTexture(textureMap, itemModelGenerator);
            customItemProperties.updateModelsFull();
        }
    }

    private static List<CustomItemProperties> getAllProperties() {
        ArrayList<CustomItemProperties> arrayList = new ArrayList<CustomItemProperties>();
        CustomItems.addAll(itemProperties, arrayList);
        CustomItems.addAll(enchantmentProperties, arrayList);
        return arrayList;
    }

    private static void addAll(CustomItemProperties[][] customItemPropertiesArray, List<CustomItemProperties> list) {
        if (customItemPropertiesArray != null) {
            for (int i = 0; i < customItemPropertiesArray.length; ++i) {
                CustomItemProperties[] customItemPropertiesArray2 = customItemPropertiesArray[i];
                if (customItemPropertiesArray2 == null) continue;
                for (int j = 0; j < customItemPropertiesArray2.length; ++j) {
                    CustomItemProperties customItemProperties = customItemPropertiesArray2[j];
                    if (customItemProperties == null) continue;
                    list.add(customItemProperties);
                }
            }
        }
    }

    private static Map makeAutoImageProperties(IResourcePack iResourcePack) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(CustomItems.makePotionImageProperties(iResourcePack, TYPE_POTION_NORMAL, Item.getIdFromItem(Items.potionitem)));
        hashMap.putAll(CustomItems.makePotionImageProperties(iResourcePack, TYPE_POTION_SPLASH, Item.getIdFromItem(Items.potionitem)));
        hashMap.putAll(CustomItems.makePotionImageProperties(iResourcePack, TYPE_POTION_LINGER, Item.getIdFromItem(Items.potionitem)));
        return hashMap;
    }

    private static Map makePotionImageProperties(IResourcePack iResourcePack, String string, int n) {
        HashMap<CallSite, CustomItemProperties> hashMap = new HashMap<CallSite, CustomItemProperties>();
        String string2 = string + "/";
        String[] stringArray = new String[]{"mcpatcher/cit/potion/" + string2, "mcpatcher/cit/Potion/" + string2};
        String[] stringArray2 = new String[]{".png"};
        String[] stringArray3 = ResUtils.collectFiles(iResourcePack, stringArray, stringArray2);
        for (int i = 0; i < stringArray3.length; ++i) {
            String string3 = stringArray3[i];
            String string4 = StrUtils.removePrefixSuffix(string3, stringArray, stringArray2);
            Properties properties = CustomItems.makePotionProperties(string4, string, n, string3);
            if (properties == null) continue;
            String string5 = StrUtils.removeSuffix(string3, stringArray2) + ".properties";
            CustomItemProperties customItemProperties = new CustomItemProperties(properties, string5);
            hashMap.put((CallSite)((Object)string5), customItemProperties);
        }
        return hashMap;
    }

    private static Properties makePotionProperties(String string, String string2, int n, String string3) {
        int n2;
        if (StrUtils.endsWith(string, new String[]{"_n", "_s"})) {
            return null;
        }
        if (string.equals("empty") && string2.equals(TYPE_POTION_NORMAL)) {
            n = Item.getIdFromItem(Items.glass_bottle);
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            ((Properties)propertiesOrdered).put("type", "item");
            ((Properties)propertiesOrdered).put("items", "" + n);
            return propertiesOrdered;
        }
        int[] nArray = (int[])CustomItems.getMapPotionIds().get(string);
        if (nArray == null) {
            Config.warn("Potion not found for image: " + string3);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n2 = 0; n2 < nArray.length; ++n2) {
            int n3 = nArray[n2];
            if (string2.equals(TYPE_POTION_SPLASH)) {
                n3 |= 0x4000;
            }
            if (n2 > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(n3);
        }
        n2 = 16447;
        if (string.equals("water") || string.equals("mundane")) {
            n2 |= 0x40;
        }
        PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
        ((Properties)propertiesOrdered).put("type", "item");
        ((Properties)propertiesOrdered).put("items", "" + n);
        ((Properties)propertiesOrdered).put("damage", stringBuffer.toString());
        ((Properties)propertiesOrdered).put("damageMask", "" + n2);
        if (string2.equals(TYPE_POTION_SPLASH)) {
            ((Properties)propertiesOrdered).put(KEY_TEXTURE_SPLASH, string);
        } else {
            ((Properties)propertiesOrdered).put(KEY_TEXTURE_DRINKABLE, string);
        }
        return propertiesOrdered;
    }

    private static Map getMapPotionIds() {
        if (mapPotionIds == null) {
            mapPotionIds = new LinkedHashMap();
            mapPotionIds.put("water", CustomItems.getPotionId(0, 0));
            mapPotionIds.put("awkward", CustomItems.getPotionId(0, 1));
            mapPotionIds.put("thick", CustomItems.getPotionId(0, 2));
            mapPotionIds.put("potent", CustomItems.getPotionId(0, 3));
            mapPotionIds.put("regeneration", CustomItems.getPotionIds(1));
            mapPotionIds.put("movespeed", CustomItems.getPotionIds(2));
            mapPotionIds.put("fireresistance", CustomItems.getPotionIds(3));
            mapPotionIds.put("poison", CustomItems.getPotionIds(4));
            mapPotionIds.put("heal", CustomItems.getPotionIds(5));
            mapPotionIds.put("nightvision", CustomItems.getPotionIds(6));
            mapPotionIds.put("clear", CustomItems.getPotionId(7, 0));
            mapPotionIds.put("bungling", CustomItems.getPotionId(7, 1));
            mapPotionIds.put("charming", CustomItems.getPotionId(7, 2));
            mapPotionIds.put("rank", CustomItems.getPotionId(7, 3));
            mapPotionIds.put("weakness", CustomItems.getPotionIds(8));
            mapPotionIds.put("damageboost", CustomItems.getPotionIds(9));
            mapPotionIds.put("moveslowdown", CustomItems.getPotionIds(10));
            mapPotionIds.put("leaping", CustomItems.getPotionIds(11));
            mapPotionIds.put("harm", CustomItems.getPotionIds(12));
            mapPotionIds.put("waterbreathing", CustomItems.getPotionIds(13));
            mapPotionIds.put("invisibility", CustomItems.getPotionIds(14));
            mapPotionIds.put("thin", CustomItems.getPotionId(15, 0));
            mapPotionIds.put("debonair", CustomItems.getPotionId(15, 1));
            mapPotionIds.put("sparkling", CustomItems.getPotionId(15, 2));
            mapPotionIds.put("stinky", CustomItems.getPotionId(15, 3));
            mapPotionIds.put("mundane", CustomItems.getPotionId(0, 4));
            mapPotionIds.put("speed", mapPotionIds.get("movespeed"));
            mapPotionIds.put("fire_resistance", mapPotionIds.get("fireresistance"));
            mapPotionIds.put("instant_health", mapPotionIds.get("heal"));
            mapPotionIds.put("night_vision", mapPotionIds.get("nightvision"));
            mapPotionIds.put("strength", mapPotionIds.get("damageboost"));
            mapPotionIds.put("slowness", mapPotionIds.get("moveslowdown"));
            mapPotionIds.put("instant_damage", mapPotionIds.get("harm"));
            mapPotionIds.put("water_breathing", mapPotionIds.get("waterbreathing"));
        }
        return mapPotionIds;
    }

    private static int[] getPotionIds(int n) {
        return new int[]{n, n + 16, n + 32, n + 48};
    }

    private static int[] getPotionId(int n, int n2) {
        return new int[]{n + n2 * 16};
    }

    private static int getPotionNameDamage(String string) {
        String string2 = "potion." + string;
        Potion[] potionArray = Potion.potionTypes;
        for (int i = 0; i < potionArray.length; ++i) {
            String string3;
            Potion potion = potionArray[i];
            if (potion == null || !string2.equals(string3 = potion.getName())) continue;
            return potion.getId();
        }
        return -1;
    }

    private static List makePropertyList(CustomItemProperties[][] customItemPropertiesArray) {
        ArrayList<ArrayList<CustomItemProperties>> arrayList = new ArrayList<ArrayList<CustomItemProperties>>();
        if (customItemPropertiesArray != null) {
            for (int i = 0; i < customItemPropertiesArray.length; ++i) {
                CustomItemProperties[] customItemPropertiesArray2 = customItemPropertiesArray[i];
                ArrayList<CustomItemProperties> arrayList2 = null;
                if (customItemPropertiesArray2 != null) {
                    arrayList2 = new ArrayList<CustomItemProperties>(Arrays.asList(customItemPropertiesArray2));
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private static CustomItemProperties[][] propertyListToArray(List list) {
        CustomItemProperties[][] customItemPropertiesArray = new CustomItemProperties[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            List list2 = (List)list.get(i);
            if (list2 == null) continue;
            CustomItemProperties[] customItemPropertiesArray2 = list2.toArray(new CustomItemProperties[list2.size()]);
            Arrays.sort(customItemPropertiesArray2, new CustomItemsComparator());
            customItemPropertiesArray[i] = customItemPropertiesArray2;
        }
        return customItemPropertiesArray;
    }

    private static void addToItemList(CustomItemProperties customItemProperties, List list) {
        if (customItemProperties.items != null) {
            for (int i = 0; i < customItemProperties.items.length; ++i) {
                int n = customItemProperties.items[i];
                if (n <= 0) {
                    Config.warn("Invalid item ID: " + n);
                    continue;
                }
                CustomItems.addToList(customItemProperties, list, n);
            }
        }
    }

    private static void addToEnchantmentList(CustomItemProperties customItemProperties, List list) {
        if (customItemProperties.type == 2 && customItemProperties.enchantmentIds != null) {
            for (int i = 0; i < 256; ++i) {
                if (!customItemProperties.enchantmentIds.isInRange(i)) continue;
                CustomItems.addToList(customItemProperties, list, i);
            }
        }
    }

    private static void addToList(CustomItemProperties customItemProperties, List list, int n) {
        while (n >= list.size()) {
            list.add(null);
        }
        ArrayList<CustomItemProperties> arrayList = (ArrayList<CustomItemProperties>)list.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList<CustomItemProperties>();
            list.set(n, arrayList);
        }
        arrayList.add(customItemProperties);
    }

    public static IBakedModel getCustomItemModel(ItemStack itemStack, IBakedModel iBakedModel, ResourceLocation resourceLocation, boolean bl) {
        if (!bl && iBakedModel.isGui3d()) {
            return iBakedModel;
        }
        if (itemProperties == null) {
            return iBakedModel;
        }
        CustomItemProperties customItemProperties = CustomItems.getCustomItemProperties(itemStack, 1);
        if (customItemProperties == null) {
            return iBakedModel;
        }
        IBakedModel iBakedModel2 = customItemProperties.getBakedModel(resourceLocation, bl);
        return iBakedModel2 != null ? iBakedModel2 : iBakedModel;
    }

    public static boolean bindCustomArmorTexture(ItemStack itemStack, int n, String string) {
        if (itemProperties == null) {
            return false;
        }
        ResourceLocation resourceLocation = CustomItems.getCustomArmorLocation(itemStack, n, string);
        if (resourceLocation == null) {
            return false;
        }
        Config.getTextureManager().bindTexture(resourceLocation);
        return true;
    }

    private static ResourceLocation getCustomArmorLocation(ItemStack itemStack, int n, String string) {
        String string2;
        ResourceLocation resourceLocation;
        CustomItemProperties customItemProperties = CustomItems.getCustomItemProperties(itemStack, 3);
        if (customItemProperties == null) {
            return null;
        }
        if (customItemProperties.mapTextureLocations == null) {
            return customItemProperties.textureLocation;
        }
        Item item = itemStack.getItem();
        if (!(item instanceof ItemArmor)) {
            return null;
        }
        ItemArmor itemArmor = (ItemArmor)item;
        String string3 = itemArmor.getArmorMaterial().getName();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("texture.");
        stringBuffer.append(string3);
        stringBuffer.append("_layer_");
        stringBuffer.append(n);
        if (string != null) {
            stringBuffer.append("_");
            stringBuffer.append(string);
        }
        return (resourceLocation = (ResourceLocation)customItemProperties.mapTextureLocations.get(string2 = stringBuffer.toString())) == null ? customItemProperties.textureLocation : resourceLocation;
    }

    private static CustomItemProperties getCustomItemProperties(ItemStack itemStack, int n) {
        CustomItemProperties[] customItemPropertiesArray;
        if (itemProperties == null) {
            return null;
        }
        if (itemStack == null) {
            return null;
        }
        Item item = itemStack.getItem();
        int n2 = Item.getIdFromItem(item);
        if (n2 >= 0 && n2 < itemProperties.length && (customItemPropertiesArray = itemProperties[n2]) != null) {
            for (int i = 0; i < customItemPropertiesArray.length; ++i) {
                CustomItemProperties customItemProperties = customItemPropertiesArray[i];
                if (customItemProperties.type != n || !CustomItems.matchesProperties(customItemProperties, itemStack, null)) continue;
                return customItemProperties;
            }
        }
        return null;
    }

    private static boolean matchesProperties(CustomItemProperties customItemProperties, ItemStack itemStack, int[][] nArray) {
        int n;
        int n2;
        int n3;
        Item item = itemStack.getItem();
        if (customItemProperties.damage != null) {
            int n4 = itemStack.getItemDamage();
            if (customItemProperties.damageMask != 0) {
                n4 &= customItemProperties.damageMask;
            }
            if (customItemProperties.damagePercent) {
                n3 = item.getMaxDamage();
                n4 = (int)((double)(n4 * 100) / (double)n3);
            }
            if (!customItemProperties.damage.isInRange(n4)) {
                return false;
            }
        }
        if (customItemProperties.stackSize != null && !customItemProperties.stackSize.isInRange(itemStack.stackSize)) {
            return false;
        }
        int[][] nArray2 = nArray;
        if (customItemProperties.enchantmentIds != null) {
            if (nArray == null) {
                nArray2 = CustomItems.getEnchantmentIdLevels(itemStack);
            }
            n3 = 0;
            for (n2 = 0; n2 < nArray2.length; ++n2) {
                n = nArray2[n2][0];
                if (!customItemProperties.enchantmentIds.isInRange(n)) continue;
                n3 = 1;
                break;
            }
            if (n3 == 0) {
                return false;
            }
        }
        if (customItemProperties.enchantmentLevels != null) {
            if (nArray2 == null) {
                nArray2 = CustomItems.getEnchantmentIdLevels(itemStack);
            }
            n3 = 0;
            for (n2 = 0; n2 < nArray2.length; ++n2) {
                n = nArray2[n2][1];
                if (!customItemProperties.enchantmentLevels.isInRange(n)) continue;
                n3 = 1;
                break;
            }
            if (n3 == 0) {
                return false;
            }
        }
        if (customItemProperties.nbtTagValues != null) {
            NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
            for (n2 = 0; n2 < customItemProperties.nbtTagValues.length; ++n2) {
                NbtTagValue nbtTagValue = customItemProperties.nbtTagValues[n2];
                if (nbtTagValue.matches(nBTTagCompound)) continue;
                return false;
            }
        }
        if (customItemProperties.hand != 0) {
            if (customItemProperties.hand == 1 && renderOffHand) {
                return false;
            }
            if (customItemProperties.hand == 2 && !renderOffHand) {
                return false;
            }
        }
        return true;
    }

    private static int[][] getEnchantmentIdLevels(ItemStack itemStack) {
        NBTTagList nBTTagList;
        Item item = itemStack.getItem();
        NBTTagList nBTTagList2 = nBTTagList = item == Items.enchanted_book ? Items.enchanted_book.getEnchantments(itemStack) : itemStack.getEnchantmentTagList();
        if (nBTTagList != null && nBTTagList.tagCount() > 0) {
            int[][] nArray = new int[nBTTagList.tagCount()][2];
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
                short s = nBTTagCompound.getShort("id");
                short s2 = nBTTagCompound.getShort("lvl");
                nArray[i][0] = s;
                nArray[i][1] = s2;
            }
            return nArray;
        }
        return EMPTY_INT2_ARRAY;
    }

    public static boolean renderCustomEffect(RenderItem renderItem, ItemStack itemStack, IBakedModel iBakedModel) {
        if (enchantmentProperties == null) {
            return false;
        }
        if (itemStack == null) {
            return false;
        }
        int[][] nArray = CustomItems.getEnchantmentIdLevels(itemStack);
        if (nArray.length <= 0) {
            return false;
        }
        HashSet<Integer> hashSet = null;
        boolean bl = false;
        TextureManager textureManager = Config.getTextureManager();
        for (int i = 0; i < nArray.length; ++i) {
            CustomItemProperties[] customItemPropertiesArray;
            int n = nArray[i][0];
            if (n < 0 || n >= enchantmentProperties.length || (customItemPropertiesArray = enchantmentProperties[n]) == null) continue;
            for (int j = 0; j < customItemPropertiesArray.length; ++j) {
                CustomItemProperties customItemProperties = customItemPropertiesArray[j];
                if (hashSet == null) {
                    hashSet = new HashSet<Integer>();
                }
                if (!hashSet.add(n) || !CustomItems.matchesProperties(customItemProperties, itemStack, nArray) || customItemProperties.textureLocation == null) continue;
                textureManager.bindTexture(customItemProperties.textureLocation);
                float f = customItemProperties.getTextureWidth(textureManager);
                if (!bl) {
                    bl = true;
                    GlStateManager.depthMask(false);
                    GlStateManager.depthFunc(514);
                    GlStateManager.disableLighting();
                    GlStateManager.matrixMode(5890);
                }
                Blender.setupBlend(customItemProperties.blend, 1.0f);
                GlStateManager.pushMatrix();
                GlStateManager.scale(f / 2.0f, f / 2.0f, f / 2.0f);
                float f2 = customItemProperties.speed * (float)(Minecraft.getSystemTime() % 3000L) / 3000.0f / 8.0f;
                GlStateManager.translate(f2, 0.0f, 0.0f);
                GlStateManager.rotate(customItemProperties.rotation, 0.0f, 0.0f, 1.0f);
                renderItem.renderModel(iBakedModel, -1);
                GlStateManager.popMatrix();
            }
        }
        if (bl) {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            textureManager.bindTexture(TextureMap.locationBlocksTexture);
        }
        return bl;
    }

    public static boolean renderCustomArmorEffect(EntityLivingBase entityLivingBase, ItemStack itemStack, ModelBase modelBase, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (enchantmentProperties == null) {
            return false;
        }
        if (Config.isShaders() && Shaders.isShadowPass) {
            return false;
        }
        if (itemStack == null) {
            return false;
        }
        int[][] nArray = CustomItems.getEnchantmentIdLevels(itemStack);
        if (nArray.length <= 0) {
            return false;
        }
        HashSet<Integer> hashSet = null;
        boolean bl = false;
        TextureManager textureManager = Config.getTextureManager();
        for (int i = 0; i < nArray.length; ++i) {
            CustomItemProperties[] customItemPropertiesArray;
            int n = nArray[i][0];
            if (n < 0 || n >= enchantmentProperties.length || (customItemPropertiesArray = enchantmentProperties[n]) == null) continue;
            for (int j = 0; j < customItemPropertiesArray.length; ++j) {
                CustomItemProperties customItemProperties = customItemPropertiesArray[j];
                if (hashSet == null) {
                    hashSet = new HashSet<Integer>();
                }
                if (!hashSet.add(n) || !CustomItems.matchesProperties(customItemProperties, itemStack, nArray) || customItemProperties.textureLocation == null) continue;
                textureManager.bindTexture(customItemProperties.textureLocation);
                float f8 = customItemProperties.getTextureWidth(textureManager);
                if (!bl) {
                    bl = true;
                    if (Config.isShaders()) {
                        ShadersRender.renderEnchantedGlintBegin();
                    }
                    GlStateManager.enableBlend();
                    GlStateManager.depthFunc(514);
                    GlStateManager.depthMask(false);
                }
                Blender.setupBlend(customItemProperties.blend, 1.0f);
                GlStateManager.disableLighting();
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                GlStateManager.rotate(customItemProperties.rotation, 0.0f, 0.0f, 1.0f);
                float f9 = f8 / 8.0f;
                GlStateManager.scale(f9, f9 / 2.0f, f9);
                float f10 = customItemProperties.speed * (float)(Minecraft.getSystemTime() % 3000L) / 3000.0f / 8.0f;
                GlStateManager.translate(0.0f, f10, 0.0f);
                GlStateManager.matrixMode(5888);
                modelBase.render(entityLivingBase, f, f2, f4, f5, f6, f7);
            }
        }
        if (bl) {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintEnd();
            }
        }
        return bl;
    }

    public static boolean isUseGlint() {
        return useGlint;
    }
}

