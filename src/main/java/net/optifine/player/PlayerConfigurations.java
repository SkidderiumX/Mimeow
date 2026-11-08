/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.player;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.optifine.http.FileDownloadThread;
import net.optifine.http.HttpUtils;
import net.optifine.player.PlayerConfiguration;
import net.optifine.player.PlayerConfigurationReceiver;

public class PlayerConfigurations {
    private static Map mapConfigurations = null;
    private static boolean reloadPlayerItems = Boolean.getBoolean("player.models.reload");
    private static long timeReloadPlayerItemsMs = System.currentTimeMillis();

    public static void renderPlayerItems(ModelBiped modelBiped, AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        PlayerConfiguration playerConfiguration = PlayerConfigurations.getPlayerConfiguration(abstractClientPlayer);
        if (playerConfiguration != null) {
            playerConfiguration.renderPlayerItems(modelBiped, abstractClientPlayer, f, f2);
        }
    }

    public static synchronized PlayerConfiguration getPlayerConfiguration(AbstractClientPlayer abstractClientPlayer) {
        Object object;
        if (reloadPlayerItems && System.currentTimeMillis() > timeReloadPlayerItemsMs + 5000L && (object = Minecraft.getMinecraft().thePlayer) != null) {
            PlayerConfigurations.setPlayerConfiguration(((AbstractClientPlayer)object).getNameClear(), null);
            timeReloadPlayerItemsMs = System.currentTimeMillis();
        }
        if ((object = abstractClientPlayer.getNameClear()) == null) {
            return null;
        }
        PlayerConfiguration playerConfiguration = (PlayerConfiguration)PlayerConfigurations.getMapConfigurations().get(object);
        if (playerConfiguration == null) {
            playerConfiguration = new PlayerConfiguration();
            PlayerConfigurations.getMapConfigurations().put(object, playerConfiguration);
            PlayerConfigurationReceiver playerConfigurationReceiver = new PlayerConfigurationReceiver((String)object);
            String string = HttpUtils.getPlayerItemsUrl() + "/users/" + (String)object + ".cfg";
            FileDownloadThread fileDownloadThread = new FileDownloadThread(string, playerConfigurationReceiver);
            fileDownloadThread.start();
        }
        return playerConfiguration;
    }

    public static synchronized void setPlayerConfiguration(String string, PlayerConfiguration playerConfiguration) {
        PlayerConfigurations.getMapConfigurations().put(string, playerConfiguration);
    }

    private static Map getMapConfigurations() {
        if (mapConfigurations == null) {
            mapConfigurations = new HashMap();
        }
        return mapConfigurations;
    }
}

