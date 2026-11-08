/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.request;

import java.io.IOException;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.raphimc.minecraftauth.java.exception.MinecraftProfileNotFoundException;
import net.raphimc.minecraftauth.java.exception.MinecraftServicesRequestException;
import net.raphimc.minecraftauth.java.model.MinecraftProfile;
import net.raphimc.minecraftauth.java.model.MinecraftToken;
import net.raphimc.minecraftauth.java.responsehandler.MinecraftServicesResponseHandler;
import net.raphimc.minecraftauth.util.UuidUtil;

public class MinecraftProfileRequest
extends GetRequest
implements MinecraftServicesResponseHandler<MinecraftProfile> {
    public MinecraftProfileRequest(MinecraftToken minecraftToken) throws MalformedURLException {
        super("https://api.minecraftservices.com/minecraft/profile");
        this.setHeader("Authorization", minecraftToken.getAuthorizationHeader());
    }

    @Override
    public MinecraftProfile handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        return new MinecraftProfile(UuidUtil.fromUndashedString(gsonObject.reqString("id")), gsonObject.reqString("name"));
    }

    @Override
    public void handleError(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        try {
            MinecraftServicesResponseHandler.super.handleError(httpResponse, gsonObject);
        }
        catch (MinecraftServicesRequestException minecraftServicesRequestException) {
            if (minecraftServicesRequestException.getResponse().getStatusCode() == 404) {
                throw new MinecraftProfileNotFoundException(minecraftServicesRequestException);
            }
            throw minecraftServicesRequestException;
        }
    }
}

