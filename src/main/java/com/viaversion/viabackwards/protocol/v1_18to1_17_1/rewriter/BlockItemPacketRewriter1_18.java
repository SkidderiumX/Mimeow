/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_18to1_17_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_18to1_17_1.Protocol1_18To1_17_1;
import com.viaversion.viabackwards.protocol.v1_18to1_17_1.data.BlockEntityMappings1_17_1;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_17;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.BitSet;

public class BlockItemPacketRewriter1_18
extends BackwardsItemRewriter<ClientboundPackets1_18, ServerboundPackets1_17, Protocol1_18To1_17_1> {
    public BlockItemPacketRewriter1_18(Protocol1_18To1_17_1 protocol1_18To1_17_1) {
        super(protocol1_18To1_17_1, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    protected void registerPackets() {
        new RecipeRewriter<ClientboundPackets1_18>(this.protocol).register(ClientboundPackets1_18.UPDATE_RECIPES);
        ((Protocol1_18To1_17_1)this.protocol).registerClientbound(ClientboundPackets1_18.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 1);
                    if (n == 1010) {
                        packetWrapper.set(Types.INT, 1, ((Protocol1_18To1_17_1)BlockItemPacketRewriter1_18.this.protocol).getMappingData().getNewItemId(n2));
                    }
                });
            }
        });
        ((Protocol1_18To1_17_1)this.protocol).replaceClientbound(ClientboundPackets1_18.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.INT, 0);
                    if (n2 == 3) {
                        int n3 = packetWrapper.read(Types.VAR_INT);
                        if (n3 == 7786) {
                            packetWrapper.set(Types.INT, 0, 3);
                        } else {
                            packetWrapper.set(Types.INT, 0, 2);
                        }
                        return;
                    }
                    ParticleMappings particleMappings = ((Protocol1_18To1_17_1)BlockItemPacketRewriter1_18.this.protocol).getMappingData().getParticleMappings();
                    if (particleMappings.isBlockParticle(n2)) {
                        n = packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.set(Types.VAR_INT, 0, ((Protocol1_18To1_17_1)BlockItemPacketRewriter1_18.this.protocol).getMappingData().getNewBlockStateId(n));
                    } else if (particleMappings.isItemParticle(n2)) {
                        BlockItemPacketRewriter1_18.this.passthroughClientboundItem(packetWrapper);
                    }
                    n = ((Protocol1_18To1_17_1)BlockItemPacketRewriter1_18.this.protocol).getMappingData().getNewParticleId(n2);
                    if (n != n2) {
                        packetWrapper.set(Types.INT, 0, n);
                    }
                });
            }
        });
        ((Protocol1_18To1_17_1)this.protocol).registerClientbound(ClientboundPackets1_18.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    CompoundTag compoundTag = packetWrapper.read(Types.NAMED_COMPOUND_TAG);
                    int n2 = BlockEntityMappings1_17_1.mappedId(n);
                    if (n2 == -1) {
                        packetWrapper.cancel();
                        return;
                    }
                    String string = (String)((Protocol1_18To1_17_1)BlockItemPacketRewriter1_18.this.protocol).getMappingData().blockEntities().get(n);
                    if (string == null) {
                        packetWrapper.cancel();
                        return;
                    }
                    CompoundTag compoundTag2 = compoundTag == null ? new CompoundTag() : compoundTag;
                    BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_14, 0);
                    compoundTag2.putString("id", Key.namespaced(string));
                    compoundTag2.putInt("x", blockPosition.x());
                    compoundTag2.putInt("y", blockPosition.y());
                    compoundTag2.putInt("z", blockPosition.z());
                    BlockItemPacketRewriter1_18.this.handleSpawner(n, compoundTag2);
                    packetWrapper.write(Types.UNSIGNED_BYTE, (short)n2);
                    packetWrapper.write(Types.NAMED_COMPOUND_TAG, compoundTag2);
                });
            }
        });
        ((Protocol1_18To1_17_1)this.protocol).registerClientbound(ClientboundPackets1_18.LEVEL_CHUNK_WITH_LIGHT, ClientboundPackets1_17_1.LEVEL_CHUNK, packetWrapper -> {
            int n;
            Object object2;
            Object e = ((Protocol1_18To1_17_1)this.protocol).getEntityRewriter().tracker(packetWrapper.user());
            ChunkType1_18 chunkType1_18 = new ChunkType1_18(e.currentWorldSectionHeight(), MathUtil.ceilLog2(((Protocol1_18To1_17_1)this.protocol).getMappingData().getBlockStateMappings().mappedSize()), MathUtil.ceilLog2(e.biomesSent()));
            Chunk chunk = packetWrapper.read(chunkType1_18);
            ChunkSection[] chunkSectionArray = chunk.getSections();
            BitSet bitSet = new BitSet(chunk.getSections().length);
            int[] nArray = new int[chunkSectionArray.length * 64];
            int n2 = 0;
            for (int i = 0; i < chunkSectionArray.length; ++i) {
                object2 = chunkSectionArray[i];
                DataPalette object3 = object2.palette(PaletteType.BIOMES);
                for (int n3 = 0; n3 < 64; ++n3) {
                    nArray[n2++] = object3.idAt(n3);
                }
                if (object2.getNonAirBlocksCount() == 0) {
                    chunkSectionArray[i] = null;
                    continue;
                }
                bitSet.set(i);
            }
            ArrayList<CompoundTag> arrayList = new ArrayList<CompoundTag>(chunk.blockEntities().size());
            for (BlockEntity blockEntity : chunk.blockEntities()) {
                CompoundTag compoundTag;
                String string = (String)((Protocol1_18To1_17_1)this.protocol).getMappingData().blockEntities().get(blockEntity.typeId());
                if (string == null) continue;
                if (blockEntity.tag() != null) {
                    compoundTag = blockEntity.tag();
                    this.handleSpawner(blockEntity.typeId(), compoundTag);
                } else {
                    compoundTag = new CompoundTag();
                }
                arrayList.add(compoundTag);
                compoundTag.putInt("x", (chunk.getX() << 4) + blockEntity.sectionX());
                compoundTag.putInt("y", blockEntity.y());
                compoundTag.putInt("z", (chunk.getZ() << 4) + blockEntity.sectionZ());
                compoundTag.putString("id", Key.namespaced(string));
            }
            object2 = new BaseChunk(chunk.getX(), chunk.getZ(), true, false, bitSet, chunk.getSections(), nArray, chunk.getHeightMap(), arrayList);
            packetWrapper.write(new ChunkType1_17(e.currentWorldSectionHeight()), object2);
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_17_1.LIGHT_UPDATE);
            packetWrapper2.write(Types.VAR_INT, object2.getX());
            packetWrapper2.write(Types.VAR_INT, object2.getZ());
            packetWrapper2.write(Types.BOOLEAN, packetWrapper.read(Types.BOOLEAN));
            packetWrapper2.write(Types.LONG_ARRAY_PRIMITIVE, packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE));
            packetWrapper2.write(Types.LONG_ARRAY_PRIMITIVE, packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE));
            packetWrapper2.write(Types.LONG_ARRAY_PRIMITIVE, packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE));
            packetWrapper2.write(Types.LONG_ARRAY_PRIMITIVE, packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE));
            int n3 = packetWrapper.read(Types.VAR_INT);
            packetWrapper2.write(Types.VAR_INT, n3);
            for (n = 0; n < n3; ++n) {
                packetWrapper2.write(Types.BYTE_ARRAY_PRIMITIVE, packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE));
            }
            n = packetWrapper.read(Types.VAR_INT);
            packetWrapper2.write(Types.VAR_INT, n);
            for (int i = 0; i < n; ++i) {
                packetWrapper2.write(Types.BYTE_ARRAY_PRIMITIVE, packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE));
            }
            packetWrapper2.send(Protocol1_18To1_17_1.class);
        });
        ((Protocol1_18To1_17_1)this.protocol).cancelClientbound(ClientboundPackets1_18.SET_SIMULATION_DISTANCE);
    }

    private void handleSpawner(int n, CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        CompoundTag compoundTag3;
        if (n == 8 && (compoundTag3 = compoundTag.getCompoundTag("SpawnData")) != null && (compoundTag2 = compoundTag3.getCompoundTag("entity")) != null) {
            compoundTag.put("SpawnData", compoundTag2);
        }
    }
}

