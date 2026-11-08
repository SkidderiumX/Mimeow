/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.libs.gson.stream.MalformedJsonException;

public class LegacyGson {
    private static final String MODERN_ALLOWED_ESCAPES = "utbnrf\n'\"\\/";
    private static final String LENIENT_EXCEPTION = "Use JsonReader.setLenient(true) to accept malformed JSON";

    public static String fixInvalidEscapes(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        char c = '\u0000';
        boolean bl2 = false;
        for (char c2 : string.toCharArray()) {
            if (!bl2) {
                if (c2 == '\"' || c2 == '\'') {
                    if (!bl) {
                        bl = true;
                        c = c2;
                    } else if (c == c2) {
                        bl = false;
                    }
                } else if (bl && c2 == '\\') {
                    bl2 = true;
                }
            } else {
                if (MODERN_ALLOWED_ESCAPES.indexOf(c2) == -1) {
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
                bl2 = false;
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static void checkStartingType(String string, boolean bl) {
        if (bl) {
            return;
        }
        char c = LegacyGson.nextNonWhitespace(string);
        if (c == ']' || c == ';' || c == ',' || c == '[' || c == '{') {
            return;
        }
        throw new JsonSyntaxException(new MalformedJsonException(LENIENT_EXCEPTION));
    }

    private static char nextNonWhitespace(String string) {
        char[] cArray = string.toCharArray();
        int n = 0;
        while (n < cArray.length) {
            char c;
            if ((c = cArray[n++]) == '\n' || c == ' ' || c == '\r' || c == '\t') continue;
            if (c == '/' || c == '#') {
                throw new JsonSyntaxException(new MalformedJsonException(LENIENT_EXCEPTION));
            }
            return c;
        }
        return '{';
    }
}

