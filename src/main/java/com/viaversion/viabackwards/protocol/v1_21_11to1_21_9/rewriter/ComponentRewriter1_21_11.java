/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;

public class ComponentRewriter1_21_11
extends NBTComponentRewriter<ClientboundPacket1_21_11> {
    public ComponentRewriter1_21_11(BackwardsProtocol<ClientboundPacket1_21_11, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        this.removeDataComponents(compoundTag2, StructuredDataKey.SWING_ANIMATION, StructuredDataKey.KINETIC_WEAPON, StructuredDataKey.PIERCING_WEAPON, StructuredDataKey.DAMAGE_TYPE26_1, StructuredDataKey.MINIMUM_ATTACK_CHARGE, StructuredDataKey.USE_EFFECTS, StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11, StructuredDataKey.ATTACK_RANGE);
    }
}

