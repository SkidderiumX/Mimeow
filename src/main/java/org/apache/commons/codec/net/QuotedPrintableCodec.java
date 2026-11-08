/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.net.Utils;

public class QuotedPrintableCodec
implements BinaryEncoder,
BinaryDecoder,
StringEncoder,
StringDecoder {
    private final Charset charset;
    private static final BitSet PRINTABLE_CHARS;
    private static final byte ESCAPE_CHAR = 61;
    private static final byte TAB = 9;
    private static final byte SPACE = 32;

    public QuotedPrintableCodec() {
        this(Charsets.UTF_8);
    }

    public QuotedPrintableCodec(Charset charset) {
        this.charset = charset;
    }

    public QuotedPrintableCodec(String string) throws IllegalCharsetNameException, IllegalArgumentException, UnsupportedCharsetException {
        this(Charset.forName(string));
    }

    private static final void encodeQuotedPrintable(int n, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char c = Character.toUpperCase(Character.forDigit(n >> 4 & 0xF, 16));
        char c2 = Character.toUpperCase(Character.forDigit(n & 0xF, 16));
        byteArrayOutputStream.write(c);
        byteArrayOutputStream.write(c2);
    }

    public static final byte[] encodeQuotedPrintable(BitSet bitSet, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = PRINTABLE_CHARS;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int n : byArray) {
            int n2 = n;
            if (n2 < 0) {
                n2 = 256 + n2;
            }
            if (bitSet.get(n2)) {
                byteArrayOutputStream.write(n2);
                continue;
            }
            QuotedPrintableCodec.encodeQuotedPrintable(n2, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] decodeQuotedPrintable(byte[] byArray) throws DecoderException {
        if (byArray == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < byArray.length; ++i) {
            byte by = byArray[i];
            if (by == 61) {
                try {
                    int n = Utils.digit16(byArray[++i]);
                    int n2 = Utils.digit16(byArray[++i]);
                    byteArrayOutputStream.write((char)((n << 4) + n2));
                    continue;
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    throw new DecoderException("Invalid quoted-printable encoding", arrayIndexOutOfBoundsException);
                }
            }
            byteArrayOutputStream.write(by);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte[] encode(byte[] byArray) {
        return QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, byArray);
    }

    @Override
    public byte[] decode(byte[] byArray) throws DecoderException {
        return QuotedPrintableCodec.decodeQuotedPrintable(byArray);
    }

    @Override
    public String encode(String string) throws EncoderException {
        return this.encode(string, this.getCharset());
    }

    public String decode(String string, Charset charset) throws DecoderException {
        if (string == null) {
            return null;
        }
        return new String(this.decode(StringUtils.getBytesUsAscii(string)), charset);
    }

    public String decode(String string, String string2) throws DecoderException, UnsupportedEncodingException {
        if (string == null) {
            return null;
        }
        return new String(this.decode(StringUtils.getBytesUsAscii(string)), string2);
    }

    @Override
    public String decode(String string) throws DecoderException {
        return this.decode(string, this.getCharset());
    }

    @Override
    public Object encode(Object object) throws EncoderException {
        if (object == null) {
            return null;
        }
        if (object instanceof byte[]) {
            return this.encode((byte[])object);
        }
        if (object instanceof String) {
            return this.encode((String)object);
        }
        throw new EncoderException("Objects of type " + object.getClass().getName() + " cannot be quoted-printable encoded");
    }

    @Override
    public Object decode(Object object) throws DecoderException {
        if (object == null) {
            return null;
        }
        if (object instanceof byte[]) {
            return this.decode((byte[])object);
        }
        if (object instanceof String) {
            return this.decode((String)object);
        }
        throw new DecoderException("Objects of type " + object.getClass().getName() + " cannot be quoted-printable decoded");
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getDefaultCharset() {
        return this.charset.name();
    }

    public String encode(String string, Charset charset) {
        if (string == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(this.encode(string.getBytes(charset)));
    }

    public String encode(String string, String string2) throws UnsupportedEncodingException {
        if (string == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(this.encode(string.getBytes(string2)));
    }

    static {
        int n;
        PRINTABLE_CHARS = new BitSet(256);
        for (n = 33; n <= 60; ++n) {
            PRINTABLE_CHARS.set(n);
        }
        for (n = 62; n <= 126; ++n) {
            PRINTABLE_CHARS.set(n);
        }
        PRINTABLE_CHARS.set(9);
        PRINTABLE_CHARS.set(32);
    }
}

