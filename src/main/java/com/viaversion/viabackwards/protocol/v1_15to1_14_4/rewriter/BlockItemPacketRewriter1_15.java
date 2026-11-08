/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_15to1_14_4.rewriter;

import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_15to1_14_4.Protocol1_15To1_14_4;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_14;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_15;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.rewriter.RecipeRewriter;

public class BlockItemPacketRewriter1_15
extends BackwardsItemRewriter<ClientboundPackets1_15, ServerboundPackets1_14, Protocol1_15To1_14_4> {
    public BlockItemPacketRewriter1_15(Protocol1_15To1_14_4 protocol1_15To1_14_4) {
        super(protocol1_15To1_14_4, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    protected void registerPackets() {
        new RecipeRewriter<ClientboundPackets1_15>(this.protocol).register(ClientboundPackets1_15.UPDATE_RECIPES);
        ((Protocol1_15To1_14_4)this.protocol).registerServerbound(ServerboundPackets1_14.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
        ((Protocol1_15To1_14_4)this.protocol).registerClientbound(ClientboundPackets1_15.LEVEL_CHUNK, packetWrapper -> {
            Chunk chunk = packetWrapper.read(ChunkType1_15.TYPE);
            packetWrapper.write(ChunkType1_14.TYPE, chunk);
            if (chunk.isFullChunk()) {
                int[] nArray = chunk.getBiomeData();
                int[] nArray2 = new int[256];
                for (int i = 0; i < 4; ++i) {
                    for (int j = 0; j < 4; ++j) {
                        int n = j << 2;
                        int n2 = i << 2;
                        int n3 = n2 << 4 | n;
                        int n4 = i << 2 | j;
                        int n5 = nArray[n4];
                        for (int k = 0; k < 4; ++k) {
                            int n6 = n3 + (k << 4);
                            for (int i2 = 0; i2 < 4; ++i2) {
                                nArray2[n6 + i2] = n5;
                            }
                        }
                    }
                }
                chunk.setBiomeData(nArray2);
            }
            ((Protocol1_15To1_14_4)this.protocol).getBlockRewriter().handleChunk(chunk);
        });
        ((Protocol1_15To1_14_4)this.protocol).replaceClientbound(ClientboundPackets1_15.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.DOUBLE, Types.FLOAT);
                this.map(Types.DOUBLE, Types.FLOAT);
                this.map(Types.DOUBLE, Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.INT, 0);
                    if (n2 == 3 || n2 == 23) {
                        n = packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.set(Types.VAR_INT, 0, ((Protocol1_15To1_14_4)BlockItemPacketRewriter1_15.this.protocol).getMappingData().getNewBlockStateId(n));
                    } else if (n2 == 32) {
                        Item item = BlockItemPacketRewriter1_15.this.handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_13_2));
                        packetWrapper.write(Types.ITEM1_13_2, item);
                    }
                    n = ((Protocol1_15To1_14_4)BlockItemPacketRewriter1_15.this.protocol).getMappingData().getNewParticleId(n2);
                    if (n2 != n) {
                        packetWrapper.set(Types.INT, 0, n);
                    }
                });
            }
        });
    }
}

