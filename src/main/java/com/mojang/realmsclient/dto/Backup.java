/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.realmsclient.dto.ValueObject;
import com.mojang.realmsclient.util.JsonUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Backup
extends ValueObject {
    private static final Logger LOGGER = LogManager.getLogger();
    public String backupId;
    public Date lastModifiedDate;
    public long size;
    private boolean uploadedVersion = false;
    public Map<String, String> metadata = new HashMap<String, String>();
    public Map<String, String> changeList = new HashMap<String, String>();

    public static Backup parse(JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Backup backup = new Backup();
        try {
            backup.backupId = JsonUtils.getStringOr("backupId", jsonObject, "");
            backup.lastModifiedDate = JsonUtils.getDateOr("lastModifiedDate", jsonObject);
            backup.size = JsonUtils.getLongOr("size", jsonObject, 0L);
            if (jsonObject.has("metadata")) {
                JsonObject jsonObject2 = jsonObject.getAsJsonObject("metadata");
                Set<Map.Entry<String, JsonElement>> set = jsonObject2.entrySet();
                for (Map.Entry<String, JsonElement> entry : set) {
                    if (entry.getValue().isJsonNull()) continue;
                    backup.metadata.put(Backup.format(entry.getKey()), entry.getValue().getAsString());
                }
            }
        }
        catch (Exception exception) {
            LOGGER.error("Could not parse Backup: " + exception.getMessage());
        }
        return backup;
    }

    private static String format(String string) {
        String[] stringArray = string.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : stringArray) {
            if (string2 == null || string2.length() < 1) continue;
            if (string2.equals("of")) {
                stringBuilder.append(string2).append(" ");
                continue;
            }
            char c = Character.toUpperCase(string2.charAt(0));
            stringBuilder.append(c).append(string2.substring(1, string2.length())).append(" ");
        }
        return stringBuilder.toString();
    }

    public boolean isUploadedVersion() {
        return this.uploadedVersion;
    }

    public void setUploadedVersion(boolean bl) {
        this.uploadedVersion = bl;
    }
}

