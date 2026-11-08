/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.request;

import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

public class ValidateRequest {
    private String clientToken;
    private String accessToken;

    public ValidateRequest(YggdrasilUserAuthentication yggdrasilUserAuthentication) {
        this.clientToken = yggdrasilUserAuthentication.getAuthenticationService().getClientToken();
        this.accessToken = yggdrasilUserAuthentication.getAuthenticatedToken();
    }
}

