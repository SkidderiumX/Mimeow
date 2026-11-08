/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.UUIDUtil;
import io.netty.buffer.ByteBuf;
import java.util.UUID;

public class UUIDType
extends Type<UUID> {
    public UUIDType() {
        super(UUID.class);
    }

    @Override
    public UUID read(ByteBuf byteBuf) {
        return new UUID(byteBuf.readLong(), byteBuf.readLong());
    }

    @Override
    public void write(ByteBuf byteBuf, UUID uUID) {
        byteBuf.writeLong(uUID.getMostSignificantBits());
        byteBuf.writeLong(uUID.getLeastSignificantBits());
    }

    @Override
    public void write(Ops ops, UUID uUID) {
        ops.write(Types.INT_ARRAY_PRIMITIVE, UUIDUtil.toIntArray(uUID));
    }

    public static final class OptionalUUIDType
    extends OptionalType<UUID> {
        public OptionalUUIDType() {
            super(Types.UUID);
        }
    }
}

