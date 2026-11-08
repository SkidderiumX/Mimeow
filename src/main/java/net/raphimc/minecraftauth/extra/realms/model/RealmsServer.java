/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.model;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.StringUtil;
import org.jetbrains.annotations.ApiStatus;

public class RealmsServer {
    private final long id;
    private final String name;
    private final String motd;
    private final String ownerName;
    private final String ownerUid;
    private final String state;
    private final boolean expired;
    private final int daysLeft;
    private final String worldType;
    private final int maxPlayers;
    private final boolean compatible;
    private final String activeVersion;
    private final JsonObject rawResponse;

    @ApiStatus.Internal
    public static RealmsServer fromApiJson(GsonObject gsonObject) {
        return new RealmsServer(gsonObject.getLong("id", -1L), StringUtil.emptyToNull(gsonObject.getString("name", null)), StringUtil.emptyToNull(gsonObject.getString("motd", null)), StringUtil.emptyToNull(gsonObject.getString("owner", null)), StringUtil.emptyToNull(gsonObject.getString("ownerUUID", null)), gsonObject.getString("state", "CLOSED"), gsonObject.getBoolean("expired", false), gsonObject.getInt("daysLeft", 0), gsonObject.getString("worldType", "NORMAL"), gsonObject.getInt("maxPlayers", 0), gsonObject.getString("compatibility", "COMPATIBLE").equals("COMPATIBLE"), StringUtil.emptyToNull(gsonObject.getString("activeVersion", null)), gsonObject.getJsonObject());
    }

    public String getNameOr(String string) {
        return this.name == null ? string : this.name;
    }

    public String getMotdOr(String string) {
        return this.motd == null ? string : this.motd;
    }

    public String getOwnerNameOr(String string) {
        return this.ownerName == null ? string : this.ownerName;
    }

    public String getOwnerUidOr(String string) {
        return this.ownerUid == null ? string : this.ownerUid;
    }

    public String getActiveVersionOr(String string) {
        return this.activeVersion == null ? string : this.activeVersion;
    }

    @Generated
    public RealmsServer(long l, String string, String string2, String string3, String string4, String string5, boolean bl, int n, String string6, int n2, boolean bl2, String string7, JsonObject jsonObject) {
        this.id = l;
        this.name = string;
        this.motd = string2;
        this.ownerName = string3;
        this.ownerUid = string4;
        this.state = string5;
        this.expired = bl;
        this.daysLeft = n;
        this.worldType = string6;
        this.maxPlayers = n2;
        this.compatible = bl2;
        this.activeVersion = string7;
        this.rawResponse = jsonObject;
    }

    @Generated
    public long getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getMotd() {
        return this.motd;
    }

    @Generated
    public String getOwnerName() {
        return this.ownerName;
    }

    @Generated
    public String getOwnerUid() {
        return this.ownerUid;
    }

    @Generated
    public String getState() {
        return this.state;
    }

    @Generated
    public boolean isExpired() {
        return this.expired;
    }

    @Generated
    public int getDaysLeft() {
        return this.daysLeft;
    }

    @Generated
    public String getWorldType() {
        return this.worldType;
    }

    @Generated
    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    @Generated
    public boolean isCompatible() {
        return this.compatible;
    }

    @Generated
    public String getActiveVersion() {
        return this.activeVersion;
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
        if (!(object instanceof RealmsServer)) {
            return false;
        }
        RealmsServer realmsServer = (RealmsServer)object;
        if (this.getId() != realmsServer.getId()) {
            return false;
        }
        if (this.isExpired() != realmsServer.isExpired()) {
            return false;
        }
        if (this.getDaysLeft() != realmsServer.getDaysLeft()) {
            return false;
        }
        if (this.getMaxPlayers() != realmsServer.getMaxPlayers()) {
            return false;
        }
        if (this.isCompatible() != realmsServer.isCompatible()) {
            return false;
        }
        String string = this.getName();
        String string2 = realmsServer.getName();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getMotd();
        String string4 = realmsServer.getMotd();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.getOwnerName();
        String string6 = realmsServer.getOwnerName();
        if (string5 == null ? string6 != null : !string5.equals(string6)) {
            return false;
        }
        String string7 = this.getOwnerUid();
        String string8 = realmsServer.getOwnerUid();
        if (string7 == null ? string8 != null : !string7.equals(string8)) {
            return false;
        }
        String string9 = this.getState();
        String string10 = realmsServer.getState();
        if (string9 == null ? string10 != null : !string9.equals(string10)) {
            return false;
        }
        String string11 = this.getWorldType();
        String string12 = realmsServer.getWorldType();
        if (string11 == null ? string12 != null : !string11.equals(string12)) {
            return false;
        }
        String string13 = this.getActiveVersion();
        String string14 = realmsServer.getActiveVersion();
        if (string13 == null ? string14 != null : !string13.equals(string14)) {
            return false;
        }
        JsonObject jsonObject = this.getRawResponse();
        JsonObject jsonObject2 = realmsServer.getRawResponse();
        return !(jsonObject == null ? jsonObject2 != null : !((Object)jsonObject).equals(jsonObject2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.getId();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        n2 = n2 * 59 + (this.isExpired() ? 79 : 97);
        n2 = n2 * 59 + this.getDaysLeft();
        n2 = n2 * 59 + this.getMaxPlayers();
        n2 = n2 * 59 + (this.isCompatible() ? 79 : 97);
        String string = this.getName();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getMotd();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.getOwnerName();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        String string4 = this.getOwnerUid();
        n2 = n2 * 59 + (string4 == null ? 43 : string4.hashCode());
        String string5 = this.getState();
        n2 = n2 * 59 + (string5 == null ? 43 : string5.hashCode());
        String string6 = this.getWorldType();
        n2 = n2 * 59 + (string6 == null ? 43 : string6.hashCode());
        String string7 = this.getActiveVersion();
        n2 = n2 * 59 + (string7 == null ? 43 : string7.hashCode());
        JsonObject jsonObject = this.getRawResponse();
        n2 = n2 * 59 + (jsonObject == null ? 43 : ((Object)jsonObject).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "RealmsServer(id=" + this.getId() + ", name=" + this.getName() + ", motd=" + this.getMotd() + ", ownerName=" + this.getOwnerName() + ", ownerUid=" + this.getOwnerUid() + ", state=" + this.getState() + ", expired=" + this.isExpired() + ", daysLeft=" + this.getDaysLeft() + ", worldType=" + this.getWorldType() + ", maxPlayers=" + this.getMaxPlayers() + ", compatible=" + this.isCompatible() + ", activeVersion=" + this.getActiveVersion() + ", rawResponse=" + this.getRawResponse() + ")";
    }
}

