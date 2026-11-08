/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.Protocol1_21_5To1_21_4;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.rewriter.BlockRewriter;

public class BlockPacketRewriter1_21_5
extends BlockRewriter<ClientboundPacket1_21_5> {
    private static final int SIGN_BOCK_ENTITY_ID = 7;
    private static final int HANGING_SIGN_BOCK_ENTITY_ID = 8;
    private final Protocol1_21_5To1_21_4 protocol;

    public BlockPacketRewriter1_21_5(Protocol1_21_5To1_21_4 protocol1_21_5To1_21_4) {
        super(protocol1_21_5To1_21_4, Types.BLOCK_POSITION1_14, Types.COMPOUND_TAG, ChunkType1_21_5::new, ChunkType1_20_2::new);
        this.protocol = protocol1_21_5To1_21_4;
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        Tag tag;
        CompoundTag compoundTag = blockEntity.tag();
        if (compoundTag == null) {
            return;
        }
        if (blockEntity.typeId() == 7 || blockEntity.typeId() == 8) {
            this.updateSignMessages(userConnection, compoundTag.getCompoundTag("front_text"));
            this.updateSignMessages(userConnection, compoundTag.getCompoundTag("back_text"));
        }
        if ((tag = compoundTag.get("CustomName")) != null) {
            compoundTag.putString("CustomName", this.protocol.getComponentRewriter().toUglyJson(userConnection, tag));
        }
    }

    private void updateSignMessages(UserConnection userConnection, CompoundTag compoundTag) {
        if (compoundTag == null) {
            return;
        }
        ListTag<?> listTag = compoundTag.getListTag("messages");
        compoundTag.put("messages", this.protocol.getComponentRewriter().updateComponentList(userConnection, listTag));
        ListTag<?> listTag2 = compoundTag.getListTag("filtered_messages");
        if (listTag2 != null) {
            compoundTag.put("filtered_messages", this.protocol.getComponentRewriter().updateComponentList(userConnection, listTag2));
        }
    }
}

