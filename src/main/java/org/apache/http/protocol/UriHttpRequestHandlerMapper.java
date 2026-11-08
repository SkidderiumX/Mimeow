/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerMapper;
import org.apache.http.protocol.UriPatternMatcher;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public class UriHttpRequestHandlerMapper
implements HttpRequestHandlerMapper {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    protected UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> uriPatternMatcher) {
        this.matcher = Args.notNull(uriPatternMatcher, "Pattern matcher");
    }

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher<HttpRequestHandler>());
    }

    public void register(String string, HttpRequestHandler httpRequestHandler) {
        Args.notNull(string, "Pattern");
        Args.notNull(httpRequestHandler, "Handler");
        this.matcher.register(string, httpRequestHandler);
    }

    public void unregister(String string) {
        this.matcher.unregister(string);
    }

    protected String getRequestPath(HttpRequest httpRequest) {
        String string = httpRequest.getRequestLine().getUri();
        int n = string.indexOf("?");
        if (n != -1) {
            string = string.substring(0, n);
        } else {
            n = string.indexOf("#");
            if (n != -1) {
                string = string.substring(0, n);
            }
        }
        return string;
    }

    @Override
    public HttpRequestHandler lookup(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return this.matcher.lookup(this.getRequestPath(httpRequest));
    }
}

