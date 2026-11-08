/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.NamedCompoundTagType;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.Map;

public class CompoundTagType
extends Type<CompoundTag> {
    private final int maxBytes;

    public CompoundTagType() {
        this(true);
    }

    public CompoundTagType(boolean bl) {
        super(CompoundTag.class);
        this.maxBytes = bl ? 0x200000 : Integer.MAX_VALUE;
    }

    @Override
    public CompoundTag read(ByteBuf byteBuf) {
        try {
            return NamedCompoundTagType.read(byteBuf, this.maxBytes, false);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public void write(ByteBuf byteBuf, CompoundTag compoundTag) {
        try {
            NamedCompoundTagType.write(byteBuf, compoundTag, null);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public void write(Ops ops, CompoundTag compoundTag) {
        ops.writeMap(mapSerializer -> {
            for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                mapSerializer.write(entry.getKey(), Types.TAG, entry.getValue());
            }
        });
    }

    public static final class OptionalCompoundTagType
    extends OptionalType<CompoundTag> {
        private OptionalCompoundTagType(Type<CompoundTag> type) {
            super(type);
        }

        public static OptionalCompoundTagType type() {
            return new OptionalCompoundTagType(Types.COMPOUND_TAG);
        }

        public static OptionalCompoundTagType trustedType() {
            return new OptionalCompoundTagType(Types.TRUSTED_COMPOUND_TAG);
        }
    }
}

