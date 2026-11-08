/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class RequestUserAgent
implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgent(String string) {
        this.userAgent = string;
    }

    public RequestUserAgent() {
        this(null);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader("User-Agent")) {
            String string = null;
            HttpParams httpParams = httpRequest.getParams();
            if (httpParams != null) {
                string = (String)httpParams.getParameter("http.useragent");
            }
            if (string == null) {
                string = this.userAgent;
            }
            if (string != null) {
                httpRequest.addHeader("User-Agent", string);
            }
        }
    }
}

