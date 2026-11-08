/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.protocol;

import java.io.IOException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.protocol.HttpContext;

@Immutable
public class ResponseContentEncoding
implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Header header;
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity != null && httpEntity.getContentLength() != 0L && (header = httpEntity.getContentEncoding()) != null) {
            HeaderElement[] headerElementArray = header.getElements();
            boolean bl = false;
            int n = 0;
            HeaderElement[] headerElementArray2 = headerElementArray;
            int n2 = headerElementArray2.length;
            if (n < n2) {
                HeaderElement headerElement = headerElementArray2[n];
                String string = headerElement.getName().toLowerCase(Locale.US);
                if ("gzip".equals(string) || "x-gzip".equals(string)) {
                    httpResponse.setEntity(new GzipDecompressingEntity(httpResponse.getEntity()));
                    bl = true;
                } else if ("deflate".equals(string)) {
                    httpResponse.setEntity(new DeflateDecompressingEntity(httpResponse.getEntity()));
                    bl = true;
                } else {
                    if ("identity".equals(string)) {
                        return;
                    }
                    throw new HttpException("Unsupported Content-Coding: " + headerElement.getName());
                }
            }
            if (bl) {
                httpResponse.removeHeaders("Content-Length");
                httpResponse.removeHeaders("Content-Encoding");
                httpResponse.removeHeaders("Content-MD5");
            }
        }
    }
}

