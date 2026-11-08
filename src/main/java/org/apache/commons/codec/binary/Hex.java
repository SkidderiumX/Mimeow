/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.binary;

import java.nio.charset.Charset;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex
implements BinaryEncoder,
BinaryDecoder {
    public static final Charset DEFAULT_CHARSET = Charsets.UTF_8;
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final Charset charset;

    public static byte[] decodeHex(char[] cArray) throws DecoderException {
        int n = cArray.length;
        if ((n & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] byArray = new byte[n >> 1];
        int n2 = 0;
        int n3 = 0;
        while (n3 < n) {
            int n4 = Hex.toDigit(cArray[n3], n3) << 4;
            n4 |= Hex.toDigit(cArray[++n3], n3);
            ++n3;
            byArray[n2] = (byte)(n4 & 0xFF);
            ++n2;
        }
        return byArray;
    }

    public static char[] encodeHex(byte[] byArray) {
        return Hex.encodeHex(byArray, true);
    }

    public static char[] encodeHex(byte[] byArray, boolean bl) {
        return Hex.encodeHex(byArray, bl ? DIGITS_LOWER : DIGITS_UPPER);
    }

    protected static char[] encodeHex(byte[] byArray, char[] cArray) {
        int n = byArray.length;
        char[] cArray2 = new char[n << 1];
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            cArray2[n2++] = cArray[(0xF0 & byArray[i]) >>> 4];
            cArray2[n2++] = cArray[0xF & byArray[i]];
        }
        return cArray2;
    }

    public static String encodeHexString(byte[] byArray) {
        return new String(Hex.encodeHex(byArray));
    }

    protected static int toDigit(char c, int n) throws DecoderException {
        int n2 = Character.digit(c, 16);
        if (n2 == -1) {
            throw new DecoderException("Illegal hexadecimal character " + c + " at index " + n);
        }
        return n2;
    }

    public Hex() {
        this.charset = DEFAULT_CHARSET;
    }

    public Hex(Charset charset) {
        this.charset = charset;
    }

    public Hex(String string) {
        this(Charset.forName(string));
    }

    @Override
    public byte[] decode(byte[] byArray) throws DecoderException {
        return Hex.decodeHex(new String(byArray, this.getCharset()).toCharArray());
    }

    @Override
    public Object decode(Object object) throws DecoderException {
        try {
            char[] cArray = object instanceof String ? ((String)object).toCharArray() : (char[])object;
            return Hex.decodeHex(cArray);
        }
        catch (ClassCastException classCastException) {
            throw new DecoderException(classCastException.getMessage(), classCastException);
        }
    }

    @Override
    public byte[] encode(byte[] byArray) {
        return Hex.encodeHexString(byArray).getBytes(this.getCharset());
    }

    @Override
    public Object encode(Object object) throws EncoderException {
        try {
            byte[] byArray = object instanceof String ? ((String)object).getBytes(this.getCharset()) : (byte[])object;
            return Hex.encodeHex(byArray);
        }
        catch (ClassCastException classCastException) {
            throw new EncoderException(classCastException.getMessage(), classCastException);
        }
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getCharsetName() {
        return this.charset.name();
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.charset + "]";
    }
}

