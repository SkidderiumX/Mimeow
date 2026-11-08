/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13_1to1_13.rewriter;

import com.viaversion.viabackwards.protocol.v1_13_1to1_13.Protocol1_13_1To1_13;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.rewriter.BlockRewriter;

public class WorldPacketRewriter1_13_1 {
    public static void register(final Protocol1_13_1To1_13 protocol1_13_1To1_13) {
        BlockRewriter<ClientboundPackets1_13> blockRewriter = BlockRewriter.legacy(protocol1_13_1To1_13);
        protocol1_13_1To1_13.registerClientbound(ClientboundPackets1_13.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_13_1To1_13.class);
            Chunk chunk = packetWrapper.passthrough(ChunkType1_13.forEnvironment(((ClientWorld)t).getEnvironment()));
            blockRewriter.handleChunk(chunk);
        });
        blockRewriter.registerBlockEvent(ClientboundPackets1_13.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_13.BLOCK_UPDATE);
        blockRewriter.registerChunkBlocksUpdate(ClientboundPackets1_13.CHUNK_BLOCKS_UPDATE);
        protocol1_13_1To1_13.registerClientbound(ClientboundPackets1_13.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 1);
                    if (n == 1010) {
                        packetWrapper.set(Types.INT, 1, protocol1_13_1To1_13.getMappingData().getNewItemId(n2));
                    } else if (n == 2001) {
                        packetWrapper.set(Types.INT, 1, protocol1_13_1To1_13.getMappingData().getNewBlockStateId(n2));
                    } else if (n == 2000) {
                        switch (n2) {
                            case 0: 
                            case 1: {
                                BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                                BlockFace blockFace = n2 == 0 ? BlockFace.BOTTOM : BlockFace.TOP;
                                packetWrapper.set(Types.BLOCK_POSITION1_8, 0, blockPosition.getRelative(blockFace));
                                packetWrapper.set(Types.INT, 1, 4);
                                break;
                            }
                            case 2: {
                                packetWrapper.set(Types.INT, 1, 1);
                                break;
                            }
                            case 3: {
                                packetWrapper.set(Types.INT, 1, 7);
                                break;
                            }
                            case 4: {
                                packetWrapper.set(Types.INT, 1, 3);
                                break;
                            }
                            case 5: {
                                packetWrapper.set(Types.INT, 1, 5);
                            }
                        }
                    }
                });
            }
        });
    }
}

