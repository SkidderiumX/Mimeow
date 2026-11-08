/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client;

import java.io.IOException;
import org.apache.http.annotation.Immutable;

@Immutable
public class ClientProtocolException
extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String string) {
        super(string);
    }

    public ClientProtocolException(Throwable throwable) {
        this.initCause(throwable);
    }

    public ClientProtocolException(String string, Throwable throwable) {
        super(string);
        this.initCause(throwable);
    }
}

