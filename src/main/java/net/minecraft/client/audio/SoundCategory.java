/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.audio;

import com.google.common.collect.Maps;
import java.util.Map;

public enum SoundCategory {
    MASTER("master", 0),
    MUSIC("music", 1),
    RECORDS("record", 2),
    WEATHER("weather", 3),
    BLOCKS("block", 4),
    MOBS("hostile", 5),
    ANIMALS("neutral", 6),
    PLAYERS("player", 7),
    AMBIENT("ambient", 8);

    private static final Map<String, SoundCategory> NAME_CATEGORY_MAP;
    private static final Map<Integer, SoundCategory> ID_CATEGORY_MAP;
    private final String categoryName;
    private final int categoryId;

    private SoundCategory(String string2, int n2) {
        this.categoryName = string2;
        this.categoryId = n2;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public static SoundCategory getCategory(String string) {
        return NAME_CATEGORY_MAP.get(string);
    }

    static {
        NAME_CATEGORY_MAP = Maps.newHashMap();
        ID_CATEGORY_MAP = Maps.newHashMap();
        for (SoundCategory soundCategory : SoundCategory.values()) {
            if (NAME_CATEGORY_MAP.containsKey(soundCategory.getCategoryName()) || ID_CATEGORY_MAP.containsKey(soundCategory.getCategoryId())) {
                throw new Error("Clash in Sound Category ID & Name pools! Cannot insert " + String.valueOf((Object)soundCategory));
            }
            NAME_CATEGORY_MAP.put(soundCategory.getCategoryName(), soundCategory);
            ID_CATEGORY_MAP.put(soundCategory.getCategoryId(), soundCategory);
        }
    }
}

