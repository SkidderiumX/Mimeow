/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.TextUtils;

@Immutable
public class ContentType
implements Serializable {
    private static final long serialVersionUID = -7768694718232371896L;
    public static final ContentType APPLICATION_ATOM_XML = ContentType.create("application/atom+xml", Consts.ISO_8859_1);
    public static final ContentType APPLICATION_FORM_URLENCODED = ContentType.create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
    public static final ContentType APPLICATION_JSON = ContentType.create("application/json", Consts.UTF_8);
    public static final ContentType APPLICATION_OCTET_STREAM = ContentType.create("application/octet-stream", (Charset)null);
    public static final ContentType APPLICATION_SVG_XML = ContentType.create("application/svg+xml", Consts.ISO_8859_1);
    public static final ContentType APPLICATION_XHTML_XML = ContentType.create("application/xhtml+xml", Consts.ISO_8859_1);
    public static final ContentType APPLICATION_XML = ContentType.create("application/xml", Consts.ISO_8859_1);
    public static final ContentType MULTIPART_FORM_DATA = ContentType.create("multipart/form-data", Consts.ISO_8859_1);
    public static final ContentType TEXT_HTML = ContentType.create("text/html", Consts.ISO_8859_1);
    public static final ContentType TEXT_PLAIN = ContentType.create("text/plain", Consts.ISO_8859_1);
    public static final ContentType TEXT_XML = ContentType.create("text/xml", Consts.ISO_8859_1);
    public static final ContentType WILDCARD = ContentType.create("*/*", (Charset)null);
    public static final ContentType DEFAULT_TEXT = TEXT_PLAIN;
    public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    private final String mimeType;
    private final Charset charset;
    private final NameValuePair[] params;

    ContentType(String string, Charset charset) {
        this.mimeType = string;
        this.charset = charset;
        this.params = null;
    }

    ContentType(String string, NameValuePair[] nameValuePairArray) throws UnsupportedCharsetException {
        this.mimeType = string;
        this.params = nameValuePairArray;
        String string2 = this.getParameter("charset");
        this.charset = !TextUtils.isBlank(string2) ? Charset.forName(string2) : null;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getParameter(String string) {
        Args.notEmpty(string, "Parameter name");
        if (this.params == null) {
            return null;
        }
        for (NameValuePair nameValuePair : this.params) {
            if (!nameValuePair.getName().equalsIgnoreCase(string)) continue;
            return nameValuePair.getValue();
        }
        return null;
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.mimeType);
        if (this.params != null) {
            charArrayBuffer.append("; ");
            BasicHeaderValueFormatter.INSTANCE.formatParameters(charArrayBuffer, this.params, false);
        } else if (this.charset != null) {
            charArrayBuffer.append("; charset=");
            charArrayBuffer.append(this.charset.name());
        }
        return charArrayBuffer.toString();
    }

    private static boolean valid(String string) {
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c != '\"' && c != ',' && c != ';') continue;
            return false;
        }
        return true;
    }

    public static ContentType create(String string, Charset charset) {
        String string2 = Args.notBlank(string, "MIME type").toLowerCase(Locale.US);
        Args.check(ContentType.valid(string2), "MIME type may not contain reserved characters");
        return new ContentType(string2, charset);
    }

    public static ContentType create(String string) {
        return new ContentType(string, (Charset)null);
    }

    public static ContentType create(String string, String string2) throws UnsupportedCharsetException {
        return ContentType.create(string, !TextUtils.isBlank(string2) ? Charset.forName(string2) : null);
    }

    private static ContentType create(HeaderElement headerElement) {
        String string = headerElement.getName();
        NameValuePair[] nameValuePairArray = headerElement.getParameters();
        return new ContentType(string, nameValuePairArray != null && nameValuePairArray.length > 0 ? nameValuePairArray : null);
    }

    public static ContentType parse(String string) throws ParseException, UnsupportedCharsetException {
        Args.notNull(string, "Content type");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(string.length());
        charArrayBuffer.append(string);
        ParserCursor parserCursor = new ParserCursor(0, string.length());
        HeaderElement[] headerElementArray = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, parserCursor);
        if (headerElementArray.length > 0) {
            return ContentType.create(headerElementArray[0]);
        }
        throw new ParseException("Invalid content type: " + string);
    }

    public static ContentType get(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        HeaderElement[] headerElementArray;
        if (httpEntity == null) {
            return null;
        }
        Header header = httpEntity.getContentType();
        if (header != null && (headerElementArray = header.getElements()).length > 0) {
            return ContentType.create(headerElementArray[0]);
        }
        return null;
    }

    public static ContentType getOrDefault(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = ContentType.get(httpEntity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public ContentType withCharset(Charset charset) {
        return ContentType.create(this.getMimeType(), charset);
    }

    public ContentType withCharset(String string) {
        return ContentType.create(this.getMimeType(), string);
    }
}

