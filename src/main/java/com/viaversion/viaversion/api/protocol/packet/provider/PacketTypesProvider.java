/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.packet.provider;

import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface PacketTypesProvider<CU extends ClientboundPacketType, CM extends ClientboundPacketType, SM extends ServerboundPacketType, SU extends ServerboundPacketType> {
    public Map<State, PacketTypeMap<CU>> unmappedClientboundPacketTypes();

    public Map<State, PacketTypeMap<SU>> unmappedServerboundPacketTypes();

    public Map<State, PacketTypeMap<CM>> mappedClientboundPacketTypes();

    public Map<State, PacketTypeMap<SM>> mappedServerboundPacketTypes();

    default public @Nullable CU unmappedClientboundType(State state, String string) {
        PacketTypeMap<CU> packetTypeMap = this.unmappedClientboundPacketTypes().get((Object)state);
        return (CU)(packetTypeMap != null ? (ClientboundPacketType)packetTypeMap.typeByName(string) : null);
    }

    default public @Nullable CM mappedClientboundType(State state, String string) {
        PacketTypeMap<CM> packetTypeMap = this.mappedClientboundPacketTypes().get((Object)state);
        return (CM)(packetTypeMap != null ? (ClientboundPacketType)packetTypeMap.typeByName(string) : null);
    }

    default public @Nullable SU unmappedServerboundType(State state, String string) {
        PacketTypeMap<SU> packetTypeMap = this.unmappedServerboundPacketTypes().get((Object)state);
        return (SU)(packetTypeMap != null ? (ServerboundPacketType)packetTypeMap.typeByName(string) : null);
    }

    default public @Nullable CU unmappedClientboundType(State state, int n) {
        PacketTypeMap<CU> packetTypeMap = this.unmappedClientboundPacketTypes().get((Object)state);
        return (CU)(packetTypeMap != null ? (ClientboundPacketType)packetTypeMap.typeById(n) : null);
    }

    default public @Nullable SU unmappedServerboundType(State state, int n) {
        PacketTypeMap<SU> packetTypeMap = this.unmappedServerboundPacketTypes().get((Object)state);
        return (SU)(packetTypeMap != null ? (ServerboundPacketType)packetTypeMap.typeById(n) : null);
    }
}

