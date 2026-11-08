/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.model;

import com.google.gson.JsonObject;
import java.util.Set;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.Expirable;
import net.raphimc.minecraftauth.util.JsonUtil;

public class MinecraftEntitlements
implements Expirable {
    private final Set<String> items;

    public static MinecraftEntitlements fromJson(JsonObject jsonObject) {
        return MinecraftEntitlements.fromJson(new GsonObject(jsonObject));
    }

    public static MinecraftEntitlements fromJson(GsonObject gsonObject) {
        return new MinecraftEntitlements(JsonUtil.decodeSet(gsonObject.reqArray("items")));
    }

    public static JsonObject toJson(MinecraftEntitlements minecraftEntitlements) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.add("items", JsonUtil.encodeSet(minecraftEntitlements.items));
        return jsonObject;
    }

    @Override
    public long getExpireTimeMs() {
        return Long.MAX_VALUE;
    }

    @Generated
    public MinecraftEntitlements(Set<String> set) {
        this.items = set;
    }

    @Generated
    public Set<String> getItems() {
        return this.items;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftEntitlements)) {
            return false;
        }
        MinecraftEntitlements minecraftEntitlements = (MinecraftEntitlements)object;
        Set<String> set = this.getItems();
        Set<String> set2 = minecraftEntitlements.getItems();
        return !(set == null ? set2 != null : !((Object)set).equals(set2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        Set<String> set = this.getItems();
        n2 = n2 * 59 + (set == null ? 43 : ((Object)set).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftEntitlements(items=" + this.getItems() + ")";
    }
}

