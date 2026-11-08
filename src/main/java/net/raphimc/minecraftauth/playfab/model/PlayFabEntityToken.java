/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.playfab.model;

import com.google.gson.JsonObject;
import java.time.Instant;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import org.jetbrains.annotations.ApiStatus;

public class PlayFabEntityToken
implements Expirable {
    private final long expireTimeMs;
    private final String token;
    private final String entityId;
    private final String entityType;

    public static PlayFabEntityToken fromJson(JsonObject jsonObject) {
        return PlayFabEntityToken.fromJson(new GsonObject(jsonObject));
    }

    public static PlayFabEntityToken fromJson(GsonObject gsonObject) {
        return new PlayFabEntityToken(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("token"), gsonObject.reqString("entityId"), gsonObject.reqString("entityType"));
    }

    public static JsonObject toJson(PlayFabEntityToken playFabEntityToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", playFabEntityToken.expireTimeMs);
        jsonObject.addProperty("token", playFabEntityToken.token);
        jsonObject.addProperty("entityId", playFabEntityToken.entityId);
        jsonObject.addProperty("entityType", playFabEntityToken.entityType);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static PlayFabEntityToken fromApiJson(GsonObject gsonObject) {
        GsonObject gsonObject2 = gsonObject.reqObject("Entity");
        return new PlayFabEntityToken(Instant.parse(gsonObject.reqString("TokenExpiration")).toEpochMilli(), gsonObject.reqString("EntityToken"), gsonObject2.reqString("Id"), gsonObject2.reqString("Type"));
    }

    @Generated
    public PlayFabEntityToken(long l, String string, String string2, String string3) {
        this.expireTimeMs = l;
        this.token = string;
        this.entityId = string2;
        this.entityType = string3;
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
    public String getEntityId() {
        return this.entityId;
    }

    @Generated
    public String getEntityType() {
        return this.entityType;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PlayFabEntityToken)) {
            return false;
        }
        PlayFabEntityToken playFabEntityToken = (PlayFabEntityToken)object;
        if (this.getExpireTimeMs() != playFabEntityToken.getExpireTimeMs()) {
            return false;
        }
        String string = this.getToken();
        String string2 = playFabEntityToken.getToken();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getEntityId();
        String string4 = playFabEntityToken.getEntityId();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.getEntityType();
        String string6 = playFabEntityToken.getEntityType();
        return !(string5 == null ? string6 != null : !string5.equals(string6));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.getToken();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getEntityId();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.getEntityType();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "PlayFabEntityToken(expireTimeMs=" + this.getExpireTimeMs() + ", token=" + this.getToken() + ", entityId=" + this.getEntityId() + ", entityType=" + this.getEntityType() + ")";
    }
}

