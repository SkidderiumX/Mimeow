/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;

public record DebugStickState(CompoundTag tag) implements Rewritable,
Copyable
{
    public static final Type<DebugStickState> TYPE = TransformingType.of(Types.COMPOUND_TAG, DebugStickState.class, DebugStickState::new, DebugStickState::tag);

    @Override
    public DebugStickState rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        CompoundTag compoundTag = this.tag;
        if (bl && protocol.getMappingData() != null && protocol.getMappingData().changedBlocks() != null) {
            compoundTag = this.tag.copy();
            compoundTag.entrySet().removeIf(entry -> {
                int n = protocol.getMappingData().getFullBlockMappings().id((String)entry.getKey());
                return protocol.getMappingData().changedBlocks().contains(n);
            });
        }
        return new DebugStickState(compoundTag);
    }

    @Override
    public DebugStickState copy() {
        return new DebugStickState(this.tag.copy());
    }
}

