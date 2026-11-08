/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import java.util.HashSet;
import java.util.Set;

public class TagKeys
implements StorableObject {
    private final Set<String> identifiers = new HashSet<String>();

    public TagKeys(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            packetWrapper.passthrough(Types.STRING);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int j = 0; j < n2; ++j) {
                String string = packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                this.identifiers.add(Key.stripMinecraftNamespace(string));
            }
        }
    }

    public boolean isValidIdentifier(String string) {
        return this.identifiers.contains(Key.stripMinecraftNamespace(string));
    }
}

