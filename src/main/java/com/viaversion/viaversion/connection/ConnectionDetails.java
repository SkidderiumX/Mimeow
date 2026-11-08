/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.nio.charset.StandardCharsets;

public class ConnectionDetails {
    public static final String PROXY_CHANNEL = "vv:proxy_details";
    public static final String SERVER_CHANNEL = "vv:server_details";
    public static final String MOD_CHANNEL = "vv:mod_details";
    public static final String APP_CHANNEL = "vv:app_details";
    private static final int VERSION = 1;

    public static void sendConnectionDetails(UserConnection userConnection, String string) {
        ConnectionDetails.sendPlayerDetails(userConnection, string);
        ConnectionDetails.sendServerDetails(userConnection, string);
    }

    public static void sendPlayerDetails(UserConnection userConnection, String string) {
        if (!Via.getConfig().sendPlayerDetails()) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("specVersion", 1);
        String string2 = Via.getPlatform().getPlatformName();
        String string3 = Via.getPlatform().getPlatformVersion();
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        ProtocolVersion protocolVersion = protocolInfo.protocolVersion();
        jsonObject.addProperty("platformName", string2);
        jsonObject.addProperty("platformVersion", string3);
        jsonObject.addProperty("version", protocolVersion.getOriginalVersion());
        jsonObject.addProperty("versionName", protocolVersion.getName());
        jsonObject.addProperty("versionType", protocolVersion.getVersionType().name());
        Via.getPlatform().modifyPlayerDetails(userConnection, jsonObject);
        Via.getPlatform().sendCustomPayload(userConnection, string, jsonObject.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static void sendServerDetails(UserConnection userConnection, String string) {
        if (!Via.getConfig().sendServerDetails()) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("specVersion", 1);
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        ProtocolVersion protocolVersion = protocolInfo.serverProtocolVersion();
        jsonObject.addProperty("version", protocolVersion.getOriginalVersion());
        jsonObject.addProperty("versionName", protocolVersion.getName());
        jsonObject.addProperty("versionType", protocolVersion.getVersionType().name());
        Via.getPlatform().modifyServerDetails(userConnection, jsonObject);
        Via.getPlatform().sendCustomPayloadToClient(userConnection, string, jsonObject.toString().getBytes(StandardCharsets.UTF_8));
    }
}

