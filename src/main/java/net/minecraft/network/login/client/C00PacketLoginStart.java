/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.login.client;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginServer;

public class C00PacketLoginStart
implements Packet<INetHandlerLoginServer> {
    private GameProfile profile;

    public C00PacketLoginStart() {
    }

    public C00PacketLoginStart(GameProfile gameProfile) {
        this.profile = gameProfile;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.profile = new GameProfile(null, packetBuffer.readStringFromBuffer(16));
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeString(this.profile.getName());
    }

    @Override
    public void processPacket(INetHandlerLoginServer iNetHandlerLoginServer) {
        iNetHandlerLoginServer.processLoginStart(this);
    }

    public GameProfile getProfile() {
        return this.profile;
    }
}

