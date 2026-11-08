/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage;

import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viaversion.api.connection.StoredObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ScoreboardTracker
extends StoredObject {
    private final HashMap<String, List<String>> teams = new HashMap();
    private final HashSet<String> objectives = new HashSet();
    private final HashMap<String, ScoreTeam> scoreTeams = new HashMap();
    private final HashMap<String, Byte> teamColors = new HashMap();
    private final HashSet<String> scoreTeamNames = new HashSet();
    private final HashMap<Byte, String> colorDependentSidebar = new HashMap();
    private final HashMap<String, String> teamNameTagVisibilities = new HashMap();
    private String colorIndependentSidebar;

    public ScoreboardTracker(UserConnection userConnection) {
        super(userConnection);
    }

    public void addPlayerToTeam(String string2, String string3) {
        this.teams.computeIfAbsent(string3, string -> new ArrayList()).add(string2);
    }

    public void setTeamColor(String string, Byte by) {
        this.teamColors.put(string, by);
    }

    public Optional<Byte> getTeamColor(String string) {
        return Optional.ofNullable(this.teamColors.get(string));
    }

    public void addTeam(String string2) {
        this.teams.computeIfAbsent(string2, string -> new ArrayList());
    }

    public void removeTeam(String string) {
        this.teams.remove(string);
        this.scoreTeams.remove(string);
        this.teamColors.remove(string);
        this.teamNameTagVisibilities.remove(string);
    }

    public boolean teamExists(String string) {
        return this.teams.containsKey(string);
    }

    public void removePlayerFromTeam(String string, String string2) {
        List<String> list = this.teams.get(string2);
        if (list != null) {
            list.remove(string);
        }
    }

    public boolean isPlayerInTeam(String string, String string2) {
        List<String> list = this.teams.get(string2);
        return list != null && list.contains(string);
    }

    public boolean isPlayerInTeam(String string) {
        for (List<String> list : this.teams.values()) {
            if (!list.contains(string)) continue;
            return true;
        }
        return false;
    }

    public Optional<Byte> getPlayerTeamColor(String string) {
        Optional<String> optional = this.getTeam(string);
        return optional.isPresent() ? this.getTeamColor(optional.get()) : Optional.empty();
    }

    public Optional<String> getTeam(String string) {
        for (Map.Entry<String, List<String>> entry : this.teams.entrySet()) {
            if (!entry.getValue().contains(string)) continue;
            return Optional.of(entry.getKey());
        }
        return Optional.empty();
    }

    public void setTeamNameTagVisibility(String string, String string2) {
        this.teamNameTagVisibilities.put(string, string2);
    }

    public String getTeamNameTagVisibility(String string) {
        return this.teamNameTagVisibilities.getOrDefault(string, "always");
    }

    public boolean isNametagHidden(String string) {
        for (Map.Entry<String, List<String>> entry : this.teams.entrySet()) {
            if (!entry.getValue().contains(string)) continue;
            return "never".equalsIgnoreCase(this.teamNameTagVisibilities.getOrDefault(entry.getKey(), "always"));
        }
        return false;
    }

    public List<String> getTeamMembers(String string) {
        return this.teams.getOrDefault(string, new ArrayList());
    }

    public void addObjective(String string) {
        this.objectives.add(string);
    }

    public void removeObjective(String string) {
        this.objectives.remove(string);
        this.colorDependentSidebar.values().remove(string);
        if (string.equals(this.colorIndependentSidebar)) {
            this.colorIndependentSidebar = null;
        }
    }

    public boolean objectiveExists(String string) {
        return this.objectives.contains(string);
    }

    public String sendTeamForScore(String string) {
        if (string.length() <= 16) {
            return string;
        }
        if (this.scoreTeams.containsKey(string)) {
            return this.scoreTeams.get((Object)string).name;
        }
        for (int i = 16; i >= 1; --i) {
            int n = Math.min(16, string.length() - i);
            int n2 = Math.max(0, string.length() - i - 16);
            for (int j = n; j >= n2; --j) {
                String string2 = string.substring(j, j + i);
                if (this.scoreTeamNames.contains(string2) || this.teams.containsKey(string2)) continue;
                String string3 = string.substring(0, j);
                String string4 = j + i >= string.length() ? "" : string.substring(j + i);
                ScoreTeam scoreTeam = new ScoreTeam(string2, string3, string4);
                this.scoreTeams.put(string, scoreTeam);
                this.scoreTeamNames.add(string2);
                PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_PLAYER_TEAM, this.getUser());
                packetWrapper.write(Types.STRING, string2);
                packetWrapper.write(Types.BYTE, (byte)0);
                packetWrapper.write(Types.STRING, "ViaRewind");
                packetWrapper.write(Types.STRING, string3);
                packetWrapper.write(Types.STRING, string4);
                packetWrapper.write(Types.BYTE, (byte)0);
                packetWrapper.write(Types.SHORT, (short)1);
                packetWrapper.write(Types.STRING, string2);
                packetWrapper.send(Protocol1_8To1_7_6_10.class);
                return string2;
            }
        }
        return string;
    }

    public String removeTeamForScore(String string) {
        ScoreTeam scoreTeam = this.scoreTeams.remove(string);
        if (scoreTeam == null) {
            return string;
        }
        this.scoreTeamNames.remove(scoreTeam.name);
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_PLAYER_TEAM, this.getUser());
        packetWrapper.write(Types.STRING, scoreTeam.name);
        packetWrapper.write(Types.BYTE, (byte)1);
        packetWrapper.send(Protocol1_8To1_7_6_10.class);
        return scoreTeam.name;
    }

    public String getColorIndependentSidebar() {
        return this.colorIndependentSidebar;
    }

    public void setColorIndependentSidebar(String string) {
        this.colorIndependentSidebar = string;
    }

    public HashMap<Byte, String> getColorDependentSidebar() {
        return this.colorDependentSidebar;
    }

    private static class ScoreTeam {
        private final String prefix;
        private final String suffix;
        private final String name;

        public ScoreTeam(String string, String string2, String string3) {
            this.prefix = string2;
            this.suffix = string3;
            this.name = string;
        }
    }
}

