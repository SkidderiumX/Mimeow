/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.util;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import org.java_websocket.exceptions.InvalidDataException;

public class Charsetfunctions {
    private static final CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
    private static final int[] utf8d = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 1, 2, 3, 5, 8, 7, 1, 1, 1, 4, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    private Charsetfunctions() {
    }

    public static byte[] utf8Bytes(String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] asciiBytes(String string) {
        return string.getBytes(StandardCharsets.US_ASCII);
    }

    public static String stringAscii(byte[] byArray) {
        return Charsetfunctions.stringAscii(byArray, 0, byArray.length);
    }

    public static String stringAscii(byte[] byArray, int n, int n2) {
        return new String(byArray, n, n2, StandardCharsets.US_ASCII);
    }

    public static String stringUtf8(byte[] byArray) throws InvalidDataException {
        return Charsetfunctions.stringUtf8(ByteBuffer.wrap(byArray));
    }

    public static String stringUtf8(ByteBuffer byteBuffer) throws InvalidDataException {
        String string;
        CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
        charsetDecoder.onMalformedInput(codingErrorAction);
        charsetDecoder.onUnmappableCharacter(codingErrorAction);
        try {
            byteBuffer.mark();
            string = charsetDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
        }
        catch (CharacterCodingException characterCodingException) {
            throw new InvalidDataException(1007, (Throwable)characterCodingException);
        }
        return string;
    }

    public static boolean isValidUTF8(ByteBuffer byteBuffer, int n) {
        int n2 = byteBuffer.remaining();
        if (n2 < n) {
            return false;
        }
        int n3 = 0;
        for (int i = n; i < n2; ++i) {
            if ((n3 = utf8d[256 + (n3 << 4) + utf8d[0xFF & byteBuffer.get(i)]]) != 1) continue;
            return false;
        }
        return true;
    }

    public static boolean isValidUTF8(ByteBuffer byteBuffer) {
        return Charsetfunctions.isValidUTF8(byteBuffer, 0);
    }
}

