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

public class SkullHandler
implements BlockEntityProvider.BlockEntityHandler {
    private static final int SKULL_WALL_START = 5447;
    private static final int SKULL_END = 5566;

    @Override
    public int transform(UserConnection userConnection, CompoundTag compoundTag) {
        BlockPosition blockPosition;
        BlockStorage blockStorage = userConnection.get(BlockStorage.class);
        if (!blockStorage.contains(blockPosition = new BlockPosition(compoundTag.getNumberTag("x").asInt(), compoundTag.getNumberTag("y").asShort(), compoundTag.getNumberTag("z").asInt()))) {
            Protocol1_12_2To1_13.LOGGER.warning("Received an head update packet, but there is no head! O_o " + String.valueOf(compoundTag));
            return -1;
        }
        int n = blockStorage.get(blockPosition).getOriginal();
        if (n >= 5447 && n <= 5566) {
            NumberTag numberTag;
            NumberTag numberTag2 = compoundTag.getNumberTag("Rot");
            if (numberTag2 != null) {
                n += numberTag2.asInt() & 0xF;
            }
            if ((numberTag = compoundTag.getNumberTag("SkullType")) != null) {
                n += numberTag.asInt() * 20;
            }
        } else {
            Protocol1_12_2To1_13.LOGGER.warning("Why does this block have the skull block entity? " + String.valueOf(compoundTag));
            return -1;
        }
        return n;
    }
}

