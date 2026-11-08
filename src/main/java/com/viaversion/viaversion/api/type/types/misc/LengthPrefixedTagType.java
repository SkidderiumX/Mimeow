/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class LengthPrefixedTagType
extends Type<Tag> {
    private final int maxLength;

    public LengthPrefixedTagType(int n) {
        super(Tag.class);
        this.maxLength = n;
    }

    @Override
    public Tag read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        Preconditions.checkArgument(n <= this.maxLength, "Cannot receive tag longer than %s bytes (got %s bytes)", this.maxLength, n);
        return (Tag)Types.TAG.read(byteBuf.readSlice(n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, Tag tag) {
        ByteBuf byteBuf2 = byteBuf.alloc().buffer();
        try {
            Types.TAG.write(byteBuf2, tag);
            Preconditions.checkArgument(byteBuf2.readableBytes() <= this.maxLength, "Cannot send tag longer than %s bytes (got %s bytes)", this.maxLength, byteBuf2.readableBytes());
            Types.VAR_INT.writePrimitive(byteBuf, byteBuf2.readableBytes());
            byteBuf.writeBytes(byteBuf2);
        }
        finally {
            byteBuf2.release();
        }
    }
}

