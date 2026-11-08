/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.storage;

import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PlayerPositionTracker
implements StorableObject {
    private final Queue<PacketWrapper> animations = new ConcurrentLinkedQueue<PacketWrapper>();
    private double posX;
    private double posY;
    private double posZ;
    private float yaw;
    private float pitch;
    private boolean onGround;
    private int confirmId = -1;

    public void setPos(double d, double d2, double d3) {
        this.posX = d;
        this.posY = d2;
        this.posZ = d3;
    }

    public void sendAnimations() {
        PacketWrapper packetWrapper;
        while ((packetWrapper = this.animations.poll()) != null) {
            packetWrapper.sendToServer(Protocol1_9To1_8.class);
        }
    }

    public void queueAnimation(PacketWrapper packetWrapper) {
        this.animations.add(packetWrapper);
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getPosZ() {
        return this.posZ;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float f) {
        this.yaw = f % 360.0f;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setPitch(float f) {
        this.pitch = f % 360.0f;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

    public void setOnGround(boolean bl) {
        this.onGround = bl;
    }

    public int getConfirmId() {
        return this.confirmId;
    }

    public void setConfirmId(int n) {
        this.confirmId = n;
    }
}

