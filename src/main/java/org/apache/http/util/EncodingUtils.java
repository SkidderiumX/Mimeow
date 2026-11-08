/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import org.apache.http.Consts;
import org.apache.http.util.Args;

public class EncodingUtils {
    public static String getString(byte[] byArray, int n, int n2, String string) {
        Args.notNull(byArray, "Input");
        Args.notEmpty(string, "Charset");
        try {
            return new String(byArray, n, n2, string);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(byArray, n, n2);
        }
    }

    public static String getString(byte[] byArray, String string) {
        Args.notNull(byArray, "Input");
        return EncodingUtils.getString(byArray, 0, byArray.length, string);
    }

    public static byte[] getBytes(String string, String string2) {
        Args.notNull(string, "Input");
        Args.notEmpty(string2, "Charset");
        try {
            return string.getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string.getBytes();
        }
    }

    public static byte[] getAsciiBytes(String string) {
        Args.notNull(string, "Input");
        try {
            return string.getBytes(Consts.ASCII.name());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new Error("ASCII not supported");
        }
    }

    public static String getAsciiString(byte[] byArray, int n, int n2) {
        Args.notNull(byArray, "Input");
        try {
            return new String(byArray, n, n2, Consts.ASCII.name());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new Error("ASCII not supported");
        }
    }

    public static String getAsciiString(byte[] byArray) {
        Args.notNull(byArray, "Input");
        return EncodingUtils.getAsciiString(byArray, 0, byArray.length);
    }

    private EncodingUtils() {
    }
}

