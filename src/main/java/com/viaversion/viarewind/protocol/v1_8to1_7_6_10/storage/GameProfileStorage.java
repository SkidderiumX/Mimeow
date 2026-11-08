/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viarewind.utils.ChatUtil;
import com.viaversion.viaversion.api.connection.StoredObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.util.ChatColorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GameProfileStorage
extends StoredObject {
    private final Map<UUID, GameProfile> properties = new HashMap<UUID, GameProfile>();
    private final ListMultimap<String, GameProfile> nameToProfile = ArrayListMultimap.create();

    public GameProfileStorage(UserConnection userConnection) {
        super(userConnection);
    }

    public GameProfile put(UUID uUID, String string, String string2, int n, int n2) {
        GameProfile gameProfile = new GameProfile(uUID, string, string2, n, n2);
        this.properties.put(uUID, gameProfile);
        this.nameToProfile.put(string, gameProfile);
        return gameProfile;
    }

    public GameProfile get(UUID uUID) {
        return this.properties.get(uUID);
    }

    public List<GameProfile> get(String string, boolean bl) {
        if (bl) {
            string = string.toLowerCase();
        }
        return this.nameToProfile.get(string);
    }

    public List<GameProfile> getAllWithPrefix(String string, boolean bl) {
        if (bl) {
            string = string.toLowerCase();
        }
        ArrayList<GameProfile> arrayList = new ArrayList<GameProfile>();
        for (GameProfile gameProfile : this.properties.values()) {
            String string2;
            if (gameProfile.name == null || !(string2 = bl ? gameProfile.name.toLowerCase() : gameProfile.name).startsWith(string)) continue;
            arrayList.add(gameProfile);
        }
        return arrayList;
    }

    public GameProfile remove(UUID uUID) {
        GameProfile gameProfile = this.properties.remove(uUID);
        if (gameProfile != null) {
            this.nameToProfile.get(gameProfile.name).remove(gameProfile);
        }
        return gameProfile;
    }

    public static class GameProfile {
        public final UUID uuid;
        public final String name;
        public String displayName;
        public List<Property> properties = new ArrayList<Property>();
        public int ping;
        public int gamemode = 0;

        public GameProfile(UUID uUID, String string, String string2, int n, int n2) {
            this.uuid = uUID;
            this.name = string;
            this.displayName = string2;
            this.ping = n;
            this.gamemode = n2;
        }

        public Item getSkull() {
            CompoundTag compoundTag = new CompoundTag();
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag.put("SkullOwner", compoundTag2);
            compoundTag2.put("Id", new StringTag(this.uuid.toString()));
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag2.put("Properties", compoundTag3);
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            compoundTag3.put("textures", listTag);
            for (Property property : this.properties) {
                if (!property.name.equals("textures")) continue;
                CompoundTag compoundTag4 = new CompoundTag();
                compoundTag4.put("Value", new StringTag(property.value));
                if (property.signature != null) {
                    compoundTag4.put("Signature", new StringTag(property.signature));
                }
                listTag.add(compoundTag4);
            }
            return new DataItem(397, 1, 3, compoundTag);
        }

        public String getLegacyDisplayName() {
            String string;
            String string2 = string = this.displayName == null ? this.name : this.displayName;
            if (string.length() > 16) {
                string = ChatUtil.removeUnusedColor(string, 'f');
            }
            if (string.length() > 16) {
                string = ChatColorUtil.stripColor(string);
            }
            if (string.length() > 16) {
                string = string.substring(0, 16);
            }
            return string;
        }

        public void setDisplayName(String string) {
            this.displayName = string;
        }
    }

    public static class Property {
        public final String name;
        public final String value;
        public final String signature;

        public Property(String string, String string2, String string3) {
            this.name = string;
            this.value = string2;
            this.signature = string3;
        }
    }
}

