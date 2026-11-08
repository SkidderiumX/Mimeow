/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import java.util.Collection;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S3EPacketTeams;

public class S3E
extends SPacket {
    public String name;
    public String displayName;
    public String prefix;
    public String suffix;
    public String nametagVisibility;
    public Collection<String> playerList;
    public int action;
    public int friendlyFlags;
    public int color;

    public S3E(S3EPacketTeams s3EPacketTeams) {
        super(s3EPacketTeams);
        this.name = s3EPacketTeams.getName();
        this.displayName = s3EPacketTeams.getDisplayName();
        this.prefix = s3EPacketTeams.getPrefix();
        this.suffix = s3EPacketTeams.getSuffix();
        this.nametagVisibility = s3EPacketTeams.getNameTagVisibility();
        this.playerList = s3EPacketTeams.getPlayers();
        this.action = s3EPacketTeams.getAction();
        this.friendlyFlags = s3EPacketTeams.getFriendlyFlags();
        this.color = s3EPacketTeams.getColor();
    }

    public S3E(Packet packet, String string, String string2, String string3, String string4, String string5, Collection<String> collection, int n, int n2, int n3) {
        super(packet);
        this.name = string;
        this.displayName = string2;
        this.prefix = string3;
        this.suffix = string4;
        this.nametagVisibility = string5;
        this.playerList = collection;
        this.action = n;
        this.friendlyFlags = n2;
        this.color = n3;
    }
}

