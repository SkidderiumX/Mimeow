/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.ArrayList;
import java.util.Properties;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.IRandomEntity;
import net.optifine.RandomEntityRule;
import net.optifine.config.ConnectedParser;

public class RandomEntityProperties {
    public String name = null;
    public String basePath = null;
    public ResourceLocation[] resourceLocations = null;
    public RandomEntityRule[] rules = null;

    public RandomEntityProperties(String string, ResourceLocation[] resourceLocationArray) {
        ConnectedParser connectedParser = new ConnectedParser("RandomEntities");
        this.name = connectedParser.parseName(string);
        this.basePath = connectedParser.parseBasePath(string);
        this.resourceLocations = resourceLocationArray;
    }

    public RandomEntityProperties(Properties properties, String string, ResourceLocation resourceLocation) {
        ConnectedParser connectedParser = new ConnectedParser("RandomEntities");
        this.name = connectedParser.parseName(string);
        this.basePath = connectedParser.parseBasePath(string);
        this.rules = this.parseRules(properties, string, resourceLocation, connectedParser);
    }

    public ResourceLocation getTextureLocation(ResourceLocation resourceLocation, IRandomEntity iRandomEntity) {
        int n;
        if (this.rules != null) {
            for (n = 0; n < this.rules.length; ++n) {
                RandomEntityRule randomEntityRule = this.rules[n];
                if (!randomEntityRule.matches(iRandomEntity)) continue;
                return randomEntityRule.getTextureLocation(resourceLocation, iRandomEntity.getId());
            }
        }
        if (this.resourceLocations != null) {
            n = iRandomEntity.getId();
            int n2 = n % this.resourceLocations.length;
            return this.resourceLocations[n2];
        }
        return resourceLocation;
    }

    private RandomEntityRule[] parseRules(Properties properties, String string, ResourceLocation resourceLocation, ConnectedParser connectedParser) {
        ArrayList<RandomEntityRule> arrayList = new ArrayList<RandomEntityRule>();
        int n = properties.size();
        for (int i = 0; i < n; ++i) {
            RandomEntityRule randomEntityRule;
            int n2 = i + 1;
            String string2 = properties.getProperty("textures." + n2);
            if (string2 == null) {
                string2 = properties.getProperty("skins." + n2);
            }
            if (string2 == null || !(randomEntityRule = new RandomEntityRule(properties, string, resourceLocation, n2, string2, connectedParser)).isValid(string)) continue;
            arrayList.add(randomEntityRule);
        }
        RandomEntityRule[] randomEntityRuleArray = arrayList.toArray(new RandomEntityRule[arrayList.size()]);
        return randomEntityRuleArray;
    }

    public boolean isValid(String string) {
        Object object;
        int n;
        if (this.resourceLocations == null && this.rules == null) {
            Config.warn("No skins specified: " + string);
            return false;
        }
        if (this.rules != null) {
            for (n = 0; n < this.rules.length; ++n) {
                object = this.rules[n];
                if (((RandomEntityRule)object).isValid(string)) continue;
                return false;
            }
        }
        if (this.resourceLocations != null) {
            for (n = 0; n < this.resourceLocations.length; ++n) {
                object = this.resourceLocations[n];
                if (Config.hasResource((ResourceLocation)object)) continue;
                Config.warn("Texture not found: " + ((ResourceLocation)object).getResourcePath());
                return false;
            }
        }
        return true;
    }

    public boolean isDefault() {
        return this.rules != null ? false : this.resourceLocations == null;
    }
}

