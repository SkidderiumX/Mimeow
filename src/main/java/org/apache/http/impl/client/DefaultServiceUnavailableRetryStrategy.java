/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultServiceUnavailableRetryStrategy
implements ServiceUnavailableRetryStrategy {
    private final int maxRetries;
    private final long retryInterval;

    public DefaultServiceUnavailableRetryStrategy(int n, int n2) {
        Args.positive(n, "Max retries");
        Args.positive(n2, "Retry interval");
        this.maxRetries = n;
        this.retryInterval = n2;
    }

    public DefaultServiceUnavailableRetryStrategy() {
        this(1, 1000);
    }

    public boolean retryRequest(HttpResponse httpResponse, int n, HttpContext httpContext) {
        return n <= this.maxRetries && httpResponse.getStatusLine().getStatusCode() == 503;
    }

    public long getRetryInterval() {
        return this.retryInterval;
    }
}

