/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.model;

import com.google.gson.JsonObject;
import java.util.UUID;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;

public class MinecraftProfile
implements Expirable {
    private final UUID id;
    private final String name;

    public static MinecraftProfile fromJson(JsonObject jsonObject) {
        return MinecraftProfile.fromJson(new GsonObject(jsonObject));
    }

    public static MinecraftProfile fromJson(GsonObject gsonObject) {
        return new MinecraftProfile(UUID.fromString(gsonObject.reqString("id")), gsonObject.reqString("name"));
    }

    public static JsonObject toJson(MinecraftProfile minecraftProfile) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("id", minecraftProfile.id.toString());
        jsonObject.addProperty("name", minecraftProfile.name);
        return jsonObject;
    }

    @Override
    public long getExpireTimeMs() {
        return Long.MAX_VALUE;
    }

    @Generated
    public MinecraftProfile(UUID uUID, String string) {
        this.id = uUID;
        this.name = string;
    }

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftProfile)) {
            return false;
        }
        MinecraftProfile minecraftProfile = (MinecraftProfile)object;
        UUID uUID = this.getId();
        UUID uUID2 = minecraftProfile.getId();
        if (uUID == null ? uUID2 != null : !((Object)uUID).equals(uUID2)) {
            return false;
        }
        String string = this.getName();
        String string2 = minecraftProfile.getName();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        UUID uUID = this.getId();
        n2 = n2 * 59 + (uUID == null ? 43 : ((Object)uUID).hashCode());
        String string = this.getName();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftProfile(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
}

