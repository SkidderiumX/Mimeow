/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S07PacketRespawn;

public class TerrainTransitionGate {
    private volatile boolean active;

    TerrainTransitionGate() {
    }

    boolean beginIfBoundary(Packet<?> packet) {
        if (packet instanceof S01PacketJoinGame || packet instanceof S07PacketRespawn) {
            this.active = true;
            return true;
        }
        return false;
    }

    boolean shouldBypassHooks() {
        return this.active;
    }

    void complete() {
        this.active = false;
    }

    void reset() {
        this.active = false;
    }
}

