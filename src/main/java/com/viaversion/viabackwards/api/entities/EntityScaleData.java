/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities;

import com.viaversion.viaversion.api.connection.StorableObject;

public class EntityScaleData
implements StorableObject {
    private boolean isBaby;
    private float scale = 1.0f;

    public boolean isBaby() {
        return this.isBaby;
    }

    public void setBaby(boolean bl) {
        this.isBaby = bl;
    }

    public float scale() {
        return this.scale;
    }

    public void setScale(float f) {
        this.scale = f;
    }
}

