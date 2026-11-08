/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.data;

import lombok.Generated;

public enum MsaEnvironment {
    LIVE("https://login.live.com/", "oauth20_connect.srf", "oauth20_authorize.srf", "oauth20_token.srf", "oauth20_desktop.srf"),
    MICROSOFT_ONLINE_COMMON("https://login.microsoftonline.com/common/oauth2/", "v2.0/devicecode", "v2.0/authorize", "v2.0/token", "nativeclient"),
    MICROSOFT_ONLINE_CONSUMERS("https://login.microsoftonline.com/consumers/oauth2/", "v2.0/devicecode", "v2.0/authorize", "v2.0/token", "nativeclient");

    private final String baseUrl;
    private final String deviceCodePath;
    private final String authorizePath;
    private final String tokenPath;
    private final String nativeClientPath;

    public String getDeviceCodeUrl() {
        return this.baseUrl + this.deviceCodePath;
    }

    public String getAuthorizeUrl() {
        return this.baseUrl + this.authorizePath;
    }

    public String getTokenUrl() {
        return this.baseUrl + this.tokenPath;
    }

    public String getNativeClientUrl() {
        return this.baseUrl + this.nativeClientPath;
    }

    @Generated
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Generated
    public String getDeviceCodePath() {
        return this.deviceCodePath;
    }

    @Generated
    public String getAuthorizePath() {
        return this.authorizePath;
    }

    @Generated
    public String getTokenPath() {
        return this.tokenPath;
    }

    @Generated
    public String getNativeClientPath() {
        return this.nativeClientPath;
    }

    @Generated
    private MsaEnvironment(String string2, String string3, String string4, String string5, String string6) {
        this.baseUrl = string2;
        this.deviceCodePath = string3;
        this.authorizePath = string4;
        this.tokenPath = string5;
        this.nativeClientPath = string6;
    }
}

