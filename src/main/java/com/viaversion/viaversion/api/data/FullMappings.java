/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.api.data.BiMappings;
import com.viaversion.viaversion.util.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface FullMappings
extends BiMappings {
    public int id(String var1);

    public int mappedId(String var1);

    default public @Nullable String identifier(int n) {
        Key key = this.keyFromId(n);
        return key != null ? key.toString() : null;
    }

    default public @Nullable String identifier(String string) {
        Key key = this.keyFromMappedKey(string);
        return key != null ? key.toString() : null;
    }

    default public @Nullable String mappedIdentifier(int n) {
        Key key = this.mappedKeyFromMappedId(n);
        return key != null ? key.toString() : null;
    }

    default public @Nullable String mappedIdentifier(String string) {
        Key key = this.mappedKeyFromKey(string);
        return key != null ? key.toString() : null;
    }

    public @Nullable Key keyFromId(int var1);

    public @Nullable Key keyFromMappedKey(String var1);

    public @Nullable Key mappedKeyFromMappedId(int var1);

    public @Nullable Key mappedKeyFromKey(String var1);

    public boolean isIntIdIdentity();

    @Override
    public FullMappings inverse();
}

