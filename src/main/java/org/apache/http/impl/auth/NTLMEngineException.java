/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthenticationException;

@Immutable
public class NTLMEngineException
extends AuthenticationException {
    private static final long serialVersionUID = 6027981323731768824L;

    public NTLMEngineException() {
    }

    public NTLMEngineException(String string) {
        super(string);
    }

    public NTLMEngineException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

