/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C16PacketClientStatus;
import x.oc7ab2161b9f;

public class C16
extends CPacket {
    public String status;

    public C16(String string) {
        super(null);
        this.status = string;
    }

    public C16(C16PacketClientStatus c16PacketClientStatus) {
        super(c16PacketClientStatus);
        this.status = c16PacketClientStatus.getStatus().name();
    }

    @Override
    public C16PacketClientStatus convert() {
        return new C16PacketClientStatus(oc7ab2161b9f.\u0120(C16PacketClientStatus.EnumState.class, this.status));
    }
}

