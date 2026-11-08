/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.request;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.java.model.MinecraftToken;
import net.raphimc.minecraftauth.java.responsehandler.MinecraftServicesResponseHandler;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;

public class MinecraftLauncherLoginRequest
extends PostRequest
implements MinecraftServicesResponseHandler<MinecraftToken> {
    public MinecraftLauncherLoginRequest(XblXstsToken xblXstsToken) throws MalformedURLException {
        super("https://api.minecraftservices.com/launcher/login");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("platform", "PC_LAUNCHER");
        jsonObject.addProperty("xtoken", xblXstsToken.getAuthorizationHeader());
        this.setContent(new JsonContent(jsonObject));
    }

    @Override
    public MinecraftToken handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        return new MinecraftToken(System.currentTimeMillis() + (long)gsonObject.reqInt("expires_in") * 1000L, gsonObject.reqString("token_type"), gsonObject.reqString("access_token"));
    }
}

