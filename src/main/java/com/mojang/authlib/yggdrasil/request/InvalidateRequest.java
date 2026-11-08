/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.request;

import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

public class InvalidateRequest {
    private String accessToken;
    private String clientToken;

    public InvalidateRequest(YggdrasilUserAuthentication yggdrasilUserAuthentication) {
        this.accessToken = yggdrasilUserAuthentication.getAuthenticatedToken();
        this.clientToken = yggdrasilUserAuthentication.getAuthenticationService().getClientToken();
    }
}

