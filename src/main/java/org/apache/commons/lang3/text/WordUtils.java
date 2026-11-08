/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class WordUtils {
    public static String wrap(String string, int n) {
        return WordUtils.wrap(string, n, null, false);
    }

    public static String wrap(String string, int n, String string2, boolean bl) {
        if (string == null) {
            return null;
        }
        if (string2 == null) {
            string2 = SystemUtils.LINE_SEPARATOR;
        }
        if (n < 1) {
            n = 1;
        }
        int n2 = string.length();
        int n3 = 0;
        StringBuilder stringBuilder = new StringBuilder(n2 + 32);
        while (n2 - n3 > n) {
            if (string.charAt(n3) == ' ') {
                ++n3;
                continue;
            }
            int n4 = string.lastIndexOf(32, n + n3);
            if (n4 >= n3) {
                stringBuilder.append(string.substring(n3, n4));
                stringBuilder.append(string2);
                n3 = n4 + 1;
                continue;
            }
            if (bl) {
                stringBuilder.append(string.substring(n3, n + n3));
                stringBuilder.append(string2);
                n3 += n;
                continue;
            }
            n4 = string.indexOf(32, n + n3);
            if (n4 >= 0) {
                stringBuilder.append(string.substring(n3, n4));
                stringBuilder.append(string2);
                n3 = n4 + 1;
                continue;
            }
            stringBuilder.append(string.substring(n3));
            n3 = n2;
        }
        stringBuilder.append(string.substring(n3));
        return stringBuilder.toString();
    }

    public static String capitalize(String string) {
        return WordUtils.capitalize(string, null);
    }

    public static String capitalize(String string, char ... cArray) {
        int n;
        int n2 = n = cArray == null ? -1 : cArray.length;
        if (StringUtils.isEmpty(string) || n == 0) {
            return string;
        }
        char[] cArray2 = string.toCharArray();
        boolean bl = true;
        for (int i = 0; i < cArray2.length; ++i) {
            char c = cArray2[i];
            if (WordUtils.isDelimiter(c, cArray)) {
                bl = true;
                continue;
            }
            if (!bl) continue;
            cArray2[i] = Character.toTitleCase(c);
            bl = false;
        }
        return new String(cArray2);
    }

    public static String capitalizeFully(String string) {
        return WordUtils.capitalizeFully(string, null);
    }

    public static String capitalizeFully(String string, char ... cArray) {
        int n;
        int n2 = n = cArray == null ? -1 : cArray.length;
        if (StringUtils.isEmpty(string) || n == 0) {
            return string;
        }
        string = string.toLowerCase();
        return WordUtils.capitalize(string, cArray);
    }

    public static String uncapitalize(String string) {
        return WordUtils.uncapitalize(string, null);
    }

    public static String uncapitalize(String string, char ... cArray) {
        int n;
        int n2 = n = cArray == null ? -1 : cArray.length;
        if (StringUtils.isEmpty(string) || n == 0) {
            return string;
        }
        char[] cArray2 = string.toCharArray();
        boolean bl = true;
        for (int i = 0; i < cArray2.length; ++i) {
            char c = cArray2[i];
            if (WordUtils.isDelimiter(c, cArray)) {
                bl = true;
                continue;
            }
            if (!bl) continue;
            cArray2[i] = Character.toLowerCase(c);
            bl = false;
        }
        return new String(cArray2);
    }

    public static String swapCase(String string) {
        if (StringUtils.isEmpty(string)) {
            return string;
        }
        char[] cArray = string.toCharArray();
        boolean bl = true;
        for (int i = 0; i < cArray.length; ++i) {
            char c = cArray[i];
            if (Character.isUpperCase(c)) {
                cArray[i] = Character.toLowerCase(c);
                bl = false;
                continue;
            }
            if (Character.isTitleCase(c)) {
                cArray[i] = Character.toLowerCase(c);
                bl = false;
                continue;
            }
            if (Character.isLowerCase(c)) {
                if (bl) {
                    cArray[i] = Character.toTitleCase(c);
                    bl = false;
                    continue;
                }
                cArray[i] = Character.toUpperCase(c);
                continue;
            }
            bl = Character.isWhitespace(c);
        }
        return new String(cArray);
    }

    public static String initials(String string) {
        return WordUtils.initials(string, null);
    }

    public static String initials(String string, char ... cArray) {
        if (StringUtils.isEmpty(string)) {
            return string;
        }
        if (cArray != null && cArray.length == 0) {
            return "";
        }
        int n = string.length();
        char[] cArray2 = new char[n / 2 + 1];
        int n2 = 0;
        boolean bl = true;
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (WordUtils.isDelimiter(c, cArray)) {
                bl = true;
                continue;
            }
            if (!bl) continue;
            cArray2[n2++] = c;
            bl = false;
        }
        return new String(cArray2, 0, n2);
    }

    private static boolean isDelimiter(char c, char[] cArray) {
        if (cArray == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArray) {
            if (c != c2) continue;
            return true;
        }
        return false;
    }
}

