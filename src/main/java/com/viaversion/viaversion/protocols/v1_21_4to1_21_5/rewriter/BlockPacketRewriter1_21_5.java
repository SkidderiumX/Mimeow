/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;

public class BlockPacketRewriter1_21_5
extends BlockRewriter<ClientboundPacket1_21_2> {
    private static final int SIGN_BOCK_ENTITY_ID = 7;
    private static final int HANGING_SIGN_BOCK_ENTITY_ID = 8;
    private final Protocol1_21_4To1_21_5 protocol;

    public BlockPacketRewriter1_21_5(Protocol1_21_4To1_21_5 protocol1_21_4To1_21_5) {
        super(protocol1_21_4To1_21_5, Types.BLOCK_POSITION1_14, Types.TRUSTED_COMPOUND_TAG, ChunkType1_20_2::new, ChunkType1_21_5::new);
        this.protocol = protocol1_21_4To1_21_5;
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        String string;
        CompoundTag compoundTag = blockEntity.tag();
        if (compoundTag == null) {
            return;
        }
        if (blockEntity.typeId() == 7 || blockEntity.typeId() == 8) {
            this.updateSignMessages(userConnection, compoundTag.getCompoundTag("front_text"));
            this.updateSignMessages(userConnection, compoundTag.getCompoundTag("back_text"));
        }
        if ((string = compoundTag.getString("CustomName")) != null) {
            compoundTag.put("CustomName", this.protocol.getComponentRewriter().uglyJsonToTag(userConnection, string));
        }
    }

    private void updateSignMessages(UserConnection userConnection, CompoundTag compoundTag) {
        if (compoundTag == null) {
            return;
        }
        ListTag<StringTag> listTag = compoundTag.getListTag("messages", StringTag.class);
        compoundTag.put("messages", this.protocol.getComponentRewriter().updateComponentList(userConnection, listTag, true));
        ListTag<StringTag> listTag2 = compoundTag.getListTag("filtered_messages", StringTag.class);
        if (listTag2 != null) {
            compoundTag.put("filtered_messages", this.protocol.getComponentRewriter().updateComponentList(userConnection, listTag2, true));
        }
    }
}

