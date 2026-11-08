/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.provider;

import com.viaversion.viabackwards.protocol.v1_20_2to1_20.provider.AdvancementCriteriaProvider;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;

public class BukkitAdvancementCriteriaProvider
extends AdvancementCriteriaProvider {
    private static final String[] EMPTY_CRITERIA = new String[0];

    @Override
    public String[] getCriteria(String string) {
        Advancement advancement = Bukkit.getAdvancement((NamespacedKey)NamespacedKey.fromString((String)string));
        return advancement == null ? EMPTY_CRITERIA : advancement.getCriteria().toArray(EMPTY_CRITERIA);
    }
}

