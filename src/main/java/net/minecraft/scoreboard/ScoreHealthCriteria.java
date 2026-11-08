/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScoreDummyCriteria;
import net.minecraft.util.MathHelper;

public class ScoreHealthCriteria
extends ScoreDummyCriteria {
    public ScoreHealthCriteria(String string) {
        super(string);
    }

    @Override
    public int setScore(List<EntityPlayer> list) {
        float f = 0.0f;
        for (EntityPlayer entityPlayer : list) {
            f += entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount();
        }
        if (list.size() > 0) {
            f /= (float)list.size();
        }
        return MathHelper.ceiling_float_int(f);
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    public IScoreObjectiveCriteria.EnumRenderType getRenderType() {
        return IScoreObjectiveCriteria.EnumRenderType.HEARTS;
    }
}

