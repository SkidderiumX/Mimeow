/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthenticationException;

@Immutable
public class InvalidCredentialsException
extends AuthenticationException {
    private static final long serialVersionUID = -4834003835215460648L;

    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String string) {
        super(string);
    }

    public InvalidCredentialsException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

