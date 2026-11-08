/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.item.BaseItemArrayType;
import io.netty.buffer.ByteBuf;

public class ItemShortArrayType1_13_2
extends BaseItemArrayType {
    @Override
    public Item[] read(ByteBuf byteBuf) {
        int n = Types.SHORT.readPrimitive(byteBuf);
        Item[] itemArray = new Item[n];
        for (int i = 0; i < n; ++i) {
            itemArray[i] = (Item)Types.ITEM1_13_2.read(byteBuf);
        }
        return itemArray;
    }

    @Override
    public void write(ByteBuf byteBuf, Item[] itemArray) {
        Types.SHORT.writePrimitive(byteBuf, (short)itemArray.length);
        for (Item item : itemArray) {
            Types.ITEM1_13_2.write(byteBuf, item);
        }
    }
}

