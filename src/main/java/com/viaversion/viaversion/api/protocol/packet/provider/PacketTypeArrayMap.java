/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.packet.provider;

import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PacketTypeArrayMap<P extends PacketType>
implements PacketTypeMap<P> {
    private final Map<String, P> packetsByName;
    private final P[] packets;

    PacketTypeArrayMap(Map<String, P> map, P[] PArray) {
        this.packetsByName = map;
        this.packets = PArray;
    }

    @Override
    public @Nullable P typeByName(String string) {
        return (P)((PacketType)this.packetsByName.get(string));
    }

    @Override
    public @Nullable P typeById(int n) {
        return n >= 0 && n < this.packets.length ? (P)this.packets[n] : null;
    }

    @Override
    public Collection<P> types() {
        return Arrays.asList(this.packets);
    }
}

