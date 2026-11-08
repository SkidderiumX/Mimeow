/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_15;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.Protocol1_15_2To1_16;
import com.viaversion.viaversion.util.CompactArrayUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.Map;
import java.util.UUID;

public class WorldPacketRewriter1_16 {
    public static void register(Protocol1_15_2To1_16 protocol1_15_2To1_16) {
        protocol1_15_2To1_16.getBlockRewriter().registerLevelChunk(ClientboundPackets1_15.LEVEL_CHUNK, ChunkType1_15.TYPE, ChunkType1_16.TYPE, (userConnection, chunk) -> {
            chunk.setIgnoreOldLightData(chunk.isFullChunk());
            CompoundTag compoundTag = chunk.getHeightMap();
            for (Tag tag : compoundTag.values()) {
                LongArrayTag longArrayTag = (LongArrayTag)tag;
                int[] nArray = new int[256];
                CompactArrayUtil.iterateCompactArray(9, nArray.length, longArrayTag.getValue(), (n, n2) -> {
                    nArray[n] = n2;
                });
                longArrayTag.setValue(CompactArrayUtil.createCompactArrayWithPadding(9, nArray.length, n -> nArray[n]));
            }
            if (chunk.getBlockEntities() == null) {
                return;
            }
            for (CompoundTag compoundTag2 : chunk.getBlockEntities()) {
                WorldPacketRewriter1_16.handleBlockEntity(protocol1_15_2To1_16, userConnection, compoundTag2);
            }
        });
        protocol1_15_2To1_16.registerClientbound(ClientboundPackets1_15.LIGHT_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.write(Types.BOOLEAN, true));
            }
        });
        protocol1_15_2To1_16.registerClientbound(ClientboundPackets1_15.BLOCK_ENTITY_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            CompoundTag compoundTag = packetWrapper.passthrough(Types.NAMED_COMPOUND_TAG);
            WorldPacketRewriter1_16.handleBlockEntity(protocol1_15_2To1_16, packetWrapper.user(), compoundTag);
        });
    }

    private static void handleBlockEntity(Protocol1_15_2To1_16 protocol1_15_2To1_16, UserConnection userConnection, CompoundTag compoundTag) {
        StringTag stringTag;
        CompoundTag compoundTag2;
        StringTag stringTag2 = compoundTag.getStringTag("id");
        if (stringTag2 == null) {
            return;
        }
        String string = Key.namespaced(stringTag2.getValue());
        if (string.equals("minecraft:conduit")) {
            Tag tag = compoundTag.remove("target_uuid");
            if (!(tag instanceof StringTag)) {
                return;
            }
            UUID uUID = UUID.fromString((String)tag.getValue());
            compoundTag.put("Target", new IntArrayTag(UUIDUtil.toIntArray(uUID)));
        } else if (string.equals("minecraft:skull") && compoundTag.getCompoundTag("Owner") != null) {
            Object object;
            CompoundTag compoundTag3 = (CompoundTag)compoundTag.removeUnchecked("Owner");
            Tag tag = compoundTag3.remove("Id");
            if (tag instanceof StringTag) {
                object = UUID.fromString(((StringTag)tag).getValue());
                compoundTag3.put("Id", new IntArrayTag(UUIDUtil.toIntArray((UUID)object)));
            }
            object = new CompoundTag();
            for (Map.Entry<String, Tag> entry : compoundTag3.entrySet()) {
                ((CompoundTag)object).put(entry.getKey(), entry.getValue());
            }
            compoundTag.put("SkullOwner", (Tag)object);
        } else if (string.equals("minecraft:sign")) {
            for (int i = 1; i <= 4; ++i) {
                StringTag stringTag3 = compoundTag.getStringTag("Text" + i);
                if (stringTag3 == null) continue;
                JsonElement jsonElement = protocol1_15_2To1_16.getComponentRewriter().processText(userConnection, stringTag3.getValue());
                compoundTag.putString("Text" + i, jsonElement.toString());
            }
        } else if (string.equals("minecraft:mob_spawner") && (compoundTag2 = compoundTag.getCompoundTag("SpawnData")) != null && (stringTag = compoundTag2.getStringTag("id")) != null && stringTag.getValue().equals("minecraft:zombie_pigman")) {
            stringTag.setValue("minecraft:zombified_piglin");
        }
    }
}

