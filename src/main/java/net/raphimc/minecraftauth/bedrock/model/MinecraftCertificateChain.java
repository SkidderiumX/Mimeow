/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.model;

import com.google.gson.JsonObject;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import net.raphimc.minecraftauth.util.jwt.Jwt;

public class MinecraftCertificateChain
implements Expirable {
    private final String mojangJwt;
    private final String identityJwt;
    private final AtomicReference<Object> parsedMojangJwt = new AtomicReference();
    private final AtomicReference<Object> parsedIdentityJwt = new AtomicReference();

    public static MinecraftCertificateChain fromJson(JsonObject jsonObject) {
        return MinecraftCertificateChain.fromJson(new GsonObject(jsonObject));
    }

    public static MinecraftCertificateChain fromJson(GsonObject gsonObject) {
        return new MinecraftCertificateChain(gsonObject.reqString("mojangJwt"), gsonObject.reqString("identityJwt"));
    }

    public static JsonObject toJson(MinecraftCertificateChain minecraftCertificateChain) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("mojangJwt", minecraftCertificateChain.mojangJwt);
        jsonObject.addProperty("identityJwt", minecraftCertificateChain.identityJwt);
        return jsonObject;
    }

    @Override
    public long getExpireTimeMs() {
        return Math.min(this.getParsedMojangJwt().getExpireTimeMs(), this.getParsedIdentityJwt().getExpireTimeMs());
    }

    public String getIdentityDisplayName() {
        return this.getParsedIdentityJwt().getPayload().reqObject("extraData").reqString("displayName");
    }

    public String getIdentityXuid() {
        return this.getParsedIdentityJwt().getPayload().reqObject("extraData").reqString("XUID");
    }

    public UUID getIdentityUuid() {
        return UUID.fromString(this.getParsedIdentityJwt().getPayload().reqObject("extraData").reqString("identity"));
    }

    @Generated
    public MinecraftCertificateChain(String string, String string2) {
        this.mojangJwt = string;
        this.identityJwt = string2;
    }

    @Generated
    public String getMojangJwt() {
        return this.mojangJwt;
    }

    @Generated
    public String getIdentityJwt() {
        return this.identityJwt;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftCertificateChain)) {
            return false;
        }
        MinecraftCertificateChain minecraftCertificateChain = (MinecraftCertificateChain)object;
        String string = this.getMojangJwt();
        String string2 = minecraftCertificateChain.getMojangJwt();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getIdentityJwt();
        String string4 = minecraftCertificateChain.getIdentityJwt();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getMojangJwt();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getIdentityJwt();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftCertificateChain(mojangJwt=" + this.getMojangJwt() + ", identityJwt=" + this.getIdentityJwt() + ")";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public Jwt getParsedMojangJwt() {
        Object object = this.parsedMojangJwt.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.parsedMojangJwt;
            synchronized (atomicReference) {
                object = this.parsedMojangJwt.get();
                if (object == null) {
                    Jwt jwt = Jwt.parse(this.mojangJwt);
                    object = jwt == null ? this.parsedMojangJwt : jwt;
                    this.parsedMojangJwt.set(object);
                }
            }
        }
        return (Jwt)(object == this.parsedMojangJwt ? null : object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public Jwt getParsedIdentityJwt() {
        Object object = this.parsedIdentityJwt.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.parsedIdentityJwt;
            synchronized (atomicReference) {
                object = this.parsedIdentityJwt.get();
                if (object == null) {
                    Jwt jwt = Jwt.parse(this.identityJwt);
                    object = jwt == null ? this.parsedIdentityJwt : jwt;
                    this.parsedIdentityJwt.set(object);
                }
            }
        }
        return (Jwt)(object == this.parsedIdentityJwt ? null : object);
    }
}

