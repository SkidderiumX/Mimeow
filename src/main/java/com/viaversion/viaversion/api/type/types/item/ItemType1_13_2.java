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

public class ItemType1_13_2
extends Type<Item> {
    public ItemType1_13_2() {
        super(Item.class);
    }

    @Override
    public @Nullable Item read(ByteBuf byteBuf) {
        boolean bl = byteBuf.readBoolean();
        if (!bl) {
            return null;
        }
        DataItem dataItem = new DataItem();
        dataItem.setIdentifier(Types.VAR_INT.readPrimitive(byteBuf));
        dataItem.setAmount(byteBuf.readByte());
        dataItem.setTag((CompoundTag)Types.NAMED_COMPOUND_TAG.read(byteBuf));
        return dataItem;
    }

    @Override
    public void write(ByteBuf byteBuf, @Nullable Item item) {
        if (item == null) {
            byteBuf.writeBoolean(false);
        } else {
            byteBuf.writeBoolean(true);
            Types.VAR_INT.writePrimitive(byteBuf, item.identifier());
            byteBuf.writeByte(item.amount());
            Types.NAMED_COMPOUND_TAG.write(byteBuf, item.tag());
        }
    }
}

