/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_5to1_21_6.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class SneakStorage
implements StorableObject {
    private boolean sneaking;

    public boolean sneaking() {
        return this.sneaking;
    }

    public boolean setSneaking(boolean bl) {
        boolean bl2 = this.sneaking;
        this.sneaking = bl;
        return bl2 != bl;
    }
}

