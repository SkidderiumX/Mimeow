/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.service.impl;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.requests.HttpRequest;
import net.raphimc.minecraftauth.extra.realms.model.RealmsJoinInformation;
import net.raphimc.minecraftauth.extra.realms.model.RealmsServer;
import net.raphimc.minecraftauth.extra.realms.request.BedrockRealmsInviteDeleteRequest;
import net.raphimc.minecraftauth.extra.realms.request.BedrockRealmsInviteLinkAcceptRequest;
import net.raphimc.minecraftauth.extra.realms.request.BedrockRealmsWorldJoinRequest;
import net.raphimc.minecraftauth.extra.realms.service.RealmsService;
import net.raphimc.minecraftauth.util.holder.Holder;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;

public class BedrockRealmsService
extends RealmsService {
    private final Holder<XblXstsToken> xstsToken;
    private final String gameVersion;

    public BedrockRealmsService(HttpClient httpClient, String string, Holder<XblXstsToken> holder) {
        super(httpClient, "pocket.realms.minecraft.net");
        this.xstsToken = holder;
        this.gameVersion = string;
    }

    public RealmsServer acceptInvite(String string) throws IOException {
        return (RealmsServer)this.httpClient.executeAndHandle(this.authorizeRequest(new BedrockRealmsInviteLinkAcceptRequest(string)));
    }

    public RealmsServer acceptInviteUnchecked(String string) {
        return this.acceptInvite(string);
    }

    public CompletableFuture<RealmsServer> acceptInviteAsync(String string) {
        return CompletableFuture.supplyAsync(() -> this.acceptInviteUnchecked(string));
    }

    public void leaveInvitedRealm(RealmsServer realmsServer) throws IOException {
        this.httpClient.executeAndHandle(this.authorizeRequest(new BedrockRealmsInviteDeleteRequest(realmsServer)));
    }

    public void leaveInvitedRealmUnchecked(RealmsServer realmsServer) {
        this.leaveInvitedRealm(realmsServer);
    }

    public CompletableFuture<Void> leaveInvitedRealmAsync(RealmsServer realmsServer) {
        return CompletableFuture.runAsync(() -> this.leaveInvitedRealmUnchecked(realmsServer));
    }

    @Override
    public RealmsJoinInformation joinWorld(RealmsServer realmsServer) throws IOException {
        return (RealmsJoinInformation)this.httpClient.executeAndHandle(this.authorizeRequest(new BedrockRealmsWorldJoinRequest(realmsServer)));
    }

    @Override
    protected <T extends HttpRequest> T authorizeRequest(T t) throws IOException {
        t.setHeader("Authorization", this.xstsToken.getUpToDate().getAuthorizationHeader());
        t.setHeader("Client-Version", this.gameVersion);
        return t;
    }
}

