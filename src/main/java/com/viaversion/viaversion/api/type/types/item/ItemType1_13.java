/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemType1_13
extends Type<Item> {
    public ItemType1_13() {
        super(Item.class);
    }

    @Override
    public @Nullable Item read(ByteBuf byteBuf) {
        short s = byteBuf.readShort();
        if (s < 0) {
            return null;
        }
        DataItem dataItem = new DataItem();
        dataItem.setIdentifier(s);
        dataItem.setAmount(byteBuf.readByte());
        dataItem.setTag((CompoundTag)Types.NAMED_COMPOUND_TAG.read(byteBuf));
        return dataItem;
    }

    @Override
    public void write(ByteBuf byteBuf, @Nullable Item item) {
        if (item == null) {
            byteBuf.writeShort(-1);
        } else {
            byteBuf.writeShort(item.identifier());
            byteBuf.writeByte(item.amount());
            Types.NAMED_COMPOUND_TAG.write(byteBuf, item.tag());
        }
    }
}

