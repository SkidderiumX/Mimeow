/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.retry;

import javax.annotation.Nonnull;
import lombok.Generated;
import net.lenni0451.commons.httpclient.retry.RetryHandler;
import net.lenni0451.commons.httpclient.retry.handlers.RetryAfterRetryHandler;

public class RetryConfig {
    private int maxConnectRetries;
    private int maxResponseRetries;
    @Nonnull
    private RetryHandler retryHandler;

    public RetryConfig() {
        this(0, 0);
    }

    public RetryConfig(int n, int n2) {
        this(n, n2, new RetryAfterRetryHandler());
    }

    public RetryConfig(int n, int n2, @Nonnull RetryHandler retryHandler) {
        this.maxConnectRetries = n;
        this.maxResponseRetries = n2;
        this.retryHandler = retryHandler;
    }

    @Generated
    public int getMaxConnectRetries() {
        return this.maxConnectRetries;
    }

    @Generated
    public int getMaxResponseRetries() {
        return this.maxResponseRetries;
    }

    @Nonnull
    @Generated
    public RetryHandler getRetryHandler() {
        return this.retryHandler;
    }

    @Generated
    public RetryConfig setMaxConnectRetries(int n) {
        this.maxConnectRetries = n;
        return this;
    }

    @Generated
    public RetryConfig setMaxResponseRetries(int n) {
        this.maxResponseRetries = n;
        return this;
    }

    @Generated
    public RetryConfig setRetryHandler(@Nonnull RetryHandler retryHandler) {
        if (retryHandler == null) {
            throw new NullPointerException("retryHandler is marked non-null but is null");
        }
        this.retryHandler = retryHandler;
        return this;
    }
}

