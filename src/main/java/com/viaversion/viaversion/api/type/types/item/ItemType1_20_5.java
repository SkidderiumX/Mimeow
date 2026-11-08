/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.item.StructuredDataTypeBase;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import java.util.Map;

public class ItemType1_20_5
extends Type<Item> {
    private final StructuredDataTypeBase dataType;

    public ItemType1_20_5(StructuredDataTypeBase structuredDataTypeBase) {
        super(Item.class);
        this.dataType = structuredDataTypeBase;
    }

    @Override
    public Item read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        if (n <= 0) {
            return StructuredItem.empty();
        }
        int n2 = Types.VAR_INT.readPrimitive(byteBuf);
        Map<StructuredDataKey<?>, StructuredData<?>> map = this.readData(byteBuf);
        return new StructuredItem(n2, n, new StructuredDataContainer(map));
    }

    protected Map<StructuredDataKey<?>, StructuredData<?>> readData(ByteBuf byteBuf) {
        StructuredDataKey<?> structuredDataKey;
        int n;
        int n2 = Types.VAR_INT.readPrimitive(byteBuf);
        int n3 = Types.VAR_INT.readPrimitive(byteBuf);
        if (n2 == 0 && n3 == 0) {
            return new Reference2ObjectOpenHashMap(0);
        }
        Reference2ObjectOpenHashMap reference2ObjectOpenHashMap = new Reference2ObjectOpenHashMap(Math.min(n2 + n3, 128));
        for (n = 0; n < n2; ++n) {
            StructuredData<?> structuredData = this.dataType.read(byteBuf);
            structuredDataKey = this.dataType.key(structuredData.id());
            Preconditions.checkNotNull(structuredDataKey, "No data component serializer found for %s", structuredData);
            reference2ObjectOpenHashMap.put(structuredDataKey, structuredData);
        }
        for (n = 0; n < n3; ++n) {
            int n4 = Types.VAR_INT.readPrimitive(byteBuf);
            structuredDataKey = this.dataType.key(n4);
            Preconditions.checkNotNull(structuredDataKey, "No data component serializer found for empty id %s", n4);
            reference2ObjectOpenHashMap.put(structuredDataKey, StructuredData.empty(structuredDataKey, n4));
        }
        return reference2ObjectOpenHashMap;
    }

    @Override
    public void write(ByteBuf byteBuf, Item item) {
        if (item.isEmpty()) {
            Types.VAR_INT.writePrimitive(byteBuf, 0);
            return;
        }
        Types.VAR_INT.writePrimitive(byteBuf, item.amount());
        Types.VAR_INT.writePrimitive(byteBuf, item.identifier());
        this.writeData(byteBuf, item);
    }

    protected void writeData(ByteBuf byteBuf, Item item) {
        Map<StructuredDataKey<?>, StructuredData<?>> map = item.dataContainer().data();
        int n = 0;
        int n2 = 0;
        for (StructuredData<?> structuredData : map.values()) {
            if (structuredData.isPresent()) {
                ++n;
                continue;
            }
            ++n2;
        }
        Types.VAR_INT.writePrimitive(byteBuf, n);
        Types.VAR_INT.writePrimitive(byteBuf, n2);
        for (StructuredData<?> structuredData : map.values()) {
            if (!structuredData.isPresent()) continue;
            this.dataType.write(byteBuf, structuredData);
        }
        for (StructuredData<?> structuredData : map.values()) {
            if (!structuredData.isEmpty()) continue;
            Types.VAR_INT.writePrimitive(byteBuf, structuredData.id());
        }
    }

    @Override
    public void write(Ops ops, Item item) {
        ops.writeMap(mapSerializer2 -> {
            mapSerializer2.write("id", Types.IDENTIFIER, ops.context().registryAccess().item(item.identifier())).write("count", Types.VAR_INT, item.amount());
            if (item.dataContainer().isEmpty()) {
                return;
            }
            mapSerializer2.writeMap("components", mapSerializer -> {
                for (StructuredData<?> structuredData : item.dataContainer().data().values()) {
                    Object object = Key.namespaced(structuredData.key().identifier());
                    if (structuredData.isEmpty()) {
                        object = "!" + (String)object;
                    }
                    mapSerializer.write((String)object, (Type)((Object)this.dataType), structuredData);
                }
            });
        });
    }

    public final class OptionalItemType
    extends OptionalType<Item> {
        public OptionalItemType() {
            super(ItemType1_20_5.this);
        }
    }
}

