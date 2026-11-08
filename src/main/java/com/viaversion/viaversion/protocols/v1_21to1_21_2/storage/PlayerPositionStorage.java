/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;

public class PlayerPositionStorage
implements StorableObject {
    private final IntSet pendingPongs = new IntOpenHashSet();
    private boolean captureNextPlayerPositionPacket;
    private PlayerPosition playerPosition;

    public void sendPing(UserConnection userConnection, int n) {
        if (!this.pendingPongs.add(n)) {
            throw new IllegalStateException("Pong already pending for id " + n);
        }
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_2.PING, userConnection);
        packetWrapper.write(Types.INT, n);
        packetWrapper.send(Protocol1_21To1_21_2.class);
    }

    public boolean checkPong(int n) {
        if (this.pendingPongs.remove(n)) {
            this.reset();
            this.captureNextPlayerPositionPacket = true;
            return true;
        }
        return false;
    }

    public boolean checkCaptureNextPlayerPositionPacket() {
        if (this.captureNextPlayerPositionPacket) {
            this.captureNextPlayerPositionPacket = false;
            return true;
        }
        this.reset();
        return false;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean checkHasPlayerPosition() {
        if (this.playerPosition != null) {
            return true;
        }
        this.reset();
        return false;
    }

    public void sendMovePlayerPosRot(UserConnection userConnection) {
        PacketWrapper packetWrapper = PacketWrapper.create(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, userConnection);
        packetWrapper.write(Types.DOUBLE, this.playerPosition.x);
        packetWrapper.write(Types.DOUBLE, this.playerPosition.y);
        packetWrapper.write(Types.DOUBLE, this.playerPosition.z);
        packetWrapper.write(Types.FLOAT, Float.valueOf(this.playerPosition.yaw));
        packetWrapper.write(Types.FLOAT, Float.valueOf(this.playerPosition.pitch));
        packetWrapper.write(Types.BOOLEAN, this.playerPosition.onGround);
        packetWrapper.sendToServer(Protocol1_21To1_21_2.class);
        this.reset();
    }

    public void reset() {
        this.captureNextPlayerPositionPacket = false;
        this.playerPosition = null;
    }

    public record PlayerPosition(double x, double y, double z, float yaw, float pitch, boolean onGround) {
    }
}

