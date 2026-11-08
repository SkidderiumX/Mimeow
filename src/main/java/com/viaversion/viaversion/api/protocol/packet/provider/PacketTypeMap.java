/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.packet.provider;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeArrayMap;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMapMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface PacketTypeMap<P extends PacketType> {
    public @Nullable P typeByName(String var1);

    public @Nullable P typeById(int var1);

    public Collection<P> types();

    public static <T extends PacketType, E extends T> PacketTypeMap<T> of(Class<E> clazz) {
        PacketType[] packetTypeArray = (PacketType[])clazz.getEnumConstants();
        Preconditions.checkArgument(packetTypeArray != null, "%s is not an enum", clazz);
        HashMap<String, PacketType> hashMap = new HashMap<String, PacketType>(packetTypeArray.length);
        for (PacketType packetType : packetTypeArray) {
            hashMap.put(packetType.getName(), packetType);
        }
        return PacketTypeMap.of(hashMap, (PacketType[])packetTypeArray);
    }

    public static <T extends PacketType, E extends T> PacketTypeMap<T> ofUnsequenced(Class<E> clazz) {
        PacketType[] packetTypeArray = (PacketType[])clazz.getEnumConstants();
        Preconditions.checkArgument(packetTypeArray != null, "%s is not an enum", clazz);
        HashMap<String, PacketType> hashMap = new HashMap<String, PacketType>(packetTypeArray.length);
        for (PacketType packetType : packetTypeArray) {
            hashMap.put(packetType.getName(), packetType);
        }
        Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap();
        for (PacketType packetType : packetTypeArray) {
            int2ObjectArrayMap.put(packetType.getId(), packetType);
        }
        return PacketTypeMap.of(hashMap, int2ObjectArrayMap);
    }

    public static <T extends PacketType> PacketTypeMap<T> of(Map<String, T> map, T[] TArray) {
        return new PacketTypeArrayMap(map, TArray);
    }

    public static <T extends PacketType> PacketTypeMap<T> of(Map<String, T> map, Int2ObjectMap<T> int2ObjectMap) {
        return new PacketTypeMapMap<T>(map, int2ObjectMap);
    }
}

