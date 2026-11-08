/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class LevitationStorage
implements StorableObject {
    private boolean active;
    private int amplifier;

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean bl) {
        this.active = bl;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    public void setAmplifier(int n) {
        this.amplifier = n;
    }
}

