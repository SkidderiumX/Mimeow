/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public class EntityUtils {
    private EntityUtils() {
    }

    public static void consumeQuietly(HttpEntity httpEntity) {
        try {
            EntityUtils.consume(httpEntity);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public static void consume(HttpEntity httpEntity) throws IOException {
        InputStream inputStream2;
        if (httpEntity == null) {
            return;
        }
        if (httpEntity.isStreaming() && (inputStream2 = httpEntity.getContent()) != null) {
            inputStream2.close();
        }
    }

    public static void updateEntity(HttpResponse httpResponse, HttpEntity httpEntity) throws IOException {
        Args.notNull(httpResponse, "Response");
        EntityUtils.consume(httpResponse.getEntity());
        httpResponse.setEntity(httpEntity);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] toByteArray(HttpEntity httpEntity) throws IOException {
        Args.notNull(httpEntity, "Entity");
        InputStream inputStream2 = httpEntity.getContent();
        if (inputStream2 == null) {
            return null;
        }
        try {
            int n;
            Args.check(httpEntity.getContentLength() <= Integer.MAX_VALUE, "HTTP entity too large to be buffered in memory");
            int n2 = (int)httpEntity.getContentLength();
            if (n2 < 0) {
                n2 = 4096;
            }
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(n2);
            byte[] byArray = new byte[4096];
            while ((n = inputStream2.read(byArray)) != -1) {
                byteArrayBuffer.append(byArray, 0, n);
            }
            byte[] byArray2 = byteArrayBuffer.toByteArray();
            return byArray2;
        }
        finally {
            inputStream2.close();
        }
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity httpEntity) throws ParseException {
        NameValuePair nameValuePair;
        HeaderElement[] headerElementArray;
        Args.notNull(httpEntity, "Entity");
        String string = null;
        if (httpEntity.getContentType() != null && (headerElementArray = httpEntity.getContentType().getElements()).length > 0 && (nameValuePair = headerElementArray[0].getParameterByName("charset")) != null) {
            string = nameValuePair.getValue();
        }
        return string;
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity httpEntity) throws ParseException {
        HeaderElement[] headerElementArray;
        Args.notNull(httpEntity, "Entity");
        String string = null;
        if (httpEntity.getContentType() != null && (headerElementArray = httpEntity.getContentType().getElements()).length > 0) {
            string = headerElementArray[0].getName();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String toString(HttpEntity httpEntity, Charset charset) throws IOException, ParseException {
        Args.notNull(httpEntity, "Entity");
        InputStream inputStream2 = httpEntity.getContent();
        if (inputStream2 == null) {
            return null;
        }
        try {
            int n;
            Object object;
            Args.check(httpEntity.getContentLength() <= Integer.MAX_VALUE, "HTTP entity too large to be buffered in memory");
            int n2 = (int)httpEntity.getContentLength();
            if (n2 < 0) {
                n2 = 4096;
            }
            Charset charset2 = null;
            try {
                object = ContentType.get(httpEntity);
                if (object != null) {
                    charset2 = ((ContentType)object).getCharset();
                }
            }
            catch (UnsupportedCharsetException unsupportedCharsetException) {
                throw new UnsupportedEncodingException(unsupportedCharsetException.getMessage());
            }
            if (charset2 == null) {
                charset2 = charset;
            }
            if (charset2 == null) {
                charset2 = HTTP.DEF_CONTENT_CHARSET;
            }
            object = new InputStreamReader(inputStream2, charset2);
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(n2);
            char[] cArray = new char[1024];
            while ((n = ((Reader)object).read(cArray)) != -1) {
                charArrayBuffer.append(cArray, 0, n);
            }
            String string = charArrayBuffer.toString();
            return string;
        }
        finally {
            inputStream2.close();
        }
    }

    public static String toString(HttpEntity httpEntity, String string) throws IOException, ParseException {
        return EntityUtils.toString(httpEntity, string != null ? Charset.forName(string) : null);
    }

    public static String toString(HttpEntity httpEntity) throws IOException, ParseException {
        return EntityUtils.toString(httpEntity, (Charset)null);
    }
}

