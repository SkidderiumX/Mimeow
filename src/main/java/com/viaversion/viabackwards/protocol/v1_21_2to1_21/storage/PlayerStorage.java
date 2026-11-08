/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.viaversion.viabackwards.api.entities.storage.PlayerPositionStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;

public class PlayerStorage
extends PlayerPositionStorage {
    private static final PlayerInput EMPTY = new PlayerInput(false, false, false, false, false, false, false);
    private static final float PLAYER_JUMP_HEIGHT = 0.42f;
    private float yaw;
    private float pitch;
    private boolean playerCommandTrackedSneaking;
    private boolean playerCommandTrackedSprinting;
    private PlayerInput lastInput = EMPTY;
    private double prevX;
    private double prevY;
    private double prevZ;

    public void tick(UserConnection userConnection) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        double d = this.x() - this.prevX;
        double d2 = this.y() - this.prevY;
        double d3 = this.z() - this.prevZ;
        double d4 = Math.sqrt(d * d + d3 * d3);
        double d5 = d4 > 0.0 ? d / d4 : 0.0;
        double d6 = d4 > 0.0 ? d3 / d4 : 0.0;
        d5 = Math.max(-1.0, Math.min(1.0, d5));
        d6 = Math.max(-1.0, Math.min(1.0, d6));
        double d7 = Math.toRadians(-this.yaw);
        double d8 = d5 * Math.cos(d7) - d6 * Math.sin(d7);
        double d9 = d5 * Math.sin(d7) + d6 * Math.cos(d7);
        boolean bl5 = d9 >= (double)0.65f;
        PlayerInput playerInput = new PlayerInput(bl5, bl4 = d9 <= (double)-0.65f, bl3 = d8 >= (double)0.65f, bl2 = d8 <= (double)-0.65f, bl = Math.abs(d2 - (double)0.42f) <= (double)1.0E-4f, this.playerCommandTrackedSneaking, this.playerCommandTrackedSprinting);
        if (!this.lastInput.equals(playerInput)) {
            PacketWrapper packetWrapper = PacketWrapper.create(ServerboundPackets1_21_2.PLAYER_INPUT, userConnection);
            byte by = 0;
            by = (byte)(by | (playerInput.forward() ? 1 : 0));
            by = (byte)(by | (playerInput.backward() ? 2 : 0));
            by = (byte)(by | (playerInput.left() ? 4 : 0));
            by = (byte)(by | (playerInput.right() ? 8 : 0));
            by = (byte)(by | (playerInput.jump() ? 16 : 0));
            by = (byte)(by | (playerInput.sneak() ? 32 : 0));
            by = (byte)(by | (playerInput.sprint() ? 64 : 0));
            packetWrapper.write(Types.BYTE, by);
            packetWrapper.sendToServer(Protocol1_21_2To1_21.class);
            this.lastInput = playerInput;
        }
        this.prevX = this.x();
        this.prevY = this.y();
        this.prevZ = this.z();
    }

    public float yaw() {
        return this.yaw;
    }

    public float pitch() {
        return this.pitch;
    }

    public void setRotation(float f, float f2) {
        this.yaw = f;
        this.pitch = f2;
    }

    public void setPlayerCommandTrackedSneaking(boolean bl) {
        this.playerCommandTrackedSneaking = bl;
    }

    public void setPlayerCommandTrackedSprinting(boolean bl) {
        this.playerCommandTrackedSprinting = bl;
    }

    public boolean setSneaking(boolean bl) {
        boolean bl2 = this.playerCommandTrackedSneaking != bl;
        this.playerCommandTrackedSneaking = bl;
        return bl2;
    }

    public record PlayerInput(boolean forward, boolean backward, boolean left, boolean right, boolean jump, boolean sneak, boolean sprint) {
    }
}

