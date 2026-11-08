/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.model;

import com.google.gson.JsonObject;
import java.util.Map;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import net.raphimc.minecraftauth.util.JsonUtil;

public class XblUserProfile
implements Expirable {
    private final String id;
    private final Map<String, String> settings;

    public static XblUserProfile fromJson(JsonObject jsonObject) {
        return XblUserProfile.fromJson(new GsonObject(jsonObject));
    }

    public static XblUserProfile fromJson(GsonObject gsonObject) {
        return new XblUserProfile(gsonObject.reqString("id"), JsonUtil.decodeMap(gsonObject.reqObject("settings")));
    }

    public static JsonObject toJson(XblUserProfile xblUserProfile) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.addProperty("id", xblUserProfile.id);
        jsonObject.add("settings", JsonUtil.encodeMap(xblUserProfile.settings));
        return jsonObject;
    }

    @Override
    public long getExpireTimeMs() {
        return Long.MAX_VALUE;
    }

    @Generated
    public XblUserProfile(String string, Map<String, String> map) {
        this.id = string;
        this.settings = map;
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public Map<String, String> getSettings() {
        return this.settings;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XblUserProfile)) {
            return false;
        }
        XblUserProfile xblUserProfile = (XblUserProfile)object;
        String string = this.getId();
        String string2 = xblUserProfile.getId();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        Map<String, String> map = this.getSettings();
        Map<String, String> map2 = xblUserProfile.getSettings();
        return !(map == null ? map2 != null : !((Object)map).equals(map2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getId();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        Map<String, String> map = this.getSettings();
        n2 = n2 * 59 + (map == null ? 43 : ((Object)map).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblUserProfile(id=" + this.getId() + ", settings=" + this.getSettings() + ")";
    }
}

