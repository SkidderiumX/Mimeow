/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.requests.impl;

import java.net.MalformedURLException;
import java.net.URL;
import net.lenni0451.commons.httpclient.requests.HttpRequest;

public class DeleteRequest
extends HttpRequest {
    public DeleteRequest(String string) throws MalformedURLException {
        super("DELETE", string);
    }

    public DeleteRequest(URL uRL) {
        super("DELETE", uRL);
    }
}

