/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client;

import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;

@Immutable
public class NonRepeatableRequestException
extends ProtocolException {
    private static final long serialVersionUID = 82685265288806048L;

    public NonRepeatableRequestException() {
    }

    public NonRepeatableRequestException(String string) {
        super(string);
    }

    public NonRepeatableRequestException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

