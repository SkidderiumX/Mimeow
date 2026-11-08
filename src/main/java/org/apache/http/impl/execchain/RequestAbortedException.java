/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.execchain;

import java.io.InterruptedIOException;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestAbortedException
extends InterruptedIOException {
    private static final long serialVersionUID = 4973849966012490112L;

    public RequestAbortedException(String string) {
        super(string);
    }

    public RequestAbortedException(String string, Throwable throwable) {
        super(string);
        if (throwable != null) {
            this.initCause(throwable);
        }
    }
}

