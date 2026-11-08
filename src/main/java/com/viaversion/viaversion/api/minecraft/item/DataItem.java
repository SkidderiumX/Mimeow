/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.libs.gson.annotations.SerializedName;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DataItem
implements Item {
    @SerializedName(value="identifier", alternate={"id"})
    private int identifier;
    private byte amount;
    private short data;
    private CompoundTag tag;

    public DataItem() {
    }

    public DataItem(int n, byte by, @Nullable CompoundTag compoundTag) {
        this(n, by, 0, compoundTag);
    }

    public DataItem(int n, byte by, short s, @Nullable CompoundTag compoundTag) {
        this.identifier = n;
        this.amount = by;
        this.data = s;
        this.tag = compoundTag;
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
        if (n != (byte)n) {
            throw new IllegalArgumentException("Invalid item amount: " + n);
        }
        this.amount = (byte)n;
    }

    @Override
    public short data() {
        return this.data;
    }

    @Override
    public void setData(short s) {
        this.data = s;
    }

    @Override
    public @Nullable CompoundTag tag() {
        return this.tag;
    }

    @Override
    public void setTag(@Nullable CompoundTag compoundTag) {
        this.tag = compoundTag;
    }

    @Override
    public StructuredDataContainer dataContainer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DataItem copy() {
        return new DataItem(this.identifier, this.amount, this.data, this.tag != null ? this.tag.copy() : null);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        DataItem dataItem = (DataItem)object;
        if (this.identifier != dataItem.identifier) {
            return false;
        }
        if (this.amount != dataItem.amount) {
            return false;
        }
        if (this.data != dataItem.data) {
            return false;
        }
        return Objects.equals(this.tag, dataItem.tag);
    }

    public int hashCode() {
        int n = this.identifier;
        n = 31 * n + this.amount;
        n = 31 * n + this.data;
        n = 31 * n + (this.tag != null ? this.tag.hashCode() : 0);
        return n;
    }

    public String toString() {
        return "DataItem{identifier=" + this.identifier + ", amount=" + this.amount + ", data=" + this.data + ", tag=" + String.valueOf(this.tag) + "}";
    }
}

