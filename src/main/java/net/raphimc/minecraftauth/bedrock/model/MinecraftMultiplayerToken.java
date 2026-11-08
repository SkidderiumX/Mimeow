/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.model;

import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import net.raphimc.minecraftauth.util.jwt.Jwt;

public class MinecraftMultiplayerToken
implements Expirable {
    private final long expireTimeMs;
    private final String token;
    private final AtomicReference<Object> parsedToken = new AtomicReference();

    public static MinecraftMultiplayerToken fromJson(JsonObject jsonObject) {
        return MinecraftMultiplayerToken.fromJson(new GsonObject(jsonObject));
    }

    public static MinecraftMultiplayerToken fromJson(GsonObject gsonObject) {
        return new MinecraftMultiplayerToken(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("token"));
    }

    public static JsonObject toJson(MinecraftMultiplayerToken minecraftMultiplayerToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", minecraftMultiplayerToken.expireTimeMs);
        jsonObject.addProperty("token", minecraftMultiplayerToken.token);
        return jsonObject;
    }

    public String getDisplayName() {
        return this.getParsedToken().getPayload().reqString("xname");
    }

    public String getXuid() {
        return this.getParsedToken().getPayload().reqString("xid");
    }

    public UUID getUuid() {
        return UUID.nameUUIDFromBytes(("pocket-auth-1-xuid:" + this.getXuid()).getBytes(StandardCharsets.UTF_8));
    }

    @Generated
    public MinecraftMultiplayerToken(long l, String string) {
        this.expireTimeMs = l;
        this.token = string;
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
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftMultiplayerToken)) {
            return false;
        }
        MinecraftMultiplayerToken minecraftMultiplayerToken = (MinecraftMultiplayerToken)object;
        if (this.getExpireTimeMs() != minecraftMultiplayerToken.getExpireTimeMs()) {
            return false;
        }
        String string = this.getToken();
        String string2 = minecraftMultiplayerToken.getToken();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.getToken();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftMultiplayerToken(expireTimeMs=" + this.getExpireTimeMs() + ", token=" + this.getToken() + ")";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public Jwt getParsedToken() {
        Object object = this.parsedToken.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.parsedToken;
            synchronized (atomicReference) {
                object = this.parsedToken.get();
                if (object == null) {
                    Jwt jwt = Jwt.parse(this.token);
                    object = jwt == null ? this.parsedToken : jwt;
                    this.parsedToken.set(object);
                }
            }
        }
        return (Jwt)(object == this.parsedToken ? null : object);
    }
}

