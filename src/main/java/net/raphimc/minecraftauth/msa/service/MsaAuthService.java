/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import lombok.Generated;
import net.lenni0451.commons.httpclient.HttpClient;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaToken;

public abstract class MsaAuthService {
    protected final HttpClient httpClient;
    protected final MsaApplicationConfig applicationConfig;

    public MsaAuthService(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig) {
        this.httpClient = httpClient;
        this.applicationConfig = msaApplicationConfig;
    }

    public abstract MsaToken acquireToken() throws IOException, InterruptedException, TimeoutException;

    public MsaToken acquireTokenUnchecked() {
        return this.acquireToken();
    }

    public CompletableFuture<MsaToken> acquireTokenAsync() {
        return CompletableFuture.supplyAsync(this::acquireTokenUnchecked);
    }

    @Generated
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @Generated
    public MsaApplicationConfig getApplicationConfig() {
        return this.applicationConfig;
    }
}

