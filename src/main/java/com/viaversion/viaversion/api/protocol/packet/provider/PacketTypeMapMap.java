/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.packet.provider;

import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PacketTypeMapMap<P extends PacketType>
implements PacketTypeMap<P> {
    private final Map<String, P> packetsByName;
    private final Int2ObjectMap<P> packetsById;

    PacketTypeMapMap(Map<String, P> map, Int2ObjectMap<P> int2ObjectMap) {
        this.packetsByName = map;
        this.packetsById = int2ObjectMap;
    }

    @Override
    public @Nullable P typeByName(String string) {
        return (P)((PacketType)this.packetsByName.get(string));
    }

    @Override
    public @Nullable P typeById(int n) {
        return (P)((PacketType)this.packetsById.get(n));
    }

    @Override
    public Collection<P> types() {
        return this.packetsById.values();
    }
}

