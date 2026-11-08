/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C01PacketChatMessage;

public class C01
extends CPacket {
    public String message;

    public C01(String string) {
        super(null);
        this.message = string;
    }

    public C01(C01PacketChatMessage c01PacketChatMessage, byte by) {
        super(c01PacketChatMessage);
        this.message = c01PacketChatMessage.getMessage();
    }

    @Override
    public C01PacketChatMessage convert() {
        return new C01PacketChatMessage(this.message);
    }
}

