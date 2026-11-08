/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_9_3to1_9_1;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_9_3to1_9_1.data.BlockEntity1_9_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_1;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;

public class Protocol1_9_3To1_9_1
extends BackwardsProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9, ServerboundPackets1_9_3, ServerboundPackets1_9> {
    public Protocol1_9_3To1_9_1() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 9) {
                        BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                        CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                        packetWrapper.clearPacket();
                        packetWrapper.setPacketType(ClientboundPackets1_9.UPDATE_SIGN);
                        packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition);
                        for (int i = 0; i < 4; ++i) {
                            StringTag stringTag = compoundTag.getStringTag("Text" + (i + 1));
                            String string = stringTag != null ? stringTag.getValue() : "";
                            packetWrapper.write(Types.STRING, string);
                        }
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_9_3To1_9_1.class);
            ChunkType1_9_3 chunkType1_9_3 = ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment());
            ChunkType1_9_1 chunkType1_9_1 = ChunkType1_9_1.forEnvironment(((ClientWorld)t).getEnvironment());
            Chunk chunk = packetWrapper.read(chunkType1_9_3);
            packetWrapper.write(chunkType1_9_1, chunk);
            BlockEntity1_9_1.handle(chunk.getBlockEntities(), packetWrapper.user());
        });
        this.registerClientbound(ClientboundPackets1_9_3.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_9_3To1_9_1.class);
                    int n = packetWrapper.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_9_3To1_9_1.class);
                    int n = packetWrapper.get(Types.INT, 0);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        JsonNBTComponentRewriter<ClientboundPackets1_9_3> jsonNBTComponentRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_9_3>(this, ComponentRewriterBase.ReadType.JSON);
        jsonNBTComponentRewriter.registerComponentPacket(ClientboundPackets1_9_3.CHAT);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
    }
}

