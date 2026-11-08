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

public class XblXstsToken
implements Expirable {
    private final long expireTimeMs;
    private final String token;
    private final String userHash;

    public static XblXstsToken fromJson(JsonObject jsonObject) {
        return XblXstsToken.fromJson(new GsonObject(jsonObject));
    }

    public static XblXstsToken fromJson(GsonObject gsonObject) {
        return new XblXstsToken(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("token"), gsonObject.reqString("userHash"));
    }

    public static JsonObject toJson(XblXstsToken xblXstsToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", xblXstsToken.expireTimeMs);
        jsonObject.addProperty("token", xblXstsToken.token);
        jsonObject.addProperty("userHash", xblXstsToken.userHash);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static XblXstsToken fromApiJson(GsonObject gsonObject) {
        return new XblXstsToken(Instant.parse(gsonObject.reqString("NotAfter")).toEpochMilli(), gsonObject.reqString("Token"), gsonObject.reqObject("DisplayClaims").reqArray("xui").get(0).asObject().reqString("uhs"));
    }

    public String getAuthorizationHeader() {
        return "XBL3.0 x=" + this.userHash + ';' + this.token;
    }

    @Generated
    public XblXstsToken(long l, String string, String string2) {
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
        if (!(object instanceof XblXstsToken)) {
            return false;
        }
        XblXstsToken xblXstsToken = (XblXstsToken)object;
        if (this.getExpireTimeMs() != xblXstsToken.getExpireTimeMs()) {
            return false;
        }
        String string = this.getToken();
        String string2 = xblXstsToken.getToken();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getUserHash();
        String string4 = xblXstsToken.getUserHash();
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
        return "XblXstsToken(expireTimeMs=" + this.getExpireTimeMs() + ", token=" + this.getToken() + ", userHash=" + this.getUserHash() + ")";
    }
}

