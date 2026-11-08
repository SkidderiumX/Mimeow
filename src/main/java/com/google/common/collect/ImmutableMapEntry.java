/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableEntry;
import javax.annotation.Nullable;

@GwtIncompatible(value="unnecessary")
public abstract class ImmutableMapEntry<K, V>
extends ImmutableEntry<K, V> {
    ImmutableMapEntry(K k, V v) {
        super(k, v);
        CollectPreconditions.checkEntryNotNull(k, v);
    }

    ImmutableMapEntry(ImmutableMapEntry<K, V> immutableMapEntry) {
        super(immutableMapEntry.getKey(), immutableMapEntry.getValue());
    }

    @Nullable
    abstract ImmutableMapEntry<K, V> getNextInKeyBucket();

    @Nullable
    abstract ImmutableMapEntry<K, V> getNextInValueBucket();

    public static final class TerminalEntry<K, V>
    extends ImmutableMapEntry<K, V> {
        TerminalEntry(ImmutableMapEntry<K, V> immutableMapEntry) {
            super(immutableMapEntry);
        }

        TerminalEntry(K k, V v) {
            super(k, v);
        }

        @Override
        @Nullable
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return null;
        }

        @Override
        @Nullable
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return null;
        }
    }
}

