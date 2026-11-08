/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage;

import com.viaversion.viabackwards.protocol.v1_16to1_15_2.Protocol1_16To1_15_2;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerAttributesStorage
implements StorableObject {
    private final Map<String, Attribute> attributes = new HashMap<String, Attribute>();

    public void sendAttributes(UserConnection userConnection, int n) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_15.UPDATE_ATTRIBUTES, userConnection);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.INT, this.attributes.size());
        for (Map.Entry<String, Attribute> entry : this.attributes.entrySet()) {
            Attribute attribute = entry.getValue();
            packetWrapper.write(Types.STRING, entry.getKey());
            packetWrapper.write(Types.DOUBLE, attribute.value());
            packetWrapper.write(Types.VAR_INT, attribute.modifiers().length);
            for (AttributeModifier attributeModifier : attribute.modifiers()) {
                packetWrapper.write(Types.UUID, attributeModifier.uuid());
                packetWrapper.write(Types.DOUBLE, attributeModifier.amount());
                packetWrapper.write(Types.BYTE, attributeModifier.operation());
            }
        }
        packetWrapper.send(Protocol1_16To1_15_2.class);
    }

    public void clearAttributes() {
        this.attributes.clear();
    }

    public void addAttribute(String string, Attribute attribute) {
        this.attributes.put(string, attribute);
    }

    public record Attribute(double value, AttributeModifier[] modifiers) {
    }

    public record AttributeModifier(UUID uuid, double amount, byte operation) {
    }
}

