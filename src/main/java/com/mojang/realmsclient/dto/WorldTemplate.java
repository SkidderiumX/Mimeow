/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

import com.google.gson.JsonObject;
import com.mojang.realmsclient.dto.ValueObject;
import com.mojang.realmsclient.util.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldTemplate
extends ValueObject {
    private static final Logger LOGGER = LogManager.getLogger();
    public String id;
    public String name;
    public String version;
    public String author;
    public String link;
    public boolean minigame = false;
    public String image;
    public String trailer;
    public String recommendedPlayers;

    public static WorldTemplate parse(JsonObject jsonObject) {
        WorldTemplate worldTemplate = new WorldTemplate();
        try {
            worldTemplate.id = JsonUtils.getStringOr("id", jsonObject, "");
            worldTemplate.name = JsonUtils.getStringOr("name", jsonObject, "");
            worldTemplate.version = JsonUtils.getStringOr("version", jsonObject, "");
            worldTemplate.author = JsonUtils.getStringOr("author", jsonObject, "");
            worldTemplate.link = JsonUtils.getStringOr("link", jsonObject, "");
            worldTemplate.image = JsonUtils.getStringOr("image", jsonObject, null);
            worldTemplate.trailer = JsonUtils.getStringOr("trailer", jsonObject, "");
            worldTemplate.recommendedPlayers = JsonUtils.getStringOr("recommendedPlayers", jsonObject, "");
        }
        catch (Exception exception) {
            LOGGER.error("Could not parse WorldTemplate: " + exception.getMessage());
        }
        return worldTemplate;
    }

    public void setMinigame(boolean bl) {
        this.minigame = bl;
    }
}

