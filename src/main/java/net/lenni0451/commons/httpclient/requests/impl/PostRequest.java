/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.requests.impl;

import java.net.MalformedURLException;
import java.net.URL;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;

public class PostRequest
extends HttpContentRequest {
    public PostRequest(String string) throws MalformedURLException {
        super("POST", string);
    }

    public PostRequest(URL uRL) {
        super("POST", uRL);
    }
}

