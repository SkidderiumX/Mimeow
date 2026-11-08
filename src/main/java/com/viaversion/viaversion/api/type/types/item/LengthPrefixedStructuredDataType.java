/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.item.StructuredDataType;
import com.viaversion.viaversion.api.type.types.item.StructuredDataTypeBase;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public class LengthPrefixedStructuredDataType
extends Type<StructuredData<?>>
implements StructuredDataTypeBase {
    private final StructuredDataType wrapped;

    public LengthPrefixedStructuredDataType(StructuredDataType structuredDataType) {
        super(StructuredData.class);
        this.wrapped = structuredDataType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, StructuredData<?> structuredData) {
        Types.VAR_INT.writePrimitive(byteBuf, structuredData.id());
        ByteBuf byteBuf2 = byteBuf.alloc().buffer();
        try {
            structuredData.write(byteBuf2);
            Types.VAR_INT.writePrimitive(byteBuf, byteBuf2.readableBytes());
            byteBuf.writeBytes(byteBuf2);
        }
        finally {
            byteBuf2.release();
        }
    }

    @Override
    public StructuredData<?> read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        StructuredDataKey<?> structuredDataKey = this.key(n);
        if (structuredDataKey == null) {
            throw new IllegalArgumentException("No data component serializer found for id " + n);
        }
        int n2 = Types.VAR_INT.readPrimitive(byteBuf);
        ByteBuf byteBuf2 = byteBuf.readSlice(n2);
        return this.wrapped.readData(byteBuf2, structuredDataKey, n);
    }

    @Override
    public @Nullable StructuredDataKey<?> key(int n) {
        return this.wrapped.key(n);
    }
}

