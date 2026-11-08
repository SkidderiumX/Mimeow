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

public class XblTitleToken
implements Expirable {
    private final long expireTimeMs;
    private final String token;
    private final String titleId;

    public static XblTitleToken fromJson(JsonObject jsonObject) {
        return XblTitleToken.fromJson(new GsonObject(jsonObject));
    }

    public static XblTitleToken fromJson(GsonObject gsonObject) {
        return new XblTitleToken(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("token"), gsonObject.reqString("titleId"));
    }

    public static JsonObject toJson(XblTitleToken xblTitleToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", xblTitleToken.expireTimeMs);
        jsonObject.addProperty("token", xblTitleToken.token);
        jsonObject.addProperty("titleId", xblTitleToken.titleId);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static XblTitleToken fromApiJson(GsonObject gsonObject) {
        return new XblTitleToken(Instant.parse(gsonObject.reqString("NotAfter")).toEpochMilli(), gsonObject.reqString("Token"), gsonObject.reqObject("DisplayClaims").reqObject("xti").reqString("tid"));
    }

    @Generated
    public XblTitleToken(long l, String string, String string2) {
        this.expireTimeMs = l;
        this.token = string;
        this.titleId = string2;
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
    public String getTitleId() {
        return this.titleId;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XblTitleToken)) {
            return false;
        }
        XblTitleToken xblTitleToken = (XblTitleToken)object;
        if (this.getExpireTimeMs() != xblTitleToken.getExpireTimeMs()) {
            return false;
        }
        String string = this.getToken();
        String string2 = xblTitleToken.getToken();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getTitleId();
        String string4 = xblTitleToken.getTitleId();
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
        String string2 = this.getTitleId();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblTitleToken(expireTimeMs=" + this.getExpireTimeMs() + ", token=" + this.getToken() + ", titleId=" + this.getTitleId() + ")";
    }
}

