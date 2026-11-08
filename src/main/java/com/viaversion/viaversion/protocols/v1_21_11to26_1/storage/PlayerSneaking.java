/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_11to26_1.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class PlayerSneaking
implements StorableObject {
    private boolean sneaking;

    public boolean sneaking() {
        return this.sneaking;
    }

    public void setSneaking(boolean bl) {
        this.sneaking = bl;
    }
}

