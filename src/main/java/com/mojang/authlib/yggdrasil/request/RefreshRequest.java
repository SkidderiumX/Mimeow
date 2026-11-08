/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.request;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

public class RefreshRequest {
    private String clientToken;
    private String accessToken;
    private GameProfile selectedProfile;
    private boolean requestUser = true;

    public RefreshRequest(YggdrasilUserAuthentication yggdrasilUserAuthentication) {
        this(yggdrasilUserAuthentication, null);
    }

    public RefreshRequest(YggdrasilUserAuthentication yggdrasilUserAuthentication, GameProfile gameProfile) {
        this.clientToken = yggdrasilUserAuthentication.getAuthenticationService().getClientToken();
        this.accessToken = yggdrasilUserAuthentication.getAuthenticatedToken();
        this.selectedProfile = gameProfile;
    }
}

