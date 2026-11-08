/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.FullMappingsBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.util.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

public class LegacyFullStringMappingsBase
extends FullMappingsBase {
    private final String[] idToString;
    private final String[] mappedIdToString;

    public LegacyFullStringMappingsBase(MappingDataLoader.IdentifiersPair identifiersPair, Mappings mappings) {
        super(LegacyFullStringMappingsBase.toInverseMap(identifiersPair.unmapped()), LegacyFullStringMappingsBase.toInverseMap(identifiersPair.mapped()), new Key[0], new Key[0], mappings);
        this.idToString = identifiersPair.unmapped().toArray(new String[0]);
        this.mappedIdToString = identifiersPair.mapped().toArray(new String[0]);
    }

    private LegacyFullStringMappingsBase(Object2IntMap<String> object2IntMap, Object2IntMap<String> object2IntMap2, String[] stringArray, String[] stringArray2, Mappings mappings) {
        super(object2IntMap, object2IntMap2, new Key[0], new Key[0], mappings);
        this.idToString = stringArray;
        this.mappedIdToString = stringArray2;
    }

    @Override
    public String identifier(int n) {
        if (n < 0 || n >= this.idToString.length) {
            return null;
        }
        return Key.namespaced(this.idToString[n]);
    }

    @Override
    public @Nullable String identifier(String string) {
        int n = this.mappedId(string);
        if (n == -1) {
            return null;
        }
        int n2 = this.mappings.inverse().getNewId(n);
        return n2 != -1 ? this.identifier(n2) : null;
    }

    @Override
    public @Nullable String mappedIdentifier(int n) {
        if (n < 0 || n >= this.mappedIdToString.length) {
            return null;
        }
        return Key.namespaced(this.mappedIdToString[n]);
    }

    @Override
    public @Nullable String mappedIdentifier(String string) {
        int n = this.id(string);
        if (n == -1) {
            return null;
        }
        int n2 = this.mappings.getNewId(n);
        return n2 != -1 ? this.mappedIdentifier(n2) : null;
    }

    @Override
    public @Nullable Key keyFromId(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable Key keyFromMappedKey(String string) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable Key mappedKeyFromMappedId(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable Key mappedKeyFromKey(String string) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FullMappings inverse() {
        return new LegacyFullStringMappingsBase((Object2IntMap<String>)this.mappedStringToId, (Object2IntMap<String>)this.stringToId, this.mappedIdToString, this.idToString, this.mappings.inverse());
    }
}

