/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface StructuredDataTypeBase {
    public StructuredData<?> read(ByteBuf var1);

    public void write(ByteBuf var1, StructuredData<?> var2);

    public @Nullable StructuredDataKey<?> key(int var1);
}

