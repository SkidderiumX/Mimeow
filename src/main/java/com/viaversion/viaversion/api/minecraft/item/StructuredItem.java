/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import org.checkerframework.checker.nullness.qual.Nullable;

public class StructuredItem
implements Item {
    private final StructuredDataContainer data;
    private int identifier;
    private int amount;

    public StructuredItem(int n, int n2) {
        this(n, n2, new StructuredDataContainer());
    }

    public StructuredItem(int n, int n2, StructuredDataContainer structuredDataContainer) {
        this.identifier = n;
        this.amount = n2;
        this.data = structuredDataContainer;
    }

    public static StructuredItem empty() {
        return new StructuredItem(0, 0);
    }

    public static Item[] emptyArray(int n) {
        Item[] itemArray = new Item[n];
        for (int i = 0; i < itemArray.length; ++i) {
            itemArray[i] = StructuredItem.empty();
        }
        return itemArray;
    }

    @Override
    public int identifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int n) {
        this.identifier = n;
    }

    @Override
    public int amount() {
        return this.amount;
    }

    @Override
    public void setAmount(int n) {
        this.amount = n;
    }

    @Override
    public @Nullable CompoundTag tag() {
        return null;
    }

    @Override
    public void setTag(@Nullable CompoundTag compoundTag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StructuredDataContainer dataContainer() {
        return this.data;
    }

    @Override
    public StructuredItem copy() {
        return new StructuredItem(this.identifier, this.amount, this.data.copy());
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        StructuredItem structuredItem = (StructuredItem)object;
        if (this.identifier != structuredItem.identifier) {
            return false;
        }
        if (this.amount != structuredItem.amount) {
            return false;
        }
        return this.data.equals(structuredItem.data);
    }

    public int hashCode() {
        int n = this.data.hashCode();
        n = 31 * n + this.identifier;
        n = 31 * n + this.amount;
        return n;
    }

    public String toString() {
        return "StructuredItem{data=" + String.valueOf(this.data) + ", identifier=" + this.identifier + ", amount=" + this.amount + "}";
    }
}

