/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.EnumChatFormatting;

public class Scoreboard {
    private final Map<String, ScoreObjective> scoreObjectives = Maps.newHashMap();
    private final Map<IScoreObjectiveCriteria, List<ScoreObjective>> scoreObjectiveCriterias = Maps.newHashMap();
    private final Map<String, Map<ScoreObjective, Score>> entitiesScoreObjectives = Maps.newHashMap();
    private final ScoreObjective[] objectiveDisplaySlots = new ScoreObjective[19];
    private final Map<String, ScorePlayerTeam> teams = Maps.newHashMap();
    private final Map<String, ScorePlayerTeam> teamMemberships = Maps.newHashMap();
    private static String[] field_178823_g = null;

    public ScoreObjective getObjective(String string) {
        return this.scoreObjectives.get(string);
    }

    public ScoreObjective addScoreObjective(String string, IScoreObjectiveCriteria iScoreObjectiveCriteria) {
        if (string.length() > 16) {
            throw new IllegalArgumentException("The objective name '" + string + "' is too long!");
        }
        ScoreObjective scoreObjective = this.getObjective(string);
        if (scoreObjective != null) {
            throw new IllegalArgumentException("An objective with the name '" + string + "' already exists!");
        }
        scoreObjective = new ScoreObjective(this, string, iScoreObjectiveCriteria);
        List<ScoreObjective> list = this.scoreObjectiveCriterias.get(iScoreObjectiveCriteria);
        if (list == null) {
            list = Lists.newArrayList();
            this.scoreObjectiveCriterias.put(iScoreObjectiveCriteria, list);
        }
        list.add(scoreObjective);
        this.scoreObjectives.put(string, scoreObjective);
        this.onScoreObjectiveAdded(scoreObjective);
        return scoreObjective;
    }

    public Collection<ScoreObjective> getObjectivesFromCriteria(IScoreObjectiveCriteria iScoreObjectiveCriteria) {
        Collection collection = this.scoreObjectiveCriterias.get(iScoreObjectiveCriteria);
        return collection == null ? Lists.newArrayList() : Lists.newArrayList(collection);
    }

    public boolean entityHasObjective(String string, ScoreObjective scoreObjective) {
        Map<ScoreObjective, Score> map = this.entitiesScoreObjectives.get(string);
        if (map == null) {
            return false;
        }
        Score score = map.get(scoreObjective);
        return score != null;
    }

    public Score getValueFromObjective(String string, ScoreObjective scoreObjective) {
        Score score;
        if (string.length() > 40) {
            throw new IllegalArgumentException("The player name '" + string + "' is too long!");
        }
        Map<ScoreObjective, Score> map = this.entitiesScoreObjectives.get(string);
        if (map == null) {
            map = Maps.newHashMap();
            this.entitiesScoreObjectives.put(string, map);
        }
        if ((score = map.get(scoreObjective)) == null) {
            score = new Score(this, scoreObjective, string);
            map.put(scoreObjective, score);
        }
        return score;
    }

    public Collection<Score> getSortedScores(ScoreObjective scoreObjective) {
        ArrayList<Score> arrayList = Lists.newArrayList();
        for (Map<ScoreObjective, Score> map : this.entitiesScoreObjectives.values()) {
            Score score = map.get(scoreObjective);
            if (score == null) continue;
            arrayList.add(score);
        }
        Collections.sort(arrayList, Score.scoreComparator);
        return arrayList;
    }

    public Collection<ScoreObjective> getScoreObjectives() {
        return this.scoreObjectives.values();
    }

    public Collection<String> getObjectiveNames() {
        return this.entitiesScoreObjectives.keySet();
    }

    public void removeObjectiveFromEntity(String string, ScoreObjective scoreObjective) {
        if (scoreObjective == null) {
            Map<ScoreObjective, Score> map = this.entitiesScoreObjectives.remove(string);
            if (map != null) {
                this.func_96516_a(string);
            }
        } else {
            Map<ScoreObjective, Score> map = this.entitiesScoreObjectives.get(string);
            if (map != null) {
                Score score = map.remove(scoreObjective);
                if (map.size() < 1) {
                    Map<ScoreObjective, Score> map2 = this.entitiesScoreObjectives.remove(string);
                    if (map2 != null) {
                        this.func_96516_a(string);
                    }
                } else if (score != null) {
                    this.func_178820_a(string, scoreObjective);
                }
            }
        }
    }

    public Collection<Score> getScores() {
        Collection<Map<ScoreObjective, Score>> collection = this.entitiesScoreObjectives.values();
        ArrayList<Score> arrayList = Lists.newArrayList();
        for (Map<ScoreObjective, Score> map : collection) {
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    public Map<ScoreObjective, Score> getObjectivesForEntity(String string) {
        Map<ScoreObjective, Score> map = this.entitiesScoreObjectives.get(string);
        if (map == null) {
            map = Maps.newHashMap();
        }
        return map;
    }

    public void removeObjective(ScoreObjective scoreObjective) {
        this.scoreObjectives.remove(scoreObjective.getName());
        for (int i = 0; i < 19; ++i) {
            if (this.getObjectiveInDisplaySlot(i) != scoreObjective) continue;
            this.setObjectiveInDisplaySlot(i, null);
        }
        List<ScoreObjective> list = this.scoreObjectiveCriterias.get(scoreObjective.getCriteria());
        if (list != null) {
            list.remove(scoreObjective);
        }
        for (Map<ScoreObjective, Score> map : this.entitiesScoreObjectives.values()) {
            map.remove(scoreObjective);
        }
        this.onScoreObjectiveRemoved(scoreObjective);
    }

    public void setObjectiveInDisplaySlot(int n, ScoreObjective scoreObjective) {
        this.objectiveDisplaySlots[n] = scoreObjective;
    }

    public ScoreObjective getObjectiveInDisplaySlot(int n) {
        return this.objectiveDisplaySlots[n];
    }

    public ScorePlayerTeam getTeam(String string) {
        return this.teams.get(string);
    }

    public ScorePlayerTeam createTeam(String string) {
        if (string.length() > 16) {
            throw new IllegalArgumentException("The team name '" + string + "' is too long!");
        }
        ScorePlayerTeam scorePlayerTeam = this.getTeam(string);
        if (scorePlayerTeam != null) {
            throw new IllegalArgumentException("A team with the name '" + string + "' already exists!");
        }
        scorePlayerTeam = new ScorePlayerTeam(this, string);
        this.teams.put(string, scorePlayerTeam);
        this.broadcastTeamCreated(scorePlayerTeam);
        return scorePlayerTeam;
    }

    public void removeTeam(ScorePlayerTeam scorePlayerTeam) {
        this.teams.remove(scorePlayerTeam.getRegisteredName());
        for (String string : scorePlayerTeam.getMembershipCollection()) {
            this.teamMemberships.remove(string);
        }
        this.func_96513_c(scorePlayerTeam);
    }

    public boolean addPlayerToTeam(String string, String string2) {
        if (string.length() > 40) {
            throw new IllegalArgumentException("The player name '" + string + "' is too long!");
        }
        if (!this.teams.containsKey(string2)) {
            return false;
        }
        ScorePlayerTeam scorePlayerTeam = this.getTeam(string2);
        if (this.getPlayersTeam(string) != null) {
            this.removePlayerFromTeams(string);
        }
        this.teamMemberships.put(string, scorePlayerTeam);
        scorePlayerTeam.getMembershipCollection().add(string);
        return true;
    }

    public boolean removePlayerFromTeams(String string) {
        ScorePlayerTeam scorePlayerTeam = this.getPlayersTeam(string);
        if (scorePlayerTeam != null) {
            this.removePlayerFromTeam(string, scorePlayerTeam);
            return true;
        }
        return false;
    }

    public void removePlayerFromTeam(String string, ScorePlayerTeam scorePlayerTeam) {
        if (this.getPlayersTeam(string) != scorePlayerTeam) {
            throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team '" + scorePlayerTeam.getRegisteredName() + "'.");
        }
        this.teamMemberships.remove(string);
        scorePlayerTeam.getMembershipCollection().remove(string);
    }

    public Collection<String> getTeamNames() {
        return this.teams.keySet();
    }

    public Collection<ScorePlayerTeam> getTeams() {
        return this.teams.values();
    }

    public ScorePlayerTeam getPlayersTeam(String string) {
        return this.teamMemberships.get(string);
    }

    public void onScoreObjectiveAdded(ScoreObjective scoreObjective) {
    }

    public void onObjectiveDisplayNameChanged(ScoreObjective scoreObjective) {
    }

    public void onScoreObjectiveRemoved(ScoreObjective scoreObjective) {
    }

    public void func_96536_a(Score score) {
    }

    public void func_96516_a(String string) {
    }

    public void func_178820_a(String string, ScoreObjective scoreObjective) {
    }

    public void broadcastTeamCreated(ScorePlayerTeam scorePlayerTeam) {
    }

    public void sendTeamUpdate(ScorePlayerTeam scorePlayerTeam) {
    }

    public void func_96513_c(ScorePlayerTeam scorePlayerTeam) {
    }

    public static String getObjectiveDisplaySlot(int n) {
        EnumChatFormatting enumChatFormatting;
        switch (n) {
            case 0: {
                return "list";
            }
            case 1: {
                return "sidebar";
            }
            case 2: {
                return "belowName";
            }
        }
        if (n >= 3 && n <= 18 && (enumChatFormatting = EnumChatFormatting.func_175744_a(n - 3)) != null && enumChatFormatting != EnumChatFormatting.RESET) {
            return "sidebar.team." + enumChatFormatting.getFriendlyName();
        }
        return null;
    }

    public static int getObjectiveDisplaySlotNumber(String string) {
        String string2;
        EnumChatFormatting enumChatFormatting;
        if (string.equalsIgnoreCase("list")) {
            return 0;
        }
        if (string.equalsIgnoreCase("sidebar")) {
            return 1;
        }
        if (string.equalsIgnoreCase("belowName")) {
            return 2;
        }
        if (string.startsWith("sidebar.team.") && (enumChatFormatting = EnumChatFormatting.getValueByName(string2 = string.substring("sidebar.team.".length()))) != null && enumChatFormatting.getColorIndex() >= 0) {
            return enumChatFormatting.getColorIndex() + 3;
        }
        return -1;
    }

    public static String[] getDisplaySlotStrings() {
        if (field_178823_g == null) {
            field_178823_g = new String[19];
            for (int i = 0; i < 19; ++i) {
                Scoreboard.field_178823_g[i] = Scoreboard.getObjectiveDisplaySlot(i);
            }
        }
        return field_178823_g;
    }

    public void func_181140_a(Entity entity) {
        if (entity != null && !(entity instanceof EntityPlayer) && !entity.isEntityAlive()) {
            String string = entity.getUniqueID().toString();
            this.removeObjectiveFromEntity(string, null);
            this.removePlayerFromTeams(string);
        }
    }
}

