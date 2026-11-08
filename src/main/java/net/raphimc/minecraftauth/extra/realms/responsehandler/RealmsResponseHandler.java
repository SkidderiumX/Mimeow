/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.responsehandler;

import java.io.IOException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.extra.realms.exception.RealmsRequestException;
import net.raphimc.minecraftauth.util.http.responsehandler.JsonHttpResponseHandler;

public interface RealmsResponseHandler<R>
extends JsonHttpResponseHandler<R> {
    @Override
    default public void handleError(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        if (gsonObject.hasNumber("errorCode") && gsonObject.hasString("errorMsg")) {
            throw new RealmsRequestException(httpResponse, gsonObject.reqInt("errorCode"), gsonObject.reqString("errorMsg"));
        }
    }
}

