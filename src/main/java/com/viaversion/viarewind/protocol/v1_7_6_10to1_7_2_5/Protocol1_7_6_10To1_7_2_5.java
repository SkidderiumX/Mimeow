/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5;

import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ServerboundPackets1_7_2_5;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Protocol1_7_6_10To1_7_2_5
extends AbstractProtocol<ClientboundPackets1_7_2_5, ClientboundPackets1_7_2_5, ServerboundPackets1_7_2_5, ServerboundPackets1_7_2_5> {
    public static final ValueTransformer<String, String> REMOVE_DASHES = new ValueTransformer<String, String>(Types.STRING){

        @Override
        public String transform(PacketWrapper packetWrapper, String string) {
            return string.replace("-", "");
        }
    };

    public Protocol1_7_6_10To1_7_2_5() {
        super(ClientboundPackets1_7_2_5.class, ClientboundPackets1_7_2_5.class, ServerboundPackets1_7_2_5.class, ServerboundPackets1_7_2_5.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING, REMOVE_DASHES);
                this.map(Types.STRING);
            }
        });
        this.registerClientbound(ClientboundPackets1_7_2_5.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.STRING, REMOVE_DASHES);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.STRING);
                    }
                });
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(RewindTypes.ENTITY_DATA_LIST1_7);
            }
        });
        this.registerClientbound(ClientboundPackets1_7_2_5.SET_PLAYER_TEAM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 0 || by == 2) {
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.BYTE);
                    }
                    if (by == 0 || by == 3 || by == 4) {
                        List<Object> list = new ArrayList<String>();
                        int n = packetWrapper.read(Types.SHORT).shortValue();
                        for (int i = 0; i < n; ++i) {
                            list.add(packetWrapper.read(Types.STRING));
                        }
                        list = list.stream().map((T string) -> string.length() > 16 ? string.substring(0, 16) : string).distinct().collect(Collectors.toList());
                        packetWrapper.write(Types.SHORT, (short)list.size());
                        for (String string2 : list) {
                            packetWrapper.write(Types.STRING, string2);
                        }
                    }
                });
            }
        });
    }
}

