/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter;

import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord1_16_2;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_17;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.Protocol1_16_4To1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import java.util.ArrayList;
import java.util.BitSet;

public class WorldPacketRewriter1_17 {
    public static void register(Protocol1_16_4To1_17 protocol1_16_4To1_17) {
        protocol1_16_4To1_17.registerClientbound(ClientboundPackets1_16_2.SET_BORDER, null, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            ClientboundPackets1_17 clientboundPackets1_17 = switch (n) {
                case 0 -> ClientboundPackets1_17.SET_BORDER_SIZE;
                case 1 -> ClientboundPackets1_17.SET_BORDER_LERP_SIZE;
                case 2 -> ClientboundPackets1_17.SET_BORDER_CENTER;
                case 3 -> ClientboundPackets1_17.INITIALIZE_BORDER;
                case 4 -> ClientboundPackets1_17.SET_BORDER_WARNING_DELAY;
                case 5 -> ClientboundPackets1_17.SET_BORDER_WARNING_DISTANCE;
                default -> throw new IllegalArgumentException("Invalid world border type received: " + n);
            };
            packetWrapper.setPacketType(clientboundPackets1_17);
        });
        protocol1_16_4To1_17.registerClientbound(ClientboundPackets1_16_2.LIGHT_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    int n2 = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(n));
                    packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(n2));
                    packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(packetWrapper.read(Types.VAR_INT)));
                    packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(packetWrapper.read(Types.VAR_INT)));
                    this.writeLightArrays(packetWrapper, n);
                    this.writeLightArrays(packetWrapper, n2);
                });
            }

            private void writeLightArrays(PacketWrapper packetWrapper, int n) {
                ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
                for (int i = 0; i < 18; ++i) {
                    if (!this.isSet(n, i)) continue;
                    arrayList.add(packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE));
                }
                packetWrapper.write(Types.VAR_INT, arrayList.size());
                for (byte[] byArray : arrayList) {
                    packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                }
            }

            private long[] toBitSetLongArray(int n) {
                return new long[]{n};
            }

            private boolean isSet(int n, int n2) {
                return (n & 1 << n2) != 0;
            }
        });
        protocol1_16_4To1_17.registerClientbound(ClientboundPackets1_16_2.LEVEL_CHUNK, packetWrapper -> {
            Chunk chunk = packetWrapper.read(ChunkType1_16_2.TYPE);
            if (!chunk.isFullChunk()) {
                WorldPacketRewriter1_17.writeMultiBlockChangePacket(packetWrapper, chunk);
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(new ChunkType1_17(chunk.getSections().length), chunk);
            chunk.setChunkMask(BitSet.valueOf(new long[]{chunk.getBitmask()}));
            protocol1_16_4To1_17.getBlockRewriter().handleChunk(chunk);
        });
    }

    private static void writeMultiBlockChangePacket(PacketWrapper packetWrapper, Chunk chunk) {
        long l = ((long)chunk.getX() & 0x3FFFFFL) << 42;
        l |= ((long)chunk.getZ() & 0x3FFFFFL) << 20;
        ChunkSection[] chunkSectionArray = chunk.getSections();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null) continue;
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_17.SECTION_BLOCKS_UPDATE);
            packetWrapper2.write(Types.LONG, l | (long)i & 0xFFFFFL);
            packetWrapper2.write(Types.BOOLEAN, true);
            BlockChangeRecord[] blockChangeRecordArray = new BlockChangeRecord[4096];
            DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
            int n = 0;
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    for (int i2 = 0; i2 < 16; ++i2) {
                        int n2 = Protocol1_16_4To1_17.MAPPINGS.getNewBlockStateId(dataPalette.idAt(j, k, i2));
                        blockChangeRecordArray[n++] = new BlockChangeRecord1_16_2(j, k, i2, n2);
                    }
                }
            }
            packetWrapper2.write(Types.VAR_LONG_BLOCK_CHANGE_ARRAY, blockChangeRecordArray);
            packetWrapper2.send(Protocol1_16_4To1_17.class);
        }
    }
}

