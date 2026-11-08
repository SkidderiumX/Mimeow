/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_2to1_20.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.data.PotionEffects1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.util.Key;

public class BlockRewriter1_20_2
extends BlockRewriter<ClientboundPackets1_20_2> {
    public BlockRewriter1_20_2(Protocol<ClientboundPackets1_20_2, ?, ?, ?> protocol) {
        super(protocol, Types.BLOCK_POSITION1_14, Types.NAMED_COMPOUND_TAG, ChunkType1_20_2::new, ChunkType1_18::new);
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        Object object;
        Object object2;
        CompoundTag compoundTag = blockEntity.tag();
        if (compoundTag == null) {
            return;
        }
        Tag tag = compoundTag.remove("primary_effect");
        if (tag instanceof StringTag) {
            object2 = Key.stripMinecraftNamespace(((StringTag)tag).getValue());
            compoundTag.putInt("Primary", PotionEffects1_20_2.keyToId((String)object2) + 1);
        }
        if ((object2 = compoundTag.remove("secondary_effect")) instanceof StringTag) {
            object = Key.stripMinecraftNamespace(((StringTag)object2).getValue());
            compoundTag.putInt("Secondary", PotionEffects1_20_2.keyToId((String)object) + 1);
        }
        if ((object = compoundTag.getCompoundTag("SkullOwner")) != null && !((CompoundTag)object).contains("Id") && ((CompoundTag)object).contains("Properties")) {
            ((CompoundTag)object).put("Id", new IntArrayTag(new int[]{0, 0, 0, 0}));
        }
    }
}

