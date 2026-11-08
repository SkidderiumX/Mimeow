/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.model;

import com.google.gson.JsonObject;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.Base64;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import net.raphimc.minecraftauth.util.JsonUtil;

public class MinecraftPlayerCertificates
implements Expirable {
    private final long expireTimeMs;
    private final KeyPair keyPair;
    private final byte[] publicKeySignature;
    private final byte[] legacyPublicKeySignature;

    public static MinecraftPlayerCertificates fromJson(JsonObject jsonObject) {
        return MinecraftPlayerCertificates.fromJson(new GsonObject(jsonObject));
    }

    public static MinecraftPlayerCertificates fromJson(GsonObject gsonObject) {
        return new MinecraftPlayerCertificates(gsonObject.reqLong("expireTimeMs"), JsonUtil.decodeKeyPair(gsonObject.reqObject("keyPair")), Base64.getDecoder().decode(gsonObject.reqString("publicKeySignature")), gsonObject.optString("legacyPublicKeySignature").map(Base64.getDecoder()::decode).orElse(null));
    }

    public static JsonObject toJson(MinecraftPlayerCertificates minecraftPlayerCertificates) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", minecraftPlayerCertificates.expireTimeMs);
        jsonObject.add("keyPair", JsonUtil.encodeKeyPair(minecraftPlayerCertificates.keyPair));
        jsonObject.addProperty("publicKeySignature", Base64.getEncoder().encodeToString(minecraftPlayerCertificates.publicKeySignature));
        if (minecraftPlayerCertificates.legacyPublicKeySignature != null) {
            jsonObject.addProperty("legacyPublicKeySignature", Base64.getEncoder().encodeToString(minecraftPlayerCertificates.legacyPublicKeySignature));
        }
        return jsonObject;
    }

    @Generated
    public MinecraftPlayerCertificates(long l, KeyPair keyPair, byte[] byArray, byte[] byArray2) {
        this.expireTimeMs = l;
        this.keyPair = keyPair;
        this.publicKeySignature = byArray;
        this.legacyPublicKeySignature = byArray2;
    }

    @Override
    @Generated
    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    @Generated
    public KeyPair getKeyPair() {
        return this.keyPair;
    }

    @Generated
    public byte[] getPublicKeySignature() {
        return this.publicKeySignature;
    }

    @Generated
    public byte[] getLegacyPublicKeySignature() {
        return this.legacyPublicKeySignature;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftPlayerCertificates)) {
            return false;
        }
        MinecraftPlayerCertificates minecraftPlayerCertificates = (MinecraftPlayerCertificates)object;
        if (this.getExpireTimeMs() != minecraftPlayerCertificates.getExpireTimeMs()) {
            return false;
        }
        KeyPair keyPair = this.getKeyPair();
        KeyPair keyPair2 = minecraftPlayerCertificates.getKeyPair();
        if (keyPair == null ? keyPair2 != null : !keyPair.equals(keyPair2)) {
            return false;
        }
        if (!Arrays.equals(this.getPublicKeySignature(), minecraftPlayerCertificates.getPublicKeySignature())) {
            return false;
        }
        return Arrays.equals(this.getLegacyPublicKeySignature(), minecraftPlayerCertificates.getLegacyPublicKeySignature());
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        KeyPair keyPair = this.getKeyPair();
        n2 = n2 * 59 + (keyPair == null ? 43 : keyPair.hashCode());
        n2 = n2 * 59 + Arrays.hashCode(this.getPublicKeySignature());
        n2 = n2 * 59 + Arrays.hashCode(this.getLegacyPublicKeySignature());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftPlayerCertificates(expireTimeMs=" + this.getExpireTimeMs() + ", keyPair=" + this.getKeyPair() + ", publicKeySignature=" + Arrays.toString(this.getPublicKeySignature()) + ", legacyPublicKeySignature=" + Arrays.toString(this.getLegacyPublicKeySignature()) + ")";
    }
}

