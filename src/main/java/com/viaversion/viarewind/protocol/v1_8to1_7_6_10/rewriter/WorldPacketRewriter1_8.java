/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter;

import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viarewind.api.type.chunk.BulkChunkType1_7_6;
import com.viaversion.viarewind.api.type.chunk.ChunkType1_7_6;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.Particles1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.WorldBorderEmulator;
import com.viaversion.viarewind.utils.ChatUtil;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.FixedByteArrayType;
import com.viaversion.viaversion.api.type.types.chunk.BulkChunkType1_8;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.util.ChatColorUtil;
import com.viaversion.viaversion.util.IdAndData;

public class WorldPacketRewriter1_8
extends RewriterBase<Protocol1_8To1_7_6_10> {
    public WorldPacketRewriter1_8(Protocol1_8To1_7_6_10 protocol1_8To1_7_6_10) {
        super(protocol1_8To1_7_6_10);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_8To1_7_6_10.class);
            Chunk chunk = packetWrapper.read(ChunkType1_8.forEnvironment(((ClientWorld)t).getEnvironment()));
            ((Protocol1_8To1_7_6_10)this.protocol).getItemRewriter().handleChunk(chunk);
            packetWrapper.write(ChunkType1_7_6.TYPE, chunk);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.BLOCK_UPDATE, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.U_BYTE_POSITION);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    n = ((Protocol1_8To1_7_6_10)WorldPacketRewriter1_8.this.protocol).getItemRewriter().handleBlockId(n);
                    packetWrapper.write(Types.VAR_INT, IdAndData.getId(n));
                    packetWrapper.write(Types.UNSIGNED_BYTE, (short)IdAndData.getData(n));
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.CHUNK_BLOCKS_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    BlockChangeRecord[] blockChangeRecordArray = packetWrapper.read(Types.BLOCK_CHANGE_ARRAY);
                    packetWrapper.write(Types.SHORT, (short)blockChangeRecordArray.length);
                    packetWrapper.write(Types.INT, blockChangeRecordArray.length * 4);
                    for (BlockChangeRecord blockChangeRecord : blockChangeRecordArray) {
                        packetWrapper.write(Types.SHORT, (short)(blockChangeRecord.getSectionX() << 12 | blockChangeRecord.getSectionZ() << 8 | blockChangeRecord.getY()));
                        packetWrapper.write(Types.SHORT, (short)((Protocol1_8To1_7_6_10)WorldPacketRewriter1_8.this.protocol).getItemRewriter().handleBlockId(blockChangeRecord.getBlockId()));
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.SHORT_POSITION);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.BLOCK_DESTRUCTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.INT_POSITION);
                this.map(Types.BYTE);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.MAP_BULK_CHUNK, packetWrapper -> {
            Chunk[] chunkArray;
            for (Chunk chunk : chunkArray = packetWrapper.read(BulkChunkType1_8.TYPE)) {
                ((Protocol1_8To1_7_6_10)this.protocol).getItemRewriter().handleChunk(chunk);
            }
            packetWrapper.write(BulkChunkType1_7_6.TYPE, chunkArray);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.BYTE_POSITION);
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.INT);
                    Particles1_8 particles1_8 = Particles1_8.find(n);
                    if (particles1_8 == null) {
                        particles1_8 = Particles1_8.CRIT;
                    }
                    packetWrapper.write(Types.STRING, particles1_8.name);
                });
                this.read(Types.BOOLEAN);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object object = packetWrapper.get(Types.STRING, 0);
                    Particles1_8 particles1_8 = Particles1_8.find((String)object);
                    if (particles1_8 == Particles1_8.ICON_CRACK || particles1_8 == Particles1_8.BLOCK_CRACK || particles1_8 == Particles1_8.BLOCK_DUST) {
                        int n;
                        int n2 = packetWrapper.read(Types.VAR_INT);
                        int n3 = n = particles1_8 == Particles1_8.ICON_CRACK ? packetWrapper.read(Types.VAR_INT) : n2 / 4096;
                        if ((n2 %= 4096) >= 256 && n2 <= 422 || n2 >= 2256 && n2 <= 2267) {
                            particles1_8 = Particles1_8.ICON_CRACK;
                        } else if (n2 >= 0 && n2 <= 164 || n2 >= 170 && n2 <= 175) {
                            if (particles1_8 == Particles1_8.ICON_CRACK) {
                                particles1_8 = Particles1_8.BLOCK_CRACK;
                            }
                        } else {
                            packetWrapper.cancel();
                            return;
                        }
                        object = particles1_8.name + "_" + n2 + "_" + n;
                    }
                    packetWrapper.set(Types.STRING, 0, object);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.UPDATE_SIGN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.SHORT_POSITION);
                this.handler(packetWrapper -> {
                    for (int i = 0; i < 4; ++i) {
                        String string = packetWrapper.read(Types.STRING);
                        string = ChatUtil.jsonToLegacy(string);
                        if ((string = ChatUtil.removeUnusedColor(string, '0')).length() > 15 && (string = ChatColorUtil.stripColor(string)).length() > 15) {
                            string = string.substring(0, 15);
                        }
                        packetWrapper.write(Types.STRING, string);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.MAP_ITEM_DATA, packetWrapper -> {
            int n;
            int n2;
            int n3;
            packetWrapper.cancel();
            int n4 = packetWrapper.read(Types.VAR_INT);
            byte by = packetWrapper.read(Types.BYTE);
            int n5 = packetWrapper.read(Types.VAR_INT);
            byte[] byArray = new byte[n5 * 4];
            for (n3 = 0; n3 < n5; ++n3) {
                n2 = packetWrapper.read(Types.BYTE).byteValue();
                byArray[n3 * 4] = (byte)(n2 >> 4 & 0xF);
                byArray[n3 * 4 + 1] = packetWrapper.read(Types.BYTE);
                byArray[n3 * 4 + 2] = packetWrapper.read(Types.BYTE);
                byArray[n3 * 4 + 3] = (byte)(n2 & 0xF);
            }
            n3 = packetWrapper.read(Types.UNSIGNED_BYTE).shortValue();
            if (n3 > 0) {
                n2 = packetWrapper.read(Types.UNSIGNED_BYTE).shortValue();
                n = packetWrapper.read(Types.UNSIGNED_BYTE).shortValue();
                short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                byte[] byArray2 = packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                for (int i = 0; i < n3; ++i) {
                    byte[] byArray3 = new byte[n2 + 3];
                    byArray3[0] = 0;
                    byArray3[1] = (byte)(n + i);
                    byArray3[2] = (byte)s;
                    for (int j = 0; j < n2; ++j) {
                        byArray3[j + 3] = byArray2[i + j * n3];
                    }
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_8.MAP_ITEM_DATA, packetWrapper.user());
                    packetWrapper2.write(Types.VAR_INT, n4);
                    packetWrapper2.write(Types.SHORT, (short)byArray3.length);
                    packetWrapper2.write(new FixedByteArrayType(byArray3.length), byArray3);
                    packetWrapper2.send(Protocol1_8To1_7_6_10.class);
                }
            }
            if (n5 > 0) {
                byte[] byArray4 = new byte[n5 * 3 + 1];
                byArray4[0] = 1;
                for (n = 0; n < n5; ++n) {
                    byArray4[n * 3 + 1] = (byte)(byArray[n * 4] << 4 | byArray[n * 4 + 3] & 0xF);
                    byArray4[n * 3 + 2] = byArray[n * 4 + 1];
                    byArray4[n * 3 + 3] = byArray[n * 4 + 2];
                }
                PacketWrapper packetWrapper3 = PacketWrapper.create(ClientboundPackets1_8.MAP_ITEM_DATA, packetWrapper.user());
                packetWrapper3.write(Types.VAR_INT, n4);
                packetWrapper3.write(Types.SHORT, (short)byArray4.length);
                packetWrapper3.write(new FixedByteArrayType(byArray4.length), byArray4);
                packetWrapper3.send(Protocol1_8To1_7_6_10.class);
            }
            PacketWrapper packetWrapper4 = PacketWrapper.create(ClientboundPackets1_8.MAP_ITEM_DATA, packetWrapper.user());
            packetWrapper4.write(Types.VAR_INT, n4);
            packetWrapper4.write(Types.SHORT, (short)2);
            packetWrapper4.write(new FixedByteArrayType(2), new byte[]{2, by});
            packetWrapper4.send(Protocol1_8To1_7_6_10.class);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.SHORT_POSITION);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG, RewindTypes.COMPRESSED_NBT);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).cancelClientbound(ClientboundPackets1_8.CHANGE_DIFFICULTY);
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_BORDER, null, packetWrapper -> {
            WorldBorderEmulator worldBorderEmulator = packetWrapper.user().get(WorldBorderEmulator.class);
            packetWrapper.cancel();
            int n = packetWrapper.read(Types.VAR_INT);
            if (n == 0) {
                worldBorderEmulator.setSize(packetWrapper.read(Types.DOUBLE));
            } else if (n == 1) {
                worldBorderEmulator.lerpSize(packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.VAR_LONG));
            } else if (n == 2) {
                worldBorderEmulator.setCenter(packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.DOUBLE));
            } else if (n == 3) {
                worldBorderEmulator.init(packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.VAR_LONG));
            }
        });
    }
}

