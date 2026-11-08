/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.io.FastByteBufInputStream;
import com.viaversion.viaversion.io.FastByteBufOutputStream;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.Nullable;

public class NamedCompoundTagType
extends Type<CompoundTag> {
    public NamedCompoundTagType() {
        super(CompoundTag.class);
    }

    @Override
    public CompoundTag read(ByteBuf byteBuf) {
        try {
            return NamedCompoundTagType.read(byteBuf, 0x200000, true);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public void write(ByteBuf byteBuf, CompoundTag compoundTag) {
        try {
            NamedCompoundTagType.write(byteBuf, compoundTag, "");
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public static CompoundTag read(ByteBuf byteBuf, int n, boolean bl) throws IOException {
        byte by = byteBuf.readByte();
        if (by == 0) {
            return null;
        }
        if (by != 10) {
            throw new IOException(String.format("Expected root tag to be a CompoundTag, was %s", by));
        }
        if (bl) {
            byteBuf.skipBytes(byteBuf.readUnsignedShort());
        }
        TagLimiter tagLimiter = TagLimiter.create(n, 512);
        return CompoundTag.read(new FastByteBufInputStream(byteBuf), tagLimiter, 0);
    }

    public static void write(ByteBuf byteBuf, Tag tag, @Nullable String string) throws IOException {
        if (tag == null) {
            byteBuf.writeByte(0);
            return;
        }
        FastByteBufOutputStream fastByteBufOutputStream = new FastByteBufOutputStream(byteBuf);
        fastByteBufOutputStream.writeByte(tag.getTagId());
        if (string != null) {
            fastByteBufOutputStream.writeUTF(string);
        }
        tag.write(fastByteBufOutputStream);
    }

    public static final class OptionalNamedCompoundTagType
    extends OptionalType<CompoundTag> {
        public OptionalNamedCompoundTagType() {
            super(Types.NAMED_COMPOUND_TAG);
        }
    }
}

