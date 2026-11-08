/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import java.util.List;

public class FakeEnumType
extends VarIntType {
    private final Entry[] entries;

    public FakeEnumType(List<String> list, Entry ... entryArray) {
        this.entries = new Entry[list.size() + entryArray.length];
        for (int i = 0; i < list.size(); ++i) {
            this.entries[i] = Entry.of(i, list.get(i));
        }
        System.arraycopy(entryArray, 0, this.entries, list.size(), entryArray.length);
    }

    public FakeEnumType(Entry ... entryArray) {
        this.entries = entryArray;
    }

    @Override
    public void write(Ops ops, Integer n) {
        Entry entry = null;
        for (Entry entry2 : this.entries) {
            if (entry2.id != n) continue;
            entry = entry2;
            break;
        }
        Types.STRING.write(ops, entry != null ? entry.name : this.entries[0].name);
    }

    public Entry[] entries() {
        return this.entries;
    }

    public record Entry(int id, String name) {
        public static Entry of(int n, String string) {
            return new Entry(n, string);
        }
    }
}

