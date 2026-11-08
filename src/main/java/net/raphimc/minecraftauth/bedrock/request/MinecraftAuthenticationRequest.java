/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.request;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.util.Base64;
import net.lenni0451.commons.gson.elements.GsonArray;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.bedrock.model.MinecraftCertificateChain;
import net.raphimc.minecraftauth.bedrock.responsehandler.MinecraftResponseHandler;
import net.raphimc.minecraftauth.util.http.content.JsonContent;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;

public class MinecraftAuthenticationRequest
extends PostRequest
implements MinecraftResponseHandler<MinecraftCertificateChain> {
    public MinecraftAuthenticationRequest(XblXstsToken xblXstsToken, KeyPair keyPair) throws MalformedURLException {
        super("https://multiplayer.minecraft.net/authentication");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identityPublicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        this.setContent(new JsonContent(jsonObject));
        this.setHeader("Authorization", xblXstsToken.getAuthorizationHeader());
    }

    @Override
    public MinecraftCertificateChain handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        GsonArray gsonArray = gsonObject.reqArray("chain");
        if (gsonArray.size() != 2) {
            throw new IllegalStateException("Invalid certificate chain length: " + gsonArray.size());
        }
        return new MinecraftCertificateChain(gsonArray.get(0).asString(), gsonArray.get(1).asString());
    }
}

