/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.update;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.update.Version;
import com.viaversion.viaversion.util.GsonUtil;
import com.viaversion.viaversion.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.CallSite;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class UpdateUtil {
    private static final String PREFIX = "\u00a7a\u00a7l[ViaVersion] \u00a7a";
    private static final String URL = "https://update.viaversion.com/";
    private static final String PLUGIN = "ViaVersion/";

    public static void sendUpdateMessage(UserConnection userConnection) {
        Via.getPlatform().runAsync(() -> {
            Pair<Level, String> pair = UpdateUtil.getUpdateMessage(false);
            if (pair != null) {
                Via.getPlatform().runSync(() -> Via.getPlatform().sendMessage(userConnection, PREFIX + (String)pair.value()));
            }
        });
    }

    public static void sendUpdateMessage() {
        Via.getPlatform().runAsync(() -> {
            Pair<Level, String> pair = UpdateUtil.getUpdateMessage(true);
            if (pair != null) {
                Via.getPlatform().runSync(() -> Via.getPlatform().getLogger().log((Level)pair.key(), (String)pair.value()));
            }
        });
    }

    private static @Nullable Pair<Level, String> getUpdateMessage(boolean bl) {
        Version version;
        String string;
        if (Via.getPlatform().getPluginVersion().equals("${version}")) {
            return new Pair<Level, String>(Level.WARNING, "You are using a debug/custom version, consider updating.");
        }
        try {
            string = UpdateUtil.getNewestVersion();
        }
        catch (JsonParseException | IOException exception) {
            return bl ? new Pair<Level, String>(Level.WARNING, "Could not check for updates, check your connection.") : null;
        }
        try {
            version = new Version(Via.getPlatform().getPluginVersion());
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return new Pair<Level, String>(Level.INFO, "You are using a custom version, consider updating.");
        }
        Version version2 = new Version(string);
        if (version.compareTo(version2) < 0) {
            return new Pair<Level, CallSite>(Level.WARNING, (CallSite)((Object)("There is a newer plugin version available: " + String.valueOf(version2) + ", you're on: " + String.valueOf(version))));
        }
        if (bl && version.compareTo(version2) != 0) {
            String string2 = version.getTag().toLowerCase(Locale.ROOT);
            if (string2.endsWith("dev") || string2.endsWith("snapshot")) {
                return new Pair<Level, String>(Level.INFO, "You are running a development version of the plugin, please report any bugs to GitHub.");
            }
            return new Pair<Level, String>(Level.WARNING, "You are running a newer version of the plugin than is released!");
        }
        return null;
    }

    private static String getNewestVersion() throws IOException {
        URL uRL = new URL("https://update.viaversion.com/ViaVersion/");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.addRequestProperty("User-Agent", "ViaVersion " + Via.getPlatform().getPluginVersion() + " " + Via.getPlatform().getPlatformName());
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.setDoOutput(true);
        StringBuilder stringBuilder = new StringBuilder();
        try (Object object = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));){
            String string;
            while ((string = ((BufferedReader)object).readLine()) != null) {
                stringBuilder.append(string);
            }
        }
        object = GsonUtil.getGson().fromJson(stringBuilder.toString(), JsonObject.class);
        return ((JsonObject)object).get("name").getAsString();
    }
}

