/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.request;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Collectors;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.raphimc.minecraftauth.java.model.MinecraftEntitlements;
import net.raphimc.minecraftauth.java.model.MinecraftToken;
import net.raphimc.minecraftauth.java.responsehandler.MinecraftServicesResponseHandler;

public class MinecraftEntitlementsRequest
extends GetRequest
implements MinecraftServicesResponseHandler<MinecraftEntitlements> {
    public MinecraftEntitlementsRequest(MinecraftToken minecraftToken) throws MalformedURLException {
        super("https://api.minecraftservices.com/entitlements/mcstore");
        this.setHeader("Authorization", minecraftToken.getAuthorizationHeader());
    }

    @Override
    public MinecraftEntitlements handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        return new MinecraftEntitlements(gsonObject.reqArray("items").stream().map(gsonElement -> gsonElement.asObject().reqString("name")).collect(Collectors.toSet()));
    }
}

