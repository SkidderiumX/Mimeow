/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.FloatTag;

public class FloatTagConverter
implements TagConverter<FloatTag, Float> {
    @Override
    public Float convert(FloatTag floatTag) {
        return floatTag.getValue();
    }

    @Override
    public FloatTag convert(Float f) {
        return new FloatTag(f.floatValue());
    }
}

