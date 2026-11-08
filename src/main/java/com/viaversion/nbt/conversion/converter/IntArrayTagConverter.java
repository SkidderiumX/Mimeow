/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.IntArrayTag;

public class IntArrayTagConverter
implements TagConverter<IntArrayTag, int[]> {
    @Override
    public int[] convert(IntArrayTag intArrayTag) {
        return intArrayTag.getValue();
    }

    @Override
    public IntArrayTag convert(int[] nArray) {
        return new IntArrayTag(nArray);
    }
}

