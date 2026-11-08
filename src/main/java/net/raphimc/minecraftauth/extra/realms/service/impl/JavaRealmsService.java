/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.service.impl;

import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.concurrent.CompletableFuture;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.requests.HttpRequest;
import net.raphimc.minecraftauth.extra.realms.model.RealmsJoinInformation;
import net.raphimc.minecraftauth.extra.realms.model.RealmsServer;
import net.raphimc.minecraftauth.extra.realms.request.JavaRealmsTosAgreedRequest;
import net.raphimc.minecraftauth.extra.realms.request.JavaRealmsWorldJoinRequest;
import net.raphimc.minecraftauth.extra.realms.service.RealmsService;
import net.raphimc.minecraftauth.java.model.MinecraftProfile;
import net.raphimc.minecraftauth.java.model.MinecraftToken;
import net.raphimc.minecraftauth.util.UuidUtil;
import net.raphimc.minecraftauth.util.holder.Holder;

public class JavaRealmsService
extends RealmsService {
    private final Holder<MinecraftToken> token;
    private final Holder<MinecraftProfile> profile;
    private final String gameVersion;

    public JavaRealmsService(HttpClient httpClient, String string, Holder<MinecraftToken> holder, Holder<MinecraftProfile> holder2) {
        super(httpClient, "pc.realms.minecraft.net");
        this.token = holder;
        this.profile = holder2;
        this.gameVersion = string;
    }

    @Override
    public RealmsJoinInformation joinWorld(RealmsServer realmsServer) throws IOException {
        return (RealmsJoinInformation)this.httpClient.executeAndHandle(this.authorizeRequest(new JavaRealmsWorldJoinRequest(realmsServer)));
    }

    public void acceptTos() throws IOException {
        this.httpClient.executeAndHandle(this.authorizeRequest(new JavaRealmsTosAgreedRequest()));
    }

    public void acceptTosUnchecked() {
        this.acceptTos();
    }

    public CompletableFuture<Void> acceptTosAsync() {
        return CompletableFuture.runAsync(this::acceptTosUnchecked);
    }

    @Override
    protected <T extends HttpRequest> T authorizeRequest(T t) throws IOException {
        CookieManager cookieManager = new CookieManager();
        MinecraftProfile minecraftProfile = this.profile.getUpToDate();
        cookieManager.getCookieStore().add(null, this.createCookie("sid", "token:" + this.token.getUpToDate().getToken() + ':' + UuidUtil.toUndashedString(minecraftProfile.getId())));
        cookieManager.getCookieStore().add(null, this.createCookie("user", minecraftProfile.getName()));
        cookieManager.getCookieStore().add(null, this.createCookie("version", this.gameVersion));
        t.setCookieManager(cookieManager);
        t.setHeader("Is-Prerelease", String.valueOf(!this.gameVersion.matches("\\d+\\.\\d+(\\.\\d+)?")));
        return t;
    }

    private HttpCookie createCookie(String string, String string2) {
        HttpCookie httpCookie = new HttpCookie(string, string2);
        httpCookie.setDomain(this.host);
        httpCookie.setPath("/");
        return httpCookie;
    }
}

