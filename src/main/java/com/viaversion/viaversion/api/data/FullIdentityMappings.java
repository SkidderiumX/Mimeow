/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.api.data.FullMappingsBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.util.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

public class FullIdentityMappings
extends FullMappingsBase {
    public FullIdentityMappings(MappingDataLoader.IdentifiersPair identifiersPair, Mappings mappings) {
        this(FullIdentityMappings.toInverseMap(identifiersPair.unmapped()), (Key[])identifiersPair.unmapped().stream().map(Key::of).toArray(Key[]::new), mappings);
    }

    private FullIdentityMappings(Object2IntMap<String> object2IntMap, Key[] keyArray, Mappings mappings) {
        super(object2IntMap, object2IntMap, keyArray, keyArray, mappings);
    }

    @Override
    public @Nullable String identifier(String string) {
        return this.mappedIdentifier(string);
    }

    @Override
    public @Nullable Key keyFromMappedKey(String string) {
        return this.mappedKeyFromKey(string);
    }

    @Override
    public boolean isIdentity() {
        return true;
    }

    @Override
    public boolean isIntIdIdentity() {
        return true;
    }

    @Override
    public FullIdentityMappings inverse() {
        return new FullIdentityMappings(this.stringToId, this.idToKey, this.mappings.inverse());
    }
}

