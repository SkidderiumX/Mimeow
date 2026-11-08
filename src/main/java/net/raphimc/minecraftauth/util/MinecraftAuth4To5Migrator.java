/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util;

import com.google.gson.JsonObject;
import java.util.Map;
import java.util.UUID;
import net.lenni0451.commons.gson.elements.GsonElement;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.util.CryptUtil;
import net.raphimc.minecraftauth.util.JsonUtil;

public class MinecraftAuth4To5Migrator {
    public static JsonObject migrateJavaSave(JsonObject jsonObject) {
        return MinecraftAuth4To5Migrator.migrateJavaSave(jsonObject, new MsaApplicationConfig("00000000402b5328", "service::user.auth.xboxlive.com::MBI_SSL"));
    }

    public static JsonObject migrateJavaSave(JsonObject jsonObject, MsaApplicationConfig msaApplicationConfig) {
        String string = MinecraftAuth4To5Migrator.findRefreshToken(new GsonObject(jsonObject));
        if (string == null) {
            throw new IllegalArgumentException("Failed to find refresh token in the provided save data");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("_saveVersion", 1);
        jsonObject2.add("msaApplicationConfig", MsaApplicationConfig.toJson(msaApplicationConfig));
        jsonObject2.addProperty("deviceType", "Win32");
        jsonObject2.add("deviceKeyPair", JsonUtil.encodeKeyPair(CryptUtil.generateEcdsa256KeyPair()));
        jsonObject2.addProperty("deviceId", UUID.randomUUID().toString());
        jsonObject2.add("msaToken", MsaToken.toJson(new MsaToken(0L, "", string)));
        return jsonObject2;
    }

    public static JsonObject migrateBedrockSave(JsonObject jsonObject) {
        return MinecraftAuth4To5Migrator.migrateBedrockSave(jsonObject, new MsaApplicationConfig("0000000048183522", "service::user.auth.xboxlive.com::MBI_SSL"));
    }

    public static JsonObject migrateBedrockSave(JsonObject jsonObject, MsaApplicationConfig msaApplicationConfig) {
        String string = MinecraftAuth4To5Migrator.findRefreshToken(new GsonObject(jsonObject));
        if (string == null) {
            throw new IllegalArgumentException("Failed to find refresh token in the provided save data");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("_saveVersion", 1);
        jsonObject2.add("msaApplicationConfig", MsaApplicationConfig.toJson(msaApplicationConfig));
        jsonObject2.addProperty("deviceType", "Android");
        jsonObject2.add("deviceKeyPair", JsonUtil.encodeKeyPair(CryptUtil.generateEcdsa256KeyPair()));
        jsonObject2.addProperty("deviceId", UUID.randomUUID().toString());
        jsonObject2.add("sessionKeyPair", JsonUtil.encodeKeyPair(CryptUtil.generateEcdsa384KeyPair()));
        jsonObject2.add("msaToken", MsaToken.toJson(new MsaToken(0L, "", string)));
        return jsonObject2;
    }

    public static String findRefreshToken(GsonObject gsonObject) {
        if (gsonObject.hasString("refreshToken")) {
            return gsonObject.reqString("refreshToken");
        }
        for (Map.Entry<String, GsonElement> entry : gsonObject.entrySet()) {
            String string;
            if (!entry.getValue().isObject() || (string = MinecraftAuth4To5Migrator.findRefreshToken(entry.getValue().asObject())) == null) continue;
            return string;
        }
        return null;
    }
}

