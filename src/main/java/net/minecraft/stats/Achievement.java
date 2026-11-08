/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.stats;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.IStatStringFormat;
import net.minecraft.stats.StatBase;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IJsonSerializable;
import net.minecraft.util.StatCollector;

public class Achievement
extends StatBase {
    public final int displayColumn;
    public final int displayRow;
    public final Achievement parentAchievement;
    private final String achievementDescription;
    private IStatStringFormat statStringFormatter;
    public final ItemStack theItemStack;
    private boolean isSpecial;

    public Achievement(String string, String string2, int n, int n2, Item item, Achievement achievement) {
        this(string, string2, n, n2, new ItemStack(item), achievement);
    }

    public Achievement(String string, String string2, int n, int n2, Block block, Achievement achievement) {
        this(string, string2, n, n2, new ItemStack(block), achievement);
    }

    public Achievement(String string, String string2, int n, int n2, ItemStack itemStack, Achievement achievement) {
        super(string, new ChatComponentTranslation("achievement." + string2, new Object[0]));
        this.theItemStack = itemStack;
        this.achievementDescription = "achievement." + string2 + ".desc";
        this.displayColumn = n;
        this.displayRow = n2;
        if (n < AchievementList.minDisplayColumn) {
            AchievementList.minDisplayColumn = n;
        }
        if (n2 < AchievementList.minDisplayRow) {
            AchievementList.minDisplayRow = n2;
        }
        if (n > AchievementList.maxDisplayColumn) {
            AchievementList.maxDisplayColumn = n;
        }
        if (n2 > AchievementList.maxDisplayRow) {
            AchievementList.maxDisplayRow = n2;
        }
        this.parentAchievement = achievement;
    }

    @Override
    public Achievement initIndependentStat() {
        this.isIndependent = true;
        return this;
    }

    public Achievement setSpecial() {
        this.isSpecial = true;
        return this;
    }

    @Override
    public Achievement registerStat() {
        super.registerStat();
        AchievementList.achievementList.add(this);
        return this;
    }

    @Override
    public boolean isAchievement() {
        return true;
    }

    @Override
    public IChatComponent getStatName() {
        IChatComponent iChatComponent = super.getStatName();
        iChatComponent.getChatStyle().setColor(this.getSpecial() ? EnumChatFormatting.DARK_PURPLE : EnumChatFormatting.GREEN);
        return iChatComponent;
    }

    @Override
    public Achievement func_150953_b(Class<? extends IJsonSerializable> clazz) {
        return (Achievement)super.func_150953_b(clazz);
    }

    public String getDescription() {
        return this.statStringFormatter != null ? this.statStringFormatter.formatString(StatCollector.translateToLocal(this.achievementDescription)) : StatCollector.translateToLocal(this.achievementDescription);
    }

    public Achievement setStatStringFormatter(IStatStringFormat iStatStringFormat) {
        this.statStringFormatter = iStatStringFormat;
        return this;
    }

    public boolean getSpecial() {
        return this.isSpecial;
    }
}

