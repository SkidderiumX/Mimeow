/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.ByteArrayTag;

public class ByteArrayTagConverter
implements TagConverter<ByteArrayTag, byte[]> {
    @Override
    public byte[] convert(ByteArrayTag byteArrayTag) {
        return byteArrayTag.getValue();
    }

    @Override
    public ByteArrayTag convert(byte[] byArray) {
        return new ByteArrayTag(byArray);
    }
}

