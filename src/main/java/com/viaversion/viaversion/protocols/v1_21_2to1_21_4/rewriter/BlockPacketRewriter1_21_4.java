/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.util.TagUtil;

public class BlockPacketRewriter1_21_4
extends BlockRewriter<ClientboundPacket1_21_2> {
    public BlockPacketRewriter1_21_4(Protocol1_21_2To1_21_4 protocol1_21_2To1_21_4) {
        super(protocol1_21_2To1_21_4, Types.BLOCK_POSITION1_14, Types.TRUSTED_COMPOUND_TAG, ChunkType1_20_2::new, null);
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        if (blockEntity.tag() == null) {
            return;
        }
        CompoundTag compoundTag = blockEntity.tag().getCompoundTag("item");
        if (compoundTag == null) {
            return;
        }
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("components");
        if (compoundTag2 == null) {
            return;
        }
        NumberTag numberTag = TagUtil.getNamespacedNumberTag(compoundTag2, "custom_model_data");
        if (numberTag != null) {
            ListTag<FloatTag> listTag = new ListTag<FloatTag>(FloatTag.class);
            listTag.add(new FloatTag(numberTag.asFloat()));
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag3.put("floats", listTag);
            TagUtil.removeNamespaced(compoundTag2, "custom_model_data");
            compoundTag2.put("custom_model_data", compoundTag3);
        }
    }
}

