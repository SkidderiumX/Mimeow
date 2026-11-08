/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j;

import java.util.Locale;

public enum Level {
    OFF(0),
    FATAL(1),
    ERROR(2),
    WARN(3),
    INFO(4),
    DEBUG(5),
    TRACE(6),
    ALL(Integer.MAX_VALUE);

    private final int intLevel;

    private Level(int n2) {
        this.intLevel = n2;
    }

    public static Level toLevel(String string) {
        return Level.toLevel(string, DEBUG);
    }

    public static Level toLevel(String string, Level level) {
        if (string == null) {
            return level;
        }
        String string2 = string.toUpperCase(Locale.ENGLISH);
        for (Level level2 : Level.values()) {
            if (!level2.name().equals(string2)) continue;
            return level2;
        }
        return level;
    }

    public boolean isAtLeastAsSpecificAs(Level level) {
        return this.intLevel <= level.intLevel;
    }

    public boolean isAtLeastAsSpecificAs(int n) {
        return this.intLevel <= n;
    }

    public boolean lessOrEqual(Level level) {
        return this.intLevel <= level.intLevel;
    }

    public boolean lessOrEqual(int n) {
        return this.intLevel <= n;
    }

    public int intLevel() {
        return this.intLevel;
    }
}

