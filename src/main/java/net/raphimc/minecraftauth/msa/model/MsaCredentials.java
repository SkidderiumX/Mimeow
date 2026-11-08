/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.model;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;

public class MsaCredentials {
    private final String email;
    private final String password;

    public static MsaCredentials fromJson(JsonObject jsonObject) {
        return MsaCredentials.fromJson(new GsonObject(jsonObject));
    }

    public static MsaCredentials fromJson(GsonObject gsonObject) {
        return new MsaCredentials(gsonObject.reqString("email"), gsonObject.reqString("password"));
    }

    public static JsonObject toJson(MsaCredentials msaCredentials) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("email", msaCredentials.email);
        jsonObject.addProperty("password", msaCredentials.password);
        return jsonObject;
    }

    @Generated
    public MsaCredentials(String string, String string2) {
        this.email = string;
        this.password = string2;
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MsaCredentials)) {
            return false;
        }
        MsaCredentials msaCredentials = (MsaCredentials)object;
        String string = this.getEmail();
        String string2 = msaCredentials.getEmail();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getPassword();
        String string4 = msaCredentials.getPassword();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getEmail();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getPassword();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaCredentials(email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }
}

