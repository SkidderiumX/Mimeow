/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

public class StringUtil {
    public static String forLogging(Object object) {
        return StringUtil.forLogging(String.valueOf(object));
    }

    public static String forLogging(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (c == '\t' || c == '\n' || c == '\r') {
                stringBuilder.append(' ');
                continue;
            }
            if (Character.isISOControl(c)) continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

