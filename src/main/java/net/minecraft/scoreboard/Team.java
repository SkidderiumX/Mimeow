/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;

public abstract class Team {
    public boolean isSameTeam(Team team) {
        return team == null ? false : this == team;
    }

    public abstract String getRegisteredName();

    public abstract String formatString(String var1);

    public abstract boolean getSeeFriendlyInvisiblesEnabled();

    public abstract boolean getAllowFriendlyFire();

    public abstract EnumVisible getNameTagVisibility();

    public abstract Collection<String> getMembershipCollection();

    public abstract EnumVisible getDeathMessageVisibility();

    public static enum EnumVisible {
        ALWAYS("always", 0),
        NEVER("never", 1),
        HIDE_FOR_OTHER_TEAMS("hideForOtherTeams", 2),
        HIDE_FOR_OWN_TEAM("hideForOwnTeam", 3);

        private static Map<String, EnumVisible> field_178828_g;
        public final String internalName;
        public final int id;

        public static String[] func_178825_a() {
            return field_178828_g.keySet().toArray(new String[field_178828_g.size()]);
        }

        public static EnumVisible func_178824_a(String string) {
            return field_178828_g.get(string);
        }

        private EnumVisible(String string2, int n2) {
            this.internalName = string2;
            this.id = n2;
        }

        static {
            field_178828_g = Maps.newHashMap();
            for (EnumVisible enumVisible : EnumVisible.values()) {
                field_178828_g.put(enumVisible.internalName, enumVisible);
            }
        }
    }
}

