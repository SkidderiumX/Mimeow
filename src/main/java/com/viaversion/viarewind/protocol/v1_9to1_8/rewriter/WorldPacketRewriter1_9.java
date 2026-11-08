/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.data.EffectIdMappings1_8;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Environment;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_8;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_1;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import java.util.ArrayList;

public class WorldPacketRewriter1_9
extends RewriterBase<Protocol1_9To1_8> {
    public WorldPacketRewriter1_9(Protocol1_9To1_8 protocol1_9To1_8) {
        super(protocol1_9To1_8);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    CompoundTag compoundTag;
                    CompoundTag compoundTag2 = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    Tag tag = compoundTag2.remove("SpawnData");
                    if (tag instanceof CompoundTag && (tag = (compoundTag = (CompoundTag)tag).remove("id")) instanceof StringTag) {
                        compoundTag2.put("EntityId", tag);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n >= 219 && n <= 234) {
                        packetWrapper.set(Types.VAR_INT, 0, 130);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.CUSTOM_SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    string = ((Protocol1_9To1_8)WorldPacketRewriter1_9.this.protocol).getMappingData().getMappedNamedSound(string);
                    if (string == null) {
                        return;
                    }
                    if (!string.isEmpty()) {
                        packetWrapper.set(Types.STRING, 0, string);
                    } else {
                        packetWrapper.cancel();
                    }
                });
                this.read(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.UNSIGNED_BYTE);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.FORGET_LEVEL_CHUNK, ClientboundPackets1_8.LEVEL_CHUNK, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    Environment environment = ((ClientWorld)packetWrapper.user().getClientWorld(Protocol1_9To1_8.class)).getEnvironment();
                    int n = packetWrapper.read(Types.INT);
                    int n2 = packetWrapper.read(Types.INT);
                    packetWrapper.write(ChunkType1_8.forEnvironment(environment), new BaseChunk(n, n2, true, false, 0, new ChunkSection[16], null, new ArrayList<CompoundTag>()));
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.LEVEL_CHUNK, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    Environment environment = ((ClientWorld)packetWrapper.user().getClientWorld(Protocol1_9To1_8.class)).getEnvironment();
                    Chunk chunk = packetWrapper.read(ChunkType1_9_1.forEnvironment(environment));
                    for (ChunkSection chunkSection : chunk.getSections()) {
                        if (chunkSection == null) continue;
                        DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
                        for (int i = 0; i < dataPalette.size(); ++i) {
                            int n = dataPalette.idByIndex(i);
                            int n2 = ((Protocol1_9To1_8)WorldPacketRewriter1_9.this.protocol).getItemRewriter().handleBlockId(n);
                            dataPalette.setIdByIndex(i, n2);
                        }
                    }
                    if (chunk.isFullChunk() && chunk.getBitmask() == 0) {
                        boolean bl = environment == Environment.NORMAL;
                        ChunkSection[] chunkSectionArray = new ChunkSection[16];
                        ChunkSectionImpl chunkSectionImpl = new ChunkSectionImpl(true);
                        chunkSectionArray[0] = chunkSectionImpl;
                        chunkSectionImpl.palette(PaletteType.BLOCKS).addId(0);
                        if (bl) {
                            chunkSectionImpl.getLight().setSkyLight(new byte[2048]);
                        }
                        chunk = new BaseChunk(chunk.getX(), chunk.getZ(), true, false, 1, chunkSectionArray, chunk.getBiomeData(), chunk.getBlockEntities());
                    }
                    packetWrapper.write(ChunkType1_8.forEnvironment(environment), chunk);
                    chunk.getBlockEntities().forEach(compoundTag -> {
                        short s;
                        if (!(compoundTag.contains("x") && compoundTag.contains("y") && compoundTag.contains("z") && compoundTag.contains("id"))) {
                            return;
                        }
                        BlockPosition blockPosition = new BlockPosition((Integer)compoundTag.get("x").getValue(), (Integer)compoundTag.get("y").getValue(), (Integer)compoundTag.get("z").getValue());
                        String string = (String)compoundTag.get("id").getValue();
                        switch (string) {
                            case "minecraft:mob_spawner": {
                                s = 1;
                                break;
                            }
                            case "minecraft:command_block": {
                                s = 2;
                                break;
                            }
                            case "minecraft:beacon": {
                                s = 3;
                                break;
                            }
                            case "minecraft:skull": {
                                s = 4;
                                break;
                            }
                            case "minecraft:flower_pot": {
                                s = 5;
                                break;
                            }
                            case "minecraft:banner": {
                                s = 6;
                                break;
                            }
                            default: {
                                return;
                            }
                        }
                        Object object = PacketWrapper.create(ClientboundPackets1_9.BLOCK_ENTITY_DATA, packetWrapper.user());
                        object.write(Types.BLOCK_POSITION1_8, blockPosition);
                        object.write(Types.UNSIGNED_BYTE, s);
                        object.write(Types.NAMED_COMPOUND_TAG, compoundTag);
                        object.scheduleSend(Protocol1_9To1_8.class, false);
                    });
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if ((n = EffectIdMappings1_8.getOldId(n)) == -1) {
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.set(Types.INT, 0, n);
                    if (n == 2001) {
                        int n2 = ((Protocol1_9To1_8)WorldPacketRewriter1_9.this.protocol).getItemRewriter().handleBlockId(packetWrapper.get(Types.INT, 1));
                        packetWrapper.set(Types.INT, 1, n2);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n > 41 && !ViaRewind.getConfig().isReplaceParticles()) {
                        packetWrapper.cancel();
                        return;
                    }
                    if (n == 42) {
                        packetWrapper.set(Types.INT, 0, 24);
                    } else if (n == 43) {
                        packetWrapper.set(Types.INT, 0, 3);
                    } else if (n == 44) {
                        packetWrapper.set(Types.INT, 0, 34);
                    } else if (n == 45) {
                        packetWrapper.set(Types.INT, 0, 1);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.read(Types.BOOLEAN);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.SOUND, ClientboundPackets1_8.CUSTOM_SOUND, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    int n2 = ((Protocol1_9To1_8)WorldPacketRewriter1_9.this.protocol).getMappingData().getFullSoundMappings().getNewId(n);
                    if (n2 == -1) {
                        packetWrapper.cancel();
                    } else {
                        packetWrapper.write(Types.STRING, ((Protocol1_9To1_8)WorldPacketRewriter1_9.this.protocol).getMappingData().getFullSoundMappings().mappedIdentifier(n2));
                    }
                });
                this.read(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.UNSIGNED_BYTE);
            }
        });
    }
}

