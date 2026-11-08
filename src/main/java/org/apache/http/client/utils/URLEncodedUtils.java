/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.utils;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final char QP_SEP_A = '&';
    private static final char QP_SEP_S = ';';
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final char[] QP_SEPS;
    private static final String QP_SEP_PATTERN;
    private static final BitSet UNRESERVED;
    private static final BitSet PUNCT;
    private static final BitSet USERINFO;
    private static final BitSet PATHSAFE;
    private static final BitSet URIC;
    private static final BitSet RESERVED;
    private static final BitSet URLENCODER;
    private static final int RADIX = 16;

    public static List<NameValuePair> parse(URI uRI, String string) {
        String string2 = uRI.getRawQuery();
        if (string2 != null && string2.length() > 0) {
            ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
            Scanner scanner = new Scanner(string2);
            URLEncodedUtils.parse(arrayList, scanner, QP_SEP_PATTERN, string);
            return arrayList;
        }
        return Collections.emptyList();
    }

    public static List<NameValuePair> parse(HttpEntity httpEntity) throws IOException {
        String string;
        ContentType contentType = ContentType.get(httpEntity);
        if (contentType != null && contentType.getMimeType().equalsIgnoreCase(CONTENT_TYPE) && (string = EntityUtils.toString(httpEntity, Consts.ASCII)) != null && string.length() > 0) {
            Charset charset = contentType.getCharset();
            if (charset == null) {
                charset = HTTP.DEF_CONTENT_CHARSET;
            }
            return URLEncodedUtils.parse(string, charset, QP_SEPS);
        }
        return Collections.emptyList();
    }

    public static boolean isEncoded(HttpEntity httpEntity) {
        HeaderElement[] headerElementArray;
        Header header = httpEntity.getContentType();
        if (header != null && (headerElementArray = header.getElements()).length > 0) {
            String string = headerElementArray[0].getName();
            return string.equalsIgnoreCase(CONTENT_TYPE);
        }
        return false;
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String string) {
        URLEncodedUtils.parse(list, scanner, QP_SEP_PATTERN, string);
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String string, String string2) {
        scanner.useDelimiter(string);
        while (scanner.hasNext()) {
            String string3 = null;
            String string4 = null;
            String string5 = scanner.next();
            int n = string5.indexOf(NAME_VALUE_SEPARATOR);
            if (n != -1) {
                string3 = URLEncodedUtils.decodeFormFields(string5.substring(0, n).trim(), string2);
                string4 = URLEncodedUtils.decodeFormFields(string5.substring(n + 1).trim(), string2);
            } else {
                string3 = URLEncodedUtils.decodeFormFields(string5.trim(), string2);
            }
            list.add(new BasicNameValuePair(string3, string4));
        }
    }

    public static List<NameValuePair> parse(String string, Charset charset) {
        return URLEncodedUtils.parse(string, charset, QP_SEPS);
    }

    public static List<NameValuePair> parse(String string, Charset charset, char ... cArray) {
        if (string == null) {
            return Collections.emptyList();
        }
        BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.INSTANCE;
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(string.length());
        charArrayBuffer.append(string);
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
        while (!parserCursor.atEnd()) {
            NameValuePair nameValuePair = basicHeaderValueParser.parseNameValuePair(charArrayBuffer, parserCursor, cArray);
            if (nameValuePair.getName().length() <= 0) continue;
            arrayList.add(new BasicNameValuePair(URLEncodedUtils.decodeFormFields(nameValuePair.getName(), charset), URLEncodedUtils.decodeFormFields(nameValuePair.getValue(), charset)));
        }
        return arrayList;
    }

    public static String format(List<? extends NameValuePair> list, String string) {
        return URLEncodedUtils.format(list, '&', string);
    }

    public static String format(List<? extends NameValuePair> list, char c, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String string2 = URLEncodedUtils.encodeFormFields(nameValuePair.getName(), string);
            String string3 = URLEncodedUtils.encodeFormFields(nameValuePair.getValue(), string);
            if (stringBuilder.length() > 0) {
                stringBuilder.append(c);
            }
            stringBuilder.append(string2);
            if (string3 == null) continue;
            stringBuilder.append(NAME_VALUE_SEPARATOR);
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }

    public static String format(Iterable<? extends NameValuePair> iterable, Charset charset) {
        return URLEncodedUtils.format(iterable, '&', charset);
    }

    public static String format(Iterable<? extends NameValuePair> iterable, char c, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder();
        for (NameValuePair nameValuePair : iterable) {
            String string = URLEncodedUtils.encodeFormFields(nameValuePair.getName(), charset);
            String string2 = URLEncodedUtils.encodeFormFields(nameValuePair.getValue(), charset);
            if (stringBuilder.length() > 0) {
                stringBuilder.append(c);
            }
            stringBuilder.append(string);
            if (string2 == null) continue;
            stringBuilder.append(NAME_VALUE_SEPARATOR);
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    private static String urlEncode(String string, Charset charset, BitSet bitSet, boolean bl) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ByteBuffer byteBuffer = charset.encode(string);
        while (byteBuffer.hasRemaining()) {
            int n = byteBuffer.get() & 0xFF;
            if (bitSet.get(n)) {
                stringBuilder.append((char)n);
                continue;
            }
            if (bl && n == 32) {
                stringBuilder.append('+');
                continue;
            }
            stringBuilder.append("%");
            char c = Character.toUpperCase(Character.forDigit(n >> 4 & 0xF, 16));
            char c2 = Character.toUpperCase(Character.forDigit(n & 0xF, 16));
            stringBuilder.append(c);
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    private static String urlDecode(String string, Charset charset, boolean bl) {
        if (string == null) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(string.length());
        CharBuffer charBuffer = CharBuffer.wrap(string);
        while (charBuffer.hasRemaining()) {
            char c = charBuffer.get();
            if (c == '%' && charBuffer.remaining() >= 2) {
                char c2 = charBuffer.get();
                char c3 = charBuffer.get();
                int n = Character.digit(c2, 16);
                int n2 = Character.digit(c3, 16);
                if (n != -1 && n2 != -1) {
                    byteBuffer.put((byte)((n << 4) + n2));
                    continue;
                }
                byteBuffer.put((byte)37);
                byteBuffer.put((byte)c2);
                byteBuffer.put((byte)c3);
                continue;
            }
            if (bl && c == '+') {
                byteBuffer.put((byte)32);
                continue;
            }
            byteBuffer.put((byte)c);
        }
        byteBuffer.flip();
        return charset.decode(byteBuffer).toString();
    }

    private static String decodeFormFields(String string, String string2) {
        if (string == null) {
            return null;
        }
        return URLEncodedUtils.urlDecode(string, string2 != null ? Charset.forName(string2) : Consts.UTF_8, true);
    }

    private static String decodeFormFields(String string, Charset charset) {
        if (string == null) {
            return null;
        }
        return URLEncodedUtils.urlDecode(string, charset != null ? charset : Consts.UTF_8, true);
    }

    private static String encodeFormFields(String string, String string2) {
        if (string == null) {
            return null;
        }
        return URLEncodedUtils.urlEncode(string, string2 != null ? Charset.forName(string2) : Consts.UTF_8, URLENCODER, true);
    }

    private static String encodeFormFields(String string, Charset charset) {
        if (string == null) {
            return null;
        }
        return URLEncodedUtils.urlEncode(string, charset != null ? charset : Consts.UTF_8, URLENCODER, true);
    }

    static String encUserInfo(String string, Charset charset) {
        return URLEncodedUtils.urlEncode(string, charset, USERINFO, false);
    }

    static String encUric(String string, Charset charset) {
        return URLEncodedUtils.urlEncode(string, charset, URIC, false);
    }

    static String encPath(String string, Charset charset) {
        return URLEncodedUtils.urlEncode(string, charset, PATHSAFE, false);
    }

    static {
        int n;
        QP_SEPS = new char[]{'&', ';'};
        QP_SEP_PATTERN = "[" + new String(QP_SEPS) + "]";
        UNRESERVED = new BitSet(256);
        PUNCT = new BitSet(256);
        USERINFO = new BitSet(256);
        PATHSAFE = new BitSet(256);
        URIC = new BitSet(256);
        RESERVED = new BitSet(256);
        URLENCODER = new BitSet(256);
        for (n = 97; n <= 122; ++n) {
            UNRESERVED.set(n);
        }
        for (n = 65; n <= 90; ++n) {
            UNRESERVED.set(n);
        }
        for (n = 48; n <= 57; ++n) {
            UNRESERVED.set(n);
        }
        UNRESERVED.set(95);
        UNRESERVED.set(45);
        UNRESERVED.set(46);
        UNRESERVED.set(42);
        URLENCODER.or(UNRESERVED);
        UNRESERVED.set(33);
        UNRESERVED.set(126);
        UNRESERVED.set(39);
        UNRESERVED.set(40);
        UNRESERVED.set(41);
        PUNCT.set(44);
        PUNCT.set(59);
        PUNCT.set(58);
        PUNCT.set(36);
        PUNCT.set(38);
        PUNCT.set(43);
        PUNCT.set(61);
        USERINFO.or(UNRESERVED);
        USERINFO.or(PUNCT);
        PATHSAFE.or(UNRESERVED);
        PATHSAFE.set(47);
        PATHSAFE.set(59);
        PATHSAFE.set(58);
        PATHSAFE.set(64);
        PATHSAFE.set(38);
        PATHSAFE.set(61);
        PATHSAFE.set(43);
        PATHSAFE.set(36);
        PATHSAFE.set(44);
        RESERVED.set(59);
        RESERVED.set(47);
        RESERVED.set(63);
        RESERVED.set(58);
        RESERVED.set(64);
        RESERVED.set(38);
        RESERVED.set(61);
        RESERVED.set(43);
        RESERVED.set(36);
        RESERVED.set(44);
        RESERVED.set(91);
        RESERVED.set(93);
        URIC.or(RESERVED);
        URIC.or(UNRESERVED);
    }
}

