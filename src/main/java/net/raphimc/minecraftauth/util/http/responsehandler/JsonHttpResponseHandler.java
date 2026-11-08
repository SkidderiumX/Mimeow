/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.http.responsehandler;

import java.io.IOException;
import net.lenni0451.commons.gson.GsonParser;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.handler.HttpResponseHandler;
import net.raphimc.minecraftauth.util.http.exception.InformativeHttpRequestException;

public interface JsonHttpResponseHandler<R>
extends HttpResponseHandler<R> {
    @Override
    default public R handle(HttpResponse httpResponse) throws IOException {
        String string = httpResponse.getContent().getAsString();
        if (string.isEmpty() && httpResponse.getStatusCode() == 204) {
            return null;
        }
        if (string.isEmpty() && httpResponse.getStatusCode() >= 300) {
            throw new InformativeHttpRequestException(httpResponse, "Empty response");
        }
        if (!httpResponse.getContent().getType().getMimeType().equals(ContentTypes.APPLICATION_JSON.getMimeType())) {
            throw new InformativeHttpRequestException(httpResponse, "Wrong content type");
        }
        GsonObject gsonObject = GsonParser.parse(string).asObject();
        if (httpResponse.getStatusCode() >= 300) {
            this.handleError(httpResponse, gsonObject);
            throw new InformativeHttpRequestException(httpResponse, string);
        }
        return this.handle(httpResponse, gsonObject);
    }

    public R handle(HttpResponse var1, GsonObject var2) throws IOException;

    public void handleError(HttpResponse var1, GsonObject var2) throws IOException;
}

