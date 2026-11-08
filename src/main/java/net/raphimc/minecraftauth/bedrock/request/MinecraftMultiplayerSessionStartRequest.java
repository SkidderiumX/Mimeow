/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.request;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.time.Instant;
import java.util.Base64;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.bedrock.model.MinecraftMultiplayerToken;
import net.raphimc.minecraftauth.bedrock.model.MinecraftSession;
import net.raphimc.minecraftauth.bedrock.responsehandler.MinecraftServicesResponseHandler;
import net.raphimc.minecraftauth.util.http.content.JsonContent;

public class MinecraftMultiplayerSessionStartRequest
extends PostRequest
implements MinecraftServicesResponseHandler<MinecraftMultiplayerToken> {
    public MinecraftMultiplayerSessionStartRequest(MinecraftSession minecraftSession, KeyPair keyPair) throws MalformedURLException {
        super("https://authorization.franchise.minecraft-services.net/api/v1.0/multiplayer/session/start");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("publicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        this.setContent(new JsonContent(jsonObject));
        this.setHeader("Authorization", minecraftSession.getAuthorizationHeader());
    }

    @Override
    public MinecraftMultiplayerToken handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        GsonObject gsonObject2 = gsonObject.reqObject("result");
        return new MinecraftMultiplayerToken(Instant.parse(gsonObject2.reqString("validUntil")).toEpochMilli(), gsonObject2.reqString("signedToken"));
    }
}

