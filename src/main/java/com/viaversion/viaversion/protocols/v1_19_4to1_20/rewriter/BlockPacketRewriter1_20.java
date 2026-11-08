/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_4to1_20.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_4to1_20.Protocol1_19_4To1_20;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.util.ComponentUtil;

public class BlockPacketRewriter1_20
extends BlockRewriter<ClientboundPackets1_19_4> {
    public BlockPacketRewriter1_20(Protocol1_19_4To1_20 protocol1_19_4To1_20) {
        super(protocol1_19_4To1_20, Types.BLOCK_POSITION1_14, Types.NAMED_COMPOUND_TAG, ChunkType1_18::new, null);
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        Tag tag;
        Tag tag2;
        CompoundTag compoundTag = blockEntity.tag();
        if (blockEntity.tag() == null || blockEntity.typeId() != 7 && blockEntity.typeId() != 8) {
            return;
        }
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag.put("front_text", compoundTag2);
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        for (int i = 1; i < 5; ++i) {
            Tag tag3 = compoundTag.remove("Text" + i);
            listTag.add(tag3 instanceof StringTag ? (StringTag)tag3 : new StringTag(ComponentUtil.emptyJsonComponentString()));
        }
        compoundTag2.put("messages", listTag);
        ListTag<StringTag> listTag2 = new ListTag<StringTag>(StringTag.class);
        for (int i = 1; i < 5; ++i) {
            tag2 = compoundTag.remove("FilteredText" + i);
            listTag2.add(tag2 instanceof StringTag ? (StringTag)tag2 : listTag.get(i - 1));
        }
        if (!listTag2.equals(listTag)) {
            compoundTag2.put("filtered_messages", listTag2);
        }
        if ((tag = compoundTag.remove("Color")) != null) {
            compoundTag2.put("color", tag);
        }
        if ((tag2 = compoundTag.remove("GlowingText")) != null) {
            compoundTag2.put("has_glowing_text", tag2);
        }
    }
}

