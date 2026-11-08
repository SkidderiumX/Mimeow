/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public enum ChatFormatting {
    BLACK('0'),
    DARK_BLUE('1'),
    DARK_GREEN('2'),
    DARK_AQUA('3'),
    DARK_RED('4'),
    DARK_PURPLE('5'),
    GOLD('6'),
    GRAY('7'),
    DARK_GRAY('8'),
    BLUE('9'),
    GREEN('a'),
    AQUA('b'),
    RED('c'),
    LIGHT_PURPLE('d'),
    YELLOW('e'),
    WHITE('f'),
    OBFUSCATED('k', true),
    BOLD('l', true),
    STRIKETHROUGH('m', true),
    UNDERLINE('n', true),
    ITALIC('o', true),
    RESET('r');

    public static final char PREFIX_CODE = '\u00a7';
    private static final Map<Character, ChatFormatting> FORMATTING_BY_CHAR;
    private static final Map<String, ChatFormatting> FORMATTING_BY_NAME;
    private static final Pattern STRIP_FORMATTING_PATTERN;
    private final char code;
    private final boolean isFormat;
    private final String toString;

    private ChatFormatting(char c) {
        this(c, false);
    }

    private ChatFormatting(char c, boolean bl) {
        this.code = c;
        this.isFormat = bl;
        this.toString = "\u00a7" + c;
    }

    public char getChar() {
        return this.code;
    }

    public boolean isFormat() {
        return this.isFormat;
    }

    public boolean isColor() {
        return !this.isFormat && this != RESET;
    }

    public String getName() {
        return this.name().toLowerCase();
    }

    public String toString() {
        return this.toString;
    }

    public static String stripFormatting(String string) {
        return string == null ? null : STRIP_FORMATTING_PATTERN.matcher(string).replaceAll("");
    }

    public static ChatFormatting getByChar(char c) {
        return FORMATTING_BY_CHAR.get(Character.valueOf(c));
    }

    public static ChatFormatting getByName(String string) {
        if (string == null) {
            return null;
        }
        return FORMATTING_BY_NAME.get(string.toLowerCase());
    }

    public static Collection<String> getNames(boolean bl, boolean bl2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (ChatFormatting chatFormatting : ChatFormatting.values()) {
            if (chatFormatting.isColor() && !bl || chatFormatting.isFormat() && !bl2) continue;
            arrayList.add(chatFormatting.getName());
        }
        return arrayList;
    }

    static {
        FORMATTING_BY_CHAR = new HashMap<Character, ChatFormatting>();
        FORMATTING_BY_NAME = new HashMap<String, ChatFormatting>();
        STRIP_FORMATTING_PATTERN = Pattern.compile("(?i)" + String.valueOf('\u00a7') + "[0-9A-FK-OR]");
        for (ChatFormatting chatFormatting : ChatFormatting.values()) {
            FORMATTING_BY_CHAR.put(Character.valueOf(chatFormatting.getChar()), chatFormatting);
            FORMATTING_BY_NAME.put(chatFormatting.getName(), chatFormatting);
        }
    }
}

