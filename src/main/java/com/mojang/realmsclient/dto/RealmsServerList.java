/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.ValueObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsServerList
extends ValueObject {
    private static final Logger LOGGER = LogManager.getLogger();
    public List<RealmsServer> servers;

    public static RealmsServerList parse(String string) {
        RealmsServerList realmsServerList = new RealmsServerList();
        realmsServerList.servers = new ArrayList<RealmsServer>();
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(string).getAsJsonObject();
            if (jsonObject.get("servers").isJsonArray()) {
                JsonArray jsonArray = jsonObject.get("servers").getAsJsonArray();
                Iterator<JsonElement> iterator2 = jsonArray.iterator();
                while (iterator2.hasNext()) {
                    realmsServerList.servers.add(RealmsServer.parse(iterator2.next().getAsJsonObject()));
                }
            }
        }
        catch (Exception exception) {
            LOGGER.error("Could not parse McoServerList: " + exception.getMessage());
        }
        return realmsServerList;
    }
}

