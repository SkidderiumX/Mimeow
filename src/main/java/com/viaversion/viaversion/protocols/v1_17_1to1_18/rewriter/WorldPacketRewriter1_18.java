/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntityImpl;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_18;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.DataPaletteImpl;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_17;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.Protocol1_17_1To1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.data.BlockEntities1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.data.BlockEntityMappings1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.storage.ChunkLightStorage;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.BitSet;

public class WorldPacketRewriter1_18 {
    public static void register(Protocol1_17_1To1_18 protocol1_17_1To1_18) {
        protocol1_17_1To1_18.registerClientbound(ClientboundPackets1_17_1.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                    int n = BlockEntityMappings1_18.newId(s);
                    packetWrapper.write(Types.VAR_INT, n);
                    WorldPacketRewriter1_18.handleSpawners(n, packetWrapper.passthrough(Types.NAMED_COMPOUND_TAG));
                });
            }
        });
        protocol1_17_1To1_18.registerClientbound(ClientboundPackets1_17_1.LIGHT_UPDATE, packetWrapper -> {
            int n;
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            if (packetWrapper.user().get(ChunkLightStorage.class).isLoaded(n2, n3)) {
                if (!Via.getConfig().cache1_17Light()) {
                    return;
                }
            } else {
                packetWrapper.cancel();
            }
            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
            long[] lArray = packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            long[] lArray2 = packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            long[] lArray3 = packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            long[] lArray4 = packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            int n4 = packetWrapper.passthrough(Types.VAR_INT);
            byte[][] byArrayArray = new byte[n4][];
            for (n = 0; n < n4; ++n) {
                byArrayArray[n] = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
            }
            n = packetWrapper.passthrough(Types.VAR_INT);
            byte[][] byArrayArray2 = new byte[n][];
            for (int i = 0; i < n; ++i) {
                byArrayArray2[i] = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
            }
            ChunkLightStorage chunkLightStorage = packetWrapper.user().get(ChunkLightStorage.class);
            chunkLightStorage.storeLight(n2, n3, new ChunkLightStorage.ChunkLight(bl, lArray, lArray2, lArray3, lArray4, byArrayArray, byArrayArray2));
        });
        protocol1_17_1To1_18.registerClientbound(ClientboundPackets1_17_1.LEVEL_CHUNK, ClientboundPackets1_18.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            ChunkLightStorage.ChunkLight chunkLight;
            Object object;
            int n;
            Object bl;
            Object object2;
            Object e = protocol1_17_1To1_18.getEntityRewriter().tracker(packetWrapper.user());
            Chunk chunk = packetWrapper.read(new ChunkType1_17(e.currentWorldSectionHeight()));
            ArrayList<BlockEntity> arrayList = new ArrayList<BlockEntity>(chunk.getBlockEntities().size());
            for (CompoundTag chunkSectionArray2 : chunk.getBlockEntities()) {
                NumberTag i = chunkSectionArray2.getNumberTag("x");
                object2 = chunkSectionArray2.getNumberTag("y");
                bl = chunkSectionArray2.getNumberTag("z");
                StringTag n2 = chunkSectionArray2.getStringTag("id");
                if (i == null || object2 == null || bl == null || n2 == null) continue;
                String n3 = n2.getValue();
                n = BlockEntities1_18.blockEntityIds().getInt(Key.stripMinecraftNamespace(n3));
                if (n == -1) {
                    protocol1_17_1To1_18.getLogger().warning("Unknown block entity: " + n3);
                }
                WorldPacketRewriter1_18.handleSpawners(n, chunkSectionArray2);
                object = (byte)((i.asInt() & 0xF) << 4 | bl.asInt() & 0xF);
                arrayList.add(new BlockEntityImpl((byte)object, object2.asShort(), n, chunkSectionArray2));
            }
            Object object4 = chunk.getBiomeData();
            ChunkSection[] chunkSectionArray = chunk.getSections();
            for (int chunk1_18 = 0; chunk1_18 < chunkSectionArray.length; ++chunk1_18) {
                object2 = chunkSectionArray[chunk1_18];
                if (object2 == null) {
                    chunkSectionArray[chunk1_18] = object2 = new ChunkSectionImpl();
                    object2.setNonAirBlocksCount(0);
                    bl = new DataPaletteImpl(4096);
                    ((DataPaletteImpl)bl).addId(0);
                    object2.addPalette(PaletteType.BLOCKS, (DataPalette)bl);
                }
                bl = new DataPaletteImpl(64);
                object2.addPalette(PaletteType.BIOMES, (DataPalette)bl);
                int chunkLight2 = chunk1_18 * 64;
                int bitSet = 0;
                n = chunkLight2;
                while (bitSet < 64) {
                    object = object4[n];
                    ((DataPaletteImpl)bl).setIdAt(bitSet, (int)(object != -1 ? object : (Object)false));
                    ++bitSet;
                    ++n;
                }
            }
            Chunk1_18 chunk1_18 = new Chunk1_18(chunk.getX(), chunk.getZ(), chunkSectionArray, chunk.getHeightMap(), arrayList);
            packetWrapper.write(new ChunkType1_18(e.currentWorldSectionHeight(), MathUtil.ceilLog2(protocol1_17_1To1_18.getMappingData().getBlockStateMappings().mappedSize()), MathUtil.ceilLog2(e.biomesSent())), chunk1_18);
            object2 = packetWrapper.user().get(ChunkLightStorage.class);
            boolean bl2 = !((ChunkLightStorage)object2).addLoadedChunk(chunk1_18.getX(), chunk1_18.getZ());
            ChunkLightStorage.ChunkLight chunkLight3 = chunkLight = Via.getConfig().cache1_17Light() ? ((ChunkLightStorage)object2).getLight(chunk1_18.getX(), chunk1_18.getZ()) : ((ChunkLightStorage)object2).removeLight(chunk1_18.getX(), chunk1_18.getZ());
            if (chunkLight == null) {
                protocol1_17_1To1_18.getLogger().warning("No light data found for chunk at " + chunk1_18.getX() + ", " + chunk1_18.getZ() + ". Chunk was already loaded: " + bl2);
                protocol1_17_1To1_18.getLogger().warning("This means another plugin is sending chunk data in a bad order, or you need to re-enable the cache-1_17-light config option.");
                BitSet byArray2 = new BitSet();
                byArray2.set(0, e.currentWorldSectionHeight() + 2);
                packetWrapper.write(Types.BOOLEAN, false);
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, new long[0]);
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, new long[0]);
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, byArray2.toLongArray());
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, byArray2.toLongArray());
                packetWrapper.write(Types.VAR_INT, 0);
                packetWrapper.write(Types.VAR_INT, 0);
            } else {
                byte[] byArray;
                packetWrapper.write(Types.BOOLEAN, chunkLight.trustEdges());
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, chunkLight.skyLightMask());
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, chunkLight.blockLightMask());
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, chunkLight.emptySkyLightMask());
                packetWrapper.write(Types.LONG_ARRAY_PRIMITIVE, chunkLight.emptyBlockLightMask());
                packetWrapper.write(Types.VAR_INT, chunkLight.skyLight().length);
                byte[][] byArray2 = chunkLight.skyLight();
                n = byArray2.length;
                for (object = (Object)false; object < n; ++object) {
                    byArray = byArray2[object];
                    packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                }
                packetWrapper.write(Types.VAR_INT, chunkLight.blockLight().length);
                byArray2 = chunkLight.blockLight();
                n = byArray2.length;
                for (object = (Object)false; object < n; ++object) {
                    byArray = byArray2[object];
                    packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                }
            }
        });
        protocol1_17_1To1_18.registerClientbound(ClientboundPackets1_17_1.FORGET_LEVEL_CHUNK, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            int n2 = packetWrapper.passthrough(Types.INT);
            packetWrapper.user().get(ChunkLightStorage.class).clear(n, n2);
        });
    }

    private static void handleSpawners(int n, CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        if (n == 8 && (compoundTag2 = compoundTag.getCompoundTag("SpawnData")) != null) {
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag.put("SpawnData", compoundTag3);
            compoundTag3.put("entity", compoundTag2);
        }
    }
}

