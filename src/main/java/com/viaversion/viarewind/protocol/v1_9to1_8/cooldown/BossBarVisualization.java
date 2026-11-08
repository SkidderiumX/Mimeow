/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.cooldown;

import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.CooldownVisualization;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import java.util.UUID;

public class BossBarVisualization
implements CooldownVisualization {
    private final UserConnection user;
    private UUID bossUUID;

    public BossBarVisualization(UserConnection userConnection) {
        this.user = userConnection;
    }

    @Override
    public void show(double d) throws Exception {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9.BOSS_EVENT, this.user);
        if (this.bossUUID == null) {
            this.bossUUID = UUID.randomUUID();
            packetWrapper.write(Types.UUID, this.bossUUID);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.COMPONENT, new JsonPrimitive(" "));
            packetWrapper.write(Types.FLOAT, Float.valueOf((float)d));
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)0);
        } else {
            packetWrapper.write(Types.UUID, this.bossUUID);
            packetWrapper.write(Types.VAR_INT, 2);
            packetWrapper.write(Types.FLOAT, Float.valueOf((float)d));
        }
        packetWrapper.send(Protocol1_9To1_8.class, false);
    }

    @Override
    public void hide() throws Exception {
        if (this.bossUUID == null) {
            return;
        }
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9.BOSS_EVENT, this.user);
        packetWrapper.write(Types.UUID, this.bossUUID);
        packetWrapper.write(Types.VAR_INT, 1);
        packetWrapper.send(Protocol1_9To1_8.class, false);
        this.bossUUID = null;
    }
}

