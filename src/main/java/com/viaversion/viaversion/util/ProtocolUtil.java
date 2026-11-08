/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMap;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ProtocolUtil {
    @SafeVarargs
    public static <P extends PacketType> Map<State, PacketTypeMap<P>> packetTypeMap(@Nullable Class<P> clazz, Class<? extends P> ... classArray) {
        if (clazz == null) {
            return Collections.emptyMap();
        }
        EnumMap<State, PacketTypeMap<P>> enumMap = new EnumMap<State, PacketTypeMap<P>>(State.class);
        for (Class<P> clazz2 : classArray) {
            PacketType[] packetTypeArray = (PacketType[])clazz2.getEnumConstants();
            Preconditions.checkArgument(packetTypeArray != null, "%s not an enum", clazz2);
            Preconditions.checkArgument(packetTypeArray.length > 0, "Enum %s has no types", clazz2);
            State state = packetTypeArray[0].state();
            enumMap.put(state, PacketTypeMap.of(clazz2));
        }
        return enumMap;
    }

    public static String toNiceHex(int n) {
        String string = Integer.toHexString(n).toUpperCase(Locale.ROOT);
        return (string.length() == 1 ? "0x0" : "0x") + string;
    }

    public static String toNiceName(Class<? extends Protocol> clazz) {
        return clazz.getSimpleName().replace("Protocol", "").replace("To", "->").replace("_", ".");
    }
}

