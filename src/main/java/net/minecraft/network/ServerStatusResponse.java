/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;
import java.lang.reflect.Type;
import java.util.UUID;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.JsonUtils;

public class ServerStatusResponse {
    private IChatComponent serverMotd;
    private PlayerCountData playerCount;
    private MinecraftProtocolVersionIdentifier protocolVersion;
    private String favicon;

    public IChatComponent getServerDescription() {
        return this.serverMotd;
    }

    public void setServerDescription(IChatComponent iChatComponent) {
        this.serverMotd = iChatComponent;
    }

    public PlayerCountData getPlayerCountData() {
        return this.playerCount;
    }

    public void setPlayerCountData(PlayerCountData playerCountData) {
        this.playerCount = playerCountData;
    }

    public MinecraftProtocolVersionIdentifier getProtocolVersionInfo() {
        return this.protocolVersion;
    }

    public void setProtocolVersionInfo(MinecraftProtocolVersionIdentifier minecraftProtocolVersionIdentifier) {
        this.protocolVersion = minecraftProtocolVersionIdentifier;
    }

    public void setFavicon(String string) {
        this.favicon = string;
    }

    public String getFavicon() {
        return this.favicon;
    }

    public static class PlayerCountData {
        private final int maxPlayers;
        private final int onlinePlayerCount;
        private GameProfile[] players;

        public PlayerCountData(int n, int n2) {
            this.maxPlayers = n;
            this.onlinePlayerCount = n2;
        }

        public int getMaxPlayers() {
            return this.maxPlayers;
        }

        public int getOnlinePlayerCount() {
            return this.onlinePlayerCount;
        }

        public GameProfile[] getPlayers() {
            return this.players;
        }

        public void setPlayers(GameProfile[] gameProfileArray) {
            this.players = gameProfileArray;
        }

        public static class Serializer
        implements JsonDeserializer<PlayerCountData>,
        JsonSerializer<PlayerCountData> {
            @Override
            public PlayerCountData deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                JsonArray jsonArray;
                JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "players");
                PlayerCountData playerCountData = new PlayerCountData(JsonUtils.getInt(jsonObject, "max"), JsonUtils.getInt(jsonObject, "online"));
                if (JsonUtils.isJsonArray(jsonObject, "sample") && (jsonArray = JsonUtils.getJsonArray(jsonObject, "sample")).size() > 0) {
                    GameProfile[] gameProfileArray = new GameProfile[jsonArray.size()];
                    for (int i = 0; i < gameProfileArray.length; ++i) {
                        JsonObject jsonObject2 = JsonUtils.getJsonObject(jsonArray.get(i), "player[" + i + "]");
                        String string = JsonUtils.getString(jsonObject2, "id");
                        gameProfileArray[i] = new GameProfile(UUID.fromString(string), JsonUtils.getString(jsonObject2, "name"));
                    }
                    playerCountData.setPlayers(gameProfileArray);
                }
                return playerCountData;
            }

            @Override
            public JsonElement serialize(PlayerCountData playerCountData, Type type, JsonSerializationContext jsonSerializationContext) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("max", playerCountData.getMaxPlayers());
                jsonObject.addProperty("online", playerCountData.getOnlinePlayerCount());
                if (playerCountData.getPlayers() != null && playerCountData.getPlayers().length > 0) {
                    JsonArray jsonArray = new JsonArray();
                    for (int i = 0; i < playerCountData.getPlayers().length; ++i) {
                        JsonObject jsonObject2 = new JsonObject();
                        UUID uUID = playerCountData.getPlayers()[i].getId();
                        jsonObject2.addProperty("id", uUID == null ? "" : uUID.toString());
                        jsonObject2.addProperty("name", playerCountData.getPlayers()[i].getName());
                        jsonArray.add(jsonObject2);
                    }
                    jsonObject.add("sample", jsonArray);
                }
                return jsonObject;
            }
        }
    }

    public static class MinecraftProtocolVersionIdentifier {
        private final String name;
        private final int protocol;

        public MinecraftProtocolVersionIdentifier(String string, int n) {
            this.name = string;
            this.protocol = n;
        }

        public String getName() {
            return this.name;
        }

        public int getProtocol() {
            return this.protocol;
        }

        public static class Serializer
        implements JsonDeserializer<MinecraftProtocolVersionIdentifier>,
        JsonSerializer<MinecraftProtocolVersionIdentifier> {
            @Override
            public MinecraftProtocolVersionIdentifier deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "version");
                return new MinecraftProtocolVersionIdentifier(JsonUtils.getString(jsonObject, "name"), JsonUtils.getInt(jsonObject, "protocol"));
            }

            @Override
            public JsonElement serialize(MinecraftProtocolVersionIdentifier minecraftProtocolVersionIdentifier, Type type, JsonSerializationContext jsonSerializationContext) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("name", minecraftProtocolVersionIdentifier.getName());
                jsonObject.addProperty("protocol", minecraftProtocolVersionIdentifier.getProtocol());
                return jsonObject;
            }
        }
    }

    public static class Serializer
    implements JsonDeserializer<ServerStatusResponse>,
    JsonSerializer<ServerStatusResponse> {
        @Override
        public ServerStatusResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "status");
            ServerStatusResponse serverStatusResponse = new ServerStatusResponse();
            if (jsonObject.has("description")) {
                serverStatusResponse.setServerDescription((IChatComponent)jsonDeserializationContext.deserialize(jsonObject.get("description"), (Type)((Object)IChatComponent.class)));
            }
            if (jsonObject.has("players")) {
                serverStatusResponse.setPlayerCountData((PlayerCountData)jsonDeserializationContext.deserialize(jsonObject.get("players"), (Type)((Object)PlayerCountData.class)));
            }
            if (jsonObject.has("version")) {
                serverStatusResponse.setProtocolVersionInfo((MinecraftProtocolVersionIdentifier)jsonDeserializationContext.deserialize(jsonObject.get("version"), (Type)((Object)MinecraftProtocolVersionIdentifier.class)));
            }
            if (jsonObject.has("favicon")) {
                serverStatusResponse.setFavicon(JsonUtils.getString(jsonObject, "favicon"));
            }
            return serverStatusResponse;
        }

        @Override
        public JsonElement serialize(ServerStatusResponse serverStatusResponse, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            if (serverStatusResponse.getServerDescription() != null) {
                jsonObject.add("description", jsonSerializationContext.serialize(serverStatusResponse.getServerDescription()));
            }
            if (serverStatusResponse.getPlayerCountData() != null) {
                jsonObject.add("players", jsonSerializationContext.serialize(serverStatusResponse.getPlayerCountData()));
            }
            if (serverStatusResponse.getProtocolVersionInfo() != null) {
                jsonObject.add("version", jsonSerializationContext.serialize(serverStatusResponse.getProtocolVersionInfo()));
            }
            if (serverStatusResponse.getFavicon() != null) {
                jsonObject.addProperty("favicon", serverStatusResponse.getFavicon());
            }
            return jsonObject;
        }
    }
}

