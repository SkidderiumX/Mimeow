/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class PlayerRotationStorage
implements StorableObject {
    private float yaw;
    private float pitch;

    public void setRotation(float f, float f2) {
        this.yaw = f;
        this.pitch = f2;
    }

    public float yaw() {
        return this.yaw;
    }

    public float pitch() {
        return this.pitch;
    }
}

