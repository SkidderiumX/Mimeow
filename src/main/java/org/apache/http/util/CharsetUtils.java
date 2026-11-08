/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetUtils {
    public static Charset lookup(String string) {
        if (string == null) {
            return null;
        }
        try {
            return Charset.forName(string);
        }
        catch (UnsupportedCharsetException unsupportedCharsetException) {
            return null;
        }
    }

    public static Charset get(String string) throws UnsupportedEncodingException {
        if (string == null) {
            return null;
        }
        try {
            return Charset.forName(string);
        }
        catch (UnsupportedCharsetException unsupportedCharsetException) {
            throw new UnsupportedEncodingException(string);
        }
    }
}

