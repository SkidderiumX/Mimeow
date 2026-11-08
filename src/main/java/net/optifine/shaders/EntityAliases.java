/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.config.ConnectedParser;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.shaders.IShaderPack;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.config.MacroProcessor;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.StrUtils;

public class EntityAliases {
    private static int[] entityAliases = null;
    private static boolean updateOnResourcesReloaded;

    public static int getEntityAliasId(int n) {
        if (entityAliases == null) {
            return -1;
        }
        if (n >= 0 && n < entityAliases.length) {
            int n2 = entityAliases[n];
            return n2;
        }
        return -1;
    }

    public static void resourcesReloaded() {
        if (updateOnResourcesReloaded) {
            updateOnResourcesReloaded = false;
            EntityAliases.update(Shaders.getShaderPack());
        }
    }

    public static void update(IShaderPack iShaderPack) {
        EntityAliases.reset();
        if (iShaderPack != null) {
            if (Reflector.Loader_getActiveModList.exists() && Config.getResourceManager() == null) {
                Config.dbg("[Shaders] Delayed loading of entity mappings after resources are loaded");
                updateOnResourcesReloaded = true;
            } else {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                String string = "/shaders/entity.properties";
                InputStream inputStream2 = iShaderPack.getResourceAsStream(string);
                if (inputStream2 != null) {
                    EntityAliases.loadEntityAliases(inputStream2, string, arrayList);
                }
                EntityAliases.loadModEntityAliases(arrayList);
                if (arrayList.size() > 0) {
                    entityAliases = EntityAliases.toArray(arrayList);
                }
            }
        }
    }

    private static void loadModEntityAliases(List<Integer> list) {
        String[] stringArray = ReflectorCompat.getCompatModIds();
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string, "shaders/entity.properties");
                InputStream inputStream2 = Config.getResourceStream(resourceLocation);
                EntityAliases.loadEntityAliases(inputStream2, resourceLocation.toString(), list);
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    private static void loadEntityAliases(InputStream inputStream2, String string, List<Integer> list) {
        if (inputStream2 != null) {
            try {
                inputStream2 = MacroProcessor.process(inputStream2, string);
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                Config.dbg("[Shaders] Parsing entity mappings: " + string);
                ConnectedParser connectedParser = new ConnectedParser("Shaders");
                for (Object object : ((Properties)propertiesOrdered).keySet()) {
                    String string2 = (String)object;
                    String string3 = propertiesOrdered.getProperty(string2);
                    String string4 = "entity.";
                    if (!string2.startsWith(string4)) {
                        Config.warn("[Shaders] Invalid entity ID: " + string2);
                        continue;
                    }
                    String string5 = StrUtils.removePrefix(string2, string4);
                    int n = Config.parseInt(string5, -1);
                    if (n < 0) {
                        Config.warn("[Shaders] Invalid entity alias ID: " + n);
                        continue;
                    }
                    int[] nArray = connectedParser.parseEntities(string3);
                    if (nArray != null && nArray.length >= 1) {
                        for (int i = 0; i < nArray.length; ++i) {
                            int n2 = nArray[i];
                            EntityAliases.addToList(list, n2, n);
                        }
                        continue;
                    }
                    Config.warn("[Shaders] Invalid entity ID mapping: " + string2 + "=" + string3);
                }
            }
            catch (IOException iOException) {
                Config.warn("[Shaders] Error reading: " + string);
            }
        }
    }

    private static void addToList(List<Integer> list, int n, int n2) {
        while (list.size() <= n) {
            list.add(-1);
        }
        list.set(n, n2);
    }

    private static int[] toArray(List<Integer> list) {
        int[] nArray = new int[list.size()];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = list.get(i);
        }
        return nArray;
    }

    public static void reset() {
        entityAliases = null;
    }
}

