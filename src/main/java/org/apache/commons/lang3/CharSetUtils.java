/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.StringUtils;

public class CharSetUtils {
    public static String squeeze(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return string;
        }
        CharSet charSet = CharSet.getInstance(stringArray);
        StringBuilder stringBuilder = new StringBuilder(string.length());
        char[] cArray = string.toCharArray();
        int n = cArray.length;
        int n2 = 32;
        int n3 = 32;
        for (int i = 0; i < n; ++i) {
            n3 = cArray[i];
            if (n3 == n2 && i != 0 && charSet.contains((char)n3)) continue;
            stringBuilder.append((char)n3);
            n2 = n3;
        }
        return stringBuilder.toString();
    }

    public static boolean containsAny(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return false;
        }
        CharSet charSet = CharSet.getInstance(stringArray);
        for (char c : string.toCharArray()) {
            if (!charSet.contains(c)) continue;
            return true;
        }
        return false;
    }

    public static int count(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(stringArray);
        int n = 0;
        for (char c : string.toCharArray()) {
            if (!charSet.contains(c)) continue;
            ++n;
        }
        return n;
    }

    public static String keep(String string, String ... stringArray) {
        if (string == null) {
            return null;
        }
        if (string.isEmpty() || CharSetUtils.deepEmpty(stringArray)) {
            return "";
        }
        return CharSetUtils.modify(string, stringArray, true);
    }

    public static String delete(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return string;
        }
        return CharSetUtils.modify(string, stringArray, false);
    }

    private static String modify(String string, String[] stringArray, boolean bl) {
        CharSet charSet = CharSet.getInstance(stringArray);
        StringBuilder stringBuilder = new StringBuilder(string.length());
        char[] cArray = string.toCharArray();
        int n = cArray.length;
        for (int i = 0; i < n; ++i) {
            if (charSet.contains(cArray[i]) != bl) continue;
            stringBuilder.append(cArray[i]);
        }
        return stringBuilder.toString();
    }

    private static boolean deepEmpty(String[] stringArray) {
        if (stringArray != null) {
            for (String string : stringArray) {
                if (!StringUtils.isNotEmpty(string)) continue;
                return false;
            }
        }
        return true;
    }
}

