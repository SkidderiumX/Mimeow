/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldSavedData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScoreboardSaveData
extends WorldSavedData {
    private static final Logger logger = LogManager.getLogger();
    private Scoreboard theScoreboard;
    private NBTTagCompound delayedInitNbt;

    public ScoreboardSaveData() {
        this("scoreboard");
    }

    public ScoreboardSaveData(String string) {
        super(string);
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.theScoreboard = scoreboard;
        if (this.delayedInitNbt != null) {
            this.readFromNBT(this.delayedInitNbt);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        if (this.theScoreboard == null) {
            this.delayedInitNbt = nBTTagCompound;
        } else {
            this.readObjectives(nBTTagCompound.getTagList("Objectives", 10));
            this.readScores(nBTTagCompound.getTagList("PlayerScores", 10));
            if (nBTTagCompound.hasKey("DisplaySlots", 10)) {
                this.readDisplayConfig(nBTTagCompound.getCompoundTag("DisplaySlots"));
            }
            if (nBTTagCompound.hasKey("Teams", 9)) {
                this.readTeams(nBTTagCompound.getTagList("Teams", 10));
            }
        }
    }

    protected void readTeams(NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            Team.EnumVisible enumVisible;
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
            String string = nBTTagCompound.getString("Name");
            if (string.length() > 16) {
                string = string.substring(0, 16);
            }
            ScorePlayerTeam scorePlayerTeam = this.theScoreboard.createTeam(string);
            String string2 = nBTTagCompound.getString("DisplayName");
            if (string2.length() > 32) {
                string2 = string2.substring(0, 32);
            }
            scorePlayerTeam.setTeamName(string2);
            if (nBTTagCompound.hasKey("TeamColor", 8)) {
                scorePlayerTeam.setChatFormat(EnumChatFormatting.getValueByName(nBTTagCompound.getString("TeamColor")));
            }
            scorePlayerTeam.setNamePrefix(nBTTagCompound.getString("Prefix"));
            scorePlayerTeam.setNameSuffix(nBTTagCompound.getString("Suffix"));
            if (nBTTagCompound.hasKey("AllowFriendlyFire", 99)) {
                scorePlayerTeam.setAllowFriendlyFire(nBTTagCompound.getBoolean("AllowFriendlyFire"));
            }
            if (nBTTagCompound.hasKey("SeeFriendlyInvisibles", 99)) {
                scorePlayerTeam.setSeeFriendlyInvisiblesEnabled(nBTTagCompound.getBoolean("SeeFriendlyInvisibles"));
            }
            if (nBTTagCompound.hasKey("NameTagVisibility", 8) && (enumVisible = Team.EnumVisible.func_178824_a(nBTTagCompound.getString("NameTagVisibility"))) != null) {
                scorePlayerTeam.setNameTagVisibility(enumVisible);
            }
            if (nBTTagCompound.hasKey("DeathMessageVisibility", 8) && (enumVisible = Team.EnumVisible.func_178824_a(nBTTagCompound.getString("DeathMessageVisibility"))) != null) {
                scorePlayerTeam.setDeathMessageVisibility(enumVisible);
            }
            this.func_96502_a(scorePlayerTeam, nBTTagCompound.getTagList("Players", 8));
        }
    }

    protected void func_96502_a(ScorePlayerTeam scorePlayerTeam, NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            this.theScoreboard.addPlayerToTeam(nBTTagList.getStringTagAt(i), scorePlayerTeam.getRegisteredName());
        }
    }

    protected void readDisplayConfig(NBTTagCompound nBTTagCompound) {
        for (int i = 0; i < 19; ++i) {
            if (!nBTTagCompound.hasKey("slot_" + i, 8)) continue;
            String string = nBTTagCompound.getString("slot_" + i);
            ScoreObjective scoreObjective = this.theScoreboard.getObjective(string);
            this.theScoreboard.setObjectiveInDisplaySlot(i, scoreObjective);
        }
    }

    protected void readObjectives(NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
            IScoreObjectiveCriteria iScoreObjectiveCriteria = IScoreObjectiveCriteria.INSTANCES.get(nBTTagCompound.getString("CriteriaName"));
            if (iScoreObjectiveCriteria == null) continue;
            String string = nBTTagCompound.getString("Name");
            if (string.length() > 16) {
                string = string.substring(0, 16);
            }
            ScoreObjective scoreObjective = this.theScoreboard.addScoreObjective(string, iScoreObjectiveCriteria);
            scoreObjective.setDisplayName(nBTTagCompound.getString("DisplayName"));
            scoreObjective.setRenderType(IScoreObjectiveCriteria.EnumRenderType.func_178795_a(nBTTagCompound.getString("RenderType")));
        }
    }

    protected void readScores(NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
            ScoreObjective scoreObjective = this.theScoreboard.getObjective(nBTTagCompound.getString("Objective"));
            String string = nBTTagCompound.getString("Name");
            if (string.length() > 40) {
                string = string.substring(0, 40);
            }
            Score score = this.theScoreboard.getValueFromObjective(string, scoreObjective);
            score.setScorePoints(nBTTagCompound.getInteger("Score"));
            if (!nBTTagCompound.hasKey("Locked")) continue;
            score.setLocked(nBTTagCompound.getBoolean("Locked"));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        if (this.theScoreboard == null) {
            logger.warn("Tried to save scoreboard without having a scoreboard...");
        } else {
            nBTTagCompound.setTag("Objectives", this.objectivesToNbt());
            nBTTagCompound.setTag("PlayerScores", this.scoresToNbt());
            nBTTagCompound.setTag("Teams", this.func_96496_a());
            this.func_96497_d(nBTTagCompound);
        }
    }

    protected NBTTagList func_96496_a() {
        NBTTagList nBTTagList = new NBTTagList();
        for (ScorePlayerTeam scorePlayerTeam : this.theScoreboard.getTeams()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setString("Name", scorePlayerTeam.getRegisteredName());
            nBTTagCompound.setString("DisplayName", scorePlayerTeam.getTeamName());
            if (scorePlayerTeam.getChatFormat().getColorIndex() >= 0) {
                nBTTagCompound.setString("TeamColor", scorePlayerTeam.getChatFormat().getFriendlyName());
            }
            nBTTagCompound.setString("Prefix", scorePlayerTeam.getColorPrefix());
            nBTTagCompound.setString("Suffix", scorePlayerTeam.getColorSuffix());
            nBTTagCompound.setBoolean("AllowFriendlyFire", scorePlayerTeam.getAllowFriendlyFire());
            nBTTagCompound.setBoolean("SeeFriendlyInvisibles", scorePlayerTeam.getSeeFriendlyInvisiblesEnabled());
            nBTTagCompound.setString("NameTagVisibility", scorePlayerTeam.getNameTagVisibility().internalName);
            nBTTagCompound.setString("DeathMessageVisibility", scorePlayerTeam.getDeathMessageVisibility().internalName);
            NBTTagList nBTTagList2 = new NBTTagList();
            for (String string : scorePlayerTeam.getMembershipCollection()) {
                nBTTagList2.appendTag(new NBTTagString(string));
            }
            nBTTagCompound.setTag("Players", nBTTagList2);
            nBTTagList.appendTag(nBTTagCompound);
        }
        return nBTTagList;
    }

    protected void func_96497_d(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        boolean bl = false;
        for (int i = 0; i < 19; ++i) {
            ScoreObjective scoreObjective = this.theScoreboard.getObjectiveInDisplaySlot(i);
            if (scoreObjective == null) continue;
            nBTTagCompound2.setString("slot_" + i, scoreObjective.getName());
            bl = true;
        }
        if (bl) {
            nBTTagCompound.setTag("DisplaySlots", nBTTagCompound2);
        }
    }

    protected NBTTagList objectivesToNbt() {
        NBTTagList nBTTagList = new NBTTagList();
        for (ScoreObjective scoreObjective : this.theScoreboard.getScoreObjectives()) {
            if (scoreObjective.getCriteria() == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setString("Name", scoreObjective.getName());
            nBTTagCompound.setString("CriteriaName", scoreObjective.getCriteria().getName());
            nBTTagCompound.setString("DisplayName", scoreObjective.getDisplayName());
            nBTTagCompound.setString("RenderType", scoreObjective.getRenderType().func_178796_a());
            nBTTagList.appendTag(nBTTagCompound);
        }
        return nBTTagList;
    }

    protected NBTTagList scoresToNbt() {
        NBTTagList nBTTagList = new NBTTagList();
        for (Score score : this.theScoreboard.getScores()) {
            if (score.getObjective() == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setString("Name", score.getPlayerName());
            nBTTagCompound.setString("Objective", score.getObjective().getName());
            nBTTagCompound.setInteger("Score", score.getScorePoints());
            nBTTagCompound.setBoolean("Locked", score.isLocked());
            nBTTagList.appendTag(nBTTagCompound);
        }
        return nBTTagList;
    }
}

