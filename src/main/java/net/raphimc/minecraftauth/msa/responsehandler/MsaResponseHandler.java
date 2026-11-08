/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.responsehandler;

import java.io.IOException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.msa.exception.MsaRequestException;
import net.raphimc.minecraftauth.util.http.responsehandler.JsonHttpResponseHandler;

public interface MsaResponseHandler<R>
extends JsonHttpResponseHandler<R> {
    @Override
    default public void handleError(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        if (gsonObject.hasString("error") && gsonObject.hasString("error_description")) {
            throw new MsaRequestException(httpResponse, gsonObject.reqString("error"), gsonObject.reqString("error_description"));
        }
    }
}

