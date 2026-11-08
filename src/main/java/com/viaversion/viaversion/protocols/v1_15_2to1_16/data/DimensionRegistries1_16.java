/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_15_2to1_16.data;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.StringTag;
import java.util.Arrays;

public class DimensionRegistries1_16 {
    private static final CompoundTag DIMENSIONS_TAG = new CompoundTag();
    private static final String[] WORLD_NAMES = new String[]{"minecraft:overworld", "minecraft:the_nether", "minecraft:the_end"};

    public static CompoundTag getDimensionsTag() {
        return DIMENSIONS_TAG.copy();
    }

    public static String[] getWorldNames() {
        return Arrays.copyOf(WORLD_NAMES, WORLD_NAMES.length);
    }

    private static CompoundTag createOverworldEntry() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("name", new StringTag("minecraft:overworld"));
        compoundTag.put("has_ceiling", new ByteTag(0));
        DimensionRegistries1_16.addSharedOverwaldEntries(compoundTag);
        return compoundTag;
    }

    private static CompoundTag createOverworldCavesEntry() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("name", new StringTag("minecraft:overworld_caves"));
        compoundTag.put("has_ceiling", new ByteTag(1));
        DimensionRegistries1_16.addSharedOverwaldEntries(compoundTag);
        return compoundTag;
    }

    private static void addSharedOverwaldEntries(CompoundTag compoundTag) {
        compoundTag.put("piglin_safe", new ByteTag(0));
        compoundTag.put("natural", new ByteTag(1));
        compoundTag.put("ambient_light", new FloatTag(0.0f));
        compoundTag.put("infiniburn", new StringTag("minecraft:infiniburn_overworld"));
        compoundTag.put("respawn_anchor_works", new ByteTag(0));
        compoundTag.put("has_skylight", new ByteTag(1));
        compoundTag.put("bed_works", new ByteTag(1));
        compoundTag.put("has_raids", new ByteTag(1));
        compoundTag.put("logical_height", new IntTag(256));
        compoundTag.put("shrunk", new ByteTag(0));
        compoundTag.put("ultrawarm", new ByteTag(0));
    }

    private static CompoundTag createNetherEntry() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("piglin_safe", new ByteTag(1));
        compoundTag.put("natural", new ByteTag(0));
        compoundTag.put("ambient_light", new FloatTag(0.1f));
        compoundTag.put("infiniburn", new StringTag("minecraft:infiniburn_nether"));
        compoundTag.put("respawn_anchor_works", new ByteTag(1));
        compoundTag.put("has_skylight", new ByteTag(0));
        compoundTag.put("bed_works", new ByteTag(0));
        compoundTag.put("fixed_time", new LongTag(18000L));
        compoundTag.put("has_raids", new ByteTag(0));
        compoundTag.put("name", new StringTag("minecraft:the_nether"));
        compoundTag.put("logical_height", new IntTag(128));
        compoundTag.put("shrunk", new ByteTag(1));
        compoundTag.put("ultrawarm", new ByteTag(1));
        compoundTag.put("has_ceiling", new ByteTag(1));
        return compoundTag;
    }

    private static CompoundTag createEndEntry() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("piglin_safe", new ByteTag(0));
        compoundTag.put("natural", new ByteTag(0));
        compoundTag.put("ambient_light", new FloatTag(0.0f));
        compoundTag.put("infiniburn", new StringTag("minecraft:infiniburn_end"));
        compoundTag.put("respawn_anchor_works", new ByteTag(0));
        compoundTag.put("has_skylight", new ByteTag(0));
        compoundTag.put("bed_works", new ByteTag(0));
        compoundTag.put("fixed_time", new LongTag(6000L));
        compoundTag.put("has_raids", new ByteTag(1));
        compoundTag.put("name", new StringTag("minecraft:the_end"));
        compoundTag.put("logical_height", new IntTag(256));
        compoundTag.put("shrunk", new ByteTag(0));
        compoundTag.put("ultrawarm", new ByteTag(0));
        compoundTag.put("has_ceiling", new ByteTag(0));
        return compoundTag;
    }

    static {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        listTag.add(DimensionRegistries1_16.createOverworldEntry());
        listTag.add(DimensionRegistries1_16.createOverworldCavesEntry());
        listTag.add(DimensionRegistries1_16.createNetherEntry());
        listTag.add(DimensionRegistries1_16.createEndEntry());
        DIMENSIONS_TAG.put("dimension", listTag);
    }
}

