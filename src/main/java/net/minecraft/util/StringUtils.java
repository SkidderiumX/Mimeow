/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern patternControlCode = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");

    public static String ticksToElapsedTime(int n) {
        int n2 = n / 20;
        int n3 = n2 / 60;
        return (n2 %= 60) < 10 ? n3 + ":0" + n2 : n3 + ":" + n2;
    }

    public static String stripControlCodes(String string) {
        return patternControlCode.matcher(string).replaceAll("");
    }

    public static boolean isNullOrEmpty(String string) {
        return org.apache.commons.lang3.StringUtils.isEmpty(string);
    }
}

