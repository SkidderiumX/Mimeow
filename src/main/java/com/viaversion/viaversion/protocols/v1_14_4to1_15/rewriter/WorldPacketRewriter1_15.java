/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_14_4to1_15.rewriter;

import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_14;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_15;
import com.viaversion.viaversion.protocols.v1_14_3to1_14_4.packet.ClientboundPackets1_14_4;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.Protocol1_14_4To1_15;

public class WorldPacketRewriter1_15 {
    public static void register(final Protocol1_14_4To1_15 protocol1_14_4To1_15) {
        protocol1_14_4To1_15.getBlockRewriter().registerLevelChunk(ClientboundPackets1_14_4.LEVEL_CHUNK, ChunkType1_14.TYPE, ChunkType1_15.TYPE, (userConnection, chunk) -> {
            if (chunk.isFullChunk()) {
                int[] nArray = chunk.getBiomeData();
                int[] nArray2 = new int[1024];
                if (nArray != null) {
                    int n;
                    for (n = 0; n < 4; ++n) {
                        for (int i = 0; i < 4; ++i) {
                            int n2 = (i << 2) + 2;
                            int n3 = (n << 2) + 2;
                            int n4 = n3 << 4 | n2;
                            nArray2[n << 2 | i] = nArray[n4];
                        }
                    }
                    for (n = 1; n < 64; ++n) {
                        System.arraycopy(nArray2, 0, nArray2, n * 16, 16);
                    }
                }
                chunk.setBiomeData(nArray2);
            }
        });
        protocol1_14_4To1_15.replaceClientbound(ClientboundPackets1_14_4.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT, Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n == 3 || n == 23) {
                        int n2 = packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.set(Types.VAR_INT, 0, protocol1_14_4To1_15.getMappingData().getNewBlockStateId(n2));
                    } else if (n == 32) {
                        protocol1_14_4To1_15.getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                    }
                });
            }
        });
    }
}

