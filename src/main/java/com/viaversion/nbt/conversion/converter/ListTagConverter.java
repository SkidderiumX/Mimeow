/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.ConverterRegistry;
import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTagConverter
implements TagConverter<ListTag, List> {
    @Override
    public List convert(ListTag listTag) {
        ArrayList arrayList = new ArrayList();
        Object object = listTag.getValue();
        Iterator iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            Tag tag = (Tag)iterator2.next();
            arrayList.add(ConverterRegistry.convertToValue(tag));
        }
        return arrayList;
    }

    @Override
    public ListTag convert(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object e : list) {
            arrayList.add(ConverterRegistry.convertToTag(e));
        }
        return new ListTag(arrayList);
    }
}

