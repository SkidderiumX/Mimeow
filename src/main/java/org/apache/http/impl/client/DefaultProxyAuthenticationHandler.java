/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.impl.client.AbstractAuthenticationHandler;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
@Immutable
public class DefaultProxyAuthenticationHandler
extends AbstractAuthenticationHandler {
    @Override
    public boolean isAuthenticationRequested(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        int n = httpResponse.getStatusLine().getStatusCode();
        return n == 407;
    }

    @Override
    public Map<String, Header> getChallenges(HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Args.notNull(httpResponse, "HTTP response");
        Header[] headerArray = httpResponse.getHeaders("Proxy-Authenticate");
        return this.parseChallenges(headerArray);
    }

    @Override
    protected List<String> getAuthPreferences(HttpResponse httpResponse, HttpContext httpContext) {
        List list = (List)httpResponse.getParams().getParameter("http.auth.proxy-scheme-pref");
        if (list != null) {
            return list;
        }
        return super.getAuthPreferences(httpResponse, httpContext);
    }
}

