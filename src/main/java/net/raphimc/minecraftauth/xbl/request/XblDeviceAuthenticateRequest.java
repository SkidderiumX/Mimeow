/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.request;

import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.time.Instant;
import java.util.UUID;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblDeviceToken;
import net.raphimc.minecraftauth.xbl.request.SignedXblPostRequest;
import net.raphimc.minecraftauth.xbl.responsehandler.XblResponseHandler;

public class XblDeviceAuthenticateRequest
extends SignedXblPostRequest
implements XblResponseHandler<XblDeviceToken> {
    public XblDeviceAuthenticateRequest(String string, UUID uUID, KeyPair keyPair) throws MalformedURLException {
        super("https://device.auth.xboxlive.com/device/authenticate");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("DeviceType", string);
        jsonObject.addProperty("Id", "{" + uUID + "}");
        jsonObject.addProperty("AuthMethod", "ProofOfPossession");
        jsonObject.add("ProofKey", this.getProofKey((ECPublicKey)keyPair.getPublic()));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", jsonObject);
        jsonObject2.addProperty("RelyingParty", "http://auth.xboxlive.com");
        jsonObject2.addProperty("TokenType", "JWT");
        this.setContent(new JsonContent(jsonObject2));
        this.setHeader("x-xbl-contract-version", "1");
        this.appendSignatureHeader((ECPrivateKey)keyPair.getPrivate());
    }

    @Override
    public XblDeviceToken handle(HttpResponse httpResponse, GsonObject gsonObject) {
        return new XblDeviceToken(Instant.parse(gsonObject.reqString("NotAfter")).toEpochMilli(), gsonObject.reqString("Token"), gsonObject.reqObject("DisplayClaims").reqObject("xdi").reqString("did"));
    }
}

