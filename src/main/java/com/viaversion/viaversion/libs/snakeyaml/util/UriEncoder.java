/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.util;

import com.viaversion.viaversion.libs.snakeyaml.error.YAMLException;
import com.viaversion.viaversion.libs.snakeyaml.external.com.google.gdata.util.common.base.Escaper;
import com.viaversion.viaversion.libs.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

public abstract class UriEncoder {
    private static final CharsetDecoder UTF8Decoder = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT);
    private static final String SAFE_CHARS = "-_.!~*'()@:$&,;=[]/";
    private static final Escaper escaper = new PercentEscaper("-_.!~*'()@:$&,;=[]/", false);

    public static String encode(String string) {
        return escaper.escape(string);
    }

    public static String decode(ByteBuffer byteBuffer) throws CharacterCodingException {
        CharBuffer charBuffer = UTF8Decoder.decode(byteBuffer);
        return charBuffer.toString();
    }

    public static String decode(String string) {
        try {
            return URLDecoder.decode(string, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new YAMLException(unsupportedEncodingException);
        }
    }
}

