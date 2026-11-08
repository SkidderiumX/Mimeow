/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.BulkChunkType1_8;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_8;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_1;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.EffectIdMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.PotionIdMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.SoundEffectMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.CommandBlockProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.HandItemProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.ClientWorld1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.Optional;

public class WorldPacketRewriter1_9 {
    public static void register(Protocol1_8To1_9 protocol1_8To1_9) {
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.UPDATE_SIGN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(packetWrapper -> {
                    for (int i = 0; i < 4; ++i) {
                        String string = packetWrapper.read(Types.STRING);
                        Protocol1_8To1_9.STRING_TO_JSON.write(packetWrapper, string);
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    n = EffectIdMappings1_9.getNewId(n);
                    packetWrapper.set(Types.INT, 0, n);
                });
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n == 2002) {
                        int n2 = packetWrapper.get(Types.INT, 1);
                        int n3 = PotionIdMappings1_9.getNewPotionID(n2);
                        packetWrapper.set(Types.INT, 1, n3);
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.CUSTOM_SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = Key.stripMinecraftNamespace(packetWrapper.get(Types.STRING, 0));
                    SoundEffectMappings1_9 soundEffectMappings1_9 = SoundEffectMappings1_9.getByName(string);
                    int n = 0;
                    String string2 = string;
                    if (soundEffectMappings1_9 != null) {
                        n = soundEffectMappings1_9.getCategory().getId();
                        string2 = soundEffectMappings1_9.getNewName();
                    }
                    packetWrapper.set(Types.STRING, 0, string2);
                    packetWrapper.write(Types.VAR_INT, n);
                    if (!Via.getConfig().cancelBlockSounds()) {
                        return;
                    }
                    if (soundEffectMappings1_9 != null && soundEffectMappings1_9.isBreakSound()) {
                        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        int n2 = packetWrapper.passthrough(Types.INT);
                        int n3 = packetWrapper.passthrough(Types.INT);
                        int n4 = packetWrapper.passthrough(Types.INT);
                        if (entityTracker1_9.interactedBlockRecently((int)Math.floor((double)n2 / 8.0), (int)Math.floor((double)n3 / 8.0), (int)Math.floor((double)n4 / 8.0))) {
                            packetWrapper.cancel();
                        }
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.LEVEL_CHUNK, packetWrapper -> {
            block6: {
                long l;
                Chunk chunk;
                ClientWorld1_9 clientWorld1_9;
                block5: {
                    clientWorld1_9 = (ClientWorld1_9)packetWrapper.user().getClientWorld(Protocol1_8To1_9.class);
                    chunk = packetWrapper.read(ChunkType1_8.forEnvironment(clientWorld1_9.getEnvironment()));
                    l = ChunkPosition.chunkKey(chunk.getX(), chunk.getZ());
                    if (!chunk.isFullChunk() || chunk.getBitmask() != 0) break block5;
                    packetWrapper.setPacketType(ClientboundPackets1_9.FORGET_LEVEL_CHUNK);
                    packetWrapper.write(Types.INT, chunk.getX());
                    packetWrapper.write(Types.INT, chunk.getZ());
                    CommandBlockProvider commandBlockProvider = Via.getManager().getProviders().get(CommandBlockProvider.class);
                    commandBlockProvider.unloadChunk(packetWrapper.user(), chunk.getX(), chunk.getZ());
                    clientWorld1_9.getLoadedChunks().remove(l);
                    if (!Via.getConfig().isChunkBorderFix()) break block6;
                    for (int i = -1; i <= 1; ++i) {
                        for (int j = -1; j <= 1; ++j) {
                            if (i == 0 && j == 0) continue;
                            int n = chunk.getX() + i;
                            int n2 = chunk.getZ() + j;
                            if (clientWorld1_9.getLoadedChunks().contains(ChunkPosition.chunkKey(n, n2))) continue;
                            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_9.FORGET_LEVEL_CHUNK);
                            packetWrapper2.write(Types.INT, n);
                            packetWrapper2.write(Types.INT, n2);
                            packetWrapper2.send(Protocol1_8To1_9.class);
                        }
                    }
                    break block6;
                }
                ChunkType1_9_1 chunkType1_9_1 = ChunkType1_9_1.forEnvironment(clientWorld1_9.getEnvironment());
                packetWrapper.write(chunkType1_9_1, chunk);
                clientWorld1_9.getLoadedChunks().add(l);
                if (Via.getConfig().isChunkBorderFix()) {
                    for (int i = -1; i <= 1; ++i) {
                        for (int j = -1; j <= 1; ++j) {
                            if (i == 0 && j == 0) continue;
                            int n = chunk.getX() + i;
                            int n3 = chunk.getZ() + j;
                            if (clientWorld1_9.getLoadedChunks().contains(ChunkPosition.chunkKey(n, n3))) continue;
                            PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_9.LEVEL_CHUNK);
                            BaseChunk baseChunk = new BaseChunk(n, n3, true, false, 0, new ChunkSection[16], new int[256], new ArrayList<CompoundTag>());
                            packetWrapper3.write(chunkType1_9_1, baseChunk);
                            packetWrapper3.send(Protocol1_8To1_9.class);
                        }
                    }
                }
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.MAP_BULK_CHUNK, null, packetWrapper -> {
            packetWrapper.cancel();
            ClientWorld1_9 clientWorld1_9 = (ClientWorld1_9)packetWrapper.user().getClientWorld(Protocol1_8To1_9.class);
            Chunk[] chunkArray = packetWrapper.read(BulkChunkType1_8.TYPE);
            ChunkType1_9_1 chunkType1_9_1 = ChunkType1_9_1.forEnvironment(clientWorld1_9.getEnvironment());
            for (Chunk chunk : chunkArray) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_9.LEVEL_CHUNK);
                packetWrapper2.write(chunkType1_9_1, chunk);
                packetWrapper2.send(Protocol1_8To1_9.class);
                clientWorld1_9.getLoadedChunks().add(ChunkPosition.chunkKey(chunk.getX(), chunk.getZ()));
            }
            if (!Via.getConfig().isChunkBorderFix()) {
                return;
            }
            for (Chunk chunk : chunkArray) {
                for (int i = -1; i <= 1; ++i) {
                    for (int j = -1; j <= 1; ++j) {
                        if (i == 0 && j == 0) continue;
                        int n = chunk.getX() + i;
                        int n2 = chunk.getZ() + j;
                        if (clientWorld1_9.getLoadedChunks().contains(ChunkPosition.chunkKey(n, n2))) continue;
                        PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_9.LEVEL_CHUNK);
                        BaseChunk baseChunk = new BaseChunk(n, n2, true, false, 0, new ChunkSection[16], new int[256], new ArrayList<CompoundTag>());
                        packetWrapper3.write(chunkType1_9_1, baseChunk);
                        packetWrapper3.send(Protocol1_8To1_9.class);
                    }
                }
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    Object object;
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    if (s == 1 && (object = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0)) != null) {
                        StringTag stringTag = ((CompoundTag)object).getStringTag("EntityId");
                        if (stringTag != null) {
                            String string = stringTag.getValue();
                            CompoundTag compoundTag = new CompoundTag();
                            compoundTag.putString("id", string);
                            ((CompoundTag)object).put("SpawnData", compoundTag);
                        } else {
                            CompoundTag compoundTag = new CompoundTag();
                            compoundTag.putString("id", "AreaEffectCloud");
                            ((CompoundTag)object).put("SpawnData", compoundTag);
                        }
                    }
                    if (s == 2) {
                        object = Via.getManager().getProviders().get(CommandBlockProvider.class);
                        ((CommandBlockProvider)object).addOrUpdateBlock(packetWrapper.user(), packetWrapper.get(Types.BLOCK_POSITION1_8, 0), packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0));
                        packetWrapper.cancel();
                    }
                });
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.SIGN_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(packetWrapper -> {
                    for (int i = 0; i < 4; ++i) {
                        String string = packetWrapper.read(Types.STRING);
                        packetWrapper.write(Types.COMPONENT, new JsonPrimitive(string));
                    }
                });
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.PLAYER_ACTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 6) {
                        packetWrapper.cancel();
                    }
                });
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if ((n == 5 || n == 4 || n == 3) && (entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class)).isBlocking()) {
                        entityTracker1_9.setBlocking(false);
                        if (!Via.getConfig().isShowShieldWhenSwordInHand()) {
                            entityTracker1_9.setSecondHand(null);
                        }
                    }
                });
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.USE_ITEM, null, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.clearInputBuffer();
            packetWrapper.setPacketType(ServerboundPackets1_8.USE_ITEM_ON);
            packetWrapper.write(Types.BLOCK_POSITION1_8, new BlockPosition(-1, -1, -1));
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)255);
            Item item = Via.getManager().getProviders().get(HandItemProvider.class).getHandItem(packetWrapper.user());
            if (Via.getConfig().isShieldBlocking() && packetWrapper.user().getProtocolInfo().protocolVersion().olderThan(ProtocolVersion.v1_21_4)) {
                boolean bl;
                EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                boolean bl2 = Via.getConfig().isShowShieldWhenSwordInHand();
                boolean bl3 = bl2 ? entityTracker1_9.hasSwordInHand() : (bl = item != null && Protocol1_8To1_9.isSword(item.identifier()));
                if (bl) {
                    boolean bl4;
                    if (n == 0 && !entityTracker1_9.isBlocking()) {
                        entityTracker1_9.setBlocking(true);
                        if (!bl2 && entityTracker1_9.getItemInSecondHand() == null) {
                            DataItem dataItem = new DataItem(442, 1, 0, null);
                            entityTracker1_9.setSecondHand(dataItem);
                        }
                    }
                    boolean bl5 = bl4 = Via.getConfig().isNoDelayShieldBlocking() && !bl2;
                    if (bl4 && n == 1 || !bl4 && n == 0) {
                        packetWrapper.cancel();
                    }
                } else {
                    if (!bl2) {
                        entityTracker1_9.setSecondHand(null);
                    }
                    entityTracker1_9.setBlocking(false);
                }
            }
            packetWrapper.write(Types.ITEM1_8, item);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)0);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)0);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)0);
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.USE_ITEM_ON, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT, Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    if (n != 0) {
                        packetWrapper.cancel();
                    }
                });
                this.handler(packetWrapper -> {
                    Item item = Via.getManager().getProviders().get(HandItemProvider.class).getHandItem(packetWrapper.user());
                    packetWrapper.write(Types.ITEM1_8, item);
                });
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    CommandBlockProvider commandBlockProvider = Via.getManager().getProviders().get(CommandBlockProvider.class);
                    BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                    Optional<CompoundTag> optional = commandBlockProvider.get(packetWrapper.user(), blockPosition);
                    if (optional.isPresent()) {
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_9.BLOCK_ENTITY_DATA, null, packetWrapper.user());
                        packetWrapper2.write(Types.BLOCK_POSITION1_8, blockPosition);
                        packetWrapper2.write(Types.UNSIGNED_BYTE, (short)2);
                        packetWrapper2.write(Types.NAMED_COMPOUND_TAG, optional.get());
                        packetWrapper2.scheduleSend(Protocol1_8To1_9.class);
                    }
                });
                if (!Via.getConfig().cancelBlockSounds()) {
                    return;
                }
                this.handler(packetWrapper -> {
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    if (s == 255) {
                        return;
                    }
                    BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                    int n = blockPosition.x();
                    int n2 = blockPosition.y();
                    int n3 = blockPosition.z();
                    switch (s) {
                        case 0: {
                            --n2;
                            break;
                        }
                        case 1: {
                            ++n2;
                            break;
                        }
                        case 2: {
                            --n3;
                            break;
                        }
                        case 3: {
                            ++n3;
                            break;
                        }
                        case 4: {
                            --n;
                            break;
                        }
                        case 5: {
                            ++n;
                        }
                    }
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.addBlockInteraction(new BlockPosition(n, n2, n3));
                });
            }
        });
    }
}

