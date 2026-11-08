/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.retry;

import java.util.concurrent.TimeUnit;
import lombok.Generated;

public class RetryAction {
    public static final RetryAction NO_RETRY = new RetryAction(false, 0L);
    private final boolean shouldRetry;
    private final long waitMillis;

    public static RetryAction waitFor(long l) {
        return RetryAction.waitFor(l, TimeUnit.MILLISECONDS);
    }

    public static RetryAction waitFor(long l, TimeUnit timeUnit) {
        return new RetryAction(true, timeUnit.toMillis(l));
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(this.waitMillis);
    }

    @Generated
    public boolean shouldRetry() {
        return this.shouldRetry;
    }

    @Generated
    public long waitMillis() {
        return this.waitMillis;
    }

    @Generated
    private RetryAction(boolean bl, long l) {
        this.shouldRetry = bl;
        this.waitMillis = l;
    }
}

