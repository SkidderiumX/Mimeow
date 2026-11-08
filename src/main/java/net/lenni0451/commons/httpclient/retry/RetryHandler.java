/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.retry;

import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.retry.RetryAction;

@FunctionalInterface
public interface RetryHandler {
    public RetryAction shouldRetry(HttpResponse var1);
}

