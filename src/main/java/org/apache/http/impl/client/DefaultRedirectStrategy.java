/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.RedirectLocations;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.TextUtils;

@Immutable
public class DefaultRedirectStrategy
implements RedirectStrategy {
    private final Log log = LogFactory.getLog(this.getClass());
    @Deprecated
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
    private static final String[] REDIRECT_METHODS = new String[]{"GET", "HEAD"};

    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        int n = httpResponse.getStatusLine().getStatusCode();
        String string = httpRequest.getRequestLine().getMethod();
        Header header = httpResponse.getFirstHeader("location");
        switch (n) {
            case 302: {
                return this.isRedirectable(string) && header != null;
            }
            case 301: 
            case 307: {
                return this.isRedirectable(string);
            }
            case 303: {
                return true;
            }
        }
        return false;
    }

    public URI getLocationURI(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Object object;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext httpClientContext = HttpClientContext.adapt(httpContext);
        Header header = httpResponse.getFirstHeader("location");
        if (header == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
        String string = header.getValue();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Redirect requested to location '" + string + "'");
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        URI uRI = this.createLocationURI(string);
        try {
            if (!uRI.isAbsolute()) {
                if (!requestConfig.isRelativeRedirectsAllowed()) {
                    throw new ProtocolException("Relative redirect location '" + uRI + "' not allowed");
                }
                object = httpClientContext.getTargetHost();
                Asserts.notNull(object, "Target host");
                URI uRI2 = new URI(httpRequest.getRequestLine().getUri());
                URI uRI3 = URIUtils.rewriteURI(uRI2, (HttpHost)object, false);
                uRI = URIUtils.resolve(uRI3, uRI);
            }
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new ProtocolException(uRISyntaxException.getMessage(), uRISyntaxException);
        }
        object = (RedirectLocations)httpClientContext.getAttribute(REDIRECT_LOCATIONS);
        if (object == null) {
            object = new RedirectLocations();
            httpContext.setAttribute(REDIRECT_LOCATIONS, object);
        }
        if (!requestConfig.isCircularRedirectsAllowed() && ((RedirectLocations)object).contains(uRI)) {
            throw new CircularRedirectException("Circular redirect to '" + uRI + "'");
        }
        ((RedirectLocations)object).add(uRI);
        return uRI;
    }

    protected URI createLocationURI(String string) throws ProtocolException {
        try {
            String string2;
            URIBuilder uRIBuilder = new URIBuilder(new URI(string).normalize());
            String string3 = uRIBuilder.getHost();
            if (string3 != null) {
                uRIBuilder.setHost(string3.toLowerCase(Locale.US));
            }
            if (TextUtils.isEmpty(string2 = uRIBuilder.getPath())) {
                uRIBuilder.setPath("/");
            }
            return uRIBuilder.build();
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new ProtocolException("Invalid redirect URI: " + string, uRISyntaxException);
        }
    }

    protected boolean isRedirectable(String string) {
        for (String string2 : REDIRECT_METHODS) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI uRI = this.getLocationURI(httpRequest, httpResponse, httpContext);
        String string = httpRequest.getRequestLine().getMethod();
        if (string.equalsIgnoreCase("HEAD")) {
            return new HttpHead(uRI);
        }
        if (string.equalsIgnoreCase("GET")) {
            return new HttpGet(uRI);
        }
        int n = httpResponse.getStatusLine().getStatusCode();
        if (n == 307) {
            return RequestBuilder.copy(httpRequest).setUri(uRI).build();
        }
        return new HttpGet(uRI);
    }
}

