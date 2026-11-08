/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.request;

import java.io.IOException;
import java.net.MalformedURLException;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.exceptions.HttpRequestException;
import net.lenni0451.commons.httpclient.handler.HttpResponseHandler;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;

public class RealmsClientCompatibleRequest
extends GetRequest
implements HttpResponseHandler<String> {
    public RealmsClientCompatibleRequest(String string) throws MalformedURLException {
        super("https://" + string + "/mco/client/compatible");
        this.setHeader("Accept", ContentTypes.TEXT_PLAIN.getMimeType());
    }

    @Override
    public String handle(HttpResponse httpResponse) throws IOException {
        if (httpResponse.getStatusCode() >= 300) {
            throw new HttpRequestException(httpResponse);
        }
        return httpResponse.getContent().getAsString();
    }
}

