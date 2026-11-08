/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_17to1_16_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.api.rewriters.MapColorRewriter;
import com.viaversion.viabackwards.protocol.v1_17_1to1_17.storage.InventoryStateIds;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.Protocol1_17To1_16_4;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.data.MapColorMappings1_16_4;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.storage.PlayerLastCursorItem;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_17;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.CompactArrayUtil;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class BlockItemPacketRewriter1_17
extends BackwardsItemRewriter<ClientboundPackets1_17, ServerboundPackets1_16_2, Protocol1_17To1_16_4> {
    private static final int BEDROCK_BLOCK_STATE = 33;

    public BlockItemPacketRewriter1_17(Protocol1_17To1_16_4 protocol1_17To1_16_4) {
        super(protocol1_17To1_16_4, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    protected void registerPackets() {
        new RecipeRewriter<ClientboundPackets1_17>(this.protocol).register(ClientboundPackets1_17.UPDATE_RECIPES);
        ((Protocol1_17To1_16_4)this.protocol).registerServerbound(ServerboundPackets1_16_2.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
        ((Protocol1_17To1_16_4)this.protocol).replaceServerbound(ServerboundPackets1_16_2.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    StorableObject storableObject;
                    short s = packetWrapper.passthrough(Types.SHORT);
                    byte by = packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.read(Types.SHORT);
                    int n = packetWrapper.passthrough(Types.VAR_INT);
                    Item item = BlockItemPacketRewriter1_17.this.handleItemToServer(packetWrapper.user(), packetWrapper.read(Types.ITEM1_13_2));
                    if (s >= 0 && item != null) {
                        packetWrapper.write(Types.VAR_INT, 1);
                        packetWrapper.write(Types.SHORT, s);
                        packetWrapper.write(Types.ITEM1_13_2, null);
                    } else {
                        packetWrapper.write(Types.VAR_INT, 0);
                    }
                    if (n != 0 && (storableObject = packetWrapper.user().get(InventoryStateIds.class)) != null) {
                        ((InventoryStateIds)storableObject).setStateId(packetWrapper.get(Types.BYTE, 0).byteValue(), -1);
                    }
                    storableObject = packetWrapper.user().get(PlayerLastCursorItem.class);
                    if (n == 0 && by == 0 && item != null) {
                        ((PlayerLastCursorItem)storableObject).setLastCursorItem(item);
                    } else if (n == 0 && by == 1 && item != null) {
                        if (((PlayerLastCursorItem)storableObject).isSet()) {
                            ((PlayerLastCursorItem)storableObject).setLastCursorItem(item);
                        } else {
                            ((PlayerLastCursorItem)storableObject).setLastCursorItem(item, (item.amount() + 1) / 2);
                        }
                    } else if (n != 5 || s != -999 || by != 0 && by != 4) {
                        ((PlayerLastCursorItem)storableObject).setLastCursorItem(null);
                    }
                    Item item2 = ((PlayerLastCursorItem)storableObject).getLastCursorItem();
                    if (item2 == null) {
                        packetWrapper.write(Types.ITEM1_13_2, item);
                    } else {
                        packetWrapper.write(Types.ITEM1_13_2, item2);
                    }
                });
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).replaceClientbound(ClientboundPackets1_17.CONTAINER_SET_SLOT, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            short s = packetWrapper.passthrough(Types.SHORT);
            Item item = packetWrapper.read(Types.ITEM1_13_2);
            if (item != null && by == -1 && s == -1) {
                packetWrapper.user().get(PlayerLastCursorItem.class).setLastCursorItem(item);
            }
            packetWrapper.write(Types.ITEM1_13_2, this.handleItemToClient(packetWrapper.user(), item));
        });
        ((Protocol1_17To1_16_4)this.protocol).registerServerbound(ServerboundPackets1_16_2.CONTAINER_ACK, null, packetWrapper -> {
            packetWrapper.cancel();
            if (!ViaBackwards.getConfig().handlePingsAsInvAcknowledgements()) {
                return;
            }
            byte by = packetWrapper.read(Types.BYTE);
            short s = packetWrapper.read(Types.SHORT);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            if (by == 0 && bl) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_17.PONG);
                packetWrapper2.write(Types.INT, Integer.valueOf(s));
                packetWrapper2.sendToServer(Protocol1_17To1_16_4.class);
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).replaceClientbound(ClientboundPackets1_17.LEVEL_PARTICLES, new PacketHandlers(){

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
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n == 16) {
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.read(Types.FLOAT);
                        packetWrapper.read(Types.FLOAT);
                        packetWrapper.read(Types.FLOAT);
                    } else if (n == 37) {
                        packetWrapper.set(Types.INT, 0, -1);
                        packetWrapper.cancel();
                    }
                });
                this.handler(((ParticleRewriter)((Protocol1_17To1_16_4)BlockItemPacketRewriter1_17.this.protocol).getParticleRewriter()).levelParticlesHandler1_13(Types.INT));
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.SET_BORDER_SIZE, ClientboundPackets1_16_2.SET_BORDER, 0);
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.SET_BORDER_LERP_SIZE, ClientboundPackets1_16_2.SET_BORDER, 1);
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.SET_BORDER_CENTER, ClientboundPackets1_16_2.SET_BORDER, 2);
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.INITIALIZE_BORDER, ClientboundPackets1_16_2.SET_BORDER, 3);
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.SET_BORDER_WARNING_DELAY, ClientboundPackets1_16_2.SET_BORDER, 4);
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.SET_BORDER_WARNING_DISTANCE, ClientboundPackets1_16_2.SET_BORDER, 5);
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.LIGHT_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getEntityTracker(Protocol1_17To1_16_4.class);
                    int n = Math.max(0, -(t.currentMinY() >> 4));
                    long[] lArray = packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE);
                    long[] lArray2 = packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE);
                    int n2 = BlockItemPacketRewriter1_17.this.cutLightMask(lArray, n);
                    int n3 = BlockItemPacketRewriter1_17.this.cutLightMask(lArray2, n);
                    packetWrapper.write(Types.VAR_INT, n2);
                    packetWrapper.write(Types.VAR_INT, n3);
                    long[] lArray3 = packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE);
                    long[] lArray4 = packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE);
                    packetWrapper.write(Types.VAR_INT, BlockItemPacketRewriter1_17.this.cutLightMask(lArray3, n));
                    packetWrapper.write(Types.VAR_INT, BlockItemPacketRewriter1_17.this.cutLightMask(lArray4, n));
                    this.writeLightArrays(packetWrapper, BitSet.valueOf(lArray), n2, n, t.currentWorldSectionHeight());
                    this.writeLightArrays(packetWrapper, BitSet.valueOf(lArray2), n3, n, t.currentWorldSectionHeight());
                });
            }

            private void writeLightArrays(PacketWrapper packetWrapper, BitSet bitSet, int n, int n2, int n3) {
                int n4;
                int n5 = packetWrapper.read(Types.VAR_INT);
                int n6 = 0;
                ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
                for (n4 = 0; n4 < n2; ++n4) {
                    if (!bitSet.get(n4)) continue;
                    ++n6;
                    packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                }
                for (n4 = 0; n4 < 18; ++n4) {
                    if (!this.isSet(n, n4)) continue;
                    ++n6;
                    arrayList.add(packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE));
                }
                for (n4 = n2 + 18; n4 < n3 + 2; ++n4) {
                    if (!bitSet.get(n4)) continue;
                    ++n6;
                    packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                }
                if (n6 != n5) {
                    for (n4 = n6; n4 < n5; ++n4) {
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    }
                }
                for (byte[] byArray : arrayList) {
                    packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                }
            }

            private boolean isSet(int n, int n2) {
                return (n & 1 << n2) != 0;
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).replaceClientbound(ClientboundPackets1_17.SECTION_BLOCKS_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.LONG);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    BlockChangeRecord[] blockChangeRecordArray;
                    long l = packetWrapper.get(Types.LONG, 0);
                    int n = (int)(l << 44 >> 44);
                    if (n < 0 || n > 15) {
                        packetWrapper.cancel();
                        return;
                    }
                    for (BlockChangeRecord blockChangeRecord : blockChangeRecordArray = packetWrapper.passthrough(Types.VAR_LONG_BLOCK_CHANGE_ARRAY)) {
                        if (ViaBackwards.getConfig().bedrockAtY0() && n == 0 && blockChangeRecord.getSectionY() == 0) {
                            blockChangeRecord.setBlockId(33);
                            continue;
                        }
                        blockChangeRecord.setBlockId(((Protocol1_17To1_16_4)BlockItemPacketRewriter1_17.this.protocol).getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId()));
                    }
                });
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).replaceClientbound(ClientboundPackets1_17.BLOCK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.BLOCK_POSITION1_14, 0).y();
                    if (n < 0 || n > 255) {
                        packetWrapper.cancel();
                        return;
                    }
                    if (ViaBackwards.getConfig().bedrockAtY0() && n == 0) {
                        packetWrapper.set(Types.VAR_INT, 0, 33);
                    } else {
                        packetWrapper.set(Types.VAR_INT, 0, ((Protocol1_17To1_16_4)BlockItemPacketRewriter1_17.this.protocol).getMappingData().getNewBlockStateId(packetWrapper.get(Types.VAR_INT, 0)));
                    }
                });
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.LEVEL_CHUNK, packetWrapper -> {
            Object object;
            Object t = packetWrapper.user().getEntityTracker(Protocol1_17To1_16_4.class);
            int n3 = t.currentWorldSectionHeight();
            Chunk chunk = packetWrapper.read(new ChunkType1_17(n3));
            packetWrapper.write(ChunkType1_16_2.TYPE, chunk);
            int n4 = Math.max(0, -(t.currentMinY() >> 4));
            chunk.setBiomeData(Arrays.copyOfRange(chunk.getBiomeData(), n4 * 64, n4 * 64 + 1024));
            chunk.setBitmask(this.cutMask(chunk.getChunkMask(), n4, false));
            chunk.setChunkMask(null);
            ChunkSection[] chunkSectionArray = Arrays.copyOfRange(chunk.getSections(), n4, n4 + 16);
            chunk.setSections(chunkSectionArray);
            CompoundTag compoundTag2 = chunk.getHeightMap();
            Object object2 = compoundTag2.values().iterator();
            while (object2.hasNext()) {
                object = object2.next();
                if (!(object instanceof LongArrayTag)) continue;
                LongArrayTag longArrayTag = (LongArrayTag)object;
                int[] nArray = new int[256];
                int n5 = MathUtil.ceilLog2((n3 << 4) + 1);
                CompactArrayUtil.iterateCompactArrayWithPadding(n5, nArray.length, longArrayTag.getValue(), (n, n2) -> {
                    nArray[n] = MathUtil.clamp(n2 + t.currentMinY(), 0, 255);
                });
                longArrayTag.setValue(CompactArrayUtil.createCompactArrayWithPadding(9, nArray.length, n -> nArray[n]));
            }
            ((Protocol1_17To1_16_4)this.protocol).getBlockRewriter().handleChunk(chunk);
            if (ViaBackwards.getConfig().bedrockAtY0() && (object2 = chunk.getSections()[0]) != null) {
                object = object2.palette(PaletteType.BLOCKS);
                for (int i = 0; i < 16; ++i) {
                    for (int j = 0; j < 16; ++j) {
                        object.setIdAt(i, 0, j, 33);
                    }
                }
            }
            chunk.getBlockEntities().removeIf(compoundTag -> {
                NumberTag numberTag = compoundTag.getNumberTag("y");
                if (numberTag == null) {
                    return false;
                }
                int n = numberTag.asInt();
                return n < 0 || n > 255 || ViaBackwards.getConfig().bedrockAtY0() && n == 0;
            });
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_ENTITY_DATA, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.BLOCK_POSITION1_14).y();
            if (n < 0 || n > 255 || ViaBackwards.getConfig().bedrockAtY0() && n == 0) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_DESTRUCTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.passthrough(Types.BLOCK_POSITION1_14).y();
                    if (n < 0 || n > 255 || ViaBackwards.getConfig().bedrockAtY0() && n == 0) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> packetWrapper.write(Types.BOOLEAN, true));
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n;
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    if (bl) {
                        n = packetWrapper.passthrough(Types.VAR_INT);
                    } else {
                        packetWrapper.write(Types.VAR_INT, 0);
                        n = 0;
                    }
                    MapColorRewriter.rewriteMapColors(packetWrapper, MapColorMappings1_16_4::getMappedColor, n);
                });
            }
        });
    }

    private int cutLightMask(long[] lArray, int n) {
        if (lArray.length == 0) {
            return 0;
        }
        return this.cutMask(BitSet.valueOf(lArray), n, true);
    }

    private int cutMask(BitSet bitSet, int n, boolean bl) {
        int n2 = 0;
        int n3 = n + (bl ? 18 : 16);
        int n4 = n;
        int n5 = 0;
        while (n4 < n3) {
            if (bitSet.get(n4)) {
                n2 |= 1 << n5;
            }
            ++n4;
            ++n5;
        }
        return n2;
    }
}

