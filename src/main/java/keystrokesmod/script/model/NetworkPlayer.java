/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import com.google.common.collect.Iterables;
import com.mojang.authlib.properties.Property;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class NetworkPlayer {
    private NetworkPlayerInfo playerInfo;
    private static HashMap<String, NetworkPlayer> cache = new HashMap();

    public NetworkPlayer(NetworkPlayerInfo networkPlayerInfo) {
        this.playerInfo = networkPlayerInfo;
    }

    public String getCape() {
        return this.playerInfo.getLocationCape().getResourcePath();
    }

    public String getDisplayName() {
        return this.playerInfo.getGameProfile() == Minecraft.getMinecraft().thePlayer.getGameProfile() ? Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText() : ScorePlayerTeam.formatPlayerName(this.playerInfo.getPlayerTeam(), this.getName());
    }

    public String getName() {
        if (this.playerInfo == null) {
            return "";
        }
        return this.playerInfo.getGameProfile().getName();
    }

    public int getPing() {
        if (this.playerInfo == null) {
            return 0;
        }
        return this.playerInfo.getResponseTime();
    }

    public String getSkinData() {
        Property property = Iterables.getFirst(this.playerInfo.getGameProfile().getProperties().get("textures"), null);
        if (property == null) {
            return null;
        }
        return new String(Base64.getDecoder().decode(property.getValue().getBytes(StandardCharsets.UTF_8)));
    }

    public String getUUID() {
        if (this.playerInfo == null) {
            return "";
        }
        return this.playerInfo.getGameProfile().getId().toString();
    }

    public static NetworkPlayer convert(NetworkPlayerInfo networkPlayerInfo) {
        if (networkPlayerInfo == null) {
            return null;
        }
        String string = networkPlayerInfo.getGameProfile().getId().toString();
        NetworkPlayer networkPlayer = cache.get(string);
        if (networkPlayer == null) {
            networkPlayer = new NetworkPlayer(networkPlayerInfo);
            cache.put(string, networkPlayer);
        }
        return networkPlayer;
    }

    public static void clearCache() {
        cache.clear();
    }
}

