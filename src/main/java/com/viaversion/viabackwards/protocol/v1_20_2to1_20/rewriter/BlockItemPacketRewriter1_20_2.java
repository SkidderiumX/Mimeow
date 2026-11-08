/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_2to1_20.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.Protocol1_20_2To1_20;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.provider.AdvancementCriteriaProvider;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntityImpl;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter.RecipeRewriter1_20_2;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_20_2
extends BackwardsItemRewriter<ClientboundPackets1_20_2, ServerboundPackets1_19_4, Protocol1_20_2To1_20> {
    public BlockItemPacketRewriter1_20_2(Protocol1_20_2To1_20 protocol1_20_2To1_20) {
        super(protocol1_20_2To1_20, Types.ITEM1_20_2, Types.ITEM1_20_2_ARRAY, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20_2To1_20)this.protocol).cancelClientbound(ClientboundPackets1_20_2.CHUNK_BATCH_START);
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.CHUNK_BATCH_FINISHED, null, packetWrapper -> {
            packetWrapper.cancel();
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_20_2.CHUNK_BATCH_RECEIVED);
            packetWrapper2.write(Types.FLOAT, Float.valueOf(500.0f));
            packetWrapper2.sendToServer(Protocol1_20_2To1_20.class);
        });
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.FORGET_LEVEL_CHUNK, packetWrapper -> {
            ChunkPosition chunkPosition = packetWrapper.read(Types.CHUNK_POSITION);
            packetWrapper.write(Types.INT, chunkPosition.chunkX());
            packetWrapper.write(Types.INT, chunkPosition.chunkZ());
        });
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.MAP_ITEM_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BOOLEAN);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                int n = packetWrapper.passthrough(Types.VAR_INT);
                for (int i = 0; i < n; ++i) {
                    int n2 = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.write(Types.VAR_INT, n2 < 27 ? n2 : 2);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
                }
            }
        });
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.TAG_QUERY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.NAMED_COMPOUND_TAG, packetWrapper.read(Types.COMPOUND_TAG));
        });
        ((Protocol1_20_2To1_20)this.protocol).replaceClientbound(ClientboundPackets1_20_2.BLOCK_ENTITY_DATA, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            CompoundTag compoundTag = packetWrapper.read(Types.TRUSTED_COMPOUND_TAG);
            BlockEntityImpl blockEntityImpl = new BlockEntityImpl(BlockEntity.pack(blockPosition.x(), blockPosition.z()), (short)blockPosition.y(), n, compoundTag);
            ((Protocol1_20_2To1_20)this.protocol).getBlockRewriter().handleBlockEntity(packetWrapper.user(), blockEntityImpl);
            packetWrapper.write(Types.NAMED_COMPOUND_TAG, blockEntityImpl.tag());
        });
        ((Protocol1_20_2To1_20)this.protocol).registerServerbound(ServerboundPackets1_19_4.SET_BEACON, packetWrapper -> {
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) - 1);
            }
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) - 1);
            }
        });
        ((Protocol1_20_2To1_20)this.protocol).replaceClientbound(ClientboundPackets1_20_2.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.COMPONENT);
                    packetWrapper.passthrough(Types.COMPONENT);
                    this.passthroughClientboundItem(packetWrapper);
                    packetWrapper.passthrough(Types.VAR_INT);
                    int n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                AdvancementCriteriaProvider advancementCriteriaProvider = Via.getManager().getProviders().get(AdvancementCriteriaProvider.class);
                packetWrapper.write(Types.STRING_ARRAY, advancementCriteriaProvider.getCriteria(string));
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n3; ++j) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        });
        ((Protocol1_20_2To1_20)this.protocol).replaceClientbound(ClientboundPackets1_20_2.SET_EQUIPMENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    byte by;
                    do {
                        by = packetWrapper.passthrough(Types.BYTE);
                        packetWrapper.write(Types.ITEM1_13_2, BlockItemPacketRewriter1_20_2.this.handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_20_2)));
                    } while ((by & 0xFFFFFF80) != 0);
                });
            }
        });
        new RecipeRewriter1_20_2<ClientboundPackets1_20_2>(this.protocol){

            @Override
            protected Type<Item> mappedItemType() {
                return BlockItemPacketRewriter1_20_2.this.mappedItemType();
            }

            @Override
            protected Type<Item[]> mappedItemArrayType() {
                return BlockItemPacketRewriter1_20_2.this.mappedItemArrayType();
            }
        }.register(ClientboundPackets1_20_2.UPDATE_RECIPES);
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if (item.tag() != null) {
            com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter.BlockItemPacketRewriter1_20_2.to1_20_1Effects(item);
            CompoundTag compoundTag = item.tag().getCompoundTag("SkullOwner");
            if (compoundTag != null && !compoundTag.contains("Id") && compoundTag.contains("Properties")) {
                compoundTag.put("Id", new IntArrayTag(new int[]{0, 0, 0, 0}));
            }
        }
        return super.handleItemToClient(userConnection, item);
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if (item.tag() != null) {
            com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter.BlockItemPacketRewriter1_20_2.to1_20_2Effects(item);
        }
        return super.handleItemToServer(userConnection, item);
    }
}

