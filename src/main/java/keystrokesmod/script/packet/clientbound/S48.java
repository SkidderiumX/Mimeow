/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S48PacketResourcePackSend;

public class S48
extends SPacket {
    public String url;
    public String hash;

    public S48(S48PacketResourcePackSend s48PacketResourcePackSend) {
        super(s48PacketResourcePackSend);
        this.url = s48PacketResourcePackSend.getURL();
        this.hash = s48PacketResourcePackSend.getHash();
    }

    public S48(String string, String string2) {
        super(new S48PacketResourcePackSend(string, string2));
        this.url = string;
        this.hash = string2;
    }
}

