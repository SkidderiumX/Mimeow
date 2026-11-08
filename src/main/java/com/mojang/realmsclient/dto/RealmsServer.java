/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

import com.google.common.collect.ComparisonChain;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.realmsclient.dto.PlayerInfo;
import com.mojang.realmsclient.dto.RealmsServerPlayerList;
import com.mojang.realmsclient.dto.RealmsWorldOptions;
import com.mojang.realmsclient.dto.ValueObject;
import com.mojang.realmsclient.util.JsonUtils;
import com.mojang.realmsclient.util.RealmsUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsServerPing;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsServer
extends ValueObject {
    private static final Logger LOGGER = LogManager.getLogger();
    public long id;
    public String remoteSubscriptionId;
    public String name;
    public String motd;
    public State state;
    public String owner;
    public String ownerUUID;
    public List<PlayerInfo> players;
    public Map<Integer, RealmsWorldOptions> slots;
    public String ip;
    public boolean expired;
    public boolean expiredTrial;
    public int daysLeft;
    public WorldType worldType;
    public int activeSlot;
    public String minigameName;
    public int minigameId;
    public String minigameImage;
    public String resourcePackUrl;
    public String resourcePackHash;
    public RealmsServerPing serverPing = new RealmsServerPing();

    public String getDescription() {
        return this.motd;
    }

    public String getName() {
        return this.name;
    }

    public String getMinigameName() {
        return this.minigameName;
    }

    public void setName(String string) {
        this.name = string;
    }

    public void setDescription(String string) {
        this.motd = string;
    }

    public void updateServerPing(RealmsServerPlayerList realmsServerPlayerList) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for (String string : realmsServerPlayerList.players) {
            if (string.equals(Realms.getUUID())) continue;
            String string2 = "";
            try {
                string2 = RealmsUtil.nameCache.get(string);
            }
            catch (Exception exception) {
                LOGGER.error("Could not get name for " + string, (Throwable)exception);
                continue;
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(string2);
            ++n;
        }
        this.serverPing.nrOfPlayers = String.valueOf(n);
        this.serverPing.playerList = stringBuilder.toString();
    }

    public static RealmsServer parse(JsonObject jsonObject) {
        RealmsServer realmsServer = new RealmsServer();
        try {
            realmsServer.id = JsonUtils.getLongOr("id", jsonObject, -1L);
            realmsServer.remoteSubscriptionId = JsonUtils.getStringOr("remoteSubscriptionId", jsonObject, null);
            realmsServer.name = JsonUtils.getStringOr("name", jsonObject, null);
            realmsServer.motd = JsonUtils.getStringOr("motd", jsonObject, null);
            realmsServer.state = RealmsServer.getState(JsonUtils.getStringOr("state", jsonObject, State.CLOSED.name()));
            realmsServer.owner = JsonUtils.getStringOr("owner", jsonObject, null);
            if (jsonObject.get("players") != null && jsonObject.get("players").isJsonArray()) {
                realmsServer.players = RealmsServer.parseInvited(jsonObject.get("players").getAsJsonArray());
                RealmsServer.sortInvited(realmsServer);
            } else {
                realmsServer.players = new ArrayList<PlayerInfo>();
            }
            realmsServer.daysLeft = JsonUtils.getIntOr("daysLeft", jsonObject, 0);
            realmsServer.ip = JsonUtils.getStringOr("ip", jsonObject, null);
            realmsServer.expired = JsonUtils.getBooleanOr("expired", jsonObject, false);
            realmsServer.expiredTrial = JsonUtils.getBooleanOr("expiredTrial", jsonObject, false);
            realmsServer.worldType = RealmsServer.getWorldType(JsonUtils.getStringOr("worldType", jsonObject, WorldType.NORMAL.name()));
            realmsServer.ownerUUID = JsonUtils.getStringOr("ownerUUID", jsonObject, "");
            realmsServer.slots = jsonObject.get("slots") != null && jsonObject.get("slots").isJsonArray() ? RealmsServer.parseSlots(jsonObject.get("slots").getAsJsonArray()) : RealmsServer.getEmptySlots();
            realmsServer.minigameName = JsonUtils.getStringOr("minigameName", jsonObject, null);
            realmsServer.activeSlot = JsonUtils.getIntOr("activeSlot", jsonObject, -1);
            realmsServer.minigameId = JsonUtils.getIntOr("minigameId", jsonObject, -1);
            realmsServer.minigameImage = JsonUtils.getStringOr("minigameImage", jsonObject, null);
            realmsServer.resourcePackUrl = JsonUtils.getStringOr("resourcePackUrl", jsonObject, null);
            realmsServer.resourcePackHash = JsonUtils.getStringOr("resourcePackHash", jsonObject, null);
        }
        catch (Exception exception) {
            LOGGER.error("Could not parse McoServer: " + exception.getMessage());
        }
        return realmsServer;
    }

    private static void sortInvited(RealmsServer realmsServer) {
        Collections.sort(realmsServer.players, new Comparator<PlayerInfo>(){

            @Override
            public int compare(PlayerInfo playerInfo, PlayerInfo playerInfo2) {
                return ComparisonChain.start().compare(Boolean.valueOf(playerInfo2.getAccepted()), Boolean.valueOf(playerInfo.getAccepted())).compare((Comparable<?>)((Object)playerInfo.getName().toLowerCase()), (Comparable<?>)((Object)playerInfo2.getName().toLowerCase())).result();
            }
        });
    }

    private static List<PlayerInfo> parseInvited(JsonArray jsonArray) {
        ArrayList<PlayerInfo> arrayList = new ArrayList<PlayerInfo>();
        for (JsonElement jsonElement : jsonArray) {
            try {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                PlayerInfo playerInfo = new PlayerInfo();
                playerInfo.setName(JsonUtils.getStringOr("name", jsonObject, null));
                playerInfo.setUuid(JsonUtils.getStringOr("uuid", jsonObject, null));
                playerInfo.setOperator(JsonUtils.getBooleanOr("operator", jsonObject, false));
                playerInfo.setAccepted(JsonUtils.getBooleanOr("accepted", jsonObject, false));
                arrayList.add(playerInfo);
            }
            catch (Exception exception) {}
        }
        return arrayList;
    }

    private static Map<Integer, RealmsWorldOptions> parseSlots(JsonArray jsonArray) {
        HashMap<Integer, RealmsWorldOptions> hashMap = new HashMap<Integer, RealmsWorldOptions>();
        for (JsonElement jsonElement : jsonArray) {
            try {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement2 = jsonParser.parse(jsonObject.get("options").getAsString());
                RealmsWorldOptions realmsWorldOptions = jsonElement2 == null ? RealmsWorldOptions.getDefaults() : RealmsWorldOptions.parse(jsonElement2.getAsJsonObject());
                int n = JsonUtils.getIntOr("slotId", jsonObject, -1);
                hashMap.put(n, realmsWorldOptions);
            }
            catch (Exception exception) {}
        }
        for (int i = 1; i <= 3; ++i) {
            if (hashMap.containsKey(i)) continue;
            hashMap.put(i, RealmsWorldOptions.getEmptyDefaults());
        }
        return hashMap;
    }

    private static Map<Integer, RealmsWorldOptions> getEmptySlots() {
        HashMap<Integer, RealmsWorldOptions> hashMap = new HashMap<Integer, RealmsWorldOptions>();
        hashMap.put(1, RealmsWorldOptions.getEmptyDefaults());
        hashMap.put(2, RealmsWorldOptions.getEmptyDefaults());
        hashMap.put(3, RealmsWorldOptions.getEmptyDefaults());
        return hashMap;
    }

    public static RealmsServer parse(String string) {
        RealmsServer realmsServer = new RealmsServer();
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(string).getAsJsonObject();
            realmsServer = RealmsServer.parse(jsonObject);
        }
        catch (Exception exception) {
            LOGGER.error("Could not parse McoServer: " + exception.getMessage());
        }
        return realmsServer;
    }

    private static State getState(String string) {
        try {
            return State.valueOf(string);
        }
        catch (Exception exception) {
            return State.CLOSED;
        }
    }

    private static WorldType getWorldType(String string) {
        try {
            return WorldType.valueOf(string);
        }
        catch (Exception exception) {
            return WorldType.NORMAL;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(this.id).append(this.name).append(this.motd).append((Object)this.state).append(this.owner).append(this.expired).toHashCode();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        RealmsServer realmsServer = (RealmsServer)object;
        return new EqualsBuilder().append(this.id, realmsServer.id).append(this.name, realmsServer.name).append(this.motd, realmsServer.motd).append((Object)this.state, (Object)realmsServer.state).append(this.owner, realmsServer.owner).append(this.expired, realmsServer.expired).append((Object)this.worldType, (Object)this.worldType).isEquals();
    }

    public RealmsServer clone() {
        RealmsServer realmsServer = new RealmsServer();
        realmsServer.id = this.id;
        realmsServer.remoteSubscriptionId = this.remoteSubscriptionId;
        realmsServer.name = this.name;
        realmsServer.motd = this.motd;
        realmsServer.state = this.state;
        realmsServer.owner = this.owner;
        realmsServer.players = this.players;
        realmsServer.slots = this.cloneSlots(this.slots);
        realmsServer.ip = this.ip;
        realmsServer.expired = this.expired;
        realmsServer.expiredTrial = this.expiredTrial;
        realmsServer.daysLeft = this.daysLeft;
        realmsServer.serverPing = new RealmsServerPing();
        realmsServer.serverPing.nrOfPlayers = this.serverPing.nrOfPlayers;
        realmsServer.serverPing.playerList = this.serverPing.playerList;
        realmsServer.worldType = this.worldType;
        realmsServer.ownerUUID = this.ownerUUID;
        realmsServer.minigameName = this.minigameName;
        realmsServer.activeSlot = this.activeSlot;
        realmsServer.minigameId = this.minigameId;
        realmsServer.minigameImage = this.minigameImage;
        realmsServer.resourcePackUrl = this.resourcePackUrl;
        realmsServer.resourcePackHash = this.resourcePackHash;
        return realmsServer;
    }

    public Map<Integer, RealmsWorldOptions> cloneSlots(Map<Integer, RealmsWorldOptions> map) {
        HashMap<Integer, RealmsWorldOptions> hashMap = new HashMap<Integer, RealmsWorldOptions>();
        for (Map.Entry<Integer, RealmsWorldOptions> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().clone());
        }
        return hashMap;
    }

    public static enum WorldType {
        NORMAL,
        MINIGAME,
        ADVENTUREMAP;

    }

    public static enum State {
        CLOSED,
        OPEN,
        UNINITIALIZED;

    }

    public static class McoServerComparator
    implements Comparator<RealmsServer> {
        private final String refOwner;

        public McoServerComparator(String string) {
            this.refOwner = string;
        }

        @Override
        public int compare(RealmsServer realmsServer, RealmsServer realmsServer2) {
            return ComparisonChain.start().compareTrueFirst(realmsServer.state.equals((Object)State.UNINITIALIZED), realmsServer2.state.equals((Object)State.UNINITIALIZED)).compareTrueFirst(realmsServer.expiredTrial, realmsServer2.expiredTrial).compareTrueFirst(realmsServer.owner.equals(this.refOwner), realmsServer2.owner.equals(this.refOwner)).compareFalseFirst(realmsServer.expired, realmsServer2.expired).compareTrueFirst(realmsServer.state.equals((Object)State.OPEN), realmsServer2.state.equals((Object)State.OPEN)).compare(realmsServer.id, realmsServer2.id).result();
        }
    }
}

