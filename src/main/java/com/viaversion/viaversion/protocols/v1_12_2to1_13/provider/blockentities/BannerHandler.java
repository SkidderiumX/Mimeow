/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockStorage;
import com.viaversion.viaversion.util.ComponentUtil;

public class BannerHandler
implements BlockEntityProvider.BlockEntityHandler {
    private static final int WALL_BANNER_START = 7110;
    private static final int WALL_BANNER_STOP = 7173;
    private static final int BANNER_START = 6854;
    private static final int BANNER_STOP = 7109;

    @Override
    public int transform(UserConnection userConnection, CompoundTag compoundTag) {
        Object object;
        int n;
        BlockPosition blockPosition;
        BlockStorage blockStorage = userConnection.get(BlockStorage.class);
        if (!blockStorage.contains(blockPosition = new BlockPosition(compoundTag.getNumberTag("x").asInt(), compoundTag.getNumberTag("y").asShort(), compoundTag.getNumberTag("z").asInt()))) {
            Protocol1_12_2To1_13.LOGGER.warning("Received an banner color update packet, but there is no banner! O_o " + String.valueOf(compoundTag));
            return -1;
        }
        int n2 = blockStorage.get(blockPosition).getOriginal();
        NumberTag numberTag = compoundTag.getNumberTag("Base");
        int n3 = n = numberTag != null ? numberTag.asInt() : 0;
        if (n2 >= 6854 && n2 <= 7109) {
            n2 += (15 - n) * 16;
        } else if (n2 >= 7110 && n2 <= 7173) {
            n2 += (15 - n) * 4;
        } else {
            Protocol1_12_2To1_13.LOGGER.warning("Why does this block have the banner block entity? :(" + String.valueOf(compoundTag));
        }
        ListTag<CompoundTag> listTag = compoundTag.getListTag("Patterns", CompoundTag.class);
        if (listTag != null) {
            object = listTag.iterator();
            while (object.hasNext()) {
                CompoundTag compoundTag2 = (CompoundTag)object.next();
                NumberTag numberTag2 = compoundTag2.getNumberTag("Color");
                if (numberTag2 == null) continue;
                compoundTag2.putInt("Color", 15 - numberTag2.asInt());
            }
        }
        if ((object = compoundTag.getStringTag("CustomName")) != null) {
            ((StringTag)object).setValue(ComponentUtil.legacyToJsonString(((StringTag)object).getValue()));
        }
        return n2;
    }
}

