/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.base.v1_7;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.base.packet.BaseClientboundPacket;
import com.viaversion.viaversion.protocols.base.packet.BasePacketTypesProvider;
import com.viaversion.viaversion.protocols.base.packet.BaseServerboundPacket;
import com.viaversion.viaversion.util.ChatColorUtil;
import com.viaversion.viaversion.util.ComponentUtil;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.logging.Level;

public class ServerboundBaseProtocol1_7
extends AbstractProtocol<BaseClientboundPacket, BaseClientboundPacket, BaseServerboundPacket, BaseServerboundPacket> {
    public ServerboundBaseProtocol1_7() {
        super(BaseClientboundPacket.class, BaseClientboundPacket.class, BaseServerboundPacket.class, BaseServerboundPacket.class);
    }

    @Override
    protected void registerPackets() {
        this.registerServerbound(ServerboundLoginPackets.LOGIN_ACKNOWLEDGED, packetWrapper -> {
            ProtocolInfo protocolInfo = packetWrapper.user().getProtocolInfo();
            protocolInfo.setState(State.CONFIGURATION);
        });
        this.registerServerbound(ServerboundLoginPackets.HELLO, packetWrapper -> {
            UserConnection userConnection = packetWrapper.user();
            ProtocolVersion protocolVersion = userConnection.getProtocolInfo().protocolVersion();
            if (Via.getConfig().blockedProtocolVersions().contains(protocolVersion)) {
                if (!userConnection.getChannel().isOpen() || !userConnection.shouldApplyBlockProtocol()) {
                    return;
                }
                packetWrapper.cancel();
                String string = ChatColorUtil.translateAlternateColorCodes(Via.getConfig().getBlockedDisconnectMsg());
                PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundLoginPackets.LOGIN_DISCONNECT, userConnection);
                JsonObject jsonObject = ComponentUtil.plainToJson(string);
                if (protocolVersion.olderThanOrEqualTo(ProtocolVersion.v1_8)) {
                    packetWrapper2.write(Types.STRING, jsonObject.toString());
                } else {
                    packetWrapper2.write(Types.COMPONENT, jsonObject);
                }
                ChannelFuture channelFuture = packetWrapper2.sendFutureRaw();
                channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>)((GenericFutureListener<Future>)future -> userConnection.getChannel().close()));
                if (Via.getConfig().logBlockedJoins()) {
                    Via.getPlatform().getLogger().log(Level.INFO, "Blocked join due to unsupported version from " + String.valueOf(userConnection.getChannel().remoteAddress()) + " (" + protocolVersion.getName() + ")");
                }
            }
        });
    }

    @Override
    public boolean isBaseProtocol() {
        return true;
    }

    @Override
    protected PacketTypesProvider<BaseClientboundPacket, BaseClientboundPacket, BaseServerboundPacket, BaseServerboundPacket> createPacketTypesProvider() {
        return BasePacketTypesProvider.INSTANCE;
    }
}

