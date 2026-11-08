/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.playfab.responsehandler;

import java.io.IOException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.playfab.exception.PlayFabRequestException;
import net.raphimc.minecraftauth.util.http.responsehandler.JsonHttpResponseHandler;

public interface PlayFabResponseHandler<R>
extends JsonHttpResponseHandler<R> {
    @Override
    default public void handleError(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        if (gsonObject.hasString("error") && gsonObject.hasString("errorMessage")) {
            throw new PlayFabRequestException(httpResponse, gsonObject.reqString("error"), gsonObject.reqString("errorMessage"));
        }
    }
}

