/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v26_2to26_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v26_2to26_1.Protocol26_2To26_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntityImpl;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys26_2;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPacket26_1;

public class BlockItemPacketRewriter26_2
extends BackwardsStructuredItemRewriter<ClientboundPacket26_1, ServerboundPacket26_1, Protocol26_2To26_1> {
    private static final int BED_BLOCK_ENTITY_TYPE_ID = 25;

    public BlockItemPacketRewriter26_2(Protocol26_2To26_1 protocol26_2To26_1) {
        super(protocol26_2To26_1);
    }

    @Override
    protected void registerPackets() {
        ((Protocol26_2To26_1)this.protocol).replaceClientbound(ClientboundPackets26_1.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            Chunk chunk = ((Protocol26_2To26_1)this.protocol).getBlockRewriter().handleChunk1_18(packetWrapper);
            ((Protocol26_2To26_1)this.protocol).getBlockRewriter().handleBlockEntities(chunk, packetWrapper.user());
            Object t = packetWrapper.user().getEntityTracker(Protocol26_2To26_1.class);
            for (int i = 0; i < chunk.getSections().length; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection.getNonAirBlocksCount() == 0) continue;
                DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
                int n = i;
                dataPalette.forEachMatchingCoordinate(BlockItemPacketRewriter26_2::bedBlockState, n2 -> {
                    byte by = (byte)(ChunkSection.xFromIndex(n2) << 4 | ChunkSection.zFromIndex(n2));
                    short s = (short)(ChunkSection.yFromIndex(n2) + t.currentMinY() + (n << 4));
                    chunk.blockEntities().add(new BlockEntityImpl(by, s, 25, new CompoundTag()));
                });
            }
        });
        ((Protocol26_2To26_1)this.protocol).replaceClientbound(ClientboundPackets26_1.BLOCK_UPDATE, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = ((Protocol26_2To26_1)this.protocol).getMappingData().getNewBlockStateId(n);
            packetWrapper.write(Types.VAR_INT, n2);
            if (BlockItemPacketRewriter26_2.bedBlockState(n)) {
                BlockItemPacketRewriter26_2.sendBedEntity(packetWrapper.user(), blockPosition);
            }
        });
        ((Protocol26_2To26_1)this.protocol).replaceClientbound(ClientboundPackets26_1.SECTION_BLOCKS_UPDATE, packetWrapper -> {
            long l = packetWrapper.passthrough(Types.LONG);
            int n = (int)(l >> 42);
            int n2 = (int)(l << 44 >> 44);
            int n3 = (int)(l << 22 >> 42);
            for (BlockChangeRecord blockChangeRecord : packetWrapper.passthrough(Types.VAR_LONG_BLOCK_CHANGE_ARRAY)) {
                int n4 = blockChangeRecord.getBlockId();
                blockChangeRecord.setBlockId(((Protocol26_2To26_1)this.protocol).getMappingData().getNewBlockStateId(n4));
                if (!BlockItemPacketRewriter26_2.bedBlockState(n4)) continue;
                int n5 = blockChangeRecord.getSectionX() + (n << 4);
                int n6 = blockChangeRecord.getSectionY() + (n2 << 4);
                int n7 = blockChangeRecord.getSectionZ() + (n3 << 4);
                BlockItemPacketRewriter26_2.sendBedEntity(packetWrapper.user(), new BlockPosition(n5, n6, n7));
            }
        });
    }

    private static boolean bedBlockState(int n) {
        return n >= 1931 && n <= 2186;
    }

    private static void sendBedEntity(UserConnection userConnection, BlockPosition blockPosition) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets26_1.BLOCK_ENTITY_DATA, userConnection);
        packetWrapper.write(Types.BLOCK_POSITION1_14, blockPosition);
        packetWrapper.write(Types.VAR_INT, 25);
        packetWrapper.write(Types.TRUSTED_COMPOUND_TAG, new CompoundTag());
        packetWrapper.send(Protocol26_2To26_1.class);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v26_1to26_2.rewriter.BlockItemPacketRewriter26_2.downgradeData((StructuredDataKeys26_2)((Types1_20_5)((Protocol26_2To26_1)this.protocol).types()).structuredDataKeys(), structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v26_1to26_2.rewriter.BlockItemPacketRewriter26_2.upgradeData(structuredDataContainer);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
    }
}

