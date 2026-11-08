/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec;

import io.netty.util.Signal;

public class DecoderResult {
    protected static final Signal SIGNAL_UNFINISHED = Signal.valueOf(DecoderResult.class.getName() + ".UNFINISHED");
    protected static final Signal SIGNAL_SUCCESS = Signal.valueOf(DecoderResult.class.getName() + ".SUCCESS");
    public static final DecoderResult UNFINISHED = new DecoderResult(SIGNAL_UNFINISHED);
    public static final DecoderResult SUCCESS = new DecoderResult(SIGNAL_SUCCESS);
    private final Throwable cause;

    public static DecoderResult failure(Throwable throwable) {
        if (throwable == null) {
            throw new NullPointerException("cause");
        }
        return new DecoderResult(throwable);
    }

    protected DecoderResult(Throwable throwable) {
        if (throwable == null) {
            throw new NullPointerException("cause");
        }
        this.cause = throwable;
    }

    public boolean isFinished() {
        return this.cause != SIGNAL_UNFINISHED;
    }

    public boolean isSuccess() {
        return this.cause == SIGNAL_SUCCESS;
    }

    public boolean isFailure() {
        return this.cause != SIGNAL_SUCCESS && this.cause != SIGNAL_UNFINISHED;
    }

    public Throwable cause() {
        if (this.isFailure()) {
            return this.cause;
        }
        return null;
    }

    public String toString() {
        if (this.isFinished()) {
            if (this.isSuccess()) {
                return "success";
            }
            String string = this.cause().toString();
            StringBuilder stringBuilder = new StringBuilder(string.length() + 17);
            stringBuilder.append("failure(");
            stringBuilder.append(string);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
        return "unfinished";
    }
}

