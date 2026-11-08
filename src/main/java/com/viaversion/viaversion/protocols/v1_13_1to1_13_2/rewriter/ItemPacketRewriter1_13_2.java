/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_1to1_13_2.rewriter;

import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_1to1_13_2.Protocol1_13_1To1_13_2;
import com.viaversion.viaversion.util.Key;

public class ItemPacketRewriter1_13_2 {
    public static void register(Protocol1_13_1To1_13_2 protocol1_13_1To1_13_2) {
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.CONTAINER_SET_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.ITEM1_13, Types.ITEM1_13_2);
            }
        });
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.CONTAINER_SET_CONTENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.ITEM1_13_SHORT_ARRAY, Types.ITEM1_13_2_SHORT_ARRAY);
            }
        });
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    String string = Key.namespaced(packetWrapper.get(Types.STRING, 0));
                    if (string.equals("minecraft:trader_list")) {
                        packetWrapper.passthrough(Types.INT);
                        int n = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
                        for (int i = 0; i < n; ++i) {
                            packetWrapper.write(Types.ITEM1_13_2, packetWrapper.read(Types.ITEM1_13));
                            packetWrapper.write(Types.ITEM1_13_2, packetWrapper.read(Types.ITEM1_13));
                            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
                            if (bl) {
                                packetWrapper.write(Types.ITEM1_13_2, packetWrapper.read(Types.ITEM1_13));
                            }
                            packetWrapper.passthrough(Types.BOOLEAN);
                            packetWrapper.passthrough(Types.INT);
                            packetWrapper.passthrough(Types.INT);
                        }
                    }
                });
            }
        });
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.SET_EQUIPPED_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.ITEM1_13, Types.ITEM1_13_2);
            }
        });
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                int n3;
                packetWrapper.passthrough(Types.STRING);
                String string = packetWrapper.passthrough(Types.STRING);
                if (string.equals("crafting_shapeless")) {
                    packetWrapper.passthrough(Types.STRING);
                    n3 = packetWrapper.passthrough(Types.VAR_INT);
                    for (n2 = 0; n2 < n3; ++n2) {
                        packetWrapper.write(Types.ITEM1_13_2_ARRAY, packetWrapper.read(Types.ITEM1_13_ARRAY));
                    }
                    packetWrapper.write(Types.ITEM1_13_2, packetWrapper.read(Types.ITEM1_13));
                    continue;
                }
                if (string.equals("crafting_shaped")) {
                    n3 = packetWrapper.passthrough(Types.VAR_INT) * packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.STRING);
                    for (n2 = 0; n2 < n3; ++n2) {
                        packetWrapper.write(Types.ITEM1_13_2_ARRAY, packetWrapper.read(Types.ITEM1_13_ARRAY));
                    }
                    packetWrapper.write(Types.ITEM1_13_2, packetWrapper.read(Types.ITEM1_13));
                    continue;
                }
                if (!string.equals("smelting")) continue;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.write(Types.ITEM1_13_2_ARRAY, packetWrapper.read(Types.ITEM1_13_ARRAY));
                packetWrapper.write(Types.ITEM1_13_2, packetWrapper.read(Types.ITEM1_13));
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.VAR_INT);
            }
        });
        protocol1_13_1To1_13_2.registerServerbound(ServerboundPackets1_13.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.VAR_INT);
                this.map(Types.ITEM1_13_2, Types.ITEM1_13);
            }
        });
        protocol1_13_1To1_13_2.registerServerbound(ServerboundPackets1_13.SET_CREATIVE_MODE_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.SHORT);
                this.map(Types.ITEM1_13_2, Types.ITEM1_13);
            }
        });
    }
}

