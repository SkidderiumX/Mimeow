/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl;

public class SslHandshakeCompletionEvent {
    public static final SslHandshakeCompletionEvent SUCCESS = new SslHandshakeCompletionEvent();
    private final Throwable cause;

    private SslHandshakeCompletionEvent() {
        this.cause = null;
    }

    public SslHandshakeCompletionEvent(Throwable throwable) {
        if (throwable == null) {
            throw new NullPointerException("cause");
        }
        this.cause = throwable;
    }

    public boolean isSuccess() {
        return this.cause == null;
    }

    public Throwable cause() {
        return this.cause;
    }
}

