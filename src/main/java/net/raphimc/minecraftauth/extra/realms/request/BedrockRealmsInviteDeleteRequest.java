/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.request;

import java.io.IOException;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.DeleteRequest;
import net.raphimc.minecraftauth.extra.realms.model.RealmsServer;
import net.raphimc.minecraftauth.extra.realms.responsehandler.RealmsResponseHandler;

public class BedrockRealmsInviteDeleteRequest
extends DeleteRequest
implements RealmsResponseHandler<Void> {
    public BedrockRealmsInviteDeleteRequest(RealmsServer realmsServer) throws MalformedURLException {
        super("https://pocket.realms.minecraft.net/invites/" + realmsServer.getId());
    }

    @Override
    public Void handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        throw new UnsupportedOperationException("This request is not supposed to return any data");
    }
}

