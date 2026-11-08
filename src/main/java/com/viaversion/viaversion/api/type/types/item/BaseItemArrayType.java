/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;

public abstract class BaseItemArrayType
extends Type<Item[]> {
    protected BaseItemArrayType() {
        super(Item[].class);
    }

    protected BaseItemArrayType(String string) {
        super(string, Item[].class);
    }

    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseItemArrayType.class;
    }
}

