/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.request;

import java.net.MalformedURLException;
import java.util.HashMap;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.content.impl.URLEncodedFormContent;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaDeviceCode;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.msa.responsehandler.MsaResponseHandler;

public class MsaDeviceCodeTokenRequest
extends PostRequest
implements MsaResponseHandler<MsaToken> {
    public MsaDeviceCodeTokenRequest(MsaApplicationConfig msaApplicationConfig, MsaDeviceCode msaDeviceCode) throws MalformedURLException {
        this(msaApplicationConfig, msaDeviceCode.getDeviceCode());
    }

    public MsaDeviceCodeTokenRequest(MsaApplicationConfig msaApplicationConfig, String string) throws MalformedURLException {
        super(msaApplicationConfig.getEnvironment().getTokenUrl());
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("client_id", msaApplicationConfig.getClientId());
        hashMap.put("grant_type", "device_code");
        hashMap.put("device_code", string);
        this.setContent(new URLEncodedFormContent(hashMap));
    }

    @Override
    public MsaToken handle(HttpResponse httpResponse, GsonObject gsonObject) {
        return new MsaToken(System.currentTimeMillis() + (long)gsonObject.reqInt("expires_in") * 1000L, gsonObject.reqString("access_token"), gsonObject.getString("refresh_token", null));
    }
}

