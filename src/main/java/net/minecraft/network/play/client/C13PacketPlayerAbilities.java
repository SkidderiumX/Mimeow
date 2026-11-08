/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C13PacketPlayerAbilities
implements Packet<INetHandlerPlayServer> {
    private boolean invulnerable;
    private boolean flying;
    private boolean allowFlying;
    private boolean creativeMode;
    private float flySpeed;
    private float walkSpeed;

    public C13PacketPlayerAbilities() {
    }

    public C13PacketPlayerAbilities(PlayerCapabilities playerCapabilities) {
        this.setInvulnerable(playerCapabilities.disableDamage);
        this.setFlying(playerCapabilities.isFlying);
        this.setAllowFlying(playerCapabilities.allowFlying);
        this.setCreativeMode(playerCapabilities.isCreativeMode);
        this.setFlySpeed(playerCapabilities.getFlySpeed());
        this.setWalkSpeed(playerCapabilities.getWalkSpeed());
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        byte by = packetBuffer.readByte();
        this.setInvulnerable((by & 1) > 0);
        this.setFlying((by & 2) > 0);
        this.setAllowFlying((by & 4) > 0);
        this.setCreativeMode((by & 8) > 0);
        this.setFlySpeed(packetBuffer.readFloat());
        this.setWalkSpeed(packetBuffer.readFloat());
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        byte by = 0;
        if (this.isInvulnerable()) {
            by = (byte)(by | 1);
        }
        if (this.isFlying()) {
            by = (byte)(by | 2);
        }
        if (this.isAllowFlying()) {
            by = (byte)(by | 4);
        }
        if (this.isCreativeMode()) {
            by = (byte)(by | 8);
        }
        packetBuffer.writeByte(by);
        packetBuffer.writeFloat(this.flySpeed);
        packetBuffer.writeFloat(this.walkSpeed);
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processPlayerAbilities(this);
    }

    public boolean isInvulnerable() {
        return this.invulnerable;
    }

    public void setInvulnerable(boolean bl) {
        this.invulnerable = bl;
    }

    public boolean isFlying() {
        return this.flying;
    }

    public void setFlying(boolean bl) {
        this.flying = bl;
    }

    public boolean isAllowFlying() {
        return this.allowFlying;
    }

    public void setAllowFlying(boolean bl) {
        this.allowFlying = bl;
    }

    public boolean isCreativeMode() {
        return this.creativeMode;
    }

    public void setCreativeMode(boolean bl) {
        this.creativeMode = bl;
    }

    public void setFlySpeed(float f) {
        this.flySpeed = f;
    }

    public void setWalkSpeed(float f) {
        this.walkSpeed = f;
    }
}

