/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.responsehandler;

import java.io.IOException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.bedrock.exception.MinecraftRequestException;
import net.raphimc.minecraftauth.util.http.exception.InformativeHttpRequestException;
import net.raphimc.minecraftauth.util.http.responsehandler.JsonHttpResponseHandler;

public interface MinecraftResponseHandler<R>
extends JsonHttpResponseHandler<R> {
    @Override
    default public void handleError(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        if (gsonObject.hasString("error") && gsonObject.hasString("errorMessage")) {
            throw new MinecraftRequestException(httpResponse, gsonObject.reqString("error"), gsonObject.reqString("errorMessage"));
        }
        if (gsonObject.hasString("errorMessage")) {
            throw new InformativeHttpRequestException(httpResponse, gsonObject.reqString("errorMessage"));
        }
    }
}

