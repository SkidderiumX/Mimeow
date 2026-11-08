/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.realmsclient.dto.ValueObject;
import com.mojang.realmsclient.dto.WorldTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldTemplateList
extends ValueObject {
    private static final Logger LOGGER = LogManager.getLogger();
    public List<WorldTemplate> templates;

    public static WorldTemplateList parse(String string) {
        WorldTemplateList worldTemplateList = new WorldTemplateList();
        worldTemplateList.templates = new ArrayList<WorldTemplate>();
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(string).getAsJsonObject();
            if (jsonObject.get("templates").isJsonArray()) {
                Iterator<JsonElement> iterator2 = jsonObject.get("templates").getAsJsonArray().iterator();
                while (iterator2.hasNext()) {
                    worldTemplateList.templates.add(WorldTemplate.parse(iterator2.next().getAsJsonObject()));
                }
            }
        }
        catch (Exception exception) {
            LOGGER.error("Could not parse WorldTemplateList: " + exception.getMessage());
        }
        return worldTemplateList;
    }
}

