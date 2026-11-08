/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

public enum Environment {
    NORMAL(0),
    NETHER(-1),
    END(1);

    private final int id;

    private Environment(int n2) {
        this.id = n2;
    }

    public int id() {
        return this.id;
    }

    public static Environment getEnvironmentById(int n) {
        return switch (n) {
            case 0 -> NORMAL;
            case 1 -> END;
            default -> NETHER;
        };
    }
}

