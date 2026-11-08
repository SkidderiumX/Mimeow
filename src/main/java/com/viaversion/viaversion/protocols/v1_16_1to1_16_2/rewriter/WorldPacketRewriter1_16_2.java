/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_1to1_16_2.rewriter;

import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord1_16_2;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16_2;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import java.util.ArrayList;
import java.util.List;

public class WorldPacketRewriter1_16_2 {
    private static final BlockChangeRecord[] EMPTY_RECORDS = new BlockChangeRecord[0];

    public static void register(Protocol1_16_1To1_16_2 protocol1_16_1To1_16_2) {
        protocol1_16_1To1_16_2.getBlockRewriter().registerLevelChunk(ClientboundPackets1_16.LEVEL_CHUNK, ChunkType1_16.TYPE, ChunkType1_16_2.TYPE);
        protocol1_16_1To1_16_2.registerClientbound(ClientboundPackets1_16.CHUNK_BLOCKS_UPDATE, ClientboundPackets1_16_2.SECTION_BLOCKS_UPDATE, packetWrapper -> {
            BlockChangeRecord[] blockChangeRecordArray;
            packetWrapper.cancel();
            int n = packetWrapper.read(Types.INT);
            int n2 = packetWrapper.read(Types.INT);
            long l = 0L;
            l |= ((long)n & 0x3FFFFFL) << 42;
            l |= ((long)n2 & 0x3FFFFFL) << 20;
            List[] listArray = new List[16];
            for (BlockChangeRecord blockChangeRecord : blockChangeRecordArray = packetWrapper.read(Types.BLOCK_CHANGE_ARRAY)) {
                int n3 = blockChangeRecord.getY() >> 4;
                ArrayList<BlockChangeRecord1_16_2> arrayList = listArray[n3];
                if (arrayList == null) {
                    listArray[n3] = arrayList = new ArrayList<BlockChangeRecord1_16_2>();
                }
                int n4 = protocol1_16_1To1_16_2.getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId());
                arrayList.add(new BlockChangeRecord1_16_2(blockChangeRecord.getSectionX(), blockChangeRecord.getSectionY(), blockChangeRecord.getSectionZ(), n4));
            }
            for (int i = 0; i < listArray.length; ++i) {
                List list = listArray[i];
                if (list == null) continue;
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_16_2.SECTION_BLOCKS_UPDATE);
                packetWrapper2.write(Types.LONG, l | (long)i & 0xFFFFFL);
                packetWrapper2.write(Types.BOOLEAN, false);
                packetWrapper2.write(Types.VAR_LONG_BLOCK_CHANGE_ARRAY, list.toArray(EMPTY_RECORDS));
                packetWrapper2.send(Protocol1_16_1To1_16_2.class);
            }
        });
    }
}

