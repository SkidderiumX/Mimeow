/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import lombok.Generated;
import net.lenni0451.commons.gson.GsonParser;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;

public class Jwt
implements Expirable {
    private final GsonObject header;
    private final GsonObject payload;
    private final byte[] signature;

    public static Jwt parse(String string) {
        if (string == null) {
            throw new IllegalArgumentException("JWT string is null");
        }
        String[] stringArray = string.split("\\.");
        if (stringArray.length < 2) {
            throw new IllegalArgumentException("JWT must have at least header and payload");
        }
        GsonObject gsonObject = GsonParser.parse(new String(Base64.getUrlDecoder().decode(stringArray[0]), StandardCharsets.UTF_8)).asObject();
        GsonObject gsonObject2 = GsonParser.parse(new String(Base64.getUrlDecoder().decode(stringArray[1]), StandardCharsets.UTF_8)).asObject();
        byte[] byArray = stringArray.length > 2 ? Base64.getUrlDecoder().decode(stringArray[2]) : null;
        return new Jwt(gsonObject, gsonObject2, byArray);
    }

    @Override
    public long getExpireTimeMs() {
        if (this.payload.hasNumber("exp")) {
            return this.payload.reqLong("exp") * 1000L;
        }
        return Long.MAX_VALUE;
    }

    @Generated
    public Jwt(GsonObject gsonObject, GsonObject gsonObject2, byte[] byArray) {
        this.header = gsonObject;
        this.payload = gsonObject2;
        this.signature = byArray;
    }

    @Generated
    public GsonObject getHeader() {
        return this.header;
    }

    @Generated
    public GsonObject getPayload() {
        return this.payload;
    }

    @Generated
    public byte[] getSignature() {
        return this.signature;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Jwt)) {
            return false;
        }
        Jwt jwt = (Jwt)object;
        GsonObject gsonObject = this.getHeader();
        GsonObject gsonObject2 = jwt.getHeader();
        if (gsonObject == null ? gsonObject2 != null : !((Object)gsonObject).equals(gsonObject2)) {
            return false;
        }
        GsonObject gsonObject3 = this.getPayload();
        GsonObject gsonObject4 = jwt.getPayload();
        if (gsonObject3 == null ? gsonObject4 != null : !((Object)gsonObject3).equals(gsonObject4)) {
            return false;
        }
        return Arrays.equals(this.getSignature(), jwt.getSignature());
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        GsonObject gsonObject = this.getHeader();
        n2 = n2 * 59 + (gsonObject == null ? 43 : ((Object)gsonObject).hashCode());
        GsonObject gsonObject2 = this.getPayload();
        n2 = n2 * 59 + (gsonObject2 == null ? 43 : ((Object)gsonObject2).hashCode());
        n2 = n2 * 59 + Arrays.hashCode(this.getSignature());
        return n2;
    }

    @Generated
    public String toString() {
        return "Jwt(header=" + this.getHeader() + ", payload=" + this.getPayload() + ", signature=" + Arrays.toString(this.getSignature()) + ")";
    }
}

