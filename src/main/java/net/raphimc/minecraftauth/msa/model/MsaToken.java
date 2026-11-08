/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.model;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;

public class MsaToken
implements Expirable {
    private final long expireTimeMs;
    private final String accessToken;
    private final String refreshToken;

    public static MsaToken fromJson(JsonObject jsonObject) {
        return MsaToken.fromJson(new GsonObject(jsonObject));
    }

    public static MsaToken fromJson(GsonObject gsonObject) {
        return new MsaToken(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("accessToken"), gsonObject.getString("refreshToken", null));
    }

    public static JsonObject toJson(MsaToken msaToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", msaToken.expireTimeMs);
        jsonObject.addProperty("accessToken", msaToken.accessToken);
        jsonObject.addProperty("refreshToken", msaToken.refreshToken);
        return jsonObject;
    }

    @Generated
    public MsaToken(long l, String string, String string2) {
        this.expireTimeMs = l;
        this.accessToken = string;
        this.refreshToken = string2;
    }

    @Override
    @Generated
    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    @Generated
    public String getAccessToken() {
        return this.accessToken;
    }

    @Generated
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MsaToken)) {
            return false;
        }
        MsaToken msaToken = (MsaToken)object;
        if (this.getExpireTimeMs() != msaToken.getExpireTimeMs()) {
            return false;
        }
        String string = this.getAccessToken();
        String string2 = msaToken.getAccessToken();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getRefreshToken();
        String string4 = msaToken.getRefreshToken();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.getAccessToken();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getRefreshToken();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaToken(expireTimeMs=" + this.getExpireTimeMs() + ", accessToken=" + this.getAccessToken() + ", refreshToken=" + this.getRefreshToken() + ")";
    }
}

