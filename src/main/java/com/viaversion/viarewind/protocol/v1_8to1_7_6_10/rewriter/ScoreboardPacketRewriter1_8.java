/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter;

import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.EntityTracker1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.ScoreboardTracker;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.util.ChatColorUtil;
import java.util.ArrayList;
import java.util.Optional;

public class ScoreboardPacketRewriter1_8
extends RewriterBase<Protocol1_8To1_7_6_10> {
    public ScoreboardPacketRewriter1_8(Protocol1_8To1_7_6_10 protocol1_8To1_7_6_10) {
        super(protocol1_8To1_7_6_10);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_OBJECTIVE, packetWrapper -> {
            String string;
            String string2 = packetWrapper.passthrough(Types.STRING);
            if (string2.length() > 16) {
                string2 = string2.substring(0, 16);
                packetWrapper.set(Types.STRING, 0, string2);
            }
            byte by = packetWrapper.read(Types.BYTE);
            ScoreboardTracker scoreboardTracker = packetWrapper.user().get(ScoreboardTracker.class);
            if (by == 0) {
                if (scoreboardTracker.objectiveExists(string2)) {
                    packetWrapper.cancel();
                    return;
                }
                scoreboardTracker.addObjective(string2);
            } else if (by == 1) {
                String string3;
                Optional<Byte> optional;
                if (!scoreboardTracker.objectiveExists(string2)) {
                    packetWrapper.cancel();
                    return;
                }
                if (scoreboardTracker.getColorIndependentSidebar() != null && (optional = scoreboardTracker.getPlayerTeamColor(string = packetWrapper.user().getProtocolInfo().getUsername())).isPresent() && string2.equals(string3 = scoreboardTracker.getColorDependentSidebar().get(optional.get()))) {
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_DISPLAY_OBJECTIVE, packetWrapper.user());
                    packetWrapper2.write(Types.BYTE, (byte)1);
                    packetWrapper2.write(Types.STRING, scoreboardTracker.getColorIndependentSidebar());
                    packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
                }
                scoreboardTracker.removeObjective(string2);
            } else if (by == 2 && !scoreboardTracker.objectiveExists(string2)) {
                packetWrapper.cancel();
                return;
            }
            if (by == 0 || by == 2) {
                string = packetWrapper.passthrough(Types.STRING);
                if (string.length() > 32) {
                    packetWrapper.set(Types.STRING, 1, string.substring(0, 32));
                }
                packetWrapper.read(Types.STRING);
            } else {
                packetWrapper.write(Types.STRING, "");
            }
            packetWrapper.write(Types.BYTE, by);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_SCORE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.VAR_INT, Types.BYTE);
                this.handler(packetWrapper -> {
                    ScoreboardTracker scoreboardTracker = packetWrapper.user().get(ScoreboardTracker.class);
                    String string = packetWrapper.get(Types.STRING, 0);
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    string = by == 1 ? scoreboardTracker.removeTeamForScore(string) : scoreboardTracker.sendTeamForScore(string);
                    if (string.length() > 16 && (string = ChatColorUtil.stripColor(string)).length() > 16) {
                        string = string.substring(0, 16);
                    }
                    packetWrapper.set(Types.STRING, 0, string);
                    String string2 = packetWrapper.read(Types.STRING);
                    if (string2.length() > 16) {
                        string2 = string2.substring(0, 16);
                    }
                    if (by != 1) {
                        int n = packetWrapper.read(Types.VAR_INT);
                        packetWrapper.write(Types.STRING, string2);
                        packetWrapper.write(Types.INT, n);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_DISPLAY_OBJECTIVE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.BYTE, 0).byteValue();
                    String string = packetWrapper.get(Types.STRING, 0);
                    ScoreboardTracker scoreboardTracker = packetWrapper.user().get(ScoreboardTracker.class);
                    if (n > 2) {
                        byte by = (byte)(n - 3);
                        scoreboardTracker.getColorDependentSidebar().put(by, string);
                        String string2 = packetWrapper.user().getProtocolInfo().getUsername();
                        Optional<Byte> optional = scoreboardTracker.getPlayerTeamColor(string2);
                        n = optional.isPresent() && optional.get() == by ? 1 : -1;
                    } else if (n == 1) {
                        scoreboardTracker.setColorIndependentSidebar(string);
                        String string3 = packetWrapper.user().getProtocolInfo().getUsername();
                        Optional<Byte> optional = scoreboardTracker.getPlayerTeamColor(string3);
                        if (optional.isPresent() && scoreboardTracker.getColorDependentSidebar().containsKey(optional.get())) {
                            n = -1;
                        }
                    }
                    if (n == -1) {
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.set(Types.BYTE, 0, (byte)n);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_PLAYER_TEAM, packetWrapper -> {
            Object object2;
            String string = packetWrapper.passthrough(Types.STRING);
            if (string == null) {
                packetWrapper.cancel();
                return;
            }
            ScoreboardTracker scoreboardTracker = packetWrapper.user().get(ScoreboardTracker.class);
            EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by != 0 && !scoreboardTracker.teamExists(string)) {
                packetWrapper.cancel();
                return;
            }
            if (by == 0 && scoreboardTracker.teamExists(string)) {
                scoreboardTracker.removeTeam(string);
                object2 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_PLAYER_TEAM, packetWrapper.user());
                object2.write(Types.STRING, string);
                object2.write(Types.BYTE, (byte)1);
                object2.send(Protocol1_8To1_7_6_10.class);
            }
            if (by == 0) {
                scoreboardTracker.addTeam(string);
            } else if (by == 1) {
                for (String object3 : scoreboardTracker.getTeamMembers(string)) {
                    entityTracker1_8.checkNametagVisbility(object3);
                }
                scoreboardTracker.removeTeam(string);
            }
            if (by == 0 || by == 2) {
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.BYTE);
                object2 = packetWrapper.read(Types.STRING);
                String string2 = scoreboardTracker.getTeamNameTagVisibility(string);
                scoreboardTracker.setTeamNameTagVisibility(string, (String)object2);
                byte by2 = packetWrapper.read(Types.BYTE);
                if (by == 2 && scoreboardTracker.getTeamColor(string).get() != by2) {
                    String string3 = scoreboardTracker.getColorDependentSidebar().get(by2);
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_DISPLAY_OBJECTIVE, packetWrapper.user());
                    packetWrapper2.write(Types.BYTE, (byte)1);
                    packetWrapper2.write(Types.STRING, string3 == null ? "" : string3);
                    packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
                }
                scoreboardTracker.setTeamColor(string, by2);
                if (by == 2 && !((String)object2).equals(string2)) {
                    for (String string4 : scoreboardTracker.getTeamMembers(string)) {
                        entityTracker1_8.checkNametagVisbility(string4);
                    }
                }
            }
            if (by == 0 || by == 3 || by == 4) {
                byte by3 = scoreboardTracker.getTeamColor(string).get();
                String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
                ArrayList<String> arrayList = new ArrayList<String>();
                for (String string5 : stringArray) {
                    String string6 = packetWrapper.user().getProtocolInfo().getUsername();
                    if (by == 4) {
                        if (!scoreboardTracker.isPlayerInTeam(string5, string)) continue;
                        scoreboardTracker.removePlayerFromTeam(string5, string);
                        entityTracker1_8.checkNametagVisbility(string5);
                        if (string5.equals(string6)) {
                            var13_22 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_DISPLAY_OBJECTIVE, packetWrapper.user());
                            var13_22.write(Types.BYTE, (byte)1);
                            var13_22.write(Types.STRING, scoreboardTracker.getColorIndependentSidebar() == null ? "" : scoreboardTracker.getColorIndependentSidebar());
                            var13_22.scheduleSend(Protocol1_8To1_7_6_10.class);
                        }
                    } else {
                        scoreboardTracker.addPlayerToTeam(string5, string);
                        entityTracker1_8.checkNametagVisbility(string5);
                        if (string5.equals(string6) && scoreboardTracker.getColorDependentSidebar().containsKey(by3)) {
                            var13_22 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_DISPLAY_OBJECTIVE, packetWrapper.user());
                            var13_22.write(Types.BYTE, (byte)1);
                            var13_22.write(Types.STRING, scoreboardTracker.getColorDependentSidebar().get(by3));
                            var13_22.scheduleSend(Protocol1_8To1_7_6_10.class);
                        }
                    }
                    arrayList.add(string5);
                }
                packetWrapper.write(Types.SHORT, (short)arrayList.size());
                for (String string7 : arrayList) {
                    packetWrapper.write(Types.STRING, string7);
                }
            }
        });
    }
}

