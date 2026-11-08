/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.CustomGuis;
import net.optifine.config.ConnectedParser;
import net.optifine.config.Matches;
import net.optifine.config.NbtTagValue;
import net.optifine.config.RangeListInt;
import net.optifine.config.VillagerProfession;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorField;
import net.optifine.util.StrUtils;
import net.optifine.util.TextureUtils;

public class CustomGuiProperties {
    private String fileName = null;
    private String basePath = null;
    private EnumContainer container = null;
    private Map<ResourceLocation, ResourceLocation> textureLocations = null;
    private NbtTagValue nbtName = null;
    private BiomeGenBase[] biomes = null;
    private RangeListInt heights = null;
    private Boolean large = null;
    private Boolean trapped = null;
    private Boolean christmas = null;
    private Boolean ender = null;
    private RangeListInt levels = null;
    private VillagerProfession[] professions = null;
    private EnumVariant[] variants = null;
    private EnumDyeColor[] colors = null;
    private static final EnumVariant[] VARIANTS_HORSE = new EnumVariant[]{EnumVariant.HORSE, EnumVariant.DONKEY, EnumVariant.MULE, EnumVariant.LLAMA};
    private static final EnumVariant[] VARIANTS_DISPENSER = new EnumVariant[]{EnumVariant.DISPENSER, EnumVariant.DROPPER};
    private static final EnumVariant[] VARIANTS_INVALID = new EnumVariant[0];
    private static final EnumDyeColor[] COLORS_INVALID = new EnumDyeColor[0];
    private static final ResourceLocation ANVIL_GUI_TEXTURE = new ResourceLocation("textures/gui/container/anvil.png");
    private static final ResourceLocation BEACON_GUI_TEXTURE = new ResourceLocation("textures/gui/container/beacon.png");
    private static final ResourceLocation BREWING_STAND_GUI_TEXTURE = new ResourceLocation("textures/gui/container/brewing_stand.png");
    private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
    private static final ResourceLocation CRAFTING_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/crafting_table.png");
    private static final ResourceLocation HORSE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/horse.png");
    private static final ResourceLocation DISPENSER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/dispenser.png");
    private static final ResourceLocation ENCHANTMENT_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/enchanting_table.png");
    private static final ResourceLocation FURNACE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");
    private static final ResourceLocation HOPPER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/hopper.png");
    private static final ResourceLocation INVENTORY_GUI_TEXTURE = new ResourceLocation("textures/gui/container/inventory.png");
    private static final ResourceLocation SHULKER_BOX_GUI_TEXTURE = new ResourceLocation("textures/gui/container/shulker_box.png");
    private static final ResourceLocation VILLAGER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/villager.png");

    public CustomGuiProperties(Properties properties, String string) {
        ConnectedParser connectedParser = new ConnectedParser("CustomGuis");
        this.fileName = connectedParser.parseName(string);
        this.basePath = connectedParser.parseBasePath(string);
        this.container = (EnumContainer)connectedParser.parseEnum(properties.getProperty("container"), EnumContainer.values(), "container");
        this.textureLocations = CustomGuiProperties.parseTextureLocations(properties, "texture", this.container, "textures/gui/", this.basePath);
        this.nbtName = connectedParser.parseNbtTagValue("name", properties.getProperty("name"));
        this.biomes = connectedParser.parseBiomes(properties.getProperty("biomes"));
        this.heights = connectedParser.parseRangeListInt(properties.getProperty("heights"));
        this.large = connectedParser.parseBooleanObject(properties.getProperty("large"));
        this.trapped = connectedParser.parseBooleanObject(properties.getProperty("trapped"));
        this.christmas = connectedParser.parseBooleanObject(properties.getProperty("christmas"));
        this.ender = connectedParser.parseBooleanObject(properties.getProperty("ender"));
        this.levels = connectedParser.parseRangeListInt(properties.getProperty("levels"));
        this.professions = connectedParser.parseProfessions(properties.getProperty("professions"));
        Enum[] enumArray = CustomGuiProperties.getContainerVariants(this.container);
        this.variants = (EnumVariant[])connectedParser.parseEnums(properties.getProperty("variants"), enumArray, "variants", VARIANTS_INVALID);
        this.colors = CustomGuiProperties.parseEnumDyeColors(properties.getProperty("colors"));
    }

    private static EnumVariant[] getContainerVariants(EnumContainer enumContainer) {
        return enumContainer == EnumContainer.HORSE ? VARIANTS_HORSE : (enumContainer == EnumContainer.DISPENSER ? VARIANTS_DISPENSER : new EnumVariant[]{});
    }

    private static EnumDyeColor[] parseEnumDyeColors(String string) {
        if (string == null) {
            return null;
        }
        string = string.toLowerCase();
        String[] stringArray = Config.tokenize(string, " ");
        EnumDyeColor[] enumDyeColorArray = new EnumDyeColor[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            EnumDyeColor enumDyeColor = CustomGuiProperties.parseEnumDyeColor(string2);
            if (enumDyeColor == null) {
                CustomGuiProperties.warn("Invalid color: " + string2);
                return COLORS_INVALID;
            }
            enumDyeColorArray[i] = enumDyeColor;
        }
        return enumDyeColorArray;
    }

    private static EnumDyeColor parseEnumDyeColor(String string) {
        if (string == null) {
            return null;
        }
        EnumDyeColor[] enumDyeColorArray = EnumDyeColor.values();
        for (int i = 0; i < enumDyeColorArray.length; ++i) {
            EnumDyeColor enumDyeColor = enumDyeColorArray[i];
            if (enumDyeColor.getName().equals(string)) {
                return enumDyeColor;
            }
            if (!enumDyeColor.getUnlocalizedName().equals(string)) continue;
            return enumDyeColor;
        }
        return null;
    }

    private static ResourceLocation parseTextureLocation(String string, String string2) {
        if (string == null) {
            return null;
        }
        Object object = TextureUtils.fixResourcePath(string = string.trim(), string2);
        if (!((String)object).endsWith(".png")) {
            object = (String)object + ".png";
        }
        return new ResourceLocation(string2 + "/" + (String)object);
    }

    private static Map<ResourceLocation, ResourceLocation> parseTextureLocations(Properties properties, String string, EnumContainer enumContainer, String string2, String string3) {
        Object object;
        HashMap<ResourceLocation, ResourceLocation> hashMap = new HashMap<ResourceLocation, ResourceLocation>();
        String string4 = properties.getProperty(string);
        if (string4 != null) {
            object = CustomGuiProperties.getGuiTextureLocation(enumContainer);
            ResourceLocation resourceLocation = CustomGuiProperties.parseTextureLocation(string4, string3);
            if (object != null && resourceLocation != null) {
                hashMap.put((ResourceLocation)object, resourceLocation);
            }
        }
        object = string + ".";
        for (Object e : properties.keySet()) {
            String string5 = (String)e;
            if (!string5.startsWith((String)object)) continue;
            String string6 = string5.substring(((String)object).length());
            string6 = string6.replace('\\', '/');
            string6 = StrUtils.removePrefixSuffix(string6, "/", ".png");
            String string7 = string2 + string6 + ".png";
            String string8 = properties.getProperty(string5);
            ResourceLocation resourceLocation = new ResourceLocation(string7);
            ResourceLocation resourceLocation2 = CustomGuiProperties.parseTextureLocation(string8, string3);
            hashMap.put(resourceLocation, resourceLocation2);
        }
        return hashMap;
    }

    private static ResourceLocation getGuiTextureLocation(EnumContainer enumContainer) {
        if (enumContainer == null) {
            return null;
        }
        switch (enumContainer) {
            case ANVIL: {
                return ANVIL_GUI_TEXTURE;
            }
            case BEACON: {
                return BEACON_GUI_TEXTURE;
            }
            case BREWING_STAND: {
                return BREWING_STAND_GUI_TEXTURE;
            }
            case CHEST: {
                return CHEST_GUI_TEXTURE;
            }
            case CRAFTING: {
                return CRAFTING_TABLE_GUI_TEXTURE;
            }
            case CREATIVE: {
                return null;
            }
            case DISPENSER: {
                return DISPENSER_GUI_TEXTURE;
            }
            case ENCHANTMENT: {
                return ENCHANTMENT_TABLE_GUI_TEXTURE;
            }
            case FURNACE: {
                return FURNACE_GUI_TEXTURE;
            }
            case HOPPER: {
                return HOPPER_GUI_TEXTURE;
            }
            case HORSE: {
                return HORSE_GUI_TEXTURE;
            }
            case INVENTORY: {
                return INVENTORY_GUI_TEXTURE;
            }
            case SHULKER_BOX: {
                return SHULKER_BOX_GUI_TEXTURE;
            }
            case VILLAGER: {
                return VILLAGER_GUI_TEXTURE;
            }
        }
        return null;
    }

    public boolean isValid(String string) {
        if (this.fileName != null && this.fileName.length() > 0) {
            if (this.basePath == null) {
                CustomGuiProperties.warn("No base path found: " + string);
                return false;
            }
            if (this.container == null) {
                CustomGuiProperties.warn("No container found: " + string);
                return false;
            }
            if (this.textureLocations.isEmpty()) {
                CustomGuiProperties.warn("No texture found: " + string);
                return false;
            }
            if (this.professions == ConnectedParser.PROFESSIONS_INVALID) {
                CustomGuiProperties.warn("Invalid professions or careers: " + string);
                return false;
            }
            if (this.variants == VARIANTS_INVALID) {
                CustomGuiProperties.warn("Invalid variants: " + string);
                return false;
            }
            if (this.colors == COLORS_INVALID) {
                CustomGuiProperties.warn("Invalid colors: " + string);
                return false;
            }
            return true;
        }
        CustomGuiProperties.warn("No name found: " + string);
        return false;
    }

    private static void warn(String string) {
        Config.warn("[CustomGuis] " + string);
    }

    private boolean matchesGeneral(EnumContainer enumContainer, BlockPos blockPos, IBlockAccess iBlockAccess) {
        BiomeGenBase biomeGenBase;
        if (this.container != enumContainer) {
            return false;
        }
        if (this.biomes != null && !Matches.biome(biomeGenBase = iBlockAccess.getBiomeGenForCoords(blockPos), this.biomes)) {
            return false;
        }
        return this.heights == null || this.heights.isInRange(blockPos.getY());
    }

    public boolean matchesPos(EnumContainer enumContainer, BlockPos blockPos, IBlockAccess iBlockAccess, GuiScreen guiScreen) {
        String string;
        if (!this.matchesGeneral(enumContainer, blockPos, iBlockAccess)) {
            return false;
        }
        if (this.nbtName != null && !this.nbtName.matchesValue(string = CustomGuiProperties.getName(guiScreen))) {
            return false;
        }
        switch (enumContainer) {
            case BEACON: {
                return this.matchesBeacon(blockPos, iBlockAccess);
            }
            case CHEST: {
                return this.matchesChest(blockPos, iBlockAccess);
            }
            case DISPENSER: {
                return this.matchesDispenser(blockPos, iBlockAccess);
            }
        }
        return true;
    }

    public static String getName(GuiScreen guiScreen) {
        IWorldNameable iWorldNameable = CustomGuiProperties.getWorldNameable(guiScreen);
        return iWorldNameable == null ? null : iWorldNameable.getDisplayName().getUnformattedText();
    }

    private static IWorldNameable getWorldNameable(GuiScreen guiScreen) {
        return guiScreen instanceof GuiBeacon ? CustomGuiProperties.getWorldNameable(guiScreen, Reflector.GuiBeacon_tileBeacon) : (guiScreen instanceof GuiBrewingStand ? CustomGuiProperties.getWorldNameable(guiScreen, Reflector.GuiBrewingStand_tileBrewingStand) : (guiScreen instanceof GuiChest ? CustomGuiProperties.getWorldNameable(guiScreen, Reflector.GuiChest_lowerChestInventory) : (guiScreen instanceof GuiDispenser ? ((GuiDispenser)guiScreen).dispenserInventory : (guiScreen instanceof GuiEnchantment ? CustomGuiProperties.getWorldNameable(guiScreen, Reflector.GuiEnchantment_nameable) : (guiScreen instanceof GuiFurnace ? CustomGuiProperties.getWorldNameable(guiScreen, Reflector.GuiFurnace_tileFurnace) : (guiScreen instanceof GuiHopper ? CustomGuiProperties.getWorldNameable(guiScreen, Reflector.GuiHopper_hopperInventory) : null))))));
    }

    private static IWorldNameable getWorldNameable(GuiScreen guiScreen, ReflectorField reflectorField) {
        Object object = Reflector.getFieldValue(guiScreen, reflectorField);
        return !(object instanceof IWorldNameable) ? null : (IWorldNameable)object;
    }

    private boolean matchesBeacon(BlockPos blockPos, IBlockAccess iBlockAccess) {
        TileEntity tileEntity = iBlockAccess.getTileEntity(blockPos);
        if (!(tileEntity instanceof TileEntityBeacon)) {
            return false;
        }
        TileEntityBeacon tileEntityBeacon = (TileEntityBeacon)tileEntity;
        if (this.levels != null) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            tileEntityBeacon.writeToNBT(nBTTagCompound);
            int n = nBTTagCompound.getInteger("Levels");
            if (!this.levels.isInRange(n)) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesChest(BlockPos blockPos, IBlockAccess iBlockAccess) {
        TileEntity tileEntity = iBlockAccess.getTileEntity(blockPos);
        if (tileEntity instanceof TileEntityChest) {
            TileEntityChest tileEntityChest = (TileEntityChest)tileEntity;
            return this.matchesChest(tileEntityChest, blockPos, iBlockAccess);
        }
        if (tileEntity instanceof TileEntityEnderChest) {
            TileEntityEnderChest tileEntityEnderChest = (TileEntityEnderChest)tileEntity;
            return this.matchesEnderChest(tileEntityEnderChest, blockPos, iBlockAccess);
        }
        return false;
    }

    private boolean matchesChest(TileEntityChest tileEntityChest, BlockPos blockPos, IBlockAccess iBlockAccess) {
        boolean bl = tileEntityChest.adjacentChestXNeg != null || tileEntityChest.adjacentChestXPos != null || tileEntityChest.adjacentChestZNeg != null || tileEntityChest.adjacentChestZPos != null;
        boolean bl2 = tileEntityChest.getChestType() == 1;
        boolean bl3 = CustomGuis.isChristmas;
        boolean bl4 = false;
        return this.matchesChest(bl, bl2, bl3, bl4);
    }

    private boolean matchesEnderChest(TileEntityEnderChest tileEntityEnderChest, BlockPos blockPos, IBlockAccess iBlockAccess) {
        return this.matchesChest(false, false, false, true);
    }

    private boolean matchesChest(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return this.large != null && this.large != bl ? false : (this.trapped != null && this.trapped != bl2 ? false : (this.christmas != null && this.christmas != bl3 ? false : this.ender == null || this.ender == bl4));
    }

    private boolean matchesDispenser(BlockPos blockPos, IBlockAccess iBlockAccess) {
        EnumVariant enumVariant;
        TileEntity tileEntity = iBlockAccess.getTileEntity(blockPos);
        if (!(tileEntity instanceof TileEntityDispenser)) {
            return false;
        }
        TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)tileEntity;
        return this.variants == null || Config.equalsOne((Object)(enumVariant = this.getDispenserVariant(tileEntityDispenser)), (Object[])this.variants);
    }

    private EnumVariant getDispenserVariant(TileEntityDispenser tileEntityDispenser) {
        return tileEntityDispenser instanceof TileEntityDropper ? EnumVariant.DROPPER : EnumVariant.DISPENSER;
    }

    public boolean matchesEntity(EnumContainer enumContainer, Entity entity, IBlockAccess iBlockAccess) {
        String string;
        if (!this.matchesGeneral(enumContainer, entity.getPosition(), iBlockAccess)) {
            return false;
        }
        if (this.nbtName != null && !this.nbtName.matchesValue(string = entity.getName())) {
            return false;
        }
        switch (enumContainer) {
            case HORSE: {
                return this.matchesHorse(entity, iBlockAccess);
            }
            case VILLAGER: {
                return this.matchesVillager(entity, iBlockAccess);
            }
        }
        return true;
    }

    private boolean matchesVillager(Entity entity, IBlockAccess iBlockAccess) {
        if (!(entity instanceof EntityVillager)) {
            return false;
        }
        EntityVillager entityVillager = (EntityVillager)entity;
        if (this.professions != null) {
            int n = entityVillager.getProfession();
            int n2 = Reflector.getFieldValueInt(entityVillager, Reflector.EntityVillager_careerId, -1);
            if (n2 < 0) {
                return false;
            }
            boolean bl = false;
            for (int i = 0; i < this.professions.length; ++i) {
                VillagerProfession villagerProfession = this.professions[i];
                if (!villagerProfession.matches(n, n2)) continue;
                bl = true;
                break;
            }
            if (!bl) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesHorse(Entity entity, IBlockAccess iBlockAccess) {
        EnumVariant enumVariant;
        if (!(entity instanceof EntityHorse)) {
            return false;
        }
        EntityHorse entityHorse = (EntityHorse)entity;
        return this.variants == null || Config.equalsOne((Object)(enumVariant = this.getHorseVariant(entityHorse)), (Object[])this.variants);
    }

    private EnumVariant getHorseVariant(EntityHorse entityHorse) {
        int n = entityHorse.getHorseType();
        switch (n) {
            case 0: {
                return EnumVariant.HORSE;
            }
            case 1: {
                return EnumVariant.DONKEY;
            }
            case 2: {
                return EnumVariant.MULE;
            }
        }
        return null;
    }

    public EnumContainer getContainer() {
        return this.container;
    }

    public ResourceLocation getTextureLocation(ResourceLocation resourceLocation) {
        ResourceLocation resourceLocation2 = this.textureLocations.get(resourceLocation);
        return resourceLocation2 == null ? resourceLocation : resourceLocation2;
    }

    public String toString() {
        return "name: " + this.fileName + ", container: " + String.valueOf((Object)this.container) + ", textures: " + String.valueOf(this.textureLocations);
    }

    public static enum EnumContainer {
        ANVIL,
        BEACON,
        BREWING_STAND,
        CHEST,
        CRAFTING,
        DISPENSER,
        ENCHANTMENT,
        FURNACE,
        HOPPER,
        HORSE,
        VILLAGER,
        SHULKER_BOX,
        CREATIVE,
        INVENTORY;

        public static final EnumContainer[] VALUES;

        static {
            VALUES = EnumContainer.values();
        }
    }

    private static enum EnumVariant {
        HORSE,
        DONKEY,
        MULE,
        LLAMA,
        DISPENSER,
        DROPPER;

    }
}

