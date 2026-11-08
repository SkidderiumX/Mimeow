/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

public enum GameMode {
    NOT_SET("", -1),
    SURVIVAL("Survival Mode", 0),
    CREATIVE("Creative Mode", 1),
    ADVENTURE("Adventure Mode", 2),
    SPECTATOR("Spectator Mode", 3);

    private final String text;
    private final int id;

    private GameMode(String string2, int n2) {
        this.text = string2;
        this.id = n2;
    }

    public String text() {
        return this.text;
    }

    public int id() {
        return this.id;
    }

    public static GameMode getById(int n) {
        return switch (n) {
            case -1 -> NOT_SET;
            case 1 -> CREATIVE;
            case 2 -> ADVENTURE;
            case 3 -> SPECTATOR;
            default -> SURVIVAL;
        };
    }
}

