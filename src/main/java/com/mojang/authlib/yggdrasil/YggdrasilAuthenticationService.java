/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.HttpAuthenticationService;
import com.mojang.authlib.UserAuthentication;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import com.mojang.authlib.exceptions.UserMigratedException;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilGameProfileRepository;
import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.authlib.yggdrasil.response.ProfileSearchResultsResponse;
import com.mojang.authlib.yggdrasil.response.Response;
import com.mojang.util.UUIDTypeAdapter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.net.URL;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

public class YggdrasilAuthenticationService
extends HttpAuthenticationService {
    private final String clientToken;
    private final Gson gson;

    public YggdrasilAuthenticationService(Proxy proxy, String string) {
        super(proxy);
        this.clientToken = string;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter((Type)((Object)GameProfile.class), new GameProfileSerializer());
        gsonBuilder.registerTypeAdapter((Type)((Object)PropertyMap.class), new PropertyMap.Serializer());
        gsonBuilder.registerTypeAdapter((Type)((Object)UUID.class), new UUIDTypeAdapter());
        gsonBuilder.registerTypeAdapter((Type)((Object)ProfileSearchResultsResponse.class), new ProfileSearchResultsResponse.Serializer());
        this.gson = gsonBuilder.create();
    }

    @Override
    public UserAuthentication createUserAuthentication(Agent agent) {
        return new YggdrasilUserAuthentication(this, agent);
    }

    @Override
    public MinecraftSessionService createMinecraftSessionService() {
        return new YggdrasilMinecraftSessionService(this);
    }

    @Override
    public GameProfileRepository createProfileRepository() {
        return new YggdrasilGameProfileRepository(this);
    }

    protected <T extends Response> T makeRequest(URL uRL, Object object, Class<T> clazz) throws AuthenticationException {
        try {
            String string = object == null ? this.performGetRequest(uRL) : this.performPostRequest(uRL, this.gson.toJson(object), "application/json");
            Response response = (Response)this.gson.fromJson(string, clazz);
            if (response == null) {
                return null;
            }
            if (StringUtils.isNotBlank(response.getError())) {
                if ("UserMigratedException".equals(response.getCause())) {
                    throw new UserMigratedException(response.getErrorMessage());
                }
                if (response.getError().equals("ForbiddenOperationException")) {
                    throw new InvalidCredentialsException(response.getErrorMessage());
                }
                throw new AuthenticationException(response.getErrorMessage());
            }
            return (T)response;
        }
        catch (IOException iOException) {
            throw new AuthenticationUnavailableException("Cannot contact authentication server", iOException);
        }
        catch (IllegalStateException illegalStateException) {
            throw new AuthenticationUnavailableException("Cannot contact authentication server", illegalStateException);
        }
        catch (JsonParseException jsonParseException) {
            throw new AuthenticationUnavailableException("Cannot contact authentication server", jsonParseException);
        }
    }

    public String getClientToken() {
        return this.clientToken;
    }

    private static class GameProfileSerializer
    implements JsonSerializer<GameProfile>,
    JsonDeserializer<GameProfile> {
        private GameProfileSerializer() {
        }

        @Override
        public GameProfile deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = (JsonObject)jsonElement;
            UUID uUID = jsonObject.has("id") ? (UUID)jsonDeserializationContext.deserialize(jsonObject.get("id"), (Type)((Object)UUID.class)) : null;
            String string = jsonObject.has("name") ? jsonObject.getAsJsonPrimitive("name").getAsString() : null;
            return new GameProfile(uUID, string);
        }

        @Override
        public JsonElement serialize(GameProfile gameProfile, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            if (gameProfile.getId() != null) {
                jsonObject.add("id", jsonSerializationContext.serialize(gameProfile.getId()));
            }
            if (gameProfile.getName() != null) {
                jsonObject.addProperty("name", gameProfile.getName());
            }
            return jsonObject;
        }
    }
}

