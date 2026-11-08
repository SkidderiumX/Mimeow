/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.model;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import org.jetbrains.annotations.ApiStatus;

public class RealmsJoinInformation {
    public static final String PROTOCOL_DEFAULT = "DEFAULT";
    public static final String PROTOCOL_NETHERNET = "NETHERNET";
    public static final String PROTOCOL_NETHERNET_JSONRPC = "NETHERNET_JSONRPC";
    private final String address;
    private final String networkProtocol;
    private final JsonObject rawResponse;

    @ApiStatus.Internal
    public static RealmsJoinInformation fromApiJson(GsonObject gsonObject) {
        return new RealmsJoinInformation(gsonObject.reqString("address"), gsonObject.getString("networkProtocol", PROTOCOL_DEFAULT), gsonObject.getJsonObject());
    }

    @Generated
    public RealmsJoinInformation(String string, String string2, JsonObject jsonObject) {
        this.address = string;
        this.networkProtocol = string2;
        this.rawResponse = jsonObject;
    }

    @Generated
    public String getAddress() {
        return this.address;
    }

    @Generated
    public String getNetworkProtocol() {
        return this.networkProtocol;
    }

    @Generated
    public JsonObject getRawResponse() {
        return this.rawResponse;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof RealmsJoinInformation)) {
            return false;
        }
        RealmsJoinInformation realmsJoinInformation = (RealmsJoinInformation)object;
        String string = this.getAddress();
        String string2 = realmsJoinInformation.getAddress();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getNetworkProtocol();
        String string4 = realmsJoinInformation.getNetworkProtocol();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        JsonObject jsonObject = this.getRawResponse();
        JsonObject jsonObject2 = realmsJoinInformation.getRawResponse();
        return !(jsonObject == null ? jsonObject2 != null : !((Object)jsonObject).equals(jsonObject2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getAddress();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getNetworkProtocol();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        JsonObject jsonObject = this.getRawResponse();
        n2 = n2 * 59 + (jsonObject == null ? 43 : ((Object)jsonObject).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "RealmsJoinInformation(address=" + this.getAddress() + ", networkProtocol=" + this.getNetworkProtocol() + ", rawResponse=" + this.getRawResponse() + ")";
    }
}

