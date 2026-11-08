/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import java.util.Optional;

public enum SoundSource1_12_2 {
    MASTER("master", 0),
    MUSIC("music", 1),
    RECORD("record", 2),
    WEATHER("weather", 3),
    BLOCK("block", 4),
    HOSTILE("hostile", 5),
    NEUTRAL("neutral", 6),
    PLAYER("player", 7),
    AMBIENT("ambient", 8),
    VOICE("voice", 9);

    private final String name;
    private final int id;

    private SoundSource1_12_2(String string2, int n2) {
        this.name = string2;
        this.id = n2;
    }

    public static Optional<SoundSource1_12_2> findBySource(String string) {
        for (SoundSource1_12_2 soundSource1_12_2 : SoundSource1_12_2.values()) {
            if (!soundSource1_12_2.name.equalsIgnoreCase(string)) continue;
            return Optional.of(soundSource1_12_2);
        }
        return Optional.empty();
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}

