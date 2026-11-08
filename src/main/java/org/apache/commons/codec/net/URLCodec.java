/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.net.Utils;

public class URLCodec
implements BinaryEncoder,
BinaryDecoder,
StringEncoder,
StringDecoder {
    static final int RADIX = 16;
    @Deprecated
    protected String charset;
    protected static final byte ESCAPE_CHAR = 37;
    protected static final BitSet WWW_FORM_URL;

    public URLCodec() {
        this("UTF-8");
    }

    public URLCodec(String string) {
        this.charset = string;
    }

    public static final byte[] encodeUrl(BitSet bitSet, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = WWW_FORM_URL;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int n : byArray) {
            int n2 = n;
            if (n2 < 0) {
                n2 = 256 + n2;
            }
            if (bitSet.get(n2)) {
                if (n2 == 32) {
                    n2 = 43;
                }
                byteArrayOutputStream.write(n2);
                continue;
            }
            byteArrayOutputStream.write(37);
            char c = Character.toUpperCase(Character.forDigit(n2 >> 4 & 0xF, 16));
            char c2 = Character.toUpperCase(Character.forDigit(n2 & 0xF, 16));
            byteArrayOutputStream.write(c);
            byteArrayOutputStream.write(c2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] decodeUrl(byte[] byArray) throws DecoderException {
        if (byArray == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < byArray.length; ++i) {
            byte by = byArray[i];
            if (by == 43) {
                byteArrayOutputStream.write(32);
                continue;
            }
            if (by == 37) {
                try {
                    int n = Utils.digit16(byArray[++i]);
                    int n2 = Utils.digit16(byArray[++i]);
                    byteArrayOutputStream.write((char)((n << 4) + n2));
                    continue;
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    throw new DecoderException("Invalid URL encoding: ", arrayIndexOutOfBoundsException);
                }
            }
            byteArrayOutputStream.write(by);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte[] encode(byte[] byArray) {
        return URLCodec.encodeUrl(WWW_FORM_URL, byArray);
    }

    @Override
    public byte[] decode(byte[] byArray) throws DecoderException {
        return URLCodec.decodeUrl(byArray);
    }

    public String encode(String string, String string2) throws UnsupportedEncodingException {
        if (string == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(this.encode(string.getBytes(string2)));
    }

    @Override
    public String encode(String string) throws EncoderException {
        if (string == null) {
            return null;
        }
        try {
            return this.encode(string, this.getDefaultCharset());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
        }
    }

    public String decode(String string, String string2) throws DecoderException, UnsupportedEncodingException {
        if (string == null) {
            return null;
        }
        return new String(this.decode(StringUtils.getBytesUsAscii(string)), string2);
    }

    @Override
    public String decode(String string) throws DecoderException {
        if (string == null) {
            return null;
        }
        try {
            return this.decode(string, this.getDefaultCharset());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
        }
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
        throw new EncoderException("Objects of type " + object.getClass().getName() + " cannot be URL encoded");
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
        throw new DecoderException("Objects of type " + object.getClass().getName() + " cannot be URL decoded");
    }

    public String getDefaultCharset() {
        return this.charset;
    }

    @Deprecated
    public String getEncoding() {
        return this.charset;
    }

    static {
        int n;
        WWW_FORM_URL = new BitSet(256);
        for (n = 97; n <= 122; ++n) {
            WWW_FORM_URL.set(n);
        }
        for (n = 65; n <= 90; ++n) {
            WWW_FORM_URL.set(n);
        }
        for (n = 48; n <= 57; ++n) {
            WWW_FORM_URL.set(n);
        }
        WWW_FORM_URL.set(45);
        WWW_FORM_URL.set(95);
        WWW_FORM_URL.set(46);
        WWW_FORM_URL.set(42);
        WWW_FORM_URL.set(32);
    }
}

