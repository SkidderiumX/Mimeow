/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_11to1_10.rewriter;

import com.viaversion.viabackwards.protocol.v1_11to1_10.Protocol1_11To1_10;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import com.viaversion.viaversion.util.ComponentUtil;

public class PlayerPacketRewriter1_11 {
    private static final ValueTransformer<Short, Float> TO_NEW_FLOAT = new ValueTransformer<Short, Float>((Type)Types.FLOAT){

        @Override
        public Float transform(PacketWrapper packetWrapper, Short s) {
            return Float.valueOf((float)s.shortValue() / 16.0f);
        }
    };

    public static void register(Protocol1_11To1_10 protocol1_11To1_10) {
        protocol1_11To1_10.registerClientbound(ClientboundPackets1_9_3.SET_TITLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 2) {
                        JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                        packetWrapper.clearPacket();
                        packetWrapper.setPacketType(ClientboundPackets1_9_3.CHAT);
                        String string = ComponentUtil.jsonToLegacy(jsonElement);
                        jsonElement = new JsonObject();
                        jsonElement.getAsJsonObject().addProperty("text", string);
                        packetWrapper.write(Types.COMPONENT, jsonElement);
                        packetWrapper.write(Types.BYTE, (byte)2);
                    } else if (n > 2) {
                        packetWrapper.set(Types.VAR_INT, 0, n - 1);
                    }
                });
            }
        });
        protocol1_11To1_10.registerClientbound(ClientboundPackets1_9_3.TAKE_ITEM_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.read(Types.VAR_INT));
            }
        });
        protocol1_11To1_10.registerServerbound(ServerboundPackets1_9_3.USE_ITEM_ON, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.UNSIGNED_BYTE, TO_NEW_FLOAT);
                this.map(Types.UNSIGNED_BYTE, TO_NEW_FLOAT);
                this.map(Types.UNSIGNED_BYTE, TO_NEW_FLOAT);
            }
        });
    }
}

