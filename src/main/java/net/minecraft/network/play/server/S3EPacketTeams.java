/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;

public class S3EPacketTeams
implements Packet<INetHandlerPlayClient> {
    private String name = "";
    private String displayName = "";
    private String prefix = "";
    private String suffix = "";
    private String nameTagVisibility;
    private int color;
    private Collection<String> players;
    private int action;
    private int friendlyFlags;

    public S3EPacketTeams() {
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.color = -1;
        this.players = Lists.newArrayList();
    }

    public S3EPacketTeams(ScorePlayerTeam scorePlayerTeam, int n) {
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.color = -1;
        this.players = Lists.newArrayList();
        this.name = scorePlayerTeam.getRegisteredName();
        this.action = n;
        if (n == 0 || n == 2) {
            this.displayName = scorePlayerTeam.getTeamName();
            this.prefix = scorePlayerTeam.getColorPrefix();
            this.suffix = scorePlayerTeam.getColorSuffix();
            this.friendlyFlags = scorePlayerTeam.func_98299_i();
            this.nameTagVisibility = scorePlayerTeam.getNameTagVisibility().internalName;
            this.color = scorePlayerTeam.getChatFormat().getColorIndex();
        }
        if (n == 0) {
            this.players.addAll(scorePlayerTeam.getMembershipCollection());
        }
    }

    public S3EPacketTeams(ScorePlayerTeam scorePlayerTeam, Collection<String> collection, int n) {
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.color = -1;
        this.players = Lists.newArrayList();
        if (n != 3 && n != 4) {
            throw new IllegalArgumentException("Method must be join or leave for player constructor");
        }
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Players cannot be null/empty");
        }
        this.action = n;
        this.name = scorePlayerTeam.getRegisteredName();
        this.players.addAll(collection);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.name = packetBuffer.readStringFromBuffer(16);
        this.action = packetBuffer.readByte();
        if (this.action == 0 || this.action == 2) {
            this.displayName = packetBuffer.readStringFromBuffer(32);
            this.prefix = packetBuffer.readStringFromBuffer(16);
            this.suffix = packetBuffer.readStringFromBuffer(16);
            this.friendlyFlags = packetBuffer.readByte();
            this.nameTagVisibility = packetBuffer.readStringFromBuffer(32);
            this.color = packetBuffer.readByte();
        }
        if (this.action == 0 || this.action == 3 || this.action == 4) {
            int n = packetBuffer.readVarIntFromBuffer();
            for (int i = 0; i < n; ++i) {
                this.players.add(packetBuffer.readStringFromBuffer(40));
            }
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeString(this.name);
        packetBuffer.writeByte(this.action);
        if (this.action == 0 || this.action == 2) {
            packetBuffer.writeString(this.displayName);
            packetBuffer.writeString(this.prefix);
            packetBuffer.writeString(this.suffix);
            packetBuffer.writeByte(this.friendlyFlags);
            packetBuffer.writeString(this.nameTagVisibility);
            packetBuffer.writeByte(this.color);
        }
        if (this.action == 0 || this.action == 3 || this.action == 4) {
            packetBuffer.writeVarIntToBuffer(this.players.size());
            for (String string : this.players) {
                packetBuffer.writeString(string);
            }
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleTeams(this);
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public Collection<String> getPlayers() {
        return this.players;
    }

    public int getAction() {
        return this.action;
    }

    public int getFriendlyFlags() {
        return this.friendlyFlags;
    }

    public int getColor() {
        return this.color;
    }

    public String getNameTagVisibility() {
        return this.nameTagVisibility;
    }
}

