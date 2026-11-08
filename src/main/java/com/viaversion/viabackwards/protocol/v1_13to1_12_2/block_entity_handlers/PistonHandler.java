/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.Protocol1_13To1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.provider.BackwardsBlockEntityProvider;
import java.util.Map;
import java.util.StringJoiner;

public class PistonHandler
implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler {
    @Override
    public CompoundTag transform(int n, CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("blockState");
        if (compoundTag2 == null) {
            return compoundTag;
        }
        String string = this.getDataFromTag(compoundTag2);
        if (string == null) {
            return compoundTag;
        }
        int n2 = Protocol1_13To1_12_2.MAPPINGS.getPistonIds().getInt(string);
        if (n2 == -1) {
            return compoundTag;
        }
        compoundTag.putInt("blockId", n2 >> 4);
        compoundTag.putInt("blockData", n2 & 0xF);
        return compoundTag;
    }

    private String getDataFromTag(CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("Name");
        if (stringTag == null) {
            return null;
        }
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("Properties");
        if (compoundTag2 == null) {
            return stringTag.getValue();
        }
        StringJoiner stringJoiner = new StringJoiner(",", stringTag.getValue() + "[", "]");
        for (Map.Entry<String, Tag> entry : compoundTag2) {
            if (!(entry.getValue() instanceof StringTag)) continue;
            stringJoiner.add(entry.getKey() + "=" + ((StringTag)entry.getValue()).getValue());
        }
        return stringJoiner.toString();
    }
}

