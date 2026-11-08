/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.ItemBase;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Item
extends ItemBase {
    default public short data() {
        return 0;
    }

    default public void setData(short s) {
        throw new UnsupportedOperationException();
    }

    public @Nullable CompoundTag tag();

    public void setTag(@Nullable CompoundTag var1);

    public StructuredDataContainer dataContainer();

    @Override
    public Item copy();

    default public boolean isTemplate() {
        return false;
    }

    public static boolean isEmpty(@Nullable Item item) {
        return item == null || item.isEmpty();
    }
}

