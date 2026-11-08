/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.ShortTag;

public class ShortTagConverter
implements TagConverter<ShortTag, Short> {
    @Override
    public Short convert(ShortTag shortTag) {
        return shortTag.getValue();
    }

    @Override
    public ShortTag convert(Short s) {
        return new ShortTag(s);
    }
}

