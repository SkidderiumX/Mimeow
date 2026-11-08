/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class ItemCostType1_20_5
extends Type<Item> {
    private static final StructuredData<?>[] EMPTY_DATA_ARRAY = new StructuredData[0];
    private final Type<StructuredData<?>[]> dataArrayType;

    public ItemCostType1_20_5(Type<StructuredData<?>[]> type) {
        super(Item.class);
        this.dataArrayType = type;
    }

    @Override
    public Item read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        int n2 = Types.VAR_INT.readPrimitive(byteBuf);
        StructuredData[] structuredDataArray = (StructuredData[])this.dataArrayType.read(byteBuf);
        return new StructuredItem(n, n2, new StructuredDataContainer(structuredDataArray));
    }

    @Override
    public void write(ByteBuf byteBuf, Item item) {
        Types.VAR_INT.writePrimitive(byteBuf, item.identifier());
        Types.VAR_INT.writePrimitive(byteBuf, item.amount());
        this.dataArrayType.write(byteBuf, item.dataContainer().data().values().toArray(EMPTY_DATA_ARRAY));
    }

    public static final class OptionalItemCostType
    extends OptionalType<Item> {
        public OptionalItemCostType(Type<Item> type) {
            super(type);
        }
    }
}

