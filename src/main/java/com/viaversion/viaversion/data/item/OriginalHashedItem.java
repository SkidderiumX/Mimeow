/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.data.item;

import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.HashedStructuredItem;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;

public class OriginalHashedItem
extends HashedStructuredItem {
    private final String backupTagName;

    public OriginalHashedItem(HashedItem hashedItem, String string) {
        this(hashedItem.identifier(), hashedItem.amount(), hashedItem.dataHashesById(), hashedItem.removedDataIds(), string);
    }

    public OriginalHashedItem(int n, int n2, String string) {
        super(n, n2);
        this.backupTagName = string;
    }

    private OriginalHashedItem(int n, int n2, Int2IntMap int2IntMap, IntSet intSet, String string) {
        super(n, n2, int2IntMap, intSet);
        this.backupTagName = string;
    }

    public String backupTagName() {
        return this.backupTagName;
    }

    public HashedItem asRegularItem() {
        return new HashedStructuredItem(this.identifier(), this.amount(), this.dataHashesById(), this.removedDataIds());
    }

    @Override
    public OriginalHashedItem copy() {
        return new OriginalHashedItem(this.identifier(), this.amount(), new Int2IntOpenHashMap(this.dataHashesById()), new IntOpenHashSet(this.removedDataIds()), this.backupTagName);
    }
}

