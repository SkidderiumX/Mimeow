/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.responsehandler;

import java.io.IOException;
import java.util.Optional;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.responsehandler.JsonHttpResponseHandler;
import net.raphimc.minecraftauth.xbl.exception.XblRequestException;

public interface XblResponseHandler<R>
extends JsonHttpResponseHandler<R> {
    @Override
    default public R handle(HttpResponse httpResponse) throws IOException {
        Optional<String> optional;
        if (httpResponse.getStatusCode() >= 300 && (optional = httpResponse.getFirstHeader("X-Err")).isPresent()) {
            throw new XblRequestException(httpResponse, Long.parseLong(optional.get()));
        }
        return JsonHttpResponseHandler.super.handle(httpResponse);
    }

    @Override
    default public void handleError(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        if (gsonObject.hasNumber("XErr")) {
            throw new XblRequestException(httpResponse, gsonObject.reqLong("XErr"));
        }
    }
}

