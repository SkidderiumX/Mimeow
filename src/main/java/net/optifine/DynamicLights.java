/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.optifine.DynamicLight;
import net.optifine.DynamicLightsMap;
import net.optifine.config.ConnectedParser;
import net.optifine.config.EntityClassLocator;
import net.optifine.config.IObjectLocator;
import net.optifine.config.ItemLocator;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.util.PropertiesOrdered;

public class DynamicLights {
    private static DynamicLightsMap mapDynamicLights = new DynamicLightsMap();
    private static Map<Class, Integer> mapEntityLightLevels = new HashMap<Class, Integer>();
    private static Map<Item, Integer> mapItemLightLevels = new HashMap<Item, Integer>();
    private static long timeUpdateMs = 0L;
    private static final double MAX_DIST = 7.5;
    private static final double MAX_DIST_SQ = 56.25;
    private static final int LIGHT_LEVEL_MAX = 15;
    private static final int LIGHT_LEVEL_FIRE = 15;
    private static final int LIGHT_LEVEL_BLAZE = 10;
    private static final int LIGHT_LEVEL_MAGMA_CUBE = 8;
    private static final int LIGHT_LEVEL_MAGMA_CUBE_CORE = 13;
    private static final int LIGHT_LEVEL_GLOWSTONE_DUST = 8;
    private static final int LIGHT_LEVEL_PRISMARINE_CRYSTALS = 8;
    private static boolean initialized;

    public static void entityAdded(Entity entity, RenderGlobal renderGlobal) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void entityRemoved(Entity entity, RenderGlobal renderGlobal) {
        DynamicLightsMap dynamicLightsMap = mapDynamicLights;
        synchronized (dynamicLightsMap) {
            DynamicLight dynamicLight = mapDynamicLights.remove(entity.getEntityId());
            if (dynamicLight != null) {
                dynamicLight.updateLitChunks(renderGlobal);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void update(RenderGlobal renderGlobal) {
        long l = System.currentTimeMillis();
        if (l >= timeUpdateMs + 50L) {
            timeUpdateMs = l;
            if (!initialized) {
                DynamicLights.initialize();
            }
            DynamicLightsMap dynamicLightsMap = mapDynamicLights;
            synchronized (dynamicLightsMap) {
                DynamicLights.updateMapDynamicLights(renderGlobal);
                if (mapDynamicLights.size() > 0) {
                    List<DynamicLight> list = mapDynamicLights.valueList();
                    for (int i = 0; i < list.size(); ++i) {
                        DynamicLight dynamicLight = list.get(i);
                        dynamicLight.update(renderGlobal);
                    }
                }
            }
        }
    }

    private static void initialize() {
        initialized = true;
        mapEntityLightLevels.clear();
        mapItemLightLevels.clear();
        String[] stringArray = ReflectorCompat.getCompatModIds();
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string, "optifine/dynamic_lights.properties");
                InputStream inputStream2 = Config.getResourceStream(resourceLocation);
                DynamicLights.loadModConfiguration(inputStream2, resourceLocation.toString(), string);
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        if (mapEntityLightLevels.size() > 0) {
            Config.dbg("DynamicLights entities: " + mapEntityLightLevels.size());
        }
        if (mapItemLightLevels.size() > 0) {
            Config.dbg("DynamicLights items: " + mapItemLightLevels.size());
        }
    }

    private static void loadModConfiguration(InputStream inputStream2, String string, String string2) {
        if (inputStream2 != null) {
            try {
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                Config.dbg("DynamicLights: Parsing " + string);
                ConnectedParser connectedParser = new ConnectedParser("DynamicLights");
                DynamicLights.loadModLightLevels(propertiesOrdered.getProperty("entities"), mapEntityLightLevels, new EntityClassLocator(), connectedParser, string, string2);
                DynamicLights.loadModLightLevels(propertiesOrdered.getProperty("items"), mapItemLightLevels, new ItemLocator(), connectedParser, string, string2);
            }
            catch (IOException iOException) {
                Config.warn("DynamicLights: Error reading " + string);
            }
        }
    }

    private static void loadModLightLevels(String string, Map map, IObjectLocator iObjectLocator, ConnectedParser connectedParser, String string2, String string3) {
        if (string != null) {
            String[] stringArray = Config.tokenize(string, " ");
            for (int i = 0; i < stringArray.length; ++i) {
                String string4 = stringArray[i];
                String[] stringArray2 = Config.tokenize(string4, ":");
                if (stringArray2.length != 2) {
                    connectedParser.warn("Invalid entry: " + string4 + ", in:" + string2);
                    continue;
                }
                String string5 = stringArray2[0];
                String string6 = stringArray2[1];
                String string7 = string3 + ":" + string5;
                ResourceLocation resourceLocation = new ResourceLocation(string7);
                Object object = iObjectLocator.getObject(resourceLocation);
                if (object == null) {
                    connectedParser.warn("Object not found: " + string7);
                    continue;
                }
                int n = connectedParser.parseInt(string6, -1);
                if (n >= 0 && n <= 15) {
                    map.put(object, new Integer(n));
                    continue;
                }
                connectedParser.warn("Invalid light level: " + string4);
            }
        }
    }

    private static void updateMapDynamicLights(RenderGlobal renderGlobal) {
        WorldClient worldClient = renderGlobal.getWorld();
        if (worldClient != null) {
            for (Entity entity : worldClient.getLoadedEntityList()) {
                DynamicLight dynamicLight;
                int n;
                int n2 = DynamicLights.getLightLevel(entity);
                if (n2 > 0) {
                    n = entity.getEntityId();
                    dynamicLight = mapDynamicLights.get(n);
                    if (dynamicLight != null) continue;
                    dynamicLight = new DynamicLight(entity);
                    mapDynamicLights.put(n, dynamicLight);
                    continue;
                }
                n = entity.getEntityId();
                dynamicLight = mapDynamicLights.remove(n);
                if (dynamicLight == null) continue;
                dynamicLight.updateLitChunks(renderGlobal);
            }
        }
    }

    public static int getCombinedLight(BlockPos blockPos, int n) {
        double d = DynamicLights.getLightLevel(blockPos);
        n = DynamicLights.getCombinedLight(d, n);
        return n;
    }

    public static int getCombinedLight(Entity entity, int n) {
        double d = DynamicLights.getLightLevel(entity);
        n = DynamicLights.getCombinedLight(d, n);
        return n;
    }

    public static int getCombinedLight(double d, int n) {
        int n2;
        int n3;
        if (d > 0.0 && (n3 = (int)(d * 16.0)) > (n2 = n & 0xFF)) {
            n &= 0xFFFFFF00;
            n |= n3;
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static double getLightLevel(BlockPos blockPos) {
        double d = 0.0;
        DynamicLightsMap dynamicLightsMap = mapDynamicLights;
        synchronized (dynamicLightsMap) {
            List<DynamicLight> list = mapDynamicLights.valueList();
            int n = list.size();
            for (int i = 0; i < n; ++i) {
                double d2;
                double d3;
                double d4;
                DynamicLight dynamicLight = list.get(i);
                int n2 = dynamicLight.getLastLightLevel();
                if (n2 <= 0) continue;
                double d5 = dynamicLight.getLastPosX();
                double d6 = dynamicLight.getLastPosY();
                double d7 = dynamicLight.getLastPosZ();
                double d8 = (double)blockPos.getX() - d5;
                double d9 = (double)blockPos.getY() - d6;
                double d10 = (double)blockPos.getZ() - d7;
                double d11 = d8 * d8 + d9 * d9 + d10 * d10;
                if (dynamicLight.isUnderwater() && !Config.isClearWater()) {
                    n2 = Config.limit(n2 - 2, 0, 15);
                    d11 *= 2.0;
                }
                if (!(d11 <= 56.25) || !((d4 = (d3 = 1.0 - (d2 = Math.sqrt(d11)) / 7.5) * (double)n2) > d)) continue;
                d = d4;
            }
        }
        double d12 = Config.limit(d, 0.0, 15.0);
        return d12;
    }

    public static int getLightLevel(ItemStack itemStack) {
        Object object;
        Block block;
        if (itemStack == null) {
            return 0;
        }
        Item item = itemStack.getItem();
        if (item instanceof ItemBlock && (block = ((ItemBlock)(object = (ItemBlock)item)).getBlock()) != null) {
            return block.getLightValue();
        }
        if (item == Items.lava_bucket) {
            return Blocks.lava.getLightValue();
        }
        if (item != Items.blaze_rod && item != Items.blaze_powder) {
            if (item == Items.glowstone_dust) {
                return 8;
            }
            if (item == Items.prismarine_crystals) {
                return 8;
            }
            if (item == Items.magma_cream) {
                return 8;
            }
            if (item == Items.nether_star) {
                return Blocks.beacon.getLightValue() / 2;
            }
            if (!mapItemLightLevels.isEmpty() && (object = mapItemLightLevels.get(item)) != null) {
                return (Integer)object;
            }
            return 0;
        }
        return 10;
    }

    public static int getLightLevel(Entity entity) {
        Object object;
        if (entity == Config.getMinecraft().getRenderViewEntity() && !Config.isDynamicHandLight()) {
            return 0;
        }
        if (entity instanceof EntityPlayer && ((EntityPlayer)(object = (EntityPlayer)entity)).isSpectator()) {
            return 0;
        }
        if (entity.isBurning()) {
            return 15;
        }
        if (!mapEntityLightLevels.isEmpty() && (object = mapEntityLightLevels.get(entity.getClass())) != null) {
            return (Integer)object;
        }
        if (entity instanceof EntityFireball) {
            return 15;
        }
        if (entity instanceof EntityTNTPrimed) {
            return 15;
        }
        if (entity instanceof EntityBlaze) {
            object = (EntityBlaze)entity;
            return ((EntityBlaze)object).func_70845_n() ? 15 : 10;
        }
        if (entity instanceof EntityMagmaCube) {
            object = (EntityMagmaCube)entity;
            return (double)((EntityMagmaCube)object).squishFactor > 0.6 ? 13 : 8;
        }
        if (entity instanceof EntityCreeper && (double)((EntityCreeper)(object = (EntityCreeper)entity)).getCreeperFlashIntensity(0.0f) > 0.001) {
            return 15;
        }
        if (entity instanceof EntityLivingBase) {
            object = (EntityLivingBase)entity;
            ItemStack itemStack = ((EntityLivingBase)object).getHeldItem();
            int n = DynamicLights.getLightLevel(itemStack);
            ItemStack itemStack2 = ((EntityLivingBase)object).getEquipmentInSlot(4);
            int n2 = DynamicLights.getLightLevel(itemStack2);
            return Math.max(n, n2);
        }
        if (entity instanceof EntityItem) {
            object = (EntityItem)entity;
            ItemStack itemStack = DynamicLights.getItemStack((EntityItem)object);
            return DynamicLights.getLightLevel(itemStack);
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeLights(RenderGlobal renderGlobal) {
        DynamicLightsMap dynamicLightsMap = mapDynamicLights;
        synchronized (dynamicLightsMap) {
            List<DynamicLight> list = mapDynamicLights.valueList();
            for (int i = 0; i < list.size(); ++i) {
                DynamicLight dynamicLight = list.get(i);
                dynamicLight.updateLitChunks(renderGlobal);
            }
            mapDynamicLights.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void clear() {
        DynamicLightsMap dynamicLightsMap = mapDynamicLights;
        synchronized (dynamicLightsMap) {
            mapDynamicLights.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int getCount() {
        DynamicLightsMap dynamicLightsMap = mapDynamicLights;
        synchronized (dynamicLightsMap) {
            return mapDynamicLights.size();
        }
    }

    public static ItemStack getItemStack(EntityItem entityItem) {
        ItemStack itemStack = entityItem.getDataWatcher().getWatchableObjectItemStack(10);
        return itemStack;
    }
}

