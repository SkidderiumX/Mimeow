/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.RegistryKey;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.util.Key;

public class SynchronizedRegistryValueType
extends VarIntType {
    private final RegistryKey registryKey;

    public SynchronizedRegistryValueType(RegistryKey registryKey) {
        this.registryKey = registryKey;
    }

    @Override
    public void write(Ops ops, Integer n) {
        Key key = ops.context().registryAccess().registryKey(this.registryKey.registry().toString(), n);
        Types.IDENTIFIER.write(ops, key);
    }
}

