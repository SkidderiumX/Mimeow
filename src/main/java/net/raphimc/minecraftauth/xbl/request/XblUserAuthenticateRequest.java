/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.request;

import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblUserToken;
import net.raphimc.minecraftauth.xbl.responsehandler.XblResponseHandler;

public class XblUserAuthenticateRequest
extends PostRequest
implements XblResponseHandler<XblUserToken> {
    public XblUserAuthenticateRequest(MsaApplicationConfig msaApplicationConfig, MsaToken msaToken) throws MalformedURLException {
        super("https://user.auth.xboxlive.com/user/authenticate");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("SiteName", "user.auth.xboxlive.com");
        jsonObject.addProperty("AuthMethod", "RPS");
        jsonObject.addProperty("RpsTicket", (msaApplicationConfig.isTitleClientId() ? "t=" : "d=") + msaToken.getAccessToken());
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", jsonObject);
        jsonObject2.addProperty("RelyingParty", "http://auth.xboxlive.com");
        jsonObject2.addProperty("TokenType", "JWT");
        this.setContent(new JsonContent(jsonObject2));
        this.setHeader("x-xbl-contract-version", "1");
    }

    @Override
    public XblUserToken handle(HttpResponse httpResponse, GsonObject gsonObject) {
        return XblUserToken.fromApiJson(gsonObject);
    }
}

