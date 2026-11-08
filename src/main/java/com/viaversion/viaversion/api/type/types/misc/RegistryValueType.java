/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.RegistryKey;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.util.Key;

public class RegistryValueType
extends VarIntType
implements RegistryKey {
    private final Key registry;
    private final Key[] keys;

    public RegistryValueType(Key key, String ... stringArray) {
        this.registry = key;
        this.keys = new Key[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            this.keys[i] = Key.of(stringArray[i]);
        }
    }

    @Override
    public void write(Ops ops, Integer n) {
        Types.IDENTIFIER.write(ops, this.keys[n]);
    }

    public Key[] keys() {
        return this.keys;
    }

    public Key byId(int n) {
        return this.keys[n];
    }

    @Override
    public Key registry() {
        return this.registry;
    }
}

