/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.requests.impl;

import java.net.MalformedURLException;
import java.net.URL;
import net.lenni0451.commons.httpclient.requests.HttpRequest;

public class HeadRequest
extends HttpRequest {
    public HeadRequest(String string) throws MalformedURLException {
        super("HEAD", string);
    }

    public HeadRequest(URL uRL) {
        super("HEAD", uRL);
    }
}

