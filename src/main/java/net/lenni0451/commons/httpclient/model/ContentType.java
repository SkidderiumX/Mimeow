/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.model;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

public class ContentType {
    private final String mimeType;
    private final Charset charset;
    private final String boundary;

    public static ContentType parse(String string) {
        if (!string.contains(";")) {
            return new ContentType(string.toLowerCase(Locale.ROOT), null, null);
        }
        String[] stringArray = string.split(";");
        String string2 = stringArray[0].toLowerCase(Locale.ROOT);
        Charset charset = null;
        String string3 = null;
        for (int i = 1; i < stringArray.length; ++i) {
            String string4 = stringArray[i].trim();
            if (string4.startsWith("charset=")) {
                try {
                    charset = Charset.forName(string4.substring(8));
                }
                catch (UnsupportedCharsetException unsupportedCharsetException) {}
                continue;
            }
            if (!string4.startsWith("boundary=")) continue;
            string3 = string4.substring(9);
        }
        return new ContentType(string2, charset, string3);
    }

    public ContentType(String string) {
        this(string, null, null);
    }

    public ContentType(String string, @Nullable Charset charset) {
        this(string, charset, null);
    }

    public ContentType(String string, @Nullable String string2) {
        this(string, null, string2);
    }

    public ContentType(String string, @Nullable Charset charset, @Nullable String string2) {
        this.mimeType = string;
        this.charset = charset;
        this.boundary = string2;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Optional<Charset> getCharset() {
        return Optional.ofNullable(this.charset);
    }

    public Optional<String> getBoundary() {
        return Optional.ofNullable(this.boundary);
    }

    public String toString() {
        return this.mimeType + (this.charset != null ? "; charset=" + this.charset.name() : "") + (this.boundary != null ? "; boundary=" + this.boundary : "");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ContentType contentType = (ContentType)object;
        return Objects.equals(this.mimeType, contentType.mimeType) && Objects.equals(this.charset, contentType.charset) && Objects.equals(this.boundary, contentType.boundary);
    }

    public int hashCode() {
        return Objects.hash(this.mimeType, this.charset, this.boundary);
    }
}

