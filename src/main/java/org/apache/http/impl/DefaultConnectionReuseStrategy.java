/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultConnectionReuseStrategy
implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        int n;
        Object object;
        Object object2;
        ProtocolVersion protocolVersion;
        block15: {
            Args.notNull(httpResponse, "HTTP response");
            Args.notNull(httpContext, "HTTP context");
            protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
            Header header = httpResponse.getFirstHeader("Transfer-Encoding");
            if (header != null) {
                if (!"chunked".equalsIgnoreCase(header.getValue())) {
                    return false;
                }
            } else if (this.canResponseHaveBody(httpResponse)) {
                object2 = httpResponse.getHeaders("Content-Length");
                if (((Header[])object2).length == 1) {
                    object = object2[0];
                    try {
                        n = Integer.parseInt(object.getValue());
                        if (n < 0) {
                            return false;
                        }
                        break block15;
                    }
                    catch (NumberFormatException numberFormatException) {
                        return false;
                    }
                }
                return false;
            }
        }
        if (!(object2 = httpResponse.headerIterator("Connection")).hasNext()) {
            object2 = httpResponse.headerIterator("Proxy-Connection");
        }
        if (object2.hasNext()) {
            try {
                object = this.createTokenIterator((HeaderIterator)object2);
                n = 0;
                while (object.hasNext()) {
                    String string = object.nextToken();
                    if ("Close".equalsIgnoreCase(string)) {
                        return false;
                    }
                    if (!"Keep-Alive".equalsIgnoreCase(string)) continue;
                    n = 1;
                }
                if (n != 0) {
                    return true;
                }
            }
            catch (ParseException parseException) {
                return false;
            }
        }
        return !protocolVersion.lessEquals(HttpVersion.HTTP_1_0);
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    private boolean canResponseHaveBody(HttpResponse httpResponse) {
        int n = httpResponse.getStatusLine().getStatusCode();
        return n >= 200 && n != 204 && n != 304 && n != 205;
    }
}

