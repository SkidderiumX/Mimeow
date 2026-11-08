/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.stats;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.event.HoverEvent;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.stats.IStatType;
import net.minecraft.stats.ObjectiveStat;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IJsonSerializable;

public class StatBase {
    public final String statId;
    private final IChatComponent statName;
    public boolean isIndependent;
    private final IStatType type;
    private final IScoreObjectiveCriteria objectiveCriteria;
    private Class<? extends IJsonSerializable> field_150956_d;
    private static NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.US);
    public static IStatType simpleStatType = new IStatType(){

        @Override
        public String format(int n) {
            return numberFormat.format(n);
        }
    };
    private static DecimalFormat decimalFormat = new DecimalFormat("########0.00");
    public static IStatType timeStatType = new IStatType(){

        @Override
        public String format(int n) {
            double d = (double)n / 20.0;
            double d2 = d / 60.0;
            double d3 = d2 / 60.0;
            double d4 = d3 / 24.0;
            double d5 = d4 / 365.0;
            return d5 > 0.5 ? decimalFormat.format(d5) + " y" : (d4 > 0.5 ? decimalFormat.format(d4) + " d" : (d3 > 0.5 ? decimalFormat.format(d3) + " h" : (d2 > 0.5 ? decimalFormat.format(d2) + " m" : d + " s")));
        }
    };
    public static IStatType distanceStatType = new IStatType(){

        @Override
        public String format(int n) {
            double d = (double)n / 100.0;
            double d2 = d / 1000.0;
            return d2 > 0.5 ? decimalFormat.format(d2) + " km" : (d > 0.5 ? decimalFormat.format(d) + " m" : n + " cm");
        }
    };
    public static IStatType field_111202_k = new IStatType(){

        @Override
        public String format(int n) {
            return decimalFormat.format((double)n * 0.1);
        }
    };

    public StatBase(String string, IChatComponent iChatComponent, IStatType iStatType) {
        this.statId = string;
        this.statName = iChatComponent;
        this.type = iStatType;
        this.objectiveCriteria = new ObjectiveStat(this);
        IScoreObjectiveCriteria.INSTANCES.put(this.objectiveCriteria.getName(), this.objectiveCriteria);
    }

    public StatBase(String string, IChatComponent iChatComponent) {
        this(string, iChatComponent, simpleStatType);
    }

    public StatBase initIndependentStat() {
        this.isIndependent = true;
        return this;
    }

    public StatBase registerStat() {
        if (StatList.oneShotStats.containsKey(this.statId)) {
            throw new RuntimeException("Duplicate stat id: \"" + String.valueOf(StatList.oneShotStats.get((Object)this.statId).statName) + "\" and \"" + String.valueOf(this.statName) + "\" at id " + this.statId);
        }
        StatList.allStats.add(this);
        StatList.oneShotStats.put(this.statId, this);
        return this;
    }

    public boolean isAchievement() {
        return false;
    }

    public String format(int n) {
        return this.type.format(n);
    }

    public IChatComponent getStatName() {
        IChatComponent iChatComponent = this.statName.createCopy();
        iChatComponent.getChatStyle().setColor(EnumChatFormatting.GRAY);
        iChatComponent.getChatStyle().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ACHIEVEMENT, new ChatComponentText(this.statId)));
        return iChatComponent;
    }

    public IChatComponent createChatComponent() {
        IChatComponent iChatComponent = this.getStatName();
        IChatComponent iChatComponent2 = new ChatComponentText("[").appendSibling(iChatComponent).appendText("]");
        iChatComponent2.setChatStyle(iChatComponent.getChatStyle());
        return iChatComponent2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            StatBase statBase = (StatBase)object;
            return this.statId.equals(statBase.statId);
        }
        return false;
    }

    public int hashCode() {
        return this.statId.hashCode();
    }

    public String toString() {
        return "Stat{id=" + this.statId + ", nameId=" + String.valueOf(this.statName) + ", awardLocallyOnly=" + this.isIndependent + ", formatter=" + String.valueOf(this.type) + ", objectiveCriteria=" + String.valueOf(this.objectiveCriteria) + "}";
    }

    public IScoreObjectiveCriteria getCriteria() {
        return this.objectiveCriteria;
    }

    public Class<? extends IJsonSerializable> func_150954_l() {
        return this.field_150956_d;
    }

    public StatBase func_150953_b(Class<? extends IJsonSerializable> clazz) {
        this.field_150956_d = clazz;
        return this;
    }
}

