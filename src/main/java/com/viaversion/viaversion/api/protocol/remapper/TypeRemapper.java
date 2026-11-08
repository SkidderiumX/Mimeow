/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.remapper;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.ValueReader;
import com.viaversion.viaversion.api.protocol.remapper.ValueWriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.exception.InformativeException;

public record TypeRemapper<T>(Type<T> type) implements ValueReader<T>,
ValueWriter<T>
{
    @Override
    public T read(PacketWrapper packetWrapper) throws InformativeException {
        return packetWrapper.read(this.type);
    }

    @Override
    public void write(PacketWrapper packetWrapper, T t) throws InformativeException {
        packetWrapper.write(this.type, t);
    }
}

