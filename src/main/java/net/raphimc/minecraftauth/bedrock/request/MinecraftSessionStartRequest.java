/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.request;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Instant;
import java.util.UUID;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.bedrock.model.MinecraftSession;
import net.raphimc.minecraftauth.bedrock.responsehandler.MinecraftServicesResponseHandler;
import net.raphimc.minecraftauth.playfab.model.PlayFabToken;
import net.raphimc.minecraftauth.util.UuidUtil;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;

public class MinecraftSessionStartRequest
extends PostRequest
implements MinecraftServicesResponseHandler<MinecraftSession> {
    @Deprecated
    public MinecraftSessionStartRequest(XblXstsToken xblXstsToken, PlayFabToken playFabToken, String string, UUID uUID) throws MalformedURLException {
        this(playFabToken, string, uUID);
    }

    public MinecraftSessionStartRequest(PlayFabToken playFabToken, String string, UUID uUID) throws MalformedURLException {
        super("https://authorization.franchise.minecraft-services.net/api/v1.0/session/start");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("applicationType", "MinecraftPE");
        jsonObject.addProperty("gameVersion", string);
        jsonObject.addProperty("id", UuidUtil.toUndashedString(uUID));
        jsonObject.addProperty("memory", 0x800000000L);
        jsonObject.addProperty("hardwareMemoryTier", 5);
        jsonObject.addProperty("platform", "Windows10");
        jsonObject.addProperty("playFabTitleId", "20CA2");
        jsonObject.addProperty("storePlatform", "uwp.store");
        jsonObject.addProperty("type", "Windows10");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("language", "en");
        jsonObject2.addProperty("regionCode", "US");
        jsonObject2.addProperty("languageCode", "en-US");
        jsonObject2.addProperty("tokenType", "PlayFab");
        jsonObject2.addProperty("token", playFabToken.getSessionTicket());
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("device", jsonObject);
        jsonObject3.add("user", jsonObject2);
        this.setContent(new JsonContent(jsonObject3));
    }

    @Override
    public MinecraftSession handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        GsonObject gsonObject2 = gsonObject.reqObject("result");
        return new MinecraftSession(Instant.parse(gsonObject2.reqString("validUntil")).toEpochMilli(), gsonObject2.reqString("authorizationHeader"));
    }
}

