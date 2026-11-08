/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

public class BlockStates1_13 {
    public static void forEach(CompoundTag compoundTag, ObjIntConsumer<String> objIntConsumer) {
        ListTag<CompoundTag> listTag = compoundTag.getListTag("properties", CompoundTag.class);
        int n = 0;
        for (CompoundTag compoundTag2 : compoundTag.getListTag("blockstates", CompoundTag.class)) {
            String string = compoundTag2.getString("name");
            IntArrayTag intArrayTag = compoundTag2.getIntArrayTag("properties");
            if (intArrayTag == null) {
                objIntConsumer.accept(string, n++);
                continue;
            }
            List<String> list = List.of("");
            for (int n2 : intArrayTag.getValue()) {
                CompoundTag compoundTag3 = listTag.get(n2);
                String string2 = compoundTag3.getString("name");
                ArrayList<String> arrayList = new ArrayList<String>();
                for (String string3 : list) {
                    for (StringTag stringTag : compoundTag3.getListTag("values", StringTag.class)) {
                        String string4 = string3.isEmpty() ? string2 + "=" + stringTag.getValue() : string3 + "," + string2 + "=" + stringTag.getValue();
                        arrayList.add(string4);
                    }
                }
                list = arrayList;
            }
            Object object = list.iterator();
            while (object.hasNext()) {
                String string5 = (String)object.next();
                objIntConsumer.accept(string + "[" + string5 + "]", n++);
            }
        }
    }
}

