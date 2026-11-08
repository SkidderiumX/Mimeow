/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.service.impl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import net.lenni0451.commons.httpclient.HttpClient;
import net.raphimc.minecraftauth.msa.exception.MsaRequestException;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaDeviceCode;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.msa.request.MsaDeviceCodeRequest;
import net.raphimc.minecraftauth.msa.request.MsaDeviceCodeTokenRequest;
import net.raphimc.minecraftauth.msa.service.MsaAuthService;

public class DeviceCodeMsaAuthService
extends MsaAuthService {
    private final Consumer<MsaDeviceCode> callback;
    private final int timeoutMs;

    public DeviceCodeMsaAuthService(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig, Consumer<MsaDeviceCode> consumer) {
        this(httpClient, msaApplicationConfig, consumer, 300000);
    }

    public DeviceCodeMsaAuthService(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig, Consumer<MsaDeviceCode> consumer, int n) {
        super(httpClient, msaApplicationConfig);
        this.callback = consumer;
        this.timeoutMs = n;
    }

    @Override
    public MsaToken acquireToken() throws IOException, InterruptedException, TimeoutException {
        MsaDeviceCode msaDeviceCode = this.requestDeviceCode();
        this.callback.accept(msaDeviceCode);
        return this.getToken(msaDeviceCode);
    }

    public MsaDeviceCode requestDeviceCode() throws IOException {
        return (MsaDeviceCode)this.httpClient.executeAndHandle(new MsaDeviceCodeRequest(this.applicationConfig));
    }

    public MsaToken getToken(MsaDeviceCode msaDeviceCode) throws IOException, InterruptedException, TimeoutException {
        long l = System.currentTimeMillis();
        while (!msaDeviceCode.isExpired() && System.currentTimeMillis() - l <= (long)this.timeoutMs) {
            try {
                return (MsaToken)this.httpClient.executeAndHandle(new MsaDeviceCodeTokenRequest(this.applicationConfig, msaDeviceCode));
            }
            catch (MsaRequestException msaRequestException) {
                if (msaRequestException.getResponse().getStatusCode() == 400 && msaRequestException.getError().equals("authorization_pending")) {
                    Thread.sleep(msaDeviceCode.getIntervalMs());
                    continue;
                }
                throw msaRequestException;
            }
        }
        throw new TimeoutException("Login timed out");
    }
}

