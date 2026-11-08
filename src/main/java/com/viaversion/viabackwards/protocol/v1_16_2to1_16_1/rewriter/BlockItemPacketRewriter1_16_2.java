/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.Protocol1_16_2To1_16_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord1_8;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16_2;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ServerboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_16_2
extends BackwardsItemRewriter<ClientboundPackets1_16_2, ServerboundPackets1_16, Protocol1_16_2To1_16_1> {
    public BlockItemPacketRewriter1_16_2(Protocol1_16_2To1_16_1 protocol1_16_2To1_16_1) {
        super(protocol1_16_2To1_16_1, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    protected void registerPackets() {
        new RecipeRewriter<ClientboundPackets1_16_2>(this.protocol).register(ClientboundPackets1_16_2.UPDATE_RECIPES);
        ((Protocol1_16_2To1_16_1)this.protocol).registerClientbound(ClientboundPackets1_16_2.RECIPE, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.read(Types.BOOLEAN);
        });
        ((Protocol1_16_2To1_16_1)this.protocol).getBlockRewriter().registerLevelChunk(ClientboundPackets1_16_2.LEVEL_CHUNK, ChunkType1_16_2.TYPE, ChunkType1_16.TYPE, (userConnection, chunk) -> {
            chunk.setIgnoreOldLightData(true);
            for (CompoundTag compoundTag : chunk.getBlockEntities()) {
                if (compoundTag == null) continue;
                this.handleBlockEntity(compoundTag);
            }
        });
        ((Protocol1_16_2To1_16_1)this.protocol).registerClientbound(ClientboundPackets1_16_2.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_16_2.this.handleBlockEntity(packetWrapper.passthrough(Types.NAMED_COMPOUND_TAG)));
            }
        });
        ((Protocol1_16_2To1_16_1)this.protocol).registerClientbound(ClientboundPackets1_16_2.SECTION_BLOCKS_UPDATE, ClientboundPackets1_16.CHUNK_BLOCKS_UPDATE, packetWrapper -> {
            long l = packetWrapper.read(Types.LONG);
            packetWrapper.read(Types.BOOLEAN);
            int n = (int)(l >> 42);
            int n2 = (int)(l << 44 >> 44);
            int n3 = (int)(l << 22 >> 42);
            packetWrapper.write(Types.INT, n);
            packetWrapper.write(Types.INT, n3);
            BlockChangeRecord[] blockChangeRecordArray = packetWrapper.read(Types.VAR_LONG_BLOCK_CHANGE_ARRAY);
            packetWrapper.write(Types.BLOCK_CHANGE_ARRAY, blockChangeRecordArray);
            for (int i = 0; i < blockChangeRecordArray.length; ++i) {
                BlockChangeRecord blockChangeRecord = blockChangeRecordArray[i];
                int n4 = ((Protocol1_16_2To1_16_1)this.protocol).getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId());
                blockChangeRecordArray[i] = new BlockChangeRecord1_8(blockChangeRecord.getSectionX(), blockChangeRecord.getY(n2), blockChangeRecord.getSectionZ(), n4);
            }
        });
        ((Protocol1_16_2To1_16_1)this.protocol).registerServerbound(ServerboundPackets1_16.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item != null && item.tag() != null) {
            this.addValueHashAsId(item.tag());
        }
        return super.handleItemToClient(userConnection, item);
    }

    private void handleBlockEntity(CompoundTag compoundTag) {
        String string = compoundTag.getString("id");
        if (string != null && Key.stripMinecraftNamespace(string).equals("skull")) {
            this.addValueHashAsId(compoundTag);
        }
    }

    private void addValueHashAsId(CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        CompoundTag compoundTag3 = compoundTag.getCompoundTag("SkullOwner");
        if (compoundTag3 == null) {
            return;
        }
        if (!compoundTag3.contains("Id")) {
            return;
        }
        CompoundTag compoundTag4 = compoundTag3.getCompoundTag("Properties");
        if (compoundTag4 == null) {
            return;
        }
        ListTag<CompoundTag> listTag = compoundTag4.getListTag("textures", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        CompoundTag compoundTag5 = compoundTag2 = !listTag.isEmpty() ? listTag.get(0) : null;
        if (compoundTag2 == null) {
            return;
        }
        int n = compoundTag2.get("Value").getValue().hashCode();
        int[] nArray = new int[]{n, 0, 0, 0};
        compoundTag3.put("Id", new IntArrayTag(nArray));
    }
}

