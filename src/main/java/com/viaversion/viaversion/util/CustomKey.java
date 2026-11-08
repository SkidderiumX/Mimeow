/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MinecraftKey;

public class CustomKey
extends Key {
    private final String original;
    private final String namespace;
    private final String path;

    CustomKey(String string, String string2, String string3) {
        if (!MinecraftKey.isValidNamespace(string2)) {
            throw new IllegalArgumentException("Invalid namespace: " + string2);
        }
        if (!MinecraftKey.isValidPath(string3)) {
            throw new IllegalArgumentException("Invalid path: " + string3);
        }
        this.original = string;
        this.namespace = string2;
        this.path = string3;
    }

    @Override
    public String namespace() {
        return this.namespace;
    }

    @Override
    public String path() {
        return this.path;
    }

    @Override
    public String original() {
        return this.original;
    }

    @Override
    public String minimized() {
        return this.original;
    }

    @Override
    public boolean hasMinecraftNamespace() {
        return false;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CustomKey)) {
            return false;
        }
        CustomKey customKey = (CustomKey)object;
        return this.original.equals(customKey.original);
    }

    public int hashCode() {
        return this.original.hashCode();
    }

    public String toString() {
        return this.original;
    }
}

