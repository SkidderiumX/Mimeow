/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter.block;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockRewriter1_21_5<C extends ClientboundPacketType>
extends BlockRewriter<C> {
    public BlockRewriter1_21_5(Protocol<C, ?, ?, ?> protocol, BlockRewriter.ChunkTypeSupplier chunkTypeSupplier, @Nullable BlockRewriter.ChunkTypeSupplier chunkTypeSupplier2) {
        super(protocol, Types.BLOCK_POSITION1_14, Types.TRUSTED_COMPOUND_TAG, chunkTypeSupplier, chunkTypeSupplier2);
    }

    public BlockRewriter1_21_5(Protocol<C, ?, ?, ?> protocol, BlockRewriter.ChunkTypeSupplier chunkTypeSupplier) {
        this(protocol, chunkTypeSupplier, null);
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        CompoundTag compoundTag = blockEntity.tag();
        if (compoundTag == null) {
            return;
        }
        FullMappings fullMappings = this.protocol.getMappingData().getBlockEntityMappings();
        if (fullMappings != null && this.protocol.getComponentRewriter() != null && (blockEntity.typeId() == fullMappings.mappedId("sign") || blockEntity.typeId() == fullMappings.mappedId("hanging_sign"))) {
            this.updateSignMessages(userConnection, compoundTag.getCompoundTag("front_text"));
            this.updateSignMessages(userConnection, compoundTag.getCompoundTag("back_text"));
        }
    }

    public void updateSignMessages(UserConnection userConnection, CompoundTag compoundTag) {
        if (compoundTag == null) {
            return;
        }
        ListTag<?> listTag = compoundTag.getListTag("messages");
        this.protocol.getComponentRewriter().processTag(userConnection, listTag);
        ListTag<?> listTag2 = compoundTag.getListTag("filtered_messages");
        if (listTag2 != null) {
            this.protocol.getComponentRewriter().processTag(userConnection, listTag2);
        }
    }
}

