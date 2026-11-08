/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.model;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;

public class MsaDeviceCode
implements Expirable {
    private final long expireTimeMs;
    private final long intervalMs;
    private final String deviceCode;
    private final String userCode;
    private final String verificationUri;

    public static MsaDeviceCode fromJson(JsonObject jsonObject) {
        return MsaDeviceCode.fromJson(new GsonObject(jsonObject));
    }

    public static MsaDeviceCode fromJson(GsonObject gsonObject) {
        return new MsaDeviceCode(gsonObject.reqLong("expireTimeMs"), gsonObject.reqLong("intervalMs"), gsonObject.reqString("deviceCode"), gsonObject.reqString("userCode"), gsonObject.reqString("verificationUri"));
    }

    public static JsonObject toJson(MsaDeviceCode msaDeviceCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("expireTimeMs", msaDeviceCode.expireTimeMs);
        jsonObject.addProperty("intervalMs", msaDeviceCode.intervalMs);
        jsonObject.addProperty("deviceCode", msaDeviceCode.deviceCode);
        jsonObject.addProperty("userCode", msaDeviceCode.userCode);
        jsonObject.addProperty("verificationUri", msaDeviceCode.verificationUri);
        return jsonObject;
    }

    public String getDirectVerificationUri() {
        return this.verificationUri + "?otc=" + this.userCode;
    }

    @Generated
    public MsaDeviceCode(long l, long l2, String string, String string2, String string3) {
        this.expireTimeMs = l;
        this.intervalMs = l2;
        this.deviceCode = string;
        this.userCode = string2;
        this.verificationUri = string3;
    }

    @Override
    @Generated
    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    @Generated
    public long getIntervalMs() {
        return this.intervalMs;
    }

    @Generated
    public String getDeviceCode() {
        return this.deviceCode;
    }

    @Generated
    public String getUserCode() {
        return this.userCode;
    }

    @Generated
    public String getVerificationUri() {
        return this.verificationUri;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MsaDeviceCode)) {
            return false;
        }
        MsaDeviceCode msaDeviceCode = (MsaDeviceCode)object;
        if (this.getExpireTimeMs() != msaDeviceCode.getExpireTimeMs()) {
            return false;
        }
        if (this.getIntervalMs() != msaDeviceCode.getIntervalMs()) {
            return false;
        }
        String string = this.getDeviceCode();
        String string2 = msaDeviceCode.getDeviceCode();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getUserCode();
        String string4 = msaDeviceCode.getUserCode();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.getVerificationUri();
        String string6 = msaDeviceCode.getVerificationUri();
        return !(string5 == null ? string6 != null : !string5.equals(string6));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getExpireTimeMs();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        long l2 = this.getIntervalMs();
        n2 = n2 * 59 + (int)(l2 >>> 32 ^ l2);
        String string = this.getDeviceCode();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getUserCode();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.getVerificationUri();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaDeviceCode(expireTimeMs=" + this.getExpireTimeMs() + ", intervalMs=" + this.getIntervalMs() + ", deviceCode=" + this.getDeviceCode() + ", userCode=" + this.getUserCode() + ", verificationUri=" + this.getVerificationUri() + ")";
    }
}

