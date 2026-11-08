/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.model;

import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.msa.data.MsaEnvironment;
import net.raphimc.minecraftauth.util.UuidUtil;

public class MsaApplicationConfig {
    private final String clientId;
    private final String scope;
    private final String clientSecret;
    private final String redirectUri;
    private final MsaEnvironment environment;

    public static MsaApplicationConfig fromJson(JsonObject jsonObject) {
        return MsaApplicationConfig.fromJson(new GsonObject(jsonObject));
    }

    public static MsaApplicationConfig fromJson(GsonObject gsonObject) {
        return new MsaApplicationConfig(gsonObject.reqString("clientId"), gsonObject.reqString("scope"), gsonObject.getString("clientSecret", null), gsonObject.getString("redirectUri", null), MsaEnvironment.valueOf(gsonObject.getString("environment", MsaEnvironment.LIVE.name())));
    }

    public static JsonObject toJson(MsaApplicationConfig msaApplicationConfig) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("clientId", msaApplicationConfig.clientId);
        jsonObject.addProperty("scope", msaApplicationConfig.scope);
        jsonObject.addProperty("clientSecret", msaApplicationConfig.clientSecret);
        jsonObject.addProperty("redirectUri", msaApplicationConfig.redirectUri);
        jsonObject.addProperty("environment", msaApplicationConfig.environment.name());
        return jsonObject;
    }

    public MsaApplicationConfig(String string, String string2) {
        this(string, string2, null, null, MsaEnvironment.LIVE);
    }

    public boolean isTitleClientId() {
        return !UuidUtil.isDashedUuid(this.clientId);
    }

    public Map<String, String> getAuthCodeParameters() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("client_id", this.clientId);
        hashMap.put("scope", this.scope);
        if (this.redirectUri != null) {
            hashMap.put("redirect_uri", this.redirectUri);
        }
        hashMap.put("response_type", "code");
        hashMap.put("response_mode", "query");
        return hashMap;
    }

    @Generated
    public String getClientId() {
        return this.clientId;
    }

    @Generated
    public String getScope() {
        return this.scope;
    }

    @Generated
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Generated
    public String getRedirectUri() {
        return this.redirectUri;
    }

    @Generated
    public MsaEnvironment getEnvironment() {
        return this.environment;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MsaApplicationConfig)) {
            return false;
        }
        MsaApplicationConfig msaApplicationConfig = (MsaApplicationConfig)object;
        String string = this.getClientId();
        String string2 = msaApplicationConfig.getClientId();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getScope();
        String string4 = msaApplicationConfig.getScope();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.getClientSecret();
        String string6 = msaApplicationConfig.getClientSecret();
        if (string5 == null ? string6 != null : !string5.equals(string6)) {
            return false;
        }
        String string7 = this.getRedirectUri();
        String string8 = msaApplicationConfig.getRedirectUri();
        if (string7 == null ? string8 != null : !string7.equals(string8)) {
            return false;
        }
        MsaEnvironment msaEnvironment = this.getEnvironment();
        MsaEnvironment msaEnvironment2 = msaApplicationConfig.getEnvironment();
        return !(msaEnvironment == null ? msaEnvironment2 != null : !((Object)((Object)msaEnvironment)).equals((Object)msaEnvironment2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getClientId();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getScope();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.getClientSecret();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        String string4 = this.getRedirectUri();
        n2 = n2 * 59 + (string4 == null ? 43 : string4.hashCode());
        MsaEnvironment msaEnvironment = this.getEnvironment();
        n2 = n2 * 59 + (msaEnvironment == null ? 43 : ((Object)((Object)msaEnvironment)).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaApplicationConfig(clientId=" + this.getClientId() + ", scope=" + this.getScope() + ", clientSecret=" + this.getClientSecret() + ", redirectUri=" + this.getRedirectUri() + ", environment=" + (Object)((Object)this.getEnvironment()) + ")";
    }

    @Generated
    public MsaApplicationConfig withClientId(String string) {
        return this.clientId == string ? this : new MsaApplicationConfig(string, this.scope, this.clientSecret, this.redirectUri, this.environment);
    }

    @Generated
    public MsaApplicationConfig withScope(String string) {
        return this.scope == string ? this : new MsaApplicationConfig(this.clientId, string, this.clientSecret, this.redirectUri, this.environment);
    }

    @Generated
    public MsaApplicationConfig withClientSecret(String string) {
        return this.clientSecret == string ? this : new MsaApplicationConfig(this.clientId, this.scope, string, this.redirectUri, this.environment);
    }

    @Generated
    public MsaApplicationConfig withRedirectUri(String string) {
        return this.redirectUri == string ? this : new MsaApplicationConfig(this.clientId, this.scope, this.clientSecret, string, this.environment);
    }

    @Generated
    public MsaApplicationConfig withEnvironment(MsaEnvironment msaEnvironment) {
        return this.environment == msaEnvironment ? this : new MsaApplicationConfig(this.clientId, this.scope, this.clientSecret, this.redirectUri, msaEnvironment);
    }

    @Generated
    public MsaApplicationConfig(String string, String string2, String string3, String string4, MsaEnvironment msaEnvironment) {
        this.clientId = string;
        this.scope = string2;
        this.clientSecret = string3;
        this.redirectUri = string4;
        this.environment = msaEnvironment;
    }
}

