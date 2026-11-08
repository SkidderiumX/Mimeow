/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class DefaultHttpRequestRetryHandler
implements HttpRequestRetryHandler {
    public static final DefaultHttpRequestRetryHandler INSTANCE = new DefaultHttpRequestRetryHandler();
    private final int retryCount;
    private final boolean requestSentRetryEnabled;
    private final Set<Class<? extends IOException>> nonRetriableClasses;

    protected DefaultHttpRequestRetryHandler(int n, boolean bl, Collection<Class<? extends IOException>> collection) {
        this.retryCount = n;
        this.requestSentRetryEnabled = bl;
        this.nonRetriableClasses = new HashSet<Class<? extends IOException>>();
        for (Class<? extends IOException> clazz : collection) {
            this.nonRetriableClasses.add(clazz);
        }
    }

    public DefaultHttpRequestRetryHandler(int n, boolean bl) {
        this(n, bl, Arrays.asList(InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class));
    }

    public DefaultHttpRequestRetryHandler() {
        this(3, false);
    }

    @Override
    public boolean retryRequest(IOException iOException, int n, HttpContext httpContext) {
        Args.notNull(iOException, "Exception parameter");
        Args.notNull(httpContext, "HTTP context");
        if (n > this.retryCount) {
            return false;
        }
        if (this.nonRetriableClasses.contains(iOException.getClass())) {
            return false;
        }
        for (Class<? extends IOException> object2 : this.nonRetriableClasses) {
            if (!object2.isInstance(iOException)) continue;
            return false;
        }
        HttpClientContext httpClientContext = HttpClientContext.adapt(httpContext);
        HttpRequest httpRequest = httpClientContext.getRequest();
        if (this.requestIsAborted(httpRequest)) {
            return false;
        }
        if (this.handleAsIdempotent(httpRequest)) {
            return true;
        }
        return !httpClientContext.isRequestSent() || this.requestSentRetryEnabled;
    }

    public boolean isRequestSentRetryEnabled() {
        return this.requestSentRetryEnabled;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    protected boolean handleAsIdempotent(HttpRequest httpRequest) {
        return !(httpRequest instanceof HttpEntityEnclosingRequest);
    }

    @Deprecated
    protected boolean requestIsAborted(HttpRequest httpRequest) {
        HttpRequest httpRequest2 = httpRequest;
        if (httpRequest instanceof RequestWrapper) {
            httpRequest2 = ((RequestWrapper)httpRequest).getOriginal();
        }
        return httpRequest2 instanceof HttpUriRequest && ((HttpUriRequest)httpRequest2).isAborted();
    }
}

