/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.LongArrayTag;

public class LongArrayTagConverter
implements TagConverter<LongArrayTag, long[]> {
    @Override
    public long[] convert(LongArrayTag longArrayTag) {
        return longArrayTag.getValue();
    }

    @Override
    public LongArrayTag convert(long[] lArray) {
        return new LongArrayTag(lArray);
    }
}

