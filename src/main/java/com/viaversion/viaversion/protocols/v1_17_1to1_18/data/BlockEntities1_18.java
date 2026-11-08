/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18.data;

import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;

public class BlockEntities1_18 {
    private static final Object2IntMap<String> BLOCK_ENTITY_IDS = new Object2IntOpenHashMap<String>();

    public static Object2IntMap<String> blockEntityIds() {
        return BLOCK_ENTITY_IDS;
    }

    private static String[] blockEntities() {
        return new String[]{"furnace", "chest", "trapped_chest", "ender_chest", "jukebox", "dispenser", "dropper", "sign", "mob_spawner", "piston", "brewing_stand", "enchanting_table", "end_portal", "beacon", "skull", "daylight_detector", "hopper", "comparator", "banner", "structure_block", "end_gateway", "command_block", "shulker_box", "bed", "conduit", "barrel", "smoker", "blast_furnace", "lectern", "bell", "jigsaw", "campfire", "beehive", "sculk_sensor"};
    }

    static {
        BLOCK_ENTITY_IDS.defaultReturnValue(-1);
        String[] stringArray = BlockEntities1_18.blockEntities();
        for (int i = 0; i < stringArray.length; ++i) {
            BLOCK_ENTITY_IDS.put(stringArray[i], i);
        }
    }
}

