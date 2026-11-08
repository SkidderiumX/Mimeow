/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.util.CustomKey;
import com.viaversion.viaversion.util.MinecraftKey;
import org.checkerframework.checker.nullness.qual.Nullable;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
public abstract class Key {
    public static Key of(String string, String string2) {
        if (string.equals("minecraft") || string.isEmpty()) {
            return Key.ofPath(string2);
        }
        return new CustomKey(string + ":" + string2, string, string2);
    }

    public static Key ofPath(String string) {
        return new MinecraftKey.CompactMinecraftKey(string);
    }

    public static Key of(String string) {
        int n = string.indexOf(58);
        if (n == -1) {
            return Key.ofPath(string);
        }
        String string2 = string.substring(n + 1);
        if (n == 0) {
            return new MinecraftKey.ColonPrefixedMinecraftKey(string, string2);
        }
        String string3 = string.substring(0, n);
        if (string3.equals("minecraft")) {
            return new MinecraftKey.FullMinecraftKey(string, string2);
        }
        return new CustomKey(string, string3, string2);
    }

    public static @Nullable Key tryParse(String string) {
        try {
            return Key.of(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    public abstract String namespace();

    public abstract String path();

    public abstract String original();

    public abstract String minimized();

    public abstract boolean hasMinecraftNamespace();

    public Key withNamespace(String string) {
        return Key.of(string, this.path());
    }

    public Key withPath(String string) {
        return Key.of(this.namespace(), string);
    }

    public final boolean equals(String string) {
        return this.equals(Key.of(string));
    }

    public static String stripNamespace(String string) {
        int n = string.indexOf(58);
        if (n == -1) {
            return string;
        }
        return string.substring(n + 1);
    }

    public static String namespace(String string) {
        int n = string.indexOf(58);
        if (n == -1 || n == 0) {
            return "minecraft";
        }
        return string.substring(0, n);
    }

    public static String stripMinecraftNamespace(String string) {
        if (string.startsWith("minecraft:")) {
            return string.substring(MinecraftKey.MINECRAFT_NAMESPACE_LENGTH + 1);
        }
        if (!string.isEmpty() && string.charAt(0) == ':') {
            return string.substring(1);
        }
        return string;
    }

    public static boolean equals(String string, String string2) {
        return string != null && string2 != null && Key.of(string).equals(Key.of(string2));
    }

    public static String namespaced(String string) {
        int n = string.indexOf(58);
        if (n == -1) {
            return "minecraft:" + string;
        }
        if (n == 0) {
            return "minecraft" + string;
        }
        return string;
    }

    public static boolean isValid(String string) {
        int n = string.indexOf(58);
        if (n == -1) {
            return MinecraftKey.isValidPath(string);
        }
        if (n == 0) {
            return MinecraftKey.isValidPath(string.substring(1));
        }
        String string2 = string.substring(0, n);
        String string3 = string.substring(n + 1);
        return MinecraftKey.isValidNamespace(string2) && MinecraftKey.isValidPath(string3);
    }
}

