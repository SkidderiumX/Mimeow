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
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import java.util.function.Consumer;

public class TitleCooldownVisualization
implements CooldownVisualization {
    private static final int ACTION_SET_TITLE = 0;
    private static final int ACTION_SET_SUBTITLE = 1;
    private static final int ACTION_SET_TIMES_AND_DISPLAY = 2;
    private static final int ACTION_HIDE = 3;
    private final UserConnection user;

    public TitleCooldownVisualization(UserConnection userConnection) {
        this.user = userConnection;
    }

    @Override
    public void show(double d) throws Exception {
        String string = CooldownVisualization.buildProgressText("\u02d9", d);
        this.sendTitlePacket(0, packetWrapper -> packetWrapper.write(Types.COMPONENT, new JsonPrimitive("")));
        this.sendTitlePacket(1, packetWrapper -> packetWrapper.write(Types.COMPONENT, new JsonPrimitive(string)));
        this.sendTitlePacket(2, packetWrapper -> {
            packetWrapper.write(Types.INT, 0);
            packetWrapper.write(Types.INT, 2);
            packetWrapper.write(Types.INT, 5);
        });
    }

    @Override
    public void hide() throws Exception {
        this.sendTitlePacket(3, packetWrapper -> {});
    }

    private void sendTitlePacket(int n, Consumer<PacketWrapper> consumer) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_8.SET_TITLES, this.user);
        packetWrapper.write(Types.VAR_INT, n);
        consumer.accept(packetWrapper);
        packetWrapper.scheduleSend(Protocol1_9To1_8.class);
    }
}

