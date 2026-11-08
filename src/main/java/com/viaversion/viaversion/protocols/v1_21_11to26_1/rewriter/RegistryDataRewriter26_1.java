/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;

public class RegistryDataRewriter26_1
extends RegistryDataRewriter {
    public RegistryDataRewriter26_1(Protocol<?, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    public void updateEnchantmentTerm(CompoundTag compoundTag) {
        if (Key.equals(compoundTag.getString("condition"), "time_check")) {
            compoundTag.putString("clock", "overworld");
        }
        super.updateEnchantmentTerm(compoundTag);
    }
}

