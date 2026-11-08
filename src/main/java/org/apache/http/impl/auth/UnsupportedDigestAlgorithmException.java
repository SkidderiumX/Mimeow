/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.auth;

import org.apache.http.annotation.Immutable;

@Immutable
public class UnsupportedDigestAlgorithmException
extends RuntimeException {
    private static final long serialVersionUID = 319558534317118022L;

    public UnsupportedDigestAlgorithmException() {
    }

    public UnsupportedDigestAlgorithmException(String string) {
        super(string);
    }

    public UnsupportedDigestAlgorithmException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

