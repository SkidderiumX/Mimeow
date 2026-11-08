/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.responsehandler;

import java.io.IOException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.bedrock.exception.MinecraftServicesRequestException;
import net.raphimc.minecraftauth.util.http.responsehandler.JsonHttpResponseHandler;

public interface MinecraftServicesResponseHandler<R>
extends JsonHttpResponseHandler<R> {
    @Override
    default public void handleError(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        MinecraftServicesRequestException minecraftServicesRequestException = null;
        Throwable throwable = null;
        GsonObject gsonObject2 = gsonObject;
        do {
            if (!gsonObject2.hasString("namespace") || !gsonObject2.hasString("code") || !gsonObject2.hasString("message")) continue;
            MinecraftServicesRequestException minecraftServicesRequestException2 = new MinecraftServicesRequestException(httpResponse, gsonObject2.getString("namespace"), gsonObject2.reqString("code"), gsonObject2.reqString("message"));
            if (minecraftServicesRequestException == null) {
                minecraftServicesRequestException = minecraftServicesRequestException2;
            } else {
                throwable.addSuppressed(minecraftServicesRequestException2);
            }
            throwable = minecraftServicesRequestException2;
        } while ((gsonObject2 = gsonObject2.hasObject("innerError") ? gsonObject2.reqObject("innerError") : null) != null);
        if (minecraftServicesRequestException != null) {
            throw minecraftServicesRequestException;
        }
    }
}

