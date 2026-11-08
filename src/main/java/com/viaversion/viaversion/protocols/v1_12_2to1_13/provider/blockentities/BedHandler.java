/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockStorage;

public class BedHandler
implements BlockEntityProvider.BlockEntityHandler {
    @Override
    public int transform(UserConnection userConnection, CompoundTag compoundTag) {
        BlockPosition blockPosition;
        BlockStorage blockStorage = userConnection.get(BlockStorage.class);
        if (!blockStorage.contains(blockPosition = new BlockPosition(compoundTag.getNumberTag("x").asInt(), compoundTag.getNumberTag("y").asShort(), compoundTag.getNumberTag("z").asInt()))) {
            Protocol1_12_2To1_13.LOGGER.warning("Received an bed color update packet, but there is no bed! O_o " + String.valueOf(compoundTag));
            return -1;
        }
        int n = blockStorage.get(blockPosition).getOriginal() - 972 + 748;
        NumberTag numberTag = compoundTag.getNumberTag("color");
        if (numberTag != null) {
            n += numberTag.asInt() * 16;
        }
        return n;
    }
}

