/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.requests.HttpRequest;
import net.raphimc.minecraftauth.extra.realms.model.RealmsJoinInformation;
import net.raphimc.minecraftauth.extra.realms.model.RealmsServer;
import net.raphimc.minecraftauth.extra.realms.request.RealmsClientCompatibleRequest;
import net.raphimc.minecraftauth.extra.realms.request.RealmsWorldsRequest;

public abstract class RealmsService {
    protected final HttpClient httpClient;
    protected final String host;

    public RealmsService(HttpClient httpClient, String string) {
        this.httpClient = httpClient;
        this.host = string;
    }

    public boolean isCompatible() throws IOException {
        String string = (String)this.httpClient.executeAndHandle(this.authorizeRequest(new RealmsClientCompatibleRequest(this.host)));
        return string.equals("COMPATIBLE");
    }

    public boolean isCompatibleUnchecked() {
        return this.isCompatible();
    }

    public CompletableFuture<Boolean> isCompatibleAsync() {
        return CompletableFuture.supplyAsync(this::isCompatibleUnchecked);
    }

    public List<RealmsServer> getWorlds() throws IOException {
        return (List)this.httpClient.executeAndHandle(this.authorizeRequest(new RealmsWorldsRequest(this.host)));
    }

    public List<RealmsServer> getWorldsUnchecked() {
        return this.getWorlds();
    }

    public CompletableFuture<List<RealmsServer>> getWorldsAsync() {
        return CompletableFuture.supplyAsync(this::getWorldsUnchecked);
    }

    public abstract RealmsJoinInformation joinWorld(RealmsServer var1) throws IOException;

    public RealmsJoinInformation joinWorldUnchecked(RealmsServer realmsServer) {
        return this.joinWorld(realmsServer);
    }

    public CompletableFuture<RealmsJoinInformation> joinWorldAsync(RealmsServer realmsServer) {
        return CompletableFuture.supplyAsync(() -> this.joinWorldUnchecked(realmsServer));
    }

    protected abstract <T extends HttpRequest> T authorizeRequest(T var1) throws IOException;

    @Generated
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @Generated
    public String getHost() {
        return this.host;
    }
}

