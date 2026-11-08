/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.util.ChatComponentText;
import x.oc7ab2161b9f;

public class S45
extends SPacket {
    public String type;
    public String message;
    private int fadeInTime;
    private int displayTime;
    private int fadeOutTime;

    public S45(S45PacketTitle s45PacketTitle) {
        super(s45PacketTitle);
        this.type = s45PacketTitle.getType().name();
        this.message = s45PacketTitle.getMessage().getUnformattedText();
        this.fadeInTime = s45PacketTitle.getFadeInTime();
        this.displayTime = s45PacketTitle.getDisplayTime();
        this.fadeOutTime = s45PacketTitle.getFadeOutTime();
    }

    public S45(String string, String string2, int n, int n2, int n3) {
        super(new S45PacketTitle(oc7ab2161b9f.\u0120(S45PacketTitle.Type.class, string), new ChatComponentText(string2), n, n2, n3));
        this.type = string;
        this.message = string2;
        this.fadeInTime = n;
        this.displayTime = n2;
        this.fadeOutTime = n3;
    }
}

