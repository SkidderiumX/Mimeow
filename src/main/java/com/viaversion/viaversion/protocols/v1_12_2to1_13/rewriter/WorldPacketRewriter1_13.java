/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_13;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.NamedSoundMappings1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.ParticleIdMappings1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.PaintingProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockStorage;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.util.IdAndData;
import com.viaversion.viaversion.util.Key;
import java.util.Iterator;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class WorldPacketRewriter1_13 {
    private static final IntSet VALID_BIOMES;

    public static void register(Protocol1_12_2To1_13 protocol1_12_2To1_13) {
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.handler(packetWrapper -> {
                    String string;
                    PaintingProvider paintingProvider = Via.getManager().getProviders().get(PaintingProvider.class);
                    Optional<Integer> optional = paintingProvider.getIntByIdentifier(string = packetWrapper.read(Types.STRING));
                    if (optional.isEmpty() && Via.getConfig().logOtherConversionWarnings()) {
                        Protocol1_12_2To1_13.LOGGER.warning("Could not find painting motive: " + string + " falling back to default (0)");
                    }
                    packetWrapper.write(Types.VAR_INT, optional.orElse(0));
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    BlockStorage blockStorage;
                    BlockStorage.ReplacementData replacementData;
                    BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    BlockEntityProvider blockEntityProvider = Via.getManager().getProviders().get(BlockEntityProvider.class);
                    int n = blockEntityProvider.transform(packetWrapper.user(), blockPosition, compoundTag, true);
                    if (n != -1 && (replacementData = (blockStorage = packetWrapper.user().get(BlockStorage.class)).get(blockPosition)) != null) {
                        replacementData.setReplacement(n);
                    }
                    if (s == 5) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    short s2 = packetWrapper.get(Types.UNSIGNED_BYTE, 1);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 25) {
                        n = 73;
                    } else if (n == 33) {
                        n = 99;
                    } else if (n == 29) {
                        n = 92;
                    } else if (n == 54) {
                        n = 142;
                    } else if (n == 146) {
                        n = 305;
                    } else if (n == 130) {
                        n = 249;
                    } else if (n == 138) {
                        n = 257;
                    } else if (n == 52) {
                        n = 140;
                    } else if (n == 209) {
                        n = 472;
                    } else if (n >= 219 && n <= 234) {
                        n = n - 219 + 483;
                    }
                    if (n == 73) {
                        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_13.BLOCK_UPDATE);
                        packetWrapper2.write(Types.BLOCK_POSITION1_8, blockPosition);
                        packetWrapper2.write(Types.VAR_INT, 249 + s * 24 * 2 + s2 * 2);
                        packetWrapper2.send(Protocol1_12_2To1_13.class);
                    }
                    packetWrapper.set(Types.VAR_INT, 0, n);
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.BLOCK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                    int n = WorldPacketRewriter1_13.toNewId(packetWrapper.get(Types.VAR_INT, 0));
                    UserConnection userConnection = packetWrapper.user();
                    if (Via.getConfig().isServersideBlockConnections()) {
                        n = ConnectionData.connect(userConnection, blockPosition, n);
                        ConnectionData.updateBlockStorage(userConnection, blockPosition.x(), blockPosition.y(), blockPosition.z(), n);
                    }
                    packetWrapper.set(Types.VAR_INT, 0, WorldPacketRewriter1_13.checkStorage(packetWrapper.user(), blockPosition, n));
                    if (Via.getConfig().isServersideBlockConnections()) {
                        packetWrapper.send(Protocol1_12_2To1_13.class);
                        packetWrapper.cancel();
                        ConnectionData.update(userConnection, blockPosition);
                    }
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.CHUNK_BLOCKS_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BLOCK_CHANGE_ARRAY);
                this.handler(packetWrapper -> {
                    BlockPosition blockPosition;
                    int n;
                    BlockChangeRecord[] blockChangeRecordArray;
                    int n2 = packetWrapper.get(Types.INT, 0);
                    int n3 = packetWrapper.get(Types.INT, 1);
                    UserConnection userConnection = packetWrapper.user();
                    for (BlockChangeRecord blockChangeRecord : blockChangeRecordArray = packetWrapper.get(Types.BLOCK_CHANGE_ARRAY, 0)) {
                        n = WorldPacketRewriter1_13.toNewId(blockChangeRecord.getBlockId());
                        blockPosition = new BlockPosition(blockChangeRecord.getSectionX() + (n2 << 4), blockChangeRecord.getY(), blockChangeRecord.getSectionZ() + (n3 << 4));
                        blockChangeRecord.setBlockId(WorldPacketRewriter1_13.checkStorage(packetWrapper.user(), blockPosition, n));
                        if (!Via.getConfig().isServersideBlockConnections()) continue;
                        ConnectionData.updateBlockStorage(userConnection, blockPosition.x(), blockPosition.y(), blockPosition.z(), n);
                    }
                    if (Via.getConfig().isServersideBlockConnections()) {
                        for (BlockChangeRecord blockChangeRecord : blockChangeRecordArray) {
                            n = blockChangeRecord.getBlockId();
                            blockPosition = new BlockPosition(blockChangeRecord.getSectionX() + n2 * 16, blockChangeRecord.getY(), blockChangeRecord.getSectionZ() + n3 * 16);
                            ConnectionHandler connectionHandler = ConnectionData.getConnectionHandler(n);
                            if (connectionHandler == null) continue;
                            n = connectionHandler.connect(userConnection, blockPosition, n);
                            blockChangeRecord.setBlockId(n);
                            ConnectionData.updateBlockStorage(userConnection, blockPosition.x(), blockPosition.y(), blockPosition.z(), n);
                        }
                        packetWrapper.send(Protocol1_12_2To1_13.class);
                        packetWrapper.cancel();
                        for (BlockChangeRecord blockChangeRecord : blockChangeRecordArray) {
                            BlockPosition blockPosition2 = new BlockPosition(blockChangeRecord.getSectionX() + n2 * 16, blockChangeRecord.getY(), blockChangeRecord.getSectionZ() + n3 * 16);
                            ConnectionData.update(userConnection, blockPosition2);
                        }
                    }
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                if (!Via.getConfig().isServersideBlockConnections()) {
                    return;
                }
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    UserConnection userConnection = packetWrapper.user();
                    int n2 = (int)Math.floor(packetWrapper.get(Types.FLOAT, 0).floatValue());
                    int n3 = (int)Math.floor(packetWrapper.get(Types.FLOAT, 1).floatValue());
                    int n4 = (int)Math.floor(packetWrapper.get(Types.FLOAT, 2).floatValue());
                    int n5 = packetWrapper.get(Types.INT, 0);
                    BlockPosition[] blockPositionArray = new BlockPosition[n5];
                    for (n = 0; n < n5; ++n) {
                        BlockPosition blockPosition;
                        blockPositionArray[n] = blockPosition = new BlockPosition(n2 + packetWrapper.passthrough(Types.BYTE), (short)(n3 + packetWrapper.passthrough(Types.BYTE)), n4 + packetWrapper.passthrough(Types.BYTE));
                        ConnectionData.updateBlockStorage(userConnection, blockPosition.x(), blockPosition.y(), blockPosition.z(), 0);
                    }
                    packetWrapper.send(Protocol1_12_2To1_13.class);
                    packetWrapper.cancel();
                    for (n = 0; n < n5; ++n) {
                        ConnectionData.update(userConnection, blockPositionArray[n]);
                    }
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.FORGET_LEVEL_CHUNK, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    int n = packetWrapper.passthrough(Types.INT);
                    int n2 = packetWrapper.passthrough(Types.INT);
                    packetWrapper.user().get(BlockStorage.class).removeChunk(n, n2);
                    if (Via.getConfig().isServersideBlockConnections()) {
                        ConnectionData.blockConnectionProvider.unloadChunk(packetWrapper.user(), n, n2);
                    }
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.CUSTOM_SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = Key.stripMinecraftNamespace(packetWrapper.get(Types.STRING, 0));
                    String string2 = NamedSoundMappings1_13.getNewId(string);
                    packetWrapper.set(Types.STRING, 0, string2);
                });
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.LEVEL_CHUNK, packetWrapper -> {
            int n;
            int n2;
            int n3;
            Object t = packetWrapper.user().getClientWorld(Protocol1_12_2To1_13.class);
            BlockStorage blockStorage = packetWrapper.user().get(BlockStorage.class);
            ChunkType1_9_3 chunkType1_9_3 = ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment());
            ChunkType1_13 chunkType1_13 = ChunkType1_13.forEnvironment(((ClientWorld)t).getEnvironment());
            Chunk chunk = packetWrapper.read(chunkType1_9_3);
            packetWrapper.write(chunkType1_13, chunk);
            for (n3 = 0; n3 < chunk.getSections().length; ++n3) {
                int n4;
                DataPalette dataPalette;
                block21: {
                    block20: {
                        ChunkSection chunkSection = chunk.getSections()[n3];
                        if (chunkSection == null) continue;
                        dataPalette = chunkSection.palette(PaletteType.BLOCKS);
                        for (n2 = 0; n2 < dataPalette.size(); ++n2) {
                            n4 = dataPalette.idByIndex(n2);
                            int n5 = WorldPacketRewriter1_13.toNewId(n4);
                            dataPalette.setIdByIndex(n2, n5);
                        }
                        if (!chunk.isFullChunk()) break block20;
                        n2 = 0;
                        for (n4 = 0; n4 < dataPalette.size(); ++n4) {
                            if (!blockStorage.isWelcome(dataPalette.idByIndex(n4))) continue;
                            n2 = 1;
                            break;
                        }
                        if (n2 == 0) break block21;
                    }
                    for (n2 = 0; n2 < 4096; ++n2) {
                        n4 = dataPalette.idAt(n2);
                        BlockPosition blockPosition = new BlockPosition(ChunkSection.xFromIndex(n2) + (chunk.getX() << 4), ChunkSection.yFromIndex(n2) + (n3 << 4), ChunkSection.zFromIndex(n2) + (chunk.getZ() << 4));
                        if (blockStorage.isWelcome(n4)) {
                            blockStorage.store(blockPosition, n4);
                            continue;
                        }
                        if (chunk.isFullChunk()) continue;
                        blockStorage.remove(blockPosition);
                    }
                }
                if (!Via.getConfig().isServersideBlockConnections() || !ConnectionData.needStoreBlocks()) continue;
                if (!chunk.isFullChunk()) {
                    ConnectionData.blockConnectionProvider.unloadChunkSection(packetWrapper.user(), chunk.getX(), n3, chunk.getZ());
                }
                n2 = 0;
                for (n4 = 0; n4 < dataPalette.size(); ++n4) {
                    if (!ConnectionData.isWelcome(dataPalette.idByIndex(n4))) continue;
                    n2 = 1;
                    break;
                }
                if (n2 == 0) continue;
                for (n4 = 0; n4 < 4096; ++n4) {
                    int n6 = dataPalette.idAt(n4);
                    if (!ConnectionData.isWelcome(n6)) continue;
                    n = ChunkSection.xFromIndex(n4) + (chunk.getX() << 4);
                    int n7 = ChunkSection.yFromIndex(n4) + (n3 << 4);
                    int n8 = ChunkSection.zFromIndex(n4) + (chunk.getZ() << 4);
                    ConnectionData.blockConnectionProvider.storeBlock(packetWrapper.user(), n, n7, n8, n6);
                }
            }
            if (chunk.isBiomeData()) {
                n3 = Integer.MIN_VALUE;
                for (int i = 0; i < 256; ++i) {
                    int n9 = chunk.getBiomeData()[i];
                    if (VALID_BIOMES.contains(n9)) continue;
                    if (n9 != 255 && n3 != n9) {
                        if (Via.getConfig().logOtherConversionWarnings()) {
                            Protocol1_12_2To1_13.LOGGER.warning("Received invalid biome id: " + n9);
                        }
                        n3 = n9;
                    }
                    chunk.getBiomeData()[i] = 1;
                }
            }
            BlockEntityProvider blockEntityProvider = Via.getManager().getProviders().get(BlockEntityProvider.class);
            Iterator<CompoundTag> iterator2 = chunk.getBlockEntities().iterator();
            while (iterator2.hasNext()) {
                String string;
                StringTag stringTag;
                CompoundTag compoundTag = iterator2.next();
                n2 = blockEntityProvider.transform(packetWrapper.user(), null, compoundTag, false);
                if (n2 != -1) {
                    short s;
                    int n10 = compoundTag.getNumberTag("x").asInt();
                    BlockPosition blockPosition = new BlockPosition(n10, s = compoundTag.getNumberTag("y").asShort(), n = compoundTag.getNumberTag("z").asInt());
                    BlockStorage.ReplacementData replacementData = blockStorage.get(blockPosition);
                    if (replacementData != null) {
                        replacementData.setReplacement(n2);
                    }
                    chunk.getSections()[s >> 4].palette(PaletteType.BLOCKS).setIdAt(n10 & 0xF, s & 0xF, n & 0xF, n2);
                }
                if ((stringTag = compoundTag.getStringTag("id")) == null || !(string = Key.namespaced(stringTag.getValue())).equals("minecraft:noteblock") && !string.equals("minecraft:flower_pot")) continue;
                iterator2.remove();
            }
            if (Via.getConfig().isServersideBlockConnections()) {
                ConnectionData.connectBlocks(packetWrapper.user(), chunk);
                packetWrapper.send(Protocol1_12_2To1_13.class);
                packetWrapper.cancel();
                ConnectionData.NeighbourUpdater neighbourUpdater = new ConnectionData.NeighbourUpdater(packetWrapper.user());
                for (n2 = 0; n2 < chunk.getSections().length; ++n2) {
                    ChunkSection chunkSection = chunk.getSections()[n2];
                    if (chunkSection == null) continue;
                    neighbourUpdater.updateChunkSectionNeighbours(chunk.getX(), chunk.getZ(), n2);
                }
            }
        });
        protocol1_12_2To1_13.registerClientbound(ClientboundPackets1_12_1.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = 0;
                    if (n == 37 || n == 38 || n == 46) {
                        n2 = 1;
                    } else if (n == 36) {
                        n2 = 2;
                    }
                    Integer[] integerArray = new Integer[n2];
                    for (int i = 0; i < integerArray.length; ++i) {
                        integerArray[i] = packetWrapper.read(Types.VAR_INT);
                    }
                    Particle particle = ParticleIdMappings1_13.rewriteParticle(n, integerArray);
                    if (particle == null || particle.id() == -1) {
                        packetWrapper.cancel();
                        return;
                    }
                    if (particle.id() == 11) {
                        int n3 = packetWrapper.get(Types.INT, 1);
                        float f = packetWrapper.get(Types.FLOAT, 6).floatValue();
                        if (n3 == 0) {
                            packetWrapper.set(Types.INT, 1, 1);
                            packetWrapper.set(Types.FLOAT, 6, Float.valueOf(0.0f));
                            for (int i = 0; i < 3; ++i) {
                                float f2 = packetWrapper.get(Types.FLOAT, i + 3).floatValue();
                                float f3 = WorldPacketRewriter1_13.redstoneDustColor(f, f2, i == 0);
                                particle.getArgument(i).setValue(Float.valueOf(f3));
                                packetWrapper.set(Types.FLOAT, i + 3, Float.valueOf(0.0f));
                            }
                        } else if (Via.getConfig().isMultiReddustColorFix()) {
                            packetWrapper.cancel();
                            boolean bl = packetWrapper.get(Types.BOOLEAN, 0);
                            float f4 = packetWrapper.get(Types.FLOAT, 0).floatValue();
                            float f5 = packetWrapper.get(Types.FLOAT, 1).floatValue();
                            float f6 = packetWrapper.get(Types.FLOAT, 2).floatValue();
                            float f7 = packetWrapper.get(Types.FLOAT, 3).floatValue();
                            float f8 = packetWrapper.get(Types.FLOAT, 4).floatValue();
                            float f9 = packetWrapper.get(Types.FLOAT, 5).floatValue();
                            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                            for (int i = 0; i < n3; ++i) {
                                float f10 = (float)((double)f4 + threadLocalRandom.nextGaussian() * (double)f7);
                                float f11 = (float)((double)f5 + threadLocalRandom.nextGaussian() * (double)f8);
                                float f12 = (float)((double)f6 + threadLocalRandom.nextGaussian() * (double)f9);
                                WorldPacketRewriter1_13.sendRedstoneParticle(packetWrapper, bl, f10, f11, f12, WorldPacketRewriter1_13.redstoneDustColor((float)threadLocalRandom.nextGaussian(), f, true), WorldPacketRewriter1_13.redstoneDustColor((float)threadLocalRandom.nextGaussian(), f, false), WorldPacketRewriter1_13.redstoneDustColor((float)threadLocalRandom.nextGaussian(), f, false));
                            }
                            return;
                        }
                    }
                    packetWrapper.set(Types.INT, 0, particle.id());
                    for (Particle.ParticleData<?> particleData : particle.getArguments()) {
                        particleData.write(packetWrapper);
                    }
                });
            }
        });
        protocol1_12_2To1_13.registerServerbound(ServerboundPackets1_13.USE_ITEM_ON, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_8);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            if (Via.getConfig().isServersideBlockConnections() && ConnectionData.needStoreBlocks()) {
                ConnectionData.markModified(packetWrapper.user(), blockPosition);
            }
        });
        protocol1_12_2To1_13.registerServerbound(ServerboundPackets1_13.PLAYER_ACTION, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_8);
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            if (n == 0 && Via.getConfig().isServersideBlockConnections() && ConnectionData.needStoreBlocks()) {
                ConnectionData.markModified(packetWrapper.user(), blockPosition);
            }
        });
    }

    private static float redstoneDustColor(float f, float f2, boolean bl) {
        float f3 = f * f2;
        if (bl && f3 == 0.0f) {
            return 1.0f;
        }
        return (float)((int)(f3 * 255.0f) & 0xFF) / 255.0f;
    }

    private static void sendRedstoneParticle(PacketWrapper packetWrapper, boolean bl, float f, float f2, float f3, float f4, float f5, float f6) {
        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_13.LEVEL_PARTICLES);
        packetWrapper2.write(Types.INT, 11);
        packetWrapper2.write(Types.BOOLEAN, bl);
        packetWrapper2.write(Types.FLOAT, Float.valueOf(f));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(f2));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(f3));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
        packetWrapper2.write(Types.INT, 0);
        packetWrapper2.write(Types.FLOAT, Float.valueOf(f4));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(f5));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(f6));
        packetWrapper2.write(Types.FLOAT, Float.valueOf(1.0f));
        packetWrapper2.send(Protocol1_12_2To1_13.class);
    }

    public static int toNewId(int n) {
        int n2;
        if (n < 0) {
            n = 0;
        }
        if ((n2 = Protocol1_12_2To1_13.MAPPINGS.getBlockMappings().getNewId(n)) != -1) {
            return n2;
        }
        n2 = Protocol1_12_2To1_13.MAPPINGS.getBlockMappings().getNewId(IdAndData.removeData(n));
        if (n2 != -1) {
            if (Via.getConfig().logOtherConversionWarnings()) {
                Protocol1_12_2To1_13.LOGGER.warning("Missing block " + n);
            }
            return n2;
        }
        if (Via.getConfig().logOtherConversionWarnings()) {
            Protocol1_12_2To1_13.LOGGER.warning("Missing block completely " + n);
        }
        return 0;
    }

    private static int checkStorage(UserConnection userConnection, BlockPosition blockPosition, int n) {
        BlockStorage blockStorage = userConnection.get(BlockStorage.class);
        if (blockStorage.contains(blockPosition)) {
            BlockStorage.ReplacementData replacementData = blockStorage.get(blockPosition);
            if (replacementData.getOriginal() == n) {
                if (replacementData.getReplacement() != -1) {
                    return replacementData.getReplacement();
                }
            } else {
                blockStorage.remove(blockPosition);
                if (blockStorage.isWelcome(n)) {
                    blockStorage.store(blockPosition, n);
                }
            }
        } else if (blockStorage.isWelcome(n)) {
            blockStorage.store(blockPosition, n);
        }
        return n;
    }

    static {
        int n;
        VALID_BIOMES = new IntOpenHashSet(70);
        for (n = 0; n < 50; ++n) {
            VALID_BIOMES.add(n);
        }
        VALID_BIOMES.add(127);
        for (n = 129; n <= 134; ++n) {
            VALID_BIOMES.add(n);
        }
        VALID_BIOMES.add(140);
        VALID_BIOMES.add(149);
        VALID_BIOMES.add(151);
        for (n = 155; n <= 158; ++n) {
            VALID_BIOMES.add(n);
        }
        for (n = 160; n <= 167; ++n) {
            VALID_BIOMES.add(n);
        }
    }
}

