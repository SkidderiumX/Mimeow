/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.base.v1_7;

import com.google.common.base.Joiner;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.ProtocolPathEntry;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.VersionProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.protocol.ProtocolManagerImpl;
import com.viaversion.viaversion.protocol.ServerProtocolVersionSingleton;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ClientboundStatusPackets;
import com.viaversion.viaversion.protocols.base.packet.BaseClientboundPacket;
import com.viaversion.viaversion.protocols.base.packet.BasePacketTypesProvider;
import com.viaversion.viaversion.protocols.base.packet.BaseServerboundPacket;
import com.viaversion.viaversion.util.GsonUtil;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public class ClientboundBaseProtocol1_7
extends AbstractProtocol<BaseClientboundPacket, BaseClientboundPacket, BaseServerboundPacket, BaseServerboundPacket> {
    public ClientboundBaseProtocol1_7() {
        super(BaseClientboundPacket.class, BaseClientboundPacket.class, BaseServerboundPacket.class, BaseServerboundPacket.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundStatusPackets.STATUS_RESPONSE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ProtocolInfo protocolInfo = packetWrapper.user().getProtocolInfo();
                    String string = packetWrapper.get(Types.STRING, 0);
                    try {
                        ProtocolVersion protocolVersion;
                        Object object;
                        JsonObject jsonObject;
                        JsonElement jsonElement = GsonUtil.getGson().fromJson(string, JsonElement.class);
                        int n = 0;
                        if (jsonElement.isJsonObject()) {
                            if (jsonElement.getAsJsonObject().has("version")) {
                                jsonObject = jsonElement.getAsJsonObject().get("version").getAsJsonObject();
                                if (jsonObject.has("protocol")) {
                                    n = Long.valueOf(jsonObject.get("protocol").getAsLong()).intValue();
                                }
                            } else {
                                jsonObject = new JsonObject();
                                jsonElement.getAsJsonObject().add("version", jsonObject);
                            }
                        } else {
                            jsonElement = new JsonObject();
                            jsonObject = new JsonObject();
                            jsonElement.getAsJsonObject().add("version", jsonObject);
                        }
                        ProtocolVersion protocolVersion2 = ProtocolVersion.getProtocol(n);
                        if (Via.getConfig().isSendSupportedVersions()) {
                            jsonObject.add("supportedVersions", GsonUtil.getGson().toJsonTree(Via.getAPI().getSupportedVersions()));
                        }
                        if (!Via.getAPI().getServerVersion().isKnown()) {
                            object = (ProtocolManagerImpl)Via.getManager().getProtocolManager();
                            ((ProtocolManagerImpl)object).setServerProtocol(new ServerProtocolVersionSingleton(protocolVersion2));
                        }
                        if ((object = Via.getManager().getProviders().get(VersionProvider.class)) == null) {
                            packetWrapper.user().setActive(false);
                            return;
                        }
                        try {
                            protocolVersion = object.getClosestServerProtocol(packetWrapper.user());
                        }
                        catch (Exception exception) {
                            throw new RuntimeException(exception);
                        }
                        List<ProtocolPathEntry> list = Via.getManager().getProtocolManager().getProtocolPath(protocolInfo.protocolVersion(), protocolVersion);
                        if (list != null) {
                            if (protocolVersion2.equalTo(protocolVersion) || protocolVersion2.getVersion() == 0) {
                                jsonObject.addProperty("protocol", protocolInfo.protocolVersion().getOriginalVersion());
                            }
                        } else {
                            packetWrapper.user().setActive(false);
                        }
                        if (Via.getConfig().blockedProtocolVersions().contains(protocolInfo.protocolVersion())) {
                            jsonObject.addProperty("protocol", -1);
                        }
                        packetWrapper.set(Types.STRING, 0, GsonUtil.getGson().toJson(jsonElement));
                    }
                    catch (JsonParseException jsonParseException) {
                        Via.getPlatform().getLogger().log(Level.SEVERE, "Error handling StatusResponse", jsonParseException);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundLoginPackets.LOGIN_COMPRESSION, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.user().getProtocolInfo().setCompressionEnabled(n >= 0);
        });
        this.registerClientbound(ClientboundLoginPackets.LOGIN_FINISHED, packetWrapper -> {
            ProtocolInfo protocolInfo = packetWrapper.user().getProtocolInfo();
            UUID uUID = this.passthroughUUID(packetWrapper);
            protocolInfo.setUuid(uUID);
            String string = packetWrapper.passthrough(Types.STRING);
            protocolInfo.setUsername(string);
            ClientboundBaseProtocol1_7.onLoginSuccess(packetWrapper.user());
        });
    }

    @Override
    public boolean isBaseProtocol() {
        return true;
    }

    public UUID passthroughUUID(PacketWrapper packetWrapper) {
        String string = packetWrapper.passthrough(Types.STRING);
        if (string.length() == 32) {
            string = ClientboundBaseProtocol1_7.addDashes(string);
        }
        return UUID.fromString(string);
    }

    public static String addDashes(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.insert(20, '-');
        stringBuilder.insert(16, '-');
        stringBuilder.insert(12, '-');
        stringBuilder.insert(8, '-');
        return stringBuilder.toString();
    }

    public static void onLoginSuccess(UserConnection userConnection) {
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        if (protocolInfo.protocolVersion().olderThan(ProtocolVersion.v1_20_2)) {
            protocolInfo.setState(State.PLAY);
        }
        Via.getManager().getConnectionManager().onLoginSuccess(userConnection);
        if (!protocolInfo.getPipeline().hasNonBaseProtocols()) {
            userConnection.setActive(false);
        }
        if (Via.getManager().isDebug()) {
            Via.getPlatform().getLogger().log(Level.INFO, "{0} logged in with protocol {1}, Route: {2}", new Object[]{protocolInfo.getUsername(), protocolInfo.protocolVersion().getName(), Joiner.on(", ").join(protocolInfo.getPipeline().pipes(), ", ", new Object[0])});
        }
    }

    @Override
    protected PacketTypesProvider<BaseClientboundPacket, BaseClientboundPacket, BaseServerboundPacket, BaseServerboundPacket> createPacketTypesProvider() {
        return BasePacketTypesProvider.INSTANCE;
    }
}

