/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;

public class SoundRewriter<C extends ClientboundPacketType>
extends com.viaversion.viaversion.rewriter.SoundRewriter<C> {
    public SoundRewriter(AbstractProtocol<C, ?, ?, ?> abstractProtocol) {
        super(abstractProtocol);
    }

    public void registerNamedSound(C c) {
        if (this.protocol.getMappingData() == null || Mappings.isFullIdentity(this.protocol.getMappingData().getFullSoundMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            this.getNamedSoundHandler().handle(packetWrapper);
        });
    }

    public void registerStopSound(C c) {
        if (this.protocol.getMappingData() == null || Mappings.isFullIdentity(this.protocol.getMappingData().getFullSoundMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            if ((by & 1) != 0) {
                packetWrapper.passthrough(Types.VAR_INT);
            }
            if ((by & 2) == 0) {
                return;
            }
            String string = packetWrapper.read(Types.STRING);
            String string2 = this.protocol.getMappingData().getFullSoundMappings().mappedIdentifier(string);
            if (string2 == null) {
                packetWrapper.write(Types.STRING, string);
                return;
            }
            if (!string2.isEmpty()) {
                packetWrapper.write(Types.STRING, string2);
            } else {
                packetWrapper.cancel();
            }
        });
    }

    public PacketHandler getNamedSoundHandler() {
        return packetWrapper -> {
            String string = packetWrapper.get(Types.STRING, 0);
            String string2 = this.protocol.getMappingData().getFullSoundMappings().mappedIdentifier(string);
            if (string2 == null) {
                return;
            }
            if (!string2.isEmpty()) {
                packetWrapper.set(Types.STRING, 0, string2);
            } else {
                packetWrapper.cancel();
            }
        };
    }
}

