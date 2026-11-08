/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.ByteTag;

public class ByteTagConverter
implements TagConverter<ByteTag, Byte> {
    @Override
    public Byte convert(ByteTag byteTag) {
        return byteTag.getValue();
    }

    @Override
    public ByteTag convert(Byte by) {
        return new ByteTag(by);
    }
}

