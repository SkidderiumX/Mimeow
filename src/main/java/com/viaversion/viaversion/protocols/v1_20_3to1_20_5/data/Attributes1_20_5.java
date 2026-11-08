/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data;

import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Attributes1_20_5 {
    private static final KeyMappings ATTRIBUTES = new KeyMappings("generic.armor", "generic.armor_toughness", "generic.attack_damage", "generic.attack_knockback", "generic.attack_speed", "player.block_break_speed", "player.block_interaction_range", "player.entity_interaction_range", "generic.fall_damage_multiplier", "generic.flying_speed", "generic.follow_range", "generic.gravity", "generic.jump_strength", "generic.knockback_resistance", "generic.luck", "generic.max_absorption", "generic.max_health", "generic.movement_speed", "generic.safe_fall_distance", "generic.scale", "zombie.spawn_reinforcements", "generic.step_height");

    public static @Nullable String idToKey(int n) {
        return ATTRIBUTES.idToKey(n);
    }

    public static int keyToId(String string) {
        if (Key.stripMinecraftNamespace(string).equals("horse.jump_strength")) {
            string = "generic.jump_strength";
        }
        return ATTRIBUTES.keyToId(string);
    }
}

