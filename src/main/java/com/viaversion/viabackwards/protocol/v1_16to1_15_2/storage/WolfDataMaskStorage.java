/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class WolfDataMaskStorage
implements StorableObject {
    private byte tameableMask;

    public WolfDataMaskStorage(byte by) {
        this.tameableMask = by;
    }

    public void setTameableMask(byte by) {
        this.tameableMask = by;
    }

    public byte tameableMask() {
        return this.tameableMask;
    }
}

