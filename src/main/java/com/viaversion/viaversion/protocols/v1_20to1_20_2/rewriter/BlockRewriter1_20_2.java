/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.data.PotionEffects1_20_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;

public class BlockRewriter1_20_2
extends BlockRewriter<ClientboundPackets1_19_4> {
    public BlockRewriter1_20_2(Protocol<ClientboundPackets1_19_4, ?, ?, ?> protocol) {
        super(protocol, Types.BLOCK_POSITION1_14, Types.NAMED_COMPOUND_TAG, ChunkType1_18::new, ChunkType1_20_2::new);
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        Tag tag;
        CompoundTag compoundTag = blockEntity.tag();
        if (compoundTag == null) {
            return;
        }
        Tag tag2 = compoundTag.remove("Primary");
        if (tag2 instanceof NumberTag && ((NumberTag)tag2).asInt() != 0) {
            compoundTag.put("primary_effect", new StringTag(PotionEffects1_20_2.idToKeyOrLuck(((NumberTag)tag2).asInt() - 1)));
        }
        if ((tag = compoundTag.remove("Secondary")) instanceof NumberTag && ((NumberTag)tag).asInt() != 0) {
            compoundTag.put("secondary_effect", new StringTag(PotionEffects1_20_2.idToKeyOrLuck(((NumberTag)tag).asInt() - 1)));
        }
    }
}

