/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScoreboardTeamStorage
implements StorableObject {
    private final Map<String, Set<String>> teams = new HashMap<String, Set<String>>();

    public void createTeam(String string) {
        if (this.teams.containsKey(string)) {
            return;
        }
        this.teams.put(string, new HashSet());
    }

    public void removeTeam(String string) {
        this.teams.remove(string);
    }

    public void addPlayerToTeam(String string, String[] stringArray) {
        Set<String> set = this.teams.get(string);
        if (set == null) {
            return;
        }
        for (Set<String> set2 : this.teams.values()) {
            for (String string2 : stringArray) {
                set2.remove(string2);
            }
        }
        Collections.addAll(set, stringArray);
    }

    public void removeFromTeam(String string, String string2) {
        Set<String> set = this.teams.get(string);
        if (set != null) {
            set.remove(string2);
        }
    }

    public String getPlayerTeam(String string) {
        for (Map.Entry<String, Set<String>> entry : this.teams.entrySet()) {
            if (!entry.getValue().contains(string)) continue;
            return entry.getKey();
        }
        return null;
    }
}

