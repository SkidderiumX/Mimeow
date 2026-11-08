/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.handler;

import java.io.IOException;
import javax.annotation.Nonnull;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.handler.ThrowingResponseHandler;

@FunctionalInterface
public interface HttpResponseHandler<R> {
    public static HttpResponseHandler<HttpResponse> identity() {
        return httpResponse -> httpResponse;
    }

    public static ThrowingResponseHandler throwing() {
        return new ThrowingResponseHandler();
    }

    public R handle(@Nonnull HttpResponse var1) throws IOException;
}

