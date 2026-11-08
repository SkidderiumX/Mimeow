/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.IntTag;

public class IntTagConverter
implements TagConverter<IntTag, Integer> {
    @Override
    public Integer convert(IntTag intTag) {
        return intTag.getValue();
    }

    @Override
    public IntTag convert(Integer n) {
        return new IntTag(n);
    }
}

