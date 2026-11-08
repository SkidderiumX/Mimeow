/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.io.File;
import net.minecraft.server.management.UserList;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.server.management.UserListEntry;

public class UserListBans
extends UserList<GameProfile, UserListBansEntry> {
    public UserListBans(File file) {
        super(file);
    }

    @Override
    protected UserListEntry<GameProfile> createEntry(JsonObject jsonObject) {
        return new UserListBansEntry(jsonObject);
    }

    public boolean isBanned(GameProfile gameProfile) {
        return this.hasEntry(gameProfile);
    }

    @Override
    public String[] getKeys() {
        String[] stringArray = new String[this.getValues().size()];
        int n = 0;
        for (UserListBansEntry userListBansEntry : this.getValues().values()) {
            stringArray[n++] = ((GameProfile)userListBansEntry.getValue()).getName();
        }
        return stringArray;
    }

    @Override
    protected String getObjectKey(GameProfile gameProfile) {
        return gameProfile.getId().toString();
    }

    public GameProfile isUsernameBanned(String string) {
        for (UserListBansEntry userListBansEntry : this.getValues().values()) {
            if (!string.equalsIgnoreCase(((GameProfile)userListBansEntry.getValue()).getName())) continue;
            return (GameProfile)userListBansEntry.getValue();
        }
        return null;
    }
}

