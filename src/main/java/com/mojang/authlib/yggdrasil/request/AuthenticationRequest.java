/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.request;

import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

public class AuthenticationRequest {
    private Agent agent;
    private String username;
    private String password;
    private String clientToken;
    private boolean requestUser = true;

    public AuthenticationRequest(YggdrasilUserAuthentication yggdrasilUserAuthentication, String string, String string2) {
        this.agent = yggdrasilUserAuthentication.getAgent();
        this.username = string;
        this.clientToken = yggdrasilUserAuthentication.getAuthenticationService().getClientToken();
        this.password = string2;
    }
}

