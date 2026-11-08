/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;

public record ItemModel(Key key) implements Rewritable
{
    public static final Type<ItemModel> TYPE = TransformingType.of(Types.IDENTIFIER, ItemModel.class, ItemModel::new, ItemModel::key);

    @Override
    public ItemModel rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        String string = this.key().toString();
        String string2 = Rewritable.rewriteItem(protocol, bl, string);
        return string2 == null || string.equals(string2) ? this : new ItemModel(Key.of(string2));
    }
}

