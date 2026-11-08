/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.entity.Entity;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.optifine.CustomGuiProperties;
import net.optifine.override.PlayerControllerOF;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.ResUtils;

public class CustomGuis {
    private static Minecraft mc = Config.getMinecraft();
    private static PlayerControllerOF playerControllerOF = null;
    private static CustomGuiProperties[][] guiProperties = null;
    public static boolean isChristmas = CustomGuis.isChristmas();

    public static ResourceLocation getTextureLocation(ResourceLocation resourceLocation) {
        if (guiProperties == null) {
            return resourceLocation;
        }
        GuiScreen guiScreen = CustomGuis.mc.currentScreen;
        if (!(guiScreen instanceof GuiContainer)) {
            return resourceLocation;
        }
        if (resourceLocation.getResourceDomain().equals("minecraft") && resourceLocation.getResourcePath().startsWith("textures/gui/")) {
            Entity entity;
            if (playerControllerOF == null) {
                return resourceLocation;
            }
            WorldClient worldClient = CustomGuis.mc.theWorld;
            if (worldClient == null) {
                return resourceLocation;
            }
            if (guiScreen instanceof GuiContainerCreative) {
                return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.CREATIVE, CustomGuis.mc.thePlayer.getPosition(), worldClient, resourceLocation, guiScreen);
            }
            if (guiScreen instanceof GuiInventory) {
                return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.INVENTORY, CustomGuis.mc.thePlayer.getPosition(), worldClient, resourceLocation, guiScreen);
            }
            BlockPos blockPos = playerControllerOF.getLastClickBlockPos();
            if (blockPos != null) {
                if (guiScreen instanceof GuiRepair) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.ANVIL, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiBeacon) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.BEACON, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiBrewingStand) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.BREWING_STAND, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiChest) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.CHEST, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiCrafting) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.CRAFTING, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiDispenser) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.DISPENSER, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiEnchantment) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.ENCHANTMENT, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiFurnace) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.FURNACE, blockPos, worldClient, resourceLocation, guiScreen);
                }
                if (guiScreen instanceof GuiHopper) {
                    return CustomGuis.getTexturePos(CustomGuiProperties.EnumContainer.HOPPER, blockPos, worldClient, resourceLocation, guiScreen);
                }
            }
            if ((entity = playerControllerOF.getLastClickEntity()) != null) {
                if (guiScreen instanceof GuiScreenHorseInventory) {
                    return CustomGuis.getTextureEntity(CustomGuiProperties.EnumContainer.HORSE, entity, worldClient, resourceLocation);
                }
                if (guiScreen instanceof GuiMerchant) {
                    return CustomGuis.getTextureEntity(CustomGuiProperties.EnumContainer.VILLAGER, entity, worldClient, resourceLocation);
                }
            }
            return resourceLocation;
        }
        return resourceLocation;
    }

    private static ResourceLocation getTexturePos(CustomGuiProperties.EnumContainer enumContainer, BlockPos blockPos, IBlockAccess iBlockAccess, ResourceLocation resourceLocation, GuiScreen guiScreen) {
        CustomGuiProperties[] customGuiPropertiesArray = guiProperties[enumContainer.ordinal()];
        if (customGuiPropertiesArray == null) {
            return resourceLocation;
        }
        for (int i = 0; i < customGuiPropertiesArray.length; ++i) {
            CustomGuiProperties customGuiProperties = customGuiPropertiesArray[i];
            if (!customGuiProperties.matchesPos(enumContainer, blockPos, iBlockAccess, guiScreen)) continue;
            return customGuiProperties.getTextureLocation(resourceLocation);
        }
        return resourceLocation;
    }

    private static ResourceLocation getTextureEntity(CustomGuiProperties.EnumContainer enumContainer, Entity entity, IBlockAccess iBlockAccess, ResourceLocation resourceLocation) {
        CustomGuiProperties[] customGuiPropertiesArray = guiProperties[enumContainer.ordinal()];
        if (customGuiPropertiesArray == null) {
            return resourceLocation;
        }
        for (int i = 0; i < customGuiPropertiesArray.length; ++i) {
            CustomGuiProperties customGuiProperties = customGuiPropertiesArray[i];
            if (!customGuiProperties.matchesEntity(enumContainer, entity, iBlockAccess)) continue;
            return customGuiProperties.getTextureLocation(resourceLocation);
        }
        return resourceLocation;
    }

    public static void update() {
        guiProperties = null;
        if (Config.isCustomGuis()) {
            ArrayList<List<CustomGuiProperties>> arrayList = new ArrayList<List<CustomGuiProperties>>();
            IResourcePack[] iResourcePackArray = Config.getResourcePacks();
            for (int i = iResourcePackArray.length - 1; i >= 0; --i) {
                IResourcePack iResourcePack = iResourcePackArray[i];
                CustomGuis.update(iResourcePack, arrayList);
            }
            guiProperties = CustomGuis.propertyListToArray(arrayList);
        }
    }

    private static CustomGuiProperties[][] propertyListToArray(List<List<CustomGuiProperties>> list) {
        if (list.isEmpty()) {
            return null;
        }
        CustomGuiProperties[][] customGuiPropertiesArray = new CustomGuiProperties[CustomGuiProperties.EnumContainer.VALUES.length][];
        for (int i = 0; i < customGuiPropertiesArray.length; ++i) {
            List<CustomGuiProperties> list2;
            if (list.size() <= i || (list2 = list.get(i)) == null) continue;
            CustomGuiProperties[] customGuiPropertiesArray2 = list2.toArray(new CustomGuiProperties[list2.size()]);
            customGuiPropertiesArray[i] = customGuiPropertiesArray2;
        }
        return customGuiPropertiesArray;
    }

    private static void update(IResourcePack iResourcePack, List<List<CustomGuiProperties>> list) {
        String[] stringArray = ResUtils.collectFiles(iResourcePack, "optifine/gui/container/", ".properties", (String[])null);
        Arrays.sort(stringArray);
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            Config.dbg("CustomGuis: " + string);
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string);
                InputStream inputStream2 = iResourcePack.getInputStream(resourceLocation);
                if (inputStream2 == null) {
                    Config.warn("CustomGuis file not found: " + string);
                    continue;
                }
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                CustomGuiProperties customGuiProperties = new CustomGuiProperties(propertiesOrdered, string);
                if (!customGuiProperties.isValid(string)) continue;
                CustomGuis.addToList(customGuiProperties, list);
                continue;
            }
            catch (FileNotFoundException fileNotFoundException) {
                Config.warn("CustomGuis file not found: " + string);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private static void addToList(CustomGuiProperties customGuiProperties, List<List<CustomGuiProperties>> list) {
        if (customGuiProperties.getContainer() == null) {
            CustomGuis.warn("Invalid container: " + String.valueOf((Object)customGuiProperties.getContainer()));
        } else {
            int n = customGuiProperties.getContainer().ordinal();
            while (list.size() <= n) {
                list.add(null);
            }
            List<CustomGuiProperties> list2 = list.get(n);
            if (list2 == null) {
                list2 = new ArrayList<CustomGuiProperties>();
                list.set(n, list2);
            }
            list2.add(customGuiProperties);
        }
    }

    public static PlayerControllerOF getPlayerControllerOF() {
        return playerControllerOF;
    }

    public static void setPlayerControllerOF(PlayerControllerOF playerControllerOF) {
    }

    private static boolean isChristmas() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26;
    }

    private static void warn(String string) {
        Config.warn("[CustomGuis] " + string);
    }
}

