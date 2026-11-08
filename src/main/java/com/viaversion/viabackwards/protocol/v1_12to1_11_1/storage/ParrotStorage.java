/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12to1_11_1.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class ParrotStorage
implements StorableObject {
    private boolean tamed = true;
    private boolean sitting = true;

    public boolean isTamed() {
        return this.tamed;
    }

    public void setTamed(boolean bl) {
        this.tamed = bl;
    }

    public boolean isSitting() {
        return this.sitting;
    }

    public void setSitting(boolean bl) {
        this.sitting = bl;
    }
}

