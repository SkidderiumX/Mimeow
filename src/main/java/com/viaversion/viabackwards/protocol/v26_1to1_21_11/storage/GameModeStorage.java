/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v26_1to1_21_11.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class GameModeStorage
implements StorableObject {
    private int gameMode = -1;

    public int gameMode() {
        return this.gameMode;
    }

    public void setGameMode(int n) {
        this.gameMode = n;
    }
}

