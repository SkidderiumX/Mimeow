/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.data;

import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.NamedSoundMappings1_13;
import com.viaversion.viaversion.util.Key;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class NamedSoundMappings1_12_2 {
    private static final Map<String, String> SOUNDS = new HashMap<String, String>();

    public static String getOldId(String string) {
        return SOUNDS.get(Key.stripMinecraftNamespace(string));
    }

    static {
        try {
            Field field = NamedSoundMappings1_13.class.getDeclaredField("oldToNew");
            field.setAccessible(true);
            Map map = (Map)field.get(null);
            map.forEach((string, string2) -> SOUNDS.put((String)string2, (String)string));
        }
        catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
        }
    }
}

