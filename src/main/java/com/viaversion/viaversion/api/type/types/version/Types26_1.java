/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.minecraft.data.version.VersionedStructuredDataKeys;
import com.viaversion.viaversion.api.minecraft.entitydata.types.AbstractEntityDataTypes;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.item.ItemTemplateType26_1;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import java.util.function.Function;

public class Types26_1<K extends VersionedStructuredDataKeys, E extends AbstractEntityDataTypes>
extends Types1_20_5<K, E> {
    public final Type<Item> itemTemplate;
    public final Type<Item> optionalItemTemplate;
    public final ArrayType<Item> itemTemplateArray;

    public Types26_1(Function<VersionedTypesHolder, K> function, Function<VersionedTypesHolder, E> function2) {
        super(null, function2);
        this.itemTemplate = new ItemTemplateType26_1(this.structuredData);
        this.optionalItemTemplate = new ItemTemplateType26_1.OptionalItemTemplateType(this.itemTemplate);
        this.itemTemplateArray = new ArrayType<Item>(this.itemTemplate);
        this.initKeys(function);
    }

    @Override
    public Type<Item> itemTemplate() {
        return this.itemTemplate;
    }

    @Override
    public Type<Item> optionalItemTemplate() {
        return this.optionalItemTemplate;
    }

    @Override
    public ArrayType<Item> itemTemplateArray() {
        return this.itemTemplateArray;
    }
}

