/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;

public class HashedStructuredItem
implements HashedItem {
    private final Int2IntMap dataHashes;
    private final IntSet removedData;
    private int identifier;
    private int amount;

    public HashedStructuredItem(int n, int n2) {
        this(n, n2, new Int2IntOpenHashMap(0), new IntOpenHashSet(0));
    }

    public HashedStructuredItem(int n, int n2, Int2IntMap int2IntMap, IntSet intSet) {
        this.identifier = n;
        this.amount = n2;
        this.dataHashes = int2IntMap;
        this.removedData = intSet;
    }

    public static HashedStructuredItem empty() {
        return new HashedStructuredItem(0, 0);
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
    public Int2IntMap dataHashesById() {
        return this.dataHashes;
    }

    @Override
    public IntSet removedDataIds() {
        return this.removedData;
    }

    @Override
    public HashedItem copy() {
        return new HashedStructuredItem(this.identifier, this.amount, new Int2IntOpenHashMap(this.dataHashes), new IntOpenHashSet(this.removedData));
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        HashedStructuredItem hashedStructuredItem = (HashedStructuredItem)object;
        if (this.identifier != hashedStructuredItem.identifier) {
            return false;
        }
        if (this.amount != hashedStructuredItem.amount) {
            return false;
        }
        return this.dataHashes.equals(hashedStructuredItem.dataHashes) && this.removedData.equals(hashedStructuredItem.removedData);
    }

    public int hashCode() {
        int n = this.dataHashes.hashCode();
        n = 31 * n + this.removedData.hashCode();
        n = 31 * n + this.identifier;
        n = 31 * n + this.amount;
        return n;
    }

    public String toString() {
        return "HashedStructuredItem{data=Hashes" + String.valueOf(this.dataHashes) + ", removedData=" + String.valueOf(this.removedData) + ", identifier=" + this.identifier + ", amount=" + this.amount + "}";
    }
}

