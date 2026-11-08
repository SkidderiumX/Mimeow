/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion;

import com.viaversion.viaversion.ViaAPIBase;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import io.netty.buffer.ByteBuf;

public class UserConnectionViaAPI
extends ViaAPIBase<UserConnection> {
    @Override
    public ProtocolVersion getPlayerProtocolVersion(UserConnection userConnection) {
        return userConnection.getProtocolInfo().protocolVersion();
    }

    @Override
    public void sendRawPacket(UserConnection userConnection, ByteBuf byteBuf) {
        userConnection.sendRawPacket(byteBuf);
    }
}

