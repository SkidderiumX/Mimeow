/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.optifine.IRandomEntity;
import net.optifine.RandomEntity;
import net.optifine.RandomEntityProperties;
import net.optifine.RandomTileEntity;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorRaw;
import net.optifine.util.IntegratedServerUtils;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.ResUtils;
import net.optifine.util.StrUtils;

public class RandomEntities {
    private static Map<String, RandomEntityProperties> mapProperties = new HashMap<String, RandomEntityProperties>();
    private static boolean active = false;
    private static RenderGlobal renderGlobal;
    private static RandomEntity randomEntity;
    private static TileEntityRendererDispatcher tileEntityRendererDispatcher;
    private static RandomTileEntity randomTileEntity;
    private static boolean working;
    public static final String SUFFIX_PNG = ".png";
    public static final String SUFFIX_PROPERTIES = ".properties";
    public static final String PREFIX_TEXTURES_ENTITY = "textures/entity/";
    public static final String PREFIX_TEXTURES_PAINTING = "textures/painting/";
    public static final String PREFIX_TEXTURES = "textures/";
    public static final String PREFIX_OPTIFINE_RANDOM = "optifine/random/";
    public static final String PREFIX_MCPATCHER_MOB = "mcpatcher/mob/";
    private static final String[] DEPENDANT_SUFFIXES;
    private static final String PREFIX_DYNAMIC_TEXTURE_HORSE = "horse/";
    private static final String[] HORSE_TEXTURES;
    private static final String[] HORSE_TEXTURES_ABBR;

    public static void entityLoaded(Entity entity, World world2) {
        if (world2 != null) {
            DataWatcher dataWatcher = entity.getDataWatcher();
            dataWatcher.spawnPosition = entity.getPosition();
            dataWatcher.spawnBiome = world2.getBiomeGenForCoords(dataWatcher.spawnPosition);
            UUID uUID = entity.getUniqueID();
            if (entity instanceof EntityVillager) {
                RandomEntities.updateEntityVillager(uUID, (EntityVillager)entity);
            }
        }
    }

    public static void entityUnloaded(Entity entity, World world2) {
    }

    private static void updateEntityVillager(UUID uUID, EntityVillager entityVillager) {
        Entity entity = IntegratedServerUtils.getEntity(uUID);
        if (entity instanceof EntityVillager) {
            EntityVillager entityVillager2 = (EntityVillager)entity;
            int n = entityVillager2.getProfession();
            entityVillager.setProfession(n);
            int n2 = Reflector.getFieldValueInt(entityVillager2, Reflector.EntityVillager_careerId, 0);
            Reflector.setFieldValueInt(entityVillager, Reflector.EntityVillager_careerId, n2);
            int n3 = Reflector.getFieldValueInt(entityVillager2, Reflector.EntityVillager_careerLevel, 0);
            Reflector.setFieldValueInt(entityVillager, Reflector.EntityVillager_careerLevel, n3);
        }
    }

    public static void worldChanged(World world2, World world3) {
        if (world3 != null) {
            List<Entity> list = world3.getLoadedEntityList();
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = list.get(i);
                RandomEntities.entityLoaded(entity, world3);
            }
        }
        randomEntity.setEntity(null);
        randomTileEntity.setTileEntity(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ResourceLocation getTextureLocation(ResourceLocation resourceLocation) {
        ResourceLocation resourceLocation2;
        if (!active) {
            return resourceLocation;
        }
        if (working) {
            return resourceLocation;
        }
        try {
            working = true;
            IRandomEntity iRandomEntity = RandomEntities.getRandomEntityRendered();
            if (iRandomEntity != null) {
                ResourceLocation resourceLocation3;
                String string = resourceLocation.getResourcePath();
                if (string.startsWith(PREFIX_DYNAMIC_TEXTURE_HORSE)) {
                    string = RandomEntities.getHorseTexturePath(string, PREFIX_DYNAMIC_TEXTURE_HORSE.length());
                }
                if (!string.startsWith(PREFIX_TEXTURES_ENTITY) && !string.startsWith(PREFIX_TEXTURES_PAINTING)) {
                    ResourceLocation resourceLocation4;
                    ResourceLocation resourceLocation5 = resourceLocation4 = resourceLocation;
                    return resourceLocation5;
                }
                RandomEntityProperties randomEntityProperties = mapProperties.get(string);
                if (randomEntityProperties == null) {
                    ResourceLocation resourceLocation6;
                    ResourceLocation resourceLocation7 = resourceLocation6 = resourceLocation;
                    return resourceLocation7;
                }
                ResourceLocation resourceLocation8 = resourceLocation3 = randomEntityProperties.getTextureLocation(resourceLocation, iRandomEntity);
                return resourceLocation8;
            }
            resourceLocation2 = resourceLocation;
        }
        finally {
            working = false;
        }
        return resourceLocation2;
    }

    private static String getHorseTexturePath(String string, int n) {
        if (HORSE_TEXTURES != null && HORSE_TEXTURES_ABBR != null) {
            for (int i = 0; i < HORSE_TEXTURES_ABBR.length; ++i) {
                String string2 = HORSE_TEXTURES_ABBR[i];
                if (!string.startsWith(string2, n)) continue;
                return HORSE_TEXTURES[i];
            }
            return string;
        }
        return string;
    }

    private static IRandomEntity getRandomEntityRendered() {
        TileEntity tileEntity;
        if (RandomEntities.renderGlobal.renderedEntity != null) {
            randomEntity.setEntity(RandomEntities.renderGlobal.renderedEntity);
            return randomEntity;
        }
        if (RandomEntities.tileEntityRendererDispatcher.tileEntityRendered != null && (tileEntity = RandomEntities.tileEntityRendererDispatcher.tileEntityRendered).getWorld() != null) {
            randomTileEntity.setTileEntity(tileEntity);
            return randomTileEntity;
        }
        return null;
    }

    private static RandomEntityProperties makeProperties(ResourceLocation resourceLocation, boolean bl) {
        ResourceLocation[] resourceLocationArray;
        String string = resourceLocation.getResourcePath();
        ResourceLocation resourceLocation2 = RandomEntities.getLocationProperties(resourceLocation, bl);
        if (resourceLocation2 != null && (resourceLocationArray = RandomEntities.parseProperties(resourceLocation2, resourceLocation)) != null) {
            return resourceLocationArray;
        }
        resourceLocationArray = RandomEntities.getLocationsVariants(resourceLocation, bl);
        return resourceLocationArray == null ? null : new RandomEntityProperties(string, resourceLocationArray);
    }

    private static RandomEntityProperties parseProperties(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        try {
            String string = resourceLocation.getResourcePath();
            RandomEntities.dbg(resourceLocation2.getResourcePath() + ", properties: " + string);
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                RandomEntities.warn("Properties not found: " + string);
                return null;
            }
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
            RandomEntityProperties randomEntityProperties = new RandomEntityProperties(propertiesOrdered, string, resourceLocation2);
            return !randomEntityProperties.isValid(string) ? null : randomEntityProperties;
        }
        catch (FileNotFoundException fileNotFoundException) {
            RandomEntities.warn("File not found: " + resourceLocation2.getResourcePath());
            return null;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    private static ResourceLocation getLocationProperties(ResourceLocation resourceLocation, boolean bl) {
        String string;
        String string2;
        String string3;
        ResourceLocation resourceLocation2 = RandomEntities.getLocationRandom(resourceLocation, bl);
        if (resourceLocation2 == null) {
            return null;
        }
        String string4 = resourceLocation2.getResourceDomain();
        ResourceLocation resourceLocation3 = new ResourceLocation(string4, string3 = (string2 = StrUtils.removeSuffix(string = resourceLocation2.getResourcePath(), SUFFIX_PNG)) + SUFFIX_PROPERTIES);
        if (Config.hasResource(resourceLocation3)) {
            return resourceLocation3;
        }
        String string5 = RandomEntities.getParentTexturePath(string2);
        if (string5 == null) {
            return null;
        }
        ResourceLocation resourceLocation4 = new ResourceLocation(string4, string5 + SUFFIX_PROPERTIES);
        return Config.hasResource(resourceLocation4) ? resourceLocation4 : null;
    }

    protected static ResourceLocation getLocationRandom(ResourceLocation resourceLocation, boolean bl) {
        String string = resourceLocation.getResourceDomain();
        String string2 = resourceLocation.getResourcePath();
        String string3 = PREFIX_TEXTURES;
        String string4 = PREFIX_OPTIFINE_RANDOM;
        if (bl) {
            string3 = PREFIX_TEXTURES_ENTITY;
            string4 = PREFIX_MCPATCHER_MOB;
        }
        if (!string2.startsWith(string3)) {
            return null;
        }
        String string5 = StrUtils.replacePrefix(string2, string3, string4);
        return new ResourceLocation(string, string5);
    }

    private static String getPathBase(String string) {
        return string.startsWith(PREFIX_OPTIFINE_RANDOM) ? StrUtils.replacePrefix(string, PREFIX_OPTIFINE_RANDOM, PREFIX_TEXTURES) : (string.startsWith(PREFIX_MCPATCHER_MOB) ? StrUtils.replacePrefix(string, PREFIX_MCPATCHER_MOB, PREFIX_TEXTURES_ENTITY) : null);
    }

    protected static ResourceLocation getLocationIndexed(ResourceLocation resourceLocation, int n) {
        if (resourceLocation == null) {
            return null;
        }
        String string = resourceLocation.getResourcePath();
        int n2 = string.lastIndexOf(46);
        if (n2 < 0) {
            return null;
        }
        String string2 = string.substring(0, n2);
        String string3 = string.substring(n2);
        String string4 = string2 + n + string3;
        ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), string4);
        return resourceLocation2;
    }

    private static String getParentTexturePath(String string) {
        for (int i = 0; i < DEPENDANT_SUFFIXES.length; ++i) {
            String string2 = DEPENDANT_SUFFIXES[i];
            if (!string.endsWith(string2)) continue;
            String string3 = StrUtils.removeSuffix(string, string2);
            return string3;
        }
        return null;
    }

    private static ResourceLocation[] getLocationsVariants(ResourceLocation resourceLocation, boolean bl) {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        arrayList.add(resourceLocation);
        ResourceLocation resourceLocation2 = RandomEntities.getLocationRandom(resourceLocation, bl);
        if (resourceLocation2 == null) {
            return null;
        }
        for (int i = 1; i < arrayList.size() + 10; ++i) {
            int n = i + 1;
            ResourceLocation resourceLocation3 = RandomEntities.getLocationIndexed(resourceLocation2, n);
            if (!Config.hasResource(resourceLocation3)) continue;
            arrayList.add(resourceLocation3);
        }
        if (arrayList.size() <= 1) {
            return null;
        }
        ResourceLocation[] resourceLocationArray = arrayList.toArray(new ResourceLocation[arrayList.size()]);
        RandomEntities.dbg(resourceLocation.getResourcePath() + ", variants: " + resourceLocationArray.length);
        return resourceLocationArray;
    }

    public static void update() {
        mapProperties.clear();
        active = false;
        if (Config.isRandomEntities()) {
            RandomEntities.initialize();
        }
    }

    private static void initialize() {
        renderGlobal = Config.getRenderGlobal();
        tileEntityRendererDispatcher = TileEntityRendererDispatcher.instance;
        String[] stringArray = new String[]{PREFIX_OPTIFINE_RANDOM, PREFIX_MCPATCHER_MOB};
        String[] stringArray2 = new String[]{SUFFIX_PNG, SUFFIX_PROPERTIES};
        String[] stringArray3 = ResUtils.collectFiles(stringArray, stringArray2);
        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < stringArray3.length; ++i) {
            RandomEntityProperties randomEntityProperties;
            Object object = stringArray3[i];
            object = StrUtils.removeSuffix((String)object, stringArray2);
            object = StrUtils.trimTrailing((String)object, "0123456789");
            String string = RandomEntities.getPathBase((String)(object = (String)object + SUFFIX_PNG));
            if (hashSet.contains(string)) continue;
            hashSet.add(string);
            ResourceLocation resourceLocation = new ResourceLocation(string);
            if (!Config.hasResource(resourceLocation) || (randomEntityProperties = mapProperties.get(string)) != null) continue;
            randomEntityProperties = RandomEntities.makeProperties(resourceLocation, false);
            if (randomEntityProperties == null) {
                randomEntityProperties = RandomEntities.makeProperties(resourceLocation, true);
            }
            if (randomEntityProperties == null) continue;
            mapProperties.put(string, randomEntityProperties);
        }
        active = !mapProperties.isEmpty();
    }

    public static void dbg(String string) {
        Config.dbg("RandomEntities: " + string);
    }

    public static void warn(String string) {
        Config.warn("RandomEntities: " + string);
    }

    static {
        randomEntity = new RandomEntity();
        randomTileEntity = new RandomTileEntity();
        working = false;
        DEPENDANT_SUFFIXES = new String[]{"_armor", "_eyes", "_exploding", "_shooting", "_fur", "_eyes", "_invulnerable", "_angry", "_tame", "_collar"};
        HORSE_TEXTURES = (String[])ReflectorRaw.getFieldValue(null, EntityHorse.class, String[].class, 2);
        HORSE_TEXTURES_ABBR = (String[])ReflectorRaw.getFieldValue(null, EntityHorse.class, String[].class, 3);
    }
}

