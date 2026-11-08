/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItemTemplate;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.item.ItemType1_20_5;
import com.viaversion.viaversion.api.type.types.item.StructuredDataTypeBase;
import io.netty.buffer.ByteBuf;
import java.util.Map;

public class ItemTemplateType26_1
extends ItemType1_20_5 {
    public ItemTemplateType26_1(StructuredDataTypeBase structuredDataTypeBase) {
        super(structuredDataTypeBase);
    }

    @Override
    public Item read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        int n2 = Types.VAR_INT.readPrimitive(byteBuf);
        Map<StructuredDataKey<?>, StructuredData<?>> map = this.readData(byteBuf);
        return new StructuredItemTemplate(n, n2, new StructuredDataContainer(map));
    }

    @Override
    public void write(ByteBuf byteBuf, Item item) {
        Types.VAR_INT.writePrimitive(byteBuf, item.identifier());
        Types.VAR_INT.writePrimitive(byteBuf, item.amount());
        this.writeData(byteBuf, item);
    }

    public static final class OptionalItemTemplateType
    extends OptionalType<Item> {
        public OptionalItemTemplateType(Type<Item> type) {
            super(type);
        }
    }
}

