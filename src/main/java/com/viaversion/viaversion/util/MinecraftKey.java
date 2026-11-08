/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.util.Key;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
public abstract class MinecraftKey
extends Key {
    static final String MINECRAFT_NAMESPACE = "minecraft";
    static final String MINECRAFT_NAMESPACE_WITH_COLON = "minecraft:";
    static final int MINECRAFT_NAMESPACE_LENGTH = "minecraft".length();
    private final String path;

    protected MinecraftKey(String string) {
        if (!MinecraftKey.isValidPath(string)) {
            throw new IllegalArgumentException("Invalid path: " + string);
        }
        this.path = string;
    }

    @Override
    public String namespace() {
        return MINECRAFT_NAMESPACE;
    }

    @Override
    public String path() {
        return this.path;
    }

    @Override
    public String minimized() {
        return this.path;
    }

    @Override
    public boolean hasMinecraftNamespace() {
        return true;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MinecraftKey)) {
            return false;
        }
        MinecraftKey minecraftKey = (MinecraftKey)object;
        return this.path.equals(minecraftKey.path);
    }

    public int hashCode() {
        return this.path.hashCode();
    }

    static boolean isValidNamespace(String string) {
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '_' || c == '-' || c == '.') continue;
            return false;
        }
        return true;
    }

    static boolean isValidPath(String string) {
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if ((char)(c - 97) <= '\u0019' || (char)(c - 45) <= '\f' || c == '_') continue;
            return false;
        }
        return true;
    }

    public static final class FullMinecraftKey
    extends MinecraftKey {
        private final String identifier;

        FullMinecraftKey(String string, String string2) {
            super(string2);
            this.identifier = string;
        }

        @Override
        public String original() {
            return this.identifier;
        }

        public String toString() {
            return this.identifier;
        }
    }

    public static final class ColonPrefixedMinecraftKey
    extends MinecraftKey {
        private final String original;
        private String identifier;

        ColonPrefixedMinecraftKey(String string, String string2) {
            super(string2);
            this.original = string;
        }

        @Override
        public String original() {
            return this.original;
        }

        public String toString() {
            if (this.identifier == null) {
                this.identifier = MinecraftKey.MINECRAFT_NAMESPACE_WITH_COLON + this.path();
            }
            return this.identifier;
        }
    }

    public static final class CompactMinecraftKey
    extends MinecraftKey {
        private String identifier;

        CompactMinecraftKey(String string) {
            super(string);
        }

        @Override
        public String original() {
            return this.path();
        }

        public String toString() {
            if (this.identifier == null) {
                this.identifier = MinecraftKey.MINECRAFT_NAMESPACE_WITH_COLON + this.path();
            }
            return this.identifier;
        }
    }
}

