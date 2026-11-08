/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.request;

import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonArray;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblDeviceToken;
import net.raphimc.minecraftauth.xbl.model.XblTitleToken;
import net.raphimc.minecraftauth.xbl.model.XblUserToken;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;
import net.raphimc.minecraftauth.xbl.responsehandler.XblResponseHandler;

public class XblXstsAuthorizeRequest
extends PostRequest
implements XblResponseHandler<XblXstsToken> {
    public XblXstsAuthorizeRequest(XblDeviceToken xblDeviceToken, XblUserToken xblUserToken, XblTitleToken xblTitleToken, String string) throws MalformedURLException {
        super("https://xsts.auth.xboxlive.com/xsts/authorize");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("SandboxId", "RETAIL");
        if (xblDeviceToken != null) {
            jsonObject.addProperty("DeviceToken", xblDeviceToken.getToken());
        }
        jsonObject.add("UserTokens", new GsonArray().add(xblUserToken.getToken()).getJsonArray());
        if (xblTitleToken != null) {
            jsonObject.addProperty("TitleToken", xblTitleToken.getToken());
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", jsonObject);
        jsonObject2.addProperty("RelyingParty", string);
        jsonObject2.addProperty("TokenType", "JWT");
        this.setContent(new JsonContent(jsonObject2));
        this.setHeader("x-xbl-contract-version", "1");
    }

    @Override
    public XblXstsToken handle(HttpResponse httpResponse, GsonObject gsonObject) {
        return XblXstsToken.fromApiJson(gsonObject);
    }
}

