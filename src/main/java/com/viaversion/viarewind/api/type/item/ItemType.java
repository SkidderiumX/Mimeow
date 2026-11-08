/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class ItemType
extends Type<Item> {
    public ItemType() {
        super(Item.class);
    }

    @Override
    public Item read(ByteBuf byteBuf) {
        short s = byteBuf.readShort();
        if (s < 0) {
            return null;
        }
        DataItem dataItem = new DataItem();
        dataItem.setIdentifier(s);
        dataItem.setAmount(byteBuf.readByte());
        dataItem.setData(byteBuf.readShort());
        dataItem.setTag((CompoundTag)RewindTypes.COMPRESSED_NBT.read(byteBuf));
        return dataItem;
    }

    @Override
    public void write(ByteBuf byteBuf, Item item) {
        if (item == null) {
            byteBuf.writeShort(-1);
        } else {
            byteBuf.writeShort(item.identifier());
            byteBuf.writeByte(item.amount());
            byteBuf.writeShort(item.data());
            RewindTypes.COMPRESSED_NBT.write(byteBuf, item.tag());
        }
    }
}

