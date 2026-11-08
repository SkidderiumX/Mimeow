/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter;

import com.viaversion.viabackwards.protocol.v1_13to1_12_2.Protocol1_13To1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.NamedSoundMappings1_12_2;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;

public class SoundPacketRewriter1_13
extends RewriterBase<Protocol1_13To1_12_2> {
    private static final String[] SOUND_SOURCES = new String[]{"master", "music", "record", "weather", "block", "hostile", "neutral", "player", "ambient", "voice"};

    public SoundPacketRewriter1_13(Protocol1_13To1_12_2 protocol1_13To1_12_2) {
        super(protocol1_13To1_12_2);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_13To1_12_2)this.protocol).replaceClientbound(ClientboundPackets1_13.CUSTOM_SOUND, packetWrapper -> {
            String string = packetWrapper.read(Types.STRING);
            String string2 = NamedSoundMappings1_12_2.getOldId(string);
            if (string2 != null || (string2 = ((Protocol1_13To1_12_2)this.protocol).getMappingData().getMappedNamedSound(string)) != null) {
                packetWrapper.write(Types.STRING, string2);
            } else {
                packetWrapper.write(Types.STRING, string);
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.STOP_SOUND, ClientboundPackets1_12_1.CUSTOM_PAYLOAD, packetWrapper -> {
            String string;
            packetWrapper.write(Types.STRING, "MC|StopSound");
            byte by = packetWrapper.read(Types.BYTE);
            String string2 = (by & 1) != 0 ? SOUND_SOURCES[packetWrapper.read(Types.VAR_INT)] : "";
            if ((by & 2) != 0) {
                String string3 = packetWrapper.read(Types.STRING);
                string = ((Protocol1_13To1_12_2)this.protocol).getMappingData().getMappedNamedSound(string3);
                if (string == null) {
                    string = "";
                }
            } else {
                string = "";
            }
            packetWrapper.write(Types.STRING, string2);
            packetWrapper.write(Types.STRING, string);
        });
    }
}

