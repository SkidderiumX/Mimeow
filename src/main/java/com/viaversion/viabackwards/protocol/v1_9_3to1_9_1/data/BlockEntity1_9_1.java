/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_9_3to1_9_1.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.protocol.v1_9_3to1_9_1.Protocol1_9_3To1_9_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockEntity1_9_1 {
    private static final Map<String, Integer> TYPES = new HashMap<String, Integer>();

    public static void handle(List<CompoundTag> list, UserConnection userConnection) {
        for (CompoundTag compoundTag : list) {
            int n;
            String string;
            StringTag stringTag = compoundTag.getStringTag("id");
            if (stringTag == null || !TYPES.containsKey(string = stringTag.getValue()) || (n = TYPES.get(string).intValue()) == -1) continue;
            int n2 = compoundTag.getNumberTag("x").asInt();
            short s = compoundTag.getNumberTag("y").asShort();
            int n3 = compoundTag.getNumberTag("z").asInt();
            BlockPosition blockPosition = new BlockPosition(n2, s, n3);
            BlockEntity1_9_1.updateBlockEntity(blockPosition, (short)n, compoundTag, userConnection);
        }
    }

    private static void updateBlockEntity(BlockPosition blockPosition, short s, CompoundTag compoundTag, UserConnection userConnection) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, null, userConnection);
        packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition);
        packetWrapper.write(Types.UNSIGNED_BYTE, s);
        packetWrapper.write(Types.NAMED_COMPOUND_TAG, compoundTag);
        packetWrapper.scheduleSend(Protocol1_9_3To1_9_1.class, false);
    }

    static {
        TYPES.put("MobSpawner", 1);
        TYPES.put("Control", 2);
        TYPES.put("Beacon", 3);
        TYPES.put("Skull", 4);
        TYPES.put("FlowerPot", 5);
        TYPES.put("Banner", 6);
        TYPES.put("UNKNOWN", 7);
        TYPES.put("EndGateway", 8);
        TYPES.put("Sign", 9);
    }
}

