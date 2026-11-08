/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.handler;

import java.io.IOException;
import javax.annotation.Nonnull;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.exceptions.HttpRequestException;
import net.lenni0451.commons.httpclient.handler.HttpResponseHandler;

public class ThrowingResponseHandler
implements HttpResponseHandler<HttpResponse> {
    @Override
    public HttpResponse handle(@Nonnull HttpResponse httpResponse) throws IOException {
        if (httpResponse.getStatusCode() >= 300) {
            throw new HttpRequestException(httpResponse);
        }
        return httpResponse;
    }
}

