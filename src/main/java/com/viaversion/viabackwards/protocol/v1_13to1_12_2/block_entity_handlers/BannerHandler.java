/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.Protocol1_13To1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.provider.BackwardsBlockEntityProvider;

public class BannerHandler
implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler {
    private static final int WALL_BANNER_START = 7110;
    private static final int WALL_BANNER_STOP = 7173;
    private static final int BANNER_START = 6854;
    private static final int BANNER_STOP = 7109;

    @Override
    public CompoundTag transform(int n, CompoundTag compoundTag) {
        if (n >= 6854 && n <= 7109) {
            var3_3 = n - 6854 >> 4;
            compoundTag.putInt("Base", 15 - var3_3);
        } else if (n >= 7110 && n <= 7173) {
            var3_3 = n - 7110 >> 2;
            compoundTag.putInt("Base", 15 - var3_3);
        } else {
            Protocol1_13To1_12_2.LOGGER.warning("Why does this block have the banner block entity? :(" + String.valueOf(compoundTag));
        }
        ListTag<CompoundTag> listTag = compoundTag.getListTag("Patterns", CompoundTag.class);
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                NumberTag numberTag = compoundTag2.getNumberTag("Color");
                if (numberTag == null) continue;
                compoundTag2.putInt("Color", 15 - numberTag.asInt());
            }
        }
        return compoundTag;
    }
}

