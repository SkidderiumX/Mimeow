/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.DoubleTag;

public class DoubleTagConverter
implements TagConverter<DoubleTag, Double> {
    @Override
    public Double convert(DoubleTag doubleTag) {
        return doubleTag.getValue();
    }

    @Override
    public DoubleTag convert(Double d) {
        return new DoubleTag(d);
    }
}

