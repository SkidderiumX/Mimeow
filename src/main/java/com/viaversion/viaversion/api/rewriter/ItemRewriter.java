/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.rewriter.Rewriter;
import com.viaversion.viaversion.api.type.Type;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ItemRewriter<T extends Protocol<?, ?, ?, ?>>
extends Rewriter<T> {
    public @Nullable Item handleItemToClient(UserConnection var1, @Nullable Item var2);

    public @Nullable Item handleItemToServer(UserConnection var1, @Nullable Item var2);

    public HashedItem handleHashedItem(UserConnection var1, HashedItem var2);

    default public @Nullable Type<Item> itemType() {
        return null;
    }

    default public @Nullable Type<Item[]> itemArrayType() {
        return null;
    }

    default public @Nullable Type<Item> mappedItemType() {
        return this.itemType();
    }

    default public @Nullable Type<Item[]> mappedItemArrayType() {
        return this.itemArrayType();
    }

    default public @Nullable Type<Item> itemTemplateType() {
        return this.itemType();
    }

    default public @Nullable Type<Item> mappedItemTemplateType() {
        return this.mappedItemType();
    }

    default public String nbtTagName() {
        return "VV|" + this.protocol().getClass().getSimpleName();
    }

    default public String nbtTagName(String string) {
        return this.nbtTagName() + "|" + string;
    }
}

