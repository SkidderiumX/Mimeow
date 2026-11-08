/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_9to1_21_11.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class GameTimeStorage
implements StorableObject {
    private long gameTime;

    public long gameTime() {
        return this.gameTime;
    }

    public void setGameTime(long l) {
        this.gameTime = l;
    }

    public void incrementGameTime() {
        ++this.gameTime;
    }
}

