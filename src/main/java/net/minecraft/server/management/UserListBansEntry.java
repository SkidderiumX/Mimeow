/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.util.Date;
import java.util.UUID;
import net.minecraft.server.management.BanEntry;

public class UserListBansEntry
extends BanEntry<GameProfile> {
    public UserListBansEntry(GameProfile gameProfile) {
        this(gameProfile, (Date)null, (String)null, (Date)null, (String)null);
    }

    public UserListBansEntry(GameProfile gameProfile, Date date, String string, Date date2, String string2) {
        super(gameProfile, date2, string, date2, string2);
    }

    public UserListBansEntry(JsonObject jsonObject) {
        super(UserListBansEntry.toGameProfile(jsonObject), jsonObject);
    }

    @Override
    protected void onSerialization(JsonObject jsonObject) {
        if (this.getValue() != null) {
            jsonObject.addProperty("uuid", ((GameProfile)this.getValue()).getId() == null ? "" : ((GameProfile)this.getValue()).getId().toString());
            jsonObject.addProperty("name", ((GameProfile)this.getValue()).getName());
            super.onSerialization(jsonObject);
        }
    }

    private static GameProfile toGameProfile(JsonObject jsonObject) {
        if (jsonObject.has("uuid") && jsonObject.has("name")) {
            UUID uUID;
            String string = jsonObject.get("uuid").getAsString();
            try {
                uUID = UUID.fromString(string);
            }
            catch (Throwable throwable) {
                return null;
            }
            return new GameProfile(uUID, jsonObject.get("name").getAsString());
        }
        return null;
    }
}

