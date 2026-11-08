/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.io.CharStreams;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.BiMappings;
import com.viaversion.viaversion.api.data.Int2IntMapBiMappings;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.util.Int2IntBiHashMap;
import com.viaversion.viaversion.util.Key;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MappingData1_13
extends MappingDataBase {
    private final Map<String, int[]> blockTags = new HashMap<String, int[]>();
    private final Map<String, int[]> itemTags = new HashMap<String, int[]>();
    private final Map<String, int[]> fluidTags = new HashMap<String, int[]>();
    private final BiMap<Short, String> oldEnchantmentsIds = HashBiMap.create();
    private final Map<String, String> translateMapping = new HashMap<String, String>();
    private final Map<String, String> mojangTranslation = new HashMap<String, String>();
    private final BiMap<String, String> channelMappings = HashBiMap.create();

    public MappingData1_13() {
        super("1.12", "1.13");
    }

    @Override
    protected void loadExtras(CompoundTag compoundTag) {
        String[] stringArray;
        JsonObject jsonObject;
        this.loadTags(this.blockTags, compoundTag.getCompoundTag("block_tags"));
        this.loadTags(this.itemTags, compoundTag.getCompoundTag("item_tags"));
        this.loadTags(this.fluidTags, compoundTag.getCompoundTag("fluid_tags"));
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("legacy_enchantments");
        this.loadEnchantments(this.oldEnchantmentsIds, compoundTag2);
        if (Via.getConfig().isSnowCollisionFix()) {
            this.blockMappings.setNewId(1248, 3416);
        }
        if (Via.getConfig().isInfestedBlocksFix()) {
            this.blockMappings.setNewId(1552, 1);
            this.blockMappings.setNewId(1553, 14);
            this.blockMappings.setNewId(1554, 3983);
            this.blockMappings.setNewId(1555, 3984);
            this.blockMappings.setNewId(1556, 3985);
            this.blockMappings.setNewId(1557, 3986);
        }
        if ((jsonObject = MappingDataLoader.INSTANCE.loadFromDataDir("channelmappings-1.13.json")) != null) {
            for (Map.Entry<String, JsonElement> stringArray2 : jsonObject.entrySet()) {
                String string = stringArray2.getKey();
                String string2 = stringArray2.getValue().getAsString();
                if (!Key.isValid(string2)) {
                    this.getLogger().warning("Channel '" + string2 + "' is not a valid 1.13 plugin channel, please check your configuration!");
                    continue;
                }
                this.channelMappings.put(string, string2);
            }
        }
        try (InputStreamReader iOException = new InputStreamReader(MappingData1_13.class.getClassLoader().getResourceAsStream("assets/viaversion/data/mapping-lang-1.12-1.13.txt"), StandardCharsets.UTF_8);){
            stringArray = CharStreams.toString(iOException).split("\n");
        }
        catch (IOException iOException2) {
            throw new RuntimeException(iOException2);
        }
        for (String string : stringArray) {
            String string3;
            int n;
            if (string.endsWith("\r")) {
                string = string.substring(0, string.length() - 1);
            }
            if (string.isEmpty() || string.charAt(0) == '#' || (n = string.indexOf(61)) == -1) continue;
            String string4 = string.substring(n + 1);
            if (string.charAt(0) == '-') {
                this.mojangTranslation.put(string.substring(1, n), string4);
                continue;
            }
            int n2 = string.indexOf(62);
            if (n2 == -1 || n2 > n) {
                string3 = string.substring(0, n);
                this.mojangTranslation.put(string3, string4);
                this.translateMapping.put(string3, string3);
                continue;
            }
            string3 = string.substring(0, n2);
            this.mojangTranslation.put(string3, string4);
            this.translateMapping.put(string3, string.substring(n2 + 1, n));
        }
    }

    @Override
    protected @Nullable Mappings loadMappings(CompoundTag compoundTag, String string) {
        if (string.equals("blocks")) {
            return super.loadMappings(compoundTag, "blockstates");
        }
        if (string.equals("blockstates")) {
            return null;
        }
        return super.loadMappings(compoundTag, string);
    }

    @Override
    protected @Nullable BiMappings loadBiMappings(CompoundTag compoundTag, String string) {
        if (string.equals("items")) {
            return (BiMappings)MappingDataLoader.INSTANCE.loadMappings(compoundTag, "items", n -> {
                Int2IntBiHashMap int2IntBiHashMap = new Int2IntBiHashMap(n);
                int2IntBiHashMap.defaultReturnValue(-1);
                return int2IntBiHashMap;
            }, Int2IntBiHashMap::put, (int2IntBiHashMap, n) -> Int2IntMapBiMappings.of(int2IntBiHashMap));
        }
        return super.loadBiMappings(compoundTag, string);
    }

    public static String validateNewChannel(String string) {
        if (!Key.isValid(string)) {
            return null;
        }
        return Key.namespaced(string);
    }

    private void loadTags(Map<String, int[]> map, CompoundTag compoundTag) {
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            IntArrayTag intArrayTag = (IntArrayTag)entry.getValue();
            map.put(Key.namespaced(entry.getKey()), intArrayTag.getValue());
        }
    }

    private void loadEnchantments(Map<Short, String> map, CompoundTag compoundTag) {
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            map.put(Short.parseShort(entry.getKey()), ((StringTag)entry.getValue()).getValue());
        }
    }

    public Map<String, int[]> getBlockTags() {
        return this.blockTags;
    }

    public Map<String, int[]> getItemTags() {
        return this.itemTags;
    }

    public Map<String, int[]> getFluidTags() {
        return this.fluidTags;
    }

    public BiMap<Short, String> getOldEnchantmentsIds() {
        return this.oldEnchantmentsIds;
    }

    public Map<String, String> getTranslateMapping() {
        return this.translateMapping;
    }

    public Map<String, String> getMojangTranslation() {
        return this.mojangTranslation;
    }

    public BiMap<String, String> getChannelMappings() {
        return this.channelMappings;
    }
}

