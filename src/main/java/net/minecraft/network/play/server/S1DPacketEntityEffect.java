/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.potion.PotionEffect;

public class S1DPacketEntityEffect
implements Packet<INetHandlerPlayClient> {
    private int entityId;
    private byte effectId;
    private byte amplifier;
    private int duration;
    private byte hideParticles;

    public S1DPacketEntityEffect() {
    }

    public S1DPacketEntityEffect(int n, PotionEffect potionEffect) {
        this.entityId = n;
        this.effectId = (byte)(potionEffect.getPotionID() & 0xFF);
        this.amplifier = (byte)(potionEffect.getAmplifier() & 0xFF);
        this.duration = potionEffect.getDuration() > Short.MAX_VALUE ? Short.MAX_VALUE : potionEffect.getDuration();
        this.hideParticles = (byte)(potionEffect.getIsShowParticles() ? 1 : 0);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.entityId = packetBuffer.readVarIntFromBuffer();
        this.effectId = packetBuffer.readByte();
        this.amplifier = packetBuffer.readByte();
        this.duration = packetBuffer.readVarIntFromBuffer();
        this.hideParticles = packetBuffer.readByte();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.entityId);
        packetBuffer.writeByte(this.effectId);
        packetBuffer.writeByte(this.amplifier);
        packetBuffer.writeVarIntToBuffer(this.duration);
        packetBuffer.writeByte(this.hideParticles);
    }

    public boolean func_149429_c() {
        return this.duration == Short.MAX_VALUE;
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleEntityEffect(this);
    }

    public int getEntityId() {
        return this.entityId;
    }

    public byte getEffectId() {
        return this.effectId;
    }

    public byte getAmplifier() {
        return this.amplifier;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean func_179707_f() {
        return this.hideParticles != 0;
    }
}

