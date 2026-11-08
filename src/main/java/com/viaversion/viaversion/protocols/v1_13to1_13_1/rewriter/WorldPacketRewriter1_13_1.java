/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13to1_13_1.rewriter;

import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.Protocol1_13To1_13_1;

public class WorldPacketRewriter1_13_1 {
    public static void register(final Protocol1_13To1_13_1 protocol1_13To1_13_1) {
        protocol1_13To1_13_1.registerClientbound(ClientboundPackets1_13.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_13To1_13_1.class);
            Chunk chunk = packetWrapper.passthrough(ChunkType1_13.forEnvironment(((ClientWorld)t).getEnvironment()));
            protocol1_13To1_13_1.getBlockRewriter().handleChunk(chunk);
        });
        protocol1_13To1_13_1.replaceClientbound(ClientboundPackets1_13.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n == 2000) {
                        int n2 = packetWrapper.get(Types.INT, 1);
                        switch (n2) {
                            case 1: {
                                packetWrapper.set(Types.INT, 1, 2);
                                break;
                            }
                            case 0: 
                            case 3: 
                            case 6: {
                                packetWrapper.set(Types.INT, 1, 4);
                                break;
                            }
                            case 2: 
                            case 5: 
                            case 8: {
                                packetWrapper.set(Types.INT, 1, 5);
                                break;
                            }
                            case 7: {
                                packetWrapper.set(Types.INT, 1, 3);
                                break;
                            }
                            default: {
                                packetWrapper.set(Types.INT, 1, 0);
                                break;
                            }
                        }
                    } else if (n == 1010) {
                        packetWrapper.set(Types.INT, 1, protocol1_13To1_13_1.getMappingData().getNewItemId(packetWrapper.get(Types.INT, 1)));
                    } else if (n == 2001) {
                        packetWrapper.set(Types.INT, 1, protocol1_13To1_13_1.getMappingData().getNewBlockStateId(packetWrapper.get(Types.INT, 1)));
                    }
                });
            }
        });
    }
}

