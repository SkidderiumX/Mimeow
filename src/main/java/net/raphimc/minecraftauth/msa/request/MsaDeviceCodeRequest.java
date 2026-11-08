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
import net.raphimc.minecraftauth.msa.data.MsaEnvironment;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaDeviceCode;
import net.raphimc.minecraftauth.msa.responsehandler.MsaResponseHandler;

public class MsaDeviceCodeRequest
extends PostRequest
implements MsaResponseHandler<MsaDeviceCode> {
    public MsaDeviceCodeRequest(MsaApplicationConfig msaApplicationConfig) throws MalformedURLException {
        super(msaApplicationConfig.getEnvironment().getDeviceCodeUrl());
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("client_id", msaApplicationConfig.getClientId());
        hashMap.put("scope", msaApplicationConfig.getScope());
        if (msaApplicationConfig.getEnvironment() == MsaEnvironment.LIVE) {
            hashMap.put("response_type", "device_code");
        }
        this.setContent(new URLEncodedFormContent(hashMap));
    }

    @Override
    public MsaDeviceCode handle(HttpResponse httpResponse, GsonObject gsonObject) {
        return new MsaDeviceCode(System.currentTimeMillis() + (long)gsonObject.reqInt("expires_in") * 1000L, (long)gsonObject.reqInt("interval") * 1000L, gsonObject.reqString("device_code"), gsonObject.reqString("user_code"), gsonObject.reqString("verification_uri"));
    }
}

