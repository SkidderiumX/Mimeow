/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib;

import com.mojang.authlib.BaseUserAuthentication;
import com.mojang.authlib.HttpAuthenticationService;

public abstract class HttpUserAuthentication
extends BaseUserAuthentication {
    protected HttpUserAuthentication(HttpAuthenticationService httpAuthenticationService) {
        super(httpAuthenticationService);
    }

    @Override
    public HttpAuthenticationService getAuthenticationService() {
        return (HttpAuthenticationService)super.getAuthenticationService();
    }
}

