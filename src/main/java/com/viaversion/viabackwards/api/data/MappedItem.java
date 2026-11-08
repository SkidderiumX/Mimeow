/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.util.Key;

public class MappedItem {
    private final int id;
    private final String jsonName;
    private final Tag tagName;
    private final int customModelData;

    public MappedItem(int n, String string, String string2, int n2) {
        this.id = n;
        string = Key.stripMinecraftNamespace(string);
        String string3 = "vb.item." + string;
        this.jsonName = MappedItem.itemJsonName(string2);
        this.tagName = MappedItem.itemTagName(string3, string2);
        this.customModelData = n2;
    }

    private static String itemJsonName(String string) {
        return "{\"italic\":false,\"color\":\"white\",\"text\":%s}\n".formatted(new JsonPrimitive(string).toString());
    }

    private static Tag itemTagName(String string, String string2) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("color", "white");
        compoundTag.putString("translate", string);
        compoundTag.putString("fallback", string2);
        compoundTag.putBoolean("italic", false);
        return compoundTag;
    }

    public int id() {
        return this.id;
    }

    public String jsonName() {
        return this.jsonName;
    }

    public Tag tagName() {
        return this.tagName.copy();
    }

    public int customModelData() {
        return this.customModelData;
    }
}

