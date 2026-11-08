/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.login.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginClient;

public class S02PacketLoginSuccess
implements Packet<INetHandlerLoginClient> {
    private GameProfile profile;

    public S02PacketLoginSuccess() {
    }

    public S02PacketLoginSuccess(GameProfile gameProfile) {
        this.profile = gameProfile;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        String string = packetBuffer.readStringFromBuffer(36);
        String string2 = packetBuffer.readStringFromBuffer(16);
        UUID uUID = UUID.fromString(string);
        this.profile = new GameProfile(uUID, string2);
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        UUID uUID = this.profile.getId();
        packetBuffer.writeString(uUID == null ? "" : uUID.toString());
        packetBuffer.writeString(this.profile.getName());
    }

    @Override
    public void processPacket(INetHandlerLoginClient iNetHandlerLoginClient) {
        iNetHandlerLoginClient.handleLoginSuccess(this);
    }

    public GameProfile getProfile() {
        return this.profile;
    }
}

