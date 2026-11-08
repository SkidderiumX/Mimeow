/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;

public class S02
extends SPacket {
    public byte type;
    public String message;

    public S02(S02PacketChat s02PacketChat) {
        super(s02PacketChat);
        this.type = s02PacketChat.getType();
        this.message = s02PacketChat.getChatComponent().getUnformattedText();
    }

    public S02(byte by, String string) {
        super(new S02PacketChat(new ChatComponentText(string), by));
        this.type = by;
        this.message = string;
    }
}

