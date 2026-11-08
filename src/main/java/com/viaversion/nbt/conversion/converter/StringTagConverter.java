/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.StringTag;

public class StringTagConverter
implements TagConverter<StringTag, String> {
    @Override
    public String convert(StringTag stringTag) {
        return stringTag.getValue();
    }

    @Override
    public StringTag convert(String string) {
        return new StringTag(string);
    }
}

