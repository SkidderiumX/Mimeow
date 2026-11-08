/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import lombok.Generated;

public class AchievementHoverEvent
extends HoverEvent {
    private String statistic;

    public AchievementHoverEvent(String string) {
        super(HoverEventAction.SHOW_ACHIEVEMENT);
        this.statistic = string;
    }

    public String getStatistic() {
        return this.statistic;
    }

    public AchievementHoverEvent setStatistic(String string) {
        this.statistic = string;
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("statistic", this.statistic).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AchievementHoverEvent)) {
            return false;
        }
        AchievementHoverEvent achievementHoverEvent = (AchievementHoverEvent)object;
        if (!achievementHoverEvent.canEqual(this)) {
            return false;
        }
        String string = this.getStatistic();
        String string2 = achievementHoverEvent.getStatistic();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof AchievementHoverEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getStatistic();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}

