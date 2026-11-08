/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.model;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;

public class MinecraftToken
implements Expirable {
    private final long expireTimeMs;
    private final String type;
    private final String token;

    public static MinecraftToken fromJson(JsonObject jsonObject) {
        return MinecraftToken.fromJson(new GsonObject(jsonObject));
    }

    public static MinecraftToken fromJson(GsonObject gsonObject) {
        return new MinecraftToken(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("type"), gsonObject.reqString("token"));
    }

    public static JsonObject toJson(MinecraftToken minecraftToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", minecraftToken.expireTimeMs);
        jsonObject.addProperty("type", minecraftToken.type);
        jsonObject.addProperty("token", minecraftToken.token);
        return jsonObject;
    }

    public String getAuthorizationHeader() {
        return this.type + ' ' + this.token;
    }

    @Generated
    public MinecraftToken(long l, String string, String string2) {
        this.expireTimeMs = l;
        this.type = string;
        this.token = string2;
    }

    @Override
    @Generated
    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    @Generated
    public String getType() {
        return this.type;
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftToken)) {
            return false;
        }
        MinecraftToken minecraftToken = (MinecraftToken)object;
        if (this.getExpireTimeMs() != minecraftToken.getExpireTimeMs()) {
            return false;
        }
        String string = this.getType();
        String string2 = minecraftToken.getType();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getToken();
        String string4 = minecraftToken.getToken();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.getType();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getToken();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftToken(expireTimeMs=" + this.getExpireTimeMs() + ", type=" + this.getType() + ", token=" + this.getToken() + ")";
    }
}

