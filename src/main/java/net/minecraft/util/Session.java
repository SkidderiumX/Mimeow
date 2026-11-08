/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import java.util.Map;
import java.util.UUID;

public class Session {
    private final String username;
    private final String playerID;
    private final String token;
    private final Type sessionType;

    public Session(String string, String string2, String string3, String string4) {
        this.username = string;
        this.playerID = string2;
        this.token = string3;
        this.sessionType = Type.setSessionType(string4);
    }

    public String getSessionID() {
        return "token:" + this.token + ":" + this.playerID;
    }

    public String getPlayerID() {
        return this.playerID;
    }

    public String getUsername() {
        return this.username;
    }

    public String getToken() {
        return this.token;
    }

    public GameProfile getProfile() {
        try {
            UUID uUID = UUIDTypeAdapter.fromString(this.getPlayerID());
            return new GameProfile(uUID, this.getUsername());
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return new GameProfile(null, this.getUsername());
        }
    }

    public Type getSessionType() {
        return this.sessionType;
    }

    public static enum Type {
        LEGACY("legacy"),
        MOJANG("mojang");

        private static final Map<String, Type> SESSION_TYPES;
        private final String sessionType;

        private Type(String string2) {
            this.sessionType = string2;
        }

        public static Type setSessionType(String string) {
            return SESSION_TYPES.get(string.toLowerCase());
        }

        static {
            SESSION_TYPES = Maps.newHashMap();
            for (Type type : Type.values()) {
                SESSION_TYPES.put(type.sessionType, type);
            }
        }
    }
}

