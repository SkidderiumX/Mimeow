/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntityImpl;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.util.MathUtil;
import java.util.List;
import java.util.function.BiConsumer;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockRewriter<C extends ClientboundPacketType> {
    protected final Protocol<C, ?, ?, ?> protocol;
    private final Type<BlockPosition> positionType;
    private final Type<CompoundTag> compoundTagType;
    private final ChunkTypeSupplier chunkTypeSupplier;
    private final ChunkTypeSupplier mappedChunkTypeSupplier;

    public BlockRewriter(Protocol<C, ?, ?, ?> protocol, Type<BlockPosition> type, Type<CompoundTag> type2, ChunkTypeSupplier chunkTypeSupplier, @Nullable ChunkTypeSupplier chunkTypeSupplier2) {
        this.protocol = protocol;
        this.positionType = type;
        this.compoundTagType = type2;
        this.chunkTypeSupplier = chunkTypeSupplier;
        this.mappedChunkTypeSupplier = chunkTypeSupplier2;
    }

    public static <C extends ClientboundPacketType> BlockRewriter<C> legacy(Protocol<C, ?, ?, ?> protocol) {
        return new BlockRewriter<C>(protocol, Types.BLOCK_POSITION1_8, Types.NAMED_COMPOUND_TAG, null, null);
    }

    public static <C extends ClientboundPacketType> BlockRewriter<C> for1_14(Protocol<C, ?, ?, ?> protocol) {
        return new BlockRewriter<C>(protocol, Types.BLOCK_POSITION1_14, Types.NAMED_COMPOUND_TAG, null, null);
    }

    public static <C extends ClientboundPacketType> BlockRewriter<C> for1_18(Protocol<C, ?, ?, ?> protocol, ChunkTypeSupplier chunkTypeSupplier) {
        return BlockRewriter.for1_18(protocol, chunkTypeSupplier, null);
    }

    public static <C extends ClientboundPacketType> BlockRewriter<C> for1_18(Protocol<C, ?, ?, ?> protocol, ChunkTypeSupplier chunkTypeSupplier, ChunkTypeSupplier chunkTypeSupplier2) {
        return new BlockRewriter<C>(protocol, Types.BLOCK_POSITION1_14, Types.NAMED_COMPOUND_TAG, chunkTypeSupplier, chunkTypeSupplier2);
    }

    public static <C extends ClientboundPacketType> BlockRewriter<C> for1_20_2(Protocol<C, ?, ?, ?> protocol, ChunkTypeSupplier chunkTypeSupplier) {
        return BlockRewriter.for1_20_2(protocol, chunkTypeSupplier, null);
    }

    public static <C extends ClientboundPacketType> BlockRewriter<C> for1_20_2(Protocol<C, ?, ?, ?> protocol, ChunkTypeSupplier chunkTypeSupplier, ChunkTypeSupplier chunkTypeSupplier2) {
        return new BlockRewriter<C>(protocol, Types.BLOCK_POSITION1_14, Types.TRUSTED_COMPOUND_TAG, chunkTypeSupplier, chunkTypeSupplier2);
    }

    public void registerBlockEvent(C c) {
        if (Mappings.isIntIdIdentity(this.protocol.getMappingData().getBlockMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(this.positionType);
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = this.protocol.getMappingData().getNewBlockId(n);
            if (n2 == -1) {
                packetWrapper.cancel();
                return;
            }
            if (n != n2) {
                packetWrapper.set(Types.VAR_INT, 0, n2);
            }
        });
    }

    public void registerBlockUpdate(C c) {
        if (Mappings.isIntIdIdentity(this.protocol.getMappingData().getBlockStateMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(this.positionType);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, this.protocol.getMappingData().getNewBlockStateId(n));
        });
    }

    public void registerChunkBlocksUpdate(C c) {
        if (Mappings.isIntIdIdentity(this.protocol.getMappingData().getBlockStateMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.INT);
            for (BlockChangeRecord blockChangeRecord : packetWrapper.passthrough(Types.BLOCK_CHANGE_ARRAY)) {
                blockChangeRecord.setBlockId(this.protocol.getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId()));
            }
        });
    }

    public void registerSectionBlocksUpdate(C c) {
        if (Mappings.isIntIdIdentity(this.protocol.getMappingData().getBlockStateMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.BOOLEAN);
            for (BlockChangeRecord blockChangeRecord : packetWrapper.passthrough(Types.VAR_LONG_BLOCK_CHANGE_ARRAY)) {
                blockChangeRecord.setBlockId(this.protocol.getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId()));
            }
        });
    }

    public void registerSectionBlocksUpdate1_20(C c) {
        if (Mappings.isIntIdIdentity(this.protocol.getMappingData().getBlockStateMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.LONG);
            for (BlockChangeRecord blockChangeRecord : packetWrapper.passthrough(Types.VAR_LONG_BLOCK_CHANGE_ARRAY)) {
                blockChangeRecord.setBlockId(this.protocol.getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId()));
            }
        });
    }

    public void registerBlockBreakAck(C c) {
        this.registerBlockUpdate(c);
    }

    public void registerLevelEvent1_13(C c) {
        this.registerLevelEvent(c, 1010, 2001);
    }

    public void registerLevelEvent1_21(C c) {
        this.registerLevelEvent(c, -1, 2001);
    }

    private void registerLevelEvent(C c, int n, int n2) {
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData == null || Mappings.isIntIdIdentity(mappingData.getItemMappings()) && Mappings.isIntIdIdentity(mappingData.getBlockStateMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n3 = packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(this.positionType);
            int n4 = packetWrapper.read(Types.INT);
            if (n != -1 && n3 == n && mappingData.getItemMappings() != null) {
                packetWrapper.write(Types.INT, mappingData.getNewItemId(n4));
            } else if (n3 == n2 && mappingData.getBlockStateMappings() != null) {
                packetWrapper.write(Types.INT, mappingData.getNewBlockStateId(n4));
            } else {
                packetWrapper.write(Types.INT, n4);
            }
        });
    }

    public void registerLevelChunk(C c, Type<Chunk> type, Type<Chunk> type2) {
        this.registerLevelChunk(c, type, type2, null);
    }

    public void registerLevelChunk(C c, Type<Chunk> type, Type<Chunk> type2, @Nullable BiConsumer<UserConnection, Chunk> biConsumer) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            Chunk chunk = (Chunk)packetWrapper.read(type);
            packetWrapper.write(type2, chunk);
            this.handleChunk(chunk);
            if (biConsumer != null) {
                biConsumer.accept(packetWrapper.user(), chunk);
            }
        });
    }

    public void handleChunk(Chunk chunk) {
        for (int i = 0; i < chunk.getSections().length; ++i) {
            ChunkSection chunkSection = chunk.getSections()[i];
            if (chunkSection == null) continue;
            DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
            dataPalette.replaceIds(this.protocol.getMappingData()::getNewBlockStateId);
        }
    }

    public void registerLevelChunk1_18(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            Chunk chunk = this.handleChunk1_18(packetWrapper);
            this.handleBlockEntities(chunk, packetWrapper.user());
        });
    }

    public void handleBlockEntities(Chunk chunk, UserConnection userConnection) {
        int n;
        FullMappings fullMappings = this.protocol.getMappingData().getBlockEntityMappings();
        List<BlockEntity> list = chunk.blockEntities();
        IntArrayList intArrayList = new IntArrayList(0);
        for (n = 0; n < list.size(); ++n) {
            BlockEntity blockEntity = list.get(n);
            if (fullMappings != null) {
                int n2 = blockEntity.typeId();
                int n3 = fullMappings.getNewId(n2);
                if (n3 == -1) {
                    intArrayList.add(n);
                    continue;
                }
                if (n2 != n3) {
                    blockEntity = blockEntity.withTypeId(n3);
                    list.set(n, blockEntity);
                }
            }
            if (blockEntity.tag() == null) continue;
            this.handleBlockEntity(userConnection, blockEntity);
        }
        if (!intArrayList.isEmpty()) {
            for (n = intArrayList.size() - 1; n >= 0; --n) {
                list.remove(intArrayList.getInt(n));
            }
        }
    }

    public Chunk handleChunk1_18(PacketWrapper packetWrapper) {
        Object e = this.protocol.getEntityRewriter().tracker(packetWrapper.user());
        Preconditions.checkArgument(e.biomesSent() != -1, "Biome count not set");
        Preconditions.checkArgument(e.currentWorldSectionHeight() != -1, "Section height not set");
        Type<Chunk> type = this.createChunkType(this.chunkTypeSupplier, (EntityTracker)e, false);
        Type<Chunk> type2 = this.mappedChunkTypeSupplier != null ? this.createChunkType(this.mappedChunkTypeSupplier, (EntityTracker)e, true) : type;
        Chunk chunk = packetWrapper.passthroughAndMap(type, type2);
        if (Mappings.isIntIdIdentity(this.protocol.getMappingData().getBlockStateMappings())) {
            return chunk;
        }
        for (ChunkSection chunkSection : chunk.getSections()) {
            DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
            dataPalette.replaceIds(this.protocol.getMappingData()::getNewBlockStateId);
        }
        return chunk;
    }

    protected Type<Chunk> createChunkType(ChunkTypeSupplier chunkTypeSupplier, EntityTracker entityTracker, boolean bl) {
        Type<Chunk> type = entityTracker.chunkType(bl);
        if (type == null) {
            Mappings mappings = this.protocol.getMappingData().getBlockStateMappings();
            type = chunkTypeSupplier.supply(entityTracker.currentWorldSectionHeight(), MathUtil.ceilLog2(bl ? mappings.mappedSize() : mappings.size()), MathUtil.ceilLog2(entityTracker.biomesSent()));
            entityTracker.setChunkType(bl, type);
        }
        return type;
    }

    public void registerBlockEntityData1_18(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(this.positionType);
            int n = packetWrapper.read(Types.VAR_INT);
            FullMappings fullMappings = this.protocol.getMappingData().getBlockEntityMappings();
            if (fullMappings != null) {
                int n2 = fullMappings.getNewId(n);
                if (n2 == -1) {
                    packetWrapper.cancel();
                    return;
                }
                packetWrapper.write(Types.VAR_INT, n2);
            } else {
                packetWrapper.write(Types.VAR_INT, n);
            }
            CompoundTag compoundTag = packetWrapper.passthrough(this.compoundTagType);
            if (compoundTag != null) {
                BlockEntityImpl blockEntityImpl = new BlockEntityImpl(BlockEntity.pack(blockPosition.x(), blockPosition.z()), (short)blockPosition.y(), n, compoundTag);
                this.handleBlockEntity(packetWrapper.user(), blockEntityImpl);
            }
        });
    }

    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
    }

    @FunctionalInterface
    public static interface ChunkTypeSupplier {
        public Type<Chunk> supply(int var1, int var2, int var3);
    }
}

