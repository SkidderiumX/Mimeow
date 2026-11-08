/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.request;

import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblDeviceToken;
import net.raphimc.minecraftauth.xbl.model.XblSisuTokens;
import net.raphimc.minecraftauth.xbl.model.XblTitleToken;
import net.raphimc.minecraftauth.xbl.model.XblUserToken;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;
import net.raphimc.minecraftauth.xbl.request.SignedXblPostRequest;
import net.raphimc.minecraftauth.xbl.responsehandler.XblResponseHandler;

public class XblSisuAuthorizeRequest
extends SignedXblPostRequest
implements XblResponseHandler<XblSisuTokens> {
    public XblSisuAuthorizeRequest(MsaApplicationConfig msaApplicationConfig, MsaToken msaToken, XblDeviceToken xblDeviceToken, KeyPair keyPair, String string) throws MalformedURLException {
        super("https://sisu.xboxlive.com/authorize");
        if (!msaApplicationConfig.isTitleClientId()) {
            throw new IllegalArgumentException("Client id must be a title client id for XBL SISU authentication");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Sandbox", "RETAIL");
        jsonObject.addProperty("UseModernGamertag", true);
        jsonObject.addProperty("AppId", msaApplicationConfig.getClientId());
        jsonObject.addProperty("AccessToken", "t=" + msaToken.getAccessToken());
        jsonObject.addProperty("DeviceToken", xblDeviceToken.getToken());
        jsonObject.add("ProofKey", this.getProofKey((ECPublicKey)keyPair.getPublic()));
        jsonObject.addProperty("RelyingParty", string);
        this.setContent(new JsonContent(jsonObject));
        this.appendSignatureHeader((ECPrivateKey)keyPair.getPrivate());
    }

    @Override
    public XblSisuTokens handle(HttpResponse httpResponse, GsonObject gsonObject) {
        return new XblSisuTokens(XblUserToken.fromApiJson(gsonObject.reqObject("UserToken")), XblTitleToken.fromApiJson(gsonObject.reqObject("TitleToken")), XblXstsToken.fromApiJson(gsonObject.reqObject("AuthorizationToken")));
    }
}

