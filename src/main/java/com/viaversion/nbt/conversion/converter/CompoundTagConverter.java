/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.ConverterRegistry;
import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import java.util.HashMap;
import java.util.Map;

public class CompoundTagConverter
implements TagConverter<CompoundTag, Map> {
    @Override
    public Map convert(CompoundTag compoundTag) {
        HashMap hashMap = new HashMap();
        Object object = compoundTag.getValue();
        for (Map.Entry entry : object.entrySet()) {
            hashMap.put((String)entry.getKey(), ConverterRegistry.convertToValue((Tag)entry.getValue()));
        }
        return hashMap;
    }

    @Override
    public CompoundTag convert(Map map) {
        HashMap<String, Tag> hashMap = new HashMap<String, Tag>();
        for (Object k : map.keySet()) {
            String string = (String)k;
            hashMap.put(string, (Tag)ConverterRegistry.convertToTag(map.get(string)));
        }
        return new CompoundTag(hashMap);
    }
}

