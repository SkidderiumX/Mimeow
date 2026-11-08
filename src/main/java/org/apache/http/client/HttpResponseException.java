/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client;

import org.apache.http.annotation.Immutable;
import org.apache.http.client.ClientProtocolException;

@Immutable
public class HttpResponseException
extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public HttpResponseException(int n, String string) {
        super(string);
        this.statusCode = n;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

