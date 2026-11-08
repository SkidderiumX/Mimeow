/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.task;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.PlayerSessionStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.WorldBorderEmulator;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import java.util.logging.Level;

public class WorldBorderUpdateTask
implements Runnable {
    public static final int VIEW_DISTANCE = 16;

    @Override
    public void run() {
        for (UserConnection userConnection : Via.getManager().getConnectionManager().getConnections()) {
            WorldBorderEmulator worldBorderEmulator = userConnection.get(WorldBorderEmulator.class);
            if (worldBorderEmulator == null || !worldBorderEmulator.isInit()) continue;
            PlayerSessionStorage playerSessionStorage = userConnection.get(PlayerSessionStorage.class);
            double d = worldBorderEmulator.getSize() / 2.0;
            for (WorldBorderEmulator.Side side : WorldBorderEmulator.Side.values()) {
                double d2;
                double d3;
                double d4;
                if (side.modX != 0) {
                    d4 = playerSessionStorage.getPosZ();
                    d3 = worldBorderEmulator.getZ();
                    d2 = Math.abs(worldBorderEmulator.getX() + d * (double)side.modX - playerSessionStorage.getPosX());
                } else {
                    d3 = worldBorderEmulator.getX();
                    d4 = playerSessionStorage.getPosX();
                    d2 = Math.abs(worldBorderEmulator.getZ() + d * (double)side.modZ - playerSessionStorage.getPosZ());
                }
                if (d2 >= 16.0) continue;
                double d5 = Math.sqrt(256.0 - d2 * d2);
                double d6 = Math.ceil(d4 - d5);
                double d7 = Math.floor(d4 + d5);
                double d8 = Math.ceil(playerSessionStorage.getPosY() - d5);
                double d9 = Math.floor(playerSessionStorage.getPosY() + d5);
                if (d6 < d3 - d) {
                    d6 = Math.ceil(d3 - d);
                }
                if (d7 > d3 + d) {
                    d7 = Math.floor(d3 + d);
                }
                if (d8 < 0.0) {
                    d8 = 0.0;
                }
                double d10 = (d6 + d7) / 2.0;
                double d11 = (d8 + d9) / 2.0;
                double d12 = 2.5;
                PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_8.LEVEL_PARTICLES, userConnection);
                packetWrapper.write(Types.STRING, ViaRewind.getConfig().getWorldBorderParticle());
                packetWrapper.write(Types.FLOAT, Float.valueOf((float)(side.modX != 0 ? worldBorderEmulator.getX() + d * (double)side.modX : d10)));
                packetWrapper.write(Types.FLOAT, Float.valueOf((float)d11));
                packetWrapper.write(Types.FLOAT, Float.valueOf((float)(side.modX == 0 ? worldBorderEmulator.getZ() + d * (double)side.modZ : d10)));
                packetWrapper.write(Types.FLOAT, Float.valueOf((float)(side.modX != 0 ? 0.0 : (d7 - d6) / d12)));
                packetWrapper.write(Types.FLOAT, Float.valueOf((float)((d9 - d8) / d12)));
                packetWrapper.write(Types.FLOAT, Float.valueOf((float)(side.modX == 0 ? 0.0 : (d7 - d6) / d12)));
                packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
                packetWrapper.write(Types.INT, (int)Math.floor((d7 - d6) * (d9 - d8) * 0.5));
                try {
                    packetWrapper.send(Protocol1_8To1_7_6_10.class);
                }
                catch (Exception exception) {
                    ViaRewind.getPlatform().getLogger().log(Level.SEVERE, "Failed to send world border particle", exception);
                }
            }
        }
    }
}

