/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.data.FullIdentityMappings;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.util.Key;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class FullMappingsBase
implements FullMappings {
    protected final Object2IntMap<String> stringToId;
    protected final Object2IntMap<String> mappedStringToId;
    protected final Key[] idToKey;
    protected final Key[] mappedIdToKey;
    protected final Mappings mappings;

    public FullMappingsBase(MappingDataLoader.IdentifiersPair identifiersPair, Mappings mappings) {
        Preconditions.checkNotNull(mappings, "Mappings cannot be null");
        this.mappings = mappings;
        this.stringToId = FullMappingsBase.toInverseMap(identifiersPair.unmapped());
        this.idToKey = (Key[])identifiersPair.unmapped().stream().map(Key::of).toArray(Key[]::new);
        this.mappedStringToId = FullMappingsBase.toInverseMap(identifiersPair.mapped());
        this.mappedIdToKey = (Key[])identifiersPair.mapped().stream().map(Key::of).toArray(Key[]::new);
    }

    protected FullMappingsBase(Object2IntMap<String> object2IntMap, Object2IntMap<String> object2IntMap2, Key[] keyArray, Key[] keyArray2, Mappings mappings) {
        this.stringToId = object2IntMap;
        this.mappedStringToId = object2IntMap2;
        this.idToKey = keyArray;
        this.mappedIdToKey = keyArray2;
        this.mappings = mappings;
    }

    public static FullMappings of(MappingDataLoader.IdentifiersPair identifiersPair, Mappings mappings) {
        return mappings.isIdentity() && identifiersPair.identity() ? new FullIdentityMappings(identifiersPair, mappings) : new FullMappingsBase(identifiersPair, mappings);
    }

    static Object2IntMap<String> toInverseMap(List<String> list) {
        Object2IntOpenHashMap<String> object2IntOpenHashMap = new Object2IntOpenHashMap<String>(list.size());
        object2IntOpenHashMap.defaultReturnValue(-1);
        for (int i = 0; i < list.size(); ++i) {
            object2IntOpenHashMap.put(list.get(i), i);
        }
        return object2IntOpenHashMap;
    }

    @Override
    public int id(String string) {
        return this.stringToId.getInt(Key.stripMinecraftNamespace(string));
    }

    @Override
    public int mappedId(String string) {
        return this.mappedStringToId.getInt(Key.stripMinecraftNamespace(string));
    }

    @Override
    public @Nullable Key keyFromId(int n) {
        if (n < 0 || n >= this.idToKey.length) {
            return null;
        }
        return this.idToKey[n];
    }

    @Override
    public @Nullable Key keyFromMappedKey(String string) {
        int n = this.mappedId(string);
        if (n == -1) {
            return null;
        }
        int n2 = this.mappings.inverse().getNewId(n);
        return n2 != -1 ? this.keyFromId(n2) : null;
    }

    @Override
    public @Nullable Key mappedKeyFromMappedId(int n) {
        if (n < 0 || n >= this.mappedIdToKey.length) {
            return null;
        }
        return this.mappedIdToKey[n];
    }

    @Override
    public @Nullable Key mappedKeyFromKey(String string) {
        int n = this.id(string);
        if (n == -1) {
            return null;
        }
        int n2 = this.mappings.getNewId(n);
        return n2 != -1 ? this.mappedKeyFromMappedId(n2) : null;
    }

    @Override
    public int getNewId(int n) {
        return this.mappings.getNewId(n);
    }

    @Override
    public void setNewId(int n, int n2) {
        this.mappings.setNewId(n, n2);
    }

    @Override
    public int size() {
        return this.mappings.size();
    }

    @Override
    public int mappedSize() {
        return this.mappings.mappedSize();
    }

    @Override
    public boolean isIntIdIdentity() {
        return this.mappings.isIdentity();
    }

    @Override
    public FullMappings inverse() {
        return new FullMappingsBase(this.mappedStringToId, this.stringToId, this.mappedIdToKey, this.idToKey, this.mappings.inverse());
    }
}

