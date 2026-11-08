/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util;

public class StringUtil {
    public static String emptyToNull(String string) {
        if (string == null || string.isEmpty() || string.trim().isEmpty()) {
            return null;
        }
        return string;
    }
}

