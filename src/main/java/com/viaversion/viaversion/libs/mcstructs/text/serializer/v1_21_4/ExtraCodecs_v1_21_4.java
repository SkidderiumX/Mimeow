/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_4;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.NbtConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Arrays;
import java.util.UUID;

public class ExtraCodecs_v1_21_4 {
    public static final Codec<Integer> ARGB_COLOR = Codec.oneOf(Codec.INTEGER, Codec.FLOAT.listOf(4, 4).map(n -> {
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        return Arrays.asList(Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f));
    }, list -> {
        int n = (int)(((Float)list.get(0)).floatValue() * 255.0f);
        int n2 = (int)(((Float)list.get(1)).floatValue() * 255.0f);
        int n3 = (int)(((Float)list.get(2)).floatValue() * 255.0f);
        int n4 = (int)(((Float)list.get(3)).floatValue() * 255.0f);
        return n4 << 24 | n << 16 | n2 << 8 | n3;
    }));
    public static final Codec<UUID> LENIENT_UUID = Codec.oneOf(Codec.INT_ARRAY_UUID, Codec.STRICT_STRING_UUID);
    public static final Codec<CompoundTag> INLINED_COMPOUND_TAG = NbtConverter_v1_20_3.INSTANCE.toCodec().verified(tag -> {
        if (!(tag instanceof CompoundTag)) {
            return Result.error("Expected a compound tag");
        }
        return null;
    }).map(compoundTag -> compoundTag, tag -> (CompoundTag)tag);
}

