/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.scoreboard.Team;

public class oc3caca5ff3f {
    static final int[] \u01da = new int[Team.EnumVisible.values().length];

    static {
        try {
            oc3caca5ff3f.\u01da[Team.EnumVisible.NEVER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc3caca5ff3f.\u01da[Team.EnumVisible.HIDE_FOR_OTHER_TEAMS.ordinal()] = 0x41D16EFC ^ 0x41D16EFE;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc3caca5ff3f.\u01da[Team.EnumVisible.HIDE_FOR_OWN_TEAM.ordinal()] = 0x41D16EFD ^ 0x41D16EFE;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc3caca5ff3f.\u01da[Team.EnumVisible.ALWAYS.ordinal()] = 0x41D16EFA ^ 0x41D16EFE;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

