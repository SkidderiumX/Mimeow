/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.request;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.time.Instant;
import java.util.Base64;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.java.model.MinecraftPlayerCertificates;
import net.raphimc.minecraftauth.java.model.MinecraftToken;
import net.raphimc.minecraftauth.java.responsehandler.MinecraftServicesResponseHandler;
import net.raphimc.minecraftauth.util.CryptUtil;

public class MinecraftPlayerCertificatesRequest
extends PostRequest
implements MinecraftServicesResponseHandler<MinecraftPlayerCertificates> {
    public MinecraftPlayerCertificatesRequest(MinecraftToken minecraftToken) throws MalformedURLException {
        super("https://api.minecraftservices.com/player/certificates");
        this.setHeader("Authorization", minecraftToken.getAuthorizationHeader());
    }

    @Override
    public MinecraftPlayerCertificates handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        GsonObject gsonObject2 = gsonObject.reqObject("keyPair");
        return new MinecraftPlayerCertificates(Instant.parse(gsonObject.reqString("expiresAt")).toEpochMilli(), new KeyPair(CryptUtil.rsaPublicKeyFromBytes(Base64.getMimeDecoder().decode(gsonObject2.reqString("publicKey").replace("-----BEGIN RSA PUBLIC KEY-----", "").replace("-----END RSA PUBLIC KEY-----", ""))), CryptUtil.rsaPrivateKeyFromBytes(Base64.getMimeDecoder().decode(gsonObject2.reqString("privateKey").replace("-----BEGIN RSA PRIVATE KEY-----", "").replace("-----END RSA PRIVATE KEY-----", "")))), Base64.getDecoder().decode(gsonObject.reqString("publicKeySignatureV2")), gsonObject.optString("publicKeySignature").map(Base64.getDecoder()::decode).orElse(null));
    }
}

