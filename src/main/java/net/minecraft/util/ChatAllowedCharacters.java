/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public class ChatAllowedCharacters {
    public static final char[] allowedCharactersArray = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};

    public static boolean isAllowedCharacter(char c) {
        return c != '\u00a7' && c >= ' ' && c != '\u007f';
    }

    public static String filterAllowedCharacters(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (!ChatAllowedCharacters.isAllowedCharacter(c)) continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

