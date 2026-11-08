/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;

public class ContainterContents {

    public static final class ContainerContentsType
    extends ArrayType<Item> {
        private final Type<Item> itemType;

        public ContainerContentsType(Type<Item> type) {
            super(type, 256);
            this.itemType = type;
        }

        @Override
        public void write(Ops ops, Item[] itemArray) {
            ops.writeList(listSerializer -> {
                for (int i = 0; i < itemArray.length; ++i) {
                    Item item = itemArray[i];
                    if (item == null || item.isEmpty()) continue;
                    int n = i;
                    listSerializer.writeMap(mapSerializer -> mapSerializer.write("slot", Types.INT, n).write("item", this.itemType, item));
                }
            });
        }
    }
}

