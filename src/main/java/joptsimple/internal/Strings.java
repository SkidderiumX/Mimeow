/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Strings {
    public static final String EMPTY = "";
    public static final String SINGLE_QUOTE = "'";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private Strings() {
        throw new UnsupportedOperationException();
    }

    public static String repeat(char c, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || EMPTY.equals(string);
    }

    public static String surround(String string, char c, char c2) {
        return c + string + c2;
    }

    public static String join(String[] stringArray, String string) {
        return Strings.join(Arrays.asList(stringArray), string);
    }

    public static String join(List<String> list, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            stringBuilder.append(iterator2.next());
            if (!iterator2.hasNext()) continue;
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}

