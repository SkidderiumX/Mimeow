/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;

public record LockCode(CompoundTag tag) implements Rewritable,
Copyable
{
    public static final Type<LockCode> TYPE = TransformingType.of(Types.COMPOUND_TAG, LockCode.class, LockCode::new, LockCode::tag);

    @Override
    public LockCode rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        CompoundTag compoundTag = this.tag;
        if (bl && protocol.getComponentRewriter() != null) {
            compoundTag = this.tag.copy();
            compoundTag.putString("id", "air");
            protocol.getComponentRewriter().handleShowItem(userConnection, compoundTag);
            compoundTag.remove("id");
            FullMappings fullMappings = protocol.getMappingData().getFullItemMappings();
            Tag tag = compoundTag.get("items");
            if (tag != null) {
                HolderSet holderSet = HolderSet.fromTag(tag, string -> fullMappings.id((String)string));
                holderSet.rewrite(fullMappings::getNewId);
                compoundTag.put("items", this.toTag(holderSet, fullMappings));
            }
        }
        return new LockCode(compoundTag);
    }

    private Tag toTag(HolderSet holderSet, FullMappings fullMappings) {
        if (holderSet.hasTagKey()) {
            return new StringTag("#" + holderSet.tagKey());
        }
        int[] nArray = holderSet.ids();
        if (nArray.length == 1) {
            return new StringTag(fullMappings.mappedIdentifier(nArray[0]));
        }
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        for (int n : nArray) {
            listTag.add(new StringTag(fullMappings.mappedIdentifier(n)));
        }
        return listTag;
    }

    @Override
    public LockCode copy() {
        return new LockCode(this.tag.copy());
    }
}

