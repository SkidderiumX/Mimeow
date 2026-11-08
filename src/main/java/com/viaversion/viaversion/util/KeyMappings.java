/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.util.Key;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.Nullable;

public class KeyMappings {
    private final Object2IntMap<String> keyToId;
    private final Key[] keys;

    public KeyMappings(Key ... keyArray) {
        this.keys = keyArray;
        this.keyToId = new Object2IntOpenHashMap<String>(keyArray.length);
        this.keyToId.defaultReturnValue(-1);
        for (int i = 0; i < keyArray.length; ++i) {
            this.keyToId.put(keyArray[i].minimized(), i);
        }
    }

    public KeyMappings(String ... stringArray) {
        this((Key[])Arrays.stream(stringArray).map(Key::of).toArray(Key[]::new));
    }

    public KeyMappings(ListTag<StringTag> listTag) {
        this((String[])listTag.getValue().stream().map(StringTag::getValue).toArray(String[]::new));
    }

    public @Nullable String idToKey(int n) {
        if (n < 0 || n >= this.keys.length) {
            return null;
        }
        return this.keys[n].minimized();
    }

    public @Nullable Key key(int n) {
        if (n < 0 || n >= this.keys.length) {
            return null;
        }
        return this.keys[n];
    }

    public int keyToId(String string) {
        return this.keyToId.getInt(Key.stripMinecraftNamespace(string));
    }

    public Key[] keys() {
        return this.keys;
    }

    public int size() {
        return this.keys.length;
    }
}

