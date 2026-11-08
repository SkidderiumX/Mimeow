/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.Properties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.IRandomEntity;
import net.optifine.RandomEntities;
import net.optifine.RandomEntity;
import net.optifine.config.ConnectedParser;
import net.optifine.config.Matches;
import net.optifine.config.NbtTagValue;
import net.optifine.config.RangeInt;
import net.optifine.config.RangeListInt;
import net.optifine.config.VillagerProfession;
import net.optifine.config.Weather;
import net.optifine.reflect.Reflector;
import net.optifine.util.ArrayUtils;
import net.optifine.util.MathUtils;

public class RandomEntityRule {
    private String pathProps = null;
    private ResourceLocation baseResLoc = null;
    private int index;
    private int[] textures = null;
    private ResourceLocation[] resourceLocations = null;
    private int[] weights = null;
    private BiomeGenBase[] biomes = null;
    private RangeListInt heights = null;
    private RangeListInt healthRange = null;
    private boolean healthPercent = false;
    private NbtTagValue nbtName = null;
    public int[] sumWeights = null;
    public int sumAllWeights = 1;
    private VillagerProfession[] professions = null;
    private EnumDyeColor[] collarColors = null;
    private Boolean baby = null;
    private RangeListInt moonPhases = null;
    private RangeListInt dayTimes = null;
    private Weather[] weatherList = null;

    public RandomEntityRule(Properties properties, String string, ResourceLocation resourceLocation, int n, String string2, ConnectedParser connectedParser) {
        String string3;
        this.pathProps = string;
        this.baseResLoc = resourceLocation;
        this.index = n;
        this.textures = connectedParser.parseIntList(string2);
        this.weights = connectedParser.parseIntList(properties.getProperty("weights." + n));
        this.biomes = connectedParser.parseBiomes(properties.getProperty("biomes." + n));
        this.heights = connectedParser.parseRangeListInt(properties.getProperty("heights." + n));
        if (this.heights == null) {
            this.heights = this.parseMinMaxHeight(properties, n);
        }
        if ((string3 = properties.getProperty("health." + n)) != null) {
            this.healthPercent = string3.contains("%");
            string3 = string3.replace("%", "");
            this.healthRange = connectedParser.parseRangeListInt(string3);
        }
        this.nbtName = connectedParser.parseNbtTagValue("name", properties.getProperty("name." + n));
        this.professions = connectedParser.parseProfessions(properties.getProperty("professions." + n));
        this.collarColors = connectedParser.parseDyeColors(properties.getProperty("collarColors." + n), "collar color", ConnectedParser.DYE_COLORS_INVALID);
        this.baby = connectedParser.parseBooleanObject(properties.getProperty("baby." + n));
        this.moonPhases = connectedParser.parseRangeListInt(properties.getProperty("moonPhase." + n));
        this.dayTimes = connectedParser.parseRangeListInt(properties.getProperty("dayTime." + n));
        this.weatherList = connectedParser.parseWeather(properties.getProperty("weather." + n), "weather." + n, null);
    }

    private RangeListInt parseMinMaxHeight(Properties properties, int n) {
        String string = properties.getProperty("minHeight." + n);
        String string2 = properties.getProperty("maxHeight." + n);
        if (string == null && string2 == null) {
            return null;
        }
        int n2 = 0;
        if (string != null && (n2 = Config.parseInt(string, -1)) < 0) {
            Config.warn("Invalid minHeight: " + string);
            return null;
        }
        int n3 = 256;
        if (string2 != null && (n3 = Config.parseInt(string2, -1)) < 0) {
            Config.warn("Invalid maxHeight: " + string2);
            return null;
        }
        if (n3 < 0) {
            Config.warn("Invalid minHeight, maxHeight: " + string + ", " + string2);
            return null;
        }
        RangeListInt rangeListInt = new RangeListInt();
        rangeListInt.addRange(new RangeInt(n2, n3));
        return rangeListInt;
    }

    public boolean isValid(String string) {
        if (this.textures != null && this.textures.length != 0) {
            int n;
            int n2;
            if (this.resourceLocations != null) {
                return true;
            }
            this.resourceLocations = new ResourceLocation[this.textures.length];
            boolean bl = this.pathProps.startsWith("mcpatcher/mob/");
            ResourceLocation resourceLocation = RandomEntities.getLocationRandom(this.baseResLoc, bl);
            if (resourceLocation == null) {
                Config.warn("Invalid path: " + this.baseResLoc.getResourcePath());
                return false;
            }
            for (n2 = 0; n2 < this.resourceLocations.length; ++n2) {
                n = this.textures[n2];
                if (n <= 1) {
                    this.resourceLocations[n2] = this.baseResLoc;
                    continue;
                }
                ResourceLocation resourceLocation2 = RandomEntities.getLocationIndexed(resourceLocation, n);
                if (resourceLocation2 == null) {
                    Config.warn("Invalid path: " + this.baseResLoc.getResourcePath());
                    return false;
                }
                if (!Config.hasResource(resourceLocation2)) {
                    Config.warn("Texture not found: " + resourceLocation2.getResourcePath());
                    return false;
                }
                this.resourceLocations[n2] = resourceLocation2;
            }
            if (this.weights != null) {
                if (this.weights.length > this.resourceLocations.length) {
                    Config.warn("More weights defined than skins, trimming weights: " + string);
                    int[] nArray = new int[this.resourceLocations.length];
                    System.arraycopy(this.weights, 0, nArray, 0, nArray.length);
                    this.weights = nArray;
                }
                if (this.weights.length < this.resourceLocations.length) {
                    Config.warn("Less weights defined than skins, expanding weights: " + string);
                    int[] nArray = new int[this.resourceLocations.length];
                    System.arraycopy(this.weights, 0, nArray, 0, this.weights.length);
                    n = MathUtils.getAverage(this.weights);
                    for (int i = this.weights.length; i < nArray.length; ++i) {
                        nArray[i] = n;
                    }
                    this.weights = nArray;
                }
                this.sumWeights = new int[this.weights.length];
                n2 = 0;
                for (n = 0; n < this.weights.length; ++n) {
                    if (this.weights[n] < 0) {
                        Config.warn("Invalid weight: " + this.weights[n]);
                        return false;
                    }
                    this.sumWeights[n] = n2 += this.weights[n];
                }
                this.sumAllWeights = n2;
                if (this.sumAllWeights <= 0) {
                    Config.warn("Invalid sum of all weights: " + n2);
                    this.sumAllWeights = 1;
                }
            }
            if (this.professions == ConnectedParser.PROFESSIONS_INVALID) {
                Config.warn("Invalid professions or careers: " + string);
                return false;
            }
            if (this.collarColors == ConnectedParser.DYE_COLORS_INVALID) {
                Config.warn("Invalid collar colors: " + string);
                return false;
            }
            return true;
        }
        Config.warn("Invalid skins for rule: " + this.index);
        return false;
    }

    public boolean matches(IRandomEntity iRandomEntity) {
        Weather weather;
        Entity entity;
        Entity entity2;
        EntityLiving entityLiving;
        Entity entity3;
        int n;
        Object object;
        if (this.biomes != null && !Matches.biome(iRandomEntity.getSpawnBiome(), this.biomes)) {
            return false;
        }
        if (this.heights != null && (object = iRandomEntity.getSpawnPosition()) != null && !this.heights.isInRange(((Vec3i)object).getY())) {
            return false;
        }
        if (this.healthRange != null) {
            int n2 = iRandomEntity.getHealth();
            if (this.healthPercent && (n = iRandomEntity.getMaxHealth()) > 0) {
                n2 = (int)((double)(n2 * 100) / (double)n);
            }
            if (!this.healthRange.isInRange(n2)) {
                return false;
            }
        }
        if (this.nbtName != null && !this.nbtName.matchesValue((String)(object = iRandomEntity.getName()))) {
            return false;
        }
        if (this.professions != null && iRandomEntity instanceof RandomEntity && (entity3 = ((RandomEntity)(object = (RandomEntity)iRandomEntity)).getEntity()) instanceof EntityVillager) {
            entityLiving = (EntityVillager)entity3;
            int n3 = ((EntityVillager)entityLiving).getProfession();
            int n4 = Reflector.getFieldValueInt(entityLiving, Reflector.EntityVillager_careerId, -1);
            if (n3 < 0 || n4 < 0) {
                return false;
            }
            boolean bl = false;
            for (int i = 0; i < this.professions.length; ++i) {
                VillagerProfession villagerProfession = this.professions[i];
                if (!villagerProfession.matches(n3, n4)) continue;
                bl = true;
                break;
            }
            if (!bl) {
                return false;
            }
        }
        if (this.collarColors != null && iRandomEntity instanceof RandomEntity && (entity2 = ((RandomEntity)(object = (RandomEntity)iRandomEntity)).getEntity()) instanceof EntityWolf) {
            entityLiving = (EntityWolf)entity2;
            if (!((EntityTameable)entityLiving).isTamed()) {
                return false;
            }
            EnumDyeColor enumDyeColor = ((EntityWolf)entityLiving).getCollarColor();
            if (!Config.equalsOne(enumDyeColor, this.collarColors)) {
                return false;
            }
        }
        if (this.baby != null && iRandomEntity instanceof RandomEntity && (entity = ((RandomEntity)(object = (RandomEntity)iRandomEntity)).getEntity()) instanceof EntityLiving && (entityLiving = (EntityLiving)entity).isChild() != this.baby.booleanValue()) {
            return false;
        }
        if (this.moonPhases != null && (object = Config.getMinecraft().theWorld) != null && !this.moonPhases.isInRange(n = ((World)object).getMoonPhase())) {
            return false;
        }
        if (this.dayTimes != null && (object = Config.getMinecraft().theWorld) != null && !this.dayTimes.isInRange(n = (int)((World)object).getWorldInfo().getWorldTime())) {
            return false;
        }
        return this.weatherList == null || (object = Config.getMinecraft().theWorld) == null || ArrayUtils.contains((Object[])this.weatherList, (Object)(weather = Weather.getWeather((World)object, 0.0f)));
    }

    public ResourceLocation getTextureLocation(ResourceLocation resourceLocation, int n) {
        if (this.resourceLocations != null && this.resourceLocations.length != 0) {
            int n2 = 0;
            if (this.weights == null) {
                n2 = n % this.resourceLocations.length;
            } else {
                int n3 = n % this.sumAllWeights;
                for (int i = 0; i < this.sumWeights.length; ++i) {
                    if (this.sumWeights[i] <= n3) continue;
                    n2 = i;
                    break;
                }
            }
            return this.resourceLocations[n2];
        }
        return resourceLocation;
    }
}

