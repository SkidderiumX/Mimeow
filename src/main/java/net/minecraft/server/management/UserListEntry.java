/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.gson.JsonObject;

public class UserListEntry<T> {
    private final T value;

    public UserListEntry(T t) {
        this.value = t;
    }

    protected UserListEntry(T t, JsonObject jsonObject) {
        this.value = t;
    }

    T getValue() {
        return this.value;
    }

    boolean hasBanExpired() {
        return false;
    }

    protected void onSerialization(JsonObject jsonObject) {
    }
}

