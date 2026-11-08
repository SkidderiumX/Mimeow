/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20to1_19_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_20to1_19_4.Protocol1_20To1_19_4;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.rewriter.BlockRewriter;

public class BlockPacketRewriter1_20
extends BlockRewriter<ClientboundPackets1_19_4> {
    public BlockPacketRewriter1_20(Protocol1_20To1_19_4 protocol1_20To1_19_4) {
        super(protocol1_20To1_19_4, Types.BLOCK_POSITION1_14, Types.NAMED_COMPOUND_TAG, ChunkType1_18::new, null);
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        CompoundTag compoundTag = blockEntity.tag();
        if (compoundTag == null || blockEntity.typeId() != 7 && blockEntity.typeId() != 8) {
            return;
        }
        Tag tag = compoundTag.remove("front_text");
        compoundTag.remove("back_text");
        if (tag instanceof CompoundTag) {
            Tag tag2;
            CompoundTag compoundTag2 = (CompoundTag)tag;
            this.writeMessages(compoundTag2, compoundTag, false);
            this.writeMessages(compoundTag2, compoundTag, true);
            Tag tag3 = compoundTag2.remove("color");
            if (tag3 != null) {
                compoundTag.put("Color", tag3);
            }
            if ((tag2 = compoundTag2.remove("has_glowing_text")) != null) {
                compoundTag.put("GlowingText", tag2);
            }
        }
    }

    private void writeMessages(CompoundTag compoundTag, CompoundTag compoundTag2, boolean bl) {
        ListTag<StringTag> listTag = compoundTag.getListTag(bl ? "filtered_messages" : "messages", StringTag.class);
        if (listTag == null) {
            return;
        }
        int n = 0;
        for (StringTag stringTag : listTag) {
            compoundTag2.put((bl ? "FilteredText" : "Text") + ++n, stringTag);
        }
    }
}

