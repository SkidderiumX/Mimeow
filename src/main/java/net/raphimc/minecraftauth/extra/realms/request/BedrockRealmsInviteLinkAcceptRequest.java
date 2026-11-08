/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.request;

import java.io.IOException;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.extra.realms.model.RealmsServer;
import net.raphimc.minecraftauth.extra.realms.responsehandler.RealmsResponseHandler;

public class BedrockRealmsInviteLinkAcceptRequest
extends PostRequest
implements RealmsResponseHandler<RealmsServer> {
    public BedrockRealmsInviteLinkAcceptRequest(String string) throws MalformedURLException {
        super("https://pocket.realms.minecraft.net/invites/v1/link/accept/" + string);
    }

    @Override
    public RealmsServer handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        return RealmsServer.fromApiJson(gsonObject);
    }
}

