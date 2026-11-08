/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class LastExplosionPowerStorage
implements StorableObject {
    private float power;
    private int affectedBlocks;

    public float power() {
        return this.power;
    }

    public void setPower(float f) {
        this.power = f;
    }

    public int affectedBlocks() {
        return this.affectedBlocks;
    }

    public void setAffectedBlocks(int n) {
        this.affectedBlocks = n;
    }
}

