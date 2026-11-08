/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.requests;

import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nullable;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.requests.HttpRequest;

public class HttpContentRequest
extends HttpRequest {
    @Nullable
    private HttpContent content;

    public HttpContentRequest(String string, String string2) throws MalformedURLException {
        super(string, string2);
    }

    public HttpContentRequest(String string, URL uRL) {
        super(string, uRL);
    }

    public boolean hasContent() {
        return this.content != null;
    }

    @Nullable
    public HttpContent getContent() {
        return this.content;
    }

    public HttpContentRequest setContent(@Nullable HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }
}

