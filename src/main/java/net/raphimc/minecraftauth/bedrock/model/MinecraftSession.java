/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.model;

import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import net.raphimc.minecraftauth.util.jwt.Jwt;

public class MinecraftSession
implements Expirable {
    private final long expireTimeMs;
    private final String authorizationHeader;
    private final AtomicReference<Object> parsedToken = new AtomicReference();

    public static MinecraftSession fromJson(JsonObject jsonObject) {
        return MinecraftSession.fromJson(new GsonObject(jsonObject));
    }

    public static MinecraftSession fromJson(GsonObject gsonObject) {
        return new MinecraftSession(gsonObject.reqLong("expireTimeMs"), gsonObject.reqString("authorizationHeader"));
    }

    public static JsonObject toJson(MinecraftSession minecraftSession) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", minecraftSession.expireTimeMs);
        jsonObject.addProperty("authorizationHeader", minecraftSession.authorizationHeader);
        return jsonObject;
    }

    @Generated
    public MinecraftSession(long l, String string) {
        this.expireTimeMs = l;
        this.authorizationHeader = string;
    }

    @Override
    @Generated
    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    @Generated
    public String getAuthorizationHeader() {
        return this.authorizationHeader;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftSession)) {
            return false;
        }
        MinecraftSession minecraftSession = (MinecraftSession)object;
        if (this.getExpireTimeMs() != minecraftSession.getExpireTimeMs()) {
            return false;
        }
        String string = this.getAuthorizationHeader();
        String string2 = minecraftSession.getAuthorizationHeader();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.getAuthorizationHeader();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftSession(expireTimeMs=" + this.getExpireTimeMs() + ", authorizationHeader=" + this.getAuthorizationHeader() + ")";
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
                    Jwt jwt = Jwt.parse(this.authorizationHeader.split(" ", 2)[1]);
                    object = jwt == null ? this.parsedToken : jwt;
                    this.parsedToken.set(object);
                }
            }
        }
        return (Jwt)(object == this.parsedToken ? null : object);
    }
}

