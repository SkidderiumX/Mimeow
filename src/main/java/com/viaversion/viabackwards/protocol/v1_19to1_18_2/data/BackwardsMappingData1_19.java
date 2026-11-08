/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.data.BackwardsMappingDataLoader;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.Protocol1_18_2To1_19;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsMappingData1_19
extends BackwardsMappingData {
    private final Int2ObjectMap<CompoundTag> defaultChatTypes = new Int2ObjectOpenHashMap<CompoundTag>();

    public BackwardsMappingData1_19() {
        super("1.19", "1.18", Protocol1_18_2To1_19.class);
    }

    @Override
    protected void loadExtras(CompoundTag compoundTag) {
        if (ViaBackwards.getConfig().sculkShriekerToCryingObsidian()) {
            for (int i = 18900; i <= 18907; ++i) {
                this.blockStateMappings.setNewId(i, 16082);
            }
            this.itemMappings.setNewId(329, 1065);
        }
        super.loadExtras(compoundTag);
        ListTag<CompoundTag> listTag = BackwardsMappingDataLoader.INSTANCE.loadNBT("chat-types-1.19.1.nbt").getListTag("values", CompoundTag.class);
        for (CompoundTag compoundTag2 : listTag) {
            NumberTag numberTag = compoundTag2.getNumberTag("id");
            this.defaultChatTypes.put(numberTag.asInt(), compoundTag2);
        }
    }

    public @Nullable CompoundTag chatType(int n) {
        return (CompoundTag)this.defaultChatTypes.get(n);
    }
}

