/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.Types;

public class AttributeRewriter<C extends ClientboundPacketType> {
    private final Protocol<C, ?, ?, ?> protocol;

    public AttributeRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
    }

    public void register1_21(C c) {
        if (this.protocol.getMappingData() == null || Mappings.isIntIdIdentity(this.protocol.getMappingData().getAttributeMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n;
            packetWrapper.passthrough(Types.VAR_INT);
            int n2 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                int n3;
                int n4;
                int n5 = packetWrapper.read(Types.VAR_INT);
                int n6 = this.protocol.getMappingData().getNewAttributeId(n5);
                if (n6 == -1) {
                    --n2;
                    packetWrapper.read(Types.DOUBLE);
                    n4 = packetWrapper.read(Types.VAR_INT);
                    for (n3 = 0; n3 < n4; ++n3) {
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.DOUBLE);
                        packetWrapper.read(Types.BYTE);
                    }
                    continue;
                }
                packetWrapper.write(Types.VAR_INT, n6);
                packetWrapper.passthrough(Types.DOUBLE);
                n4 = packetWrapper.passthrough(Types.VAR_INT);
                for (n3 = 0; n3 < n4; ++n3) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.BYTE);
                }
            }
            if (n != n2) {
                packetWrapper.set(Types.VAR_INT, 1, n2);
            }
        });
    }
}

