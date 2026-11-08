/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.model;

import com.google.gson.JsonObject;
import java.time.Instant;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import org.jetbrains.annotations.ApiStatus;

public class XblUserToken
implements Expirable {
    private final long expireTimeMs;
    private final String token;
    private final String userHash;

    public static XblUserToken fromJson(JsonObject jsonObject) {
        return XblUserToken.fromJson(new GsonObject(jsonObject));
    }

    public static XblUserToken fromJson(GsonObject gsonObject) {
        return new XblUserToken(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("token"), gsonObject.reqString("userHash"));
    }

    public static JsonObject toJson(XblUserToken xblUserToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", xblUserToken.expireTimeMs);
        jsonObject.addProperty("token", xblUserToken.token);
        jsonObject.addProperty("userHash", xblUserToken.userHash);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static XblUserToken fromApiJson(GsonObject gsonObject) {
        return new XblUserToken(Instant.parse(gsonObject.reqString("NotAfter")).toEpochMilli(), gsonObject.reqString("Token"), gsonObject.reqObject("DisplayClaims").reqArray("xui").get(0).asObject().reqString("uhs"));
    }

    @Generated
    public XblUserToken(long l, String string, String string2) {
        this.expireTimeMs = l;
        this.token = string;
        this.userHash = string2;
    }

    @Override
    @Generated
    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public String getUserHash() {
        return this.userHash;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XblUserToken)) {
            return false;
        }
        XblUserToken xblUserToken = (XblUserToken)object;
        if (this.getExpireTimeMs() != xblUserToken.getExpireTimeMs()) {
            return false;
        }
        String string = this.getToken();
        String string2 = xblUserToken.getToken();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getUserHash();
        String string4 = xblUserToken.getUserHash();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.getToken();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getUserHash();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblUserToken(expireTimeMs=" + this.getExpireTimeMs() + ", token=" + this.getToken() + ", userHash=" + this.getUserHash() + ")";
    }
}

