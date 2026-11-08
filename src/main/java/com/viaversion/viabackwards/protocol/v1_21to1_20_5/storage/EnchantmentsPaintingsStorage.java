/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.util.KeyMappings;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EnchantmentsPaintingsStorage
implements StorableObject {
    private KeyMappings enchantments;
    private KeyMappings paintings;
    private int[] paintingMappings;
    private Tag[] enchantmentDescriptions;
    private int[] enchantmentMaxLevels;
    private int[] jubeboxSongsToItems;

    public KeyMappings enchantments() {
        return this.enchantments;
    }

    public void setEnchantments(KeyMappings keyMappings, Tag[] tagArray, int[] nArray) {
        this.enchantments = keyMappings;
        this.enchantmentDescriptions = tagArray;
        this.enchantmentMaxLevels = nArray;
    }

    public KeyMappings paintings() {
        return this.paintings;
    }

    public void setPaintings(KeyMappings keyMappings, int[] nArray) {
        this.paintings = keyMappings;
        this.paintingMappings = nArray;
    }

    public void setJubeboxSongsToItems(int[] nArray) {
        this.jubeboxSongsToItems = nArray;
    }

    public int jubeboxSongToItem(int n) {
        return n >= 0 && n < this.jubeboxSongsToItems.length ? this.jubeboxSongsToItems[n] : -1;
    }

    public int mappedPainting(int n) {
        return n > 0 && n < this.paintingMappings.length ? this.paintingMappings[n] : 0;
    }

    public @Nullable Tag enchantmentDescription(int n) {
        return n > 0 && n < this.enchantmentDescriptions.length ? this.enchantmentDescriptions[n] : null;
    }

    public int enchantmentMaxLevel(int n) {
        return n > 0 && n < this.enchantmentMaxLevels.length ? this.enchantmentMaxLevels[n] : -1;
    }
}

