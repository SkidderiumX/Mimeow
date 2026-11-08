/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type.item;

import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class ItemArrayType
extends Type<Item[]> {
    public ItemArrayType() {
        super(Item[].class);
    }

    @Override
    public Item[] read(ByteBuf byteBuf) {
        int n = Types.SHORT.readPrimitive(byteBuf);
        Item[] itemArray = new Item[n];
        for (int i = 0; i < n; ++i) {
            itemArray[i] = (Item)RewindTypes.COMPRESSED_NBT_ITEM.read(byteBuf);
        }
        return itemArray;
    }

    @Override
    public void write(ByteBuf byteBuf, Item[] itemArray) {
        Types.SHORT.writePrimitive(byteBuf, (short)itemArray.length);
        for (Item item : itemArray) {
            RewindTypes.COMPRESSED_NBT_ITEM.write(byteBuf, item);
        }
    }
}

