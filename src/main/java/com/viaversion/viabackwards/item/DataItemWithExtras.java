/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DataItemWithExtras
extends DataItem {
    private JsonElement name;
    private List<JsonElement> lore;

    public DataItemWithExtras(Item item) {
        ListTag<StringTag> listTag;
        this.setIdentifier(item.identifier());
        this.setAmount(item.amount());
        this.setData(item.data());
        this.setTag(item.tag());
        if (this.tag() == null) {
            return;
        }
        CompoundTag compoundTag = this.tag().getCompoundTag("display");
        if (compoundTag == null) {
            return;
        }
        StringTag stringTag = compoundTag.getStringTag("Name");
        if (stringTag != null) {
            this.name = this.parse(stringTag.getValue());
        }
        if ((listTag = compoundTag.getListTag("Lore", StringTag.class)) != null) {
            this.lore = new ArrayList<JsonElement>(listTag.size());
            for (int i = 0; i < listTag.size(); ++i) {
                this.lore.add(this.parse(listTag.get(i).getValue()));
            }
        }
    }

    public @Nullable JsonElement name() {
        return this.name;
    }

    public @Nullable StringTag rawName() {
        if (this.tag() == null) {
            return null;
        }
        CompoundTag compoundTag = this.tag().getCompoundTag("display");
        return compoundTag != null ? compoundTag.getStringTag("Name") : null;
    }

    public @Nullable List<JsonElement> lore() {
        return this.lore;
    }

    public @Nullable ListTag<StringTag> rawLore() {
        if (this.tag() == null) {
            return null;
        }
        CompoundTag compoundTag = this.tag().getCompoundTag("display");
        return compoundTag != null ? compoundTag.getListTag("Lore", StringTag.class) : null;
    }

    private JsonElement parse(String string) {
        try {
            return JsonParser.parseString(string);
        }
        catch (JsonSyntaxException jsonSyntaxException) {
            return new JsonPrimitive(string);
        }
    }
}

