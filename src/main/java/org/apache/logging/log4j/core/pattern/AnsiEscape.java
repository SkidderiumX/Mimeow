/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum AnsiEscape {
    PREFIX("\u001b["),
    SUFFIX("m"),
    SEPARATOR(";"),
    NORMAL("0"),
    BRIGHT("1"),
    DIM("2"),
    UNDERLINE("3"),
    BLINK("5"),
    REVERSE("7"),
    HIDDEN("8"),
    BLACK("30"),
    FG_BLACK("30"),
    RED("31"),
    FG_RED("31"),
    GREEN("32"),
    FG_GREEN("32"),
    YELLOW("33"),
    FG_YELLOW("33"),
    BLUE("34"),
    FG_BLUE("34"),
    MAGENTA("35"),
    FG_MAGENTA("35"),
    CYAN("36"),
    FG_CYAN("36"),
    WHITE("37"),
    FG_WHITE("37"),
    DEFAULT("39"),
    FG_DEFAULT("39"),
    BG_BLACK("40"),
    BG_RED("41"),
    BG_GREEN("42"),
    BG_YELLOW("43"),
    BG_BLUE("44"),
    BG_MAGENTA("45"),
    BG_CYAN("46"),
    BG_WHITE("47");

    private static final String WHITESPACE_REGEX = "\\s*";
    private final String code;

    private AnsiEscape(String string2) {
        this.code = string2;
    }

    public static String getDefaultStyle() {
        return PREFIX.getCode() + SUFFIX.getCode();
    }

    private static String toRegexSeparator(String string) {
        return WHITESPACE_REGEX + string + WHITESPACE_REGEX;
    }

    public String getCode() {
        return this.code;
    }

    public static Map<String, String> createMap(String string, String[] stringArray) {
        return AnsiEscape.createMap(string.split(AnsiEscape.toRegexSeparator(",")), stringArray);
    }

    public static Map<String, String> createMap(String[] stringArray, String[] stringArray2) {
        Object[] objectArray = stringArray2 != null ? (String[])stringArray2.clone() : new String[]{};
        Arrays.sort(objectArray);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (String string : stringArray) {
            String[] stringArray3 = string.split(AnsiEscape.toRegexSeparator("="));
            if (stringArray3.length <= 1) continue;
            String string2 = stringArray3[0].toUpperCase(Locale.ENGLISH);
            String string3 = stringArray3[1];
            boolean bl = Arrays.binarySearch(objectArray, string2) < 0;
            hashMap.put(string2, bl ? AnsiEscape.createSequence(string3.split("\\s")) : string3);
        }
        return hashMap;
    }

    public static String createSequence(String ... stringArray) {
        if (stringArray == null) {
            return AnsiEscape.getDefaultStyle();
        }
        StringBuilder stringBuilder = new StringBuilder(PREFIX.getCode());
        boolean bl = true;
        for (String string : stringArray) {
            try {
                AnsiEscape ansiEscape = AnsiEscape.valueOf(string.trim().toUpperCase(Locale.ENGLISH));
                if (!bl) {
                    stringBuilder.append(SEPARATOR.getCode());
                }
                bl = false;
                stringBuilder.append(ansiEscape.getCode());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        stringBuilder.append(SUFFIX.getCode());
        return stringBuilder.toString();
    }
}

