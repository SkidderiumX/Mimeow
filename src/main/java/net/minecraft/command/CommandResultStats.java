/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CommandResultStats {
    private static final int NUM_RESULT_TYPES = Type.values().length;
    private static final String[] STRING_RESULT_TYPES = new String[NUM_RESULT_TYPES];
    private String[] entitiesID = STRING_RESULT_TYPES;
    private String[] objectives = STRING_RESULT_TYPES;

    public void setCommandStatScore(final ICommandSender iCommandSender, Type type, int n) {
        String string = this.entitiesID[type.getTypeID()];
        if (string != null) {
            Scoreboard scoreboard;
            ScoreObjective scoreObjective;
            String string2;
            ICommandSender iCommandSender2 = new ICommandSender(){

                @Override
                public String getName() {
                    return iCommandSender.getName();
                }

                @Override
                public IChatComponent getDisplayName() {
                    return iCommandSender.getDisplayName();
                }

                @Override
                public void addChatMessage(IChatComponent iChatComponent) {
                    iCommandSender.addChatMessage(iChatComponent);
                }

                @Override
                public boolean canCommandSenderUseCommand(int n, String string) {
                    return true;
                }

                @Override
                public BlockPos getPosition() {
                    return iCommandSender.getPosition();
                }

                @Override
                public Vec3 getPositionVector() {
                    return iCommandSender.getPositionVector();
                }

                @Override
                public World getEntityWorld() {
                    return iCommandSender.getEntityWorld();
                }

                @Override
                public Entity getCommandSenderEntity() {
                    return iCommandSender.getCommandSenderEntity();
                }

                @Override
                public boolean sendCommandFeedback() {
                    return iCommandSender.sendCommandFeedback();
                }

                @Override
                public void setCommandStat(Type type, int n) {
                    iCommandSender.setCommandStat(type, n);
                }
            };
            try {
                string2 = CommandBase.getEntityName(iCommandSender2, string);
            }
            catch (EntityNotFoundException entityNotFoundException) {
                return;
            }
            String string3 = this.objectives[type.getTypeID()];
            if (string3 != null && (scoreObjective = (scoreboard = iCommandSender.getEntityWorld().getScoreboard()).getObjective(string3)) != null && scoreboard.entityHasObjective(string2, scoreObjective)) {
                Score score = scoreboard.getValueFromObjective(string2, scoreObjective);
                score.setScorePoints(n);
            }
        }
    }

    public void readStatsFromNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound.hasKey("CommandStats", 10)) {
            NBTTagCompound nBTTagCompound2 = nBTTagCompound.getCompoundTag("CommandStats");
            for (Type type : Type.values()) {
                String string = type.getTypeName() + "Name";
                String string2 = type.getTypeName() + "Objective";
                if (!nBTTagCompound2.hasKey(string, 8) || !nBTTagCompound2.hasKey(string2, 8)) continue;
                String string3 = nBTTagCompound2.getString(string);
                String string4 = nBTTagCompound2.getString(string2);
                CommandResultStats.setScoreBoardStat(this, type, string3, string4);
            }
        }
    }

    public void writeStatsToNBT(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        for (Type type : Type.values()) {
            String string = this.entitiesID[type.getTypeID()];
            String string2 = this.objectives[type.getTypeID()];
            if (string == null || string2 == null) continue;
            nBTTagCompound2.setString(type.getTypeName() + "Name", string);
            nBTTagCompound2.setString(type.getTypeName() + "Objective", string2);
        }
        if (!nBTTagCompound2.hasNoTags()) {
            nBTTagCompound.setTag("CommandStats", nBTTagCompound2);
        }
    }

    public static void setScoreBoardStat(CommandResultStats commandResultStats, Type type, String string, String string2) {
        if (string != null && string.length() != 0 && string2 != null && string2.length() != 0) {
            if (commandResultStats.entitiesID == STRING_RESULT_TYPES || commandResultStats.objectives == STRING_RESULT_TYPES) {
                commandResultStats.entitiesID = new String[NUM_RESULT_TYPES];
                commandResultStats.objectives = new String[NUM_RESULT_TYPES];
            }
            commandResultStats.entitiesID[type.getTypeID()] = string;
            commandResultStats.objectives[type.getTypeID()] = string2;
        } else {
            CommandResultStats.removeScoreBoardStat(commandResultStats, type);
        }
    }

    private static void removeScoreBoardStat(CommandResultStats commandResultStats, Type type) {
        if (commandResultStats.entitiesID != STRING_RESULT_TYPES && commandResultStats.objectives != STRING_RESULT_TYPES) {
            commandResultStats.entitiesID[type.getTypeID()] = null;
            commandResultStats.objectives[type.getTypeID()] = null;
            boolean bl = true;
            for (Type type2 : Type.values()) {
                if (commandResultStats.entitiesID[type2.getTypeID()] == null || commandResultStats.objectives[type2.getTypeID()] == null) continue;
                bl = false;
                break;
            }
            if (bl) {
                commandResultStats.entitiesID = STRING_RESULT_TYPES;
                commandResultStats.objectives = STRING_RESULT_TYPES;
            }
        }
    }

    public void addAllStats(CommandResultStats commandResultStats) {
        for (Type type : Type.values()) {
            CommandResultStats.setScoreBoardStat(this, type, commandResultStats.entitiesID[type.getTypeID()], commandResultStats.objectives[type.getTypeID()]);
        }
    }

    public static enum Type {
        SUCCESS_COUNT(0, "SuccessCount"),
        AFFECTED_BLOCKS(1, "AffectedBlocks"),
        AFFECTED_ENTITIES(2, "AffectedEntities"),
        AFFECTED_ITEMS(3, "AffectedItems"),
        QUERY_RESULT(4, "QueryResult");

        final int typeID;
        final String typeName;

        private Type(int n2, String string2) {
            this.typeID = n2;
            this.typeName = string2;
        }

        public int getTypeID() {
            return this.typeID;
        }

        public String getTypeName() {
            return this.typeName;
        }

        public static String[] getTypeNames() {
            String[] stringArray = new String[Type.values().length];
            int n = 0;
            for (Type type : Type.values()) {
                stringArray[n++] = type.getTypeName();
            }
            return stringArray;
        }

        public static Type getTypeByName(String string) {
            for (Type type : Type.values()) {
                if (!type.getTypeName().equals(string)) continue;
                return type;
            }
            return null;
        }
    }
}

