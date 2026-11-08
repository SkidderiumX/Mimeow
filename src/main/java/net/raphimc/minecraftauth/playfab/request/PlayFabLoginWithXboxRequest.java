/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.playfab.request;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.playfab.model.PlayFabEntityToken;
import net.raphimc.minecraftauth.playfab.model.PlayFabToken;
import net.raphimc.minecraftauth.playfab.responsehandler.PlayFabResponseHandler;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;

public class PlayFabLoginWithXboxRequest
extends PostRequest
implements PlayFabResponseHandler<PlayFabToken> {
    public PlayFabLoginWithXboxRequest(XblXstsToken xblXstsToken, String string) throws MalformedURLException {
        super("https://" + string.toLowerCase(Locale.ROOT) + ".playfabapi.com/Client/LoginWithXbox");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("GetPlayerProfile", true);
        jsonObject.addProperty("GetUserAccountInfo", true);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("CreateAccount", true);
        jsonObject2.add("InfoRequestParameters", jsonObject);
        jsonObject2.addProperty("TitleId", string.toUpperCase(Locale.ROOT));
        jsonObject2.addProperty("XboxToken", xblXstsToken.getAuthorizationHeader());
        this.setContent(new JsonContent(jsonObject2));
    }

    @Override
    public PlayFabToken handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        GsonObject gsonObject2 = gsonObject.reqObject("data");
        return new PlayFabToken(PlayFabEntityToken.fromApiJson(gsonObject2.reqObject("EntityToken")), gsonObject2.reqString("PlayFabId"), gsonObject2.reqString("SessionTicket"));
    }
}

