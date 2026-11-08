/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.requests.impl;

import java.net.MalformedURLException;
import java.net.URL;
import net.lenni0451.commons.httpclient.requests.HttpRequest;

public class GetRequest
extends HttpRequest {
    public GetRequest(String string) throws MalformedURLException {
        super("GET", string);
    }

    public GetRequest(URL uRL) {
        super("GET", uRL);
    }
}

