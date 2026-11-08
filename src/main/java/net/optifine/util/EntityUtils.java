/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.src.Config;

public class EntityUtils {
    private static final Map<Class, Integer> mapIdByClass = new HashMap<Class, Integer>();
    private static final Map<String, Integer> mapIdByName = new HashMap<String, Integer>();
    private static final Map<String, Class> mapClassByName = new HashMap<String, Class>();

    public static int getEntityIdByClass(Entity entity) {
        return entity == null ? -1 : EntityUtils.getEntityIdByClass(entity.getClass());
    }

    public static int getEntityIdByClass(Class clazz) {
        Integer n = mapIdByClass.get(clazz);
        return n == null ? -1 : n;
    }

    public static int getEntityIdByName(String string) {
        Integer n = mapIdByName.get(string);
        return n == null ? -1 : n;
    }

    public static Class getEntityClassByName(String string) {
        Class clazz = mapClassByName.get(string);
        return clazz;
    }

    static {
        for (int i = 0; i < 1000; ++i) {
            String string;
            Class<? extends Entity> clazz = EntityList.getClassFromID(i);
            if (clazz == null || (string = EntityList.getStringFromID(i)) == null) continue;
            if (mapIdByClass.containsKey(clazz)) {
                Config.warn("Duplicate entity class: " + String.valueOf(clazz) + ", id1: " + String.valueOf(mapIdByClass.get(clazz)) + ", id2: " + i);
            }
            if (mapIdByName.containsKey(string)) {
                Config.warn("Duplicate entity name: " + string + ", id1: " + String.valueOf(mapIdByName.get(string)) + ", id2: " + i);
            }
            if (mapClassByName.containsKey(string)) {
                Config.warn("Duplicate entity name: " + string + ", class1: " + String.valueOf(mapClassByName.get(string)) + ", class2: " + String.valueOf(clazz));
            }
            mapIdByClass.put(clazz, i);
            mapIdByName.put(string, i);
            mapClassByName.put(string, clazz);
        }
    }
}

