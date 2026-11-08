/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.requests.impl;

import java.net.MalformedURLException;
import java.net.URL;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;

public class PutRequest
extends HttpContentRequest {
    public PutRequest(String string) throws MalformedURLException {
        super("PUT", string);
    }

    public PutRequest(URL uRL) {
        super("PUT", uRL);
    }
}

