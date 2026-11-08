/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.data;

import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;

public class BackwardsItemMappings {
    private static final Int2ObjectMap<String> MODEL_DATA_TO_NAME = new Int2ObjectOpenHashMap<String>();

    public static String identifier(int n) {
        return (String)MODEL_DATA_TO_NAME.get(n);
    }

    private static void add(String string, int n) {
        MODEL_DATA_TO_NAME.put(n, string);
    }

    static {
        BackwardsItemMappings.add("acacia_button", 245);
        BackwardsItemMappings.add("birch_button", 243);
        BackwardsItemMappings.add("spruce_button", 242);
        BackwardsItemMappings.add("jungle_button", 244);
        BackwardsItemMappings.add("dark_oak_button", 246);
        BackwardsItemMappings.add("acacia_trapdoor", 191);
        BackwardsItemMappings.add("birch_trapdoor", 189);
        BackwardsItemMappings.add("spruce_trapdoor", 188);
        BackwardsItemMappings.add("jungle_trapdoor", 190);
        BackwardsItemMappings.add("dark_oak_trapdoor", 192);
        BackwardsItemMappings.add("acacia_pressure_plate", 164);
        BackwardsItemMappings.add("birch_pressure_plate", 162);
        BackwardsItemMappings.add("spruce_pressure_plate", 161);
        BackwardsItemMappings.add("jungle_pressure_plate", 163);
        BackwardsItemMappings.add("dark_oak_pressure_plate", 165);
        BackwardsItemMappings.add("acacia_boat", 762);
        BackwardsItemMappings.add("birch_boat", 760);
        BackwardsItemMappings.add("spruce_boat", 759);
        BackwardsItemMappings.add("jungle_boat", 761);
        BackwardsItemMappings.add("dark_oak_boat", 763);
        BackwardsItemMappings.add("blue_ice", 453);
        BackwardsItemMappings.add("pufferfish_bucket", 547);
        BackwardsItemMappings.add("salmon_bucket", 548);
        BackwardsItemMappings.add("cod_bucket", 549);
        BackwardsItemMappings.add("tropical_fish_bucket", 550);
        BackwardsItemMappings.add("heart_of_the_sea", 784);
        BackwardsItemMappings.add("nautilus_shell", 783);
        BackwardsItemMappings.add("phantom_membrane", 782);
        BackwardsItemMappings.add("turtle_helmet", 465);
        BackwardsItemMappings.add("turtle_egg", 427);
        BackwardsItemMappings.add("scute", 466);
        BackwardsItemMappings.add("trident", 781);
        BackwardsItemMappings.add("sea_pickle", 80);
        BackwardsItemMappings.add("seagrass", 79);
        BackwardsItemMappings.add("conduit", 454);
        BackwardsItemMappings.add("kelp", 554);
        BackwardsItemMappings.add("dried_kelp", 611);
        BackwardsItemMappings.add("dried_kelp_block", 555);
        BackwardsItemMappings.add("stripped_oak_log", 38);
        BackwardsItemMappings.add("stripped_acacia_log", 42);
        BackwardsItemMappings.add("stripped_birch_log", 40);
        BackwardsItemMappings.add("stripped_spruce_log", 39);
        BackwardsItemMappings.add("stripped_jungle_log", 41);
        BackwardsItemMappings.add("stripped_dark_oak_log", 43);
        BackwardsItemMappings.add("stripped_oak_wood", 44);
        BackwardsItemMappings.add("stripped_acacia_wood", 48);
        BackwardsItemMappings.add("stripped_birch_wood", 46);
        BackwardsItemMappings.add("stripped_spruce_wood", 45);
        BackwardsItemMappings.add("stripped_jungle_wood", 47);
        BackwardsItemMappings.add("stripped_dark_oak_wood", 49);
        BackwardsItemMappings.add("oak_wood", 50);
        BackwardsItemMappings.add("spruce_wood", 51);
        BackwardsItemMappings.add("birch_wood", 52);
        BackwardsItemMappings.add("jungle_wood", 53);
        BackwardsItemMappings.add("acacia_wood", 54);
        BackwardsItemMappings.add("dark_oak_wood", 55);
        BackwardsItemMappings.add("prismarine_slab", 128);
        BackwardsItemMappings.add("prismarine_brick_slab", 129);
        BackwardsItemMappings.add("dark_prismarine_slab", 130);
        BackwardsItemMappings.add("prismarine_stairs", 346);
        BackwardsItemMappings.add("prismarine_brick_stairs", 347);
        BackwardsItemMappings.add("dark_prismarine_stairs", 348);
        BackwardsItemMappings.add("drowned_spawn_egg", 643);
        BackwardsItemMappings.add("phantom_spawn_egg", 658);
        BackwardsItemMappings.add("dolphin_spawn_egg", 641);
        BackwardsItemMappings.add("turtle_spawn_egg", 674);
        BackwardsItemMappings.add("cod_spawn_egg", 638);
        BackwardsItemMappings.add("salmon_spawn_egg", 663);
        BackwardsItemMappings.add("pufferfish_spawn_egg", 661);
        BackwardsItemMappings.add("tropical_fish_spawn_egg", 673);
        BackwardsItemMappings.add("tube_coral", 438);
        BackwardsItemMappings.add("brain_coral", 439);
        BackwardsItemMappings.add("bubble_coral", 440);
        BackwardsItemMappings.add("fire_coral", 441);
        BackwardsItemMappings.add("horn_coral", 442);
        BackwardsItemMappings.add("tube_coral_fan", 443);
        BackwardsItemMappings.add("brain_coral_fan", 444);
        BackwardsItemMappings.add("bubble_coral_fan", 445);
        BackwardsItemMappings.add("fire_coral_fan", 446);
        BackwardsItemMappings.add("horn_coral_fan", 447);
        BackwardsItemMappings.add("dead_tube_coral_fan", 448);
        BackwardsItemMappings.add("dead_brain_coral_fan", 449);
        BackwardsItemMappings.add("dead_bubble_coral_fan", 450);
        BackwardsItemMappings.add("dead_fire_coral_fan", 451);
        BackwardsItemMappings.add("dead_horn_coral_fan", 452);
        BackwardsItemMappings.add("dead_tube_coral_block", 428);
        BackwardsItemMappings.add("dead_brain_coral_block", 429);
        BackwardsItemMappings.add("dead_bubble_coral_block", 430);
        BackwardsItemMappings.add("dead_fire_coral_block", 431);
        BackwardsItemMappings.add("dead_horn_coral_block", 432);
        BackwardsItemMappings.add("tube_coral_block", 433);
        BackwardsItemMappings.add("brain_coral_block", 434);
        BackwardsItemMappings.add("bubble_coral_block", 435);
        BackwardsItemMappings.add("fire_coral_block", 436);
        BackwardsItemMappings.add("horn_coral_block", 437);
        BackwardsItemMappings.add("smooth_quartz", 131);
        BackwardsItemMappings.add("smooth_red_sandstone", 132);
        BackwardsItemMappings.add("smooth_sandstone", 133);
        BackwardsItemMappings.add("smooth_stone", 134);
        BackwardsItemMappings.add("pumpkin", 181);
        BackwardsItemMappings.add("mushroom_stem", 205);
        BackwardsItemMappings.add("debug_stick", 768);
    }
}

