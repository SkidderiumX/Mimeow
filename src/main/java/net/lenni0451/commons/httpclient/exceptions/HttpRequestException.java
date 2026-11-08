/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.exceptions;

import java.io.IOException;
import net.lenni0451.commons.httpclient.HttpResponse;

public class HttpRequestException
extends IOException {
    private final HttpResponse response;

    public HttpRequestException(HttpResponse httpResponse) {
        this(httpResponse, "Request failed: " + httpResponse.getStatusCode() + " " + httpResponse.getStatusMessage());
    }

    public HttpRequestException(HttpResponse httpResponse, String string) {
        super(string);
        this.response = httpResponse;
    }

    public HttpResponse getResponse() {
        return this.response;
    }
}

