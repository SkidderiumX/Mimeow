/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.io.File;
import net.minecraft.server.management.UserList;
import net.minecraft.server.management.UserListEntry;
import net.minecraft.server.management.UserListOpsEntry;

public class UserListOps
extends UserList<GameProfile, UserListOpsEntry> {
    public UserListOps(File file) {
        super(file);
    }

    @Override
    protected UserListEntry<GameProfile> createEntry(JsonObject jsonObject) {
        return new UserListOpsEntry(jsonObject);
    }

    @Override
    public String[] getKeys() {
        String[] stringArray = new String[this.getValues().size()];
        int n = 0;
        for (UserListOpsEntry userListOpsEntry : this.getValues().values()) {
            stringArray[n++] = ((GameProfile)userListOpsEntry.getValue()).getName();
        }
        return stringArray;
    }

    public boolean bypassesPlayerLimit(GameProfile gameProfile) {
        UserListOpsEntry userListOpsEntry = (UserListOpsEntry)this.getEntry(gameProfile);
        return userListOpsEntry != null ? userListOpsEntry.bypassesPlayerLimit() : false;
    }

    @Override
    protected String getObjectKey(GameProfile gameProfile) {
        return gameProfile.getId().toString();
    }

    public GameProfile getGameProfileFromName(String string) {
        for (UserListOpsEntry userListOpsEntry : this.getValues().values()) {
            if (!string.equalsIgnoreCase(((GameProfile)userListOpsEntry.getValue()).getName())) continue;
            return (GameProfile)userListOpsEntry.getValue();
        }
        return null;
    }
}

