/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v26_1to1_21_11.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class DayTimeStorage
implements StorableObject {
    private long gameTime;
    private long dayTime;
    private boolean advanceTime;

    public long gameTime() {
        return this.gameTime;
    }

    public void setGameTime(long l) {
        this.gameTime = l;
    }

    public long setGameTimeAndUpdateDayTime(long l) {
        if (this.advanceTime) {
            this.dayTime += l - this.gameTime;
        }
        this.gameTime = l;
        return this.dayTime;
    }

    public long dayTime() {
        return this.dayTime;
    }

    public void setDayTime(long l) {
        this.dayTime = l;
    }

    public boolean advanceTime() {
        return this.advanceTime;
    }

    public void setAdvanceTime(boolean bl) {
        this.advanceTime = bl;
    }
}

