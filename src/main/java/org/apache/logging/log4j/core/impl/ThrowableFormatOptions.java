/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.core.helpers.Constants;

public class ThrowableFormatOptions {
    private static final int DEFAULT_LINES = Integer.MAX_VALUE;
    protected static final ThrowableFormatOptions DEFAULT = new ThrowableFormatOptions();
    private static final String FULL = "full";
    private static final String NONE = "none";
    private static final String SHORT = "short";
    private final int lines;
    private final String separator;
    private final List<String> packages;
    public static final String CLASS_NAME = "short.className";
    public static final String METHOD_NAME = "short.methodName";
    public static final String LINE_NUMBER = "short.lineNumber";
    public static final String FILE_NAME = "short.fileName";
    public static final String MESSAGE = "short.message";
    public static final String LOCALIZED_MESSAGE = "short.localizedMessage";

    protected ThrowableFormatOptions(int n, String string, List<String> list) {
        this.lines = n;
        this.separator = string == null ? Constants.LINE_SEP : string;
        this.packages = list;
    }

    protected ThrowableFormatOptions(List<String> list) {
        this(Integer.MAX_VALUE, null, list);
    }

    protected ThrowableFormatOptions() {
        this(Integer.MAX_VALUE, null, null);
    }

    public int getLines() {
        return this.lines;
    }

    public String getSeparator() {
        return this.separator;
    }

    public List<String> getPackages() {
        return this.packages;
    }

    public boolean allLines() {
        return this.lines == Integer.MAX_VALUE;
    }

    public boolean anyLines() {
        return this.lines > 0;
    }

    public int minLines(int n) {
        return this.lines > n ? n : this.lines;
    }

    public boolean hasPackages() {
        return this.packages != null && !this.packages.isEmpty();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append(this.allLines() ? FULL : (this.lines == 2 ? SHORT : (this.anyLines() ? String.valueOf(this.lines) : NONE))).append("}");
        stringBuilder.append("{separator(").append(this.separator).append(")}");
        if (this.hasPackages()) {
            stringBuilder.append("{filters(");
            for (String string : this.packages) {
                stringBuilder.append(string).append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(")}");
        }
        return stringBuilder.toString();
    }

    public static ThrowableFormatOptions newInstance(String[] stringArray) {
        ArrayList<String> arrayList;
        String string;
        if (stringArray == null || stringArray.length == 0) {
            return DEFAULT;
        }
        if (stringArray.length == 1 && stringArray[0] != null && stringArray[0].length() > 0) {
            String[] stringArray2 = stringArray[0].split(",", 2);
            string = stringArray2[0].trim();
            arrayList = new Scanner(string);
            if (stringArray2.length > 1 && (string.equalsIgnoreCase(FULL) || string.equalsIgnoreCase(SHORT) || string.equalsIgnoreCase(NONE) || ((Scanner)((Object)arrayList)).hasNextInt())) {
                stringArray = new String[]{string, stringArray2[1].trim()};
            }
            ((Scanner)((Object)arrayList)).close();
        }
        int n = ThrowableFormatOptions.DEFAULT.lines;
        string = ThrowableFormatOptions.DEFAULT.separator;
        arrayList = ThrowableFormatOptions.DEFAULT.packages;
        for (String string2 : stringArray) {
            String string3;
            if (string2 == null || (string3 = string2.trim()).isEmpty()) continue;
            if (string3.startsWith("separator(") && string3.endsWith(")")) {
                string = string3.substring("separator(".length(), string3.length() - 1);
                continue;
            }
            if (string3.startsWith("filters(") && string3.endsWith(")")) {
                String[] stringArray3;
                String string4 = string3.substring("filters(".length(), string3.length() - 1);
                if (string4.length() <= 0 || (stringArray3 = string4.split(",")).length <= 0) continue;
                arrayList = new ArrayList<String>(stringArray3.length);
                for (String string5 : stringArray3) {
                    if ((string5 = string5.trim()).length() <= 0) continue;
                    arrayList.add(string5);
                }
                continue;
            }
            if (string3.equalsIgnoreCase(NONE)) {
                n = 0;
                continue;
            }
            if (string3.equalsIgnoreCase(SHORT) || string3.equalsIgnoreCase(CLASS_NAME) || string3.equalsIgnoreCase(METHOD_NAME) || string3.equalsIgnoreCase(LINE_NUMBER) || string3.equalsIgnoreCase(FILE_NAME) || string3.equalsIgnoreCase(MESSAGE) || string3.equalsIgnoreCase(LOCALIZED_MESSAGE)) {
                n = 2;
                continue;
            }
            if (string3.equalsIgnoreCase(FULL)) continue;
            n = Integer.parseInt(string3);
        }
        return new ThrowableFormatOptions(n, string, arrayList);
    }
}

