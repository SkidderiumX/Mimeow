/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import lombok.Generated;

public class URLCoder {
    public static String encode(String string) {
        return URLCoder.encode(string, StandardCharsets.UTF_8);
    }

    public static String encode(String string, Charset charset) {
        return URLEncoder.encode(string, charset.name());
    }

    public static String decode(String string) {
        return URLCoder.decode(string, StandardCharsets.UTF_8);
    }

    public static String decode(String string, Charset charset) {
        return URLDecoder.decode(string, charset.name());
    }

    @Generated
    private URLCoder() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

