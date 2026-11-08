/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.playfab.request;

import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.util.Locale;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.playfab.model.PlayFabEntityToken;
import net.raphimc.minecraftauth.playfab.responsehandler.PlayFabResponseHandler;
import net.raphimc.minecraftauth.util.http.content.JsonContent;

public class PlayFabGetEntityTokenRequest
extends PostRequest
implements PlayFabResponseHandler<PlayFabEntityToken> {
    public PlayFabGetEntityTokenRequest(PlayFabEntityToken playFabEntityToken, String string, String string2, String string3) throws MalformedURLException {
        super("https://" + string.toLowerCase(Locale.ROOT) + ".playfabapi.com/Authentication/GetEntityToken");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Id", string2);
        jsonObject.addProperty("Type", string3);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Entity", jsonObject);
        this.setContent(new JsonContent(jsonObject2));
        this.setHeader("X-EntityToken", playFabEntityToken.getToken());
    }

    @Override
    public PlayFabEntityToken handle(HttpResponse httpResponse, GsonObject gsonObject) {
        return PlayFabEntityToken.fromApiJson(gsonObject.reqObject("data"));
    }
}

